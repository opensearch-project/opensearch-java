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

// typedef: _types.analysis.SnowballAnalyzer

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class SnowballAnalyzer implements AnalyzerVariant, PlainJsonSerializable {

    @Nonnull
    private final SnowballLanguage language;

    @Nonnull
    private final List<String> stopwords;

    @Nullable
    private final String version;

    // ---------------------------------------------------------------------------------------------

    private SnowballAnalyzer(Builder builder) {
        this.language = ApiTypeHelper.requireNonNull(builder.language, this, "language");
        this.stopwords = ApiTypeHelper.unmodifiable(builder.stopwords);
        this.version = builder.version;
    }

    public static SnowballAnalyzer of(Function<SnowballAnalyzer.Builder, ObjectBuilder<SnowballAnalyzer>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link Analyzer} variant kind.
     */
    @Override
    public Analyzer.Kind _analyzerKind() {
        return Analyzer.Kind.Snowball;
    }

    /**
     * Required - API name: {@code language}
     */
    @Nonnull
    public final SnowballLanguage language() {
        return this.language;
    }

    /**
     * API name: {@code stopwords}
     */
    @Nonnull
    public final List<String> stopwords() {
        return this.stopwords;
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
        generator.write("type", "snowball");
        generator.writeKey("language");
        this.language.serialize(generator, mapper);

        if (ApiTypeHelper.isDefined(this.stopwords)) {
            generator.writeKey("stopwords");
            generator.writeStartArray();
            for (String item0 : this.stopwords) {
                generator.write(item0);
            }
            generator.writeEnd();
        }

        if (this.version != null) {
            generator.writeKey("version");
            generator.write(this.version);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Builder for {@link SnowballAnalyzer}.
     */
    public static class Builder extends ObjectBuilderBase implements ObjectBuilder<SnowballAnalyzer> {
        private SnowballLanguage language;
        @Nullable
        private List<String> stopwords;
        @Nullable
        private String version;

        /**
         * Required - API name: {@code language}
         */
        public final Builder language(SnowballLanguage value) {
            this.language = value;
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
         * API name: {@code version}
         */
        public final Builder version(@Nullable String value) {
            this.version = value;
            return this;
        }

        /**
         * Builds a {@link SnowballAnalyzer}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        public SnowballAnalyzer build() {
            _checkSingleUse();

            return new SnowballAnalyzer(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link SnowballAnalyzer}
     */
    public static final JsonpDeserializer<SnowballAnalyzer> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        SnowballAnalyzer::setupSnowballAnalyzerDeserializer
    );

    protected static void setupSnowballAnalyzerDeserializer(ObjectDeserializer<SnowballAnalyzer.Builder> op) {
        op.add(Builder::language, SnowballLanguage._DESERIALIZER, "language");
        op.add(Builder::stopwords, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "stopwords");
        op.add(Builder::version, JsonpDeserializer.stringDeserializer(), "version");

        op.ignore("type");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.language.hashCode();
        result = 31 * result + Objects.hashCode(this.stopwords);
        result = 31 * result + Objects.hashCode(this.version);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        SnowballAnalyzer other = (SnowballAnalyzer) o;
        return this.language.equals(other.language)
            && Objects.equals(this.stopwords, other.stopwords)
            && Objects.equals(this.version, other.version);
    }
}
