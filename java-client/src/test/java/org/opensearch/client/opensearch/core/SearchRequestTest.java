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
import org.opensearch.client.json.JsonData;
import org.opensearch.client.opensearch.model.ModelTestCase;

public class SearchRequestTest extends ModelTestCase {

    @Test
    public void ext() {
        SearchRequest request = new SearchRequest.Builder().ext(
            "similarity",
            JsonData.of(Collections.singletonMap("fields", Collections.singletonList("name")))
        ).build();

        assertEquals("{\"ext\":{\"similarity\":{\"fields\":[\"name\"]}}}", toJson(request));
    }

    @Test
    public void toBuilder() {
        SearchRequest origin = new SearchRequest.Builder().index("index").build();
        SearchRequest copied = origin.toBuilder().build();

        assertEquals(copied.index(), origin.index());
    }
}
