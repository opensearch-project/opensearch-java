/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

/*
 * Licensed to Elasticsearch B.V. under one or more contributor
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
 * ownership. Elasticsearch B.V. licenses this file to you under
 * the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

/*
 * Modifications Copyright OpenSearch Contributors. See
 * GitHub history for details.
 */

package org.opensearch.client.transport;

import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import org.apache.hc.core5.http.HttpHost;
import org.apache.hc.core5.http.NameValuePair;
import org.apache.hc.core5.net.URLEncodedUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.opensearch.client.ResponseException;
import org.opensearch.client.RestClient;
import org.opensearch.client.json.jsonb.JsonbJsonpMapper;
import org.opensearch.client.opensearch.OpenSearchClient;
import org.opensearch.client.transport.rest_client.RestClientTransport;

public class RequestOptionsTest extends Assert {

    private static HttpServer httpServer;
    private static RestClient restClient;

    @Before
    public void classSetup() throws IOException {

        httpServer = HttpServer.create(new InetSocketAddress(InetAddress.getLoopbackAddress(), 0), 0);
        httpServer.createContext("/", ex -> {
            if (ex.getRequestMethod().equals("HEAD")) {
                // Call to ping()
                ex.sendResponseHeaders(200, -1);
            }

            // Call to info()
            // Send back all request headers with a 418 that will cause an exception where we can access the LLRC response
            ex.getResponseHeaders().putAll(ex.getRequestHeaders());
            ex.sendResponseHeaders(418, 0);
            OutputStreamWriter out = new OutputStreamWriter(ex.getResponseBody(), StandardCharsets.UTF_8);
            for (Map.Entry<String, List<String>> header : ex.getRequestHeaders().entrySet()) {
                out.write("header-");
                out.write(header.getKey().toLowerCase(Locale.ROOT));
                out.write("=");
                out.write(header.getValue().get(0));
                out.write("\n");
            }
            final List<NameValuePair> params = URLEncodedUtils.parse(ex.getRequestURI(), StandardCharsets.UTF_8);
            for (NameValuePair param : params) {
                out.write("param-");
                out.write(param.getName());
                out.write("=");
                out.write(param.getValue());
            }
            out.close();
        });

        httpServer.start();
        InetSocketAddress address = httpServer.getAddress();
        restClient = RestClient.builder(new HttpHost("http", address.getHostString(), address.getPort())).build();
    }

    @After
    public void classTearDown() throws IOException {
        httpServer.stop(0);
        restClient.close();
    }

    private Properties getProps(OpenSearchClient client) throws IOException {
        ResponseException ex = assertThrows(ResponseException.class, client::info);
        assertEquals(418, ex.getResponse().getStatusLine().getStatusCode());
        Properties result = new Properties();
        result.load(ex.getResponse().getEntity().getContent());
        return result;
    }

    @Test
    public void testClientHeader() throws IOException {
        final RestClientTransport trsp = new RestClientTransport(restClient, new JsonbJsonpMapper());
        final OpenSearchClient client = new OpenSearchClient(trsp).withTransportOptions(
            trsp.options().with(b -> b.addHeader("X-Foo", "Bar").addHeader("uSer-agEnt", "MegaClient/1.2.3"))
        );

        Properties props = getProps(client);
        assertEquals("Bar", props.getProperty("header-x-foo"));
        assertEquals("MegaClient/1.2.3", props.getProperty("header-user-agent"));
    }
}
