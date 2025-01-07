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
import java.util.concurrent.CompletableFuture;
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
public abstract class OpenSearchCatAsyncClientBase<Self extends OpenSearchCatAsyncClientBase<Self>> extends ApiClient<
    OpenSearchTransport,
    Self> {
    public OpenSearchCatAsyncClientBase(OpenSearchTransport transport, @Nullable TransportOptions transportOptions) {
        super(transport, transportOptions);
    }

    // ----- Endpoint: cat.aliases

    /**
     * Shows information about aliases currently configured to indexes, including filter and routing information.
     */
    public CompletableFuture<AliasesResponse> aliases(AliasesRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, AliasesRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Shows information about aliases currently configured to indexes, including filter and routing information.
     *
     * @param fn a function that initializes a builder to create the {@link AliasesRequest}
     */
    public final CompletableFuture<AliasesResponse> aliases(Function<AliasesRequest.Builder, ObjectBuilder<AliasesRequest>> fn)
        throws IOException, OpenSearchException {
        return aliases(fn.apply(new AliasesRequest.Builder()).build());
    }

    /**
     * Shows information about aliases currently configured to indexes, including filter and routing information.
     */
    public final CompletableFuture<AliasesResponse> aliases() throws IOException, OpenSearchException {
        return aliases(new AliasesRequest.Builder().build());
    }

    // ----- Endpoint: cat.all_pit_segments

    /**
     * Lists all active CAT point-in-time segments.
     */
    public CompletableFuture<AllPitSegmentsResponse> allPitSegments(AllPitSegmentsRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, AllPitSegmentsRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Lists all active CAT point-in-time segments.
     *
     * @param fn a function that initializes a builder to create the {@link AllPitSegmentsRequest}
     */
    public final CompletableFuture<AllPitSegmentsResponse> allPitSegments(
        Function<AllPitSegmentsRequest.Builder, ObjectBuilder<AllPitSegmentsRequest>> fn
    ) throws IOException, OpenSearchException {
        return allPitSegments(fn.apply(new AllPitSegmentsRequest.Builder()).build());
    }

    /**
     * Lists all active CAT point-in-time segments.
     */
    public final CompletableFuture<AllPitSegmentsResponse> allPitSegments() throws IOException, OpenSearchException {
        return allPitSegments(new AllPitSegmentsRequest.Builder().build());
    }

    // ----- Endpoint: cat.allocation

    /**
     * Provides a snapshot of how many shards are allocated to each data node and how much disk space they are using.
     */
    public CompletableFuture<AllocationResponse> allocation(AllocationRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, AllocationRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Provides a snapshot of how many shards are allocated to each data node and how much disk space they are using.
     *
     * @param fn a function that initializes a builder to create the {@link AllocationRequest}
     */
    public final CompletableFuture<AllocationResponse> allocation(Function<AllocationRequest.Builder, ObjectBuilder<AllocationRequest>> fn)
        throws IOException, OpenSearchException {
        return allocation(fn.apply(new AllocationRequest.Builder()).build());
    }

    /**
     * Provides a snapshot of how many shards are allocated to each data node and how much disk space they are using.
     */
    public final CompletableFuture<AllocationResponse> allocation() throws IOException, OpenSearchException {
        return allocation(new AllocationRequest.Builder().build());
    }

    // ----- Endpoint: cat.cluster_manager

    /**
     * Returns information about the cluster-manager node.
     */
    public CompletableFuture<ClusterManagerResponse> clusterManager(ClusterManagerRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, ClusterManagerRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Returns information about the cluster-manager node.
     *
     * @param fn a function that initializes a builder to create the {@link ClusterManagerRequest}
     */
    public final CompletableFuture<ClusterManagerResponse> clusterManager(
        Function<ClusterManagerRequest.Builder, ObjectBuilder<ClusterManagerRequest>> fn
    ) throws IOException, OpenSearchException {
        return clusterManager(fn.apply(new ClusterManagerRequest.Builder()).build());
    }

    /**
     * Returns information about the cluster-manager node.
     */
    public final CompletableFuture<ClusterManagerResponse> clusterManager() throws IOException, OpenSearchException {
        return clusterManager(new ClusterManagerRequest.Builder().build());
    }

    // ----- Endpoint: cat.count

    /**
     * Provides quick access to the document count of the entire cluster or of an individual index.
     */
    public CompletableFuture<CountResponse> count(CountRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, CountRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Provides quick access to the document count of the entire cluster or of an individual index.
     *
     * @param fn a function that initializes a builder to create the {@link CountRequest}
     */
    public final CompletableFuture<CountResponse> count(Function<CountRequest.Builder, ObjectBuilder<CountRequest>> fn) throws IOException,
        OpenSearchException {
        return count(fn.apply(new CountRequest.Builder()).build());
    }

    /**
     * Provides quick access to the document count of the entire cluster or of an individual index.
     */
    public final CompletableFuture<CountResponse> count() throws IOException, OpenSearchException {
        return count(new CountRequest.Builder().build());
    }

    // ----- Endpoint: cat.fielddata

    /**
     * Shows how much heap memory is currently being used by field data on every data node in the cluster.
     */
    public CompletableFuture<FielddataResponse> fielddata(FielddataRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, FielddataRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Shows how much heap memory is currently being used by field data on every data node in the cluster.
     *
     * @param fn a function that initializes a builder to create the {@link FielddataRequest}
     */
    public final CompletableFuture<FielddataResponse> fielddata(Function<FielddataRequest.Builder, ObjectBuilder<FielddataRequest>> fn)
        throws IOException, OpenSearchException {
        return fielddata(fn.apply(new FielddataRequest.Builder()).build());
    }

    /**
     * Shows how much heap memory is currently being used by field data on every data node in the cluster.
     */
    public final CompletableFuture<FielddataResponse> fielddata() throws IOException, OpenSearchException {
        return fielddata(new FielddataRequest.Builder().build());
    }

    // ----- Endpoint: cat.health

    /**
     * Returns a concise representation of the cluster health.
     */
    public CompletableFuture<HealthResponse> health(HealthRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, HealthRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Returns a concise representation of the cluster health.
     *
     * @param fn a function that initializes a builder to create the {@link HealthRequest}
     */
    public final CompletableFuture<HealthResponse> health(Function<HealthRequest.Builder, ObjectBuilder<HealthRequest>> fn)
        throws IOException, OpenSearchException {
        return health(fn.apply(new HealthRequest.Builder()).build());
    }

    /**
     * Returns a concise representation of the cluster health.
     */
    public final CompletableFuture<HealthResponse> health() throws IOException, OpenSearchException {
        return health(new HealthRequest.Builder().build());
    }

    // ----- Endpoint: cat.indices

    /**
     * Lists information related to indexes, that is, how much disk space they are using, how many shards they have, their health status,
     * and so on.
     */
    public CompletableFuture<IndicesResponse> indices(IndicesRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, IndicesRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Lists information related to indexes, that is, how much disk space they are using, how many shards they have, their health status,
     * and so on.
     *
     * @param fn a function that initializes a builder to create the {@link IndicesRequest}
     */
    public final CompletableFuture<IndicesResponse> indices(Function<IndicesRequest.Builder, ObjectBuilder<IndicesRequest>> fn)
        throws IOException, OpenSearchException {
        return indices(fn.apply(new IndicesRequest.Builder()).build());
    }

    /**
     * Lists information related to indexes, that is, how much disk space they are using, how many shards they have, their health status,
     * and so on.
     */
    public final CompletableFuture<IndicesResponse> indices() throws IOException, OpenSearchException {
        return indices(new IndicesRequest.Builder().build());
    }

    // ----- Endpoint: cat.master

    /**
     * Returns information about the cluster-manager node.
     */
    @Deprecated
    public CompletableFuture<MasterResponse> master(MasterRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, MasterRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Returns information about the cluster-manager node.
     *
     * @param fn a function that initializes a builder to create the {@link MasterRequest}
     */
    @Deprecated
    public final CompletableFuture<MasterResponse> master(Function<MasterRequest.Builder, ObjectBuilder<MasterRequest>> fn)
        throws IOException, OpenSearchException {
        return master(fn.apply(new MasterRequest.Builder()).build());
    }

    /**
     * Returns information about the cluster-manager node.
     */
    @Deprecated
    public final CompletableFuture<MasterResponse> master() throws IOException, OpenSearchException {
        return master(new MasterRequest.Builder().build());
    }

    // ----- Endpoint: cat.nodeattrs

    /**
     * Returns information about custom node attributes.
     */
    public CompletableFuture<NodeattrsResponse> nodeattrs(NodeattrsRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, NodeattrsRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Returns information about custom node attributes.
     *
     * @param fn a function that initializes a builder to create the {@link NodeattrsRequest}
     */
    public final CompletableFuture<NodeattrsResponse> nodeattrs(Function<NodeattrsRequest.Builder, ObjectBuilder<NodeattrsRequest>> fn)
        throws IOException, OpenSearchException {
        return nodeattrs(fn.apply(new NodeattrsRequest.Builder()).build());
    }

    /**
     * Returns information about custom node attributes.
     */
    public final CompletableFuture<NodeattrsResponse> nodeattrs() throws IOException, OpenSearchException {
        return nodeattrs(new NodeattrsRequest.Builder().build());
    }

    // ----- Endpoint: cat.nodes

    /**
     * Returns basic statistics about the performance of cluster nodes.
     */
    public CompletableFuture<NodesResponse> nodes(NodesRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, NodesRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Returns basic statistics about the performance of cluster nodes.
     *
     * @param fn a function that initializes a builder to create the {@link NodesRequest}
     */
    public final CompletableFuture<NodesResponse> nodes(Function<NodesRequest.Builder, ObjectBuilder<NodesRequest>> fn) throws IOException,
        OpenSearchException {
        return nodes(fn.apply(new NodesRequest.Builder()).build());
    }

    /**
     * Returns basic statistics about the performance of cluster nodes.
     */
    public final CompletableFuture<NodesResponse> nodes() throws IOException, OpenSearchException {
        return nodes(new NodesRequest.Builder().build());
    }

    // ----- Endpoint: cat.pending_tasks

    /**
     * Returns a concise representation of the cluster's pending tasks.
     */
    public CompletableFuture<PendingTasksResponse> pendingTasks(PendingTasksRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, PendingTasksRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Returns a concise representation of the cluster's pending tasks.
     *
     * @param fn a function that initializes a builder to create the {@link PendingTasksRequest}
     */
    public final CompletableFuture<PendingTasksResponse> pendingTasks(
        Function<PendingTasksRequest.Builder, ObjectBuilder<PendingTasksRequest>> fn
    ) throws IOException, OpenSearchException {
        return pendingTasks(fn.apply(new PendingTasksRequest.Builder()).build());
    }

    /**
     * Returns a concise representation of the cluster's pending tasks.
     */
    public final CompletableFuture<PendingTasksResponse> pendingTasks() throws IOException, OpenSearchException {
        return pendingTasks(new PendingTasksRequest.Builder().build());
    }

    // ----- Endpoint: cat.pit_segments

    /**
     * Lists one or several CAT point-in-time segments.
     */
    public CompletableFuture<PitSegmentsResponse> pitSegments(PitSegmentsRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, PitSegmentsRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Lists one or several CAT point-in-time segments.
     *
     * @param fn a function that initializes a builder to create the {@link PitSegmentsRequest}
     */
    public final CompletableFuture<PitSegmentsResponse> pitSegments(
        Function<PitSegmentsRequest.Builder, ObjectBuilder<PitSegmentsRequest>> fn
    ) throws IOException, OpenSearchException {
        return pitSegments(fn.apply(new PitSegmentsRequest.Builder()).build());
    }

    // ----- Endpoint: cat.plugins

    /**
     * Returns information about the names, components, and versions of the installed plugins.
     */
    public CompletableFuture<PluginsResponse> plugins(PluginsRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, PluginsRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Returns information about the names, components, and versions of the installed plugins.
     *
     * @param fn a function that initializes a builder to create the {@link PluginsRequest}
     */
    public final CompletableFuture<PluginsResponse> plugins(Function<PluginsRequest.Builder, ObjectBuilder<PluginsRequest>> fn)
        throws IOException, OpenSearchException {
        return plugins(fn.apply(new PluginsRequest.Builder()).build());
    }

    /**
     * Returns information about the names, components, and versions of the installed plugins.
     */
    public final CompletableFuture<PluginsResponse> plugins() throws IOException, OpenSearchException {
        return plugins(new PluginsRequest.Builder().build());
    }
}
