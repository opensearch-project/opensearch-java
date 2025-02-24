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

package org.opensearch.client.opensearch.cat.health;

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
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: cat.health.HealthRecord

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class HealthRecord implements PlainJsonSerializable, ToCopyableBuilder<HealthRecord.Builder, HealthRecord> {

    @Nullable
    private final String activeShardsPercent;

    @Nullable
    private final String cluster;

    @Nullable
    private final String discoveredClusterManager;

    @Nullable
    private final Long epoch;

    @Nullable
    private final String init;

    @Nullable
    private final String maxTaskWaitTime;

    @Nullable
    private final String nodeData;

    @Nullable
    private final String nodeTotal;

    @Nullable
    private final String pendingTasks;

    @Nullable
    private final String pri;

    @Nullable
    private final String relo;

    @Nullable
    private final String shards;

    @Nullable
    private final String status;

    @Nullable
    private final String timestamp;

    @Nullable
    private final String unassign;

    // ---------------------------------------------------------------------------------------------

    private HealthRecord(Builder builder) {
        this.activeShardsPercent = builder.activeShardsPercent;
        this.cluster = builder.cluster;
        this.discoveredClusterManager = builder.discoveredClusterManager;
        this.epoch = builder.epoch;
        this.init = builder.init;
        this.maxTaskWaitTime = builder.maxTaskWaitTime;
        this.nodeData = builder.nodeData;
        this.nodeTotal = builder.nodeTotal;
        this.pendingTasks = builder.pendingTasks;
        this.pri = builder.pri;
        this.relo = builder.relo;
        this.shards = builder.shards;
        this.status = builder.status;
        this.timestamp = builder.timestamp;
        this.unassign = builder.unassign;
    }

    public static HealthRecord of(Function<HealthRecord.Builder, ObjectBuilder<HealthRecord>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * active number of shards in percent
     * <p>
     * API name: {@code active_shards_percent}
     * </p>
     */
    @Nullable
    public final String activeShardsPercent() {
        return this.activeShardsPercent;
    }

    /**
     * cluster name
     * <p>
     * API name: {@code cluster}
     * </p>
     */
    @Nullable
    public final String cluster() {
        return this.cluster;
    }

    /**
     * cluster manager is discovered or not
     * <p>
     * API name: {@code discovered_cluster_manager}
     * </p>
     */
    @Nullable
    public final String discoveredClusterManager() {
        return this.discoveredClusterManager;
    }

    /**
     * API name: {@code epoch}
     */
    @Nullable
    public final Long epoch() {
        return this.epoch;
    }

    /**
     * number of initializing nodes
     * <p>
     * API name: {@code init}
     * </p>
     */
    @Nullable
    public final String init() {
        return this.init;
    }

    /**
     * wait time of longest task pending
     * <p>
     * API name: {@code max_task_wait_time}
     * </p>
     */
    @Nullable
    public final String maxTaskWaitTime() {
        return this.maxTaskWaitTime;
    }

    /**
     * number of nodes that can store data
     * <p>
     * API name: {@code node.data}
     * </p>
     */
    @Nullable
    public final String nodeData() {
        return this.nodeData;
    }

    /**
     * total number of nodes
     * <p>
     * API name: {@code node.total}
     * </p>
     */
    @Nullable
    public final String nodeTotal() {
        return this.nodeTotal;
    }

    /**
     * number of pending tasks
     * <p>
     * API name: {@code pending_tasks}
     * </p>
     */
    @Nullable
    public final String pendingTasks() {
        return this.pendingTasks;
    }

    /**
     * number of primary shards
     * <p>
     * API name: {@code pri}
     * </p>
     */
    @Nullable
    public final String pri() {
        return this.pri;
    }

    /**
     * number of relocating nodes
     * <p>
     * API name: {@code relo}
     * </p>
     */
    @Nullable
    public final String relo() {
        return this.relo;
    }

    /**
     * total number of shards
     * <p>
     * API name: {@code shards}
     * </p>
     */
    @Nullable
    public final String shards() {
        return this.shards;
    }

    /**
     * health status
     * <p>
     * API name: {@code status}
     * </p>
     */
    @Nullable
    public final String status() {
        return this.status;
    }

    /**
     * API name: {@code timestamp}
     */
    @Nullable
    public final String timestamp() {
        return this.timestamp;
    }

    /**
     * number of unassigned shards
     * <p>
     * API name: {@code unassign}
     * </p>
     */
    @Nullable
    public final String unassign() {
        return this.unassign;
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
        if (this.activeShardsPercent != null) {
            generator.writeKey("active_shards_percent");
            generator.write(this.activeShardsPercent);
        }

        if (this.cluster != null) {
            generator.writeKey("cluster");
            generator.write(this.cluster);
        }

        if (this.discoveredClusterManager != null) {
            generator.writeKey("discovered_cluster_manager");
            generator.write(this.discoveredClusterManager);
        }

        if (this.epoch != null) {
            generator.writeKey("epoch");
            generator.write(this.epoch);
        }

        if (this.init != null) {
            generator.writeKey("init");
            generator.write(this.init);
        }

        if (this.maxTaskWaitTime != null) {
            generator.writeKey("max_task_wait_time");
            generator.write(this.maxTaskWaitTime);
        }

        if (this.nodeData != null) {
            generator.writeKey("node.data");
            generator.write(this.nodeData);
        }

        if (this.nodeTotal != null) {
            generator.writeKey("node.total");
            generator.write(this.nodeTotal);
        }

        if (this.pendingTasks != null) {
            generator.writeKey("pending_tasks");
            generator.write(this.pendingTasks);
        }

        if (this.pri != null) {
            generator.writeKey("pri");
            generator.write(this.pri);
        }

        if (this.relo != null) {
            generator.writeKey("relo");
            generator.write(this.relo);
        }

        if (this.shards != null) {
            generator.writeKey("shards");
            generator.write(this.shards);
        }

        if (this.status != null) {
            generator.writeKey("status");
            generator.write(this.status);
        }

        if (this.timestamp != null) {
            generator.writeKey("timestamp");
            generator.write(this.timestamp);
        }

        if (this.unassign != null) {
            generator.writeKey("unassign");
            generator.write(this.unassign);
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
     * Builder for {@link HealthRecord}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, HealthRecord> {
        @Nullable
        private String activeShardsPercent;
        @Nullable
        private String cluster;
        @Nullable
        private String discoveredClusterManager;
        @Nullable
        private Long epoch;
        @Nullable
        private String init;
        @Nullable
        private String maxTaskWaitTime;
        @Nullable
        private String nodeData;
        @Nullable
        private String nodeTotal;
        @Nullable
        private String pendingTasks;
        @Nullable
        private String pri;
        @Nullable
        private String relo;
        @Nullable
        private String shards;
        @Nullable
        private String status;
        @Nullable
        private String timestamp;
        @Nullable
        private String unassign;

        public Builder() {}

        private Builder(HealthRecord o) {
            this.activeShardsPercent = o.activeShardsPercent;
            this.cluster = o.cluster;
            this.discoveredClusterManager = o.discoveredClusterManager;
            this.epoch = o.epoch;
            this.init = o.init;
            this.maxTaskWaitTime = o.maxTaskWaitTime;
            this.nodeData = o.nodeData;
            this.nodeTotal = o.nodeTotal;
            this.pendingTasks = o.pendingTasks;
            this.pri = o.pri;
            this.relo = o.relo;
            this.shards = o.shards;
            this.status = o.status;
            this.timestamp = o.timestamp;
            this.unassign = o.unassign;
        }

        private Builder(Builder o) {
            this.activeShardsPercent = o.activeShardsPercent;
            this.cluster = o.cluster;
            this.discoveredClusterManager = o.discoveredClusterManager;
            this.epoch = o.epoch;
            this.init = o.init;
            this.maxTaskWaitTime = o.maxTaskWaitTime;
            this.nodeData = o.nodeData;
            this.nodeTotal = o.nodeTotal;
            this.pendingTasks = o.pendingTasks;
            this.pri = o.pri;
            this.relo = o.relo;
            this.shards = o.shards;
            this.status = o.status;
            this.timestamp = o.timestamp;
            this.unassign = o.unassign;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * active number of shards in percent
         * <p>
         * API name: {@code active_shards_percent}
         * </p>
         */
        @Nonnull
        public final Builder activeShardsPercent(@Nullable String value) {
            this.activeShardsPercent = value;
            return this;
        }

        /**
         * cluster name
         * <p>
         * API name: {@code cluster}
         * </p>
         */
        @Nonnull
        public final Builder cluster(@Nullable String value) {
            this.cluster = value;
            return this;
        }

        /**
         * cluster manager is discovered or not
         * <p>
         * API name: {@code discovered_cluster_manager}
         * </p>
         */
        @Nonnull
        public final Builder discoveredClusterManager(@Nullable String value) {
            this.discoveredClusterManager = value;
            return this;
        }

        /**
         * API name: {@code epoch}
         */
        @Nonnull
        public final Builder epoch(@Nullable Long value) {
            this.epoch = value;
            return this;
        }

        /**
         * number of initializing nodes
         * <p>
         * API name: {@code init}
         * </p>
         */
        @Nonnull
        public final Builder init(@Nullable String value) {
            this.init = value;
            return this;
        }

        /**
         * wait time of longest task pending
         * <p>
         * API name: {@code max_task_wait_time}
         * </p>
         */
        @Nonnull
        public final Builder maxTaskWaitTime(@Nullable String value) {
            this.maxTaskWaitTime = value;
            return this;
        }

        /**
         * number of nodes that can store data
         * <p>
         * API name: {@code node.data}
         * </p>
         */
        @Nonnull
        public final Builder nodeData(@Nullable String value) {
            this.nodeData = value;
            return this;
        }

        /**
         * total number of nodes
         * <p>
         * API name: {@code node.total}
         * </p>
         */
        @Nonnull
        public final Builder nodeTotal(@Nullable String value) {
            this.nodeTotal = value;
            return this;
        }

        /**
         * number of pending tasks
         * <p>
         * API name: {@code pending_tasks}
         * </p>
         */
        @Nonnull
        public final Builder pendingTasks(@Nullable String value) {
            this.pendingTasks = value;
            return this;
        }

        /**
         * number of primary shards
         * <p>
         * API name: {@code pri}
         * </p>
         */
        @Nonnull
        public final Builder pri(@Nullable String value) {
            this.pri = value;
            return this;
        }

        /**
         * number of relocating nodes
         * <p>
         * API name: {@code relo}
         * </p>
         */
        @Nonnull
        public final Builder relo(@Nullable String value) {
            this.relo = value;
            return this;
        }

        /**
         * total number of shards
         * <p>
         * API name: {@code shards}
         * </p>
         */
        @Nonnull
        public final Builder shards(@Nullable String value) {
            this.shards = value;
            return this;
        }

        /**
         * health status
         * <p>
         * API name: {@code status}
         * </p>
         */
        @Nonnull
        public final Builder status(@Nullable String value) {
            this.status = value;
            return this;
        }

        /**
         * API name: {@code timestamp}
         */
        @Nonnull
        public final Builder timestamp(@Nullable String value) {
            this.timestamp = value;
            return this;
        }

        /**
         * number of unassigned shards
         * <p>
         * API name: {@code unassign}
         * </p>
         */
        @Nonnull
        public final Builder unassign(@Nullable String value) {
            this.unassign = value;
            return this;
        }

        /**
         * Builds a {@link HealthRecord}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public HealthRecord build() {
            _checkSingleUse();

            return new HealthRecord(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link HealthRecord}
     */
    public static final JsonpDeserializer<HealthRecord> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        HealthRecord::setupHealthRecordDeserializer
    );

    protected static void setupHealthRecordDeserializer(ObjectDeserializer<HealthRecord.Builder> op) {
        op.add(Builder::activeShardsPercent, JsonpDeserializer.stringDeserializer(), "active_shards_percent");
        op.add(Builder::cluster, JsonpDeserializer.stringDeserializer(), "cluster");
        op.add(Builder::discoveredClusterManager, JsonpDeserializer.stringDeserializer(), "discovered_cluster_manager");
        op.add(Builder::epoch, JsonpDeserializer.longDeserializer(), "epoch");
        op.add(Builder::init, JsonpDeserializer.stringDeserializer(), "init");
        op.add(Builder::maxTaskWaitTime, JsonpDeserializer.stringDeserializer(), "max_task_wait_time");
        op.add(Builder::nodeData, JsonpDeserializer.stringDeserializer(), "node.data");
        op.add(Builder::nodeTotal, JsonpDeserializer.stringDeserializer(), "node.total");
        op.add(Builder::pendingTasks, JsonpDeserializer.stringDeserializer(), "pending_tasks");
        op.add(Builder::pri, JsonpDeserializer.stringDeserializer(), "pri");
        op.add(Builder::relo, JsonpDeserializer.stringDeserializer(), "relo");
        op.add(Builder::shards, JsonpDeserializer.stringDeserializer(), "shards");
        op.add(Builder::status, JsonpDeserializer.stringDeserializer(), "status");
        op.add(Builder::timestamp, JsonpDeserializer.stringDeserializer(), "timestamp");
        op.add(Builder::unassign, JsonpDeserializer.stringDeserializer(), "unassign");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.activeShardsPercent);
        result = 31 * result + Objects.hashCode(this.cluster);
        result = 31 * result + Objects.hashCode(this.discoveredClusterManager);
        result = 31 * result + Objects.hashCode(this.epoch);
        result = 31 * result + Objects.hashCode(this.init);
        result = 31 * result + Objects.hashCode(this.maxTaskWaitTime);
        result = 31 * result + Objects.hashCode(this.nodeData);
        result = 31 * result + Objects.hashCode(this.nodeTotal);
        result = 31 * result + Objects.hashCode(this.pendingTasks);
        result = 31 * result + Objects.hashCode(this.pri);
        result = 31 * result + Objects.hashCode(this.relo);
        result = 31 * result + Objects.hashCode(this.shards);
        result = 31 * result + Objects.hashCode(this.status);
        result = 31 * result + Objects.hashCode(this.timestamp);
        result = 31 * result + Objects.hashCode(this.unassign);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        HealthRecord other = (HealthRecord) o;
        return Objects.equals(this.activeShardsPercent, other.activeShardsPercent)
            && Objects.equals(this.cluster, other.cluster)
            && Objects.equals(this.discoveredClusterManager, other.discoveredClusterManager)
            && Objects.equals(this.epoch, other.epoch)
            && Objects.equals(this.init, other.init)
            && Objects.equals(this.maxTaskWaitTime, other.maxTaskWaitTime)
            && Objects.equals(this.nodeData, other.nodeData)
            && Objects.equals(this.nodeTotal, other.nodeTotal)
            && Objects.equals(this.pendingTasks, other.pendingTasks)
            && Objects.equals(this.pri, other.pri)
            && Objects.equals(this.relo, other.relo)
            && Objects.equals(this.shards, other.shards)
            && Objects.equals(this.status, other.status)
            && Objects.equals(this.timestamp, other.timestamp)
            && Objects.equals(this.unassign, other.unassign);
    }
}
