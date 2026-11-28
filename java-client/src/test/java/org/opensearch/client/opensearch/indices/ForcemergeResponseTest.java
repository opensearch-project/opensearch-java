/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.opensearch.indices;

import org.junit.Test;
import org.opensearch.client.opensearch.model.ModelTestCase;

public class ForcemergeResponseTest extends ModelTestCase {

    @Test
    public void shouldDeserializeAsyncResponse() {
        ForcemergeResponse response = fromJson("{\"task\":\"node:123\"}", ForcemergeResponse.class);

        assertEquals("node:123", response.task());
        assertNull(response.shards());
    }

    @Test
    public void shouldDeserializeSynchronousResponse() {
        ForcemergeResponse response = fromJson("{\"_shards\":{\"total\":10,\"successful\":5,\"failed\":0}}", ForcemergeResponse.class);

        assertNull(response.task());
        assertNotNull(response.shards());
        assertEquals(10, response.shards().total());
        assertEquals(5, response.shards().successful());
        assertEquals(0, response.shards().failed());
    }
}
