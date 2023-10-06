/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.opensearch.integTest;

import org.apache.logging.log4j.core.util.Throwables;
import org.junit.Test;

public abstract class AbstractAsyncStracktraceIT extends OpenSearchJavaClientTestCase {
    @Test
    public void testFailureFromClientPreservesStacktraceOfCaller() throws Exception {
        var thrown = assertThrows(Exception.class, () -> javaClient().indices().get(g -> g.index("nonexisting-index")));

        var stacktraceElements = Throwables.toStringList(thrown);
        var someElementContainsCallerMethodName =
                stacktraceElements.stream().anyMatch(it -> it.contains("testFailureFromClientPreservesStacktraceOfCaller"));

        assertTrue(someElementContainsCallerMethodName);
    }
}
