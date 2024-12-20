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

package org.opensearch.client.opensearch.cluster.remote_info;

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
import org.opensearch.client.opensearch._types.Time;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: cluster.remote_info.ClusterRemoteProxyInfo

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class ClusterRemoteProxyInfo
    implements
        ClusterRemoteInfoVariant,
        PlainJsonSerializable,
        ToCopyableBuilder<ClusterRemoteProxyInfo.Builder, ClusterRemoteProxyInfo> {

    private final boolean connected;

    @Nonnull
    private final Time initialConnectTimeout;

    private final int maxProxySocketConnections;

    private final int numProxySocketsConnected;

    @Nonnull
    private final String proxyAddress;

    @Nonnull
    private final String serverName;

    private final boolean skipUnavailable;

    // ---------------------------------------------------------------------------------------------

    private ClusterRemoteProxyInfo(Builder builder) {
        this.connected = ApiTypeHelper.requireNonNull(builder.connected, this, "connected");
        this.initialConnectTimeout = ApiTypeHelper.requireNonNull(builder.initialConnectTimeout, this, "initialConnectTimeout");
        this.maxProxySocketConnections = ApiTypeHelper.requireNonNull(builder.maxProxySocketConnections, this, "maxProxySocketConnections");
        this.numProxySocketsConnected = ApiTypeHelper.requireNonNull(builder.numProxySocketsConnected, this, "numProxySocketsConnected");
        this.proxyAddress = ApiTypeHelper.requireNonNull(builder.proxyAddress, this, "proxyAddress");
        this.serverName = ApiTypeHelper.requireNonNull(builder.serverName, this, "serverName");
        this.skipUnavailable = ApiTypeHelper.requireNonNull(builder.skipUnavailable, this, "skipUnavailable");
    }

    public static ClusterRemoteProxyInfo of(Function<ClusterRemoteProxyInfo.Builder, ObjectBuilder<ClusterRemoteProxyInfo>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link ClusterRemoteInfo} variant kind.
     */
    @Override
    public ClusterRemoteInfo.Kind _clusterRemoteInfoKind() {
        return ClusterRemoteInfo.Kind.Proxy;
    }

    /**
     * Required - API name: {@code connected}
     */
    public final boolean connected() {
        return this.connected;
    }

    /**
     * Required - API name: {@code initial_connect_timeout}
     */
    @Nonnull
    public final Time initialConnectTimeout() {
        return this.initialConnectTimeout;
    }

    /**
     * Required - API name: {@code max_proxy_socket_connections}
     */
    public final int maxProxySocketConnections() {
        return this.maxProxySocketConnections;
    }

    /**
     * Required - API name: {@code num_proxy_sockets_connected}
     */
    public final int numProxySocketsConnected() {
        return this.numProxySocketsConnected;
    }

    /**
     * Required - API name: {@code proxy_address}
     */
    @Nonnull
    public final String proxyAddress() {
        return this.proxyAddress;
    }

    /**
     * Required - API name: {@code server_name}
     */
    @Nonnull
    public final String serverName() {
        return this.serverName;
    }

    /**
     * Required - API name: {@code skip_unavailable}
     */
    public final boolean skipUnavailable() {
        return this.skipUnavailable;
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
        generator.write("mode", "proxy");
        generator.writeKey("connected");
        generator.write(this.connected);

        generator.writeKey("initial_connect_timeout");
        this.initialConnectTimeout.serialize(generator, mapper);

        generator.writeKey("max_proxy_socket_connections");
        generator.write(this.maxProxySocketConnections);

        generator.writeKey("num_proxy_sockets_connected");
        generator.write(this.numProxySocketsConnected);

        generator.writeKey("proxy_address");
        generator.write(this.proxyAddress);

        generator.writeKey("server_name");
        generator.write(this.serverName);

        generator.writeKey("skip_unavailable");
        generator.write(this.skipUnavailable);
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
     * Builder for {@link ClusterRemoteProxyInfo}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, ClusterRemoteProxyInfo> {
        private Boolean connected;
        private Time initialConnectTimeout;
        private Integer maxProxySocketConnections;
        private Integer numProxySocketsConnected;
        private String proxyAddress;
        private String serverName;
        private Boolean skipUnavailable;

        public Builder() {}

        private Builder(ClusterRemoteProxyInfo o) {
            this.connected = o.connected;
            this.initialConnectTimeout = o.initialConnectTimeout;
            this.maxProxySocketConnections = o.maxProxySocketConnections;
            this.numProxySocketsConnected = o.numProxySocketsConnected;
            this.proxyAddress = o.proxyAddress;
            this.serverName = o.serverName;
            this.skipUnavailable = o.skipUnavailable;
        }

        private Builder(Builder o) {
            this.connected = o.connected;
            this.initialConnectTimeout = o.initialConnectTimeout;
            this.maxProxySocketConnections = o.maxProxySocketConnections;
            this.numProxySocketsConnected = o.numProxySocketsConnected;
            this.proxyAddress = o.proxyAddress;
            this.serverName = o.serverName;
            this.skipUnavailable = o.skipUnavailable;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - API name: {@code connected}
         */
        @Nonnull
        public final Builder connected(boolean value) {
            this.connected = value;
            return this;
        }

        /**
         * Required - API name: {@code initial_connect_timeout}
         */
        @Nonnull
        public final Builder initialConnectTimeout(Time value) {
            this.initialConnectTimeout = value;
            return this;
        }

        /**
         * Required - API name: {@code initial_connect_timeout}
         */
        @Nonnull
        public final Builder initialConnectTimeout(Function<Time.Builder, ObjectBuilder<Time>> fn) {
            return initialConnectTimeout(fn.apply(new Time.Builder()).build());
        }

        /**
         * Required - API name: {@code max_proxy_socket_connections}
         */
        @Nonnull
        public final Builder maxProxySocketConnections(int value) {
            this.maxProxySocketConnections = value;
            return this;
        }

        /**
         * Required - API name: {@code num_proxy_sockets_connected}
         */
        @Nonnull
        public final Builder numProxySocketsConnected(int value) {
            this.numProxySocketsConnected = value;
            return this;
        }

        /**
         * Required - API name: {@code proxy_address}
         */
        @Nonnull
        public final Builder proxyAddress(String value) {
            this.proxyAddress = value;
            return this;
        }

        /**
         * Required - API name: {@code server_name}
         */
        @Nonnull
        public final Builder serverName(String value) {
            this.serverName = value;
            return this;
        }

        /**
         * Required - API name: {@code skip_unavailable}
         */
        @Nonnull
        public final Builder skipUnavailable(boolean value) {
            this.skipUnavailable = value;
            return this;
        }

        /**
         * Builds a {@link ClusterRemoteProxyInfo}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ClusterRemoteProxyInfo build() {
            _checkSingleUse();

            return new ClusterRemoteProxyInfo(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ClusterRemoteProxyInfo}
     */
    public static final JsonpDeserializer<ClusterRemoteProxyInfo> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ClusterRemoteProxyInfo::setupClusterRemoteProxyInfoDeserializer
    );

    protected static void setupClusterRemoteProxyInfoDeserializer(ObjectDeserializer<ClusterRemoteProxyInfo.Builder> op) {
        op.add(Builder::connected, JsonpDeserializer.booleanDeserializer(), "connected");
        op.add(Builder::initialConnectTimeout, Time._DESERIALIZER, "initial_connect_timeout");
        op.add(Builder::maxProxySocketConnections, JsonpDeserializer.integerDeserializer(), "max_proxy_socket_connections");
        op.add(Builder::numProxySocketsConnected, JsonpDeserializer.integerDeserializer(), "num_proxy_sockets_connected");
        op.add(Builder::proxyAddress, JsonpDeserializer.stringDeserializer(), "proxy_address");
        op.add(Builder::serverName, JsonpDeserializer.stringDeserializer(), "server_name");
        op.add(Builder::skipUnavailable, JsonpDeserializer.booleanDeserializer(), "skip_unavailable");

        op.ignore("mode");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Boolean.hashCode(this.connected);
        result = 31 * result + this.initialConnectTimeout.hashCode();
        result = 31 * result + Integer.hashCode(this.maxProxySocketConnections);
        result = 31 * result + Integer.hashCode(this.numProxySocketsConnected);
        result = 31 * result + this.proxyAddress.hashCode();
        result = 31 * result + this.serverName.hashCode();
        result = 31 * result + Boolean.hashCode(this.skipUnavailable);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ClusterRemoteProxyInfo other = (ClusterRemoteProxyInfo) o;
        return this.connected == other.connected
            && this.initialConnectTimeout.equals(other.initialConnectTimeout)
            && this.maxProxySocketConnections == other.maxProxySocketConnections
            && this.numProxySocketsConnected == other.numProxySocketsConnected
            && this.proxyAddress.equals(other.proxyAddress)
            && this.serverName.equals(other.serverName)
            && this.skipUnavailable == other.skipUnavailable;
    }
}
