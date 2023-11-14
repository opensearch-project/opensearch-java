package org.opensearch.client.opensearch.core;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.StringReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.junit.Assert;
import org.junit.Test;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.jsonb.JsonbJsonpMapper;
import org.opensearch.client.opensearch._types.mapping.IcuCollationKeywordProperty;
import org.opensearch.client.opensearch._types.mapping.Property;
import org.opensearch.client.opensearch.indices.GetTemplateResponse;

public class GetMappingsResponseTest extends Assert {

    @Test
    public void deserialize_IcuCollationKeywordExists_propertyDeserializes() throws JsonProcessingException {
        Map<String, Object> mappingTemplate = new HashMap<>();
        mappingTemplate.put(
            "test-index",
            Map.of(
                "aliases",
                Collections.emptyMap(),
                "index_patterns",
                Collections.singletonList("test-pattern*"),
                "mappings",
                Map.of(
                    "properties",
                    Map.of(
                        "icu_test_field",
                        Map.of(
                            "type",
                            "icu_collation_keyword",
                            "ignore_above",
                            1,
                            "index",
                            true,
                            "null_value",
                            "not-null-value",
                            "store",
                            true
                        )
                    )
                ),
                "order",
                0,
                "settings",
                Collections.emptyMap(),
                "version",
                1
            )
        );
        final JsonpMapper mapper = new JsonbJsonpMapper();
        final String indexTemplate = new ObjectMapper().writeValueAsString(mappingTemplate);
        final var parser = mapper.jsonProvider().createParser(new StringReader(indexTemplate));

        final GetTemplateResponse response = GetTemplateResponse._DESERIALIZER.deserialize(parser, mapper);
        final var template = response.get("test-index");
        final var mappings = template.mappings();
        final var properties = mappings.properties();
        final var property = properties.get("icu_test_field");
        final IcuCollationKeywordProperty icu = property.icuCollationKeyword();

        assertEquals(property._kind(), Property.Kind.IcuCollationKeyword);
        assertTrue(property.isIcuCollationKeyword());
        assertEquals(icu.nullValue(), "not-null-value");
        assertTrue(icu.index());
        assertTrue(icu.store());
        assertEquals((int) icu.ignoreAbove(), 1);
    }
}
