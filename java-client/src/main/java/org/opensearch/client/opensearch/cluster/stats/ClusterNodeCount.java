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

package org.opensearch.client.opensearch.cluster.stats;

import jakarta.json.stream.JsonGenerator;
import java.util.function.Function;
import javax.annotation.Nullable;
import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.JsonpSerializable;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;

// typedef: cluster.stats.ClusterNodeCount

@JsonpDeserializable
public class ClusterNodeCount implements JsonpSerializable {
    private final int coordinatingOnly;

    private final int data;

    private final int ingest;

    @Deprecated
    private final Integer master;

    private final Integer clusterManager;

    private final int total;

    private final int remoteClusterClient;

    @Nullable
    private final Integer search;

    // ---------------------------------------------------------------------------------------------

    private ClusterNodeCount(Builder builder) {

        this.coordinatingOnly = ApiTypeHelper.requireNonNull(builder.coordinatingOnly, this, "coordinatingOnly");
        this.data = ApiTypeHelper.requireNonNull(builder.data, this, "data");
        this.ingest = ApiTypeHelper.requireNonNull(builder.ingest, this, "ingest");
        this.master = builder.master;
        this.clusterManager = builder.clusterManager;
        this.total = ApiTypeHelper.requireNonNull(builder.total, this, "total");
        this.remoteClusterClient = ApiTypeHelper.requireNonNull(builder.remoteClusterClient, this, "remoteClusterClient");
        this.search = builder.search;
    }

    public static ClusterNodeCount of(Function<Builder, ObjectBuilder<ClusterNodeCount>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code coordinating_only}
     */
    public final int coordinatingOnly() {
        return this.coordinatingOnly;
    }

    /**
     * Required - API name: {@code data}
     */
    public final int data() {
        return this.data;
    }

    /**
     * Required - API name: {@code ingest}
     */
    public final int ingest() {
        return this.ingest;
    }

    /**
     * API name: {@code master}
     */
    @Deprecated
    public final int master() {
        return this.master;
    }

    /**
     * API name: {@code clusterManager}
     */
    public final int clusterManager() {
        return this.clusterManager;
    }

    /**
     * Required - API name: {@code total}
     */
    public final int total() {
        return this.total;
    }

    /**
     * Required - API name: {@code remote_cluster_client}
     */
    public final int remoteClusterClient() {
        return this.remoteClusterClient;
    }

    /**
     * API name: {@code search}
     */
    @Nullable
    public final Integer search() {
        return this.search;
    }

    /**
     * Serialize this object to JSON.
     */
    public void serialize(JsonGenerator generator, JsonpMapper mapper) {
        generator.writeStartObject();
        serializeInternal(generator, mapper);
        generator.writeEnd();
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {

        generator.writeKey("coordinating_only");
        generator.write(this.coordinatingOnly);

        generator.writeKey("data");
        generator.write(this.data);

        generator.writeKey("ingest");
        generator.write(this.ingest);

        if (this.master != null) {
            generator.writeKey("master");
            generator.write(this.master);
        }

        if (this.clusterManager != null) {
            generator.writeKey("cluster_manager");
            generator.write(this.clusterManager);
        }

        generator.writeKey("total");
        generator.write(this.total);

        generator.writeKey("remote_cluster_client");
        generator.write(this.remoteClusterClient);

        if (this.search != null) {
            generator.writeKey("search");
            generator.write(this.search);
        }

    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Builder for {@link ClusterNodeCount}.
     */

    public static class Builder extends ObjectBuilderBase implements ObjectBuilder<ClusterNodeCount> {
        private Integer coordinatingOnly;

        private Integer data;

        private Integer ingest;

        private Integer master;

        private Integer clusterManager;

        private Integer total;

        private Integer remoteClusterClient;

        private Integer search;

        /**
         * Required - API name: {@code coordinating_only}
         */
        public final Builder coordinatingOnly(int value) {
            this.coordinatingOnly = value;
            return this;
        }

        /**
         * Required - API name: {@code data}
         */
        public final Builder data(int value) {
            this.data = value;
            return this;
        }

        /**
         * Required - API name: {@code ingest}
         */
        public final Builder ingest(int value) {
            this.ingest = value;
            return this;
        }

        /**
         * API name: {@code master}
         */
        @Deprecated
        public final Builder master(int value) {
            this.master = value;
            return this;
        }

        /**
         * API name: {@code clusterManager}
         */
        public final Builder clusterManager(int value) {
            this.clusterManager = value;
            return this;
        }

        /**
         * Required - API name: {@code total}
         */
        public final Builder total(int value) {
            this.total = value;
            return this;
        }

        /**
         * Required - API name: {@code remote_cluster_client}
         */
        public final Builder remoteClusterClient(int value) {
            this.remoteClusterClient = value;
            return this;
        }

        /**
         * API name: {@code search}
         */
        @Nullable
        public final Builder search(int value) {
            this.search = value;
            return this;
        }

        /**
         * Builds a {@link ClusterNodeCount}.
         *
         * @throws NullPointerException
         *             if some of the required fields are null.
         */
        public ClusterNodeCount build() {
            _checkSingleUse();

            return new ClusterNodeCount(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ClusterNodeCount}
     */
    public static final JsonpDeserializer<ClusterNodeCount> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ClusterNodeCount::setupClusterNodeCountDeserializer
    );

    protected static void setupClusterNodeCountDeserializer(ObjectDeserializer<ClusterNodeCount.Builder> op) {

        op.add(Builder::coordinatingOnly, JsonpDeserializer.integerDeserializer(), "coordinating_only");
        op.add(Builder::data, JsonpDeserializer.integerDeserializer(), "data");
        op.add(Builder::ingest, JsonpDeserializer.integerDeserializer(), "ingest");
        op.add(Builder::master, JsonpDeserializer.integerDeserializer(), "master");
        op.add(Builder::clusterManager, JsonpDeserializer.integerDeserializer(), "cluster_manager");
        op.add(Builder::total, JsonpDeserializer.integerDeserializer(), "total");
        op.add(Builder::remoteClusterClient, JsonpDeserializer.integerDeserializer(), "remote_cluster_client");
        op.add(Builder::search, JsonpDeserializer.integerDeserializer(), "search");

    }

}
