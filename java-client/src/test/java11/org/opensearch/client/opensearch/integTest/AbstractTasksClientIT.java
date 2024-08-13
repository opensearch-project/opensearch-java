/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.opensearch.integTest;

import java.io.IOException;
import org.junit.Test;
import org.opensearch.client.opensearch.tasks.GroupBy;
import org.opensearch.client.opensearch.tasks.ListResponse;

public abstract class AbstractTasksClientIT extends OpenSearchJavaClientTestCase {
    @Test
    public void list_groupedByNodes() throws IOException {
        final ListResponse response = javaClient().tasks().list(l -> l.groupBy(GroupBy.Nodes));
        assertFalse(response.nodes().isEmpty());
        assertTrue(response.tasks().isEmpty());
    }

    @Test
    public void list_groupedByParents() throws IOException {
        final ListResponse response = javaClient().tasks().list(l -> l.groupBy(GroupBy.Parents));
        assertTrue(response.nodes().isEmpty());
        assertFalse(response.tasks().isEmpty());
    }

    @Test
    public void list_groupedByNone() throws IOException {
        final ListResponse response = javaClient().tasks().list(l -> l.groupBy(GroupBy.None));
        assertTrue(response.nodes().isEmpty());
        assertFalse(response.tasks().isEmpty());
    }
}
