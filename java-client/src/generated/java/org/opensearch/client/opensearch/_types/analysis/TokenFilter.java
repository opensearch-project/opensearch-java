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

package org.opensearch.client.opensearch._types.analysis;

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

// typedef: _types.analysis.TokenFilter

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class TokenFilter implements TaggedUnion<TokenFilter.Kind, Object>, PlainJsonSerializable {
    /**
     * {@link TokenFilter} variant kinds.
     */
    public enum Kind {
        Definition,
        Name
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

    private TokenFilter(Kind kind, Object value) {
        this._kind = kind;
        this._value = value;
    }

    private TokenFilter(Builder builder) {
        this._kind = ApiTypeHelper.requireNonNull(builder._kind, builder, "<variant kind>");
        this._value = ApiTypeHelper.requireNonNull(builder._value, builder, "<variant value>");
    }

    public static TokenFilter of(Function<TokenFilter.Builder, ObjectBuilder<TokenFilter>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Is this variant instance of kind {@code definition}?
     */
    public boolean isDefinition() {
        return _kind == Kind.Definition;
    }

    /**
     * Get the {@code definition} variant value.
     *
     * @throws IllegalStateException if the current variant is not the {@code definition} kind.
     */
    public TokenFilterDefinition definition() {
        return TaggedUnionUtils.get(this, Kind.Definition);
    }

    /**
     * Is this variant instance of kind {@code name}?
     */
    public boolean isName() {
        return _kind == Kind.Name;
    }

    /**
     * Get the {@code name} variant value.
     *
     * @throws IllegalStateException if the current variant is not the {@code name} kind.
     */
    public String name() {
        return TaggedUnionUtils.get(this, Kind.Name);
    }

    @Override
    public void serialize(JsonGenerator generator, JsonpMapper mapper) {
        if (_value instanceof JsonpSerializable) {
            ((JsonpSerializable) _value).serialize(generator, mapper);
        } else {
            switch (_kind) {
                case Name:
                    generator.write(((String) this._value));
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

    public static class Builder extends ObjectBuilderBase implements ObjectBuilder<TokenFilter> {
        private Kind _kind;
        private Object _value;

        public Builder() {}

        private Builder(TokenFilter o) {
            this._kind = o._kind;
            this._value = o._value;
        }

        public ObjectBuilder<TokenFilter> definition(TokenFilterDefinition v) {
            this._kind = Kind.Definition;
            this._value = v;
            return this;
        }

        public ObjectBuilder<TokenFilter> definition(Function<TokenFilterDefinition.Builder, ObjectBuilder<TokenFilterDefinition>> fn) {
            return this.definition(fn.apply(new TokenFilterDefinition.Builder()).build());
        }

        public ObjectBuilder<TokenFilter> name(String v) {
            this._kind = Kind.Name;
            this._value = v;
            return this;
        }

        @Override
        public TokenFilter build() {
            _checkSingleUse();
            return new TokenFilter(this);
        }
    }

    private static JsonpDeserializer<TokenFilter> buildTokenFilterDeserializer() {
        return new UnionDeserializer.Builder<TokenFilter, Kind, Object>(TokenFilter::new, false).addMember(
            Kind.Definition,
            TokenFilterDefinition._DESERIALIZER
        ).addMember(Kind.Name, JsonpDeserializer.stringDeserializer()).build();
    }

    public static final JsonpDeserializer<TokenFilter> _DESERIALIZER = JsonpDeserializer.lazy(TokenFilter::buildTokenFilterDeserializer);

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
        TokenFilter other = (TokenFilter) o;
        return Objects.equals(this._kind, other._kind) && Objects.equals(this._value, other._value);
    }
}
