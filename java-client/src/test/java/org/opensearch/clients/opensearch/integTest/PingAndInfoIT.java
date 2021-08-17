///*
// * SPDX-License-Identifier: Apache-2.0
// *
// * The OpenSearch Contributors require contributions made to
// * this file be licensed under the Apache-2.0 license or a
// * compatible open source license.
// */
//
//package org.opensearch.clients.opensearch.integTest;
//
//import org.apache.http.client.methods.HttpGet;
//import org.opensearch.clients.opensearch.OpenSearchClient;
//
//import java.io.IOException;
//import java.util.Map;
//
//public class PingAndInfoIT extends OpenSearchRestHighLevelClientTestCase {
//
//    public void testPing() throws IOException {
//        OpenSearchClient openSearchClient = highLevelClient();
//        BooleanResponse ping = openSearchClient.ping();
//        assertTrue(ping.value());
//    }
//
//    public void testInfo() throws IOException {
//        OpenSearchClient openSearchClient = highLevelClient();
//        InfoResponse info = openSearchClient.info();
//
//        // compare with what the low level client outputs
//        Map<String, Object> infoAsMap = entityAsMap(adminClient().performRequest(new Request(HttpGet.METHOD_NAME, "/")));
//        assertEquals(infoAsMap.get("cluster_name"), info.clusterName());
//        assertEquals(infoAsMap.get("cluster_uuid"), info.clusterUuid());
//
//        @SuppressWarnings("unchecked")
//        Map<String, Object> versionMap = (Map<String, Object>) infoAsMap.get("version");
//        assertEquals(versionMap.get("build_date"), info.version().buildDate());
//        assertEquals(versionMap.get("build_flavor"), info.version().buildFlavor());
//        assertEquals(versionMap.get("build_hash"), info.version().buildHash());
//        assertEquals(versionMap.get("build_snapshot"), info.version().buildSnapshot());
//        assertEquals(versionMap.get("build_type"), info.version().buildType());
//        assertEquals(versionMap.get("distribution"), info.version().distribution());
//        assertEquals(versionMap.get("lucene_version"), info.version().luceneVersion());
//        assertTrue(versionMap.get("number").toString().startsWith(info.version().number()));
//    }
//
//}
