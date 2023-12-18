/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.opensearch.core;

import org.junit.Test;
import org.opensearch.client.opensearch.model.ModelTestCase;

public class UpdateByQueryRethrottleRequestTest extends ModelTestCase {
    @Test
    public void toBuilder() {
        UpdateByQueryRethrottleRequest origin = new UpdateByQueryRethrottleRequest.Builder().taskId("taskId").build();
        UpdateByQueryRethrottleRequest copied = origin.toBuilder().build();

        assertEquals(toJson(copied), toJson(origin));
    }
}
