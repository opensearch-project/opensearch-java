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

public class RankEvalRequestTest extends Assert {

    @Test
    public void toBuilder() {
        RankEvalRequest origin = new RankEvalRequest.Builder().index("index").requests(Collections.emptyList()).build();
        RankEvalRequest copied = origin.toBuilder().build();

        assertEquals(copied.index(), origin.index());
    }
}
