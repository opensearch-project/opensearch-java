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

//----------------------------------------------------
// THIS CODE IS GENERATED. MANUAL EDITS WILL BE LOST.
//----------------------------------------------------

package org.opensearch.clients.opensearch.api.cat;

import org.elasticsearch.client.RequestOptions;
import org.opensearch.clients.base.ApiClient;
import org.opensearch.clients.base.Transport;
import org.opensearch.clients.opensearch.cat.AliasesRequest;
import org.opensearch.clients.opensearch.cat.AliasesResponse;
import org.opensearch.clients.opensearch.cat.AllocationRequest;
import org.opensearch.clients.opensearch.cat.AllocationResponse;
import org.opensearch.clients.opensearch.cat.CountRequest;
import org.opensearch.clients.opensearch.cat.CountResponse;
import org.opensearch.clients.opensearch.cat.DataFrameAnalyticsRequest;
import org.opensearch.clients.opensearch.cat.DataFrameAnalyticsResponse;
import org.opensearch.clients.opensearch.cat.DatafeedsRequest;
import org.opensearch.clients.opensearch.cat.DatafeedsResponse;
import org.opensearch.clients.opensearch.cat.FielddataRequest;
import org.opensearch.clients.opensearch.cat.FielddataResponse;
import org.opensearch.clients.opensearch.cat.HealthRequest;
import org.opensearch.clients.opensearch.cat.HealthResponse;
import org.opensearch.clients.opensearch.cat.HelpRequest;
import org.opensearch.clients.opensearch.cat.HelpResponse;
import org.opensearch.clients.opensearch.cat.IndicesRequest;
import org.opensearch.clients.opensearch.cat.IndicesResponse;
import org.opensearch.clients.opensearch.cat.JobsRequest;
import org.opensearch.clients.opensearch.cat.JobsResponse;
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
import org.opensearch.clients.opensearch.cat.TrainedModelsRequest;
import org.opensearch.clients.opensearch.cat.TrainedModelsResponse;
import org.opensearch.clients.opensearch.cat.TransformsRequest;
import org.opensearch.clients.opensearch.cat.TransformsResponse;
import org.opensearch.clients.util.ObjectBuilder;

import javax.annotation.Nullable;
import java.io.IOException;
import java.util.function.Function;

/**
 * Client for the cat namespace.
 */
public class CatClient extends ApiClient<CatClient> {

	public CatClient(Transport transport) {
		super(transport, null);
	}

	public CatClient(Transport transport, RequestOptions options) {
		super(transport, options);
	}

	// ----- Endpoint: cat.aliases

	/**
	 * Shows information about currently configured aliases to indices including
	 * filter and routing infos.
	 *
	 * @see "https://www.elastic.co/guide/en/elasticsearch/reference/master/cat-alias.html"
	 */

	public AliasesResponse aliases(AliasesRequest request) throws IOException {
		return this.transport.performRequest(request, AliasesRequest.ENDPOINT, this.requestOptions);
	}

	/**
	 * Shows information about currently configured aliases to indices including
	 * filter and routing infos.
	 *
	 * @see "https://www.elastic.co/guide/en/elasticsearch/reference/master/cat-alias.html"
	 * @param fn
	 *            a function that initializes a freshly created builder. This
	 *            function can either return its builder argument after having set
	 *            its properties or return another builder.
	 */

	public final AliasesResponse aliases(Function<AliasesRequest.Builder, ObjectBuilder<AliasesRequest>> fn)
			throws IOException {
		return aliases(fn.apply(new AliasesRequest.Builder()).build());
	}

	// ----- Endpoint: cat.allocation

	/**
	 * Provides a snapshot of how many shards are allocated to each data node and
	 * how much disk space they are using.
	 *
	 * @see "https://www.elastic.co/guide/en/elasticsearch/reference/master/cat-allocation.html"
	 */

	public AllocationResponse allocation(AllocationRequest request) throws IOException {
		return this.transport.performRequest(request, AllocationRequest.ENDPOINT, this.requestOptions);
	}

	/**
	 * Provides a snapshot of how many shards are allocated to each data node and
	 * how much disk space they are using.
	 *
	 * @see "https://www.elastic.co/guide/en/elasticsearch/reference/master/cat-allocation.html"
	 * @param fn
	 *            a function that initializes a freshly created builder. This
	 *            function can either return its builder argument after having set
	 *            its properties or return another builder.
	 */

	public final AllocationResponse allocation(Function<AllocationRequest.Builder, ObjectBuilder<AllocationRequest>> fn)
			throws IOException {
		return allocation(fn.apply(new AllocationRequest.Builder()).build());
	}

	// ----- Endpoint: cat.count

	/**
	 * Provides quick access to the document count of the entire cluster, or
	 * individual indices.
	 *
	 * @see "https://www.elastic.co/guide/en/elasticsearch/reference/master/cat-count.html"
	 */

	public CountResponse count(CountRequest request) throws IOException {
		return this.transport.performRequest(request, CountRequest.ENDPOINT, this.requestOptions);
	}

	/**
	 * Provides quick access to the document count of the entire cluster, or
	 * individual indices.
	 *
	 * @see "https://www.elastic.co/guide/en/elasticsearch/reference/master/cat-count.html"
	 * @param fn
	 *            a function that initializes a freshly created builder. This
	 *            function can either return its builder argument after having set
	 *            its properties or return another builder.
	 */

	public final CountResponse count(Function<CountRequest.Builder, ObjectBuilder<CountRequest>> fn)
			throws IOException {
		return count(fn.apply(new CountRequest.Builder()).build());
	}

	// ----- Endpoint: cat.fielddata

	/**
	 * Shows how much heap memory is currently being used by fielddata on every data
	 * node in the cluster.
	 *
	 * @see "https://www.elastic.co/guide/en/elasticsearch/reference/master/cat-fielddata.html"
	 */

	public FielddataResponse fielddata(FielddataRequest request) throws IOException {
		return this.transport.performRequest(request, FielddataRequest.ENDPOINT, this.requestOptions);
	}

	/**
	 * Shows how much heap memory is currently being used by fielddata on every data
	 * node in the cluster.
	 *
	 * @see "https://www.elastic.co/guide/en/elasticsearch/reference/master/cat-fielddata.html"
	 * @param fn
	 *            a function that initializes a freshly created builder. This
	 *            function can either return its builder argument after having set
	 *            its properties or return another builder.
	 */

	public final FielddataResponse fielddata(Function<FielddataRequest.Builder, ObjectBuilder<FielddataRequest>> fn)
			throws IOException {
		return fielddata(fn.apply(new FielddataRequest.Builder()).build());
	}

	// ----- Endpoint: cat.health

	/**
	 * Returns a concise representation of the cluster health.
	 *
	 * @see "https://www.elastic.co/guide/en/elasticsearch/reference/master/cat-health.html"
	 */

	public HealthResponse health(HealthRequest request) throws IOException {
		return this.transport.performRequest(request, HealthRequest.ENDPOINT, this.requestOptions);
	}

	/**
	 * Returns a concise representation of the cluster health.
	 *
	 * @see "https://www.elastic.co/guide/en/elasticsearch/reference/master/cat-health.html"
	 * @param fn
	 *            a function that initializes a freshly created builder. This
	 *            function can either return its builder argument after having set
	 *            its properties or return another builder.
	 */

	public final HealthResponse health(Function<HealthRequest.Builder, ObjectBuilder<HealthRequest>> fn)
			throws IOException {
		return health(fn.apply(new HealthRequest.Builder()).build());
	}

	// ----- Endpoint: cat.help

	/**
	 * Returns help for the Cat APIs.
	 *
	 * @see "https://www.elastic.co/guide/en/elasticsearch/reference/master/cat.html"
	 */
	public HelpResponse help() throws IOException {
		return this.transport.performRequest(HelpRequest.INSTANCE, HelpRequest.ENDPOINT, this.requestOptions);
	}

	// ----- Endpoint: cat.indices

	/**
	 * Returns information about indices: number of primaries and replicas, document
	 * counts, disk size, ...
	 *
	 * @see "https://www.elastic.co/guide/en/elasticsearch/reference/master/cat-indices.html"
	 */

	public IndicesResponse indices(IndicesRequest request) throws IOException {
		return this.transport.performRequest(request, IndicesRequest.ENDPOINT, this.requestOptions);
	}

	/**
	 * Returns information about indices: number of primaries and replicas, document
	 * counts, disk size, ...
	 *
	 * @see "https://www.elastic.co/guide/en/elasticsearch/reference/master/cat-indices.html"
	 * @param fn
	 *            a function that initializes a freshly created builder. This
	 *            function can either return its builder argument after having set
	 *            its properties or return another builder.
	 */

	public final IndicesResponse indices(Function<IndicesRequest.Builder, ObjectBuilder<IndicesRequest>> fn)
			throws IOException {
		return indices(fn.apply(new IndicesRequest.Builder()).build());
	}

	// ----- Endpoint: cat.master

	/**
	 * Returns information about the master node.
	 *
	 * @see "https://www.elastic.co/guide/en/elasticsearch/reference/master/cat-master.html"
	 */
	public MasterResponse master() throws IOException {
		return this.transport.performRequest(MasterRequest.INSTANCE, MasterRequest.ENDPOINT, this.requestOptions);
	}

	// ----- Endpoint: cat.ml_data_frame_analytics

	/**
	 * Gets configuration and usage information about data frame analytics jobs.
	 *
	 * @see "http://www.elastic.co/guide/en/elasticsearch/reference/current/cat-dfanalytics.html"
	 */

	public DataFrameAnalyticsResponse mlDataFrameAnalytics(DataFrameAnalyticsRequest request) throws IOException {
		return this.transport.performRequest(request, DataFrameAnalyticsRequest.ENDPOINT, this.requestOptions);
	}

	/**
	 * Gets configuration and usage information about data frame analytics jobs.
	 *
	 * @see "http://www.elastic.co/guide/en/elasticsearch/reference/current/cat-dfanalytics.html"
	 * @param fn
	 *            a function that initializes a freshly created builder. This
	 *            function can either return its builder argument after having set
	 *            its properties or return another builder.
	 */

	public final DataFrameAnalyticsResponse mlDataFrameAnalytics(
			Function<DataFrameAnalyticsRequest.Builder, ObjectBuilder<DataFrameAnalyticsRequest>> fn)
			throws IOException {
		return mlDataFrameAnalytics(fn.apply(new DataFrameAnalyticsRequest.Builder()).build());
	}

	// ----- Endpoint: cat.ml_datafeeds

	/**
	 * Gets configuration and usage information about datafeeds.
	 *
	 * @see "http://www.elastic.co/guide/en/elasticsearch/reference/current/cat-datafeeds.html"
	 */

	public DatafeedsResponse mlDatafeeds(DatafeedsRequest request) throws IOException {
		return this.transport.performRequest(request, DatafeedsRequest.ENDPOINT, this.requestOptions);
	}

	/**
	 * Gets configuration and usage information about datafeeds.
	 *
	 * @see "http://www.elastic.co/guide/en/elasticsearch/reference/current/cat-datafeeds.html"
	 * @param fn
	 *            a function that initializes a freshly created builder. This
	 *            function can either return its builder argument after having set
	 *            its properties or return another builder.
	 */

	public final DatafeedsResponse mlDatafeeds(Function<DatafeedsRequest.Builder, ObjectBuilder<DatafeedsRequest>> fn)
			throws IOException {
		return mlDatafeeds(fn.apply(new DatafeedsRequest.Builder()).build());
	}

	// ----- Endpoint: cat.ml_jobs

	/**
	 * Gets configuration and usage information about anomaly detection jobs.
	 *
	 * @see "http://www.elastic.co/guide/en/elasticsearch/reference/current/cat-anomaly-detectors.html"
	 */

	public JobsResponse mlJobs(JobsRequest request) throws IOException {
		return this.transport.performRequest(request, JobsRequest.ENDPOINT, this.requestOptions);
	}

	/**
	 * Gets configuration and usage information about anomaly detection jobs.
	 *
	 * @see "http://www.elastic.co/guide/en/elasticsearch/reference/current/cat-anomaly-detectors.html"
	 * @param fn
	 *            a function that initializes a freshly created builder. This
	 *            function can either return its builder argument after having set
	 *            its properties or return another builder.
	 */

	public final JobsResponse mlJobs(Function<JobsRequest.Builder, ObjectBuilder<JobsRequest>> fn) throws IOException {
		return mlJobs(fn.apply(new JobsRequest.Builder()).build());
	}

	// ----- Endpoint: cat.ml_trained_models

	/**
	 * Gets configuration and usage information about inference trained models.
	 *
	 * @see "https://www.elastic.co/guide/en/elasticsearch/reference/current/cat-trained-model.html"
	 */

	public TrainedModelsResponse mlTrainedModels(TrainedModelsRequest request) throws IOException {
		return this.transport.performRequest(request, TrainedModelsRequest.ENDPOINT, this.requestOptions);
	}

	/**
	 * Gets configuration and usage information about inference trained models.
	 *
	 * @see "https://www.elastic.co/guide/en/elasticsearch/reference/current/cat-trained-model.html"
	 * @param fn
	 *            a function that initializes a freshly created builder. This
	 *            function can either return its builder argument after having set
	 *            its properties or return another builder.
	 */

	public final TrainedModelsResponse mlTrainedModels(
			Function<TrainedModelsRequest.Builder, ObjectBuilder<TrainedModelsRequest>> fn) throws IOException {
		return mlTrainedModels(fn.apply(new TrainedModelsRequest.Builder()).build());
	}

	// ----- Endpoint: cat.nodeattrs

	/**
	 * Returns information about custom node attributes.
	 *
	 * @see "https://www.elastic.co/guide/en/elasticsearch/reference/master/cat-nodeattrs.html"
	 */
	public NodeAttributesResponse nodeattrs() throws IOException {
		return this.transport.performRequest(NodeAttributesRequest.INSTANCE, NodeAttributesRequest.ENDPOINT,
				this.requestOptions);
	}

	// ----- Endpoint: cat.nodes

	/**
	 * Returns basic statistics about performance of cluster nodes.
	 *
	 * @see "https://www.elastic.co/guide/en/elasticsearch/reference/master/cat-nodes.html"
	 */

	public NodesResponse nodes(NodesRequest request) throws IOException {
		return this.transport.performRequest(request, NodesRequest.ENDPOINT, this.requestOptions);
	}

	/**
	 * Returns basic statistics about performance of cluster nodes.
	 *
	 * @see "https://www.elastic.co/guide/en/elasticsearch/reference/master/cat-nodes.html"
	 * @param fn
	 *            a function that initializes a freshly created builder. This
	 *            function can either return its builder argument after having set
	 *            its properties or return another builder.
	 */

	public final NodesResponse nodes(Function<NodesRequest.Builder, ObjectBuilder<NodesRequest>> fn)
			throws IOException {
		return nodes(fn.apply(new NodesRequest.Builder()).build());
	}

	// ----- Endpoint: cat.pending_tasks

	/**
	 * Returns a concise representation of the cluster pending tasks.
	 *
	 * @see "https://www.elastic.co/guide/en/elasticsearch/reference/master/cat-pending-tasks.html"
	 */
	public PendingTasksResponse pendingTasks() throws IOException {
		return this.transport.performRequest(PendingTasksRequest.INSTANCE, PendingTasksRequest.ENDPOINT,
				this.requestOptions);
	}

	// ----- Endpoint: cat.plugins

	/**
	 * Returns information about installed plugins across nodes node.
	 *
	 * @see "https://www.elastic.co/guide/en/elasticsearch/reference/master/cat-plugins.html"
	 */
	public PluginsResponse plugins() throws IOException {
		return this.transport.performRequest(PluginsRequest.INSTANCE, PluginsRequest.ENDPOINT, this.requestOptions);
	}

	// ----- Endpoint: cat.recovery

	/**
	 * Returns information about index shard recoveries, both on-going completed.
	 *
	 * @see "https://www.elastic.co/guide/en/elasticsearch/reference/master/cat-recovery.html"
	 */

	public RecoveryResponse recovery(RecoveryRequest request) throws IOException {
		return this.transport.performRequest(request, RecoveryRequest.ENDPOINT, this.requestOptions);
	}

	/**
	 * Returns information about index shard recoveries, both on-going completed.
	 *
	 * @see "https://www.elastic.co/guide/en/elasticsearch/reference/master/cat-recovery.html"
	 * @param fn
	 *            a function that initializes a freshly created builder. This
	 *            function can either return its builder argument after having set
	 *            its properties or return another builder.
	 */

	public final RecoveryResponse recovery(Function<RecoveryRequest.Builder, ObjectBuilder<RecoveryRequest>> fn)
			throws IOException {
		return recovery(fn.apply(new RecoveryRequest.Builder()).build());
	}

	// ----- Endpoint: cat.repositories

	/**
	 * Returns information about snapshot repositories registered in the cluster.
	 *
	 * @see "https://www.elastic.co/guide/en/elasticsearch/reference/master/cat-repositories.html"
	 */
	public RepositoriesResponse repositories() throws IOException {
		return this.transport.performRequest(RepositoriesRequest.INSTANCE, RepositoriesRequest.ENDPOINT,
				this.requestOptions);
	}

	// ----- Endpoint: cat.segments

	/**
	 * Provides low-level information about the segments in the shards of an index.
	 *
	 * @see "https://www.elastic.co/guide/en/elasticsearch/reference/master/cat-segments.html"
	 */

	public SegmentsResponse segments(SegmentsRequest request) throws IOException {
		return this.transport.performRequest(request, SegmentsRequest.ENDPOINT, this.requestOptions);
	}

	/**
	 * Provides low-level information about the segments in the shards of an index.
	 *
	 * @see "https://www.elastic.co/guide/en/elasticsearch/reference/master/cat-segments.html"
	 * @param fn
	 *            a function that initializes a freshly created builder. This
	 *            function can either return its builder argument after having set
	 *            its properties or return another builder.
	 */

	public final SegmentsResponse segments(Function<SegmentsRequest.Builder, ObjectBuilder<SegmentsRequest>> fn)
			throws IOException {
		return segments(fn.apply(new SegmentsRequest.Builder()).build());
	}

	// ----- Endpoint: cat.shards

	/**
	 * Provides a detailed view of shard allocation on nodes.
	 *
	 * @see "https://www.elastic.co/guide/en/elasticsearch/reference/master/cat-shards.html"
	 */

	public ShardsResponse shards(ShardsRequest request) throws IOException {
		return this.transport.performRequest(request, ShardsRequest.ENDPOINT, this.requestOptions);
	}

	/**
	 * Provides a detailed view of shard allocation on nodes.
	 *
	 * @see "https://www.elastic.co/guide/en/elasticsearch/reference/master/cat-shards.html"
	 * @param fn
	 *            a function that initializes a freshly created builder. This
	 *            function can either return its builder argument after having set
	 *            its properties or return another builder.
	 */

	public final ShardsResponse shards(Function<ShardsRequest.Builder, ObjectBuilder<ShardsRequest>> fn)
			throws IOException {
		return shards(fn.apply(new ShardsRequest.Builder()).build());
	}

	// ----- Endpoint: cat.snapshots

	/**
	 * Returns all snapshots in a specific repository.
	 *
	 * @see "https://www.elastic.co/guide/en/elasticsearch/reference/master/cat-snapshots.html"
	 */

	public SnapshotsResponse snapshots(SnapshotsRequest request) throws IOException {
		return this.transport.performRequest(request, SnapshotsRequest.ENDPOINT, this.requestOptions);
	}

	/**
	 * Returns all snapshots in a specific repository.
	 *
	 * @see "https://www.elastic.co/guide/en/elasticsearch/reference/master/cat-snapshots.html"
	 * @param fn
	 *            a function that initializes a freshly created builder. This
	 *            function can either return its builder argument after having set
	 *            its properties or return another builder.
	 */

	public final SnapshotsResponse snapshots(Function<SnapshotsRequest.Builder, ObjectBuilder<SnapshotsRequest>> fn)
			throws IOException {
		return snapshots(fn.apply(new SnapshotsRequest.Builder()).build());
	}

	// ----- Endpoint: cat.tasks

	/**
	 * Returns information about the tasks currently executing on one or more nodes
	 * in the cluster.
	 *
	 * @see "https://www.elastic.co/guide/en/elasticsearch/reference/master/tasks.html"
	 */

	public TasksResponse tasks(TasksRequest request) throws IOException {
		return this.transport.performRequest(request, TasksRequest.ENDPOINT, this.requestOptions);
	}

	/**
	 * Returns information about the tasks currently executing on one or more nodes
	 * in the cluster.
	 *
	 * @see "https://www.elastic.co/guide/en/elasticsearch/reference/master/tasks.html"
	 * @param fn
	 *            a function that initializes a freshly created builder. This
	 *            function can either return its builder argument after having set
	 *            its properties or return another builder.
	 */

	public final TasksResponse tasks(Function<TasksRequest.Builder, ObjectBuilder<TasksRequest>> fn)
			throws IOException {
		return tasks(fn.apply(new TasksRequest.Builder()).build());
	}

	// ----- Endpoint: cat.templates

	/**
	 * Returns information about existing templates.
	 *
	 * @see "https://www.elastic.co/guide/en/elasticsearch/reference/master/cat-templates.html"
	 */

	public TemplatesResponse templates(TemplatesRequest request) throws IOException {
		return this.transport.performRequest(request, TemplatesRequest.ENDPOINT, this.requestOptions);
	}

	/**
	 * Returns information about existing templates.
	 *
	 * @see "https://www.elastic.co/guide/en/elasticsearch/reference/master/cat-templates.html"
	 * @param fn
	 *            a function that initializes a freshly created builder. This
	 *            function can either return its builder argument after having set
	 *            its properties or return another builder.
	 */

	public final TemplatesResponse templates(Function<TemplatesRequest.Builder, ObjectBuilder<TemplatesRequest>> fn)
			throws IOException {
		return templates(fn.apply(new TemplatesRequest.Builder()).build());
	}

	// ----- Endpoint: cat.thread_pool

	/**
	 * Returns cluster-wide thread pool statistics per node. By default the active,
	 * queue and rejected statistics are returned for all thread pools.
	 *
	 * @see "https://www.elastic.co/guide/en/elasticsearch/reference/master/cat-thread-pool.html"
	 */

	public ThreadPoolResponse threadPool(ThreadPoolRequest request) throws IOException {
		return this.transport.performRequest(request, ThreadPoolRequest.ENDPOINT, this.requestOptions);
	}

	/**
	 * Returns cluster-wide thread pool statistics per node. By default the active,
	 * queue and rejected statistics are returned for all thread pools.
	 *
	 * @see "https://www.elastic.co/guide/en/elasticsearch/reference/master/cat-thread-pool.html"
	 * @param fn
	 *            a function that initializes a freshly created builder. This
	 *            function can either return its builder argument after having set
	 *            its properties or return another builder.
	 */

	public final ThreadPoolResponse threadPool(Function<ThreadPoolRequest.Builder, ObjectBuilder<ThreadPoolRequest>> fn)
			throws IOException {
		return threadPool(fn.apply(new ThreadPoolRequest.Builder()).build());
	}

	// ----- Endpoint: cat.transforms

	/**
	 * Gets configuration and usage information about transforms.
	 *
	 * @see "https://www.elastic.co/guide/en/elasticsearch/reference/current/cat-transforms.html"
	 */

	public TransformsResponse transforms(TransformsRequest request) throws IOException {
		return this.transport.performRequest(request, TransformsRequest.ENDPOINT, this.requestOptions);
	}

	/**
	 * Gets configuration and usage information about transforms.
	 *
	 * @see "https://www.elastic.co/guide/en/elasticsearch/reference/current/cat-transforms.html"
	 * @param fn
	 *            a function that initializes a freshly created builder. This
	 *            function can either return its builder argument after having set
	 *            its properties or return another builder.
	 */

	public final TransformsResponse transforms(Function<TransformsRequest.Builder, ObjectBuilder<TransformsRequest>> fn)
			throws IOException {
		return transforms(fn.apply(new TransformsRequest.Builder()).build());
	}

	// ----- Misc

	/**
	 * Creates a new {@link #CatClient} with specific request options.
	 */
	@Override
	public CatClient withRequestOptions(@Nullable RequestOptions options) {
		return new CatClient(transport, options);
	}

	/**
	 * Creates a new {@link #CatClient} with specific request options, inheriting
	 * existing options.
	 *
	 * @param fn
	 *            a function taking an options builder initialized with the current
	 *            request options, or initialized with default values.
	 */
	public CatClient withRequestOptions(Function<RequestOptions.Builder, RequestOptions.Builder> fn) {
		RequestOptions.Builder builder = requestOptions == null
				? RequestOptions.DEFAULT.toBuilder()
				: requestOptions.toBuilder();

		return withRequestOptions(fn.apply(builder).build());
	}
}
