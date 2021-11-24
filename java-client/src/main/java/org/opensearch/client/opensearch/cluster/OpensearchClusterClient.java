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

package org.opensearch.client.opensearch.cluster;

import org.opensearch.client.ApiClient;
import org.opensearch.client.opensearch._types.OpensearchException;
import org.opensearch.client.transport.BooleanResponse;
import org.opensearch.client.transport.Transport;
import org.opensearch.client.transport.TransportOptions;
import org.opensearch.client.util.ObjectBuilder;

import java.io.IOException;
import java.util.function.Function;
import javax.annotation.Nullable;

/**
 * Client for the cluster namespace.
 */
public class OpensearchClusterClient extends ApiClient<OpensearchClusterClient> {

	public OpensearchClusterClient(Transport transport) {
		super(transport, null);
	}

	public OpensearchClusterClient(Transport transport, @Nullable TransportOptions transportOptions) {
		super(transport, transportOptions);
	}

	@Override
	public OpensearchClusterClient withTransportOptions(@Nullable TransportOptions transportOptions) {
		return new OpensearchClusterClient(this.transport, transportOptions);
	}

	// ----- Endpoint: cluster.allocation_explain

	/**
	 * Provides explanations for shard allocations in the cluster.
	 */

	public AllocationExplainResponse allocationExplain(AllocationExplainRequest request)
			throws IOException, OpensearchException {
		return this.transport.performRequest(request, AllocationExplainRequest.ENDPOINT, this.transportOptions);
	}

	/**
	 * Provides explanations for shard allocations in the cluster.
	 * 
	 * @param fn
	 *            a function that initializes a builder to create the
	 *            {@link AllocationExplainRequest}
	 */

	public final AllocationExplainResponse allocationExplain(
			Function<AllocationExplainRequest.Builder, ObjectBuilder<AllocationExplainRequest>> fn)
			throws IOException, OpensearchException {
		return allocationExplain(fn.apply(new AllocationExplainRequest.Builder()).build());
	}

	/**
	 * Provides explanations for shard allocations in the cluster.
	 */

	public AllocationExplainResponse allocationExplain() throws IOException, OpensearchException {
		return this.transport.performRequest(new AllocationExplainRequest.Builder().build(),
				AllocationExplainRequest.ENDPOINT, this.transportOptions);
	}

	// ----- Endpoint: cluster.delete_component_template

	/**
	 * Deletes a component template
	 */

	public DeleteComponentTemplateResponse deleteComponentTemplate(DeleteComponentTemplateRequest request)
			throws IOException, OpensearchException {
		return this.transport.performRequest(request, DeleteComponentTemplateRequest.ENDPOINT, this.transportOptions);
	}

	/**
	 * Deletes a component template
	 * 
	 * @param fn
	 *            a function that initializes a builder to create the
	 *            {@link DeleteComponentTemplateRequest}
	 */

	public final DeleteComponentTemplateResponse deleteComponentTemplate(
			Function<DeleteComponentTemplateRequest.Builder, ObjectBuilder<DeleteComponentTemplateRequest>> fn)
			throws IOException, OpensearchException {
		return deleteComponentTemplate(fn.apply(new DeleteComponentTemplateRequest.Builder()).build());
	}

	// ----- Endpoint: cluster.delete_voting_config_exclusions

	/**
	 * Clears cluster voting config exclusions.
	 */

	public BooleanResponse deleteVotingConfigExclusions(DeleteVotingConfigExclusionsRequest request)
			throws IOException, OpensearchException {
		return this.transport.performRequest(request, DeleteVotingConfigExclusionsRequest.ENDPOINT,
				this.transportOptions);
	}

	/**
	 * Clears cluster voting config exclusions.
	 * 
	 * @param fn
	 *            a function that initializes a builder to create the
	 *            {@link DeleteVotingConfigExclusionsRequest}
	 */

	public final BooleanResponse deleteVotingConfigExclusions(
			Function<DeleteVotingConfigExclusionsRequest.Builder, ObjectBuilder<DeleteVotingConfigExclusionsRequest>> fn)
			throws IOException, OpensearchException {
		return deleteVotingConfigExclusions(fn.apply(new DeleteVotingConfigExclusionsRequest.Builder()).build());
	}

	/**
	 * Clears cluster voting config exclusions.
	 */

	public BooleanResponse deleteVotingConfigExclusions() throws IOException, OpensearchException {
		return this.transport.performRequest(new DeleteVotingConfigExclusionsRequest.Builder().build(),
				DeleteVotingConfigExclusionsRequest.ENDPOINT, this.transportOptions);
	}

	// ----- Endpoint: cluster.exists_component_template

	/**
	 * Returns information about whether a particular component template exist
	 */

	public BooleanResponse existsComponentTemplate(ExistsComponentTemplateRequest request)
			throws IOException, OpensearchException {
		return this.transport.performRequest(request, ExistsComponentTemplateRequest.ENDPOINT, this.transportOptions);
	}

	/**
	 * Returns information about whether a particular component template exist
	 * 
	 * @param fn
	 *            a function that initializes a builder to create the
	 *            {@link ExistsComponentTemplateRequest}
	 */

	public final BooleanResponse existsComponentTemplate(
			Function<ExistsComponentTemplateRequest.Builder, ObjectBuilder<ExistsComponentTemplateRequest>> fn)
			throws IOException, OpensearchException {
		return existsComponentTemplate(fn.apply(new ExistsComponentTemplateRequest.Builder()).build());
	}

	// ----- Endpoint: cluster.get_component_template

	/**
	 * Returns one or more component templates
	 */

	public GetComponentTemplateResponse getComponentTemplate(GetComponentTemplateRequest request)
			throws IOException, OpensearchException {
		return this.transport.performRequest(request, GetComponentTemplateRequest.ENDPOINT, this.transportOptions);
	}

	/**
	 * Returns one or more component templates
	 * 
	 * @param fn
	 *            a function that initializes a builder to create the
	 *            {@link GetComponentTemplateRequest}
	 * 
	 */

	public final GetComponentTemplateResponse getComponentTemplate(
			Function<GetComponentTemplateRequest.Builder, ObjectBuilder<GetComponentTemplateRequest>> fn)
			throws IOException, OpensearchException {
		return getComponentTemplate(fn.apply(new GetComponentTemplateRequest.Builder()).build());
	}

	/**
	 * Returns one or more component templates
	 */

	public GetComponentTemplateResponse getComponentTemplate() throws IOException, OpensearchException {
		return this.transport.performRequest(new GetComponentTemplateRequest.Builder().build(),
				GetComponentTemplateRequest.ENDPOINT, this.transportOptions);
	}

	// ----- Endpoint: cluster.get_settings

	/**
	 * Returns cluster settings.
	 */

	public GetSettingsResponse getSettings(GetSettingsRequest request) throws IOException, OpensearchException {
		return this.transport.performRequest(request, GetSettingsRequest.ENDPOINT, this.transportOptions);
	}

	/**
	 * Returns cluster settings.
	 * 
	 * @param fn
	 *            a function that initializes a builder to create the
	 *            {@link GetSettingsRequest}
	 */

	public final GetSettingsResponse getSettings(
			Function<GetSettingsRequest.Builder, ObjectBuilder<GetSettingsRequest>> fn)
			throws IOException, OpensearchException {
		return getSettings(fn.apply(new GetSettingsRequest.Builder()).build());
	}

	/**
	 * Returns cluster settings.
	 */

	public GetSettingsResponse getSettings() throws IOException, OpensearchException {
		return this.transport.performRequest(new GetSettingsRequest.Builder().build(), GetSettingsRequest.ENDPOINT,
				this.transportOptions);
	}

	// ----- Endpoint: cluster.health

	/**
	 * Returns basic information about the health of the cluster.
	 */

	public HealthResponse health(HealthRequest request) throws IOException, OpensearchException {
		return this.transport.performRequest(request, HealthRequest.ENDPOINT, this.transportOptions);
	}

	/**
	 * Returns basic information about the health of the cluster.
	 * 
	 * @param fn
	 *            a function that initializes a builder to create the
	 *            {@link HealthRequest}
	 */

	public final HealthResponse health(Function<HealthRequest.Builder, ObjectBuilder<HealthRequest>> fn)
			throws IOException, OpensearchException {
		return health(fn.apply(new HealthRequest.Builder()).build());
	}

	/**
	 * Returns basic information about the health of the cluster.
	 * 
	 */

	public HealthResponse health() throws IOException, OpensearchException {
		return this.transport.performRequest(new HealthRequest.Builder().build(), HealthRequest.ENDPOINT,
				this.transportOptions);
	}

	// ----- Endpoint: cluster.pending_tasks

	/**
	 * Returns a list of any cluster-level changes (e.g. create index, update
	 * mapping, allocate or fail shard) which have not yet been executed.
	 */

	public PendingTasksResponse pendingTasks(PendingTasksRequest request) throws IOException, OpensearchException {
		return this.transport.performRequest(request, PendingTasksRequest.ENDPOINT, this.transportOptions);
	}

	/**
	 * Returns a list of any cluster-level changes (e.g. create index, update
	 * mapping, allocate or fail shard) which have not yet been executed.
	 * 
	 * @param fn
	 *            a function that initializes a builder to create the
	 *            {@link PendingTasksRequest}
	 */

	public final PendingTasksResponse pendingTasks(
			Function<PendingTasksRequest.Builder, ObjectBuilder<PendingTasksRequest>> fn)
			throws IOException, OpensearchException {
		return pendingTasks(fn.apply(new PendingTasksRequest.Builder()).build());
	}

	/**
	 * Returns a list of any cluster-level changes (e.g. create index, update
	 * mapping, allocate or fail shard) which have not yet been executed.
	 */

	public PendingTasksResponse pendingTasks() throws IOException, OpensearchException {
		return this.transport.performRequest(new PendingTasksRequest.Builder().build(), PendingTasksRequest.ENDPOINT,
				this.transportOptions);
	}

	// ----- Endpoint: cluster.post_voting_config_exclusions

	/**
	 * Updates the cluster voting config exclusions by node ids or node names.
	 */

	public BooleanResponse postVotingConfigExclusions(PostVotingConfigExclusionsRequest request)
			throws IOException, OpensearchException {
		return this.transport.performRequest(request, PostVotingConfigExclusionsRequest.ENDPOINT,
				this.transportOptions);
	}

	/**
	 * Updates the cluster voting config exclusions by node ids or node names.
	 * 
	 * @param fn
	 *            a function that initializes a builder to create the
	 *            {@link PostVotingConfigExclusionsRequest}
	 */

	public final BooleanResponse postVotingConfigExclusions(
			Function<PostVotingConfigExclusionsRequest.Builder, ObjectBuilder<PostVotingConfigExclusionsRequest>> fn)
			throws IOException, OpensearchException {
		return postVotingConfigExclusions(fn.apply(new PostVotingConfigExclusionsRequest.Builder()).build());
	}

	/**
	 * Updates the cluster voting config exclusions by node ids or node names.
	 */

	public BooleanResponse postVotingConfigExclusions() throws IOException, OpensearchException {
		return this.transport.performRequest(new PostVotingConfigExclusionsRequest.Builder().build(),
				PostVotingConfigExclusionsRequest.ENDPOINT, this.transportOptions);
	}

	// ----- Endpoint: cluster.put_component_template

	/**
	 * Creates or updates a component template
	 */

	public PutComponentTemplateResponse putComponentTemplate(PutComponentTemplateRequest request)
			throws IOException, OpensearchException {
		return this.transport.performRequest(request, PutComponentTemplateRequest.ENDPOINT, this.transportOptions);
	}

	/**
	 * Creates or updates a component template
	 * 
	 * @param fn
	 *            a function that initializes a builder to create the
	 *            {@link PutComponentTemplateRequest}
	 */

	public final PutComponentTemplateResponse putComponentTemplate(
			Function<PutComponentTemplateRequest.Builder, ObjectBuilder<PutComponentTemplateRequest>> fn)
			throws IOException, OpensearchException {
		return putComponentTemplate(fn.apply(new PutComponentTemplateRequest.Builder()).build());
	}

	// ----- Endpoint: cluster.put_settings

	/**
	 * Updates the cluster settings.
	 * 
	 */

	public PutSettingsResponse putSettings(PutSettingsRequest request) throws IOException, OpensearchException {
		return this.transport.performRequest(request, PutSettingsRequest.ENDPOINT, this.transportOptions);
	}

	/**
	 * Updates the cluster settings.
	 * 
	 * @param fn
	 *            a function that initializes a builder to create the
	 *            {@link PutSettingsRequest}
	 */

	public final PutSettingsResponse putSettings(
			Function<PutSettingsRequest.Builder, ObjectBuilder<PutSettingsRequest>> fn)
			throws IOException, OpensearchException {
		return putSettings(fn.apply(new PutSettingsRequest.Builder()).build());
	}

	/**
	 * Updates the cluster settings.
	 * 
	 */

	public PutSettingsResponse putSettings() throws IOException, OpensearchException {
		return this.transport.performRequest(new PutSettingsRequest.Builder().build(), PutSettingsRequest.ENDPOINT,
				this.transportOptions);
	}

	// ----- Endpoint: cluster.remote_info

	/**
	 * Returns the information about configured remote clusters.
	 */
	public RemoteInfoResponse remoteInfo() throws IOException, OpensearchException {
		return this.transport.performRequest(RemoteInfoRequest._INSTANCE, RemoteInfoRequest.ENDPOINT,
				this.transportOptions);
	}

	// ----- Endpoint: cluster.reroute

	/**
	 * Allows to manually change the allocation of individual shards in the cluster.
	 */

	public RerouteResponse reroute(RerouteRequest request) throws IOException, OpensearchException {
		return this.transport.performRequest(request, RerouteRequest.ENDPOINT, this.transportOptions);
	}

	/**
	 * Allows to manually change the allocation of individual shards in the cluster.
	 * 
	 * @param fn
	 *            a function that initializes a builder to create the
	 *            {@link RerouteRequest}
	 */

	public final RerouteResponse reroute(Function<RerouteRequest.Builder, ObjectBuilder<RerouteRequest>> fn)
			throws IOException, OpensearchException {
		return reroute(fn.apply(new RerouteRequest.Builder()).build());
	}

	/**
	 * Allows to manually change the allocation of individual shards in the cluster.
	 */

	public RerouteResponse reroute() throws IOException, OpensearchException {
		return this.transport.performRequest(new RerouteRequest.Builder().build(), RerouteRequest.ENDPOINT,
				this.transportOptions);
	}

	// ----- Endpoint: cluster.state

	/**
	 * Returns a comprehensive information about the state of the cluster.
	 */

	public StateResponse state(StateRequest request) throws IOException, OpensearchException {
		return this.transport.performRequest(request, StateRequest.ENDPOINT, this.transportOptions);
	}

	/**
	 * Returns a comprehensive information about the state of the cluster.
	 * 
	 * @param fn
	 *            a function that initializes a builder to create the
	 *            {@link StateRequest}
	 */

	public final StateResponse state(Function<StateRequest.Builder, ObjectBuilder<StateRequest>> fn)
			throws IOException, OpensearchException {
		return state(fn.apply(new StateRequest.Builder()).build());
	}

	/**
	 * Returns a comprehensive information about the state of the cluster.
	 */

	public StateResponse state() throws IOException, OpensearchException {
		return this.transport.performRequest(new StateRequest.Builder().build(), StateRequest.ENDPOINT,
				this.transportOptions);
	}

	// ----- Endpoint: cluster.stats

	/**
	 * Returns high-level overview of cluster statistics.
	 */

	public ClusterStatsResponse stats(ClusterStatsRequest request) throws IOException, OpensearchException {
		return this.transport.performRequest(request, ClusterStatsRequest.ENDPOINT, this.transportOptions);
	}

	/**
	 * Returns high-level overview of cluster statistics.
	 * 
	 * @param fn
	 *            a function that initializes a builder to create the
	 *            {@link ClusterStatsRequest}
	 */

	public final ClusterStatsResponse stats(
			Function<ClusterStatsRequest.Builder, ObjectBuilder<ClusterStatsRequest>> fn)
			throws IOException, OpensearchException {
		return stats(fn.apply(new ClusterStatsRequest.Builder()).build());
	}

	/**
	 * Returns high-level overview of cluster statistics.
	 */

	public ClusterStatsResponse stats() throws IOException, OpensearchException {
		return this.transport.performRequest(new ClusterStatsRequest.Builder().build(), ClusterStatsRequest.ENDPOINT,
				this.transportOptions);
	}

}
