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
import org.opensearch.client.json.PlainJsonSerializable;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: _types.query_dsl.IntervalsMatch

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class IntervalsMatch
    implements
        IntervalsVariant,
        IntervalsQueryVariant,
        PlainJsonSerializable,
        ToCopyableBuilder<IntervalsMatch.Builder, IntervalsMatch> {

    @Nullable
    private final String analyzer;

    @Nullable
    private final IntervalsFilter filter;

    @Nullable
    private final Integer maxGaps;

    @Nullable
    private final Boolean ordered;

    @Nonnull
    private final String query;

    @Nullable
    private final String useField;

    // ---------------------------------------------------------------------------------------------

    private IntervalsMatch(Builder builder) {
        this.analyzer = builder.analyzer;
        this.filter = builder.filter;
        this.maxGaps = builder.maxGaps;
        this.ordered = builder.ordered;
        this.query = ApiTypeHelper.requireNonNull(builder.query, this, "query");
        this.useField = builder.useField;
    }

    public static IntervalsMatch of(Function<IntervalsMatch.Builder, ObjectBuilder<IntervalsMatch>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link Intervals} variant kind.
     */
    @Override
    public Intervals.Kind _intervalsKind() {
        return Intervals.Kind.Match;
    }

    /**
     * {@link IntervalsQuery} variant kind.
     */
    @Override
    public IntervalsQuery.Kind _intervalsQueryKind() {
        return IntervalsQuery.Kind.Match;
    }

    /**
     * Analyzer used to analyze terms in the query.
     * <p>
     * API name: {@code analyzer}
     * </p>
     */
    @Nullable
    public final String analyzer() {
        return this.analyzer;
    }

    /**
     * API name: {@code filter}
     */
    @Nullable
    public final IntervalsFilter filter() {
        return this.filter;
    }

    /**
     * Maximum number of positions between the matching terms. Terms further apart than this are not considered matches.
     * <p>
     * API name: {@code max_gaps}
     * </p>
     */
    @Nullable
    public final Integer maxGaps() {
        return this.maxGaps;
    }

    /**
     * If <code>true</code>, matching terms must appear in their specified order.
     * <p>
     * API name: {@code ordered}
     * </p>
     */
    @Nullable
    public final Boolean ordered() {
        return this.ordered;
    }

    /**
     * Required - Text you wish to find in the provided field.
     * <p>
     * API name: {@code query}
     * </p>
     */
    @Nonnull
    public final String query() {
        return this.query;
    }

    /**
     * API name: {@code use_field}
     */
    @Nullable
    public final String useField() {
        return this.useField;
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
        if (this.analyzer != null) {
            generator.writeKey("analyzer");
            generator.write(this.analyzer);
        }

        if (this.filter != null) {
            generator.writeKey("filter");
            this.filter.serialize(generator, mapper);
        }

        if (this.maxGaps != null) {
            generator.writeKey("max_gaps");
            generator.write(this.maxGaps);
        }

        if (this.ordered != null) {
            generator.writeKey("ordered");
            generator.write(this.ordered);
        }

        generator.writeKey("query");
        generator.write(this.query);

        if (this.useField != null) {
            generator.writeKey("use_field");
            generator.write(this.useField);
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
     * Builder for {@link IntervalsMatch}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, IntervalsMatch> {
        @Nullable
        private String analyzer;
        @Nullable
        private IntervalsFilter filter;
        @Nullable
        private Integer maxGaps;
        @Nullable
        private Boolean ordered;
        private String query;
        @Nullable
        private String useField;

        public Builder() {}

        private Builder(IntervalsMatch o) {
            this.analyzer = o.analyzer;
            this.filter = o.filter;
            this.maxGaps = o.maxGaps;
            this.ordered = o.ordered;
            this.query = o.query;
            this.useField = o.useField;
        }

        private Builder(Builder o) {
            this.analyzer = o.analyzer;
            this.filter = o.filter;
            this.maxGaps = o.maxGaps;
            this.ordered = o.ordered;
            this.query = o.query;
            this.useField = o.useField;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Analyzer used to analyze terms in the query.
         * <p>
         * API name: {@code analyzer}
         * </p>
         */
        @Nonnull
        public final Builder analyzer(@Nullable String value) {
            this.analyzer = value;
            return this;
        }

        /**
         * API name: {@code filter}
         */
        @Nonnull
        public final Builder filter(@Nullable IntervalsFilter value) {
            this.filter = value;
            return this;
        }

        /**
         * API name: {@code filter}
         */
        @Nonnull
        public final Builder filter(Function<IntervalsFilter.Builder, ObjectBuilder<IntervalsFilter>> fn) {
            return filter(fn.apply(new IntervalsFilter.Builder()).build());
        }

        /**
         * Maximum number of positions between the matching terms. Terms further apart than this are not considered matches.
         * <p>
         * API name: {@code max_gaps}
         * </p>
         */
        @Nonnull
        public final Builder maxGaps(@Nullable Integer value) {
            this.maxGaps = value;
            return this;
        }

        /**
         * If <code>true</code>, matching terms must appear in their specified order.
         * <p>
         * API name: {@code ordered}
         * </p>
         */
        @Nonnull
        public final Builder ordered(@Nullable Boolean value) {
            this.ordered = value;
            return this;
        }

        /**
         * Required - Text you wish to find in the provided field.
         * <p>
         * API name: {@code query}
         * </p>
         */
        @Nonnull
        public final Builder query(String value) {
            this.query = value;
            return this;
        }

        /**
         * API name: {@code use_field}
         */
        @Nonnull
        public final Builder useField(@Nullable String value) {
            this.useField = value;
            return this;
        }

        /**
         * Builds a {@link IntervalsMatch}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public IntervalsMatch build() {
            _checkSingleUse();

            return new IntervalsMatch(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link IntervalsMatch}
     */
    public static final JsonpDeserializer<IntervalsMatch> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        IntervalsMatch::setupIntervalsMatchDeserializer
    );

    protected static void setupIntervalsMatchDeserializer(ObjectDeserializer<IntervalsMatch.Builder> op) {
        op.add(Builder::analyzer, JsonpDeserializer.stringDeserializer(), "analyzer");
        op.add(Builder::filter, IntervalsFilter._DESERIALIZER, "filter");
        op.add(Builder::maxGaps, JsonpDeserializer.integerDeserializer(), "max_gaps");
        op.add(Builder::ordered, JsonpDeserializer.booleanDeserializer(), "ordered");
        op.add(Builder::query, JsonpDeserializer.stringDeserializer(), "query");
        op.add(Builder::useField, JsonpDeserializer.stringDeserializer(), "use_field");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.analyzer);
        result = 31 * result + Objects.hashCode(this.filter);
        result = 31 * result + Objects.hashCode(this.maxGaps);
        result = 31 * result + Objects.hashCode(this.ordered);
        result = 31 * result + this.query.hashCode();
        result = 31 * result + Objects.hashCode(this.useField);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        IntervalsMatch other = (IntervalsMatch) o;
        return Objects.equals(this.analyzer, other.analyzer)
            && Objects.equals(this.filter, other.filter)
            && Objects.equals(this.maxGaps, other.maxGaps)
            && Objects.equals(this.ordered, other.ordered)
            && this.query.equals(other.query)
            && Objects.equals(this.useField, other.useField);
    }
}
