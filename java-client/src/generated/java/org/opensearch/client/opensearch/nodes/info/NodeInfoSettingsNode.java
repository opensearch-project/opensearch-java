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

// typedef: nodes.info.NodeInfoSettingsNode

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class NodeInfoSettingsNode implements PlainJsonSerializable, ToCopyableBuilder<NodeInfoSettingsNode.Builder, NodeInfoSettingsNode> {

    @Nonnull
    private final Map<String, JsonData> attr;

    @Nullable
    private final String maxLocalStorageNodes;

    @Nonnull
    private final String name;

    // ---------------------------------------------------------------------------------------------

    private NodeInfoSettingsNode(Builder builder) {
        this.attr = ApiTypeHelper.unmodifiableRequired(builder.attr, this, "attr");
        this.maxLocalStorageNodes = builder.maxLocalStorageNodes;
        this.name = ApiTypeHelper.requireNonNull(builder.name, this, "name");
    }

    public static NodeInfoSettingsNode of(Function<NodeInfoSettingsNode.Builder, ObjectBuilder<NodeInfoSettingsNode>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code attr}
     */
    @Nonnull
    public final Map<String, JsonData> attr() {
        return this.attr;
    }

    /**
     * API name: {@code max_local_storage_nodes}
     */
    @Nullable
    public final String maxLocalStorageNodes() {
        return this.maxLocalStorageNodes;
    }

    /**
     * Required - API name: {@code name}
     */
    @Nonnull
    public final String name() {
        return this.name;
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
        generator.writeKey("attr");
        generator.writeStartObject();
        for (Map.Entry<String, JsonData> item0 : this.attr.entrySet()) {
            generator.writeKey(item0.getKey());
            item0.getValue().serialize(generator, mapper);
        }
        generator.writeEnd();

        if (this.maxLocalStorageNodes != null) {
            generator.writeKey("max_local_storage_nodes");
            generator.write(this.maxLocalStorageNodes);
        }

        generator.writeKey("name");
        generator.write(this.name);
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
     * Builder for {@link NodeInfoSettingsNode}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, NodeInfoSettingsNode> {
        private Map<String, JsonData> attr;
        @Nullable
        private String maxLocalStorageNodes;
        private String name;

        public Builder() {}

        private Builder(NodeInfoSettingsNode o) {
            this.attr = _mapCopy(o.attr);
            this.maxLocalStorageNodes = o.maxLocalStorageNodes;
            this.name = o.name;
        }

        private Builder(Builder o) {
            this.attr = _mapCopy(o.attr);
            this.maxLocalStorageNodes = o.maxLocalStorageNodes;
            this.name = o.name;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - API name: {@code attr}
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>attr</code>.
         * </p>
         */
        @Nonnull
        public final Builder attr(Map<String, JsonData> map) {
            this.attr = _mapPutAll(this.attr, map);
            return this;
        }

        /**
         * Required - API name: {@code attr}
         *
         * <p>
         * Adds an entry to <code>attr</code>.
         * </p>
         */
        @Nonnull
        public final Builder attr(String key, JsonData value) {
            this.attr = _mapPut(this.attr, key, value);
            return this;
        }

        /**
         * API name: {@code max_local_storage_nodes}
         */
        @Nonnull
        public final Builder maxLocalStorageNodes(@Nullable String value) {
            this.maxLocalStorageNodes = value;
            return this;
        }

        /**
         * Required - API name: {@code name}
         */
        @Nonnull
        public final Builder name(String value) {
            this.name = value;
            return this;
        }

        /**
         * Builds a {@link NodeInfoSettingsNode}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public NodeInfoSettingsNode build() {
            _checkSingleUse();

            return new NodeInfoSettingsNode(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link NodeInfoSettingsNode}
     */
    public static final JsonpDeserializer<NodeInfoSettingsNode> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        NodeInfoSettingsNode::setupNodeInfoSettingsNodeDeserializer
    );

    protected static void setupNodeInfoSettingsNodeDeserializer(ObjectDeserializer<NodeInfoSettingsNode.Builder> op) {
        op.add(Builder::attr, JsonpDeserializer.stringMapDeserializer(JsonData._DESERIALIZER), "attr");
        op.add(Builder::maxLocalStorageNodes, JsonpDeserializer.stringDeserializer(), "max_local_storage_nodes");
        op.add(Builder::name, JsonpDeserializer.stringDeserializer(), "name");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.attr.hashCode();
        result = 31 * result + Objects.hashCode(this.maxLocalStorageNodes);
        result = 31 * result + this.name.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        NodeInfoSettingsNode other = (NodeInfoSettingsNode) o;
        return this.attr.equals(other.attr)
            && Objects.equals(this.maxLocalStorageNodes, other.maxLocalStorageNodes)
            && this.name.equals(other.name);
    }
}
