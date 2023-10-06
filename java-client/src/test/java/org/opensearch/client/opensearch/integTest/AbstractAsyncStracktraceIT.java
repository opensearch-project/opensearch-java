package org.opensearch.client.opensearch.integTest;

import org.apache.logging.log4j.core.util.Throwables;
import org.junit.Test;

public abstract class AbstractAsyncStracktraceIT extends OpenSearchJavaClientTestCase {
    @Test
    public void testFailureFromClientPreservesStacktraceOfCaller() throws Exception {
        var thrown = assertThrows(Exception.class, () -> javaClient().indices().get(g -> g.index("nonexisting-index")));

        var stacktraceElements = Throwables.toStringList(thrown);

        stacktraceElements.forEach(System.out::println);

        var someElementContainsCallerMethodName =
                stacktraceElements.stream().anyMatch(it -> it.contains("testFailureFromClientPreservesStacktraceOfCaller"));

        assertTrue(someElementContainsCallerMethodName);
    }
}
