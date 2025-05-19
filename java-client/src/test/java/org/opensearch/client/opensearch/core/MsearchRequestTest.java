/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.opensearch.core;

import java.util.Collections;
import org.junit.Test;
import org.opensearch.client.opensearch._types.Time;
import org.opensearch.client.opensearch.model.ModelTestCase;

public class MsearchRequestTest extends ModelTestCase {

    @Test
    public void toBuilder() {
        MsearchRequest origin = new MsearchRequest.Builder().index("index").searches(Collections.emptyList()).build();
        MsearchRequest copied = origin.toBuilder().build();

        assertEquals(copied.index(), origin.index());
    }

    @Test
    public void cancelAfterTimeInterval() {
        Time cancelAfterTimeInterval = Time.of(ti -> ti.time("1000ms"));
        MsearchRequest request = new MsearchRequest.Builder().index("index")
            .searches(Collections.emptyList())
            .cancelAfterTimeInterval(cancelAfterTimeInterval)
            .build();

        assertEquals("[]", toJson(request));
        assertEquals(cancelAfterTimeInterval, request.cancelAfterTimeInterval());
        assertEquals("1000ms", MsearchRequest._ENDPOINT.queryParameters(request).get("cancel_after_time_interval"));
    }
}
