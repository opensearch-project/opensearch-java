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
import java.util.Map;
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

// typedef: _types.SortCombinations

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class SortCombinations implements TaggedUnion<SortCombinations.Kind, Object>, PlainJsonSerializable {
    /**
     * {@link SortCombinations} variant kinds.
     */
    public enum Kind {
        Field,
        FieldWithDirection,
        FieldWithOrder,
        Options
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

    private SortCombinations(Kind kind, Object value) {
        this._kind = kind;
        this._value = value;
    }

    private SortCombinations(Builder builder) {
        this._kind = ApiTypeHelper.requireNonNull(builder._kind, builder, "<variant kind>");
        this._value = ApiTypeHelper.requireNonNull(builder._value, builder, "<variant value>");
    }

    public static SortCombinations of(Function<SortCombinations.Builder, ObjectBuilder<SortCombinations>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Is this variant instance of kind {@code field}?
     */
    public boolean isField() {
        return _kind == Kind.Field;
    }

    /**
     * Get the {@code field} variant value.
     *
     * @throws IllegalStateException if the current variant is not the {@code field} kind.
     */
    public String field() {
        return TaggedUnionUtils.get(this, Kind.Field);
    }

    /**
     * Is this variant instance of kind {@code field_with_direction}?
     */
    public boolean isFieldWithDirection() {
        return _kind == Kind.FieldWithDirection;
    }

    /**
     * Get the {@code field_with_direction} variant value.
     *
     * @throws IllegalStateException if the current variant is not the {@code field_with_direction} kind.
     */
    public Map<String, SortOrder> fieldWithDirection() {
        return TaggedUnionUtils.get(this, Kind.FieldWithDirection);
    }

    /**
     * Is this variant instance of kind {@code field_with_order}?
     */
    public boolean isFieldWithOrder() {
        return _kind == Kind.FieldWithOrder;
    }

    /**
     * Get the {@code field_with_order} variant value.
     *
     * @throws IllegalStateException if the current variant is not the {@code field_with_order} kind.
     */
    public Map<String, FieldSort> fieldWithOrder() {
        return TaggedUnionUtils.get(this, Kind.FieldWithOrder);
    }

    /**
     * Is this variant instance of kind {@code options}?
     */
    public boolean isOptions() {
        return _kind == Kind.Options;
    }

    /**
     * Get the {@code options} variant value.
     *
     * @throws IllegalStateException if the current variant is not the {@code options} kind.
     */
    public SortOptions options() {
        return TaggedUnionUtils.get(this, Kind.Options);
    }

    @Override
    public void serialize(JsonGenerator generator, JsonpMapper mapper) {
        if (_value instanceof JsonpSerializable) {
            ((JsonpSerializable) _value).serialize(generator, mapper);
        } else {
            switch (_kind) {
                case Field:
                    generator.write(((String) this._value));
                    break;
                case FieldWithDirection:
                    generator.writeStartObject();
                    for (Map.Entry<String, SortOrder> item0 : ((Map<String, SortOrder>) this._value).entrySet()) {
                        generator.writeKey(item0.getKey());
                        item0.getValue().serialize(generator, mapper);
                    }
                    generator.writeEnd();
                    break;
                case FieldWithOrder:
                    generator.writeStartObject();
                    for (Map.Entry<String, FieldSort> item0 : ((Map<String, FieldSort>) this._value).entrySet()) {
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

    public static class Builder extends ObjectBuilderBase implements ObjectBuilder<SortCombinations> {
        private Kind _kind;
        private Object _value;

        public Builder() {}

        private Builder(SortCombinations o) {
            this._kind = o._kind;
            this._value = o._value;
        }

        public ObjectBuilder<SortCombinations> field(String v) {
            this._kind = Kind.Field;
            this._value = v;
            return this;
        }

        public ObjectBuilder<SortCombinations> fieldWithDirection(Map<String, SortOrder> v) {
            this._kind = Kind.FieldWithDirection;
            this._value = v;
            return this;
        }

        public ObjectBuilder<SortCombinations> fieldWithOrder(Map<String, FieldSort> v) {
            this._kind = Kind.FieldWithOrder;
            this._value = v;
            return this;
        }

        public ObjectBuilder<SortCombinations> options(SortOptions v) {
            this._kind = Kind.Options;
            this._value = v;
            return this;
        }

        public ObjectBuilder<SortCombinations> options(Function<SortOptions.Builder, ObjectBuilder<SortOptions>> fn) {
            return this.options(fn.apply(new SortOptions.Builder()).build());
        }

        @Override
        public SortCombinations build() {
            _checkSingleUse();
            return new SortCombinations(this);
        }
    }

    private static JsonpDeserializer<SortCombinations> buildSortCombinationsDeserializer() {
        return new UnionDeserializer.Builder<SortCombinations, Kind, Object>(SortCombinations::new, false).addMember(
            Kind.Field,
            JsonpDeserializer.stringDeserializer()
        )
            .addMember(Kind.FieldWithDirection, JsonpDeserializer.stringMapDeserializer(SortOrder._DESERIALIZER))
            .addMember(Kind.FieldWithOrder, JsonpDeserializer.stringMapDeserializer(FieldSort._DESERIALIZER))
            .addMember(Kind.Options, SortOptions._DESERIALIZER)
            .build();
    }

    public static final JsonpDeserializer<SortCombinations> _DESERIALIZER = JsonpDeserializer.lazy(
        SortCombinations::buildSortCombinationsDeserializer
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
        SortCombinations other = (SortCombinations) o;
        return Objects.equals(this._kind, other._kind) && Objects.equals(this._value, other._value);
    }
}
