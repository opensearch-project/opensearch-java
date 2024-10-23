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

package org.opensearch.client.opensearch.indices;

import java.io.IOException;
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
 * Client for the indices namespace.
 */
@Generated("org.opensearch.client.codegen.CodeGenerator")
public abstract class OpenSearchIndicesClientBase<Self extends OpenSearchIndicesClientBase<Self>> extends ApiClient<
    OpenSearchTransport,
    Self> {
    public OpenSearchIndicesClientBase(OpenSearchTransport transport, @Nullable TransportOptions transportOptions) {
        super(transport, transportOptions);
    }

    // ----- Endpoint: indices.create

    /**
     * Creates an index with optional settings and mappings.
     */
    public CreateIndexResponse create(CreateIndexRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, CreateIndexRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Creates an index with optional settings and mappings.
     *
     * @param fn a function that initializes a builder to create the {@link CreateIndexRequest}
     */
    public final CreateIndexResponse create(Function<CreateIndexRequest.Builder, ObjectBuilder<CreateIndexRequest>> fn) throws IOException,
        OpenSearchException {
        return create(fn.apply(new CreateIndexRequest.Builder()).build());
    }

    // ----- Endpoint: indices.exists

    /**
     * Returns information about whether a particular index exists.
     */
    public BooleanResponse exists(ExistsRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, ExistsRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Returns information about whether a particular index exists.
     *
     * @param fn a function that initializes a builder to create the {@link ExistsRequest}
     */
    public final BooleanResponse exists(Function<ExistsRequest.Builder, ObjectBuilder<ExistsRequest>> fn) throws IOException,
        OpenSearchException {
        return exists(fn.apply(new ExistsRequest.Builder()).build());
    }

    // ----- Endpoint: indices.get

    /**
     * Returns information about one or more indices.
     */
    public GetIndexResponse get(GetIndexRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, GetIndexRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Returns information about one or more indices.
     *
     * @param fn a function that initializes a builder to create the {@link GetIndexRequest}
     */
    public final GetIndexResponse get(Function<GetIndexRequest.Builder, ObjectBuilder<GetIndexRequest>> fn) throws IOException,
        OpenSearchException {
        return get(fn.apply(new GetIndexRequest.Builder()).build());
    }
}
