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
import org.opensearch.clients.transport.BooleanEndpoint;
import org.opensearch.clients.transport.BooleanResponse;
import org.opensearch.clients.transport.Endpoint;
import org.opensearch.clients.transport.SimpleEndpoint;
import org.opensearch.clients.util.ModelTypeHelper;
import org.opensearch.clients.util.ObjectBuilder;
import org.opensearch.clients.util.ObjectBuilderBase;

import java.lang.Boolean;
import java.lang.String;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Nullable;

// typedef: cluster.exists_component_template.Request

public class ExistsComponentTemplateRequest extends RequestBase {
	@Nullable
	private final Boolean local;

	@Nullable
	private final String masterTimeout;

	private final List<String> name;

	// ---------------------------------------------------------------------------------------------

	private ExistsComponentTemplateRequest(Builder builder) {

		this.local = builder.local;
		this.masterTimeout = builder.masterTimeout;
		this.name = ModelTypeHelper.unmodifiableRequired(builder.name, this, "name");

	}

	public static ExistsComponentTemplateRequest of(
			Function<Builder, ObjectBuilder<ExistsComponentTemplateRequest>> fn) {
		return fn.apply(new Builder()).build();
	}

	/**
	 * If true, the request retrieves information from the local node only. Defaults
	 * to false, which means information is retrieved from the master node.
	 * <p>
	 * API name: {@code local}
	 */
	@Nullable
	public final Boolean local() {
		return this.local;
	}

	/**
	 * Period to wait for a connection to the master node. If no response is
	 * received before the timeout expires, the request fails and returns an error.
	 * <p>
	 * API name: {@code master_timeout}
	 */
	@Nullable
	public final String masterTimeout() {
		return this.masterTimeout;
	}

	/**
	 * Required - Comma-separated list of component template names used to limit the
	 * request. Wildcard (*) expressions are supported.
	 * <p>
	 * API name: {@code name}
	 */
	public final List<String> name() {
		return this.name;
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link ExistsComponentTemplateRequest}.
	 */
	public static class Builder extends ObjectBuilderBase implements ObjectBuilder<ExistsComponentTemplateRequest> {
		@Nullable
		private Boolean local;

		@Nullable
		private String masterTimeout;

		private List<String> name;

		/**
		 * If true, the request retrieves information from the local node only. Defaults
		 * to false, which means information is retrieved from the master node.
		 * <p>
		 * API name: {@code local}
		 */
		public final Builder local(@Nullable Boolean value) {
			this.local = value;
			return this;
		}

		/**
		 * Period to wait for a connection to the master node. If no response is
		 * received before the timeout expires, the request fails and returns an error.
		 * <p>
		 * API name: {@code master_timeout}
		 */
		public final Builder masterTimeout(@Nullable String value) {
			this.masterTimeout = value;
			return this;
		}

		/**
		 * Required - Comma-separated list of component template names used to limit the
		 * request. Wildcard (*) expressions are supported.
		 * <p>
		 * API name: {@code name}
		 */
		public final Builder name(List<String> value) {
			this.name = value;
			return this;
		}

		/**
		 * Required - Comma-separated list of component template names used to limit the
		 * request. Wildcard (*) expressions are supported.
		 * <p>
		 * API name: {@code name}
		 */
		public final Builder name(String... value) {
			this.name = Arrays.asList(value);
			return this;
		}

		/**
		 * Builds a {@link ExistsComponentTemplateRequest}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public ExistsComponentTemplateRequest build() {
			_checkSingleUse();

			return new ExistsComponentTemplateRequest(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Endpoint "{@code cluster.exists_component_template}".
	 */
	public static final Endpoint<ExistsComponentTemplateRequest, BooleanResponse, ErrorResponse> ENDPOINT = new BooleanEndpoint<>(
			// Request method
			request -> {
				return "HEAD";

			},

			// Request path
			request -> {
				final int _name = 1 << 0;

				int propsSet = 0;

				propsSet |= _name;

				if (propsSet == (_name)) {
					StringBuilder buf = new StringBuilder();
					buf.append("/_component_template");
					buf.append("/");
					SimpleEndpoint.pathEncode(request.name.stream().map(v -> v).collect(Collectors.joining(",")), buf);
					return buf.toString();
				}
				throw SimpleEndpoint.noPathTemplateFound("path");

			},

			// Request parameters
			request -> {
				Map<String, String> params = new HashMap<>();
				if (request.masterTimeout != null) {
					params.put("master_timeout", request.masterTimeout);
				}
				if (request.local != null) {
					params.put("local", String.valueOf(request.local));
				}
				return params;

			}, SimpleEndpoint.emptyMap(), false, null);
}
