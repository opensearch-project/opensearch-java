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

package org.opensearch.clients.opensearch.integTest;

import org.apache.http.client.methods.HttpGet;
import org.opensearch.client.Request;
import org.opensearch.clients.base.BooleanResponse;
import org.opensearch.clients.opensearch.OpenSearchClient;
import org.opensearch.clients.opensearch._global.InfoResponse;

import java.io.IOException;
import java.util.Map;

public class PingAndInfoIT extends OpenSearchRestHighLevelClientTestCase {

    public void testPing() throws IOException {
        OpenSearchClient openSearchClient = highLevelClient();
        BooleanResponse ping = openSearchClient.ping();
        assertTrue(ping.value());
    }

    public void testInfo() throws IOException {
        OpenSearchClient openSearchClient = highLevelClient();
        InfoResponse info = openSearchClient.info();

        // compare with what the low level client outputs
        Map<String, Object> infoAsMap = entityAsMap(adminClient().performRequest(new Request(HttpGet.METHOD_NAME, "/")));
        assertEquals(infoAsMap.get("cluster_name"), info.clusterName());
        assertEquals(infoAsMap.get("cluster_uuid"), info.clusterUuid());

        @SuppressWarnings("unchecked")
        Map<String, Object> versionMap = (Map<String, Object>) infoAsMap.get("version");
        assertEquals(versionMap.get("build_type"), info.version().buildType());
        assertEquals(versionMap.get("build_hash"), info.version().buildHash());
        assertEquals(versionMap.get("build_date"), info.version().buildDate());
        assertEquals(versionMap.get("build_snapshot"), info.version().buildSnapshot());
        assertTrue(versionMap.get("number").toString().startsWith(info.version().number()));
        assertEquals(versionMap.get("lucene_version"), info.version().luceneVersion());
    }

}
