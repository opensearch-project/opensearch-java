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
import java.util.Objects;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.opensearch.client.opensearch._types.ErrorResponse;
import org.opensearch.client.opensearch._types.RequestBase;
import org.opensearch.client.transport.Endpoint;
import org.opensearch.client.transport.endpoints.SimpleEndpoint;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: tasks.cancel.Request

/**
 * Cancels a task, if it can be cancelled through an API.
 */
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class CancelRequest extends RequestBase implements ToCopyableBuilder<CancelRequest.Builder, CancelRequest> {

    @Nonnull
    private final List<String> actions;

    @Nonnull
    private final List<String> nodes;

    @Nullable
    private final String parentTaskId;

    @Nullable
    private final String taskId;

    @Nullable
    private final Boolean waitForCompletion;

    // ---------------------------------------------------------------------------------------------

    private CancelRequest(Builder builder) {
        this.actions = ApiTypeHelper.unmodifiable(builder.actions);
        this.nodes = ApiTypeHelper.unmodifiable(builder.nodes);
        this.parentTaskId = builder.parentTaskId;
        this.taskId = builder.taskId;
        this.waitForCompletion = builder.waitForCompletion;
    }

    public static CancelRequest of(Function<CancelRequest.Builder, ObjectBuilder<CancelRequest>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Comma-separated list or wildcard expression of actions used to limit the request.
     * <p>
     * API name: {@code actions}
     * </p>
     */
    @Nonnull
    public final List<String> actions() {
        return this.actions;
    }

    /**
     * Comma-separated list of node IDs or names used to limit the request.
     * <p>
     * API name: {@code nodes}
     * </p>
     */
    @Nonnull
    public final List<String> nodes() {
        return this.nodes;
    }

    /**
     * Parent task ID used to limit the tasks.
     * <p>
     * API name: {@code parent_task_id}
     * </p>
     */
    @Nullable
    public final String parentTaskId() {
        return this.parentTaskId;
    }

    /**
     * ID of the task.
     * <p>
     * API name: {@code task_id}
     * </p>
     */
    @Nullable
    public final String taskId() {
        return this.taskId;
    }

    /**
     * Should the request block until the cancellation of the task and its descendant tasks is completed. Defaults to false
     * <p>
     * API name: {@code wait_for_completion}
     * </p>
     */
    @Nullable
    public final Boolean waitForCompletion() {
        return this.waitForCompletion;
    }

    // ---------------------------------------------------------------------------------------------

    @Override
    @Nonnull
    public Builder toBuilder() {
        return new Builder(this);
    }

    @Nonnull
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Builder for {@link CancelRequest}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, CancelRequest> {
        @Nullable
        private List<String> actions;
        @Nullable
        private List<String> nodes;
        @Nullable
        private String parentTaskId;
        @Nullable
        private String taskId;
        @Nullable
        private Boolean waitForCompletion;

        public Builder() {}

        private Builder(CancelRequest o) {
            this.actions = _listCopy(o.actions);
            this.nodes = _listCopy(o.nodes);
            this.parentTaskId = o.parentTaskId;
            this.taskId = o.taskId;
            this.waitForCompletion = o.waitForCompletion;
        }

        private Builder(Builder o) {
            this.actions = _listCopy(o.actions);
            this.nodes = _listCopy(o.nodes);
            this.parentTaskId = o.parentTaskId;
            this.taskId = o.taskId;
            this.waitForCompletion = o.waitForCompletion;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

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
        @Nonnull
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
        @Nonnull
        public final Builder actions(String value, String... values) {
            this.actions = _listAdd(this.actions, value, values);
            return this;
        }

        /**
         * Comma-separated list of node IDs or names used to limit the request.
         * <p>
         * API name: {@code nodes}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>nodes</code>.
         * </p>
         */
        @Nonnull
        public final Builder nodes(List<String> list) {
            this.nodes = _listAddAll(this.nodes, list);
            return this;
        }

        /**
         * Comma-separated list of node IDs or names used to limit the request.
         * <p>
         * API name: {@code nodes}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>nodes</code>.
         * </p>
         */
        @Nonnull
        public final Builder nodes(String value, String... values) {
            this.nodes = _listAdd(this.nodes, value, values);
            return this;
        }

        /**
         * Parent task ID used to limit the tasks.
         * <p>
         * API name: {@code parent_task_id}
         * </p>
         */
        @Nonnull
        public final Builder parentTaskId(@Nullable String value) {
            this.parentTaskId = value;
            return this;
        }

        /**
         * ID of the task.
         * <p>
         * API name: {@code task_id}
         * </p>
         */
        @Nonnull
        public final Builder taskId(@Nullable String value) {
            this.taskId = value;
            return this;
        }

        /**
         * Should the request block until the cancellation of the task and its descendant tasks is completed. Defaults to false
         * <p>
         * API name: {@code wait_for_completion}
         * </p>
         */
        @Nonnull
        public final Builder waitForCompletion(@Nullable Boolean value) {
            this.waitForCompletion = value;
            return this;
        }

        /**
         * Builds a {@link CancelRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public CancelRequest build() {
            _checkSingleUse();

            return new CancelRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Endpoint "{@code tasks.cancel}".
     */
    public static final Endpoint<CancelRequest, CancelResponse, ErrorResponse> _ENDPOINT = new SimpleEndpoint<>(
        // Request method
        request -> "POST",
        // Request path
        request -> {
            final int _taskId = 1 << 0;

            int propsSet = 0;

            if (request.taskId() != null) propsSet |= _taskId;

            if (propsSet == 0) {
                return "/_tasks/_cancel";
            }
            if (propsSet == (_taskId)) {
                StringBuilder buf = new StringBuilder();
                buf.append("/_tasks/");
                SimpleEndpoint.pathEncode(request.taskId, buf);
                buf.append("/_cancel");
                return buf.toString();
            }

            throw SimpleEndpoint.noPathTemplateFound("path");
        },
        // Request parameters
        request -> {
            Map<String, String> params = new HashMap<>();
            if (ApiTypeHelper.isDefined(request.actions)) {
                params.put("actions", String.join(",", request.actions));
            }
            if (ApiTypeHelper.isDefined(request.nodes)) {
                params.put("nodes", String.join(",", request.nodes));
            }
            if (request.parentTaskId != null) {
                params.put("parent_task_id", request.parentTaskId);
            }
            if (request.waitForCompletion != null) {
                params.put("wait_for_completion", String.valueOf(request.waitForCompletion));
            }
            return params;
        },
        SimpleEndpoint.emptyMap(),
        false,
        CancelResponse._DESERIALIZER
    );

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.actions);
        result = 31 * result + Objects.hashCode(this.nodes);
        result = 31 * result + Objects.hashCode(this.parentTaskId);
        result = 31 * result + Objects.hashCode(this.taskId);
        result = 31 * result + Objects.hashCode(this.waitForCompletion);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        CancelRequest other = (CancelRequest) o;
        return Objects.equals(this.actions, other.actions)
            && Objects.equals(this.nodes, other.nodes)
            && Objects.equals(this.parentTaskId, other.parentTaskId)
            && Objects.equals(this.taskId, other.taskId)
            && Objects.equals(this.waitForCompletion, other.waitForCompletion);
    }
}