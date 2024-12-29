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

package org.opensearch.client.opensearch.nodes.reload_secure_settings;

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

// typedef: nodes.reload_secure_settings.NodeReloadResult

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class NodeReloadResult implements TaggedUnion<NodeReloadResult.Kind, Object>, PlainJsonSerializable {
    /**
     * {@link NodeReloadResult} variant kinds.
     */
    public enum Kind {
        Error,
        Success
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

    private NodeReloadResult(Kind kind, Object value) {
        this._kind = kind;
        this._value = value;
    }

    private NodeReloadResult(Builder builder) {
        this._kind = ApiTypeHelper.requireNonNull(builder._kind, builder, "<variant kind>");
        this._value = ApiTypeHelper.requireNonNull(builder._value, builder, "<variant value>");
    }

    public static NodeReloadResult of(Function<NodeReloadResult.Builder, ObjectBuilder<NodeReloadResult>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Is this variant instance of kind {@code error}?
     */
    public boolean isError() {
        return _kind == Kind.Error;
    }

    /**
     * Get the {@code error} variant value.
     *
     * @throws IllegalStateException if the current variant is not the {@code error} kind.
     */
    public NodeReloadError error() {
        return TaggedUnionUtils.get(this, Kind.Error);
    }

    /**
     * Is this variant instance of kind {@code success}?
     */
    public boolean isSuccess() {
        return _kind == Kind.Success;
    }

    /**
     * Get the {@code success} variant value.
     *
     * @throws IllegalStateException if the current variant is not the {@code success} kind.
     */
    public NodeReloadSuccess success() {
        return TaggedUnionUtils.get(this, Kind.Success);
    }

    @Override
    public void serialize(JsonGenerator generator, JsonpMapper mapper) {
        if (_value instanceof JsonpSerializable) {
            ((JsonpSerializable) _value).serialize(generator, mapper);
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

    public static class Builder extends ObjectBuilderBase implements ObjectBuilder<NodeReloadResult> {
        private Kind _kind;
        private Object _value;

        public Builder() {}

        private Builder(NodeReloadResult o) {
            this._kind = o._kind;
            this._value = o._value;
        }

        public ObjectBuilder<NodeReloadResult> error(NodeReloadError v) {
            this._kind = Kind.Error;
            this._value = v;
            return this;
        }

        public ObjectBuilder<NodeReloadResult> error(Function<NodeReloadError.Builder, ObjectBuilder<NodeReloadError>> fn) {
            return this.error(fn.apply(new NodeReloadError.Builder()).build());
        }

        public ObjectBuilder<NodeReloadResult> success(NodeReloadSuccess v) {
            this._kind = Kind.Success;
            this._value = v;
            return this;
        }

        public ObjectBuilder<NodeReloadResult> success(Function<NodeReloadSuccess.Builder, ObjectBuilder<NodeReloadSuccess>> fn) {
            return this.success(fn.apply(new NodeReloadSuccess.Builder()).build());
        }

        @Override
        public NodeReloadResult build() {
            _checkSingleUse();
            return new NodeReloadResult(this);
        }
    }

    private static JsonpDeserializer<NodeReloadResult> buildNodeReloadResultDeserializer() {
        return new UnionDeserializer.Builder<NodeReloadResult, Kind, Object>(NodeReloadResult::new, false).addMember(
            Kind.Error,
            NodeReloadError._DESERIALIZER
        ).addMember(Kind.Success, NodeReloadSuccess._DESERIALIZER).build();
    }

    public static final JsonpDeserializer<NodeReloadResult> _DESERIALIZER = JsonpDeserializer.lazy(
        NodeReloadResult::buildNodeReloadResultDeserializer
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
        NodeReloadResult other = (NodeReloadResult) o;
        return Objects.equals(this._kind, other._kind) && Objects.equals(this._value, other._value);
    }
}
