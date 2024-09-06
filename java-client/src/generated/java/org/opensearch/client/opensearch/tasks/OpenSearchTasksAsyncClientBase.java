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

package org.opensearch.client.opensearch.tasks;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nullable;
import org.opensearch.client.ApiClient;
import org.opensearch.client.opensearch._types.ErrorResponse;
import org.opensearch.client.opensearch._types.OpenSearchException;
import org.opensearch.client.transport.JsonEndpoint;
import org.opensearch.client.transport.OpenSearchTransport;
import org.opensearch.client.transport.TransportOptions;
import org.opensearch.client.util.ObjectBuilder;

/**
 * Client for the tasks namespace.
 */
@Generated("org.opensearch.client.codegen.CodeGenerator")
public abstract class OpenSearchTasksAsyncClientBase<Self extends OpenSearchTasksAsyncClientBase<Self>> extends ApiClient<
    OpenSearchTransport,
    Self> {
    public OpenSearchTasksAsyncClientBase(OpenSearchTransport transport, @Nullable TransportOptions transportOptions) {
        super(transport, transportOptions);
    }

    // ----- Endpoint: tasks.list

    /**
     * Returns a list of tasks.
     */
    public CompletableFuture<ListResponse> list(ListRequest request) throws IOException, OpenSearchException {
        @SuppressWarnings("unchecked")
        JsonEndpoint<ListRequest, ListResponse, ErrorResponse> endpoint = (JsonEndpoint<
            ListRequest,
            ListResponse,
            ErrorResponse>) ListRequest._ENDPOINT;

        return this.transport.performRequestAsync(request, endpoint, this.transportOptions);
    }

    /**
     * Returns a list of tasks.
     *
     * @param fn a function that initializes a builder to create the {@link ListRequest}
     */
    public final CompletableFuture<ListResponse> list(Function<ListRequest.Builder, ObjectBuilder<ListRequest>> fn) throws IOException,
        OpenSearchException {
        return list(fn.apply(new ListRequest.Builder()).build());
    }

    /**
     * Returns a list of tasks.
     */
    public CompletableFuture<ListResponse> list() throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(new ListRequest.Builder().build(), ListRequest._ENDPOINT, this.transportOptions);
    }
}
