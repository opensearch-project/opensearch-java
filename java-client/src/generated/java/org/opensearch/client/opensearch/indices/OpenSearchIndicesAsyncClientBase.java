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
 * Client for the indices namespace.
 */
@Generated("org.opensearch.client.codegen.CodeGenerator")
public abstract class OpenSearchIndicesAsyncClientBase<Self extends OpenSearchIndicesAsyncClientBase<Self>> extends ApiClient<
    OpenSearchTransport,
    Self> {
    public OpenSearchIndicesAsyncClientBase(OpenSearchTransport transport, @Nullable TransportOptions transportOptions) {
        super(transport, transportOptions);
    }

    // ----- Endpoint: indices.add_block

    /**
     * Adds a block to an index.
     */
    public CompletableFuture<AddBlockResponse> addBlock(AddBlockRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, AddBlockRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Adds a block to an index.
     *
     * @param fn a function that initializes a builder to create the {@link AddBlockRequest}
     */
    public final CompletableFuture<AddBlockResponse> addBlock(Function<AddBlockRequest.Builder, ObjectBuilder<AddBlockRequest>> fn)
        throws IOException, OpenSearchException {
        return addBlock(fn.apply(new AddBlockRequest.Builder()).build());
    }

    // ----- Endpoint: indices.analyze

    /**
     * Performs the analysis process on a text and return the tokens breakdown of the text.
     */
    public CompletableFuture<AnalyzeResponse> analyze(AnalyzeRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, AnalyzeRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Performs the analysis process on a text and return the tokens breakdown of the text.
     *
     * @param fn a function that initializes a builder to create the {@link AnalyzeRequest}
     */
    public final CompletableFuture<AnalyzeResponse> analyze(Function<AnalyzeRequest.Builder, ObjectBuilder<AnalyzeRequest>> fn)
        throws IOException, OpenSearchException {
        return analyze(fn.apply(new AnalyzeRequest.Builder()).build());
    }

    /**
     * Performs the analysis process on a text and return the tokens breakdown of the text.
     */
    public final CompletableFuture<AnalyzeResponse> analyze() throws IOException, OpenSearchException {
        return analyze(new AnalyzeRequest.Builder().build());
    }

    // ----- Endpoint: indices.clear_cache

    /**
     * Clears all or specific caches for one or more indexes.
     */
    public CompletableFuture<ClearCacheResponse> clearCache(ClearCacheRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, ClearCacheRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Clears all or specific caches for one or more indexes.
     *
     * @param fn a function that initializes a builder to create the {@link ClearCacheRequest}
     */
    public final CompletableFuture<ClearCacheResponse> clearCache(Function<ClearCacheRequest.Builder, ObjectBuilder<ClearCacheRequest>> fn)
        throws IOException, OpenSearchException {
        return clearCache(fn.apply(new ClearCacheRequest.Builder()).build());
    }

    /**
     * Clears all or specific caches for one or more indexes.
     */
    public final CompletableFuture<ClearCacheResponse> clearCache() throws IOException, OpenSearchException {
        return clearCache(new ClearCacheRequest.Builder().build());
    }

    // ----- Endpoint: indices.clone

    /**
     * Clones an index.
     */
    public CompletableFuture<CloneIndexResponse> clone(CloneIndexRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, CloneIndexRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Clones an index.
     *
     * @param fn a function that initializes a builder to create the {@link CloneIndexRequest}
     */
    public final CompletableFuture<CloneIndexResponse> clone(Function<CloneIndexRequest.Builder, ObjectBuilder<CloneIndexRequest>> fn)
        throws IOException, OpenSearchException {
        return clone(fn.apply(new CloneIndexRequest.Builder()).build());
    }

    // ----- Endpoint: indices.close

    /**
     * Closes an index.
     */
    public CompletableFuture<CloseIndexResponse> close(CloseIndexRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, CloseIndexRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Closes an index.
     *
     * @param fn a function that initializes a builder to create the {@link CloseIndexRequest}
     */
    public final CompletableFuture<CloseIndexResponse> close(Function<CloseIndexRequest.Builder, ObjectBuilder<CloseIndexRequest>> fn)
        throws IOException, OpenSearchException {
        return close(fn.apply(new CloseIndexRequest.Builder()).build());
    }

    // ----- Endpoint: indices.create

    /**
     * Creates an index with optional settings and mappings.
     */
    public CompletableFuture<CreateIndexResponse> create(CreateIndexRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, CreateIndexRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Creates an index with optional settings and mappings.
     *
     * @param fn a function that initializes a builder to create the {@link CreateIndexRequest}
     */
    public final CompletableFuture<CreateIndexResponse> create(Function<CreateIndexRequest.Builder, ObjectBuilder<CreateIndexRequest>> fn)
        throws IOException, OpenSearchException {
        return create(fn.apply(new CreateIndexRequest.Builder()).build());
    }

    // ----- Endpoint: indices.create_data_stream

    /**
     * Creates or updates a data stream.
     */
    public CompletableFuture<CreateDataStreamResponse> createDataStream(CreateDataStreamRequest request) throws IOException,
        OpenSearchException {
        return this.transport.performRequestAsync(request, CreateDataStreamRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Creates or updates a data stream.
     *
     * @param fn a function that initializes a builder to create the {@link CreateDataStreamRequest}
     */
    public final CompletableFuture<CreateDataStreamResponse> createDataStream(
        Function<CreateDataStreamRequest.Builder, ObjectBuilder<CreateDataStreamRequest>> fn
    ) throws IOException, OpenSearchException {
        return createDataStream(fn.apply(new CreateDataStreamRequest.Builder()).build());
    }

    // ----- Endpoint: indices.data_streams_stats

    /**
     * Provides statistics on operations happening in a data stream.
     */
    public CompletableFuture<DataStreamsStatsResponse> dataStreamsStats(DataStreamsStatsRequest request) throws IOException,
        OpenSearchException {
        return this.transport.performRequestAsync(request, DataStreamsStatsRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Provides statistics on operations happening in a data stream.
     *
     * @param fn a function that initializes a builder to create the {@link DataStreamsStatsRequest}
     */
    public final CompletableFuture<DataStreamsStatsResponse> dataStreamsStats(
        Function<DataStreamsStatsRequest.Builder, ObjectBuilder<DataStreamsStatsRequest>> fn
    ) throws IOException, OpenSearchException {
        return dataStreamsStats(fn.apply(new DataStreamsStatsRequest.Builder()).build());
    }

    /**
     * Provides statistics on operations happening in a data stream.
     */
    public final CompletableFuture<DataStreamsStatsResponse> dataStreamsStats() throws IOException, OpenSearchException {
        return dataStreamsStats(new DataStreamsStatsRequest.Builder().build());
    }

    // ----- Endpoint: indices.delete

    /**
     * Deletes an index.
     */
    public CompletableFuture<DeleteIndexResponse> delete(DeleteIndexRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, DeleteIndexRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Deletes an index.
     *
     * @param fn a function that initializes a builder to create the {@link DeleteIndexRequest}
     */
    public final CompletableFuture<DeleteIndexResponse> delete(Function<DeleteIndexRequest.Builder, ObjectBuilder<DeleteIndexRequest>> fn)
        throws IOException, OpenSearchException {
        return delete(fn.apply(new DeleteIndexRequest.Builder()).build());
    }

    // ----- Endpoint: indices.delete_alias

    /**
     * Deletes an alias.
     */
    public CompletableFuture<DeleteAliasResponse> deleteAlias(DeleteAliasRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, DeleteAliasRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Deletes an alias.
     *
     * @param fn a function that initializes a builder to create the {@link DeleteAliasRequest}
     */
    public final CompletableFuture<DeleteAliasResponse> deleteAlias(
        Function<DeleteAliasRequest.Builder, ObjectBuilder<DeleteAliasRequest>> fn
    ) throws IOException, OpenSearchException {
        return deleteAlias(fn.apply(new DeleteAliasRequest.Builder()).build());
    }

    // ----- Endpoint: indices.delete_data_stream

    /**
     * Deletes a data stream.
     */
    public CompletableFuture<DeleteDataStreamResponse> deleteDataStream(DeleteDataStreamRequest request) throws IOException,
        OpenSearchException {
        return this.transport.performRequestAsync(request, DeleteDataStreamRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Deletes a data stream.
     *
     * @param fn a function that initializes a builder to create the {@link DeleteDataStreamRequest}
     */
    public final CompletableFuture<DeleteDataStreamResponse> deleteDataStream(
        Function<DeleteDataStreamRequest.Builder, ObjectBuilder<DeleteDataStreamRequest>> fn
    ) throws IOException, OpenSearchException {
        return deleteDataStream(fn.apply(new DeleteDataStreamRequest.Builder()).build());
    }

    // ----- Endpoint: indices.delete_index_template

    /**
     * Deletes an index template.
     */
    public CompletableFuture<DeleteIndexTemplateResponse> deleteIndexTemplate(DeleteIndexTemplateRequest request) throws IOException,
        OpenSearchException {
        return this.transport.performRequestAsync(request, DeleteIndexTemplateRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Deletes an index template.
     *
     * @param fn a function that initializes a builder to create the {@link DeleteIndexTemplateRequest}
     */
    public final CompletableFuture<DeleteIndexTemplateResponse> deleteIndexTemplate(
        Function<DeleteIndexTemplateRequest.Builder, ObjectBuilder<DeleteIndexTemplateRequest>> fn
    ) throws IOException, OpenSearchException {
        return deleteIndexTemplate(fn.apply(new DeleteIndexTemplateRequest.Builder()).build());
    }

    // ----- Endpoint: indices.delete_template

    /**
     * Deletes an index template.
     */
    public CompletableFuture<DeleteTemplateResponse> deleteTemplate(DeleteTemplateRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, DeleteTemplateRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Deletes an index template.
     *
     * @param fn a function that initializes a builder to create the {@link DeleteTemplateRequest}
     */
    public final CompletableFuture<DeleteTemplateResponse> deleteTemplate(
        Function<DeleteTemplateRequest.Builder, ObjectBuilder<DeleteTemplateRequest>> fn
    ) throws IOException, OpenSearchException {
        return deleteTemplate(fn.apply(new DeleteTemplateRequest.Builder()).build());
    }

    // ----- Endpoint: indices.exists

    /**
     * Returns information about whether a particular index exists.
     */
    public CompletableFuture<BooleanResponse> exists(ExistsRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, ExistsRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Returns information about whether a particular index exists.
     *
     * @param fn a function that initializes a builder to create the {@link ExistsRequest}
     */
    public final CompletableFuture<BooleanResponse> exists(Function<ExistsRequest.Builder, ObjectBuilder<ExistsRequest>> fn)
        throws IOException, OpenSearchException {
        return exists(fn.apply(new ExistsRequest.Builder()).build());
    }

    // ----- Endpoint: indices.exists_alias

    /**
     * Returns information about whether a particular alias exists.
     */
    public CompletableFuture<BooleanResponse> existsAlias(ExistsAliasRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, ExistsAliasRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Returns information about whether a particular alias exists.
     *
     * @param fn a function that initializes a builder to create the {@link ExistsAliasRequest}
     */
    public final CompletableFuture<BooleanResponse> existsAlias(Function<ExistsAliasRequest.Builder, ObjectBuilder<ExistsAliasRequest>> fn)
        throws IOException, OpenSearchException {
        return existsAlias(fn.apply(new ExistsAliasRequest.Builder()).build());
    }

    // ----- Endpoint: indices.exists_index_template

    /**
     * Returns information about whether a particular index template exists.
     */
    public CompletableFuture<BooleanResponse> existsIndexTemplate(ExistsIndexTemplateRequest request) throws IOException,
        OpenSearchException {
        return this.transport.performRequestAsync(request, ExistsIndexTemplateRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Returns information about whether a particular index template exists.
     *
     * @param fn a function that initializes a builder to create the {@link ExistsIndexTemplateRequest}
     */
    public final CompletableFuture<BooleanResponse> existsIndexTemplate(
        Function<ExistsIndexTemplateRequest.Builder, ObjectBuilder<ExistsIndexTemplateRequest>> fn
    ) throws IOException, OpenSearchException {
        return existsIndexTemplate(fn.apply(new ExistsIndexTemplateRequest.Builder()).build());
    }

    // ----- Endpoint: indices.exists_template

    /**
     * Returns information about whether a particular index template exists.
     */
    public CompletableFuture<BooleanResponse> existsTemplate(ExistsTemplateRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, ExistsTemplateRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Returns information about whether a particular index template exists.
     *
     * @param fn a function that initializes a builder to create the {@link ExistsTemplateRequest}
     */
    public final CompletableFuture<BooleanResponse> existsTemplate(
        Function<ExistsTemplateRequest.Builder, ObjectBuilder<ExistsTemplateRequest>> fn
    ) throws IOException, OpenSearchException {
        return existsTemplate(fn.apply(new ExistsTemplateRequest.Builder()).build());
    }

    // ----- Endpoint: indices.flush

    /**
     * Performs the flush operation on one or more indexes.
     */
    public CompletableFuture<FlushResponse> flush(FlushRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, FlushRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Performs the flush operation on one or more indexes.
     *
     * @param fn a function that initializes a builder to create the {@link FlushRequest}
     */
    public final CompletableFuture<FlushResponse> flush(Function<FlushRequest.Builder, ObjectBuilder<FlushRequest>> fn) throws IOException,
        OpenSearchException {
        return flush(fn.apply(new FlushRequest.Builder()).build());
    }

    /**
     * Performs the flush operation on one or more indexes.
     */
    public final CompletableFuture<FlushResponse> flush() throws IOException, OpenSearchException {
        return flush(new FlushRequest.Builder().build());
    }

    // ----- Endpoint: indices.forcemerge

    /**
     * Performs the force merge operation on one or more indexes.
     */
    public CompletableFuture<ForcemergeResponse> forcemerge(ForcemergeRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, ForcemergeRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Performs the force merge operation on one or more indexes.
     *
     * @param fn a function that initializes a builder to create the {@link ForcemergeRequest}
     */
    public final CompletableFuture<ForcemergeResponse> forcemerge(Function<ForcemergeRequest.Builder, ObjectBuilder<ForcemergeRequest>> fn)
        throws IOException, OpenSearchException {
        return forcemerge(fn.apply(new ForcemergeRequest.Builder()).build());
    }

    /**
     * Performs the force merge operation on one or more indexes.
     */
    public final CompletableFuture<ForcemergeResponse> forcemerge() throws IOException, OpenSearchException {
        return forcemerge(new ForcemergeRequest.Builder().build());
    }

    // ----- Endpoint: indices.get

    /**
     * Returns information about one or more indexes.
     */
    public CompletableFuture<GetIndexResponse> get(GetIndexRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, GetIndexRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Returns information about one or more indexes.
     *
     * @param fn a function that initializes a builder to create the {@link GetIndexRequest}
     */
    public final CompletableFuture<GetIndexResponse> get(Function<GetIndexRequest.Builder, ObjectBuilder<GetIndexRequest>> fn)
        throws IOException, OpenSearchException {
        return get(fn.apply(new GetIndexRequest.Builder()).build());
    }

    // ----- Endpoint: indices.get_alias

    /**
     * Returns an alias.
     */
    public CompletableFuture<GetAliasResponse> getAlias(GetAliasRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, GetAliasRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Returns an alias.
     *
     * @param fn a function that initializes a builder to create the {@link GetAliasRequest}
     */
    public final CompletableFuture<GetAliasResponse> getAlias(Function<GetAliasRequest.Builder, ObjectBuilder<GetAliasRequest>> fn)
        throws IOException, OpenSearchException {
        return getAlias(fn.apply(new GetAliasRequest.Builder()).build());
    }

    /**
     * Returns an alias.
     */
    public final CompletableFuture<GetAliasResponse> getAlias() throws IOException, OpenSearchException {
        return getAlias(new GetAliasRequest.Builder().build());
    }

    // ----- Endpoint: indices.get_data_stream

    /**
     * Returns data streams.
     */
    public CompletableFuture<GetDataStreamResponse> getDataStream(GetDataStreamRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, GetDataStreamRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Returns data streams.
     *
     * @param fn a function that initializes a builder to create the {@link GetDataStreamRequest}
     */
    public final CompletableFuture<GetDataStreamResponse> getDataStream(
        Function<GetDataStreamRequest.Builder, ObjectBuilder<GetDataStreamRequest>> fn
    ) throws IOException, OpenSearchException {
        return getDataStream(fn.apply(new GetDataStreamRequest.Builder()).build());
    }

    /**
     * Returns data streams.
     */
    public final CompletableFuture<GetDataStreamResponse> getDataStream() throws IOException, OpenSearchException {
        return getDataStream(new GetDataStreamRequest.Builder().build());
    }

    // ----- Endpoint: indices.get_index_template

    /**
     * Returns an index template.
     */
    public CompletableFuture<GetIndexTemplateResponse> getIndexTemplate(GetIndexTemplateRequest request) throws IOException,
        OpenSearchException {
        return this.transport.performRequestAsync(request, GetIndexTemplateRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Returns an index template.
     *
     * @param fn a function that initializes a builder to create the {@link GetIndexTemplateRequest}
     */
    public final CompletableFuture<GetIndexTemplateResponse> getIndexTemplate(
        Function<GetIndexTemplateRequest.Builder, ObjectBuilder<GetIndexTemplateRequest>> fn
    ) throws IOException, OpenSearchException {
        return getIndexTemplate(fn.apply(new GetIndexTemplateRequest.Builder()).build());
    }

    /**
     * Returns an index template.
     */
    public final CompletableFuture<GetIndexTemplateResponse> getIndexTemplate() throws IOException, OpenSearchException {
        return getIndexTemplate(new GetIndexTemplateRequest.Builder().build());
    }

    // ----- Endpoint: indices.get_mapping

    /**
     * Returns mappings for one or more indexes.
     */
    public CompletableFuture<GetMappingResponse> getMapping(GetMappingRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, GetMappingRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Returns mappings for one or more indexes.
     *
     * @param fn a function that initializes a builder to create the {@link GetMappingRequest}
     */
    public final CompletableFuture<GetMappingResponse> getMapping(Function<GetMappingRequest.Builder, ObjectBuilder<GetMappingRequest>> fn)
        throws IOException, OpenSearchException {
        return getMapping(fn.apply(new GetMappingRequest.Builder()).build());
    }

    /**
     * Returns mappings for one or more indexes.
     */
    public final CompletableFuture<GetMappingResponse> getMapping() throws IOException, OpenSearchException {
        return getMapping(new GetMappingRequest.Builder().build());
    }

    // ----- Endpoint: indices.get_settings

    /**
     * Returns settings for one or more indexes.
     */
    public CompletableFuture<GetIndicesSettingsResponse> getSettings(GetIndicesSettingsRequest request) throws IOException,
        OpenSearchException {
        return this.transport.performRequestAsync(request, GetIndicesSettingsRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Returns settings for one or more indexes.
     *
     * @param fn a function that initializes a builder to create the {@link GetIndicesSettingsRequest}
     */
    public final CompletableFuture<GetIndicesSettingsResponse> getSettings(
        Function<GetIndicesSettingsRequest.Builder, ObjectBuilder<GetIndicesSettingsRequest>> fn
    ) throws IOException, OpenSearchException {
        return getSettings(fn.apply(new GetIndicesSettingsRequest.Builder()).build());
    }

    /**
     * Returns settings for one or more indexes.
     */
    public final CompletableFuture<GetIndicesSettingsResponse> getSettings() throws IOException, OpenSearchException {
        return getSettings(new GetIndicesSettingsRequest.Builder().build());
    }

    // ----- Endpoint: indices.get_template

    /**
     * Returns an index template.
     */
    public CompletableFuture<GetTemplateResponse> getTemplate(GetTemplateRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, GetTemplateRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Returns an index template.
     *
     * @param fn a function that initializes a builder to create the {@link GetTemplateRequest}
     */
    public final CompletableFuture<GetTemplateResponse> getTemplate(
        Function<GetTemplateRequest.Builder, ObjectBuilder<GetTemplateRequest>> fn
    ) throws IOException, OpenSearchException {
        return getTemplate(fn.apply(new GetTemplateRequest.Builder()).build());
    }

    /**
     * Returns an index template.
     */
    public final CompletableFuture<GetTemplateResponse> getTemplate() throws IOException, OpenSearchException {
        return getTemplate(new GetTemplateRequest.Builder().build());
    }

    // ----- Endpoint: indices.get_upgrade

    /**
     * The <code>_upgrade</code> API is no longer useful and will be removed.
     */
    @Deprecated
    public CompletableFuture<GetUpgradeResponse> getUpgrade(GetUpgradeRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, GetUpgradeRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * The <code>_upgrade</code> API is no longer useful and will be removed.
     *
     * @param fn a function that initializes a builder to create the {@link GetUpgradeRequest}
     */
    @Deprecated
    public final CompletableFuture<GetUpgradeResponse> getUpgrade(Function<GetUpgradeRequest.Builder, ObjectBuilder<GetUpgradeRequest>> fn)
        throws IOException, OpenSearchException {
        return getUpgrade(fn.apply(new GetUpgradeRequest.Builder()).build());
    }

    /**
     * The <code>_upgrade</code> API is no longer useful and will be removed.
     */
    @Deprecated
    public final CompletableFuture<GetUpgradeResponse> getUpgrade() throws IOException, OpenSearchException {
        return getUpgrade(new GetUpgradeRequest.Builder().build());
    }

    // ----- Endpoint: indices.open

    /**
     * Opens an index.
     */
    public CompletableFuture<OpenResponse> open(OpenRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, OpenRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Opens an index.
     *
     * @param fn a function that initializes a builder to create the {@link OpenRequest}
     */
    public final CompletableFuture<OpenResponse> open(Function<OpenRequest.Builder, ObjectBuilder<OpenRequest>> fn) throws IOException,
        OpenSearchException {
        return open(fn.apply(new OpenRequest.Builder()).build());
    }

    // ----- Endpoint: indices.put_alias

    /**
     * Creates or updates an alias.
     */
    public CompletableFuture<PutAliasResponse> putAlias(PutAliasRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, PutAliasRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Creates or updates an alias.
     *
     * @param fn a function that initializes a builder to create the {@link PutAliasRequest}
     */
    public final CompletableFuture<PutAliasResponse> putAlias(Function<PutAliasRequest.Builder, ObjectBuilder<PutAliasRequest>> fn)
        throws IOException, OpenSearchException {
        return putAlias(fn.apply(new PutAliasRequest.Builder()).build());
    }

    /**
     * Creates or updates an alias.
     */
    public final CompletableFuture<PutAliasResponse> putAlias() throws IOException, OpenSearchException {
        return putAlias(new PutAliasRequest.Builder().build());
    }

    // ----- Endpoint: indices.put_index_template

    /**
     * Creates or updates an index template.
     */
    public CompletableFuture<PutIndexTemplateResponse> putIndexTemplate(PutIndexTemplateRequest request) throws IOException,
        OpenSearchException {
        return this.transport.performRequestAsync(request, PutIndexTemplateRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Creates or updates an index template.
     *
     * @param fn a function that initializes a builder to create the {@link PutIndexTemplateRequest}
     */
    public final CompletableFuture<PutIndexTemplateResponse> putIndexTemplate(
        Function<PutIndexTemplateRequest.Builder, ObjectBuilder<PutIndexTemplateRequest>> fn
    ) throws IOException, OpenSearchException {
        return putIndexTemplate(fn.apply(new PutIndexTemplateRequest.Builder()).build());
    }

    // ----- Endpoint: indices.put_mapping

    /**
     * Updates the index mappings.
     */
    public CompletableFuture<PutMappingResponse> putMapping(PutMappingRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, PutMappingRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Updates the index mappings.
     *
     * @param fn a function that initializes a builder to create the {@link PutMappingRequest}
     */
    public final CompletableFuture<PutMappingResponse> putMapping(Function<PutMappingRequest.Builder, ObjectBuilder<PutMappingRequest>> fn)
        throws IOException, OpenSearchException {
        return putMapping(fn.apply(new PutMappingRequest.Builder()).build());
    }

    // ----- Endpoint: indices.put_settings

    /**
     * Updates the index settings.
     */
    public CompletableFuture<PutIndicesSettingsResponse> putSettings(PutIndicesSettingsRequest request) throws IOException,
        OpenSearchException {
        return this.transport.performRequestAsync(request, PutIndicesSettingsRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Updates the index settings.
     *
     * @param fn a function that initializes a builder to create the {@link PutIndicesSettingsRequest}
     */
    public final CompletableFuture<PutIndicesSettingsResponse> putSettings(
        Function<PutIndicesSettingsRequest.Builder, ObjectBuilder<PutIndicesSettingsRequest>> fn
    ) throws IOException, OpenSearchException {
        return putSettings(fn.apply(new PutIndicesSettingsRequest.Builder()).build());
    }

    // ----- Endpoint: indices.put_template

    /**
     * Creates or updates an index template.
     */
    public CompletableFuture<PutTemplateResponse> putTemplate(PutTemplateRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, PutTemplateRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Creates or updates an index template.
     *
     * @param fn a function that initializes a builder to create the {@link PutTemplateRequest}
     */
    public final CompletableFuture<PutTemplateResponse> putTemplate(
        Function<PutTemplateRequest.Builder, ObjectBuilder<PutTemplateRequest>> fn
    ) throws IOException, OpenSearchException {
        return putTemplate(fn.apply(new PutTemplateRequest.Builder()).build());
    }

    // ----- Endpoint: indices.recovery

    /**
     * Returns information about ongoing index shard recoveries.
     */
    public CompletableFuture<RecoveryResponse> recovery(RecoveryRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, RecoveryRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Returns information about ongoing index shard recoveries.
     *
     * @param fn a function that initializes a builder to create the {@link RecoveryRequest}
     */
    public final CompletableFuture<RecoveryResponse> recovery(Function<RecoveryRequest.Builder, ObjectBuilder<RecoveryRequest>> fn)
        throws IOException, OpenSearchException {
        return recovery(fn.apply(new RecoveryRequest.Builder()).build());
    }

    /**
     * Returns information about ongoing index shard recoveries.
     */
    public final CompletableFuture<RecoveryResponse> recovery() throws IOException, OpenSearchException {
        return recovery(new RecoveryRequest.Builder().build());
    }

    // ----- Endpoint: indices.refresh

    /**
     * Performs the refresh operation in one or more indexes.
     */
    public CompletableFuture<RefreshResponse> refresh(RefreshRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, RefreshRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Performs the refresh operation in one or more indexes.
     *
     * @param fn a function that initializes a builder to create the {@link RefreshRequest}
     */
    public final CompletableFuture<RefreshResponse> refresh(Function<RefreshRequest.Builder, ObjectBuilder<RefreshRequest>> fn)
        throws IOException, OpenSearchException {
        return refresh(fn.apply(new RefreshRequest.Builder()).build());
    }

    /**
     * Performs the refresh operation in one or more indexes.
     */
    public final CompletableFuture<RefreshResponse> refresh() throws IOException, OpenSearchException {
        return refresh(new RefreshRequest.Builder().build());
    }

    // ----- Endpoint: indices.resolve_index

    /**
     * Returns information about any matching indexes, aliases, and data streams.
     */
    public CompletableFuture<ResolveIndexResponse> resolveIndex(ResolveIndexRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, ResolveIndexRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Returns information about any matching indexes, aliases, and data streams.
     *
     * @param fn a function that initializes a builder to create the {@link ResolveIndexRequest}
     */
    public final CompletableFuture<ResolveIndexResponse> resolveIndex(
        Function<ResolveIndexRequest.Builder, ObjectBuilder<ResolveIndexRequest>> fn
    ) throws IOException, OpenSearchException {
        return resolveIndex(fn.apply(new ResolveIndexRequest.Builder()).build());
    }

    // ----- Endpoint: indices.rollover

    /**
     * Updates an alias to point to a new index when the existing index is considered to be too large or too old.
     */
    public CompletableFuture<RolloverResponse> rollover(RolloverRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, RolloverRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Updates an alias to point to a new index when the existing index is considered to be too large or too old.
     *
     * @param fn a function that initializes a builder to create the {@link RolloverRequest}
     */
    public final CompletableFuture<RolloverResponse> rollover(Function<RolloverRequest.Builder, ObjectBuilder<RolloverRequest>> fn)
        throws IOException, OpenSearchException {
        return rollover(fn.apply(new RolloverRequest.Builder()).build());
    }

    // ----- Endpoint: indices.segments

    /**
     * Provides low-level information about segments in a Lucene index.
     */
    public CompletableFuture<SegmentsResponse> segments(SegmentsRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, SegmentsRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Provides low-level information about segments in a Lucene index.
     *
     * @param fn a function that initializes a builder to create the {@link SegmentsRequest}
     */
    public final CompletableFuture<SegmentsResponse> segments(Function<SegmentsRequest.Builder, ObjectBuilder<SegmentsRequest>> fn)
        throws IOException, OpenSearchException {
        return segments(fn.apply(new SegmentsRequest.Builder()).build());
    }

    /**
     * Provides low-level information about segments in a Lucene index.
     */
    public final CompletableFuture<SegmentsResponse> segments() throws IOException, OpenSearchException {
        return segments(new SegmentsRequest.Builder().build());
    }

    // ----- Endpoint: indices.shard_stores

    /**
     * Provides store information for shard copies of indexes.
     */
    public CompletableFuture<ShardStoresResponse> shardStores(ShardStoresRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, ShardStoresRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Provides store information for shard copies of indexes.
     *
     * @param fn a function that initializes a builder to create the {@link ShardStoresRequest}
     */
    public final CompletableFuture<ShardStoresResponse> shardStores(
        Function<ShardStoresRequest.Builder, ObjectBuilder<ShardStoresRequest>> fn
    ) throws IOException, OpenSearchException {
        return shardStores(fn.apply(new ShardStoresRequest.Builder()).build());
    }

    /**
     * Provides store information for shard copies of indexes.
     */
    public final CompletableFuture<ShardStoresResponse> shardStores() throws IOException, OpenSearchException {
        return shardStores(new ShardStoresRequest.Builder().build());
    }

    // ----- Endpoint: indices.shrink

    /**
     * Allow to shrink an existing index into a new index with fewer primary shards.
     */
    public CompletableFuture<ShrinkResponse> shrink(ShrinkRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, ShrinkRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Allow to shrink an existing index into a new index with fewer primary shards.
     *
     * @param fn a function that initializes a builder to create the {@link ShrinkRequest}
     */
    public final CompletableFuture<ShrinkResponse> shrink(Function<ShrinkRequest.Builder, ObjectBuilder<ShrinkRequest>> fn)
        throws IOException, OpenSearchException {
        return shrink(fn.apply(new ShrinkRequest.Builder()).build());
    }

    // ----- Endpoint: indices.simulate_index_template

    /**
     * Simulate matching the given index name against the index templates in the system.
     */
    public CompletableFuture<SimulateIndexTemplateResponse> simulateIndexTemplate(SimulateIndexTemplateRequest request) throws IOException,
        OpenSearchException {
        return this.transport.performRequestAsync(request, SimulateIndexTemplateRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Simulate matching the given index name against the index templates in the system.
     *
     * @param fn a function that initializes a builder to create the {@link SimulateIndexTemplateRequest}
     */
    public final CompletableFuture<SimulateIndexTemplateResponse> simulateIndexTemplate(
        Function<SimulateIndexTemplateRequest.Builder, ObjectBuilder<SimulateIndexTemplateRequest>> fn
    ) throws IOException, OpenSearchException {
        return simulateIndexTemplate(fn.apply(new SimulateIndexTemplateRequest.Builder()).build());
    }

    // ----- Endpoint: indices.simulate_template

    /**
     * Simulate resolving the given template name or body.
     */
    public CompletableFuture<SimulateTemplateResponse> simulateTemplate(SimulateTemplateRequest request) throws IOException,
        OpenSearchException {
        return this.transport.performRequestAsync(request, SimulateTemplateRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Simulate resolving the given template name or body.
     *
     * @param fn a function that initializes a builder to create the {@link SimulateTemplateRequest}
     */
    public final CompletableFuture<SimulateTemplateResponse> simulateTemplate(
        Function<SimulateTemplateRequest.Builder, ObjectBuilder<SimulateTemplateRequest>> fn
    ) throws IOException, OpenSearchException {
        return simulateTemplate(fn.apply(new SimulateTemplateRequest.Builder()).build());
    }

    // ----- Endpoint: indices.update_aliases

    /**
     * Updates index aliases.
     */
    public CompletableFuture<UpdateAliasesResponse> updateAliases(UpdateAliasesRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, UpdateAliasesRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Updates index aliases.
     *
     * @param fn a function that initializes a builder to create the {@link UpdateAliasesRequest}
     */
    public final CompletableFuture<UpdateAliasesResponse> updateAliases(
        Function<UpdateAliasesRequest.Builder, ObjectBuilder<UpdateAliasesRequest>> fn
    ) throws IOException, OpenSearchException {
        return updateAliases(fn.apply(new UpdateAliasesRequest.Builder()).build());
    }

    /**
     * Updates index aliases.
     */
    public final CompletableFuture<UpdateAliasesResponse> updateAliases() throws IOException, OpenSearchException {
        return updateAliases(new UpdateAliasesRequest.Builder().build());
    }
}
