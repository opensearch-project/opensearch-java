/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.opensearch.core;

import org.junit.Test;
import org.opensearch.client.opensearch.model.ModelTestCase;

public class SearchTemplateRequestTest extends ModelTestCase {

    @Test
    public void phaseTook() {
        SearchTemplateRequest request = new SearchTemplateRequest.Builder().phaseTook(true).build();

        assertEquals("{}", toJson(request));
        assertEquals(true, request.phaseTook());
        assertTrue(Boolean.parseBoolean(SearchTemplateRequest._ENDPOINT.queryParameters(request).get("phase_took")));
    }

    @Test
    public void pipeline() {
        SearchTemplateRequest request = new SearchTemplateRequest.Builder().pipeline("my_pipeline").build();

        assertEquals("{}", toJson(request));
        assertEquals("my_pipeline", request.pipeline());
        assertEquals("my_pipeline", SearchTemplateRequest._ENDPOINT.queryParameters(request).get("search_pipeline"));
    }

    @Test
    public void toBuilder() {
        SearchTemplateRequest origin = new SearchTemplateRequest.Builder().index("index").build();
        SearchTemplateRequest copied = origin.toBuilder().build();

        assertEquals(copied.index(), origin.index());
    }
}
