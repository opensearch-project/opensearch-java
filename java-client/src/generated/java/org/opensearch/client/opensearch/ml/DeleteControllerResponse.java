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

// typedef: ml.delete_controller.Response

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class DeleteControllerResponse extends WriteResponseBase
    implements
        ToCopyableBuilder<DeleteControllerResponse.Builder, DeleteControllerResponse> {

    // ---------------------------------------------------------------------------------------------

    private DeleteControllerResponse(Builder builder) {
        super(builder);
    }

    public static DeleteControllerResponse of(Function<DeleteControllerResponse.Builder, ObjectBuilder<DeleteControllerResponse>> fn) {
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
     * Builder for {@link DeleteControllerResponse}.
     */
    public static class Builder extends WriteResponseBase.AbstractBuilder<Builder>
        implements
            CopyableBuilder<Builder, DeleteControllerResponse> {

        public Builder() {}

        private Builder(DeleteControllerResponse o) {
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
         * Builds a {@link DeleteControllerResponse}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public DeleteControllerResponse build() {
            _checkSingleUse();

            return new DeleteControllerResponse(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link DeleteControllerResponse}
     */
    public static final JsonpDeserializer<DeleteControllerResponse> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        DeleteControllerResponse::setupDeleteControllerResponseDeserializer
    );

    protected static void setupDeleteControllerResponseDeserializer(ObjectDeserializer<DeleteControllerResponse.Builder> op) {
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
