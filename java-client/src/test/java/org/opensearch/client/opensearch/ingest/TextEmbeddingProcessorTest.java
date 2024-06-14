/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.opensearch.ingest;

import java.util.HashMap;
import java.util.Map;
import org.junit.Test;
import org.opensearch.client.opensearch.model.ModelTestCase;

public class TextEmbeddingProcessorTest extends ModelTestCase {

    private static final Map<String, String> baseFieldMap = new HashMap<>();
    static {
        baseFieldMap.put("input_field", "vector_field");
    }

    private static TextEmbeddingProcessor.Builder baseTextEmbeddingProcessor() {
        return new TextEmbeddingProcessor.Builder().modelId("modelId").fieldMap(baseFieldMap).tag("some-tag");
    }

    @Test
    public void testJsonRoundtripWithDescription() {
        Processor processor = new Processor.Builder().textEmbedding(
            baseTextEmbeddingProcessor().description("processor-description").build()
        ).build();
        String json =
            "{\"text_embedding\":{\"tag\":\"some-tag\",\"model_id\":\"modelId\",\"field_map\":{\"input_field\":\"vector_field\"},\"description\":\"processor-description\"}}";
        TextEmbeddingProcessor deserialized = checkJsonRoundtrip(processor, json).textEmbedding();

        assertEquals("modelId", deserialized.modelId());
        assertEquals(baseFieldMap, deserialized.fieldMap());
        assertEquals("processor-description", deserialized.description());
        assertEquals("some-tag", deserialized.tag());
    }

    @Test
    public void testJsonRoundtripWithoutDescription() {
        Processor processor = new Processor.Builder().textEmbedding(baseTextEmbeddingProcessor().build()).build();
        String json =
            "{\"text_embedding\":{\"tag\":\"some-tag\",\"model_id\":\"modelId\",\"field_map\":{\"input_field\":\"vector_field\"}}}";
        TextEmbeddingProcessor deserialized = checkJsonRoundtrip(processor, json).textEmbedding();

        assertEquals("modelId", deserialized.modelId());
        assertEquals(baseFieldMap, deserialized.fieldMap());
        assertNull(deserialized.description());
        assertEquals("some-tag", deserialized.tag());
    }
}
