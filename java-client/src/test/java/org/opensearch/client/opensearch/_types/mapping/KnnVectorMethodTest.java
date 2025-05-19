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
import java.util.Collections;
import junit.framework.TestCase;
import org.junit.Test;
import org.opensearch.client.json.JsonData;
import org.opensearch.client.json.jackson.JacksonJsonpMapper;

public class KnnVectorMethodTest {
    @Test
    public void testCreateKnnVectorMethod() {
        KnnVectorMethod knnVectorMethod = new KnnVectorMethod.Builder().name("hnsw").build();
        assertEquals("hnsw", knnVectorMethod.name());
    }

    @Test
    public void testCreateKnnVectorMethodWithAll() {
        KnnVectorMethod knnVectorMethod = new KnnVectorMethod.Builder().name("hnsw")
            .spaceType("l2")
            .engine("faiss")
            .parameters(Collections.singletonMap("ef_construction", JsonData.of(128)))
            .build();
        assertEquals("hnsw", knnVectorMethod.name());
        assertEquals("l2", knnVectorMethod.spaceType());
        assertEquals("faiss", knnVectorMethod.engine());
        assertEquals("128", knnVectorMethod.parameters().get("ef_construction").toString());
    }

    @Test
    public void testDeserializeKnnVectorMethod() {
        String jsonString = "{\"name\": \"hnsw\", \"space_type\": \"l2\", \"engine\": \"faiss\","
            + " \"parameters\": {\"ef_construction\": 128, \"m\": 24}}";
        StringReader reader = new StringReader(jsonString);
        JacksonJsonpMapper mapper = new JacksonJsonpMapper();
        JsonParser parser = mapper.jsonProvider().createParser(reader);

        KnnVectorMethod knnVectorMethod = KnnVectorMethod._DESERIALIZER.deserialize(parser, mapper);

        TestCase.assertEquals("hnsw", knnVectorMethod.name());
        TestCase.assertEquals("l2", knnVectorMethod.spaceType());
        TestCase.assertEquals("faiss", knnVectorMethod.engine());
        TestCase.assertEquals("128", knnVectorMethod.parameters().get("ef_construction").toString());
        TestCase.assertEquals("24", knnVectorMethod.parameters().get("m").toString());
    }
}
