/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

/*
 * Licensed to Elasticsearch B.V. under one or more contributor
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
 * ownership. Elasticsearch B.V. licenses this file to you under
 * the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

/*
 * Modifications Copyright OpenSearch Contributors. See
 * GitHub history for details.
 */

//----------------------------------------------------
// THIS CODE IS GENERATED. MANUAL EDITS WILL BE LOST.
//----------------------------------------------------

package org.opensearch.client.opensearch._types;

import jakarta.json.stream.JsonGenerator;
import java.util.Objects;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
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

// typedef: _types.GeoHashPrecision

/**
 * The level of geohash precision, which can be expressed as a geohash length between 1 and 12 or as a distance measure, such as
 * &quot;1km&quot; or &quot;10m&quot;.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class GeoHashPrecision implements TaggedUnion<GeoHashPrecision.Kind, Object>, PlainJsonSerializable {
    /**
     * {@link GeoHashPrecision} variant kinds.
     */
    public enum Kind {
        Distance,
        GeohashLength
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

    private GeoHashPrecision(Kind kind, Object value) {
        this._kind = kind;
        this._value = value;
    }

    private GeoHashPrecision(Builder builder) {
        this._kind = ApiTypeHelper.requireNonNull(builder._kind, builder, "<variant kind>");
        this._value = ApiTypeHelper.requireNonNull(builder._value, builder, "<variant value>");
    }

    public static GeoHashPrecision of(Function<GeoHashPrecision.Builder, ObjectBuilder<GeoHashPrecision>> fn) {
        return fn.apply(new Builder()).build();
    }

    public String _toJsonString() {
        switch (_kind) {
            case Distance:
                return this.distance();
            case GeohashLength:
                return String.valueOf(this.geohashLength());
            default:
                throw new IllegalStateException("Unknown kind " + _kind);
        }
    }

    /**
     * Is this variant instance of kind {@code distance}?
     */
    public boolean isDistance() {
        return _kind == Kind.Distance;
    }

    /**
     * Get the {@code distance} variant value.
     *
     * @throws IllegalStateException if the current variant is not the {@code distance} kind.
     */
    public String distance() {
        return TaggedUnionUtils.get(this, Kind.Distance);
    }

    /**
     * Is this variant instance of kind {@code geohash_length}?
     */
    public boolean isGeohashLength() {
        return _kind == Kind.GeohashLength;
    }

    /**
     * Get the {@code geohash_length} variant value.
     *
     * @throws IllegalStateException if the current variant is not the {@code geohash_length} kind.
     */
    public Integer geohashLength() {
        return TaggedUnionUtils.get(this, Kind.GeohashLength);
    }

    @Override
    public void serialize(JsonGenerator generator, JsonpMapper mapper) {
        if (_value instanceof JsonpSerializable) {
            ((JsonpSerializable) _value).serialize(generator, mapper);
        } else {
            switch (_kind) {
                case Distance:
                    generator.write(((String) this._value));
                    break;
                case GeohashLength:
                    generator.write(((Integer) this._value));
                    break;
            }
        }
    }

    @Nonnull
    public Builder toBuilder() {
        return new Builder(this);
    }

    @Nonnull
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder extends ObjectBuilderBase implements ObjectBuilder<GeoHashPrecision> {
        private Kind _kind;
        private Object _value;

        public Builder() {}

        private Builder(GeoHashPrecision o) {
            this._kind = o._kind;
            this._value = o._value;
        }

        public ObjectBuilder<GeoHashPrecision> distance(String v) {
            this._kind = Kind.Distance;
            this._value = v;
            return this;
        }

        public ObjectBuilder<GeoHashPrecision> geohashLength(Integer v) {
            this._kind = Kind.GeohashLength;
            this._value = v;
            return this;
        }

        @Override
        public GeoHashPrecision build() {
            _checkSingleUse();
            return new GeoHashPrecision(this);
        }
    }

    private static JsonpDeserializer<GeoHashPrecision> buildGeoHashPrecisionDeserializer() {
        return new UnionDeserializer.Builder<GeoHashPrecision, Kind, Object>(GeoHashPrecision::new, false).addMember(
            Kind.Distance,
            JsonpDeserializer.stringDeserializer()
        ).addMember(Kind.GeohashLength, JsonpDeserializer.integerDeserializer()).build();
    }

    public static final JsonpDeserializer<GeoHashPrecision> _DESERIALIZER = JsonpDeserializer.lazy(
        GeoHashPrecision::buildGeoHashPrecisionDeserializer
    );

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
        GeoHashPrecision other = (GeoHashPrecision) o;
        return Objects.equals(this._kind, other._kind) && Objects.equals(this._value, other._value);
    }
}
