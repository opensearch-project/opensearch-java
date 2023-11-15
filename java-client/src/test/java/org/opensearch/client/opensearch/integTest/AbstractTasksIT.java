package org.opensearch.client.opensearch.integTest;

import java.io.IOException;
import org.junit.Test;
import org.opensearch.client.opensearch.tasks.Status;

public abstract class AbstractTasksIT extends OpenSearchJavaClientTestCase {

    @Test
    public void getTasks_waitForCompletionFalse_jsonDataStatusCanBeDeserialized() throws IOException, InterruptedException {
        String indexName = "test_index_tasks_response";
        javaClient().indices().create(_1 -> _1.index(indexName));
        javaClient().index(b -> b.index(indexName).id("a").document(new IndexData("test")));
        // Ensure the document is indexed
        Thread.sleep(3000);

        final var deleteByQueryResponse = javaClient().deleteByQuery(
            d -> d.index(indexName)
                .query(q -> q.match(m -> m.queryName("match").query(_q -> _q.stringValue("test")).field("title")))
                .waitForCompletion(false)
        );

        Thread.sleep(3000);

        // Create a task to be used to deserialize a task status from as the test subject
        final var tasksResponse = javaClient().tasks().get(t -> t.taskId(deleteByQueryResponse.task()));

        assertTrue(tasksResponse.completed());

        // Deserialize the JsonData to a typed Status response
        assertNotNull(tasksResponse.task().status());
        final Status taskStatus = tasksResponse.task().status().to(Status.class);

        // Ensure the JsonData can be deserialized
        assertEquals(1, taskStatus.total());
        assertEquals(1, taskStatus.deleted());
        assertEquals(0, taskStatus.created());
        assertEquals(0, taskStatus.noops());
        assertEquals(0, taskStatus.failures().size());
    }

    public class IndexData {
        private String title;

        public IndexData(String title) {
            this.title = title;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        @Override
        public String toString() {
            return String.format("IndexData{title='%s'}", title);
        }
    }
}
