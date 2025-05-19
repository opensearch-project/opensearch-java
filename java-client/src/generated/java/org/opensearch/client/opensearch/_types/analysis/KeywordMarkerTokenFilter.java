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

// typedef: _types.analysis.KeywordMarkerTokenFilter

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class KeywordMarkerTokenFilter extends TokenFilterBase
    implements
        TokenFilterDefinitionVariant,
        ToCopyableBuilder<KeywordMarkerTokenFilter.Builder, KeywordMarkerTokenFilter> {

    @Nullable
    private final Boolean ignoreCase;

    @Nonnull
    private final List<String> keywords;

    @Nullable
    private final String keywordsPath;

    @Nullable
    private final String keywordsPattern;

    // ---------------------------------------------------------------------------------------------

    private KeywordMarkerTokenFilter(Builder builder) {
        super(builder);
        this.ignoreCase = builder.ignoreCase;
        this.keywords = ApiTypeHelper.unmodifiable(builder.keywords);
        this.keywordsPath = builder.keywordsPath;
        this.keywordsPattern = builder.keywordsPattern;
    }

    public static KeywordMarkerTokenFilter of(Function<KeywordMarkerTokenFilter.Builder, ObjectBuilder<KeywordMarkerTokenFilter>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link TokenFilterDefinition} variant kind.
     */
    @Override
    public TokenFilterDefinition.Kind _tokenFilterDefinitionKind() {
        return TokenFilterDefinition.Kind.KeywordMarker;
    }

    /**
     * API name: {@code ignore_case}
     */
    @Nullable
    public final Boolean ignoreCase() {
        return this.ignoreCase;
    }

    /**
     * API name: {@code keywords}
     */
    @Nonnull
    public final List<String> keywords() {
        return this.keywords;
    }

    /**
     * API name: {@code keywords_path}
     */
    @Nullable
    public final String keywordsPath() {
        return this.keywordsPath;
    }

    /**
     * API name: {@code keywords_pattern}
     */
    @Nullable
    public final String keywordsPattern() {
        return this.keywordsPattern;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        generator.write("type", "keyword_marker");
        super.serializeInternal(generator, mapper);
        if (this.ignoreCase != null) {
            generator.writeKey("ignore_case");
            generator.write(this.ignoreCase);
        }

        if (ApiTypeHelper.isDefined(this.keywords)) {
            generator.writeKey("keywords");
            generator.writeStartArray();
            for (String item0 : this.keywords) {
                generator.write(item0);
            }
            generator.writeEnd();
        }

        if (this.keywordsPath != null) {
            generator.writeKey("keywords_path");
            generator.write(this.keywordsPath);
        }

        if (this.keywordsPattern != null) {
            generator.writeKey("keywords_pattern");
            generator.write(this.keywordsPattern);
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
     * Builder for {@link KeywordMarkerTokenFilter}.
     */
    public static class Builder extends TokenFilterBase.AbstractBuilder<Builder>
        implements
            CopyableBuilder<Builder, KeywordMarkerTokenFilter> {
        @Nullable
        private Boolean ignoreCase;
        @Nullable
        private List<String> keywords;
        @Nullable
        private String keywordsPath;
        @Nullable
        private String keywordsPattern;

        public Builder() {}

        private Builder(KeywordMarkerTokenFilter o) {
            super(o);
            this.ignoreCase = o.ignoreCase;
            this.keywords = _listCopy(o.keywords);
            this.keywordsPath = o.keywordsPath;
            this.keywordsPattern = o.keywordsPattern;
        }

        private Builder(Builder o) {
            super(o);
            this.ignoreCase = o.ignoreCase;
            this.keywords = _listCopy(o.keywords);
            this.keywordsPath = o.keywordsPath;
            this.keywordsPattern = o.keywordsPattern;
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
         * API name: {@code ignore_case}
         */
        @Nonnull
        public final Builder ignoreCase(@Nullable Boolean value) {
            this.ignoreCase = value;
            return this;
        }

        /**
         * API name: {@code keywords}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>keywords</code>.
         * </p>
         */
        @Nonnull
        public final Builder keywords(List<String> list) {
            this.keywords = _listAddAll(this.keywords, list);
            return this;
        }

        /**
         * API name: {@code keywords}
         *
         * <p>
         * Adds one or more values to <code>keywords</code>.
         * </p>
         */
        @Nonnull
        public final Builder keywords(String value, String... values) {
            this.keywords = _listAdd(this.keywords, value, values);
            return this;
        }

        /**
         * API name: {@code keywords_path}
         */
        @Nonnull
        public final Builder keywordsPath(@Nullable String value) {
            this.keywordsPath = value;
            return this;
        }

        /**
         * API name: {@code keywords_pattern}
         */
        @Nonnull
        public final Builder keywordsPattern(@Nullable String value) {
            this.keywordsPattern = value;
            return this;
        }

        /**
         * Builds a {@link KeywordMarkerTokenFilter}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public KeywordMarkerTokenFilter build() {
            _checkSingleUse();

            return new KeywordMarkerTokenFilter(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link KeywordMarkerTokenFilter}
     */
    public static final JsonpDeserializer<KeywordMarkerTokenFilter> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        KeywordMarkerTokenFilter::setupKeywordMarkerTokenFilterDeserializer
    );

    protected static void setupKeywordMarkerTokenFilterDeserializer(ObjectDeserializer<KeywordMarkerTokenFilter.Builder> op) {
        setupTokenFilterBaseDeserializer(op);
        op.add(Builder::ignoreCase, JsonpDeserializer.booleanDeserializer(), "ignore_case");
        op.add(Builder::keywords, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "keywords");
        op.add(Builder::keywordsPath, JsonpDeserializer.stringDeserializer(), "keywords_path");
        op.add(Builder::keywordsPattern, JsonpDeserializer.stringDeserializer(), "keywords_pattern");

        op.ignore("type");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(this.ignoreCase);
        result = 31 * result + Objects.hashCode(this.keywords);
        result = 31 * result + Objects.hashCode(this.keywordsPath);
        result = 31 * result + Objects.hashCode(this.keywordsPattern);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        KeywordMarkerTokenFilter other = (KeywordMarkerTokenFilter) o;
        return Objects.equals(this.ignoreCase, other.ignoreCase)
            && Objects.equals(this.keywords, other.keywords)
            && Objects.equals(this.keywordsPath, other.keywordsPath)
            && Objects.equals(this.keywordsPattern, other.keywordsPattern);
    }
}
