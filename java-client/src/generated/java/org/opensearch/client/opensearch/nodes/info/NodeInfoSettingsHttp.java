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
import java.util.List;
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

    @Nonnull
    private final List<String> bindHost;

    @Nullable
    private final Boolean compression;

    @Nonnull
    private final List<String> host;

    @Nullable
    private final String port;

    @Nonnull
    private final List<String> publishHost;

    @Nullable
    private final Integer publishPort;

    @Nonnull
    private final NodeInfoSettingsHttpType type;

    @Nullable
    private final String typeDefault;

    // ---------------------------------------------------------------------------------------------

    private NodeInfoSettingsHttp(Builder builder) {
        this.bindHost = ApiTypeHelper.unmodifiable(builder.bindHost);
        this.compression = builder.compression;
        this.host = ApiTypeHelper.unmodifiable(builder.host);
        this.port = builder.port;
        this.publishHost = ApiTypeHelper.unmodifiable(builder.publishHost);
        this.publishPort = builder.publishPort;
        this.type = ApiTypeHelper.requireNonNull(builder.type, this, "type");
        this.typeDefault = builder.typeDefault;
    }

    public static NodeInfoSettingsHttp of(Function<NodeInfoSettingsHttp.Builder, ObjectBuilder<NodeInfoSettingsHttp>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * The host addresses the HTTP server binds to.
     * <p>
     * API name: {@code bind_host}
     * </p>
     */
    @Nonnull
    public final List<String> bindHost() {
        return this.bindHost;
    }

    /**
     * API name: {@code compression}
     */
    @Nullable
    public final Boolean compression() {
        return this.compression;
    }

    /**
     * The host addresses the HTTP server binds to and publishes.
     * <p>
     * API name: {@code host}
     * </p>
     */
    @Nonnull
    public final List<String> host() {
        return this.host;
    }

    /**
     * The port or port range (for example, <code>9200-9300</code>) the HTTP server binds to.
     * <p>
     * API name: {@code port}
     * </p>
     */
    @Nullable
    public final String port() {
        return this.port;
    }

    /**
     * The host addresses the HTTP server publishes to clients.
     * <p>
     * API name: {@code publish_host}
     * </p>
     */
    @Nonnull
    public final List<String> publishHost() {
        return this.publishHost;
    }

    /**
     * The port the HTTP server publishes to clients.
     * <p>
     * API name: {@code publish_port}
     * </p>
     */
    @Nullable
    public final Integer publishPort() {
        return this.publishPort;
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
        if (ApiTypeHelper.isDefined(this.bindHost)) {
            generator.writeKey("bind_host");
            generator.writeStartArray();
            for (String item0 : this.bindHost) {
                generator.write(item0);
            }
            generator.writeEnd();
        }

        if (this.compression != null) {
            generator.writeKey("compression");
            generator.write(this.compression);
        }

        if (ApiTypeHelper.isDefined(this.host)) {
            generator.writeKey("host");
            generator.writeStartArray();
            for (String item0 : this.host) {
                generator.write(item0);
            }
            generator.writeEnd();
        }

        if (this.port != null) {
            generator.writeKey("port");
            generator.write(this.port);
        }

        if (ApiTypeHelper.isDefined(this.publishHost)) {
            generator.writeKey("publish_host");
            generator.writeStartArray();
            for (String item0 : this.publishHost) {
                generator.write(item0);
            }
            generator.writeEnd();
        }

        if (this.publishPort != null) {
            generator.writeKey("publish_port");
            generator.write(this.publishPort);
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
        private List<String> bindHost;
        @Nullable
        private Boolean compression;
        @Nullable
        private List<String> host;
        @Nullable
        private String port;
        @Nullable
        private List<String> publishHost;
        @Nullable
        private Integer publishPort;
        private NodeInfoSettingsHttpType type;
        @Nullable
        private String typeDefault;

        public Builder() {}

        private Builder(NodeInfoSettingsHttp o) {
            this.bindHost = _listCopy(o.bindHost);
            this.compression = o.compression;
            this.host = _listCopy(o.host);
            this.port = o.port;
            this.publishHost = _listCopy(o.publishHost);
            this.publishPort = o.publishPort;
            this.type = o.type;
            this.typeDefault = o.typeDefault;
        }

        private Builder(Builder o) {
            this.bindHost = _listCopy(o.bindHost);
            this.compression = o.compression;
            this.host = _listCopy(o.host);
            this.port = o.port;
            this.publishHost = _listCopy(o.publishHost);
            this.publishPort = o.publishPort;
            this.type = o.type;
            this.typeDefault = o.typeDefault;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * The host addresses the HTTP server binds to.
         * <p>
         * API name: {@code bind_host}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>bindHost</code>.
         * </p>
         */
        @Nonnull
        public final Builder bindHost(List<String> list) {
            this.bindHost = _listAddAll(this.bindHost, list);
            return this;
        }

        /**
         * The host addresses the HTTP server binds to.
         * <p>
         * API name: {@code bind_host}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>bindHost</code>.
         * </p>
         */
        @Nonnull
        public final Builder bindHost(String value, String... values) {
            this.bindHost = _listAdd(this.bindHost, value, values);
            return this;
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
         * The host addresses the HTTP server binds to and publishes.
         * <p>
         * API name: {@code host}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>host</code>.
         * </p>
         */
        @Nonnull
        public final Builder host(List<String> list) {
            this.host = _listAddAll(this.host, list);
            return this;
        }

        /**
         * The host addresses the HTTP server binds to and publishes.
         * <p>
         * API name: {@code host}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>host</code>.
         * </p>
         */
        @Nonnull
        public final Builder host(String value, String... values) {
            this.host = _listAdd(this.host, value, values);
            return this;
        }

        /**
         * The port or port range (for example, <code>9200-9300</code>) the HTTP server binds to.
         * <p>
         * API name: {@code port}
         * </p>
         */
        @Nonnull
        public final Builder port(@Nullable String value) {
            this.port = value;
            return this;
        }

        /**
         * The host addresses the HTTP server publishes to clients.
         * <p>
         * API name: {@code publish_host}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>publishHost</code>.
         * </p>
         */
        @Nonnull
        public final Builder publishHost(List<String> list) {
            this.publishHost = _listAddAll(this.publishHost, list);
            return this;
        }

        /**
         * The host addresses the HTTP server publishes to clients.
         * <p>
         * API name: {@code publish_host}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>publishHost</code>.
         * </p>
         */
        @Nonnull
        public final Builder publishHost(String value, String... values) {
            this.publishHost = _listAdd(this.publishHost, value, values);
            return this;
        }

        /**
         * The port the HTTP server publishes to clients.
         * <p>
         * API name: {@code publish_port}
         * </p>
         */
        @Nonnull
        public final Builder publishPort(@Nullable Integer value) {
            this.publishPort = value;
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
        op.add(Builder::bindHost, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "bind_host");
        op.add(Builder::compression, JsonpDeserializer.booleanDeserializer(), "compression");
        op.add(Builder::host, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "host");
        op.add(Builder::port, JsonpDeserializer.stringDeserializer(), "port");
        op.add(Builder::publishHost, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "publish_host");
        op.add(Builder::publishPort, JsonpDeserializer.integerDeserializer(), "publish_port");
        op.add(Builder::type, NodeInfoSettingsHttpType._DESERIALIZER, "type");
        op.add(Builder::typeDefault, JsonpDeserializer.stringDeserializer(), "type.default");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.bindHost);
        result = 31 * result + Objects.hashCode(this.compression);
        result = 31 * result + Objects.hashCode(this.host);
        result = 31 * result + Objects.hashCode(this.port);
        result = 31 * result + Objects.hashCode(this.publishHost);
        result = 31 * result + Objects.hashCode(this.publishPort);
        result = 31 * result + this.type.hashCode();
        result = 31 * result + Objects.hashCode(this.typeDefault);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        NodeInfoSettingsHttp other = (NodeInfoSettingsHttp) o;
        return Objects.equals(this.bindHost, other.bindHost)
            && Objects.equals(this.compression, other.compression)
            && Objects.equals(this.host, other.host)
            && Objects.equals(this.port, other.port)
            && Objects.equals(this.publishHost, other.publishHost)
            && Objects.equals(this.publishPort, other.publishPort)
            && this.type.equals(other.type)
            && Objects.equals(this.typeDefault, other.typeDefault);
    }
}
