/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.opensearch.core.pit;

import org.opensearch.client.opensearch._types.ErrorResponse;
import org.opensearch.client.transport.Endpoint;
import org.opensearch.client.transport.endpoints.SimpleEndpoint;


/**
 * Lists all PITs on the OpenSearch cluster
 * 
 */
public class ListAllPointInTimeRequest {
    public ListAllPointInTimeRequest() {

    }

    /**
     * Singleton instance for {@link ListAllPointInTimeRequest}.
     */
    public static final ListAllPointInTimeRequest _INSTANCE = new ListAllPointInTimeRequest();

    /**
     * Endpoint "{@code list_all_point_in_time}"
     */
    public static final Endpoint<ListAllPointInTimeRequest, ListAllPointInTimeResponse, ErrorResponse> _ENDPOINT = new SimpleEndpoint<>(
            // Request method
            request -> {
                return "GET";
            },

            // Request Path
            request -> {
                return "/_search/point_in_time/_all";
            }, SimpleEndpoint.emptyMap(), SimpleEndpoint.emptyMap(), false, ListAllPointInTimeResponse._DESERIALIZER);
}
