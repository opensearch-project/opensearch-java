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

package org.opensearch.client.opensearch.indices;

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

// typedef: indices.IndexSettingsMerge

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class IndexSettingsMerge implements PlainJsonSerializable, ToCopyableBuilder<IndexSettingsMerge.Builder, IndexSettingsMerge> {

    @Nullable
    private final IndexSettingsMergeLogByteSizePolicy logByteSizePolicy;

    @Nullable
    private final IndexSettingsMergePolicy policy;

    @Nullable
    private final Double policyDeletesPctAllowed;

    @Nullable
    private final Double policyExpungeDeletesAllowed;

    @Nullable
    private final String policyFloorSegment;

    @Nullable
    private final Integer policyMaxMergeAtOnce;

    @Nullable
    private final String policyMaxMergedSegment;

    @Nullable
    private final Double policyReclaimDeletesWeight;

    @Nullable
    private final Double policySegmentsPerTier;

    @Nullable
    private final IndexSettingsMergeScheduler scheduler;

    // ---------------------------------------------------------------------------------------------

    private IndexSettingsMerge(Builder builder) {
        this.logByteSizePolicy = builder.logByteSizePolicy;
        this.policy = builder.policy;
        this.policyDeletesPctAllowed = builder.policyDeletesPctAllowed;
        this.policyExpungeDeletesAllowed = builder.policyExpungeDeletesAllowed;
        this.policyFloorSegment = builder.policyFloorSegment;
        this.policyMaxMergeAtOnce = builder.policyMaxMergeAtOnce;
        this.policyMaxMergedSegment = builder.policyMaxMergedSegment;
        this.policyReclaimDeletesWeight = builder.policyReclaimDeletesWeight;
        this.policySegmentsPerTier = builder.policySegmentsPerTier;
        this.scheduler = builder.scheduler;
    }

    public static IndexSettingsMerge of(Function<IndexSettingsMerge.Builder, ObjectBuilder<IndexSettingsMerge>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code log_byte_size_policy}
     */
    @Nullable
    public final IndexSettingsMergeLogByteSizePolicy logByteSizePolicy() {
        return this.logByteSizePolicy;
    }

    /**
     * API name: {@code policy}
     */
    @Nullable
    public final IndexSettingsMergePolicy policy() {
        return this.policy;
    }

    /**
     * API name: {@code policy.deletes_pct_allowed}
     */
    @Nullable
    public final Double policyDeletesPctAllowed() {
        return this.policyDeletesPctAllowed;
    }

    /**
     * API name: {@code policy.expunge_deletes_allowed}
     */
    @Nullable
    public final Double policyExpungeDeletesAllowed() {
        return this.policyExpungeDeletesAllowed;
    }

    /**
     * API name: {@code policy.floor_segment}
     */
    @Nullable
    public final String policyFloorSegment() {
        return this.policyFloorSegment;
    }

    /**
     * API name: {@code policy.max_merge_at_once}
     */
    @Nullable
    public final Integer policyMaxMergeAtOnce() {
        return this.policyMaxMergeAtOnce;
    }

    /**
     * API name: {@code policy.max_merged_segment}
     */
    @Nullable
    public final String policyMaxMergedSegment() {
        return this.policyMaxMergedSegment;
    }

    /**
     * API name: {@code policy.reclaim_deletes_weight}
     */
    @Nullable
    public final Double policyReclaimDeletesWeight() {
        return this.policyReclaimDeletesWeight;
    }

    /**
     * API name: {@code policy.segments_per_tier}
     */
    @Nullable
    public final Double policySegmentsPerTier() {
        return this.policySegmentsPerTier;
    }

    /**
     * API name: {@code scheduler}
     */
    @Nullable
    public final IndexSettingsMergeScheduler scheduler() {
        return this.scheduler;
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
        if (this.logByteSizePolicy != null) {
            generator.writeKey("log_byte_size_policy");
            this.logByteSizePolicy.serialize(generator, mapper);
        }

        if (this.policy != null) {
            generator.writeKey("policy");
            this.policy.serialize(generator, mapper);
        }

        if (this.policyDeletesPctAllowed != null) {
            generator.writeKey("policy.deletes_pct_allowed");
            generator.write(this.policyDeletesPctAllowed);
        }

        if (this.policyExpungeDeletesAllowed != null) {
            generator.writeKey("policy.expunge_deletes_allowed");
            generator.write(this.policyExpungeDeletesAllowed);
        }

        if (this.policyFloorSegment != null) {
            generator.writeKey("policy.floor_segment");
            generator.write(this.policyFloorSegment);
        }

        if (this.policyMaxMergeAtOnce != null) {
            generator.writeKey("policy.max_merge_at_once");
            generator.write(this.policyMaxMergeAtOnce);
        }

        if (this.policyMaxMergedSegment != null) {
            generator.writeKey("policy.max_merged_segment");
            generator.write(this.policyMaxMergedSegment);
        }

        if (this.policyReclaimDeletesWeight != null) {
            generator.writeKey("policy.reclaim_deletes_weight");
            generator.write(this.policyReclaimDeletesWeight);
        }

        if (this.policySegmentsPerTier != null) {
            generator.writeKey("policy.segments_per_tier");
            generator.write(this.policySegmentsPerTier);
        }

        if (this.scheduler != null) {
            generator.writeKey("scheduler");
            this.scheduler.serialize(generator, mapper);
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
     * Builder for {@link IndexSettingsMerge}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, IndexSettingsMerge> {
        @Nullable
        private IndexSettingsMergeLogByteSizePolicy logByteSizePolicy;
        @Nullable
        private IndexSettingsMergePolicy policy;
        @Nullable
        private Double policyDeletesPctAllowed;
        @Nullable
        private Double policyExpungeDeletesAllowed;
        @Nullable
        private String policyFloorSegment;
        @Nullable
        private Integer policyMaxMergeAtOnce;
        @Nullable
        private String policyMaxMergedSegment;
        @Nullable
        private Double policyReclaimDeletesWeight;
        @Nullable
        private Double policySegmentsPerTier;
        @Nullable
        private IndexSettingsMergeScheduler scheduler;

        public Builder() {}

        private Builder(IndexSettingsMerge o) {
            this.logByteSizePolicy = o.logByteSizePolicy;
            this.policy = o.policy;
            this.policyDeletesPctAllowed = o.policyDeletesPctAllowed;
            this.policyExpungeDeletesAllowed = o.policyExpungeDeletesAllowed;
            this.policyFloorSegment = o.policyFloorSegment;
            this.policyMaxMergeAtOnce = o.policyMaxMergeAtOnce;
            this.policyMaxMergedSegment = o.policyMaxMergedSegment;
            this.policyReclaimDeletesWeight = o.policyReclaimDeletesWeight;
            this.policySegmentsPerTier = o.policySegmentsPerTier;
            this.scheduler = o.scheduler;
        }

        private Builder(Builder o) {
            this.logByteSizePolicy = o.logByteSizePolicy;
            this.policy = o.policy;
            this.policyDeletesPctAllowed = o.policyDeletesPctAllowed;
            this.policyExpungeDeletesAllowed = o.policyExpungeDeletesAllowed;
            this.policyFloorSegment = o.policyFloorSegment;
            this.policyMaxMergeAtOnce = o.policyMaxMergeAtOnce;
            this.policyMaxMergedSegment = o.policyMaxMergedSegment;
            this.policyReclaimDeletesWeight = o.policyReclaimDeletesWeight;
            this.policySegmentsPerTier = o.policySegmentsPerTier;
            this.scheduler = o.scheduler;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code log_byte_size_policy}
         */
        @Nonnull
        public final Builder logByteSizePolicy(@Nullable IndexSettingsMergeLogByteSizePolicy value) {
            this.logByteSizePolicy = value;
            return this;
        }

        /**
         * API name: {@code log_byte_size_policy}
         */
        @Nonnull
        public final Builder logByteSizePolicy(
            Function<IndexSettingsMergeLogByteSizePolicy.Builder, ObjectBuilder<IndexSettingsMergeLogByteSizePolicy>> fn
        ) {
            return logByteSizePolicy(fn.apply(new IndexSettingsMergeLogByteSizePolicy.Builder()).build());
        }

        /**
         * API name: {@code policy}
         */
        @Nonnull
        public final Builder policy(@Nullable IndexSettingsMergePolicy value) {
            this.policy = value;
            return this;
        }

        /**
         * API name: {@code policy}
         */
        @Nonnull
        public final Builder policy(Function<IndexSettingsMergePolicy.Builder, ObjectBuilder<IndexSettingsMergePolicy>> fn) {
            return policy(fn.apply(new IndexSettingsMergePolicy.Builder()).build());
        }

        /**
         * API name: {@code policy.deletes_pct_allowed}
         */
        @Nonnull
        public final Builder policyDeletesPctAllowed(@Nullable Double value) {
            this.policyDeletesPctAllowed = value;
            return this;
        }

        /**
         * API name: {@code policy.expunge_deletes_allowed}
         */
        @Nonnull
        public final Builder policyExpungeDeletesAllowed(@Nullable Double value) {
            this.policyExpungeDeletesAllowed = value;
            return this;
        }

        /**
         * API name: {@code policy.floor_segment}
         */
        @Nonnull
        public final Builder policyFloorSegment(@Nullable String value) {
            this.policyFloorSegment = value;
            return this;
        }

        /**
         * API name: {@code policy.max_merge_at_once}
         */
        @Nonnull
        public final Builder policyMaxMergeAtOnce(@Nullable Integer value) {
            this.policyMaxMergeAtOnce = value;
            return this;
        }

        /**
         * API name: {@code policy.max_merged_segment}
         */
        @Nonnull
        public final Builder policyMaxMergedSegment(@Nullable String value) {
            this.policyMaxMergedSegment = value;
            return this;
        }

        /**
         * API name: {@code policy.reclaim_deletes_weight}
         */
        @Nonnull
        public final Builder policyReclaimDeletesWeight(@Nullable Double value) {
            this.policyReclaimDeletesWeight = value;
            return this;
        }

        /**
         * API name: {@code policy.segments_per_tier}
         */
        @Nonnull
        public final Builder policySegmentsPerTier(@Nullable Double value) {
            this.policySegmentsPerTier = value;
            return this;
        }

        /**
         * API name: {@code scheduler}
         */
        @Nonnull
        public final Builder scheduler(@Nullable IndexSettingsMergeScheduler value) {
            this.scheduler = value;
            return this;
        }

        /**
         * API name: {@code scheduler}
         */
        @Nonnull
        public final Builder scheduler(Function<IndexSettingsMergeScheduler.Builder, ObjectBuilder<IndexSettingsMergeScheduler>> fn) {
            return scheduler(fn.apply(new IndexSettingsMergeScheduler.Builder()).build());
        }

        /**
         * Builds a {@link IndexSettingsMerge}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public IndexSettingsMerge build() {
            _checkSingleUse();

            return new IndexSettingsMerge(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link IndexSettingsMerge}
     */
    public static final JsonpDeserializer<IndexSettingsMerge> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        IndexSettingsMerge::setupIndexSettingsMergeDeserializer
    );

    protected static void setupIndexSettingsMergeDeserializer(ObjectDeserializer<IndexSettingsMerge.Builder> op) {
        op.add(Builder::logByteSizePolicy, IndexSettingsMergeLogByteSizePolicy._DESERIALIZER, "log_byte_size_policy");
        op.add(Builder::policy, IndexSettingsMergePolicy._DESERIALIZER, "policy");
        op.add(Builder::policyDeletesPctAllowed, JsonpDeserializer.doubleDeserializer(), "policy.deletes_pct_allowed");
        op.add(Builder::policyExpungeDeletesAllowed, JsonpDeserializer.doubleDeserializer(), "policy.expunge_deletes_allowed");
        op.add(Builder::policyFloorSegment, JsonpDeserializer.stringDeserializer(), "policy.floor_segment");
        op.add(Builder::policyMaxMergeAtOnce, JsonpDeserializer.integerDeserializer(), "policy.max_merge_at_once");
        op.add(Builder::policyMaxMergedSegment, JsonpDeserializer.stringDeserializer(), "policy.max_merged_segment");
        op.add(Builder::policyReclaimDeletesWeight, JsonpDeserializer.doubleDeserializer(), "policy.reclaim_deletes_weight");
        op.add(Builder::policySegmentsPerTier, JsonpDeserializer.doubleDeserializer(), "policy.segments_per_tier");
        op.add(Builder::scheduler, IndexSettingsMergeScheduler._DESERIALIZER, "scheduler");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.logByteSizePolicy);
        result = 31 * result + Objects.hashCode(this.policy);
        result = 31 * result + Objects.hashCode(this.policyDeletesPctAllowed);
        result = 31 * result + Objects.hashCode(this.policyExpungeDeletesAllowed);
        result = 31 * result + Objects.hashCode(this.policyFloorSegment);
        result = 31 * result + Objects.hashCode(this.policyMaxMergeAtOnce);
        result = 31 * result + Objects.hashCode(this.policyMaxMergedSegment);
        result = 31 * result + Objects.hashCode(this.policyReclaimDeletesWeight);
        result = 31 * result + Objects.hashCode(this.policySegmentsPerTier);
        result = 31 * result + Objects.hashCode(this.scheduler);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        IndexSettingsMerge other = (IndexSettingsMerge) o;
        return Objects.equals(this.logByteSizePolicy, other.logByteSizePolicy)
            && Objects.equals(this.policy, other.policy)
            && Objects.equals(this.policyDeletesPctAllowed, other.policyDeletesPctAllowed)
            && Objects.equals(this.policyExpungeDeletesAllowed, other.policyExpungeDeletesAllowed)
            && Objects.equals(this.policyFloorSegment, other.policyFloorSegment)
            && Objects.equals(this.policyMaxMergeAtOnce, other.policyMaxMergeAtOnce)
            && Objects.equals(this.policyMaxMergedSegment, other.policyMaxMergedSegment)
            && Objects.equals(this.policyReclaimDeletesWeight, other.policyReclaimDeletesWeight)
            && Objects.equals(this.policySegmentsPerTier, other.policySegmentsPerTier)
            && Objects.equals(this.scheduler, other.scheduler);
    }
}
