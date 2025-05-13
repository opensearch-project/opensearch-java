/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.opensearch.integTest.httpclient5;

import static org.opensearch.client.opensearch.integTest.OpenSearchJavaClientTestCase.COMPRESSION_ENABLED;
import static org.opensearch.client.opensearch.integTest.OpenSearchJavaClientTestCase.CUSTOM_CLIENT_ID;
import static org.opensearch.client.opensearch.integTest.OpenSearchJavaClientTestCase.METRICS_ENABLED;
import static org.opensearch.client.opensearch.integTest.OpenSearchJavaClientTestCase.METRICS_GROUPS;
import static org.opensearch.test.rest.OpenSearchRestTestCase.CLIENT_PATH_PREFIX;
import static org.opensearch.test.rest.OpenSearchRestTestCase.CLIENT_SOCKET_TIMEOUT;

import io.micrometer.core.instrument.simple.SimpleMeterRegistry;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.List;
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
import org.opensearch.client.transport.client_metrics.MetricGroup;
import org.opensearch.client.transport.client_metrics.MetricOptions;
import org.opensearch.client.transport.httpclient5.ApacheHttpClient5TransportBuilder;
import org.opensearch.common.settings.Settings;
import org.opensearch.common.unit.TimeValue;
import org.opensearch.common.util.concurrent.ThreadContext;

interface HttpClient5TransportSupport extends OpenSearchTransportSupport {
    @Override
    default OpenSearchTransport buildTransport(Settings settings, org.apache.http.HttpHost[] hosts) throws IOException {
        final HttpHost[] converted = Arrays.stream(hosts)
            .map(h -> new HttpHost(h.getSchemeName(), h.getHostName(), h.getPort()))
            .toArray(HttpHost[]::new);

        final ApacheHttpClient5TransportBuilder builder = ApacheHttpClient5TransportBuilder.builder(converted);
        configure(builder, settings, converted);
        return builder.setStrictDeprecationMode(true).build();
    }

    private void configure(ApacheHttpClient5TransportBuilder builder, Settings settings, HttpHost[] hosts) throws IOException {
        if (isHttps()) {
            try {
                final SSLContext sslcontext = SSLContextBuilder.create().loadTrustMaterial(null, (chains, authType) -> true).build();

                builder.setHttpClientConfigCallback(httpClientBuilder -> {
                    String userName = Optional.ofNullable(System.getProperty("user")).orElse("admin");
                    String password = Optional.ofNullable(System.getProperty("password")).orElse("admin");

                    final BasicCredentialsProvider credentialsProvider = new BasicCredentialsProvider();
                    for (final HttpHost host : hosts) {
                        credentialsProvider.setCredentials(
                            new AuthScope(host),
                            new UsernamePasswordCredentials(userName, password.toCharArray())
                        );
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

                    return httpClientBuilder.setDefaultCredentialsProvider(credentialsProvider).setConnectionManager(connectionManager);
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
        if (settings.hasValue(METRICS_ENABLED) && settings.getAsBoolean(METRICS_ENABLED, false)) {
            MetricOptions.MetricOptionsBuilder metricOptionsBuilder = MetricOptions.builder()
                .setMeterRegistry(new SimpleMeterRegistry())
                .setPercentiles(0.95)
                .setMetricsEnabled(true);
            if (settings.hasValue(CUSTOM_CLIENT_ID)) {
                metricOptionsBuilder.setClientId(settings.get(CUSTOM_CLIENT_ID));
            }
            if (settings.hasValue(METRICS_GROUPS)) {
                List<String> metricGroupStrList = settings.getAsList(METRICS_GROUPS);
                MetricGroup[] metricGroups = new MetricGroup[metricGroupStrList.size()];
                for (int j = 0; j < metricGroupStrList.size(); j++) {
                    metricGroups[j] = MetricGroup.valueOf(metricGroupStrList.get(j));
                }
                metricOptionsBuilder.setAdditionalMetricGroups(metricGroups);
            }
            builder.setMetricOptions(metricOptionsBuilder.build());
        }
        if (settings.hasValue(COMPRESSION_ENABLED)) {
            builder.setCompressionEnabled(settings.getAsBoolean(COMPRESSION_ENABLED, false));
        }
    }
}
