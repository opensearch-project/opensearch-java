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

package org.opensearch.client.opensearch._types.aggregations;

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
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: _types.aggregations.MultiTermsAggregation

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class MultiTermsAggregation extends BucketAggregationBase
    implements
        AggregationVariant,
        ToCopyableBuilder<MultiTermsAggregation.Builder, MultiTermsAggregation> {

    @Nullable
    private final TermsAggregationCollectMode collectMode;

    @Nullable
    private final Integer minDocCount;

    @Nullable
    private final HistogramOrder order;

    @Nullable
    private final Integer shardMinDocCount;

    @Nullable
    private final Integer shardSize;

    @Nullable
    private final Boolean showTermDocCountError;

    @Nullable
    private final Integer size;

    @Nonnull
    private final List<MultiTermLookup> terms;

    // ---------------------------------------------------------------------------------------------

    private MultiTermsAggregation(Builder builder) {
        super(builder);
        this.collectMode = builder.collectMode;
        this.minDocCount = builder.minDocCount;
        this.order = builder.order;
        this.shardMinDocCount = builder.shardMinDocCount;
        this.shardSize = builder.shardSize;
        this.showTermDocCountError = builder.showTermDocCountError;
        this.size = builder.size;
        this.terms = ApiTypeHelper.unmodifiableRequired(builder.terms, this, "terms");
    }

    public static MultiTermsAggregation of(Function<MultiTermsAggregation.Builder, ObjectBuilder<MultiTermsAggregation>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link Aggregation} variant kind.
     */
    @Override
    public Aggregation.Kind _aggregationKind() {
        return Aggregation.Kind.MultiTerms;
    }

    /**
     * API name: {@code collect_mode}
     */
    @Nullable
    public final TermsAggregationCollectMode collectMode() {
        return this.collectMode;
    }

    /**
     * The minimum number of documents in a bucket for it to be returned.
     * <p>
     * API name: {@code min_doc_count}
     * </p>
     */
    @Nullable
    public final Integer minDocCount() {
        return this.minDocCount;
    }

    /**
     * API name: {@code order}
     */
    @Nullable
    public final HistogramOrder order() {
        return this.order;
    }

    /**
     * The minimum number of documents in a bucket on each shard for it to be returned.
     * <p>
     * API name: {@code shard_min_doc_count}
     * </p>
     */
    @Nullable
    public final Integer shardMinDocCount() {
        return this.shardMinDocCount;
    }

    /**
     * The number of candidate terms produced by each shard. By default, <code>shard_size</code> will be automatically estimated based on
     * the number of shards and the <code>size</code> parameter.
     * <p>
     * API name: {@code shard_size}
     * </p>
     */
    @Nullable
    public final Integer shardSize() {
        return this.shardSize;
    }

    /**
     * Calculates the doc count error on per term basis.
     * <p>
     * API name: {@code show_term_doc_count_error}
     * </p>
     */
    @Nullable
    public final Boolean showTermDocCountError() {
        return this.showTermDocCountError;
    }

    /**
     * The number of term buckets should be returned out of the overall terms list.
     * <p>
     * API name: {@code size}
     * </p>
     */
    @Nullable
    public final Integer size() {
        return this.size;
    }

    /**
     * Required - The field from which to generate sets of terms.
     * <p>
     * API name: {@code terms}
     * </p>
     */
    @Nonnull
    public final List<MultiTermLookup> terms() {
        return this.terms;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        super.serializeInternal(generator, mapper);
        if (this.collectMode != null) {
            generator.writeKey("collect_mode");
            this.collectMode.serialize(generator, mapper);
        }

        if (this.minDocCount != null) {
            generator.writeKey("min_doc_count");
            generator.write(this.minDocCount);
        }

        if (this.order != null) {
            generator.writeKey("order");
            this.order.serialize(generator, mapper);
        }

        if (this.shardMinDocCount != null) {
            generator.writeKey("shard_min_doc_count");
            generator.write(this.shardMinDocCount);
        }

        if (this.shardSize != null) {
            generator.writeKey("shard_size");
            generator.write(this.shardSize);
        }

        if (this.showTermDocCountError != null) {
            generator.writeKey("show_term_doc_count_error");
            generator.write(this.showTermDocCountError);
        }

        if (this.size != null) {
            generator.writeKey("size");
            generator.write(this.size);
        }

        generator.writeKey("terms");
        generator.writeStartArray();
        for (MultiTermLookup item0 : this.terms) {
            item0.serialize(generator, mapper);
        }
        generator.writeEnd();
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
     * Builder for {@link MultiTermsAggregation}.
     */
    public static class Builder extends BucketAggregationBase.AbstractBuilder<Builder>
        implements
            CopyableBuilder<Builder, MultiTermsAggregation> {
        @Nullable
        private TermsAggregationCollectMode collectMode;
        @Nullable
        private Integer minDocCount;
        @Nullable
        private HistogramOrder order;
        @Nullable
        private Integer shardMinDocCount;
        @Nullable
        private Integer shardSize;
        @Nullable
        private Boolean showTermDocCountError;
        @Nullable
        private Integer size;
        private List<MultiTermLookup> terms;

        public Builder() {}

        private Builder(MultiTermsAggregation o) {
            super(o);
            this.collectMode = o.collectMode;
            this.minDocCount = o.minDocCount;
            this.order = o.order;
            this.shardMinDocCount = o.shardMinDocCount;
            this.shardSize = o.shardSize;
            this.showTermDocCountError = o.showTermDocCountError;
            this.size = o.size;
            this.terms = _listCopy(o.terms);
        }

        private Builder(Builder o) {
            super(o);
            this.collectMode = o.collectMode;
            this.minDocCount = o.minDocCount;
            this.order = o.order;
            this.shardMinDocCount = o.shardMinDocCount;
            this.shardSize = o.shardSize;
            this.showTermDocCountError = o.showTermDocCountError;
            this.size = o.size;
            this.terms = _listCopy(o.terms);
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        @Override
        @Nonnull
        protected Builder self() {
            return this;
        }

        /**
         * API name: {@code collect_mode}
         */
        @Nonnull
        public final Builder collectMode(@Nullable TermsAggregationCollectMode value) {
            this.collectMode = value;
            return this;
        }

        /**
         * The minimum number of documents in a bucket for it to be returned.
         * <p>
         * API name: {@code min_doc_count}
         * </p>
         */
        @Nonnull
        public final Builder minDocCount(@Nullable Integer value) {
            this.minDocCount = value;
            return this;
        }

        /**
         * API name: {@code order}
         */
        @Nonnull
        public final Builder order(@Nullable HistogramOrder value) {
            this.order = value;
            return this;
        }

        /**
         * API name: {@code order}
         */
        @Nonnull
        public final Builder order(Function<HistogramOrder.Builder, ObjectBuilder<HistogramOrder>> fn) {
            return order(fn.apply(new HistogramOrder.Builder()).build());
        }

        /**
         * The minimum number of documents in a bucket on each shard for it to be returned.
         * <p>
         * API name: {@code shard_min_doc_count}
         * </p>
         */
        @Nonnull
        public final Builder shardMinDocCount(@Nullable Integer value) {
            this.shardMinDocCount = value;
            return this;
        }

        /**
         * The number of candidate terms produced by each shard. By default, <code>shard_size</code> will be automatically estimated based
         * on the number of shards and the <code>size</code> parameter.
         * <p>
         * API name: {@code shard_size}
         * </p>
         */
        @Nonnull
        public final Builder shardSize(@Nullable Integer value) {
            this.shardSize = value;
            return this;
        }

        /**
         * Calculates the doc count error on per term basis.
         * <p>
         * API name: {@code show_term_doc_count_error}
         * </p>
         */
        @Nonnull
        public final Builder showTermDocCountError(@Nullable Boolean value) {
            this.showTermDocCountError = value;
            return this;
        }

        /**
         * The number of term buckets should be returned out of the overall terms list.
         * <p>
         * API name: {@code size}
         * </p>
         */
        @Nonnull
        public final Builder size(@Nullable Integer value) {
            this.size = value;
            return this;
        }

        /**
         * Required - The field from which to generate sets of terms.
         * <p>
         * API name: {@code terms}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>terms</code>.
         * </p>
         */
        @Nonnull
        public final Builder terms(List<MultiTermLookup> list) {
            this.terms = _listAddAll(this.terms, list);
            return this;
        }

        /**
         * Required - The field from which to generate sets of terms.
         * <p>
         * API name: {@code terms}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>terms</code>.
         * </p>
         */
        @Nonnull
        public final Builder terms(MultiTermLookup value, MultiTermLookup... values) {
            this.terms = _listAdd(this.terms, value, values);
            return this;
        }

        /**
         * Required - The field from which to generate sets of terms.
         * <p>
         * API name: {@code terms}
         * </p>
         *
         * <p>
         * Adds a value to <code>terms</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder terms(Function<MultiTermLookup.Builder, ObjectBuilder<MultiTermLookup>> fn) {
            return terms(fn.apply(new MultiTermLookup.Builder()).build());
        }

        /**
         * Builds a {@link MultiTermsAggregation}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public MultiTermsAggregation build() {
            _checkSingleUse();

            return new MultiTermsAggregation(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link MultiTermsAggregation}
     */
    public static final JsonpDeserializer<MultiTermsAggregation> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        MultiTermsAggregation::setupMultiTermsAggregationDeserializer
    );

    protected static void setupMultiTermsAggregationDeserializer(ObjectDeserializer<MultiTermsAggregation.Builder> op) {
        setupBucketAggregationBaseDeserializer(op);
        op.add(Builder::collectMode, TermsAggregationCollectMode._DESERIALIZER, "collect_mode");
        op.add(Builder::minDocCount, JsonpDeserializer.integerDeserializer(), "min_doc_count");
        op.add(Builder::order, HistogramOrder._DESERIALIZER, "order");
        op.add(Builder::shardMinDocCount, JsonpDeserializer.integerDeserializer(), "shard_min_doc_count");
        op.add(Builder::shardSize, JsonpDeserializer.integerDeserializer(), "shard_size");
        op.add(Builder::showTermDocCountError, JsonpDeserializer.booleanDeserializer(), "show_term_doc_count_error");
        op.add(Builder::size, JsonpDeserializer.integerDeserializer(), "size");
        op.add(Builder::terms, JsonpDeserializer.arrayDeserializer(MultiTermLookup._DESERIALIZER), "terms");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(this.collectMode);
        result = 31 * result + Objects.hashCode(this.minDocCount);
        result = 31 * result + Objects.hashCode(this.order);
        result = 31 * result + Objects.hashCode(this.shardMinDocCount);
        result = 31 * result + Objects.hashCode(this.shardSize);
        result = 31 * result + Objects.hashCode(this.showTermDocCountError);
        result = 31 * result + Objects.hashCode(this.size);
        result = 31 * result + this.terms.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        MultiTermsAggregation other = (MultiTermsAggregation) o;
        return Objects.equals(this.collectMode, other.collectMode)
            && Objects.equals(this.minDocCount, other.minDocCount)
            && Objects.equals(this.order, other.order)
            && Objects.equals(this.shardMinDocCount, other.shardMinDocCount)
            && Objects.equals(this.shardSize, other.shardSize)
            && Objects.equals(this.showTermDocCountError, other.showTermDocCountError)
            && Objects.equals(this.size, other.size)
            && this.terms.equals(other.terms);
    }
}
