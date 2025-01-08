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

package org.opensearch.client.opensearch.cat;

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
 * Client for the cat namespace.
 */
@Generated("org.opensearch.client.codegen.CodeGenerator")
public abstract class OpenSearchCatClientBase<Self extends OpenSearchCatClientBase<Self>> extends ApiClient<OpenSearchTransport, Self> {
    public OpenSearchCatClientBase(OpenSearchTransport transport, @Nullable TransportOptions transportOptions) {
        super(transport, transportOptions);
    }

    // ----- Endpoint: cat.aliases

    /**
     * Shows information about aliases currently configured to indexes, including filter and routing information.
     */
    public AliasesResponse aliases(AliasesRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, AliasesRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Shows information about aliases currently configured to indexes, including filter and routing information.
     *
     * @param fn a function that initializes a builder to create the {@link AliasesRequest}
     */
    public final AliasesResponse aliases(Function<AliasesRequest.Builder, ObjectBuilder<AliasesRequest>> fn) throws IOException,
        OpenSearchException {
        return aliases(fn.apply(new AliasesRequest.Builder()).build());
    }

    /**
     * Shows information about aliases currently configured to indexes, including filter and routing information.
     */
    public final AliasesResponse aliases() throws IOException, OpenSearchException {
        return aliases(new AliasesRequest.Builder().build());
    }

    // ----- Endpoint: cat.all_pit_segments

    /**
     * Lists all active CAT point-in-time segments.
     */
    public AllPitSegmentsResponse allPitSegments(AllPitSegmentsRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, AllPitSegmentsRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Lists all active CAT point-in-time segments.
     *
     * @param fn a function that initializes a builder to create the {@link AllPitSegmentsRequest}
     */
    public final AllPitSegmentsResponse allPitSegments(Function<AllPitSegmentsRequest.Builder, ObjectBuilder<AllPitSegmentsRequest>> fn)
        throws IOException, OpenSearchException {
        return allPitSegments(fn.apply(new AllPitSegmentsRequest.Builder()).build());
    }

    /**
     * Lists all active CAT point-in-time segments.
     */
    public final AllPitSegmentsResponse allPitSegments() throws IOException, OpenSearchException {
        return allPitSegments(new AllPitSegmentsRequest.Builder().build());
    }

    // ----- Endpoint: cat.allocation

    /**
     * Provides a snapshot of how many shards are allocated to each data node and how much disk space they are using.
     */
    public AllocationResponse allocation(AllocationRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, AllocationRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Provides a snapshot of how many shards are allocated to each data node and how much disk space they are using.
     *
     * @param fn a function that initializes a builder to create the {@link AllocationRequest}
     */
    public final AllocationResponse allocation(Function<AllocationRequest.Builder, ObjectBuilder<AllocationRequest>> fn) throws IOException,
        OpenSearchException {
        return allocation(fn.apply(new AllocationRequest.Builder()).build());
    }

    /**
     * Provides a snapshot of how many shards are allocated to each data node and how much disk space they are using.
     */
    public final AllocationResponse allocation() throws IOException, OpenSearchException {
        return allocation(new AllocationRequest.Builder().build());
    }

    // ----- Endpoint: cat.cluster_manager

    /**
     * Returns information about the cluster-manager node.
     */
    public ClusterManagerResponse clusterManager(ClusterManagerRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, ClusterManagerRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Returns information about the cluster-manager node.
     *
     * @param fn a function that initializes a builder to create the {@link ClusterManagerRequest}
     */
    public final ClusterManagerResponse clusterManager(Function<ClusterManagerRequest.Builder, ObjectBuilder<ClusterManagerRequest>> fn)
        throws IOException, OpenSearchException {
        return clusterManager(fn.apply(new ClusterManagerRequest.Builder()).build());
    }

    /**
     * Returns information about the cluster-manager node.
     */
    public final ClusterManagerResponse clusterManager() throws IOException, OpenSearchException {
        return clusterManager(new ClusterManagerRequest.Builder().build());
    }

    // ----- Endpoint: cat.count

    /**
     * Provides quick access to the document count of the entire cluster or of an individual index.
     */
    public CountResponse count(CountRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, CountRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Provides quick access to the document count of the entire cluster or of an individual index.
     *
     * @param fn a function that initializes a builder to create the {@link CountRequest}
     */
    public final CountResponse count(Function<CountRequest.Builder, ObjectBuilder<CountRequest>> fn) throws IOException,
        OpenSearchException {
        return count(fn.apply(new CountRequest.Builder()).build());
    }

    /**
     * Provides quick access to the document count of the entire cluster or of an individual index.
     */
    public final CountResponse count() throws IOException, OpenSearchException {
        return count(new CountRequest.Builder().build());
    }

    // ----- Endpoint: cat.fielddata

    /**
     * Shows how much heap memory is currently being used by field data on every data node in the cluster.
     */
    public FielddataResponse fielddata(FielddataRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, FielddataRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Shows how much heap memory is currently being used by field data on every data node in the cluster.
     *
     * @param fn a function that initializes a builder to create the {@link FielddataRequest}
     */
    public final FielddataResponse fielddata(Function<FielddataRequest.Builder, ObjectBuilder<FielddataRequest>> fn) throws IOException,
        OpenSearchException {
        return fielddata(fn.apply(new FielddataRequest.Builder()).build());
    }

    /**
     * Shows how much heap memory is currently being used by field data on every data node in the cluster.
     */
    public final FielddataResponse fielddata() throws IOException, OpenSearchException {
        return fielddata(new FielddataRequest.Builder().build());
    }

    // ----- Endpoint: cat.health

    /**
     * Returns a concise representation of the cluster health.
     */
    public HealthResponse health(HealthRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, HealthRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Returns a concise representation of the cluster health.
     *
     * @param fn a function that initializes a builder to create the {@link HealthRequest}
     */
    public final HealthResponse health(Function<HealthRequest.Builder, ObjectBuilder<HealthRequest>> fn) throws IOException,
        OpenSearchException {
        return health(fn.apply(new HealthRequest.Builder()).build());
    }

    /**
     * Returns a concise representation of the cluster health.
     */
    public final HealthResponse health() throws IOException, OpenSearchException {
        return health(new HealthRequest.Builder().build());
    }

    // ----- Endpoint: cat.indices

    /**
     * Lists information related to indexes, that is, how much disk space they are using, how many shards they have, their health status,
     * and so on.
     */
    public IndicesResponse indices(IndicesRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, IndicesRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Lists information related to indexes, that is, how much disk space they are using, how many shards they have, their health status,
     * and so on.
     *
     * @param fn a function that initializes a builder to create the {@link IndicesRequest}
     */
    public final IndicesResponse indices(Function<IndicesRequest.Builder, ObjectBuilder<IndicesRequest>> fn) throws IOException,
        OpenSearchException {
        return indices(fn.apply(new IndicesRequest.Builder()).build());
    }

    /**
     * Lists information related to indexes, that is, how much disk space they are using, how many shards they have, their health status,
     * and so on.
     */
    public final IndicesResponse indices() throws IOException, OpenSearchException {
        return indices(new IndicesRequest.Builder().build());
    }

    // ----- Endpoint: cat.master

    /**
     * Returns information about the cluster-manager node.
     */
    @Deprecated
    public MasterResponse master(MasterRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, MasterRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Returns information about the cluster-manager node.
     *
     * @param fn a function that initializes a builder to create the {@link MasterRequest}
     */
    @Deprecated
    public final MasterResponse master(Function<MasterRequest.Builder, ObjectBuilder<MasterRequest>> fn) throws IOException,
        OpenSearchException {
        return master(fn.apply(new MasterRequest.Builder()).build());
    }

    /**
     * Returns information about the cluster-manager node.
     */
    @Deprecated
    public final MasterResponse master() throws IOException, OpenSearchException {
        return master(new MasterRequest.Builder().build());
    }

    // ----- Endpoint: cat.nodeattrs

    /**
     * Returns information about custom node attributes.
     */
    public NodeattrsResponse nodeattrs(NodeattrsRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, NodeattrsRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Returns information about custom node attributes.
     *
     * @param fn a function that initializes a builder to create the {@link NodeattrsRequest}
     */
    public final NodeattrsResponse nodeattrs(Function<NodeattrsRequest.Builder, ObjectBuilder<NodeattrsRequest>> fn) throws IOException,
        OpenSearchException {
        return nodeattrs(fn.apply(new NodeattrsRequest.Builder()).build());
    }

    /**
     * Returns information about custom node attributes.
     */
    public final NodeattrsResponse nodeattrs() throws IOException, OpenSearchException {
        return nodeattrs(new NodeattrsRequest.Builder().build());
    }

    // ----- Endpoint: cat.nodes

    /**
     * Returns basic statistics about the performance of cluster nodes.
     */
    public NodesResponse nodes(NodesRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, NodesRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Returns basic statistics about the performance of cluster nodes.
     *
     * @param fn a function that initializes a builder to create the {@link NodesRequest}
     */
    public final NodesResponse nodes(Function<NodesRequest.Builder, ObjectBuilder<NodesRequest>> fn) throws IOException,
        OpenSearchException {
        return nodes(fn.apply(new NodesRequest.Builder()).build());
    }

    /**
     * Returns basic statistics about the performance of cluster nodes.
     */
    public final NodesResponse nodes() throws IOException, OpenSearchException {
        return nodes(new NodesRequest.Builder().build());
    }

    // ----- Endpoint: cat.pending_tasks

    /**
     * Returns a concise representation of the cluster's pending tasks.
     */
    public PendingTasksResponse pendingTasks(PendingTasksRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, PendingTasksRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Returns a concise representation of the cluster's pending tasks.
     *
     * @param fn a function that initializes a builder to create the {@link PendingTasksRequest}
     */
    public final PendingTasksResponse pendingTasks(Function<PendingTasksRequest.Builder, ObjectBuilder<PendingTasksRequest>> fn)
        throws IOException, OpenSearchException {
        return pendingTasks(fn.apply(new PendingTasksRequest.Builder()).build());
    }

    /**
     * Returns a concise representation of the cluster's pending tasks.
     */
    public final PendingTasksResponse pendingTasks() throws IOException, OpenSearchException {
        return pendingTasks(new PendingTasksRequest.Builder().build());
    }

    // ----- Endpoint: cat.pit_segments

    /**
     * Lists one or several CAT point-in-time segments.
     */
    public PitSegmentsResponse pitSegments(PitSegmentsRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, PitSegmentsRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Lists one or several CAT point-in-time segments.
     *
     * @param fn a function that initializes a builder to create the {@link PitSegmentsRequest}
     */
    public final PitSegmentsResponse pitSegments(Function<PitSegmentsRequest.Builder, ObjectBuilder<PitSegmentsRequest>> fn)
        throws IOException, OpenSearchException {
        return pitSegments(fn.apply(new PitSegmentsRequest.Builder()).build());
    }

    // ----- Endpoint: cat.plugins

    /**
     * Returns information about the names, components, and versions of the installed plugins.
     */
    public PluginsResponse plugins(PluginsRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, PluginsRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Returns information about the names, components, and versions of the installed plugins.
     *
     * @param fn a function that initializes a builder to create the {@link PluginsRequest}
     */
    public final PluginsResponse plugins(Function<PluginsRequest.Builder, ObjectBuilder<PluginsRequest>> fn) throws IOException,
        OpenSearchException {
        return plugins(fn.apply(new PluginsRequest.Builder()).build());
    }

    /**
     * Returns information about the names, components, and versions of the installed plugins.
     */
    public final PluginsResponse plugins() throws IOException, OpenSearchException {
        return plugins(new PluginsRequest.Builder().build());
    }

    // ----- Endpoint: cat.recovery

    /**
     * Returns all completed and ongoing index and shard recoveries.
     */
    public RecoveryResponse recovery(RecoveryRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, RecoveryRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Returns all completed and ongoing index and shard recoveries.
     *
     * @param fn a function that initializes a builder to create the {@link RecoveryRequest}
     */
    public final RecoveryResponse recovery(Function<RecoveryRequest.Builder, ObjectBuilder<RecoveryRequest>> fn) throws IOException,
        OpenSearchException {
        return recovery(fn.apply(new RecoveryRequest.Builder()).build());
    }

    /**
     * Returns all completed and ongoing index and shard recoveries.
     */
    public final RecoveryResponse recovery() throws IOException, OpenSearchException {
        return recovery(new RecoveryRequest.Builder().build());
    }

    // ----- Endpoint: cat.repositories

    /**
     * Returns information about all snapshot repositories for a cluster.
     */
    public RepositoriesResponse repositories(RepositoriesRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, RepositoriesRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Returns information about all snapshot repositories for a cluster.
     *
     * @param fn a function that initializes a builder to create the {@link RepositoriesRequest}
     */
    public final RepositoriesResponse repositories(Function<RepositoriesRequest.Builder, ObjectBuilder<RepositoriesRequest>> fn)
        throws IOException, OpenSearchException {
        return repositories(fn.apply(new RepositoriesRequest.Builder()).build());
    }

    /**
     * Returns information about all snapshot repositories for a cluster.
     */
    public final RepositoriesResponse repositories() throws IOException, OpenSearchException {
        return repositories(new RepositoriesRequest.Builder().build());
    }

    // ----- Endpoint: cat.segment_replication

    /**
     * Returns information about active and last-completed segment replication events on each replica shard, including related shard-level
     * metrics. These metrics provide information about how far behind the primary shard the replicas are lagging.
     */
    public SegmentReplicationResponse segmentReplication(SegmentReplicationRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, SegmentReplicationRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Returns information about active and last-completed segment replication events on each replica shard, including related shard-level
     * metrics. These metrics provide information about how far behind the primary shard the replicas are lagging.
     *
     * @param fn a function that initializes a builder to create the {@link SegmentReplicationRequest}
     */
    public final SegmentReplicationResponse segmentReplication(
        Function<SegmentReplicationRequest.Builder, ObjectBuilder<SegmentReplicationRequest>> fn
    ) throws IOException, OpenSearchException {
        return segmentReplication(fn.apply(new SegmentReplicationRequest.Builder()).build());
    }

    /**
     * Returns information about active and last-completed segment replication events on each replica shard, including related shard-level
     * metrics. These metrics provide information about how far behind the primary shard the replicas are lagging.
     */
    public final SegmentReplicationResponse segmentReplication() throws IOException, OpenSearchException {
        return segmentReplication(new SegmentReplicationRequest.Builder().build());
    }

    // ----- Endpoint: cat.segments

    /**
     * Provides low-level information about the segments in the shards of an index.
     */
    public SegmentsResponse segments(SegmentsRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, SegmentsRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Provides low-level information about the segments in the shards of an index.
     *
     * @param fn a function that initializes a builder to create the {@link SegmentsRequest}
     */
    public final SegmentsResponse segments(Function<SegmentsRequest.Builder, ObjectBuilder<SegmentsRequest>> fn) throws IOException,
        OpenSearchException {
        return segments(fn.apply(new SegmentsRequest.Builder()).build());
    }

    /**
     * Provides low-level information about the segments in the shards of an index.
     */
    public final SegmentsResponse segments() throws IOException, OpenSearchException {
        return segments(new SegmentsRequest.Builder().build());
    }

    // ----- Endpoint: cat.shards

    /**
     * Lists the states of all primary and replica shards and how they are distributed.
     */
    public ShardsResponse shards(ShardsRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, ShardsRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Lists the states of all primary and replica shards and how they are distributed.
     *
     * @param fn a function that initializes a builder to create the {@link ShardsRequest}
     */
    public final ShardsResponse shards(Function<ShardsRequest.Builder, ObjectBuilder<ShardsRequest>> fn) throws IOException,
        OpenSearchException {
        return shards(fn.apply(new ShardsRequest.Builder()).build());
    }

    /**
     * Lists the states of all primary and replica shards and how they are distributed.
     */
    public final ShardsResponse shards() throws IOException, OpenSearchException {
        return shards(new ShardsRequest.Builder().build());
    }

    // ----- Endpoint: cat.snapshots

    /**
     * Lists all of the snapshots stored in a specific repository.
     */
    public SnapshotsResponse snapshots(SnapshotsRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, SnapshotsRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Lists all of the snapshots stored in a specific repository.
     *
     * @param fn a function that initializes a builder to create the {@link SnapshotsRequest}
     */
    public final SnapshotsResponse snapshots(Function<SnapshotsRequest.Builder, ObjectBuilder<SnapshotsRequest>> fn) throws IOException,
        OpenSearchException {
        return snapshots(fn.apply(new SnapshotsRequest.Builder()).build());
    }

    /**
     * Lists all of the snapshots stored in a specific repository.
     */
    public final SnapshotsResponse snapshots() throws IOException, OpenSearchException {
        return snapshots(new SnapshotsRequest.Builder().build());
    }

    // ----- Endpoint: cat.tasks

    /**
     * Lists the progress of all tasks currently running on the cluster.
     */
    public TasksResponse tasks(TasksRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, TasksRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Lists the progress of all tasks currently running on the cluster.
     *
     * @param fn a function that initializes a builder to create the {@link TasksRequest}
     */
    public final TasksResponse tasks(Function<TasksRequest.Builder, ObjectBuilder<TasksRequest>> fn) throws IOException,
        OpenSearchException {
        return tasks(fn.apply(new TasksRequest.Builder()).build());
    }

    /**
     * Lists the progress of all tasks currently running on the cluster.
     */
    public final TasksResponse tasks() throws IOException, OpenSearchException {
        return tasks(new TasksRequest.Builder().build());
    }

    // ----- Endpoint: cat.templates

    /**
     * Lists the names, patterns, order numbers, and version numbers of index templates.
     */
    public TemplatesResponse templates(TemplatesRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, TemplatesRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Lists the names, patterns, order numbers, and version numbers of index templates.
     *
     * @param fn a function that initializes a builder to create the {@link TemplatesRequest}
     */
    public final TemplatesResponse templates(Function<TemplatesRequest.Builder, ObjectBuilder<TemplatesRequest>> fn) throws IOException,
        OpenSearchException {
        return templates(fn.apply(new TemplatesRequest.Builder()).build());
    }

    /**
     * Lists the names, patterns, order numbers, and version numbers of index templates.
     */
    public final TemplatesResponse templates() throws IOException, OpenSearchException {
        return templates(new TemplatesRequest.Builder().build());
    }

    // ----- Endpoint: cat.thread_pool

    /**
     * Returns cluster-wide thread pool statistics per node. By default the active, queued, and rejected statistics are returned for all
     * thread pools.
     */
    public ThreadPoolResponse threadPool(ThreadPoolRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, ThreadPoolRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Returns cluster-wide thread pool statistics per node. By default the active, queued, and rejected statistics are returned for all
     * thread pools.
     *
     * @param fn a function that initializes a builder to create the {@link ThreadPoolRequest}
     */
    public final ThreadPoolResponse threadPool(Function<ThreadPoolRequest.Builder, ObjectBuilder<ThreadPoolRequest>> fn) throws IOException,
        OpenSearchException {
        return threadPool(fn.apply(new ThreadPoolRequest.Builder()).build());
    }

    /**
     * Returns cluster-wide thread pool statistics per node. By default the active, queued, and rejected statistics are returned for all
     * thread pools.
     */
    public final ThreadPoolResponse threadPool() throws IOException, OpenSearchException {
        return threadPool(new ThreadPoolRequest.Builder().build());
    }
}