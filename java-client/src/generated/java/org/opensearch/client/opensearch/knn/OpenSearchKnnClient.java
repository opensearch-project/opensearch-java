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

package org.opensearch.client.opensearch.knn;

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
 * Client for the knn namespace.
 */
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class OpenSearchKnnClient extends ApiClient<OpenSearchTransport, OpenSearchKnnClient> {
    public OpenSearchKnnClient(OpenSearchTransport transport) {
        super(transport, null);
    }

    public OpenSearchKnnClient(OpenSearchTransport transport, @Nullable TransportOptions transportOptions) {
        super(transport, transportOptions);
    }

    @Override
    public OpenSearchKnnClient withTransportOptions(@Nullable TransportOptions transportOptions) {
        return new OpenSearchKnnClient(this.transport, transportOptions);
    }

    // ----- Endpoint: knn.delete_model

    /**
     * Used to delete a particular model in the cluster.
     */
    public DeleteModelResponse deleteModel(DeleteModelRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, DeleteModelRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Used to delete a particular model in the cluster.
     *
     * @param fn a function that initializes a builder to create the {@link DeleteModelRequest}
     */
    public final DeleteModelResponse deleteModel(Function<DeleteModelRequest.Builder, ObjectBuilder<DeleteModelRequest>> fn)
        throws IOException, OpenSearchException {
        return deleteModel(fn.apply(new DeleteModelRequest.Builder()).build());
    }

    // ----- Endpoint: knn.get_model

    /**
     * Used to retrieve information about models present in the cluster.
     */
    public GetModelResponse getModel(GetModelRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, GetModelRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Used to retrieve information about models present in the cluster.
     *
     * @param fn a function that initializes a builder to create the {@link GetModelRequest}
     */
    public final GetModelResponse getModel(Function<GetModelRequest.Builder, ObjectBuilder<GetModelRequest>> fn) throws IOException,
        OpenSearchException {
        return getModel(fn.apply(new GetModelRequest.Builder()).build());
    }

    // ----- Endpoint: knn.search_models

    /**
     * Use an OpenSearch query to search for models in the index.
     */
    public SearchModelsResponse searchModels(SearchModelsRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, SearchModelsRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Use an OpenSearch query to search for models in the index.
     *
     * @param fn a function that initializes a builder to create the {@link SearchModelsRequest}
     */
    public final SearchModelsResponse searchModels(Function<SearchModelsRequest.Builder, ObjectBuilder<SearchModelsRequest>> fn)
        throws IOException, OpenSearchException {
        return searchModels(fn.apply(new SearchModelsRequest.Builder()).build());
    }

    /**
     * Use an OpenSearch query to search for models in the index.
     */
    public final SearchModelsResponse searchModels() throws IOException, OpenSearchException {
        return searchModels(new SearchModelsRequest.Builder().build());
    }

    // ----- Endpoint: knn.stats

    /**
     * Provides information about the current status of the k-NN plugin.
     */
    public KnnStatsResponse stats(KnnStatsRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, KnnStatsRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Provides information about the current status of the k-NN plugin.
     *
     * @param fn a function that initializes a builder to create the {@link KnnStatsRequest}
     */
    public final KnnStatsResponse stats(Function<KnnStatsRequest.Builder, ObjectBuilder<KnnStatsRequest>> fn) throws IOException,
        OpenSearchException {
        return stats(fn.apply(new KnnStatsRequest.Builder()).build());
    }

    /**
     * Provides information about the current status of the k-NN plugin.
     */
    public final KnnStatsResponse stats() throws IOException, OpenSearchException {
        return stats(new KnnStatsRequest.Builder().build());
    }

    // ----- Endpoint: knn.train_model

    /**
     * Create and train a model that can be used for initializing k-NN native library indexes during indexing.
     */
    public TrainModelResponse trainModel(TrainModelRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, TrainModelRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Create and train a model that can be used for initializing k-NN native library indexes during indexing.
     *
     * @param fn a function that initializes a builder to create the {@link TrainModelRequest}
     */
    public final TrainModelResponse trainModel(Function<TrainModelRequest.Builder, ObjectBuilder<TrainModelRequest>> fn) throws IOException,
        OpenSearchException {
        return trainModel(fn.apply(new TrainModelRequest.Builder()).build());
    }

    // ----- Endpoint: knn.warmup

    /**
     * Preloads native library files into memory, reducing initial search latency for specified indexes.
     */
    public WarmupResponse warmup(WarmupRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, WarmupRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Preloads native library files into memory, reducing initial search latency for specified indexes.
     *
     * @param fn a function that initializes a builder to create the {@link WarmupRequest}
     */
    public final WarmupResponse warmup(Function<WarmupRequest.Builder, ObjectBuilder<WarmupRequest>> fn) throws IOException,
        OpenSearchException {
        return warmup(fn.apply(new WarmupRequest.Builder()).build());
    }
}
