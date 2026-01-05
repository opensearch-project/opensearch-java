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

package org.opensearch.client.opensearch.ubi;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nullable;
import org.opensearch.client.ApiClient;
import org.opensearch.client.opensearch._types.OpenSearchException;
import org.opensearch.client.transport.OpenSearchTransport;
import org.opensearch.client.transport.TransportOptions;
import org.opensearch.client.transport.endpoints.BooleanResponse;
import org.opensearch.client.util.ObjectBuilder;

/**
 * Client for the ubi namespace.
 */
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class OpenSearchUbiAsyncClient extends ApiClient<OpenSearchTransport, OpenSearchUbiAsyncClient> {
    public OpenSearchUbiAsyncClient(OpenSearchTransport transport) {
        super(transport, null);
    }

    public OpenSearchUbiAsyncClient(OpenSearchTransport transport, @Nullable TransportOptions transportOptions) {
        super(transport, transportOptions);
    }

    @Override
    public OpenSearchUbiAsyncClient withTransportOptions(@Nullable TransportOptions transportOptions) {
        return new OpenSearchUbiAsyncClient(this.transport, transportOptions);
    }

    // ----- Endpoint: ubi.initialize

    /**
     * Initializes the UBI indexes.
     */
    public CompletableFuture<BooleanResponse> initialize(InitializeRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, InitializeRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Initializes the UBI indexes.
     *
     * @param fn a function that initializes a builder to create the {@link InitializeRequest}
     */
    public final CompletableFuture<BooleanResponse> initialize(Function<InitializeRequest.Builder, ObjectBuilder<InitializeRequest>> fn)
        throws IOException, OpenSearchException {
        return initialize(fn.apply(new InitializeRequest.Builder()).build());
    }

    /**
     * Initializes the UBI indexes.
     */
    public final CompletableFuture<BooleanResponse> initialize() throws IOException, OpenSearchException {
        return initialize(new InitializeRequest.Builder().build());
    }
}
