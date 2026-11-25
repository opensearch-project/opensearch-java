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

// typedef: nodes.info.NodeInfoDiscovery

/**
 * The node discovery configuration.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class NodeInfoDiscovery implements PlainJsonSerializable, ToCopyableBuilder<NodeInfoDiscovery.Builder, NodeInfoDiscovery> {

    @Nonnull
    private final List<String> seedHosts;

    @Nullable
    private final String type;

    // ---------------------------------------------------------------------------------------------

    private NodeInfoDiscovery(Builder builder) {
        this.seedHosts = ApiTypeHelper.unmodifiable(builder.seedHosts);
        this.type = builder.type;
    }

    public static NodeInfoDiscovery of(Function<NodeInfoDiscovery.Builder, ObjectBuilder<NodeInfoDiscovery>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * The configured seed hosts for node discovery.
     * <p>
     * API name: {@code seed_hosts}
     * </p>
     */
    @Nonnull
    public final List<String> seedHosts() {
        return this.seedHosts;
    }

    /**
     * The discovery mechanism type.
     * <p>
     * API name: {@code type}
     * </p>
     */
    @Nullable
    public final String type() {
        return this.type;
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
        if (ApiTypeHelper.isDefined(this.seedHosts)) {
            generator.writeKey("seed_hosts");
            generator.writeStartArray();
            for (String item0 : this.seedHosts) {
                generator.write(item0);
            }
            generator.writeEnd();
        }

        if (this.type != null) {
            generator.writeKey("type");
            generator.write(this.type);
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
     * Builder for {@link NodeInfoDiscovery}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, NodeInfoDiscovery> {
        @Nullable
        private List<String> seedHosts;
        @Nullable
        private String type;

        public Builder() {}

        private Builder(NodeInfoDiscovery o) {
            this.seedHosts = _listCopy(o.seedHosts);
            this.type = o.type;
        }

        private Builder(Builder o) {
            this.seedHosts = _listCopy(o.seedHosts);
            this.type = o.type;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * The configured seed hosts for node discovery.
         * <p>
         * API name: {@code seed_hosts}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>seedHosts</code>.
         * </p>
         */
        @Nonnull
        public final Builder seedHosts(List<String> list) {
            this.seedHosts = _listAddAll(this.seedHosts, list);
            return this;
        }

        /**
         * The configured seed hosts for node discovery.
         * <p>
         * API name: {@code seed_hosts}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>seedHosts</code>.
         * </p>
         */
        @Nonnull
        public final Builder seedHosts(String value, String... values) {
            this.seedHosts = _listAdd(this.seedHosts, value, values);
            return this;
        }

        /**
         * The discovery mechanism type.
         * <p>
         * API name: {@code type}
         * </p>
         */
        @Nonnull
        public final Builder type(@Nullable String value) {
            this.type = value;
            return this;
        }

        /**
         * Builds a {@link NodeInfoDiscovery}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public NodeInfoDiscovery build() {
            _checkSingleUse();

            return new NodeInfoDiscovery(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link NodeInfoDiscovery}
     */
    public static final JsonpDeserializer<NodeInfoDiscovery> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        NodeInfoDiscovery::setupNodeInfoDiscoveryDeserializer
    );

    protected static void setupNodeInfoDiscoveryDeserializer(ObjectDeserializer<NodeInfoDiscovery.Builder> op) {
        op.add(Builder::seedHosts, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "seed_hosts");
        op.add(Builder::type, JsonpDeserializer.stringDeserializer(), "type");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.seedHosts);
        result = 31 * result + Objects.hashCode(this.type);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        NodeInfoDiscovery other = (NodeInfoDiscovery) o;
        return Objects.equals(this.seedHosts, other.seedHosts) && Objects.equals(this.type, other.type);
    }
}
