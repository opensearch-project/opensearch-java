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
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import org.opensearch.client.opensearch._types.ErrorResponse;
import org.opensearch.client.opensearch._types.RequestBase;
import org.opensearch.client.transport.Endpoint;
import org.opensearch.client.transport.endpoints.SimpleEndpoint;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: tasks.delete.Request

/**
 * Deletes a stored completed task result.
 */
@Generated("org.opensearch.client.codegen.CodeGenerator")
public final class DeleteTasksRequest extends RequestBase implements ToCopyableBuilder<DeleteTasksRequest.Builder, DeleteTasksRequest> {

    @Nonnull
    private final String taskId;

    // ---------------------------------------------------------------------------------------------

    private DeleteTasksRequest(Builder builder) {
        super(builder);
        this.taskId = ApiTypeHelper.requireNonNull(builder.taskId, this, "taskId");
    }

    public static DeleteTasksRequest of(Function<DeleteTasksRequest.Builder, ObjectBuilder<DeleteTasksRequest>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - The ID of the stored completed task result to delete (<code>node_id:task_number</code>).
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
     * Builder for {@link DeleteTasksRequest}.
     */
    public static class Builder extends RequestBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, DeleteTasksRequest> {
        private String taskId;

        public Builder() {}

        private Builder(DeleteTasksRequest o) {
            super(o);
            this.taskId = o.taskId;
        }

        private Builder(Builder o) {
            super(o);
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
         * Required - The ID of the stored completed task result to delete (<code>node_id:task_number</code>).
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
         * Builds a {@link DeleteTasksRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public DeleteTasksRequest build() {
            _checkSingleUse();

            return new DeleteTasksRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Endpoint "{@code tasks.delete}".
     */
    public static final Endpoint<DeleteTasksRequest, DeleteTasksResponse, ErrorResponse> _ENDPOINT = new SimpleEndpoint<>(
        // Request method
        request -> "DELETE",
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
        DeleteTasksResponse._DESERIALIZER
    );

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.taskId.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        DeleteTasksRequest other = (DeleteTasksRequest) o;
        return this.taskId.equals(other.taskId);
    }
}
