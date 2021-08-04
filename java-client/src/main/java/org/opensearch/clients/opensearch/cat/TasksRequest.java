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

package org.opensearch.clients.opensearch.cat;

import org.opensearch.clients.opensearch._types.ErrorResponse;
import org.opensearch.clients.transport.Endpoint;
import org.opensearch.clients.transport.SimpleEndpoint;
import org.opensearch.clients.util.ModelTypeHelper;
import org.opensearch.clients.util.ObjectBuilder;
import org.opensearch.clients.util.ObjectBuilderBase;

import java.lang.Boolean;
import java.lang.Long;
import java.lang.String;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Nullable;

// typedef: cat.tasks.Request

public class TasksRequest extends CatRequestBase {
	private final List<String> actions;

	@Nullable
	private final Boolean detailed;

	private final List<String> nodeId;

	@Nullable
	private final Long parentTask;

	// ---------------------------------------------------------------------------------------------

	private TasksRequest(Builder builder) {

		this.actions = ModelTypeHelper.unmodifiable(builder.actions);
		this.detailed = builder.detailed;
		this.nodeId = ModelTypeHelper.unmodifiable(builder.nodeId);
		this.parentTask = builder.parentTask;

	}

	public static TasksRequest of(Function<Builder, ObjectBuilder<TasksRequest>> fn) {
		return fn.apply(new Builder()).build();
	}

	/**
	 * A comma-separated list of actions that should be returned. Leave empty to
	 * return all.
	 * <p>
	 * API name: {@code actions}
	 */
	public final List<String> actions() {
		return this.actions;
	}

	/**
	 * Return detailed task information (default: false)
	 * <p>
	 * API name: {@code detailed}
	 */
	@Nullable
	public final Boolean detailed() {
		return this.detailed;
	}

	/**
	 * API name: {@code node_id}
	 */
	public final List<String> nodeId() {
		return this.nodeId;
	}

	/**
	 * API name: {@code parent_task}
	 */
	@Nullable
	public final Long parentTask() {
		return this.parentTask;
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link TasksRequest}.
	 */
	public static class Builder extends ObjectBuilderBase implements ObjectBuilder<TasksRequest> {
		@Nullable
		private List<String> actions;

		@Nullable
		private Boolean detailed;

		@Nullable
		private List<String> nodeId;

		@Nullable
		private Long parentTask;

		/**
		 * A comma-separated list of actions that should be returned. Leave empty to
		 * return all.
		 * <p>
		 * API name: {@code actions}
		 */
		public final Builder actions(@Nullable List<String> value) {
			this.actions = value;
			return this;
		}

		/**
		 * A comma-separated list of actions that should be returned. Leave empty to
		 * return all.
		 * <p>
		 * API name: {@code actions}
		 */
		public final Builder actions(String... value) {
			this.actions = Arrays.asList(value);
			return this;
		}

		/**
		 * Return detailed task information (default: false)
		 * <p>
		 * API name: {@code detailed}
		 */
		public final Builder detailed(@Nullable Boolean value) {
			this.detailed = value;
			return this;
		}

		/**
		 * API name: {@code node_id}
		 */
		public final Builder nodeId(@Nullable List<String> value) {
			this.nodeId = value;
			return this;
		}

		/**
		 * API name: {@code node_id}
		 */
		public final Builder nodeId(String... value) {
			this.nodeId = Arrays.asList(value);
			return this;
		}

		/**
		 * API name: {@code parent_task}
		 */
		public final Builder parentTask(@Nullable Long value) {
			this.parentTask = value;
			return this;
		}

		/**
		 * Builds a {@link TasksRequest}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public TasksRequest build() {
			_checkSingleUse();

			return new TasksRequest(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Endpoint "{@code cat.tasks}".
	 */
	public static final Endpoint<TasksRequest, TasksResponse, ErrorResponse> ENDPOINT = new SimpleEndpoint<>(
			// Request method
			request -> {
				return "GET";

			},

			// Request path
			request -> {
				return "/_cat/tasks";

			},

			// Request parameters
			request -> {
				Map<String, String> params = new HashMap<>();
				params.put("format", "json");
				if (request.detailed != null) {
					params.put("detailed", String.valueOf(request.detailed));
				}
				if (request.parentTask != null) {
					params.put("parent_task", String.valueOf(request.parentTask));
				}
				if (ModelTypeHelper.isDefined(request.actions)) {
					params.put("actions", request.actions.stream().map(v -> v).collect(Collectors.joining(",")));
				}
				if (ModelTypeHelper.isDefined(request.nodeId)) {
					params.put("node_id", request.nodeId.stream().map(v -> v).collect(Collectors.joining(",")));
				}
				return params;

			}, SimpleEndpoint.emptyMap(), false, TasksResponse._DESERIALIZER);
}
