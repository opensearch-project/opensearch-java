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

package org.opensearch.client.opensearch._types.query_dsl;

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
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: _types.query_dsl.CommonTermsQuery

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class CommonTermsQuery extends QueryBase implements QueryVariant, ToCopyableBuilder<CommonTermsQuery.Builder, CommonTermsQuery> {

    @Nullable
    private final String analyzer;

    @Nullable
    private final Float cutoffFrequency;

    @Nonnull
    private final String field;

    @Nullable
    private final Operator highFreqOperator;

    @Nullable
    private final Operator lowFreqOperator;

    @Nullable
    private final String minimumShouldMatch;

    @Nonnull
    private final String query;

    // ---------------------------------------------------------------------------------------------

    private CommonTermsQuery(Builder builder) {
        super(builder);
        this.analyzer = builder.analyzer;
        this.cutoffFrequency = builder.cutoffFrequency;
        this.field = ApiTypeHelper.requireNonNull(builder.field, this, "field");
        this.highFreqOperator = builder.highFreqOperator;
        this.lowFreqOperator = builder.lowFreqOperator;
        this.minimumShouldMatch = builder.minimumShouldMatch;
        this.query = ApiTypeHelper.requireNonNull(builder.query, this, "query");
    }

    public static CommonTermsQuery of(Function<CommonTermsQuery.Builder, ObjectBuilder<CommonTermsQuery>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link Query} variant kind.
     */
    @Override
    public Query.Kind _queryKind() {
        return Query.Kind.Common;
    }

    /**
     * API name: {@code analyzer}
     */
    @Nullable
    public final String analyzer() {
        return this.analyzer;
    }

    /**
     * API name: {@code cutoff_frequency}
     */
    @Nullable
    public final Float cutoffFrequency() {
        return this.cutoffFrequency;
    }

    /**
     * Required - The target field
     */
    @Nonnull
    public final String field() {
        return this.field;
    }

    /**
     * API name: {@code high_freq_operator}
     */
    @Nullable
    public final Operator highFreqOperator() {
        return this.highFreqOperator;
    }

    /**
     * API name: {@code low_freq_operator}
     */
    @Nullable
    public final Operator lowFreqOperator() {
        return this.lowFreqOperator;
    }

    /**
     * API name: {@code minimum_should_match}
     */
    @Nullable
    public final String minimumShouldMatch() {
        return this.minimumShouldMatch;
    }

    /**
     * Required - API name: {@code query}
     */
    @Nonnull
    public final String query() {
        return this.query;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        generator.writeStartObject(this.field);
        super.serializeInternal(generator, mapper);
        if (this.analyzer != null) {
            generator.writeKey("analyzer");
            generator.write(this.analyzer);
        }

        if (this.cutoffFrequency != null) {
            generator.writeKey("cutoff_frequency");
            generator.write(this.cutoffFrequency);
        }

        if (this.highFreqOperator != null) {
            generator.writeKey("high_freq_operator");
            this.highFreqOperator.serialize(generator, mapper);
        }

        if (this.lowFreqOperator != null) {
            generator.writeKey("low_freq_operator");
            this.lowFreqOperator.serialize(generator, mapper);
        }

        if (this.minimumShouldMatch != null) {
            generator.writeKey("minimum_should_match");
            generator.write(this.minimumShouldMatch);
        }

        generator.writeKey("query");
        generator.write(this.query);
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
     * Builder for {@link CommonTermsQuery}.
     */
    public static class Builder extends QueryBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, CommonTermsQuery> {
        @Nullable
        private String analyzer;
        @Nullable
        private Float cutoffFrequency;
        private String field;
        @Nullable
        private Operator highFreqOperator;
        @Nullable
        private Operator lowFreqOperator;
        @Nullable
        private String minimumShouldMatch;
        private String query;

        public Builder() {}

        private Builder(CommonTermsQuery o) {
            super(o);
            this.analyzer = o.analyzer;
            this.cutoffFrequency = o.cutoffFrequency;
            this.field = o.field;
            this.highFreqOperator = o.highFreqOperator;
            this.lowFreqOperator = o.lowFreqOperator;
            this.minimumShouldMatch = o.minimumShouldMatch;
            this.query = o.query;
        }

        private Builder(Builder o) {
            super(o);
            this.analyzer = o.analyzer;
            this.cutoffFrequency = o.cutoffFrequency;
            this.field = o.field;
            this.highFreqOperator = o.highFreqOperator;
            this.lowFreqOperator = o.lowFreqOperator;
            this.minimumShouldMatch = o.minimumShouldMatch;
            this.query = o.query;
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
         * API name: {@code analyzer}
         */
        @Nonnull
        public final Builder analyzer(@Nullable String value) {
            this.analyzer = value;
            return this;
        }

        /**
         * API name: {@code cutoff_frequency}
         */
        @Nonnull
        public final Builder cutoffFrequency(@Nullable Float value) {
            this.cutoffFrequency = value;
            return this;
        }

        /**
         * Required - The target field
         */
        @Nonnull
        public final Builder field(String value) {
            this.field = value;
            return this;
        }

        /**
         * API name: {@code high_freq_operator}
         */
        @Nonnull
        public final Builder highFreqOperator(@Nullable Operator value) {
            this.highFreqOperator = value;
            return this;
        }

        /**
         * API name: {@code low_freq_operator}
         */
        @Nonnull
        public final Builder lowFreqOperator(@Nullable Operator value) {
            this.lowFreqOperator = value;
            return this;
        }

        /**
         * API name: {@code minimum_should_match}
         */
        @Nonnull
        public final Builder minimumShouldMatch(@Nullable String value) {
            this.minimumShouldMatch = value;
            return this;
        }

        /**
         * Required - API name: {@code query}
         */
        @Nonnull
        public final Builder query(String value) {
            this.query = value;
            return this;
        }

        /**
         * Builds a {@link CommonTermsQuery}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public CommonTermsQuery build() {
            _checkSingleUse();

            return new CommonTermsQuery(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link CommonTermsQuery}
     */
    public static final JsonpDeserializer<CommonTermsQuery> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        CommonTermsQuery::setupCommonTermsQueryDeserializer
    );

    protected static void setupCommonTermsQueryDeserializer(ObjectDeserializer<CommonTermsQuery.Builder> op) {
        setupQueryBaseDeserializer(op);
        op.add(Builder::analyzer, JsonpDeserializer.stringDeserializer(), "analyzer");
        op.add(Builder::cutoffFrequency, JsonpDeserializer.floatDeserializer(), "cutoff_frequency");
        op.add(Builder::highFreqOperator, Operator._DESERIALIZER, "high_freq_operator");
        op.add(Builder::lowFreqOperator, Operator._DESERIALIZER, "low_freq_operator");
        op.add(Builder::minimumShouldMatch, JsonpDeserializer.stringDeserializer(), "minimum_should_match");
        op.add(Builder::query, JsonpDeserializer.stringDeserializer(), "query");
        op.setKey(Builder::field, JsonpDeserializer.stringDeserializer());

        op.shortcutProperty("query");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(this.analyzer);
        result = 31 * result + Objects.hashCode(this.cutoffFrequency);
        result = 31 * result + this.field.hashCode();
        result = 31 * result + Objects.hashCode(this.highFreqOperator);
        result = 31 * result + Objects.hashCode(this.lowFreqOperator);
        result = 31 * result + Objects.hashCode(this.minimumShouldMatch);
        result = 31 * result + this.query.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        CommonTermsQuery other = (CommonTermsQuery) o;
        return Objects.equals(this.analyzer, other.analyzer)
            && Objects.equals(this.cutoffFrequency, other.cutoffFrequency)
            && this.field.equals(other.field)
            && Objects.equals(this.highFreqOperator, other.highFreqOperator)
            && Objects.equals(this.lowFreqOperator, other.lowFreqOperator)
            && Objects.equals(this.minimumShouldMatch, other.minimumShouldMatch)
            && this.query.equals(other.query);
    }
}
