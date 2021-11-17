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

package org.opensearch.clients.opensearch.dangling_indices;

import org.opensearch.clients.opensearch._types.ErrorResponse;
import org.opensearch.clients.opensearch._types.RequestBase;
import org.opensearch.clients.transport.Endpoint;
import org.opensearch.clients.transport.SimpleEndpoint;

import java.util.Collections;

// typedef: dangling_indices.list_dangling_indices.Request

public class ListDanglingIndicesRequest extends RequestBase {
	public ListDanglingIndicesRequest() {
	}

	/**
	 * Singleton instance for {@link ListDanglingIndicesRequest}.
	 */
	public static final ListDanglingIndicesRequest _INSTANCE = new ListDanglingIndicesRequest();

	// ---------------------------------------------------------------------------------------------

	/**
	 * Endpoint "{@code dangling_indices.list_dangling_indices}".
	 */
	public static final Endpoint<ListDanglingIndicesRequest, ListDanglingIndicesResponse, ErrorResponse> ENDPOINT = new SimpleEndpoint<>(
			// Request method
			request -> {
				return "GET";

			},

			// Request path
			request -> {
				return "/_dangling";

			},

			// Request parameters
			request -> {
				return Collections.emptyMap();

			}, SimpleEndpoint.emptyMap(), false, ListDanglingIndicesResponse._DESERIALIZER);
}
