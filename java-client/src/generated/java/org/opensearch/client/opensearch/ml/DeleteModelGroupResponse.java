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
import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.opensearch._types.WriteResponseBase;
import org.opensearch.client.util.ObjectBuilder;

// typedef: ml.delete_model_group.Response

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class DeleteModelGroupResponse extends WriteResponseBase {

    // ---------------------------------------------------------------------------------------------

    private DeleteModelGroupResponse(Builder builder) {
        super(builder);
    }

    public static DeleteModelGroupResponse of(Function<DeleteModelGroupResponse.Builder, ObjectBuilder<DeleteModelGroupResponse>> fn) {
        return fn.apply(new Builder()).build();
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Builder for {@link DeleteModelGroupResponse}.
     */
    public static class Builder extends WriteResponseBase.AbstractBuilder<Builder> implements ObjectBuilder<DeleteModelGroupResponse> {
        @Override
        protected Builder self() {
            return this;
        }

        /**
         * Builds a {@link DeleteModelGroupResponse}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
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
        WriteResponseBase.setupWriteResponseBaseDeserializer(op);
    }

    public int hashCode() {
        int result = super.hashCode();
        return result;
    }

    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        return true;
    }
}
