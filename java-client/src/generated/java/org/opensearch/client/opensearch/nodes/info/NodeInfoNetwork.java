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

// typedef: nodes.info.NodeInfoNetwork

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class NodeInfoNetwork implements PlainJsonSerializable, ToCopyableBuilder<NodeInfoNetwork.Builder, NodeInfoNetwork> {

    @Nonnull
    private final NodeInfoNetworkInterface primaryInterface;

    private final int refreshInterval;

    // ---------------------------------------------------------------------------------------------

    private NodeInfoNetwork(Builder builder) {
        this.primaryInterface = ApiTypeHelper.requireNonNull(builder.primaryInterface, this, "primaryInterface");
        this.refreshInterval = ApiTypeHelper.requireNonNull(builder.refreshInterval, this, "refreshInterval");
    }

    public static NodeInfoNetwork of(Function<NodeInfoNetwork.Builder, ObjectBuilder<NodeInfoNetwork>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code primary_interface}
     */
    @Nonnull
    public final NodeInfoNetworkInterface primaryInterface() {
        return this.primaryInterface;
    }

    /**
     * Required - API name: {@code refresh_interval}
     */
    public final int refreshInterval() {
        return this.refreshInterval;
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
        generator.writeKey("primary_interface");
        this.primaryInterface.serialize(generator, mapper);

        generator.writeKey("refresh_interval");
        generator.write(this.refreshInterval);
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
     * Builder for {@link NodeInfoNetwork}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, NodeInfoNetwork> {
        private NodeInfoNetworkInterface primaryInterface;
        private Integer refreshInterval;

        public Builder() {}

        private Builder(NodeInfoNetwork o) {
            this.primaryInterface = o.primaryInterface;
            this.refreshInterval = o.refreshInterval;
        }

        private Builder(Builder o) {
            this.primaryInterface = o.primaryInterface;
            this.refreshInterval = o.refreshInterval;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - API name: {@code primary_interface}
         */
        @Nonnull
        public final Builder primaryInterface(NodeInfoNetworkInterface value) {
            this.primaryInterface = value;
            return this;
        }

        /**
         * Required - API name: {@code primary_interface}
         */
        @Nonnull
        public final Builder primaryInterface(Function<NodeInfoNetworkInterface.Builder, ObjectBuilder<NodeInfoNetworkInterface>> fn) {
            return primaryInterface(fn.apply(new NodeInfoNetworkInterface.Builder()).build());
        }

        /**
         * Required - API name: {@code refresh_interval}
         */
        @Nonnull
        public final Builder refreshInterval(int value) {
            this.refreshInterval = value;
            return this;
        }

        /**
         * Builds a {@link NodeInfoNetwork}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public NodeInfoNetwork build() {
            _checkSingleUse();

            return new NodeInfoNetwork(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link NodeInfoNetwork}
     */
    public static final JsonpDeserializer<NodeInfoNetwork> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        NodeInfoNetwork::setupNodeInfoNetworkDeserializer
    );

    protected static void setupNodeInfoNetworkDeserializer(ObjectDeserializer<NodeInfoNetwork.Builder> op) {
        op.add(Builder::primaryInterface, NodeInfoNetworkInterface._DESERIALIZER, "primary_interface");
        op.add(Builder::refreshInterval, JsonpDeserializer.integerDeserializer(), "refresh_interval");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.primaryInterface.hashCode();
        result = 31 * result + Integer.hashCode(this.refreshInterval);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        NodeInfoNetwork other = (NodeInfoNetwork) o;
        return this.primaryInterface.equals(other.primaryInterface) && this.refreshInterval == other.refreshInterval;
    }
}
