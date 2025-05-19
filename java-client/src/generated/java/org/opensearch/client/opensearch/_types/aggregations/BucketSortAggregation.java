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
import org.opensearch.client.opensearch._types.SortOptions;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: _types.aggregations.BucketSortAggregation

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class BucketSortAggregation extends AggregationBase
    implements
        AggregationVariant,
        ToCopyableBuilder<BucketSortAggregation.Builder, BucketSortAggregation> {

    @Nullable
    private final Integer from;

    @Nullable
    private final GapPolicy gapPolicy;

    @Nullable
    private final Integer size;

    @Nonnull
    private final List<SortOptions> sort;

    // ---------------------------------------------------------------------------------------------

    private BucketSortAggregation(Builder builder) {
        super(builder);
        this.from = builder.from;
        this.gapPolicy = builder.gapPolicy;
        this.size = builder.size;
        this.sort = ApiTypeHelper.unmodifiable(builder.sort);
    }

    public static BucketSortAggregation of(Function<BucketSortAggregation.Builder, ObjectBuilder<BucketSortAggregation>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link Aggregation} variant kind.
     */
    @Override
    public Aggregation.Kind _aggregationKind() {
        return Aggregation.Kind.BucketSort;
    }

    /**
     * Buckets in positions prior to <code>from</code> will be truncated.
     * <p>
     * API name: {@code from}
     * </p>
     */
    @Nullable
    public final Integer from() {
        return this.from;
    }

    /**
     * API name: {@code gap_policy}
     */
    @Nullable
    public final GapPolicy gapPolicy() {
        return this.gapPolicy;
    }

    /**
     * The number of buckets to return. Defaults to all buckets of the parent aggregation.
     * <p>
     * API name: {@code size}
     * </p>
     */
    @Nullable
    public final Integer size() {
        return this.size;
    }

    /**
     * API name: {@code sort}
     */
    @Nonnull
    public final List<SortOptions> sort() {
        return this.sort;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        super.serializeInternal(generator, mapper);
        if (this.from != null) {
            generator.writeKey("from");
            generator.write(this.from);
        }

        if (this.gapPolicy != null) {
            generator.writeKey("gap_policy");
            this.gapPolicy.serialize(generator, mapper);
        }

        if (this.size != null) {
            generator.writeKey("size");
            generator.write(this.size);
        }

        if (ApiTypeHelper.isDefined(this.sort)) {
            generator.writeKey("sort");
            generator.writeStartArray();
            for (SortOptions item0 : this.sort) {
                item0.serialize(generator, mapper);
            }
            generator.writeEnd();
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
     * Builder for {@link BucketSortAggregation}.
     */
    public static class Builder extends AggregationBase.AbstractBuilder<Builder>
        implements
            CopyableBuilder<Builder, BucketSortAggregation> {
        @Nullable
        private Integer from;
        @Nullable
        private GapPolicy gapPolicy;
        @Nullable
        private Integer size;
        @Nullable
        private List<SortOptions> sort;

        public Builder() {}

        private Builder(BucketSortAggregation o) {
            super(o);
            this.from = o.from;
            this.gapPolicy = o.gapPolicy;
            this.size = o.size;
            this.sort = _listCopy(o.sort);
        }

        private Builder(Builder o) {
            super(o);
            this.from = o.from;
            this.gapPolicy = o.gapPolicy;
            this.size = o.size;
            this.sort = _listCopy(o.sort);
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
         * Buckets in positions prior to <code>from</code> will be truncated.
         * <p>
         * API name: {@code from}
         * </p>
         */
        @Nonnull
        public final Builder from(@Nullable Integer value) {
            this.from = value;
            return this;
        }

        /**
         * API name: {@code gap_policy}
         */
        @Nonnull
        public final Builder gapPolicy(@Nullable GapPolicy value) {
            this.gapPolicy = value;
            return this;
        }

        /**
         * The number of buckets to return. Defaults to all buckets of the parent aggregation.
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
         * API name: {@code sort}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>sort</code>.
         * </p>
         */
        @Nonnull
        public final Builder sort(List<SortOptions> list) {
            this.sort = _listAddAll(this.sort, list);
            return this;
        }

        /**
         * API name: {@code sort}
         *
         * <p>
         * Adds one or more values to <code>sort</code>.
         * </p>
         */
        @Nonnull
        public final Builder sort(SortOptions value, SortOptions... values) {
            this.sort = _listAdd(this.sort, value, values);
            return this;
        }

        /**
         * API name: {@code sort}
         *
         * <p>
         * Adds a value to <code>sort</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder sort(Function<SortOptions.Builder, ObjectBuilder<SortOptions>> fn) {
            return sort(fn.apply(new SortOptions.Builder()).build());
        }

        /**
         * Builds a {@link BucketSortAggregation}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public BucketSortAggregation build() {
            _checkSingleUse();

            return new BucketSortAggregation(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link BucketSortAggregation}
     */
    public static final JsonpDeserializer<BucketSortAggregation> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        BucketSortAggregation::setupBucketSortAggregationDeserializer
    );

    protected static void setupBucketSortAggregationDeserializer(ObjectDeserializer<BucketSortAggregation.Builder> op) {
        setupAggregationBaseDeserializer(op);
        op.add(Builder::from, JsonpDeserializer.integerDeserializer(), "from");
        op.add(Builder::gapPolicy, GapPolicy._DESERIALIZER, "gap_policy");
        op.add(Builder::size, JsonpDeserializer.integerDeserializer(), "size");
        op.add(Builder::sort, JsonpDeserializer.arrayDeserializer(SortOptions._DESERIALIZER), "sort");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(this.from);
        result = 31 * result + Objects.hashCode(this.gapPolicy);
        result = 31 * result + Objects.hashCode(this.size);
        result = 31 * result + Objects.hashCode(this.sort);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        BucketSortAggregation other = (BucketSortAggregation) o;
        return Objects.equals(this.from, other.from)
            && Objects.equals(this.gapPolicy, other.gapPolicy)
            && Objects.equals(this.size, other.size)
            && Objects.equals(this.sort, other.sort);
    }
}
