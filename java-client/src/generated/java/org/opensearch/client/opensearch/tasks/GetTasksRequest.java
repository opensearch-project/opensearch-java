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
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.opensearch.client.opensearch._types.ErrorResponse;
import org.opensearch.client.opensearch._types.RequestBase;
import org.opensearch.client.opensearch._types.Time;
import org.opensearch.client.transport.Endpoint;
import org.opensearch.client.transport.endpoints.SimpleEndpoint;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: tasks.get.Request

/**
 * Returns information about a task.
 */
@Generated("org.opensearch.client.codegen.CodeGenerator")
public final class GetTasksRequest extends RequestBase implements ToCopyableBuilder<GetTasksRequest.Builder, GetTasksRequest> {

    @Nonnull
    private final String taskId;

    @Nullable
    private final Time timeout;

    @Nullable
    private final Boolean waitForCompletion;

    // ---------------------------------------------------------------------------------------------

    private GetTasksRequest(Builder builder) {
        super(builder);
        this.taskId = ApiTypeHelper.requireNonNull(builder.taskId, this, "taskId");
        this.timeout = builder.timeout;
        this.waitForCompletion = builder.waitForCompletion;
    }

    public static GetTasksRequest of(Function<GetTasksRequest.Builder, ObjectBuilder<GetTasksRequest>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - The task ID.
     * <p>
     * API name: {@code task_id}
     * </p>
     */
    @Nonnull
    public final String taskId() {
        return this.taskId;
    }

    /**
     * The amount of time to wait for a response.
     * <p>
     * API name: {@code timeout}
     * </p>
     */
    @Nullable
    public final Time timeout() {
        return this.timeout;
    }

    /**
     * Waits for the matching task to complete. When <code>true</code>, the request is blocked until the task has completed.
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
     * Builder for {@link GetTasksRequest}.
     */
    public static class Builder extends RequestBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, GetTasksRequest> {
        private String taskId;
        @Nullable
        private Time timeout;
        @Nullable
        private Boolean waitForCompletion;

        public Builder() {}

        private Builder(GetTasksRequest o) {
            super(o);
            this.taskId = o.taskId;
            this.timeout = o.timeout;
            this.waitForCompletion = o.waitForCompletion;
        }

        private Builder(Builder o) {
            super(o);
            this.taskId = o.taskId;
            this.timeout = o.timeout;
            this.waitForCompletion = o.waitForCompletion;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        @Override
        @Nonnull
        protected Builder self() {
            return this;
        }

        /**
         * Required - The task ID.
         * <p>
         * API name: {@code task_id}
         * </p>
         */
        @Nonnull
        public final Builder taskId(String value) {
            this.taskId = value;
            return this;
        }

        /**
         * The amount of time to wait for a response.
         * <p>
         * API name: {@code timeout}
         * </p>
         */
        @Nonnull
        public final Builder timeout(@Nullable Time value) {
            this.timeout = value;
            return this;
        }

        /**
         * The amount of time to wait for a response.
         * <p>
         * API name: {@code timeout}
         * </p>
         */
        @Nonnull
        public final Builder timeout(Function<Time.Builder, ObjectBuilder<Time>> fn) {
            return timeout(fn.apply(new Time.Builder()).build());
        }

        /**
         * Waits for the matching task to complete. When <code>true</code>, the request is blocked until the task has completed.
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
         * Builds a {@link GetTasksRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public GetTasksRequest build() {
            _checkSingleUse();

            return new GetTasksRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    @Override
    protected void applyQueryParameters(@Nonnull Map<String, String> params) {
        super.applyQueryParameters(params);
        if (this.timeout != null) {
            params.put("timeout", this.timeout._toJsonString());
        }
        if (this.waitForCompletion != null) {
            params.put("wait_for_completion", String.valueOf(this.waitForCompletion));
        }
    }

    /**
     * Endpoint "{@code tasks.get}".
     */
    public static final Endpoint<GetTasksRequest, GetTasksResponse, ErrorResponse> _ENDPOINT = new SimpleEndpoint<>(
        // Request method
        request -> "GET",
        // Request path
        request -> {
            StringBuilder buf = new StringBuilder();
            buf.append("/_tasks/");
            SimpleEndpoint.pathEncode(request.taskId, buf);
            return buf.toString();
        },
        // Request parameters
        request -> {
            Map<String, String> params = new HashMap<>();
            request.applyQueryParameters(params);
            return params;
        },
        SimpleEndpoint.emptyMap(),
        false,
        GetTasksResponse._DESERIALIZER
    );

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.taskId.hashCode();
        result = 31 * result + Objects.hashCode(this.timeout);
        result = 31 * result + Objects.hashCode(this.waitForCompletion);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        GetTasksRequest other = (GetTasksRequest) o;
        return this.taskId.equals(other.taskId)
            && Objects.equals(this.timeout, other.timeout)
            && Objects.equals(this.waitForCompletion, other.waitForCompletion);
    }
}
