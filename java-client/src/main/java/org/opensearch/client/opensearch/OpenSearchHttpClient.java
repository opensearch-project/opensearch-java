/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.opensearch;

import java.io.IOException;
import java.util.function.Function;

import javax.annotation.Nullable;

import org.opensearch.client.ApiClient;
import org.opensearch.client.Response;
import org.opensearch.client.opensearch._types.ErrorResponse;
import org.opensearch.client.opensearch._types.OpenSearchException;
import org.opensearch.client.opensearch.request.GetHttpRequest;
import org.opensearch.client.transport.Endpoint;
import org.opensearch.client.transport.JsonEndpoint;
import org.opensearch.client.transport.OpenSearchTransport;
import org.opensearch.client.transport.TransportOptions;
import org.opensearch.client.util.ObjectBuilder;

public class OpenSearchHttpClient extends ApiClient<OpenSearchTransport, OpenSearchHttpClient>{

    public OpenSearchHttpClient(OpenSearchTransport transport) {
        super(transport, null);
    }

    public OpenSearchHttpClient(OpenSearchTransport transport, @Nullable TransportOptions transportOptions) {
        super(transport, transportOptions);
    }

    // ----- Endpoint: get

    /**
     * Makes a GET Request.
     * 
     *
     */

    public Response get(GetHttpRequest request)
            throws IOException, OpenSearchException {
        @SuppressWarnings("unchecked")
        Endpoint<GetHttpRequest, Response, ErrorResponse> endpoint = (Endpoint<GetHttpRequest, Response, ErrorResponse>) GetHttpRequest._ENDPOINT;

        return this.transport.performRequest(request, endpoint, this.transportOptions);
    }

    /**
     * Makes a GET Request.
     * 
     * @param fn
     *           a function that initializes a builder to create the
     *           {@link GetHttpRequest}
     *
     */

    public final Response get(Function<GetHttpRequest.Builder, ObjectBuilder<GetHttpRequest>> fn) throws IOException, OpenSearchException {
        return get(fn.apply(new GetHttpRequest.Builder()).build());
    }

    @Override
    public OpenSearchHttpClient withTransportOptions(@Nullable TransportOptions transportOptions) {
        return new OpenSearchHttpClient(this.transport, transportOptions);
    }
    
}
