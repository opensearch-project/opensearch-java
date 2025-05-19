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

// typedef: _types.analysis.KuromojiReadingFormTokenFilter

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class KuromojiReadingFormTokenFilter extends TokenFilterBase
    implements
        TokenFilterDefinitionVariant,
        ToCopyableBuilder<KuromojiReadingFormTokenFilter.Builder, KuromojiReadingFormTokenFilter> {

    private final boolean useRomaji;

    // ---------------------------------------------------------------------------------------------

    private KuromojiReadingFormTokenFilter(Builder builder) {
        super(builder);
        this.useRomaji = ApiTypeHelper.requireNonNull(builder.useRomaji, this, "useRomaji");
    }

    public static KuromojiReadingFormTokenFilter of(
        Function<KuromojiReadingFormTokenFilter.Builder, ObjectBuilder<KuromojiReadingFormTokenFilter>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link TokenFilterDefinition} variant kind.
     */
    @Override
    public TokenFilterDefinition.Kind _tokenFilterDefinitionKind() {
        return TokenFilterDefinition.Kind.KuromojiReadingform;
    }

    /**
     * Required - API name: {@code use_romaji}
     */
    public final boolean useRomaji() {
        return this.useRomaji;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        generator.write("type", "kuromoji_readingform");
        super.serializeInternal(generator, mapper);
        generator.writeKey("use_romaji");
        generator.write(this.useRomaji);
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
     * Builder for {@link KuromojiReadingFormTokenFilter}.
     */
    public static class Builder extends TokenFilterBase.AbstractBuilder<Builder>
        implements
            CopyableBuilder<Builder, KuromojiReadingFormTokenFilter> {
        private Boolean useRomaji;

        public Builder() {}

        private Builder(KuromojiReadingFormTokenFilter o) {
            super(o);
            this.useRomaji = o.useRomaji;
        }

        private Builder(Builder o) {
            super(o);
            this.useRomaji = o.useRomaji;
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
         * Required - API name: {@code use_romaji}
         */
        @Nonnull
        public final Builder useRomaji(boolean value) {
            this.useRomaji = value;
            return this;
        }

        /**
         * Builds a {@link KuromojiReadingFormTokenFilter}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public KuromojiReadingFormTokenFilter build() {
            _checkSingleUse();

            return new KuromojiReadingFormTokenFilter(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link KuromojiReadingFormTokenFilter}
     */
    public static final JsonpDeserializer<KuromojiReadingFormTokenFilter> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        KuromojiReadingFormTokenFilter::setupKuromojiReadingFormTokenFilterDeserializer
    );

    protected static void setupKuromojiReadingFormTokenFilterDeserializer(ObjectDeserializer<KuromojiReadingFormTokenFilter.Builder> op) {
        setupTokenFilterBaseDeserializer(op);
        op.add(Builder::useRomaji, JsonpDeserializer.booleanDeserializer(), "use_romaji");

        op.ignore("type");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Boolean.hashCode(this.useRomaji);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        KuromojiReadingFormTokenFilter other = (KuromojiReadingFormTokenFilter) o;
        return this.useRomaji == other.useRomaji;
    }
}
