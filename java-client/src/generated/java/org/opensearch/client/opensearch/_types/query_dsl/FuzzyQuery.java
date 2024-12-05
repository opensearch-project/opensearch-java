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
import org.opensearch.client.opensearch._types.FieldValue;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: _types.query_dsl.FuzzyQuery

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class FuzzyQuery extends QueryBase implements QueryVariant, ToCopyableBuilder<FuzzyQuery.Builder, FuzzyQuery> {

    @Nonnull
    private final String field;

    @Nullable
    private final String fuzziness;

    @Nullable
    private final Integer maxExpansions;

    @Nullable
    private final Integer prefixLength;

    @Nullable
    private final String rewrite;

    @Nullable
    private final Boolean transpositions;

    @Nonnull
    private final FieldValue value;

    // ---------------------------------------------------------------------------------------------

    private FuzzyQuery(Builder builder) {
        super(builder);
        this.field = ApiTypeHelper.requireNonNull(builder.field, this, "field");
        this.fuzziness = builder.fuzziness;
        this.maxExpansions = builder.maxExpansions;
        this.prefixLength = builder.prefixLength;
        this.rewrite = builder.rewrite;
        this.transpositions = builder.transpositions;
        this.value = ApiTypeHelper.requireNonNull(builder.value, this, "value");
    }

    public static FuzzyQuery of(Function<FuzzyQuery.Builder, ObjectBuilder<FuzzyQuery>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link Query} variant kind.
     */
    @Override
    public Query.Kind _queryKind() {
        return Query.Kind.Fuzzy;
    }

    /**
     * Required - The target field
     */
    @Nonnull
    public final String field() {
        return this.field;
    }

    /**
     * API name: {@code fuzziness}
     */
    @Nullable
    public final String fuzziness() {
        return this.fuzziness;
    }

    /**
     * Maximum number of variations created.
     * <p>
     * API name: {@code max_expansions}
     * </p>
     */
    @Nullable
    public final Integer maxExpansions() {
        return this.maxExpansions;
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
     * API name: {@code rewrite}
     */
    @Nullable
    public final String rewrite() {
        return this.rewrite;
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
     * Required - Term you wish to find in the provided field.
     * <p>
     * API name: {@code value}
     * </p>
     */
    @Nonnull
    public final FieldValue value() {
        return this.value;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        generator.writeStartObject(this.field);
        super.serializeInternal(generator, mapper);
        if (this.fuzziness != null) {
            generator.writeKey("fuzziness");
            generator.write(this.fuzziness);
        }

        if (this.maxExpansions != null) {
            generator.writeKey("max_expansions");
            generator.write(this.maxExpansions);
        }

        if (this.prefixLength != null) {
            generator.writeKey("prefix_length");
            generator.write(this.prefixLength);
        }

        if (this.rewrite != null) {
            generator.writeKey("rewrite");
            generator.write(this.rewrite);
        }

        if (this.transpositions != null) {
            generator.writeKey("transpositions");
            generator.write(this.transpositions);
        }

        generator.writeKey("value");
        this.value.serialize(generator, mapper);
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
     * Builder for {@link FuzzyQuery}.
     */
    public static class Builder extends QueryBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, FuzzyQuery> {
        private String field;
        @Nullable
        private String fuzziness;
        @Nullable
        private Integer maxExpansions;
        @Nullable
        private Integer prefixLength;
        @Nullable
        private String rewrite;
        @Nullable
        private Boolean transpositions;
        private FieldValue value;

        public Builder() {}

        private Builder(FuzzyQuery o) {
            super(o);
            this.field = o.field;
            this.fuzziness = o.fuzziness;
            this.maxExpansions = o.maxExpansions;
            this.prefixLength = o.prefixLength;
            this.rewrite = o.rewrite;
            this.transpositions = o.transpositions;
            this.value = o.value;
        }

        private Builder(Builder o) {
            super(o);
            this.field = o.field;
            this.fuzziness = o.fuzziness;
            this.maxExpansions = o.maxExpansions;
            this.prefixLength = o.prefixLength;
            this.rewrite = o.rewrite;
            this.transpositions = o.transpositions;
            this.value = o.value;
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
         * Required - The target field
         */
        @Nonnull
        public final Builder field(String value) {
            this.field = value;
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
         * Maximum number of variations created.
         * <p>
         * API name: {@code max_expansions}
         * </p>
         */
        @Nonnull
        public final Builder maxExpansions(@Nullable Integer value) {
            this.maxExpansions = value;
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
         * API name: {@code rewrite}
         */
        @Nonnull
        public final Builder rewrite(@Nullable String value) {
            this.rewrite = value;
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
         * Required - Term you wish to find in the provided field.
         * <p>
         * API name: {@code value}
         * </p>
         */
        @Nonnull
        public final Builder value(FieldValue value) {
            this.value = value;
            return this;
        }

        /**
         * Required - Term you wish to find in the provided field.
         * <p>
         * API name: {@code value}
         * </p>
         */
        @Nonnull
        public final Builder value(Function<FieldValue.Builder, ObjectBuilder<FieldValue>> fn) {
            return value(fn.apply(new FieldValue.Builder()).build());
        }

        /**
         * Builds a {@link FuzzyQuery}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public FuzzyQuery build() {
            _checkSingleUse();

            return new FuzzyQuery(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link FuzzyQuery}
     */
    public static final JsonpDeserializer<FuzzyQuery> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        FuzzyQuery::setupFuzzyQueryDeserializer
    );

    protected static void setupFuzzyQueryDeserializer(ObjectDeserializer<FuzzyQuery.Builder> op) {
        setupQueryBaseDeserializer(op);
        op.add(Builder::fuzziness, JsonpDeserializer.stringDeserializer(), "fuzziness");
        op.add(Builder::maxExpansions, JsonpDeserializer.integerDeserializer(), "max_expansions");
        op.add(Builder::prefixLength, JsonpDeserializer.integerDeserializer(), "prefix_length");
        op.add(Builder::rewrite, JsonpDeserializer.stringDeserializer(), "rewrite");
        op.add(Builder::transpositions, JsonpDeserializer.booleanDeserializer(), "transpositions");
        op.add(Builder::value, FieldValue._DESERIALIZER, "value");
        op.setKey(Builder::field, JsonpDeserializer.stringDeserializer());

        op.shortcutProperty("value");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + this.field.hashCode();
        result = 31 * result + Objects.hashCode(this.fuzziness);
        result = 31 * result + Objects.hashCode(this.maxExpansions);
        result = 31 * result + Objects.hashCode(this.prefixLength);
        result = 31 * result + Objects.hashCode(this.rewrite);
        result = 31 * result + Objects.hashCode(this.transpositions);
        result = 31 * result + this.value.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        FuzzyQuery other = (FuzzyQuery) o;
        return this.field.equals(other.field)
            && Objects.equals(this.fuzziness, other.fuzziness)
            && Objects.equals(this.maxExpansions, other.maxExpansions)
            && Objects.equals(this.prefixLength, other.prefixLength)
            && Objects.equals(this.rewrite, other.rewrite)
            && Objects.equals(this.transpositions, other.transpositions)
            && this.value.equals(other.value);
    }
}
