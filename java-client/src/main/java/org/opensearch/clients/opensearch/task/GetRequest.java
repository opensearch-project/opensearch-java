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

package org.opensearch.clients.opensearch.task;

import jakarta.json.JsonValue;
import org.opensearch.clients.base.OpenSearchError;
import org.opensearch.clients.base.Endpoint;
import org.opensearch.clients.opensearch._types.RequestBase;
import org.opensearch.clients.util.ObjectBuilder;

import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

// typedef: task.get.Request
public final class GetRequest extends RequestBase {
	private final String taskId;

	@Nullable
	private final JsonValue timeout;

	@Nullable
	private final Boolean waitForCompletion;

	// ---------------------------------------------------------------------------------------------

	protected GetRequest(Builder builder) {

		this.taskId = Objects.requireNonNull(builder.taskId, "task_id");
		this.timeout = builder.timeout;
		this.waitForCompletion = builder.waitForCompletion;

	}

	/**
	 * API name: {@code task_id}
	 */
	public String taskId() {
		return this.taskId;
	}

	/**
	 * API name: {@code timeout}
	 */
	@Nullable
	public JsonValue timeout() {
		return this.timeout;
	}

	/**
	 * API name: {@code wait_for_completion}
	 */
	@Nullable
	public Boolean waitForCompletion() {
		return this.waitForCompletion;
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link GetRequest}.
	 */
	public static class Builder implements ObjectBuilder<GetRequest> {
		private String taskId;

		@Nullable
		private JsonValue timeout;

		@Nullable
		private Boolean waitForCompletion;

		/**
		 * API name: {@code task_id}
		 */
		public Builder taskId(String value) {
			this.taskId = value;
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
		 * API name: {@code wait_for_completion}
		 */
		public Builder waitForCompletion(@Nullable Boolean value) {
			this.waitForCompletion = value;
			return this;
		}

		/**
		 * Builds a {@link GetRequest}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public GetRequest build() {

			return new GetRequest(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Endpoint "{@code tasks.get}".
	 */
	public static final Endpoint<GetRequest, GetResponse, OpenSearchError> ENDPOINT = new Endpoint.Simple<>(
			// Request method
			request -> {
				return "GET";

			},

			// Request path
			request -> {
				final int _taskId = 1 << 0;

				int propsSet = 0;

				if (request.taskId() != null)
					propsSet |= _taskId;

				if (propsSet == (_taskId)) {
					StringBuilder buf = new StringBuilder();
					buf.append("/_tasks");
					buf.append("/");
					buf.append(request.taskId);
					return buf.toString();
				}
				throw Endpoint.Simple.noPathTemplateFound("path");

			},

			// Request parameters
			request -> {
				Map<String, String> params = new HashMap<>();
				if (request.timeout != null) {
					params.put("timeout", request.timeout.toString());
				}
				if (request.waitForCompletion != null) {
					params.put("wait_for_completion", String.valueOf(request.waitForCompletion));
				}
				return params;

			}, Endpoint.Simple.emptyMap(), false, GetResponse.DESERIALIZER);
}
