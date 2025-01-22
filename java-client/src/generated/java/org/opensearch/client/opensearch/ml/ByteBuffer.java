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

// typedef: ml.ByteBuffer

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class ByteBuffer implements PlainJsonSerializable, ToCopyableBuilder<ByteBuffer.Builder, ByteBuffer> {

    @Nullable
    private final String array;

    @Nullable
    private final String order;

    // ---------------------------------------------------------------------------------------------

    private ByteBuffer(Builder builder) {
        this.array = builder.array;
        this.order = builder.order;
    }

    public static ByteBuffer of(Function<ByteBuffer.Builder, ObjectBuilder<ByteBuffer>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * The byte buffer array.
     * <p>
     * API name: {@code array}
     * </p>
     */
    @Nullable
    public final String array() {
        return this.array;
    }

    /**
     * The byte buffer order.
     * <p>
     * API name: {@code order}
     * </p>
     */
    @Nullable
    public final String order() {
        return this.order;
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
        if (this.array != null) {
            generator.writeKey("array");
            generator.write(this.array);
        }

        if (this.order != null) {
            generator.writeKey("order");
            generator.write(this.order);
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
     * Builder for {@link ByteBuffer}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, ByteBuffer> {
        @Nullable
        private String array;
        @Nullable
        private String order;

        public Builder() {}

        private Builder(ByteBuffer o) {
            this.array = o.array;
            this.order = o.order;
        }

        private Builder(Builder o) {
            this.array = o.array;
            this.order = o.order;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * The byte buffer array.
         * <p>
         * API name: {@code array}
         * </p>
         */
        @Nonnull
        public final Builder array(@Nullable String value) {
            this.array = value;
            return this;
        }

        /**
         * The byte buffer order.
         * <p>
         * API name: {@code order}
         * </p>
         */
        @Nonnull
        public final Builder order(@Nullable String value) {
            this.order = value;
            return this;
        }

        /**
         * Builds a {@link ByteBuffer}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ByteBuffer build() {
            _checkSingleUse();

            return new ByteBuffer(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ByteBuffer}
     */
    public static final JsonpDeserializer<ByteBuffer> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ByteBuffer::setupByteBufferDeserializer
    );

    protected static void setupByteBufferDeserializer(ObjectDeserializer<ByteBuffer.Builder> op) {
        op.add(Builder::array, JsonpDeserializer.stringDeserializer(), "array");
        op.add(Builder::order, JsonpDeserializer.stringDeserializer(), "order");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.array);
        result = 31 * result + Objects.hashCode(this.order);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ByteBuffer other = (ByteBuffer) o;
        return Objects.equals(this.array, other.array) && Objects.equals(this.order, other.order);
    }
}
