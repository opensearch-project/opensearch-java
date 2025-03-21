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

// typedef: _types.query_dsl.IntervalsWildcard

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class IntervalsWildcard
    implements
        IntervalsVariant,
        IntervalsQueryVariant,
        PlainJsonSerializable,
        ToCopyableBuilder<IntervalsWildcard.Builder, IntervalsWildcard> {

    @Nullable
    private final String analyzer;

    @Nonnull
    private final String pattern;

    @Nullable
    private final String useField;

    // ---------------------------------------------------------------------------------------------

    private IntervalsWildcard(Builder builder) {
        this.analyzer = builder.analyzer;
        this.pattern = ApiTypeHelper.requireNonNull(builder.pattern, this, "pattern");
        this.useField = builder.useField;
    }

    public static IntervalsWildcard of(Function<IntervalsWildcard.Builder, ObjectBuilder<IntervalsWildcard>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link Intervals} variant kind.
     */
    @Override
    public Intervals.Kind _intervalsKind() {
        return Intervals.Kind.Wildcard;
    }

    /**
     * {@link IntervalsQuery} variant kind.
     */
    @Override
    public IntervalsQuery.Kind _intervalsQueryKind() {
        return IntervalsQuery.Kind.Wildcard;
    }

    /**
     * Analyzer used to analyze the <code>pattern</code>. Defaults to the top-level field's analyzer.
     * <p>
     * API name: {@code analyzer}
     * </p>
     */
    @Nullable
    public final String analyzer() {
        return this.analyzer;
    }

    /**
     * Required - Wildcard pattern used to find matching terms.
     * <p>
     * API name: {@code pattern}
     * </p>
     */
    @Nonnull
    public final String pattern() {
        return this.pattern;
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

        generator.writeKey("pattern");
        generator.write(this.pattern);

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
     * Builder for {@link IntervalsWildcard}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, IntervalsWildcard> {
        @Nullable
        private String analyzer;
        private String pattern;
        @Nullable
        private String useField;

        public Builder() {}

        private Builder(IntervalsWildcard o) {
            this.analyzer = o.analyzer;
            this.pattern = o.pattern;
            this.useField = o.useField;
        }

        private Builder(Builder o) {
            this.analyzer = o.analyzer;
            this.pattern = o.pattern;
            this.useField = o.useField;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Analyzer used to analyze the <code>pattern</code>. Defaults to the top-level field's analyzer.
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
         * Required - Wildcard pattern used to find matching terms.
         * <p>
         * API name: {@code pattern}
         * </p>
         */
        @Nonnull
        public final Builder pattern(String value) {
            this.pattern = value;
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
         * Builds a {@link IntervalsWildcard}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public IntervalsWildcard build() {
            _checkSingleUse();

            return new IntervalsWildcard(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link IntervalsWildcard}
     */
    public static final JsonpDeserializer<IntervalsWildcard> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        IntervalsWildcard::setupIntervalsWildcardDeserializer
    );

    protected static void setupIntervalsWildcardDeserializer(ObjectDeserializer<IntervalsWildcard.Builder> op) {
        op.add(Builder::analyzer, JsonpDeserializer.stringDeserializer(), "analyzer");
        op.add(Builder::pattern, JsonpDeserializer.stringDeserializer(), "pattern");
        op.add(Builder::useField, JsonpDeserializer.stringDeserializer(), "use_field");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.analyzer);
        result = 31 * result + this.pattern.hashCode();
        result = 31 * result + Objects.hashCode(this.useField);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        IntervalsWildcard other = (IntervalsWildcard) o;
        return Objects.equals(this.analyzer, other.analyzer)
            && this.pattern.equals(other.pattern)
            && Objects.equals(this.useField, other.useField);
    }
}
