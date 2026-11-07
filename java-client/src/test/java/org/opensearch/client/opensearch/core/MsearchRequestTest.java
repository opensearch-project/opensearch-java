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
import org.opensearch.client.opensearch._types.query_dsl.Query;
import org.opensearch.client.opensearch.core.msearch.MultisearchBody;
import org.opensearch.client.opensearch.core.msearch.RequestItem;
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

    @Test
    public void searchPipeline() {
        RequestItem item = new RequestItem.Builder().header(h -> h.index("index"))
            .body(b -> b.query(Query.of(q -> q.matchAll(m -> m))).searchPipeline("my_pipeline"))
            .build();
        MsearchRequest request = new MsearchRequest.Builder().searches(item).build();

        assertEquals(
            "[{\"header\":{\"index\":[\"index\"]},\"body\":{\"query\":{\"match_all\":{}},\"search_pipeline\":\"my_pipeline\"}}]",
            toJson(request)
        );
        assertEquals("my_pipeline", request.searches().get(0).body().searchPipeline());
    }

    @Test
    public void searchPipelineDeserialization() {
        MultisearchBody body = fromJson("{\"search_pipeline\":\"my_pipeline\"}", MultisearchBody._DESERIALIZER);

        assertEquals("my_pipeline", body.searchPipeline());
    }
}
