package org.opensearch.client.opensearch.json;

import jakarta.json.stream.JsonParser;
import org.junit.Test;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.opensearch._types.FieldValue;
import org.opensearch.client.opensearch.model.ModelTestCase;

import java.io.StringReader;
import java.util.List;


public class JsonpDeserializerBaseTest extends ModelTestCase {

    @Test
    public void testNullArrayItem() {

        String json = "[\"a\", null, \"c\"]";

        // Types that don't accept null events should end up as null values in the list
        {
            JsonpDeserializer<String> stringDeser = JsonpDeserializer.stringDeserializer();
            assertFalse(stringDeser.accepts(JsonParser.Event.VALUE_NULL));

            JsonParser parser = mapper.jsonProvider().createParser(new StringReader(json));

            List<String> stringList = JsonpDeserializer.arrayDeserializer(stringDeser).deserialize(parser, mapper);
            assertEquals("a", stringList.get(0));
            assertNull(stringList.get(1));
            assertEquals("c", stringList.get(2));
        }

        // Types that do accept null events should end up as their null representation
        {
            assertTrue(FieldValue._DESERIALIZER.accepts(JsonParser.Event.VALUE_NULL));

            JsonParser parser = mapper.jsonProvider().createParser(new StringReader(json));
            List<FieldValue> valueList = JsonpDeserializer.arrayDeserializer(FieldValue._DESERIALIZER).deserialize(parser, mapper);

            assertEquals("a", valueList.get(0)._get());
            assertTrue(valueList.get(1).isNull());
            assertEquals("c", valueList.get(2)._get());
        }
    }
}
