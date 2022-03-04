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

package org.opensearch.client.opensearch.indices;

import jakarta.json.JsonValue;
import jakarta.json.stream.JsonGenerator;
import org.opensearch.client.base.OpenSearchError;
import org.opensearch.client.base.Endpoint;
import org.opensearch.client.opensearch._types.RequestBase;
import org.opensearch.client.opensearch._types.mapping.AllField;
import org.opensearch.client.opensearch._types.mapping.DynamicTemplate;
import org.opensearch.client.opensearch._types.mapping.FieldNamesField;
import org.opensearch.client.opensearch._types.mapping.IndexField;
import org.opensearch.client.opensearch._types.mapping.RoutingField;
import org.opensearch.client.opensearch._types.mapping.RuntimeField;
import org.opensearch.client.opensearch._types.mapping.SizeField;
import org.opensearch.client.opensearch._types.mapping.SourceField;
import org.opensearch.client.json.DelegatingDeserializer;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ToJsonp;
import org.opensearch.client.util.ObjectBuilder;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

// typedef: indices.put_mapping.Request
public final class PutMappingRequest extends RequestBase implements ToJsonp {
	@Nullable
	private final List<String> index;

	@Nullable
	private final String type;

	@Nullable
	private final Boolean allowNoIndices;

	@Nullable
	private final JsonValue expandWildcards;

	@Nullable
	private final Boolean ignoreUnavailable;

	@Nullable
	private final Boolean includeTypeName;

	@Nullable
	private final JsonValue masterTimeout;

	@Nullable
	private final JsonValue timeout;

	@Nullable
	private final Boolean writeIndexOnly;

	@Nullable
	private final Map<String, JsonValue> properties;

	// ---------------------------------------------------------------------------------------------

	protected PutMappingRequest(Builder builder) {

		this.index = builder.index;
		this.type = builder.type;
		this.allowNoIndices = builder.allowNoIndices;
		this.expandWildcards = builder.expandWildcards;
		this.ignoreUnavailable = builder.ignoreUnavailable;
		this.includeTypeName = builder.includeTypeName;
		this.masterTimeout = builder.masterTimeout;
		this.timeout = builder.timeout;
		this.writeIndexOnly = builder.writeIndexOnly;
		this.properties = builder.properties;

	}

	/**
	 * API name: {@code index}
	 */
	@Nullable
	public List<String> index() {
		return this.index;
	}

	/**
	 * API name: {@code type}
	 */
	@Nullable
	public String type() {
		return this.type;
	}

	/**
	 * API name: {@code allow_no_indices}
	 */
	@Nullable
	public Boolean allowNoIndices() {
		return this.allowNoIndices;
	}

	/**
	 * API name: {@code expand_wildcards}
	 */
	@Nullable
	public JsonValue expandWildcards() {
		return this.expandWildcards;
	}

	/**
	 * API name: {@code ignore_unavailable}
	 */
	@Nullable
	public Boolean ignoreUnavailable() {
		return this.ignoreUnavailable;
	}

	/**
	 * API name: {@code include_type_name}
	 */
	@Nullable
	public Boolean includeTypeName() {
		return this.includeTypeName;
	}

	/**
	 * API name: {@code master_timeout}
	 */
	@Nullable
	public JsonValue masterTimeout() {
		return this.masterTimeout;
	}

	/**
	 * API name: {@code timeout}
	 */
	@Nullable
	public JsonValue timeout() {
		return this.timeout;
	}

	/**
	 * API name: {@code write_index_only}
	 */
	@Nullable
	public Boolean writeIndexOnly() {
		return this.writeIndexOnly;
	}

	/**
	 * API name: {@code properties}
	 */
	@Nullable
	public Map<String, JsonValue> properties() {
		return this.properties;
	}

	/**
	 * Serialize this object to JSON.
	 */
	public void toJsonp(JsonGenerator generator, JsonpMapper mapper) {
		generator.writeStartObject();
		toJsonpInternal(generator, mapper);
		generator.writeEnd();
	}

	protected void toJsonpInternal(JsonGenerator generator, JsonpMapper mapper) {
		if (this.properties != null) {

			generator.writeKey("properties");
			generator.writeStartObject();
			for (Map.Entry<String, JsonValue> item0 : this.properties.entrySet()) {
				generator.writeKey(item0.getKey());
				generator.write(item0.getValue());

			}
			generator.writeEnd();

		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link PutMappingRequest}.
	 */
	public static class Builder implements ObjectBuilder<PutMappingRequest> {
		@Nullable
		private List<String> index;

		@Nullable
		private String type;

		@Nullable
		private Boolean allowNoIndices;

		@Nullable
		private JsonValue expandWildcards;

		@Nullable
		private Boolean ignoreUnavailable;

		@Nullable
		private Boolean includeTypeName;

		@Nullable
		private JsonValue masterTimeout;

		@Nullable
		private JsonValue timeout;

		@Nullable
		private Boolean writeIndexOnly;

		@Nullable
		private Map<String, JsonValue> properties;

		/**
		 * API name: {@code index}
		 */
		public Builder index(@Nullable List<String> value) {
			this.index = value;
			return this;
		}

		/**
		 * API name: {@code index}
		 */
		public Builder index(String... value) {
			this.index = Arrays.asList(value);
			return this;
		}

		/**
		 * Add a value to {@link #index(List)}, creating the list if needed.
		 */
		public Builder addIndex(String value) {
			if (this.index == null) {
				this.index = new ArrayList<>();
			}
			this.index.add(value);
			return this;
		}

		/**
		 * API name: {@code type}
		 */
		public Builder type(@Nullable String value) {
			this.type = value;
			return this;
		}

		/**
		 * API name: {@code allow_no_indices}
		 */
		public Builder allowNoIndices(@Nullable Boolean value) {
			this.allowNoIndices = value;
			return this;
		}

		/**
		 * API name: {@code expand_wildcards}
		 */
		public Builder expandWildcards(@Nullable JsonValue value) {
			this.expandWildcards = value;
			return this;
		}

		/**
		 * API name: {@code ignore_unavailable}
		 */
		public Builder ignoreUnavailable(@Nullable Boolean value) {
			this.ignoreUnavailable = value;
			return this;
		}

		/**
		 * API name: {@code include_type_name}
		 */
		public Builder includeTypeName(@Nullable Boolean value) {
			this.includeTypeName = value;
			return this;
		}

		/**
		 * API name: {@code master_timeout}
		 */
		public Builder masterTimeout(@Nullable JsonValue value) {
			this.masterTimeout = value;
			return this;
		}

		/**
		 * API name: {@code timeout}
		 */
		public Builder timeout(@Nullable JsonValue value) {
			this.timeout = value;
			return this;
		}

		/**
		 * API name: {@code write_index_only}
		 */
		public Builder writeIndexOnly(@Nullable Boolean value) {
			this.writeIndexOnly = value;
			return this;
		}

		/**
		 * API name: {@code properties}
		 */
		public Builder properties(@Nullable Map<String, JsonValue> value) {
			this.properties = value;
			return this;
		}

		/**
		 * Add a key/value to {@link #properties(Map)}, creating the map if needed.
		 */
		public Builder putProperties(String key, JsonValue value) {
			if (this.properties == null) {
				this.properties = new HashMap<>();
			}
			this.properties.put(key, value);
			return this;
		}

		/**
		/**
		 * Builds a {@link PutMappingRequest}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public PutMappingRequest build() {

			return new PutMappingRequest(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Json deserializer for PutMappingRequest
	 */
	public static final JsonpDeserializer<PutMappingRequest> DESERIALIZER = ObjectBuilderDeserializer
			.createForObject(Builder::new, PutMappingRequest::setupPutMappingRequestDeserializer);

	protected static void setupPutMappingRequestDeserializer(DelegatingDeserializer<PutMappingRequest.Builder> op) {

		op.add(Builder::properties, JsonpDeserializer.stringMapDeserializer(JsonpDeserializer.jsonValueDeserializer()),
				"properties");

	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Endpoint "{@code indices.put_mapping}".
	 */
	public static final Endpoint<PutMappingRequest, PutMappingResponse, OpenSearchError> ENDPOINT = new Endpoint.Simple<>(
			// Request method
			request -> {
				return "PUT";

			},

			// Request path
			request -> {
				final int _index = 1 << 0;
				final int _type = 1 << 1;

				int propsSet = 0;

				if (request.index() != null)
					propsSet |= _index;
				if (request.type() != null)
					propsSet |= _type;

				if (propsSet == (_index)) {
					StringBuilder buf = new StringBuilder();
					buf.append("/");
					buf.append(request.index.stream().map(v -> v).collect(Collectors.joining(",")));
					buf.append("/_mapping");
					return buf.toString();
				}
				if (propsSet == (_index | _type)) {
					StringBuilder buf = new StringBuilder();
					buf.append("/");
					buf.append(request.index.stream().map(v -> v).collect(Collectors.joining(",")));
					buf.append("/");
					buf.append(request.type);
					buf.append("/_mapping");
					return buf.toString();
				}
				if (propsSet == (_index | _type)) {
					StringBuilder buf = new StringBuilder();
					buf.append("/");
					buf.append(request.index.stream().map(v -> v).collect(Collectors.joining(",")));
					buf.append("/_mapping");
					buf.append("/");
					buf.append(request.type);
					return buf.toString();
				}
				if (propsSet == (_index | _type)) {
					StringBuilder buf = new StringBuilder();
					buf.append("/");
					buf.append(request.index.stream().map(v -> v).collect(Collectors.joining(",")));
					buf.append("/");
					buf.append(request.type);
					buf.append("/_mappings");
					return buf.toString();
				}
				if (propsSet == (_index | _type)) {
					StringBuilder buf = new StringBuilder();
					buf.append("/");
					buf.append(request.index.stream().map(v -> v).collect(Collectors.joining(",")));
					buf.append("/_mappings");
					buf.append("/");
					buf.append(request.type);
					return buf.toString();
				}
				if (propsSet == (_type)) {
					StringBuilder buf = new StringBuilder();
					buf.append("/_mappings");
					buf.append("/");
					buf.append(request.type);
					return buf.toString();
				}
				if (propsSet == (_index)) {
					StringBuilder buf = new StringBuilder();
					buf.append("/");
					buf.append(request.index.stream().map(v -> v).collect(Collectors.joining(",")));
					buf.append("/_mappings");
					return buf.toString();
				}
				if (propsSet == (_type)) {
					StringBuilder buf = new StringBuilder();
					buf.append("/_mapping");
					buf.append("/");
					buf.append(request.type);
					return buf.toString();
				}
				throw Endpoint.Simple.noPathTemplateFound("path");

			},

			// Request parameters
			request -> {
				Map<String, String> params = new HashMap<>();
				if (request.allowNoIndices != null) {
					params.put("allow_no_indices", String.valueOf(request.allowNoIndices));
				}
				if (request.expandWildcards != null) {
					params.put("expand_wildcards", request.expandWildcards.toString());
				}
				if (request.ignoreUnavailable != null) {
					params.put("ignore_unavailable", String.valueOf(request.ignoreUnavailable));
				}
				if (request.includeTypeName != null) {
					params.put("include_type_name", String.valueOf(request.includeTypeName));
				}
				if (request.masterTimeout != null) {
					params.put("master_timeout", request.masterTimeout.toString());
				}
				if (request.timeout != null) {
					params.put("timeout", request.timeout.toString());
				}
				if (request.writeIndexOnly != null) {
					params.put("write_index_only", String.valueOf(request.writeIndexOnly));
				}
				return params;

			}, Endpoint.Simple.emptyMap(), true, PutMappingResponse.DESERIALIZER);
}
