/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.opensearch.core;

import java.util.Collections;
import org.junit.Assert;
import org.junit.Test;

public class ClearScrollRequestTest extends Assert {

    @Test
    public void toBuilder() {
        ClearScrollRequest origin = new ClearScrollRequest.Builder().scrollId(Collections.singletonList("1")).build();
        ClearScrollRequest copied = origin.toBuilder().build();

        assertEquals(copied.scrollId(), origin.scrollId());
    }
}
