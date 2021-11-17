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

package org.opensearch.clients.opensearch.indices;

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

// typedef: indices.migrate_to_data_stream.Request

public class MigrateToDataStreamRequest extends RequestBase {
	private final String name;

	// ---------------------------------------------------------------------------------------------

	private MigrateToDataStreamRequest(Builder builder) {

		this.name = ModelTypeHelper.requireNonNull(builder.name, this, "name");

	}

	public static MigrateToDataStreamRequest of(Function<Builder, ObjectBuilder<MigrateToDataStreamRequest>> fn) {
		return fn.apply(new Builder()).build();
	}

	/**
	 * Required - The name of the alias to migrate
	 * <p>
	 * API name: {@code name}
	 */
	public final String name() {
		return this.name;
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link MigrateToDataStreamRequest}.
	 */
	public static class Builder extends ObjectBuilderBase implements ObjectBuilder<MigrateToDataStreamRequest> {
		private String name;

		/**
		 * Required - The name of the alias to migrate
		 * <p>
		 * API name: {@code name}
		 */
		public final Builder name(String value) {
			this.name = value;
			return this;
		}

		/**
		 * Builds a {@link MigrateToDataStreamRequest}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public MigrateToDataStreamRequest build() {
			_checkSingleUse();

			return new MigrateToDataStreamRequest(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Endpoint "{@code indices.migrate_to_data_stream}".
	 */
	public static final Endpoint<MigrateToDataStreamRequest, MigrateToDataStreamResponse, ErrorResponse> ENDPOINT = new SimpleEndpoint<>(
			// Request method
			request -> {
				return "POST";

			},

			// Request path
			request -> {
				final int _name = 1 << 0;

				int propsSet = 0;

				propsSet |= _name;

				if (propsSet == (_name)) {
					StringBuilder buf = new StringBuilder();
					buf.append("/_data_stream");
					buf.append("/_migrate");
					buf.append("/");
					SimpleEndpoint.pathEncode(request.name, buf);
					return buf.toString();
				}
				throw SimpleEndpoint.noPathTemplateFound("path");

			},

			// Request parameters
			request -> {
				return Collections.emptyMap();

			}, SimpleEndpoint.emptyMap(), false, MigrateToDataStreamResponse._DESERIALIZER);
}
