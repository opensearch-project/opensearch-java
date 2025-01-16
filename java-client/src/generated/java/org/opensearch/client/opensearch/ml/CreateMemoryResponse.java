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

// typedef: ml.create_memory.Response

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class CreateMemoryResponse implements PlainJsonSerializable, ToCopyableBuilder<CreateMemoryResponse.Builder, CreateMemoryResponse> {

    @Nonnull
    private final String memoryId;

    // ---------------------------------------------------------------------------------------------

    private CreateMemoryResponse(Builder builder) {
        this.memoryId = ApiTypeHelper.requireNonNull(builder.memoryId, this, "memoryId");
    }

    public static CreateMemoryResponse of(Function<CreateMemoryResponse.Builder, ObjectBuilder<CreateMemoryResponse>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code memory_id}
     */
    @Nonnull
    public final String memoryId() {
        return this.memoryId;
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
        generator.writeKey("memory_id");
        generator.write(this.memoryId);
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
     * Builder for {@link CreateMemoryResponse}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, CreateMemoryResponse> {
        private String memoryId;

        public Builder() {}

        private Builder(CreateMemoryResponse o) {
            this.memoryId = o.memoryId;
        }

        private Builder(Builder o) {
            this.memoryId = o.memoryId;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - API name: {@code memory_id}
         */
        @Nonnull
        public final Builder memoryId(String value) {
            this.memoryId = value;
            return this;
        }

        /**
         * Builds a {@link CreateMemoryResponse}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public CreateMemoryResponse build() {
            _checkSingleUse();

            return new CreateMemoryResponse(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link CreateMemoryResponse}
     */
    public static final JsonpDeserializer<CreateMemoryResponse> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        CreateMemoryResponse::setupCreateMemoryResponseDeserializer
    );

    protected static void setupCreateMemoryResponseDeserializer(ObjectDeserializer<CreateMemoryResponse.Builder> op) {
        op.add(Builder::memoryId, JsonpDeserializer.stringDeserializer(), "memory_id");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.memoryId.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        CreateMemoryResponse other = (CreateMemoryResponse) o;
        return this.memoryId.equals(other.memoryId);
    }
}
