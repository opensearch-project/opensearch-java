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

// typedef: ml.create_memory_container.Response

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class CreateMemoryContainerResponse
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<CreateMemoryContainerResponse.Builder, CreateMemoryContainerResponse> {

    @Nullable
    private final String memoryContainerId;

    @Nullable
    private final String status;

    // ---------------------------------------------------------------------------------------------

    private CreateMemoryContainerResponse(Builder builder) {
        this.memoryContainerId = builder.memoryContainerId;
        this.status = builder.status;
    }

    public static CreateMemoryContainerResponse of(
        Function<CreateMemoryContainerResponse.Builder, ObjectBuilder<CreateMemoryContainerResponse>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code memory_container_id}
     */
    @Nullable
    public final String memoryContainerId() {
        return this.memoryContainerId;
    }

    /**
     * API name: {@code status}
     */
    @Nullable
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
        if (this.memoryContainerId != null) {
            generator.writeKey("memory_container_id");
            generator.write(this.memoryContainerId);
        }

        if (this.status != null) {
            generator.writeKey("status");
            generator.write(this.status);
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
     * Builder for {@link CreateMemoryContainerResponse}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, CreateMemoryContainerResponse> {
        @Nullable
        private String memoryContainerId;
        @Nullable
        private String status;

        public Builder() {}

        private Builder(CreateMemoryContainerResponse o) {
            this.memoryContainerId = o.memoryContainerId;
            this.status = o.status;
        }

        private Builder(Builder o) {
            this.memoryContainerId = o.memoryContainerId;
            this.status = o.status;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code memory_container_id}
         */
        @Nonnull
        public final Builder memoryContainerId(@Nullable String value) {
            this.memoryContainerId = value;
            return this;
        }

        /**
         * API name: {@code status}
         */
        @Nonnull
        public final Builder status(@Nullable String value) {
            this.status = value;
            return this;
        }

        /**
         * Builds a {@link CreateMemoryContainerResponse}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public CreateMemoryContainerResponse build() {
            _checkSingleUse();

            return new CreateMemoryContainerResponse(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link CreateMemoryContainerResponse}
     */
    public static final JsonpDeserializer<CreateMemoryContainerResponse> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        CreateMemoryContainerResponse::setupCreateMemoryContainerResponseDeserializer
    );

    protected static void setupCreateMemoryContainerResponseDeserializer(ObjectDeserializer<CreateMemoryContainerResponse.Builder> op) {
        op.add(Builder::memoryContainerId, JsonpDeserializer.stringDeserializer(), "memory_container_id");
        op.add(Builder::status, JsonpDeserializer.stringDeserializer(), "status");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.memoryContainerId);
        result = 31 * result + Objects.hashCode(this.status);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        CreateMemoryContainerResponse other = (CreateMemoryContainerResponse) o;
        return Objects.equals(this.memoryContainerId, other.memoryContainerId) && Objects.equals(this.status, other.status);
    }
}
