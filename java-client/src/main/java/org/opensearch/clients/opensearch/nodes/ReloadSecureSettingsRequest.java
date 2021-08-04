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

package org.opensearch.clients.opensearch.nodes;

import org.opensearch.clients.opensearch._types.ErrorResponse;
import org.opensearch.clients.opensearch._types.RequestBase;
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
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Nullable;

// typedef: nodes.reload_secure_settings.Request
@JsonpDeserializable
public class ReloadSecureSettingsRequest extends RequestBase implements JsonpSerializable {
	private final List<String> nodeId;

	@Nullable
	private final String secureSettingsPassword;

	@Nullable
	private final String timeout;

	// ---------------------------------------------------------------------------------------------

	private ReloadSecureSettingsRequest(Builder builder) {

		this.nodeId = ModelTypeHelper.unmodifiable(builder.nodeId);
		this.secureSettingsPassword = builder.secureSettingsPassword;
		this.timeout = builder.timeout;

	}

	public static ReloadSecureSettingsRequest of(Function<Builder, ObjectBuilder<ReloadSecureSettingsRequest>> fn) {
		return fn.apply(new Builder()).build();
	}

	/**
	 * A comma-separated list of node IDs to span the reload/reinit call. Should
	 * stay empty because reloading usually involves all cluster nodes.
	 * <p>
	 * API name: {@code node_id}
	 */
	public final List<String> nodeId() {
		return this.nodeId;
	}

	/**
	 * API name: {@code secure_settings_password}
	 */
	@Nullable
	public final String secureSettingsPassword() {
		return this.secureSettingsPassword;
	}

	/**
	 * Explicit operation timeout
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

		if (this.secureSettingsPassword != null) {
			generator.writeKey("secure_settings_password");
			generator.write(this.secureSettingsPassword);

		}

	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link ReloadSecureSettingsRequest}.
	 */
	public static class Builder extends ObjectBuilderBase implements ObjectBuilder<ReloadSecureSettingsRequest> {
		@Nullable
		private List<String> nodeId;

		@Nullable
		private String secureSettingsPassword;

		@Nullable
		private String timeout;

		/**
		 * A comma-separated list of node IDs to span the reload/reinit call. Should
		 * stay empty because reloading usually involves all cluster nodes.
		 * <p>
		 * API name: {@code node_id}
		 */
		public final Builder nodeId(@Nullable List<String> value) {
			this.nodeId = value;
			return this;
		}

		/**
		 * A comma-separated list of node IDs to span the reload/reinit call. Should
		 * stay empty because reloading usually involves all cluster nodes.
		 * <p>
		 * API name: {@code node_id}
		 */
		public final Builder nodeId(String... value) {
			this.nodeId = Arrays.asList(value);
			return this;
		}

		/**
		 * API name: {@code secure_settings_password}
		 */
		public final Builder secureSettingsPassword(@Nullable String value) {
			this.secureSettingsPassword = value;
			return this;
		}

		/**
		 * Explicit operation timeout
		 * <p>
		 * API name: {@code timeout}
		 */
		public final Builder timeout(@Nullable String value) {
			this.timeout = value;
			return this;
		}

		/**
		 * Builds a {@link ReloadSecureSettingsRequest}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public ReloadSecureSettingsRequest build() {
			_checkSingleUse();

			return new ReloadSecureSettingsRequest(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Json deserializer for {@link ReloadSecureSettingsRequest}
	 */
	public static final JsonpDeserializer<ReloadSecureSettingsRequest> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
			Builder::new, ReloadSecureSettingsRequest::setupReloadSecureSettingsRequestDeserializer, Builder::build);

	protected static void setupReloadSecureSettingsRequestDeserializer(
			DelegatingDeserializer<ReloadSecureSettingsRequest.Builder> op) {

		op.add(Builder::secureSettingsPassword, JsonpDeserializer.stringDeserializer(), "secure_settings_password");

	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Endpoint "{@code nodes.reload_secure_settings}".
	 */
	public static final Endpoint<ReloadSecureSettingsRequest, ReloadSecureSettingsResponse, ErrorResponse> ENDPOINT = new SimpleEndpoint<>(
			// Request method
			request -> {
				return "POST";

			},

			// Request path
			request -> {
				final int _nodeId = 1 << 0;

				int propsSet = 0;

				if (ModelTypeHelper.isDefined(request.nodeId()))
					propsSet |= _nodeId;

				if (propsSet == 0) {
					StringBuilder buf = new StringBuilder();
					buf.append("/_nodes");
					buf.append("/reload_secure_settings");
					return buf.toString();
				}
				if (propsSet == (_nodeId)) {
					StringBuilder buf = new StringBuilder();
					buf.append("/_nodes");
					buf.append("/");
					SimpleEndpoint.pathEncode(request.nodeId.stream().map(v -> v).collect(Collectors.joining(",")),
							buf);
					buf.append("/reload_secure_settings");
					return buf.toString();
				}
				throw SimpleEndpoint.noPathTemplateFound("path");

			},

			// Request parameters
			request -> {
				Map<String, String> params = new HashMap<>();
				if (request.timeout != null) {
					params.put("timeout", request.timeout);
				}
				return params;

			}, SimpleEndpoint.emptyMap(), true, ReloadSecureSettingsResponse._DESERIALIZER);
}
