/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.opensearch._types.analysis;

import static org.junit.Assert.assertEquals;

import jakarta.json.stream.JsonParser;
import java.io.StringReader;
import org.junit.Test;
import org.opensearch.client.json.jackson.JacksonJsonpMapper;

public class PatternReplaceCharFilterTest {
    @Test
    public void testCreatePatternReplaceCharFilter() {
        PatternReplaceCharFilter patternReplaceCharFilter = new PatternReplaceCharFilter.Builder().pattern("pattern").build();
        assertEquals("pattern", patternReplaceCharFilter.pattern());
    }

    @Test
    public void testCreatePatternReplaceCharFilterWithReplacement() {
        PatternReplaceCharFilter patternReplaceCharFilter = new PatternReplaceCharFilter.Builder().pattern("pattern")
            .replacement("replacement")
            .build();
        assertEquals("pattern", patternReplaceCharFilter.pattern());
        assertEquals("replacement", patternReplaceCharFilter.replacement());
    }

    @Test
    public void testCreatePatternReplaceCharFilterWithFlags() {
        PatternReplaceCharFilter patternReplaceCharFilter = new PatternReplaceCharFilter.Builder().pattern("pattern")
            .replacement("replacement")
            .flags("flags")
            .build();
        assertEquals("pattern", patternReplaceCharFilter.pattern());
        assertEquals("replacement", patternReplaceCharFilter.replacement());
        assertEquals("flags", patternReplaceCharFilter.flags());
    }

    @Test
    public void testDeserializePatternReplaceCharFilterWithAllFields() {
        String jsonString =
            "{\"type\": \"pattern_replace\", \"pattern\": \"pattern\", \"replacement\": \"replacement\", \"flags\": \"flags\"}";

        StringReader reader = new StringReader(jsonString);
        JacksonJsonpMapper mapper = new JacksonJsonpMapper();
        JsonParser parser = mapper.jsonProvider().createParser(reader);

        PatternReplaceCharFilter patternReplaceCharFilter = PatternReplaceCharFilter._DESERIALIZER.deserialize(parser, mapper);
        assertEquals("pattern", patternReplaceCharFilter.pattern());
        assertEquals("replacement", patternReplaceCharFilter.replacement());
        assertEquals("flags", patternReplaceCharFilter.flags());
    }

    @Test
    public void testDeserializePatternReplaceCharFilterWithPatternOnly() {
        String jsonString = "{\"type\": \"pattern_replace\", \"pattern\": \"pattern\"}";

        StringReader reader = new StringReader(jsonString);
        JacksonJsonpMapper mapper = new JacksonJsonpMapper();
        JsonParser parser = mapper.jsonProvider().createParser(reader);

        PatternReplaceCharFilter patternReplaceCharFilter = PatternReplaceCharFilter._DESERIALIZER.deserialize(parser, mapper);
        assertEquals("pattern", patternReplaceCharFilter.pattern());
    }
}
