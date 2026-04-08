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
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.opensearch.client.json.JsonData;
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

// typedef: _types.aggregations.MultiTermsAggregate

@Generated("org.opensearch.client.codegen.CodeGenerator")
public class MultiTermsAggregate<TBucket>
    implements
        AggregateVariant,
        PlainJsonSerializable,
        ToCopyableBuilder<MultiTermsAggregate.Builder<TBucket>, MultiTermsAggregate<TBucket>> {

    @Nonnull
    private final Buckets<TBucket> buckets;

    @Nullable
    private final Long docCountErrorUpperBound;

    @Nonnull
    private final Map<String, JsonData> meta;

    @Nullable
    private final Long sumOtherDocCount;

    // ---------------------------------------------------------------------------------------------

    private MultiTermsAggregate(Builder<TBucket> builder) {
        this.buckets = ApiTypeHelper.requireNonNull(builder.buckets, this, "buckets");
        this.docCountErrorUpperBound = builder.docCountErrorUpperBound;
        this.meta = ApiTypeHelper.unmodifiable(builder.meta);
        this.sumOtherDocCount = builder.sumOtherDocCount;
    }

    public static <TBucket> MultiTermsAggregate<TBucket> of(
        Function<MultiTermsAggregate.Builder<TBucket>, ObjectBuilder<MultiTermsAggregate<TBucket>>> fn
    ) {
        return fn.apply(new Builder<>()).build();
    }

    /**
     * {@link Aggregate} variant kind.
     */
    @Override
    public Aggregate.Kind _aggregateKind() {
        return Aggregate.Kind.MultiTerms;
    }

    /**
     * Required - API name: {@code buckets}
     */
    @Nonnull
    public final Buckets<TBucket> buckets() {
        return this.buckets;
    }

    /**
     * API name: {@code doc_count_error_upper_bound}
     */
    @Nullable
    public final Long docCountErrorUpperBound() {
        return this.docCountErrorUpperBound;
    }

    /**
     * API name: {@code meta}
     */
    @Nonnull
    public final Map<String, JsonData> meta() {
        return this.meta;
    }

    /**
     * API name: {@code sum_other_doc_count}
     */
    @Nullable
    public final Long sumOtherDocCount() {
        return this.sumOtherDocCount;
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
        generator.writeKey("buckets");
        this.buckets.serialize(generator, mapper);

        if (this.docCountErrorUpperBound != null) {
            generator.writeKey("doc_count_error_upper_bound");
            generator.write(this.docCountErrorUpperBound);
        }

        if (ApiTypeHelper.isDefined(this.meta)) {
            generator.writeKey("meta");
            generator.writeStartObject();
            for (Map.Entry<String, JsonData> item0 : this.meta.entrySet()) {
                generator.writeKey(item0.getKey());
                item0.getValue().serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (this.sumOtherDocCount != null) {
            generator.writeKey("sum_other_doc_count");
            generator.write(this.sumOtherDocCount);
        }
    }

    // ---------------------------------------------------------------------------------------------

    @Override
    @Nonnull
    public Builder<TBucket> toBuilder() {
        return new Builder<>(this);
    }

    @Nonnull
    public static <TBucket> Builder builder() {
        return new Builder<>();
    }

    /**
     * Builder for {@link MultiTermsAggregate}.
     */
    public static class Builder<TBucket> extends ObjectBuilderBase
        implements
            CopyableBuilder<Builder<TBucket>, MultiTermsAggregate<TBucket>> {
        private Buckets<TBucket> buckets;
        @Nullable
        private Long docCountErrorUpperBound;
        @Nullable
        private Map<String, JsonData> meta;
        @Nullable
        private Long sumOtherDocCount;

        public Builder() {}

        private Builder(MultiTermsAggregate<TBucket> o) {
            this.buckets = o.buckets;
            this.docCountErrorUpperBound = o.docCountErrorUpperBound;
            this.meta = _mapCopy(o.meta);
            this.sumOtherDocCount = o.sumOtherDocCount;
        }

        private Builder(Builder<TBucket> o) {
            this.buckets = o.buckets;
            this.docCountErrorUpperBound = o.docCountErrorUpperBound;
            this.meta = _mapCopy(o.meta);
            this.sumOtherDocCount = o.sumOtherDocCount;
        }

        @Override
        @Nonnull
        public Builder<TBucket> copy() {
            return new Builder<>(this);
        }

        /**
         * Required - API name: {@code buckets}
         */
        @Nonnull
        public final Builder<TBucket> buckets(Buckets<TBucket> value) {
            this.buckets = value;
            return this;
        }

        /**
         * Required - API name: {@code buckets}
         */
        @Nonnull
        public final Builder<TBucket> buckets(Function<Buckets.Builder<TBucket>, ObjectBuilder<Buckets<TBucket>>> fn) {
            return buckets(fn.apply(new Buckets.Builder<TBucket>()).build());
        }

        /**
         * API name: {@code doc_count_error_upper_bound}
         */
        @Nonnull
        public final Builder<TBucket> docCountErrorUpperBound(@Nullable Long value) {
            this.docCountErrorUpperBound = value;
            return this;
        }

        /**
         * API name: {@code meta}
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>meta</code>.
         * </p>
         */
        @Nonnull
        public final Builder<TBucket> meta(Map<String, JsonData> map) {
            this.meta = _mapPutAll(this.meta, map);
            return this;
        }

        /**
         * API name: {@code meta}
         *
         * <p>
         * Adds an entry to <code>meta</code>.
         * </p>
         */
        @Nonnull
        public final Builder<TBucket> meta(String key, JsonData value) {
            this.meta = _mapPut(this.meta, key, value);
            return this;
        }

        /**
         * API name: {@code sum_other_doc_count}
         */
        @Nonnull
        public final Builder<TBucket> sumOtherDocCount(@Nullable Long value) {
            this.sumOtherDocCount = value;
            return this;
        }

        /**
         * Builds a {@link MultiTermsAggregate}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public MultiTermsAggregate<TBucket> build() {
            _checkSingleUse();

            return new MultiTermsAggregate<>(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Create a JSON deserializer for MultiTermsAggregate.
     */
    public static <TBucket> JsonpDeserializer<MultiTermsAggregate<TBucket>> createMultiTermsAggregateDeserializer(
        JsonpDeserializer<TBucket> tBucketDeserializer
    ) {
        return ObjectBuilderDeserializer.createForObject(
            Builder<TBucket>::new,
            op -> MultiTermsAggregate.setupMultiTermsAggregateDeserializer(op, tBucketDeserializer)
        );
    }

    protected static <TBucket> void setupMultiTermsAggregateDeserializer(
        ObjectDeserializer<MultiTermsAggregate.Builder<TBucket>> op,
        JsonpDeserializer<TBucket> tBucketDeserializer
    ) {
        op.add(Builder::buckets, Buckets.createBucketsDeserializer(tBucketDeserializer), "buckets");
        op.add(Builder::docCountErrorUpperBound, JsonpDeserializer.longDeserializer(), "doc_count_error_upper_bound");
        op.add(Builder::meta, JsonpDeserializer.stringMapDeserializer(JsonData._DESERIALIZER), "meta");
        op.add(Builder::sumOtherDocCount, JsonpDeserializer.longDeserializer(), "sum_other_doc_count");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.buckets.hashCode();
        result = 31 * result + Objects.hashCode(this.docCountErrorUpperBound);
        result = 31 * result + Objects.hashCode(this.meta);
        result = 31 * result + Objects.hashCode(this.sumOtherDocCount);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        MultiTermsAggregate<?> other = (MultiTermsAggregate<?>) o;
        return this.buckets.equals(other.buckets)
            && Objects.equals(this.docCountErrorUpperBound, other.docCountErrorUpperBound)
            && Objects.equals(this.meta, other.meta)
            && Objects.equals(this.sumOtherDocCount, other.sumOtherDocCount);
    }
}
