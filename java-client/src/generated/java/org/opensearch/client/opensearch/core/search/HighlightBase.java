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

package org.opensearch.client.opensearch.core.search;

import jakarta.json.stream.JsonGenerator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.opensearch.client.json.JsonData;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.json.PlainJsonSerializable;
import org.opensearch.client.opensearch._types.query_dsl.Query;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;

// typedef: core.search.HighlightBase

@Generated("org.opensearch.client.codegen.CodeGenerator")
public abstract class HighlightBase implements PlainJsonSerializable {

    @Nullable
    private final String boundaryChars;

    @Nullable
    private final Integer boundaryMaxScan;

    @Nullable
    private final BoundaryScanner boundaryScanner;

    @Nullable
    private final String boundaryScannerLocale;

    @Nullable
    private final Boolean forceSource;

    @Nullable
    private final Integer fragmentOffset;

    @Nullable
    private final Integer fragmentSize;

    @Nullable
    private final HighlighterFragmenter fragmenter;

    @Nullable
    private final Boolean highlightFilter;

    @Nullable
    private final Query highlightQuery;

    @Nullable
    private final Integer maxAnalyzerOffset;

    @Nullable
    private final Integer maxFragmentLength;

    @Nullable
    private final Integer noMatchSize;

    @Nullable
    private final Integer numberOfFragments;

    @Nonnull
    private final Map<String, Map<String, JsonData>> options;

    @Nullable
    private final HighlighterOrder order;

    @Nullable
    private final Integer phraseLimit;

    @Nonnull
    private final List<String> postTags;

    @Nonnull
    private final List<String> preTags;

    @Nullable
    private final Boolean requireFieldMatch;

    @Nullable
    private final HighlighterTagsSchema tagsSchema;

    @Nullable
    private final HighlighterType type;

    // ---------------------------------------------------------------------------------------------

    protected HighlightBase(AbstractBuilder<?> builder) {
        this.boundaryChars = builder.boundaryChars;
        this.boundaryMaxScan = builder.boundaryMaxScan;
        this.boundaryScanner = builder.boundaryScanner;
        this.boundaryScannerLocale = builder.boundaryScannerLocale;
        this.forceSource = builder.forceSource;
        this.fragmentOffset = builder.fragmentOffset;
        this.fragmentSize = builder.fragmentSize;
        this.fragmenter = builder.fragmenter;
        this.highlightFilter = builder.highlightFilter;
        this.highlightQuery = builder.highlightQuery;
        this.maxAnalyzerOffset = builder.maxAnalyzerOffset;
        this.maxFragmentLength = builder.maxFragmentLength;
        this.noMatchSize = builder.noMatchSize;
        this.numberOfFragments = builder.numberOfFragments;
        this.options = ApiTypeHelper.unmodifiable(builder.options);
        this.order = builder.order;
        this.phraseLimit = builder.phraseLimit;
        this.postTags = ApiTypeHelper.unmodifiable(builder.postTags);
        this.preTags = ApiTypeHelper.unmodifiable(builder.preTags);
        this.requireFieldMatch = builder.requireFieldMatch;
        this.tagsSchema = builder.tagsSchema;
        this.type = builder.type;
    }

    /**
     * A string that contains each boundary character.
     * <p>
     * API name: {@code boundary_chars}
     * </p>
     */
    @Nullable
    public final String boundaryChars() {
        return this.boundaryChars;
    }

    /**
     * How far to scan for boundary characters.
     * <p>
     * API name: {@code boundary_max_scan}
     * </p>
     */
    @Nullable
    public final Integer boundaryMaxScan() {
        return this.boundaryMaxScan;
    }

    /**
     * API name: {@code boundary_scanner}
     */
    @Nullable
    public final BoundaryScanner boundaryScanner() {
        return this.boundaryScanner;
    }

    /**
     * Controls which locale is used to search for sentence and word boundaries. This parameter takes the form of a language tag, for
     * example, <code>&quot;en-US&quot;</code>, <code>&quot;fr-FR&quot;</code>, or <code>&quot;ja-JP&quot;</code>.
     * <p>
     * API name: {@code boundary_scanner_locale}
     * </p>
     */
    @Nullable
    public final String boundaryScannerLocale() {
        return this.boundaryScannerLocale;
    }

    /**
     * API name: {@code force_source}
     */
    @Nullable
    public final Boolean forceSource() {
        return this.forceSource;
    }

    /**
     * API name: {@code fragment_offset}
     */
    @Nullable
    public final Integer fragmentOffset() {
        return this.fragmentOffset;
    }

    /**
     * The size of the highlighted fragment in characters.
     * <p>
     * API name: {@code fragment_size}
     * </p>
     */
    @Nullable
    public final Integer fragmentSize() {
        return this.fragmentSize;
    }

    /**
     * API name: {@code fragmenter}
     */
    @Nullable
    public final HighlighterFragmenter fragmenter() {
        return this.fragmenter;
    }

    /**
     * API name: {@code highlight_filter}
     */
    @Nullable
    public final Boolean highlightFilter() {
        return this.highlightFilter;
    }

    /**
     * API name: {@code highlight_query}
     */
    @Nullable
    public final Query highlightQuery() {
        return this.highlightQuery;
    }

    /**
     * If set to a non-negative value, highlighting stops at this defined maximum limit. The rest of the text is not processed or
     * highlighted, and no error is returned. The <code>max_analyzer_offset</code> query setting does not override the
     * <code>index.highlight.max_analyzed_offset</code> setting, which takes precedence when it is set to a lower value than the query
     * setting.
     * <p>
     * API name: {@code max_analyzer_offset}
     * </p>
     */
    @Nullable
    public final Integer maxAnalyzerOffset() {
        return this.maxAnalyzerOffset;
    }

    /**
     * API name: {@code max_fragment_length}
     */
    @Nullable
    public final Integer maxFragmentLength() {
        return this.maxFragmentLength;
    }

    /**
     * The amount of text you want to return from the beginning of the field if there are no matching fragments to highlight.
     * <p>
     * API name: {@code no_match_size}
     * </p>
     */
    @Nullable
    public final Integer noMatchSize() {
        return this.noMatchSize;
    }

    /**
     * The maximum number of fragments to return. When the number of fragments is set to <code>0</code>, no fragments are returned. Instead,
     * the entirety of a field's contents are highlighted and returned. This is useful when you need to highlight short texts, such as a
     * title or address, in which fragmentation is not required. If <code>number_of_fragments</code> is set to <code>0</code>, the
     * <code>fragment_size</code> is ignored.
     * <p>
     * API name: {@code number_of_fragments}
     * </p>
     */
    @Nullable
    public final Integer numberOfFragments() {
        return this.numberOfFragments;
    }

    /**
     * API name: {@code options}
     */
    @Nonnull
    public final Map<String, Map<String, JsonData>> options() {
        return this.options;
    }

    /**
     * API name: {@code order}
     */
    @Nullable
    public final HighlighterOrder order() {
        return this.order;
    }

    /**
     * Controls the number of matching phrases in a document that are considered. This prevents the <code>fvh</code> highlighter from
     * analyzing too many phrases and consuming too much memory. When using <code>matched_fields</code>, phrase-limited phrases per matched
     * field are considered. Raising the limit increases the query time and consumes more memory. This setting is only supported by the
     * <code>fvh</code> highlighter.
     * <p>
     * API name: {@code phrase_limit}
     * </p>
     */
    @Nullable
    public final Integer phraseLimit() {
        return this.phraseLimit;
    }

    /**
     * When used in conjunction with <code>pre_tags</code>, defines the HTML tags to use for the highlighted text. By default, highlighted
     * text is wrapped in <code>&lt;em&gt;</code> and <code>&lt;/em&gt;</code> tags.
     * <p>
     * API name: {@code post_tags}
     * </p>
     */
    @Nonnull
    public final List<String> postTags() {
        return this.postTags;
    }

    /**
     * When used in conjunction with <code>post_tags</code>, defines the HTML tags to use for the highlighted text. By default, highlighted
     * text is wrapped in <code>&lt;em&gt;</code> and <code>&lt;/em&gt;</code> tags.
     * <p>
     * API name: {@code pre_tags}
     * </p>
     */
    @Nonnull
    public final List<String> preTags() {
        return this.preTags;
    }

    /**
     * By default, only fields that contains a query match are highlighted. Set to <code>false</code> to highlight all fields.
     * <p>
     * API name: {@code require_field_match}
     * </p>
     */
    @Nullable
    public final Boolean requireFieldMatch() {
        return this.requireFieldMatch;
    }

    /**
     * API name: {@code tags_schema}
     */
    @Nullable
    public final HighlighterTagsSchema tagsSchema() {
        return this.tagsSchema;
    }

    /**
     * API name: {@code type}
     */
    @Nullable
    public final HighlighterType type() {
        return this.type;
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
        if (this.boundaryChars != null) {
            generator.writeKey("boundary_chars");
            generator.write(this.boundaryChars);
        }

        if (this.boundaryMaxScan != null) {
            generator.writeKey("boundary_max_scan");
            generator.write(this.boundaryMaxScan);
        }

        if (this.boundaryScanner != null) {
            generator.writeKey("boundary_scanner");
            this.boundaryScanner.serialize(generator, mapper);
        }

        if (this.boundaryScannerLocale != null) {
            generator.writeKey("boundary_scanner_locale");
            generator.write(this.boundaryScannerLocale);
        }

        if (this.forceSource != null) {
            generator.writeKey("force_source");
            generator.write(this.forceSource);
        }

        if (this.fragmentOffset != null) {
            generator.writeKey("fragment_offset");
            generator.write(this.fragmentOffset);
        }

        if (this.fragmentSize != null) {
            generator.writeKey("fragment_size");
            generator.write(this.fragmentSize);
        }

        if (this.fragmenter != null) {
            generator.writeKey("fragmenter");
            this.fragmenter.serialize(generator, mapper);
        }

        if (this.highlightFilter != null) {
            generator.writeKey("highlight_filter");
            generator.write(this.highlightFilter);
        }

        if (this.highlightQuery != null) {
            generator.writeKey("highlight_query");
            this.highlightQuery.serialize(generator, mapper);
        }

        if (this.maxAnalyzerOffset != null) {
            generator.writeKey("max_analyzer_offset");
            generator.write(this.maxAnalyzerOffset);
        }

        if (this.maxFragmentLength != null) {
            generator.writeKey("max_fragment_length");
            generator.write(this.maxFragmentLength);
        }

        if (this.noMatchSize != null) {
            generator.writeKey("no_match_size");
            generator.write(this.noMatchSize);
        }

        if (this.numberOfFragments != null) {
            generator.writeKey("number_of_fragments");
            generator.write(this.numberOfFragments);
        }

        if (ApiTypeHelper.isDefined(this.options)) {
            generator.writeKey("options");
            generator.writeStartObject();
            for (Map.Entry<String, Map<String, JsonData>> item0 : this.options.entrySet()) {
                generator.writeKey(item0.getKey());
                generator.writeStartObject();
                for (Map.Entry<String, JsonData> item1 : item0.getValue().entrySet()) {
                    generator.writeKey(item1.getKey());
                    item1.getValue().serialize(generator, mapper);
                }
                generator.writeEnd();
            }
            generator.writeEnd();
        }

        if (this.order != null) {
            generator.writeKey("order");
            this.order.serialize(generator, mapper);
        }

        if (this.phraseLimit != null) {
            generator.writeKey("phrase_limit");
            generator.write(this.phraseLimit);
        }

        if (ApiTypeHelper.isDefined(this.postTags)) {
            generator.writeKey("post_tags");
            generator.writeStartArray();
            for (String item0 : this.postTags) {
                generator.write(item0);
            }
            generator.writeEnd();
        }

        if (ApiTypeHelper.isDefined(this.preTags)) {
            generator.writeKey("pre_tags");
            generator.writeStartArray();
            for (String item0 : this.preTags) {
                generator.write(item0);
            }
            generator.writeEnd();
        }

        if (this.requireFieldMatch != null) {
            generator.writeKey("require_field_match");
            generator.write(this.requireFieldMatch);
        }

        if (this.tagsSchema != null) {
            generator.writeKey("tags_schema");
            this.tagsSchema.serialize(generator, mapper);
        }

        if (this.type != null) {
            generator.writeKey("type");
            this.type.serialize(generator, mapper);
        }
    }

    // ---------------------------------------------------------------------------------------------

    public abstract static class AbstractBuilder<BuilderT extends AbstractBuilder<BuilderT>> extends ObjectBuilderBase {
        @Nullable
        private String boundaryChars;
        @Nullable
        private Integer boundaryMaxScan;
        @Nullable
        private BoundaryScanner boundaryScanner;
        @Nullable
        private String boundaryScannerLocale;
        @Nullable
        private Boolean forceSource;
        @Nullable
        private Integer fragmentOffset;
        @Nullable
        private Integer fragmentSize;
        @Nullable
        private HighlighterFragmenter fragmenter;
        @Nullable
        private Boolean highlightFilter;
        @Nullable
        private Query highlightQuery;
        @Nullable
        private Integer maxAnalyzerOffset;
        @Nullable
        private Integer maxFragmentLength;
        @Nullable
        private Integer noMatchSize;
        @Nullable
        private Integer numberOfFragments;
        @Nullable
        private Map<String, Map<String, JsonData>> options;
        @Nullable
        private HighlighterOrder order;
        @Nullable
        private Integer phraseLimit;
        @Nullable
        private List<String> postTags;
        @Nullable
        private List<String> preTags;
        @Nullable
        private Boolean requireFieldMatch;
        @Nullable
        private HighlighterTagsSchema tagsSchema;
        @Nullable
        private HighlighterType type;

        protected AbstractBuilder() {}

        protected AbstractBuilder(HighlightBase o) {
            this.boundaryChars = o.boundaryChars;
            this.boundaryMaxScan = o.boundaryMaxScan;
            this.boundaryScanner = o.boundaryScanner;
            this.boundaryScannerLocale = o.boundaryScannerLocale;
            this.forceSource = o.forceSource;
            this.fragmentOffset = o.fragmentOffset;
            this.fragmentSize = o.fragmentSize;
            this.fragmenter = o.fragmenter;
            this.highlightFilter = o.highlightFilter;
            this.highlightQuery = o.highlightQuery;
            this.maxAnalyzerOffset = o.maxAnalyzerOffset;
            this.maxFragmentLength = o.maxFragmentLength;
            this.noMatchSize = o.noMatchSize;
            this.numberOfFragments = o.numberOfFragments;
            this.options = _mapCopy(o.options);
            this.order = o.order;
            this.phraseLimit = o.phraseLimit;
            this.postTags = _listCopy(o.postTags);
            this.preTags = _listCopy(o.preTags);
            this.requireFieldMatch = o.requireFieldMatch;
            this.tagsSchema = o.tagsSchema;
            this.type = o.type;
        }

        protected AbstractBuilder(AbstractBuilder<BuilderT> o) {
            this.boundaryChars = o.boundaryChars;
            this.boundaryMaxScan = o.boundaryMaxScan;
            this.boundaryScanner = o.boundaryScanner;
            this.boundaryScannerLocale = o.boundaryScannerLocale;
            this.forceSource = o.forceSource;
            this.fragmentOffset = o.fragmentOffset;
            this.fragmentSize = o.fragmentSize;
            this.fragmenter = o.fragmenter;
            this.highlightFilter = o.highlightFilter;
            this.highlightQuery = o.highlightQuery;
            this.maxAnalyzerOffset = o.maxAnalyzerOffset;
            this.maxFragmentLength = o.maxFragmentLength;
            this.noMatchSize = o.noMatchSize;
            this.numberOfFragments = o.numberOfFragments;
            this.options = _mapCopy(o.options);
            this.order = o.order;
            this.phraseLimit = o.phraseLimit;
            this.postTags = _listCopy(o.postTags);
            this.preTags = _listCopy(o.preTags);
            this.requireFieldMatch = o.requireFieldMatch;
            this.tagsSchema = o.tagsSchema;
            this.type = o.type;
        }

        @Nonnull
        protected abstract BuilderT self();

        /**
         * A string that contains each boundary character.
         * <p>
         * API name: {@code boundary_chars}
         * </p>
         */
        @Nonnull
        public final BuilderT boundaryChars(@Nullable String value) {
            this.boundaryChars = value;
            return self();
        }

        /**
         * How far to scan for boundary characters.
         * <p>
         * API name: {@code boundary_max_scan}
         * </p>
         */
        @Nonnull
        public final BuilderT boundaryMaxScan(@Nullable Integer value) {
            this.boundaryMaxScan = value;
            return self();
        }

        /**
         * API name: {@code boundary_scanner}
         */
        @Nonnull
        public final BuilderT boundaryScanner(@Nullable BoundaryScanner value) {
            this.boundaryScanner = value;
            return self();
        }

        /**
         * Controls which locale is used to search for sentence and word boundaries. This parameter takes the form of a language tag, for
         * example, <code>&quot;en-US&quot;</code>, <code>&quot;fr-FR&quot;</code>, or <code>&quot;ja-JP&quot;</code>.
         * <p>
         * API name: {@code boundary_scanner_locale}
         * </p>
         */
        @Nonnull
        public final BuilderT boundaryScannerLocale(@Nullable String value) {
            this.boundaryScannerLocale = value;
            return self();
        }

        /**
         * API name: {@code force_source}
         */
        @Nonnull
        public final BuilderT forceSource(@Nullable Boolean value) {
            this.forceSource = value;
            return self();
        }

        /**
         * API name: {@code fragment_offset}
         */
        @Nonnull
        public final BuilderT fragmentOffset(@Nullable Integer value) {
            this.fragmentOffset = value;
            return self();
        }

        /**
         * The size of the highlighted fragment in characters.
         * <p>
         * API name: {@code fragment_size}
         * </p>
         */
        @Nonnull
        public final BuilderT fragmentSize(@Nullable Integer value) {
            this.fragmentSize = value;
            return self();
        }

        /**
         * API name: {@code fragmenter}
         */
        @Nonnull
        public final BuilderT fragmenter(@Nullable HighlighterFragmenter value) {
            this.fragmenter = value;
            return self();
        }

        /**
         * API name: {@code highlight_filter}
         */
        @Nonnull
        public final BuilderT highlightFilter(@Nullable Boolean value) {
            this.highlightFilter = value;
            return self();
        }

        /**
         * API name: {@code highlight_query}
         */
        @Nonnull
        public final BuilderT highlightQuery(@Nullable Query value) {
            this.highlightQuery = value;
            return self();
        }

        /**
         * API name: {@code highlight_query}
         */
        @Nonnull
        public final BuilderT highlightQuery(Function<Query.Builder, ObjectBuilder<Query>> fn) {
            return highlightQuery(fn.apply(new Query.Builder()).build());
        }

        /**
         * If set to a non-negative value, highlighting stops at this defined maximum limit. The rest of the text is not processed or
         * highlighted, and no error is returned. The <code>max_analyzer_offset</code> query setting does not override the
         * <code>index.highlight.max_analyzed_offset</code> setting, which takes precedence when it is set to a lower value than the query
         * setting.
         * <p>
         * API name: {@code max_analyzer_offset}
         * </p>
         */
        @Nonnull
        public final BuilderT maxAnalyzerOffset(@Nullable Integer value) {
            this.maxAnalyzerOffset = value;
            return self();
        }

        /**
         * API name: {@code max_fragment_length}
         */
        @Nonnull
        public final BuilderT maxFragmentLength(@Nullable Integer value) {
            this.maxFragmentLength = value;
            return self();
        }

        /**
         * The amount of text you want to return from the beginning of the field if there are no matching fragments to highlight.
         * <p>
         * API name: {@code no_match_size}
         * </p>
         */
        @Nonnull
        public final BuilderT noMatchSize(@Nullable Integer value) {
            this.noMatchSize = value;
            return self();
        }

        /**
         * The maximum number of fragments to return. When the number of fragments is set to <code>0</code>, no fragments are returned.
         * Instead, the entirety of a field's contents are highlighted and returned. This is useful when you need to highlight short texts,
         * such as a title or address, in which fragmentation is not required. If <code>number_of_fragments</code> is set to <code>0</code>,
         * the <code>fragment_size</code> is ignored.
         * <p>
         * API name: {@code number_of_fragments}
         * </p>
         */
        @Nonnull
        public final BuilderT numberOfFragments(@Nullable Integer value) {
            this.numberOfFragments = value;
            return self();
        }

        /**
         * API name: {@code options}
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>options</code>.
         * </p>
         */
        @Nonnull
        public final BuilderT options(Map<String, Map<String, JsonData>> map) {
            this.options = _mapPutAll(this.options, map);
            return self();
        }

        /**
         * API name: {@code options}
         *
         * <p>
         * Adds an entry to <code>options</code>.
         * </p>
         */
        @Nonnull
        public final BuilderT options(String key, Map<String, JsonData> value) {
            this.options = _mapPut(this.options, key, value);
            return self();
        }

        /**
         * API name: {@code order}
         */
        @Nonnull
        public final BuilderT order(@Nullable HighlighterOrder value) {
            this.order = value;
            return self();
        }

        /**
         * Controls the number of matching phrases in a document that are considered. This prevents the <code>fvh</code> highlighter from
         * analyzing too many phrases and consuming too much memory. When using <code>matched_fields</code>, phrase-limited phrases per
         * matched field are considered. Raising the limit increases the query time and consumes more memory. This setting is only supported
         * by the <code>fvh</code> highlighter.
         * <p>
         * API name: {@code phrase_limit}
         * </p>
         */
        @Nonnull
        public final BuilderT phraseLimit(@Nullable Integer value) {
            this.phraseLimit = value;
            return self();
        }

        /**
         * When used in conjunction with <code>pre_tags</code>, defines the HTML tags to use for the highlighted text. By default,
         * highlighted text is wrapped in <code>&lt;em&gt;</code> and <code>&lt;/em&gt;</code> tags.
         * <p>
         * API name: {@code post_tags}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>postTags</code>.
         * </p>
         */
        @Nonnull
        public final BuilderT postTags(List<String> list) {
            this.postTags = _listAddAll(this.postTags, list);
            return self();
        }

        /**
         * When used in conjunction with <code>pre_tags</code>, defines the HTML tags to use for the highlighted text. By default,
         * highlighted text is wrapped in <code>&lt;em&gt;</code> and <code>&lt;/em&gt;</code> tags.
         * <p>
         * API name: {@code post_tags}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>postTags</code>.
         * </p>
         */
        @Nonnull
        public final BuilderT postTags(String value, String... values) {
            this.postTags = _listAdd(this.postTags, value, values);
            return self();
        }

        /**
         * When used in conjunction with <code>post_tags</code>, defines the HTML tags to use for the highlighted text. By default,
         * highlighted text is wrapped in <code>&lt;em&gt;</code> and <code>&lt;/em&gt;</code> tags.
         * <p>
         * API name: {@code pre_tags}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>preTags</code>.
         * </p>
         */
        @Nonnull
        public final BuilderT preTags(List<String> list) {
            this.preTags = _listAddAll(this.preTags, list);
            return self();
        }

        /**
         * When used in conjunction with <code>post_tags</code>, defines the HTML tags to use for the highlighted text. By default,
         * highlighted text is wrapped in <code>&lt;em&gt;</code> and <code>&lt;/em&gt;</code> tags.
         * <p>
         * API name: {@code pre_tags}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>preTags</code>.
         * </p>
         */
        @Nonnull
        public final BuilderT preTags(String value, String... values) {
            this.preTags = _listAdd(this.preTags, value, values);
            return self();
        }

        /**
         * By default, only fields that contains a query match are highlighted. Set to <code>false</code> to highlight all fields.
         * <p>
         * API name: {@code require_field_match}
         * </p>
         */
        @Nonnull
        public final BuilderT requireFieldMatch(@Nullable Boolean value) {
            this.requireFieldMatch = value;
            return self();
        }

        /**
         * API name: {@code tags_schema}
         */
        @Nonnull
        public final BuilderT tagsSchema(@Nullable HighlighterTagsSchema value) {
            this.tagsSchema = value;
            return self();
        }

        /**
         * API name: {@code type}
         */
        @Nonnull
        public final BuilderT type(@Nullable HighlighterType value) {
            this.type = value;
            return self();
        }

        /**
         * API name: {@code type}
         */
        @Nonnull
        public final BuilderT type(Function<HighlighterType.Builder, ObjectBuilder<HighlighterType>> fn) {
            return type(fn.apply(new HighlighterType.Builder()).build());
        }
    }

    // ---------------------------------------------------------------------------------------------

    protected static <BuilderT extends AbstractBuilder<BuilderT>> void setupHighlightBaseDeserializer(ObjectDeserializer<BuilderT> op) {
        op.add(AbstractBuilder::boundaryChars, JsonpDeserializer.stringDeserializer(), "boundary_chars");
        op.add(AbstractBuilder::boundaryMaxScan, JsonpDeserializer.integerDeserializer(), "boundary_max_scan");
        op.add(AbstractBuilder::boundaryScanner, BoundaryScanner._DESERIALIZER, "boundary_scanner");
        op.add(AbstractBuilder::boundaryScannerLocale, JsonpDeserializer.stringDeserializer(), "boundary_scanner_locale");
        op.add(AbstractBuilder::forceSource, JsonpDeserializer.booleanDeserializer(), "force_source");
        op.add(AbstractBuilder::fragmentOffset, JsonpDeserializer.integerDeserializer(), "fragment_offset");
        op.add(AbstractBuilder::fragmentSize, JsonpDeserializer.integerDeserializer(), "fragment_size");
        op.add(AbstractBuilder::fragmenter, HighlighterFragmenter._DESERIALIZER, "fragmenter");
        op.add(AbstractBuilder::highlightFilter, JsonpDeserializer.booleanDeserializer(), "highlight_filter");
        op.add(AbstractBuilder::highlightQuery, Query._DESERIALIZER, "highlight_query");
        op.add(AbstractBuilder::maxAnalyzerOffset, JsonpDeserializer.integerDeserializer(), "max_analyzer_offset");
        op.add(AbstractBuilder::maxFragmentLength, JsonpDeserializer.integerDeserializer(), "max_fragment_length");
        op.add(AbstractBuilder::noMatchSize, JsonpDeserializer.integerDeserializer(), "no_match_size");
        op.add(AbstractBuilder::numberOfFragments, JsonpDeserializer.integerDeserializer(), "number_of_fragments");
        op.add(
            AbstractBuilder::options,
            JsonpDeserializer.stringMapDeserializer(JsonpDeserializer.stringMapDeserializer(JsonData._DESERIALIZER)),
            "options"
        );
        op.add(AbstractBuilder::order, HighlighterOrder._DESERIALIZER, "order");
        op.add(AbstractBuilder::phraseLimit, JsonpDeserializer.integerDeserializer(), "phrase_limit");
        op.add(AbstractBuilder::postTags, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "post_tags");
        op.add(AbstractBuilder::preTags, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "pre_tags");
        op.add(AbstractBuilder::requireFieldMatch, JsonpDeserializer.booleanDeserializer(), "require_field_match");
        op.add(AbstractBuilder::tagsSchema, HighlighterTagsSchema._DESERIALIZER, "tags_schema");
        op.add(AbstractBuilder::type, HighlighterType._DESERIALIZER, "type");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.boundaryChars);
        result = 31 * result + Objects.hashCode(this.boundaryMaxScan);
        result = 31 * result + Objects.hashCode(this.boundaryScanner);
        result = 31 * result + Objects.hashCode(this.boundaryScannerLocale);
        result = 31 * result + Objects.hashCode(this.forceSource);
        result = 31 * result + Objects.hashCode(this.fragmentOffset);
        result = 31 * result + Objects.hashCode(this.fragmentSize);
        result = 31 * result + Objects.hashCode(this.fragmenter);
        result = 31 * result + Objects.hashCode(this.highlightFilter);
        result = 31 * result + Objects.hashCode(this.highlightQuery);
        result = 31 * result + Objects.hashCode(this.maxAnalyzerOffset);
        result = 31 * result + Objects.hashCode(this.maxFragmentLength);
        result = 31 * result + Objects.hashCode(this.noMatchSize);
        result = 31 * result + Objects.hashCode(this.numberOfFragments);
        result = 31 * result + Objects.hashCode(this.options);
        result = 31 * result + Objects.hashCode(this.order);
        result = 31 * result + Objects.hashCode(this.phraseLimit);
        result = 31 * result + Objects.hashCode(this.postTags);
        result = 31 * result + Objects.hashCode(this.preTags);
        result = 31 * result + Objects.hashCode(this.requireFieldMatch);
        result = 31 * result + Objects.hashCode(this.tagsSchema);
        result = 31 * result + Objects.hashCode(this.type);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        HighlightBase other = (HighlightBase) o;
        return Objects.equals(this.boundaryChars, other.boundaryChars)
            && Objects.equals(this.boundaryMaxScan, other.boundaryMaxScan)
            && Objects.equals(this.boundaryScanner, other.boundaryScanner)
            && Objects.equals(this.boundaryScannerLocale, other.boundaryScannerLocale)
            && Objects.equals(this.forceSource, other.forceSource)
            && Objects.equals(this.fragmentOffset, other.fragmentOffset)
            && Objects.equals(this.fragmentSize, other.fragmentSize)
            && Objects.equals(this.fragmenter, other.fragmenter)
            && Objects.equals(this.highlightFilter, other.highlightFilter)
            && Objects.equals(this.highlightQuery, other.highlightQuery)
            && Objects.equals(this.maxAnalyzerOffset, other.maxAnalyzerOffset)
            && Objects.equals(this.maxFragmentLength, other.maxFragmentLength)
            && Objects.equals(this.noMatchSize, other.noMatchSize)
            && Objects.equals(this.numberOfFragments, other.numberOfFragments)
            && Objects.equals(this.options, other.options)
            && Objects.equals(this.order, other.order)
            && Objects.equals(this.phraseLimit, other.phraseLimit)
            && Objects.equals(this.postTags, other.postTags)
            && Objects.equals(this.preTags, other.preTags)
            && Objects.equals(this.requireFieldMatch, other.requireFieldMatch)
            && Objects.equals(this.tagsSchema, other.tagsSchema)
            && Objects.equals(this.type, other.type);
    }
}
