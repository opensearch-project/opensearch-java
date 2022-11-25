/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.opensearch.integTest.httpclient5;

import static org.opensearch.test.rest.OpenSearchRestTestCase.CLIENT_PATH_PREFIX;
import static org.opensearch.test.rest.OpenSearchRestTestCase.CLIENT_SOCKET_TIMEOUT;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import java.util.Optional;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLEngine;

import org.apache.hc.client5.http.auth.AuthScope;
import org.apache.hc.client5.http.auth.UsernamePasswordCredentials;
import org.apache.hc.client5.http.impl.auth.BasicCredentialsProvider;
import org.apache.hc.client5.http.impl.nio.PoolingAsyncClientConnectionManager;
import org.apache.hc.client5.http.impl.nio.PoolingAsyncClientConnectionManagerBuilder;
import org.apache.hc.client5.http.ssl.ClientTlsStrategyBuilder;
import org.apache.hc.client5.http.ssl.NoopHostnameVerifier;
import org.apache.hc.core5.function.Factory;
import org.apache.hc.core5.http.Header;
import org.apache.hc.core5.http.HttpHost;
import org.apache.hc.core5.http.message.BasicHeader;
import org.apache.hc.core5.http.nio.ssl.TlsStrategy;
import org.apache.hc.core5.reactor.ssl.TlsDetails;
import org.apache.hc.core5.ssl.SSLContextBuilder;
import org.apache.hc.core5.util.Timeout;
import org.opensearch.client.opensearch.integTest.OpenSearchTransportSupport;
import org.opensearch.client.transport.OpenSearchTransport;
import org.opensearch.client.transport.httpclient5.ApacheHttpClient5TransportBuilder;
import org.opensearch.common.settings.Settings;
import org.opensearch.common.unit.TimeValue;
import org.opensearch.common.util.concurrent.ThreadContext;

interface HttpClient5TransportSupport extends OpenSearchTransportSupport {
    @Override
    default OpenSearchTransport buildTransport(Settings settings, HttpHost[] hosts) throws IOException {
        final ApacheHttpClient5TransportBuilder builder = ApacheHttpClient5TransportBuilder.builder(hosts);
        configure(builder, settings, hosts);
        return builder.setStrictDeprecationMode(true).build();
    }

    private void configure(ApacheHttpClient5TransportBuilder builder, Settings settings, HttpHost[] hosts) throws IOException {
        if (isHttps()) {
            try {
                final SSLContext sslcontext = SSLContextBuilder
                        .create()
                        .loadTrustMaterial(null, (chains, authType) -> true)
                        .build();

                builder.setHttpClientConfigCallback(httpClientBuilder -> {
                    String userName = Optional.ofNullable(System.getProperty("user")).orElse("admin");
                    String password = Optional.ofNullable(System.getProperty("password")).orElse("admin");
        
                    final BasicCredentialsProvider credentialsProvider = new BasicCredentialsProvider();
                    for (final HttpHost host: hosts) {
                        credentialsProvider.setCredentials(new AuthScope(host),
                            new UsernamePasswordCredentials(userName, password.toCharArray()));
                    }

                    final TlsStrategy tlsStrategy = ClientTlsStrategyBuilder.create()
                        .setSslContext(sslcontext)
                        // disable the certificate since our testing cluster just uses the default security configuration
                        .setHostnameVerifier(NoopHostnameVerifier.INSTANCE)
                        // See https://issues.apache.org/jira/browse/HTTPCLIENT-2219
                        .setTlsDetailsFactory(new Factory<SSLEngine, TlsDetails>() {
                            @Override
                            public TlsDetails create(final SSLEngine sslEngine) {
                                return new TlsDetails(sslEngine.getSession(), sslEngine.getApplicationProtocol());
                            }
                        })
                        .build();

                    final PoolingAsyncClientConnectionManager connectionManager = PoolingAsyncClientConnectionManagerBuilder.create()
                        .setTlsStrategy(tlsStrategy)
                        .build();

                    return httpClientBuilder
                        .setDefaultCredentialsProvider(credentialsProvider)
                        .setConnectionManager(connectionManager);
                });
            } catch (KeyStoreException | NoSuchAlgorithmException | KeyManagementException e) {
                throw new RuntimeException("Error setting up ssl", e);
            }
        }

        Map<String, String> headers = ThreadContext.buildDefaultHeaders(settings);
        Header[] defaultHeaders = new Header[headers.size()];
        int i = 0;
        for (Map.Entry<String, String> entry : headers.entrySet()) {
            defaultHeaders[i++] = new BasicHeader(entry.getKey(), entry.getValue());
        }
        builder.setDefaultHeaders(defaultHeaders);
        final String socketTimeoutString = settings.get(CLIENT_SOCKET_TIMEOUT);
        final TimeValue socketTimeout = TimeValue.parseTimeValue(
            socketTimeoutString == null ? "60s" : socketTimeoutString,
            CLIENT_SOCKET_TIMEOUT
        );
        builder.setRequestConfigCallback(
            conf -> conf.setResponseTimeout(Timeout.ofMilliseconds(Math.toIntExact(socketTimeout.getMillis())))
        );
        if (settings.hasValue(CLIENT_PATH_PREFIX)) {
            builder.setPathPrefix(settings.get(CLIENT_PATH_PREFIX));
        }
    }
}
