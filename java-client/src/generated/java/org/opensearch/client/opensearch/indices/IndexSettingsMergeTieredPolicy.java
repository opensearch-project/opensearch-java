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

// typedef: indices.IndexSettingsMergeTieredPolicy

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class IndexSettingsMergeTieredPolicy
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<IndexSettingsMergeTieredPolicy.Builder, IndexSettingsMergeTieredPolicy> {

    @Nullable
    private final Double deletesPctAllowed;

    @Nullable
    private final Double expungeDeletesAllowed;

    @Nullable
    private final String floorSegment;

    @Nullable
    private final Integer maxMergeAtOnce;

    @Nullable
    private final String maxMergedSegment;

    @Nullable
    private final Double reclaimDeletesWeight;

    @Nullable
    private final Double segmentsPerTier;

    // ---------------------------------------------------------------------------------------------

    private IndexSettingsMergeTieredPolicy(Builder builder) {
        this.deletesPctAllowed = builder.deletesPctAllowed;
        this.expungeDeletesAllowed = builder.expungeDeletesAllowed;
        this.floorSegment = builder.floorSegment;
        this.maxMergeAtOnce = builder.maxMergeAtOnce;
        this.maxMergedSegment = builder.maxMergedSegment;
        this.reclaimDeletesWeight = builder.reclaimDeletesWeight;
        this.segmentsPerTier = builder.segmentsPerTier;
    }

    public static IndexSettingsMergeTieredPolicy of(
        Function<IndexSettingsMergeTieredPolicy.Builder, ObjectBuilder<IndexSettingsMergeTieredPolicy>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code deletes_pct_allowed}
     */
    @Nullable
    public final Double deletesPctAllowed() {
        return this.deletesPctAllowed;
    }

    /**
     * API name: {@code expunge_deletes_allowed}
     */
    @Nullable
    public final Double expungeDeletesAllowed() {
        return this.expungeDeletesAllowed;
    }

    /**
     * API name: {@code floor_segment}
     */
    @Nullable
    public final String floorSegment() {
        return this.floorSegment;
    }

    /**
     * API name: {@code max_merge_at_once}
     */
    @Nullable
    public final Integer maxMergeAtOnce() {
        return this.maxMergeAtOnce;
    }

    /**
     * API name: {@code max_merged_segment}
     */
    @Nullable
    public final String maxMergedSegment() {
        return this.maxMergedSegment;
    }

    /**
     * API name: {@code reclaim_deletes_weight}
     */
    @Nullable
    public final Double reclaimDeletesWeight() {
        return this.reclaimDeletesWeight;
    }

    /**
     * API name: {@code segments_per_tier}
     */
    @Nullable
    public final Double segmentsPerTier() {
        return this.segmentsPerTier;
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
        if (this.deletesPctAllowed != null) {
            generator.writeKey("deletes_pct_allowed");
            generator.write(this.deletesPctAllowed);
        }

        if (this.expungeDeletesAllowed != null) {
            generator.writeKey("expunge_deletes_allowed");
            generator.write(this.expungeDeletesAllowed);
        }

        if (this.floorSegment != null) {
            generator.writeKey("floor_segment");
            generator.write(this.floorSegment);
        }

        if (this.maxMergeAtOnce != null) {
            generator.writeKey("max_merge_at_once");
            generator.write(this.maxMergeAtOnce);
        }

        if (this.maxMergedSegment != null) {
            generator.writeKey("max_merged_segment");
            generator.write(this.maxMergedSegment);
        }

        if (this.reclaimDeletesWeight != null) {
            generator.writeKey("reclaim_deletes_weight");
            generator.write(this.reclaimDeletesWeight);
        }

        if (this.segmentsPerTier != null) {
            generator.writeKey("segments_per_tier");
            generator.write(this.segmentsPerTier);
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
     * Builder for {@link IndexSettingsMergeTieredPolicy}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, IndexSettingsMergeTieredPolicy> {
        @Nullable
        private Double deletesPctAllowed;
        @Nullable
        private Double expungeDeletesAllowed;
        @Nullable
        private String floorSegment;
        @Nullable
        private Integer maxMergeAtOnce;
        @Nullable
        private String maxMergedSegment;
        @Nullable
        private Double reclaimDeletesWeight;
        @Nullable
        private Double segmentsPerTier;

        public Builder() {}

        private Builder(IndexSettingsMergeTieredPolicy o) {
            this.deletesPctAllowed = o.deletesPctAllowed;
            this.expungeDeletesAllowed = o.expungeDeletesAllowed;
            this.floorSegment = o.floorSegment;
            this.maxMergeAtOnce = o.maxMergeAtOnce;
            this.maxMergedSegment = o.maxMergedSegment;
            this.reclaimDeletesWeight = o.reclaimDeletesWeight;
            this.segmentsPerTier = o.segmentsPerTier;
        }

        private Builder(Builder o) {
            this.deletesPctAllowed = o.deletesPctAllowed;
            this.expungeDeletesAllowed = o.expungeDeletesAllowed;
            this.floorSegment = o.floorSegment;
            this.maxMergeAtOnce = o.maxMergeAtOnce;
            this.maxMergedSegment = o.maxMergedSegment;
            this.reclaimDeletesWeight = o.reclaimDeletesWeight;
            this.segmentsPerTier = o.segmentsPerTier;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code deletes_pct_allowed}
         */
        @Nonnull
        public final Builder deletesPctAllowed(@Nullable Double value) {
            this.deletesPctAllowed = value;
            return this;
        }

        /**
         * API name: {@code expunge_deletes_allowed}
         */
        @Nonnull
        public final Builder expungeDeletesAllowed(@Nullable Double value) {
            this.expungeDeletesAllowed = value;
            return this;
        }

        /**
         * API name: {@code floor_segment}
         */
        @Nonnull
        public final Builder floorSegment(@Nullable String value) {
            this.floorSegment = value;
            return this;
        }

        /**
         * API name: {@code max_merge_at_once}
         */
        @Nonnull
        public final Builder maxMergeAtOnce(@Nullable Integer value) {
            this.maxMergeAtOnce = value;
            return this;
        }

        /**
         * API name: {@code max_merged_segment}
         */
        @Nonnull
        public final Builder maxMergedSegment(@Nullable String value) {
            this.maxMergedSegment = value;
            return this;
        }

        /**
         * API name: {@code reclaim_deletes_weight}
         */
        @Nonnull
        public final Builder reclaimDeletesWeight(@Nullable Double value) {
            this.reclaimDeletesWeight = value;
            return this;
        }

        /**
         * API name: {@code segments_per_tier}
         */
        @Nonnull
        public final Builder segmentsPerTier(@Nullable Double value) {
            this.segmentsPerTier = value;
            return this;
        }

        /**
         * Builds a {@link IndexSettingsMergeTieredPolicy}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public IndexSettingsMergeTieredPolicy build() {
            _checkSingleUse();

            return new IndexSettingsMergeTieredPolicy(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link IndexSettingsMergeTieredPolicy}
     */
    public static final JsonpDeserializer<IndexSettingsMergeTieredPolicy> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        IndexSettingsMergeTieredPolicy::setupIndexSettingsMergeTieredPolicyDeserializer
    );

    protected static void setupIndexSettingsMergeTieredPolicyDeserializer(ObjectDeserializer<IndexSettingsMergeTieredPolicy.Builder> op) {
        op.add(Builder::deletesPctAllowed, JsonpDeserializer.doubleDeserializer(), "deletes_pct_allowed");
        op.add(Builder::expungeDeletesAllowed, JsonpDeserializer.doubleDeserializer(), "expunge_deletes_allowed");
        op.add(Builder::floorSegment, JsonpDeserializer.stringDeserializer(), "floor_segment");
        op.add(Builder::maxMergeAtOnce, JsonpDeserializer.integerDeserializer(), "max_merge_at_once");
        op.add(Builder::maxMergedSegment, JsonpDeserializer.stringDeserializer(), "max_merged_segment");
        op.add(Builder::reclaimDeletesWeight, JsonpDeserializer.doubleDeserializer(), "reclaim_deletes_weight");
        op.add(Builder::segmentsPerTier, JsonpDeserializer.doubleDeserializer(), "segments_per_tier");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.deletesPctAllowed);
        result = 31 * result + Objects.hashCode(this.expungeDeletesAllowed);
        result = 31 * result + Objects.hashCode(this.floorSegment);
        result = 31 * result + Objects.hashCode(this.maxMergeAtOnce);
        result = 31 * result + Objects.hashCode(this.maxMergedSegment);
        result = 31 * result + Objects.hashCode(this.reclaimDeletesWeight);
        result = 31 * result + Objects.hashCode(this.segmentsPerTier);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        IndexSettingsMergeTieredPolicy other = (IndexSettingsMergeTieredPolicy) o;
        return Objects.equals(this.deletesPctAllowed, other.deletesPctAllowed)
            && Objects.equals(this.expungeDeletesAllowed, other.expungeDeletesAllowed)
            && Objects.equals(this.floorSegment, other.floorSegment)
            && Objects.equals(this.maxMergeAtOnce, other.maxMergeAtOnce)
            && Objects.equals(this.maxMergedSegment, other.maxMergedSegment)
            && Objects.equals(this.reclaimDeletesWeight, other.reclaimDeletesWeight)
            && Objects.equals(this.segmentsPerTier, other.segmentsPerTier);
    }
}
