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
import javax.annotation.Nullable;
import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.util.ObjectBuilder;

// typedef: _types.analysis.EdgeNGramTokenFilter

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class EdgeNGramTokenFilter extends TokenFilterBase implements TokenFilterDefinitionVariant {

    @Nullable
    private final Integer maxGram;

    @Nullable
    private final Integer minGram;

    @Nullable
    private final Boolean preserveOriginal;

    @Nullable
    private final EdgeNGramSide side;

    // ---------------------------------------------------------------------------------------------

    private EdgeNGramTokenFilter(Builder builder) {
        super(builder);
        this.maxGram = builder.maxGram;
        this.minGram = builder.minGram;
        this.preserveOriginal = builder.preserveOriginal;
        this.side = builder.side;
    }

    public static EdgeNGramTokenFilter of(Function<EdgeNGramTokenFilter.Builder, ObjectBuilder<EdgeNGramTokenFilter>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link TokenFilterDefinition} variant kind.
     */
    @Override
    public TokenFilterDefinition.Kind _tokenFilterDefinitionKind() {
        return TokenFilterDefinition.Kind.EdgeNgram;
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

    /**
     * API name: {@code side}
     */
    @Nullable
    public final EdgeNGramSide side() {
        return this.side;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        generator.write("type", "edge_ngram");
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

        if (this.side != null) {
            generator.writeKey("side");
            this.side.serialize(generator, mapper);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Builder for {@link EdgeNGramTokenFilter}.
     */
    public static class Builder extends TokenFilterBase.AbstractBuilder<Builder> implements ObjectBuilder<EdgeNGramTokenFilter> {
        @Nullable
        private Integer maxGram;
        @Nullable
        private Integer minGram;
        @Nullable
        private Boolean preserveOriginal;
        @Nullable
        private EdgeNGramSide side;

        /**
         * API name: {@code max_gram}
         */
        public final Builder maxGram(@Nullable Integer value) {
            this.maxGram = value;
            return this;
        }

        /**
         * API name: {@code min_gram}
         */
        public final Builder minGram(@Nullable Integer value) {
            this.minGram = value;
            return this;
        }

        /**
         * API name: {@code preserve_original}
         */
        public final Builder preserveOriginal(@Nullable Boolean value) {
            this.preserveOriginal = value;
            return this;
        }

        /**
         * API name: {@code side}
         */
        public final Builder side(@Nullable EdgeNGramSide value) {
            this.side = value;
            return this;
        }

        @Override
        protected Builder self() {
            return this;
        }

        /**
         * Builds a {@link EdgeNGramTokenFilter}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        public EdgeNGramTokenFilter build() {
            _checkSingleUse();

            return new EdgeNGramTokenFilter(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link EdgeNGramTokenFilter}
     */
    public static final JsonpDeserializer<EdgeNGramTokenFilter> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        EdgeNGramTokenFilter::setupEdgeNGramTokenFilterDeserializer
    );

    protected static void setupEdgeNGramTokenFilterDeserializer(ObjectDeserializer<EdgeNGramTokenFilter.Builder> op) {
        setupTokenFilterBaseDeserializer(op);
        op.add(Builder::maxGram, JsonpDeserializer.integerDeserializer(), "max_gram");
        op.add(Builder::minGram, JsonpDeserializer.integerDeserializer(), "min_gram");
        op.add(Builder::preserveOriginal, JsonpDeserializer.booleanDeserializer(), "preserve_original");
        op.add(Builder::side, EdgeNGramSide._DESERIALIZER, "side");

        op.ignore("type");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(this.maxGram);
        result = 31 * result + Objects.hashCode(this.minGram);
        result = 31 * result + Objects.hashCode(this.preserveOriginal);
        result = 31 * result + Objects.hashCode(this.side);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        EdgeNGramTokenFilter other = (EdgeNGramTokenFilter) o;
        return Objects.equals(this.maxGram, other.maxGram)
            && Objects.equals(this.minGram, other.minGram)
            && Objects.equals(this.preserveOriginal, other.preserveOriginal)
            && Objects.equals(this.side, other.side);
    }
}
