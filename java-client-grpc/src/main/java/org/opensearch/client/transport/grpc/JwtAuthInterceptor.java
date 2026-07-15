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
import java.util.function.Supplier;

/**
 * gRPC {@link ClientInterceptor} that adds JWT Bearer token authentication
 * to every outgoing gRPC call as metadata.
 * <p>
 * Attaches the {@code Authorization: Bearer <token>} header as gRPC metadata.
 * The token is obtained from a {@link Supplier} on every call to support
 * automatic token refresh/rotation.
 * <p>
 * Usage:
 * <pre>{@code
 * // Static token
 * JwtAuthInterceptor interceptor = new JwtAuthInterceptor(() -> "my-jwt-token");
 *
 * // Token from a refresh provider
 * JwtAuthInterceptor interceptor = new JwtAuthInterceptor(() -> tokenProvider.getAccessToken());
 *
 * // In the transport builder
 * GrpcTransport.builder("localhost", 9400)
 *     .jwtAuth(() -> myTokenProvider.getToken())
 *     .build();
 * }</pre>
 *
 * @see <a href="https://docs.opensearch.org/latest/security/authentication-backends/jwt/">OpenSearch JWT Authentication</a>
 */
public class JwtAuthInterceptor implements ClientInterceptor {

    private static final Metadata.Key<String> AUTHORIZATION_KEY = Metadata.Key.of("Authorization", Metadata.ASCII_STRING_MARSHALLER);

    private final Supplier<String> tokenSupplier;

    /**
     * Creates a JWT auth interceptor with a token supplier.
     * The supplier is called on every gRPC call to get a fresh token.
     *
     * @param tokenSupplier supplies the JWT token string (without "Bearer " prefix)
     * @throws IllegalArgumentException if tokenSupplier is null
     */
    public JwtAuthInterceptor(Supplier<String> tokenSupplier) {
        if (tokenSupplier == null) {
            throw new IllegalArgumentException("tokenSupplier cannot be null");
        }
        this.tokenSupplier = tokenSupplier;
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
                String token = tokenSupplier.get();
                if (token == null || token.isEmpty()) {
                    throw new IllegalStateException(
                        "JWT token supplier returned null or empty token. " + "Ensure your token provider is configured correctly."
                    );
                }
                headers.put(AUTHORIZATION_KEY, "Bearer " + token);
                super.start(responseListener, headers);
            }
        };
    }

    /**
     * Returns the token supplier (for testing).
     */
    Supplier<String> getTokenSupplier() {
        return tokenSupplier;
    }
}
