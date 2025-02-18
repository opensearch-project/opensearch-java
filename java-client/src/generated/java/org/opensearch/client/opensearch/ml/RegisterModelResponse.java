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
import javax.annotation.Nonnull;
import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.json.PlainJsonSerializable;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: ml.register_model.Response

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class RegisterModelResponse
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<RegisterModelResponse.Builder, RegisterModelResponse> {

    @Nonnull
    private final String status;

    @Nonnull
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
    @Nonnull
    public final String status() {
        return this.status;
    }

    /**
     * Required - API name: {@code task_id}
     */
    @Nonnull
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
     * Builder for {@link RegisterModelResponse}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, RegisterModelResponse> {
        private String status;
        private String taskId;

        public Builder() {}

        private Builder(RegisterModelResponse o) {
            this.status = o.status;
            this.taskId = o.taskId;
        }

        private Builder(Builder o) {
            this.status = o.status;
            this.taskId = o.taskId;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - API name: {@code status}
         */
        @Nonnull
        public final Builder status(String value) {
            this.status = value;
            return this;
        }

        /**
         * Required - API name: {@code task_id}
         */
        @Nonnull
        public final Builder taskId(String value) {
            this.taskId = value;
            return this;
        }

        /**
         * Builds a {@link RegisterModelResponse}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
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

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.status.hashCode();
        result = 31 * result + this.taskId.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        RegisterModelResponse other = (RegisterModelResponse) o;
        return this.status.equals(other.status) && this.taskId.equals(other.taskId);
    }
}
