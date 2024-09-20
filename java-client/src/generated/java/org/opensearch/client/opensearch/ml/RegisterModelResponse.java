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

// typedef: ml.register_model.Response

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class RegisterModelResponse implements PlainJsonSerializable {

    private final String status;

    private final String taskId;

    // ---------------------------------------------------------------------------------------------

    private RegisterModelResponse(Builder builder) {
        this.status = ApiTypeHelper.requireNonNull(builder.status, this, "status");
        this.taskId = ApiTypeHelper.requireNonNull(builder.taskId, this, "taskId");
    }

    public static RegisterModelResponse of(Function<RegisterModelResponse.Builder, ObjectBuilder<RegisterModelResponse>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code status}
     */
    public final String status() {
        return this.status;
    }

    /**
     * Required - API name: {@code task_id}
     */
    public final String taskId() {
        return this.taskId;
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
        generator.writeKey("status");
        generator.write(this.status);

        generator.writeKey("task_id");
        generator.write(this.taskId);
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Builder for {@link RegisterModelResponse}.
     */
    public static class Builder extends ObjectBuilderBase implements ObjectBuilder<RegisterModelResponse> {
        private String status;
        private String taskId;

        /**
         * Required - API name: {@code status}
         */
        public final Builder status(String value) {
            this.status = value;
            return this;
        }

        /**
         * Required - API name: {@code task_id}
         */
        public final Builder taskId(String value) {
            this.taskId = value;
            return this;
        }

        /**
         * Builds a {@link RegisterModelResponse}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        public RegisterModelResponse build() {
            _checkSingleUse();

            return new RegisterModelResponse(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link RegisterModelResponse}
     */
    public static final JsonpDeserializer<RegisterModelResponse> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        RegisterModelResponse::setupRegisterModelResponseDeserializer
    );

    protected static void setupRegisterModelResponseDeserializer(ObjectDeserializer<RegisterModelResponse.Builder> op) {
        op.add(Builder::status, JsonpDeserializer.stringDeserializer(), "status");
        op.add(Builder::taskId, JsonpDeserializer.stringDeserializer(), "task_id");
    }

    public int hashCode() {
        int result = 17;
        result = 31 * result + this.status.hashCode();
        result = 31 * result + this.taskId.hashCode();
        return result;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (this.getClass() != o.getClass()) return false;
        RegisterModelResponse other = (RegisterModelResponse) o;
        return java.util.Objects.equals(this.status, other.status) && java.util.Objects.equals(this.taskId, other.taskId);
    }
}
