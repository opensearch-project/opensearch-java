/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.transport.aws;

import jakarta.json.JsonObject;
import jakarta.json.stream.JsonParser;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.time.Clock;
import java.util.AbstractMap;
import java.util.Collection;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.zip.GZIPInputStream;
import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.net.ssl.SSLHandshakeException;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.jackson.JacksonJsonpMapper;
import org.opensearch.client.opensearch.OpenSearchClient;
import org.opensearch.client.opensearch._types.ErrorCause;
import org.opensearch.client.opensearch._types.ErrorResponse;
import org.opensearch.client.opensearch._types.OpenSearchException;
import org.opensearch.client.opensearch.generic.OpenSearchClientException;
import org.opensearch.client.transport.Endpoint;
import org.opensearch.client.transport.GenericEndpoint;
import org.opensearch.client.transport.JsonEndpoint;
import org.opensearch.client.transport.OpenSearchTransport;
import org.opensearch.client.transport.TransportException;
import org.opensearch.client.transport.TransportOptions;
import org.opensearch.client.transport.endpoints.BooleanEndpoint;
import org.opensearch.client.transport.endpoints.BooleanResponse;
import org.opensearch.client.util.MissingRequiredPropertyException;
import org.opensearch.client.util.OpenSearchRequestBodyBuffer;
import software.amazon.awssdk.auth.credentials.AwsCredentialsProvider;
import software.amazon.awssdk.auth.credentials.DefaultCredentialsProvider;
import software.amazon.awssdk.http.AbortableInputStream;
import software.amazon.awssdk.http.ContentStreamProvider;
import software.amazon.awssdk.http.Header;
import software.amazon.awssdk.http.HttpExecuteRequest;
import software.amazon.awssdk.http.HttpExecuteResponse;
import software.amazon.awssdk.http.SdkHttpClient;
import software.amazon.awssdk.http.SdkHttpFullRequest;
import software.amazon.awssdk.http.SdkHttpMethod;
import software.amazon.awssdk.http.SdkHttpRequest;
import software.amazon.awssdk.http.SdkHttpResponse;
import software.amazon.awssdk.http.async.AsyncExecuteRequest;
import software.amazon.awssdk.http.async.SdkAsyncHttpClient;
import software.amazon.awssdk.http.auth.aws.signer.AwsV4HttpSigner;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.utils.IoUtils;
import software.amazon.awssdk.utils.SdkAutoCloseable;

/**
 * Implementation of the OpenSearchTransport interface that sends signed requests using
 * the AWS v2 SDK HTTP clients, to connect to an AWS OpenSearch service using IAM authentication.
 */
public class AwsSdk2Transport implements OpenSearchTransport {
    /**
     * By default, requests that exceed this size will be automatically compressed.
     * {@link AwsSdk2TransportOptions} can be used to override this setting or disable compression.
     */
    public static final Integer DEFAULT_REQUEST_COMPRESSION_SIZE = 8192;

    private static final byte[] NO_BYTES = new byte[0];
    private final SdkAutoCloseable httpClient;
    private final boolean isApacheHttpClient;
    private final String host;
    private final String signingServiceName;
    private final Region signingRegion;
    private final JsonpMapper defaultMapper;
    private final AwsSdk2TransportOptions transportOptions;

    /**
     * Create an {@link OpenSearchTransport} with an asynchronous AWS HTTP client.
     * <p>
     * Note that asynchronous OpenSearch requests sent through this transport will be dispatched
     * *synchronously* on the calling thread.
     *
     * @param asyncHttpClient Asynchronous HTTP client to use for OpenSearch requests.
     * @param host The fully qualified domain name to connect to.
     * @param signingRegion The AWS region for which requests will be signed. This should typically match the region in `host`.
     * @param options Options that apply to all requests. Can be null. Create with
     *                {@link AwsSdk2TransportOptions#builder()} and use these to specify non-default credentials,
     *                compression options, etc.
     */
    public AwsSdk2Transport(
        @CheckForNull SdkAsyncHttpClient asyncHttpClient,
        @Nonnull String host,
        @Nonnull Region signingRegion,
        @CheckForNull AwsSdk2TransportOptions options
    ) {
        this(asyncHttpClient, host, "es", signingRegion, options);
    }

    /**
     * Create an {@link OpenSearchTransport} with a synchronous AWS HTTP client.
     *
     * @param syncHttpClient Synchronous HTTP client to use for OpenSearch requests.
     * @param host The fully qualified domain name to connect to.
     * @param signingRegion The AWS region for which requests will be signed. This should typically match the region in `host`.
     * @param options Options that apply to all requests. Can be null. Create with
     *                {@link AwsSdk2TransportOptions#builder()} and use these to specify non-default credentials,
     *                compression options, etc.
     *
     * @implNote Using {@code software.amazon.awssdk.http.apache.ApacheHttpClient} is discouraged as it does not support request bodies on GET or DELETE requests.
     *           This leads to incorrect handling of requests such as {@link OpenSearchClient#clearScroll(org.opensearch.client.opensearch.core.ClearScrollRequest)} and {@link OpenSearchClient#deletePit(org.opensearch.client.opensearch.core.pit.DeletePitRequest)}.
     *           As such {@link #performRequest(Object, Endpoint, TransportOptions)} &amp; {@link #performRequestAsync(Object, Endpoint, TransportOptions)} will throw a {@link TransportException} if an unsupported request is encountered while using {@code ApacheHttpClient}.
     */
    public AwsSdk2Transport(
        @CheckForNull SdkHttpClient syncHttpClient,
        @Nonnull String host,
        @Nonnull Region signingRegion,
        @CheckForNull AwsSdk2TransportOptions options
    ) {
        this(syncHttpClient, host, "es", signingRegion, options);
    }

    /**
     * Create an {@link OpenSearchTransport} with an asynchronous AWS HTTP client.
     * <p>
     * Note that asynchronous OpenSearch requests sent through this transport will be dispatched
     * *synchronously* on the calling thread.
     *
     * @param asyncHttpClient Asynchronous HTTP client to use for OpenSearch requests.
     * @param host The fully qualified domain name to connect to.
     * @param signingRegion The AWS region for which requests will be signed. This should typically match the region in `host`.
     * @param signingServiceName The AWS signing service name, one of `es` (Amazon OpenSearch) or `aoss` (Amazon OpenSearch Serverless).
     * @param options Options that apply to all requests. Can be null. Create with
     *                {@link AwsSdk2TransportOptions#builder()} and use these to specify non-default credentials,
     *                compression options, etc.
     */
    public AwsSdk2Transport(
        @CheckForNull SdkAsyncHttpClient asyncHttpClient,
        @Nonnull String host,
        @Nonnull String signingServiceName,
        @Nonnull Region signingRegion,
        @CheckForNull AwsSdk2TransportOptions options
    ) {
        this((SdkAutoCloseable) asyncHttpClient, host, signingServiceName, signingRegion, options);
    }

    /**
     * Create an {@link OpenSearchTransport} with a synchronous AWS HTTP client.
     *
     * @param syncHttpClient Synchronous HTTP client to use for OpenSearch requests.
     * @param host The fully qualified domain name to connect to.
     * @param signingRegion The AWS region for which requests will be signed. This should typically match the region in `host`.
     * @param signingServiceName The AWS signing service name, one of `es` (Amazon OpenSearch) or `aoss` (Amazon OpenSearch Serverless).
     * @param options Options that apply to all requests. Can be null. Create with
     *                {@link AwsSdk2TransportOptions#builder()} and use these to specify non-default credentials,
     *                compression options, etc.
     *
     * @implNote Using {@code software.amazon.awssdk.http.apache.ApacheHttpClient} is discouraged as it does not support request bodies on GET or DELETE requests.
     *           This leads to incorrect handling of requests such as {@link OpenSearchClient#clearScroll(org.opensearch.client.opensearch.core.ClearScrollRequest)} and {@link OpenSearchClient#deletePit(org.opensearch.client.opensearch.core.pit.DeletePitRequest)}.
     *           As such {@link #performRequest(Object, Endpoint, TransportOptions)} &amp; {@link #performRequestAsync(Object, Endpoint, TransportOptions)} will throw a {@link TransportException} if an unsupported request is encountered while using {@code ApacheHttpClient}.
     */
    public AwsSdk2Transport(
        @CheckForNull SdkHttpClient syncHttpClient,
        @Nonnull String host,
        @Nonnull String signingServiceName,
        @Nonnull Region signingRegion,
        @CheckForNull AwsSdk2TransportOptions options
    ) {
        this((SdkAutoCloseable) syncHttpClient, host, signingServiceName, signingRegion, options);
    }

    private AwsSdk2Transport(
        @CheckForNull SdkAutoCloseable httpClient,
        @Nonnull String host,
        @Nonnull String signingServiceName,
        @Nonnull Region signingRegion,
        @CheckForNull AwsSdk2TransportOptions options
    ) {
        Objects.requireNonNull(host, "Target OpenSearch service host must not be null");
        this.httpClient = httpClient;
        this.isApacheHttpClient = httpClient instanceof SdkHttpClient
            && httpClient.getClass().getName().equals("software.amazon.awssdk.http.apache.ApacheHttpClient");
        this.host = host;
        this.signingServiceName = signingServiceName;
        this.signingRegion = signingRegion;
        this.transportOptions = options != null ? options : AwsSdk2TransportOptions.builder().build();
        this.defaultMapper = Optional.ofNullable(options).map(AwsSdk2TransportOptions::mapper).orElse(new JacksonJsonpMapper());
    }

    @Override
    public <RequestT, ResponseT, ErrorT> ResponseT performRequest(
        RequestT request,
        Endpoint<RequestT, ResponseT, ErrorT> endpoint,
        @Nullable TransportOptions options
    ) throws IOException {
        OpenSearchRequestBodyBuffer requestBody = prepareRequestBody(request, endpoint, options);
        SdkHttpRequest clientReq = prepareRequest(request, endpoint, options, requestBody);

        if (httpClient instanceof SdkHttpClient) {
            return executeSync((SdkHttpClient) httpClient, clientReq, requestBody, endpoint, options);
        } else if (httpClient instanceof SdkAsyncHttpClient) {
            try {
                return executeAsync((SdkAsyncHttpClient) httpClient, clientReq, requestBody, endpoint, options).get();
            } catch (ExecutionException e) {
                Exception cause = extractAndWrapCause(e);
                if (cause instanceof IOException) {
                    throw (IOException) cause;
                }
                if (cause instanceof RuntimeException) {
                    throw (RuntimeException) cause;
                }
                throw new IllegalStateException("unexpected exception type: must be either RuntimeException or IOException", cause);
            } catch (InterruptedException e) {
                throw new IOException("HttpRequest was interrupted", e);
            }
        } else {
            throw new IOException("invalid httpClient: " + httpClient);
        }
    }

    @Override
    public <RequestT, ResponseT, ErrorT> CompletableFuture<ResponseT> performRequestAsync(
        RequestT request,
        Endpoint<RequestT, ResponseT, ErrorT> endpoint,
        @Nullable TransportOptions options
    ) {
        try {
            OpenSearchRequestBodyBuffer requestBody = prepareRequestBody(request, endpoint, options);
            SdkHttpRequest clientReq = prepareRequest(request, endpoint, options, requestBody);
            if (httpClient instanceof SdkAsyncHttpClient) {
                return executeAsync((SdkAsyncHttpClient) httpClient, clientReq, requestBody, endpoint, options);
            } else if (httpClient instanceof SdkHttpClient) {
                ResponseT result = executeSync((SdkHttpClient) httpClient, clientReq, requestBody, endpoint, options);
                return CompletableFuture.completedFuture(result);
            } else {
                throw new IOException("invalid httpClient: " + httpClient);
            }
        } catch (Throwable e) {
            CompletableFuture<ResponseT> cf = new CompletableFuture<>();
            cf.completeExceptionally(e);
            return cf;
        }
    }

    @Override
    public JsonpMapper jsonpMapper() {
        return defaultMapper;
    }

    @Override
    public AwsSdk2TransportOptions options() {
        return transportOptions;
    }

    @Override
    public void close() {}

    @CheckForNull
    private <RequestT> OpenSearchRequestBodyBuffer prepareRequestBody(
        RequestT request,
        Endpoint<RequestT, ?, ?> endpoint,
        TransportOptions options
    ) throws IOException {
        if (endpoint.hasRequestBody()) {
            final JsonpMapper mapper = Optional.ofNullable(
                options instanceof AwsSdk2TransportOptions ? ((AwsSdk2TransportOptions) options) : null
            ).map(AwsSdk2TransportOptions::mapper).orElse(defaultMapper);
            final int maxUncompressedSize = getOption(options, AwsSdk2TransportOptions::requestCompressionSize).orElse(
                DEFAULT_REQUEST_COMPRESSION_SIZE
            );

            OpenSearchRequestBodyBuffer buffer = new OpenSearchRequestBodyBuffer(mapper, maxUncompressedSize);
            buffer.addContent(request);
            buffer.close();
            return buffer;
        }
        return null;
    }

    private <RequestT> SdkHttpRequest prepareRequest(
        RequestT request,
        Endpoint<RequestT, ?, ?> endpoint,
        @CheckForNull TransportOptions options,
        @CheckForNull OpenSearchRequestBodyBuffer body
    ) throws UnsupportedEncodingException, TransportException {
        SdkHttpMethod method = SdkHttpMethod.fromValue(endpoint.method(request));

        // AWS Apache Http Client only supports request bodies on PATCH, POST & PUT requests.
        // See:
        // https://github.com/aws/aws-sdk-java-v2/blob/master/http-clients/apache-client/src/main/java/software/amazon/awssdk/http/apache/internal/impl/ApacheHttpRequestFactory.java#L118-L137
        if (isApacheHttpClient
            && method != SdkHttpMethod.PATCH
            && method != SdkHttpMethod.POST
            && method != SdkHttpMethod.PUT
            && body != null
            && body.getContentLength() > 0) {
            throw new TransportException(
                "AWS SDK's ApacheHttpClient does not support request bodies for HTTP method `"
                    + method
                    + "`. Please use a different SdkHttpClient implementation."
            );
        }

        SdkHttpFullRequest.Builder req = SdkHttpFullRequest.builder().method(method);

        StringBuilder url = new StringBuilder();
        url.append("https://").append(host);
        String path = endpoint.requestUrl(request);
        if (!path.startsWith("/")) {
            url.append('/');
        }
        url.append(path);
        Map<String, String> params = endpoint.queryParameters(request);
        if (params != null && !params.isEmpty()) {
            char sep = '?';
            for (Map.Entry<String, String> ent : params.entrySet()) {
                url.append(sep).append(ent.getKey()).append('=');
                url.append(URLEncoder.encode(ent.getValue(), "UTF-8"));
                sep = '&';
            }
        }
        applyOptionsParams(url, transportOptions);
        applyOptionsParams(url, options);
        try {
            req.uri(new URI(url.toString()));
        } catch (URISyntaxException e) {
            throw new IllegalArgumentException("Invalid request URI: " + url.toString());
        }

        ContentStreamProvider bodyProvider = body != null ? ContentStreamProvider.fromByteArrayUnsafe(body.getByteArray()) : null;

        applyHeadersPreSigning(req, options, body);

        final AwsCredentialsProvider credentials = getOption(options, AwsSdk2TransportOptions::credentials).orElseGet(
            DefaultCredentialsProvider::create
        );

        final Clock signingClock = getOption(options, AwsSdk2TransportOptions::signingClock).orElse(null);

        SdkHttpRequest.Builder signedReq = AwsV4HttpSigner.create()
            .sign(
                b -> b.identity(credentials.resolveCredentials())
                    .request(req.build())
                    .payload(bodyProvider)
                    .putProperty(AwsV4HttpSigner.SERVICE_SIGNING_NAME, this.signingServiceName)
                    .putProperty(AwsV4HttpSigner.REGION_NAME, this.signingRegion.id())
                    .putProperty(AwsV4HttpSigner.SIGNING_CLOCK, signingClock)
            )
            .request()
            .toBuilder();

        applyHeadersPostSigning(signedReq, body);

        return signedReq.build();
    }

    private void applyHeadersPreSigning(SdkHttpRequest.Builder req, TransportOptions options, OpenSearchRequestBodyBuffer body) {
        applyOptionsHeaders(req, transportOptions);
        applyOptionsHeaders(req, options);

        if (body != null) {
            req.putHeader("Content-Type", body.getContentType());
            String encoding = body.getContentEncoding();
            if (encoding != null) {
                req.putHeader("Content-Encoding", encoding);
            }
        }

        if (getOption(options, AwsSdk2TransportOptions::responseCompression).orElse(Boolean.TRUE)) {
            req.putHeader("Accept-Encoding", "gzip");
        } else {
            req.removeHeader("Accept-Encoding");
        }
    }

    private void applyHeadersPostSigning(SdkHttpRequest.Builder req, OpenSearchRequestBodyBuffer body) {
        if (body != null) {
            req.putHeader("Content-Length", String.valueOf(body.getContentLength()));
        }
    }

    private void applyOptionsParams(StringBuilder url, TransportOptions options) throws UnsupportedEncodingException {
        if (options == null) {
            return;
        }
        Map<String, String> params = options.queryParameters();
        if (params != null && !params.isEmpty()) {
            char sep = url.indexOf("?") < 0 ? '?' : '&';
            for (Map.Entry<String, String> param : params.entrySet()) {
                url.append(sep).append(param.getKey()).append('=');
                url.append(URLEncoder.encode(param.getValue(), "UTF-8"));
                sep = '?';
            }
        }
    }

    private void applyOptionsHeaders(SdkHttpRequest.Builder builder, TransportOptions options) {
        if (options == null) {
            return;
        }
        Collection<Map.Entry<String, String>> headers = options.headers();
        if (headers != null && !headers.isEmpty()) {
            for (Map.Entry<String, String> header : headers) {
                builder.appendHeader(header.getKey(), header.getValue());
            }
        }
    }

    private <ResponseT> ResponseT executeSync(
        SdkHttpClient syncHttpClient,
        SdkHttpRequest httpRequest,
        OpenSearchRequestBodyBuffer requestBody,
        Endpoint<?, ResponseT, ?> endpoint,
        TransportOptions options
    ) throws IOException {
        HttpExecuteRequest.Builder executeRequest = HttpExecuteRequest.builder().request(httpRequest);
        if (requestBody != null) {
            executeRequest.contentStreamProvider(ContentStreamProvider.fromByteArrayUnsafe(requestBody.getByteArray()));
        }
        HttpExecuteResponse executeResponse = syncHttpClient.prepareRequest(executeRequest.build()).call();
        AbortableInputStream bodyStream = null;
        try {
            bodyStream = executeResponse.responseBody().orElse(null);
            SdkHttpResponse httpResponse = executeResponse.httpResponse();
            return parseResponse(
                httpRequest.getUri(),
                httpRequest.method(),
                httpRequest.protocol(),
                httpResponse,
                bodyStream,
                endpoint,
                options
            );
        } finally {
            if (bodyStream != null) {
                bodyStream.close();
            }
        }
    }

    private <ResponseT> CompletableFuture<ResponseT> executeAsync(
        SdkAsyncHttpClient asyncHttpClient,
        SdkHttpRequest httpRequest,
        @CheckForNull OpenSearchRequestBodyBuffer requestBody,
        Endpoint<?, ResponseT, ?> endpoint,
        TransportOptions options
    ) {
        byte[] requestBodyArray = requestBody == null ? NO_BYTES : requestBody.getByteArray();
        final AsyncCapturingResponseHandler responseHandler = new AsyncCapturingResponseHandler();
        AsyncExecuteRequest.Builder executeRequest = AsyncExecuteRequest.builder()
            .request(httpRequest)
            .requestContentPublisher(new AsyncByteArrayContentPublisher(requestBodyArray))
            .responseHandler(responseHandler);
        CompletableFuture<Void> executeFuture = asyncHttpClient.execute(executeRequest.build());
        return executeFuture.thenCompose(_v -> responseHandler.getHeaderPromise())
            .thenCompose(response -> responseHandler.getBodyPromise().thenCompose(responseBody -> {
                CompletableFuture<ResponseT> ret = new CompletableFuture<>();
                try {
                    InputStream bodyStream = new ByteArrayInputStream(responseBody);
                    ret.complete(
                        parseResponse(
                            httpRequest.getUri(),
                            httpRequest.method(),
                            httpRequest.protocol(),
                            response,
                            bodyStream,
                            endpoint,
                            options
                        )
                    );
                } catch (Throwable e) {
                    ret.completeExceptionally(e);
                }
                return ret;
            }));
    }

    private <ResponseT, ErrorT> ResponseT parseResponse(
        URI uri,
        @Nonnull SdkHttpMethod method,
        String protocol,
        @Nonnull SdkHttpResponse httpResponse,
        @CheckForNull InputStream bodyStream,
        @Nonnull Endpoint<?, ResponseT, ErrorT> endpoint,
        @CheckForNull TransportOptions options
    ) throws IOException {
        final JsonpMapper mapper = Optional.ofNullable(
            options instanceof AwsSdk2TransportOptions ? ((AwsSdk2TransportOptions) options) : null
        ).map(AwsSdk2TransportOptions::mapper).orElse(defaultMapper);

        int statusCode = httpResponse.statusCode();
        boolean isZipped = httpResponse.firstMatchingHeader("Content-Encoding").map(enc -> enc.contains("gzip")).orElse(Boolean.FALSE);
        if (bodyStream != null && isZipped) {
            bodyStream = new GZIPInputStream(bodyStream);
        }

        if (statusCode == 403) {
            // Authentication errors from AWS do not follow OpenSearch exception format
            ErrorCause.Builder cause = new ErrorCause.Builder();
            cause.type("security_exception");
            cause.reason("authentication/authorization failure");

            if (bodyStream != null) {
                try (JsonParser parser = mapper.jsonProvider().createParser(bodyStream)) {
                    JsonObject val = JsonpDeserializer.jsonValueDeserializer().deserialize(parser, mapper).asJsonObject();
                    String message = null;
                    if (val.get("error") instanceof JsonObject) {
                        message = val.get("error").asJsonObject().getString("reason", null);
                    }
                    if (message == null) {
                        message = val.getString("Message", null);
                    }
                    if (message == null) {
                        message = val.getString("message", null);
                    }
                    if (message != null) {
                        cause.reason(message);
                    }
                } catch (Exception e) {
                    // OK. We'll use default message
                }
            }

            ErrorResponse error = ErrorResponse.of(err -> err.status(statusCode).error(cause.build()));
            throw new OpenSearchException(error);
        }

        if (endpoint.isError(statusCode)) {
            if (endpoint instanceof GenericEndpoint) {
                @SuppressWarnings("unchecked")
                final GenericEndpoint<?, ResponseT> rawEndpoint = (GenericEndpoint<?, ResponseT>) endpoint;

                String contentType = null;
                if (bodyStream != null) {
                    contentType = httpResponse.firstMatchingHeader(Header.CONTENT_TYPE).orElse(null);
                }

                final ResponseT error = rawEndpoint.responseDeserializer(
                    uri.toString(),
                    method.name(),
                    protocol,
                    httpResponse.statusCode(),
                    httpResponse.statusText().orElse(null),
                    httpResponse.headers()
                        .entrySet()
                        .stream()
                        .map(h -> new AbstractMap.SimpleEntry<String, String>(h.getKey(), Objects.toString(h.getValue())))
                        .collect(Collectors.toList()),
                    contentType,
                    bodyStream
                );

                throw rawEndpoint.exceptionConverter(statusCode, error);
            } else {
                JsonpDeserializer<ErrorT> errorDeserializer = endpoint.errorDeserializer(statusCode);
                if (errorDeserializer == null || bodyStream == null) {
                    throw new TransportException("Request failed with status code '" + statusCode + "'");
                }

                // We may have to reset if there is a parse deserialization exception
                bodyStream = toByteArrayInputStream(bodyStream);

                try {
                    try (JsonParser parser = mapper.jsonProvider().createParser(bodyStream)) {
                        ErrorT error = errorDeserializer.deserialize(parser, mapper);
                        throw new OpenSearchException((ErrorResponse) error);
                    } catch (MissingRequiredPropertyException errorEx) {
                        bodyStream.reset();
                        return decodeResponse(uri, method, protocol, httpResponse, bodyStream, endpoint, mapper);
                    }
                } catch (OpenSearchException e) {
                    throw e;
                } catch (Exception e) {
                    // can't parse the error - use a general exception
                    ErrorCause.Builder cause = new ErrorCause.Builder();
                    cause.type("http_exception");
                    cause.reason("server returned " + statusCode);
                    ErrorResponse error = ErrorResponse.of(err -> err.status(statusCode).error(cause.build()));
                    throw new OpenSearchException(error);
                }
            }
        } else {
            return decodeResponse(uri, method, protocol, httpResponse, bodyStream, endpoint, mapper);
        }
    }

    private <ResponseT, ErrorT> ResponseT decodeResponse(
        URI uri,
        @Nonnull SdkHttpMethod method,
        String protocol,
        @Nonnull SdkHttpResponse httpResponse,
        @CheckForNull InputStream bodyStream,
        @Nonnull Endpoint<?, ResponseT, ErrorT> endpoint,
        JsonpMapper mapper
    ) throws IOException {
        if (endpoint instanceof BooleanEndpoint) {
            BooleanEndpoint<?> bep = (BooleanEndpoint<?>) endpoint;
            @SuppressWarnings("unchecked")
            ResponseT response = (ResponseT) new BooleanResponse(bep.getResult(httpResponse.statusCode()));
            return response;
        } else if (endpoint instanceof JsonEndpoint) {
            JsonEndpoint<?, ResponseT, ?> jsonEndpoint = (JsonEndpoint<?, ResponseT, ?>) endpoint;
            // Successful response
            ResponseT response = null;
            JsonpDeserializer<ResponseT> responseParser = jsonEndpoint.responseDeserializer();
            if (responseParser != null) {
                // Expecting a body
                if (bodyStream == null) {
                    throw new TransportException("Expecting a response body, but none was sent");
                }
                try (JsonParser parser = mapper.jsonProvider().createParser(bodyStream)) {
                    try {
                        response = responseParser.deserialize(parser, mapper);
                    } catch (NullPointerException e) {
                        response = responseParser.deserialize(parser, mapper);
                    }
                }
            }
            return response;
        } else if (endpoint instanceof GenericEndpoint) {
            @SuppressWarnings("unchecked")
            final GenericEndpoint<?, ResponseT> rawEndpoint = (GenericEndpoint<?, ResponseT>) endpoint;

            String contentType = null;
            if (bodyStream != null) {
                contentType = httpResponse.firstMatchingHeader(Header.CONTENT_TYPE).orElse(null);
            }

            return rawEndpoint.responseDeserializer(
                uri.toString(),
                method.name(),
                protocol,
                httpResponse.statusCode(),
                httpResponse.statusText().orElse(null),
                httpResponse.headers()
                    .entrySet()
                    .stream()
                    .map(h -> new AbstractMap.SimpleEntry<String, String>(h.getKey(), Objects.toString(h.getValue())))
                    .collect(Collectors.toList()),
                contentType,
                bodyStream
            );
        } else {
            throw new TransportException("Unhandled endpoint type: '" + endpoint.getClass().getName() + "'");
        }
    }

    private <T> Optional<T> getOption(@Nullable TransportOptions options, @Nonnull Function<AwsSdk2TransportOptions, T> getter) {
        Objects.requireNonNull(getter, "getter must not be null");

        Function<AwsSdk2TransportOptions, Optional<T>> optGetter = o -> Optional.ofNullable(getter.apply(o));

        Optional<T> opt = Optional.ofNullable(options instanceof AwsSdk2TransportOptions ? (AwsSdk2TransportOptions) options : null)
            .flatMap(optGetter);

        return opt.isPresent() ? opt : optGetter.apply(transportOptions);
    }

    private static ByteArrayInputStream toByteArrayInputStream(InputStream is) throws IOException {
        // Optimization to avoid copying when applicable. `executeAsync` will produce `ByteArrayInputStream`.
        if (is instanceof ByteArrayInputStream) {
            return (ByteArrayInputStream) is;
        }
        return new ByteArrayInputStream(IoUtils.toByteArray(is));
    }

    /**
     * Wrap the exception so the caller's signature shows up in the stack trace, taking care to copy the original type and message
     * where possible so async and sync code don't have to check different exceptions.
     */
    private static Exception extractAndWrapCause(Exception exception) {
        if (exception instanceof InterruptedException) {
            throw new RuntimeException("thread waiting for the response was interrupted", exception);
        }
        if (exception instanceof ExecutionException) {
            ExecutionException executionException = (ExecutionException) exception;
            Throwable t = executionException.getCause() == null ? executionException : executionException.getCause();
            if (t instanceof Error) {
                throw (Error) t;
            }
            exception = (Exception) t;
        }
        if (exception instanceof SocketTimeoutException) {
            SocketTimeoutException e = new SocketTimeoutException(exception.getMessage());
            e.initCause(exception);
            return e;
        }
        if (exception instanceof SSLHandshakeException) {
            SSLHandshakeException e = new SSLHandshakeException(
                exception.getMessage() + "\nSee https://opensearch.org/docs/latest/clients/java/ for troubleshooting."
            );
            e.initCause(exception);
            return e;
        }
        if (exception instanceof ConnectException) {
            ConnectException e = new ConnectException(exception.getMessage());
            e.initCause(exception);
            return e;
        }
        if (exception instanceof IOException) {
            return new IOException(exception.getMessage(), exception);
        }
        if (exception instanceof OpenSearchException) {
            final OpenSearchException e = new OpenSearchException(((OpenSearchException) exception).response());
            e.initCause(exception);
            return e;
        }
        if (exception instanceof OpenSearchClientException) {
            final OpenSearchClientException e = new OpenSearchClientException(((OpenSearchClientException) exception).response());
            e.initCause(exception);
            return e;
        }
        if (exception instanceof RuntimeException) {
            return new RuntimeException(exception.getMessage(), exception);
        }
        return new RuntimeException("error while performing request", exception);
    }
}
