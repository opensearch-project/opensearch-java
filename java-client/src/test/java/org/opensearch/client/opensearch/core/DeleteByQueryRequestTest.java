/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.opensearch.core;

import java.util.Map;
import org.junit.Assert;
import org.junit.Test;
import org.opensearch.client.opensearch._types.FieldValue;
import org.opensearch.client.opensearch._types.SlicesCalculation;
import org.opensearch.client.opensearch._types.query_dsl.Query;
import org.opensearch.client.opensearch._types.query_dsl.TermQuery;

public class DeleteByQueryRequestTest extends Assert {
    @Test
    public void testEndpointSlicesAuto() {
        DeleteByQueryRequest deleteByQueryRequest = DeleteByQueryRequest.of(
            b -> b.index("test-index").slices(s -> s.calculation(SlicesCalculation.Auto))
        );
        Map<String, String> queryParameters = DeleteByQueryRequest._ENDPOINT.queryParameters(deleteByQueryRequest);
        assertTrue("Must have a slices query parameter", queryParameters.containsKey("slices"));
        assertEquals("auto", queryParameters.get("slices"));
    }

    @Test
    public void DeleteByQueryRequest() {
        DeleteByQueryRequest deleteByQueryRequest = DeleteByQueryRequest.of(b -> b.index("test-index").slices(s -> s.count(6)));
        Map<String, String> queryParameters = DeleteByQueryRequest._ENDPOINT.queryParameters(deleteByQueryRequest);
        assertTrue("Must have a slices query parameter", queryParameters.containsKey("slices"));
        assertEquals("6", queryParameters.get("slices"));
    }

    @Test
    public void toBuilder() {
        DeleteByQueryRequest origin = new DeleteByQueryRequest.Builder().index("index").query(buildDummyQuery()).build();
        DeleteByQueryRequest copied = origin.toBuilder().build();

        assertEquals(copied.index(), origin.index());
    }

    private Query buildDummyQuery() {
        return Query.of(
            query -> query.bool(
                builder -> builder.filter(filter -> filter.term(TermQuery.of(term -> term.field("size").value(FieldValue.of(1)))))
            )
        );
    }
}
