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

package org.opensearch.client.opensearch._types;

import jakarta.json.stream.JsonGenerator;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import javax.annotation.Generated;
import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.JsonpSerializable;
import org.opensearch.client.json.PlainJsonSerializable;
import org.opensearch.client.json.UnionDeserializer;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.TaggedUnion;
import org.opensearch.client.util.TaggedUnionUtils;

// typedef: _types.XyLocation

/**
 * <p>
 * A two-dimensional Cartesian point specified by x and y coordinates. It can be represented in the following ways:
 * </p>
 * <ul>
 * <li>As an <code>{x, y}</code> object.</li>
 * <li>As an <code>[x, y]</code> array.</li>
 * <li>As a string in <code>&quot;x, y&quot;</code> or WKT point format.</li>
 * </ul>
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class XyLocation implements TaggedUnion<XyLocation.Kind, Object>, PlainJsonSerializable {
    /**
     * {@link XyLocation} variant kinds.
     */
    public enum Kind {
        Cartesian,
        Coords,
        Text
    }

    private final Kind _kind;
    private final Object _value;

    @Override
    public final Kind _kind() {
        return _kind;
    }

    @Override
    public final Object _get() {
        return _value;
    }

    private XyLocation(Kind kind, Object value) {
        this._kind = kind;
        this._value = value;
    }

    private XyLocation(Builder builder) {
        this._kind = ApiTypeHelper.requireNonNull(builder._kind, builder, "<variant kind>");
        this._value = ApiTypeHelper.requireNonNull(builder._value, builder, "<variant value>");
    }

    public static XyLocation of(Function<XyLocation.Builder, ObjectBuilder<XyLocation>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Is this variant instance of kind {@code cartesian}?
     */
    public boolean isCartesian() {
        return _kind == Kind.Cartesian;
    }

    /**
     * Get the {@code cartesian} variant value.
     *
     * @throws IllegalStateException if the current variant is not the {@code cartesian} kind.
     */
    public XyCartesianCoordinates cartesian() {
        return TaggedUnionUtils.get(this, Kind.Cartesian);
    }

    /**
     * Is this variant instance of kind {@code coords}?
     */
    public boolean isCoords() {
        return _kind == Kind.Coords;
    }

    /**
     * Get the {@code coords} variant value.
     *
     * @throws IllegalStateException if the current variant is not the {@code coords} kind.
     */
    public List<Double> coords() {
        return TaggedUnionUtils.get(this, Kind.Coords);
    }

    /**
     * Is this variant instance of kind {@code text}?
     */
    public boolean isText() {
        return _kind == Kind.Text;
    }

    /**
     * Get the {@code text} variant value.
     *
     * @throws IllegalStateException if the current variant is not the {@code text} kind.
     */
    public String text() {
        return TaggedUnionUtils.get(this, Kind.Text);
    }

    @Override
    public void serialize(JsonGenerator generator, JsonpMapper mapper) {
        if (_value instanceof JsonpSerializable) {
            ((JsonpSerializable) _value).serialize(generator, mapper);
        } else {
            switch (_kind) {
                case Coords:
                    generator.writeStartArray();
                    for (Double item0 : ((List<Double>) this._value)) {
                        generator.write(item0);
                    }
                    generator.writeEnd();
                    break;
                case Text:
                    generator.write(((String) this._value));
                    break;
            }
        }
    }

    public static class Builder extends ObjectBuilderBase implements ObjectBuilder<XyLocation> {
        private Kind _kind;
        private Object _value;

        public ObjectBuilder<XyLocation> cartesian(XyCartesianCoordinates v) {
            this._kind = Kind.Cartesian;
            this._value = v;
            return this;
        }

        public ObjectBuilder<XyLocation> cartesian(Function<XyCartesianCoordinates.Builder, ObjectBuilder<XyCartesianCoordinates>> fn) {
            return this.cartesian(fn.apply(new XyCartesianCoordinates.Builder()).build());
        }

        public ObjectBuilder<XyLocation> coords(List<Double> v) {
            this._kind = Kind.Coords;
            this._value = v;
            return this;
        }

        public ObjectBuilder<XyLocation> text(String v) {
            this._kind = Kind.Text;
            this._value = v;
            return this;
        }

        @Override
        public XyLocation build() {
            _checkSingleUse();
            return new XyLocation(this);
        }
    }

    private static JsonpDeserializer<XyLocation> buildXyLocationDeserializer() {
        return new UnionDeserializer.Builder<XyLocation, Kind, Object>(XyLocation::new, false).addMember(
            Kind.Cartesian,
            XyCartesianCoordinates._DESERIALIZER
        )
            .addMember(Kind.Coords, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.doubleDeserializer()))
            .addMember(Kind.Text, JsonpDeserializer.stringDeserializer())
            .build();
    }

    public static final JsonpDeserializer<XyLocation> _DESERIALIZER = JsonpDeserializer.lazy(XyLocation::buildXyLocationDeserializer);

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this._kind);
        result = 31 * result + Objects.hashCode(this._value);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        XyLocation other = (XyLocation) o;
        return Objects.equals(this._kind, other._kind) && Objects.equals(this._value, other._value);
    }
}
