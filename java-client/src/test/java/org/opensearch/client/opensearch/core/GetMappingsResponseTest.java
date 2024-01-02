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
import org.opensearch.client.opensearch._types.mapping.IcuCollationKeywordProperty;
import org.opensearch.client.opensearch._types.mapping.Property;
import org.opensearch.client.opensearch._types.mapping.TypeMapping;
import org.opensearch.client.opensearch.indices.GetTemplateResponse;
import org.opensearch.client.opensearch.indices.TemplateMapping;

public class GetMappingsResponseTest extends Assert {

    @Test
    public void deserialize_IcuCollationKeywordExists_propertyDeserializes() throws JsonProcessingException {
        Map<String, Object> mappingTemplate = new HashMap<>();
        Map<String, Object> icuCollationConfig = new HashMap<>();
        icuCollationConfig.put("type", "icu_collation_keyword");
        icuCollationConfig.put("ignore_above", 1);
        icuCollationConfig.put("index", true);
        icuCollationConfig.put("null_value", "not-null-value");
        icuCollationConfig.put("store", true);

        // Collations
        icuCollationConfig.put("alternate", "shifted");
        icuCollationConfig.put("case_level", true);
        icuCollationConfig.put("case_first", "lower");
        icuCollationConfig.put("decomposition", "no");
        icuCollationConfig.put("hiragana_quaternary_mode", true);
        icuCollationConfig.put("numeric", true);
        icuCollationConfig.put("strength", "quaternary");
        icuCollationConfig.put("variable_top", "$");

        final Map<String, Object> mappingTemplateMap = new HashMap<>();
        mappingTemplateMap.put("aliases", Collections.emptyMap());
        mappingTemplateMap.put("index_patterns", Collections.singletonList("test-pattern*"));
        mappingTemplateMap.put(
            "mappings",
            Collections.singletonMap("properties", Collections.singletonMap("icu_test_field", icuCollationConfig))
        );
        mappingTemplateMap.put("order", 0);
        mappingTemplateMap.put("settings", Collections.emptyMap());
        mappingTemplateMap.put("version", 1);
        mappingTemplate.put("test-index", mappingTemplateMap);

        final JsonpMapper mapper = new JsonbJsonpMapper();
        final String indexTemplate = new ObjectMapper().writeValueAsString(mappingTemplate);
        final JsonParser parser = mapper.jsonProvider().createParser(new StringReader(indexTemplate));

        final GetTemplateResponse response = GetTemplateResponse._DESERIALIZER.deserialize(parser, mapper);
        final TemplateMapping template = response.get("test-index");
        final TypeMapping mappings = template.mappings();
        final Map<String, Property> properties = mappings.properties();
        final Property property = properties.get("icu_test_field");
        final IcuCollationKeywordProperty icu = property.icuCollationKeyword();

        assertEquals(property._kind(), Property.Kind.IcuCollationKeyword);
        assertTrue(property.isIcuCollationKeyword());
        assertEquals(icu.nullValue(), "not-null-value");
        assertTrue(icu.index());
        assertTrue(icu.store());
        assertEquals((int) icu.ignoreAbove(), 1);
        assertEquals(icu.alternate().jsonValue(), "shifted");
        assertTrue(icu.caseLevel());
        assertEquals(icu.caseFirst().jsonValue(), "lower");
        assertEquals(icu.decomposition().jsonValue(), "no");
        assertTrue(icu.hiraganaQuaternaryMode());
        assertTrue(icu.numeric());
        assertEquals(icu.strength().jsonValue(), "quaternary");
        assertEquals(icu.variableTop(), "$");
    }
}
