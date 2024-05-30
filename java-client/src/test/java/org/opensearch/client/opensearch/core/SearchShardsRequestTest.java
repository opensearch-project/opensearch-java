package org.opensearch.client.opensearch.core;

import org.junit.Assert;
import org.junit.Test;

public class SearchShardsRequestTest extends Assert {

    @Test
    public void toBuilder() {
        SearchShardsRequest origin = new SearchShardsRequest.Builder().index("index").build();
        SearchShardsRequest copied = origin.toBuilder().build();

        assertEquals(copied.index(), origin.index());
    }
}
