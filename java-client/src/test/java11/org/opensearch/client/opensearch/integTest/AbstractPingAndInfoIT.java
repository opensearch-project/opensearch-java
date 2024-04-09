/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.opensearch.integTest;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;

import java.io.IOException;
import java.util.Collections;
import java.util.Map;
import org.opensearch.client.opensearch.OpenSearchClient;
import org.opensearch.client.opensearch.core.InfoResponse;
import org.opensearch.client.opensearch.generic.Bodies;
import org.opensearch.client.opensearch.generic.OpenSearchGenericClient.ClientOptions;
import org.opensearch.client.opensearch.generic.Requests;
import org.opensearch.client.opensearch.generic.Response;
import org.opensearch.client.transport.endpoints.BooleanResponse;

public abstract class AbstractPingAndInfoIT extends OpenSearchJavaClientTestCase {
    public void testPing() throws IOException {
        BooleanResponse ping = javaClient().ping();
        assertTrue(ping.value());
    }

    public void testInfo() throws IOException {
        OpenSearchClient openSearchClient = javaClient();
        InfoResponse info = openSearchClient.info();

        // compare with what the low level client outputs
        try (
            Response response = javaClient().generic(ClientOptions.DEFAULT).execute(Requests.builder().endpoint("/").method("GET").build())
        ) {
            assertThat(response.getStatus(), equalTo(200));
            assertThat(response.getProtocol(), equalTo("HTTP/1.1"));
            assertThat(response.getBody().isEmpty(), is(false));

            Map<String, Object> infoAsMap = response.getBody()
                .map(b -> Bodies.json(b, Map.class, javaClient()._transport().jsonpMapper()))
                .orElseGet(Collections::emptyMap);

            assertEquals(infoAsMap.get("cluster_name"), info.clusterName());
            assertEquals(infoAsMap.get("cluster_uuid"), info.clusterUuid());

            @SuppressWarnings("unchecked")
            Map<String, Object> versionMap = (Map<String, Object>) infoAsMap.get("version");
            assertEquals(versionMap.get("build_date"), info.version().buildDate());
            assertEquals(versionMap.get("build_flavor"), info.version().buildFlavor());
            assertEquals(versionMap.get("build_hash"), info.version().buildHash());
            assertEquals(versionMap.get("build_snapshot"), info.version().buildSnapshot());
            assertEquals(versionMap.get("build_type"), info.version().buildType());
            assertEquals(versionMap.get("distribution"), info.version().distribution());
            assertEquals(versionMap.get("lucene_version"), info.version().luceneVersion());
            assertTrue(versionMap.get("number").toString().startsWith(info.version().number()));
        }
    }
}
