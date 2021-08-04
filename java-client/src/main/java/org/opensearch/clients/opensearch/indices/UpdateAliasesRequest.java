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

package org.opensearch.clients.opensearch.indices;

import org.opensearch.clients.opensearch._types.ErrorResponse;
import org.opensearch.clients.opensearch._types.RequestBase;
import org.opensearch.clients.opensearch.indices.update_aliases.Action;
import org.opensearch.clients.json.DelegatingDeserializer;
import org.opensearch.clients.json.JsonpDeserializable;
import org.opensearch.clients.json.JsonpDeserializer;
import org.opensearch.clients.json.JsonpMapper;
import org.opensearch.clients.json.JsonpSerializable;
import org.opensearch.clients.json.ObjectBuilderDeserializer;
import org.opensearch.clients.transport.Endpoint;
import org.opensearch.clients.transport.SimpleEndpoint;
import org.opensearch.clients.util.ModelTypeHelper;
import org.opensearch.clients.util.ObjectBuilder;
import org.opensearch.clients.util.ObjectBuilderBase;
import jakarta.json.stream.JsonGenerator;

import java.lang.String;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import javax.annotation.Nullable;

// typedef: indices.update_aliases.Request
@JsonpDeserializable
public class UpdateAliasesRequest extends RequestBase implements JsonpSerializable {
	private final List<Action> actions;

	@Nullable
	private final String masterTimeout;

	@Nullable
	private final String timeout;

	// ---------------------------------------------------------------------------------------------

	private UpdateAliasesRequest(Builder builder) {

		this.actions = ModelTypeHelper.unmodifiable(builder.actions);
		this.masterTimeout = builder.masterTimeout;
		this.timeout = builder.timeout;

	}

	public static UpdateAliasesRequest of(Function<Builder, ObjectBuilder<UpdateAliasesRequest>> fn) {
		return fn.apply(new Builder()).build();
	}

	/**
	 * API name: {@code actions}
	 */
	public final List<Action> actions() {
		return this.actions;
	}

	/**
	 * Specify timeout for connection to master
	 * <p>
	 * API name: {@code master_timeout}
	 */
	@Nullable
	public final String masterTimeout() {
		return this.masterTimeout;
	}

	/**
	 * Request timeout
	 * <p>
	 * API name: {@code timeout}
	 */
	@Nullable
	public final String timeout() {
		return this.timeout;
	}

	/**
	 * Serialize this object to JSON.
	 */
	public void serialize(JsonGenerator generator, JsonpMapper mapper) {
		generator.writeStartObject();
		serializeInternal(generator, mapper);
		generator.writeEnd();
	}

	protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {

		if (ModelTypeHelper.isDefined(this.actions)) {
			generator.writeKey("actions");
			generator.writeStartArray();
			for (Action item0 : this.actions) {
				item0.serialize(generator, mapper);

			}
			generator.writeEnd();

		}

	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link UpdateAliasesRequest}.
	 */
	public static class Builder extends ObjectBuilderBase implements ObjectBuilder<UpdateAliasesRequest> {
		@Nullable
		private List<Action> actions;

		@Nullable
		private String masterTimeout;

		@Nullable
		private String timeout;

		/**
		 * API name: {@code actions}
		 */
		public final Builder actions(@Nullable List<Action> value) {
			this.actions = value;
			return this;
		}

		/**
		 * API name: {@code actions}
		 */
		public final Builder actions(Action... value) {
			this.actions = Arrays.asList(value);
			return this;
		}

		/**
		 * API name: {@code actions}
		 */
		@SafeVarargs
		public final Builder actions(Function<Action.Builder, ObjectBuilder<Action>>... fns) {
			this.actions = new ArrayList<>(fns.length);
			for (Function<Action.Builder, ObjectBuilder<Action>> fn : fns) {
				this.actions.add(fn.apply(new Action.Builder()).build());
			}
			return this;
		}

		/**
		 * Specify timeout for connection to master
		 * <p>
		 * API name: {@code master_timeout}
		 */
		public final Builder masterTimeout(@Nullable String value) {
			this.masterTimeout = value;
			return this;
		}

		/**
		 * Request timeout
		 * <p>
		 * API name: {@code timeout}
		 */
		public final Builder timeout(@Nullable String value) {
			this.timeout = value;
			return this;
		}

		/**
		 * Builds a {@link UpdateAliasesRequest}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public UpdateAliasesRequest build() {
			_checkSingleUse();

			return new UpdateAliasesRequest(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Json deserializer for {@link UpdateAliasesRequest}
	 */
	public static final JsonpDeserializer<UpdateAliasesRequest> _DESERIALIZER = ObjectBuilderDeserializer
			.lazy(Builder::new, UpdateAliasesRequest::setupUpdateAliasesRequestDeserializer, Builder::build);

	protected static void setupUpdateAliasesRequestDeserializer(
			DelegatingDeserializer<UpdateAliasesRequest.Builder> op) {

		op.add(Builder::actions, JsonpDeserializer.arrayDeserializer(Action._DESERIALIZER), "actions");

	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Endpoint "{@code indices.update_aliases}".
	 */
	public static final Endpoint<UpdateAliasesRequest, UpdateAliasesResponse, ErrorResponse> ENDPOINT = new SimpleEndpoint<>(
			// Request method
			request -> {
				return "POST";

			},

			// Request path
			request -> {
				return "/_aliases";

			},

			// Request parameters
			request -> {
				Map<String, String> params = new HashMap<>();
				if (request.masterTimeout != null) {
					params.put("master_timeout", request.masterTimeout);
				}
				if (request.timeout != null) {
					params.put("timeout", request.timeout);
				}
				return params;

			}, SimpleEndpoint.emptyMap(), true, UpdateAliasesResponse._DESERIALIZER);
}
