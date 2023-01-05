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

import org.opensearch.client.opensearch.nodes.NodesStatsResponse;

public class NodesIT extends OpenSearchJavaClientTestCase {
    public void testNodesStats() throws IOException {
        final NodesStatsResponse response = javaClient().nodes().stats();
        assertThat(response.clusterName(), not(nullValue()));
        assertThat(response.nodes(), not(anEmptyMap()));
    }
} 