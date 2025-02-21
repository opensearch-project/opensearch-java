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

// typedef: ml.delete_memory.Response

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class DeleteMemoryResponse implements PlainJsonSerializable, ToCopyableBuilder<DeleteMemoryResponse.Builder, DeleteMemoryResponse> {

    private final boolean success;

    // ---------------------------------------------------------------------------------------------

    private DeleteMemoryResponse(Builder builder) {
        this.success = ApiTypeHelper.requireNonNull(builder.success, this, "success");
    }

    public static DeleteMemoryResponse of(Function<DeleteMemoryResponse.Builder, ObjectBuilder<DeleteMemoryResponse>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - Whether the memory was deleted successfully.
     * <p>
     * API name: {@code success}
     * </p>
     */
    public final boolean success() {
        return this.success;
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
        generator.writeKey("success");
        generator.write(this.success);
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
     * Builder for {@link DeleteMemoryResponse}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, DeleteMemoryResponse> {
        private Boolean success;

        public Builder() {}

        private Builder(DeleteMemoryResponse o) {
            this.success = o.success;
        }

        private Builder(Builder o) {
            this.success = o.success;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - Whether the memory was deleted successfully.
         * <p>
         * API name: {@code success}
         * </p>
         */
        @Nonnull
        public final Builder success(boolean value) {
            this.success = value;
            return this;
        }

        /**
         * Builds a {@link DeleteMemoryResponse}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public DeleteMemoryResponse build() {
            _checkSingleUse();

            return new DeleteMemoryResponse(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link DeleteMemoryResponse}
     */
    public static final JsonpDeserializer<DeleteMemoryResponse> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        DeleteMemoryResponse::setupDeleteMemoryResponseDeserializer
    );

    protected static void setupDeleteMemoryResponseDeserializer(ObjectDeserializer<DeleteMemoryResponse.Builder> op) {
        op.add(Builder::success, JsonpDeserializer.booleanDeserializer(), "success");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Boolean.hashCode(this.success);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        DeleteMemoryResponse other = (DeleteMemoryResponse) o;
        return this.success == other.success;
    }
}
