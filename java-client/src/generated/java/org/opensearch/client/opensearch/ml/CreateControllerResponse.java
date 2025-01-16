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
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.json.PlainJsonSerializable;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: ml.create_controller.Response

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class CreateControllerResponse
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<CreateControllerResponse.Builder, CreateControllerResponse> {

    @Nullable
    private final String modelId;

    @Nullable
    private final Status status;

    // ---------------------------------------------------------------------------------------------

    private CreateControllerResponse(Builder builder) {
        this.modelId = builder.modelId;
        this.status = builder.status;
    }

    public static CreateControllerResponse of(Function<CreateControllerResponse.Builder, ObjectBuilder<CreateControllerResponse>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code model_id}
     */
    @Nullable
    public final String modelId() {
        return this.modelId;
    }

    /**
     * API name: {@code status}
     */
    @Nullable
    public final Status status() {
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
        if (this.modelId != null) {
            generator.writeKey("model_id");
            generator.write(this.modelId);
        }

        if (this.status != null) {
            generator.writeKey("status");
            this.status.serialize(generator, mapper);
        }
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
     * Builder for {@link CreateControllerResponse}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, CreateControllerResponse> {
        @Nullable
        private String modelId;
        @Nullable
        private Status status;

        public Builder() {}

        private Builder(CreateControllerResponse o) {
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
         * API name: {@code model_id}
         */
        @Nonnull
        public final Builder modelId(@Nullable String value) {
            this.modelId = value;
            return this;
        }

        /**
         * API name: {@code status}
         */
        @Nonnull
        public final Builder status(@Nullable Status value) {
            this.status = value;
            return this;
        }

        /**
         * Builds a {@link CreateControllerResponse}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public CreateControllerResponse build() {
            _checkSingleUse();

            return new CreateControllerResponse(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link CreateControllerResponse}
     */
    public static final JsonpDeserializer<CreateControllerResponse> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        CreateControllerResponse::setupCreateControllerResponseDeserializer
    );

    protected static void setupCreateControllerResponseDeserializer(ObjectDeserializer<CreateControllerResponse.Builder> op) {
        op.add(Builder::modelId, JsonpDeserializer.stringDeserializer(), "model_id");
        op.add(Builder::status, Status._DESERIALIZER, "status");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.modelId);
        result = 31 * result + Objects.hashCode(this.status);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        CreateControllerResponse other = (CreateControllerResponse) o;
        return Objects.equals(this.modelId, other.modelId) && Objects.equals(this.status, other.status);
    }
}
