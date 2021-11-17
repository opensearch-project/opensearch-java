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

package org.opensearch.clients.opensearch.shutdown;

import org.opensearch.clients.opensearch._types.ErrorResponse;
import org.opensearch.clients.opensearch._types.RequestBase;
import org.opensearch.clients.transport.Endpoint;
import org.opensearch.clients.transport.SimpleEndpoint;
import org.opensearch.clients.util.ModelTypeHelper;
import org.opensearch.clients.util.ObjectBuilder;
import org.opensearch.clients.util.ObjectBuilderBase;

import java.lang.String;
import java.util.Collections;
import java.util.function.Function;

// typedef: shutdown.delete_node.Request

public class DeleteNodeRequest extends RequestBase {
	private final String nodeId;

	// ---------------------------------------------------------------------------------------------

	private DeleteNodeRequest(Builder builder) {

		this.nodeId = ModelTypeHelper.requireNonNull(builder.nodeId, this, "nodeId");

	}

	public static DeleteNodeRequest of(Function<Builder, ObjectBuilder<DeleteNodeRequest>> fn) {
		return fn.apply(new Builder()).build();
	}

	/**
	 * Required - The node id of node to be removed from the shutdown state
	 * <p>
	 * API name: {@code node_id}
	 */
	public final String nodeId() {
		return this.nodeId;
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link DeleteNodeRequest}.
	 */
	public static class Builder extends ObjectBuilderBase implements ObjectBuilder<DeleteNodeRequest> {
		private String nodeId;

		/**
		 * Required - The node id of node to be removed from the shutdown state
		 * <p>
		 * API name: {@code node_id}
		 */
		public final Builder nodeId(String value) {
			this.nodeId = value;
			return this;
		}

		/**
		 * Builds a {@link DeleteNodeRequest}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public DeleteNodeRequest build() {
			_checkSingleUse();

			return new DeleteNodeRequest(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Endpoint "{@code shutdown.delete_node}".
	 */
	public static final Endpoint<DeleteNodeRequest, DeleteNodeResponse, ErrorResponse> ENDPOINT = new SimpleEndpoint<>(
			// Request method
			request -> {
				return "DELETE";

			},

			// Request path
			request -> {
				final int _nodeId = 1 << 0;

				int propsSet = 0;

				propsSet |= _nodeId;

				if (propsSet == (_nodeId)) {
					StringBuilder buf = new StringBuilder();
					buf.append("/_nodes");
					buf.append("/");
					SimpleEndpoint.pathEncode(request.nodeId, buf);
					buf.append("/shutdown");
					return buf.toString();
				}
				throw SimpleEndpoint.noPathTemplateFound("path");

			},

			// Request parameters
			request -> {
				return Collections.emptyMap();

			}, SimpleEndpoint.emptyMap(), false, DeleteNodeResponse._DESERIALIZER);
}
