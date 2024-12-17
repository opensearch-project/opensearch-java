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
