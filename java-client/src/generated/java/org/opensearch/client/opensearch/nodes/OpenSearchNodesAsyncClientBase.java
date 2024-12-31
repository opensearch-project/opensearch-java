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

package org.opensearch.client.opensearch.nodes;

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
 * Client for the nodes namespace.
 */
@Generated("org.opensearch.client.codegen.CodeGenerator")
public abstract class OpenSearchNodesAsyncClientBase<Self extends OpenSearchNodesAsyncClientBase<Self>> extends ApiClient<
    OpenSearchTransport,
    Self> {
    public OpenSearchNodesAsyncClientBase(OpenSearchTransport transport, @Nullable TransportOptions transportOptions) {
        super(transport, transportOptions);
    }

    // ----- Endpoint: nodes.info

    /**
     * Returns information about nodes in the cluster.
     */
    public CompletableFuture<NodesInfoResponse> info(NodesInfoRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, NodesInfoRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Returns information about nodes in the cluster.
     *
     * @param fn a function that initializes a builder to create the {@link NodesInfoRequest}
     */
    public final CompletableFuture<NodesInfoResponse> info(Function<NodesInfoRequest.Builder, ObjectBuilder<NodesInfoRequest>> fn)
        throws IOException, OpenSearchException {
        return info(fn.apply(new NodesInfoRequest.Builder()).build());
    }

    /**
     * Returns information about nodes in the cluster.
     */
    public final CompletableFuture<NodesInfoResponse> info() throws IOException, OpenSearchException {
        return info(new NodesInfoRequest.Builder().build());
    }

    // ----- Endpoint: nodes.reload_secure_settings

    /**
     * Reloads secure settings.
     */
    public CompletableFuture<ReloadSecureSettingsResponse> reloadSecureSettings(ReloadSecureSettingsRequest request) throws IOException,
        OpenSearchException {
        return this.transport.performRequestAsync(request, ReloadSecureSettingsRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Reloads secure settings.
     *
     * @param fn a function that initializes a builder to create the {@link ReloadSecureSettingsRequest}
     */
    public final CompletableFuture<ReloadSecureSettingsResponse> reloadSecureSettings(
        Function<ReloadSecureSettingsRequest.Builder, ObjectBuilder<ReloadSecureSettingsRequest>> fn
    ) throws IOException, OpenSearchException {
        return reloadSecureSettings(fn.apply(new ReloadSecureSettingsRequest.Builder()).build());
    }

    /**
     * Reloads secure settings.
     */
    public final CompletableFuture<ReloadSecureSettingsResponse> reloadSecureSettings() throws IOException, OpenSearchException {
        return reloadSecureSettings(new ReloadSecureSettingsRequest.Builder().build());
    }

    // ----- Endpoint: nodes.stats

    /**
     * Returns statistical information about nodes in the cluster.
     */
    public CompletableFuture<NodesStatsResponse> stats(NodesStatsRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, NodesStatsRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Returns statistical information about nodes in the cluster.
     *
     * @param fn a function that initializes a builder to create the {@link NodesStatsRequest}
     */
    public final CompletableFuture<NodesStatsResponse> stats(Function<NodesStatsRequest.Builder, ObjectBuilder<NodesStatsRequest>> fn)
        throws IOException, OpenSearchException {
        return stats(fn.apply(new NodesStatsRequest.Builder()).build());
    }

    /**
     * Returns statistical information about nodes in the cluster.
     */
    public final CompletableFuture<NodesStatsResponse> stats() throws IOException, OpenSearchException {
        return stats(new NodesStatsRequest.Builder().build());
    }
}
