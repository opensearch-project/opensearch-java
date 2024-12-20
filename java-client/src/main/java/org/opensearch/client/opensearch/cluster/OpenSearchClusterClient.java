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
import java.util.function.Function;
import javax.annotation.Nullable;
import org.opensearch.client.ApiClient;
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
public class OpenSearchClusterClient extends OpenSearchClusterClientBase<OpenSearchClusterClient> {

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

    // ----- Endpoint: cluster.delete_voting_config_exclusions

    /**
     * Clears cluster voting config exclusions.
     *
     *
     */

    public BooleanResponse deleteVotingConfigExclusions(DeleteVotingConfigExclusionsRequest request) throws IOException,
        OpenSearchException {
        @SuppressWarnings("unchecked")
        JsonEndpoint<DeleteVotingConfigExclusionsRequest, BooleanResponse, ErrorResponse> endpoint = (JsonEndpoint<
            DeleteVotingConfigExclusionsRequest,
            BooleanResponse,
            ErrorResponse>) DeleteVotingConfigExclusionsRequest._ENDPOINT;

        return this.transport.performRequest(request, endpoint, this.transportOptions);
    }

    /**
     * Clears cluster voting config exclusions.
     *
     * @param fn
     *            a function that initializes a builder to create the
     *            {@link DeleteVotingConfigExclusionsRequest}
     *
     */

    public final BooleanResponse deleteVotingConfigExclusions(
        Function<DeleteVotingConfigExclusionsRequest.Builder, ObjectBuilder<DeleteVotingConfigExclusionsRequest>> fn
    ) throws IOException, OpenSearchException {
        return deleteVotingConfigExclusions(fn.apply(new DeleteVotingConfigExclusionsRequest.Builder()).build());
    }

    /**
     * Clears cluster voting config exclusions.
     *
     *
     */

    public BooleanResponse deleteVotingConfigExclusions() throws IOException, OpenSearchException {
        return this.transport.performRequest(
            new DeleteVotingConfigExclusionsRequest.Builder().build(),
            DeleteVotingConfigExclusionsRequest._ENDPOINT,
            this.transportOptions
        );
    }

    // ----- Endpoint: cluster.get_settings

    /**
     * Returns cluster settings.
     *
     *
     */

    public GetClusterSettingsResponse getSettings(GetClusterSettingsRequest request) throws IOException, OpenSearchException {
        @SuppressWarnings("unchecked")
        JsonEndpoint<GetClusterSettingsRequest, GetClusterSettingsResponse, ErrorResponse> endpoint = (JsonEndpoint<
            GetClusterSettingsRequest,
            GetClusterSettingsResponse,
            ErrorResponse>) GetClusterSettingsRequest._ENDPOINT;

        return this.transport.performRequest(request, endpoint, this.transportOptions);
    }

    /**
     * Returns cluster settings.
     *
     * @param fn
     *            a function that initializes a builder to create the
     *            {@link GetClusterSettingsRequest}
     *
     */

    public final GetClusterSettingsResponse getSettings(
        Function<GetClusterSettingsRequest.Builder, ObjectBuilder<GetClusterSettingsRequest>> fn
    ) throws IOException, OpenSearchException {
        return getSettings(fn.apply(new GetClusterSettingsRequest.Builder()).build());
    }

    /**
     * Returns cluster settings.
     *
     *
     */

    public GetClusterSettingsResponse getSettings() throws IOException, OpenSearchException {
        return this.transport.performRequest(
            new GetClusterSettingsRequest.Builder().build(),
            GetClusterSettingsRequest._ENDPOINT,
            this.transportOptions
        );
    }

    // ----- Endpoint: cluster.health

    /**
     * Returns basic information about the health of the cluster.
     *
     *
     */

    public HealthResponse health(HealthRequest request) throws IOException, OpenSearchException {
        @SuppressWarnings("unchecked")
        JsonEndpoint<HealthRequest, HealthResponse, ErrorResponse> endpoint = (JsonEndpoint<
            HealthRequest,
            HealthResponse,
            ErrorResponse>) HealthRequest._ENDPOINT;

        return this.transport.performRequest(request, endpoint, this.transportOptions);
    }

    /**
     * Returns basic information about the health of the cluster.
     *
     * @param fn
     *            a function that initializes a builder to create the
     *            {@link HealthRequest}
     *
     */

    public final HealthResponse health(Function<HealthRequest.Builder, ObjectBuilder<HealthRequest>> fn) throws IOException,
        OpenSearchException {
        return health(fn.apply(new HealthRequest.Builder()).build());
    }

    /**
     * Returns basic information about the health of the cluster.
     *
     *
     */

    public HealthResponse health() throws IOException, OpenSearchException {
        return this.transport.performRequest(new HealthRequest.Builder().build(), HealthRequest._ENDPOINT, this.transportOptions);
    }

    // ----- Endpoint: cluster.pending_tasks

    /**
     * Returns a list of any cluster-level changes (e.g. create index, update
     * mapping, allocate or fail shard) which have not yet been executed.
     *
     *
     */

    public PendingTasksResponse pendingTasks(PendingTasksRequest request) throws IOException, OpenSearchException {
        @SuppressWarnings("unchecked")
        JsonEndpoint<PendingTasksRequest, PendingTasksResponse, ErrorResponse> endpoint = (JsonEndpoint<
            PendingTasksRequest,
            PendingTasksResponse,
            ErrorResponse>) PendingTasksRequest._ENDPOINT;

        return this.transport.performRequest(request, endpoint, this.transportOptions);
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

    public final PendingTasksResponse pendingTasks(Function<PendingTasksRequest.Builder, ObjectBuilder<PendingTasksRequest>> fn)
        throws IOException, OpenSearchException {
        return pendingTasks(fn.apply(new PendingTasksRequest.Builder()).build());
    }

    /**
     * Returns a list of any cluster-level changes (e.g. create index, update
     * mapping, allocate or fail shard) which have not yet been executed.
     *
     *
     */

    public PendingTasksResponse pendingTasks() throws IOException, OpenSearchException {
        return this.transport.performRequest(
            new PendingTasksRequest.Builder().build(),
            PendingTasksRequest._ENDPOINT,
            this.transportOptions
        );
    }

    // ----- Endpoint: cluster.post_voting_config_exclusions

    /**
     * Updates the cluster voting config exclusions by node ids or node names.
     *
     *
     */

    public BooleanResponse postVotingConfigExclusions(PostVotingConfigExclusionsRequest request) throws IOException, OpenSearchException {
        @SuppressWarnings("unchecked")
        JsonEndpoint<PostVotingConfigExclusionsRequest, BooleanResponse, ErrorResponse> endpoint = (JsonEndpoint<
            PostVotingConfigExclusionsRequest,
            BooleanResponse,
            ErrorResponse>) PostVotingConfigExclusionsRequest._ENDPOINT;

        return this.transport.performRequest(request, endpoint, this.transportOptions);
    }

    /**
     * Updates the cluster voting config exclusions by node ids or node names.
     *
     * @param fn
     *            a function that initializes a builder to create the
     *            {@link PostVotingConfigExclusionsRequest}
     *
     */

    public final BooleanResponse postVotingConfigExclusions(
        Function<PostVotingConfigExclusionsRequest.Builder, ObjectBuilder<PostVotingConfigExclusionsRequest>> fn
    ) throws IOException, OpenSearchException {
        return postVotingConfigExclusions(fn.apply(new PostVotingConfigExclusionsRequest.Builder()).build());
    }

    /**
     * Updates the cluster voting config exclusions by node ids or node names.
     *
     *
     */

    public BooleanResponse postVotingConfigExclusions() throws IOException, OpenSearchException {
        return this.transport.performRequest(
            new PostVotingConfigExclusionsRequest.Builder().build(),
            PostVotingConfigExclusionsRequest._ENDPOINT,
            this.transportOptions
        );
    }

    // ----- Endpoint: cluster.put_settings

    /**
     * Updates the cluster settings.
     *
     *
     */

    public PutClusterSettingsResponse putSettings(PutClusterSettingsRequest request) throws IOException, OpenSearchException {
        @SuppressWarnings("unchecked")
        JsonEndpoint<PutClusterSettingsRequest, PutClusterSettingsResponse, ErrorResponse> endpoint = (JsonEndpoint<
            PutClusterSettingsRequest,
            PutClusterSettingsResponse,
            ErrorResponse>) PutClusterSettingsRequest._ENDPOINT;

        return this.transport.performRequest(request, endpoint, this.transportOptions);
    }

    /**
     * Updates the cluster settings.
     *
     * @param fn
     *            a function that initializes a builder to create the
     *            {@link PutClusterSettingsRequest}
     *
     */

    public final PutClusterSettingsResponse putSettings(
        Function<PutClusterSettingsRequest.Builder, ObjectBuilder<PutClusterSettingsRequest>> fn
    ) throws IOException, OpenSearchException {
        return putSettings(fn.apply(new PutClusterSettingsRequest.Builder()).build());
    }

    /**
     * Updates the cluster settings.
     *
     *
     */

    public PutClusterSettingsResponse putSettings() throws IOException, OpenSearchException {
        return this.transport.performRequest(
            new PutClusterSettingsRequest.Builder().build(),
            PutClusterSettingsRequest._ENDPOINT,
            this.transportOptions
        );
    }

    // ----- Endpoint: cluster.remote_info

    /**
     * Returns the information about configured remote clusters.
     *
     *
     */
    public RemoteInfoResponse remoteInfo() throws IOException, OpenSearchException {
        return this.transport.performRequest(RemoteInfoRequest._INSTANCE, RemoteInfoRequest._ENDPOINT, this.transportOptions);
    }

    // ----- Endpoint: cluster.reroute

    /**
     * Allows to manually change the allocation of individual shards in the cluster.
     *
     *
     */

    public RerouteResponse reroute(RerouteRequest request) throws IOException, OpenSearchException {
        @SuppressWarnings("unchecked")
        JsonEndpoint<RerouteRequest, RerouteResponse, ErrorResponse> endpoint = (JsonEndpoint<
            RerouteRequest,
            RerouteResponse,
            ErrorResponse>) RerouteRequest._ENDPOINT;

        return this.transport.performRequest(request, endpoint, this.transportOptions);
    }

    /**
     * Allows to manually change the allocation of individual shards in the cluster.
     *
     * @param fn
     *            a function that initializes a builder to create the
     *            {@link RerouteRequest}
     *
     */

    public final RerouteResponse reroute(Function<RerouteRequest.Builder, ObjectBuilder<RerouteRequest>> fn) throws IOException,
        OpenSearchException {
        return reroute(fn.apply(new RerouteRequest.Builder()).build());
    }

    /**
     * Allows to manually change the allocation of individual shards in the cluster.
     *
     *
     */

    public RerouteResponse reroute() throws IOException, OpenSearchException {
        return this.transport.performRequest(new RerouteRequest.Builder().build(), RerouteRequest._ENDPOINT, this.transportOptions);
    }

    // ----- Endpoint: cluster.state

    /**
     * Returns a comprehensive information about the state of the cluster.
     *
     *
     */

    public StateResponse state(StateRequest request) throws IOException, OpenSearchException {
        @SuppressWarnings("unchecked")
        JsonEndpoint<StateRequest, StateResponse, ErrorResponse> endpoint = (JsonEndpoint<
            StateRequest,
            StateResponse,
            ErrorResponse>) StateRequest._ENDPOINT;

        return this.transport.performRequest(request, endpoint, this.transportOptions);
    }

    /**
     * Returns a comprehensive information about the state of the cluster.
     *
     * @param fn
     *            a function that initializes a builder to create the
     *            {@link StateRequest}
     *
     */

    public final StateResponse state(Function<StateRequest.Builder, ObjectBuilder<StateRequest>> fn) throws IOException,
        OpenSearchException {
        return state(fn.apply(new StateRequest.Builder()).build());
    }

    /**
     * Returns a comprehensive information about the state of the cluster.
     *
     *
     */

    public StateResponse state() throws IOException, OpenSearchException {
        return this.transport.performRequest(new StateRequest.Builder().build(), StateRequest._ENDPOINT, this.transportOptions);
    }

    // ----- Endpoint: cluster.stats

    /**
     * Returns high-level overview of cluster statistics.
     *
     *
     */

    public ClusterStatsResponse stats(ClusterStatsRequest request) throws IOException, OpenSearchException {
        @SuppressWarnings("unchecked")
        JsonEndpoint<ClusterStatsRequest, ClusterStatsResponse, ErrorResponse> endpoint = (JsonEndpoint<
            ClusterStatsRequest,
            ClusterStatsResponse,
            ErrorResponse>) ClusterStatsRequest._ENDPOINT;

        return this.transport.performRequest(request, endpoint, this.transportOptions);
    }

    /**
     * Returns high-level overview of cluster statistics.
     *
     * @param fn
     *            a function that initializes a builder to create the
     *            {@link ClusterStatsRequest}
     *
     */

    public final ClusterStatsResponse stats(Function<ClusterStatsRequest.Builder, ObjectBuilder<ClusterStatsRequest>> fn)
        throws IOException, OpenSearchException {
        return stats(fn.apply(new ClusterStatsRequest.Builder()).build());
    }

    /**
     * Returns high-level overview of cluster statistics.
     *
     *
     */

    public ClusterStatsResponse stats() throws IOException, OpenSearchException {
        return this.transport.performRequest(
            new ClusterStatsRequest.Builder().build(),
            ClusterStatsRequest._ENDPOINT,
            this.transportOptions
        );
    }

}
