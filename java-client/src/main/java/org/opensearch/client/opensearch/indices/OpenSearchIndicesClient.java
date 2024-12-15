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
import java.util.function.Function;
import javax.annotation.Nullable;
import org.opensearch.client.opensearch._types.ErrorResponse;
import org.opensearch.client.opensearch._types.OpenSearchException;
import org.opensearch.client.transport.JsonEndpoint;
import org.opensearch.client.transport.OpenSearchTransport;
import org.opensearch.client.transport.TransportOptions;
import org.opensearch.client.util.ObjectBuilder;

/**
 * Client for the indices namespace.
 */
public class OpenSearchIndicesClient extends OpenSearchIndicesClientBase<OpenSearchIndicesClient> {

    public OpenSearchIndicesClient(OpenSearchTransport transport) {
        super(transport, null);
    }

    public OpenSearchIndicesClient(OpenSearchTransport transport, @Nullable TransportOptions transportOptions) {
        super(transport, transportOptions);
    }

    @Override
    public OpenSearchIndicesClient withTransportOptions(@Nullable TransportOptions transportOptions) {
        return new OpenSearchIndicesClient(this.transport, transportOptions);
    }

    // ----- Endpoint: indices.close

    /**
     * Closes an index.
     *
     *
     */

    public CloseIndexResponse close(CloseIndexRequest request) throws IOException, OpenSearchException {
        @SuppressWarnings("unchecked")
        JsonEndpoint<CloseIndexRequest, CloseIndexResponse, ErrorResponse> endpoint = (JsonEndpoint<
            CloseIndexRequest,
            CloseIndexResponse,
            ErrorResponse>) CloseIndexRequest._ENDPOINT;

        return this.transport.performRequest(request, endpoint, this.transportOptions);
    }

    /**
     * Closes an index.
     *
     * @param fn
     *            a function that initializes a builder to create the
     *            {@link CloseIndexRequest}
     *
     */

    public final CloseIndexResponse close(Function<CloseIndexRequest.Builder, ObjectBuilder<CloseIndexRequest>> fn) throws IOException,
        OpenSearchException {
        return close(fn.apply(new CloseIndexRequest.Builder()).build());
    }

    // ----- Endpoint: indices.flush

    /**
     * Performs the flush operation on one or more indices.
     *
     *
     */

    public FlushResponse flush(FlushRequest request) throws IOException, OpenSearchException {
        @SuppressWarnings("unchecked")
        JsonEndpoint<FlushRequest, FlushResponse, ErrorResponse> endpoint = (JsonEndpoint<
            FlushRequest,
            FlushResponse,
            ErrorResponse>) FlushRequest._ENDPOINT;

        return this.transport.performRequest(request, endpoint, this.transportOptions);
    }

    /**
     * Performs the flush operation on one or more indices.
     *
     * @param fn
     *            a function that initializes a builder to create the
     *            {@link FlushRequest}
     *
     */

    public final FlushResponse flush(Function<FlushRequest.Builder, ObjectBuilder<FlushRequest>> fn) throws IOException,
        OpenSearchException {
        return flush(fn.apply(new FlushRequest.Builder()).build());
    }

    /**
     * Performs the flush operation on one or more indices.
     *
     *
     */

    public FlushResponse flush() throws IOException, OpenSearchException {
        return this.transport.performRequest(new FlushRequest.Builder().build(), FlushRequest._ENDPOINT, this.transportOptions);
    }

    // ----- Endpoint: indices.forcemerge

    /**
     * Performs the force merge operation on one or more indices.
     *
     *
     */

    public ForcemergeResponse forcemerge(ForcemergeRequest request) throws IOException, OpenSearchException {
        @SuppressWarnings("unchecked")
        JsonEndpoint<ForcemergeRequest, ForcemergeResponse, ErrorResponse> endpoint = (JsonEndpoint<
            ForcemergeRequest,
            ForcemergeResponse,
            ErrorResponse>) ForcemergeRequest._ENDPOINT;

        return this.transport.performRequest(request, endpoint, this.transportOptions);
    }

    /**
     * Performs the force merge operation on one or more indices.
     *
     * @param fn
     *            a function that initializes a builder to create the
     *            {@link ForcemergeRequest}
     *
     */

    public final ForcemergeResponse forcemerge(Function<ForcemergeRequest.Builder, ObjectBuilder<ForcemergeRequest>> fn) throws IOException,
        OpenSearchException {
        return forcemerge(fn.apply(new ForcemergeRequest.Builder()).build());
    }

    /**
     * Performs the force merge operation on one or more indices.
     *
     *
     */

    public ForcemergeResponse forcemerge() throws IOException, OpenSearchException {
        return this.transport.performRequest(new ForcemergeRequest.Builder().build(), ForcemergeRequest._ENDPOINT, this.transportOptions);
    }

    // ----- Endpoint: indices.get_field_mapping

    /**
     * Returns mapping for one or more fields.
     *
     *
     */

    public GetFieldMappingResponse getFieldMapping(GetFieldMappingRequest request) throws IOException, OpenSearchException {
        @SuppressWarnings("unchecked")
        JsonEndpoint<GetFieldMappingRequest, GetFieldMappingResponse, ErrorResponse> endpoint = (JsonEndpoint<
            GetFieldMappingRequest,
            GetFieldMappingResponse,
            ErrorResponse>) GetFieldMappingRequest._ENDPOINT;

        return this.transport.performRequest(request, endpoint, this.transportOptions);
    }

    /**
     * Returns mapping for one or more fields.
     *
     * @param fn
     *            a function that initializes a builder to create the
     *            {@link GetFieldMappingRequest}
     *
     */

    public final GetFieldMappingResponse getFieldMapping(Function<GetFieldMappingRequest.Builder, ObjectBuilder<GetFieldMappingRequest>> fn)
        throws IOException, OpenSearchException {
        return getFieldMapping(fn.apply(new GetFieldMappingRequest.Builder()).build());
    }

    // ----- Endpoint: indices.get_upgrade

    /**
     * DEPRECATED Returns a progress status of current upgrade.
     *
     *
     */

    public GetUpgradeResponse getUpgrade(GetUpgradeRequest request) throws IOException, OpenSearchException {
        @SuppressWarnings("unchecked")
        JsonEndpoint<GetUpgradeRequest, GetUpgradeResponse, ErrorResponse> endpoint = (JsonEndpoint<
            GetUpgradeRequest,
            GetUpgradeResponse,
            ErrorResponse>) GetUpgradeRequest._ENDPOINT;

        return this.transport.performRequest(request, endpoint, this.transportOptions);
    }

    /**
     * DEPRECATED Returns a progress status of current upgrade.
     *
     * @param fn
     *            a function that initializes a builder to create the
     *            {@link GetUpgradeRequest}
     *
     */

    public final GetUpgradeResponse getUpgrade(Function<GetUpgradeRequest.Builder, ObjectBuilder<GetUpgradeRequest>> fn) throws IOException,
        OpenSearchException {
        return getUpgrade(fn.apply(new GetUpgradeRequest.Builder()).build());
    }

    /**
     * DEPRECATED Returns a progress status of current upgrade.
     *
     *
     */

    public GetUpgradeResponse getUpgrade() throws IOException, OpenSearchException {
        return this.transport.performRequest(new GetUpgradeRequest.Builder().build(), GetUpgradeRequest._ENDPOINT, this.transportOptions);
    }

    // ----- Endpoint: indices.open

    /**
     * Opens an index.
     *
     *
     */

    public OpenResponse open(OpenRequest request) throws IOException, OpenSearchException {
        @SuppressWarnings("unchecked")
        JsonEndpoint<OpenRequest, OpenResponse, ErrorResponse> endpoint = (JsonEndpoint<
            OpenRequest,
            OpenResponse,
            ErrorResponse>) OpenRequest._ENDPOINT;

        return this.transport.performRequest(request, endpoint, this.transportOptions);
    }

    /**
     * Opens an index.
     *
     * @param fn
     *            a function that initializes a builder to create the
     *            {@link OpenRequest}
     *
     */

    public final OpenResponse open(Function<OpenRequest.Builder, ObjectBuilder<OpenRequest>> fn) throws IOException, OpenSearchException {
        return open(fn.apply(new OpenRequest.Builder()).build());
    }

    // ----- Endpoint: indices.recovery

    /**
     * Returns information about ongoing index shard recoveries.
     *
     *
     */

    public RecoveryResponse recovery(RecoveryRequest request) throws IOException, OpenSearchException {
        @SuppressWarnings("unchecked")
        JsonEndpoint<RecoveryRequest, RecoveryResponse, ErrorResponse> endpoint = (JsonEndpoint<
            RecoveryRequest,
            RecoveryResponse,
            ErrorResponse>) RecoveryRequest._ENDPOINT;

        return this.transport.performRequest(request, endpoint, this.transportOptions);
    }

    /**
     * Returns information about ongoing index shard recoveries.
     *
     * @param fn
     *            a function that initializes a builder to create the
     *            {@link RecoveryRequest}
     *
     */

    public final RecoveryResponse recovery(Function<RecoveryRequest.Builder, ObjectBuilder<RecoveryRequest>> fn) throws IOException,
        OpenSearchException {
        return recovery(fn.apply(new RecoveryRequest.Builder()).build());
    }

    /**
     * Returns information about ongoing index shard recoveries.
     *
     *
     */

    public RecoveryResponse recovery() throws IOException, OpenSearchException {
        return this.transport.performRequest(new RecoveryRequest.Builder().build(), RecoveryRequest._ENDPOINT, this.transportOptions);
    }

    // ----- Endpoint: indices.refresh

    /**
     * Performs the refresh operation in one or more indices.
     *
     *
     */

    public RefreshResponse refresh(RefreshRequest request) throws IOException, OpenSearchException {
        @SuppressWarnings("unchecked")
        JsonEndpoint<RefreshRequest, RefreshResponse, ErrorResponse> endpoint = (JsonEndpoint<
            RefreshRequest,
            RefreshResponse,
            ErrorResponse>) RefreshRequest._ENDPOINT;

        return this.transport.performRequest(request, endpoint, this.transportOptions);
    }

    /**
     * Performs the refresh operation in one or more indices.
     *
     * @param fn
     *            a function that initializes a builder to create the
     *            {@link RefreshRequest}
     *
     */

    public final RefreshResponse refresh(Function<RefreshRequest.Builder, ObjectBuilder<RefreshRequest>> fn) throws IOException,
        OpenSearchException {
        return refresh(fn.apply(new RefreshRequest.Builder()).build());
    }

    /**
     * Performs the refresh operation in one or more indices.
     *
     *
     */

    public RefreshResponse refresh() throws IOException, OpenSearchException {
        return this.transport.performRequest(new RefreshRequest.Builder().build(), RefreshRequest._ENDPOINT, this.transportOptions);
    }

    // ----- Endpoint: indices.resolve_index

    /**
     * Returns information about any matching indices, aliases, and data streams
     *
     *
     */

    public ResolveIndexResponse resolveIndex(ResolveIndexRequest request) throws IOException, OpenSearchException {
        @SuppressWarnings("unchecked")
        JsonEndpoint<ResolveIndexRequest, ResolveIndexResponse, ErrorResponse> endpoint = (JsonEndpoint<
            ResolveIndexRequest,
            ResolveIndexResponse,
            ErrorResponse>) ResolveIndexRequest._ENDPOINT;

        return this.transport.performRequest(request, endpoint, this.transportOptions);
    }

    /**
     * Returns information about any matching indices, aliases, and data streams
     *
     * @param fn
     *            a function that initializes a builder to create the
     *            {@link ResolveIndexRequest}
     *
     */

    public final ResolveIndexResponse resolveIndex(Function<ResolveIndexRequest.Builder, ObjectBuilder<ResolveIndexRequest>> fn)
        throws IOException, OpenSearchException {
        return resolveIndex(fn.apply(new ResolveIndexRequest.Builder()).build());
    }

    // ----- Endpoint: indices.rollover

    /**
     * Updates an alias to point to a new index when the existing index is
     * considered to be too large or too old.
     *
     *
     */

    public RolloverResponse rollover(RolloverRequest request) throws IOException, OpenSearchException {
        @SuppressWarnings("unchecked")
        JsonEndpoint<RolloverRequest, RolloverResponse, ErrorResponse> endpoint = (JsonEndpoint<
            RolloverRequest,
            RolloverResponse,
            ErrorResponse>) RolloverRequest._ENDPOINT;

        return this.transport.performRequest(request, endpoint, this.transportOptions);
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

    public final RolloverResponse rollover(Function<RolloverRequest.Builder, ObjectBuilder<RolloverRequest>> fn) throws IOException,
        OpenSearchException {
        return rollover(fn.apply(new RolloverRequest.Builder()).build());
    }

    // ----- Endpoint: indices.segments

    /**
     * Provides low-level information about segments in a Lucene index.
     *
     *
     */

    public SegmentsResponse segments(SegmentsRequest request) throws IOException, OpenSearchException {
        @SuppressWarnings("unchecked")
        JsonEndpoint<SegmentsRequest, SegmentsResponse, ErrorResponse> endpoint = (JsonEndpoint<
            SegmentsRequest,
            SegmentsResponse,
            ErrorResponse>) SegmentsRequest._ENDPOINT;

        return this.transport.performRequest(request, endpoint, this.transportOptions);
    }

    /**
     * Provides low-level information about segments in a Lucene index.
     *
     * @param fn
     *            a function that initializes a builder to create the
     *            {@link SegmentsRequest}
     *
     */

    public final SegmentsResponse segments(Function<SegmentsRequest.Builder, ObjectBuilder<SegmentsRequest>> fn) throws IOException,
        OpenSearchException {
        return segments(fn.apply(new SegmentsRequest.Builder()).build());
    }

    /**
     * Provides low-level information about segments in a Lucene index.
     *
     *
     */

    public SegmentsResponse segments() throws IOException, OpenSearchException {
        return this.transport.performRequest(new SegmentsRequest.Builder().build(), SegmentsRequest._ENDPOINT, this.transportOptions);
    }

    // ----- Endpoint: indices.shard_stores

    /**
     * Provides store information for shard copies of indices.
     *
     *
     */

    public ShardStoresResponse shardStores(ShardStoresRequest request) throws IOException, OpenSearchException {
        @SuppressWarnings("unchecked")
        JsonEndpoint<ShardStoresRequest, ShardStoresResponse, ErrorResponse> endpoint = (JsonEndpoint<
            ShardStoresRequest,
            ShardStoresResponse,
            ErrorResponse>) ShardStoresRequest._ENDPOINT;

        return this.transport.performRequest(request, endpoint, this.transportOptions);
    }

    /**
     * Provides store information for shard copies of indices.
     *
     * @param fn
     *            a function that initializes a builder to create the
     *            {@link ShardStoresRequest}
     *
     */

    public final ShardStoresResponse shardStores(Function<ShardStoresRequest.Builder, ObjectBuilder<ShardStoresRequest>> fn)
        throws IOException, OpenSearchException {
        return shardStores(fn.apply(new ShardStoresRequest.Builder()).build());
    }

    /**
     * Provides store information for shard copies of indices.
     *
     *
     */

    public ShardStoresResponse shardStores() throws IOException, OpenSearchException {
        return this.transport.performRequest(new ShardStoresRequest.Builder().build(), ShardStoresRequest._ENDPOINT, this.transportOptions);
    }

    // ----- Endpoint: indices.shrink

    /**
     * Allow to shrink an existing index into a new index with fewer primary shards.
     *
     *
     */

    public ShrinkResponse shrink(ShrinkRequest request) throws IOException, OpenSearchException {
        @SuppressWarnings("unchecked")
        JsonEndpoint<ShrinkRequest, ShrinkResponse, ErrorResponse> endpoint = (JsonEndpoint<
            ShrinkRequest,
            ShrinkResponse,
            ErrorResponse>) ShrinkRequest._ENDPOINT;

        return this.transport.performRequest(request, endpoint, this.transportOptions);
    }

    /**
     * Allow to shrink an existing index into a new index with fewer primary shards.
     *
     * @param fn
     *            a function that initializes a builder to create the
     *            {@link ShrinkRequest}
     *
     */

    public final ShrinkResponse shrink(Function<ShrinkRequest.Builder, ObjectBuilder<ShrinkRequest>> fn) throws IOException,
        OpenSearchException {
        return shrink(fn.apply(new ShrinkRequest.Builder()).build());
    }

    // ----- Endpoint: indices.split

    /**
     * Allows you to split an existing index into a new index with more primary
     * shards.
     *
     *
     */

    public SplitResponse split(SplitRequest request) throws IOException, OpenSearchException {
        @SuppressWarnings("unchecked")
        JsonEndpoint<SplitRequest, SplitResponse, ErrorResponse> endpoint = (JsonEndpoint<
            SplitRequest,
            SplitResponse,
            ErrorResponse>) SplitRequest._ENDPOINT;

        return this.transport.performRequest(request, endpoint, this.transportOptions);
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

    public final SplitResponse split(Function<SplitRequest.Builder, ObjectBuilder<SplitRequest>> fn) throws IOException,
        OpenSearchException {
        return split(fn.apply(new SplitRequest.Builder()).build());
    }

    // ----- Endpoint: indices.stats

    /**
     * Provides statistics on operations happening in an index.
     *
     *
     */

    public IndicesStatsResponse stats(IndicesStatsRequest request) throws IOException, OpenSearchException {
        @SuppressWarnings("unchecked")
        JsonEndpoint<IndicesStatsRequest, IndicesStatsResponse, ErrorResponse> endpoint = (JsonEndpoint<
            IndicesStatsRequest,
            IndicesStatsResponse,
            ErrorResponse>) IndicesStatsRequest._ENDPOINT;

        return this.transport.performRequest(request, endpoint, this.transportOptions);
    }

    /**
     * Provides statistics on operations happening in an index.
     *
     * @param fn
     *            a function that initializes a builder to create the
     *            {@link IndicesStatsRequest}
     *
     */

    public final IndicesStatsResponse stats(Function<IndicesStatsRequest.Builder, ObjectBuilder<IndicesStatsRequest>> fn)
        throws IOException, OpenSearchException {
        return stats(fn.apply(new IndicesStatsRequest.Builder()).build());
    }

    /**
     * Provides statistics on operations happening in an index.
     *
     *
     */

    public IndicesStatsResponse stats() throws IOException, OpenSearchException {
        return this.transport.performRequest(
            new IndicesStatsRequest.Builder().build(),
            IndicesStatsRequest._ENDPOINT,
            this.transportOptions
        );
    }

    // ----- Endpoint: indices.upgrade

    /**
     * DEPRECATED Upgrades to the current version of Lucene.
     *
     *
     */

    public UpgradeResponse upgrade(UpgradeRequest request) throws IOException, OpenSearchException {
        @SuppressWarnings("unchecked")
        JsonEndpoint<UpgradeRequest, UpgradeResponse, ErrorResponse> endpoint = (JsonEndpoint<
            UpgradeRequest,
            UpgradeResponse,
            ErrorResponse>) UpgradeRequest._ENDPOINT;

        return this.transport.performRequest(request, endpoint, this.transportOptions);
    }

    /**
     * DEPRECATED Upgrades to the current version of Lucene.
     *
     * @param fn
     *            a function that initializes a builder to create the
     *            {@link UpgradeRequest}
     *
     */

    public final UpgradeResponse upgrade(Function<UpgradeRequest.Builder, ObjectBuilder<UpgradeRequest>> fn) throws IOException,
        OpenSearchException {
        return upgrade(fn.apply(new UpgradeRequest.Builder()).build());
    }

    /**
     * DEPRECATED Upgrades to the current version of Lucene.
     *
     *
     */

    public UpgradeResponse upgrade() throws IOException, OpenSearchException {
        return this.transport.performRequest(new UpgradeRequest.Builder().build(), UpgradeRequest._ENDPOINT, this.transportOptions);
    }

    // ----- Endpoint: indices.validate_query

    /**
     * Allows a user to validate a potentially expensive query without executing it.
     *
     *
     */

    public ValidateQueryResponse validateQuery(ValidateQueryRequest request) throws IOException, OpenSearchException {
        @SuppressWarnings("unchecked")
        JsonEndpoint<ValidateQueryRequest, ValidateQueryResponse, ErrorResponse> endpoint = (JsonEndpoint<
            ValidateQueryRequest,
            ValidateQueryResponse,
            ErrorResponse>) ValidateQueryRequest._ENDPOINT;

        return this.transport.performRequest(request, endpoint, this.transportOptions);
    }

    /**
     * Allows a user to validate a potentially expensive query without executing it.
     *
     * @param fn
     *            a function that initializes a builder to create the
     *            {@link ValidateQueryRequest}
     *
     */

    public final ValidateQueryResponse validateQuery(Function<ValidateQueryRequest.Builder, ObjectBuilder<ValidateQueryRequest>> fn)
        throws IOException, OpenSearchException {
        return validateQuery(fn.apply(new ValidateQueryRequest.Builder()).build());
    }

    /**
     * Allows a user to validate a potentially expensive query without executing it.
     *
     *
     */

    public ValidateQueryResponse validateQuery() throws IOException, OpenSearchException {
        return this.transport.performRequest(
            new ValidateQueryRequest.Builder().build(),
            ValidateQueryRequest._ENDPOINT,
            this.transportOptions
        );
    }

}
