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

import java.io.IOException;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nullable;
import org.opensearch.client.ApiClient;
import org.opensearch.client.opensearch._types.OpenSearchException;
import org.opensearch.client.transport.OpenSearchTransport;
import org.opensearch.client.transport.TransportOptions;
import org.opensearch.client.transport.endpoints.BooleanResponse;
import org.opensearch.client.util.ObjectBuilder;

/**
 * Client for the cluster namespace.
 */
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class OpenSearchClusterClient extends ApiClient<OpenSearchTransport, OpenSearchClusterClient> {
    public OpenSearchClusterClient(OpenSearchTransport transport) {
        super(transport, null);
    }

    public OpenSearchClusterClient(OpenSearchTransport transport, @Nullable TransportOptions transportOptions) {
        super(transport, transportOptions);
    }

    @Override
    public OpenSearchClusterClient withTransportOptions(@Nullable TransportOptions transportOptions) {
        return new OpenSearchClusterClient(this.transport, transportOptions);
    }

    // ----- Endpoint: cluster.allocation_explain

    /**
     * Provides explanations for shard allocations in the cluster.
     */
    public AllocationExplainResponse allocationExplain(AllocationExplainRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, AllocationExplainRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Provides explanations for shard allocations in the cluster.
     *
     * @param fn a function that initializes a builder to create the {@link AllocationExplainRequest}
     */
    public final AllocationExplainResponse allocationExplain(
        Function<AllocationExplainRequest.Builder, ObjectBuilder<AllocationExplainRequest>> fn
    ) throws IOException, OpenSearchException {
        return allocationExplain(fn.apply(new AllocationExplainRequest.Builder()).build());
    }

    /**
     * Provides explanations for shard allocations in the cluster.
     */
    public final AllocationExplainResponse allocationExplain() throws IOException, OpenSearchException {
        return allocationExplain(new AllocationExplainRequest.Builder().build());
    }

    // ----- Endpoint: cluster.delete_component_template

    /**
     * Deletes a component template.
     */
    public DeleteComponentTemplateResponse deleteComponentTemplate(DeleteComponentTemplateRequest request) throws IOException,
        OpenSearchException {
        return this.transport.performRequest(request, DeleteComponentTemplateRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Deletes a component template.
     *
     * @param fn a function that initializes a builder to create the {@link DeleteComponentTemplateRequest}
     */
    public final DeleteComponentTemplateResponse deleteComponentTemplate(
        Function<DeleteComponentTemplateRequest.Builder, ObjectBuilder<DeleteComponentTemplateRequest>> fn
    ) throws IOException, OpenSearchException {
        return deleteComponentTemplate(fn.apply(new DeleteComponentTemplateRequest.Builder()).build());
    }

    // ----- Endpoint: cluster.delete_voting_config_exclusions

    /**
     * Clears cluster voting config exclusions.
     */
    public BooleanResponse deleteVotingConfigExclusions(DeleteVotingConfigExclusionsRequest request) throws IOException,
        OpenSearchException {
        return this.transport.performRequest(request, DeleteVotingConfigExclusionsRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Clears cluster voting config exclusions.
     *
     * @param fn a function that initializes a builder to create the {@link DeleteVotingConfigExclusionsRequest}
     */
    public final BooleanResponse deleteVotingConfigExclusions(
        Function<DeleteVotingConfigExclusionsRequest.Builder, ObjectBuilder<DeleteVotingConfigExclusionsRequest>> fn
    ) throws IOException, OpenSearchException {
        return deleteVotingConfigExclusions(fn.apply(new DeleteVotingConfigExclusionsRequest.Builder()).build());
    }

    /**
     * Clears cluster voting config exclusions.
     */
    public final BooleanResponse deleteVotingConfigExclusions() throws IOException, OpenSearchException {
        return deleteVotingConfigExclusions(new DeleteVotingConfigExclusionsRequest.Builder().build());
    }

    // ----- Endpoint: cluster.exists_component_template

    /**
     * Returns information about whether a particular component template exist.
     */
    public BooleanResponse existsComponentTemplate(ExistsComponentTemplateRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, ExistsComponentTemplateRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Returns information about whether a particular component template exist.
     *
     * @param fn a function that initializes a builder to create the {@link ExistsComponentTemplateRequest}
     */
    public final BooleanResponse existsComponentTemplate(
        Function<ExistsComponentTemplateRequest.Builder, ObjectBuilder<ExistsComponentTemplateRequest>> fn
    ) throws IOException, OpenSearchException {
        return existsComponentTemplate(fn.apply(new ExistsComponentTemplateRequest.Builder()).build());
    }

    // ----- Endpoint: cluster.get_component_template

    /**
     * Returns one or more component templates.
     */
    public GetComponentTemplateResponse getComponentTemplate(GetComponentTemplateRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, GetComponentTemplateRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Returns one or more component templates.
     *
     * @param fn a function that initializes a builder to create the {@link GetComponentTemplateRequest}
     */
    public final GetComponentTemplateResponse getComponentTemplate(
        Function<GetComponentTemplateRequest.Builder, ObjectBuilder<GetComponentTemplateRequest>> fn
    ) throws IOException, OpenSearchException {
        return getComponentTemplate(fn.apply(new GetComponentTemplateRequest.Builder()).build());
    }

    /**
     * Returns one or more component templates.
     */
    public final GetComponentTemplateResponse getComponentTemplate() throws IOException, OpenSearchException {
        return getComponentTemplate(new GetComponentTemplateRequest.Builder().build());
    }

    // ----- Endpoint: cluster.get_settings

    /**
     * Returns cluster settings.
     */
    public GetClusterSettingsResponse getSettings(GetClusterSettingsRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, GetClusterSettingsRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Returns cluster settings.
     *
     * @param fn a function that initializes a builder to create the {@link GetClusterSettingsRequest}
     */
    public final GetClusterSettingsResponse getSettings(
        Function<GetClusterSettingsRequest.Builder, ObjectBuilder<GetClusterSettingsRequest>> fn
    ) throws IOException, OpenSearchException {
        return getSettings(fn.apply(new GetClusterSettingsRequest.Builder()).build());
    }

    /**
     * Returns cluster settings.
     */
    public final GetClusterSettingsResponse getSettings() throws IOException, OpenSearchException {
        return getSettings(new GetClusterSettingsRequest.Builder().build());
    }

    // ----- Endpoint: cluster.health

    /**
     * Returns basic information about the health of the cluster.
     */
    public HealthResponse health(HealthRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, HealthRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Returns basic information about the health of the cluster.
     *
     * @param fn a function that initializes a builder to create the {@link HealthRequest}
     */
    public final HealthResponse health(Function<HealthRequest.Builder, ObjectBuilder<HealthRequest>> fn) throws IOException,
        OpenSearchException {
        return health(fn.apply(new HealthRequest.Builder()).build());
    }

    /**
     * Returns basic information about the health of the cluster.
     */
    public final HealthResponse health() throws IOException, OpenSearchException {
        return health(new HealthRequest.Builder().build());
    }

    // ----- Endpoint: cluster.pending_tasks

    /**
     * Returns a list of any cluster-level changes (e.g. create index, update mapping, allocate or fail shard) which have not yet been
     * executed.
     */
    public PendingTasksResponse pendingTasks(PendingTasksRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, PendingTasksRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Returns a list of any cluster-level changes (e.g. create index, update mapping, allocate or fail shard) which have not yet been
     * executed.
     *
     * @param fn a function that initializes a builder to create the {@link PendingTasksRequest}
     */
    public final PendingTasksResponse pendingTasks(Function<PendingTasksRequest.Builder, ObjectBuilder<PendingTasksRequest>> fn)
        throws IOException, OpenSearchException {
        return pendingTasks(fn.apply(new PendingTasksRequest.Builder()).build());
    }

    /**
     * Returns a list of any cluster-level changes (e.g. create index, update mapping, allocate or fail shard) which have not yet been
     * executed.
     */
    public final PendingTasksResponse pendingTasks() throws IOException, OpenSearchException {
        return pendingTasks(new PendingTasksRequest.Builder().build());
    }

    // ----- Endpoint: cluster.post_voting_config_exclusions

    /**
     * Updates the cluster voting config exclusions by node ids or node names.
     */
    public BooleanResponse postVotingConfigExclusions(PostVotingConfigExclusionsRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, PostVotingConfigExclusionsRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Updates the cluster voting config exclusions by node ids or node names.
     *
     * @param fn a function that initializes a builder to create the {@link PostVotingConfigExclusionsRequest}
     */
    public final BooleanResponse postVotingConfigExclusions(
        Function<PostVotingConfigExclusionsRequest.Builder, ObjectBuilder<PostVotingConfigExclusionsRequest>> fn
    ) throws IOException, OpenSearchException {
        return postVotingConfigExclusions(fn.apply(new PostVotingConfigExclusionsRequest.Builder()).build());
    }

    /**
     * Updates the cluster voting config exclusions by node ids or node names.
     */
    public final BooleanResponse postVotingConfigExclusions() throws IOException, OpenSearchException {
        return postVotingConfigExclusions(new PostVotingConfigExclusionsRequest.Builder().build());
    }

    // ----- Endpoint: cluster.put_component_template

    /**
     * Creates or updates a component template.
     */
    public PutComponentTemplateResponse putComponentTemplate(PutComponentTemplateRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, PutComponentTemplateRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Creates or updates a component template.
     *
     * @param fn a function that initializes a builder to create the {@link PutComponentTemplateRequest}
     */
    public final PutComponentTemplateResponse putComponentTemplate(
        Function<PutComponentTemplateRequest.Builder, ObjectBuilder<PutComponentTemplateRequest>> fn
    ) throws IOException, OpenSearchException {
        return putComponentTemplate(fn.apply(new PutComponentTemplateRequest.Builder()).build());
    }

    // ----- Endpoint: cluster.put_settings

    /**
     * Updates the cluster settings.
     */
    public PutClusterSettingsResponse putSettings(PutClusterSettingsRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, PutClusterSettingsRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Updates the cluster settings.
     *
     * @param fn a function that initializes a builder to create the {@link PutClusterSettingsRequest}
     */
    public final PutClusterSettingsResponse putSettings(
        Function<PutClusterSettingsRequest.Builder, ObjectBuilder<PutClusterSettingsRequest>> fn
    ) throws IOException, OpenSearchException {
        return putSettings(fn.apply(new PutClusterSettingsRequest.Builder()).build());
    }

    /**
     * Updates the cluster settings.
     */
    public final PutClusterSettingsResponse putSettings() throws IOException, OpenSearchException {
        return putSettings(new PutClusterSettingsRequest.Builder().build());
    }

    // ----- Endpoint: cluster.remote_info

    /**
     * Returns the information about configured remote clusters.
     */
    public RemoteInfoResponse remoteInfo(RemoteInfoRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, RemoteInfoRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Returns the information about configured remote clusters.
     *
     * @param fn a function that initializes a builder to create the {@link RemoteInfoRequest}
     */
    public final RemoteInfoResponse remoteInfo(Function<RemoteInfoRequest.Builder, ObjectBuilder<RemoteInfoRequest>> fn) throws IOException,
        OpenSearchException {
        return remoteInfo(fn.apply(new RemoteInfoRequest.Builder()).build());
    }

    /**
     * Returns the information about configured remote clusters.
     */
    public final RemoteInfoResponse remoteInfo() throws IOException, OpenSearchException {
        return remoteInfo(new RemoteInfoRequest.Builder().build());
    }

    // ----- Endpoint: cluster.reroute

    /**
     * Allows to manually change the allocation of individual shards in the cluster.
     */
    public RerouteResponse reroute(RerouteRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, RerouteRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Allows to manually change the allocation of individual shards in the cluster.
     *
     * @param fn a function that initializes a builder to create the {@link RerouteRequest}
     */
    public final RerouteResponse reroute(Function<RerouteRequest.Builder, ObjectBuilder<RerouteRequest>> fn) throws IOException,
        OpenSearchException {
        return reroute(fn.apply(new RerouteRequest.Builder()).build());
    }

    /**
     * Allows to manually change the allocation of individual shards in the cluster.
     */
    public final RerouteResponse reroute() throws IOException, OpenSearchException {
        return reroute(new RerouteRequest.Builder().build());
    }

    // ----- Endpoint: cluster.state

    /**
     * Returns a comprehensive information about the state of the cluster.
     */
    public StateResponse state(StateRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, StateRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Returns a comprehensive information about the state of the cluster.
     *
     * @param fn a function that initializes a builder to create the {@link StateRequest}
     */
    public final StateResponse state(Function<StateRequest.Builder, ObjectBuilder<StateRequest>> fn) throws IOException,
        OpenSearchException {
        return state(fn.apply(new StateRequest.Builder()).build());
    }

    /**
     * Returns a comprehensive information about the state of the cluster.
     */
    public final StateResponse state() throws IOException, OpenSearchException {
        return state(new StateRequest.Builder().build());
    }

    // ----- Endpoint: cluster.stats

    /**
     * Returns high-level overview of cluster statistics.
     */
    public ClusterStatsResponse stats(ClusterStatsRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, ClusterStatsRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Returns high-level overview of cluster statistics.
     *
     * @param fn a function that initializes a builder to create the {@link ClusterStatsRequest}
     */
    public final ClusterStatsResponse stats(Function<ClusterStatsRequest.Builder, ObjectBuilder<ClusterStatsRequest>> fn)
        throws IOException, OpenSearchException {
        return stats(fn.apply(new ClusterStatsRequest.Builder()).build());
    }

    /**
     * Returns high-level overview of cluster statistics.
     */
    public final ClusterStatsResponse stats() throws IOException, OpenSearchException {
        return stats(new ClusterStatsRequest.Builder().build());
    }
}
