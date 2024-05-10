package org.opensearch.client.opensearch._types;

import static org.junit.Assert.assertEquals;

import jakarta.json.stream.JsonParser;
import java.io.StringReader;
import java.util.List;
import org.junit.Test;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.jackson.JacksonJsonpMapper;

public class SortOptionsTest {

    @Test
    public void testSortOptions() {
        String jsonString = "[{\"entityId\":{\"order\":\"asc\"}}]";
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
