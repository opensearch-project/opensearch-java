package org.opensearch.client.opensearch.core;

import org.junit.Test;
import org.opensearch.client.opensearch._types.FieldValue;
import org.opensearch.client.opensearch.model.ModelTestCase;

public class SearchRequestTest extends ModelTestCase {
    @Test
    public void afterSearch() {
        SearchRequest request = new SearchRequest.Builder().searchAfter(FieldValue.of(1), FieldValue.of("string")).build();

        assertEquals("{\"search_after\":[1,\"string\"]}", toJson(request));
    }

    @Test
    public void toBuilder() {
        SearchRequest origin = new SearchRequest.Builder().index("index").build();
        SearchRequest copied = origin.toBuilder().build();

        assertEquals(copied.index(), origin.index());
    }
}
