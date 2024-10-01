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

// typedef: ml.undeploy_model.Request

/**
 * Undeploys a model.
 */
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class UndeployModelRequest extends RequestBase {

    @Nonnull
    private final String modelId;

    // ---------------------------------------------------------------------------------------------

    private UndeployModelRequest(Builder builder) {
        this.modelId = ApiTypeHelper.requireNonNull(builder.modelId, this, "modelId");
    }

    public static UndeployModelRequest of(Function<UndeployModelRequest.Builder, ObjectBuilder<UndeployModelRequest>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code model_id}
     */
    @Nonnull
    public final String modelId() {
        return this.modelId;
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Builder for {@link UndeployModelRequest}.
     */
    public static class Builder extends ObjectBuilderBase implements ObjectBuilder<UndeployModelRequest> {
        private String modelId;

        /**
         * Required - API name: {@code model_id}
         */
        public final Builder modelId(String value) {
            this.modelId = value;
            return this;
        }

        /**
         * Builds a {@link UndeployModelRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        public UndeployModelRequest build() {
            _checkSingleUse();

            return new UndeployModelRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Endpoint "{@code ml.undeploy_model}".
     */
    public static final Endpoint<UndeployModelRequest, UndeployModelResponse, ErrorResponse> _ENDPOINT = new SimpleEndpoint<>(
        // Request method
        request -> "POST",
        // Request path
        request -> {
            StringBuilder buf = new StringBuilder();
            buf.append("/_plugins/_ml/models/");
            SimpleEndpoint.pathEncode(request.modelId, buf);
            buf.append("/_undeploy");
            return buf.toString();
        },
        // Request parameters
        SimpleEndpoint.emptyMap(),
        SimpleEndpoint.emptyMap(),
        false,
        UndeployModelResponse._DESERIALIZER
    );

    public int hashCode() {
        int result = 17;
        result = 31 * result + this.modelId.hashCode();
        return result;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        UndeployModelRequest other = (UndeployModelRequest) o;
        return this.modelId.equals(other.modelId);
    }
}
