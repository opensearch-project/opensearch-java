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
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: core.search.AggregationProfileDebug

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class AggregationProfileDebug
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<AggregationProfileDebug.Builder, AggregationProfileDebug> {

    @Nullable
    private final Integer builtBuckets;

    @Nullable
    private final Integer charsFetched;

    @Nullable
    private final Integer collectAnalyzedCount;

    @Nullable
    private final Integer collectAnalyzedNs;

    @Nullable
    private final String collectionStrategy;

    @Nonnull
    private final List<String> deferredAggregators;

    @Nullable
    private final String delegate;

    @Nullable
    private final AggregationProfileDelegateDebug delegateDebug;

    @Nullable
    private final Integer emptyCollectorsUsed;

    @Nullable
    private final Integer extractCount;

    @Nullable
    private final Integer extractNs;

    @Nullable
    private final Boolean hasFilter;

    @Nullable
    private final String mapReducer;

    @Nullable
    private final Integer numericCollectorsUsed;

    @Nullable
    private final Integer ordinalsCollectorsOverheadTooHigh;

    @Nullable
    private final Integer ordinalsCollectorsUsed;

    @Nullable
    private final String resultStrategy;

    @Nullable
    private final Integer segmentsWithMultiValuedOrds;

    @Nullable
    private final Integer segmentsWithSingleValuedOrds;

    @Nullable
    private final Integer stringHashingCollectorsUsed;

    @Nullable
    private final Integer survivingBuckets;

    @Nullable
    private final Integer totalBuckets;

    @Nullable
    private final Integer valuesFetched;

    // ---------------------------------------------------------------------------------------------

    private AggregationProfileDebug(Builder builder) {
        this.builtBuckets = builder.builtBuckets;
        this.charsFetched = builder.charsFetched;
        this.collectAnalyzedCount = builder.collectAnalyzedCount;
        this.collectAnalyzedNs = builder.collectAnalyzedNs;
        this.collectionStrategy = builder.collectionStrategy;
        this.deferredAggregators = ApiTypeHelper.unmodifiable(builder.deferredAggregators);
        this.delegate = builder.delegate;
        this.delegateDebug = builder.delegateDebug;
        this.emptyCollectorsUsed = builder.emptyCollectorsUsed;
        this.extractCount = builder.extractCount;
        this.extractNs = builder.extractNs;
        this.hasFilter = builder.hasFilter;
        this.mapReducer = builder.mapReducer;
        this.numericCollectorsUsed = builder.numericCollectorsUsed;
        this.ordinalsCollectorsOverheadTooHigh = builder.ordinalsCollectorsOverheadTooHigh;
        this.ordinalsCollectorsUsed = builder.ordinalsCollectorsUsed;
        this.resultStrategy = builder.resultStrategy;
        this.segmentsWithMultiValuedOrds = builder.segmentsWithMultiValuedOrds;
        this.segmentsWithSingleValuedOrds = builder.segmentsWithSingleValuedOrds;
        this.stringHashingCollectorsUsed = builder.stringHashingCollectorsUsed;
        this.survivingBuckets = builder.survivingBuckets;
        this.totalBuckets = builder.totalBuckets;
        this.valuesFetched = builder.valuesFetched;
    }

    public static AggregationProfileDebug of(Function<AggregationProfileDebug.Builder, ObjectBuilder<AggregationProfileDebug>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code built_buckets}
     */
    @Nullable
    public final Integer builtBuckets() {
        return this.builtBuckets;
    }

    /**
     * API name: {@code chars_fetched}
     */
    @Nullable
    public final Integer charsFetched() {
        return this.charsFetched;
    }

    /**
     * API name: {@code collect_analyzed_count}
     */
    @Nullable
    public final Integer collectAnalyzedCount() {
        return this.collectAnalyzedCount;
    }

    /**
     * API name: {@code collect_analyzed_ns}
     */
    @Nullable
    public final Integer collectAnalyzedNs() {
        return this.collectAnalyzedNs;
    }

    /**
     * API name: {@code collection_strategy}
     */
    @Nullable
    public final String collectionStrategy() {
        return this.collectionStrategy;
    }

    /**
     * API name: {@code deferred_aggregators}
     */
    @Nonnull
    public final List<String> deferredAggregators() {
        return this.deferredAggregators;
    }

    /**
     * API name: {@code delegate}
     */
    @Nullable
    public final String delegate() {
        return this.delegate;
    }

    /**
     * API name: {@code delegate_debug}
     */
    @Nullable
    public final AggregationProfileDelegateDebug delegateDebug() {
        return this.delegateDebug;
    }

    /**
     * API name: {@code empty_collectors_used}
     */
    @Nullable
    public final Integer emptyCollectorsUsed() {
        return this.emptyCollectorsUsed;
    }

    /**
     * API name: {@code extract_count}
     */
    @Nullable
    public final Integer extractCount() {
        return this.extractCount;
    }

    /**
     * API name: {@code extract_ns}
     */
    @Nullable
    public final Integer extractNs() {
        return this.extractNs;
    }

    /**
     * API name: {@code has_filter}
     */
    @Nullable
    public final Boolean hasFilter() {
        return this.hasFilter;
    }

    /**
     * API name: {@code map_reducer}
     */
    @Nullable
    public final String mapReducer() {
        return this.mapReducer;
    }

    /**
     * API name: {@code numeric_collectors_used}
     */
    @Nullable
    public final Integer numericCollectorsUsed() {
        return this.numericCollectorsUsed;
    }

    /**
     * API name: {@code ordinals_collectors_overhead_too_high}
     */
    @Nullable
    public final Integer ordinalsCollectorsOverheadTooHigh() {
        return this.ordinalsCollectorsOverheadTooHigh;
    }

    /**
     * API name: {@code ordinals_collectors_used}
     */
    @Nullable
    public final Integer ordinalsCollectorsUsed() {
        return this.ordinalsCollectorsUsed;
    }

    /**
     * API name: {@code result_strategy}
     */
    @Nullable
    public final String resultStrategy() {
        return this.resultStrategy;
    }

    /**
     * API name: {@code segments_with_multi_valued_ords}
     */
    @Nullable
    public final Integer segmentsWithMultiValuedOrds() {
        return this.segmentsWithMultiValuedOrds;
    }

    /**
     * API name: {@code segments_with_single_valued_ords}
     */
    @Nullable
    public final Integer segmentsWithSingleValuedOrds() {
        return this.segmentsWithSingleValuedOrds;
    }

    /**
     * API name: {@code string_hashing_collectors_used}
     */
    @Nullable
    public final Integer stringHashingCollectorsUsed() {
        return this.stringHashingCollectorsUsed;
    }

    /**
     * API name: {@code surviving_buckets}
     */
    @Nullable
    public final Integer survivingBuckets() {
        return this.survivingBuckets;
    }

    /**
     * API name: {@code total_buckets}
     */
    @Nullable
    public final Integer totalBuckets() {
        return this.totalBuckets;
    }

    /**
     * API name: {@code values_fetched}
     */
    @Nullable
    public final Integer valuesFetched() {
        return this.valuesFetched;
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
        if (this.builtBuckets != null) {
            generator.writeKey("built_buckets");
            generator.write(this.builtBuckets);
        }

        if (this.charsFetched != null) {
            generator.writeKey("chars_fetched");
            generator.write(this.charsFetched);
        }

        if (this.collectAnalyzedCount != null) {
            generator.writeKey("collect_analyzed_count");
            generator.write(this.collectAnalyzedCount);
        }

        if (this.collectAnalyzedNs != null) {
            generator.writeKey("collect_analyzed_ns");
            generator.write(this.collectAnalyzedNs);
        }

        if (this.collectionStrategy != null) {
            generator.writeKey("collection_strategy");
            generator.write(this.collectionStrategy);
        }

        if (ApiTypeHelper.isDefined(this.deferredAggregators)) {
            generator.writeKey("deferred_aggregators");
            generator.writeStartArray();
            for (String item0 : this.deferredAggregators) {
                generator.write(item0);
            }
            generator.writeEnd();
        }

        if (this.delegate != null) {
            generator.writeKey("delegate");
            generator.write(this.delegate);
        }

        if (this.delegateDebug != null) {
            generator.writeKey("delegate_debug");
            this.delegateDebug.serialize(generator, mapper);
        }

        if (this.emptyCollectorsUsed != null) {
            generator.writeKey("empty_collectors_used");
            generator.write(this.emptyCollectorsUsed);
        }

        if (this.extractCount != null) {
            generator.writeKey("extract_count");
            generator.write(this.extractCount);
        }

        if (this.extractNs != null) {
            generator.writeKey("extract_ns");
            generator.write(this.extractNs);
        }

        if (this.hasFilter != null) {
            generator.writeKey("has_filter");
            generator.write(this.hasFilter);
        }

        if (this.mapReducer != null) {
            generator.writeKey("map_reducer");
            generator.write(this.mapReducer);
        }

        if (this.numericCollectorsUsed != null) {
            generator.writeKey("numeric_collectors_used");
            generator.write(this.numericCollectorsUsed);
        }

        if (this.ordinalsCollectorsOverheadTooHigh != null) {
            generator.writeKey("ordinals_collectors_overhead_too_high");
            generator.write(this.ordinalsCollectorsOverheadTooHigh);
        }

        if (this.ordinalsCollectorsUsed != null) {
            generator.writeKey("ordinals_collectors_used");
            generator.write(this.ordinalsCollectorsUsed);
        }

        if (this.resultStrategy != null) {
            generator.writeKey("result_strategy");
            generator.write(this.resultStrategy);
        }

        if (this.segmentsWithMultiValuedOrds != null) {
            generator.writeKey("segments_with_multi_valued_ords");
            generator.write(this.segmentsWithMultiValuedOrds);
        }

        if (this.segmentsWithSingleValuedOrds != null) {
            generator.writeKey("segments_with_single_valued_ords");
            generator.write(this.segmentsWithSingleValuedOrds);
        }

        if (this.stringHashingCollectorsUsed != null) {
            generator.writeKey("string_hashing_collectors_used");
            generator.write(this.stringHashingCollectorsUsed);
        }

        if (this.survivingBuckets != null) {
            generator.writeKey("surviving_buckets");
            generator.write(this.survivingBuckets);
        }

        if (this.totalBuckets != null) {
            generator.writeKey("total_buckets");
            generator.write(this.totalBuckets);
        }

        if (this.valuesFetched != null) {
            generator.writeKey("values_fetched");
            generator.write(this.valuesFetched);
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
     * Builder for {@link AggregationProfileDebug}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, AggregationProfileDebug> {
        @Nullable
        private Integer builtBuckets;
        @Nullable
        private Integer charsFetched;
        @Nullable
        private Integer collectAnalyzedCount;
        @Nullable
        private Integer collectAnalyzedNs;
        @Nullable
        private String collectionStrategy;
        @Nullable
        private List<String> deferredAggregators;
        @Nullable
        private String delegate;
        @Nullable
        private AggregationProfileDelegateDebug delegateDebug;
        @Nullable
        private Integer emptyCollectorsUsed;
        @Nullable
        private Integer extractCount;
        @Nullable
        private Integer extractNs;
        @Nullable
        private Boolean hasFilter;
        @Nullable
        private String mapReducer;
        @Nullable
        private Integer numericCollectorsUsed;
        @Nullable
        private Integer ordinalsCollectorsOverheadTooHigh;
        @Nullable
        private Integer ordinalsCollectorsUsed;
        @Nullable
        private String resultStrategy;
        @Nullable
        private Integer segmentsWithMultiValuedOrds;
        @Nullable
        private Integer segmentsWithSingleValuedOrds;
        @Nullable
        private Integer stringHashingCollectorsUsed;
        @Nullable
        private Integer survivingBuckets;
        @Nullable
        private Integer totalBuckets;
        @Nullable
        private Integer valuesFetched;

        public Builder() {}

        private Builder(AggregationProfileDebug o) {
            this.builtBuckets = o.builtBuckets;
            this.charsFetched = o.charsFetched;
            this.collectAnalyzedCount = o.collectAnalyzedCount;
            this.collectAnalyzedNs = o.collectAnalyzedNs;
            this.collectionStrategy = o.collectionStrategy;
            this.deferredAggregators = _listCopy(o.deferredAggregators);
            this.delegate = o.delegate;
            this.delegateDebug = o.delegateDebug;
            this.emptyCollectorsUsed = o.emptyCollectorsUsed;
            this.extractCount = o.extractCount;
            this.extractNs = o.extractNs;
            this.hasFilter = o.hasFilter;
            this.mapReducer = o.mapReducer;
            this.numericCollectorsUsed = o.numericCollectorsUsed;
            this.ordinalsCollectorsOverheadTooHigh = o.ordinalsCollectorsOverheadTooHigh;
            this.ordinalsCollectorsUsed = o.ordinalsCollectorsUsed;
            this.resultStrategy = o.resultStrategy;
            this.segmentsWithMultiValuedOrds = o.segmentsWithMultiValuedOrds;
            this.segmentsWithSingleValuedOrds = o.segmentsWithSingleValuedOrds;
            this.stringHashingCollectorsUsed = o.stringHashingCollectorsUsed;
            this.survivingBuckets = o.survivingBuckets;
            this.totalBuckets = o.totalBuckets;
            this.valuesFetched = o.valuesFetched;
        }

        private Builder(Builder o) {
            this.builtBuckets = o.builtBuckets;
            this.charsFetched = o.charsFetched;
            this.collectAnalyzedCount = o.collectAnalyzedCount;
            this.collectAnalyzedNs = o.collectAnalyzedNs;
            this.collectionStrategy = o.collectionStrategy;
            this.deferredAggregators = _listCopy(o.deferredAggregators);
            this.delegate = o.delegate;
            this.delegateDebug = o.delegateDebug;
            this.emptyCollectorsUsed = o.emptyCollectorsUsed;
            this.extractCount = o.extractCount;
            this.extractNs = o.extractNs;
            this.hasFilter = o.hasFilter;
            this.mapReducer = o.mapReducer;
            this.numericCollectorsUsed = o.numericCollectorsUsed;
            this.ordinalsCollectorsOverheadTooHigh = o.ordinalsCollectorsOverheadTooHigh;
            this.ordinalsCollectorsUsed = o.ordinalsCollectorsUsed;
            this.resultStrategy = o.resultStrategy;
            this.segmentsWithMultiValuedOrds = o.segmentsWithMultiValuedOrds;
            this.segmentsWithSingleValuedOrds = o.segmentsWithSingleValuedOrds;
            this.stringHashingCollectorsUsed = o.stringHashingCollectorsUsed;
            this.survivingBuckets = o.survivingBuckets;
            this.totalBuckets = o.totalBuckets;
            this.valuesFetched = o.valuesFetched;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code built_buckets}
         */
        @Nonnull
        public final Builder builtBuckets(@Nullable Integer value) {
            this.builtBuckets = value;
            return this;
        }

        /**
         * API name: {@code chars_fetched}
         */
        @Nonnull
        public final Builder charsFetched(@Nullable Integer value) {
            this.charsFetched = value;
            return this;
        }

        /**
         * API name: {@code collect_analyzed_count}
         */
        @Nonnull
        public final Builder collectAnalyzedCount(@Nullable Integer value) {
            this.collectAnalyzedCount = value;
            return this;
        }

        /**
         * API name: {@code collect_analyzed_ns}
         */
        @Nonnull
        public final Builder collectAnalyzedNs(@Nullable Integer value) {
            this.collectAnalyzedNs = value;
            return this;
        }

        /**
         * API name: {@code collection_strategy}
         */
        @Nonnull
        public final Builder collectionStrategy(@Nullable String value) {
            this.collectionStrategy = value;
            return this;
        }

        /**
         * API name: {@code deferred_aggregators}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>deferredAggregators</code>.
         * </p>
         */
        @Nonnull
        public final Builder deferredAggregators(List<String> list) {
            this.deferredAggregators = _listAddAll(this.deferredAggregators, list);
            return this;
        }

        /**
         * API name: {@code deferred_aggregators}
         *
         * <p>
         * Adds one or more values to <code>deferredAggregators</code>.
         * </p>
         */
        @Nonnull
        public final Builder deferredAggregators(String value, String... values) {
            this.deferredAggregators = _listAdd(this.deferredAggregators, value, values);
            return this;
        }

        /**
         * API name: {@code delegate}
         */
        @Nonnull
        public final Builder delegate(@Nullable String value) {
            this.delegate = value;
            return this;
        }

        /**
         * API name: {@code delegate_debug}
         */
        @Nonnull
        public final Builder delegateDebug(@Nullable AggregationProfileDelegateDebug value) {
            this.delegateDebug = value;
            return this;
        }

        /**
         * API name: {@code delegate_debug}
         */
        @Nonnull
        public final Builder delegateDebug(
            Function<AggregationProfileDelegateDebug.Builder, ObjectBuilder<AggregationProfileDelegateDebug>> fn
        ) {
            return delegateDebug(fn.apply(new AggregationProfileDelegateDebug.Builder()).build());
        }

        /**
         * API name: {@code empty_collectors_used}
         */
        @Nonnull
        public final Builder emptyCollectorsUsed(@Nullable Integer value) {
            this.emptyCollectorsUsed = value;
            return this;
        }

        /**
         * API name: {@code extract_count}
         */
        @Nonnull
        public final Builder extractCount(@Nullable Integer value) {
            this.extractCount = value;
            return this;
        }

        /**
         * API name: {@code extract_ns}
         */
        @Nonnull
        public final Builder extractNs(@Nullable Integer value) {
            this.extractNs = value;
            return this;
        }

        /**
         * API name: {@code has_filter}
         */
        @Nonnull
        public final Builder hasFilter(@Nullable Boolean value) {
            this.hasFilter = value;
            return this;
        }

        /**
         * API name: {@code map_reducer}
         */
        @Nonnull
        public final Builder mapReducer(@Nullable String value) {
            this.mapReducer = value;
            return this;
        }

        /**
         * API name: {@code numeric_collectors_used}
         */
        @Nonnull
        public final Builder numericCollectorsUsed(@Nullable Integer value) {
            this.numericCollectorsUsed = value;
            return this;
        }

        /**
         * API name: {@code ordinals_collectors_overhead_too_high}
         */
        @Nonnull
        public final Builder ordinalsCollectorsOverheadTooHigh(@Nullable Integer value) {
            this.ordinalsCollectorsOverheadTooHigh = value;
            return this;
        }

        /**
         * API name: {@code ordinals_collectors_used}
         */
        @Nonnull
        public final Builder ordinalsCollectorsUsed(@Nullable Integer value) {
            this.ordinalsCollectorsUsed = value;
            return this;
        }

        /**
         * API name: {@code result_strategy}
         */
        @Nonnull
        public final Builder resultStrategy(@Nullable String value) {
            this.resultStrategy = value;
            return this;
        }

        /**
         * API name: {@code segments_with_multi_valued_ords}
         */
        @Nonnull
        public final Builder segmentsWithMultiValuedOrds(@Nullable Integer value) {
            this.segmentsWithMultiValuedOrds = value;
            return this;
        }

        /**
         * API name: {@code segments_with_single_valued_ords}
         */
        @Nonnull
        public final Builder segmentsWithSingleValuedOrds(@Nullable Integer value) {
            this.segmentsWithSingleValuedOrds = value;
            return this;
        }

        /**
         * API name: {@code string_hashing_collectors_used}
         */
        @Nonnull
        public final Builder stringHashingCollectorsUsed(@Nullable Integer value) {
            this.stringHashingCollectorsUsed = value;
            return this;
        }

        /**
         * API name: {@code surviving_buckets}
         */
        @Nonnull
        public final Builder survivingBuckets(@Nullable Integer value) {
            this.survivingBuckets = value;
            return this;
        }

        /**
         * API name: {@code total_buckets}
         */
        @Nonnull
        public final Builder totalBuckets(@Nullable Integer value) {
            this.totalBuckets = value;
            return this;
        }

        /**
         * API name: {@code values_fetched}
         */
        @Nonnull
        public final Builder valuesFetched(@Nullable Integer value) {
            this.valuesFetched = value;
            return this;
        }

        /**
         * Builds a {@link AggregationProfileDebug}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public AggregationProfileDebug build() {
            _checkSingleUse();

            return new AggregationProfileDebug(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link AggregationProfileDebug}
     */
    public static final JsonpDeserializer<AggregationProfileDebug> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        AggregationProfileDebug::setupAggregationProfileDebugDeserializer
    );

    protected static void setupAggregationProfileDebugDeserializer(ObjectDeserializer<AggregationProfileDebug.Builder> op) {
        op.add(Builder::builtBuckets, JsonpDeserializer.integerDeserializer(), "built_buckets");
        op.add(Builder::charsFetched, JsonpDeserializer.integerDeserializer(), "chars_fetched");
        op.add(Builder::collectAnalyzedCount, JsonpDeserializer.integerDeserializer(), "collect_analyzed_count");
        op.add(Builder::collectAnalyzedNs, JsonpDeserializer.integerDeserializer(), "collect_analyzed_ns");
        op.add(Builder::collectionStrategy, JsonpDeserializer.stringDeserializer(), "collection_strategy");
        op.add(
            Builder::deferredAggregators,
            JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()),
            "deferred_aggregators"
        );
        op.add(Builder::delegate, JsonpDeserializer.stringDeserializer(), "delegate");
        op.add(Builder::delegateDebug, AggregationProfileDelegateDebug._DESERIALIZER, "delegate_debug");
        op.add(Builder::emptyCollectorsUsed, JsonpDeserializer.integerDeserializer(), "empty_collectors_used");
        op.add(Builder::extractCount, JsonpDeserializer.integerDeserializer(), "extract_count");
        op.add(Builder::extractNs, JsonpDeserializer.integerDeserializer(), "extract_ns");
        op.add(Builder::hasFilter, JsonpDeserializer.booleanDeserializer(), "has_filter");
        op.add(Builder::mapReducer, JsonpDeserializer.stringDeserializer(), "map_reducer");
        op.add(Builder::numericCollectorsUsed, JsonpDeserializer.integerDeserializer(), "numeric_collectors_used");
        op.add(
            Builder::ordinalsCollectorsOverheadTooHigh,
            JsonpDeserializer.integerDeserializer(),
            "ordinals_collectors_overhead_too_high"
        );
        op.add(Builder::ordinalsCollectorsUsed, JsonpDeserializer.integerDeserializer(), "ordinals_collectors_used");
        op.add(Builder::resultStrategy, JsonpDeserializer.stringDeserializer(), "result_strategy");
        op.add(Builder::segmentsWithMultiValuedOrds, JsonpDeserializer.integerDeserializer(), "segments_with_multi_valued_ords");
        op.add(Builder::segmentsWithSingleValuedOrds, JsonpDeserializer.integerDeserializer(), "segments_with_single_valued_ords");
        op.add(Builder::stringHashingCollectorsUsed, JsonpDeserializer.integerDeserializer(), "string_hashing_collectors_used");
        op.add(Builder::survivingBuckets, JsonpDeserializer.integerDeserializer(), "surviving_buckets");
        op.add(Builder::totalBuckets, JsonpDeserializer.integerDeserializer(), "total_buckets");
        op.add(Builder::valuesFetched, JsonpDeserializer.integerDeserializer(), "values_fetched");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.builtBuckets);
        result = 31 * result + Objects.hashCode(this.charsFetched);
        result = 31 * result + Objects.hashCode(this.collectAnalyzedCount);
        result = 31 * result + Objects.hashCode(this.collectAnalyzedNs);
        result = 31 * result + Objects.hashCode(this.collectionStrategy);
        result = 31 * result + Objects.hashCode(this.deferredAggregators);
        result = 31 * result + Objects.hashCode(this.delegate);
        result = 31 * result + Objects.hashCode(this.delegateDebug);
        result = 31 * result + Objects.hashCode(this.emptyCollectorsUsed);
        result = 31 * result + Objects.hashCode(this.extractCount);
        result = 31 * result + Objects.hashCode(this.extractNs);
        result = 31 * result + Objects.hashCode(this.hasFilter);
        result = 31 * result + Objects.hashCode(this.mapReducer);
        result = 31 * result + Objects.hashCode(this.numericCollectorsUsed);
        result = 31 * result + Objects.hashCode(this.ordinalsCollectorsOverheadTooHigh);
        result = 31 * result + Objects.hashCode(this.ordinalsCollectorsUsed);
        result = 31 * result + Objects.hashCode(this.resultStrategy);
        result = 31 * result + Objects.hashCode(this.segmentsWithMultiValuedOrds);
        result = 31 * result + Objects.hashCode(this.segmentsWithSingleValuedOrds);
        result = 31 * result + Objects.hashCode(this.stringHashingCollectorsUsed);
        result = 31 * result + Objects.hashCode(this.survivingBuckets);
        result = 31 * result + Objects.hashCode(this.totalBuckets);
        result = 31 * result + Objects.hashCode(this.valuesFetched);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        AggregationProfileDebug other = (AggregationProfileDebug) o;
        return Objects.equals(this.builtBuckets, other.builtBuckets)
            && Objects.equals(this.charsFetched, other.charsFetched)
            && Objects.equals(this.collectAnalyzedCount, other.collectAnalyzedCount)
            && Objects.equals(this.collectAnalyzedNs, other.collectAnalyzedNs)
            && Objects.equals(this.collectionStrategy, other.collectionStrategy)
            && Objects.equals(this.deferredAggregators, other.deferredAggregators)
            && Objects.equals(this.delegate, other.delegate)
            && Objects.equals(this.delegateDebug, other.delegateDebug)
            && Objects.equals(this.emptyCollectorsUsed, other.emptyCollectorsUsed)
            && Objects.equals(this.extractCount, other.extractCount)
            && Objects.equals(this.extractNs, other.extractNs)
            && Objects.equals(this.hasFilter, other.hasFilter)
            && Objects.equals(this.mapReducer, other.mapReducer)
            && Objects.equals(this.numericCollectorsUsed, other.numericCollectorsUsed)
            && Objects.equals(this.ordinalsCollectorsOverheadTooHigh, other.ordinalsCollectorsOverheadTooHigh)
            && Objects.equals(this.ordinalsCollectorsUsed, other.ordinalsCollectorsUsed)
            && Objects.equals(this.resultStrategy, other.resultStrategy)
            && Objects.equals(this.segmentsWithMultiValuedOrds, other.segmentsWithMultiValuedOrds)
            && Objects.equals(this.segmentsWithSingleValuedOrds, other.segmentsWithSingleValuedOrds)
            && Objects.equals(this.stringHashingCollectorsUsed, other.stringHashingCollectorsUsed)
            && Objects.equals(this.survivingBuckets, other.survivingBuckets)
            && Objects.equals(this.totalBuckets, other.totalBuckets)
            && Objects.equals(this.valuesFetched, other.valuesFetched);
    }
}
