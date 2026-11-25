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

// typedef: nodes.info.NodeInfoSettingsNetwork

/**
 * The network configuration settings.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class NodeInfoSettingsNetwork
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<NodeInfoSettingsNetwork.Builder, NodeInfoSettingsNetwork> {

    @Nonnull
    private final List<String> bindHost;

    @Nonnull
    private final List<String> host;

    @Nonnull
    private final List<String> publishHost;

    // ---------------------------------------------------------------------------------------------

    private NodeInfoSettingsNetwork(Builder builder) {
        this.bindHost = ApiTypeHelper.unmodifiable(builder.bindHost);
        this.host = ApiTypeHelper.unmodifiable(builder.host);
        this.publishHost = ApiTypeHelper.unmodifiable(builder.publishHost);
    }

    public static NodeInfoSettingsNetwork of(Function<NodeInfoSettingsNetwork.Builder, ObjectBuilder<NodeInfoSettingsNetwork>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * The host addresses the node binds to for all network services.
     * <p>
     * API name: {@code bind_host}
     * </p>
     */
    @Nonnull
    public final List<String> bindHost() {
        return this.bindHost;
    }

    /**
     * The host addresses the node binds to and publishes for all network services.
     * <p>
     * API name: {@code host}
     * </p>
     */
    @Nonnull
    public final List<String> host() {
        return this.host;
    }

    /**
     * The host addresses the node publishes for all network services.
     * <p>
     * API name: {@code publish_host}
     * </p>
     */
    @Nonnull
    public final List<String> publishHost() {
        return this.publishHost;
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

        if (ApiTypeHelper.isDefined(this.host)) {
            generator.writeKey("host");
            generator.writeStartArray();
            for (String item0 : this.host) {
                generator.write(item0);
            }
            generator.writeEnd();
        }

        if (ApiTypeHelper.isDefined(this.publishHost)) {
            generator.writeKey("publish_host");
            generator.writeStartArray();
            for (String item0 : this.publishHost) {
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
     * Builder for {@link NodeInfoSettingsNetwork}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, NodeInfoSettingsNetwork> {
        @Nullable
        private List<String> bindHost;
        @Nullable
        private List<String> host;
        @Nullable
        private List<String> publishHost;

        public Builder() {}

        private Builder(NodeInfoSettingsNetwork o) {
            this.bindHost = _listCopy(o.bindHost);
            this.host = _listCopy(o.host);
            this.publishHost = _listCopy(o.publishHost);
        }

        private Builder(Builder o) {
            this.bindHost = _listCopy(o.bindHost);
            this.host = _listCopy(o.host);
            this.publishHost = _listCopy(o.publishHost);
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * The host addresses the node binds to for all network services.
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
         * The host addresses the node binds to for all network services.
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
         * The host addresses the node binds to and publishes for all network services.
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
         * The host addresses the node binds to and publishes for all network services.
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
         * The host addresses the node publishes for all network services.
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
         * The host addresses the node publishes for all network services.
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
         * Builds a {@link NodeInfoSettingsNetwork}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public NodeInfoSettingsNetwork build() {
            _checkSingleUse();

            return new NodeInfoSettingsNetwork(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link NodeInfoSettingsNetwork}
     */
    public static final JsonpDeserializer<NodeInfoSettingsNetwork> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        NodeInfoSettingsNetwork::setupNodeInfoSettingsNetworkDeserializer
    );

    protected static void setupNodeInfoSettingsNetworkDeserializer(ObjectDeserializer<NodeInfoSettingsNetwork.Builder> op) {
        op.add(Builder::bindHost, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "bind_host");
        op.add(Builder::host, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "host");
        op.add(Builder::publishHost, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "publish_host");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.bindHost);
        result = 31 * result + Objects.hashCode(this.host);
        result = 31 * result + Objects.hashCode(this.publishHost);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        NodeInfoSettingsNetwork other = (NodeInfoSettingsNetwork) o;
        return Objects.equals(this.bindHost, other.bindHost)
            && Objects.equals(this.host, other.host)
            && Objects.equals(this.publishHost, other.publishHost);
    }
}
