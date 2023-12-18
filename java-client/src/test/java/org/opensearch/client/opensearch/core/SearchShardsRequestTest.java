package org.opensearch.client.opensearch.core;

import org.junit.Test;
import org.opensearch.client.opensearch.model.ModelTestCase;

public class SearchShardsRequestTest extends ModelTestCase {

    @Test
    public void toBuilder() {
        SearchShardsRequest origin = new SearchShardsRequest.Builder().index("index").build();
        SearchShardsRequest copied = origin.toBuilder().build();

        assertEquals(toJson(copied), toJson(origin));
    }
}
