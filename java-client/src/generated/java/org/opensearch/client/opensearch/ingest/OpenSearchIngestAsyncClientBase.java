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

package org.opensearch.client.opensearch.ingest;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nullable;
import org.opensearch.client.ApiClient;
import org.opensearch.client.opensearch._types.OpenSearchException;
import org.opensearch.client.transport.OpenSearchTransport;
import org.opensearch.client.transport.TransportOptions;
import org.opensearch.client.util.ObjectBuilder;

/**
 * Client for the ingest namespace.
 */
@Generated("org.opensearch.client.codegen.CodeGenerator")
public abstract class OpenSearchIngestAsyncClientBase<Self extends OpenSearchIngestAsyncClientBase<Self>> extends ApiClient<
    OpenSearchTransport,
    Self> {
    public OpenSearchIngestAsyncClientBase(OpenSearchTransport transport, @Nullable TransportOptions transportOptions) {
        super(transport, transportOptions);
    }

    // ----- Endpoint: ingest.delete_pipeline

    /**
     * Deletes a pipeline.
     */
    public CompletableFuture<DeletePipelineResponse> deletePipeline(DeletePipelineRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, DeletePipelineRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Deletes a pipeline.
     *
     * @param fn a function that initializes a builder to create the {@link DeletePipelineRequest}
     */
    public final CompletableFuture<DeletePipelineResponse> deletePipeline(
        Function<DeletePipelineRequest.Builder, ObjectBuilder<DeletePipelineRequest>> fn
    ) throws IOException, OpenSearchException {
        return deletePipeline(fn.apply(new DeletePipelineRequest.Builder()).build());
    }

    // ----- Endpoint: ingest.get_pipeline

    /**
     * Returns a pipeline.
     */
    public CompletableFuture<GetPipelineResponse> getPipeline(GetPipelineRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, GetPipelineRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Returns a pipeline.
     *
     * @param fn a function that initializes a builder to create the {@link GetPipelineRequest}
     */
    public final CompletableFuture<GetPipelineResponse> getPipeline(
        Function<GetPipelineRequest.Builder, ObjectBuilder<GetPipelineRequest>> fn
    ) throws IOException, OpenSearchException {
        return getPipeline(fn.apply(new GetPipelineRequest.Builder()).build());
    }

    /**
     * Returns a pipeline.
     */
    public final CompletableFuture<GetPipelineResponse> getPipeline() throws IOException, OpenSearchException {
        return getPipeline(new GetPipelineRequest.Builder().build());
    }
}
