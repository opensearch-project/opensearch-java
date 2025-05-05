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

package org.opensearch.client.opensearch.nodes.info;

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

// typedef: nodes.info.NodeInfoSettingsTransportType

/**
 * The transport layer type configuration.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class NodeInfoSettingsTransportType implements TaggedUnion<NodeInfoSettingsTransportType.Kind, Object>, PlainJsonSerializable {
    /**
     * {@link NodeInfoSettingsTransportType} variant kinds.
     */
    public enum Kind {
        Config,
        Type
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

    private NodeInfoSettingsTransportType(Kind kind, Object value) {
        this._kind = kind;
        this._value = value;
    }

    private NodeInfoSettingsTransportType(Builder builder) {
        this._kind = ApiTypeHelper.requireNonNull(builder._kind, builder, "<variant kind>");
        this._value = ApiTypeHelper.requireNonNull(builder._value, builder, "<variant value>");
    }

    public static NodeInfoSettingsTransportType of(
        Function<NodeInfoSettingsTransportType.Builder, ObjectBuilder<NodeInfoSettingsTransportType>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Is this variant instance of kind {@code config}?
     */
    public boolean isConfig() {
        return _kind == Kind.Config;
    }

    /**
     * Get the {@code config} variant value.
     *
     * @throws IllegalStateException if the current variant is not the {@code config} kind.
     */
    public NodeInfoSettingsTransportTypeConfig config() {
        return TaggedUnionUtils.get(this, Kind.Config);
    }

    /**
     * Is this variant instance of kind {@code type}?
     */
    public boolean isType() {
        return _kind == Kind.Type;
    }

    /**
     * Get the {@code type} variant value.
     *
     * @throws IllegalStateException if the current variant is not the {@code type} kind.
     */
    public String type() {
        return TaggedUnionUtils.get(this, Kind.Type);
    }

    @Override
    public void serialize(JsonGenerator generator, JsonpMapper mapper) {
        if (_value instanceof JsonpSerializable) {
            ((JsonpSerializable) _value).serialize(generator, mapper);
        } else {
            switch (_kind) {
                case Type:
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

    public static class Builder extends ObjectBuilderBase implements ObjectBuilder<NodeInfoSettingsTransportType> {
        private Kind _kind;
        private Object _value;

        public Builder() {}

        private Builder(NodeInfoSettingsTransportType o) {
            this._kind = o._kind;
            this._value = o._value;
        }

        public ObjectBuilder<NodeInfoSettingsTransportType> config(NodeInfoSettingsTransportTypeConfig v) {
            this._kind = Kind.Config;
            this._value = v;
            return this;
        }

        public ObjectBuilder<NodeInfoSettingsTransportType> config(
            Function<NodeInfoSettingsTransportTypeConfig.Builder, ObjectBuilder<NodeInfoSettingsTransportTypeConfig>> fn
        ) {
            return this.config(fn.apply(new NodeInfoSettingsTransportTypeConfig.Builder()).build());
        }

        public ObjectBuilder<NodeInfoSettingsTransportType> type(String v) {
            this._kind = Kind.Type;
            this._value = v;
            return this;
        }

        @Override
        public NodeInfoSettingsTransportType build() {
            _checkSingleUse();
            return new NodeInfoSettingsTransportType(this);
        }
    }

    private static JsonpDeserializer<NodeInfoSettingsTransportType> buildNodeInfoSettingsTransportTypeDeserializer() {
        return new UnionDeserializer.Builder<NodeInfoSettingsTransportType, Kind, Object>(NodeInfoSettingsTransportType::new, false)
            .addMember(Kind.Config, NodeInfoSettingsTransportTypeConfig._DESERIALIZER)
            .addMember(Kind.Type, JsonpDeserializer.stringDeserializer())
            .build();
    }

    public static final JsonpDeserializer<NodeInfoSettingsTransportType> _DESERIALIZER = JsonpDeserializer.lazy(
        NodeInfoSettingsTransportType::buildNodeInfoSettingsTransportTypeDeserializer
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
        NodeInfoSettingsTransportType other = (NodeInfoSettingsTransportType) o;
        return Objects.equals(this._kind, other._kind) && Objects.equals(this._value, other._value);
    }
}
