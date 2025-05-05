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
import java.util.Map;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
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

// typedef: nodes.info.NodeInfoTransport

/**
 * The transport layer information.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class NodeInfoTransport implements PlainJsonSerializable, ToCopyableBuilder<NodeInfoTransport.Builder, NodeInfoTransport> {

    @Nonnull
    private final List<String> boundAddress;

    @Nonnull
    private final Map<String, String> profiles;

    @Nonnull
    private final String publishAddress;

    // ---------------------------------------------------------------------------------------------

    private NodeInfoTransport(Builder builder) {
        this.boundAddress = ApiTypeHelper.unmodifiableRequired(builder.boundAddress, this, "boundAddress");
        this.profiles = ApiTypeHelper.unmodifiableRequired(builder.profiles, this, "profiles");
        this.publishAddress = ApiTypeHelper.requireNonNull(builder.publishAddress, this, "publishAddress");
    }

    public static NodeInfoTransport of(Function<NodeInfoTransport.Builder, ObjectBuilder<NodeInfoTransport>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - The addresses the node is bound to for transport traffic.
     * <p>
     * API name: {@code bound_address}
     * </p>
     */
    @Nonnull
    public final List<String> boundAddress() {
        return this.boundAddress;
    }

    /**
     * Required - The configured transport profiles.
     * <p>
     * API name: {@code profiles}
     * </p>
     */
    @Nonnull
    public final Map<String, String> profiles() {
        return this.profiles;
    }

    /**
     * Required - The published transport address.
     * <p>
     * API name: {@code publish_address}
     * </p>
     */
    @Nonnull
    public final String publishAddress() {
        return this.publishAddress;
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
        generator.writeKey("bound_address");
        generator.writeStartArray();
        for (String item0 : this.boundAddress) {
            generator.write(item0);
        }
        generator.writeEnd();

        generator.writeKey("profiles");
        generator.writeStartObject();
        for (Map.Entry<String, String> item0 : this.profiles.entrySet()) {
            generator.writeKey(item0.getKey());
            generator.write(item0.getValue());
        }
        generator.writeEnd();

        generator.writeKey("publish_address");
        generator.write(this.publishAddress);
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
     * Builder for {@link NodeInfoTransport}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, NodeInfoTransport> {
        private List<String> boundAddress;
        private Map<String, String> profiles;
        private String publishAddress;

        public Builder() {}

        private Builder(NodeInfoTransport o) {
            this.boundAddress = _listCopy(o.boundAddress);
            this.profiles = _mapCopy(o.profiles);
            this.publishAddress = o.publishAddress;
        }

        private Builder(Builder o) {
            this.boundAddress = _listCopy(o.boundAddress);
            this.profiles = _mapCopy(o.profiles);
            this.publishAddress = o.publishAddress;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - The addresses the node is bound to for transport traffic.
         * <p>
         * API name: {@code bound_address}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>boundAddress</code>.
         * </p>
         */
        @Nonnull
        public final Builder boundAddress(List<String> list) {
            this.boundAddress = _listAddAll(this.boundAddress, list);
            return this;
        }

        /**
         * Required - The addresses the node is bound to for transport traffic.
         * <p>
         * API name: {@code bound_address}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>boundAddress</code>.
         * </p>
         */
        @Nonnull
        public final Builder boundAddress(String value, String... values) {
            this.boundAddress = _listAdd(this.boundAddress, value, values);
            return this;
        }

        /**
         * Required - The configured transport profiles.
         * <p>
         * API name: {@code profiles}
         * </p>
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>profiles</code>.
         * </p>
         */
        @Nonnull
        public final Builder profiles(Map<String, String> map) {
            this.profiles = _mapPutAll(this.profiles, map);
            return this;
        }

        /**
         * Required - The configured transport profiles.
         * <p>
         * API name: {@code profiles}
         * </p>
         *
         * <p>
         * Adds an entry to <code>profiles</code>.
         * </p>
         */
        @Nonnull
        public final Builder profiles(String key, String value) {
            this.profiles = _mapPut(this.profiles, key, value);
            return this;
        }

        /**
         * Required - The published transport address.
         * <p>
         * API name: {@code publish_address}
         * </p>
         */
        @Nonnull
        public final Builder publishAddress(String value) {
            this.publishAddress = value;
            return this;
        }

        /**
         * Builds a {@link NodeInfoTransport}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public NodeInfoTransport build() {
            _checkSingleUse();

            return new NodeInfoTransport(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link NodeInfoTransport}
     */
    public static final JsonpDeserializer<NodeInfoTransport> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        NodeInfoTransport::setupNodeInfoTransportDeserializer
    );

    protected static void setupNodeInfoTransportDeserializer(ObjectDeserializer<NodeInfoTransport.Builder> op) {
        op.add(Builder::boundAddress, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "bound_address");
        op.add(Builder::profiles, JsonpDeserializer.stringMapDeserializer(JsonpDeserializer.stringDeserializer()), "profiles");
        op.add(Builder::publishAddress, JsonpDeserializer.stringDeserializer(), "publish_address");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.boundAddress.hashCode();
        result = 31 * result + this.profiles.hashCode();
        result = 31 * result + this.publishAddress.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        NodeInfoTransport other = (NodeInfoTransport) o;
        return this.boundAddress.equals(other.boundAddress)
            && this.profiles.equals(other.profiles)
            && this.publishAddress.equals(other.publishAddress);
    }
}
