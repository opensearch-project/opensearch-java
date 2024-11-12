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
import org.opensearch.client.json.PlainJsonSerializable;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;

// typedef: _types.analysis.LanguageAnalyzer

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class LanguageAnalyzer implements AnalyzerVariant, PlainJsonSerializable {

    @Nonnull
    private final Language language;

    @Nonnull
    private final List<String> stemExclusion;

    @Nonnull
    private final List<String> stopwords;

    @Nullable
    private final String stopwordsPath;

    @Nullable
    private final String version;

    // ---------------------------------------------------------------------------------------------

    private LanguageAnalyzer(Builder builder) {
        this.language = ApiTypeHelper.requireNonNull(builder.language, this, "language");
        this.stemExclusion = ApiTypeHelper.unmodifiableRequired(builder.stemExclusion, this, "stemExclusion");
        this.stopwords = ApiTypeHelper.unmodifiable(builder.stopwords);
        this.stopwordsPath = builder.stopwordsPath;
        this.version = builder.version;
    }

    public static LanguageAnalyzer of(Function<LanguageAnalyzer.Builder, ObjectBuilder<LanguageAnalyzer>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link Analyzer} variant kind.
     */
    @Override
    public Analyzer.Kind _analyzerKind() {
        return Analyzer.Kind.Language;
    }

    /**
     * Required - API name: {@code language}
     */
    @Nonnull
    public final Language language() {
        return this.language;
    }

    /**
     * Required - API name: {@code stem_exclusion}
     */
    @Nonnull
    public final List<String> stemExclusion() {
        return this.stemExclusion;
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

    /**
     * API name: {@code version}
     */
    @Nullable
    public final String version() {
        return this.version;
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
        generator.write("type", "language");
        generator.writeKey("language");
        this.language.serialize(generator, mapper);

        generator.writeKey("stem_exclusion");
        generator.writeStartArray();
        for (String item0 : this.stemExclusion) {
            generator.write(item0);
        }
        generator.writeEnd();

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

        if (this.version != null) {
            generator.writeKey("version");
            generator.write(this.version);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Builder for {@link LanguageAnalyzer}.
     */
    public static class Builder extends ObjectBuilderBase implements ObjectBuilder<LanguageAnalyzer> {
        private Language language;
        private List<String> stemExclusion;
        @Nullable
        private List<String> stopwords;
        @Nullable
        private String stopwordsPath;
        @Nullable
        private String version;

        /**
         * Required - API name: {@code language}
         */
        public final Builder language(Language value) {
            this.language = value;
            return this;
        }

        /**
         * Required - API name: {@code stem_exclusion}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>stemExclusion</code>.
         * </p>
         */
        public final Builder stemExclusion(List<String> list) {
            this.stemExclusion = _listAddAll(this.stemExclusion, list);
            return this;
        }

        /**
         * Required - API name: {@code stem_exclusion}
         *
         * <p>
         * Adds one or more values to <code>stemExclusion</code>.
         * </p>
         */
        public final Builder stemExclusion(String value, String... values) {
            this.stemExclusion = _listAdd(this.stemExclusion, value, values);
            return this;
        }

        /**
         * API name: {@code stopwords}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>stopwords</code>.
         * </p>
         */
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
        public final Builder stopwords(String value, String... values) {
            this.stopwords = _listAdd(this.stopwords, value, values);
            return this;
        }

        /**
         * API name: {@code stopwords_path}
         */
        public final Builder stopwordsPath(@Nullable String value) {
            this.stopwordsPath = value;
            return this;
        }

        /**
         * API name: {@code version}
         */
        public final Builder version(@Nullable String value) {
            this.version = value;
            return this;
        }

        /**
         * Builds a {@link LanguageAnalyzer}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        public LanguageAnalyzer build() {
            _checkSingleUse();

            return new LanguageAnalyzer(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link LanguageAnalyzer}
     */
    public static final JsonpDeserializer<LanguageAnalyzer> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        LanguageAnalyzer::setupLanguageAnalyzerDeserializer
    );

    protected static void setupLanguageAnalyzerDeserializer(ObjectDeserializer<LanguageAnalyzer.Builder> op) {
        op.add(Builder::language, Language._DESERIALIZER, "language");
        op.add(Builder::stemExclusion, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "stem_exclusion");
        op.add(Builder::stopwords, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "stopwords");
        op.add(Builder::stopwordsPath, JsonpDeserializer.stringDeserializer(), "stopwords_path");
        op.add(Builder::version, JsonpDeserializer.stringDeserializer(), "version");

        op.ignore("type");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.language.hashCode();
        result = 31 * result + this.stemExclusion.hashCode();
        result = 31 * result + Objects.hashCode(this.stopwords);
        result = 31 * result + Objects.hashCode(this.stopwordsPath);
        result = 31 * result + Objects.hashCode(this.version);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        LanguageAnalyzer other = (LanguageAnalyzer) o;
        return this.language.equals(other.language)
            && this.stemExclusion.equals(other.stemExclusion)
            && Objects.equals(this.stopwords, other.stopwords)
            && Objects.equals(this.stopwordsPath, other.stopwordsPath)
            && Objects.equals(this.version, other.version);
    }
}
