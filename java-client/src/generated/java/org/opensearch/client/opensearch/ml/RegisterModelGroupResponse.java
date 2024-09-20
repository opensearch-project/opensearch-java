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
import java.util.function.Function;
import javax.annotation.Generated;
import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.json.PlainJsonSerializable;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;

// typedef: ml.register_model_group.Response

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class RegisterModelGroupResponse implements PlainJsonSerializable {

    private final String modelGroupId;

    private final String status;

    // ---------------------------------------------------------------------------------------------

    private RegisterModelGroupResponse(Builder builder) {
        this.modelGroupId = ApiTypeHelper.requireNonNull(builder.modelGroupId, this, "modelGroupId");
        this.status = ApiTypeHelper.requireNonNull(builder.status, this, "status");
    }

    public static RegisterModelGroupResponse of(
        Function<RegisterModelGroupResponse.Builder, ObjectBuilder<RegisterModelGroupResponse>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - The model group ID.
     * <p>
     * API name: {@code model_group_id}
     * </p>
     */
    public final String modelGroupId() {
        return this.modelGroupId;
    }

    /**
     * Required - The status.
     * <p>
     * API name: {@code status}
     * </p>
     */
    public final String status() {
        return this.status;
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
        generator.writeKey("model_group_id");
        generator.write(this.modelGroupId);

        generator.writeKey("status");
        generator.write(this.status);
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Builder for {@link RegisterModelGroupResponse}.
     */
    public static class Builder extends ObjectBuilderBase implements ObjectBuilder<RegisterModelGroupResponse> {
        private String modelGroupId;
        private String status;

        /**
         * Required - The model group ID.
         * <p>
         * API name: {@code model_group_id}
         * </p>
         */
        public final Builder modelGroupId(String value) {
            this.modelGroupId = value;
            return this;
        }

        /**
         * Required - The status.
         * <p>
         * API name: {@code status}
         * </p>
         */
        public final Builder status(String value) {
            this.status = value;
            return this;
        }

        /**
         * Builds a {@link RegisterModelGroupResponse}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        public RegisterModelGroupResponse build() {
            _checkSingleUse();

            return new RegisterModelGroupResponse(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link RegisterModelGroupResponse}
     */
    public static final JsonpDeserializer<RegisterModelGroupResponse> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        RegisterModelGroupResponse::setupRegisterModelGroupResponseDeserializer
    );

    protected static void setupRegisterModelGroupResponseDeserializer(ObjectDeserializer<RegisterModelGroupResponse.Builder> op) {
        op.add(Builder::modelGroupId, JsonpDeserializer.stringDeserializer(), "model_group_id");
        op.add(Builder::status, JsonpDeserializer.stringDeserializer(), "status");
    }

    public int hashCode() {
        int result = 17;
        result = 31 * result + this.modelGroupId.hashCode();
        result = 31 * result + this.status.hashCode();
        return result;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (this.getClass() != o.getClass()) return false;
        RegisterModelGroupResponse other = (RegisterModelGroupResponse) o;
        return java.util.Objects.equals(this.modelGroupId, other.modelGroupId) && java.util.Objects.equals(this.status, other.status);
    }
}
