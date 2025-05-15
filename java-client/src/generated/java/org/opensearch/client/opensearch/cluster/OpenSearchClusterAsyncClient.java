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
import java.util.concurrent.CompletableFuture;
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
public class OpenSearchClusterAsyncClient extends ApiClient<OpenSearchTransport, OpenSearchClusterAsyncClient> {
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

    // ----- Endpoint: cluster.allocation_explain

    /**
     * Explains how shards are allocated in the current cluster and provides an explanation for why unassigned shards can't be allocated to
     * a node.
     */
    public CompletableFuture<AllocationExplainResponse> allocationExplain(AllocationExplainRequest request) throws IOException,
        OpenSearchException {
        return this.transport.performRequestAsync(request, AllocationExplainRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Explains how shards are allocated in the current cluster and provides an explanation for why unassigned shards can't be allocated to
     * a node.
     *
     * @param fn a function that initializes a builder to create the {@link AllocationExplainRequest}
     */
    public final CompletableFuture<AllocationExplainResponse> allocationExplain(
        Function<AllocationExplainRequest.Builder, ObjectBuilder<AllocationExplainRequest>> fn
    ) throws IOException, OpenSearchException {
        return allocationExplain(fn.apply(new AllocationExplainRequest.Builder()).build());
    }

    /**
     * Explains how shards are allocated in the current cluster and provides an explanation for why unassigned shards can't be allocated to
     * a node.
     */
    public final CompletableFuture<AllocationExplainResponse> allocationExplain() throws IOException, OpenSearchException {
        return allocationExplain(new AllocationExplainRequest.Builder().build());
    }

    // ----- Endpoint: cluster.delete_component_template

    /**
     * Deletes a component template.
     */
    public CompletableFuture<DeleteComponentTemplateResponse> deleteComponentTemplate(DeleteComponentTemplateRequest request)
        throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, DeleteComponentTemplateRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Deletes a component template.
     *
     * @param fn a function that initializes a builder to create the {@link DeleteComponentTemplateRequest}
     */
    public final CompletableFuture<DeleteComponentTemplateResponse> deleteComponentTemplate(
        Function<DeleteComponentTemplateRequest.Builder, ObjectBuilder<DeleteComponentTemplateRequest>> fn
    ) throws IOException, OpenSearchException {
        return deleteComponentTemplate(fn.apply(new DeleteComponentTemplateRequest.Builder()).build());
    }

    // ----- Endpoint: cluster.delete_decommission_awareness

    /**
     * Recommissions a decommissioned zone.
     */
    public CompletableFuture<DeleteDecommissionAwarenessResponse> deleteDecommissionAwareness(DeleteDecommissionAwarenessRequest request)
        throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, DeleteDecommissionAwarenessRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Recommissions a decommissioned zone.
     *
     * @param fn a function that initializes a builder to create the {@link DeleteDecommissionAwarenessRequest}
     */
    public final CompletableFuture<DeleteDecommissionAwarenessResponse> deleteDecommissionAwareness(
        Function<DeleteDecommissionAwarenessRequest.Builder, ObjectBuilder<DeleteDecommissionAwarenessRequest>> fn
    ) throws IOException, OpenSearchException {
        return deleteDecommissionAwareness(fn.apply(new DeleteDecommissionAwarenessRequest.Builder()).build());
    }

    /**
     * Recommissions a decommissioned zone.
     */
    public final CompletableFuture<DeleteDecommissionAwarenessResponse> deleteDecommissionAwareness() throws IOException,
        OpenSearchException {
        return deleteDecommissionAwareness(new DeleteDecommissionAwarenessRequest.Builder().build());
    }

    // ----- Endpoint: cluster.delete_voting_config_exclusions

    /**
     * Clears any cluster voting configuration exclusions.
     */
    public CompletableFuture<BooleanResponse> deleteVotingConfigExclusions(DeleteVotingConfigExclusionsRequest request) throws IOException,
        OpenSearchException {
        return this.transport.performRequestAsync(request, DeleteVotingConfigExclusionsRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Clears any cluster voting configuration exclusions.
     *
     * @param fn a function that initializes a builder to create the {@link DeleteVotingConfigExclusionsRequest}
     */
    public final CompletableFuture<BooleanResponse> deleteVotingConfigExclusions(
        Function<DeleteVotingConfigExclusionsRequest.Builder, ObjectBuilder<DeleteVotingConfigExclusionsRequest>> fn
    ) throws IOException, OpenSearchException {
        return deleteVotingConfigExclusions(fn.apply(new DeleteVotingConfigExclusionsRequest.Builder()).build());
    }

    /**
     * Clears any cluster voting configuration exclusions.
     */
    public final CompletableFuture<BooleanResponse> deleteVotingConfigExclusions() throws IOException, OpenSearchException {
        return deleteVotingConfigExclusions(new DeleteVotingConfigExclusionsRequest.Builder().build());
    }

    // ----- Endpoint: cluster.delete_weighted_routing

    /**
     * Delete weighted shard routing weights.
     */
    public CompletableFuture<DeleteWeightedRoutingResponse> deleteWeightedRouting(DeleteWeightedRoutingRequest request) throws IOException,
        OpenSearchException {
        return this.transport.performRequestAsync(request, DeleteWeightedRoutingRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Delete weighted shard routing weights.
     *
     * @param fn a function that initializes a builder to create the {@link DeleteWeightedRoutingRequest}
     */
    public final CompletableFuture<DeleteWeightedRoutingResponse> deleteWeightedRouting(
        Function<DeleteWeightedRoutingRequest.Builder, ObjectBuilder<DeleteWeightedRoutingRequest>> fn
    ) throws IOException, OpenSearchException {
        return deleteWeightedRouting(fn.apply(new DeleteWeightedRoutingRequest.Builder()).build());
    }

    /**
     * Delete weighted shard routing weights.
     */
    public final CompletableFuture<DeleteWeightedRoutingResponse> deleteWeightedRouting() throws IOException, OpenSearchException {
        return deleteWeightedRouting(new DeleteWeightedRoutingRequest.Builder().build());
    }

    // ----- Endpoint: cluster.exists_component_template

    /**
     * Returns information about whether a particular component template exist.
     */
    public CompletableFuture<BooleanResponse> existsComponentTemplate(ExistsComponentTemplateRequest request) throws IOException,
        OpenSearchException {
        return this.transport.performRequestAsync(request, ExistsComponentTemplateRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Returns information about whether a particular component template exist.
     *
     * @param fn a function that initializes a builder to create the {@link ExistsComponentTemplateRequest}
     */
    public final CompletableFuture<BooleanResponse> existsComponentTemplate(
        Function<ExistsComponentTemplateRequest.Builder, ObjectBuilder<ExistsComponentTemplateRequest>> fn
    ) throws IOException, OpenSearchException {
        return existsComponentTemplate(fn.apply(new ExistsComponentTemplateRequest.Builder()).build());
    }

    // ----- Endpoint: cluster.get_component_template

    /**
     * Returns one or more component templates.
     */
    public CompletableFuture<GetComponentTemplateResponse> getComponentTemplate(GetComponentTemplateRequest request) throws IOException,
        OpenSearchException {
        return this.transport.performRequestAsync(request, GetComponentTemplateRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Returns one or more component templates.
     *
     * @param fn a function that initializes a builder to create the {@link GetComponentTemplateRequest}
     */
    public final CompletableFuture<GetComponentTemplateResponse> getComponentTemplate(
        Function<GetComponentTemplateRequest.Builder, ObjectBuilder<GetComponentTemplateRequest>> fn
    ) throws IOException, OpenSearchException {
        return getComponentTemplate(fn.apply(new GetComponentTemplateRequest.Builder()).build());
    }

    /**
     * Returns one or more component templates.
     */
    public final CompletableFuture<GetComponentTemplateResponse> getComponentTemplate() throws IOException, OpenSearchException {
        return getComponentTemplate(new GetComponentTemplateRequest.Builder().build());
    }

    // ----- Endpoint: cluster.get_decommission_awareness

    /**
     * Retrieves the decommission status for all zones.
     */
    public CompletableFuture<GetDecommissionAwarenessResponse> getDecommissionAwareness(GetDecommissionAwarenessRequest request)
        throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, GetDecommissionAwarenessRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Retrieves the decommission status for all zones.
     *
     * @param fn a function that initializes a builder to create the {@link GetDecommissionAwarenessRequest}
     */
    public final CompletableFuture<GetDecommissionAwarenessResponse> getDecommissionAwareness(
        Function<GetDecommissionAwarenessRequest.Builder, ObjectBuilder<GetDecommissionAwarenessRequest>> fn
    ) throws IOException, OpenSearchException {
        return getDecommissionAwareness(fn.apply(new GetDecommissionAwarenessRequest.Builder()).build());
    }

    // ----- Endpoint: cluster.get_settings

    /**
     * Returns cluster settings.
     */
    public CompletableFuture<GetClusterSettingsResponse> getSettings(GetClusterSettingsRequest request) throws IOException,
        OpenSearchException {
        return this.transport.performRequestAsync(request, GetClusterSettingsRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Returns cluster settings.
     *
     * @param fn a function that initializes a builder to create the {@link GetClusterSettingsRequest}
     */
    public final CompletableFuture<GetClusterSettingsResponse> getSettings(
        Function<GetClusterSettingsRequest.Builder, ObjectBuilder<GetClusterSettingsRequest>> fn
    ) throws IOException, OpenSearchException {
        return getSettings(fn.apply(new GetClusterSettingsRequest.Builder()).build());
    }

    /**
     * Returns cluster settings.
     */
    public final CompletableFuture<GetClusterSettingsResponse> getSettings() throws IOException, OpenSearchException {
        return getSettings(new GetClusterSettingsRequest.Builder().build());
    }

    // ----- Endpoint: cluster.get_weighted_routing

    /**
     * Fetches weighted shard routing weights.
     */
    public CompletableFuture<GetWeightedRoutingResponse> getWeightedRouting(GetWeightedRoutingRequest request) throws IOException,
        OpenSearchException {
        return this.transport.performRequestAsync(request, GetWeightedRoutingRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Fetches weighted shard routing weights.
     *
     * @param fn a function that initializes a builder to create the {@link GetWeightedRoutingRequest}
     */
    public final CompletableFuture<GetWeightedRoutingResponse> getWeightedRouting(
        Function<GetWeightedRoutingRequest.Builder, ObjectBuilder<GetWeightedRoutingRequest>> fn
    ) throws IOException, OpenSearchException {
        return getWeightedRouting(fn.apply(new GetWeightedRoutingRequest.Builder()).build());
    }

    // ----- Endpoint: cluster.health

    /**
     * Returns basic information about the health of the cluster.
     */
    public CompletableFuture<HealthResponse> health(HealthRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, HealthRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Returns basic information about the health of the cluster.
     *
     * @param fn a function that initializes a builder to create the {@link HealthRequest}
     */
    public final CompletableFuture<HealthResponse> health(Function<HealthRequest.Builder, ObjectBuilder<HealthRequest>> fn)
        throws IOException, OpenSearchException {
        return health(fn.apply(new HealthRequest.Builder()).build());
    }

    /**
     * Returns basic information about the health of the cluster.
     */
    public final CompletableFuture<HealthResponse> health() throws IOException, OpenSearchException {
        return health(new HealthRequest.Builder().build());
    }

    // ----- Endpoint: cluster.pending_tasks

    /**
     * Returns a list of pending cluster-level tasks, such as index creation, mapping updates, or new allocations.
     */
    public CompletableFuture<PendingTasksResponse> pendingTasks(PendingTasksRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, PendingTasksRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Returns a list of pending cluster-level tasks, such as index creation, mapping updates, or new allocations.
     *
     * @param fn a function that initializes a builder to create the {@link PendingTasksRequest}
     */
    public final CompletableFuture<PendingTasksResponse> pendingTasks(
        Function<PendingTasksRequest.Builder, ObjectBuilder<PendingTasksRequest>> fn
    ) throws IOException, OpenSearchException {
        return pendingTasks(fn.apply(new PendingTasksRequest.Builder()).build());
    }

    /**
     * Returns a list of pending cluster-level tasks, such as index creation, mapping updates, or new allocations.
     */
    public final CompletableFuture<PendingTasksResponse> pendingTasks() throws IOException, OpenSearchException {
        return pendingTasks(new PendingTasksRequest.Builder().build());
    }

    // ----- Endpoint: cluster.post_voting_config_exclusions

    /**
     * Updates the cluster voting configuration by excluding certain node IDs or names.
     */
    public CompletableFuture<BooleanResponse> postVotingConfigExclusions(PostVotingConfigExclusionsRequest request) throws IOException,
        OpenSearchException {
        return this.transport.performRequestAsync(request, PostVotingConfigExclusionsRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Updates the cluster voting configuration by excluding certain node IDs or names.
     *
     * @param fn a function that initializes a builder to create the {@link PostVotingConfigExclusionsRequest}
     */
    public final CompletableFuture<BooleanResponse> postVotingConfigExclusions(
        Function<PostVotingConfigExclusionsRequest.Builder, ObjectBuilder<PostVotingConfigExclusionsRequest>> fn
    ) throws IOException, OpenSearchException {
        return postVotingConfigExclusions(fn.apply(new PostVotingConfigExclusionsRequest.Builder()).build());
    }

    /**
     * Updates the cluster voting configuration by excluding certain node IDs or names.
     */
    public final CompletableFuture<BooleanResponse> postVotingConfigExclusions() throws IOException, OpenSearchException {
        return postVotingConfigExclusions(new PostVotingConfigExclusionsRequest.Builder().build());
    }

    // ----- Endpoint: cluster.put_component_template

    /**
     * Creates or updates a component template.
     */
    public CompletableFuture<PutComponentTemplateResponse> putComponentTemplate(PutComponentTemplateRequest request) throws IOException,
        OpenSearchException {
        return this.transport.performRequestAsync(request, PutComponentTemplateRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Creates or updates a component template.
     *
     * @param fn a function that initializes a builder to create the {@link PutComponentTemplateRequest}
     */
    public final CompletableFuture<PutComponentTemplateResponse> putComponentTemplate(
        Function<PutComponentTemplateRequest.Builder, ObjectBuilder<PutComponentTemplateRequest>> fn
    ) throws IOException, OpenSearchException {
        return putComponentTemplate(fn.apply(new PutComponentTemplateRequest.Builder()).build());
    }

    // ----- Endpoint: cluster.put_decommission_awareness

    /**
     * Decommissions a cluster zone based on awareness. This can greatly benefit multi-zone deployments, where awareness attributes can aid
     * in applying new upgrades to a cluster in a controlled fashion.
     */
    public CompletableFuture<PutDecommissionAwarenessResponse> putDecommissionAwareness(PutDecommissionAwarenessRequest request)
        throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, PutDecommissionAwarenessRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Decommissions a cluster zone based on awareness. This can greatly benefit multi-zone deployments, where awareness attributes can aid
     * in applying new upgrades to a cluster in a controlled fashion.
     *
     * @param fn a function that initializes a builder to create the {@link PutDecommissionAwarenessRequest}
     */
    public final CompletableFuture<PutDecommissionAwarenessResponse> putDecommissionAwareness(
        Function<PutDecommissionAwarenessRequest.Builder, ObjectBuilder<PutDecommissionAwarenessRequest>> fn
    ) throws IOException, OpenSearchException {
        return putDecommissionAwareness(fn.apply(new PutDecommissionAwarenessRequest.Builder()).build());
    }

    // ----- Endpoint: cluster.put_settings

    /**
     * Updates the cluster settings.
     */
    public CompletableFuture<PutClusterSettingsResponse> putSettings(PutClusterSettingsRequest request) throws IOException,
        OpenSearchException {
        return this.transport.performRequestAsync(request, PutClusterSettingsRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Updates the cluster settings.
     *
     * @param fn a function that initializes a builder to create the {@link PutClusterSettingsRequest}
     */
    public final CompletableFuture<PutClusterSettingsResponse> putSettings(
        Function<PutClusterSettingsRequest.Builder, ObjectBuilder<PutClusterSettingsRequest>> fn
    ) throws IOException, OpenSearchException {
        return putSettings(fn.apply(new PutClusterSettingsRequest.Builder()).build());
    }

    /**
     * Updates the cluster settings.
     */
    public final CompletableFuture<PutClusterSettingsResponse> putSettings() throws IOException, OpenSearchException {
        return putSettings(new PutClusterSettingsRequest.Builder().build());
    }

    // ----- Endpoint: cluster.put_weighted_routing

    /**
     * Updates weighted shard routing weights.
     */
    public CompletableFuture<PutWeightedRoutingResponse> putWeightedRouting(PutWeightedRoutingRequest request) throws IOException,
        OpenSearchException {
        return this.transport.performRequestAsync(request, PutWeightedRoutingRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Updates weighted shard routing weights.
     *
     * @param fn a function that initializes a builder to create the {@link PutWeightedRoutingRequest}
     */
    public final CompletableFuture<PutWeightedRoutingResponse> putWeightedRouting(
        Function<PutWeightedRoutingRequest.Builder, ObjectBuilder<PutWeightedRoutingRequest>> fn
    ) throws IOException, OpenSearchException {
        return putWeightedRouting(fn.apply(new PutWeightedRoutingRequest.Builder()).build());
    }

    // ----- Endpoint: cluster.remote_info

    /**
     * Returns the information about configured remote clusters.
     */
    public CompletableFuture<RemoteInfoResponse> remoteInfo(RemoteInfoRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, RemoteInfoRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Returns the information about configured remote clusters.
     *
     * @param fn a function that initializes a builder to create the {@link RemoteInfoRequest}
     */
    public final CompletableFuture<RemoteInfoResponse> remoteInfo(Function<RemoteInfoRequest.Builder, ObjectBuilder<RemoteInfoRequest>> fn)
        throws IOException, OpenSearchException {
        return remoteInfo(fn.apply(new RemoteInfoRequest.Builder()).build());
    }

    /**
     * Returns the information about configured remote clusters.
     */
    public final CompletableFuture<RemoteInfoResponse> remoteInfo() throws IOException, OpenSearchException {
        return remoteInfo(new RemoteInfoRequest.Builder().build());
    }

    // ----- Endpoint: cluster.reroute

    /**
     * Allows to manually change the allocation of individual shards in the cluster.
     */
    public CompletableFuture<RerouteResponse> reroute(RerouteRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, RerouteRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Allows to manually change the allocation of individual shards in the cluster.
     *
     * @param fn a function that initializes a builder to create the {@link RerouteRequest}
     */
    public final CompletableFuture<RerouteResponse> reroute(Function<RerouteRequest.Builder, ObjectBuilder<RerouteRequest>> fn)
        throws IOException, OpenSearchException {
        return reroute(fn.apply(new RerouteRequest.Builder()).build());
    }

    /**
     * Allows to manually change the allocation of individual shards in the cluster.
     */
    public final CompletableFuture<RerouteResponse> reroute() throws IOException, OpenSearchException {
        return reroute(new RerouteRequest.Builder().build());
    }

    // ----- Endpoint: cluster.state

    /**
     * Returns comprehensive information about the state of the cluster.
     */
    public CompletableFuture<StateResponse> state(StateRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, StateRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Returns comprehensive information about the state of the cluster.
     *
     * @param fn a function that initializes a builder to create the {@link StateRequest}
     */
    public final CompletableFuture<StateResponse> state(Function<StateRequest.Builder, ObjectBuilder<StateRequest>> fn) throws IOException,
        OpenSearchException {
        return state(fn.apply(new StateRequest.Builder()).build());
    }

    /**
     * Returns comprehensive information about the state of the cluster.
     */
    public final CompletableFuture<StateResponse> state() throws IOException, OpenSearchException {
        return state(new StateRequest.Builder().build());
    }

    // ----- Endpoint: cluster.stats

    /**
     * Returns a high-level overview of cluster statistics.
     */
    public CompletableFuture<ClusterStatsResponse> stats(ClusterStatsRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, ClusterStatsRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Returns a high-level overview of cluster statistics.
     *
     * @param fn a function that initializes a builder to create the {@link ClusterStatsRequest}
     */
    public final CompletableFuture<ClusterStatsResponse> stats(Function<ClusterStatsRequest.Builder, ObjectBuilder<ClusterStatsRequest>> fn)
        throws IOException, OpenSearchException {
        return stats(fn.apply(new ClusterStatsRequest.Builder()).build());
    }

    /**
     * Returns a high-level overview of cluster statistics.
     */
    public final CompletableFuture<ClusterStatsResponse> stats() throws IOException, OpenSearchException {
        return stats(new ClusterStatsRequest.Builder().build());
    }
}
