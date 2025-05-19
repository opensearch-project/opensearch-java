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
import org.opensearch.client.opensearch._types.GeoLocation;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.TaggedUnion;
import org.opensearch.client.util.TaggedUnionUtils;

// typedef: core.search.Context

/**
 * Text or location that we want similar documents for or a lookup to a document's field for the text.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class Context implements TaggedUnion<Context.Kind, Object>, PlainJsonSerializable {
    /**
     * {@link Context} variant kinds.
     */
    public enum Kind {
        Category,
        Location
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

    private Context(Kind kind, Object value) {
        this._kind = kind;
        this._value = value;
    }

    private Context(Builder builder) {
        this._kind = ApiTypeHelper.requireNonNull(builder._kind, builder, "<variant kind>");
        this._value = ApiTypeHelper.requireNonNull(builder._value, builder, "<variant value>");
    }

    public static Context of(Function<Context.Builder, ObjectBuilder<Context>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Is this variant instance of kind {@code category}?
     */
    public boolean isCategory() {
        return _kind == Kind.Category;
    }

    /**
     * Get the {@code category} variant value.
     *
     * @throws IllegalStateException if the current variant is not the {@code category} kind.
     */
    public String category() {
        return TaggedUnionUtils.get(this, Kind.Category);
    }

    /**
     * Is this variant instance of kind {@code location}?
     */
    public boolean isLocation() {
        return _kind == Kind.Location;
    }

    /**
     * Get the {@code location} variant value.
     *
     * @throws IllegalStateException if the current variant is not the {@code location} kind.
     */
    public GeoLocation location() {
        return TaggedUnionUtils.get(this, Kind.Location);
    }

    @Override
    public void serialize(JsonGenerator generator, JsonpMapper mapper) {
        if (_value instanceof JsonpSerializable) {
            ((JsonpSerializable) _value).serialize(generator, mapper);
        } else {
            switch (_kind) {
                case Category:
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

    public static class Builder extends ObjectBuilderBase implements ObjectBuilder<Context> {
        private Kind _kind;
        private Object _value;

        public Builder() {}

        private Builder(Context o) {
            this._kind = o._kind;
            this._value = o._value;
        }

        public ObjectBuilder<Context> category(String v) {
            this._kind = Kind.Category;
            this._value = v;
            return this;
        }

        public ObjectBuilder<Context> location(GeoLocation v) {
            this._kind = Kind.Location;
            this._value = v;
            return this;
        }

        public ObjectBuilder<Context> location(Function<GeoLocation.Builder, ObjectBuilder<GeoLocation>> fn) {
            return this.location(fn.apply(new GeoLocation.Builder()).build());
        }

        @Override
        public Context build() {
            _checkSingleUse();
            return new Context(this);
        }
    }

    private static JsonpDeserializer<Context> buildContextDeserializer() {
        return new UnionDeserializer.Builder<Context, Kind, Object>(Context::new, true).addMember(
            Kind.Category,
            JsonpDeserializer.stringDeserializer()
        ).addMember(Kind.Location, GeoLocation._DESERIALIZER).build();
    }

    public static final JsonpDeserializer<Context> _DESERIALIZER = JsonpDeserializer.lazy(Context::buildContextDeserializer);

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
        Context other = (Context) o;
        return Objects.equals(this._kind, other._kind) && Objects.equals(this._value, other._value);
    }
}
