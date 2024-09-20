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

package org.opensearch.client.opensearch.tasks;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nullable;
import org.opensearch.client.opensearch._types.ErrorResponse;
import org.opensearch.client.opensearch._types.RequestBase;
import org.opensearch.client.opensearch._types.Time;
import org.opensearch.client.transport.Endpoint;
import org.opensearch.client.transport.endpoints.SimpleEndpoint;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;

// typedef: tasks.list.Request

/**
 * Returns a list of tasks.
 */
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class ListRequest extends RequestBase {

    private final List<String> actions;

    @Nullable
    private final Boolean detailed;

    @Nullable
    private final GroupBy groupBy;

    private final List<String> nodes;

    @Nullable
    private final String parentTaskId;

    @Nullable
    private final Time timeout;

    @Nullable
    private final Boolean waitForCompletion;

    // ---------------------------------------------------------------------------------------------

    private ListRequest(Builder builder) {
        this.actions = ApiTypeHelper.unmodifiable(builder.actions);
        this.detailed = builder.detailed;
        this.groupBy = builder.groupBy;
        this.nodes = ApiTypeHelper.unmodifiable(builder.nodes);
        this.parentTaskId = builder.parentTaskId;
        this.timeout = builder.timeout;
        this.waitForCompletion = builder.waitForCompletion;
    }

    public static ListRequest of(Function<ListRequest.Builder, ObjectBuilder<ListRequest>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Comma-separated list or wildcard expression of actions used to limit the request.
     * <p>
     * API name: {@code actions}
     * </p>
     */
    public final List<String> actions() {
        return this.actions;
    }

    /**
     * If `true`, the response includes detailed information about shard recoveries.
     * <p>
     * API name: {@code detailed}
     * </p>
     */
    @Nullable
    public final Boolean detailed() {
        return this.detailed;
    }

    /**
     * Key used to group tasks in the response.
     * <p>
     * API name: {@code group_by}
     * </p>
     */
    @Nullable
    public final GroupBy groupBy() {
        return this.groupBy;
    }

    /**
     * Comma-separated list of node IDs or names to limit the returned information; use `_local` to return information from the node you're
     * connecting to, leave empty to get information from all nodes.
     * <p>
     * API name: {@code nodes}
     * </p>
     */
    public final List<String> nodes() {
        return this.nodes;
    }

    /**
     * Parent task ID used to limit returned information. To return all tasks, omit this parameter or use a value of `-1`.
     * <p>
     * API name: {@code parent_task_id}
     * </p>
     */
    @Nullable
    public final String parentTaskId() {
        return this.parentTaskId;
    }

    /**
     * Period to wait for a response. If no response is received before the timeout expires, the request fails and returns an error.
     * <p>
     * API name: {@code timeout}
     * </p>
     */
    @Nullable
    public final Time timeout() {
        return this.timeout;
    }

    /**
     * If `true`, the request blocks until the operation is complete.
     * <p>
     * API name: {@code wait_for_completion}
     * </p>
     */
    @Nullable
    public final Boolean waitForCompletion() {
        return this.waitForCompletion;
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Builder for {@link ListRequest}.
     */
    public static class Builder extends ObjectBuilderBase implements ObjectBuilder<ListRequest> {
        @Nullable
        private List<String> actions;
        @Nullable
        private Boolean detailed;
        @Nullable
        private GroupBy groupBy;
        @Nullable
        private List<String> nodes;
        @Nullable
        private String parentTaskId;
        @Nullable
        private Time timeout;
        @Nullable
        private Boolean waitForCompletion;

        /**
         * Comma-separated list or wildcard expression of actions used to limit the request.
         * <p>
         * API name: {@code actions}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>actions</code>.
         * </p>
         */
        public final Builder actions(List<String> list) {
            this.actions = _listAddAll(this.actions, list);
            return this;
        }

        /**
         * Comma-separated list or wildcard expression of actions used to limit the request.
         * <p>
         * API name: {@code actions}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>actions</code>.
         * </p>
         */
        public final Builder actions(String value, String... values) {
            this.actions = _listAdd(this.actions, value, values);
            return this;
        }

        /**
         * If `true`, the response includes detailed information about shard recoveries.
         * <p>
         * API name: {@code detailed}
         * </p>
         */
        public final Builder detailed(@Nullable Boolean value) {
            this.detailed = value;
            return this;
        }

        /**
         * Key used to group tasks in the response.
         * <p>
         * API name: {@code group_by}
         * </p>
         */
        public final Builder groupBy(@Nullable GroupBy value) {
            this.groupBy = value;
            return this;
        }

        /**
         * Comma-separated list of node IDs or names to limit the returned information; use `_local` to return information from the node
         * you're connecting to, leave empty to get information from all nodes.
         * <p>
         * API name: {@code nodes}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>nodes</code>.
         * </p>
         */
        public final Builder nodes(List<String> list) {
            this.nodes = _listAddAll(this.nodes, list);
            return this;
        }

        /**
         * Comma-separated list of node IDs or names to limit the returned information; use `_local` to return information from the node
         * you're connecting to, leave empty to get information from all nodes.
         * <p>
         * API name: {@code nodes}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>nodes</code>.
         * </p>
         */
        public final Builder nodes(String value, String... values) {
            this.nodes = _listAdd(this.nodes, value, values);
            return this;
        }

        /**
         * Parent task ID used to limit returned information. To return all tasks, omit this parameter or use a value of `-1`.
         * <p>
         * API name: {@code parent_task_id}
         * </p>
         */
        public final Builder parentTaskId(@Nullable String value) {
            this.parentTaskId = value;
            return this;
        }

        /**
         * Period to wait for a response. If no response is received before the timeout expires, the request fails and returns an error.
         * <p>
         * API name: {@code timeout}
         * </p>
         */
        public final Builder timeout(@Nullable Time value) {
            this.timeout = value;
            return this;
        }

        /**
         * Period to wait for a response. If no response is received before the timeout expires, the request fails and returns an error.
         * <p>
         * API name: {@code timeout}
         * </p>
         */
        public final Builder timeout(Function<Time.Builder, ObjectBuilder<Time>> fn) {
            return timeout(fn.apply(new Time.Builder()).build());
        }

        /**
         * If `true`, the request blocks until the operation is complete.
         * <p>
         * API name: {@code wait_for_completion}
         * </p>
         */
        public final Builder waitForCompletion(@Nullable Boolean value) {
            this.waitForCompletion = value;
            return this;
        }

        /**
         * Builds a {@link ListRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        public ListRequest build() {
            _checkSingleUse();

            return new ListRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Endpoint "{@code tasks.list}".
     */
    public static final Endpoint<ListRequest, ListResponse, ErrorResponse> _ENDPOINT = new SimpleEndpoint<>(
        // Request method
        request -> "GET",
        // Request path
        request -> "/_tasks",
        // Request parameters
        request -> {
            Map<String, String> params = new HashMap<>();
            if (ApiTypeHelper.isDefined(request.actions)) {
                params.put("actions", String.join(",", request.actions));
            }
            if (request.detailed != null) {
                params.put("detailed", String.valueOf(request.detailed));
            }
            if (request.groupBy != null) {
                params.put("group_by", request.groupBy.jsonValue());
            }
            if (ApiTypeHelper.isDefined(request.nodes)) {
                params.put("nodes", String.join(",", request.nodes));
            }
            if (request.parentTaskId != null) {
                params.put("parent_task_id", request.parentTaskId);
            }
            if (request.timeout != null) {
                params.put("timeout", request.timeout._toJsonString());
            }
            if (request.waitForCompletion != null) {
                params.put("wait_for_completion", String.valueOf(request.waitForCompletion));
            }
            return params;
        },
        SimpleEndpoint.emptyMap(),
        false,
        ListResponse._DESERIALIZER
    );

    public int hashCode() {
        int result = 17;
        result = 31 * result + java.util.Objects.hashCode(this.actions);
        result = 31 * result + Boolean.hashCode(this.detailed);
        result = 31 * result + java.util.Objects.hashCode(this.groupBy);
        result = 31 * result + java.util.Objects.hashCode(this.nodes);
        result = 31 * result + java.util.Objects.hashCode(this.parentTaskId);
        result = 31 * result + java.util.Objects.hashCode(this.timeout);
        result = 31 * result + Boolean.hashCode(this.waitForCompletion);
        return result;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (this.getClass() != o.getClass()) return false;
        return true;
    }
}
