package org.opensearch.client.opensearch.core;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.jsonb.JsonbJsonpMapper;
import org.opensearch.client.opensearch.indices.PutIndexTemplateRequest;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

public class PutIndexTemplateRequestTest extends Assert {

    @Test
    public void deserialize_validFieldsIncluded_RequestIsBuilt() throws JsonProcessingException {
        final JsonpMapper mapper = new JsonbJsonpMapper();
        final Map<String, Object> indexTemplateMap = Map.of("name", "test", "index_patterns", "*", "create", true, "priority", 1);

        final String indexTemplate = new ObjectMapper().writeValueAsString(indexTemplateMap);
        final var parser = mapper.jsonProvider().createParser(new StringReader(indexTemplate));

        final PutIndexTemplateRequest putIndexTemplateRequest = PutIndexTemplateRequest._DESERIALIZER.deserialize(parser, mapper);

        assertEquals(putIndexTemplateRequest.name(), "test");
        assertEquals(putIndexTemplateRequest.indexPatterns(), List.of("*"));
        assertEquals((int) putIndexTemplateRequest.priority(), 1);
    }

}
