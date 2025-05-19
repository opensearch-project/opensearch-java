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

// typedef: _types.analysis.PatternAnalyzer

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class PatternAnalyzer
    implements
        AnalyzerVariant,
        PlainJsonSerializable,
        ToCopyableBuilder<PatternAnalyzer.Builder, PatternAnalyzer> {

    @Nullable
    private final String flags;

    @Nullable
    private final Boolean lowercase;

    @Nonnull
    private final String pattern;

    @Nonnull
    private final List<String> stopwords;

    @Nullable
    private final String version;

    // ---------------------------------------------------------------------------------------------

    private PatternAnalyzer(Builder builder) {
        this.flags = builder.flags;
        this.lowercase = builder.lowercase;
        this.pattern = ApiTypeHelper.requireNonNull(builder.pattern, this, "pattern");
        this.stopwords = ApiTypeHelper.unmodifiable(builder.stopwords);
        this.version = builder.version;
    }

    public static PatternAnalyzer of(Function<PatternAnalyzer.Builder, ObjectBuilder<PatternAnalyzer>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link Analyzer} variant kind.
     */
    @Override
    public Analyzer.Kind _analyzerKind() {
        return Analyzer.Kind.Pattern;
    }

    /**
     * API name: {@code flags}
     */
    @Nullable
    public final String flags() {
        return this.flags;
    }

    /**
     * API name: {@code lowercase}
     */
    @Nullable
    public final Boolean lowercase() {
        return this.lowercase;
    }

    /**
     * Required - API name: {@code pattern}
     */
    @Nonnull
    public final String pattern() {
        return this.pattern;
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
        generator.write("type", "pattern");
        if (this.flags != null) {
            generator.writeKey("flags");
            generator.write(this.flags);
        }

        if (this.lowercase != null) {
            generator.writeKey("lowercase");
            generator.write(this.lowercase);
        }

        generator.writeKey("pattern");
        generator.write(this.pattern);

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
     * Builder for {@link PatternAnalyzer}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, PatternAnalyzer> {
        @Nullable
        private String flags;
        @Nullable
        private Boolean lowercase;
        private String pattern;
        @Nullable
        private List<String> stopwords;
        @Nullable
        private String version;

        public Builder() {}

        private Builder(PatternAnalyzer o) {
            this.flags = o.flags;
            this.lowercase = o.lowercase;
            this.pattern = o.pattern;
            this.stopwords = _listCopy(o.stopwords);
            this.version = o.version;
        }

        private Builder(Builder o) {
            this.flags = o.flags;
            this.lowercase = o.lowercase;
            this.pattern = o.pattern;
            this.stopwords = _listCopy(o.stopwords);
            this.version = o.version;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code flags}
         */
        @Nonnull
        public final Builder flags(@Nullable String value) {
            this.flags = value;
            return this;
        }

        /**
         * API name: {@code lowercase}
         */
        @Nonnull
        public final Builder lowercase(@Nullable Boolean value) {
            this.lowercase = value;
            return this;
        }

        /**
         * Required - API name: {@code pattern}
         */
        @Nonnull
        public final Builder pattern(String value) {
            this.pattern = value;
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
         * API name: {@code version}
         */
        @Nonnull
        public final Builder version(@Nullable String value) {
            this.version = value;
            return this;
        }

        /**
         * Builds a {@link PatternAnalyzer}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public PatternAnalyzer build() {
            _checkSingleUse();

            return new PatternAnalyzer(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link PatternAnalyzer}
     */
    public static final JsonpDeserializer<PatternAnalyzer> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        PatternAnalyzer::setupPatternAnalyzerDeserializer
    );

    protected static void setupPatternAnalyzerDeserializer(ObjectDeserializer<PatternAnalyzer.Builder> op) {
        op.add(Builder::flags, JsonpDeserializer.stringDeserializer(), "flags");
        op.add(Builder::lowercase, JsonpDeserializer.booleanDeserializer(), "lowercase");
        op.add(Builder::pattern, JsonpDeserializer.stringDeserializer(), "pattern");
        op.add(Builder::stopwords, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "stopwords");
        op.add(Builder::version, JsonpDeserializer.stringDeserializer(), "version");

        op.ignore("type");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.flags);
        result = 31 * result + Objects.hashCode(this.lowercase);
        result = 31 * result + this.pattern.hashCode();
        result = 31 * result + Objects.hashCode(this.stopwords);
        result = 31 * result + Objects.hashCode(this.version);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        PatternAnalyzer other = (PatternAnalyzer) o;
        return Objects.equals(this.flags, other.flags)
            && Objects.equals(this.lowercase, other.lowercase)
            && this.pattern.equals(other.pattern)
            && Objects.equals(this.stopwords, other.stopwords)
            && Objects.equals(this.version, other.version);
    }
}
