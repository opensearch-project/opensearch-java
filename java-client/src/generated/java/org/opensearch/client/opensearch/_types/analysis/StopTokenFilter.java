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

// typedef: _types.analysis.StopTokenFilter

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class StopTokenFilter extends TokenFilterBase
    implements
        TokenFilterDefinitionVariant,
        ToCopyableBuilder<StopTokenFilter.Builder, StopTokenFilter> {

    @Nullable
    private final Boolean ignoreCase;

    @Nullable
    private final Boolean removeTrailing;

    @Nonnull
    private final List<String> stopwords;

    @Nullable
    private final String stopwordsPath;

    // ---------------------------------------------------------------------------------------------

    private StopTokenFilter(Builder builder) {
        super(builder);
        this.ignoreCase = builder.ignoreCase;
        this.removeTrailing = builder.removeTrailing;
        this.stopwords = ApiTypeHelper.unmodifiable(builder.stopwords);
        this.stopwordsPath = builder.stopwordsPath;
    }

    public static StopTokenFilter of(Function<StopTokenFilter.Builder, ObjectBuilder<StopTokenFilter>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link TokenFilterDefinition} variant kind.
     */
    @Override
    public TokenFilterDefinition.Kind _tokenFilterDefinitionKind() {
        return TokenFilterDefinition.Kind.Stop;
    }

    /**
     * API name: {@code ignore_case}
     */
    @Nullable
    public final Boolean ignoreCase() {
        return this.ignoreCase;
    }

    /**
     * API name: {@code remove_trailing}
     */
    @Nullable
    public final Boolean removeTrailing() {
        return this.removeTrailing;
    }

    /**
     * API name: {@code stopwords}
     */
    @Nonnull
    public final List<String> stopwords() {
        return this.stopwords;
    }

    /**
     * API name: {@code stopwords_path}
     */
    @Nullable
    public final String stopwordsPath() {
        return this.stopwordsPath;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        generator.write("type", "stop");
        super.serializeInternal(generator, mapper);
        if (this.ignoreCase != null) {
            generator.writeKey("ignore_case");
            generator.write(this.ignoreCase);
        }

        if (this.removeTrailing != null) {
            generator.writeKey("remove_trailing");
            generator.write(this.removeTrailing);
        }

        if (ApiTypeHelper.isDefined(this.stopwords)) {
            generator.writeKey("stopwords");
            generator.writeStartArray();
            for (String item0 : this.stopwords) {
                generator.write(item0);
            }
            generator.writeEnd();
        }

        if (this.stopwordsPath != null) {
            generator.writeKey("stopwords_path");
            generator.write(this.stopwordsPath);
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
     * Builder for {@link StopTokenFilter}.
     */
    public static class Builder extends TokenFilterBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, StopTokenFilter> {
        @Nullable
        private Boolean ignoreCase;
        @Nullable
        private Boolean removeTrailing;
        @Nullable
        private List<String> stopwords;
        @Nullable
        private String stopwordsPath;

        public Builder() {}

        private Builder(StopTokenFilter o) {
            super(o);
            this.ignoreCase = o.ignoreCase;
            this.removeTrailing = o.removeTrailing;
            this.stopwords = _listCopy(o.stopwords);
            this.stopwordsPath = o.stopwordsPath;
        }

        private Builder(Builder o) {
            super(o);
            this.ignoreCase = o.ignoreCase;
            this.removeTrailing = o.removeTrailing;
            this.stopwords = _listCopy(o.stopwords);
            this.stopwordsPath = o.stopwordsPath;
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
         * API name: {@code remove_trailing}
         */
        @Nonnull
        public final Builder removeTrailing(@Nullable Boolean value) {
            this.removeTrailing = value;
            return this;
        }

        /**
         * API name: {@code stopwords}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>stopwords</code>.
         * </p>
         */
        @Nonnull
        public final Builder stopwords(List<String> list) {
            this.stopwords = _listAddAll(this.stopwords, list);
            return this;
        }

        /**
         * API name: {@code stopwords}
         *
         * <p>
         * Adds one or more values to <code>stopwords</code>.
         * </p>
         */
        @Nonnull
        public final Builder stopwords(String value, String... values) {
            this.stopwords = _listAdd(this.stopwords, value, values);
            return this;
        }

        /**
         * API name: {@code stopwords_path}
         */
        @Nonnull
        public final Builder stopwordsPath(@Nullable String value) {
            this.stopwordsPath = value;
            return this;
        }

        /**
         * Builds a {@link StopTokenFilter}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public StopTokenFilter build() {
            _checkSingleUse();

            return new StopTokenFilter(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link StopTokenFilter}
     */
    public static final JsonpDeserializer<StopTokenFilter> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        StopTokenFilter::setupStopTokenFilterDeserializer
    );

    protected static void setupStopTokenFilterDeserializer(ObjectDeserializer<StopTokenFilter.Builder> op) {
        setupTokenFilterBaseDeserializer(op);
        op.add(Builder::ignoreCase, JsonpDeserializer.booleanDeserializer(), "ignore_case");
        op.add(Builder::removeTrailing, JsonpDeserializer.booleanDeserializer(), "remove_trailing");
        op.add(Builder::stopwords, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "stopwords");
        op.add(Builder::stopwordsPath, JsonpDeserializer.stringDeserializer(), "stopwords_path");

        op.ignore("type");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(this.ignoreCase);
        result = 31 * result + Objects.hashCode(this.removeTrailing);
        result = 31 * result + Objects.hashCode(this.stopwords);
        result = 31 * result + Objects.hashCode(this.stopwordsPath);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        StopTokenFilter other = (StopTokenFilter) o;
        return Objects.equals(this.ignoreCase, other.ignoreCase)
            && Objects.equals(this.removeTrailing, other.removeTrailing)
            && Objects.equals(this.stopwords, other.stopwords)
            && Objects.equals(this.stopwordsPath, other.stopwordsPath);
    }
}
