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

package org.opensearch.client.opensearch._types.analysis;

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
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: _types.analysis.NGramTokenFilter

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class NGramTokenFilter extends TokenFilterBase
    implements
        TokenFilterDefinitionVariant,
        ToCopyableBuilder<NGramTokenFilter.Builder, NGramTokenFilter> {

    @Nullable
    private final Integer maxGram;

    @Nullable
    private final Integer minGram;

    @Nullable
    private final Boolean preserveOriginal;

    // ---------------------------------------------------------------------------------------------

    private NGramTokenFilter(Builder builder) {
        super(builder);
        this.maxGram = builder.maxGram;
        this.minGram = builder.minGram;
        this.preserveOriginal = builder.preserveOriginal;
    }

    public static NGramTokenFilter of(Function<NGramTokenFilter.Builder, ObjectBuilder<NGramTokenFilter>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link TokenFilterDefinition} variant kind.
     */
    @Override
    public TokenFilterDefinition.Kind _tokenFilterDefinitionKind() {
        return TokenFilterDefinition.Kind.Ngram;
    }

    /**
     * API name: {@code max_gram}
     */
    @Nullable
    public final Integer maxGram() {
        return this.maxGram;
    }

    /**
     * API name: {@code min_gram}
     */
    @Nullable
    public final Integer minGram() {
        return this.minGram;
    }

    /**
     * API name: {@code preserve_original}
     */
    @Nullable
    public final Boolean preserveOriginal() {
        return this.preserveOriginal;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        generator.write("type", "ngram");
        super.serializeInternal(generator, mapper);
        if (this.maxGram != null) {
            generator.writeKey("max_gram");
            generator.write(this.maxGram);
        }

        if (this.minGram != null) {
            generator.writeKey("min_gram");
            generator.write(this.minGram);
        }

        if (this.preserveOriginal != null) {
            generator.writeKey("preserve_original");
            generator.write(this.preserveOriginal);
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
     * Builder for {@link NGramTokenFilter}.
     */
    public static class Builder extends TokenFilterBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, NGramTokenFilter> {
        @Nullable
        private Integer maxGram;
        @Nullable
        private Integer minGram;
        @Nullable
        private Boolean preserveOriginal;

        public Builder() {}

        private Builder(NGramTokenFilter o) {
            super(o);
            this.maxGram = o.maxGram;
            this.minGram = o.minGram;
            this.preserveOriginal = o.preserveOriginal;
        }

        private Builder(Builder o) {
            super(o);
            this.maxGram = o.maxGram;
            this.minGram = o.minGram;
            this.preserveOriginal = o.preserveOriginal;
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
         * API name: {@code max_gram}
         */
        @Nonnull
        public final Builder maxGram(@Nullable Integer value) {
            this.maxGram = value;
            return this;
        }

        /**
         * API name: {@code min_gram}
         */
        @Nonnull
        public final Builder minGram(@Nullable Integer value) {
            this.minGram = value;
            return this;
        }

        /**
         * API name: {@code preserve_original}
         */
        @Nonnull
        public final Builder preserveOriginal(@Nullable Boolean value) {
            this.preserveOriginal = value;
            return this;
        }

        /**
         * Builds a {@link NGramTokenFilter}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public NGramTokenFilter build() {
            _checkSingleUse();

            return new NGramTokenFilter(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link NGramTokenFilter}
     */
    public static final JsonpDeserializer<NGramTokenFilter> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        NGramTokenFilter::setupNGramTokenFilterDeserializer
    );

    protected static void setupNGramTokenFilterDeserializer(ObjectDeserializer<NGramTokenFilter.Builder> op) {
        setupTokenFilterBaseDeserializer(op);
        op.add(Builder::maxGram, JsonpDeserializer.integerDeserializer(), "max_gram");
        op.add(Builder::minGram, JsonpDeserializer.integerDeserializer(), "min_gram");
        op.add(Builder::preserveOriginal, JsonpDeserializer.booleanDeserializer(), "preserve_original");

        op.ignore("type");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(this.maxGram);
        result = 31 * result + Objects.hashCode(this.minGram);
        result = 31 * result + Objects.hashCode(this.preserveOriginal);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        NGramTokenFilter other = (NGramTokenFilter) o;
        return Objects.equals(this.maxGram, other.maxGram)
            && Objects.equals(this.minGram, other.minGram)
            && Objects.equals(this.preserveOriginal, other.preserveOriginal);
    }
}
