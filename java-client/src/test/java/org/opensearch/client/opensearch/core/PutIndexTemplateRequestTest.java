/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.opensearch.core;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.json.stream.JsonParser;
import java.io.StringReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.junit.Assert;
import org.junit.Test;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.jsonb.JsonbJsonpMapper;
import org.opensearch.client.opensearch.indices.PutIndexTemplateRequest;

public class PutIndexTemplateRequestTest extends Assert {

    @Test
    public void deserialize_validFieldsIncluded_RequestIsBuilt() throws JsonProcessingException {
        final JsonpMapper mapper = new JsonbJsonpMapper();
        final Map<String, Object> indexTemplateMap = new HashMap<>();
        indexTemplateMap.put("name", "test");
        indexTemplateMap.put("index_patterns", "*");
        indexTemplateMap.put("create", true);
        indexTemplateMap.put("priority", 1);

        final String indexTemplate = new ObjectMapper().writeValueAsString(indexTemplateMap);
        final JsonParser parser = mapper.jsonProvider().createParser(new StringReader(indexTemplate));

        final PutIndexTemplateRequest putIndexTemplateRequest = PutIndexTemplateRequest._DESERIALIZER.deserialize(parser, mapper);

        assertEquals(putIndexTemplateRequest.name(), "test");
        assertEquals(putIndexTemplateRequest.indexPatterns(), Collections.singletonList("*"));
        assertEquals((int) putIndexTemplateRequest.priority(), 1);
    }

}
