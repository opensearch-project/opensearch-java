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

// typedef: ml.undeploy_model.Response

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class UndeployModelResponse extends DictionaryResponse<String, UndeployModelNode> {
    // ---------------------------------------------------------------------------------------------

    private UndeployModelResponse(Builder builder) {
        super(builder);
    }

    public static UndeployModelResponse of(Function<UndeployModelResponse.Builder, ObjectBuilder<UndeployModelResponse>> fn) {
        return fn.apply(new Builder()).build();
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Builder for {@link UndeployModelResponse}.
     */
    public static class Builder extends DictionaryResponse.AbstractBuilder<String, UndeployModelNode, Builder>
        implements
            ObjectBuilder<UndeployModelResponse> {
        @Override
        @Nonnull
        protected Builder self() {
            return this;
        }

        /**
         * Builds a {@link UndeployModelResponse}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        public UndeployModelResponse build() {
            _checkSingleUse();
            super.tKeySerializer(null);
            super.tValueSerializer(null);

            return new UndeployModelResponse(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link UndeployModelResponse}
     */
    public static final JsonpDeserializer<UndeployModelResponse> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        UndeployModelResponse::setupUndeployModelResponseDeserializer
    );

    protected static void setupUndeployModelResponseDeserializer(ObjectDeserializer<UndeployModelResponse.Builder> op) {
        setupDictionaryResponseDeserializer(op, JsonpDeserializer.stringDeserializer(), UndeployModelNode._DESERIALIZER);
    }
}
