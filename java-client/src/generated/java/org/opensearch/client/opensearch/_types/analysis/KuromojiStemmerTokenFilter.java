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
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: _types.analysis.KuromojiStemmerTokenFilter

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class KuromojiStemmerTokenFilter extends TokenFilterBase
    implements
        TokenFilterDefinitionVariant,
        ToCopyableBuilder<KuromojiStemmerTokenFilter.Builder, KuromojiStemmerTokenFilter> {

    private final int minimumLength;

    // ---------------------------------------------------------------------------------------------

    private KuromojiStemmerTokenFilter(Builder builder) {
        super(builder);
        this.minimumLength = ApiTypeHelper.requireNonNull(builder.minimumLength, this, "minimumLength");
    }

    public static KuromojiStemmerTokenFilter of(
        Function<KuromojiStemmerTokenFilter.Builder, ObjectBuilder<KuromojiStemmerTokenFilter>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link TokenFilterDefinition} variant kind.
     */
    @Override
    public TokenFilterDefinition.Kind _tokenFilterDefinitionKind() {
        return TokenFilterDefinition.Kind.KuromojiStemmer;
    }

    /**
     * Required - API name: {@code minimum_length}
     */
    public final int minimumLength() {
        return this.minimumLength;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        generator.write("type", "kuromoji_stemmer");
        super.serializeInternal(generator, mapper);
        generator.writeKey("minimum_length");
        generator.write(this.minimumLength);
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
     * Builder for {@link KuromojiStemmerTokenFilter}.
     */
    public static class Builder extends TokenFilterBase.AbstractBuilder<Builder>
        implements
            CopyableBuilder<Builder, KuromojiStemmerTokenFilter> {
        private Integer minimumLength;

        public Builder() {}

        private Builder(KuromojiStemmerTokenFilter o) {
            super(o);
            this.minimumLength = o.minimumLength;
        }

        private Builder(Builder o) {
            super(o);
            this.minimumLength = o.minimumLength;
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
         * Required - API name: {@code minimum_length}
         */
        @Nonnull
        public final Builder minimumLength(int value) {
            this.minimumLength = value;
            return this;
        }

        /**
         * Builds a {@link KuromojiStemmerTokenFilter}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public KuromojiStemmerTokenFilter build() {
            _checkSingleUse();

            return new KuromojiStemmerTokenFilter(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link KuromojiStemmerTokenFilter}
     */
    public static final JsonpDeserializer<KuromojiStemmerTokenFilter> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        KuromojiStemmerTokenFilter::setupKuromojiStemmerTokenFilterDeserializer
    );

    protected static void setupKuromojiStemmerTokenFilterDeserializer(ObjectDeserializer<KuromojiStemmerTokenFilter.Builder> op) {
        setupTokenFilterBaseDeserializer(op);
        op.add(Builder::minimumLength, JsonpDeserializer.integerDeserializer(), "minimum_length");

        op.ignore("type");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Integer.hashCode(this.minimumLength);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        KuromojiStemmerTokenFilter other = (KuromojiStemmerTokenFilter) o;
        return this.minimumLength == other.minimumLength;
    }
}
