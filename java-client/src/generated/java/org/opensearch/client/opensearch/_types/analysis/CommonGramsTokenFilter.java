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
import java.util.List;
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

// typedef: _types.analysis.CommonGramsTokenFilter

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class CommonGramsTokenFilter extends TokenFilterBase
    implements
        TokenFilterDefinitionVariant,
        ToCopyableBuilder<CommonGramsTokenFilter.Builder, CommonGramsTokenFilter> {

    @Nonnull
    private final List<String> commonWords;

    @Nullable
    private final String commonWordsPath;

    @Nullable
    private final Boolean ignoreCase;

    @Nullable
    private final Boolean queryMode;

    // ---------------------------------------------------------------------------------------------

    private CommonGramsTokenFilter(Builder builder) {
        super(builder);
        this.commonWords = ApiTypeHelper.unmodifiable(builder.commonWords);
        this.commonWordsPath = builder.commonWordsPath;
        this.ignoreCase = builder.ignoreCase;
        this.queryMode = builder.queryMode;
    }

    public static CommonGramsTokenFilter of(Function<CommonGramsTokenFilter.Builder, ObjectBuilder<CommonGramsTokenFilter>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link TokenFilterDefinition} variant kind.
     */
    @Override
    public TokenFilterDefinition.Kind _tokenFilterDefinitionKind() {
        return TokenFilterDefinition.Kind.CommonGrams;
    }

    /**
     * API name: {@code common_words}
     */
    @Nonnull
    public final List<String> commonWords() {
        return this.commonWords;
    }

    /**
     * API name: {@code common_words_path}
     */
    @Nullable
    public final String commonWordsPath() {
        return this.commonWordsPath;
    }

    /**
     * API name: {@code ignore_case}
     */
    @Nullable
    public final Boolean ignoreCase() {
        return this.ignoreCase;
    }

    /**
     * API name: {@code query_mode}
     */
    @Nullable
    public final Boolean queryMode() {
        return this.queryMode;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        generator.write("type", "common_grams");
        super.serializeInternal(generator, mapper);
        if (ApiTypeHelper.isDefined(this.commonWords)) {
            generator.writeKey("common_words");
            generator.writeStartArray();
            for (String item0 : this.commonWords) {
                generator.write(item0);
            }
            generator.writeEnd();
        }

        if (this.commonWordsPath != null) {
            generator.writeKey("common_words_path");
            generator.write(this.commonWordsPath);
        }

        if (this.ignoreCase != null) {
            generator.writeKey("ignore_case");
            generator.write(this.ignoreCase);
        }

        if (this.queryMode != null) {
            generator.writeKey("query_mode");
            generator.write(this.queryMode);
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
     * Builder for {@link CommonGramsTokenFilter}.
     */
    public static class Builder extends TokenFilterBase.AbstractBuilder<Builder>
        implements
            CopyableBuilder<Builder, CommonGramsTokenFilter> {
        @Nullable
        private List<String> commonWords;
        @Nullable
        private String commonWordsPath;
        @Nullable
        private Boolean ignoreCase;
        @Nullable
        private Boolean queryMode;

        public Builder() {}

        private Builder(CommonGramsTokenFilter o) {
            super(o);
            this.commonWords = _listCopy(o.commonWords);
            this.commonWordsPath = o.commonWordsPath;
            this.ignoreCase = o.ignoreCase;
            this.queryMode = o.queryMode;
        }

        private Builder(Builder o) {
            super(o);
            this.commonWords = _listCopy(o.commonWords);
            this.commonWordsPath = o.commonWordsPath;
            this.ignoreCase = o.ignoreCase;
            this.queryMode = o.queryMode;
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
         * API name: {@code common_words}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>commonWords</code>.
         * </p>
         */
        @Nonnull
        public final Builder commonWords(List<String> list) {
            this.commonWords = _listAddAll(this.commonWords, list);
            return this;
        }

        /**
         * API name: {@code common_words}
         *
         * <p>
         * Adds one or more values to <code>commonWords</code>.
         * </p>
         */
        @Nonnull
        public final Builder commonWords(String value, String... values) {
            this.commonWords = _listAdd(this.commonWords, value, values);
            return this;
        }

        /**
         * API name: {@code common_words_path}
         */
        @Nonnull
        public final Builder commonWordsPath(@Nullable String value) {
            this.commonWordsPath = value;
            return this;
        }

        /**
         * API name: {@code ignore_case}
         */
        @Nonnull
        public final Builder ignoreCase(@Nullable Boolean value) {
            this.ignoreCase = value;
            return this;
        }

        /**
         * API name: {@code query_mode}
         */
        @Nonnull
        public final Builder queryMode(@Nullable Boolean value) {
            this.queryMode = value;
            return this;
        }

        /**
         * Builds a {@link CommonGramsTokenFilter}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public CommonGramsTokenFilter build() {
            _checkSingleUse();

            return new CommonGramsTokenFilter(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link CommonGramsTokenFilter}
     */
    public static final JsonpDeserializer<CommonGramsTokenFilter> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        CommonGramsTokenFilter::setupCommonGramsTokenFilterDeserializer
    );

    protected static void setupCommonGramsTokenFilterDeserializer(ObjectDeserializer<CommonGramsTokenFilter.Builder> op) {
        setupTokenFilterBaseDeserializer(op);
        op.add(Builder::commonWords, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "common_words");
        op.add(Builder::commonWordsPath, JsonpDeserializer.stringDeserializer(), "common_words_path");
        op.add(Builder::ignoreCase, JsonpDeserializer.booleanDeserializer(), "ignore_case");
        op.add(Builder::queryMode, JsonpDeserializer.booleanDeserializer(), "query_mode");

        op.ignore("type");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(this.commonWords);
        result = 31 * result + Objects.hashCode(this.commonWordsPath);
        result = 31 * result + Objects.hashCode(this.ignoreCase);
        result = 31 * result + Objects.hashCode(this.queryMode);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        CommonGramsTokenFilter other = (CommonGramsTokenFilter) o;
        return Objects.equals(this.commonWords, other.commonWords)
            && Objects.equals(this.commonWordsPath, other.commonWordsPath)
            && Objects.equals(this.ignoreCase, other.ignoreCase)
            && Objects.equals(this.queryMode, other.queryMode);
    }
}
