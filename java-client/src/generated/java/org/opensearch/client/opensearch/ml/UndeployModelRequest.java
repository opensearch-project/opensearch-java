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
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: ml.undeploy_model.Request

/**
 * Undeploys a model.
 */
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class UndeployModelRequest extends RequestBase implements ToCopyableBuilder<UndeployModelRequest.Builder, UndeployModelRequest> {

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
     * Builder for {@link UndeployModelRequest}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, UndeployModelRequest> {
        private String modelId;

        public Builder() {}

        private Builder(UndeployModelRequest o) {
            this.modelId = o.modelId;
        }

        private Builder(Builder o) {
            this.modelId = o.modelId;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - API name: {@code model_id}
         */
        @Nonnull
        public final Builder modelId(String value) {
            this.modelId = value;
            return this;
        }

        /**
         * Builds a {@link UndeployModelRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
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

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.modelId.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        UndeployModelRequest other = (UndeployModelRequest) o;
        return this.modelId.equals(other.modelId);
    }
}
