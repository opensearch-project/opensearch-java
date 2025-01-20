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
import org.opensearch.client.opensearch._types.query_dsl.Query;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: _types.aggregations.FiltersAggregation

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class FiltersAggregation extends BucketAggregationBase
    implements
        AggregationVariant,
        ToCopyableBuilder<FiltersAggregation.Builder, FiltersAggregation> {

    @Nullable
    private final Buckets<Query> filters;

    @Nullable
    private final Boolean keyed;

    @Nullable
    private final Boolean otherBucket;

    @Nullable
    private final String otherBucketKey;

    // ---------------------------------------------------------------------------------------------

    private FiltersAggregation(Builder builder) {
        super(builder);
        this.filters = builder.filters;
        this.keyed = builder.keyed;
        this.otherBucket = builder.otherBucket;
        this.otherBucketKey = builder.otherBucketKey;
    }

    public static FiltersAggregation of(Function<FiltersAggregation.Builder, ObjectBuilder<FiltersAggregation>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link Aggregation} variant kind.
     */
    @Override
    public Aggregation.Kind _aggregationKind() {
        return Aggregation.Kind.Filters;
    }

    /**
     * API name: {@code filters}
     */
    @Nullable
    public final Buckets<Query> filters() {
        return this.filters;
    }

    /**
     * By default, the named filters aggregation returns the buckets as an object. Set to <code>false</code> to return the buckets as an
     * array of objects.
     * <p>
     * API name: {@code keyed}
     * </p>
     */
    @Nullable
    public final Boolean keyed() {
        return this.keyed;
    }

    /**
     * Set to <code>true</code> to add a bucket to the response which will contain all documents that do not match any of the given filters.
     * <p>
     * API name: {@code other_bucket}
     * </p>
     */
    @Nullable
    public final Boolean otherBucket() {
        return this.otherBucket;
    }

    /**
     * The key with which the other bucket is returned.
     * <p>
     * API name: {@code other_bucket_key}
     * </p>
     */
    @Nullable
    public final String otherBucketKey() {
        return this.otherBucketKey;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        super.serializeInternal(generator, mapper);
        if (this.filters != null) {
            generator.writeKey("filters");
            this.filters.serialize(generator, mapper);
        }

        if (this.keyed != null) {
            generator.writeKey("keyed");
            generator.write(this.keyed);
        }

        if (this.otherBucket != null) {
            generator.writeKey("other_bucket");
            generator.write(this.otherBucket);
        }

        if (this.otherBucketKey != null) {
            generator.writeKey("other_bucket_key");
            generator.write(this.otherBucketKey);
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
     * Builder for {@link FiltersAggregation}.
     */
    public static class Builder extends BucketAggregationBase.AbstractBuilder<Builder>
        implements
            CopyableBuilder<Builder, FiltersAggregation> {
        @Nullable
        private Buckets<Query> filters;
        @Nullable
        private Boolean keyed;
        @Nullable
        private Boolean otherBucket;
        @Nullable
        private String otherBucketKey;

        public Builder() {}

        private Builder(FiltersAggregation o) {
            super(o);
            this.filters = o.filters;
            this.keyed = o.keyed;
            this.otherBucket = o.otherBucket;
            this.otherBucketKey = o.otherBucketKey;
        }

        private Builder(Builder o) {
            super(o);
            this.filters = o.filters;
            this.keyed = o.keyed;
            this.otherBucket = o.otherBucket;
            this.otherBucketKey = o.otherBucketKey;
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
         * API name: {@code filters}
         */
        @Nonnull
        public final Builder filters(@Nullable Buckets<Query> value) {
            this.filters = value;
            return this;
        }

        /**
         * API name: {@code filters}
         */
        @Nonnull
        public final Builder filters(Function<Buckets.Builder, ObjectBuilder<Buckets<Query>>> fn) {
            return filters(fn.apply(new Buckets.Builder()).build());
        }

        /**
         * By default, the named filters aggregation returns the buckets as an object. Set to <code>false</code> to return the buckets as an
         * array of objects.
         * <p>
         * API name: {@code keyed}
         * </p>
         */
        @Nonnull
        public final Builder keyed(@Nullable Boolean value) {
            this.keyed = value;
            return this;
        }

        /**
         * Set to <code>true</code> to add a bucket to the response which will contain all documents that do not match any of the given
         * filters.
         * <p>
         * API name: {@code other_bucket}
         * </p>
         */
        @Nonnull
        public final Builder otherBucket(@Nullable Boolean value) {
            this.otherBucket = value;
            return this;
        }

        /**
         * The key with which the other bucket is returned.
         * <p>
         * API name: {@code other_bucket_key}
         * </p>
         */
        @Nonnull
        public final Builder otherBucketKey(@Nullable String value) {
            this.otherBucketKey = value;
            return this;
        }

        /**
         * Builds a {@link FiltersAggregation}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public FiltersAggregation build() {
            _checkSingleUse();

            return new FiltersAggregation(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link FiltersAggregation}
     */
    public static final JsonpDeserializer<FiltersAggregation> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        FiltersAggregation::setupFiltersAggregationDeserializer
    );

    protected static void setupFiltersAggregationDeserializer(ObjectDeserializer<FiltersAggregation.Builder> op) {
        setupBucketAggregationBaseDeserializer(op);
        op.add(Builder::filters, Buckets.createBucketsDeserializer(Query._DESERIALIZER), "filters");
        op.add(Builder::keyed, JsonpDeserializer.booleanDeserializer(), "keyed");
        op.add(Builder::otherBucket, JsonpDeserializer.booleanDeserializer(), "other_bucket");
        op.add(Builder::otherBucketKey, JsonpDeserializer.stringDeserializer(), "other_bucket_key");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(this.filters);
        result = 31 * result + Objects.hashCode(this.keyed);
        result = 31 * result + Objects.hashCode(this.otherBucket);
        result = 31 * result + Objects.hashCode(this.otherBucketKey);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        FiltersAggregation other = (FiltersAggregation) o;
        return Objects.equals(this.filters, other.filters)
            && Objects.equals(this.keyed, other.keyed)
            && Objects.equals(this.otherBucket, other.otherBucket)
            && Objects.equals(this.otherBucketKey, other.otherBucketKey);
    }
}
