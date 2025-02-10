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

// typedef: _types.WaitForActiveShards

/**
 * Waits until the specified number of shards is active before returning a response. Use <code>all</code> for all shards.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class WaitForActiveShards implements TaggedUnion<WaitForActiveShards.Kind, Object>, PlainJsonSerializable {
    /**
     * {@link WaitForActiveShards} variant kinds.
     */
    public enum Kind {
        Count,
        Option
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

    private WaitForActiveShards(Kind kind, Object value) {
        this._kind = kind;
        this._value = value;
    }

    private WaitForActiveShards(Builder builder) {
        this._kind = ApiTypeHelper.requireNonNull(builder._kind, builder, "<variant kind>");
        this._value = ApiTypeHelper.requireNonNull(builder._value, builder, "<variant value>");
    }

    public static WaitForActiveShards of(Function<WaitForActiveShards.Builder, ObjectBuilder<WaitForActiveShards>> fn) {
        return fn.apply(new Builder()).build();
    }

    public String _toJsonString() {
        switch (_kind) {
            case Count:
                return String.valueOf(this.count());
            case Option:
                return this.option().jsonValue();
            default:
                throw new IllegalStateException("Unknown kind " + _kind);
        }
    }

    /**
     * Is this variant instance of kind {@code count}?
     */
    public boolean isCount() {
        return _kind == Kind.Count;
    }

    /**
     * Get the {@code count} variant value.
     *
     * @throws IllegalStateException if the current variant is not the {@code count} kind.
     */
    public Integer count() {
        return TaggedUnionUtils.get(this, Kind.Count);
    }

    /**
     * Is this variant instance of kind {@code option}?
     */
    public boolean isOption() {
        return _kind == Kind.Option;
    }

    /**
     * Get the {@code option} variant value.
     *
     * @throws IllegalStateException if the current variant is not the {@code option} kind.
     */
    public WaitForActiveShardOptions option() {
        return TaggedUnionUtils.get(this, Kind.Option);
    }

    @Override
    public void serialize(JsonGenerator generator, JsonpMapper mapper) {
        if (_value instanceof JsonpSerializable) {
            ((JsonpSerializable) _value).serialize(generator, mapper);
        } else {
            switch (_kind) {
                case Count:
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

    public static class Builder extends ObjectBuilderBase implements ObjectBuilder<WaitForActiveShards> {
        private Kind _kind;
        private Object _value;

        public Builder() {}

        private Builder(WaitForActiveShards o) {
            this._kind = o._kind;
            this._value = o._value;
        }

        public ObjectBuilder<WaitForActiveShards> count(Integer v) {
            this._kind = Kind.Count;
            this._value = v;
            return this;
        }

        public ObjectBuilder<WaitForActiveShards> option(WaitForActiveShardOptions v) {
            this._kind = Kind.Option;
            this._value = v;
            return this;
        }

        @Override
        public WaitForActiveShards build() {
            _checkSingleUse();
            return new WaitForActiveShards(this);
        }
    }

    private static JsonpDeserializer<WaitForActiveShards> buildWaitForActiveShardsDeserializer() {
        return new UnionDeserializer.Builder<WaitForActiveShards, Kind, Object>(WaitForActiveShards::new, false).addMember(
            Kind.Count,
            JsonpDeserializer.integerDeserializer()
        ).addMember(Kind.Option, WaitForActiveShardOptions._DESERIALIZER).build();
    }

    public static final JsonpDeserializer<WaitForActiveShards> _DESERIALIZER = JsonpDeserializer.lazy(
        WaitForActiveShards::buildWaitForActiveShardsDeserializer
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
        WaitForActiveShards other = (WaitForActiveShards) o;
        return Objects.equals(this._kind, other._kind) && Objects.equals(this._value, other._value);
    }
}
