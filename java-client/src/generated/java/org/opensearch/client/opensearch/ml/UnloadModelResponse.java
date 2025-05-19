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
import org.opensearch.client.transport.endpoints.DictionaryResponse;
import org.opensearch.client.util.ObjectBuilder;

// typedef: ml.unload_model.Response

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class UnloadModelResponse extends DictionaryResponse<String, UnloadModelNode> {
    // ---------------------------------------------------------------------------------------------

    private UnloadModelResponse(Builder builder) {
        super(builder);
    }

    public static UnloadModelResponse of(Function<UnloadModelResponse.Builder, ObjectBuilder<UnloadModelResponse>> fn) {
        return fn.apply(new Builder()).build();
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Builder for {@link UnloadModelResponse}.
     */
    public static class Builder extends DictionaryResponse.AbstractBuilder<String, UnloadModelNode, Builder>
        implements
            ObjectBuilder<UnloadModelResponse> {
        @Override
        @Nonnull
        protected Builder self() {
            return this;
        }

        /**
         * Builds a {@link UnloadModelResponse}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        public UnloadModelResponse build() {
            _checkSingleUse();
            super.tKeySerializer(null);
            super.tValueSerializer(null);

            return new UnloadModelResponse(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link UnloadModelResponse}
     */
    public static final JsonpDeserializer<UnloadModelResponse> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        UnloadModelResponse::setupUnloadModelResponseDeserializer
    );

    protected static void setupUnloadModelResponseDeserializer(ObjectDeserializer<UnloadModelResponse.Builder> op) {
        setupDictionaryResponseDeserializer(op, JsonpDeserializer.stringDeserializer(), UnloadModelNode._DESERIALIZER);
    }
}
