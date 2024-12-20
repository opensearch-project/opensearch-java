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
import org.opensearch.client.opensearch._types.ErrorResponse;
import org.opensearch.client.opensearch._types.OpenSearchException;
import org.opensearch.client.transport.JsonEndpoint;
import org.opensearch.client.transport.OpenSearchTransport;
import org.opensearch.client.transport.TransportOptions;
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
