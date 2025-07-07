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

// typedef: ml.Values

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class Values implements PlainJsonSerializable, ToCopyableBuilder<Values.Builder, Values> {

    @Nullable
    private final ColumnType columnType;

    @Nullable
    private final Number value;

    // ---------------------------------------------------------------------------------------------

    private Values(Builder builder) {
        this.columnType = builder.columnType;
        this.value = builder.value;
    }

    public static Values of(Function<Values.Builder, ObjectBuilder<Values>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code column_type}
     */
    @Nullable
    public final ColumnType columnType() {
        return this.columnType;
    }

    /**
     * The value.
     * <p>
     * API name: {@code value}
     * </p>
     */
    @Nullable
    public final Number value() {
        return this.value;
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
        if (this.columnType != null) {
            generator.writeKey("column_type");
            this.columnType.serialize(generator, mapper);
        }

        if (this.value != null) {
            generator.writeKey("value");
            generator.write(this.value.doubleValue());
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
     * Builder for {@link Values}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, Values> {
        @Nullable
        private ColumnType columnType;
        @Nullable
        private Number value;

        public Builder() {}

        private Builder(Values o) {
            this.columnType = o.columnType;
            this.value = o.value;
        }

        private Builder(Builder o) {
            this.columnType = o.columnType;
            this.value = o.value;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code column_type}
         */
        @Nonnull
        public final Builder columnType(@Nullable ColumnType value) {
            this.columnType = value;
            return this;
        }

        /**
         * The value.
         * <p>
         * API name: {@code value}
         * </p>
         */
        @Nonnull
        public final Builder value(@Nullable Number value) {
            this.value = value;
            return this;
        }

        /**
         * Builds a {@link Values}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public Values build() {
            _checkSingleUse();

            return new Values(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link Values}
     */
    public static final JsonpDeserializer<Values> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        Values::setupValuesDeserializer
    );

    protected static void setupValuesDeserializer(ObjectDeserializer<Values.Builder> op) {
        op.add(Builder::columnType, ColumnType._DESERIALIZER, "column_type");
        op.add(Builder::value, JsonpDeserializer.numberDeserializer(), "value");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.columnType);
        result = 31 * result + Objects.hashCode(this.value);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Values other = (Values) o;
        return Objects.equals(this.columnType, other.columnType) && Objects.equals(this.value, other.value);
    }
}
