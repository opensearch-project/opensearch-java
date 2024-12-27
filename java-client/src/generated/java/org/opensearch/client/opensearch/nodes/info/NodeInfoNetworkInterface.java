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

// typedef: nodes.info.NodeInfoNetworkInterface

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class NodeInfoNetworkInterface
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<NodeInfoNetworkInterface.Builder, NodeInfoNetworkInterface> {

    @Nonnull
    private final String address;

    @Nonnull
    private final String macAddress;

    @Nonnull
    private final String name;

    // ---------------------------------------------------------------------------------------------

    private NodeInfoNetworkInterface(Builder builder) {
        this.address = ApiTypeHelper.requireNonNull(builder.address, this, "address");
        this.macAddress = ApiTypeHelper.requireNonNull(builder.macAddress, this, "macAddress");
        this.name = ApiTypeHelper.requireNonNull(builder.name, this, "name");
    }

    public static NodeInfoNetworkInterface of(Function<NodeInfoNetworkInterface.Builder, ObjectBuilder<NodeInfoNetworkInterface>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code address}
     */
    @Nonnull
    public final String address() {
        return this.address;
    }

    /**
     * Required - API name: {@code mac_address}
     */
    @Nonnull
    public final String macAddress() {
        return this.macAddress;
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
        generator.writeKey("address");
        generator.write(this.address);

        generator.writeKey("mac_address");
        generator.write(this.macAddress);

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
     * Builder for {@link NodeInfoNetworkInterface}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, NodeInfoNetworkInterface> {
        private String address;
        private String macAddress;
        private String name;

        public Builder() {}

        private Builder(NodeInfoNetworkInterface o) {
            this.address = o.address;
            this.macAddress = o.macAddress;
            this.name = o.name;
        }

        private Builder(Builder o) {
            this.address = o.address;
            this.macAddress = o.macAddress;
            this.name = o.name;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - API name: {@code address}
         */
        @Nonnull
        public final Builder address(String value) {
            this.address = value;
            return this;
        }

        /**
         * Required - API name: {@code mac_address}
         */
        @Nonnull
        public final Builder macAddress(String value) {
            this.macAddress = value;
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
         * Builds a {@link NodeInfoNetworkInterface}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public NodeInfoNetworkInterface build() {
            _checkSingleUse();

            return new NodeInfoNetworkInterface(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link NodeInfoNetworkInterface}
     */
    public static final JsonpDeserializer<NodeInfoNetworkInterface> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        NodeInfoNetworkInterface::setupNodeInfoNetworkInterfaceDeserializer
    );

    protected static void setupNodeInfoNetworkInterfaceDeserializer(ObjectDeserializer<NodeInfoNetworkInterface.Builder> op) {
        op.add(Builder::address, JsonpDeserializer.stringDeserializer(), "address");
        op.add(Builder::macAddress, JsonpDeserializer.stringDeserializer(), "mac_address");
        op.add(Builder::name, JsonpDeserializer.stringDeserializer(), "name");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.address.hashCode();
        result = 31 * result + this.macAddress.hashCode();
        result = 31 * result + this.name.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        NodeInfoNetworkInterface other = (NodeInfoNetworkInterface) o;
        return this.address.equals(other.address) && this.macAddress.equals(other.macAddress) && this.name.equals(other.name);
    }
}
