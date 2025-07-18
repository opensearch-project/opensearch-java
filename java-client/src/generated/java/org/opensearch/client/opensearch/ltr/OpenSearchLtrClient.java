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

package org.opensearch.client.opensearch.ltr;

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
 * Client for the ltr namespace.
 */
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class OpenSearchLtrClient extends ApiClient<OpenSearchTransport, OpenSearchLtrClient> {
    public OpenSearchLtrClient(OpenSearchTransport transport) {
        super(transport, null);
    }

    public OpenSearchLtrClient(OpenSearchTransport transport, @Nullable TransportOptions transportOptions) {
        super(transport, transportOptions);
    }

    @Override
    public OpenSearchLtrClient withTransportOptions(@Nullable TransportOptions transportOptions) {
        return new OpenSearchLtrClient(this.transport, transportOptions);
    }

    // ----- Endpoint: ltr.add_features_to_set

    /**
     * Add features to an existing feature set in the default feature store.
     */
    public AddFeaturesToSetResponse addFeaturesToSet(AddFeaturesToSetRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, AddFeaturesToSetRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Add features to an existing feature set in the default feature store.
     *
     * @param fn a function that initializes a builder to create the {@link AddFeaturesToSetRequest}
     */
    public final AddFeaturesToSetResponse addFeaturesToSet(
        Function<AddFeaturesToSetRequest.Builder, ObjectBuilder<AddFeaturesToSetRequest>> fn
    ) throws IOException, OpenSearchException {
        return addFeaturesToSet(fn.apply(new AddFeaturesToSetRequest.Builder()).build());
    }

    // ----- Endpoint: ltr.add_features_to_set_by_query

    /**
     * Add features to an existing feature set in the default feature store.
     */
    public AddFeaturesToSetByQueryResponse addFeaturesToSetByQuery(AddFeaturesToSetByQueryRequest request) throws IOException,
        OpenSearchException {
        return this.transport.performRequest(request, AddFeaturesToSetByQueryRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Add features to an existing feature set in the default feature store.
     *
     * @param fn a function that initializes a builder to create the {@link AddFeaturesToSetByQueryRequest}
     */
    public final AddFeaturesToSetByQueryResponse addFeaturesToSetByQuery(
        Function<AddFeaturesToSetByQueryRequest.Builder, ObjectBuilder<AddFeaturesToSetByQueryRequest>> fn
    ) throws IOException, OpenSearchException {
        return addFeaturesToSetByQuery(fn.apply(new AddFeaturesToSetByQueryRequest.Builder()).build());
    }

    // ----- Endpoint: ltr.cache_stats

    /**
     * Retrieves cache statistics for all feature stores.
     */
    public CacheStatsResponse cacheStats(CacheStatsRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, CacheStatsRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Retrieves cache statistics for all feature stores.
     *
     * @param fn a function that initializes a builder to create the {@link CacheStatsRequest}
     */
    public final CacheStatsResponse cacheStats(Function<CacheStatsRequest.Builder, ObjectBuilder<CacheStatsRequest>> fn) throws IOException,
        OpenSearchException {
        return cacheStats(fn.apply(new CacheStatsRequest.Builder()).build());
    }

    /**
     * Retrieves cache statistics for all feature stores.
     */
    public final CacheStatsResponse cacheStats() throws IOException, OpenSearchException {
        return cacheStats(new CacheStatsRequest.Builder().build());
    }

    // ----- Endpoint: ltr.clear_cache

    /**
     * Clears the store caches.
     */
    public ClearCacheResponse clearCache(ClearCacheRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, ClearCacheRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Clears the store caches.
     *
     * @param fn a function that initializes a builder to create the {@link ClearCacheRequest}
     */
    public final ClearCacheResponse clearCache(Function<ClearCacheRequest.Builder, ObjectBuilder<ClearCacheRequest>> fn) throws IOException,
        OpenSearchException {
        return clearCache(fn.apply(new ClearCacheRequest.Builder()).build());
    }

    /**
     * Clears the store caches.
     */
    public final ClearCacheResponse clearCache() throws IOException, OpenSearchException {
        return clearCache(new ClearCacheRequest.Builder().build());
    }

    // ----- Endpoint: ltr.create_default_store

    /**
     * Creates the default feature store.
     */
    public CreateDefaultStoreResponse createDefaultStore(CreateDefaultStoreRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, CreateDefaultStoreRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Creates the default feature store.
     *
     * @param fn a function that initializes a builder to create the {@link CreateDefaultStoreRequest}
     */
    public final CreateDefaultStoreResponse createDefaultStore(
        Function<CreateDefaultStoreRequest.Builder, ObjectBuilder<CreateDefaultStoreRequest>> fn
    ) throws IOException, OpenSearchException {
        return createDefaultStore(fn.apply(new CreateDefaultStoreRequest.Builder()).build());
    }

    /**
     * Creates the default feature store.
     */
    public final CreateDefaultStoreResponse createDefaultStore() throws IOException, OpenSearchException {
        return createDefaultStore(new CreateDefaultStoreRequest.Builder().build());
    }

    // ----- Endpoint: ltr.create_feature

    /**
     * Create or update a feature in the default feature store.
     */
    public CreateFeatureResponse createFeature(CreateFeatureRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, CreateFeatureRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Create or update a feature in the default feature store.
     *
     * @param fn a function that initializes a builder to create the {@link CreateFeatureRequest}
     */
    public final CreateFeatureResponse createFeature(Function<CreateFeatureRequest.Builder, ObjectBuilder<CreateFeatureRequest>> fn)
        throws IOException, OpenSearchException {
        return createFeature(fn.apply(new CreateFeatureRequest.Builder()).build());
    }

    // ----- Endpoint: ltr.create_featureset

    /**
     * Create or update a feature set in the default feature store.
     */
    public CreateFeaturesetResponse createFeatureset(CreateFeaturesetRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, CreateFeaturesetRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Create or update a feature set in the default feature store.
     *
     * @param fn a function that initializes a builder to create the {@link CreateFeaturesetRequest}
     */
    public final CreateFeaturesetResponse createFeatureset(
        Function<CreateFeaturesetRequest.Builder, ObjectBuilder<CreateFeaturesetRequest>> fn
    ) throws IOException, OpenSearchException {
        return createFeatureset(fn.apply(new CreateFeaturesetRequest.Builder()).build());
    }

    // ----- Endpoint: ltr.create_model

    /**
     * Create or update a model in the default feature store.
     */
    public CreateModelResponse createModel(CreateModelRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, CreateModelRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Create or update a model in the default feature store.
     *
     * @param fn a function that initializes a builder to create the {@link CreateModelRequest}
     */
    public final CreateModelResponse createModel(Function<CreateModelRequest.Builder, ObjectBuilder<CreateModelRequest>> fn)
        throws IOException, OpenSearchException {
        return createModel(fn.apply(new CreateModelRequest.Builder()).build());
    }

    // ----- Endpoint: ltr.create_model_from_set

    /**
     * Create a model from an existing feature set in the default feature store.
     */
    public CreateModelFromSetResponse createModelFromSet(CreateModelFromSetRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, CreateModelFromSetRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Create a model from an existing feature set in the default feature store.
     *
     * @param fn a function that initializes a builder to create the {@link CreateModelFromSetRequest}
     */
    public final CreateModelFromSetResponse createModelFromSet(
        Function<CreateModelFromSetRequest.Builder, ObjectBuilder<CreateModelFromSetRequest>> fn
    ) throws IOException, OpenSearchException {
        return createModelFromSet(fn.apply(new CreateModelFromSetRequest.Builder()).build());
    }

    // ----- Endpoint: ltr.create_store

    /**
     * Creates a new feature store with the specified name.
     */
    public CreateStoreResponse createStore(CreateStoreRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, CreateStoreRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Creates a new feature store with the specified name.
     *
     * @param fn a function that initializes a builder to create the {@link CreateStoreRequest}
     */
    public final CreateStoreResponse createStore(Function<CreateStoreRequest.Builder, ObjectBuilder<CreateStoreRequest>> fn)
        throws IOException, OpenSearchException {
        return createStore(fn.apply(new CreateStoreRequest.Builder()).build());
    }

    // ----- Endpoint: ltr.delete_default_store

    /**
     * Deletes the default feature store.
     */
    public DeleteDefaultStoreResponse deleteDefaultStore(DeleteDefaultStoreRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, DeleteDefaultStoreRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Deletes the default feature store.
     *
     * @param fn a function that initializes a builder to create the {@link DeleteDefaultStoreRequest}
     */
    public final DeleteDefaultStoreResponse deleteDefaultStore(
        Function<DeleteDefaultStoreRequest.Builder, ObjectBuilder<DeleteDefaultStoreRequest>> fn
    ) throws IOException, OpenSearchException {
        return deleteDefaultStore(fn.apply(new DeleteDefaultStoreRequest.Builder()).build());
    }

    /**
     * Deletes the default feature store.
     */
    public final DeleteDefaultStoreResponse deleteDefaultStore() throws IOException, OpenSearchException {
        return deleteDefaultStore(new DeleteDefaultStoreRequest.Builder().build());
    }

    // ----- Endpoint: ltr.delete_feature

    /**
     * Delete a feature from the default feature store.
     */
    public DeleteFeatureResponse deleteFeature(DeleteFeatureRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, DeleteFeatureRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Delete a feature from the default feature store.
     *
     * @param fn a function that initializes a builder to create the {@link DeleteFeatureRequest}
     */
    public final DeleteFeatureResponse deleteFeature(Function<DeleteFeatureRequest.Builder, ObjectBuilder<DeleteFeatureRequest>> fn)
        throws IOException, OpenSearchException {
        return deleteFeature(fn.apply(new DeleteFeatureRequest.Builder()).build());
    }

    // ----- Endpoint: ltr.delete_featureset

    /**
     * Delete a feature set from the default feature store.
     */
    public DeleteFeaturesetResponse deleteFeatureset(DeleteFeaturesetRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, DeleteFeaturesetRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Delete a feature set from the default feature store.
     *
     * @param fn a function that initializes a builder to create the {@link DeleteFeaturesetRequest}
     */
    public final DeleteFeaturesetResponse deleteFeatureset(
        Function<DeleteFeaturesetRequest.Builder, ObjectBuilder<DeleteFeaturesetRequest>> fn
    ) throws IOException, OpenSearchException {
        return deleteFeatureset(fn.apply(new DeleteFeaturesetRequest.Builder()).build());
    }

    // ----- Endpoint: ltr.delete_model

    /**
     * Delete a model from the default feature store.
     */
    public DeleteModelResponse deleteModel(DeleteModelRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, DeleteModelRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Delete a model from the default feature store.
     *
     * @param fn a function that initializes a builder to create the {@link DeleteModelRequest}
     */
    public final DeleteModelResponse deleteModel(Function<DeleteModelRequest.Builder, ObjectBuilder<DeleteModelRequest>> fn)
        throws IOException, OpenSearchException {
        return deleteModel(fn.apply(new DeleteModelRequest.Builder()).build());
    }

    // ----- Endpoint: ltr.delete_store

    /**
     * Deletes a feature store with the specified name.
     */
    public DeleteStoreResponse deleteStore(DeleteStoreRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, DeleteStoreRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Deletes a feature store with the specified name.
     *
     * @param fn a function that initializes a builder to create the {@link DeleteStoreRequest}
     */
    public final DeleteStoreResponse deleteStore(Function<DeleteStoreRequest.Builder, ObjectBuilder<DeleteStoreRequest>> fn)
        throws IOException, OpenSearchException {
        return deleteStore(fn.apply(new DeleteStoreRequest.Builder()).build());
    }

    // ----- Endpoint: ltr.get_feature

    /**
     * Get a feature from the default feature store.
     */
    public GetFeatureResponse getFeature(GetFeatureRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, GetFeatureRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Get a feature from the default feature store.
     *
     * @param fn a function that initializes a builder to create the {@link GetFeatureRequest}
     */
    public final GetFeatureResponse getFeature(Function<GetFeatureRequest.Builder, ObjectBuilder<GetFeatureRequest>> fn) throws IOException,
        OpenSearchException {
        return getFeature(fn.apply(new GetFeatureRequest.Builder()).build());
    }

    // ----- Endpoint: ltr.get_featureset

    /**
     * Get a feature set from the default feature store.
     */
    public GetFeaturesetResponse getFeatureset(GetFeaturesetRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, GetFeaturesetRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Get a feature set from the default feature store.
     *
     * @param fn a function that initializes a builder to create the {@link GetFeaturesetRequest}
     */
    public final GetFeaturesetResponse getFeatureset(Function<GetFeaturesetRequest.Builder, ObjectBuilder<GetFeaturesetRequest>> fn)
        throws IOException, OpenSearchException {
        return getFeatureset(fn.apply(new GetFeaturesetRequest.Builder()).build());
    }

    // ----- Endpoint: ltr.get_model

    /**
     * Get a model from the default feature store.
     */
    public GetModelResponse getModel(GetModelRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, GetModelRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Get a model from the default feature store.
     *
     * @param fn a function that initializes a builder to create the {@link GetModelRequest}
     */
    public final GetModelResponse getModel(Function<GetModelRequest.Builder, ObjectBuilder<GetModelRequest>> fn) throws IOException,
        OpenSearchException {
        return getModel(fn.apply(new GetModelRequest.Builder()).build());
    }

    // ----- Endpoint: ltr.get_store

    /**
     * Checks if a store exists.
     */
    public GetStoreResponse getStore(GetStoreRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, GetStoreRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Checks if a store exists.
     *
     * @param fn a function that initializes a builder to create the {@link GetStoreRequest}
     */
    public final GetStoreResponse getStore(Function<GetStoreRequest.Builder, ObjectBuilder<GetStoreRequest>> fn) throws IOException,
        OpenSearchException {
        return getStore(fn.apply(new GetStoreRequest.Builder()).build());
    }

    // ----- Endpoint: ltr.list_stores

    /**
     * Lists all available feature stores.
     */
    public ListStoresResponse listStores(ListStoresRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, ListStoresRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Lists all available feature stores.
     *
     * @param fn a function that initializes a builder to create the {@link ListStoresRequest}
     */
    public final ListStoresResponse listStores(Function<ListStoresRequest.Builder, ObjectBuilder<ListStoresRequest>> fn) throws IOException,
        OpenSearchException {
        return listStores(fn.apply(new ListStoresRequest.Builder()).build());
    }

    /**
     * Lists all available feature stores.
     */
    public final ListStoresResponse listStores() throws IOException, OpenSearchException {
        return listStores(new ListStoresRequest.Builder().build());
    }

    // ----- Endpoint: ltr.search_features

    /**
     * Search for features in a feature store.
     */
    public SearchFeaturesResponse searchFeatures(SearchFeaturesRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, SearchFeaturesRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Search for features in a feature store.
     *
     * @param fn a function that initializes a builder to create the {@link SearchFeaturesRequest}
     */
    public final SearchFeaturesResponse searchFeatures(Function<SearchFeaturesRequest.Builder, ObjectBuilder<SearchFeaturesRequest>> fn)
        throws IOException, OpenSearchException {
        return searchFeatures(fn.apply(new SearchFeaturesRequest.Builder()).build());
    }

    /**
     * Search for features in a feature store.
     */
    public final SearchFeaturesResponse searchFeatures() throws IOException, OpenSearchException {
        return searchFeatures(new SearchFeaturesRequest.Builder().build());
    }

    // ----- Endpoint: ltr.search_featuresets

    /**
     * Search for feature sets in a feature store.
     */
    public SearchFeaturesetsResponse searchFeaturesets(SearchFeaturesetsRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, SearchFeaturesetsRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Search for feature sets in a feature store.
     *
     * @param fn a function that initializes a builder to create the {@link SearchFeaturesetsRequest}
     */
    public final SearchFeaturesetsResponse searchFeaturesets(
        Function<SearchFeaturesetsRequest.Builder, ObjectBuilder<SearchFeaturesetsRequest>> fn
    ) throws IOException, OpenSearchException {
        return searchFeaturesets(fn.apply(new SearchFeaturesetsRequest.Builder()).build());
    }

    /**
     * Search for feature sets in a feature store.
     */
    public final SearchFeaturesetsResponse searchFeaturesets() throws IOException, OpenSearchException {
        return searchFeaturesets(new SearchFeaturesetsRequest.Builder().build());
    }

    // ----- Endpoint: ltr.search_models

    /**
     * Search for models in a feature store.
     */
    public SearchModelsResponse searchModels(SearchModelsRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, SearchModelsRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Search for models in a feature store.
     *
     * @param fn a function that initializes a builder to create the {@link SearchModelsRequest}
     */
    public final SearchModelsResponse searchModels(Function<SearchModelsRequest.Builder, ObjectBuilder<SearchModelsRequest>> fn)
        throws IOException, OpenSearchException {
        return searchModels(fn.apply(new SearchModelsRequest.Builder()).build());
    }

    /**
     * Search for models in a feature store.
     */
    public final SearchModelsResponse searchModels() throws IOException, OpenSearchException {
        return searchModels(new SearchModelsRequest.Builder().build());
    }

    // ----- Endpoint: ltr.stats

    /**
     * Provides information about the current status of the LTR plugin.
     */
    public LtrStatsResponse stats(LtrStatsRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, LtrStatsRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Provides information about the current status of the LTR plugin.
     *
     * @param fn a function that initializes a builder to create the {@link LtrStatsRequest}
     */
    public final LtrStatsResponse stats(Function<LtrStatsRequest.Builder, ObjectBuilder<LtrStatsRequest>> fn) throws IOException,
        OpenSearchException {
        return stats(fn.apply(new LtrStatsRequest.Builder()).build());
    }

    /**
     * Provides information about the current status of the LTR plugin.
     */
    public final LtrStatsResponse stats() throws IOException, OpenSearchException {
        return stats(new LtrStatsRequest.Builder().build());
    }

    // ----- Endpoint: ltr.update_feature

    /**
     * Update a feature in the default feature store.
     */
    public UpdateFeatureResponse updateFeature(UpdateFeatureRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, UpdateFeatureRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Update a feature in the default feature store.
     *
     * @param fn a function that initializes a builder to create the {@link UpdateFeatureRequest}
     */
    public final UpdateFeatureResponse updateFeature(Function<UpdateFeatureRequest.Builder, ObjectBuilder<UpdateFeatureRequest>> fn)
        throws IOException, OpenSearchException {
        return updateFeature(fn.apply(new UpdateFeatureRequest.Builder()).build());
    }

    // ----- Endpoint: ltr.update_featureset

    /**
     * Update a feature set in the default feature store.
     */
    public UpdateFeaturesetResponse updateFeatureset(UpdateFeaturesetRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, UpdateFeaturesetRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Update a feature set in the default feature store.
     *
     * @param fn a function that initializes a builder to create the {@link UpdateFeaturesetRequest}
     */
    public final UpdateFeaturesetResponse updateFeatureset(
        Function<UpdateFeaturesetRequest.Builder, ObjectBuilder<UpdateFeaturesetRequest>> fn
    ) throws IOException, OpenSearchException {
        return updateFeatureset(fn.apply(new UpdateFeaturesetRequest.Builder()).build());
    }
}
