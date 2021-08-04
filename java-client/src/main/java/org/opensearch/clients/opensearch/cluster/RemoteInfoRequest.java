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

package org.opensearch.clients.opensearch.cluster;

import org.opensearch.clients.opensearch._types.ErrorResponse;
import org.opensearch.clients.opensearch._types.RequestBase;
import org.opensearch.clients.transport.Endpoint;
import org.opensearch.clients.transport.endpoints.SimpleEndpoint;

import java.util.Collections;

// typedef: cluster.remote_info.Request

/**
 * The cluster remote info API allows you to retrieve all of the configured
 * remote cluster information. It returns connection and endpoint information
 * keyed by the configured remote cluster alias.
 * 
 * @see <a href=
 *      "https://github.com/elastic/elasticsearch-specification/tree/98036c3/specification/cluster/remote_info/ClusterRemoteInfoRequest.ts#L23-L31">API
 *      specification</a>
 */

public class RemoteInfoRequest extends RequestBase {
	public RemoteInfoRequest() {
	}

	/**
	 * Singleton instance for {@link RemoteInfoRequest}.
	 */
	public static final RemoteInfoRequest _INSTANCE = new RemoteInfoRequest();

	// ---------------------------------------------------------------------------------------------

	/**
	 * Endpoint "{@code cluster.remote_info}".
	 */
	public static final Endpoint<RemoteInfoRequest, RemoteInfoResponse, ErrorResponse> _ENDPOINT = new SimpleEndpoint<>(
			"es/cluster.remote_info",

			// Request method
			request -> {
				return "GET";

			},

			// Request path
			request -> {
				return "/_remote/info";

			},

			// Request parameters
			request -> {
				return Collections.emptyMap();

			}, SimpleEndpoint.emptyMap(), false, RemoteInfoResponse._DESERIALIZER);
}
