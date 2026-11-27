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

// typedef: nodes.info.NodeInfoSettingsClusterRoutingAllocationAwarenessForce

/**
 * The forced awareness values for a node attribute.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class NodeInfoSettingsClusterRoutingAllocationAwarenessForce
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<
            NodeInfoSettingsClusterRoutingAllocationAwarenessForce.Builder,
            NodeInfoSettingsClusterRoutingAllocationAwarenessForce> {

    @Nonnull
    private final List<String> values;

    // ---------------------------------------------------------------------------------------------

    private NodeInfoSettingsClusterRoutingAllocationAwarenessForce(Builder builder) {
        this.values = ApiTypeHelper.unmodifiable(builder.values);
    }

    public static NodeInfoSettingsClusterRoutingAllocationAwarenessForce of(
        Function<
            NodeInfoSettingsClusterRoutingAllocationAwarenessForce.Builder,
            ObjectBuilder<NodeInfoSettingsClusterRoutingAllocationAwarenessForce>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * The attribute values across which shards are forced to be spread.
     * <p>
     * API name: {@code values}
     * </p>
     */
    @Nonnull
    public final List<String> values() {
        return this.values;
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
        if (ApiTypeHelper.isDefined(this.values)) {
            generator.writeKey("values");
            generator.writeStartArray();
            for (String item0 : this.values) {
                generator.write(item0);
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
     * Builder for {@link NodeInfoSettingsClusterRoutingAllocationAwarenessForce}.
     */
    public static class Builder extends ObjectBuilderBase
        implements
            CopyableBuilder<Builder, NodeInfoSettingsClusterRoutingAllocationAwarenessForce> {
        @Nullable
        private List<String> values;

        public Builder() {}

        private Builder(NodeInfoSettingsClusterRoutingAllocationAwarenessForce o) {
            this.values = _listCopy(o.values);
        }

        private Builder(Builder o) {
            this.values = _listCopy(o.values);
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * The attribute values across which shards are forced to be spread.
         * <p>
         * API name: {@code values}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>values</code>.
         * </p>
         */
        @Nonnull
        public final Builder values(List<String> list) {
            this.values = _listAddAll(this.values, list);
            return this;
        }

        /**
         * The attribute values across which shards are forced to be spread.
         * <p>
         * API name: {@code values}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>values</code>.
         * </p>
         */
        @Nonnull
        public final Builder values(String value, String... values) {
            this.values = _listAdd(this.values, value, values);
            return this;
        }

        /**
         * Builds a {@link NodeInfoSettingsClusterRoutingAllocationAwarenessForce}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public NodeInfoSettingsClusterRoutingAllocationAwarenessForce build() {
            _checkSingleUse();

            return new NodeInfoSettingsClusterRoutingAllocationAwarenessForce(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link NodeInfoSettingsClusterRoutingAllocationAwarenessForce}
     */
    public static final JsonpDeserializer<NodeInfoSettingsClusterRoutingAllocationAwarenessForce> _DESERIALIZER = ObjectBuilderDeserializer
        .lazy(
            Builder::new,
            NodeInfoSettingsClusterRoutingAllocationAwarenessForce::setupNodeInfoSettingsClusterRoutingAllocationAwarenessForceDeserializer
        );

    protected static void setupNodeInfoSettingsClusterRoutingAllocationAwarenessForceDeserializer(
        ObjectDeserializer<NodeInfoSettingsClusterRoutingAllocationAwarenessForce.Builder> op
    ) {
        op.add(Builder::values, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "values");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.values);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        NodeInfoSettingsClusterRoutingAllocationAwarenessForce other = (NodeInfoSettingsClusterRoutingAllocationAwarenessForce) o;
        return Objects.equals(this.values, other.values);
    }
}
