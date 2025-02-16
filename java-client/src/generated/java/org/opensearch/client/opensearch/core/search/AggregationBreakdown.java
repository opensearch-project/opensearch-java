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

package org.opensearch.client.opensearch.core.search;

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

// typedef: core.search.AggregationBreakdown

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class AggregationBreakdown implements PlainJsonSerializable, ToCopyableBuilder<AggregationBreakdown.Builder, AggregationBreakdown> {

    private final long buildAggregation;

    private final long buildAggregationCount;

    private final long buildLeafCollector;

    private final long buildLeafCollectorCount;

    private final long collect;

    private final long collectCount;

    private final long initialize;

    private final long initializeCount;

    @Nullable
    private final Long postCollection;

    @Nullable
    private final Long postCollectionCount;

    private final long reduce;

    private final long reduceCount;

    // ---------------------------------------------------------------------------------------------

    private AggregationBreakdown(Builder builder) {
        this.buildAggregation = ApiTypeHelper.requireNonNull(builder.buildAggregation, this, "buildAggregation");
        this.buildAggregationCount = ApiTypeHelper.requireNonNull(builder.buildAggregationCount, this, "buildAggregationCount");
        this.buildLeafCollector = ApiTypeHelper.requireNonNull(builder.buildLeafCollector, this, "buildLeafCollector");
        this.buildLeafCollectorCount = ApiTypeHelper.requireNonNull(builder.buildLeafCollectorCount, this, "buildLeafCollectorCount");
        this.collect = ApiTypeHelper.requireNonNull(builder.collect, this, "collect");
        this.collectCount = ApiTypeHelper.requireNonNull(builder.collectCount, this, "collectCount");
        this.initialize = ApiTypeHelper.requireNonNull(builder.initialize, this, "initialize");
        this.initializeCount = ApiTypeHelper.requireNonNull(builder.initializeCount, this, "initializeCount");
        this.postCollection = builder.postCollection;
        this.postCollectionCount = builder.postCollectionCount;
        this.reduce = ApiTypeHelper.requireNonNull(builder.reduce, this, "reduce");
        this.reduceCount = ApiTypeHelper.requireNonNull(builder.reduceCount, this, "reduceCount");
    }

    public static AggregationBreakdown of(Function<AggregationBreakdown.Builder, ObjectBuilder<AggregationBreakdown>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code build_aggregation}
     */
    public final long buildAggregation() {
        return this.buildAggregation;
    }

    /**
     * Required - API name: {@code build_aggregation_count}
     */
    public final long buildAggregationCount() {
        return this.buildAggregationCount;
    }

    /**
     * Required - API name: {@code build_leaf_collector}
     */
    public final long buildLeafCollector() {
        return this.buildLeafCollector;
    }

    /**
     * Required - API name: {@code build_leaf_collector_count}
     */
    public final long buildLeafCollectorCount() {
        return this.buildLeafCollectorCount;
    }

    /**
     * Required - API name: {@code collect}
     */
    public final long collect() {
        return this.collect;
    }

    /**
     * Required - API name: {@code collect_count}
     */
    public final long collectCount() {
        return this.collectCount;
    }

    /**
     * Required - API name: {@code initialize}
     */
    public final long initialize() {
        return this.initialize;
    }

    /**
     * Required - API name: {@code initialize_count}
     */
    public final long initializeCount() {
        return this.initializeCount;
    }

    /**
     * API name: {@code post_collection}
     */
    @Nullable
    public final Long postCollection() {
        return this.postCollection;
    }

    /**
     * API name: {@code post_collection_count}
     */
    @Nullable
    public final Long postCollectionCount() {
        return this.postCollectionCount;
    }

    /**
     * Required - API name: {@code reduce}
     */
    public final long reduce() {
        return this.reduce;
    }

    /**
     * Required - API name: {@code reduce_count}
     */
    public final long reduceCount() {
        return this.reduceCount;
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
        generator.writeKey("build_aggregation");
        generator.write(this.buildAggregation);

        generator.writeKey("build_aggregation_count");
        generator.write(this.buildAggregationCount);

        generator.writeKey("build_leaf_collector");
        generator.write(this.buildLeafCollector);

        generator.writeKey("build_leaf_collector_count");
        generator.write(this.buildLeafCollectorCount);

        generator.writeKey("collect");
        generator.write(this.collect);

        generator.writeKey("collect_count");
        generator.write(this.collectCount);

        generator.writeKey("initialize");
        generator.write(this.initialize);

        generator.writeKey("initialize_count");
        generator.write(this.initializeCount);

        if (this.postCollection != null) {
            generator.writeKey("post_collection");
            generator.write(this.postCollection);
        }

        if (this.postCollectionCount != null) {
            generator.writeKey("post_collection_count");
            generator.write(this.postCollectionCount);
        }

        generator.writeKey("reduce");
        generator.write(this.reduce);

        generator.writeKey("reduce_count");
        generator.write(this.reduceCount);
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
     * Builder for {@link AggregationBreakdown}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, AggregationBreakdown> {
        private Long buildAggregation;
        private Long buildAggregationCount;
        private Long buildLeafCollector;
        private Long buildLeafCollectorCount;
        private Long collect;
        private Long collectCount;
        private Long initialize;
        private Long initializeCount;
        @Nullable
        private Long postCollection;
        @Nullable
        private Long postCollectionCount;
        private Long reduce;
        private Long reduceCount;

        public Builder() {}

        private Builder(AggregationBreakdown o) {
            this.buildAggregation = o.buildAggregation;
            this.buildAggregationCount = o.buildAggregationCount;
            this.buildLeafCollector = o.buildLeafCollector;
            this.buildLeafCollectorCount = o.buildLeafCollectorCount;
            this.collect = o.collect;
            this.collectCount = o.collectCount;
            this.initialize = o.initialize;
            this.initializeCount = o.initializeCount;
            this.postCollection = o.postCollection;
            this.postCollectionCount = o.postCollectionCount;
            this.reduce = o.reduce;
            this.reduceCount = o.reduceCount;
        }

        private Builder(Builder o) {
            this.buildAggregation = o.buildAggregation;
            this.buildAggregationCount = o.buildAggregationCount;
            this.buildLeafCollector = o.buildLeafCollector;
            this.buildLeafCollectorCount = o.buildLeafCollectorCount;
            this.collect = o.collect;
            this.collectCount = o.collectCount;
            this.initialize = o.initialize;
            this.initializeCount = o.initializeCount;
            this.postCollection = o.postCollection;
            this.postCollectionCount = o.postCollectionCount;
            this.reduce = o.reduce;
            this.reduceCount = o.reduceCount;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - API name: {@code build_aggregation}
         */
        @Nonnull
        public final Builder buildAggregation(long value) {
            this.buildAggregation = value;
            return this;
        }

        /**
         * Required - API name: {@code build_aggregation_count}
         */
        @Nonnull
        public final Builder buildAggregationCount(long value) {
            this.buildAggregationCount = value;
            return this;
        }

        /**
         * Required - API name: {@code build_leaf_collector}
         */
        @Nonnull
        public final Builder buildLeafCollector(long value) {
            this.buildLeafCollector = value;
            return this;
        }

        /**
         * Required - API name: {@code build_leaf_collector_count}
         */
        @Nonnull
        public final Builder buildLeafCollectorCount(long value) {
            this.buildLeafCollectorCount = value;
            return this;
        }

        /**
         * Required - API name: {@code collect}
         */
        @Nonnull
        public final Builder collect(long value) {
            this.collect = value;
            return this;
        }

        /**
         * Required - API name: {@code collect_count}
         */
        @Nonnull
        public final Builder collectCount(long value) {
            this.collectCount = value;
            return this;
        }

        /**
         * Required - API name: {@code initialize}
         */
        @Nonnull
        public final Builder initialize(long value) {
            this.initialize = value;
            return this;
        }

        /**
         * Required - API name: {@code initialize_count}
         */
        @Nonnull
        public final Builder initializeCount(long value) {
            this.initializeCount = value;
            return this;
        }

        /**
         * API name: {@code post_collection}
         */
        @Nonnull
        public final Builder postCollection(@Nullable Long value) {
            this.postCollection = value;
            return this;
        }

        /**
         * API name: {@code post_collection_count}
         */
        @Nonnull
        public final Builder postCollectionCount(@Nullable Long value) {
            this.postCollectionCount = value;
            return this;
        }

        /**
         * Required - API name: {@code reduce}
         */
        @Nonnull
        public final Builder reduce(long value) {
            this.reduce = value;
            return this;
        }

        /**
         * Required - API name: {@code reduce_count}
         */
        @Nonnull
        public final Builder reduceCount(long value) {
            this.reduceCount = value;
            return this;
        }

        /**
         * Builds a {@link AggregationBreakdown}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public AggregationBreakdown build() {
            _checkSingleUse();

            return new AggregationBreakdown(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link AggregationBreakdown}
     */
    public static final JsonpDeserializer<AggregationBreakdown> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        AggregationBreakdown::setupAggregationBreakdownDeserializer
    );

    protected static void setupAggregationBreakdownDeserializer(ObjectDeserializer<AggregationBreakdown.Builder> op) {
        op.add(Builder::buildAggregation, JsonpDeserializer.longDeserializer(), "build_aggregation");
        op.add(Builder::buildAggregationCount, JsonpDeserializer.longDeserializer(), "build_aggregation_count");
        op.add(Builder::buildLeafCollector, JsonpDeserializer.longDeserializer(), "build_leaf_collector");
        op.add(Builder::buildLeafCollectorCount, JsonpDeserializer.longDeserializer(), "build_leaf_collector_count");
        op.add(Builder::collect, JsonpDeserializer.longDeserializer(), "collect");
        op.add(Builder::collectCount, JsonpDeserializer.longDeserializer(), "collect_count");
        op.add(Builder::initialize, JsonpDeserializer.longDeserializer(), "initialize");
        op.add(Builder::initializeCount, JsonpDeserializer.longDeserializer(), "initialize_count");
        op.add(Builder::postCollection, JsonpDeserializer.longDeserializer(), "post_collection");
        op.add(Builder::postCollectionCount, JsonpDeserializer.longDeserializer(), "post_collection_count");
        op.add(Builder::reduce, JsonpDeserializer.longDeserializer(), "reduce");
        op.add(Builder::reduceCount, JsonpDeserializer.longDeserializer(), "reduce_count");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Long.hashCode(this.buildAggregation);
        result = 31 * result + Long.hashCode(this.buildAggregationCount);
        result = 31 * result + Long.hashCode(this.buildLeafCollector);
        result = 31 * result + Long.hashCode(this.buildLeafCollectorCount);
        result = 31 * result + Long.hashCode(this.collect);
        result = 31 * result + Long.hashCode(this.collectCount);
        result = 31 * result + Long.hashCode(this.initialize);
        result = 31 * result + Long.hashCode(this.initializeCount);
        result = 31 * result + Objects.hashCode(this.postCollection);
        result = 31 * result + Objects.hashCode(this.postCollectionCount);
        result = 31 * result + Long.hashCode(this.reduce);
        result = 31 * result + Long.hashCode(this.reduceCount);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        AggregationBreakdown other = (AggregationBreakdown) o;
        return this.buildAggregation == other.buildAggregation
            && this.buildAggregationCount == other.buildAggregationCount
            && this.buildLeafCollector == other.buildLeafCollector
            && this.buildLeafCollectorCount == other.buildLeafCollectorCount
            && this.collect == other.collect
            && this.collectCount == other.collectCount
            && this.initialize == other.initialize
            && this.initializeCount == other.initializeCount
            && Objects.equals(this.postCollection, other.postCollection)
            && Objects.equals(this.postCollectionCount, other.postCollectionCount)
            && this.reduce == other.reduce
            && this.reduceCount == other.reduceCount;
    }
}
