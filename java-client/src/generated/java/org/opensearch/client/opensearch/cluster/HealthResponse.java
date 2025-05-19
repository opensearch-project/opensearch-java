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

package org.opensearch.client.opensearch.cluster;

import jakarta.json.stream.JsonGenerator;
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
import org.opensearch.client.opensearch._types.HealthStatus;
import org.opensearch.client.opensearch._types.Time;
import org.opensearch.client.opensearch.cluster.health.AwarenessAttributeStats;
import org.opensearch.client.opensearch.cluster.health.IndexHealthStats;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: cluster.health.Response

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class HealthResponse implements PlainJsonSerializable, ToCopyableBuilder<HealthResponse.Builder, HealthResponse> {

    private final int activePrimaryShards;

    private final int activeShards;

    @Nullable
    private final String activeShardsPercent;

    private final double activeShardsPercentAsNumber;

    @Nonnull
    private final Map<String, AwarenessAttributeStats> awarenessAttributes;

    @Nonnull
    private final String clusterName;

    private final int delayedUnassignedShards;

    @Nullable
    private final Boolean discoveredClusterManager;

    @Nullable
    private final Boolean discoveredMaster;

    @Nonnull
    private final Map<String, IndexHealthStats> indices;

    private final int initializingShards;

    private final int numberOfDataNodes;

    private final int numberOfInFlightFetch;

    private final int numberOfNodes;

    private final int numberOfPendingTasks;

    private final int relocatingShards;

    @Nonnull
    private final HealthStatus status;

    @Nullable
    private final Time taskMaxWaitingInQueue;

    private final long taskMaxWaitingInQueueMillis;

    private final boolean timedOut;

    private final int unassignedShards;

    // ---------------------------------------------------------------------------------------------

    private HealthResponse(Builder builder) {
        this.activePrimaryShards = ApiTypeHelper.requireNonNull(builder.activePrimaryShards, this, "activePrimaryShards");
        this.activeShards = ApiTypeHelper.requireNonNull(builder.activeShards, this, "activeShards");
        this.activeShardsPercent = builder.activeShardsPercent;
        this.activeShardsPercentAsNumber = ApiTypeHelper.requireNonNull(
            builder.activeShardsPercentAsNumber,
            this,
            "activeShardsPercentAsNumber"
        );
        this.awarenessAttributes = ApiTypeHelper.unmodifiable(builder.awarenessAttributes);
        this.clusterName = ApiTypeHelper.requireNonNull(builder.clusterName, this, "clusterName");
        this.delayedUnassignedShards = ApiTypeHelper.requireNonNull(builder.delayedUnassignedShards, this, "delayedUnassignedShards");
        this.discoveredClusterManager = builder.discoveredClusterManager;
        this.discoveredMaster = builder.discoveredMaster;
        this.indices = ApiTypeHelper.unmodifiable(builder.indices);
        this.initializingShards = ApiTypeHelper.requireNonNull(builder.initializingShards, this, "initializingShards");
        this.numberOfDataNodes = ApiTypeHelper.requireNonNull(builder.numberOfDataNodes, this, "numberOfDataNodes");
        this.numberOfInFlightFetch = ApiTypeHelper.requireNonNull(builder.numberOfInFlightFetch, this, "numberOfInFlightFetch");
        this.numberOfNodes = ApiTypeHelper.requireNonNull(builder.numberOfNodes, this, "numberOfNodes");
        this.numberOfPendingTasks = ApiTypeHelper.requireNonNull(builder.numberOfPendingTasks, this, "numberOfPendingTasks");
        this.relocatingShards = ApiTypeHelper.requireNonNull(builder.relocatingShards, this, "relocatingShards");
        this.status = ApiTypeHelper.requireNonNull(builder.status, this, "status");
        this.taskMaxWaitingInQueue = builder.taskMaxWaitingInQueue;
        this.taskMaxWaitingInQueueMillis = ApiTypeHelper.requireNonNull(
            builder.taskMaxWaitingInQueueMillis,
            this,
            "taskMaxWaitingInQueueMillis"
        );
        this.timedOut = ApiTypeHelper.requireNonNull(builder.timedOut, this, "timedOut");
        this.unassignedShards = ApiTypeHelper.requireNonNull(builder.unassignedShards, this, "unassignedShards");
    }

    public static HealthResponse of(Function<HealthResponse.Builder, ObjectBuilder<HealthResponse>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - The number of active primary shards.
     * <p>
     * API name: {@code active_primary_shards}
     * </p>
     */
    public final int activePrimaryShards() {
        return this.activePrimaryShards;
    }

    /**
     * Required - The total number of active primary and replica shards.
     * <p>
     * API name: {@code active_shards}
     * </p>
     */
    public final int activeShards() {
        return this.activeShards;
    }

    /**
     * API name: {@code active_shards_percent}
     */
    @Nullable
    public final String activeShardsPercent() {
        return this.activeShardsPercent;
    }

    /**
     * Required - API name: {@code active_shards_percent_as_number}
     */
    public final double activeShardsPercentAsNumber() {
        return this.activeShardsPercentAsNumber;
    }

    /**
     * Cluster health information for each awareness attribute.
     * <p>
     * API name: {@code awareness_attributes}
     * </p>
     */
    @Nonnull
    public final Map<String, AwarenessAttributeStats> awarenessAttributes() {
        return this.awarenessAttributes;
    }

    /**
     * Required - API name: {@code cluster_name}
     */
    @Nonnull
    public final String clusterName() {
        return this.clusterName;
    }

    /**
     * Required - The number of shards whose allocation has been delayed by the timeout settings.
     * <p>
     * API name: {@code delayed_unassigned_shards}
     * </p>
     */
    public final int delayedUnassignedShards() {
        return this.delayedUnassignedShards;
    }

    /**
     * True if the cluster-manager node has been discovered.
     * <p>
     * API name: {@code discovered_cluster_manager}
     * </p>
     */
    @Nullable
    public final Boolean discoveredClusterManager() {
        return this.discoveredClusterManager;
    }

    /**
     * True if the cluster-manager node has been discovered.
     * <p>
     * API name: {@code discovered_master}
     * </p>
     */
    @Nullable
    public final Boolean discoveredMaster() {
        return this.discoveredMaster;
    }

    /**
     * API name: {@code indices}
     */
    @Nonnull
    public final Map<String, IndexHealthStats> indices() {
        return this.indices;
    }

    /**
     * Required - The number of shards that are under initialization.
     * <p>
     * API name: {@code initializing_shards}
     * </p>
     */
    public final int initializingShards() {
        return this.initializingShards;
    }

    /**
     * Required - The number of nodes that are dedicated data nodes.
     * <p>
     * API name: {@code number_of_data_nodes}
     * </p>
     */
    public final int numberOfDataNodes() {
        return this.numberOfDataNodes;
    }

    /**
     * Required - The number of unfinished fetches.
     * <p>
     * API name: {@code number_of_in_flight_fetch}
     * </p>
     */
    public final int numberOfInFlightFetch() {
        return this.numberOfInFlightFetch;
    }

    /**
     * Required - The number of nodes within the cluster.
     * <p>
     * API name: {@code number_of_nodes}
     * </p>
     */
    public final int numberOfNodes() {
        return this.numberOfNodes;
    }

    /**
     * Required - The number of cluster-level changes that have not yet been executed.
     * <p>
     * API name: {@code number_of_pending_tasks}
     * </p>
     */
    public final int numberOfPendingTasks() {
        return this.numberOfPendingTasks;
    }

    /**
     * Required - The number of shards that are under relocation.
     * <p>
     * API name: {@code relocating_shards}
     * </p>
     */
    public final int relocatingShards() {
        return this.relocatingShards;
    }

    /**
     * Required - API name: {@code status}
     */
    @Nonnull
    public final HealthStatus status() {
        return this.status;
    }

    /**
     * API name: {@code task_max_waiting_in_queue}
     */
    @Nullable
    public final Time taskMaxWaitingInQueue() {
        return this.taskMaxWaitingInQueue;
    }

    /**
     * Required - API name: {@code task_max_waiting_in_queue_millis}
     */
    public final long taskMaxWaitingInQueueMillis() {
        return this.taskMaxWaitingInQueueMillis;
    }

    /**
     * Required - If <code>false</code> the response returned within the period of time that is specified by the timeout parameter
     * (<code>30s</code> by default).
     * <p>
     * API name: {@code timed_out}
     * </p>
     */
    public final boolean timedOut() {
        return this.timedOut;
    }

    /**
     * Required - The number of shards that are not allocated.
     * <p>
     * API name: {@code unassigned_shards}
     * </p>
     */
    public final int unassignedShards() {
        return this.unassignedShards;
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
        generator.writeKey("active_primary_shards");
        generator.write(this.activePrimaryShards);

        generator.writeKey("active_shards");
        generator.write(this.activeShards);

        if (this.activeShardsPercent != null) {
            generator.writeKey("active_shards_percent");
            generator.write(this.activeShardsPercent);
        }

        generator.writeKey("active_shards_percent_as_number");
        generator.write(this.activeShardsPercentAsNumber);

        if (ApiTypeHelper.isDefined(this.awarenessAttributes)) {
            generator.writeKey("awareness_attributes");
            generator.writeStartObject();
            for (Map.Entry<String, AwarenessAttributeStats> item0 : this.awarenessAttributes.entrySet()) {
                generator.writeKey(item0.getKey());
                item0.getValue().serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        generator.writeKey("cluster_name");
        generator.write(this.clusterName);

        generator.writeKey("delayed_unassigned_shards");
        generator.write(this.delayedUnassignedShards);

        if (this.discoveredClusterManager != null) {
            generator.writeKey("discovered_cluster_manager");
            generator.write(this.discoveredClusterManager);
        }

        if (this.discoveredMaster != null) {
            generator.writeKey("discovered_master");
            generator.write(this.discoveredMaster);
        }

        if (ApiTypeHelper.isDefined(this.indices)) {
            generator.writeKey("indices");
            generator.writeStartObject();
            for (Map.Entry<String, IndexHealthStats> item0 : this.indices.entrySet()) {
                generator.writeKey(item0.getKey());
                item0.getValue().serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        generator.writeKey("initializing_shards");
        generator.write(this.initializingShards);

        generator.writeKey("number_of_data_nodes");
        generator.write(this.numberOfDataNodes);

        generator.writeKey("number_of_in_flight_fetch");
        generator.write(this.numberOfInFlightFetch);

        generator.writeKey("number_of_nodes");
        generator.write(this.numberOfNodes);

        generator.writeKey("number_of_pending_tasks");
        generator.write(this.numberOfPendingTasks);

        generator.writeKey("relocating_shards");
        generator.write(this.relocatingShards);

        generator.writeKey("status");
        this.status.serialize(generator, mapper);

        if (this.taskMaxWaitingInQueue != null) {
            generator.writeKey("task_max_waiting_in_queue");
            this.taskMaxWaitingInQueue.serialize(generator, mapper);
        }

        generator.writeKey("task_max_waiting_in_queue_millis");
        generator.write(this.taskMaxWaitingInQueueMillis);

        generator.writeKey("timed_out");
        generator.write(this.timedOut);

        generator.writeKey("unassigned_shards");
        generator.write(this.unassignedShards);
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
     * Builder for {@link HealthResponse}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, HealthResponse> {
        private Integer activePrimaryShards;
        private Integer activeShards;
        @Nullable
        private String activeShardsPercent;
        private Double activeShardsPercentAsNumber;
        @Nullable
        private Map<String, AwarenessAttributeStats> awarenessAttributes;
        private String clusterName;
        private Integer delayedUnassignedShards;
        @Nullable
        private Boolean discoveredClusterManager;
        @Nullable
        private Boolean discoveredMaster;
        @Nullable
        private Map<String, IndexHealthStats> indices;
        private Integer initializingShards;
        private Integer numberOfDataNodes;
        private Integer numberOfInFlightFetch;
        private Integer numberOfNodes;
        private Integer numberOfPendingTasks;
        private Integer relocatingShards;
        private HealthStatus status;
        @Nullable
        private Time taskMaxWaitingInQueue;
        private Long taskMaxWaitingInQueueMillis;
        private Boolean timedOut;
        private Integer unassignedShards;

        public Builder() {}

        private Builder(HealthResponse o) {
            this.activePrimaryShards = o.activePrimaryShards;
            this.activeShards = o.activeShards;
            this.activeShardsPercent = o.activeShardsPercent;
            this.activeShardsPercentAsNumber = o.activeShardsPercentAsNumber;
            this.awarenessAttributes = _mapCopy(o.awarenessAttributes);
            this.clusterName = o.clusterName;
            this.delayedUnassignedShards = o.delayedUnassignedShards;
            this.discoveredClusterManager = o.discoveredClusterManager;
            this.discoveredMaster = o.discoveredMaster;
            this.indices = _mapCopy(o.indices);
            this.initializingShards = o.initializingShards;
            this.numberOfDataNodes = o.numberOfDataNodes;
            this.numberOfInFlightFetch = o.numberOfInFlightFetch;
            this.numberOfNodes = o.numberOfNodes;
            this.numberOfPendingTasks = o.numberOfPendingTasks;
            this.relocatingShards = o.relocatingShards;
            this.status = o.status;
            this.taskMaxWaitingInQueue = o.taskMaxWaitingInQueue;
            this.taskMaxWaitingInQueueMillis = o.taskMaxWaitingInQueueMillis;
            this.timedOut = o.timedOut;
            this.unassignedShards = o.unassignedShards;
        }

        private Builder(Builder o) {
            this.activePrimaryShards = o.activePrimaryShards;
            this.activeShards = o.activeShards;
            this.activeShardsPercent = o.activeShardsPercent;
            this.activeShardsPercentAsNumber = o.activeShardsPercentAsNumber;
            this.awarenessAttributes = _mapCopy(o.awarenessAttributes);
            this.clusterName = o.clusterName;
            this.delayedUnassignedShards = o.delayedUnassignedShards;
            this.discoveredClusterManager = o.discoveredClusterManager;
            this.discoveredMaster = o.discoveredMaster;
            this.indices = _mapCopy(o.indices);
            this.initializingShards = o.initializingShards;
            this.numberOfDataNodes = o.numberOfDataNodes;
            this.numberOfInFlightFetch = o.numberOfInFlightFetch;
            this.numberOfNodes = o.numberOfNodes;
            this.numberOfPendingTasks = o.numberOfPendingTasks;
            this.relocatingShards = o.relocatingShards;
            this.status = o.status;
            this.taskMaxWaitingInQueue = o.taskMaxWaitingInQueue;
            this.taskMaxWaitingInQueueMillis = o.taskMaxWaitingInQueueMillis;
            this.timedOut = o.timedOut;
            this.unassignedShards = o.unassignedShards;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - The number of active primary shards.
         * <p>
         * API name: {@code active_primary_shards}
         * </p>
         */
        @Nonnull
        public final Builder activePrimaryShards(int value) {
            this.activePrimaryShards = value;
            return this;
        }

        /**
         * Required - The total number of active primary and replica shards.
         * <p>
         * API name: {@code active_shards}
         * </p>
         */
        @Nonnull
        public final Builder activeShards(int value) {
            this.activeShards = value;
            return this;
        }

        /**
         * API name: {@code active_shards_percent}
         */
        @Nonnull
        public final Builder activeShardsPercent(@Nullable String value) {
            this.activeShardsPercent = value;
            return this;
        }

        /**
         * Required - API name: {@code active_shards_percent_as_number}
         */
        @Nonnull
        public final Builder activeShardsPercentAsNumber(double value) {
            this.activeShardsPercentAsNumber = value;
            return this;
        }

        /**
         * Cluster health information for each awareness attribute.
         * <p>
         * API name: {@code awareness_attributes}
         * </p>
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>awarenessAttributes</code>.
         * </p>
         */
        @Nonnull
        public final Builder awarenessAttributes(Map<String, AwarenessAttributeStats> map) {
            this.awarenessAttributes = _mapPutAll(this.awarenessAttributes, map);
            return this;
        }

        /**
         * Cluster health information for each awareness attribute.
         * <p>
         * API name: {@code awareness_attributes}
         * </p>
         *
         * <p>
         * Adds an entry to <code>awarenessAttributes</code>.
         * </p>
         */
        @Nonnull
        public final Builder awarenessAttributes(String key, AwarenessAttributeStats value) {
            this.awarenessAttributes = _mapPut(this.awarenessAttributes, key, value);
            return this;
        }

        /**
         * Cluster health information for each awareness attribute.
         * <p>
         * API name: {@code awareness_attributes}
         * </p>
         *
         * <p>
         * Adds a value to <code>awarenessAttributes</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder awarenessAttributes(
            String key,
            Function<AwarenessAttributeStats.Builder, ObjectBuilder<AwarenessAttributeStats>> fn
        ) {
            return awarenessAttributes(key, fn.apply(new AwarenessAttributeStats.Builder()).build());
        }

        /**
         * Required - API name: {@code cluster_name}
         */
        @Nonnull
        public final Builder clusterName(String value) {
            this.clusterName = value;
            return this;
        }

        /**
         * Required - The number of shards whose allocation has been delayed by the timeout settings.
         * <p>
         * API name: {@code delayed_unassigned_shards}
         * </p>
         */
        @Nonnull
        public final Builder delayedUnassignedShards(int value) {
            this.delayedUnassignedShards = value;
            return this;
        }

        /**
         * True if the cluster-manager node has been discovered.
         * <p>
         * API name: {@code discovered_cluster_manager}
         * </p>
         */
        @Nonnull
        public final Builder discoveredClusterManager(@Nullable Boolean value) {
            this.discoveredClusterManager = value;
            return this;
        }

        /**
         * True if the cluster-manager node has been discovered.
         * <p>
         * API name: {@code discovered_master}
         * </p>
         */
        @Nonnull
        public final Builder discoveredMaster(@Nullable Boolean value) {
            this.discoveredMaster = value;
            return this;
        }

        /**
         * API name: {@code indices}
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>indices</code>.
         * </p>
         */
        @Nonnull
        public final Builder indices(Map<String, IndexHealthStats> map) {
            this.indices = _mapPutAll(this.indices, map);
            return this;
        }

        /**
         * API name: {@code indices}
         *
         * <p>
         * Adds an entry to <code>indices</code>.
         * </p>
         */
        @Nonnull
        public final Builder indices(String key, IndexHealthStats value) {
            this.indices = _mapPut(this.indices, key, value);
            return this;
        }

        /**
         * API name: {@code indices}
         *
         * <p>
         * Adds a value to <code>indices</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder indices(String key, Function<IndexHealthStats.Builder, ObjectBuilder<IndexHealthStats>> fn) {
            return indices(key, fn.apply(new IndexHealthStats.Builder()).build());
        }

        /**
         * Required - The number of shards that are under initialization.
         * <p>
         * API name: {@code initializing_shards}
         * </p>
         */
        @Nonnull
        public final Builder initializingShards(int value) {
            this.initializingShards = value;
            return this;
        }

        /**
         * Required - The number of nodes that are dedicated data nodes.
         * <p>
         * API name: {@code number_of_data_nodes}
         * </p>
         */
        @Nonnull
        public final Builder numberOfDataNodes(int value) {
            this.numberOfDataNodes = value;
            return this;
        }

        /**
         * Required - The number of unfinished fetches.
         * <p>
         * API name: {@code number_of_in_flight_fetch}
         * </p>
         */
        @Nonnull
        public final Builder numberOfInFlightFetch(int value) {
            this.numberOfInFlightFetch = value;
            return this;
        }

        /**
         * Required - The number of nodes within the cluster.
         * <p>
         * API name: {@code number_of_nodes}
         * </p>
         */
        @Nonnull
        public final Builder numberOfNodes(int value) {
            this.numberOfNodes = value;
            return this;
        }

        /**
         * Required - The number of cluster-level changes that have not yet been executed.
         * <p>
         * API name: {@code number_of_pending_tasks}
         * </p>
         */
        @Nonnull
        public final Builder numberOfPendingTasks(int value) {
            this.numberOfPendingTasks = value;
            return this;
        }

        /**
         * Required - The number of shards that are under relocation.
         * <p>
         * API name: {@code relocating_shards}
         * </p>
         */
        @Nonnull
        public final Builder relocatingShards(int value) {
            this.relocatingShards = value;
            return this;
        }

        /**
         * Required - API name: {@code status}
         */
        @Nonnull
        public final Builder status(HealthStatus value) {
            this.status = value;
            return this;
        }

        /**
         * API name: {@code task_max_waiting_in_queue}
         */
        @Nonnull
        public final Builder taskMaxWaitingInQueue(@Nullable Time value) {
            this.taskMaxWaitingInQueue = value;
            return this;
        }

        /**
         * API name: {@code task_max_waiting_in_queue}
         */
        @Nonnull
        public final Builder taskMaxWaitingInQueue(Function<Time.Builder, ObjectBuilder<Time>> fn) {
            return taskMaxWaitingInQueue(fn.apply(new Time.Builder()).build());
        }

        /**
         * Required - API name: {@code task_max_waiting_in_queue_millis}
         */
        @Nonnull
        public final Builder taskMaxWaitingInQueueMillis(long value) {
            this.taskMaxWaitingInQueueMillis = value;
            return this;
        }

        /**
         * Required - If <code>false</code> the response returned within the period of time that is specified by the timeout parameter
         * (<code>30s</code> by default).
         * <p>
         * API name: {@code timed_out}
         * </p>
         */
        @Nonnull
        public final Builder timedOut(boolean value) {
            this.timedOut = value;
            return this;
        }

        /**
         * Required - The number of shards that are not allocated.
         * <p>
         * API name: {@code unassigned_shards}
         * </p>
         */
        @Nonnull
        public final Builder unassignedShards(int value) {
            this.unassignedShards = value;
            return this;
        }

        /**
         * Builds a {@link HealthResponse}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public HealthResponse build() {
            _checkSingleUse();

            return new HealthResponse(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link HealthResponse}
     */
    public static final JsonpDeserializer<HealthResponse> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        HealthResponse::setupHealthResponseDeserializer
    );

    protected static void setupHealthResponseDeserializer(ObjectDeserializer<HealthResponse.Builder> op) {
        op.add(Builder::activePrimaryShards, JsonpDeserializer.integerDeserializer(), "active_primary_shards");
        op.add(Builder::activeShards, JsonpDeserializer.integerDeserializer(), "active_shards");
        op.add(Builder::activeShardsPercent, JsonpDeserializer.stringDeserializer(), "active_shards_percent");
        op.add(Builder::activeShardsPercentAsNumber, JsonpDeserializer.doubleDeserializer(), "active_shards_percent_as_number");
        op.add(
            Builder::awarenessAttributes,
            JsonpDeserializer.stringMapDeserializer(AwarenessAttributeStats._DESERIALIZER),
            "awareness_attributes"
        );
        op.add(Builder::clusterName, JsonpDeserializer.stringDeserializer(), "cluster_name");
        op.add(Builder::delayedUnassignedShards, JsonpDeserializer.integerDeserializer(), "delayed_unassigned_shards");
        op.add(Builder::discoveredClusterManager, JsonpDeserializer.booleanDeserializer(), "discovered_cluster_manager");
        op.add(Builder::discoveredMaster, JsonpDeserializer.booleanDeserializer(), "discovered_master");
        op.add(Builder::indices, JsonpDeserializer.stringMapDeserializer(IndexHealthStats._DESERIALIZER), "indices");
        op.add(Builder::initializingShards, JsonpDeserializer.integerDeserializer(), "initializing_shards");
        op.add(Builder::numberOfDataNodes, JsonpDeserializer.integerDeserializer(), "number_of_data_nodes");
        op.add(Builder::numberOfInFlightFetch, JsonpDeserializer.integerDeserializer(), "number_of_in_flight_fetch");
        op.add(Builder::numberOfNodes, JsonpDeserializer.integerDeserializer(), "number_of_nodes");
        op.add(Builder::numberOfPendingTasks, JsonpDeserializer.integerDeserializer(), "number_of_pending_tasks");
        op.add(Builder::relocatingShards, JsonpDeserializer.integerDeserializer(), "relocating_shards");
        op.add(Builder::status, HealthStatus._DESERIALIZER, "status");
        op.add(Builder::taskMaxWaitingInQueue, Time._DESERIALIZER, "task_max_waiting_in_queue");
        op.add(Builder::taskMaxWaitingInQueueMillis, JsonpDeserializer.longDeserializer(), "task_max_waiting_in_queue_millis");
        op.add(Builder::timedOut, JsonpDeserializer.booleanDeserializer(), "timed_out");
        op.add(Builder::unassignedShards, JsonpDeserializer.integerDeserializer(), "unassigned_shards");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Integer.hashCode(this.activePrimaryShards);
        result = 31 * result + Integer.hashCode(this.activeShards);
        result = 31 * result + Objects.hashCode(this.activeShardsPercent);
        result = 31 * result + Double.hashCode(this.activeShardsPercentAsNumber);
        result = 31 * result + Objects.hashCode(this.awarenessAttributes);
        result = 31 * result + this.clusterName.hashCode();
        result = 31 * result + Integer.hashCode(this.delayedUnassignedShards);
        result = 31 * result + Objects.hashCode(this.discoveredClusterManager);
        result = 31 * result + Objects.hashCode(this.discoveredMaster);
        result = 31 * result + Objects.hashCode(this.indices);
        result = 31 * result + Integer.hashCode(this.initializingShards);
        result = 31 * result + Integer.hashCode(this.numberOfDataNodes);
        result = 31 * result + Integer.hashCode(this.numberOfInFlightFetch);
        result = 31 * result + Integer.hashCode(this.numberOfNodes);
        result = 31 * result + Integer.hashCode(this.numberOfPendingTasks);
        result = 31 * result + Integer.hashCode(this.relocatingShards);
        result = 31 * result + this.status.hashCode();
        result = 31 * result + Objects.hashCode(this.taskMaxWaitingInQueue);
        result = 31 * result + Long.hashCode(this.taskMaxWaitingInQueueMillis);
        result = 31 * result + Boolean.hashCode(this.timedOut);
        result = 31 * result + Integer.hashCode(this.unassignedShards);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        HealthResponse other = (HealthResponse) o;
        return this.activePrimaryShards == other.activePrimaryShards
            && this.activeShards == other.activeShards
            && Objects.equals(this.activeShardsPercent, other.activeShardsPercent)
            && this.activeShardsPercentAsNumber == other.activeShardsPercentAsNumber
            && Objects.equals(this.awarenessAttributes, other.awarenessAttributes)
            && this.clusterName.equals(other.clusterName)
            && this.delayedUnassignedShards == other.delayedUnassignedShards
            && Objects.equals(this.discoveredClusterManager, other.discoveredClusterManager)
            && Objects.equals(this.discoveredMaster, other.discoveredMaster)
            && Objects.equals(this.indices, other.indices)
            && this.initializingShards == other.initializingShards
            && this.numberOfDataNodes == other.numberOfDataNodes
            && this.numberOfInFlightFetch == other.numberOfInFlightFetch
            && this.numberOfNodes == other.numberOfNodes
            && this.numberOfPendingTasks == other.numberOfPendingTasks
            && this.relocatingShards == other.relocatingShards
            && this.status.equals(other.status)
            && Objects.equals(this.taskMaxWaitingInQueue, other.taskMaxWaitingInQueue)
            && this.taskMaxWaitingInQueueMillis == other.taskMaxWaitingInQueueMillis
            && this.timedOut == other.timedOut
            && this.unassignedShards == other.unassignedShards;
    }
}
