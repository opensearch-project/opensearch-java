/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.opensearch.integTest.aws;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.apache.logging.log4j.core.util.Throwables;
import org.junit.Test;
import org.opensearch.client.opensearch.OpenSearchClient;

// It would be nice to extend AbstractAsyncStracktraceIT.
public class AwsSdk2AsyncStacktraceIT extends AwsSdk2TransportTestCase {
    @Test
    public void testFailureFromClientPreservesStacktraceOfCaller() throws Exception {
        final OpenSearchClient client = getClient(false, null, null);
        var thrown = assertThrows(Exception.class, () -> client.indices().get(g -> g.index("nonexisting-index")));

        var stacktraceElements = Throwables.toStringList(thrown);
        var someElementContainsCallerMethodName = stacktraceElements.stream()
            .anyMatch(it -> it.contains("testFailureFromClientPreservesStacktraceOfCaller"));

        assertTrue(someElementContainsCallerMethodName);
    }
}
