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

package org.opensearch.client.opensearch.cluster.stats;

import jakarta.json.stream.JsonGenerator;
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

// typedef: cluster.stats.ClusterNodeCount

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class ClusterNodeCount implements PlainJsonSerializable, ToCopyableBuilder<ClusterNodeCount.Builder, ClusterNodeCount> {

    @Nullable
    private final Integer clusterManager;

    private final int coordinatingOnly;

    private final int data;

    @Nullable
    private final Integer dataCold;

    @Nullable
    private final Integer dataContent;

    @Nullable
    private final Integer dataFrozen;

    @Nullable
    private final Integer dataHot;

    @Nullable
    private final Integer dataWarm;

    private final int ingest;

    private final int master;

    @Nullable
    private final Integer ml;

    private final int remoteClusterClient;

    @Nullable
    private final Integer search;

    private final int total;

    @Nullable
    private final Integer transform;

    @Nullable
    private final Integer votingOnly;

    // ---------------------------------------------------------------------------------------------

    private ClusterNodeCount(Builder builder) {
        this.clusterManager = builder.clusterManager;
        this.coordinatingOnly = ApiTypeHelper.requireNonNull(builder.coordinatingOnly, this, "coordinatingOnly");
        this.data = ApiTypeHelper.requireNonNull(builder.data, this, "data");
        this.dataCold = builder.dataCold;
        this.dataContent = builder.dataContent;
        this.dataFrozen = builder.dataFrozen;
        this.dataHot = builder.dataHot;
        this.dataWarm = builder.dataWarm;
        this.ingest = ApiTypeHelper.requireNonNull(builder.ingest, this, "ingest");
        this.master = ApiTypeHelper.requireNonNull(builder.master, this, "master");
        this.ml = builder.ml;
        this.remoteClusterClient = ApiTypeHelper.requireNonNull(builder.remoteClusterClient, this, "remoteClusterClient");
        this.search = builder.search;
        this.total = ApiTypeHelper.requireNonNull(builder.total, this, "total");
        this.transform = builder.transform;
        this.votingOnly = builder.votingOnly;
    }

    public static ClusterNodeCount of(Function<ClusterNodeCount.Builder, ObjectBuilder<ClusterNodeCount>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code cluster_manager}
     */
    @Nullable
    public final Integer clusterManager() {
        return this.clusterManager;
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
     * API name: {@code data_cold}
     */
    @Nullable
    public final Integer dataCold() {
        return this.dataCold;
    }

    /**
     * API name: {@code data_content}
     */
    @Nullable
    public final Integer dataContent() {
        return this.dataContent;
    }

    /**
     * API name: {@code data_frozen}
     */
    @Nullable
    public final Integer dataFrozen() {
        return this.dataFrozen;
    }

    /**
     * API name: {@code data_hot}
     */
    @Nullable
    public final Integer dataHot() {
        return this.dataHot;
    }

    /**
     * API name: {@code data_warm}
     */
    @Nullable
    public final Integer dataWarm() {
        return this.dataWarm;
    }

    /**
     * Required - API name: {@code ingest}
     */
    public final int ingest() {
        return this.ingest;
    }

    /**
     * Required - API name: {@code master}
     */
    public final int master() {
        return this.master;
    }

    /**
     * API name: {@code ml}
     */
    @Nullable
    public final Integer ml() {
        return this.ml;
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
     * Required - API name: {@code total}
     */
    public final int total() {
        return this.total;
    }

    /**
     * API name: {@code transform}
     */
    @Nullable
    public final Integer transform() {
        return this.transform;
    }

    /**
     * API name: {@code voting_only}
     */
    @Nullable
    public final Integer votingOnly() {
        return this.votingOnly;
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
        if (this.clusterManager != null) {
            generator.writeKey("cluster_manager");
            generator.write(this.clusterManager);
        }

        generator.writeKey("coordinating_only");
        generator.write(this.coordinatingOnly);

        generator.writeKey("data");
        generator.write(this.data);

        if (this.dataCold != null) {
            generator.writeKey("data_cold");
            generator.write(this.dataCold);
        }

        if (this.dataContent != null) {
            generator.writeKey("data_content");
            generator.write(this.dataContent);
        }

        if (this.dataFrozen != null) {
            generator.writeKey("data_frozen");
            generator.write(this.dataFrozen);
        }

        if (this.dataHot != null) {
            generator.writeKey("data_hot");
            generator.write(this.dataHot);
        }

        if (this.dataWarm != null) {
            generator.writeKey("data_warm");
            generator.write(this.dataWarm);
        }

        generator.writeKey("ingest");
        generator.write(this.ingest);

        generator.writeKey("master");
        generator.write(this.master);

        if (this.ml != null) {
            generator.writeKey("ml");
            generator.write(this.ml);
        }

        generator.writeKey("remote_cluster_client");
        generator.write(this.remoteClusterClient);

        if (this.search != null) {
            generator.writeKey("search");
            generator.write(this.search);
        }

        generator.writeKey("total");
        generator.write(this.total);

        if (this.transform != null) {
            generator.writeKey("transform");
            generator.write(this.transform);
        }

        if (this.votingOnly != null) {
            generator.writeKey("voting_only");
            generator.write(this.votingOnly);
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
     * Builder for {@link ClusterNodeCount}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, ClusterNodeCount> {
        @Nullable
        private Integer clusterManager;
        private Integer coordinatingOnly;
        private Integer data;
        @Nullable
        private Integer dataCold;
        @Nullable
        private Integer dataContent;
        @Nullable
        private Integer dataFrozen;
        @Nullable
        private Integer dataHot;
        @Nullable
        private Integer dataWarm;
        private Integer ingest;
        private Integer master;
        @Nullable
        private Integer ml;
        private Integer remoteClusterClient;
        @Nullable
        private Integer search;
        private Integer total;
        @Nullable
        private Integer transform;
        @Nullable
        private Integer votingOnly;

        public Builder() {}

        private Builder(ClusterNodeCount o) {
            this.clusterManager = o.clusterManager;
            this.coordinatingOnly = o.coordinatingOnly;
            this.data = o.data;
            this.dataCold = o.dataCold;
            this.dataContent = o.dataContent;
            this.dataFrozen = o.dataFrozen;
            this.dataHot = o.dataHot;
            this.dataWarm = o.dataWarm;
            this.ingest = o.ingest;
            this.master = o.master;
            this.ml = o.ml;
            this.remoteClusterClient = o.remoteClusterClient;
            this.search = o.search;
            this.total = o.total;
            this.transform = o.transform;
            this.votingOnly = o.votingOnly;
        }

        private Builder(Builder o) {
            this.clusterManager = o.clusterManager;
            this.coordinatingOnly = o.coordinatingOnly;
            this.data = o.data;
            this.dataCold = o.dataCold;
            this.dataContent = o.dataContent;
            this.dataFrozen = o.dataFrozen;
            this.dataHot = o.dataHot;
            this.dataWarm = o.dataWarm;
            this.ingest = o.ingest;
            this.master = o.master;
            this.ml = o.ml;
            this.remoteClusterClient = o.remoteClusterClient;
            this.search = o.search;
            this.total = o.total;
            this.transform = o.transform;
            this.votingOnly = o.votingOnly;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code cluster_manager}
         */
        @Nonnull
        public final Builder clusterManager(@Nullable Integer value) {
            this.clusterManager = value;
            return this;
        }

        /**
         * Required - API name: {@code coordinating_only}
         */
        @Nonnull
        public final Builder coordinatingOnly(int value) {
            this.coordinatingOnly = value;
            return this;
        }

        /**
         * Required - API name: {@code data}
         */
        @Nonnull
        public final Builder data(int value) {
            this.data = value;
            return this;
        }

        /**
         * API name: {@code data_cold}
         */
        @Nonnull
        public final Builder dataCold(@Nullable Integer value) {
            this.dataCold = value;
            return this;
        }

        /**
         * API name: {@code data_content}
         */
        @Nonnull
        public final Builder dataContent(@Nullable Integer value) {
            this.dataContent = value;
            return this;
        }

        /**
         * API name: {@code data_frozen}
         */
        @Nonnull
        public final Builder dataFrozen(@Nullable Integer value) {
            this.dataFrozen = value;
            return this;
        }

        /**
         * API name: {@code data_hot}
         */
        @Nonnull
        public final Builder dataHot(@Nullable Integer value) {
            this.dataHot = value;
            return this;
        }

        /**
         * API name: {@code data_warm}
         */
        @Nonnull
        public final Builder dataWarm(@Nullable Integer value) {
            this.dataWarm = value;
            return this;
        }

        /**
         * Required - API name: {@code ingest}
         */
        @Nonnull
        public final Builder ingest(int value) {
            this.ingest = value;
            return this;
        }

        /**
         * Required - API name: {@code master}
         */
        @Nonnull
        public final Builder master(int value) {
            this.master = value;
            return this;
        }

        /**
         * API name: {@code ml}
         */
        @Nonnull
        public final Builder ml(@Nullable Integer value) {
            this.ml = value;
            return this;
        }

        /**
         * Required - API name: {@code remote_cluster_client}
         */
        @Nonnull
        public final Builder remoteClusterClient(int value) {
            this.remoteClusterClient = value;
            return this;
        }

        /**
         * API name: {@code search}
         */
        @Nonnull
        public final Builder search(@Nullable Integer value) {
            this.search = value;
            return this;
        }

        /**
         * Required - API name: {@code total}
         */
        @Nonnull
        public final Builder total(int value) {
            this.total = value;
            return this;
        }

        /**
         * API name: {@code transform}
         */
        @Nonnull
        public final Builder transform(@Nullable Integer value) {
            this.transform = value;
            return this;
        }

        /**
         * API name: {@code voting_only}
         */
        @Nonnull
        public final Builder votingOnly(@Nullable Integer value) {
            this.votingOnly = value;
            return this;
        }

        /**
         * Builds a {@link ClusterNodeCount}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
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
        op.add(Builder::clusterManager, JsonpDeserializer.integerDeserializer(), "cluster_manager");
        op.add(Builder::coordinatingOnly, JsonpDeserializer.integerDeserializer(), "coordinating_only");
        op.add(Builder::data, JsonpDeserializer.integerDeserializer(), "data");
        op.add(Builder::dataCold, JsonpDeserializer.integerDeserializer(), "data_cold");
        op.add(Builder::dataContent, JsonpDeserializer.integerDeserializer(), "data_content");
        op.add(Builder::dataFrozen, JsonpDeserializer.integerDeserializer(), "data_frozen");
        op.add(Builder::dataHot, JsonpDeserializer.integerDeserializer(), "data_hot");
        op.add(Builder::dataWarm, JsonpDeserializer.integerDeserializer(), "data_warm");
        op.add(Builder::ingest, JsonpDeserializer.integerDeserializer(), "ingest");
        op.add(Builder::master, JsonpDeserializer.integerDeserializer(), "master");
        op.add(Builder::ml, JsonpDeserializer.integerDeserializer(), "ml");
        op.add(Builder::remoteClusterClient, JsonpDeserializer.integerDeserializer(), "remote_cluster_client");
        op.add(Builder::search, JsonpDeserializer.integerDeserializer(), "search");
        op.add(Builder::total, JsonpDeserializer.integerDeserializer(), "total");
        op.add(Builder::transform, JsonpDeserializer.integerDeserializer(), "transform");
        op.add(Builder::votingOnly, JsonpDeserializer.integerDeserializer(), "voting_only");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.clusterManager);
        result = 31 * result + Integer.hashCode(this.coordinatingOnly);
        result = 31 * result + Integer.hashCode(this.data);
        result = 31 * result + Objects.hashCode(this.dataCold);
        result = 31 * result + Objects.hashCode(this.dataContent);
        result = 31 * result + Objects.hashCode(this.dataFrozen);
        result = 31 * result + Objects.hashCode(this.dataHot);
        result = 31 * result + Objects.hashCode(this.dataWarm);
        result = 31 * result + Integer.hashCode(this.ingest);
        result = 31 * result + Integer.hashCode(this.master);
        result = 31 * result + Objects.hashCode(this.ml);
        result = 31 * result + Integer.hashCode(this.remoteClusterClient);
        result = 31 * result + Objects.hashCode(this.search);
        result = 31 * result + Integer.hashCode(this.total);
        result = 31 * result + Objects.hashCode(this.transform);
        result = 31 * result + Objects.hashCode(this.votingOnly);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ClusterNodeCount other = (ClusterNodeCount) o;
        return Objects.equals(this.clusterManager, other.clusterManager)
            && this.coordinatingOnly == other.coordinatingOnly
            && this.data == other.data
            && Objects.equals(this.dataCold, other.dataCold)
            && Objects.equals(this.dataContent, other.dataContent)
            && Objects.equals(this.dataFrozen, other.dataFrozen)
            && Objects.equals(this.dataHot, other.dataHot)
            && Objects.equals(this.dataWarm, other.dataWarm)
            && this.ingest == other.ingest
            && this.master == other.master
            && Objects.equals(this.ml, other.ml)
            && this.remoteClusterClient == other.remoteClusterClient
            && Objects.equals(this.search, other.search)
            && this.total == other.total
            && Objects.equals(this.transform, other.transform)
            && Objects.equals(this.votingOnly, other.votingOnly);
    }
}
