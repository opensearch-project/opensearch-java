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

import jakarta.json.stream.JsonGenerator;
import java.util.Objects;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nullable;
import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.json.PlainJsonSerializable;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;

// typedef: ml.register_agents.Response

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class RegisterAgentsResponse implements PlainJsonSerializable {

    @Nullable
    private final String agentId;

    // ---------------------------------------------------------------------------------------------

    private RegisterAgentsResponse(Builder builder) {
        this.agentId = builder.agentId;
    }

    public static RegisterAgentsResponse of(Function<RegisterAgentsResponse.Builder, ObjectBuilder<RegisterAgentsResponse>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code agent_id}
     */
    @Nullable
    public final String agentId() {
        return this.agentId;
    }

    /**
     * Serialize this object to JSON.
     */
    @Override
    public void serialize(JsonGenerator generator, JsonpMapper mapper) {
        generator.writeStartObject();
        serializeInternal(generator, mapper);
        generator.writeEnd();
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        if (this.agentId != null) {
            generator.writeKey("agent_id");
            generator.write(this.agentId);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Builder for {@link RegisterAgentsResponse}.
     */
    public static class Builder extends ObjectBuilderBase implements ObjectBuilder<RegisterAgentsResponse> {
        @Nullable
        private String agentId;

        /**
         * API name: {@code agent_id}
         */
        public final Builder agentId(@Nullable String value) {
            this.agentId = value;
            return this;
        }

        /**
         * Builds a {@link RegisterAgentsResponse}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        public RegisterAgentsResponse build() {
            _checkSingleUse();

            return new RegisterAgentsResponse(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link RegisterAgentsResponse}
     */
    public static final JsonpDeserializer<RegisterAgentsResponse> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        RegisterAgentsResponse::setupRegisterAgentsResponseDeserializer
    );

    protected static void setupRegisterAgentsResponseDeserializer(ObjectDeserializer<RegisterAgentsResponse.Builder> op) {
        op.add(Builder::agentId, JsonpDeserializer.stringDeserializer(), "agent_id");
    }

    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.agentId);
        return result;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (this.getClass() != o.getClass()) return false;
        RegisterAgentsResponse other = (RegisterAgentsResponse) o;
        return Objects.equals(this.agentId, other.agentId);
    }
}
