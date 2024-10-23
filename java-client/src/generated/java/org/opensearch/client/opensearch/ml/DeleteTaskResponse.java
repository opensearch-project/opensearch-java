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

// typedef: ml.delete_task.Response

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class DeleteTaskResponse extends WriteResponseBase {

    // ---------------------------------------------------------------------------------------------

    private DeleteTaskResponse(Builder builder) {
        super(builder);
    }

    public static DeleteTaskResponse of(Function<DeleteTaskResponse.Builder, ObjectBuilder<DeleteTaskResponse>> fn) {
        return fn.apply(new Builder()).build();
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Builder for {@link DeleteTaskResponse}.
     */
    public static class Builder extends WriteResponseBase.AbstractBuilder<Builder> implements ObjectBuilder<DeleteTaskResponse> {

        @Override
        protected Builder self() {
            return this;
        }

        /**
         * Builds a {@link DeleteTaskResponse}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        public DeleteTaskResponse build() {
            _checkSingleUse();

            return new DeleteTaskResponse(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link DeleteTaskResponse}
     */
    public static final JsonpDeserializer<DeleteTaskResponse> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        DeleteTaskResponse::setupDeleteTaskResponseDeserializer
    );

    protected static void setupDeleteTaskResponseDeserializer(ObjectDeserializer<DeleteTaskResponse.Builder> op) {
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
