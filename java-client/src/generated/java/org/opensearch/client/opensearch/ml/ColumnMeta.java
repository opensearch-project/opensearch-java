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

// typedef: ml.ColumnMeta

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class ColumnMeta implements PlainJsonSerializable, ToCopyableBuilder<ColumnMeta.Builder, ColumnMeta> {

    @Nullable
    private final String columnType;

    @Nullable
    private final String name;

    // ---------------------------------------------------------------------------------------------

    private ColumnMeta(Builder builder) {
        this.columnType = builder.columnType;
        this.name = builder.name;
    }

    public static ColumnMeta of(Function<ColumnMeta.Builder, ObjectBuilder<ColumnMeta>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * The column type.
     * <p>
     * API name: {@code column_type}
     * </p>
     */
    @Nullable
    public final String columnType() {
        return this.columnType;
    }

    /**
     * API name: {@code name}
     */
    @Nullable
    public final String name() {
        return this.name;
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
            generator.write(this.columnType);
        }

        if (this.name != null) {
            generator.writeKey("name");
            generator.write(this.name);
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
     * Builder for {@link ColumnMeta}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, ColumnMeta> {
        @Nullable
        private String columnType;
        @Nullable
        private String name;

        public Builder() {}

        private Builder(ColumnMeta o) {
            this.columnType = o.columnType;
            this.name = o.name;
        }

        private Builder(Builder o) {
            this.columnType = o.columnType;
            this.name = o.name;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * The column type.
         * <p>
         * API name: {@code column_type}
         * </p>
         */
        @Nonnull
        public final Builder columnType(@Nullable String value) {
            this.columnType = value;
            return this;
        }

        /**
         * API name: {@code name}
         */
        @Nonnull
        public final Builder name(@Nullable String value) {
            this.name = value;
            return this;
        }

        /**
         * Builds a {@link ColumnMeta}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ColumnMeta build() {
            _checkSingleUse();

            return new ColumnMeta(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ColumnMeta}
     */
    public static final JsonpDeserializer<ColumnMeta> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ColumnMeta::setupColumnMetaDeserializer
    );

    protected static void setupColumnMetaDeserializer(ObjectDeserializer<ColumnMeta.Builder> op) {
        op.add(Builder::columnType, JsonpDeserializer.stringDeserializer(), "column_type");
        op.add(Builder::name, JsonpDeserializer.stringDeserializer(), "name");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.columnType);
        result = 31 * result + Objects.hashCode(this.name);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ColumnMeta other = (ColumnMeta) o;
        return Objects.equals(this.columnType, other.columnType) && Objects.equals(this.name, other.name);
    }
}
