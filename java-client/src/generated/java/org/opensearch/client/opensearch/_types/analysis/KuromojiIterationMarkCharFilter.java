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

// typedef: _types.analysis.KuromojiIterationMarkCharFilter

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class KuromojiIterationMarkCharFilter extends CharFilterBase
    implements
        CharFilterDefinitionVariant,
        ToCopyableBuilder<KuromojiIterationMarkCharFilter.Builder, KuromojiIterationMarkCharFilter> {

    private final boolean normalizeKana;

    private final boolean normalizeKanji;

    // ---------------------------------------------------------------------------------------------

    private KuromojiIterationMarkCharFilter(Builder builder) {
        super(builder);
        this.normalizeKana = ApiTypeHelper.requireNonNull(builder.normalizeKana, this, "normalizeKana");
        this.normalizeKanji = ApiTypeHelper.requireNonNull(builder.normalizeKanji, this, "normalizeKanji");
    }

    public static KuromojiIterationMarkCharFilter of(
        Function<KuromojiIterationMarkCharFilter.Builder, ObjectBuilder<KuromojiIterationMarkCharFilter>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link CharFilterDefinition} variant kind.
     */
    @Override
    public CharFilterDefinition.Kind _charFilterDefinitionKind() {
        return CharFilterDefinition.Kind.KuromojiIterationMark;
    }

    /**
     * Required - API name: {@code normalize_kana}
     */
    public final boolean normalizeKana() {
        return this.normalizeKana;
    }

    /**
     * Required - API name: {@code normalize_kanji}
     */
    public final boolean normalizeKanji() {
        return this.normalizeKanji;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        generator.write("type", "kuromoji_iteration_mark");
        super.serializeInternal(generator, mapper);
        generator.writeKey("normalize_kana");
        generator.write(this.normalizeKana);

        generator.writeKey("normalize_kanji");
        generator.write(this.normalizeKanji);
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
     * Builder for {@link KuromojiIterationMarkCharFilter}.
     */
    public static class Builder extends CharFilterBase.AbstractBuilder<Builder>
        implements
            CopyableBuilder<Builder, KuromojiIterationMarkCharFilter> {
        private Boolean normalizeKana;
        private Boolean normalizeKanji;

        public Builder() {}

        private Builder(KuromojiIterationMarkCharFilter o) {
            super(o);
            this.normalizeKana = o.normalizeKana;
            this.normalizeKanji = o.normalizeKanji;
        }

        private Builder(Builder o) {
            super(o);
            this.normalizeKana = o.normalizeKana;
            this.normalizeKanji = o.normalizeKanji;
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
         * Required - API name: {@code normalize_kana}
         */
        @Nonnull
        public final Builder normalizeKana(boolean value) {
            this.normalizeKana = value;
            return this;
        }

        /**
         * Required - API name: {@code normalize_kanji}
         */
        @Nonnull
        public final Builder normalizeKanji(boolean value) {
            this.normalizeKanji = value;
            return this;
        }

        /**
         * Builds a {@link KuromojiIterationMarkCharFilter}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public KuromojiIterationMarkCharFilter build() {
            _checkSingleUse();

            return new KuromojiIterationMarkCharFilter(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link KuromojiIterationMarkCharFilter}
     */
    public static final JsonpDeserializer<KuromojiIterationMarkCharFilter> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        KuromojiIterationMarkCharFilter::setupKuromojiIterationMarkCharFilterDeserializer
    );

    protected static void setupKuromojiIterationMarkCharFilterDeserializer(ObjectDeserializer<KuromojiIterationMarkCharFilter.Builder> op) {
        setupCharFilterBaseDeserializer(op);
        op.add(Builder::normalizeKana, JsonpDeserializer.booleanDeserializer(), "normalize_kana");
        op.add(Builder::normalizeKanji, JsonpDeserializer.booleanDeserializer(), "normalize_kanji");

        op.ignore("type");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Boolean.hashCode(this.normalizeKana);
        result = 31 * result + Boolean.hashCode(this.normalizeKanji);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        KuromojiIterationMarkCharFilter other = (KuromojiIterationMarkCharFilter) o;
        return this.normalizeKana == other.normalizeKana && this.normalizeKanji == other.normalizeKanji;
    }
}
