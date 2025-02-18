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
import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.opensearch._types.WriteResponseBase;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: ml.delete_model_group.Response

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class DeleteModelGroupResponse extends WriteResponseBase
    implements
        ToCopyableBuilder<DeleteModelGroupResponse.Builder, DeleteModelGroupResponse> {

    // ---------------------------------------------------------------------------------------------

    private DeleteModelGroupResponse(Builder builder) {
        super(builder);
    }

    public static DeleteModelGroupResponse of(Function<DeleteModelGroupResponse.Builder, ObjectBuilder<DeleteModelGroupResponse>> fn) {
        return fn.apply(new Builder()).build();
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
     * Builder for {@link DeleteModelGroupResponse}.
     */
    public static class Builder extends WriteResponseBase.AbstractBuilder<Builder>
        implements
            CopyableBuilder<Builder, DeleteModelGroupResponse> {

        public Builder() {}

        private Builder(DeleteModelGroupResponse o) {
            super(o);
        }

        private Builder(Builder o) {
            super(o);
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
         * Builds a {@link DeleteModelGroupResponse}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public DeleteModelGroupResponse build() {
            _checkSingleUse();

            return new DeleteModelGroupResponse(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link DeleteModelGroupResponse}
     */
    public static final JsonpDeserializer<DeleteModelGroupResponse> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        DeleteModelGroupResponse::setupDeleteModelGroupResponseDeserializer
    );

    protected static void setupDeleteModelGroupResponseDeserializer(ObjectDeserializer<DeleteModelGroupResponse.Builder> op) {
        setupWriteResponseBaseDeserializer(op);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        return true;
    }
}
