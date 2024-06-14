/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.opensearch.core;

import org.junit.Assert;
import org.junit.Test;

public class ExistsRequestTest extends Assert {

    @Test
    public void toBuilder() {
        ExistsRequest origin = new ExistsRequest.Builder().index("index").id("id").build();
        ExistsRequest copied = origin.toBuilder().build();

        assertEquals(copied.index(), origin.index());
    }
}
