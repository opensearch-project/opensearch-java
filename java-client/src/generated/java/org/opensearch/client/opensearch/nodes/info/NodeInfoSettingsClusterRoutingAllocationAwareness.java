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

// typedef: nodes.info.NodeInfoSettingsClusterRoutingAllocationAwareness

/**
 * The shard allocation awareness configuration.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class NodeInfoSettingsClusterRoutingAllocationAwareness
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<NodeInfoSettingsClusterRoutingAllocationAwareness.Builder, NodeInfoSettingsClusterRoutingAllocationAwareness> {

    @Nonnull
    private final List<String> attributes;

    @Nonnull
    private final Map<String, NodeInfoSettingsClusterRoutingAllocationAwarenessForce> force;

    // ---------------------------------------------------------------------------------------------

    private NodeInfoSettingsClusterRoutingAllocationAwareness(Builder builder) {
        this.attributes = ApiTypeHelper.unmodifiable(builder.attributes);
        this.force = ApiTypeHelper.unmodifiable(builder.force);
    }

    public static NodeInfoSettingsClusterRoutingAllocationAwareness of(
        Function<
            NodeInfoSettingsClusterRoutingAllocationAwareness.Builder,
            ObjectBuilder<NodeInfoSettingsClusterRoutingAllocationAwareness>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * The node attributes used for shard allocation awareness.
     * <p>
     * API name: {@code attributes}
     * </p>
     */
    @Nonnull
    public final List<String> attributes() {
        return this.attributes;
    }

    /**
     * The forced awareness configuration, keyed by node attribute name.
     * <p>
     * API name: {@code force}
     * </p>
     */
    @Nonnull
    public final Map<String, NodeInfoSettingsClusterRoutingAllocationAwarenessForce> force() {
        return this.force;
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
        if (ApiTypeHelper.isDefined(this.attributes)) {
            generator.writeKey("attributes");
            generator.writeStartArray();
            for (String item0 : this.attributes) {
                generator.write(item0);
            }
            generator.writeEnd();
        }

        if (ApiTypeHelper.isDefined(this.force)) {
            generator.writeKey("force");
            generator.writeStartObject();
            for (Map.Entry<String, NodeInfoSettingsClusterRoutingAllocationAwarenessForce> item0 : this.force.entrySet()) {
                generator.writeKey(item0.getKey());
                item0.getValue().serialize(generator, mapper);
            }
            generator.writeEnd();
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
     * Builder for {@link NodeInfoSettingsClusterRoutingAllocationAwareness}.
     */
    public static class Builder extends ObjectBuilderBase
        implements
            CopyableBuilder<Builder, NodeInfoSettingsClusterRoutingAllocationAwareness> {
        @Nullable
        private List<String> attributes;
        @Nullable
        private Map<String, NodeInfoSettingsClusterRoutingAllocationAwarenessForce> force;

        public Builder() {}

        private Builder(NodeInfoSettingsClusterRoutingAllocationAwareness o) {
            this.attributes = _listCopy(o.attributes);
            this.force = _mapCopy(o.force);
        }

        private Builder(Builder o) {
            this.attributes = _listCopy(o.attributes);
            this.force = _mapCopy(o.force);
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * The node attributes used for shard allocation awareness.
         * <p>
         * API name: {@code attributes}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>attributes</code>.
         * </p>
         */
        @Nonnull
        public final Builder attributes(List<String> list) {
            this.attributes = _listAddAll(this.attributes, list);
            return this;
        }

        /**
         * The node attributes used for shard allocation awareness.
         * <p>
         * API name: {@code attributes}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>attributes</code>.
         * </p>
         */
        @Nonnull
        public final Builder attributes(String value, String... values) {
            this.attributes = _listAdd(this.attributes, value, values);
            return this;
        }

        /**
         * The forced awareness configuration, keyed by node attribute name.
         * <p>
         * API name: {@code force}
         * </p>
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>force</code>.
         * </p>
         */
        @Nonnull
        public final Builder force(Map<String, NodeInfoSettingsClusterRoutingAllocationAwarenessForce> map) {
            this.force = _mapPutAll(this.force, map);
            return this;
        }

        /**
         * The forced awareness configuration, keyed by node attribute name.
         * <p>
         * API name: {@code force}
         * </p>
         *
         * <p>
         * Adds an entry to <code>force</code>.
         * </p>
         */
        @Nonnull
        public final Builder force(String key, NodeInfoSettingsClusterRoutingAllocationAwarenessForce value) {
            this.force = _mapPut(this.force, key, value);
            return this;
        }

        /**
         * The forced awareness configuration, keyed by node attribute name.
         * <p>
         * API name: {@code force}
         * </p>
         *
         * <p>
         * Adds a value to <code>force</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder force(
            String key,
            Function<
                NodeInfoSettingsClusterRoutingAllocationAwarenessForce.Builder,
                ObjectBuilder<NodeInfoSettingsClusterRoutingAllocationAwarenessForce>> fn
        ) {
            return force(key, fn.apply(new NodeInfoSettingsClusterRoutingAllocationAwarenessForce.Builder()).build());
        }

        /**
         * Builds a {@link NodeInfoSettingsClusterRoutingAllocationAwareness}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public NodeInfoSettingsClusterRoutingAllocationAwareness build() {
            _checkSingleUse();

            return new NodeInfoSettingsClusterRoutingAllocationAwareness(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link NodeInfoSettingsClusterRoutingAllocationAwareness}
     */
    public static final JsonpDeserializer<NodeInfoSettingsClusterRoutingAllocationAwareness> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        NodeInfoSettingsClusterRoutingAllocationAwareness::setupNodeInfoSettingsClusterRoutingAllocationAwarenessDeserializer
    );

    protected static void setupNodeInfoSettingsClusterRoutingAllocationAwarenessDeserializer(
        ObjectDeserializer<NodeInfoSettingsClusterRoutingAllocationAwareness.Builder> op
    ) {
        op.add(Builder::attributes, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "attributes");
        op.add(
            Builder::force,
            JsonpDeserializer.stringMapDeserializer(NodeInfoSettingsClusterRoutingAllocationAwarenessForce._DESERIALIZER),
            "force"
        );
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.attributes);
        result = 31 * result + Objects.hashCode(this.force);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        NodeInfoSettingsClusterRoutingAllocationAwareness other = (NodeInfoSettingsClusterRoutingAllocationAwareness) o;
        return Objects.equals(this.attributes, other.attributes) && Objects.equals(this.force, other.force);
    }
}
