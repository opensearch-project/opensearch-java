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

// typedef: indices.IndexSettingsMergeLogByteSizePolicy

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class IndexSettingsMergeLogByteSizePolicy
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<IndexSettingsMergeLogByteSizePolicy.Builder, IndexSettingsMergeLogByteSizePolicy> {

    @Nullable
    private final String maxMergeSegment;

    @Nullable
    private final String maxMergeSegmentForcedMerge;

    @Nullable
    private final Integer maxMergedDocs;

    @Nullable
    private final Integer mergeFactor;

    @Nullable
    private final String minMerge;

    @Nullable
    private final Double noCfsRatio;

    // ---------------------------------------------------------------------------------------------

    private IndexSettingsMergeLogByteSizePolicy(Builder builder) {
        this.maxMergeSegment = builder.maxMergeSegment;
        this.maxMergeSegmentForcedMerge = builder.maxMergeSegmentForcedMerge;
        this.maxMergedDocs = builder.maxMergedDocs;
        this.mergeFactor = builder.mergeFactor;
        this.minMerge = builder.minMerge;
        this.noCfsRatio = builder.noCfsRatio;
    }

    public static IndexSettingsMergeLogByteSizePolicy of(
        Function<IndexSettingsMergeLogByteSizePolicy.Builder, ObjectBuilder<IndexSettingsMergeLogByteSizePolicy>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code max_merge_segment}
     */
    @Nullable
    public final String maxMergeSegment() {
        return this.maxMergeSegment;
    }

    /**
     * API name: {@code max_merge_segment_forced_merge}
     */
    @Nullable
    public final String maxMergeSegmentForcedMerge() {
        return this.maxMergeSegmentForcedMerge;
    }

    /**
     * API name: {@code max_merged_docs}
     */
    @Nullable
    public final Integer maxMergedDocs() {
        return this.maxMergedDocs;
    }

    /**
     * API name: {@code merge_factor}
     */
    @Nullable
    public final Integer mergeFactor() {
        return this.mergeFactor;
    }

    /**
     * API name: {@code min_merge}
     */
    @Nullable
    public final String minMerge() {
        return this.minMerge;
    }

    /**
     * API name: {@code no_cfs_ratio}
     */
    @Nullable
    public final Double noCfsRatio() {
        return this.noCfsRatio;
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
        if (this.maxMergeSegment != null) {
            generator.writeKey("max_merge_segment");
            generator.write(this.maxMergeSegment);
        }

        if (this.maxMergeSegmentForcedMerge != null) {
            generator.writeKey("max_merge_segment_forced_merge");
            generator.write(this.maxMergeSegmentForcedMerge);
        }

        if (this.maxMergedDocs != null) {
            generator.writeKey("max_merged_docs");
            generator.write(this.maxMergedDocs);
        }

        if (this.mergeFactor != null) {
            generator.writeKey("merge_factor");
            generator.write(this.mergeFactor);
        }

        if (this.minMerge != null) {
            generator.writeKey("min_merge");
            generator.write(this.minMerge);
        }

        if (this.noCfsRatio != null) {
            generator.writeKey("no_cfs_ratio");
            generator.write(this.noCfsRatio);
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
     * Builder for {@link IndexSettingsMergeLogByteSizePolicy}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, IndexSettingsMergeLogByteSizePolicy> {
        @Nullable
        private String maxMergeSegment;
        @Nullable
        private String maxMergeSegmentForcedMerge;
        @Nullable
        private Integer maxMergedDocs;
        @Nullable
        private Integer mergeFactor;
        @Nullable
        private String minMerge;
        @Nullable
        private Double noCfsRatio;

        public Builder() {}

        private Builder(IndexSettingsMergeLogByteSizePolicy o) {
            this.maxMergeSegment = o.maxMergeSegment;
            this.maxMergeSegmentForcedMerge = o.maxMergeSegmentForcedMerge;
            this.maxMergedDocs = o.maxMergedDocs;
            this.mergeFactor = o.mergeFactor;
            this.minMerge = o.minMerge;
            this.noCfsRatio = o.noCfsRatio;
        }

        private Builder(Builder o) {
            this.maxMergeSegment = o.maxMergeSegment;
            this.maxMergeSegmentForcedMerge = o.maxMergeSegmentForcedMerge;
            this.maxMergedDocs = o.maxMergedDocs;
            this.mergeFactor = o.mergeFactor;
            this.minMerge = o.minMerge;
            this.noCfsRatio = o.noCfsRatio;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code max_merge_segment}
         */
        @Nonnull
        public final Builder maxMergeSegment(@Nullable String value) {
            this.maxMergeSegment = value;
            return this;
        }

        /**
         * API name: {@code max_merge_segment_forced_merge}
         */
        @Nonnull
        public final Builder maxMergeSegmentForcedMerge(@Nullable String value) {
            this.maxMergeSegmentForcedMerge = value;
            return this;
        }

        /**
         * API name: {@code max_merged_docs}
         */
        @Nonnull
        public final Builder maxMergedDocs(@Nullable Integer value) {
            this.maxMergedDocs = value;
            return this;
        }

        /**
         * API name: {@code merge_factor}
         */
        @Nonnull
        public final Builder mergeFactor(@Nullable Integer value) {
            this.mergeFactor = value;
            return this;
        }

        /**
         * API name: {@code min_merge}
         */
        @Nonnull
        public final Builder minMerge(@Nullable String value) {
            this.minMerge = value;
            return this;
        }

        /**
         * API name: {@code no_cfs_ratio}
         */
        @Nonnull
        public final Builder noCfsRatio(@Nullable Double value) {
            this.noCfsRatio = value;
            return this;
        }

        /**
         * Builds a {@link IndexSettingsMergeLogByteSizePolicy}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public IndexSettingsMergeLogByteSizePolicy build() {
            _checkSingleUse();

            return new IndexSettingsMergeLogByteSizePolicy(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link IndexSettingsMergeLogByteSizePolicy}
     */
    public static final JsonpDeserializer<IndexSettingsMergeLogByteSizePolicy> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        IndexSettingsMergeLogByteSizePolicy::setupIndexSettingsMergeLogByteSizePolicyDeserializer
    );

    protected static void setupIndexSettingsMergeLogByteSizePolicyDeserializer(
        ObjectDeserializer<IndexSettingsMergeLogByteSizePolicy.Builder> op
    ) {
        op.add(Builder::maxMergeSegment, JsonpDeserializer.stringDeserializer(), "max_merge_segment");
        op.add(Builder::maxMergeSegmentForcedMerge, JsonpDeserializer.stringDeserializer(), "max_merge_segment_forced_merge");
        op.add(Builder::maxMergedDocs, JsonpDeserializer.integerDeserializer(), "max_merged_docs");
        op.add(Builder::mergeFactor, JsonpDeserializer.integerDeserializer(), "merge_factor");
        op.add(Builder::minMerge, JsonpDeserializer.stringDeserializer(), "min_merge");
        op.add(Builder::noCfsRatio, JsonpDeserializer.doubleDeserializer(), "no_cfs_ratio");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.maxMergeSegment);
        result = 31 * result + Objects.hashCode(this.maxMergeSegmentForcedMerge);
        result = 31 * result + Objects.hashCode(this.maxMergedDocs);
        result = 31 * result + Objects.hashCode(this.mergeFactor);
        result = 31 * result + Objects.hashCode(this.minMerge);
        result = 31 * result + Objects.hashCode(this.noCfsRatio);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        IndexSettingsMergeLogByteSizePolicy other = (IndexSettingsMergeLogByteSizePolicy) o;
        return Objects.equals(this.maxMergeSegment, other.maxMergeSegment)
            && Objects.equals(this.maxMergeSegmentForcedMerge, other.maxMergeSegmentForcedMerge)
            && Objects.equals(this.maxMergedDocs, other.maxMergedDocs)
            && Objects.equals(this.mergeFactor, other.mergeFactor)
            && Objects.equals(this.minMerge, other.minMerge)
            && Objects.equals(this.noCfsRatio, other.noCfsRatio);
    }
}
