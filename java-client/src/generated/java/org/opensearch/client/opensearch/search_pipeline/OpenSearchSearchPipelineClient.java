/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

/*
 * Licensed to Elasticsearch B.V. under one or more contributor
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
 * ownership. Elasticsearch B.V. licenses this file to you under
 * the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

/*
 * Modifications Copyright OpenSearch Contributors. See
 * GitHub history for details.
 */

//----------------------------------------------------
// THIS CODE IS GENERATED. MANUAL EDITS WILL BE LOST.
//----------------------------------------------------

package org.opensearch.client.opensearch.search_pipeline;

import java.io.IOException;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nullable;
import org.opensearch.client.ApiClient;
import org.opensearch.client.opensearch._types.OpenSearchException;
import org.opensearch.client.transport.OpenSearchTransport;
import org.opensearch.client.transport.TransportOptions;
import org.opensearch.client.util.ObjectBuilder;

/**
 * Client for the search_pipeline namespace.
 */
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class OpenSearchSearchPipelineClient extends ApiClient<OpenSearchTransport, OpenSearchSearchPipelineClient> {
    public OpenSearchSearchPipelineClient(OpenSearchTransport transport) {
        super(transport, null);
    }

    public OpenSearchSearchPipelineClient(OpenSearchTransport transport, @Nullable TransportOptions transportOptions) {
        super(transport, transportOptions);
    }

    @Override
    public OpenSearchSearchPipelineClient withTransportOptions(@Nullable TransportOptions transportOptions) {
        return new OpenSearchSearchPipelineClient(this.transport, transportOptions);
    }

    // ----- Endpoint: search_pipeline.delete

    /**
     * Deletes the specified search pipeline.
     */
    public DeleteSearchPipelineResponse delete(DeleteSearchPipelineRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, DeleteSearchPipelineRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Deletes the specified search pipeline.
     *
     * @param fn a function that initializes a builder to create the {@link DeleteSearchPipelineRequest}
     */
    public final DeleteSearchPipelineResponse delete(
        Function<DeleteSearchPipelineRequest.Builder, ObjectBuilder<DeleteSearchPipelineRequest>> fn
    ) throws IOException, OpenSearchException {
        return delete(fn.apply(new DeleteSearchPipelineRequest.Builder()).build());
    }

    // ----- Endpoint: search_pipeline.get

    /**
     * Retrieves information about a specified search pipeline.
     */
    public GetSearchPipelineResponse get(GetSearchPipelineRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, GetSearchPipelineRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Retrieves information about a specified search pipeline.
     *
     * @param fn a function that initializes a builder to create the {@link GetSearchPipelineRequest}
     */
    public final GetSearchPipelineResponse get(Function<GetSearchPipelineRequest.Builder, ObjectBuilder<GetSearchPipelineRequest>> fn)
        throws IOException, OpenSearchException {
        return get(fn.apply(new GetSearchPipelineRequest.Builder()).build());
    }

    /**
     * Retrieves information about a specified search pipeline.
     */
    public final GetSearchPipelineResponse get() throws IOException, OpenSearchException {
        return get(new GetSearchPipelineRequest.Builder().build());
    }

    // ----- Endpoint: search_pipeline.put

    /**
     * Creates or replaces the specified search pipeline.
     */
    public PutSearchPipelineResponse put(PutSearchPipelineRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, PutSearchPipelineRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Creates or replaces the specified search pipeline.
     *
     * @param fn a function that initializes a builder to create the {@link PutSearchPipelineRequest}
     */
    public final PutSearchPipelineResponse put(Function<PutSearchPipelineRequest.Builder, ObjectBuilder<PutSearchPipelineRequest>> fn)
        throws IOException, OpenSearchException {
        return put(fn.apply(new PutSearchPipelineRequest.Builder()).build());
    }
}
