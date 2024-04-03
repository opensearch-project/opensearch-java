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

package org.opensearch.client.opensearch.core.msearch;

import jakarta.json.stream.JsonGenerator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import javax.annotation.Nullable;
import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.JsonpSerializable;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.opensearch._types.ScriptField;
import org.opensearch.client.opensearch._types.SortOptions;
import org.opensearch.client.opensearch._types.aggregations.Aggregation;
import org.opensearch.client.opensearch._types.query_dsl.FieldAndFormat;
import org.opensearch.client.opensearch._types.query_dsl.Query;
import org.opensearch.client.opensearch.core.SearchRequest.Builder;
import org.opensearch.client.opensearch.core.search.Highlight;
import org.opensearch.client.opensearch.core.search.SourceConfig;
import org.opensearch.client.opensearch.core.search.Suggester;
import org.opensearch.client.opensearch.core.search.TrackHits;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;

// typedef: _global.msearch.MultisearchBody

@JsonpDeserializable
public class MultisearchBody implements JsonpSerializable {
    private final Map<String, Aggregation> aggregations;

    @Nullable
    private final Query query;

    @Nullable
    private final Integer from;

    @Nullable
    private final Double minScore;

    @Nullable
    private final Query postFilter;

    private final List<String> searchAfter;

    @Nullable
    private final Integer size;

    private final List<SortOptions> sort;

    @Nullable
    private final Boolean trackScores;

    @Nullable
    private final TrackHits trackTotalHits;

    @Nullable
    private final Suggester suggest;

    @Nullable
    private Highlight highlight;

    @Nullable
    private SourceConfig source;

    private final Map<String, ScriptField> scriptFields;

    @Nullable
    private final Boolean seqNoPrimaryTerm;

    private final List<String> storedFields;

    @Nullable
    private final Boolean explain;

    private final List<FieldAndFormat> fields;

    private final List<Map<String, Double>> indicesBoost;

    // ---------------------------------------------------------------------------------------------

    private MultisearchBody(Builder builder) {

        this.aggregations = ApiTypeHelper.unmodifiable(builder.aggregations);
        this.query = builder.query;
        this.from = builder.from;
        this.minScore = builder.minScore;
        this.postFilter = builder.postFilter;
        this.searchAfter = ApiTypeHelper.unmodifiable(builder.searchAfter);
        this.size = builder.size;
        this.sort = ApiTypeHelper.unmodifiable(builder.sort);
        this.trackScores = builder.trackScores;
        this.trackTotalHits = builder.trackTotalHits;
        this.suggest = builder.suggest;
        this.highlight = builder.highlight;
        this.source = builder.source;
        this.scriptFields = ApiTypeHelper.unmodifiable(builder.scriptFields);
        this.seqNoPrimaryTerm = builder.seqNoPrimaryTerm;
        this.storedFields = ApiTypeHelper.unmodifiable(builder.storedFields);
        this.explain = builder.explain;
        this.fields = ApiTypeHelper.unmodifiable(builder.fields);
        this.indicesBoost = ApiTypeHelper.unmodifiable(builder.indicesBoost);
    }

    public static MultisearchBody of(Function<Builder, ObjectBuilder<MultisearchBody>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code aggregations}
     */
    public final Map<String, Aggregation> aggregations() {
        return this.aggregations;
    }

    /**
     * API name: {@code query}
     */
    @Nullable
    public final Query query() {
        return this.query;
    }

    /**
     * API name: {@code from}
     */
    @Nullable
    public final Integer from() {
        return this.from;
    }

    /**
     * API name: {@code from}
     */
    @Nullable
    public final Double minScore() {
        return this.minScore;
    }

    /**
     * API name: {@code post_filter}
     */
    @Nullable
    public final Query postFilter() {
        return this.postFilter;
    }

    /**
     * API name: {@code search_after}
     */
    public final List<String> searchAfter() {
        return this.searchAfter;
    }

    /**
     * API name: {@code size}
     */
    @Nullable
    public final Integer size() {
        return this.size;
    }

    /**
     * API name: {@code sort}
     */
    public final List<SortOptions> sort() {
        return this.sort;
    }

    /**
     * API name: {@code track_scores}
     */
    @Nullable
    public final Boolean trackScores() {
        return this.trackScores;
    }

    /**
     * API name: {@code track_total_hits}
     */
    @Nullable
    public final TrackHits trackTotalHits() {
        return this.trackTotalHits;
    }

    /**
     * API name: {@code suggest}
     */
    @Nullable
    public final Suggester suggest() {
        return this.suggest;
    }

    /**
     * API name: {@code highlight}
     */
    @Nullable
    public final Highlight highlight() {
        return this.highlight;
    }

    /**
     * API name: {@code _source}
     */
    @Nullable
    public final SourceConfig source() {
        return this.source;
    }

    public final Map<String, ScriptField> scriptFields() {
        return this.scriptFields;
    }

    /**
     * If true, returns sequence number and primary term of the last modification of
     * each hit. See Optimistic concurrency control.
     * <p>
     * API name: {@code seq_no_primary_term}
     */
    @Nullable
    public final Boolean seqNoPrimaryTerm() {
        return this.seqNoPrimaryTerm;
    }

    /**
     * List of stored fields to return as part of a hit. If no fields are specified,
     * no stored fields are included in the response. If this field is specified,
     * the _source parameter defaults to false. You can pass _source: true to return
     * both source fields and stored fields in the search response.
     * <p>
     * API name: {@code stored_fields}
     */
    public final List<String> storedFields() {
        return this.storedFields;
    }

    /**
     * If true, returns detailed information about score computation as part of a
     * hit.
     * <p>
     * API name: {@code explain}
     */
    @Nullable
    public final Boolean explain() {
        return this.explain;
    }

    /**
     * Array of wildcard (*) patterns. The request returns values for field names
     * matching these patterns in the hits.fields property of the response.
     * <p>
     * API name: {@code fields}
     */
    public final List<FieldAndFormat> fields() {
        return this.fields;
    }

    /**
     * Boosts the _score of documents from specified indices.
     * <p>
     * API name: {@code indices_boost}
     */
    public final List<Map<String, Double>> indicesBoost() {
        return this.indicesBoost;
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

        if (ApiTypeHelper.isDefined(this.aggregations)) {
            generator.writeKey("aggregations");
            generator.writeStartObject();
            for (Map.Entry<String, Aggregation> item0 : this.aggregations.entrySet()) {
                generator.writeKey(item0.getKey());
                item0.getValue().serialize(generator, mapper);

            }
            generator.writeEnd();

        }
        if (this.query != null) {
            generator.writeKey("query");
            this.query.serialize(generator, mapper);

        }
        if (this.from != null) {
            generator.writeKey("from");
            generator.write(this.from);

        }
        if (this.minScore != null) {
            generator.writeKey("min_score");
            generator.write(this.minScore);

        }
        if (this.postFilter != null) {
            generator.writeKey("post_filter");
            this.postFilter.serialize(generator, mapper);

        }
        if (ApiTypeHelper.isDefined(this.searchAfter)) {
            generator.writeKey("search_after");
            generator.writeStartArray();
            for (String item0 : this.searchAfter) {
                generator.write(item0);

            }
            generator.writeEnd();

        }
        if (this.size != null) {
            generator.writeKey("size");
            generator.write(this.size);

        }
        if (ApiTypeHelper.isDefined(this.sort)) {
            generator.writeKey("sort");
            generator.writeStartArray();
            for (SortOptions item0 : this.sort) {
                item0.serialize(generator, mapper);

            }
            generator.writeEnd();

        }
        if (this.trackScores != null) {
            generator.writeKey("track_scores");
            generator.write(this.trackScores);

        }
        if (this.trackTotalHits != null) {
            generator.writeKey("track_total_hits");
            this.trackTotalHits.serialize(generator, mapper);

        }
        if (this.suggest != null) {
            generator.writeKey("suggest");
            this.suggest.serialize(generator, mapper);

        }

        if (this.highlight != null) {
            generator.writeKey("highlight");
            this.highlight.serialize(generator, mapper);

        }

        if (this.source != null) {
            generator.writeKey("_source");
            this.source.serialize(generator, mapper);

        }

        if (ApiTypeHelper.isDefined(this.scriptFields)) {
            generator.writeKey("script_fields");
            generator.writeStartObject();
            for (Map.Entry<String, ScriptField> item0 : this.scriptFields.entrySet()) {
                generator.writeKey(item0.getKey());
                item0.getValue().serialize(generator, mapper);

            }
            generator.writeEnd();

        }

        if (this.seqNoPrimaryTerm != null) {
            generator.writeKey("seq_no_primary_term");
            generator.write(this.seqNoPrimaryTerm);
        }

        if (ApiTypeHelper.isDefined(this.storedFields)) {
            generator.writeKey("stored_fields");
            generator.writeStartArray();
            for (String item0 : this.storedFields) {
                generator.write(item0);

            }
            generator.writeEnd();
        }

        if (this.explain != null) {
            generator.writeKey("explain");
            generator.write(this.explain);

        }

        if (ApiTypeHelper.isDefined(this.fields)) {
            generator.writeKey("fields");
            generator.writeStartArray();
            for (FieldAndFormat item0 : this.fields) {
                item0.serialize(generator, mapper);

            }
            generator.writeEnd();
        }

        if (ApiTypeHelper.isDefined(this.indicesBoost)) {
            generator.writeKey("indices_boost");
            generator.writeStartArray();
            for (Map<String, Double> item0 : this.indicesBoost) {
                generator.writeStartObject();
                if (item0 != null) {
                    for (Map.Entry<String, Double> item1 : item0.entrySet()) {
                        generator.writeKey(item1.getKey());
                        generator.write(item1.getValue());

                    }
                }
                generator.writeEnd();

            }
            generator.writeEnd();
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Builder for {@link MultisearchBody}.
     */

    public static class Builder extends ObjectBuilderBase implements ObjectBuilder<MultisearchBody> {
        @Nullable
        private Map<String, Aggregation> aggregations;

        @Nullable
        private Query query;

        @Nullable
        private Integer from;

        @Nullable
        private Double minScore;

        @Nullable
        private Query postFilter;

        @Nullable
        private List<String> searchAfter;

        @Nullable
        private Integer size;

        @Nullable
        private List<SortOptions> sort;

        @Nullable
        private Boolean trackScores;

        @Nullable
        private TrackHits trackTotalHits;

        @Nullable
        private Suggester suggest;

        @Nullable
        private Highlight highlight;

        @Nullable
        private SourceConfig source;

        private Map<String, ScriptField> scriptFields;

        @Nullable
        private Boolean seqNoPrimaryTerm;

        @Nullable
        private List<String> storedFields;

        @Nullable
        private Boolean explain;

        @Nullable
        private List<FieldAndFormat> fields;

        @Nullable
        private List<Map<String, Double>> indicesBoost;

        /**
         * API name: {@code aggregations}
         * <p>
         * Adds all entries of <code>map</code> to <code>aggregations</code>.
         */
        public final Builder aggregations(Map<String, Aggregation> map) {
            this.aggregations = _mapPutAll(this.aggregations, map);
            return this;
        }

        /**
         * API name: {@code aggregations}
         * <p>
         * Adds an entry to <code>aggregations</code>.
         */
        public final Builder aggregations(String key, Aggregation value) {
            this.aggregations = _mapPut(this.aggregations, key, value);
            return this;
        }

        /**
         * API name: {@code aggregations}
         * <p>
         * Adds an entry to <code>aggregations</code> using a builder lambda.
         */
        public final Builder aggregations(String key, Function<Aggregation.Builder, ObjectBuilder<Aggregation>> fn) {
            return aggregations(key, fn.apply(new Aggregation.Builder()).build());
        }

        /**
         * API name: {@code query}
         */
        public final Builder query(@Nullable Query value) {
            this.query = value;
            return this;
        }

        /**
         * API name: {@code query}
         */
        public final Builder query(Function<Query.Builder, ObjectBuilder<Query>> fn) {
            return this.query(fn.apply(new Query.Builder()).build());
        }

        /**
         * API name: {@code from}
         */
        public final Builder from(@Nullable Integer value) {
            this.from = value;
            return this;
        }

        /**
         * Minimum _score for matching documents. Documents with a lower _score are not
         * included in the search results.
         * <p>
         * API name: {@code min_score}
         */
        public final Builder minScore(@Nullable Double value) {
            this.minScore = value;
            return this;
        }

        /**
         * API name: {@code post_filter}
         */
        public final Builder postFilter(@Nullable Query value) {
            this.postFilter = value;
            return this;
        }

        /**
         * API name: {@code post_filter}
         */
        public final Builder postFilter(Function<Query.Builder, ObjectBuilder<Query>> fn) {
            return this.postFilter(fn.apply(new Query.Builder()).build());
        }

        /**
         * API name: {@code search_after}
         * <p>
         * Adds all elements of <code>list</code> to <code>searchAfter</code>.
         */
        public final Builder searchAfter(List<String> list) {
            this.searchAfter = _listAddAll(this.searchAfter, list);
            return this;
        }

        /**
         * API name: {@code search_after}
         * <p>
         * Adds one or more values to <code>searchAfter</code>.
         */
        public final Builder searchAfter(String value, String... values) {
            this.searchAfter = _listAdd(this.searchAfter, value, values);
            return this;
        }

        /**
         * API name: {@code size}
         */
        public final Builder size(@Nullable Integer value) {
            this.size = value;
            return this;
        }

        /**
         * API name: {@code sort}
         * <p>
         * Adds all elements of <code>list</code> to <code>sort</code>.
         */
        public final Builder sort(List<SortOptions> list) {
            this.sort = _listAddAll(this.sort, list);
            return this;
        }

        /**
         * API name: {@code sort}
         * <p>
         * Adds one or more values to <code>sort</code>.
         */
        public final Builder sort(SortOptions value, SortOptions... values) {
            this.sort = _listAdd(this.sort, value, values);
            return this;
        }

        /**
         * API name: {@code sort}
         * <p>
         * Adds a value to <code>sort</code> using a builder lambda.
         */
        public final Builder sort(Function<SortOptions.Builder, ObjectBuilder<SortOptions>> fn) {
            return sort(fn.apply(new SortOptions.Builder()).build());
        }

        /**
         * If true, calculate and return document scores, even if the scores are not
         * used for sorting.
         * <p>
         * API name: {@code track_scores}
         */
        public final Builder trackScores(@Nullable Boolean value) {
            this.trackScores = value;
            return this;
        }

        /**
         * API name: {@code track_total_hits}
         */
        public final Builder trackTotalHits(@Nullable TrackHits value) {
            this.trackTotalHits = value;
            return this;
        }

        /**
         * API name: {@code track_total_hits}
         */
        public final Builder trackTotalHits(Function<TrackHits.Builder, ObjectBuilder<TrackHits>> fn) {
            return this.trackTotalHits(fn.apply(new TrackHits.Builder()).build());
        }

        /**
         * API name: {@code suggest}
         */
        public final Builder suggest(@Nullable Suggester value) {
            this.suggest = value;
            return this;
        }

        /**
         * API name: {@code suggest}
         */
        public final Builder suggest(Function<Suggester.Builder, ObjectBuilder<Suggester>> fn) {
            return this.suggest(fn.apply(new Suggester.Builder()).build());
        }

        /**
         * API name: {@code highlight}
         */
        public final Builder highlight(@Nullable Highlight value) {
            this.highlight = value;
            return this;
        }

        /**
         * API name: {@code highlight}
         */
        public final Builder highlight(Function<Highlight.Builder, ObjectBuilder<Highlight>> fn) {
            return this.highlight(fn.apply(new Highlight.Builder()).build());
        }

        /**
         * API name: {@code _source}
         */
        public final Builder source(@Nullable SourceConfig value) {
            this.source = value;
            return this;
        }

        /**
         * API name: {@code _source}
         */
        public final Builder source(Function<SourceConfig.Builder, ObjectBuilder<SourceConfig>> fn) {
            return this.source(fn.apply(new SourceConfig.Builder()).build());
        }

        /**
         * API name: {@code script_fields}
         */
        public final Builder scriptFields(Map<String, ScriptField> map) {
            this.scriptFields = _mapPutAll(this.scriptFields, map);
            return this;
        }

        /**
         * API name: {@code script_fields}
         */
        public final Builder scriptFields(String key, ScriptField value) {
            this.scriptFields = _mapPut(this.scriptFields, key, value);
            return this;
        }

        /**
         * API name: {@code script_fields}
         */
        public final Builder scriptFields(String key, Function<ScriptField.Builder, ObjectBuilder<ScriptField>> fn) {
            return scriptFields(key, fn.apply(new ScriptField.Builder()).build());
        }

        /**
         * If true, returns sequence number and primary term of the last modification of
         * each hit. See Optimistic concurrency control.
         * <p>
         * API name: {@code seq_no_primary_term}
         */
        public final Builder seqNoPrimaryTerm(@Nullable Boolean value) {
            this.seqNoPrimaryTerm = value;
            return this;
        }

        /**
         * List of stored fields to return as part of a hit. If no fields are specified,
         * no stored fields are included in the response. If this field is specified,
         * the _source parameter defaults to false. You can pass _source: true to return
         * both source fields and stored fields in the search response.
         * <p>
         * API name: {@code stored_fields}
         * <p>
         * Adds all elements of <code>list</code> to <code>storedFields</code>.
         */
        public final Builder storedFields(List<String> list) {
            this.storedFields = _listAddAll(this.storedFields, list);
            return this;
        }

        /**
         * List of stored fields to return as part of a hit. If no fields are specified,
         * no stored fields are included in the response. If this field is specified,
         * the _source parameter defaults to false. You can pass _source: true to return
         * both source fields and stored fields in the search response.
         * <p>
         * API name: {@code stored_fields}
         * <p>
         * Adds one or more values to <code>storedFields</code>.
         */
        public final Builder storedFields(String value, String... values) {
            this.storedFields = _listAdd(this.storedFields, value, values);
            return this;
        }

        /**
         * If true, returns detailed information about score computation as part of a
         * hit.
         * <p>
         * API name: {@code explain}
         */
        public final Builder explain(@Nullable Boolean value) {
            this.explain = value;
            return this;
        }

        /**
         * Array of wildcard (*) patterns. The request returns values for field names
         * matching these patterns in the hits.fields property of the response.
         * <p>
         * API name: {@code fields}
         * <p>
         * Adds all elements of <code>list</code> to <code>fields</code>.
         */
        public final Builder fields(List<FieldAndFormat> list) {
            this.fields = _listAddAll(this.fields, list);
            return this;
        }

        /**
         * Array of wildcard (*) patterns. The request returns values for field names
         * matching these patterns in the hits.fields property of the response.
         * <p>
         * API name: {@code fields}
         * <p>
         * Adds one or more values to <code>fields</code>.
         */
        public final Builder fields(FieldAndFormat value, FieldAndFormat... values) {
            this.fields = _listAdd(this.fields, value, values);
            return this;
        }

        /**
         * Array of wildcard (*) patterns. The request returns values for field names
         * matching these patterns in the hits.fields property of the response.
         * <p>
         * API name: {@code fields}
         * <p>
         * Adds a value to <code>fields</code> using a builder lambda.
         */
        public final Builder fields(Function<FieldAndFormat.Builder, ObjectBuilder<FieldAndFormat>> fn) {
            return fields(fn.apply(new FieldAndFormat.Builder()).build());
        }

        /**
         * Boosts the _score of documents from specified indices.
         * <p>
         * API name: {@code indices_boost}
         * <p>
         * Adds all elements of <code>list</code> to <code>indicesBoost</code>.
         */
        public final Builder indicesBoost(List<Map<String, Double>> list) {
            this.indicesBoost = _listAddAll(this.indicesBoost, list);
            return this;
        }

        /**
         * Boosts the _score of documents from specified indices.
         * <p>
         * API name: {@code indices_boost}
         * <p>
         * Adds one or more values to <code>indicesBoost</code>.
         */
        public final Builder indicesBoost(Map<String, Double> value, Map<String, Double>... values) {
            this.indicesBoost = _listAdd(this.indicesBoost, value, values);
            return this;
        }

        /**
         * Builds a {@link MultisearchBody}.
         *
         * @throws NullPointerException
         *             if some of the required fields are null.
         */
        public MultisearchBody build() {
            _checkSingleUse();

            return new MultisearchBody(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link MultisearchBody}
     */
    public static final JsonpDeserializer<MultisearchBody> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        MultisearchBody::setupMultisearchBodyDeserializer
    );

    protected static void setupMultisearchBodyDeserializer(ObjectDeserializer<MultisearchBody.Builder> op) {

        op.add(Builder::aggregations, JsonpDeserializer.stringMapDeserializer(Aggregation._DESERIALIZER), "aggregations", "aggs");
        op.add(Builder::query, Query._DESERIALIZER, "query");
        op.add(Builder::from, JsonpDeserializer.integerDeserializer(), "from");
        op.add(Builder::minScore, JsonpDeserializer.doubleDeserializer(), "min_score");
        op.add(Builder::postFilter, Query._DESERIALIZER, "post_filter");
        op.add(Builder::searchAfter, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "search_after");
        op.add(Builder::size, JsonpDeserializer.integerDeserializer(), "size");
        op.add(Builder::sort, JsonpDeserializer.arrayDeserializer(SortOptions._DESERIALIZER), "sort");
        op.add(Builder::trackScores, JsonpDeserializer.booleanDeserializer(), "track_scores");
        op.add(Builder::trackTotalHits, TrackHits._DESERIALIZER, "track_total_hits");
        op.add(Builder::suggest, Suggester._DESERIALIZER, "suggest");
        op.add(Builder::highlight, Highlight._DESERIALIZER, "highlight");
        op.add(Builder::source, SourceConfig._DESERIALIZER, "_source");
        op.add(Builder::scriptFields, JsonpDeserializer.stringMapDeserializer(ScriptField._DESERIALIZER), "script_fields");
        op.add(Builder::seqNoPrimaryTerm, JsonpDeserializer.booleanDeserializer(), "seq_no_primary_term");
        op.add(Builder::storedFields, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "stored_fields");
        op.add(Builder::explain, JsonpDeserializer.booleanDeserializer(), "explain");
        op.add(Builder::fields, JsonpDeserializer.arrayDeserializer(FieldAndFormat._DESERIALIZER), "fields");
        op.add(
            Builder::indicesBoost,
            JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringMapDeserializer(JsonpDeserializer.doubleDeserializer())),
            "indices_boost"
        );
    }

}
