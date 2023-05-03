/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.opensearch.integTest;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.Matchers.anEmptyMap;

import java.io.IOException;
import java.util.Arrays;

import org.opensearch.client.opensearch.nodes.NodesStatsResponse;
import org.opensearch.client.opensearch.tasks.ListRequest;
import org.opensearch.client.opensearch.tasks.ListResponse;

public abstract class AbstractNodesIT extends OpenSearchJavaClientTestCase {
    public void testNodesStats() throws IOException {
        final NodesStatsResponse response = javaClient().nodes().stats();
        assertThat(response.clusterName(), not(nullValue()));
        assertThat(response.nodes(), not(anEmptyMap()));
    }

    public void testNodesList() throws IOException {
        ListRequest listRequest = new ListRequest.Builder().actions(Arrays.asList("*reindex")).build();
        ListResponse listResponse = javaClient().tasks().list();
        assertThat(listResponse.nodes(), not(anEmptyMap()));
    }
}
