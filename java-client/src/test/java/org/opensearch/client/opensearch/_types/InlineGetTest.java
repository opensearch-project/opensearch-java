/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.opensearch._types;

import static org.junit.Assert.assertEquals;

import jakarta.json.stream.JsonParser;
import java.io.StringReader;
import org.junit.Test;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.jackson.JacksonJsonpMapper;

public class InlineGetTest {
    @Test
    public void testInlineGet_withSource() {
        final InlineGet inlineGet = InlineGet.of(
            b -> b.found(true).seqNo(1L).primaryTerm(2L).routing("routing").source("{\"name\":\"John Doe\"}")
        );

        final String jsonString = "{\"found\":true,\"_seq_no\":1,\"_primary_term\":2,\"_routing\":\"routing\","
            + "\"_source\":\"{\\\"name\\\":\\\"John Doe\\\"}\"}";

        final StringReader reader = new StringReader(jsonString);
        final JacksonJsonpMapper mapper = new JacksonJsonpMapper();
        final JsonParser parser = mapper.jsonProvider().createParser(reader);
        final InlineGet actual = InlineGet.createInlineGetDeserializer(JsonpDeserializer.stringDeserializer()).deserialize(parser, mapper);
        assertEquals(inlineGet.found(), actual.found());
        assertEquals(inlineGet.seqNo(), actual.seqNo());
        assertEquals(inlineGet.primaryTerm(), actual.primaryTerm());
        assertEquals(inlineGet.routing(), actual.routing());
        assertEquals(inlineGet.source(), actual.source());
    }

    @Test
    public void testInlineGet_withoutSource() {
        final InlineGet inlineGet = InlineGet.of(b -> b.found(true).seqNo(1L).primaryTerm(2L).routing("routing"));

        final String jsonString = "{\"found\":true,\"_seq_no\":1,\"_primary_term\":2,\"_routing\":\"routing\"}";

        final StringReader reader = new StringReader(jsonString);
        final JacksonJsonpMapper mapper = new JacksonJsonpMapper();
        final JsonParser parser = mapper.jsonProvider().createParser(reader);
        final InlineGet actual = InlineGet.createInlineGetDeserializer(JsonpDeserializer.stringDeserializer()).deserialize(parser, mapper);
        assertEquals(inlineGet.found(), actual.found());
        assertEquals(inlineGet.seqNo(), actual.seqNo());
        assertEquals(inlineGet.primaryTerm(), actual.primaryTerm());
        assertEquals(inlineGet.routing(), actual.routing());
    }
}
