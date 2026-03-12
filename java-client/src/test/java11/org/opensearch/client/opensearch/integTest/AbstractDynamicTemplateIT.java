/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.opensearch.integTest;

import jakarta.json.stream.JsonParser;
import java.io.IOException;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.jackson.JacksonJsonpMapper;
import org.opensearch.client.opensearch._types.Refresh;
import org.opensearch.client.opensearch._types.mapping.TypeMapping;
import org.opensearch.client.opensearch.core.IndexResponse;
import org.opensearch.client.opensearch.core.SearchResponse;

public abstract class AbstractDynamicTemplateIT extends OpenSearchJavaClientTestCase {
    private static final String INDEX_NAME_ONE = "dynamic-templates-test-one";
    private static final String INDEX_NAME_TWO = "dynamic-templates-test-two";

    @Test
    public void shouldCreateDynamicTemplateOne() throws IOException {
        // Create index with dynamic templates
        final String dynamicTemplatesMappingOne = """
            {
              "dynamic_templates": [
                {
                  "with_custom_analyzer": {
                    "mapping": {
                      "type": "text",
                      "analyzer": "standard"
                    },
                    "path_match": "names.*"
                  }
                }
              ]
            }
            """;

        final TypeMapping typeMapping = parseMappingJson(dynamicTemplatesMappingOne);

        javaClient().indices().create(builder -> builder.index(INDEX_NAME_ONE).mappings(typeMapping));

        // Index a document with a Map containing a key with a DOT
        // This is the problematic case: "first.last" as a property name
        final Map<String, Object> document = new HashMap<>();
        document.put("id", "1");

        final Map<String, String> names = new HashMap<>();
        names.put("John", "Smith");
        document.put("names", names);

        final IndexResponse indexResponse = javaClient().index(
            builder -> builder.index(INDEX_NAME_ONE).id("1").document(document).refresh(Refresh.True)
        );

        assertEquals("Created", indexResponse.result().name());

        // Search to verify the document was indexed
        final SearchResponse<Map> searchResponse = javaClient().search(
            builder -> builder.index(INDEX_NAME_ONE).query(q -> q.matchAll(m -> m)),
            Map.class
        );

        assertEquals(1L, searchResponse.hits().total().value());

        // Verify we can retrieve the nested property value
        @SuppressWarnings("unchecked")
        final Map<String, Object> source = searchResponse.hits().hits().get(0).source();
        assertNotNull(source);
        assertTrue(source.get("names") instanceof Map);

        @SuppressWarnings("unchecked")
        final Map<String, String> retrievedNames = (Map<String, String>) source.get("names");
        assertEquals("Smith", retrievedNames.get("John"));
    }

    @Test
    public void shouldCreateDynamicTemplateTwo() throws IOException {
        // Create index with dynamic templates
        final String dynamicTemplatesMappingTwo = """
            {
              "dynamic_templates": [
                {
                  "keywords_without_doc_values": {
                    "match_mapping_type": "string",
                    "mapping": {
                      "fields": {
                        "keyword": {
                          "type": "keyword",
                          "doc_values": false
                        }
                      }
                    },
                    "path_match": "names.*"
                  }
                }
              ]
            }
            """;

        final TypeMapping typeMapping = parseMappingJson(dynamicTemplatesMappingTwo);

        javaClient().indices().create(builder -> builder.index(INDEX_NAME_TWO).mappings(typeMapping));

        // Index a document with a Map containing a key with a DOT
        // This is the problematic case: "first.last" as a property name
        final Map<String, Object> document = new HashMap<>();
        document.put("id", "1");

        final Map<String, String> names = new HashMap<>();
        names.put("first.last", "Smith");  // Property name contains a dot
        document.put("names", names);

        final IndexResponse indexResponse = javaClient().index(
            builder -> builder.index(INDEX_NAME_TWO).id("1").document(document).refresh(Refresh.True)
        );

        assertEquals("Created", indexResponse.result().name());

        // Search to verify the document was indexed
        final SearchResponse<Map> searchResponse = javaClient().search(
            builder -> builder.index(INDEX_NAME_TWO).query(q -> q.matchAll(m -> m)),
            Map.class
        );

        assertEquals(1L, searchResponse.hits().total().value());

        // Verify we can retrieve the nested property value
        @SuppressWarnings("unchecked")
        final Map<String, Object> source = searchResponse.hits().hits().get(0).source();
        assertNotNull(source);
        assertTrue(source.get("names") instanceof Map);

        @SuppressWarnings("unchecked")
        final Map<String, String> retrievedNames = (Map<String, String>) source.get("names");
        assertEquals("Smith", retrievedNames.get("first.last"));
    }

    /**
     * Parse JSON mapping string into TypeMapping object.
     */
    private TypeMapping parseMappingJson(final String json) {
        final JsonpMapper mapper = new JacksonJsonpMapper();
        try (final JsonParser parser = mapper.jsonProvider().createParser(new StringReader(json))) {
            return mapper.deserialize(parser, TypeMapping.class);
        }
    }
}
