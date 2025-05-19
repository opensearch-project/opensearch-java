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

package org.opensearch.client.opensearch.core.search;

import jakarta.json.stream.JsonGenerator;
import java.util.List;
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

// typedef: core.search.SourceConfigParam

/**
 * Defines how to fetch a source. Fetching can be disabled entirely, or the source can be filtered. Use this setting with the
 * <code>_source_includes</code> and <code>_source_excludes</code> parameters.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class SourceConfigParam implements TaggedUnion<SourceConfigParam.Kind, Object>, PlainJsonSerializable {
    /**
     * {@link SourceConfigParam} variant kinds.
     */
    public enum Kind {
        Fetch,
        Fields
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

    private SourceConfigParam(Kind kind, Object value) {
        this._kind = kind;
        this._value = value;
    }

    private SourceConfigParam(Builder builder) {
        this._kind = ApiTypeHelper.requireNonNull(builder._kind, builder, "<variant kind>");
        this._value = ApiTypeHelper.requireNonNull(builder._value, builder, "<variant value>");
    }

    public static SourceConfigParam of(Function<SourceConfigParam.Builder, ObjectBuilder<SourceConfigParam>> fn) {
        return fn.apply(new Builder()).build();
    }

    public String _toJsonString() {
        switch (_kind) {
            case Fetch:
                return String.valueOf(this.fetch());
            case Fields:
                return String.join(",", this.fields());
            default:
                throw new IllegalStateException("Unknown kind " + _kind);
        }
    }

    /**
     * Is this variant instance of kind {@code fetch}?
     */
    public boolean isFetch() {
        return _kind == Kind.Fetch;
    }

    /**
     * Get the {@code fetch} variant value.
     *
     * @throws IllegalStateException if the current variant is not the {@code fetch} kind.
     */
    public Boolean fetch() {
        return TaggedUnionUtils.get(this, Kind.Fetch);
    }

    /**
     * Is this variant instance of kind {@code fields}?
     */
    public boolean isFields() {
        return _kind == Kind.Fields;
    }

    /**
     * Get the {@code fields} variant value.
     *
     * @throws IllegalStateException if the current variant is not the {@code fields} kind.
     */
    public List<String> fields() {
        return TaggedUnionUtils.get(this, Kind.Fields);
    }

    @Override
    public void serialize(JsonGenerator generator, JsonpMapper mapper) {
        if (_value instanceof JsonpSerializable) {
            ((JsonpSerializable) _value).serialize(generator, mapper);
        } else {
            switch (_kind) {
                case Fetch:
                    generator.write(((Boolean) this._value));
                    break;
                case Fields:
                    generator.writeStartArray();
                    for (String item0 : ((List<String>) this._value)) {
                        generator.write(item0);
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

    public static class Builder extends ObjectBuilderBase implements ObjectBuilder<SourceConfigParam> {
        private Kind _kind;
        private Object _value;

        public Builder() {}

        private Builder(SourceConfigParam o) {
            this._kind = o._kind;
            this._value = o._value;
        }

        public ObjectBuilder<SourceConfigParam> fetch(Boolean v) {
            this._kind = Kind.Fetch;
            this._value = v;
            return this;
        }

        public ObjectBuilder<SourceConfigParam> fields(List<String> v) {
            this._kind = Kind.Fields;
            this._value = v;
            return this;
        }

        @Override
        public SourceConfigParam build() {
            _checkSingleUse();
            return new SourceConfigParam(this);
        }
    }

    private static JsonpDeserializer<SourceConfigParam> buildSourceConfigParamDeserializer() {
        return new UnionDeserializer.Builder<SourceConfigParam, Kind, Object>(SourceConfigParam::new, false).addMember(
            Kind.Fetch,
            JsonpDeserializer.booleanDeserializer()
        ).addMember(Kind.Fields, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer())).build();
    }

    public static final JsonpDeserializer<SourceConfigParam> _DESERIALIZER = JsonpDeserializer.lazy(
        SourceConfigParam::buildSourceConfigParamDeserializer
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
        SourceConfigParam other = (SourceConfigParam) o;
        return Objects.equals(this._kind, other._kind) && Objects.equals(this._value, other._value);
    }
}
