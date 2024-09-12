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

// typedef: ml.delete_model.Response

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class DeleteModelResponse extends WriteResponseBase {

    // ---------------------------------------------------------------------------------------------

    private DeleteModelResponse(Builder builder) {
        super(builder);
    }

    public static DeleteModelResponse of(Function<DeleteModelResponse.Builder, ObjectBuilder<DeleteModelResponse>> fn) {
        return fn.apply(new Builder()).build();
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Builder for {@link DeleteModelResponse}.
     */
    public static class Builder extends WriteResponseBase.AbstractBuilder<Builder> implements ObjectBuilder<DeleteModelResponse> {
        @Override
        protected Builder self() {
            return this;
        }

        /**
         * Builds a {@link DeleteModelResponse}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        public DeleteModelResponse build() {
            _checkSingleUse();

            return new DeleteModelResponse(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link DeleteModelResponse}
     */
    public static final JsonpDeserializer<DeleteModelResponse> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        DeleteModelResponse::setupDeleteModelResponseDeserializer
    );

    protected static void setupDeleteModelResponseDeserializer(ObjectDeserializer<DeleteModelResponse.Builder> op) {
        WriteResponseBase.setupWriteResponseBaseDeserializer(op);
    }
}
