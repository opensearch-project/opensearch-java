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

package org.opensearch.clients.opensearch.api.cat;

import org.opensearch.client.RequestOptions;
import org.opensearch.clients.base.ApiClient;
import org.opensearch.clients.base.Transport;
import org.opensearch.clients.opensearch.cat.AliasesRequest;
import org.opensearch.clients.opensearch.cat.AliasesResponse;
import org.opensearch.clients.opensearch.cat.AllocationRequest;
import org.opensearch.clients.opensearch.cat.AllocationResponse;
import org.opensearch.clients.opensearch.cat.CountRequest;
import org.opensearch.clients.opensearch.cat.CountResponse;
import org.opensearch.clients.opensearch.cat.FielddataRequest;
import org.opensearch.clients.opensearch.cat.FielddataResponse;
import org.opensearch.clients.opensearch.cat.HealthRequest;
import org.opensearch.clients.opensearch.cat.HealthResponse;
import org.opensearch.clients.opensearch.cat.HelpRequest;
import org.opensearch.clients.opensearch.cat.HelpResponse;
import org.opensearch.clients.opensearch.cat.IndicesRequest;
import org.opensearch.clients.opensearch.cat.IndicesResponse;
import org.opensearch.clients.opensearch.cat.MasterRequest;
import org.opensearch.clients.opensearch.cat.MasterResponse;
import org.opensearch.clients.opensearch.cat.NodeAttributesRequest;
import org.opensearch.clients.opensearch.cat.NodeAttributesResponse;
import org.opensearch.clients.opensearch.cat.NodesRequest;
import org.opensearch.clients.opensearch.cat.NodesResponse;
import org.opensearch.clients.opensearch.cat.PendingTasksRequest;
import org.opensearch.clients.opensearch.cat.PendingTasksResponse;
import org.opensearch.clients.opensearch.cat.PluginsRequest;
import org.opensearch.clients.opensearch.cat.PluginsResponse;
import org.opensearch.clients.opensearch.cat.RecoveryRequest;
import org.opensearch.clients.opensearch.cat.RecoveryResponse;
import org.opensearch.clients.opensearch.cat.RepositoriesRequest;
import org.opensearch.clients.opensearch.cat.RepositoriesResponse;
import org.opensearch.clients.opensearch.cat.SegmentsRequest;
import org.opensearch.clients.opensearch.cat.SegmentsResponse;
import org.opensearch.clients.opensearch.cat.ShardsRequest;
import org.opensearch.clients.opensearch.cat.ShardsResponse;
import org.opensearch.clients.opensearch.cat.SnapshotsRequest;
import org.opensearch.clients.opensearch.cat.SnapshotsResponse;
import org.opensearch.clients.opensearch.cat.TasksRequest;
import org.opensearch.clients.opensearch.cat.TasksResponse;
import org.opensearch.clients.opensearch.cat.TemplatesRequest;
import org.opensearch.clients.opensearch.cat.TemplatesResponse;
import org.opensearch.clients.opensearch.cat.ThreadPoolRequest;
import org.opensearch.clients.opensearch.cat.ThreadPoolResponse;
import org.opensearch.clients.util.ObjectBuilder;

import javax.annotation.Nullable;
import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;

/**
 * Client for the cat namespace.
 */
public class CatAsyncClient extends ApiClient<CatAsyncClient> {

	public CatAsyncClient(Transport transport) {
		super(transport, null);
	}

	public CatAsyncClient(Transport transport, RequestOptions options) {
		super(transport, options);
	}

	// ----- Endpoint: cat.aliases

	/**
	 * Shows information about currently configured aliases to indices including
	 * filter and routing infos.
	 *
	 */

	public CompletableFuture<AliasesResponse> aliases(AliasesRequest request) throws IOException {
		return this.transport.performRequestAsync(request, AliasesRequest.ENDPOINT, this.requestOptions);
	}

	/**
	 * Shows information about currently configured aliases to indices including
	 * filter and routing infos.
	 *
	 * @param fn
	 *            a function that initializes a freshly created builder. This
	 *            function can either return its builder argument after having set
	 *            its properties or return another builder.
	 */

	public final CompletableFuture<AliasesResponse> aliases(
			Function<AliasesRequest.Builder, ObjectBuilder<AliasesRequest>> fn) throws IOException {
		return aliases(fn.apply(new AliasesRequest.Builder()).build());
	}

	// ----- Endpoint: cat.allocation

	/**
	 * Provides a snapshot of how many shards are allocated to each data node and
	 * how much disk space they are using.
	 *
	 */

	public CompletableFuture<AllocationResponse> allocation(AllocationRequest request) throws IOException {
		return this.transport.performRequestAsync(request, AllocationRequest.ENDPOINT, this.requestOptions);
	}

	/**
	 * Provides a snapshot of how many shards are allocated to each data node and
	 * how much disk space they are using.
	 *
	 * @param fn
	 *            a function that initializes a freshly created builder. This
	 *            function can either return its builder argument after having set
	 *            its properties or return another builder.
	 */

	public final CompletableFuture<AllocationResponse> allocation(
			Function<AllocationRequest.Builder, ObjectBuilder<AllocationRequest>> fn) throws IOException {
		return allocation(fn.apply(new AllocationRequest.Builder()).build());
	}

	// ----- Endpoint: cat.count

	/**
	 * Provides quick access to the document count of the entire cluster, or
	 * individual indices.
	 *
	 */

	public CompletableFuture<CountResponse> count(CountRequest request) throws IOException {
		return this.transport.performRequestAsync(request, CountRequest.ENDPOINT, this.requestOptions);
	}

	/**
	 * Provides quick access to the document count of the entire cluster, or
	 * individual indices.
	 *
	 * @param fn
	 *            a function that initializes a freshly created builder. This
	 *            function can either return its builder argument after having set
	 *            its properties or return another builder.
	 */

	public final CompletableFuture<CountResponse> count(Function<CountRequest.Builder, ObjectBuilder<CountRequest>> fn)
			throws IOException {
		return count(fn.apply(new CountRequest.Builder()).build());
	}

	// ----- Endpoint: cat.fielddata

	/**
	 * Shows how much heap memory is currently being used by fielddata on every data
	 * node in the cluster.
	 *
	 */

	public CompletableFuture<FielddataResponse> fielddata(FielddataRequest request) throws IOException {
		return this.transport.performRequestAsync(request, FielddataRequest.ENDPOINT, this.requestOptions);
	}

	/**
	 * Shows how much heap memory is currently being used by fielddata on every data
	 * node in the cluster.
	 *
	 * @param fn
	 *            a function that initializes a freshly created builder. This
	 *            function can either return its builder argument after having set
	 *            its properties or return another builder.
	 */

	public final CompletableFuture<FielddataResponse> fielddata(
			Function<FielddataRequest.Builder, ObjectBuilder<FielddataRequest>> fn) throws IOException {
		return fielddata(fn.apply(new FielddataRequest.Builder()).build());
	}

	// ----- Endpoint: cat.health

	/**
	 * Returns a concise representation of the cluster health.
	 *
	 */

	public CompletableFuture<HealthResponse> health(HealthRequest request) throws IOException {
		return this.transport.performRequestAsync(request, HealthRequest.ENDPOINT, this.requestOptions);
	}

	/**
	 * Returns a concise representation of the cluster health.
	 *
	 * @param fn
	 *            a function that initializes a freshly created builder. This
	 *            function can either return its builder argument after having set
	 *            its properties or return another builder.
	 */

	public final CompletableFuture<HealthResponse> health(
			Function<HealthRequest.Builder, ObjectBuilder<HealthRequest>> fn) throws IOException {
		return health(fn.apply(new HealthRequest.Builder()).build());
	}

	// ----- Endpoint: cat.help

	/**
	 * Returns help for the Cat APIs.
	 *
	 */
	public CompletableFuture<HelpResponse> help() throws IOException {
		return this.transport.performRequestAsync(HelpRequest.INSTANCE, HelpRequest.ENDPOINT, this.requestOptions);
	}

	// ----- Endpoint: cat.indices

	/**
	 * Returns information about indices: number of primaries and replicas, document
	 * counts, disk size, ...
	 *
	 */

	public CompletableFuture<IndicesResponse> indices(IndicesRequest request) throws IOException {
		return this.transport.performRequestAsync(request, IndicesRequest.ENDPOINT, this.requestOptions);
	}

	/**
	 * Returns information about indices: number of primaries and replicas, document
	 * counts, disk size, ...
	 *
	 * @param fn
	 *            a function that initializes a freshly created builder. This
	 *            function can either return its builder argument after having set
	 *            its properties or return another builder.
	 */

	public final CompletableFuture<IndicesResponse> indices(
			Function<IndicesRequest.Builder, ObjectBuilder<IndicesRequest>> fn) throws IOException {
		return indices(fn.apply(new IndicesRequest.Builder()).build());
	}

	// ----- Endpoint: cat.master

	/**
	 * Returns information about the master node.
	 *
	 */
	public CompletableFuture<MasterResponse> master() throws IOException {
		return this.transport.performRequestAsync(MasterRequest.INSTANCE, MasterRequest.ENDPOINT, this.requestOptions);
	}

	// ----- Endpoint: cat.nodeattrs

	/**
	 * Returns information about custom node attributes.
	 *
	 */
	public CompletableFuture<NodeAttributesResponse> nodeattrs() throws IOException {
		return this.transport.performRequestAsync(NodeAttributesRequest.INSTANCE, NodeAttributesRequest.ENDPOINT,
				this.requestOptions);
	}

	// ----- Endpoint: cat.nodes

	/**
	 * Returns basic statistics about performance of cluster nodes.
	 *
	 */

	public CompletableFuture<NodesResponse> nodes(NodesRequest request) throws IOException {
		return this.transport.performRequestAsync(request, NodesRequest.ENDPOINT, this.requestOptions);
	}

	/**
	 * Returns basic statistics about performance of cluster nodes.
	 *
	 * @param fn
	 *            a function that initializes a freshly created builder. This
	 *            function can either return its builder argument after having set
	 *            its properties or return another builder.
	 */

	public final CompletableFuture<NodesResponse> nodes(Function<NodesRequest.Builder, ObjectBuilder<NodesRequest>> fn)
			throws IOException {
		return nodes(fn.apply(new NodesRequest.Builder()).build());
	}

	// ----- Endpoint: cat.pending_tasks

	/**
	 * Returns a concise representation of the cluster pending tasks.
	 *
	 */
	public CompletableFuture<PendingTasksResponse> pendingTasks() throws IOException {
		return this.transport.performRequestAsync(PendingTasksRequest.INSTANCE, PendingTasksRequest.ENDPOINT,
				this.requestOptions);
	}

	// ----- Endpoint: cat.plugins

	/**
	 * Returns information about installed plugins across nodes node.
	 *
	 */
	public CompletableFuture<PluginsResponse> plugins() throws IOException {
		return this.transport.performRequestAsync(PluginsRequest.INSTANCE, PluginsRequest.ENDPOINT,
				this.requestOptions);
	}

	// ----- Endpoint: cat.recovery

	/**
	 * Returns information about index shard recoveries, both on-going completed.
	 *
	 */

	public CompletableFuture<RecoveryResponse> recovery(RecoveryRequest request) throws IOException {
		return this.transport.performRequestAsync(request, RecoveryRequest.ENDPOINT, this.requestOptions);
	}

	/**
	 * Returns information about index shard recoveries, both on-going completed.
	 *
	 * @param fn
	 *            a function that initializes a freshly created builder. This
	 *            function can either return its builder argument after having set
	 *            its properties or return another builder.
	 */

	public final CompletableFuture<RecoveryResponse> recovery(
			Function<RecoveryRequest.Builder, ObjectBuilder<RecoveryRequest>> fn) throws IOException {
		return recovery(fn.apply(new RecoveryRequest.Builder()).build());
	}

	// ----- Endpoint: cat.repositories

	/**
	 * Returns information about snapshot repositories registered in the cluster.
	 *
	 */
	public CompletableFuture<RepositoriesResponse> repositories() throws IOException {
		return this.transport.performRequestAsync(RepositoriesRequest.INSTANCE, RepositoriesRequest.ENDPOINT,
				this.requestOptions);
	}

	// ----- Endpoint: cat.segments

	/**
	 * Provides low-level information about the segments in the shards of an index.
	 *
	 */

	public CompletableFuture<SegmentsResponse> segments(SegmentsRequest request) throws IOException {
		return this.transport.performRequestAsync(request, SegmentsRequest.ENDPOINT, this.requestOptions);
	}

	/**
	 * Provides low-level information about the segments in the shards of an index.
	 *
	 * @param fn
	 *            a function that initializes a freshly created builder. This
	 *            function can either return its builder argument after having set
	 *            its properties or return another builder.
	 */

	public final CompletableFuture<SegmentsResponse> segments(
			Function<SegmentsRequest.Builder, ObjectBuilder<SegmentsRequest>> fn) throws IOException {
		return segments(fn.apply(new SegmentsRequest.Builder()).build());
	}

	// ----- Endpoint: cat.shards

	/**
	 * Provides a detailed view of shard allocation on nodes.
	 *
	 */

	public CompletableFuture<ShardsResponse> shards(ShardsRequest request) throws IOException {
		return this.transport.performRequestAsync(request, ShardsRequest.ENDPOINT, this.requestOptions);
	}

	/**
	 * Provides a detailed view of shard allocation on nodes.
	 *
	 * @param fn
	 *            a function that initializes a freshly created builder. This
	 *            function can either return its builder argument after having set
	 *            its properties or return another builder.
	 */

	public final CompletableFuture<ShardsResponse> shards(
			Function<ShardsRequest.Builder, ObjectBuilder<ShardsRequest>> fn) throws IOException {
		return shards(fn.apply(new ShardsRequest.Builder()).build());
	}

	// ----- Endpoint: cat.snapshots

	/**
	 * Returns all snapshots in a specific repository.
	 *
	 */

	public CompletableFuture<SnapshotsResponse> snapshots(SnapshotsRequest request) throws IOException {
		return this.transport.performRequestAsync(request, SnapshotsRequest.ENDPOINT, this.requestOptions);
	}

	/**
	 * Returns all snapshots in a specific repository.
	 *
	 * @param fn
	 *            a function that initializes a freshly created builder. This
	 *            function can either return its builder argument after having set
	 *            its properties or return another builder.
	 */

	public final CompletableFuture<SnapshotsResponse> snapshots(
			Function<SnapshotsRequest.Builder, ObjectBuilder<SnapshotsRequest>> fn) throws IOException {
		return snapshots(fn.apply(new SnapshotsRequest.Builder()).build());
	}

	// ----- Endpoint: cat.tasks

	/**
	 * Returns information about the tasks currently executing on one or more nodes
	 * in the cluster.
	 *
	 */

	public CompletableFuture<TasksResponse> tasks(TasksRequest request) throws IOException {
		return this.transport.performRequestAsync(request, TasksRequest.ENDPOINT, this.requestOptions);
	}

	/**
	 * Returns information about the tasks currently executing on one or more nodes
	 * in the cluster.
	 *
	 * @param fn
	 *            a function that initializes a freshly created builder. This
	 *            function can either return its builder argument after having set
	 *            its properties or return another builder.
	 */

	public final CompletableFuture<TasksResponse> tasks(Function<TasksRequest.Builder, ObjectBuilder<TasksRequest>> fn)
			throws IOException {
		return tasks(fn.apply(new TasksRequest.Builder()).build());
	}

	// ----- Endpoint: cat.templates

	/**
	 * Returns information about existing templates.
	 *
	 */

	public CompletableFuture<TemplatesResponse> templates(TemplatesRequest request) throws IOException {
		return this.transport.performRequestAsync(request, TemplatesRequest.ENDPOINT, this.requestOptions);
	}

	/**
	 * Returns information about existing templates.
	 *
	 * @param fn
	 *            a function that initializes a freshly created builder. This
	 *            function can either return its builder argument after having set
	 *            its properties or return another builder.
	 */

	public final CompletableFuture<TemplatesResponse> templates(
			Function<TemplatesRequest.Builder, ObjectBuilder<TemplatesRequest>> fn) throws IOException {
		return templates(fn.apply(new TemplatesRequest.Builder()).build());
	}

	// ----- Endpoint: cat.thread_pool

	/**
	 * Returns cluster-wide thread pool statistics per node. By default the active,
	 * queue and rejected statistics are returned for all thread pools.
	 *
	 */

	public CompletableFuture<ThreadPoolResponse> threadPool(ThreadPoolRequest request) throws IOException {
		return this.transport.performRequestAsync(request, ThreadPoolRequest.ENDPOINT, this.requestOptions);
	}

	/**
	 * Returns cluster-wide thread pool statistics per node. By default the active,
	 * queue and rejected statistics are returned for all thread pools.
	 *
	 * @param fn
	 *            a function that initializes a freshly created builder. This
	 *            function can either return its builder argument after having set
	 *            its properties or return another builder.
	 */

	public final CompletableFuture<ThreadPoolResponse> threadPool(
			Function<ThreadPoolRequest.Builder, ObjectBuilder<ThreadPoolRequest>> fn) throws IOException {
		return threadPool(fn.apply(new ThreadPoolRequest.Builder()).build());
	}

	// ----- Misc

	/**
	 * Creates a new {@link #CatAsyncClient} with specific request options.
	 */
	@Override
	public CatAsyncClient withRequestOptions(@Nullable RequestOptions options) {
		return new CatAsyncClient(transport, options);
	}

	/**
	 * Creates a new {@link #CatAsyncClient} with specific request options,
	 * inheriting existing options.
	 *
	 * @param fn
	 *            a function taking an options builder initialized with the current
	 *            request options, or initialized with default values.
	 */
	public CatAsyncClient withRequestOptions(Function<RequestOptions.Builder, RequestOptions.Builder> fn) {
		RequestOptions.Builder builder = requestOptions == null
				? RequestOptions.DEFAULT.toBuilder()
				: requestOptions.toBuilder();

		return withRequestOptions(fn.apply(builder).build());
	}
}
