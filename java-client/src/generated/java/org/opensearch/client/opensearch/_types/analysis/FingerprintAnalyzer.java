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
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: _types.analysis.FingerprintAnalyzer

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class FingerprintAnalyzer
    implements
        AnalyzerVariant,
        PlainJsonSerializable,
        ToCopyableBuilder<FingerprintAnalyzer.Builder, FingerprintAnalyzer> {

    private final int maxOutputSize;

    private final boolean preserveOriginal;

    @Nonnull
    private final String separator;

    @Nonnull
    private final List<String> stopwords;

    @Nullable
    private final String stopwordsPath;

    @Nullable
    private final String version;

    // ---------------------------------------------------------------------------------------------

    private FingerprintAnalyzer(Builder builder) {
        this.maxOutputSize = ApiTypeHelper.requireNonNull(builder.maxOutputSize, this, "maxOutputSize");
        this.preserveOriginal = ApiTypeHelper.requireNonNull(builder.preserveOriginal, this, "preserveOriginal");
        this.separator = ApiTypeHelper.requireNonNull(builder.separator, this, "separator");
        this.stopwords = ApiTypeHelper.unmodifiable(builder.stopwords);
        this.stopwordsPath = builder.stopwordsPath;
        this.version = builder.version;
    }

    public static FingerprintAnalyzer of(Function<FingerprintAnalyzer.Builder, ObjectBuilder<FingerprintAnalyzer>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link Analyzer} variant kind.
     */
    @Override
    public Analyzer.Kind _analyzerKind() {
        return Analyzer.Kind.Fingerprint;
    }

    /**
     * Required - API name: {@code max_output_size}
     */
    public final int maxOutputSize() {
        return this.maxOutputSize;
    }

    /**
     * Required - API name: {@code preserve_original}
     */
    public final boolean preserveOriginal() {
        return this.preserveOriginal;
    }

    /**
     * Required - API name: {@code separator}
     */
    @Nonnull
    public final String separator() {
        return this.separator;
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
        generator.write("type", "fingerprint");
        generator.writeKey("max_output_size");
        generator.write(this.maxOutputSize);

        generator.writeKey("preserve_original");
        generator.write(this.preserveOriginal);

        generator.writeKey("separator");
        generator.write(this.separator);

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
     * Builder for {@link FingerprintAnalyzer}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, FingerprintAnalyzer> {
        private Integer maxOutputSize;
        private Boolean preserveOriginal;
        private String separator;
        @Nullable
        private List<String> stopwords;
        @Nullable
        private String stopwordsPath;
        @Nullable
        private String version;

        public Builder() {}

        private Builder(FingerprintAnalyzer o) {
            this.maxOutputSize = o.maxOutputSize;
            this.preserveOriginal = o.preserveOriginal;
            this.separator = o.separator;
            this.stopwords = _listCopy(o.stopwords);
            this.stopwordsPath = o.stopwordsPath;
            this.version = o.version;
        }

        private Builder(Builder o) {
            this.maxOutputSize = o.maxOutputSize;
            this.preserveOriginal = o.preserveOriginal;
            this.separator = o.separator;
            this.stopwords = _listCopy(o.stopwords);
            this.stopwordsPath = o.stopwordsPath;
            this.version = o.version;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - API name: {@code max_output_size}
         */
        @Nonnull
        public final Builder maxOutputSize(int value) {
            this.maxOutputSize = value;
            return this;
        }

        /**
         * Required - API name: {@code preserve_original}
         */
        @Nonnull
        public final Builder preserveOriginal(boolean value) {
            this.preserveOriginal = value;
            return this;
        }

        /**
         * Required - API name: {@code separator}
         */
        @Nonnull
        public final Builder separator(String value) {
            this.separator = value;
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
         * API name: {@code version}
         */
        @Nonnull
        public final Builder version(@Nullable String value) {
            this.version = value;
            return this;
        }

        /**
         * Builds a {@link FingerprintAnalyzer}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public FingerprintAnalyzer build() {
            _checkSingleUse();

            return new FingerprintAnalyzer(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link FingerprintAnalyzer}
     */
    public static final JsonpDeserializer<FingerprintAnalyzer> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        FingerprintAnalyzer::setupFingerprintAnalyzerDeserializer
    );

    protected static void setupFingerprintAnalyzerDeserializer(ObjectDeserializer<FingerprintAnalyzer.Builder> op) {
        op.add(Builder::maxOutputSize, JsonpDeserializer.integerDeserializer(), "max_output_size");
        op.add(Builder::preserveOriginal, JsonpDeserializer.booleanDeserializer(), "preserve_original");
        op.add(Builder::separator, JsonpDeserializer.stringDeserializer(), "separator");
        op.add(Builder::stopwords, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "stopwords");
        op.add(Builder::stopwordsPath, JsonpDeserializer.stringDeserializer(), "stopwords_path");
        op.add(Builder::version, JsonpDeserializer.stringDeserializer(), "version");

        op.ignore("type");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Integer.hashCode(this.maxOutputSize);
        result = 31 * result + Boolean.hashCode(this.preserveOriginal);
        result = 31 * result + this.separator.hashCode();
        result = 31 * result + Objects.hashCode(this.stopwords);
        result = 31 * result + Objects.hashCode(this.stopwordsPath);
        result = 31 * result + Objects.hashCode(this.version);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        FingerprintAnalyzer other = (FingerprintAnalyzer) o;
        return this.maxOutputSize == other.maxOutputSize
            && this.preserveOriginal == other.preserveOriginal
            && this.separator.equals(other.separator)
            && Objects.equals(this.stopwords, other.stopwords)
            && Objects.equals(this.stopwordsPath, other.stopwordsPath)
            && Objects.equals(this.version, other.version);
    }
}
