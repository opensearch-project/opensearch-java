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
import org.opensearch.client.opensearch._types.XyLocation;
import org.opensearch.client.util.ObjectBuilder;

// typedef: _types.mapping.XyPointProperty

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class XyPointProperty extends DocValuesPropertyBase implements PropertyVariant {

    @Nullable
    private final Boolean ignoreMalformed;

    @Nullable
    private final Boolean ignoreZValue;

    @Nullable
    private final XyLocation nullValue;

    // ---------------------------------------------------------------------------------------------

    private XyPointProperty(Builder builder) {
        super(builder);
        this.ignoreMalformed = builder.ignoreMalformed;
        this.ignoreZValue = builder.ignoreZValue;
        this.nullValue = builder.nullValue;
    }

    public static XyPointProperty of(Function<XyPointProperty.Builder, ObjectBuilder<XyPointProperty>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link Property} variant kind.
     */
    @Override
    public Property.Kind _propertyKind() {
        return Property.Kind.XyPoint;
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
     * API name: {@code null_value}
     */
    @Nullable
    public final XyLocation nullValue() {
        return this.nullValue;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        generator.write("type", "xy_point");
        super.serializeInternal(generator, mapper);
        if (this.ignoreMalformed != null) {
            generator.writeKey("ignore_malformed");
            generator.write(this.ignoreMalformed);
        }

        if (this.ignoreZValue != null) {
            generator.writeKey("ignore_z_value");
            generator.write(this.ignoreZValue);
        }

        if (this.nullValue != null) {
            generator.writeKey("null_value");
            this.nullValue.serialize(generator, mapper);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Builder for {@link XyPointProperty}.
     */
    public static class Builder extends DocValuesPropertyBase.AbstractBuilder<Builder> implements ObjectBuilder<XyPointProperty> {
        @Nullable
        private Boolean ignoreMalformed;
        @Nullable
        private Boolean ignoreZValue;
        @Nullable
        private XyLocation nullValue;

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
         * API name: {@code null_value}
         */
        public final Builder nullValue(@Nullable XyLocation value) {
            this.nullValue = value;
            return this;
        }

        /**
         * API name: {@code null_value}
         */
        public final Builder nullValue(Function<XyLocation.Builder, ObjectBuilder<XyLocation>> fn) {
            return nullValue(fn.apply(new XyLocation.Builder()).build());
        }

        @Override
        protected Builder self() {
            return this;
        }

        /**
         * Builds a {@link XyPointProperty}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        public XyPointProperty build() {
            _checkSingleUse();

            return new XyPointProperty(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link XyPointProperty}
     */
    public static final JsonpDeserializer<XyPointProperty> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        XyPointProperty::setupXyPointPropertyDeserializer
    );

    protected static void setupXyPointPropertyDeserializer(ObjectDeserializer<XyPointProperty.Builder> op) {
        setupDocValuesPropertyBaseDeserializer(op);
        op.add(Builder::ignoreMalformed, JsonpDeserializer.booleanDeserializer(), "ignore_malformed");
        op.add(Builder::ignoreZValue, JsonpDeserializer.booleanDeserializer(), "ignore_z_value");
        op.add(Builder::nullValue, XyLocation._DESERIALIZER, "null_value");

        op.ignore("type");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(this.ignoreMalformed);
        result = 31 * result + Objects.hashCode(this.ignoreZValue);
        result = 31 * result + Objects.hashCode(this.nullValue);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        XyPointProperty other = (XyPointProperty) o;
        return Objects.equals(this.ignoreMalformed, other.ignoreMalformed)
            && Objects.equals(this.ignoreZValue, other.ignoreZValue)
            && Objects.equals(this.nullValue, other.nullValue);
    }
}
