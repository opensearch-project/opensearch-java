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

package org.opensearch.client.opensearch.cluster;

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
 * Client for the cluster namespace.
 */
public class OpenSearchClusterAsyncClient extends OpenSearchClusterAsyncClientBase<OpenSearchClusterAsyncClient> {

    public OpenSearchClusterAsyncClient(OpenSearchTransport transport) {
        super(transport, null);
    }

    public OpenSearchClusterAsyncClient(OpenSearchTransport transport, @Nullable TransportOptions transportOptions) {
        super(transport, transportOptions);
    }

    @Override
    public OpenSearchClusterAsyncClient withTransportOptions(@Nullable TransportOptions transportOptions) {
        return new OpenSearchClusterAsyncClient(this.transport, transportOptions);
    }

    // ----- Endpoint: cluster.health

    /**
     * Returns basic information about the health of the cluster.
     *
     *
     */

    public CompletableFuture<HealthResponse> health(HealthRequest request) throws IOException, OpenSearchException {
        @SuppressWarnings("unchecked")
        JsonEndpoint<HealthRequest, HealthResponse, ErrorResponse> endpoint = (JsonEndpoint<
            HealthRequest,
            HealthResponse,
            ErrorResponse>) HealthRequest._ENDPOINT;

        return this.transport.performRequestAsync(request, endpoint, this.transportOptions);
    }

    /**
     * Returns basic information about the health of the cluster.
     *
     * @param fn
     *            a function that initializes a builder to create the
     *            {@link HealthRequest}
     *
     */

    public final CompletableFuture<HealthResponse> health(Function<HealthRequest.Builder, ObjectBuilder<HealthRequest>> fn)
        throws IOException, OpenSearchException {
        return health(fn.apply(new HealthRequest.Builder()).build());
    }

    /**
     * Returns basic information about the health of the cluster.
     *
     *
     */

    public CompletableFuture<HealthResponse> health() throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(new HealthRequest.Builder().build(), HealthRequest._ENDPOINT, this.transportOptions);
    }

    // ----- Endpoint: cluster.pending_tasks

    /**
     * Returns a list of any cluster-level changes (e.g. create index, update
     * mapping, allocate or fail shard) which have not yet been executed.
     *
     *
     */

    public CompletableFuture<PendingTasksResponse> pendingTasks(PendingTasksRequest request) throws IOException, OpenSearchException {
        @SuppressWarnings("unchecked")
        JsonEndpoint<PendingTasksRequest, PendingTasksResponse, ErrorResponse> endpoint = (JsonEndpoint<
            PendingTasksRequest,
            PendingTasksResponse,
            ErrorResponse>) PendingTasksRequest._ENDPOINT;

        return this.transport.performRequestAsync(request, endpoint, this.transportOptions);
    }

    /**
     * Returns a list of any cluster-level changes (e.g. create index, update
     * mapping, allocate or fail shard) which have not yet been executed.
     *
     * @param fn
     *            a function that initializes a builder to create the
     *            {@link PendingTasksRequest}
     *
     */

    public final CompletableFuture<PendingTasksResponse> pendingTasks(
        Function<PendingTasksRequest.Builder, ObjectBuilder<PendingTasksRequest>> fn
    ) throws IOException, OpenSearchException {
        return pendingTasks(fn.apply(new PendingTasksRequest.Builder()).build());
    }

    /**
     * Returns a list of any cluster-level changes (e.g. create index, update
     * mapping, allocate or fail shard) which have not yet been executed.
     *
     *
     */

    public CompletableFuture<PendingTasksResponse> pendingTasks() throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(
            new PendingTasksRequest.Builder().build(),
            PendingTasksRequest._ENDPOINT,
            this.transportOptions
        );
    }

    // ----- Endpoint: cluster.remote_info

    /**
     * Returns the information about configured remote clusters.
     *
     *
     */
    public CompletableFuture<RemoteInfoResponse> remoteInfo() throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(RemoteInfoRequest._INSTANCE, RemoteInfoRequest._ENDPOINT, this.transportOptions);
    }

    // ----- Endpoint: cluster.reroute

    /**
     * Allows to manually change the allocation of individual shards in the cluster.
     *
     *
     */

    public CompletableFuture<RerouteResponse> reroute(RerouteRequest request) throws IOException, OpenSearchException {
        @SuppressWarnings("unchecked")
        JsonEndpoint<RerouteRequest, RerouteResponse, ErrorResponse> endpoint = (JsonEndpoint<
            RerouteRequest,
            RerouteResponse,
            ErrorResponse>) RerouteRequest._ENDPOINT;

        return this.transport.performRequestAsync(request, endpoint, this.transportOptions);
    }

    /**
     * Allows to manually change the allocation of individual shards in the cluster.
     *
     * @param fn
     *            a function that initializes a builder to create the
     *            {@link RerouteRequest}
     *
     */

    public final CompletableFuture<RerouteResponse> reroute(Function<RerouteRequest.Builder, ObjectBuilder<RerouteRequest>> fn)
        throws IOException, OpenSearchException {
        return reroute(fn.apply(new RerouteRequest.Builder()).build());
    }

    /**
     * Allows to manually change the allocation of individual shards in the cluster.
     *
     *
     */

    public CompletableFuture<RerouteResponse> reroute() throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(new RerouteRequest.Builder().build(), RerouteRequest._ENDPOINT, this.transportOptions);
    }

    // ----- Endpoint: cluster.state

    /**
     * Returns a comprehensive information about the state of the cluster.
     *
     *
     */

    public CompletableFuture<StateResponse> state(StateRequest request) throws IOException, OpenSearchException {
        @SuppressWarnings("unchecked")
        JsonEndpoint<StateRequest, StateResponse, ErrorResponse> endpoint = (JsonEndpoint<
            StateRequest,
            StateResponse,
            ErrorResponse>) StateRequest._ENDPOINT;

        return this.transport.performRequestAsync(request, endpoint, this.transportOptions);
    }

    /**
     * Returns a comprehensive information about the state of the cluster.
     *
     * @param fn
     *            a function that initializes a builder to create the
     *            {@link StateRequest}
     *
     */

    public final CompletableFuture<StateResponse> state(Function<StateRequest.Builder, ObjectBuilder<StateRequest>> fn) throws IOException,
        OpenSearchException {
        return state(fn.apply(new StateRequest.Builder()).build());
    }

    /**
     * Returns a comprehensive information about the state of the cluster.
     *
     *
     */

    public CompletableFuture<StateResponse> state() throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(new StateRequest.Builder().build(), StateRequest._ENDPOINT, this.transportOptions);
    }

    // ----- Endpoint: cluster.stats

    /**
     * Returns high-level overview of cluster statistics.
     *
     *
     */

    public CompletableFuture<ClusterStatsResponse> stats(ClusterStatsRequest request) throws IOException, OpenSearchException {
        @SuppressWarnings("unchecked")
        JsonEndpoint<ClusterStatsRequest, ClusterStatsResponse, ErrorResponse> endpoint = (JsonEndpoint<
            ClusterStatsRequest,
            ClusterStatsResponse,
            ErrorResponse>) ClusterStatsRequest._ENDPOINT;

        return this.transport.performRequestAsync(request, endpoint, this.transportOptions);
    }

    /**
     * Returns high-level overview of cluster statistics.
     *
     * @param fn
     *            a function that initializes a builder to create the
     *            {@link ClusterStatsRequest}
     *
     */

    public final CompletableFuture<ClusterStatsResponse> stats(Function<ClusterStatsRequest.Builder, ObjectBuilder<ClusterStatsRequest>> fn)
        throws IOException, OpenSearchException {
        return stats(fn.apply(new ClusterStatsRequest.Builder()).build());
    }

    /**
     * Returns high-level overview of cluster statistics.
     *
     *
     */

    public CompletableFuture<ClusterStatsResponse> stats() throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(
            new ClusterStatsRequest.Builder().build(),
            ClusterStatsRequest._ENDPOINT,
            this.transportOptions
        );
    }

}
