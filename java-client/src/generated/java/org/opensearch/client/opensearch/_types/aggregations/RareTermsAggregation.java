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
import org.opensearch.client.opensearch._types.FieldValue;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: _types.aggregations.RareTermsAggregation

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class RareTermsAggregation extends BucketAggregationBase
    implements
        AggregationVariant,
        ToCopyableBuilder<RareTermsAggregation.Builder, RareTermsAggregation> {

    @Nullable
    private final TermsExclude exclude;

    @Nullable
    private final String field;

    @Nullable
    private final TermsInclude include;

    @Nullable
    private final Long maxDocCount;

    @Nullable
    private final FieldValue missing;

    @Nullable
    private final Double precision;

    @Nullable
    private final String valueType;

    // ---------------------------------------------------------------------------------------------

    private RareTermsAggregation(Builder builder) {
        super(builder);
        this.exclude = builder.exclude;
        this.field = builder.field;
        this.include = builder.include;
        this.maxDocCount = builder.maxDocCount;
        this.missing = builder.missing;
        this.precision = builder.precision;
        this.valueType = builder.valueType;
    }

    public static RareTermsAggregation of(Function<RareTermsAggregation.Builder, ObjectBuilder<RareTermsAggregation>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link Aggregation} variant kind.
     */
    @Override
    public Aggregation.Kind _aggregationKind() {
        return Aggregation.Kind.RareTerms;
    }

    /**
     * API name: {@code exclude}
     */
    @Nullable
    public final TermsExclude exclude() {
        return this.exclude;
    }

    /**
     * API name: {@code field}
     */
    @Nullable
    public final String field() {
        return this.field;
    }

    /**
     * API name: {@code include}
     */
    @Nullable
    public final TermsInclude include() {
        return this.include;
    }

    /**
     * The maximum number of documents a term should appear in.
     * <p>
     * API name: {@code max_doc_count}
     * </p>
     */
    @Nullable
    public final Long maxDocCount() {
        return this.maxDocCount;
    }

    /**
     * API name: {@code missing}
     */
    @Nullable
    public final FieldValue missing() {
        return this.missing;
    }

    /**
     * The precision of the internal CuckooFilters. Smaller precision leads to better approximation, but higher memory usage.
     * <p>
     * API name: {@code precision}
     * </p>
     */
    @Nullable
    public final Double precision() {
        return this.precision;
    }

    /**
     * API name: {@code value_type}
     */
    @Nullable
    public final String valueType() {
        return this.valueType;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        super.serializeInternal(generator, mapper);
        if (this.exclude != null) {
            generator.writeKey("exclude");
            this.exclude.serialize(generator, mapper);
        }

        if (this.field != null) {
            generator.writeKey("field");
            generator.write(this.field);
        }

        if (this.include != null) {
            generator.writeKey("include");
            this.include.serialize(generator, mapper);
        }

        if (this.maxDocCount != null) {
            generator.writeKey("max_doc_count");
            generator.write(this.maxDocCount);
        }

        if (this.missing != null) {
            generator.writeKey("missing");
            this.missing.serialize(generator, mapper);
        }

        if (this.precision != null) {
            generator.writeKey("precision");
            generator.write(this.precision);
        }

        if (this.valueType != null) {
            generator.writeKey("value_type");
            generator.write(this.valueType);
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
     * Builder for {@link RareTermsAggregation}.
     */
    public static class Builder extends BucketAggregationBase.AbstractBuilder<Builder>
        implements
            CopyableBuilder<Builder, RareTermsAggregation> {
        @Nullable
        private TermsExclude exclude;
        @Nullable
        private String field;
        @Nullable
        private TermsInclude include;
        @Nullable
        private Long maxDocCount;
        @Nullable
        private FieldValue missing;
        @Nullable
        private Double precision;
        @Nullable
        private String valueType;

        public Builder() {}

        private Builder(RareTermsAggregation o) {
            super(o);
            this.exclude = o.exclude;
            this.field = o.field;
            this.include = o.include;
            this.maxDocCount = o.maxDocCount;
            this.missing = o.missing;
            this.precision = o.precision;
            this.valueType = o.valueType;
        }

        private Builder(Builder o) {
            super(o);
            this.exclude = o.exclude;
            this.field = o.field;
            this.include = o.include;
            this.maxDocCount = o.maxDocCount;
            this.missing = o.missing;
            this.precision = o.precision;
            this.valueType = o.valueType;
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
         * API name: {@code exclude}
         */
        @Nonnull
        public final Builder exclude(@Nullable TermsExclude value) {
            this.exclude = value;
            return this;
        }

        /**
         * API name: {@code exclude}
         */
        @Nonnull
        public final Builder exclude(Function<TermsExclude.Builder, ObjectBuilder<TermsExclude>> fn) {
            return exclude(fn.apply(new TermsExclude.Builder()).build());
        }

        /**
         * API name: {@code field}
         */
        @Nonnull
        public final Builder field(@Nullable String value) {
            this.field = value;
            return this;
        }

        /**
         * API name: {@code include}
         */
        @Nonnull
        public final Builder include(@Nullable TermsInclude value) {
            this.include = value;
            return this;
        }

        /**
         * API name: {@code include}
         */
        @Nonnull
        public final Builder include(Function<TermsInclude.Builder, ObjectBuilder<TermsInclude>> fn) {
            return include(fn.apply(new TermsInclude.Builder()).build());
        }

        /**
         * The maximum number of documents a term should appear in.
         * <p>
         * API name: {@code max_doc_count}
         * </p>
         */
        @Nonnull
        public final Builder maxDocCount(@Nullable Long value) {
            this.maxDocCount = value;
            return this;
        }

        /**
         * API name: {@code missing}
         */
        @Nonnull
        public final Builder missing(@Nullable FieldValue value) {
            this.missing = value;
            return this;
        }

        /**
         * API name: {@code missing}
         */
        @Nonnull
        public final Builder missing(Function<FieldValue.Builder, ObjectBuilder<FieldValue>> fn) {
            return missing(fn.apply(new FieldValue.Builder()).build());
        }

        /**
         * The precision of the internal CuckooFilters. Smaller precision leads to better approximation, but higher memory usage.
         * <p>
         * API name: {@code precision}
         * </p>
         */
        @Nonnull
        public final Builder precision(@Nullable Double value) {
            this.precision = value;
            return this;
        }

        /**
         * API name: {@code value_type}
         */
        @Nonnull
        public final Builder valueType(@Nullable String value) {
            this.valueType = value;
            return this;
        }

        /**
         * Builds a {@link RareTermsAggregation}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public RareTermsAggregation build() {
            _checkSingleUse();

            return new RareTermsAggregation(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link RareTermsAggregation}
     */
    public static final JsonpDeserializer<RareTermsAggregation> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        RareTermsAggregation::setupRareTermsAggregationDeserializer
    );

    protected static void setupRareTermsAggregationDeserializer(ObjectDeserializer<RareTermsAggregation.Builder> op) {
        setupBucketAggregationBaseDeserializer(op);
        op.add(Builder::exclude, TermsExclude._DESERIALIZER, "exclude");
        op.add(Builder::field, JsonpDeserializer.stringDeserializer(), "field");
        op.add(Builder::include, TermsInclude._DESERIALIZER, "include");
        op.add(Builder::maxDocCount, JsonpDeserializer.longDeserializer(), "max_doc_count");
        op.add(Builder::missing, FieldValue._DESERIALIZER, "missing");
        op.add(Builder::precision, JsonpDeserializer.doubleDeserializer(), "precision");
        op.add(Builder::valueType, JsonpDeserializer.stringDeserializer(), "value_type");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(this.exclude);
        result = 31 * result + Objects.hashCode(this.field);
        result = 31 * result + Objects.hashCode(this.include);
        result = 31 * result + Objects.hashCode(this.maxDocCount);
        result = 31 * result + Objects.hashCode(this.missing);
        result = 31 * result + Objects.hashCode(this.precision);
        result = 31 * result + Objects.hashCode(this.valueType);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        RareTermsAggregation other = (RareTermsAggregation) o;
        return Objects.equals(this.exclude, other.exclude)
            && Objects.equals(this.field, other.field)
            && Objects.equals(this.include, other.include)
            && Objects.equals(this.maxDocCount, other.maxDocCount)
            && Objects.equals(this.missing, other.missing)
            && Objects.equals(this.precision, other.precision)
            && Objects.equals(this.valueType, other.valueType);
    }
}
