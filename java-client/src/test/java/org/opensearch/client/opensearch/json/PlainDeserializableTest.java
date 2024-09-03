/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.opensearch.json;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import org.opensearch.client.opensearch.indices.PutIndexTemplateRequest;
import org.opensearch.client.opensearch.indices.put_index_template.IndexTemplateMapping;

public class PlainDeserializableTest {
    @Test
    public void testWithJsonPutIndexTemplateRequest() {

        String stringTemplate =
            "{\"mappings\":{\"properties\":{\"age\":{\"type\":\"integer\"}}},\"settings\":{\"number_of_shards\":\"2\",\"number_of_replicas\":\"1\"}}";
        InputStream inputStream = new ByteArrayInputStream(stringTemplate.getBytes(StandardCharsets.UTF_8));

        PutIndexTemplateRequest indexTemplateRequest = new PutIndexTemplateRequest.Builder().name("My index")
            .indexPatterns("index_pattern1")
            .template(new IndexTemplateMapping.Builder().withJson(inputStream).build())
            .build();

        String expectedName = "My index";
        List<String> expectedIndexPatterns = Arrays.asList("index_pattern1");
        String expectedNumberOfShards = "2";

        assertEquals(indexTemplateRequest.name(), expectedName);
        assertEquals(expectedIndexPatterns, indexTemplateRequest.indexPatterns());
        assertEquals(expectedNumberOfShards, indexTemplateRequest.template().settings().numberOfShards());

    }
}
