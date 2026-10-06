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
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.opensearch.client.json.JsonData;
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

// typedef: nodes.info.NodeInfoSettingsTransport

/**
 * The transport layer configuration settings.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class NodeInfoSettingsTransport
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<NodeInfoSettingsTransport.Builder, NodeInfoSettingsTransport> {

    @Nonnull
    private final Map<String, JsonData> ssl;

    @Nonnull
    private final NodeInfoSettingsTransportType type;

    @Nullable
    private final String typeDefault;

    // ---------------------------------------------------------------------------------------------

    private NodeInfoSettingsTransport(Builder builder) {
        this.ssl = ApiTypeHelper.unmodifiable(builder.ssl);
        this.type = ApiTypeHelper.requireNonNull(builder.type, this, "type");
        this.typeDefault = builder.typeDefault;
    }

    public static NodeInfoSettingsTransport of(Function<NodeInfoSettingsTransport.Builder, ObjectBuilder<NodeInfoSettingsTransport>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * The transport-layer SSL settings.
     * <p>
     * API name: {@code ssl}
     * </p>
     */
    @Nonnull
    public final Map<String, JsonData> ssl() {
        return this.ssl;
    }

    /**
     * Required - API name: {@code type}
     */
    @Nonnull
    public final NodeInfoSettingsTransportType type() {
        return this.type;
    }

    /**
     * The default transport type.
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
        if (ApiTypeHelper.isDefined(this.ssl)) {
            generator.writeKey("ssl");
            generator.writeStartObject();
            for (Map.Entry<String, JsonData> item0 : this.ssl.entrySet()) {
                generator.writeKey(item0.getKey());
                item0.getValue().serialize(generator, mapper);
            }
            generator.writeEnd();
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
     * Builder for {@link NodeInfoSettingsTransport}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, NodeInfoSettingsTransport> {
        @Nullable
        private Map<String, JsonData> ssl;
        private NodeInfoSettingsTransportType type;
        @Nullable
        private String typeDefault;

        public Builder() {}

        private Builder(NodeInfoSettingsTransport o) {
            this.ssl = _mapCopy(o.ssl);
            this.type = o.type;
            this.typeDefault = o.typeDefault;
        }

        private Builder(Builder o) {
            this.ssl = _mapCopy(o.ssl);
            this.type = o.type;
            this.typeDefault = o.typeDefault;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * The transport-layer SSL settings.
         * <p>
         * API name: {@code ssl}
         * </p>
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>ssl</code>.
         * </p>
         */
        @Nonnull
        public final Builder ssl(Map<String, JsonData> map) {
            this.ssl = _mapPutAll(this.ssl, map);
            return this;
        }

        /**
         * The transport-layer SSL settings.
         * <p>
         * API name: {@code ssl}
         * </p>
         *
         * <p>
         * Adds an entry to <code>ssl</code>.
         * </p>
         */
        @Nonnull
        public final Builder ssl(String key, JsonData value) {
            this.ssl = _mapPut(this.ssl, key, value);
            return this;
        }

        /**
         * Required - API name: {@code type}
         */
        @Nonnull
        public final Builder type(NodeInfoSettingsTransportType value) {
            this.type = value;
            return this;
        }

        /**
         * Required - API name: {@code type}
         */
        @Nonnull
        public final Builder type(Function<NodeInfoSettingsTransportType.Builder, ObjectBuilder<NodeInfoSettingsTransportType>> fn) {
            return type(fn.apply(new NodeInfoSettingsTransportType.Builder()).build());
        }

        /**
         * The default transport type.
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
         * Builds a {@link NodeInfoSettingsTransport}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public NodeInfoSettingsTransport build() {
            _checkSingleUse();

            return new NodeInfoSettingsTransport(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link NodeInfoSettingsTransport}
     */
    public static final JsonpDeserializer<NodeInfoSettingsTransport> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        NodeInfoSettingsTransport::setupNodeInfoSettingsTransportDeserializer
    );

    protected static void setupNodeInfoSettingsTransportDeserializer(ObjectDeserializer<NodeInfoSettingsTransport.Builder> op) {
        op.add(Builder::ssl, JsonpDeserializer.stringMapDeserializer(JsonData._DESERIALIZER), "ssl");
        op.add(Builder::type, NodeInfoSettingsTransportType._DESERIALIZER, "type");
        op.add(Builder::typeDefault, JsonpDeserializer.stringDeserializer(), "type.default");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.ssl);
        result = 31 * result + this.type.hashCode();
        result = 31 * result + Objects.hashCode(this.typeDefault);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        NodeInfoSettingsTransport other = (NodeInfoSettingsTransport) o;
        return Objects.equals(this.ssl, other.ssl) && this.type.equals(other.type) && Objects.equals(this.typeDefault, other.typeDefault);
    }
}
