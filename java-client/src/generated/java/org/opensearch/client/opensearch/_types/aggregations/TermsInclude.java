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

// typedef: _types.aggregations.TermsInclude

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class TermsInclude implements TaggedUnion<TermsInclude.Kind, Object>, PlainJsonSerializable {
    /**
     * {@link TermsInclude} variant kinds.
     */
    public enum Kind {
        Partition,
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

    private TermsInclude(Kind kind, Object value) {
        this._kind = kind;
        this._value = value;
    }

    private TermsInclude(Builder builder) {
        this._kind = ApiTypeHelper.requireNonNull(builder._kind, builder, "<variant kind>");
        this._value = ApiTypeHelper.requireNonNull(builder._value, builder, "<variant value>");
    }

    public static TermsInclude of(Function<TermsInclude.Builder, ObjectBuilder<TermsInclude>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Is this variant instance of kind {@code partition}?
     */
    public boolean isPartition() {
        return _kind == Kind.Partition;
    }

    /**
     * Get the {@code partition} variant value.
     *
     * @throws IllegalStateException if the current variant is not the {@code partition} kind.
     */
    public TermsPartition partition() {
        return TaggedUnionUtils.get(this, Kind.Partition);
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

    public static class Builder extends ObjectBuilderBase implements ObjectBuilder<TermsInclude> {
        private Kind _kind;
        private Object _value;

        public Builder() {}

        private Builder(TermsInclude o) {
            this._kind = o._kind;
            this._value = o._value;
        }

        public ObjectBuilder<TermsInclude> partition(TermsPartition v) {
            this._kind = Kind.Partition;
            this._value = v;
            return this;
        }

        public ObjectBuilder<TermsInclude> partition(Function<TermsPartition.Builder, ObjectBuilder<TermsPartition>> fn) {
            return this.partition(fn.apply(new TermsPartition.Builder()).build());
        }

        public ObjectBuilder<TermsInclude> regexp(String v) {
            this._kind = Kind.Regexp;
            this._value = v;
            return this;
        }

        public ObjectBuilder<TermsInclude> terms(List<String> v) {
            this._kind = Kind.Terms;
            this._value = v;
            return this;
        }

        @Override
        public TermsInclude build() {
            _checkSingleUse();
            return new TermsInclude(this);
        }
    }

    private static JsonpDeserializer<TermsInclude> buildTermsIncludeDeserializer() {
        return new UnionDeserializer.Builder<TermsInclude, Kind, Object>(TermsInclude::new, false).addMember(
            Kind.Partition,
            TermsPartition._DESERIALIZER
        )
            .addMember(Kind.Regexp, JsonpDeserializer.stringDeserializer())
            .addMember(Kind.Terms, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()))
            .build();
    }

    public static final JsonpDeserializer<TermsInclude> _DESERIALIZER = JsonpDeserializer.lazy(TermsInclude::buildTermsIncludeDeserializer);

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
        TermsInclude other = (TermsInclude) o;
        return Objects.equals(this._kind, other._kind) && Objects.equals(this._value, other._value);
    }
}
