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

package org.opensearch.client.opensearch.ingestion;

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
 * Client for the ingestion namespace.
 */
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class OpenSearchIngestionAsyncClient extends ApiClient<OpenSearchTransport, OpenSearchIngestionAsyncClient> {
    public OpenSearchIngestionAsyncClient(OpenSearchTransport transport) {
        super(transport, null);
    }

    public OpenSearchIngestionAsyncClient(OpenSearchTransport transport, @Nullable TransportOptions transportOptions) {
        super(transport, transportOptions);
    }

    @Override
    public OpenSearchIngestionAsyncClient withTransportOptions(@Nullable TransportOptions transportOptions) {
        return new OpenSearchIngestionAsyncClient(this.transport, transportOptions);
    }

    // ----- Endpoint: ingestion.get_state

    /**
     * Use this API to retrieve the ingestion state for a given index.
     */
    public CompletableFuture<GetStateResponse> getState(GetStateRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, GetStateRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Use this API to retrieve the ingestion state for a given index.
     *
     * @param fn a function that initializes a builder to create the {@link GetStateRequest}
     */
    public final CompletableFuture<GetStateResponse> getState(Function<GetStateRequest.Builder, ObjectBuilder<GetStateRequest>> fn)
        throws IOException, OpenSearchException {
        return getState(fn.apply(new GetStateRequest.Builder()).build());
    }

    // ----- Endpoint: ingestion.pause

    /**
     * Use this API to pause ingestion for a given index.
     */
    public CompletableFuture<PauseResponse> pause(PauseRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, PauseRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Use this API to pause ingestion for a given index.
     *
     * @param fn a function that initializes a builder to create the {@link PauseRequest}
     */
    public final CompletableFuture<PauseResponse> pause(Function<PauseRequest.Builder, ObjectBuilder<PauseRequest>> fn) throws IOException,
        OpenSearchException {
        return pause(fn.apply(new PauseRequest.Builder()).build());
    }

    // ----- Endpoint: ingestion.resume

    /**
     * Use this API to resume ingestion for the given index.
     */
    public CompletableFuture<ResumeResponse> resume(ResumeRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, ResumeRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Use this API to resume ingestion for the given index.
     *
     * @param fn a function that initializes a builder to create the {@link ResumeRequest}
     */
    public final CompletableFuture<ResumeResponse> resume(Function<ResumeRequest.Builder, ObjectBuilder<ResumeRequest>> fn)
        throws IOException, OpenSearchException {
        return resume(fn.apply(new ResumeRequest.Builder()).build());
    }
}
