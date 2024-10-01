/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

//----------------------------------------------------
// THIS CODE IS GENERATED. MANUAL EDITS WILL BE LOST.
//----------------------------------------------------

package org.opensearch.client.opensearch.ml;

import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import org.opensearch.client.opensearch._types.ErrorResponse;
import org.opensearch.client.opensearch._types.RequestBase;
import org.opensearch.client.transport.Endpoint;
import org.opensearch.client.transport.endpoints.SimpleEndpoint;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;

// typedef: ml.get_task.Request

/**
 * Retrieves a task.
 */
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class GetTaskRequest extends RequestBase {

    @Nonnull
    private final String taskId;

    // ---------------------------------------------------------------------------------------------

    private GetTaskRequest(Builder builder) {
        this.taskId = ApiTypeHelper.requireNonNull(builder.taskId, this, "taskId");
    }

    public static GetTaskRequest of(Function<GetTaskRequest.Builder, ObjectBuilder<GetTaskRequest>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code task_id}
     */
    @Nonnull
    public final String taskId() {
        return this.taskId;
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Builder for {@link GetTaskRequest}.
     */
    public static class Builder extends ObjectBuilderBase implements ObjectBuilder<GetTaskRequest> {
        private String taskId;

        /**
         * Required - API name: {@code task_id}
         */
        public final Builder taskId(String value) {
            this.taskId = value;
            return this;
        }

        /**
         * Builds a {@link GetTaskRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        public GetTaskRequest build() {
            _checkSingleUse();

            return new GetTaskRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Endpoint "{@code ml.get_task}".
     */
    public static final Endpoint<GetTaskRequest, GetTaskResponse, ErrorResponse> _ENDPOINT = new SimpleEndpoint<>(
        // Request method
        request -> "GET",
        // Request path
        request -> {
            StringBuilder buf = new StringBuilder();
            buf.append("/_plugins/_ml/tasks/");
            SimpleEndpoint.pathEncode(request.taskId, buf);
            return buf.toString();
        },
        // Request parameters
        SimpleEndpoint.emptyMap(),
        SimpleEndpoint.emptyMap(),
        false,
        GetTaskResponse._DESERIALIZER
    );

    public int hashCode() {
        int result = 17;
        result = 31 * result + this.taskId.hashCode();
        return result;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        GetTaskRequest other = (GetTaskRequest) o;
        return this.taskId.equals(other.taskId);
    }
}
