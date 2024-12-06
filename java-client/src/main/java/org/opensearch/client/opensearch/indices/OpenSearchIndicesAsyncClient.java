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

package org.opensearch.client.opensearch.indices;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;
import javax.annotation.Nullable;
import org.opensearch.client.opensearch._types.ErrorResponse;
import org.opensearch.client.opensearch._types.OpenSearchException;
import org.opensearch.client.transport.JsonEndpoint;
import org.opensearch.client.transport.OpenSearchTransport;
import org.opensearch.client.transport.TransportOptions;
import org.opensearch.client.transport.endpoints.BooleanResponse;
import org.opensearch.client.util.ObjectBuilder;

/**
 * Client for the indices namespace.
 */
public class OpenSearchIndicesAsyncClient extends OpenSearchIndicesAsyncClientBase<OpenSearchIndicesAsyncClient> {

    public OpenSearchIndicesAsyncClient(OpenSearchTransport transport) {
        super(transport, null);
    }

    public OpenSearchIndicesAsyncClient(OpenSearchTransport transport, @Nullable TransportOptions transportOptions) {
        super(transport, transportOptions);
    }

    @Override
    public OpenSearchIndicesAsyncClient withTransportOptions(@Nullable TransportOptions transportOptions) {
        return new OpenSearchIndicesAsyncClient(this.transport, transportOptions);
    }

    // ----- Endpoint: indices.add_block

    /**
     * Adds a block to an index.
     *
     *
     */

    public CompletableFuture<AddBlockResponse> addBlock(AddBlockRequest request) throws IOException, OpenSearchException {
        @SuppressWarnings("unchecked")
        JsonEndpoint<AddBlockRequest, AddBlockResponse, ErrorResponse> endpoint = (JsonEndpoint<
            AddBlockRequest,
            AddBlockResponse,
            ErrorResponse>) AddBlockRequest._ENDPOINT;

        return this.transport.performRequestAsync(request, endpoint, this.transportOptions);
    }

    /**
     * Adds a block to an index.
     *
     * @param fn
     *            a function that initializes a builder to create the
     *            {@link AddBlockRequest}
     *
     */

    public final CompletableFuture<AddBlockResponse> addBlock(Function<AddBlockRequest.Builder, ObjectBuilder<AddBlockRequest>> fn)
        throws IOException, OpenSearchException {
        return addBlock(fn.apply(new AddBlockRequest.Builder()).build());
    }

    // ----- Endpoint: indices.analyze

    /**
     * Performs the analysis process on a text and return the tokens breakdown of
     * the text.
     *
     *
     */

    public CompletableFuture<AnalyzeResponse> analyze(AnalyzeRequest request) throws IOException, OpenSearchException {
        @SuppressWarnings("unchecked")
        JsonEndpoint<AnalyzeRequest, AnalyzeResponse, ErrorResponse> endpoint = (JsonEndpoint<
            AnalyzeRequest,
            AnalyzeResponse,
            ErrorResponse>) AnalyzeRequest._ENDPOINT;

        return this.transport.performRequestAsync(request, endpoint, this.transportOptions);
    }

    /**
     * Performs the analysis process on a text and return the tokens breakdown of
     * the text.
     *
     * @param fn
     *            a function that initializes a builder to create the
     *            {@link AnalyzeRequest}
     *
     */

    public final CompletableFuture<AnalyzeResponse> analyze(Function<AnalyzeRequest.Builder, ObjectBuilder<AnalyzeRequest>> fn)
        throws IOException, OpenSearchException {
        return analyze(fn.apply(new AnalyzeRequest.Builder()).build());
    }

    /**
     * Performs the analysis process on a text and return the tokens breakdown of
     * the text.
     *
     *
     */

    public CompletableFuture<AnalyzeResponse> analyze() throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(new AnalyzeRequest.Builder().build(), AnalyzeRequest._ENDPOINT, this.transportOptions);
    }

    // ----- Endpoint: indices.clear_cache

    /**
     * Clears all or specific caches for one or more indices.
     *
     *
     */

    public CompletableFuture<ClearCacheResponse> clearCache(ClearCacheRequest request) throws IOException, OpenSearchException {
        @SuppressWarnings("unchecked")
        JsonEndpoint<ClearCacheRequest, ClearCacheResponse, ErrorResponse> endpoint = (JsonEndpoint<
            ClearCacheRequest,
            ClearCacheResponse,
            ErrorResponse>) ClearCacheRequest._ENDPOINT;

        return this.transport.performRequestAsync(request, endpoint, this.transportOptions);
    }

    /**
     * Clears all or specific caches for one or more indices.
     *
     * @param fn
     *            a function that initializes a builder to create the
     *            {@link ClearCacheRequest}
     *
     */

    public final CompletableFuture<ClearCacheResponse> clearCache(Function<ClearCacheRequest.Builder, ObjectBuilder<ClearCacheRequest>> fn)
        throws IOException, OpenSearchException {
        return clearCache(fn.apply(new ClearCacheRequest.Builder()).build());
    }

    /**
     * Clears all or specific caches for one or more indices.
     *
     *
     */

    public CompletableFuture<ClearCacheResponse> clearCache() throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(
            new ClearCacheRequest.Builder().build(),
            ClearCacheRequest._ENDPOINT,
            this.transportOptions
        );
    }

    // ----- Endpoint: indices.clone

    /**
     * Clones an index
     *
     */

    public CompletableFuture<CloneIndexResponse> clone(CloneIndexRequest request) throws IOException, OpenSearchException {
        @SuppressWarnings("unchecked")
        JsonEndpoint<CloneIndexRequest, CloneIndexResponse, ErrorResponse> endpoint = (JsonEndpoint<
            CloneIndexRequest,
            CloneIndexResponse,
            ErrorResponse>) CloneIndexRequest._ENDPOINT;

        return this.transport.performRequestAsync(request, endpoint, this.transportOptions);
    }

    /**
     * Clones an index
     *
     * @param fn
     *            a function that initializes a builder to create the
     *            {@link CloneIndexRequest}
     *
     */

    public final CompletableFuture<CloneIndexResponse> clone(Function<CloneIndexRequest.Builder, ObjectBuilder<CloneIndexRequest>> fn)
        throws IOException, OpenSearchException {
        return clone(fn.apply(new CloneIndexRequest.Builder()).build());
    }

    // ----- Endpoint: indices.close

    /**
     * Closes an index.
     *
     *
     */

    public CompletableFuture<CloseIndexResponse> close(CloseIndexRequest request) throws IOException, OpenSearchException {
        @SuppressWarnings("unchecked")
        JsonEndpoint<CloseIndexRequest, CloseIndexResponse, ErrorResponse> endpoint = (JsonEndpoint<
            CloseIndexRequest,
            CloseIndexResponse,
            ErrorResponse>) CloseIndexRequest._ENDPOINT;

        return this.transport.performRequestAsync(request, endpoint, this.transportOptions);
    }

    /**
     * Closes an index.
     *
     * @param fn
     *            a function that initializes a builder to create the
     *            {@link CloseIndexRequest}
     *
     */

    public final CompletableFuture<CloseIndexResponse> close(Function<CloseIndexRequest.Builder, ObjectBuilder<CloseIndexRequest>> fn)
        throws IOException, OpenSearchException {
        return close(fn.apply(new CloseIndexRequest.Builder()).build());
    }

    // ----- Endpoint: indices.create_data_stream

    /**
     * Creates a data stream
     */

    public CompletableFuture<CreateDataStreamResponse> createDataStream(CreateDataStreamRequest request) throws IOException,
        OpenSearchException {
        @SuppressWarnings("unchecked")
        JsonEndpoint<CreateDataStreamRequest, CreateDataStreamResponse, ErrorResponse> endpoint = (JsonEndpoint<
            CreateDataStreamRequest,
            CreateDataStreamResponse,
            ErrorResponse>) CreateDataStreamRequest._ENDPOINT;

        return this.transport.performRequestAsync(request, endpoint, this.transportOptions);
    }

    /**
     * Creates a data stream
     *
     * @param fn
     * 				a function that initializes a builder to create the {@link CreateDataStreamRequest}
     */

    public CompletableFuture<CreateDataStreamResponse> createDataStream(
        Function<CreateDataStreamRequest.Builder, ObjectBuilder<CreateDataStreamRequest>> fn
    ) throws IOException, OpenSearchException {
        return createDataStream(fn.apply(new CreateDataStreamRequest.Builder()).build());
    }

    // ----- Endpoint: indices.delete_data_stream

    /**
     * Deletes one or more data streams and their backing indices.
     */

    public CompletableFuture<DeleteDataStreamResponse> deleteDataStream(DeleteDataStreamRequest request) throws IOException,
        OpenSearchException {
        @SuppressWarnings("unchecked")
        JsonEndpoint<DeleteDataStreamRequest, DeleteDataStreamResponse, ErrorResponse> endpoint = (JsonEndpoint<
            DeleteDataStreamRequest,
            DeleteDataStreamResponse,
            ErrorResponse>) DeleteDataStreamRequest._ENDPOINT;

        return this.transport.performRequestAsync(request, endpoint, this.transportOptions);
    }

    /**
     * Deletes one or more data streams and their backing indices.
     *
     * @param fn
     *            a function that initializes a builder to create the
     *            {@link DeleteDataStreamRequest}
     *
     */

    public final CompletableFuture<DeleteDataStreamResponse> deleteDataStream(
        Function<DeleteDataStreamRequest.Builder, ObjectBuilder<DeleteDataStreamRequest>> fn
    ) throws IOException, OpenSearchException {
        return deleteDataStream(fn.apply(new DeleteDataStreamRequest.Builder()).build());
    }

    // ----- Endpoint: indices.delete_alias

    /**
     * Deletes an alias.
     *
     *
     */

    public CompletableFuture<DeleteAliasResponse> deleteAlias(DeleteAliasRequest request) throws IOException, OpenSearchException {
        @SuppressWarnings("unchecked")
        JsonEndpoint<DeleteAliasRequest, DeleteAliasResponse, ErrorResponse> endpoint = (JsonEndpoint<
            DeleteAliasRequest,
            DeleteAliasResponse,
            ErrorResponse>) DeleteAliasRequest._ENDPOINT;

        return this.transport.performRequestAsync(request, endpoint, this.transportOptions);
    }

    /**
     * Deletes an alias.
     *
     * @param fn
     *            a function that initializes a builder to create the
     *            {@link DeleteAliasRequest}
     *
     */

    public final CompletableFuture<DeleteAliasResponse> deleteAlias(
        Function<DeleteAliasRequest.Builder, ObjectBuilder<DeleteAliasRequest>> fn
    ) throws IOException, OpenSearchException {
        return deleteAlias(fn.apply(new DeleteAliasRequest.Builder()).build());
    }

    // ----- Endpoint: indices.disk_usage

    /**
     * Analyzes the disk usage of each field of an index or data stream
     *
     *
     */

    public CompletableFuture<DiskUsageResponse> diskUsage(DiskUsageRequest request) throws IOException, OpenSearchException {
        @SuppressWarnings("unchecked")
        JsonEndpoint<DiskUsageRequest, DiskUsageResponse, ErrorResponse> endpoint = (JsonEndpoint<
            DiskUsageRequest,
            DiskUsageResponse,
            ErrorResponse>) DiskUsageRequest._ENDPOINT;

        return this.transport.performRequestAsync(request, endpoint, this.transportOptions);
    }

    /**
     * Analyzes the disk usage of each field of an index or data stream
     *
     * @param fn
     *            a function that initializes a builder to create the
     *            {@link DiskUsageRequest}
     *
     */

    public final CompletableFuture<DiskUsageResponse> diskUsage(Function<DiskUsageRequest.Builder, ObjectBuilder<DiskUsageRequest>> fn)
        throws IOException, OpenSearchException {
        return diskUsage(fn.apply(new DiskUsageRequest.Builder()).build());
    }

    // ----- Endpoint: indices.exists_alias

    /**
     * Returns information about whether a particular alias exists.
     *
     *
     */

    public CompletableFuture<BooleanResponse> existsAlias(ExistsAliasRequest request) throws IOException, OpenSearchException {
        @SuppressWarnings("unchecked")
        JsonEndpoint<ExistsAliasRequest, BooleanResponse, ErrorResponse> endpoint = (JsonEndpoint<
            ExistsAliasRequest,
            BooleanResponse,
            ErrorResponse>) ExistsAliasRequest._ENDPOINT;

        return this.transport.performRequestAsync(request, endpoint, this.transportOptions);
    }

    /**
     * Returns information about whether a particular alias exists.
     *
     * @param fn
     *            a function that initializes a builder to create the
     *            {@link ExistsAliasRequest}
     *
     */

    public final CompletableFuture<BooleanResponse> existsAlias(Function<ExistsAliasRequest.Builder, ObjectBuilder<ExistsAliasRequest>> fn)
        throws IOException, OpenSearchException {
        return existsAlias(fn.apply(new ExistsAliasRequest.Builder()).build());
    }

    // ----- Endpoint: indices.flush

    /**
     * Performs the flush operation on one or more indices.
     *
     *
     */

    public CompletableFuture<FlushResponse> flush(FlushRequest request) throws IOException, OpenSearchException {
        @SuppressWarnings("unchecked")
        JsonEndpoint<FlushRequest, FlushResponse, ErrorResponse> endpoint = (JsonEndpoint<
            FlushRequest,
            FlushResponse,
            ErrorResponse>) FlushRequest._ENDPOINT;

        return this.transport.performRequestAsync(request, endpoint, this.transportOptions);
    }

    /**
     * Performs the flush operation on one or more indices.
     *
     * @param fn
     *            a function that initializes a builder to create the
     *            {@link FlushRequest}
     *
     */

    public final CompletableFuture<FlushResponse> flush(Function<FlushRequest.Builder, ObjectBuilder<FlushRequest>> fn) throws IOException,
        OpenSearchException {
        return flush(fn.apply(new FlushRequest.Builder()).build());
    }

    /**
     * Performs the flush operation on one or more indices.
     *
     *
     */

    public CompletableFuture<FlushResponse> flush() throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(new FlushRequest.Builder().build(), FlushRequest._ENDPOINT, this.transportOptions);
    }

    // ----- Endpoint: indices.forcemerge

    /**
     * Performs the force merge operation on one or more indices.
     *
     *
     */

    public CompletableFuture<ForcemergeResponse> forcemerge(ForcemergeRequest request) throws IOException, OpenSearchException {
        @SuppressWarnings("unchecked")
        JsonEndpoint<ForcemergeRequest, ForcemergeResponse, ErrorResponse> endpoint = (JsonEndpoint<
            ForcemergeRequest,
            ForcemergeResponse,
            ErrorResponse>) ForcemergeRequest._ENDPOINT;

        return this.transport.performRequestAsync(request, endpoint, this.transportOptions);
    }

    /**
     * Performs the force merge operation on one or more indices.
     *
     * @param fn
     *            a function that initializes a builder to create the
     *            {@link ForcemergeRequest}
     *
     */

    public final CompletableFuture<ForcemergeResponse> forcemerge(Function<ForcemergeRequest.Builder, ObjectBuilder<ForcemergeRequest>> fn)
        throws IOException, OpenSearchException {
        return forcemerge(fn.apply(new ForcemergeRequest.Builder()).build());
    }

    /**
     * Performs the force merge operation on one or more indices.
     *
     *
     */

    public CompletableFuture<ForcemergeResponse> forcemerge() throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(
            new ForcemergeRequest.Builder().build(),
            ForcemergeRequest._ENDPOINT,
            this.transportOptions
        );
    }

    // ----- Endpoint: indices.get_data_stream

    /**
     * Returns information about one or more data streams.
     *
     *
     */

    public CompletableFuture<GetDataStreamResponse> getDataStream(GetDataStreamRequest request) throws IOException, OpenSearchException {
        @SuppressWarnings("unchecked")
        JsonEndpoint<GetDataStreamRequest, GetDataStreamResponse, ErrorResponse> endpoint = (JsonEndpoint<
            GetDataStreamRequest,
            GetDataStreamResponse,
            ErrorResponse>) GetDataStreamRequest._ENDPOINT;

        return this.transport.performRequestAsync(request, endpoint, this.transportOptions);
    }

    /**
     * Returns information about one or more data streams.
     *
     * @param fn
     *            a function that initializes a builder to create the
     *            {@link GetDataStreamRequest}
     *
     */

    public final CompletableFuture<GetDataStreamResponse> getDataStream(
        Function<GetDataStreamRequest.Builder, ObjectBuilder<GetDataStreamRequest>> fn
    ) throws IOException, OpenSearchException {
        return getDataStream(fn.apply(new GetDataStreamRequest.Builder()).build());
    }

    /**
     * Returns information about one or more data streams.
     *
     *
     */

    public CompletableFuture<GetDataStreamResponse> getDataStream() throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(
            new GetDataStreamRequest.Builder().build(),
            GetDataStreamRequest._ENDPOINT,
            this.transportOptions
        );
    }

    // ----- Endpoint: indices.get_alias

    /**
     * Returns an alias.
     *
     *
     */

    public CompletableFuture<GetAliasResponse> getAlias(GetAliasRequest request) throws IOException, OpenSearchException {
        @SuppressWarnings("unchecked")
        JsonEndpoint<GetAliasRequest, GetAliasResponse, ErrorResponse> endpoint = (JsonEndpoint<
            GetAliasRequest,
            GetAliasResponse,
            ErrorResponse>) GetAliasRequest._ENDPOINT;

        return this.transport.performRequestAsync(request, endpoint, this.transportOptions);
    }

    /**
     * Returns an alias.
     *
     * @param fn
     *            a function that initializes a builder to create the
     *            {@link GetAliasRequest}
     *
     */

    public final CompletableFuture<GetAliasResponse> getAlias(Function<GetAliasRequest.Builder, ObjectBuilder<GetAliasRequest>> fn)
        throws IOException, OpenSearchException {
        return getAlias(fn.apply(new GetAliasRequest.Builder()).build());
    }

    /**
     * Returns an alias.
     *
     *
     */

    public CompletableFuture<GetAliasResponse> getAlias() throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(new GetAliasRequest.Builder().build(), GetAliasRequest._ENDPOINT, this.transportOptions);
    }

    // ----- Endpoint: indices.get_field_mapping

    /**
     * Returns mapping for one or more fields.
     *
     *
     */

    public CompletableFuture<GetFieldMappingResponse> getFieldMapping(GetFieldMappingRequest request) throws IOException,
        OpenSearchException {
        @SuppressWarnings("unchecked")
        JsonEndpoint<GetFieldMappingRequest, GetFieldMappingResponse, ErrorResponse> endpoint = (JsonEndpoint<
            GetFieldMappingRequest,
            GetFieldMappingResponse,
            ErrorResponse>) GetFieldMappingRequest._ENDPOINT;

        return this.transport.performRequestAsync(request, endpoint, this.transportOptions);
    }

    /**
     * Returns mapping for one or more fields.
     *
     * @param fn
     *            a function that initializes a builder to create the
     *            {@link GetFieldMappingRequest}
     *
     */

    public final CompletableFuture<GetFieldMappingResponse> getFieldMapping(
        Function<GetFieldMappingRequest.Builder, ObjectBuilder<GetFieldMappingRequest>> fn
    ) throws IOException, OpenSearchException {
        return getFieldMapping(fn.apply(new GetFieldMappingRequest.Builder()).build());
    }

    // ----- Endpoint: indices.get_mapping

    /**
     * Returns mappings for one or more indices.
     *
     *
     */

    public CompletableFuture<GetMappingResponse> getMapping(GetMappingRequest request) throws IOException, OpenSearchException {
        @SuppressWarnings("unchecked")
        JsonEndpoint<GetMappingRequest, GetMappingResponse, ErrorResponse> endpoint = (JsonEndpoint<
            GetMappingRequest,
            GetMappingResponse,
            ErrorResponse>) GetMappingRequest._ENDPOINT;

        return this.transport.performRequestAsync(request, endpoint, this.transportOptions);
    }

    /**
     * Returns mappings for one or more indices.
     *
     * @param fn
     *            a function that initializes a builder to create the
     *            {@link GetMappingRequest}
     *
     */

    public final CompletableFuture<GetMappingResponse> getMapping(Function<GetMappingRequest.Builder, ObjectBuilder<GetMappingRequest>> fn)
        throws IOException, OpenSearchException {
        return getMapping(fn.apply(new GetMappingRequest.Builder()).build());
    }

    /**
     * Returns mappings for one or more indices.
     *
     *
     */

    public CompletableFuture<GetMappingResponse> getMapping() throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(
            new GetMappingRequest.Builder().build(),
            GetMappingRequest._ENDPOINT,
            this.transportOptions
        );
    }

    // ----- Endpoint: indices.get_upgrade

    /**
     * DEPRECATED Returns a progress status of current upgrade.
     *
     *
     */

    public CompletableFuture<GetUpgradeResponse> getUpgrade(GetUpgradeRequest request) throws IOException, OpenSearchException {
        @SuppressWarnings("unchecked")
        JsonEndpoint<GetUpgradeRequest, GetUpgradeResponse, ErrorResponse> endpoint = (JsonEndpoint<
            GetUpgradeRequest,
            GetUpgradeResponse,
            ErrorResponse>) GetUpgradeRequest._ENDPOINT;

        return this.transport.performRequestAsync(request, endpoint, this.transportOptions);
    }

    /**
     * DEPRECATED Returns a progress status of current upgrade.
     *
     * @param fn
     *            a function that initializes a builder to create the
     *            {@link GetUpgradeRequest}
     *
     */

    public final CompletableFuture<GetUpgradeResponse> getUpgrade(Function<GetUpgradeRequest.Builder, ObjectBuilder<GetUpgradeRequest>> fn)
        throws IOException, OpenSearchException {
        return getUpgrade(fn.apply(new GetUpgradeRequest.Builder()).build());
    }

    /**
     * DEPRECATED Returns a progress status of current upgrade.
     *
     *
     */

    public CompletableFuture<GetUpgradeResponse> getUpgrade() throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(
            new GetUpgradeRequest.Builder().build(),
            GetUpgradeRequest._ENDPOINT,
            this.transportOptions
        );
    }

    // ----- Endpoint: indices.open

    /**
     * Opens an index.
     *
     *
     */

    public CompletableFuture<OpenResponse> open(OpenRequest request) throws IOException, OpenSearchException {
        @SuppressWarnings("unchecked")
        JsonEndpoint<OpenRequest, OpenResponse, ErrorResponse> endpoint = (JsonEndpoint<
            OpenRequest,
            OpenResponse,
            ErrorResponse>) OpenRequest._ENDPOINT;

        return this.transport.performRequestAsync(request, endpoint, this.transportOptions);
    }

    /**
     * Opens an index.
     *
     * @param fn
     *            a function that initializes a builder to create the
     *            {@link OpenRequest}
     *
     */

    public final CompletableFuture<OpenResponse> open(Function<OpenRequest.Builder, ObjectBuilder<OpenRequest>> fn) throws IOException,
        OpenSearchException {
        return open(fn.apply(new OpenRequest.Builder()).build());
    }

    // ----- Endpoint: indices.put_alias

    /**
     * Creates or updates an alias.
     *
     *
     */

    public CompletableFuture<PutAliasResponse> putAlias(PutAliasRequest request) throws IOException, OpenSearchException {
        @SuppressWarnings("unchecked")
        JsonEndpoint<PutAliasRequest, PutAliasResponse, ErrorResponse> endpoint = (JsonEndpoint<
            PutAliasRequest,
            PutAliasResponse,
            ErrorResponse>) PutAliasRequest._ENDPOINT;

        return this.transport.performRequestAsync(request, endpoint, this.transportOptions);
    }

    /**
     * Creates or updates an alias.
     *
     * @param fn
     *            a function that initializes a builder to create the
     *            {@link PutAliasRequest}
     *
     */

    public final CompletableFuture<PutAliasResponse> putAlias(Function<PutAliasRequest.Builder, ObjectBuilder<PutAliasRequest>> fn)
        throws IOException, OpenSearchException {
        return putAlias(fn.apply(new PutAliasRequest.Builder()).build());
    }

    // ----- Endpoint: indices.put_mapping

    /**
     * Updates the index mappings.
     *
     *
     */

    public CompletableFuture<PutMappingResponse> putMapping(PutMappingRequest request) throws IOException, OpenSearchException {
        @SuppressWarnings("unchecked")
        JsonEndpoint<PutMappingRequest, PutMappingResponse, ErrorResponse> endpoint = (JsonEndpoint<
            PutMappingRequest,
            PutMappingResponse,
            ErrorResponse>) PutMappingRequest._ENDPOINT;

        return this.transport.performRequestAsync(request, endpoint, this.transportOptions);
    }

    /**
     * Updates the index mappings.
     *
     * @param fn
     *            a function that initializes a builder to create the
     *            {@link PutMappingRequest}
     *
     */

    public final CompletableFuture<PutMappingResponse> putMapping(Function<PutMappingRequest.Builder, ObjectBuilder<PutMappingRequest>> fn)
        throws IOException, OpenSearchException {
        return putMapping(fn.apply(new PutMappingRequest.Builder()).build());
    }

    // ----- Endpoint: indices.put_settings

    /**
     * Updates the index settings.
     *
     *
     */

    public CompletableFuture<PutIndicesSettingsResponse> putSettings(PutIndicesSettingsRequest request) throws IOException,
        OpenSearchException {
        @SuppressWarnings("unchecked")
        JsonEndpoint<PutIndicesSettingsRequest, PutIndicesSettingsResponse, ErrorResponse> endpoint = (JsonEndpoint<
            PutIndicesSettingsRequest,
            PutIndicesSettingsResponse,
            ErrorResponse>) PutIndicesSettingsRequest._ENDPOINT;

        return this.transport.performRequestAsync(request, endpoint, this.transportOptions);
    }

    /**
     * Updates the index settings.
     *
     * @param fn
     *            a function that initializes a builder to create the
     *            {@link PutIndicesSettingsRequest}
     *
     */

    public final CompletableFuture<PutIndicesSettingsResponse> putSettings(
        Function<PutIndicesSettingsRequest.Builder, ObjectBuilder<PutIndicesSettingsRequest>> fn
    ) throws IOException, OpenSearchException {
        return putSettings(fn.apply(new PutIndicesSettingsRequest.Builder()).build());
    }

    /**
     * Updates the index settings.
     *
     *
     */

    public CompletableFuture<PutIndicesSettingsResponse> putSettings() throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(
            new PutIndicesSettingsRequest.Builder().build(),
            PutIndicesSettingsRequest._ENDPOINT,
            this.transportOptions
        );
    }

    // ----- Endpoint: indices.recovery

    /**
     * Returns information about ongoing index shard recoveries.
     *
     *
     */

    public CompletableFuture<RecoveryResponse> recovery(RecoveryRequest request) throws IOException, OpenSearchException {
        @SuppressWarnings("unchecked")
        JsonEndpoint<RecoveryRequest, RecoveryResponse, ErrorResponse> endpoint = (JsonEndpoint<
            RecoveryRequest,
            RecoveryResponse,
            ErrorResponse>) RecoveryRequest._ENDPOINT;

        return this.transport.performRequestAsync(request, endpoint, this.transportOptions);
    }

    /**
     * Returns information about ongoing index shard recoveries.
     *
     * @param fn
     *            a function that initializes a builder to create the
     *            {@link RecoveryRequest}
     *
     */

    public final CompletableFuture<RecoveryResponse> recovery(Function<RecoveryRequest.Builder, ObjectBuilder<RecoveryRequest>> fn)
        throws IOException, OpenSearchException {
        return recovery(fn.apply(new RecoveryRequest.Builder()).build());
    }

    /**
     * Returns information about ongoing index shard recoveries.
     *
     *
     */

    public CompletableFuture<RecoveryResponse> recovery() throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(new RecoveryRequest.Builder().build(), RecoveryRequest._ENDPOINT, this.transportOptions);
    }

    // ----- Endpoint: indices.refresh

    /**
     * Performs the refresh operation in one or more indices.
     *
     *
     */

    public CompletableFuture<RefreshResponse> refresh(RefreshRequest request) throws IOException, OpenSearchException {
        @SuppressWarnings("unchecked")
        JsonEndpoint<RefreshRequest, RefreshResponse, ErrorResponse> endpoint = (JsonEndpoint<
            RefreshRequest,
            RefreshResponse,
            ErrorResponse>) RefreshRequest._ENDPOINT;

        return this.transport.performRequestAsync(request, endpoint, this.transportOptions);
    }

    /**
     * Performs the refresh operation in one or more indices.
     *
     * @param fn
     *            a function that initializes a builder to create the
     *            {@link RefreshRequest}
     *
     */

    public final CompletableFuture<RefreshResponse> refresh(Function<RefreshRequest.Builder, ObjectBuilder<RefreshRequest>> fn)
        throws IOException, OpenSearchException {
        return refresh(fn.apply(new RefreshRequest.Builder()).build());
    }

    /**
     * Performs the refresh operation in one or more indices.
     *
     *
     */

    public CompletableFuture<RefreshResponse> refresh() throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(new RefreshRequest.Builder().build(), RefreshRequest._ENDPOINT, this.transportOptions);
    }

    // ----- Endpoint: indices.resolve_index

    /**
     * Returns information about any matching indices, aliases, and data streams
     *
     *
     */

    public CompletableFuture<ResolveIndexResponse> resolveIndex(ResolveIndexRequest request) throws IOException, OpenSearchException {
        @SuppressWarnings("unchecked")
        JsonEndpoint<ResolveIndexRequest, ResolveIndexResponse, ErrorResponse> endpoint = (JsonEndpoint<
            ResolveIndexRequest,
            ResolveIndexResponse,
            ErrorResponse>) ResolveIndexRequest._ENDPOINT;

        return this.transport.performRequestAsync(request, endpoint, this.transportOptions);
    }

    /**
     * Returns information about any matching indices, aliases, and data streams
     *
     * @param fn
     *            a function that initializes a builder to create the
     *            {@link ResolveIndexRequest}
     *
     */

    public final CompletableFuture<ResolveIndexResponse> resolveIndex(
        Function<ResolveIndexRequest.Builder, ObjectBuilder<ResolveIndexRequest>> fn
    ) throws IOException, OpenSearchException {
        return resolveIndex(fn.apply(new ResolveIndexRequest.Builder()).build());
    }

    // ----- Endpoint: indices.rollover

    /**
     * Updates an alias to point to a new index when the existing index is
     * considered to be too large or too old.
     *
     *
     */

    public CompletableFuture<RolloverResponse> rollover(RolloverRequest request) throws IOException, OpenSearchException {
        @SuppressWarnings("unchecked")
        JsonEndpoint<RolloverRequest, RolloverResponse, ErrorResponse> endpoint = (JsonEndpoint<
            RolloverRequest,
            RolloverResponse,
            ErrorResponse>) RolloverRequest._ENDPOINT;

        return this.transport.performRequestAsync(request, endpoint, this.transportOptions);
    }

    /**
     * Updates an alias to point to a new index when the existing index is
     * considered to be too large or too old.
     *
     * @param fn
     *            a function that initializes a builder to create the
     *            {@link RolloverRequest}
     *
     */

    public final CompletableFuture<RolloverResponse> rollover(Function<RolloverRequest.Builder, ObjectBuilder<RolloverRequest>> fn)
        throws IOException, OpenSearchException {
        return rollover(fn.apply(new RolloverRequest.Builder()).build());
    }

    // ----- Endpoint: indices.segments

    /**
     * Provides low-level information about segments in a Lucene index.
     *
     *
     */

    public CompletableFuture<SegmentsResponse> segments(SegmentsRequest request) throws IOException, OpenSearchException {
        @SuppressWarnings("unchecked")
        JsonEndpoint<SegmentsRequest, SegmentsResponse, ErrorResponse> endpoint = (JsonEndpoint<
            SegmentsRequest,
            SegmentsResponse,
            ErrorResponse>) SegmentsRequest._ENDPOINT;

        return this.transport.performRequestAsync(request, endpoint, this.transportOptions);
    }

    /**
     * Provides low-level information about segments in a Lucene index.
     *
     * @param fn
     *            a function that initializes a builder to create the
     *            {@link SegmentsRequest}
     *
     */

    public final CompletableFuture<SegmentsResponse> segments(Function<SegmentsRequest.Builder, ObjectBuilder<SegmentsRequest>> fn)
        throws IOException, OpenSearchException {
        return segments(fn.apply(new SegmentsRequest.Builder()).build());
    }

    /**
     * Provides low-level information about segments in a Lucene index.
     *
     *
     */

    public CompletableFuture<SegmentsResponse> segments() throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(new SegmentsRequest.Builder().build(), SegmentsRequest._ENDPOINT, this.transportOptions);
    }

    // ----- Endpoint: indices.shard_stores

    /**
     * Provides store information for shard copies of indices.
     *
     *
     */

    public CompletableFuture<ShardStoresResponse> shardStores(ShardStoresRequest request) throws IOException, OpenSearchException {
        @SuppressWarnings("unchecked")
        JsonEndpoint<ShardStoresRequest, ShardStoresResponse, ErrorResponse> endpoint = (JsonEndpoint<
            ShardStoresRequest,
            ShardStoresResponse,
            ErrorResponse>) ShardStoresRequest._ENDPOINT;

        return this.transport.performRequestAsync(request, endpoint, this.transportOptions);
    }

    /**
     * Provides store information for shard copies of indices.
     *
     * @param fn
     *            a function that initializes a builder to create the
     *            {@link ShardStoresRequest}
     *
     */

    public final CompletableFuture<ShardStoresResponse> shardStores(
        Function<ShardStoresRequest.Builder, ObjectBuilder<ShardStoresRequest>> fn
    ) throws IOException, OpenSearchException {
        return shardStores(fn.apply(new ShardStoresRequest.Builder()).build());
    }

    /**
     * Provides store information for shard copies of indices.
     *
     *
     */

    public CompletableFuture<ShardStoresResponse> shardStores() throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(
            new ShardStoresRequest.Builder().build(),
            ShardStoresRequest._ENDPOINT,
            this.transportOptions
        );
    }

    // ----- Endpoint: indices.shrink

    /**
     * Allow to shrink an existing index into a new index with fewer primary shards.
     *
     *
     */

    public CompletableFuture<ShrinkResponse> shrink(ShrinkRequest request) throws IOException, OpenSearchException {
        @SuppressWarnings("unchecked")
        JsonEndpoint<ShrinkRequest, ShrinkResponse, ErrorResponse> endpoint = (JsonEndpoint<
            ShrinkRequest,
            ShrinkResponse,
            ErrorResponse>) ShrinkRequest._ENDPOINT;

        return this.transport.performRequestAsync(request, endpoint, this.transportOptions);
    }

    /**
     * Allow to shrink an existing index into a new index with fewer primary shards.
     *
     * @param fn
     *            a function that initializes a builder to create the
     *            {@link ShrinkRequest}
     *
     */

    public final CompletableFuture<ShrinkResponse> shrink(Function<ShrinkRequest.Builder, ObjectBuilder<ShrinkRequest>> fn)
        throws IOException, OpenSearchException {
        return shrink(fn.apply(new ShrinkRequest.Builder()).build());
    }

    // ----- Endpoint: indices.split

    /**
     * Allows you to split an existing index into a new index with more primary
     * shards.
     *
     *
     */

    public CompletableFuture<SplitResponse> split(SplitRequest request) throws IOException, OpenSearchException {
        @SuppressWarnings("unchecked")
        JsonEndpoint<SplitRequest, SplitResponse, ErrorResponse> endpoint = (JsonEndpoint<
            SplitRequest,
            SplitResponse,
            ErrorResponse>) SplitRequest._ENDPOINT;

        return this.transport.performRequestAsync(request, endpoint, this.transportOptions);
    }

    /**
     * Allows you to split an existing index into a new index with more primary
     * shards.
     *
     * @param fn
     *            a function that initializes a builder to create the
     *            {@link SplitRequest}
     *
     */

    public final CompletableFuture<SplitResponse> split(Function<SplitRequest.Builder, ObjectBuilder<SplitRequest>> fn) throws IOException,
        OpenSearchException {
        return split(fn.apply(new SplitRequest.Builder()).build());
    }

    // ----- Endpoint: indices.stats

    /**
     * Provides statistics on operations happening in an index.
     *
     *
     */

    public CompletableFuture<IndicesStatsResponse> stats(IndicesStatsRequest request) throws IOException, OpenSearchException {
        @SuppressWarnings("unchecked")
        JsonEndpoint<IndicesStatsRequest, IndicesStatsResponse, ErrorResponse> endpoint = (JsonEndpoint<
            IndicesStatsRequest,
            IndicesStatsResponse,
            ErrorResponse>) IndicesStatsRequest._ENDPOINT;

        return this.transport.performRequestAsync(request, endpoint, this.transportOptions);
    }

    /**
     * Provides statistics on operations happening in an index.
     *
     * @param fn
     *            a function that initializes a builder to create the
     *            {@link IndicesStatsRequest}
     *
     */

    public final CompletableFuture<IndicesStatsResponse> stats(Function<IndicesStatsRequest.Builder, ObjectBuilder<IndicesStatsRequest>> fn)
        throws IOException, OpenSearchException {
        return stats(fn.apply(new IndicesStatsRequest.Builder()).build());
    }

    /**
     * Provides statistics on operations happening in an index.
     *
     *
     */

    public CompletableFuture<IndicesStatsResponse> stats() throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(
            new IndicesStatsRequest.Builder().build(),
            IndicesStatsRequest._ENDPOINT,
            this.transportOptions
        );
    }

    // ----- Endpoint: indices.data_streams_stats

    /**
     * Returns statistics of data streams
     *
     *
     */

    public CompletableFuture<DataStreamsStatsResponse> dataStreamsStats(DataStreamsStatsRequest request) throws IOException,
        OpenSearchException {
        @SuppressWarnings("unchecked")
        JsonEndpoint<DataStreamsStatsRequest, DataStreamsStatsResponse, ErrorResponse> endpoint = (JsonEndpoint<
            DataStreamsStatsRequest,
            DataStreamsStatsResponse,
            ErrorResponse>) DataStreamsStatsRequest._ENDPOINT;

        return this.transport.performRequestAsync(request, endpoint, this.transportOptions);
    }

    /**
     * Returns statistics of data streams
     *
     * @param fn
     *            a function that initializes a builder to create the
     *            {@link DataStreamsStatsRequest}
     *
     */

    public final CompletableFuture<DataStreamsStatsResponse> dataStreamsStats(
        Function<DataStreamsStatsRequest.Builder, ObjectBuilder<DataStreamsStatsRequest>> fn
    ) throws IOException, OpenSearchException {
        return dataStreamsStats(fn.apply(new DataStreamsStatsRequest.Builder()).build());
    }

    /**
     * Returns statistics of data streams
     *
     *
     */

    public CompletableFuture<DataStreamsStatsResponse> dataStreamsStats() throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(
            new DataStreamsStatsRequest.Builder().build(),
            DataStreamsStatsRequest._ENDPOINT,
            this.transportOptions
        );
    }

    // ----- Endpoint: indices.update_aliases

    /**
     * Updates index aliases.
     *
     *
     */

    public CompletableFuture<UpdateAliasesResponse> updateAliases(UpdateAliasesRequest request) throws IOException, OpenSearchException {
        @SuppressWarnings("unchecked")
        JsonEndpoint<UpdateAliasesRequest, UpdateAliasesResponse, ErrorResponse> endpoint = (JsonEndpoint<
            UpdateAliasesRequest,
            UpdateAliasesResponse,
            ErrorResponse>) UpdateAliasesRequest._ENDPOINT;

        return this.transport.performRequestAsync(request, endpoint, this.transportOptions);
    }

    /**
     * Updates index aliases.
     *
     * @param fn
     *            a function that initializes a builder to create the
     *            {@link UpdateAliasesRequest}
     *
     */

    public final CompletableFuture<UpdateAliasesResponse> updateAliases(
        Function<UpdateAliasesRequest.Builder, ObjectBuilder<UpdateAliasesRequest>> fn
    ) throws IOException, OpenSearchException {
        return updateAliases(fn.apply(new UpdateAliasesRequest.Builder()).build());
    }

    /**
     * Updates index aliases.
     *
     *
     */

    public CompletableFuture<UpdateAliasesResponse> updateAliases() throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(
            new UpdateAliasesRequest.Builder().build(),
            UpdateAliasesRequest._ENDPOINT,
            this.transportOptions
        );
    }

    // ----- Endpoint: indices.upgrade

    /**
     * DEPRECATED Upgrades to the current version of Lucene.
     *
     *
     */

    public CompletableFuture<UpgradeResponse> upgrade(UpgradeRequest request) throws IOException, OpenSearchException {
        @SuppressWarnings("unchecked")
        JsonEndpoint<UpgradeRequest, UpgradeResponse, ErrorResponse> endpoint = (JsonEndpoint<
            UpgradeRequest,
            UpgradeResponse,
            ErrorResponse>) UpgradeRequest._ENDPOINT;

        return this.transport.performRequestAsync(request, endpoint, this.transportOptions);
    }

    /**
     * DEPRECATED Upgrades to the current version of Lucene.
     *
     * @param fn
     *            a function that initializes a builder to create the
     *            {@link UpgradeRequest}
     *
     */

    public final CompletableFuture<UpgradeResponse> upgrade(Function<UpgradeRequest.Builder, ObjectBuilder<UpgradeRequest>> fn)
        throws IOException, OpenSearchException {
        return upgrade(fn.apply(new UpgradeRequest.Builder()).build());
    }

    /**
     * DEPRECATED Upgrades to the current version of Lucene.
     *
     *
     */

    public CompletableFuture<UpgradeResponse> upgrade() throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(new UpgradeRequest.Builder().build(), UpgradeRequest._ENDPOINT, this.transportOptions);
    }

    // ----- Endpoint: indices.validate_query

    /**
     * Allows a user to validate a potentially expensive query without executing it.
     *
     *
     */

    public CompletableFuture<ValidateQueryResponse> validateQuery(ValidateQueryRequest request) throws IOException, OpenSearchException {
        @SuppressWarnings("unchecked")
        JsonEndpoint<ValidateQueryRequest, ValidateQueryResponse, ErrorResponse> endpoint = (JsonEndpoint<
            ValidateQueryRequest,
            ValidateQueryResponse,
            ErrorResponse>) ValidateQueryRequest._ENDPOINT;

        return this.transport.performRequestAsync(request, endpoint, this.transportOptions);
    }

    /**
     * Allows a user to validate a potentially expensive query without executing it.
     *
     * @param fn
     *            a function that initializes a builder to create the
     *            {@link ValidateQueryRequest}
     *
     */

    public final CompletableFuture<ValidateQueryResponse> validateQuery(
        Function<ValidateQueryRequest.Builder, ObjectBuilder<ValidateQueryRequest>> fn
    ) throws IOException, OpenSearchException {
        return validateQuery(fn.apply(new ValidateQueryRequest.Builder()).build());
    }

    /**
     * Allows a user to validate a potentially expensive query without executing it.
     *
     *
     */

    public CompletableFuture<ValidateQueryResponse> validateQuery() throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(
            new ValidateQueryRequest.Builder().build(),
            ValidateQueryRequest._ENDPOINT,
            this.transportOptions
        );
    }

}
