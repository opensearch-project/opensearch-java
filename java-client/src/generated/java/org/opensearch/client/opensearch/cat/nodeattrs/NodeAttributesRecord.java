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

package org.opensearch.client.opensearch.cat.nodeattrs;

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
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: cat.nodeattrs.NodeAttributesRecord

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class NodeAttributesRecord implements PlainJsonSerializable, ToCopyableBuilder<NodeAttributesRecord.Builder, NodeAttributesRecord> {

    @Nullable
    private final String attr;

    @Nullable
    private final String host;

    @Nullable
    private final String id;

    @Nullable
    private final String ip;

    @Nullable
    private final String node;

    @Nullable
    private final String pid;

    @Nullable
    private final String port;

    @Nullable
    private final String value;

    // ---------------------------------------------------------------------------------------------

    private NodeAttributesRecord(Builder builder) {
        this.attr = builder.attr;
        this.host = builder.host;
        this.id = builder.id;
        this.ip = builder.ip;
        this.node = builder.node;
        this.pid = builder.pid;
        this.port = builder.port;
        this.value = builder.value;
    }

    public static NodeAttributesRecord of(Function<NodeAttributesRecord.Builder, ObjectBuilder<NodeAttributesRecord>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * The attribute name.
     * <p>
     * API name: {@code attr}
     * </p>
     */
    @Nullable
    public final String attr() {
        return this.attr;
    }

    /**
     * The hostname.
     * <p>
     * API name: {@code host}
     * </p>
     */
    @Nullable
    public final String host() {
        return this.host;
    }

    /**
     * The unique node identifier.
     * <p>
     * API name: {@code id}
     * </p>
     */
    @Nullable
    public final String id() {
        return this.id;
    }

    /**
     * The IP address.
     * <p>
     * API name: {@code ip}
     * </p>
     */
    @Nullable
    public final String ip() {
        return this.ip;
    }

    /**
     * The node name.
     * <p>
     * API name: {@code node}
     * </p>
     */
    @Nullable
    public final String node() {
        return this.node;
    }

    /**
     * The process identifier.
     * <p>
     * API name: {@code pid}
     * </p>
     */
    @Nullable
    public final String pid() {
        return this.pid;
    }

    /**
     * The bound transport port.
     * <p>
     * API name: {@code port}
     * </p>
     */
    @Nullable
    public final String port() {
        return this.port;
    }

    /**
     * The attribute value.
     * <p>
     * API name: {@code value}
     * </p>
     */
    @Nullable
    public final String value() {
        return this.value;
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
        if (this.attr != null) {
            generator.writeKey("attr");
            generator.write(this.attr);
        }

        if (this.host != null) {
            generator.writeKey("host");
            generator.write(this.host);
        }

        if (this.id != null) {
            generator.writeKey("id");
            generator.write(this.id);
        }

        if (this.ip != null) {
            generator.writeKey("ip");
            generator.write(this.ip);
        }

        if (this.node != null) {
            generator.writeKey("node");
            generator.write(this.node);
        }

        if (this.pid != null) {
            generator.writeKey("pid");
            generator.write(this.pid);
        }

        if (this.port != null) {
            generator.writeKey("port");
            generator.write(this.port);
        }

        if (this.value != null) {
            generator.writeKey("value");
            generator.write(this.value);
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
     * Builder for {@link NodeAttributesRecord}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, NodeAttributesRecord> {
        @Nullable
        private String attr;
        @Nullable
        private String host;
        @Nullable
        private String id;
        @Nullable
        private String ip;
        @Nullable
        private String node;
        @Nullable
        private String pid;
        @Nullable
        private String port;
        @Nullable
        private String value;

        public Builder() {}

        private Builder(NodeAttributesRecord o) {
            this.attr = o.attr;
            this.host = o.host;
            this.id = o.id;
            this.ip = o.ip;
            this.node = o.node;
            this.pid = o.pid;
            this.port = o.port;
            this.value = o.value;
        }

        private Builder(Builder o) {
            this.attr = o.attr;
            this.host = o.host;
            this.id = o.id;
            this.ip = o.ip;
            this.node = o.node;
            this.pid = o.pid;
            this.port = o.port;
            this.value = o.value;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * The attribute name.
         * <p>
         * API name: {@code attr}
         * </p>
         */
        @Nonnull
        public final Builder attr(@Nullable String value) {
            this.attr = value;
            return this;
        }

        /**
         * The hostname.
         * <p>
         * API name: {@code host}
         * </p>
         */
        @Nonnull
        public final Builder host(@Nullable String value) {
            this.host = value;
            return this;
        }

        /**
         * The unique node identifier.
         * <p>
         * API name: {@code id}
         * </p>
         */
        @Nonnull
        public final Builder id(@Nullable String value) {
            this.id = value;
            return this;
        }

        /**
         * The IP address.
         * <p>
         * API name: {@code ip}
         * </p>
         */
        @Nonnull
        public final Builder ip(@Nullable String value) {
            this.ip = value;
            return this;
        }

        /**
         * The node name.
         * <p>
         * API name: {@code node}
         * </p>
         */
        @Nonnull
        public final Builder node(@Nullable String value) {
            this.node = value;
            return this;
        }

        /**
         * The process identifier.
         * <p>
         * API name: {@code pid}
         * </p>
         */
        @Nonnull
        public final Builder pid(@Nullable String value) {
            this.pid = value;
            return this;
        }

        /**
         * The bound transport port.
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
         * The attribute value.
         * <p>
         * API name: {@code value}
         * </p>
         */
        @Nonnull
        public final Builder value(@Nullable String value) {
            this.value = value;
            return this;
        }

        /**
         * Builds a {@link NodeAttributesRecord}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public NodeAttributesRecord build() {
            _checkSingleUse();

            return new NodeAttributesRecord(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link NodeAttributesRecord}
     */
    public static final JsonpDeserializer<NodeAttributesRecord> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        NodeAttributesRecord::setupNodeAttributesRecordDeserializer
    );

    protected static void setupNodeAttributesRecordDeserializer(ObjectDeserializer<NodeAttributesRecord.Builder> op) {
        op.add(Builder::attr, JsonpDeserializer.stringDeserializer(), "attr");
        op.add(Builder::host, JsonpDeserializer.stringDeserializer(), "host");
        op.add(Builder::id, JsonpDeserializer.stringDeserializer(), "id");
        op.add(Builder::ip, JsonpDeserializer.stringDeserializer(), "ip");
        op.add(Builder::node, JsonpDeserializer.stringDeserializer(), "node");
        op.add(Builder::pid, JsonpDeserializer.stringDeserializer(), "pid");
        op.add(Builder::port, JsonpDeserializer.stringDeserializer(), "port");
        op.add(Builder::value, JsonpDeserializer.stringDeserializer(), "value");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.attr);
        result = 31 * result + Objects.hashCode(this.host);
        result = 31 * result + Objects.hashCode(this.id);
        result = 31 * result + Objects.hashCode(this.ip);
        result = 31 * result + Objects.hashCode(this.node);
        result = 31 * result + Objects.hashCode(this.pid);
        result = 31 * result + Objects.hashCode(this.port);
        result = 31 * result + Objects.hashCode(this.value);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        NodeAttributesRecord other = (NodeAttributesRecord) o;
        return Objects.equals(this.attr, other.attr)
            && Objects.equals(this.host, other.host)
            && Objects.equals(this.id, other.id)
            && Objects.equals(this.ip, other.ip)
            && Objects.equals(this.node, other.node)
            && Objects.equals(this.pid, other.pid)
            && Objects.equals(this.port, other.port)
            && Objects.equals(this.value, other.value);
    }
}
