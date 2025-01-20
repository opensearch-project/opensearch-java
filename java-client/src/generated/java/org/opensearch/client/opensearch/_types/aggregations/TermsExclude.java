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

// typedef: _types.aggregations.TermsExclude

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class TermsExclude implements TaggedUnion<TermsExclude.Kind, Object>, PlainJsonSerializable {
    /**
     * {@link TermsExclude} variant kinds.
     */
    public enum Kind {
        Regexp,
        Terms
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

    private TermsExclude(Kind kind, Object value) {
        this._kind = kind;
        this._value = value;
    }

    private TermsExclude(Builder builder) {
        this._kind = ApiTypeHelper.requireNonNull(builder._kind, builder, "<variant kind>");
        this._value = ApiTypeHelper.requireNonNull(builder._value, builder, "<variant value>");
    }

    public static TermsExclude of(Function<TermsExclude.Builder, ObjectBuilder<TermsExclude>> fn) {
        return fn.apply(new Builder()).build();
    }

    public String _toJsonString() {
        switch (_kind) {
            case Regexp:
                return this.regexp();
            case Terms:
                return String.join(",", this.terms());
            default:
                throw new IllegalStateException("Unknown kind " + _kind);
        }
    }

    /**
     * Is this variant instance of kind {@code regexp}?
     */
    public boolean isRegexp() {
        return _kind == Kind.Regexp;
    }

    /**
     * Get the {@code regexp} variant value.
     *
     * @throws IllegalStateException if the current variant is not the {@code regexp} kind.
     */
    public String regexp() {
        return TaggedUnionUtils.get(this, Kind.Regexp);
    }

    /**
     * Is this variant instance of kind {@code terms}?
     */
    public boolean isTerms() {
        return _kind == Kind.Terms;
    }

    /**
     * Get the {@code terms} variant value.
     *
     * @throws IllegalStateException if the current variant is not the {@code terms} kind.
     */
    public List<String> terms() {
        return TaggedUnionUtils.get(this, Kind.Terms);
    }

    @Override
    public void serialize(JsonGenerator generator, JsonpMapper mapper) {
        if (_value instanceof JsonpSerializable) {
            ((JsonpSerializable) _value).serialize(generator, mapper);
        } else {
            switch (_kind) {
                case Regexp:
                    generator.write(((String) this._value));
                    break;
                case Terms:
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

    public static class Builder extends ObjectBuilderBase implements ObjectBuilder<TermsExclude> {
        private Kind _kind;
        private Object _value;

        public Builder() {}

        private Builder(TermsExclude o) {
            this._kind = o._kind;
            this._value = o._value;
        }

        public ObjectBuilder<TermsExclude> regexp(String v) {
            this._kind = Kind.Regexp;
            this._value = v;
            return this;
        }

        public ObjectBuilder<TermsExclude> terms(List<String> v) {
            this._kind = Kind.Terms;
            this._value = v;
            return this;
        }

        @Override
        public TermsExclude build() {
            _checkSingleUse();
            return new TermsExclude(this);
        }
    }

    private static JsonpDeserializer<TermsExclude> buildTermsExcludeDeserializer() {
        return new UnionDeserializer.Builder<TermsExclude, Kind, Object>(TermsExclude::new, false).addMember(
            Kind.Regexp,
            JsonpDeserializer.stringDeserializer()
        ).addMember(Kind.Terms, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer())).build();
    }

    public static final JsonpDeserializer<TermsExclude> _DESERIALIZER = JsonpDeserializer.lazy(TermsExclude::buildTermsExcludeDeserializer);

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
        TermsExclude other = (TermsExclude) o;
        return Objects.equals(this._kind, other._kind) && Objects.equals(this._value, other._value);
    }
}
