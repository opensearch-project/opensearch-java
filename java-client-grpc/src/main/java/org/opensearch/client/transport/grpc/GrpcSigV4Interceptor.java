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
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import java.net.URI;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
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
 * Supports two payload signing modes:
 * <ul>
 *   <li><b>Unsigned payload</b> (default): Uses "UNSIGNED-PAYLOAD" as the content hash.
 *       Simpler and works when the server doesn't validate body hash.</li>
 *   <li><b>Signed payload</b>: Computes SHA-256 of the actual serialized protobuf bytes.
 *       More secure, required if the server validates the content hash.
 *       Set via {@link #setPayloadHash(String)} before the call.</li>
 * </ul>
 * <p>
 * For body-aware signing (matching the sample OpenSearchGrpcClient pattern), use the
 * static helper {@link #computePayloadHash(byte[])} to pre-compute the hash:
 * <pre>{@code
 * // Pre-compute hash from serialized protobuf
 * String payloadHash = GrpcSigV4Interceptor.computePayloadHash(protoRequest.toByteArray());
 *
 * // Or use unsigned payload
 * String payloadHash = GrpcSigV4Interceptor.UNSIGNED_PAYLOAD;
 * }</pre>
 * <p>
 * Credentials are resolved on every call (not cached) to handle temporary credential rotation.
 *
 * @see <a href="https://docs.aws.amazon.com/general/latest/gr/sigv4_signing.html">AWS SigV4 Signing</a>
 */
public class GrpcSigV4Interceptor implements ClientInterceptor {

    private static final Logger logger = Logger.getLogger(GrpcSigV4Interceptor.class.getName());

    /** Use this as payloadHash when you don't want to sign the body content. */
    public static final String UNSIGNED_PAYLOAD = "UNSIGNED-PAYLOAD";

    private final GrpcSigV4Config config;
    private final String host;

    // Thread-local payload hash for per-call body signing
    private final ThreadLocal<String> payloadHashHolder = new ThreadLocal<>();

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
     * Sets the payload hash for the next gRPC call on the current thread.
     * <p>
     * Call this before invoking the gRPC stub if you want body-aware signing:
     * <pre>{@code
     * interceptor.setPayloadHash(GrpcSigV4Interceptor.computePayloadHash(request.toByteArray()));
     * stub.bulk(request);
     * }</pre>
     * <p>
     * If not set, defaults to {@link #UNSIGNED_PAYLOAD}.
     *
     * @param payloadHash the pre-computed SHA-256 hex of the request body, or {@link #UNSIGNED_PAYLOAD}
     */
    public void setPayloadHash(String payloadHash) {
        payloadHashHolder.set(payloadHash);
    }

    /**
     * Computes the SHA-256 hex hash of the given bytes.
     * Use this to pre-compute the payload hash for body-aware signing.
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
        return new SimpleForwardingClientCall<ReqT, RespT>(next.newCall(method, callOptions)) {
            @Override
            public void start(Listener<RespT> responseListener, Metadata headers) {
                try {
                    // Get payload hash: use pre-set value or default to UNSIGNED-PAYLOAD
                    String payloadHash = payloadHashHolder.get();
                    if (payloadHash == null) {
                        payloadHash = UNSIGNED_PAYLOAD;
                    }
                    // Clear after use (one-shot per call)
                    payloadHashHolder.remove();

                    // Sign using the gRPC method path
                    Map<String, List<String>> signedHeaders = signRequest(method.getFullMethodName(), payloadHash);

                    // Attach signed headers as gRPC metadata
                    for (Map.Entry<String, List<String>> entry : signedHeaders.entrySet()) {
                        String key = entry.getKey().toLowerCase();
                        if (isSigningHeader(key)) {
                            Metadata.Key<String> metadataKey = Metadata.Key.of(key, Metadata.ASCII_STRING_MARSHALLER);
                            for (String value : entry.getValue()) {
                                headers.put(metadataKey, value);
                            }
                        }
                    }
                } catch (Exception e) {
                    logger.log(Level.WARNING, "Failed to sign gRPC request: " + e.getMessage(), e);
                }

                super.start(responseListener, headers);
            }
        };
    }

    /**
     * Signs a synthetic HTTP request representing the gRPC call.
     *
     * @param grpcMethodPath the full gRPC method name (e.g., "opensearch.DocumentService/Bulk")
     * @param payloadHash    the SHA-256 hex hash of the body, or "UNSIGNED-PAYLOAD"
     * @return map of signed header names to their values
     */
    Map<String, List<String>> signRequest(String grpcMethodPath, String payloadHash) {
        String path = "/" + grpcMethodPath;
        String url = "https://" + host + path;

        // Build the synthetic HTTP request for signing
        SdkHttpFullRequest.Builder requestBuilder = SdkHttpFullRequest.builder()
            .method(SdkHttpMethod.POST)
            .uri(URI.create(url))
            .putHeader("host", host)
            .putHeader("x-amz-content-sha256", payloadHash);

        // For signed payload, we pass the actual bytes; for unsigned, empty
        ContentStreamProvider bodyProvider = ContentStreamProvider.fromByteArrayUnsafe(new byte[0]);

        // Sign the request
        SignedRequest signedRequest = AwsV4HttpSigner.create()
            .sign(
                b -> b.identity(config.credentialsProvider().resolveCredentials())
                    .request(requestBuilder.build())
                    .payload(bodyProvider)
                    .putProperty(AwsV4HttpSigner.SERVICE_SIGNING_NAME, config.service())
                    .putProperty(AwsV4HttpSigner.REGION_NAME, config.region().id())
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
