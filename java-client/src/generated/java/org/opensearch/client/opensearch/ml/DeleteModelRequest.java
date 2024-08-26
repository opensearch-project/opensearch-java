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

// typedef: ml.delete_model.Request

/**
 * Deletes a model.
 */
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class DeleteModelRequest extends RequestBase {

    private final String modelId;

    // ---------------------------------------------------------------------------------------------

    private DeleteModelRequest(Builder builder) {
        this.modelId = ApiTypeHelper.requireNonNull(builder.modelId, this, "modelId");
    }

    public static DeleteModelRequest of(Function<DeleteModelRequest.Builder, ObjectBuilder<DeleteModelRequest>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code model_id}
     */
    public final String modelId() {
        return this.modelId;
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Builder for {@link DeleteModelRequest}.
     */
    public static class Builder extends ObjectBuilderBase implements ObjectBuilder<DeleteModelRequest> {
        private String modelId;

        /**
         * Required - API name: {@code model_id}
         */
        public final Builder modelId(String value) {
            this.modelId = value;
            return this;
        }

        /**
         * Builds a {@link DeleteModelRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        public DeleteModelRequest build() {
            _checkSingleUse();

            return new DeleteModelRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Endpoint "{@code ml.delete_model}".
     */
    public static final Endpoint<DeleteModelRequest, DeleteModelResponse, ErrorResponse> _ENDPOINT = new SimpleEndpoint<>(
        // Request method
        request -> "DELETE",
        // Request path
        request -> {
            StringBuilder buf = new StringBuilder();
            buf.append("/_plugins/_ml/models/");
            SimpleEndpoint.pathEncode(request.modelId, buf);
            return buf.toString();
        },
        // Request parameters
        SimpleEndpoint.emptyMap(),
        SimpleEndpoint.emptyMap(),
        false,
        DeleteModelResponse._DESERIALIZER
    );
}
