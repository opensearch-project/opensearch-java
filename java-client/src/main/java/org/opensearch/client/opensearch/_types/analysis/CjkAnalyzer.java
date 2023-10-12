/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

/*
 * Modifications Copyright OpenSearch Contributors. See
 * GitHub history for details.
 */

package org.opensearch.client.opensearch._types.analysis;

import jakarta.json.stream.JsonGenerator;
import java.util.List;
import java.util.function.Function;
import javax.annotation.Nullable;
import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.JsonpSerializable;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;

// typedef: _types.analysis.LanguageAnalyzer

@JsonpDeserializable
public class CjkAnalyzer implements AnalyzerVariant, JsonpSerializable {
    @Nullable
    private final List<String> stopwords;

    @Nullable
    private final String stopwordsPath;

    // ---------------------------------------------------------------------------------------------

    private CjkAnalyzer(Builder builder) {

        this.stopwords = ApiTypeHelper.unmodifiable(builder.stopwords);
        this.stopwordsPath = builder.stopwordsPath;

    }

    public static CjkAnalyzer of(Function<Builder, ObjectBuilder<CjkAnalyzer>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Analyzer variant kind.
     */
    @Override
    public Analyzer.Kind _analyzerKind() {
        return Analyzer.Kind.Cjk;
    }

    /**
     * API name: {@code stopwords}
     */
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
    public void serialize(JsonGenerator generator, JsonpMapper mapper) {
        generator.writeStartObject();
        serializeInternal(generator, mapper);
        generator.writeEnd();
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {

        generator.write("type", Analyzer.Kind.Cjk.jsonValue());

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

    /**
     * Builder for {@link CjkAnalyzer}.
     */

    public static class Builder extends ObjectBuilderBase implements ObjectBuilder<CjkAnalyzer> {
        @Nullable
        private List<String> stopwords;

        @Nullable
        private String stopwordsPath;

        /**
         * API name: {@code stopwords}
         * <p>
         * Adds all elements of <code>list</code> to <code>stopwords</code>.
         */
        public final Builder stopwords(List<String> list) {
            this.stopwords = _listAddAll(this.stopwords, list);
            return this;
        }

        /**
         * API name: {@code stopwords}
         * <p>
         * Adds one or more values to <code>stopwords</code>.
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
         * Builds a {@link CjkAnalyzer}.
         *
         * @throws NullPointerException
         *             if some required fields are null.
         */
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
        CjkAnalyzer::setupLanguageAnalyzerDeserializer
    );

    protected static void setupLanguageAnalyzerDeserializer(ObjectDeserializer<CjkAnalyzer.Builder> op) {

        op.add(Builder::stopwords, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "stopwords");
        op.add(Builder::stopwordsPath, JsonpDeserializer.stringDeserializer(), "stopwords_path");

        op.ignore("type");
    }

}
