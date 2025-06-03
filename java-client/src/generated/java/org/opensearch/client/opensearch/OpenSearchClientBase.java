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

package org.opensearch.client.opensearch;

import java.io.IOException;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nullable;
import org.opensearch.client.ApiClient;
import org.opensearch.client.opensearch._types.OpenSearchException;
import org.opensearch.client.opensearch.core.SearchShardsRequest;
import org.opensearch.client.opensearch.core.SearchShardsResponse;
import org.opensearch.client.opensearch.ml.OpenSearchMlClient;
import org.opensearch.client.opensearch.search_pipeline.OpenSearchSearchPipelineClient;
import org.opensearch.client.transport.OpenSearchTransport;
import org.opensearch.client.transport.TransportOptions;
import org.opensearch.client.util.ObjectBuilder;

/**
 * Client for the namespace.
 */
@Generated("org.opensearch.client.codegen.CodeGenerator")
public abstract class OpenSearchClientBase<Self extends OpenSearchClientBase<Self>> extends ApiClient<OpenSearchTransport, Self> {
    public OpenSearchClientBase(OpenSearchTransport transport, @Nullable TransportOptions transportOptions) {
        super(transport, transportOptions);
    }

    // ----- Child clients

    public OpenSearchMlClient ml() {
        return new OpenSearchMlClient(this.transport, this.transportOptions);
    }

    public OpenSearchSearchPipelineClient searchPipeline() {
        return new OpenSearchSearchPipelineClient(this.transport, this.transportOptions);
    }

    // ----- Endpoint: search_shards

    /**
     * Returns information about the indexes and shards that a search request would be executed against.
     */
    public SearchShardsResponse searchShards(SearchShardsRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, SearchShardsRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Returns information about the indexes and shards that a search request would be executed against.
     *
     * @param fn a function that initializes a builder to create the {@link SearchShardsRequest}
     */
    public final SearchShardsResponse searchShards(Function<SearchShardsRequest.Builder, ObjectBuilder<SearchShardsRequest>> fn)
        throws IOException, OpenSearchException {
        return searchShards(fn.apply(new SearchShardsRequest.Builder()).build());
    }

    /**
     * Returns information about the indexes and shards that a search request would be executed against.
     */
    public final SearchShardsResponse searchShards() throws IOException, OpenSearchException {
        return searchShards(new SearchShardsRequest.Builder().build());
    }
}
