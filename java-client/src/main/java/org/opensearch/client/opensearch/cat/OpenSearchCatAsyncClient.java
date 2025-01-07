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

package org.opensearch.client.opensearch.cat;

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
 * Client for the cat namespace.
 */
public class OpenSearchCatAsyncClient extends OpenSearchCatAsyncClientBase<OpenSearchCatAsyncClient> {

    public OpenSearchCatAsyncClient(OpenSearchTransport transport) {
        super(transport, null);
    }

    public OpenSearchCatAsyncClient(OpenSearchTransport transport, @Nullable TransportOptions transportOptions) {
        super(transport, transportOptions);
    }

    @Override
    public OpenSearchCatAsyncClient withTransportOptions(@Nullable TransportOptions transportOptions) {
        return new OpenSearchCatAsyncClient(this.transport, transportOptions);
    }

    // ----- Endpoint: cat.count

    /**
     * Provides quick access to the document count of the entire cluster, or
     * individual indices.
     *
     *
     */

    public CompletableFuture<CountResponse> count(CountRequest request) throws IOException, OpenSearchException {
        @SuppressWarnings("unchecked")
        JsonEndpoint<CountRequest, CountResponse, ErrorResponse> endpoint = (JsonEndpoint<
            CountRequest,
            CountResponse,
            ErrorResponse>) CountRequest._ENDPOINT;

        return this.transport.performRequestAsync(request, endpoint, this.transportOptions);
    }

    /**
     * Provides quick access to the document count of the entire cluster, or
     * individual indices.
     *
     * @param fn
     *            a function that initializes a builder to create the
     *            {@link CountRequest}
     *
     */

    public final CompletableFuture<CountResponse> count(Function<CountRequest.Builder, ObjectBuilder<CountRequest>> fn) throws IOException,
        OpenSearchException {
        return count(fn.apply(new CountRequest.Builder()).build());
    }

    /**
     * Provides quick access to the document count of the entire cluster, or
     * individual indices.
     *
     *
     */

    public CompletableFuture<CountResponse> count() throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(new CountRequest.Builder().build(), CountRequest._ENDPOINT, this.transportOptions);
    }

    // ----- Endpoint: cat.fielddata

    /**
     * Shows how much heap memory is currently being used by fielddata on every data
     * node in the cluster.
     *
     *
     */

    public CompletableFuture<FielddataResponse> fielddata(FielddataRequest request) throws IOException, OpenSearchException {
        @SuppressWarnings("unchecked")
        JsonEndpoint<FielddataRequest, FielddataResponse, ErrorResponse> endpoint = (JsonEndpoint<
            FielddataRequest,
            FielddataResponse,
            ErrorResponse>) FielddataRequest._ENDPOINT;

        return this.transport.performRequestAsync(request, endpoint, this.transportOptions);
    }

    /**
     * Shows how much heap memory is currently being used by fielddata on every data
     * node in the cluster.
     *
     * @param fn
     *            a function that initializes a builder to create the
     *            {@link FielddataRequest}
     *
     */

    public final CompletableFuture<FielddataResponse> fielddata(Function<FielddataRequest.Builder, ObjectBuilder<FielddataRequest>> fn)
        throws IOException, OpenSearchException {
        return fielddata(fn.apply(new FielddataRequest.Builder()).build());
    }

    /**
     * Shows how much heap memory is currently being used by fielddata on every data
     * node in the cluster.
     *
     *
     */

    public CompletableFuture<FielddataResponse> fielddata() throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(
            new FielddataRequest.Builder().build(),
            FielddataRequest._ENDPOINT,
            this.transportOptions
        );
    }

    // ----- Endpoint: cat.health

    /**
     * Returns a concise representation of the cluster health.
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
     * Returns a concise representation of the cluster health.
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
     * Returns a concise representation of the cluster health.
     *
     *
     */

    public CompletableFuture<HealthResponse> health() throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(new HealthRequest.Builder().build(), HealthRequest._ENDPOINT, this.transportOptions);
    }

    // ----- Endpoint: cat.help

    /**
     * Returns help for the Cat APIs.
     *
     *
     */
    public CompletableFuture<HelpResponse> help() throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(HelpRequest._INSTANCE, HelpRequest._ENDPOINT, this.transportOptions);
    }

    // ----- Endpoint: cat.indices

    /**
     * Returns information about indices: number of primaries and replicas, document
     * counts, disk size, ...
     *
     *
     */

    public CompletableFuture<IndicesResponse> indices(IndicesRequest request) throws IOException, OpenSearchException {
        @SuppressWarnings("unchecked")
        JsonEndpoint<IndicesRequest, IndicesResponse, ErrorResponse> endpoint = (JsonEndpoint<
            IndicesRequest,
            IndicesResponse,
            ErrorResponse>) IndicesRequest._ENDPOINT;

        return this.transport.performRequestAsync(request, endpoint, this.transportOptions);
    }

    /**
     * Returns information about indices: number of primaries and replicas, document
     * counts, disk size, ...
     *
     * @param fn
     *            a function that initializes a builder to create the
     *            {@link IndicesRequest}
     *
     */

    public final CompletableFuture<IndicesResponse> indices(Function<IndicesRequest.Builder, ObjectBuilder<IndicesRequest>> fn)
        throws IOException, OpenSearchException {
        return indices(fn.apply(new IndicesRequest.Builder()).build());
    }

    /**
     * Returns information about indices: number of primaries and replicas, document
     * counts, disk size, ...
     *
     *
     */

    public CompletableFuture<IndicesResponse> indices() throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(new IndicesRequest.Builder().build(), IndicesRequest._ENDPOINT, this.transportOptions);
    }

    // ----- Endpoint: cat.master

    /**
     * Returns information about the master node.
     *
     *
     */
    @Deprecated
    public CompletableFuture<ClusterManagerResponse> master() throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(
            ClusterManagerRequest._INSTANCE,
            ClusterManagerRequest._DEPRECATED_ENDPOINT,
            this.transportOptions
        );
    }

    // ----- Endpoint: cat.cluster_manager

    /**
     * Returns information about the cluster-manager node.
     *
     *
     */
    public CompletableFuture<ClusterManagerResponse> clusterManager() throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(ClusterManagerRequest._INSTANCE, ClusterManagerRequest._ENDPOINT, this.transportOptions);
    }

    // ----- Endpoint: cat.nodeattrs

    /**
     * Returns information about custom node attributes.
     *
     *
     */
    public CompletableFuture<NodeattrsResponse> nodeattrs() throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(NodeattrsRequest._INSTANCE, NodeattrsRequest._ENDPOINT, this.transportOptions);
    }

    // ----- Endpoint: cat.nodes

    /**
     * Returns basic statistics about performance of cluster nodes.
     *
     *
     */

    public CompletableFuture<NodesResponse> nodes(NodesRequest request) throws IOException, OpenSearchException {
        @SuppressWarnings("unchecked")
        JsonEndpoint<NodesRequest, NodesResponse, ErrorResponse> endpoint = (JsonEndpoint<
            NodesRequest,
            NodesResponse,
            ErrorResponse>) NodesRequest._ENDPOINT;

        return this.transport.performRequestAsync(request, endpoint, this.transportOptions);
    }

    /**
     * Returns basic statistics about performance of cluster nodes.
     *
     * @param fn
     *            a function that initializes a builder to create the
     *            {@link NodesRequest}
     *
     */

    public final CompletableFuture<NodesResponse> nodes(Function<NodesRequest.Builder, ObjectBuilder<NodesRequest>> fn) throws IOException,
        OpenSearchException {
        return nodes(fn.apply(new NodesRequest.Builder()).build());
    }

    /**
     * Returns basic statistics about performance of cluster nodes.
     *
     *
     */

    public CompletableFuture<NodesResponse> nodes() throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(new NodesRequest.Builder().build(), NodesRequest._ENDPOINT, this.transportOptions);
    }

    // ----- Endpoint: cat.point_in_time_segments

    /**
     * Provides low-level information about the disk utilization of a PIT by
     * describing its Lucene segments.
     *
     *
     */
    public CompletableFuture<SegmentsResponse> pitSegments() throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(
            new PitSegmentsRequest.Builder().build(),
            PitSegmentsRequest._ENDPOINT,
            this.transportOptions
        );
    }

    // ----- Endpoint: cat.pending_tasks

    /**
     * Returns a concise representation of the cluster pending tasks.
     *
     *
     */
    public CompletableFuture<PendingTasksResponse> pendingTasks() throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(PendingTasksRequest._INSTANCE, PendingTasksRequest._ENDPOINT, this.transportOptions);
    }

    // ----- Endpoint: cat.plugins

    /**
     * Returns information about installed plugins across nodes node.
     *
     *
     */
    public CompletableFuture<PluginsResponse> plugins() throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(PluginsRequest._INSTANCE, PluginsRequest._ENDPOINT, this.transportOptions);
    }

    // ----- Endpoint: cat.recovery

    /**
     * Returns information about index shard recoveries, both on-going completed.
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
     * Returns information about index shard recoveries, both on-going completed.
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
     * Returns information about index shard recoveries, both on-going completed.
     *
     *
     */

    public CompletableFuture<RecoveryResponse> recovery() throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(new RecoveryRequest.Builder().build(), RecoveryRequest._ENDPOINT, this.transportOptions);
    }

    // ----- Endpoint: cat.repositories

    /**
     * Returns information about snapshot repositories registered in the cluster.
     *
     *
     */
    public CompletableFuture<RepositoriesResponse> repositories() throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(RepositoriesRequest._INSTANCE, RepositoriesRequest._ENDPOINT, this.transportOptions);
    }

    // ----- Endpoint: cat.segments

    /**
     * Provides low-level information about the segments in the shards of an index.
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
     * Provides low-level information about the segments in the shards of an index.
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
     * Provides low-level information about the segments in the shards of an index.
     *
     *
     */

    public CompletableFuture<SegmentsResponse> segments() throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(new SegmentsRequest.Builder().build(), SegmentsRequest._ENDPOINT, this.transportOptions);
    }

    // ----- Endpoint: cat.shards

    /**
     * Provides a detailed view of shard allocation on nodes.
     *
     *
     */

    public CompletableFuture<ShardsResponse> shards(ShardsRequest request) throws IOException, OpenSearchException {
        @SuppressWarnings("unchecked")
        JsonEndpoint<ShardsRequest, ShardsResponse, ErrorResponse> endpoint = (JsonEndpoint<
            ShardsRequest,
            ShardsResponse,
            ErrorResponse>) ShardsRequest._ENDPOINT;

        return this.transport.performRequestAsync(request, endpoint, this.transportOptions);
    }

    /**
     * Provides a detailed view of shard allocation on nodes.
     *
     * @param fn
     *            a function that initializes a builder to create the
     *            {@link ShardsRequest}
     *
     */

    public final CompletableFuture<ShardsResponse> shards(Function<ShardsRequest.Builder, ObjectBuilder<ShardsRequest>> fn)
        throws IOException, OpenSearchException {
        return shards(fn.apply(new ShardsRequest.Builder()).build());
    }

    /**
     * Provides a detailed view of shard allocation on nodes.
     *
     *
     */

    public CompletableFuture<ShardsResponse> shards() throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(new ShardsRequest.Builder().build(), ShardsRequest._ENDPOINT, this.transportOptions);
    }

    // ----- Endpoint: cat.snapshots

    /**
     * Returns all snapshots in a specific repository.
     *
     *
     */

    public CompletableFuture<SnapshotsResponse> snapshots(SnapshotsRequest request) throws IOException, OpenSearchException {
        @SuppressWarnings("unchecked")
        JsonEndpoint<SnapshotsRequest, SnapshotsResponse, ErrorResponse> endpoint = (JsonEndpoint<
            SnapshotsRequest,
            SnapshotsResponse,
            ErrorResponse>) SnapshotsRequest._ENDPOINT;

        return this.transport.performRequestAsync(request, endpoint, this.transportOptions);
    }

    /**
     * Returns all snapshots in a specific repository.
     *
     * @param fn
     *            a function that initializes a builder to create the
     *            {@link SnapshotsRequest}
     *
     */

    public final CompletableFuture<SnapshotsResponse> snapshots(Function<SnapshotsRequest.Builder, ObjectBuilder<SnapshotsRequest>> fn)
        throws IOException, OpenSearchException {
        return snapshots(fn.apply(new SnapshotsRequest.Builder()).build());
    }

    /**
     * Returns all snapshots in a specific repository.
     *
     *
     */

    public CompletableFuture<SnapshotsResponse> snapshots() throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(
            new SnapshotsRequest.Builder().build(),
            SnapshotsRequest._ENDPOINT,
            this.transportOptions
        );
    }

    // ----- Endpoint: cat.tasks

    /**
     * Returns information about the tasks currently executing on one or more nodes
     * in the cluster.
     *
     *
     */

    public CompletableFuture<TasksResponse> tasks(TasksRequest request) throws IOException, OpenSearchException {
        @SuppressWarnings("unchecked")
        JsonEndpoint<TasksRequest, TasksResponse, ErrorResponse> endpoint = (JsonEndpoint<
            TasksRequest,
            TasksResponse,
            ErrorResponse>) TasksRequest._ENDPOINT;

        return this.transport.performRequestAsync(request, endpoint, this.transportOptions);
    }

    /**
     * Returns information about the tasks currently executing on one or more nodes
     * in the cluster.
     *
     * @param fn
     *            a function that initializes a builder to create the
     *            {@link TasksRequest}
     *
     */

    public final CompletableFuture<TasksResponse> tasks(Function<TasksRequest.Builder, ObjectBuilder<TasksRequest>> fn) throws IOException,
        OpenSearchException {
        return tasks(fn.apply(new TasksRequest.Builder()).build());
    }

    /**
     * Returns information about the tasks currently executing on one or more nodes
     * in the cluster.
     *
     *
     */

    public CompletableFuture<TasksResponse> tasks() throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(new TasksRequest.Builder().build(), TasksRequest._ENDPOINT, this.transportOptions);
    }

    // ----- Endpoint: cat.templates

    /**
     * Returns information about existing templates.
     *
     *
     */

    public CompletableFuture<TemplatesResponse> templates(TemplatesRequest request) throws IOException, OpenSearchException {
        @SuppressWarnings("unchecked")
        JsonEndpoint<TemplatesRequest, TemplatesResponse, ErrorResponse> endpoint = (JsonEndpoint<
            TemplatesRequest,
            TemplatesResponse,
            ErrorResponse>) TemplatesRequest._ENDPOINT;

        return this.transport.performRequestAsync(request, endpoint, this.transportOptions);
    }

    /**
     * Returns information about existing templates.
     *
     * @param fn
     *            a function that initializes a builder to create the
     *            {@link TemplatesRequest}
     *
     */

    public final CompletableFuture<TemplatesResponse> templates(Function<TemplatesRequest.Builder, ObjectBuilder<TemplatesRequest>> fn)
        throws IOException, OpenSearchException {
        return templates(fn.apply(new TemplatesRequest.Builder()).build());
    }

    /**
     * Returns information about existing templates.
     *
     *
     */

    public CompletableFuture<TemplatesResponse> templates() throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(
            new TemplatesRequest.Builder().build(),
            TemplatesRequest._ENDPOINT,
            this.transportOptions
        );
    }

    // ----- Endpoint: cat.thread_pool

    /**
     * Returns cluster-wide thread pool statistics per node. By default the active,
     * queue and rejected statistics are returned for all thread pools.
     *
     *
     */

    public CompletableFuture<ThreadPoolResponse> threadPool(ThreadPoolRequest request) throws IOException, OpenSearchException {
        @SuppressWarnings("unchecked")
        JsonEndpoint<ThreadPoolRequest, ThreadPoolResponse, ErrorResponse> endpoint = (JsonEndpoint<
            ThreadPoolRequest,
            ThreadPoolResponse,
            ErrorResponse>) ThreadPoolRequest._ENDPOINT;

        return this.transport.performRequestAsync(request, endpoint, this.transportOptions);
    }

    /**
     * Returns cluster-wide thread pool statistics per node. By default the active,
     * queue and rejected statistics are returned for all thread pools.
     *
     * @param fn
     *            a function that initializes a builder to create the
     *            {@link ThreadPoolRequest}
     *
     */

    public final CompletableFuture<ThreadPoolResponse> threadPool(Function<ThreadPoolRequest.Builder, ObjectBuilder<ThreadPoolRequest>> fn)
        throws IOException, OpenSearchException {
        return threadPool(fn.apply(new ThreadPoolRequest.Builder()).build());
    }

    /**
     * Returns cluster-wide thread pool statistics per node. By default the active,
     * queue and rejected statistics are returned for all thread pools.
     *
     *
     */

    public CompletableFuture<ThreadPoolResponse> threadPool() throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(
            new ThreadPoolRequest.Builder().build(),
            ThreadPoolRequest._ENDPOINT,
            this.transportOptions
        );
    }

}
