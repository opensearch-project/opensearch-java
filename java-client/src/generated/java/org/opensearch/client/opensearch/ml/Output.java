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
import java.util.List;
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
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: ml.Output

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class Output implements PlainJsonSerializable, ToCopyableBuilder<Output.Builder, Output> {

    @Nullable
    private final ByteBuffer byteBuffer;

    @Nonnull
    private final List<Double> data;

    @Nullable
    private final MlResultDataType dataType;

    @Nullable
    private final String name;

    @Nullable
    private final String result;

    @Nonnull
    private final List<Long> shape;

    // ---------------------------------------------------------------------------------------------

    private Output(Builder builder) {
        this.byteBuffer = builder.byteBuffer;
        this.data = ApiTypeHelper.unmodifiable(builder.data);
        this.dataType = builder.dataType;
        this.name = builder.name;
        this.result = builder.result;
        this.shape = ApiTypeHelper.unmodifiable(builder.shape);
    }

    public static Output of(Function<Output.Builder, ObjectBuilder<Output>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code byte_buffer}
     */
    @Nullable
    public final ByteBuffer byteBuffer() {
        return this.byteBuffer;
    }

    /**
     * API name: {@code data}
     */
    @Nonnull
    public final List<Double> data() {
        return this.data;
    }

    /**
     * API name: {@code data_type}
     */
    @Nullable
    public final MlResultDataType dataType() {
        return this.dataType;
    }

    /**
     * The output name.
     * <p>
     * API name: {@code name}
     * </p>
     */
    @Nullable
    public final String name() {
        return this.name;
    }

    /**
     * The output result.
     * <p>
     * API name: {@code result}
     * </p>
     */
    @Nullable
    public final String result() {
        return this.result;
    }

    /**
     * API name: {@code shape}
     */
    @Nonnull
    public final List<Long> shape() {
        return this.shape;
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
        if (this.byteBuffer != null) {
            generator.writeKey("byte_buffer");
            this.byteBuffer.serialize(generator, mapper);
        }

        if (ApiTypeHelper.isDefined(this.data)) {
            generator.writeKey("data");
            generator.writeStartArray();
            for (Double item0 : this.data) {
                generator.write(item0);
            }
            generator.writeEnd();
        }

        if (this.dataType != null) {
            generator.writeKey("data_type");
            this.dataType.serialize(generator, mapper);
        }

        if (this.name != null) {
            generator.writeKey("name");
            generator.write(this.name);
        }

        if (this.result != null) {
            generator.writeKey("result");
            generator.write(this.result);
        }

        if (ApiTypeHelper.isDefined(this.shape)) {
            generator.writeKey("shape");
            generator.writeStartArray();
            for (Long item0 : this.shape) {
                generator.write(item0);
            }
            generator.writeEnd();
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
     * Builder for {@link Output}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, Output> {
        @Nullable
        private ByteBuffer byteBuffer;
        @Nullable
        private List<Double> data;
        @Nullable
        private MlResultDataType dataType;
        @Nullable
        private String name;
        @Nullable
        private String result;
        @Nullable
        private List<Long> shape;

        public Builder() {}

        private Builder(Output o) {
            this.byteBuffer = o.byteBuffer;
            this.data = _listCopy(o.data);
            this.dataType = o.dataType;
            this.name = o.name;
            this.result = o.result;
            this.shape = _listCopy(o.shape);
        }

        private Builder(Builder o) {
            this.byteBuffer = o.byteBuffer;
            this.data = _listCopy(o.data);
            this.dataType = o.dataType;
            this.name = o.name;
            this.result = o.result;
            this.shape = _listCopy(o.shape);
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code byte_buffer}
         */
        @Nonnull
        public final Builder byteBuffer(@Nullable ByteBuffer value) {
            this.byteBuffer = value;
            return this;
        }

        /**
         * API name: {@code byte_buffer}
         */
        @Nonnull
        public final Builder byteBuffer(Function<ByteBuffer.Builder, ObjectBuilder<ByteBuffer>> fn) {
            return byteBuffer(fn.apply(new ByteBuffer.Builder()).build());
        }

        /**
         * API name: {@code data}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>data</code>.
         * </p>
         */
        @Nonnull
        public final Builder data(List<Double> list) {
            this.data = _listAddAll(this.data, list);
            return this;
        }

        /**
         * API name: {@code data}
         *
         * <p>
         * Adds one or more values to <code>data</code>.
         * </p>
         */
        @Nonnull
        public final Builder data(Double value, Double... values) {
            this.data = _listAdd(this.data, value, values);
            return this;
        }

        /**
         * API name: {@code data_type}
         */
        @Nonnull
        public final Builder dataType(@Nullable MlResultDataType value) {
            this.dataType = value;
            return this;
        }

        /**
         * The output name.
         * <p>
         * API name: {@code name}
         * </p>
         */
        @Nonnull
        public final Builder name(@Nullable String value) {
            this.name = value;
            return this;
        }

        /**
         * The output result.
         * <p>
         * API name: {@code result}
         * </p>
         */
        @Nonnull
        public final Builder result(@Nullable String value) {
            this.result = value;
            return this;
        }

        /**
         * API name: {@code shape}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>shape</code>.
         * </p>
         */
        @Nonnull
        public final Builder shape(List<Long> list) {
            this.shape = _listAddAll(this.shape, list);
            return this;
        }

        /**
         * API name: {@code shape}
         *
         * <p>
         * Adds one or more values to <code>shape</code>.
         * </p>
         */
        @Nonnull
        public final Builder shape(Long value, Long... values) {
            this.shape = _listAdd(this.shape, value, values);
            return this;
        }

        /**
         * Builds a {@link Output}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public Output build() {
            _checkSingleUse();

            return new Output(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link Output}
     */
    public static final JsonpDeserializer<Output> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        Output::setupOutputDeserializer
    );

    protected static void setupOutputDeserializer(ObjectDeserializer<Output.Builder> op) {
        op.add(Builder::byteBuffer, ByteBuffer._DESERIALIZER, "byte_buffer");
        op.add(Builder::data, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.doubleDeserializer()), "data");
        op.add(Builder::dataType, MlResultDataType._DESERIALIZER, "data_type");
        op.add(Builder::name, JsonpDeserializer.stringDeserializer(), "name");
        op.add(Builder::result, JsonpDeserializer.stringDeserializer(), "result");
        op.add(Builder::shape, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.longDeserializer()), "shape");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.byteBuffer);
        result = 31 * result + Objects.hashCode(this.data);
        result = 31 * result + Objects.hashCode(this.dataType);
        result = 31 * result + Objects.hashCode(this.name);
        result = 31 * result + Objects.hashCode(this.result);
        result = 31 * result + Objects.hashCode(this.shape);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Output other = (Output) o;
        return Objects.equals(this.byteBuffer, other.byteBuffer)
            && Objects.equals(this.data, other.data)
            && Objects.equals(this.dataType, other.dataType)
            && Objects.equals(this.name, other.name)
            && Objects.equals(this.result, other.result)
            && Objects.equals(this.shape, other.shape);
    }
}
