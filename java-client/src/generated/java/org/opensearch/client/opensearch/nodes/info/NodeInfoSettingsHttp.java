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
import javax.annotation.Nullable;
import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.json.PlainJsonSerializable;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: nodes.info.NodeInfoSettingsHttp

/**
 * The HTTP server configuration.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class NodeInfoSettingsHttp implements PlainJsonSerializable, ToCopyableBuilder<NodeInfoSettingsHttp.Builder, NodeInfoSettingsHttp> {

    @Nullable
    private final Boolean compression;

    @Nullable
    private final Integer port;

    @Nonnull
    private final NodeInfoSettingsHttpType type;

    @Nullable
    private final String typeDefault;

    // ---------------------------------------------------------------------------------------------

    private NodeInfoSettingsHttp(Builder builder) {
        this.compression = builder.compression;
        this.port = builder.port;
        this.type = ApiTypeHelper.requireNonNull(builder.type, this, "type");
        this.typeDefault = builder.typeDefault;
    }

    public static NodeInfoSettingsHttp of(Function<NodeInfoSettingsHttp.Builder, ObjectBuilder<NodeInfoSettingsHttp>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code compression}
     */
    @Nullable
    public final Boolean compression() {
        return this.compression;
    }

    /**
     * API name: {@code port}
     */
    @Nullable
    public final Integer port() {
        return this.port;
    }

    /**
     * Required - API name: {@code type}
     */
    @Nonnull
    public final NodeInfoSettingsHttpType type() {
        return this.type;
    }

    /**
     * The default HTTP server type.
     * <p>
     * API name: {@code type.default}
     * </p>
     */
    @Nullable
    public final String typeDefault() {
        return this.typeDefault;
    }

    /**
     * Serialize this object to JSON.
     */
    @Override
    public void serialize(JsonGenerator generator, JsonpMapper mapper) {
        generator.writeStartObject();
        serializeInternal(generator, mapper);
        generator.writeEnd();
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        if (this.compression != null) {
            generator.writeKey("compression");
            generator.write(this.compression);
        }

        if (this.port != null) {
            generator.writeKey("port");
            generator.write(this.port);
        }

        generator.writeKey("type");
        this.type.serialize(generator, mapper);

        if (this.typeDefault != null) {
            generator.writeKey("type.default");
            generator.write(this.typeDefault);
        }
    }

    // ---------------------------------------------------------------------------------------------

    @Override
    @Nonnull
    public Builder toBuilder() {
        return new Builder(this);
    }

    @Nonnull
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Builder for {@link NodeInfoSettingsHttp}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, NodeInfoSettingsHttp> {
        @Nullable
        private Boolean compression;
        @Nullable
        private Integer port;
        private NodeInfoSettingsHttpType type;
        @Nullable
        private String typeDefault;

        public Builder() {}

        private Builder(NodeInfoSettingsHttp o) {
            this.compression = o.compression;
            this.port = o.port;
            this.type = o.type;
            this.typeDefault = o.typeDefault;
        }

        private Builder(Builder o) {
            this.compression = o.compression;
            this.port = o.port;
            this.type = o.type;
            this.typeDefault = o.typeDefault;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code compression}
         */
        @Nonnull
        public final Builder compression(@Nullable Boolean value) {
            this.compression = value;
            return this;
        }

        /**
         * API name: {@code port}
         */
        @Nonnull
        public final Builder port(@Nullable Integer value) {
            this.port = value;
            return this;
        }

        /**
         * Required - API name: {@code type}
         */
        @Nonnull
        public final Builder type(NodeInfoSettingsHttpType value) {
            this.type = value;
            return this;
        }

        /**
         * Required - API name: {@code type}
         */
        @Nonnull
        public final Builder type(Function<NodeInfoSettingsHttpType.Builder, ObjectBuilder<NodeInfoSettingsHttpType>> fn) {
            return type(fn.apply(new NodeInfoSettingsHttpType.Builder()).build());
        }

        /**
         * The default HTTP server type.
         * <p>
         * API name: {@code type.default}
         * </p>
         */
        @Nonnull
        public final Builder typeDefault(@Nullable String value) {
            this.typeDefault = value;
            return this;
        }

        /**
         * Builds a {@link NodeInfoSettingsHttp}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public NodeInfoSettingsHttp build() {
            _checkSingleUse();

            return new NodeInfoSettingsHttp(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link NodeInfoSettingsHttp}
     */
    public static final JsonpDeserializer<NodeInfoSettingsHttp> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        NodeInfoSettingsHttp::setupNodeInfoSettingsHttpDeserializer
    );

    protected static void setupNodeInfoSettingsHttpDeserializer(ObjectDeserializer<NodeInfoSettingsHttp.Builder> op) {
        op.add(Builder::compression, JsonpDeserializer.booleanDeserializer(), "compression");
        op.add(Builder::port, JsonpDeserializer.integerDeserializer(), "port");
        op.add(Builder::type, NodeInfoSettingsHttpType._DESERIALIZER, "type");
        op.add(Builder::typeDefault, JsonpDeserializer.stringDeserializer(), "type.default");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.compression);
        result = 31 * result + Objects.hashCode(this.port);
        result = 31 * result + this.type.hashCode();
        result = 31 * result + Objects.hashCode(this.typeDefault);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        NodeInfoSettingsHttp other = (NodeInfoSettingsHttp) o;
        return Objects.equals(this.compression, other.compression)
            && Objects.equals(this.port, other.port)
            && this.type.equals(other.type)
            && Objects.equals(this.typeDefault, other.typeDefault);
    }
}
