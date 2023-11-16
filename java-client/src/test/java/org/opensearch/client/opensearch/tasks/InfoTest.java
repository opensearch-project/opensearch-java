package org.opensearch.client.opensearch.tasks;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.StringReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Assert;
import org.junit.Test;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.jsonb.JsonbJsonpMapper;
import org.opensearch.client.util.MissingRequiredPropertyException;

public class InfoTest extends Assert {

    @Test
    public void deserialize_validInfo_infoDeserializesCorrectly() throws JsonProcessingException {

        Map<String, Object> infoMap = new HashMap<>();

        infoMap.put("action", "test-action");
        infoMap.put("cancelled", true);
        infoMap.put("cancellable", true);
        infoMap.put("description", "test-description");
        infoMap.put("id", 123L);
        infoMap.put("node", "test-node");
        infoMap.put("running_time_in_nanos", 1234567);
        infoMap.put("start_time_in_millis", 12345678);
        infoMap.put("type", "test-type");
        infoMap.put("parent_task_id", "test-parent-id");

        Map<String, List<String>> headers = new HashMap<>();
        headers.put("header-key-1", List.of("header-1", "header-2"));
        headers.put("header-key-2", List.of("header-3", "header-4"));

        infoMap.put("headers", headers);

        final JsonpMapper mapper = new JsonbJsonpMapper();
        final String infoJson = new ObjectMapper().writeValueAsString(infoMap);
        final var parser = mapper.jsonProvider().createParser(new StringReader(infoJson));

        final Info info = Info._DESERIALIZER.deserialize(parser, mapper);

        assertTrue(info.cancelled());
        assertEquals("test-action", info.action());
        assertTrue(info.cancellable());
        assertEquals("test-description", info.description());
        assertEquals(123L, info.id());
        assertEquals("test-node", info.node());
        assertEquals(1234567, info.runningTimeInNanos());
        assertEquals(12345678, info.startTimeInMillis());
        assertEquals("test-type", info.type());
        assertEquals("test-parent-id", info.parentTaskId());

        Map<String, List<String>> infoHeaders = info.headers();
        assertEquals(List.of("header-1", "header-2"), infoHeaders.get("header-key-1"));
        assertEquals(List.of("header-3", "header-4"), infoHeaders.get("header-key-2"));
    }

    @Test
    public void deserialize_infoWithNullableProperties_missingRequiredPropertyExceptionNotThrown() throws JsonProcessingException {

        Map<String, Object> infoMap = new HashMap<>();

        infoMap.put("action", "test-action");
        infoMap.put("cancellable", true);
        infoMap.put("id", 123L);
        infoMap.put("node", "test-node");
        infoMap.put("running_time_in_nanos", 1234567);
        infoMap.put("start_time_in_millis", 12345678);
        infoMap.put("type", "test-type");

        Map<String, List<String>> headers = new HashMap<>();
        headers.put("header-key-1", List.of("header-1", "header-2"));
        headers.put("header-key-2", List.of("header-3", "header-4"));

        infoMap.put("headers", headers);

        final JsonpMapper mapper = new JsonbJsonpMapper();
        final String infoJson = new ObjectMapper().writeValueAsString(infoMap);
        final var parser = mapper.jsonProvider().createParser(new StringReader(infoJson));

        try {
            Info._DESERIALIZER.deserialize(parser, mapper);
        } catch (MissingRequiredPropertyException e) {
            fail("Nullable properties should not be required");
        }
    }
}
