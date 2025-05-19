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

// typedef: _types.analysis.ElisionTokenFilter

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class ElisionTokenFilter extends TokenFilterBase
    implements
        TokenFilterDefinitionVariant,
        ToCopyableBuilder<ElisionTokenFilter.Builder, ElisionTokenFilter> {

    @Nonnull
    private final List<String> articles;

    @Nullable
    private final Boolean articlesCase;

    @Nullable
    private final String articlesPath;

    // ---------------------------------------------------------------------------------------------

    private ElisionTokenFilter(Builder builder) {
        super(builder);
        this.articles = ApiTypeHelper.unmodifiable(builder.articles);
        this.articlesCase = builder.articlesCase;
        this.articlesPath = builder.articlesPath;
    }

    public static ElisionTokenFilter of(Function<ElisionTokenFilter.Builder, ObjectBuilder<ElisionTokenFilter>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link TokenFilterDefinition} variant kind.
     */
    @Override
    public TokenFilterDefinition.Kind _tokenFilterDefinitionKind() {
        return TokenFilterDefinition.Kind.Elision;
    }

    /**
     * API name: {@code articles}
     */
    @Nonnull
    public final List<String> articles() {
        return this.articles;
    }

    /**
     * API name: {@code articles_case}
     */
    @Nullable
    public final Boolean articlesCase() {
        return this.articlesCase;
    }

    /**
     * API name: {@code articles_path}
     */
    @Nullable
    public final String articlesPath() {
        return this.articlesPath;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        generator.write("type", "elision");
        super.serializeInternal(generator, mapper);
        if (ApiTypeHelper.isDefined(this.articles)) {
            generator.writeKey("articles");
            generator.writeStartArray();
            for (String item0 : this.articles) {
                generator.write(item0);
            }
            generator.writeEnd();
        }

        if (this.articlesCase != null) {
            generator.writeKey("articles_case");
            generator.write(this.articlesCase);
        }

        if (this.articlesPath != null) {
            generator.writeKey("articles_path");
            generator.write(this.articlesPath);
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
     * Builder for {@link ElisionTokenFilter}.
     */
    public static class Builder extends TokenFilterBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, ElisionTokenFilter> {
        @Nullable
        private List<String> articles;
        @Nullable
        private Boolean articlesCase;
        @Nullable
        private String articlesPath;

        public Builder() {}

        private Builder(ElisionTokenFilter o) {
            super(o);
            this.articles = _listCopy(o.articles);
            this.articlesCase = o.articlesCase;
            this.articlesPath = o.articlesPath;
        }

        private Builder(Builder o) {
            super(o);
            this.articles = _listCopy(o.articles);
            this.articlesCase = o.articlesCase;
            this.articlesPath = o.articlesPath;
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
         * API name: {@code articles}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>articles</code>.
         * </p>
         */
        @Nonnull
        public final Builder articles(List<String> list) {
            this.articles = _listAddAll(this.articles, list);
            return this;
        }

        /**
         * API name: {@code articles}
         *
         * <p>
         * Adds one or more values to <code>articles</code>.
         * </p>
         */
        @Nonnull
        public final Builder articles(String value, String... values) {
            this.articles = _listAdd(this.articles, value, values);
            return this;
        }

        /**
         * API name: {@code articles_case}
         */
        @Nonnull
        public final Builder articlesCase(@Nullable Boolean value) {
            this.articlesCase = value;
            return this;
        }

        /**
         * API name: {@code articles_path}
         */
        @Nonnull
        public final Builder articlesPath(@Nullable String value) {
            this.articlesPath = value;
            return this;
        }

        /**
         * Builds a {@link ElisionTokenFilter}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ElisionTokenFilter build() {
            _checkSingleUse();

            return new ElisionTokenFilter(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ElisionTokenFilter}
     */
    public static final JsonpDeserializer<ElisionTokenFilter> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ElisionTokenFilter::setupElisionTokenFilterDeserializer
    );

    protected static void setupElisionTokenFilterDeserializer(ObjectDeserializer<ElisionTokenFilter.Builder> op) {
        setupTokenFilterBaseDeserializer(op);
        op.add(Builder::articles, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "articles");
        op.add(Builder::articlesCase, JsonpDeserializer.booleanDeserializer(), "articles_case");
        op.add(Builder::articlesPath, JsonpDeserializer.stringDeserializer(), "articles_path");

        op.ignore("type");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(this.articles);
        result = 31 * result + Objects.hashCode(this.articlesCase);
        result = 31 * result + Objects.hashCode(this.articlesPath);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ElisionTokenFilter other = (ElisionTokenFilter) o;
        return Objects.equals(this.articles, other.articles)
            && Objects.equals(this.articlesCase, other.articlesCase)
            && Objects.equals(this.articlesPath, other.articlesPath);
    }
}
