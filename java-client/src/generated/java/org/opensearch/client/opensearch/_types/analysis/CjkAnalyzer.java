/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
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

// typedef: _types.analysis.CjkAnalyzer

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class CjkAnalyzer implements AnalyzerVariant, PlainJsonSerializable, ToCopyableBuilder<CjkAnalyzer.Builder, CjkAnalyzer> {

    @Nonnull
    private final List<String> stopwords;

    @Nullable
    private final String stopwordsPath;

    // ---------------------------------------------------------------------------------------------

    private CjkAnalyzer(Builder builder) {
        this.stopwords = ApiTypeHelper.unmodifiable(builder.stopwords);
        this.stopwordsPath = builder.stopwordsPath;
    }

    public static CjkAnalyzer of(Function<CjkAnalyzer.Builder, ObjectBuilder<CjkAnalyzer>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link Analyzer} variant kind.
     */
    @Override
    public Analyzer.Kind _analyzerKind() {
        return Analyzer.Kind.Cjk;
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
     * Serialize this object to JSON.
     */
    @Override
    public void serialize(JsonGenerator generator, JsonpMapper mapper) {
        generator.writeStartObject();
        serializeInternal(generator, mapper);
        generator.writeEnd();
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        generator.write("type", "cjk");
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
     * Builder for {@link CjkAnalyzer}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, CjkAnalyzer> {
        @Nullable
        private List<String> stopwords;
        @Nullable
        private String stopwordsPath;

        public Builder() {}

        private Builder(CjkAnalyzer o) {
            this.stopwords = _listCopy(o.stopwords);
            this.stopwordsPath = o.stopwordsPath;
        }

        private Builder(Builder o) {
            this.stopwords = _listCopy(o.stopwords);
            this.stopwordsPath = o.stopwordsPath;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
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
         * Builds a {@link CjkAnalyzer}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public CjkAnalyzer build() {
            _checkSingleUse();

            return new CjkAnalyzer(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link CjkAnalyzer}
     */
    public static final JsonpDeserializer<CjkAnalyzer> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        CjkAnalyzer::setupCjkAnalyzerDeserializer
    );

    protected static void setupCjkAnalyzerDeserializer(ObjectDeserializer<CjkAnalyzer.Builder> op) {
        op.add(Builder::stopwords, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "stopwords");
        op.add(Builder::stopwordsPath, JsonpDeserializer.stringDeserializer(), "stopwords_path");

        op.ignore("type");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.stopwords);
        result = 31 * result + Objects.hashCode(this.stopwordsPath);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        CjkAnalyzer other = (CjkAnalyzer) o;
        return Objects.equals(this.stopwords, other.stopwords) && Objects.equals(this.stopwordsPath, other.stopwordsPath);
    }
}
