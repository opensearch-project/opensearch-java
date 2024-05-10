package org.opensearch.client.opensearch._types;

import jakarta.json.stream.JsonParser;
import org.junit.Test;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.jackson.JacksonJsonpMapper;

import java.io.StringReader;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class SortOptionsTest {

    @Test
    public void testSortOptions() {
        String jsonString = "[{\n" +
                "    \"entityId\": {\n" +
                "      \"order\": \"asc\"\n" +
                "    }\n" +
                "  }]";
        StringReader reader = new StringReader(jsonString);
        JacksonJsonpMapper mapper = new JacksonJsonpMapper();
        JsonParser parser = mapper.jsonProvider().createParser(reader);

        List<SortOptions> sortOptions = JsonpDeserializer.arrayDeserializer(SortOptions._DESERIALIZER).deserialize(parser, mapper);
        assertEquals(1, sortOptions.size());
        assertEquals(SortOptions.Kind.Field, sortOptions.get(0)._kind());
        FieldSort fieldSort = (FieldSort) sortOptions.get(0)._get();
        assertEquals("entityId", fieldSort.field());
        assertEquals(SortOrder.Asc, fieldSort.order());
    }
}
