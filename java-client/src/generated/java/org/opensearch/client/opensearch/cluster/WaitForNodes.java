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

package org.opensearch.client.opensearch.cluster;

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

// typedef: cluster.WaitForNodes

/**
 * Waits until the specified number of nodes (<code>N</code>) is available. Accepts <code>&gt;=N</code>, <code>&lt;=N</code>,
 * <code>&gt;N</code>, and <code>&lt;N</code>. You can also use <code>ge(N)</code>, <code>le(N)</code>, <code>gt(N)</code>, and
 * <code>lt(N)</code> notation.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class WaitForNodes implements TaggedUnion<WaitForNodes.Kind, Object>, PlainJsonSerializable {
    /**
     * {@link WaitForNodes} variant kinds.
     */
    public enum Kind {
        Comparison,
        Count
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

    private WaitForNodes(Kind kind, Object value) {
        this._kind = kind;
        this._value = value;
    }

    private WaitForNodes(Builder builder) {
        this._kind = ApiTypeHelper.requireNonNull(builder._kind, builder, "<variant kind>");
        this._value = ApiTypeHelper.requireNonNull(builder._value, builder, "<variant value>");
    }

    public static WaitForNodes of(Function<WaitForNodes.Builder, ObjectBuilder<WaitForNodes>> fn) {
        return fn.apply(new Builder()).build();
    }

    public String _toJsonString() {
        switch (_kind) {
            case Comparison:
                return this.comparison();
            case Count:
                return String.valueOf(this.count());
            default:
                throw new IllegalStateException("Unknown kind " + _kind);
        }
    }

    /**
     * Is this variant instance of kind {@code comparison}?
     */
    public boolean isComparison() {
        return _kind == Kind.Comparison;
    }

    /**
     * Get the {@code comparison} variant value.
     *
     * @throws IllegalStateException if the current variant is not the {@code comparison} kind.
     */
    public String comparison() {
        return TaggedUnionUtils.get(this, Kind.Comparison);
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

    @Override
    public void serialize(JsonGenerator generator, JsonpMapper mapper) {
        if (_value instanceof JsonpSerializable) {
            ((JsonpSerializable) _value).serialize(generator, mapper);
        } else {
            switch (_kind) {
                case Comparison:
                    generator.write(((String) this._value));
                    break;
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

    public static class Builder extends ObjectBuilderBase implements ObjectBuilder<WaitForNodes> {
        private Kind _kind;
        private Object _value;

        public Builder() {}

        private Builder(WaitForNodes o) {
            this._kind = o._kind;
            this._value = o._value;
        }

        public ObjectBuilder<WaitForNodes> comparison(String v) {
            this._kind = Kind.Comparison;
            this._value = v;
            return this;
        }

        public ObjectBuilder<WaitForNodes> count(Integer v) {
            this._kind = Kind.Count;
            this._value = v;
            return this;
        }

        @Override
        public WaitForNodes build() {
            _checkSingleUse();
            return new WaitForNodes(this);
        }
    }

    private static JsonpDeserializer<WaitForNodes> buildWaitForNodesDeserializer() {
        return new UnionDeserializer.Builder<WaitForNodes, Kind, Object>(WaitForNodes::new, false).addMember(
            Kind.Comparison,
            JsonpDeserializer.stringDeserializer()
        ).addMember(Kind.Count, JsonpDeserializer.integerDeserializer()).build();
    }

    public static final JsonpDeserializer<WaitForNodes> _DESERIALIZER = JsonpDeserializer.lazy(WaitForNodes::buildWaitForNodesDeserializer);

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
        WaitForNodes other = (WaitForNodes) o;
        return Objects.equals(this._kind, other._kind) && Objects.equals(this._value, other._value);
    }
}
