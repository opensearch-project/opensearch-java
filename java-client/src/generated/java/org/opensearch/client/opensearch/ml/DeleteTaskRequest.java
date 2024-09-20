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
import org.opensearch.client.opensearch._types.ErrorResponse;
import org.opensearch.client.opensearch._types.RequestBase;
import org.opensearch.client.transport.Endpoint;
import org.opensearch.client.transport.endpoints.SimpleEndpoint;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;

// typedef: ml.delete_task.Request

/**
 * Deletes a task.
 */
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class DeleteTaskRequest extends RequestBase {

    private final String taskId;

    // ---------------------------------------------------------------------------------------------

    private DeleteTaskRequest(Builder builder) {
        this.taskId = ApiTypeHelper.requireNonNull(builder.taskId, this, "taskId");
    }

    public static DeleteTaskRequest of(Function<DeleteTaskRequest.Builder, ObjectBuilder<DeleteTaskRequest>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code task_id}
     */
    public final String taskId() {
        return this.taskId;
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Builder for {@link DeleteTaskRequest}.
     */
    public static class Builder extends ObjectBuilderBase implements ObjectBuilder<DeleteTaskRequest> {
        private String taskId;

        /**
         * Required - API name: {@code task_id}
         */
        public final Builder taskId(String value) {
            this.taskId = value;
            return this;
        }

        /**
         * Builds a {@link DeleteTaskRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        public DeleteTaskRequest build() {
            _checkSingleUse();

            return new DeleteTaskRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Endpoint "{@code ml.delete_task}".
     */
    public static final Endpoint<DeleteTaskRequest, DeleteTaskResponse, ErrorResponse> _ENDPOINT = new SimpleEndpoint<>(
        // Request method
        request -> "DELETE",
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
        DeleteTaskResponse._DESERIALIZER
    );

    public int hashCode() {
        int result = 17;
        result = 31 * result + this.taskId.hashCode();
        return result;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (this.getClass() != o.getClass()) return false;
        return true;
    }
}
