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

public class MtermvectorsRequestTest extends Assert {

    @Test
    public void toBuilder() {
        MtermvectorsRequest origin = new MtermvectorsRequest.Builder().index("index").build();
        MtermvectorsRequest copied = origin.toBuilder().build();

        assertEquals(copied.index(), origin.index());
    }
}
