/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.opensearch._types.mapping;

import static org.junit.Assert.assertEquals;

import jakarta.json.stream.JsonParser;
import java.io.StringReader;
import org.junit.Test;
import org.opensearch.client.json.jackson.JacksonJsonpMapper;
import org.opensearch.client.opensearch.model.ModelTestCase;

public class MatchOnlyTextPropertyTest extends ModelTestCase {

    @Test
    public void testDeserializeAnalyzers() {
        String json = "{\"type\": \"match_only_text\", \"analyzer\": \"standard\", \"search_analyzer\": \"whitespace\"}";
        JacksonJsonpMapper mapper = new JacksonJsonpMapper();
        JsonParser parser = mapper.jsonProvider().createParser(new StringReader(json));

        Property property = Property._DESERIALIZER.deserialize(parser, mapper);

        assertEquals(Property.Kind.MatchOnlyText, property._kind());
        MatchOnlyTextProperty matchOnlyText = property.matchOnlyText();
        assertEquals("standard", matchOnlyText.analyzer());
        assertEquals("whitespace", matchOnlyText.searchAnalyzer());
    }

    @Test
    public void testSerializeAnalyzers() {
        Property property = Property.of(p -> p.matchOnlyText(m -> m.analyzer("standard").searchAnalyzer("whitespace")));

        assertEquals("{\"type\":\"match_only_text\",\"analyzer\":\"standard\",\"search_analyzer\":\"whitespace\"}", toJson(property));
    }
}
