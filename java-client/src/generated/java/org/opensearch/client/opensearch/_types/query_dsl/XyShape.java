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

package org.opensearch.client.opensearch._types.query_dsl;

import jakarta.json.stream.JsonGenerator;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.opensearch.client.json.JsonData;
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

// typedef: _types.query_dsl.XyShape

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class XyShape implements PlainJsonSerializable, ToCopyableBuilder<XyShape.Builder, XyShape> {

    @Nonnull
    private final List<JsonData> coordinates;

    @Nullable
    private final String type;

    // ---------------------------------------------------------------------------------------------

    private XyShape(Builder builder) {
        this.coordinates = ApiTypeHelper.unmodifiable(builder.coordinates);
        this.type = builder.type;
    }

    public static XyShape of(Function<XyShape.Builder, ObjectBuilder<XyShape>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code coordinates}
     */
    @Nonnull
    public final List<JsonData> coordinates() {
        return this.coordinates;
    }

    /**
     * API name: {@code type}
     */
    @Nullable
    public final String type() {
        return this.type;
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
        if (ApiTypeHelper.isDefined(this.coordinates)) {
            generator.writeKey("coordinates");
            generator.writeStartArray();
            for (JsonData item0 : this.coordinates) {
                item0.serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (this.type != null) {
            generator.writeKey("type");
            generator.write(this.type);
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
     * Builder for {@link XyShape}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, XyShape> {
        @Nullable
        private List<JsonData> coordinates;
        @Nullable
        private String type;

        public Builder() {}

        private Builder(XyShape o) {
            this.coordinates = _listCopy(o.coordinates);
            this.type = o.type;
        }

        private Builder(Builder o) {
            this.coordinates = _listCopy(o.coordinates);
            this.type = o.type;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code coordinates}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>coordinates</code>.
         * </p>
         */
        @Nonnull
        public final Builder coordinates(List<JsonData> list) {
            this.coordinates = _listAddAll(this.coordinates, list);
            return this;
        }

        /**
         * API name: {@code coordinates}
         *
         * <p>
         * Adds one or more values to <code>coordinates</code>.
         * </p>
         */
        @Nonnull
        public final Builder coordinates(JsonData value, JsonData... values) {
            this.coordinates = _listAdd(this.coordinates, value, values);
            return this;
        }

        /**
         * API name: {@code type}
         */
        @Nonnull
        public final Builder type(@Nullable String value) {
            this.type = value;
            return this;
        }

        /**
         * Builds a {@link XyShape}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public XyShape build() {
            _checkSingleUse();

            return new XyShape(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link XyShape}
     */
    public static final JsonpDeserializer<XyShape> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        XyShape::setupXyShapeDeserializer
    );

    protected static void setupXyShapeDeserializer(ObjectDeserializer<XyShape.Builder> op) {
        op.add(Builder::coordinates, JsonpDeserializer.arrayDeserializer(JsonData._DESERIALIZER), "coordinates");
        op.add(Builder::type, JsonpDeserializer.stringDeserializer(), "type");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.coordinates);
        result = 31 * result + Objects.hashCode(this.type);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        XyShape other = (XyShape) o;
        return Objects.equals(this.coordinates, other.coordinates) && Objects.equals(this.type, other.type);
    }
}
