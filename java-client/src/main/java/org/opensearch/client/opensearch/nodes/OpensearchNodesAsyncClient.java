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

import org.opensearch.client.ApiClient;
import org.opensearch.client.opensearch._types.OpensearchException;
import org.opensearch.client.transport.Transport;
import org.opensearch.client.transport.TransportOptions;
import org.opensearch.client.util.ObjectBuilder;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;
import javax.annotation.Nullable;

/**
 * Client for the nodes namespace.
 */
public class OpensearchNodesAsyncClient extends ApiClient<OpensearchNodesAsyncClient> {

	public OpensearchNodesAsyncClient(org.opensearch.client.transport.Transport transport) {
		super(transport, null);
	}

	public OpensearchNodesAsyncClient(Transport transport, @Nullable TransportOptions transportOptions) {
		super(transport, transportOptions);
	}

	@Override
	public OpensearchNodesAsyncClient withTransportOptions(@Nullable TransportOptions transportOptions) {
		return new OpensearchNodesAsyncClient(this.transport, transportOptions);
	}

	// ----- Endpoint: nodes.hot_threads

	/**
	 * Returns information about hot threads on each node in the cluster.
	 * 
	 * 
	 */

	public CompletableFuture<HotThreadsResponse> hotThreads(HotThreadsRequest request)
			throws IOException, OpensearchException {
		return this.transport.performRequestAsync(request, HotThreadsRequest.ENDPOINT, this.transportOptions);
	}

	/**
	 * Returns information about hot threads on each node in the cluster.
	 * 
	 * @param fn
	 *            a function that initializes a builder to create the
	 *            {@link HotThreadsRequest}
	 * 
	 */

	public final CompletableFuture<HotThreadsResponse> hotThreads(
			Function<HotThreadsRequest.Builder, ObjectBuilder<HotThreadsRequest>> fn)
			throws IOException, OpensearchException {
		return hotThreads(fn.apply(new HotThreadsRequest.Builder()).build());
	}

	/**
	 * Returns information about hot threads on each node in the cluster.
	 * 
	 * 
	 */

	public CompletableFuture<HotThreadsResponse> hotThreads() throws IOException, OpensearchException {
		return this.transport.performRequestAsync(new HotThreadsRequest.Builder().build(), HotThreadsRequest.ENDPOINT,
				this.transportOptions);
	}

	// ----- Endpoint: nodes.info

	/**
	 * Returns information about nodes in the cluster.
	 * 
	 * 
	 */

	public CompletableFuture<NodesInfoResponse> info(NodesInfoRequest request)
			throws IOException, OpensearchException {
		return this.transport.performRequestAsync(request, NodesInfoRequest.ENDPOINT, this.transportOptions);
	}

	/**
	 * Returns information about nodes in the cluster.
	 * 
	 * @param fn
	 *            a function that initializes a builder to create the
	 *            {@link NodesInfoRequest}
	 * 
	 */

	public final CompletableFuture<NodesInfoResponse> info(
			Function<NodesInfoRequest.Builder, ObjectBuilder<NodesInfoRequest>> fn)
			throws IOException, OpensearchException {
		return info(fn.apply(new NodesInfoRequest.Builder()).build());
	}

	/**
	 * Returns information about nodes in the cluster.
	 * 
	 * 
	 */

	public CompletableFuture<NodesInfoResponse> info() throws IOException, OpensearchException {
		return this.transport.performRequestAsync(new NodesInfoRequest.Builder().build(), NodesInfoRequest.ENDPOINT,
				this.transportOptions);
	}

	// ----- Endpoint: nodes.reload_secure_settings

	/**
	 * Reloads secure settings.
	 * 
	 * 
	 */

	public CompletableFuture<ReloadSecureSettingsResponse> reloadSecureSettings(ReloadSecureSettingsRequest request)
			throws IOException, OpensearchException {
		return this.transport.performRequestAsync(request, ReloadSecureSettingsRequest.ENDPOINT, this.transportOptions);
	}

	/**
	 * Reloads secure settings.
	 * 
	 * @param fn
	 *            a function that initializes a builder to create the
	 *            {@link ReloadSecureSettingsRequest}
	 * 
	 */

	public final CompletableFuture<ReloadSecureSettingsResponse> reloadSecureSettings(
			Function<ReloadSecureSettingsRequest.Builder, ObjectBuilder<ReloadSecureSettingsRequest>> fn)
			throws IOException, OpensearchException {
		return reloadSecureSettings(fn.apply(new ReloadSecureSettingsRequest.Builder()).build());
	}

	/**
	 * Reloads secure settings.
	 * 
	 * 
	 */

	public CompletableFuture<ReloadSecureSettingsResponse> reloadSecureSettings()
			throws IOException, OpensearchException {
		return this.transport.performRequestAsync(new ReloadSecureSettingsRequest.Builder().build(),
				ReloadSecureSettingsRequest.ENDPOINT, this.transportOptions);
	}

	// ----- Endpoint: nodes.stats

	/**
	 * Returns statistical information about nodes in the cluster.
	 * 
	 * 
	 */

	public CompletableFuture<NodesStatsResponse> stats(NodesStatsRequest request)
			throws IOException, OpensearchException {
		return this.transport.performRequestAsync(request, NodesStatsRequest.ENDPOINT, this.transportOptions);
	}

	/**
	 * Returns statistical information about nodes in the cluster.
	 * 
	 * @param fn
	 *            a function that initializes a builder to create the
	 *            {@link NodesStatsRequest}
	 * 
	 */

	public final CompletableFuture<NodesStatsResponse> stats(
			Function<NodesStatsRequest.Builder, ObjectBuilder<NodesStatsRequest>> fn)
			throws IOException, OpensearchException {
		return stats(fn.apply(new NodesStatsRequest.Builder()).build());
	}

	/**
	 * Returns statistical information about nodes in the cluster.
	 * 
	 * 
	 */

	public CompletableFuture<NodesStatsResponse> stats() throws IOException, OpensearchException {
		return this.transport.performRequestAsync(new NodesStatsRequest.Builder().build(), NodesStatsRequest.ENDPOINT,
				this.transportOptions);
	}

	// ----- Endpoint: nodes.usage

	/**
	 * Returns low-level information about REST actions usage on nodes.
	 * 
	 * 
	 */

	public CompletableFuture<UsageResponse> usage(UsageRequest request) throws IOException, OpensearchException {
		return this.transport.performRequestAsync(request, UsageRequest.ENDPOINT, this.transportOptions);
	}

	/**
	 * Returns low-level information about REST actions usage on nodes.
	 * 
	 * @param fn
	 *            a function that initializes a builder to create the
	 *            {@link UsageRequest}
	 * 
	 */

	public final CompletableFuture<UsageResponse> usage(Function<UsageRequest.Builder, ObjectBuilder<UsageRequest>> fn)
			throws IOException, OpensearchException {
		return usage(fn.apply(new UsageRequest.Builder()).build());
	}

	/**
	 * Returns low-level information about REST actions usage on nodes.
	 * 
	 * 
	 */

	public CompletableFuture<UsageResponse> usage() throws IOException, OpensearchException {
		return this.transport.performRequestAsync(new UsageRequest.Builder().build(), UsageRequest.ENDPOINT,
				this.transportOptions);
	}

}
