package org.opensearch.client.opensearch.core;

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
import org.opensearch.client.opensearch.tasks.GetTasksResponse;
import org.opensearch.client.opensearch.tasks.Status;

public class GetTasksResponseTest extends Assert {

    @Test
    public void test() throws JsonProcessingException {

        final JsonpMapper mapper = new JsonbJsonpMapper();
        final String taskResponse = new ObjectMapper().writeValueAsString(createJsonMap());
        final var parser = mapper.jsonProvider().createParser(new StringReader(taskResponse));

        final GetTasksResponse tasksResponse = GetTasksResponse._DESERIALIZER.deserialize(parser, mapper);

        // Deserialize the JsonData to a typed Status response
        final Status response = tasksResponse.response().to(Status.class);
        final Status taskStatus = tasksResponse.task().status().to(Status.class);

        assertTrue(tasksResponse.completed());

        // Assertions for "task" field
        assertEquals("test-node-id", tasksResponse.task().node());
        assertEquals(298365, tasksResponse.task().id());
        assertEquals("transport", tasksResponse.task().type());
        assertEquals("indices:data/write/delete/byquery", tasksResponse.task().action());
        assertEquals(1, taskStatus.total());
        assertEquals(0, taskStatus.updated());
        assertEquals(0, taskStatus.created());
        assertEquals(0, taskStatus.deleted());
        assertEquals(1, taskStatus.batches());
        assertEquals(1, taskStatus.noops());
        assertEquals(1, taskStatus.versionConflicts());
        assertEquals(0, taskStatus.retries().bulk());
        assertEquals(0, taskStatus.retries().search());
        assertEquals(0, taskStatus.throttledMillis());
        assertEquals(-1f, taskStatus.requestsPerSecond(), 0.01);
        assertEquals(0, taskStatus.throttledUntilMillis());
        assertEquals("test-description", tasksResponse.task().description());
        assertEquals(1698853787531L, tasksResponse.task().startTimeInMillis());
        assertEquals(13688917, tasksResponse.task().runningTimeInNanos());
        assertTrue(tasksResponse.task().cancellable());
        assertEquals(new HashMap<>(), tasksResponse.task().headers());

        // Assertions for "response" field
        assertEquals(13L, (long) response.took());
        assertFalse(response.timedOut());
        assertEquals(1, response.total());
        assertEquals(0, response.updated());
        assertEquals(0, response.created());
        assertEquals(0, response.deleted());
        assertEquals(1, response.batches());
        assertEquals(0, response.noops());
        assertEquals(1, response.versionConflicts());
        assertEquals(0, response.retries().bulk());
        assertEquals(0, response.retries().search());
        assertEquals("0s", response.throttled()._toJsonString());
        assertEquals(0, response.throttledMillis());
        assertEquals(-1f, response.requestsPerSecond(), 0.01);
        assertEquals("0s", response.throttledUntil()._toJsonString());
        assertEquals(0, response.throttledUntilMillis());

        // Assertions for "failures" field within "response"
        final var failures = response.failures();
        assertNotNull(failures);
        assertEquals(1, failures.size());

        final var failure = failures.get(0);
        assertEquals("test-index", failure.index());
        assertEquals("test-failure-id", failure.id());

        // Assertions for "cause" field within "failures"
        final var cause = failure.cause();
        assertNotNull(cause);
        assertEquals("version_conflict_engine_exception", cause.type());
        assertEquals("version conflict", cause.reason());
        assertEquals(409, (int) failure.status());
        assertEquals("_doc", failure.type());
    }

    private static Map<String, Object> createJsonMap() {
        Map<String, Object> resultMap = new HashMap<>();

        resultMap.put("completed", true);

        Map<String, Object> taskMap = new HashMap<>();
        taskMap.put("node", "test-node-id");
        taskMap.put("id", 298365);
        taskMap.put("type", "transport");
        taskMap.put("action", "indices:data/write/delete/byquery");

        Map<String, Object> statusMap = new HashMap<>();
        statusMap.put("total", 1);
        statusMap.put("updated", 0);
        statusMap.put("created", 0);
        statusMap.put("deleted", 0);
        statusMap.put("batches", 1);
        statusMap.put("noops", 1);
        statusMap.put("version_conflicts", 1);

        Map<String, Object> retriesMap = new HashMap<>();
        retriesMap.put("bulk", 0);
        retriesMap.put("search", 0);
        statusMap.put("retries", retriesMap);

        statusMap.put("throttled_millis", 0);
        statusMap.put("requests_per_second", -1);
        statusMap.put("throttled_until_millis", 0);

        taskMap.put("status", statusMap);

        taskMap.put("description", "test-description");
        taskMap.put("start_time_in_millis", 1698853787531L);
        taskMap.put("running_time_in_nanos", 13688917);
        taskMap.put("cancellable", true);
        taskMap.put("headers", new HashMap<>());

        resultMap.put("task", taskMap);
        resultMap.put("response", getResponseMap());

        return resultMap;
    }

    private static Map<String, Object> getResponseMap() {
        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("took", 13);
        responseMap.put("timed_out", false);
        responseMap.put("total", 1);
        responseMap.put("updated", 0);
        responseMap.put("created", 0);
        responseMap.put("deleted", 0);
        responseMap.put("batches", 1);
        responseMap.put("noops", 0);
        responseMap.put("version_conflicts", 1);

        Map<String, Object> responseRetriesMap = new HashMap<>();
        responseRetriesMap.put("bulk", 0);
        responseRetriesMap.put("search", 0);
        responseMap.put("retries", responseRetriesMap);

        responseMap.put("throttled", "0s");
        responseMap.put("throttled_millis", 0);
        responseMap.put("requests_per_second", -1);
        responseMap.put("throttled_until", "0s");
        responseMap.put("throttled_until_millis", 0);

        Map<String, Object> failuresMap = new HashMap<>();
        failuresMap.put("index", "test-index");
        failuresMap.put("id", "test-failure-id");

        Map<String, Object> causeMap = new HashMap<>();
        causeMap.put("type", "version_conflict_engine_exception");
        causeMap.put("reason", "version conflict");
        causeMap.put("index", "test-index");

        failuresMap.put("cause", causeMap);
        failuresMap.put("status", 409);
        failuresMap.put("type", "_doc");

        responseMap.put("failures", List.of(failuresMap));

        return responseMap;
    }
}
