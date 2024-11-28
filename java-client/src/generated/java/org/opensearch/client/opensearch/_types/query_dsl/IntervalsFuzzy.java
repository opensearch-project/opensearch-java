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

// typedef: _types.query_dsl.IntervalsFuzzy

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class IntervalsFuzzy
    implements
        IntervalsVariant,
        IntervalsQueryVariant,
        PlainJsonSerializable,
        ToCopyableBuilder<IntervalsFuzzy.Builder, IntervalsFuzzy> {

    @Nullable
    private final String analyzer;

    @Nullable
    private final String fuzziness;

    @Nullable
    private final Integer prefixLength;

    @Nonnull
    private final String term;

    @Nullable
    private final Boolean transpositions;

    @Nullable
    private final String useField;

    // ---------------------------------------------------------------------------------------------

    private IntervalsFuzzy(Builder builder) {
        this.analyzer = builder.analyzer;
        this.fuzziness = builder.fuzziness;
        this.prefixLength = builder.prefixLength;
        this.term = ApiTypeHelper.requireNonNull(builder.term, this, "term");
        this.transpositions = builder.transpositions;
        this.useField = builder.useField;
    }

    public static IntervalsFuzzy of(Function<IntervalsFuzzy.Builder, ObjectBuilder<IntervalsFuzzy>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link Intervals} variant kind.
     */
    @Override
    public Intervals.Kind _intervalsKind() {
        return Intervals.Kind.Fuzzy;
    }

    /**
     * {@link IntervalsQuery} variant kind.
     */
    @Override
    public IntervalsQuery.Kind _intervalsQueryKind() {
        return IntervalsQuery.Kind.Fuzzy;
    }

    /**
     * Analyzer used to normalize the term.
     * <p>
     * API name: {@code analyzer}
     * </p>
     */
    @Nullable
    public final String analyzer() {
        return this.analyzer;
    }

    /**
     * API name: {@code fuzziness}
     */
    @Nullable
    public final String fuzziness() {
        return this.fuzziness;
    }

    /**
     * Number of beginning characters left unchanged when creating expansions.
     * <p>
     * API name: {@code prefix_length}
     * </p>
     */
    @Nullable
    public final Integer prefixLength() {
        return this.prefixLength;
    }

    /**
     * Required - The term to match.
     * <p>
     * API name: {@code term}
     * </p>
     */
    @Nonnull
    public final String term() {
        return this.term;
    }

    /**
     * Indicates whether edits include transpositions of two adjacent characters (for example, <code>ab</code> to <code>ba</code>).
     * <p>
     * API name: {@code transpositions}
     * </p>
     */
    @Nullable
    public final Boolean transpositions() {
        return this.transpositions;
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

        if (this.fuzziness != null) {
            generator.writeKey("fuzziness");
            generator.write(this.fuzziness);
        }

        if (this.prefixLength != null) {
            generator.writeKey("prefix_length");
            generator.write(this.prefixLength);
        }

        generator.writeKey("term");
        generator.write(this.term);

        if (this.transpositions != null) {
            generator.writeKey("transpositions");
            generator.write(this.transpositions);
        }

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
     * Builder for {@link IntervalsFuzzy}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, IntervalsFuzzy> {
        @Nullable
        private String analyzer;
        @Nullable
        private String fuzziness;
        @Nullable
        private Integer prefixLength;
        private String term;
        @Nullable
        private Boolean transpositions;
        @Nullable
        private String useField;

        public Builder() {}

        private Builder(IntervalsFuzzy o) {
            this.analyzer = o.analyzer;
            this.fuzziness = o.fuzziness;
            this.prefixLength = o.prefixLength;
            this.term = o.term;
            this.transpositions = o.transpositions;
            this.useField = o.useField;
        }

        private Builder(Builder o) {
            this.analyzer = o.analyzer;
            this.fuzziness = o.fuzziness;
            this.prefixLength = o.prefixLength;
            this.term = o.term;
            this.transpositions = o.transpositions;
            this.useField = o.useField;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Analyzer used to normalize the term.
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
         * API name: {@code fuzziness}
         */
        @Nonnull
        public final Builder fuzziness(@Nullable String value) {
            this.fuzziness = value;
            return this;
        }

        /**
         * Number of beginning characters left unchanged when creating expansions.
         * <p>
         * API name: {@code prefix_length}
         * </p>
         */
        @Nonnull
        public final Builder prefixLength(@Nullable Integer value) {
            this.prefixLength = value;
            return this;
        }

        /**
         * Required - The term to match.
         * <p>
         * API name: {@code term}
         * </p>
         */
        @Nonnull
        public final Builder term(String value) {
            this.term = value;
            return this;
        }

        /**
         * Indicates whether edits include transpositions of two adjacent characters (for example, <code>ab</code> to <code>ba</code>).
         * <p>
         * API name: {@code transpositions}
         * </p>
         */
        @Nonnull
        public final Builder transpositions(@Nullable Boolean value) {
            this.transpositions = value;
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
         * Builds a {@link IntervalsFuzzy}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public IntervalsFuzzy build() {
            _checkSingleUse();

            return new IntervalsFuzzy(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link IntervalsFuzzy}
     */
    public static final JsonpDeserializer<IntervalsFuzzy> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        IntervalsFuzzy::setupIntervalsFuzzyDeserializer
    );

    protected static void setupIntervalsFuzzyDeserializer(ObjectDeserializer<IntervalsFuzzy.Builder> op) {
        op.add(Builder::analyzer, JsonpDeserializer.stringDeserializer(), "analyzer");
        op.add(Builder::fuzziness, JsonpDeserializer.stringDeserializer(), "fuzziness");
        op.add(Builder::prefixLength, JsonpDeserializer.integerDeserializer(), "prefix_length");
        op.add(Builder::term, JsonpDeserializer.stringDeserializer(), "term");
        op.add(Builder::transpositions, JsonpDeserializer.booleanDeserializer(), "transpositions");
        op.add(Builder::useField, JsonpDeserializer.stringDeserializer(), "use_field");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.analyzer);
        result = 31 * result + Objects.hashCode(this.fuzziness);
        result = 31 * result + Objects.hashCode(this.prefixLength);
        result = 31 * result + this.term.hashCode();
        result = 31 * result + Objects.hashCode(this.transpositions);
        result = 31 * result + Objects.hashCode(this.useField);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        IntervalsFuzzy other = (IntervalsFuzzy) o;
        return Objects.equals(this.analyzer, other.analyzer)
            && Objects.equals(this.fuzziness, other.fuzziness)
            && Objects.equals(this.prefixLength, other.prefixLength)
            && this.term.equals(other.term)
            && Objects.equals(this.transpositions, other.transpositions)
            && Objects.equals(this.useField, other.useField);
    }
}
