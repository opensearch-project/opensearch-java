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
import org.opensearch.client.opensearch._types.Time;
import org.opensearch.client.opensearch.cluster.allocation_explain.AllocationDecision;
import org.opensearch.client.opensearch.cluster.allocation_explain.ClusterInfo;
import org.opensearch.client.opensearch.cluster.allocation_explain.CurrentNode;
import org.opensearch.client.opensearch.cluster.allocation_explain.Decision;
import org.opensearch.client.opensearch.cluster.allocation_explain.NodeAllocationExplanation;
import org.opensearch.client.opensearch.cluster.allocation_explain.UnassignedInformation;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: cluster.allocation_explain.Response

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class AllocationExplainResponse
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<AllocationExplainResponse.Builder, AllocationExplainResponse> {

    @Nullable
    private final String allocateExplanation;

    @Nullable
    private final Time allocationDelay;

    @Nullable
    private final Long allocationDelayInMillis;

    @Nullable
    private final Decision canAllocate;

    @Nullable
    private final Decision canMoveToOtherNode;

    @Nullable
    private final Decision canRebalanceCluster;

    @Nonnull
    private final List<AllocationDecision> canRebalanceClusterDecisions;

    @Nullable
    private final Decision canRebalanceToOtherNode;

    @Nonnull
    private final List<AllocationDecision> canRemainDecisions;

    @Nullable
    private final Decision canRemainOnCurrentNode;

    @Nullable
    private final ClusterInfo clusterInfo;

    @Nullable
    private final Time configuredDelay;

    @Nullable
    private final Long configuredDelayInMillis;

    @Nullable
    private final CurrentNode currentNode;

    @Nonnull
    private final String currentState;

    @Nonnull
    private final String index;

    @Nullable
    private final String moveExplanation;

    @Nonnull
    private final List<NodeAllocationExplanation> nodeAllocationDecisions;

    @Nullable
    private final String note;

    private final boolean primary;

    @Nullable
    private final String rebalanceExplanation;

    @Nullable
    private final Time remainingDelay;

    @Nullable
    private final Long remainingDelayInMillis;

    private final int shard;

    @Nullable
    private final UnassignedInformation unassignedInfo;

    // ---------------------------------------------------------------------------------------------

    private AllocationExplainResponse(Builder builder) {
        this.allocateExplanation = builder.allocateExplanation;
        this.allocationDelay = builder.allocationDelay;
        this.allocationDelayInMillis = builder.allocationDelayInMillis;
        this.canAllocate = builder.canAllocate;
        this.canMoveToOtherNode = builder.canMoveToOtherNode;
        this.canRebalanceCluster = builder.canRebalanceCluster;
        this.canRebalanceClusterDecisions = ApiTypeHelper.unmodifiable(builder.canRebalanceClusterDecisions);
        this.canRebalanceToOtherNode = builder.canRebalanceToOtherNode;
        this.canRemainDecisions = ApiTypeHelper.unmodifiable(builder.canRemainDecisions);
        this.canRemainOnCurrentNode = builder.canRemainOnCurrentNode;
        this.clusterInfo = builder.clusterInfo;
        this.configuredDelay = builder.configuredDelay;
        this.configuredDelayInMillis = builder.configuredDelayInMillis;
        this.currentNode = builder.currentNode;
        this.currentState = ApiTypeHelper.requireNonNull(builder.currentState, this, "currentState");
        this.index = ApiTypeHelper.requireNonNull(builder.index, this, "index");
        this.moveExplanation = builder.moveExplanation;
        this.nodeAllocationDecisions = ApiTypeHelper.unmodifiable(builder.nodeAllocationDecisions);
        this.note = builder.note;
        this.primary = ApiTypeHelper.requireNonNull(builder.primary, this, "primary");
        this.rebalanceExplanation = builder.rebalanceExplanation;
        this.remainingDelay = builder.remainingDelay;
        this.remainingDelayInMillis = builder.remainingDelayInMillis;
        this.shard = ApiTypeHelper.requireNonNull(builder.shard, this, "shard");
        this.unassignedInfo = builder.unassignedInfo;
    }

    public static AllocationExplainResponse of(Function<AllocationExplainResponse.Builder, ObjectBuilder<AllocationExplainResponse>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code allocate_explanation}
     */
    @Nullable
    public final String allocateExplanation() {
        return this.allocateExplanation;
    }

    /**
     * API name: {@code allocation_delay}
     */
    @Nullable
    public final Time allocationDelay() {
        return this.allocationDelay;
    }

    /**
     * API name: {@code allocation_delay_in_millis}
     */
    @Nullable
    public final Long allocationDelayInMillis() {
        return this.allocationDelayInMillis;
    }

    /**
     * API name: {@code can_allocate}
     */
    @Nullable
    public final Decision canAllocate() {
        return this.canAllocate;
    }

    /**
     * API name: {@code can_move_to_other_node}
     */
    @Nullable
    public final Decision canMoveToOtherNode() {
        return this.canMoveToOtherNode;
    }

    /**
     * API name: {@code can_rebalance_cluster}
     */
    @Nullable
    public final Decision canRebalanceCluster() {
        return this.canRebalanceCluster;
    }

    /**
     * API name: {@code can_rebalance_cluster_decisions}
     */
    @Nonnull
    public final List<AllocationDecision> canRebalanceClusterDecisions() {
        return this.canRebalanceClusterDecisions;
    }

    /**
     * API name: {@code can_rebalance_to_other_node}
     */
    @Nullable
    public final Decision canRebalanceToOtherNode() {
        return this.canRebalanceToOtherNode;
    }

    /**
     * API name: {@code can_remain_decisions}
     */
    @Nonnull
    public final List<AllocationDecision> canRemainDecisions() {
        return this.canRemainDecisions;
    }

    /**
     * API name: {@code can_remain_on_current_node}
     */
    @Nullable
    public final Decision canRemainOnCurrentNode() {
        return this.canRemainOnCurrentNode;
    }

    /**
     * API name: {@code cluster_info}
     */
    @Nullable
    public final ClusterInfo clusterInfo() {
        return this.clusterInfo;
    }

    /**
     * API name: {@code configured_delay}
     */
    @Nullable
    public final Time configuredDelay() {
        return this.configuredDelay;
    }

    /**
     * API name: {@code configured_delay_in_millis}
     */
    @Nullable
    public final Long configuredDelayInMillis() {
        return this.configuredDelayInMillis;
    }

    /**
     * API name: {@code current_node}
     */
    @Nullable
    public final CurrentNode currentNode() {
        return this.currentNode;
    }

    /**
     * Required - API name: {@code current_state}
     */
    @Nonnull
    public final String currentState() {
        return this.currentState;
    }

    /**
     * Required - API name: {@code index}
     */
    @Nonnull
    public final String index() {
        return this.index;
    }

    /**
     * API name: {@code move_explanation}
     */
    @Nullable
    public final String moveExplanation() {
        return this.moveExplanation;
    }

    /**
     * API name: {@code node_allocation_decisions}
     */
    @Nonnull
    public final List<NodeAllocationExplanation> nodeAllocationDecisions() {
        return this.nodeAllocationDecisions;
    }

    /**
     * API name: {@code note}
     */
    @Nullable
    public final String note() {
        return this.note;
    }

    /**
     * Required - API name: {@code primary}
     */
    public final boolean primary() {
        return this.primary;
    }

    /**
     * API name: {@code rebalance_explanation}
     */
    @Nullable
    public final String rebalanceExplanation() {
        return this.rebalanceExplanation;
    }

    /**
     * API name: {@code remaining_delay}
     */
    @Nullable
    public final Time remainingDelay() {
        return this.remainingDelay;
    }

    /**
     * API name: {@code remaining_delay_in_millis}
     */
    @Nullable
    public final Long remainingDelayInMillis() {
        return this.remainingDelayInMillis;
    }

    /**
     * Required - API name: {@code shard}
     */
    public final int shard() {
        return this.shard;
    }

    /**
     * API name: {@code unassigned_info}
     */
    @Nullable
    public final UnassignedInformation unassignedInfo() {
        return this.unassignedInfo;
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
        if (this.allocateExplanation != null) {
            generator.writeKey("allocate_explanation");
            generator.write(this.allocateExplanation);
        }

        if (this.allocationDelay != null) {
            generator.writeKey("allocation_delay");
            this.allocationDelay.serialize(generator, mapper);
        }

        if (this.allocationDelayInMillis != null) {
            generator.writeKey("allocation_delay_in_millis");
            generator.write(this.allocationDelayInMillis);
        }

        if (this.canAllocate != null) {
            generator.writeKey("can_allocate");
            this.canAllocate.serialize(generator, mapper);
        }

        if (this.canMoveToOtherNode != null) {
            generator.writeKey("can_move_to_other_node");
            this.canMoveToOtherNode.serialize(generator, mapper);
        }

        if (this.canRebalanceCluster != null) {
            generator.writeKey("can_rebalance_cluster");
            this.canRebalanceCluster.serialize(generator, mapper);
        }

        if (ApiTypeHelper.isDefined(this.canRebalanceClusterDecisions)) {
            generator.writeKey("can_rebalance_cluster_decisions");
            generator.writeStartArray();
            for (AllocationDecision item0 : this.canRebalanceClusterDecisions) {
                item0.serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (this.canRebalanceToOtherNode != null) {
            generator.writeKey("can_rebalance_to_other_node");
            this.canRebalanceToOtherNode.serialize(generator, mapper);
        }

        if (ApiTypeHelper.isDefined(this.canRemainDecisions)) {
            generator.writeKey("can_remain_decisions");
            generator.writeStartArray();
            for (AllocationDecision item0 : this.canRemainDecisions) {
                item0.serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (this.canRemainOnCurrentNode != null) {
            generator.writeKey("can_remain_on_current_node");
            this.canRemainOnCurrentNode.serialize(generator, mapper);
        }

        if (this.clusterInfo != null) {
            generator.writeKey("cluster_info");
            this.clusterInfo.serialize(generator, mapper);
        }

        if (this.configuredDelay != null) {
            generator.writeKey("configured_delay");
            this.configuredDelay.serialize(generator, mapper);
        }

        if (this.configuredDelayInMillis != null) {
            generator.writeKey("configured_delay_in_millis");
            generator.write(this.configuredDelayInMillis);
        }

        if (this.currentNode != null) {
            generator.writeKey("current_node");
            this.currentNode.serialize(generator, mapper);
        }

        generator.writeKey("current_state");
        generator.write(this.currentState);

        generator.writeKey("index");
        generator.write(this.index);

        if (this.moveExplanation != null) {
            generator.writeKey("move_explanation");
            generator.write(this.moveExplanation);
        }

        if (ApiTypeHelper.isDefined(this.nodeAllocationDecisions)) {
            generator.writeKey("node_allocation_decisions");
            generator.writeStartArray();
            for (NodeAllocationExplanation item0 : this.nodeAllocationDecisions) {
                item0.serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (this.note != null) {
            generator.writeKey("note");
            generator.write(this.note);
        }

        generator.writeKey("primary");
        generator.write(this.primary);

        if (this.rebalanceExplanation != null) {
            generator.writeKey("rebalance_explanation");
            generator.write(this.rebalanceExplanation);
        }

        if (this.remainingDelay != null) {
            generator.writeKey("remaining_delay");
            this.remainingDelay.serialize(generator, mapper);
        }

        if (this.remainingDelayInMillis != null) {
            generator.writeKey("remaining_delay_in_millis");
            generator.write(this.remainingDelayInMillis);
        }

        generator.writeKey("shard");
        generator.write(this.shard);

        if (this.unassignedInfo != null) {
            generator.writeKey("unassigned_info");
            this.unassignedInfo.serialize(generator, mapper);
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
     * Builder for {@link AllocationExplainResponse}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, AllocationExplainResponse> {
        @Nullable
        private String allocateExplanation;
        @Nullable
        private Time allocationDelay;
        @Nullable
        private Long allocationDelayInMillis;
        @Nullable
        private Decision canAllocate;
        @Nullable
        private Decision canMoveToOtherNode;
        @Nullable
        private Decision canRebalanceCluster;
        @Nullable
        private List<AllocationDecision> canRebalanceClusterDecisions;
        @Nullable
        private Decision canRebalanceToOtherNode;
        @Nullable
        private List<AllocationDecision> canRemainDecisions;
        @Nullable
        private Decision canRemainOnCurrentNode;
        @Nullable
        private ClusterInfo clusterInfo;
        @Nullable
        private Time configuredDelay;
        @Nullable
        private Long configuredDelayInMillis;
        @Nullable
        private CurrentNode currentNode;
        private String currentState;
        private String index;
        @Nullable
        private String moveExplanation;
        @Nullable
        private List<NodeAllocationExplanation> nodeAllocationDecisions;
        @Nullable
        private String note;
        private Boolean primary;
        @Nullable
        private String rebalanceExplanation;
        @Nullable
        private Time remainingDelay;
        @Nullable
        private Long remainingDelayInMillis;
        private Integer shard;
        @Nullable
        private UnassignedInformation unassignedInfo;

        public Builder() {}

        private Builder(AllocationExplainResponse o) {
            this.allocateExplanation = o.allocateExplanation;
            this.allocationDelay = o.allocationDelay;
            this.allocationDelayInMillis = o.allocationDelayInMillis;
            this.canAllocate = o.canAllocate;
            this.canMoveToOtherNode = o.canMoveToOtherNode;
            this.canRebalanceCluster = o.canRebalanceCluster;
            this.canRebalanceClusterDecisions = _listCopy(o.canRebalanceClusterDecisions);
            this.canRebalanceToOtherNode = o.canRebalanceToOtherNode;
            this.canRemainDecisions = _listCopy(o.canRemainDecisions);
            this.canRemainOnCurrentNode = o.canRemainOnCurrentNode;
            this.clusterInfo = o.clusterInfo;
            this.configuredDelay = o.configuredDelay;
            this.configuredDelayInMillis = o.configuredDelayInMillis;
            this.currentNode = o.currentNode;
            this.currentState = o.currentState;
            this.index = o.index;
            this.moveExplanation = o.moveExplanation;
            this.nodeAllocationDecisions = _listCopy(o.nodeAllocationDecisions);
            this.note = o.note;
            this.primary = o.primary;
            this.rebalanceExplanation = o.rebalanceExplanation;
            this.remainingDelay = o.remainingDelay;
            this.remainingDelayInMillis = o.remainingDelayInMillis;
            this.shard = o.shard;
            this.unassignedInfo = o.unassignedInfo;
        }

        private Builder(Builder o) {
            this.allocateExplanation = o.allocateExplanation;
            this.allocationDelay = o.allocationDelay;
            this.allocationDelayInMillis = o.allocationDelayInMillis;
            this.canAllocate = o.canAllocate;
            this.canMoveToOtherNode = o.canMoveToOtherNode;
            this.canRebalanceCluster = o.canRebalanceCluster;
            this.canRebalanceClusterDecisions = _listCopy(o.canRebalanceClusterDecisions);
            this.canRebalanceToOtherNode = o.canRebalanceToOtherNode;
            this.canRemainDecisions = _listCopy(o.canRemainDecisions);
            this.canRemainOnCurrentNode = o.canRemainOnCurrentNode;
            this.clusterInfo = o.clusterInfo;
            this.configuredDelay = o.configuredDelay;
            this.configuredDelayInMillis = o.configuredDelayInMillis;
            this.currentNode = o.currentNode;
            this.currentState = o.currentState;
            this.index = o.index;
            this.moveExplanation = o.moveExplanation;
            this.nodeAllocationDecisions = _listCopy(o.nodeAllocationDecisions);
            this.note = o.note;
            this.primary = o.primary;
            this.rebalanceExplanation = o.rebalanceExplanation;
            this.remainingDelay = o.remainingDelay;
            this.remainingDelayInMillis = o.remainingDelayInMillis;
            this.shard = o.shard;
            this.unassignedInfo = o.unassignedInfo;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code allocate_explanation}
         */
        @Nonnull
        public final Builder allocateExplanation(@Nullable String value) {
            this.allocateExplanation = value;
            return this;
        }

        /**
         * API name: {@code allocation_delay}
         */
        @Nonnull
        public final Builder allocationDelay(@Nullable Time value) {
            this.allocationDelay = value;
            return this;
        }

        /**
         * API name: {@code allocation_delay}
         */
        @Nonnull
        public final Builder allocationDelay(Function<Time.Builder, ObjectBuilder<Time>> fn) {
            return allocationDelay(fn.apply(new Time.Builder()).build());
        }

        /**
         * API name: {@code allocation_delay_in_millis}
         */
        @Nonnull
        public final Builder allocationDelayInMillis(@Nullable Long value) {
            this.allocationDelayInMillis = value;
            return this;
        }

        /**
         * API name: {@code can_allocate}
         */
        @Nonnull
        public final Builder canAllocate(@Nullable Decision value) {
            this.canAllocate = value;
            return this;
        }

        /**
         * API name: {@code can_move_to_other_node}
         */
        @Nonnull
        public final Builder canMoveToOtherNode(@Nullable Decision value) {
            this.canMoveToOtherNode = value;
            return this;
        }

        /**
         * API name: {@code can_rebalance_cluster}
         */
        @Nonnull
        public final Builder canRebalanceCluster(@Nullable Decision value) {
            this.canRebalanceCluster = value;
            return this;
        }

        /**
         * API name: {@code can_rebalance_cluster_decisions}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>canRebalanceClusterDecisions</code>.
         * </p>
         */
        @Nonnull
        public final Builder canRebalanceClusterDecisions(List<AllocationDecision> list) {
            this.canRebalanceClusterDecisions = _listAddAll(this.canRebalanceClusterDecisions, list);
            return this;
        }

        /**
         * API name: {@code can_rebalance_cluster_decisions}
         *
         * <p>
         * Adds one or more values to <code>canRebalanceClusterDecisions</code>.
         * </p>
         */
        @Nonnull
        public final Builder canRebalanceClusterDecisions(AllocationDecision value, AllocationDecision... values) {
            this.canRebalanceClusterDecisions = _listAdd(this.canRebalanceClusterDecisions, value, values);
            return this;
        }

        /**
         * API name: {@code can_rebalance_cluster_decisions}
         *
         * <p>
         * Adds a value to <code>canRebalanceClusterDecisions</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder canRebalanceClusterDecisions(Function<AllocationDecision.Builder, ObjectBuilder<AllocationDecision>> fn) {
            return canRebalanceClusterDecisions(fn.apply(new AllocationDecision.Builder()).build());
        }

        /**
         * API name: {@code can_rebalance_to_other_node}
         */
        @Nonnull
        public final Builder canRebalanceToOtherNode(@Nullable Decision value) {
            this.canRebalanceToOtherNode = value;
            return this;
        }

        /**
         * API name: {@code can_remain_decisions}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>canRemainDecisions</code>.
         * </p>
         */
        @Nonnull
        public final Builder canRemainDecisions(List<AllocationDecision> list) {
            this.canRemainDecisions = _listAddAll(this.canRemainDecisions, list);
            return this;
        }

        /**
         * API name: {@code can_remain_decisions}
         *
         * <p>
         * Adds one or more values to <code>canRemainDecisions</code>.
         * </p>
         */
        @Nonnull
        public final Builder canRemainDecisions(AllocationDecision value, AllocationDecision... values) {
            this.canRemainDecisions = _listAdd(this.canRemainDecisions, value, values);
            return this;
        }

        /**
         * API name: {@code can_remain_decisions}
         *
         * <p>
         * Adds a value to <code>canRemainDecisions</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder canRemainDecisions(Function<AllocationDecision.Builder, ObjectBuilder<AllocationDecision>> fn) {
            return canRemainDecisions(fn.apply(new AllocationDecision.Builder()).build());
        }

        /**
         * API name: {@code can_remain_on_current_node}
         */
        @Nonnull
        public final Builder canRemainOnCurrentNode(@Nullable Decision value) {
            this.canRemainOnCurrentNode = value;
            return this;
        }

        /**
         * API name: {@code cluster_info}
         */
        @Nonnull
        public final Builder clusterInfo(@Nullable ClusterInfo value) {
            this.clusterInfo = value;
            return this;
        }

        /**
         * API name: {@code cluster_info}
         */
        @Nonnull
        public final Builder clusterInfo(Function<ClusterInfo.Builder, ObjectBuilder<ClusterInfo>> fn) {
            return clusterInfo(fn.apply(new ClusterInfo.Builder()).build());
        }

        /**
         * API name: {@code configured_delay}
         */
        @Nonnull
        public final Builder configuredDelay(@Nullable Time value) {
            this.configuredDelay = value;
            return this;
        }

        /**
         * API name: {@code configured_delay}
         */
        @Nonnull
        public final Builder configuredDelay(Function<Time.Builder, ObjectBuilder<Time>> fn) {
            return configuredDelay(fn.apply(new Time.Builder()).build());
        }

        /**
         * API name: {@code configured_delay_in_millis}
         */
        @Nonnull
        public final Builder configuredDelayInMillis(@Nullable Long value) {
            this.configuredDelayInMillis = value;
            return this;
        }

        /**
         * API name: {@code current_node}
         */
        @Nonnull
        public final Builder currentNode(@Nullable CurrentNode value) {
            this.currentNode = value;
            return this;
        }

        /**
         * API name: {@code current_node}
         */
        @Nonnull
        public final Builder currentNode(Function<CurrentNode.Builder, ObjectBuilder<CurrentNode>> fn) {
            return currentNode(fn.apply(new CurrentNode.Builder()).build());
        }

        /**
         * Required - API name: {@code current_state}
         */
        @Nonnull
        public final Builder currentState(String value) {
            this.currentState = value;
            return this;
        }

        /**
         * Required - API name: {@code index}
         */
        @Nonnull
        public final Builder index(String value) {
            this.index = value;
            return this;
        }

        /**
         * API name: {@code move_explanation}
         */
        @Nonnull
        public final Builder moveExplanation(@Nullable String value) {
            this.moveExplanation = value;
            return this;
        }

        /**
         * API name: {@code node_allocation_decisions}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>nodeAllocationDecisions</code>.
         * </p>
         */
        @Nonnull
        public final Builder nodeAllocationDecisions(List<NodeAllocationExplanation> list) {
            this.nodeAllocationDecisions = _listAddAll(this.nodeAllocationDecisions, list);
            return this;
        }

        /**
         * API name: {@code node_allocation_decisions}
         *
         * <p>
         * Adds one or more values to <code>nodeAllocationDecisions</code>.
         * </p>
         */
        @Nonnull
        public final Builder nodeAllocationDecisions(NodeAllocationExplanation value, NodeAllocationExplanation... values) {
            this.nodeAllocationDecisions = _listAdd(this.nodeAllocationDecisions, value, values);
            return this;
        }

        /**
         * API name: {@code node_allocation_decisions}
         *
         * <p>
         * Adds a value to <code>nodeAllocationDecisions</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder nodeAllocationDecisions(
            Function<NodeAllocationExplanation.Builder, ObjectBuilder<NodeAllocationExplanation>> fn
        ) {
            return nodeAllocationDecisions(fn.apply(new NodeAllocationExplanation.Builder()).build());
        }

        /**
         * API name: {@code note}
         */
        @Nonnull
        public final Builder note(@Nullable String value) {
            this.note = value;
            return this;
        }

        /**
         * Required - API name: {@code primary}
         */
        @Nonnull
        public final Builder primary(boolean value) {
            this.primary = value;
            return this;
        }

        /**
         * API name: {@code rebalance_explanation}
         */
        @Nonnull
        public final Builder rebalanceExplanation(@Nullable String value) {
            this.rebalanceExplanation = value;
            return this;
        }

        /**
         * API name: {@code remaining_delay}
         */
        @Nonnull
        public final Builder remainingDelay(@Nullable Time value) {
            this.remainingDelay = value;
            return this;
        }

        /**
         * API name: {@code remaining_delay}
         */
        @Nonnull
        public final Builder remainingDelay(Function<Time.Builder, ObjectBuilder<Time>> fn) {
            return remainingDelay(fn.apply(new Time.Builder()).build());
        }

        /**
         * API name: {@code remaining_delay_in_millis}
         */
        @Nonnull
        public final Builder remainingDelayInMillis(@Nullable Long value) {
            this.remainingDelayInMillis = value;
            return this;
        }

        /**
         * Required - API name: {@code shard}
         */
        @Nonnull
        public final Builder shard(int value) {
            this.shard = value;
            return this;
        }

        /**
         * API name: {@code unassigned_info}
         */
        @Nonnull
        public final Builder unassignedInfo(@Nullable UnassignedInformation value) {
            this.unassignedInfo = value;
            return this;
        }

        /**
         * API name: {@code unassigned_info}
         */
        @Nonnull
        public final Builder unassignedInfo(Function<UnassignedInformation.Builder, ObjectBuilder<UnassignedInformation>> fn) {
            return unassignedInfo(fn.apply(new UnassignedInformation.Builder()).build());
        }

        /**
         * Builds a {@link AllocationExplainResponse}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public AllocationExplainResponse build() {
            _checkSingleUse();

            return new AllocationExplainResponse(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link AllocationExplainResponse}
     */
    public static final JsonpDeserializer<AllocationExplainResponse> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        AllocationExplainResponse::setupAllocationExplainResponseDeserializer
    );

    protected static void setupAllocationExplainResponseDeserializer(ObjectDeserializer<AllocationExplainResponse.Builder> op) {
        op.add(Builder::allocateExplanation, JsonpDeserializer.stringDeserializer(), "allocate_explanation");
        op.add(Builder::allocationDelay, Time._DESERIALIZER, "allocation_delay");
        op.add(Builder::allocationDelayInMillis, JsonpDeserializer.longDeserializer(), "allocation_delay_in_millis");
        op.add(Builder::canAllocate, Decision._DESERIALIZER, "can_allocate");
        op.add(Builder::canMoveToOtherNode, Decision._DESERIALIZER, "can_move_to_other_node");
        op.add(Builder::canRebalanceCluster, Decision._DESERIALIZER, "can_rebalance_cluster");
        op.add(
            Builder::canRebalanceClusterDecisions,
            JsonpDeserializer.arrayDeserializer(AllocationDecision._DESERIALIZER),
            "can_rebalance_cluster_decisions"
        );
        op.add(Builder::canRebalanceToOtherNode, Decision._DESERIALIZER, "can_rebalance_to_other_node");
        op.add(Builder::canRemainDecisions, JsonpDeserializer.arrayDeserializer(AllocationDecision._DESERIALIZER), "can_remain_decisions");
        op.add(Builder::canRemainOnCurrentNode, Decision._DESERIALIZER, "can_remain_on_current_node");
        op.add(Builder::clusterInfo, ClusterInfo._DESERIALIZER, "cluster_info");
        op.add(Builder::configuredDelay, Time._DESERIALIZER, "configured_delay");
        op.add(Builder::configuredDelayInMillis, JsonpDeserializer.longDeserializer(), "configured_delay_in_millis");
        op.add(Builder::currentNode, CurrentNode._DESERIALIZER, "current_node");
        op.add(Builder::currentState, JsonpDeserializer.stringDeserializer(), "current_state");
        op.add(Builder::index, JsonpDeserializer.stringDeserializer(), "index");
        op.add(Builder::moveExplanation, JsonpDeserializer.stringDeserializer(), "move_explanation");
        op.add(
            Builder::nodeAllocationDecisions,
            JsonpDeserializer.arrayDeserializer(NodeAllocationExplanation._DESERIALIZER),
            "node_allocation_decisions"
        );
        op.add(Builder::note, JsonpDeserializer.stringDeserializer(), "note");
        op.add(Builder::primary, JsonpDeserializer.booleanDeserializer(), "primary");
        op.add(Builder::rebalanceExplanation, JsonpDeserializer.stringDeserializer(), "rebalance_explanation");
        op.add(Builder::remainingDelay, Time._DESERIALIZER, "remaining_delay");
        op.add(Builder::remainingDelayInMillis, JsonpDeserializer.longDeserializer(), "remaining_delay_in_millis");
        op.add(Builder::shard, JsonpDeserializer.integerDeserializer(), "shard");
        op.add(Builder::unassignedInfo, UnassignedInformation._DESERIALIZER, "unassigned_info");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.allocateExplanation);
        result = 31 * result + Objects.hashCode(this.allocationDelay);
        result = 31 * result + Objects.hashCode(this.allocationDelayInMillis);
        result = 31 * result + Objects.hashCode(this.canAllocate);
        result = 31 * result + Objects.hashCode(this.canMoveToOtherNode);
        result = 31 * result + Objects.hashCode(this.canRebalanceCluster);
        result = 31 * result + Objects.hashCode(this.canRebalanceClusterDecisions);
        result = 31 * result + Objects.hashCode(this.canRebalanceToOtherNode);
        result = 31 * result + Objects.hashCode(this.canRemainDecisions);
        result = 31 * result + Objects.hashCode(this.canRemainOnCurrentNode);
        result = 31 * result + Objects.hashCode(this.clusterInfo);
        result = 31 * result + Objects.hashCode(this.configuredDelay);
        result = 31 * result + Objects.hashCode(this.configuredDelayInMillis);
        result = 31 * result + Objects.hashCode(this.currentNode);
        result = 31 * result + this.currentState.hashCode();
        result = 31 * result + this.index.hashCode();
        result = 31 * result + Objects.hashCode(this.moveExplanation);
        result = 31 * result + Objects.hashCode(this.nodeAllocationDecisions);
        result = 31 * result + Objects.hashCode(this.note);
        result = 31 * result + Boolean.hashCode(this.primary);
        result = 31 * result + Objects.hashCode(this.rebalanceExplanation);
        result = 31 * result + Objects.hashCode(this.remainingDelay);
        result = 31 * result + Objects.hashCode(this.remainingDelayInMillis);
        result = 31 * result + Integer.hashCode(this.shard);
        result = 31 * result + Objects.hashCode(this.unassignedInfo);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        AllocationExplainResponse other = (AllocationExplainResponse) o;
        return Objects.equals(this.allocateExplanation, other.allocateExplanation)
            && Objects.equals(this.allocationDelay, other.allocationDelay)
            && Objects.equals(this.allocationDelayInMillis, other.allocationDelayInMillis)
            && Objects.equals(this.canAllocate, other.canAllocate)
            && Objects.equals(this.canMoveToOtherNode, other.canMoveToOtherNode)
            && Objects.equals(this.canRebalanceCluster, other.canRebalanceCluster)
            && Objects.equals(this.canRebalanceClusterDecisions, other.canRebalanceClusterDecisions)
            && Objects.equals(this.canRebalanceToOtherNode, other.canRebalanceToOtherNode)
            && Objects.equals(this.canRemainDecisions, other.canRemainDecisions)
            && Objects.equals(this.canRemainOnCurrentNode, other.canRemainOnCurrentNode)
            && Objects.equals(this.clusterInfo, other.clusterInfo)
            && Objects.equals(this.configuredDelay, other.configuredDelay)
            && Objects.equals(this.configuredDelayInMillis, other.configuredDelayInMillis)
            && Objects.equals(this.currentNode, other.currentNode)
            && this.currentState.equals(other.currentState)
            && this.index.equals(other.index)
            && Objects.equals(this.moveExplanation, other.moveExplanation)
            && Objects.equals(this.nodeAllocationDecisions, other.nodeAllocationDecisions)
            && Objects.equals(this.note, other.note)
            && this.primary == other.primary
            && Objects.equals(this.rebalanceExplanation, other.rebalanceExplanation)
            && Objects.equals(this.remainingDelay, other.remainingDelay)
            && Objects.equals(this.remainingDelayInMillis, other.remainingDelayInMillis)
            && this.shard == other.shard
            && Objects.equals(this.unassignedInfo, other.unassignedInfo);
    }
}
