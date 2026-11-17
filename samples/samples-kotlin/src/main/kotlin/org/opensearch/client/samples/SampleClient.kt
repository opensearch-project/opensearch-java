/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.samples

import org.apache.hc.client5.http.auth.AuthScope
import org.apache.hc.client5.http.auth.UsernamePasswordCredentials
import org.apache.hc.client5.http.impl.auth.BasicCredentialsProvider
import org.apache.hc.client5.http.impl.nio.PoolingAsyncClientConnectionManagerBuilder
import org.apache.hc.client5.http.ssl.ClientTlsStrategyBuilder
import org.apache.hc.client5.http.ssl.NoopHostnameVerifier
import org.apache.hc.core5.http.HttpHost
import org.apache.hc.core5.ssl.SSLContextBuilder
import org.opensearch.client.json.jackson3.JacksonJsonpMapper
import org.opensearch.client.opensearch.OpenSearchClient
import org.opensearch.client.transport.httpclient5.ApacheHttpClient5TransportBuilder

object SampleClient {
    @JvmStatic
    fun create(): OpenSearchClient {
        val env = System.getenv()
        val https = (env["HTTPS"] ?: "true").toBoolean()
        val hostname = env["HOST"] ?: "localhost"
        val port = (env["PORT"] ?: "9200").toInt()
        val user = env["USERNAME"] ?: "admin"
        val pass = env["PASSWORD"] ?: "admin"

        val hosts = arrayOf(HttpHost(if (https) "https" else "http", hostname, port))

        val sslContext = SSLContextBuilder.create().loadTrustMaterial(null) { _, _ -> true }.build()

        val transport = ApacheHttpClient5TransportBuilder.builder(*hosts)
            .setMapper(JacksonJsonpMapper())
            .setHttpClientConfigCallback { httpClientBuilder ->
                val credentialsProvider = BasicCredentialsProvider()
                for (host in hosts) {
                    credentialsProvider.setCredentials(
                        AuthScope(host),
                        UsernamePasswordCredentials(user, pass.toCharArray())
                    )
                }

                // Disable SSL/TLS verification as our local testing clusters use self-signed certificates
                val tlsStrategy = ClientTlsStrategyBuilder.create()
                    .setSslContext(sslContext)
                    .setHostnameVerifier(NoopHostnameVerifier.INSTANCE)
                    .build()

                val connectionManager = PoolingAsyncClientConnectionManagerBuilder.create()
                    .setTlsStrategy(tlsStrategy)
                    .build()

                httpClientBuilder
                    .setDefaultCredentialsProvider(credentialsProvider)
                    .setConnectionManager(connectionManager)
            }
            .build()
        return OpenSearchClient(transport)
    }
}
