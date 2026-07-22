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
import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * gRPC {@link ClientInterceptor} that adds HTTP Basic Authentication credentials
 * to every outgoing gRPC call as metadata.
 * <p>
 * Attaches the {@code Authorization: Basic <base64(user:pass)>} header as gRPC metadata,
 * which the OpenSearch server reads for authentication.
 * <p>
 * This is the gRPC equivalent of the REST client's basic auth configuration
 * ({@code UsernamePasswordCredentials} on the HTTP client).
 * <p>
 * Usage:
 * <pre>{@code
 * BasicAuthInterceptor interceptor = new BasicAuthInterceptor("admin", "admin");
 * ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9400)
 *     .intercept(interceptor)
 *     .build();
 * }</pre>
 *
 * @see <a href="https://docs.opensearch.org/latest/security/authentication-backends/basic-authc/">OpenSearch Basic Auth</a>
 */
class BasicAuthInterceptor implements ClientInterceptor {

    private static final Metadata.Key<String> AUTHORIZATION_KEY = Metadata.Key.of("Authorization", Metadata.ASCII_STRING_MARSHALLER);

    private final String authHeaderValue;

    /**
     * Creates a basic auth interceptor with the given credentials.
     *
     * @param username the username
     * @param password the password
     * @throws IllegalArgumentException if username or password is null
     */
    BasicAuthInterceptor(String username, String password) {
        if (username == null) {
            throw new IllegalArgumentException("username cannot be null");
        }
        if (password == null) {
            throw new IllegalArgumentException("password cannot be null");
        }
        this.authHeaderValue = encodeBasicAuth(username, password);
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
                headers.put(AUTHORIZATION_KEY, authHeaderValue);
                super.start(responseListener, headers);
            }
        };
    }

    /**
     * Returns the encoded Authorization header value (for testing purposes).
     */
    String getAuthHeaderValue() {
        return authHeaderValue;
    }

    /**
     * Encodes username:password as a Basic auth header value.
     *
     * @return "Basic <base64(username:password)>"
     */
    private static String encodeBasicAuth(String username, String password) {
        String credentials = username + ":" + password;
        String encoded = Base64.getEncoder().encodeToString(credentials.getBytes(StandardCharsets.UTF_8));
        return "Basic " + encoded;
    }
}
