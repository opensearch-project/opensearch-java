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

package org.opensearch.client.opensearch.core;

import java.util.HashMap;
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
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: _global.update_by_query_rethrottle.Request

/**
 * Changes the number of requests per second for a particular Update By Query operation.
 */
@Generated("org.opensearch.client.codegen.CodeGenerator")
public final class UpdateByQueryRethrottleRequest extends RequestBase
    implements
        ToCopyableBuilder<UpdateByQueryRethrottleRequest.Builder, UpdateByQueryRethrottleRequest> {

    @Nullable
    private final Float requestsPerSecond;

    @Nonnull
    private final String taskId;

    // ---------------------------------------------------------------------------------------------

    private UpdateByQueryRethrottleRequest(Builder builder) {
        super(builder);
        this.requestsPerSecond = builder.requestsPerSecond;
        this.taskId = ApiTypeHelper.requireNonNull(builder.taskId, this, "taskId");
    }

    public static UpdateByQueryRethrottleRequest of(
        Function<UpdateByQueryRethrottleRequest.Builder, ObjectBuilder<UpdateByQueryRethrottleRequest>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * The throttle for this request in sub-requests per second.
     * <p>
     * API name: {@code requests_per_second}
     * </p>
     */
    @Nullable
    public final Float requestsPerSecond() {
        return this.requestsPerSecond;
    }

    /**
     * Required - The ID for the task.
     * <p>
     * API name: {@code task_id}
     * </p>
     */
    @Nonnull
    public final String taskId() {
        return this.taskId;
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
     * Builder for {@link UpdateByQueryRethrottleRequest}.
     */
    public static class Builder extends RequestBase.AbstractBuilder<Builder>
        implements
            CopyableBuilder<Builder, UpdateByQueryRethrottleRequest> {
        @Nullable
        private Float requestsPerSecond;
        private String taskId;

        public Builder() {}

        private Builder(UpdateByQueryRethrottleRequest o) {
            super(o);
            this.requestsPerSecond = o.requestsPerSecond;
            this.taskId = o.taskId;
        }

        private Builder(Builder o) {
            super(o);
            this.requestsPerSecond = o.requestsPerSecond;
            this.taskId = o.taskId;
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
         * The throttle for this request in sub-requests per second.
         * <p>
         * API name: {@code requests_per_second}
         * </p>
         */
        @Nonnull
        public final Builder requestsPerSecond(@Nullable Float value) {
            this.requestsPerSecond = value;
            return this;
        }

        /**
         * Required - The ID for the task.
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
         * Builds a {@link UpdateByQueryRethrottleRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public UpdateByQueryRethrottleRequest build() {
            _checkSingleUse();

            return new UpdateByQueryRethrottleRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    @Override
    protected void applyQueryParameters(@Nonnull Map<String, String> params) {
        super.applyQueryParameters(params);
        if (this.requestsPerSecond != null) {
            params.put("requests_per_second", String.valueOf(this.requestsPerSecond));
        }
    }

    /**
     * Endpoint "{@code update_by_query_rethrottle}".
     */
    public static final Endpoint<UpdateByQueryRethrottleRequest, UpdateByQueryRethrottleResponse, ErrorResponse> _ENDPOINT =
        new SimpleEndpoint<>(
            // Request method
            request -> "POST",
            // Request path
            request -> {
                StringBuilder buf = new StringBuilder();
                buf.append("/_update_by_query/");
                SimpleEndpoint.pathEncode(request.taskId, buf);
                buf.append("/_rethrottle");
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
            UpdateByQueryRethrottleResponse._DESERIALIZER
        );

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.requestsPerSecond);
        result = 31 * result + this.taskId.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        UpdateByQueryRethrottleRequest other = (UpdateByQueryRethrottleRequest) o;
        return Objects.equals(this.requestsPerSecond, other.requestsPerSecond) && this.taskId.equals(other.taskId);
    }
}
