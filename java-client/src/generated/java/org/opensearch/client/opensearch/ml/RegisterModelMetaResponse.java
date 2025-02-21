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

// typedef: ml.register_model_meta.Response

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class RegisterModelMetaResponse
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<RegisterModelMetaResponse.Builder, RegisterModelMetaResponse> {

    @Nonnull
    private final String modelId;

    @Nonnull
    private final String status;

    // ---------------------------------------------------------------------------------------------

    private RegisterModelMetaResponse(Builder builder) {
        this.modelId = ApiTypeHelper.requireNonNull(builder.modelId, this, "modelId");
        this.status = ApiTypeHelper.requireNonNull(builder.status, this, "status");
    }

    public static RegisterModelMetaResponse of(Function<RegisterModelMetaResponse.Builder, ObjectBuilder<RegisterModelMetaResponse>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code model_id}
     */
    @Nonnull
    public final String modelId() {
        return this.modelId;
    }

    /**
     * Required - API name: {@code status}
     */
    @Nonnull
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
        generator.writeKey("model_id");
        generator.write(this.modelId);

        generator.writeKey("status");
        generator.write(this.status);
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
     * Builder for {@link RegisterModelMetaResponse}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, RegisterModelMetaResponse> {
        private String modelId;
        private String status;

        public Builder() {}

        private Builder(RegisterModelMetaResponse o) {
            this.modelId = o.modelId;
            this.status = o.status;
        }

        private Builder(Builder o) {
            this.modelId = o.modelId;
            this.status = o.status;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - API name: {@code model_id}
         */
        @Nonnull
        public final Builder modelId(String value) {
            this.modelId = value;
            return this;
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
         * Builds a {@link RegisterModelMetaResponse}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public RegisterModelMetaResponse build() {
            _checkSingleUse();

            return new RegisterModelMetaResponse(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link RegisterModelMetaResponse}
     */
    public static final JsonpDeserializer<RegisterModelMetaResponse> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        RegisterModelMetaResponse::setupRegisterModelMetaResponseDeserializer
    );

    protected static void setupRegisterModelMetaResponseDeserializer(ObjectDeserializer<RegisterModelMetaResponse.Builder> op) {
        op.add(Builder::modelId, JsonpDeserializer.stringDeserializer(), "model_id");
        op.add(Builder::status, JsonpDeserializer.stringDeserializer(), "status");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.modelId.hashCode();
        result = 31 * result + this.status.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        RegisterModelMetaResponse other = (RegisterModelMetaResponse) o;
        return this.modelId.equals(other.modelId) && this.status.equals(other.status);
    }
}
