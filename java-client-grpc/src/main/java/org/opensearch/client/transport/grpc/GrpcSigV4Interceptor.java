/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.transport.grpc;

import io.grpc.CallOptions;
import io.grpc.Channel;
import io.grpc.ClientCall;
import io.grpc.ClientInterceptor;
import io.grpc.ForwardingClientCall.SimpleForwardingClientCall;
import io.grpc.KnownLength;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.Status;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import software.amazon.awssdk.http.ContentStreamProvider;
import software.amazon.awssdk.http.SdkHttpFullRequest;
import software.amazon.awssdk.http.SdkHttpMethod;
import software.amazon.awssdk.http.auth.aws.signer.AwsV4HttpSigner;
import software.amazon.awssdk.http.auth.spi.signer.SignedRequest;

/**
 * gRPC {@link ClientInterceptor} that signs every outgoing request with AWS SigV4.
 * <p>
 * For each gRPC call, this interceptor:
 * <ol>
 *   <li>Constructs a synthetic HTTP request using the gRPC method path as the URL
 *       (e.g., {@code https://host/opensearch.DocumentService/Bulk})</li>
 *   <li>Signs it using {@link AwsV4HttpSigner} with the configured credentials and region</li>
 *   <li>Extracts the signed headers (Authorization, X-Amz-Date, X-Amz-Security-Token,
 *       X-Amz-Content-SHA256) and attaches them as gRPC metadata</li>
 * </ol>
 * <p>
 * The payload is signed with its SHA-256 hash, which Amazon OpenSearch Service requires:
 * <ul>
 *   <li>A call that sends exactly one request message (unary and server-streaming methods, such as Bulk, Search and
 *       ServerStreamSearch) starts only once its message is sent: the interceptor serializes the message, signs those
 *       bytes, then starts the call and sends the same bytes. Each attempt, including a retry, is signed for its own
 *       message.</li>
 *   <li>Calls that stream request messages (client-streaming and bidirectional methods) are signed with
 *       {@link #UNSIGNED_PAYLOAD}, since their body is not known when the call starts.</li>
 * </ul>
 * <p>
 * A call that cannot be signed fails with {@code UNAUTHENTICATED} and sends nothing.
 * <p>
 * Credentials are resolved on every call (not cached) to handle temporary credential rotation.
 *
 * @see <a href="https://docs.aws.amazon.com/general/latest/gr/sigv4_signing.html">AWS SigV4 Signing</a>
 */
public class GrpcSigV4Interceptor implements ClientInterceptor {

    private static final Logger logger = Logger.getLogger(GrpcSigV4Interceptor.class.getName());

    /** The payload hash of a call whose body is not signed. */
    public static final String UNSIGNED_PAYLOAD = "UNSIGNED-PAYLOAD";

    private final GrpcSigV4Config config;
    private final String host;

    /**
     * Creates a SigV4 interceptor.
     *
     * @param config the SigV4 configuration (region, service, credentials)
     * @param host   the OpenSearch endpoint hostname (used in the signing URL and Host header)
     */
    public GrpcSigV4Interceptor(GrpcSigV4Config config, String host) {
        if (config == null) {
            throw new IllegalArgumentException("SigV4 config cannot be null");
        }
        if (host == null || host.isEmpty()) {
            throw new IllegalArgumentException("host cannot be null or empty");
        }
        this.config = config;
        this.host = host;
    }

    /**
     * Does nothing: each call is signed for the bytes it sends.
     *
     * @param payloadHash ignored
     * @deprecated Calls that send one request message are signed with the hash of the bytes they send, and other calls
     *             with {@link #UNSIGNED_PAYLOAD}.
     */
    @Deprecated
    public void setPayloadHash(String payloadHash) {
        // Signing does not depend on state set by the caller.
    }

    /**
     * Computes the SHA-256 hex hash of the given bytes.
     *
     * @param payload the serialized protobuf request bytes
     * @return lowercase hex-encoded SHA-256 hash
     */
    public static String computePayloadHash(byte[] payload) {
        if (payload == null || payload.length == 0) {
            // SHA-256 of empty string
            return "e3b0c44298fc1c149afbf4c8996fb92427ae41e4649b934ca495991b7852b855";
        }
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(payload);
            return bytesToHex(hash);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("SHA-256 not available", e);
        }
    }

    @Override
    public <ReqT, RespT> ClientCall<ReqT, RespT> interceptCall(
        MethodDescriptor<ReqT, RespT> method,
        CallOptions callOptions,
        Channel next
    ) {
        if (method.getType().clientSendsOneMessage()) {
            return new BodySigningCall<>(method, callOptions, next);
        }
        return new SimpleForwardingClientCall<ReqT, RespT>(next.newCall(method, callOptions)) {
            @Override
            public void start(Listener<RespT> responseListener, Metadata headers) {
                final Map<String, List<String>> signedHeaders;
                try {
                    signedHeaders = signRequest(method.getFullMethodName(), UNSIGNED_PAYLOAD);
                } catch (RuntimeException e) {
                    logger.log(Level.WARNING, "Failed to sign gRPC request: " + e.getMessage(), e);
                    responseListener.onClose(signingFailed(e), new Metadata());
                    return;
                }
                addSigningHeaders(signedHeaders, headers);
                super.start(responseListener, headers);
            }
        };
    }

    /**
     * A call that sends one request message, signed with the hash of that message. It starts the underlying call only
     * once the message is sent, and sends the bytes it signed.
     * <p>
     * gRPC calls this class from one thread at a time, except {@link #request(int)}, which may come from any thread. So
     * the start of the underlying call and the replay of earlier requests happen under one lock.
     */
    private final class BodySigningCall<ReqT, RespT> extends ClientCall<ReqT, RespT> {
        private final MethodDescriptor<ReqT, RespT> method;
        private final SignedBodyMarshaller<ReqT> marshaller;
        private final ClientCall<ReqT, RespT> delegate;

        private final Object lock = new Object();
        private Listener<RespT> listener;
        private Metadata headers;
        /** Whether the underlying call started. */
        private boolean started;
        /** Whether the call ended here, before the underlying call started. */
        private boolean closedLocally;
        private int pendingRequests;

        BodySigningCall(MethodDescriptor<ReqT, RespT> method, CallOptions callOptions, Channel next) {
            this.method = method;
            this.marshaller = new SignedBodyMarshaller<>(method.getRequestMarshaller());
            // The same method with a request marshaller that sends the bytes signed below; name and type are unchanged.
            this.delegate = next.newCall(method.toBuilder(marshaller, method.getResponseMarshaller()).build(), callOptions);
        }

        @Override
        public void start(Listener<RespT> responseListener, Metadata headers) {
            synchronized (lock) {
                this.listener = responseListener;
                this.headers = headers;
            }
        }

        @Override
        public void request(int numMessages) {
            synchronized (lock) {
                if (started == false) {
                    pendingRequests += numMessages;
                    return;
                }
            }
            delegate.request(numMessages);
        }

        @Override
        public void sendMessage(ReqT message) {
            synchronized (lock) {
                if (closedLocally) {
                    return;
                }
                if (started) {
                    // Not expected for a method that sends one message; gRPC itself rejects a second one.
                    delegate.sendMessage(message);
                    return;
                }
            }
            final byte[] body;
            try {
                body = marshaller.serialize(message);
            } catch (IOException | RuntimeException e) {
                closeLocally(Status.INTERNAL.withDescription("Failed to serialize gRPC request: " + e.getMessage()).withCause(e));
                return;
            }
            if (signAndStart(body)) {
                delegate.sendMessage(message);
            }
        }

        @Override
        public void halfClose() {
            final boolean notStarted;
            synchronized (lock) {
                if (closedLocally) {
                    return;
                }
                notStarted = started == false;
            }
            // A call half-closed without a message is signed for an empty body; the server rejects it as usual.
            if (notStarted && signAndStart(new byte[0]) == false) {
                return;
            }
            delegate.halfClose();
        }

        @Override
        public void cancel(String message, Throwable cause) {
            final boolean notStarted;
            synchronized (lock) {
                if (closedLocally) {
                    return;
                }
                notStarted = started == false;
            }
            if (notStarted) {
                closeLocally(Status.CANCELLED.withDescription(message).withCause(cause));
                return;
            }
            delegate.cancel(message, cause);
        }

        @Override
        public boolean isReady() {
            synchronized (lock) {
                if (started == false) {
                    return false;
                }
            }
            return delegate.isReady();
        }

        @Override
        public void setMessageCompression(boolean enabled) {
            delegate.setMessageCompression(enabled);
        }

        @Override
        public io.grpc.Attributes getAttributes() {
            return delegate.getAttributes();
        }

        /**
         * Signs the call for {@code body} and starts the underlying call, replaying the requests made meanwhile.
         *
         * @return whether the call started; a call that cannot be signed fails with {@code UNAUTHENTICATED} instead
         */
        private boolean signAndStart(byte[] body) {
            final Map<String, List<String>> signedHeaders;
            try {
                signedHeaders = signRequest(method.getFullMethodName(), body);
            } catch (RuntimeException e) {
                logger.log(Level.WARNING, "Failed to sign gRPC request: " + e.getMessage(), e);
                closeLocally(signingFailed(e));
                return false;
            }
            synchronized (lock) {
                if (closedLocally || started) {
                    return started;
                }
                addSigningHeaders(signedHeaders, headers);
                started = true;
                delegate.start(listener, headers);
                if (pendingRequests > 0) {
                    delegate.request(pendingRequests);
                    pendingRequests = 0;
                }
                return true;
            }
        }

        /** Ends the call before the underlying call started: nothing was sent. */
        private void closeLocally(Status status) {
            final Listener<RespT> closing;
            synchronized (lock) {
                if (closedLocally || started) {
                    return;
                }
                closedLocally = true;
                closing = listener;
            }
            if (closing != null) {
                closing.onClose(status, new Metadata());
            }
        }
    }

    /**
     * Serializes a request message once, for signing, and hands the same bytes to gRPC when the call sends it.
     */
    private static final class SignedBodyMarshaller<T> implements MethodDescriptor.Marshaller<T> {
        private final MethodDescriptor.Marshaller<T> delegate;
        private volatile T signedMessage;
        private volatile byte[] signedBody;

        SignedBodyMarshaller(MethodDescriptor.Marshaller<T> delegate) {
            this.delegate = delegate;
        }

        byte[] serialize(T message) throws IOException {
            final byte[] body;
            try (InputStream in = delegate.stream(message)) {
                body = readBody(in);
            }
            signedMessage = message;
            signedBody = body;
            return body;
        }

        @Override
        public InputStream stream(T value) {
            final byte[] body = signedBody;
            if (body != null && value == signedMessage) {
                return new ByteArrayInputStream(body);
            }
            return delegate.stream(value);
        }

        @Override
        public T parse(InputStream stream) {
            return delegate.parse(stream);
        }
    }

    /**
     * Reads a serialized message in one copy when its stream knows its length. The stream of a protobuf message writes
     * the message straight into an array of that length; read in chunks, it would first copy the whole message aside.
     */
    static byte[] readBody(InputStream in) throws IOException {
        if (in instanceof KnownLength == false) {
            return in.readAllBytes();
        }
        byte[] body = new byte[in.available()];
        int read = in.readNBytes(body, 0, body.length);
        int next = in.read();
        if (next == -1) {
            return read == body.length ? body : Arrays.copyOf(body, read);
        }
        // The stream holds more than it announced
        ByteArrayOutputStream rest = new ByteArrayOutputStream();
        rest.write(body, 0, read);
        rest.write(next);
        in.transferTo(rest);
        return rest.toByteArray();
    }

    private static Status signingFailed(Exception e) {
        return Status.UNAUTHENTICATED.withDescription("Failed to sign gRPC request with AWS SigV4: " + e.getMessage()).withCause(e);
    }

    /** Copies the AWS signing headers into the call's gRPC metadata. */
    private static void addSigningHeaders(Map<String, List<String>> signedHeaders, Metadata headers) {
        for (Map.Entry<String, List<String>> entry : signedHeaders.entrySet()) {
            String key = entry.getKey().toLowerCase(Locale.ROOT);
            if (isSigningHeader(key)) {
                Metadata.Key<String> metadataKey = Metadata.Key.of(key, Metadata.ASCII_STRING_MARSHALLER);
                headers.removeAll(metadataKey);
                for (String value : entry.getValue()) {
                    headers.put(metadataKey, value);
                }
            }
        }
    }

    /**
     * Signs a synthetic HTTP request representing the gRPC call.
     *
     * @param grpcMethodPath the full gRPC method name (e.g., "opensearch.DocumentService/Bulk")
     * @param payloadHash    the SHA-256 hex hash of the body, or "UNSIGNED-PAYLOAD"
     * @return map of signed header names to their values
     */
    Map<String, List<String>> signRequest(String grpcMethodPath, String payloadHash) {
        return sign(grpcMethodPath, payloadHash, new byte[0]);
    }

    /**
     * Signs a synthetic HTTP request representing a gRPC call whose request body is {@code body}.
     *
     * @param grpcMethodPath the full gRPC method name
     * @param body           the serialized request message, as sent on the wire
     * @return map of signed header names to their values
     */
    Map<String, List<String>> signRequest(String grpcMethodPath, byte[] body) {
        // The signer hashes the body itself and sets x-amz-content-sha256
        return sign(grpcMethodPath, null, body);
    }

    /**
     * Signs a synthetic HTTP POST to the gRPC method path.
     *
     * @param payloadHash the payload hash to send, or {@code null} to sign the payload, whose hash the signer computes
     */
    private Map<String, List<String>> sign(String grpcMethodPath, String payloadHash, byte[] body) {
        String path = "/" + grpcMethodPath;
        String url = "https://" + host + path;

        // Build the synthetic HTTP request for signing
        SdkHttpFullRequest.Builder requestBuilder = SdkHttpFullRequest.builder()
            .method(SdkHttpMethod.POST)
            .uri(URI.create(url))
            .putHeader("host", host);
        if (payloadHash != null) {
            requestBuilder.putHeader("x-amz-content-sha256", payloadHash);
        }

        ContentStreamProvider bodyProvider = ContentStreamProvider.fromByteArrayUnsafe(body);

        // Without payload signing the signer sends UNSIGNED-PAYLOAD; with it, it hashes the body it is given (and would
        // replace a preset UNSIGNED-PAYLOAD with the hash of an empty body).
        boolean signPayload = UNSIGNED_PAYLOAD.equals(payloadHash) == false;
        SignedRequest signedRequest = AwsV4HttpSigner.create()
            .sign(
                b -> b.identity(config.credentialsProvider().resolveCredentials())
                    .request(requestBuilder.build())
                    .payload(bodyProvider)
                    .putProperty(AwsV4HttpSigner.SERVICE_SIGNING_NAME, config.service())
                    .putProperty(AwsV4HttpSigner.REGION_NAME, config.region().id())
                    .putProperty(AwsV4HttpSigner.PAYLOAD_SIGNING_ENABLED, signPayload)
            );

        return signedRequest.request().headers();
    }

    /**
     * Returns true if this is an AWS signing header that should be forwarded as gRPC metadata.
     */
    private static boolean isSigningHeader(String headerName) {
        return headerName.equals("authorization")
            || headerName.equals("x-amz-date")
            || headerName.equals("x-amz-security-token")
            || headerName.equals("x-amz-content-sha256")
            || headerName.equals("host");
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder(bytes.length * 2);
        for (byte b : bytes) {
            sb.append(String.format("%02x", b & 0xff));
        }
        return sb.toString();
    }

    /**
     * Returns the configured host (for testing).
     */
    String getHost() {
        return host;
    }

    /**
     * Returns the SigV4 config (for testing).
     */
    GrpcSigV4Config getConfig() {
        return config;
    }
}
