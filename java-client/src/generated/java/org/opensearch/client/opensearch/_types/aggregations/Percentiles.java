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

package org.opensearch.client.opensearch._types.aggregations;

import jakarta.json.stream.JsonGenerator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import org.opensearch.client.json.JsonData;
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

// typedef: _types.aggregations.Percentiles

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class Percentiles implements TaggedUnion<Percentiles.Kind, Object>, PlainJsonSerializable {
    /**
     * {@link Percentiles} variant kinds.
     */
    public enum Kind {
        Array,
        Keyed
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

    private Percentiles(Kind kind, Object value) {
        this._kind = kind;
        this._value = value;
    }

    private Percentiles(Builder builder) {
        this._kind = ApiTypeHelper.requireNonNull(builder._kind, builder, "<variant kind>");
        this._value = ApiTypeHelper.requireNonNull(builder._value, builder, "<variant value>");
    }

    public static Percentiles of(Function<Percentiles.Builder, ObjectBuilder<Percentiles>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Is this variant instance of kind {@code array}?
     */
    public boolean isArray() {
        return _kind == Kind.Array;
    }

    /**
     * Get the {@code array} variant value.
     *
     * @throws IllegalStateException if the current variant is not the {@code array} kind.
     */
    public List<ArrayPercentilesItem> array() {
        return TaggedUnionUtils.get(this, Kind.Array);
    }

    /**
     * Is this variant instance of kind {@code keyed}?
     */
    public boolean isKeyed() {
        return _kind == Kind.Keyed;
    }

    /**
     * Get the {@code keyed} variant value.
     *
     * @throws IllegalStateException if the current variant is not the {@code keyed} kind.
     */
    public Map<String, JsonData> keyed() {
        return TaggedUnionUtils.get(this, Kind.Keyed);
    }

    @Override
    public void serialize(JsonGenerator generator, JsonpMapper mapper) {
        if (_value instanceof JsonpSerializable) {
            ((JsonpSerializable) _value).serialize(generator, mapper);
        } else {
            switch (_kind) {
                case Array:
                    generator.writeStartArray();
                    for (ArrayPercentilesItem item0 : ((List<ArrayPercentilesItem>) this._value)) {
                        item0.serialize(generator, mapper);
                    }
                    generator.writeEnd();
                    break;
                case Keyed:
                    generator.writeStartObject();
                    for (Map.Entry<String, JsonData> item0 : ((Map<String, JsonData>) this._value).entrySet()) {
                        generator.writeKey(item0.getKey());
                        item0.getValue().serialize(generator, mapper);
                    }
                    generator.writeEnd();
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

    public static class Builder extends ObjectBuilderBase implements ObjectBuilder<Percentiles> {
        private Kind _kind;
        private Object _value;

        public Builder() {}

        private Builder(Percentiles o) {
            this._kind = o._kind;
            this._value = o._value;
        }

        public ObjectBuilder<Percentiles> array(List<ArrayPercentilesItem> v) {
            this._kind = Kind.Array;
            this._value = v;
            return this;
        }

        public ObjectBuilder<Percentiles> keyed(Map<String, JsonData> v) {
            this._kind = Kind.Keyed;
            this._value = v;
            return this;
        }

        @Override
        public Percentiles build() {
            _checkSingleUse();
            return new Percentiles(this);
        }
    }

    private static JsonpDeserializer<Percentiles> buildPercentilesDeserializer() {
        return new UnionDeserializer.Builder<Percentiles, Kind, Object>(Percentiles::new, false).addMember(
            Kind.Array,
            JsonpDeserializer.arrayDeserializer(ArrayPercentilesItem._DESERIALIZER)
        ).addMember(Kind.Keyed, JsonpDeserializer.stringMapDeserializer(JsonData._DESERIALIZER)).build();
    }

    public static final JsonpDeserializer<Percentiles> _DESERIALIZER = JsonpDeserializer.lazy(Percentiles::buildPercentilesDeserializer);

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
        Percentiles other = (Percentiles) o;
        return Objects.equals(this._kind, other._kind) && Objects.equals(this._value, other._value);
    }
}
