package org.opensearch.client.opensearch._types.mapping;

import jakarta.json.stream.JsonParser;
import org.junit.Test;
import org.opensearch.client.json.jackson.JacksonJsonpMapper;
import org.opensearch.client.util.MissingRequiredPropertyException;

import java.io.StringReader;

import static junit.framework.TestCase.assertEquals;

public class KnnVectorPropertyTest {

    @Test
    public void testCreateKnnVectorProperty() {
        KnnVectorProperty knnVectorProperty = new KnnVectorProperty.Builder()
                .dimension(10)
                .build();
        assertEquals(10, knnVectorProperty.dimension());
    }

    @Test
    public void testCreateKnnVectorPropertyWithAllFields() {
        KnnVectorProperty knnVectorProperty = new KnnVectorProperty.Builder()
                .dimension(10)
                .method(new KnnVectorMethod.Builder()
                        .name("hnsw")
                        .build()
                )
                .build();
        assertEquals(10, knnVectorProperty.dimension());
        assertEquals("hnsw", knnVectorProperty.method().name());
    }

    @Test(expected = MissingRequiredPropertyException.class)
    public void testCreateKnnVectorPropertyNoDimension() {
        new KnnVectorProperty.Builder()
                .build();
    }

    @Test
    public void testDeserializeKnnVectorProperty() {
        String jsonString = "{\"type\": \"knn_vector\", \"dimension\": 4, \"model_id\": \"testModelId\", \"method\": {\"name\": \"hnsw\", \"space_type\": \"l2\", \"engine\": \"nmslib\", \"parameters\": {\"ef_construction\": 128, \"m\": 24}}}";
        StringReader reader = new StringReader(jsonString);
        JacksonJsonpMapper mapper = new JacksonJsonpMapper();
        JsonParser parser = mapper.jsonProvider().createParser(reader);

        KnnVectorProperty knnVectorProperty = KnnVectorProperty._DESERIALIZER.deserialize(parser, mapper);

        assertEquals(4, knnVectorProperty.dimension());
        assertEquals("testModelId", knnVectorProperty.modelId());
        assertEquals("hnsw", knnVectorProperty.method().name());
        assertEquals("l2", knnVectorProperty.method().spaceType());
        assertEquals("nmslib", knnVectorProperty.method().engine());
        assertEquals("128", knnVectorProperty.method().parameters().get("ef_construction").toString());
        assertEquals("24", knnVectorProperty.method().parameters().get("m").toString());
    }
}
