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
import java.util.List;
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

// typedef: cluster.remote_info.ClusterRemoteSniffInfo

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class ClusterRemoteSniffInfo
    implements
        ClusterRemoteInfoVariant,
        PlainJsonSerializable,
        ToCopyableBuilder<ClusterRemoteSniffInfo.Builder, ClusterRemoteSniffInfo> {

    private final boolean connected;

    @Nonnull
    private final Time initialConnectTimeout;

    private final int maxConnectionsPerCluster;

    private final long numNodesConnected;

    @Nonnull
    private final List<String> seeds;

    private final boolean skipUnavailable;

    // ---------------------------------------------------------------------------------------------

    private ClusterRemoteSniffInfo(Builder builder) {
        this.connected = ApiTypeHelper.requireNonNull(builder.connected, this, "connected");
        this.initialConnectTimeout = ApiTypeHelper.requireNonNull(builder.initialConnectTimeout, this, "initialConnectTimeout");
        this.maxConnectionsPerCluster = ApiTypeHelper.requireNonNull(builder.maxConnectionsPerCluster, this, "maxConnectionsPerCluster");
        this.numNodesConnected = ApiTypeHelper.requireNonNull(builder.numNodesConnected, this, "numNodesConnected");
        this.seeds = ApiTypeHelper.unmodifiableRequired(builder.seeds, this, "seeds");
        this.skipUnavailable = ApiTypeHelper.requireNonNull(builder.skipUnavailable, this, "skipUnavailable");
    }

    public static ClusterRemoteSniffInfo of(Function<ClusterRemoteSniffInfo.Builder, ObjectBuilder<ClusterRemoteSniffInfo>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link ClusterRemoteInfo} variant kind.
     */
    @Override
    public ClusterRemoteInfo.Kind _clusterRemoteInfoKind() {
        return ClusterRemoteInfo.Kind.Sniff;
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
     * Required - API name: {@code max_connections_per_cluster}
     */
    public final int maxConnectionsPerCluster() {
        return this.maxConnectionsPerCluster;
    }

    /**
     * Required - API name: {@code num_nodes_connected}
     */
    public final long numNodesConnected() {
        return this.numNodesConnected;
    }

    /**
     * Required - API name: {@code seeds}
     */
    @Nonnull
    public final List<String> seeds() {
        return this.seeds;
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
        generator.write("mode", "sniff");
        generator.writeKey("connected");
        generator.write(this.connected);

        generator.writeKey("initial_connect_timeout");
        this.initialConnectTimeout.serialize(generator, mapper);

        generator.writeKey("max_connections_per_cluster");
        generator.write(this.maxConnectionsPerCluster);

        generator.writeKey("num_nodes_connected");
        generator.write(this.numNodesConnected);

        generator.writeKey("seeds");
        generator.writeStartArray();
        for (String item0 : this.seeds) {
            generator.write(item0);
        }
        generator.writeEnd();

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
     * Builder for {@link ClusterRemoteSniffInfo}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, ClusterRemoteSniffInfo> {
        private Boolean connected;
        private Time initialConnectTimeout;
        private Integer maxConnectionsPerCluster;
        private Long numNodesConnected;
        private List<String> seeds;
        private Boolean skipUnavailable;

        public Builder() {}

        private Builder(ClusterRemoteSniffInfo o) {
            this.connected = o.connected;
            this.initialConnectTimeout = o.initialConnectTimeout;
            this.maxConnectionsPerCluster = o.maxConnectionsPerCluster;
            this.numNodesConnected = o.numNodesConnected;
            this.seeds = _listCopy(o.seeds);
            this.skipUnavailable = o.skipUnavailable;
        }

        private Builder(Builder o) {
            this.connected = o.connected;
            this.initialConnectTimeout = o.initialConnectTimeout;
            this.maxConnectionsPerCluster = o.maxConnectionsPerCluster;
            this.numNodesConnected = o.numNodesConnected;
            this.seeds = _listCopy(o.seeds);
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
         * Required - API name: {@code max_connections_per_cluster}
         */
        @Nonnull
        public final Builder maxConnectionsPerCluster(int value) {
            this.maxConnectionsPerCluster = value;
            return this;
        }

        /**
         * Required - API name: {@code num_nodes_connected}
         */
        @Nonnull
        public final Builder numNodesConnected(long value) {
            this.numNodesConnected = value;
            return this;
        }

        /**
         * Required - API name: {@code seeds}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>seeds</code>.
         * </p>
         */
        @Nonnull
        public final Builder seeds(List<String> list) {
            this.seeds = _listAddAll(this.seeds, list);
            return this;
        }

        /**
         * Required - API name: {@code seeds}
         *
         * <p>
         * Adds one or more values to <code>seeds</code>.
         * </p>
         */
        @Nonnull
        public final Builder seeds(String value, String... values) {
            this.seeds = _listAdd(this.seeds, value, values);
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
         * Builds a {@link ClusterRemoteSniffInfo}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ClusterRemoteSniffInfo build() {
            _checkSingleUse();

            return new ClusterRemoteSniffInfo(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ClusterRemoteSniffInfo}
     */
    public static final JsonpDeserializer<ClusterRemoteSniffInfo> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ClusterRemoteSniffInfo::setupClusterRemoteSniffInfoDeserializer
    );

    protected static void setupClusterRemoteSniffInfoDeserializer(ObjectDeserializer<ClusterRemoteSniffInfo.Builder> op) {
        op.add(Builder::connected, JsonpDeserializer.booleanDeserializer(), "connected");
        op.add(Builder::initialConnectTimeout, Time._DESERIALIZER, "initial_connect_timeout");
        op.add(Builder::maxConnectionsPerCluster, JsonpDeserializer.integerDeserializer(), "max_connections_per_cluster");
        op.add(Builder::numNodesConnected, JsonpDeserializer.longDeserializer(), "num_nodes_connected");
        op.add(Builder::seeds, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "seeds");
        op.add(Builder::skipUnavailable, JsonpDeserializer.booleanDeserializer(), "skip_unavailable");

        op.ignore("mode");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Boolean.hashCode(this.connected);
        result = 31 * result + this.initialConnectTimeout.hashCode();
        result = 31 * result + Integer.hashCode(this.maxConnectionsPerCluster);
        result = 31 * result + Long.hashCode(this.numNodesConnected);
        result = 31 * result + this.seeds.hashCode();
        result = 31 * result + Boolean.hashCode(this.skipUnavailable);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ClusterRemoteSniffInfo other = (ClusterRemoteSniffInfo) o;
        return this.connected == other.connected
            && this.initialConnectTimeout.equals(other.initialConnectTimeout)
            && this.maxConnectionsPerCluster == other.maxConnectionsPerCluster
            && this.numNodesConnected == other.numNodesConnected
            && this.seeds.equals(other.seeds)
            && this.skipUnavailable == other.skipUnavailable;
    }
}
