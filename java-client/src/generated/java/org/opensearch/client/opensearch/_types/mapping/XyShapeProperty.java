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

package org.opensearch.client.opensearch._types.mapping;

import jakarta.json.stream.JsonGenerator;
import java.util.Objects;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nullable;
import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.util.ObjectBuilder;

// typedef: _types.mapping.XyShapeProperty

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class XyShapeProperty extends DocValuesPropertyBase implements PropertyVariant {

    @Nullable
    private final Boolean coerce;

    @Nullable
    private final Boolean ignoreMalformed;

    @Nullable
    private final Boolean ignoreZValue;

    @Nullable
    private final GeoOrientation orientation;

    // ---------------------------------------------------------------------------------------------

    private XyShapeProperty(Builder builder) {
        super(builder);
        this.coerce = builder.coerce;
        this.ignoreMalformed = builder.ignoreMalformed;
        this.ignoreZValue = builder.ignoreZValue;
        this.orientation = builder.orientation;
    }

    public static XyShapeProperty of(Function<XyShapeProperty.Builder, ObjectBuilder<XyShapeProperty>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link Property} variant kind.
     */
    @Override
    public Property.Kind _propertyKind() {
        return Property.Kind.XyShape;
    }

    /**
     * API name: {@code coerce}
     */
    @Nullable
    public final Boolean coerce() {
        return this.coerce;
    }

    /**
     * API name: {@code ignore_malformed}
     */
    @Nullable
    public final Boolean ignoreMalformed() {
        return this.ignoreMalformed;
    }

    /**
     * API name: {@code ignore_z_value}
     */
    @Nullable
    public final Boolean ignoreZValue() {
        return this.ignoreZValue;
    }

    /**
     * API name: {@code orientation}
     */
    @Nullable
    public final GeoOrientation orientation() {
        return this.orientation;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        generator.write("type", "xy_shape");
        super.serializeInternal(generator, mapper);
        if (this.coerce != null) {
            generator.writeKey("coerce");
            generator.write(this.coerce);
        }

        if (this.ignoreMalformed != null) {
            generator.writeKey("ignore_malformed");
            generator.write(this.ignoreMalformed);
        }

        if (this.ignoreZValue != null) {
            generator.writeKey("ignore_z_value");
            generator.write(this.ignoreZValue);
        }

        if (this.orientation != null) {
            generator.writeKey("orientation");
            this.orientation.serialize(generator, mapper);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Builder for {@link XyShapeProperty}.
     */
    public static class Builder extends DocValuesPropertyBase.AbstractBuilder<Builder> implements ObjectBuilder<XyShapeProperty> {
        @Nullable
        private Boolean coerce;
        @Nullable
        private Boolean ignoreMalformed;
        @Nullable
        private Boolean ignoreZValue;
        @Nullable
        private GeoOrientation orientation;

        /**
         * API name: {@code coerce}
         */
        public final Builder coerce(@Nullable Boolean value) {
            this.coerce = value;
            return this;
        }

        /**
         * API name: {@code ignore_malformed}
         */
        public final Builder ignoreMalformed(@Nullable Boolean value) {
            this.ignoreMalformed = value;
            return this;
        }

        /**
         * API name: {@code ignore_z_value}
         */
        public final Builder ignoreZValue(@Nullable Boolean value) {
            this.ignoreZValue = value;
            return this;
        }

        /**
         * API name: {@code orientation}
         */
        public final Builder orientation(@Nullable GeoOrientation value) {
            this.orientation = value;
            return this;
        }

        @Override
        protected Builder self() {
            return this;
        }

        /**
         * Builds a {@link XyShapeProperty}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        public XyShapeProperty build() {
            _checkSingleUse();

            return new XyShapeProperty(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link XyShapeProperty}
     */
    public static final JsonpDeserializer<XyShapeProperty> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        XyShapeProperty::setupXyShapePropertyDeserializer
    );

    protected static void setupXyShapePropertyDeserializer(ObjectDeserializer<XyShapeProperty.Builder> op) {
        setupDocValuesPropertyBaseDeserializer(op);
        op.add(Builder::coerce, JsonpDeserializer.booleanDeserializer(), "coerce");
        op.add(Builder::ignoreMalformed, JsonpDeserializer.booleanDeserializer(), "ignore_malformed");
        op.add(Builder::ignoreZValue, JsonpDeserializer.booleanDeserializer(), "ignore_z_value");
        op.add(Builder::orientation, GeoOrientation._DESERIALIZER, "orientation");

        op.ignore("type");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(this.coerce);
        result = 31 * result + Objects.hashCode(this.ignoreMalformed);
        result = 31 * result + Objects.hashCode(this.ignoreZValue);
        result = 31 * result + Objects.hashCode(this.orientation);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        XyShapeProperty other = (XyShapeProperty) o;
        return Objects.equals(this.coerce, other.coerce)
            && Objects.equals(this.ignoreMalformed, other.ignoreMalformed)
            && Objects.equals(this.ignoreZValue, other.ignoreZValue)
            && Objects.equals(this.orientation, other.orientation);
    }
}
