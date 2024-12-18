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
import org.junit.Ignore;
import org.junit.Test;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.jsonb.JsonbJsonpMapper;
import org.opensearch.client.opensearch.indices.PutTemplateRequest;

public class PutTemplateRequestTest extends Assert {

    // TODO: Allow constructing requests from JSON with required path params
    @Ignore
    @Test
    public void deserialize_validFieldsIncluded_RequestIsBuilt() throws JsonProcessingException {
        final JsonpMapper mapper = new JsonbJsonpMapper();
        final Map<String, Object> indexTemplateMap = new HashMap<>();
        indexTemplateMap.put("name", "test");
        indexTemplateMap.put("index_patterns", "*");
        indexTemplateMap.put("order", 1);

        final String indexTemplate = new ObjectMapper().writeValueAsString(indexTemplateMap);
        final JsonParser parser = mapper.jsonProvider().createParser(new StringReader(indexTemplate));

        final PutTemplateRequest putTemplateRequest = PutTemplateRequest._DESERIALIZER.deserialize(parser, mapper);

        assertEquals("test", putTemplateRequest.name());
        assertEquals(Collections.singletonList("*"), putTemplateRequest.indexPatterns());
        assertEquals((Integer) 1, putTemplateRequest.order());
    }
}
