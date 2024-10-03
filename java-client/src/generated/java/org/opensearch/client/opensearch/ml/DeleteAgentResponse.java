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

// typedef: ml.delete_agent.Response

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class DeleteAgentResponse extends WriteResponseBase {

    // ---------------------------------------------------------------------------------------------

    private DeleteAgentResponse(Builder builder) {
        super(builder);
    }

    public static DeleteAgentResponse of(Function<DeleteAgentResponse.Builder, ObjectBuilder<DeleteAgentResponse>> fn) {
        return fn.apply(new Builder()).build();
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Builder for {@link DeleteAgentResponse}.
     */
    public static class Builder extends WriteResponseBase.AbstractBuilder<Builder> implements ObjectBuilder<DeleteAgentResponse> {

        @Override
        protected Builder self() {
            return this;
        }

        /**
         * Builds a {@link DeleteAgentResponse}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        public DeleteAgentResponse build() {
            _checkSingleUse();

            return new DeleteAgentResponse(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link DeleteAgentResponse}
     */
    public static final JsonpDeserializer<DeleteAgentResponse> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        DeleteAgentResponse::setupDeleteAgentResponseDeserializer
    );

    protected static void setupDeleteAgentResponseDeserializer(ObjectDeserializer<DeleteAgentResponse.Builder> op) {
        setupWriteResponseBaseDeserializer(op);
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
