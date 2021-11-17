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

package org.opensearch.clients.elasticsearch.cat;

import org.opensearch.clients.elasticsearch._types.ErrorResponse;
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

// typedef: cat.snapshots.Request

public class SnapshotsRequest extends CatRequestBase {
	@Nullable
	private final Boolean ignoreUnavailable;

	private final List<String> repository;

	// ---------------------------------------------------------------------------------------------

	private SnapshotsRequest(Builder builder) {

		this.ignoreUnavailable = builder.ignoreUnavailable;
		this.repository = ModelTypeHelper.unmodifiable(builder.repository);

	}

	public static SnapshotsRequest of(Function<Builder, ObjectBuilder<SnapshotsRequest>> fn) {
		return fn.apply(new Builder()).build();
	}

	/**
	 * Set to true to ignore unavailable snapshots
	 * <p>
	 * API name: {@code ignore_unavailable}
	 */
	@Nullable
	public final Boolean ignoreUnavailable() {
		return this.ignoreUnavailable;
	}

	/**
	 * Name of repository from which to fetch the snapshot information
	 * <p>
	 * API name: {@code repository}
	 */
	public final List<String> repository() {
		return this.repository;
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link SnapshotsRequest}.
	 */
	public static class Builder extends ObjectBuilderBase implements ObjectBuilder<SnapshotsRequest> {
		@Nullable
		private Boolean ignoreUnavailable;

		@Nullable
		private List<String> repository;

		/**
		 * Set to true to ignore unavailable snapshots
		 * <p>
		 * API name: {@code ignore_unavailable}
		 */
		public final Builder ignoreUnavailable(@Nullable Boolean value) {
			this.ignoreUnavailable = value;
			return this;
		}

		/**
		 * Name of repository from which to fetch the snapshot information
		 * <p>
		 * API name: {@code repository}
		 */
		public final Builder repository(@Nullable List<String> value) {
			this.repository = value;
			return this;
		}

		/**
		 * Name of repository from which to fetch the snapshot information
		 * <p>
		 * API name: {@code repository}
		 */
		public final Builder repository(String... value) {
			this.repository = Arrays.asList(value);
			return this;
		}

		/**
		 * Builds a {@link SnapshotsRequest}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public SnapshotsRequest build() {
			_checkSingleUse();

			return new SnapshotsRequest(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Endpoint "{@code cat.snapshots}".
	 */
	public static final Endpoint<SnapshotsRequest, SnapshotsResponse, ErrorResponse> ENDPOINT = new SimpleEndpoint<>(
			// Request method
			request -> {
				return "GET";

			},

			// Request path
			request -> {
				final int _repository = 1 << 0;

				int propsSet = 0;

				if (ModelTypeHelper.isDefined(request.repository()))
					propsSet |= _repository;

				if (propsSet == 0) {
					StringBuilder buf = new StringBuilder();
					buf.append("/_cat");
					buf.append("/snapshots");
					return buf.toString();
				}
				if (propsSet == (_repository)) {
					StringBuilder buf = new StringBuilder();
					buf.append("/_cat");
					buf.append("/snapshots");
					buf.append("/");
					SimpleEndpoint.pathEncode(request.repository.stream().map(v -> v).collect(Collectors.joining(",")),
							buf);
					return buf.toString();
				}
				throw SimpleEndpoint.noPathTemplateFound("path");

			},

			// Request parameters
			request -> {
				Map<String, String> params = new HashMap<>();
				params.put("format", "json");
				if (request.ignoreUnavailable != null) {
					params.put("ignore_unavailable", String.valueOf(request.ignoreUnavailable));
				}
				return params;

			}, SimpleEndpoint.emptyMap(), false, SnapshotsResponse._DESERIALIZER);
}
