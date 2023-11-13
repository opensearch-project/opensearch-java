package org.opensearch.client.opensearch.core;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.StringReader;
import java.util.List;
import java.util.Map;
import org.junit.Assert;
import org.junit.Test;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.jsonb.JsonbJsonpMapper;
import org.opensearch.client.opensearch.indices.PutTemplateRequest;

public class PutTemplateRequestTest extends Assert {
    private static String INDEX_NAME_FIELD = "name";
    private static String INDEX_PATTERNS_FIELD = "index_patterns";
    private static String CREATE_FIELD = "create";
    private static String ORDER_FIELD = "order";

    @Test
    public void deserialize_validFieldsIncluded_RequestIsBuilt() throws JsonProcessingException {
        // Arrange
        final JsonpMapper mapper = new JsonbJsonpMapper();
        final Map<String, Object> indexTemplateMap = Map.of(
            INDEX_NAME_FIELD,
            "test",
            INDEX_PATTERNS_FIELD,
            "*",
            CREATE_FIELD,
            true,
            ORDER_FIELD,
            1

        );
        final String indexTemplate = new ObjectMapper().writeValueAsString(indexTemplateMap);
        final var parser = mapper.jsonProvider().createParser(new StringReader(indexTemplate));

        // Act
        final PutTemplateRequest putTemplateRequest = PutTemplateRequest._DESERIALIZER.deserialize(parser, mapper);

        // Assert
        assertEquals(putTemplateRequest.name(), "test");
        assertEquals(putTemplateRequest.indexPatterns(), List.of("*"));
        assertEquals((long) putTemplateRequest.order(), 1L);
        assertEquals(putTemplateRequest.create(), true);
    }
}
