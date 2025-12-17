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
import java.util.HashMap;
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
import org.opensearch.client.json.JsonpSerializer;
import org.opensearch.client.json.JsonpUtils;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.json.PlainJsonSerializable;
import org.opensearch.client.opensearch._types.FieldValue;
import org.opensearch.client.opensearch.core.explain.Explanation;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: core.search.Hit

@Generated("org.opensearch.client.codegen.CodeGenerator")
public class Hit<TDocument> implements PlainJsonSerializable, ToCopyableBuilder<Hit.Builder<TDocument>, Hit<TDocument>> {

    @Nullable
    private final Explanation explanation;

    @Nonnull
    private final Map<String, JsonData> fields;

    @Nonnull
    private final Map<String, List<String>> highlight;

    @Nullable
    private final String id;

    @Nonnull
    private final List<String> ignored;

    @Nonnull
    private final Map<String, List<String>> ignoredFieldValues;

    @Nullable
    private final String index;

    @Nonnull
    private final Map<String, InnerHitsResult> innerHits;

    @Nonnull
    private final List<String> matchedQueries;

    @Nonnull
    private final Map<String, JsonData> metaFields;

    @Nullable
    private final NestedIdentity nested;

    @Nullable
    private final String node;

    @Nullable
    private final Long primaryTerm;

    @Nullable
    private final String routing;

    @Nullable
    private final Double score;

    @Nullable
    private final Long seqNo;

    @Nullable
    private final String shard;

    @Nonnull
    private final List<FieldValue> sort;

    @Nullable
    private final TDocument source;

    @Nullable
    private final JsonpSerializer<TDocument> tDocumentSerializer;

    @Nullable
    private final Long version;

    // ---------------------------------------------------------------------------------------------

    private Hit(Builder<TDocument> builder) {
        this.explanation = builder.explanation;
        this.fields = ApiTypeHelper.unmodifiable(builder.fields);
        this.highlight = ApiTypeHelper.unmodifiable(builder.highlight);
        this.id = builder.id;
        this.ignored = ApiTypeHelper.unmodifiable(builder.ignored);
        this.ignoredFieldValues = ApiTypeHelper.unmodifiable(builder.ignoredFieldValues);
        this.index = builder.index;
        this.innerHits = ApiTypeHelper.unmodifiable(builder.innerHits);
        this.matchedQueries = ApiTypeHelper.unmodifiable(builder.matchedQueries);
        this.metaFields = ApiTypeHelper.unmodifiable(builder.metaFields);
        this.nested = builder.nested;
        this.node = builder.node;
        this.primaryTerm = builder.primaryTerm;
        this.routing = builder.routing;
        this.score = builder.score;
        this.seqNo = builder.seqNo;
        this.shard = builder.shard;
        this.sort = ApiTypeHelper.unmodifiable(builder.sort);
        this.source = builder.source;
        this.tDocumentSerializer = builder.tDocumentSerializer;
        this.version = builder.version;
    }

    public static <TDocument> Hit<TDocument> of(Function<Hit.Builder<TDocument>, ObjectBuilder<Hit<TDocument>>> fn) {
        return fn.apply(new Builder<>()).build();
    }

    /**
     * API name: {@code _explanation}
     */
    @Nullable
    public final Explanation explanation() {
        return this.explanation;
    }

    /**
     * API name: {@code fields}
     */
    @Nonnull
    public final Map<String, JsonData> fields() {
        return this.fields;
    }

    /**
     * API name: {@code highlight}
     */
    @Nonnull
    public final Map<String, List<String>> highlight() {
        return this.highlight;
    }

    /**
     * API name: {@code _id}
     */
    @Nullable
    public final String id() {
        return this.id;
    }

    /**
     * API name: {@code _ignored}
     */
    @Nonnull
    public final List<String> ignored() {
        return this.ignored;
    }

    /**
     * API name: {@code ignored_field_values}
     */
    @Nonnull
    public final Map<String, List<String>> ignoredFieldValues() {
        return this.ignoredFieldValues;
    }

    /**
     * API name: {@code _index}
     */
    @Nullable
    public final String index() {
        return this.index;
    }

    /**
     * API name: {@code inner_hits}
     */
    @Nonnull
    public final Map<String, InnerHitsResult> innerHits() {
        return this.innerHits;
    }

    /**
     * API name: {@code matched_queries}
     */
    @Nonnull
    public final List<String> matchedQueries() {
        return this.matchedQueries;
    }

    /**
     * Contains metadata values for the documents.
     */
    @Nonnull
    public final Map<String, JsonData> metaFields() {
        return this.metaFields;
    }

    /**
     * API name: {@code _nested}
     */
    @Nullable
    public final NestedIdentity nested() {
        return this.nested;
    }

    /**
     * API name: {@code _node}
     */
    @Nullable
    public final String node() {
        return this.node;
    }

    /**
     * API name: {@code _primary_term}
     */
    @Nullable
    public final Long primaryTerm() {
        return this.primaryTerm;
    }

    /**
     * API name: {@code _routing}
     */
    @Nullable
    public final String routing() {
        return this.routing;
    }

    /**
     * API name: {@code _score}
     */
    @Nullable
    public final Double score() {
        return this.score;
    }

    /**
     * API name: {@code _seq_no}
     */
    @Nullable
    public final Long seqNo() {
        return this.seqNo;
    }

    /**
     * API name: {@code _shard}
     */
    @Nullable
    public final String shard() {
        return this.shard;
    }

    /**
     * API name: {@code sort}
     */
    @Nonnull
    public final List<FieldValue> sort() {
        return this.sort;
    }

    /**
     * API name: {@code _source}
     */
    @Nullable
    public final TDocument source() {
        return this.source;
    }

    /**
     * Serializer for {@code TDocument}. If not set, an attempt will be made to find a serializer from the JSON context.
     */
    @Nullable
    public final JsonpSerializer<TDocument> tDocumentSerializer() {
        return this.tDocumentSerializer;
    }

    /**
     * API name: {@code _version}
     */
    @Nullable
    public final Long version() {
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
        for (Map.Entry<String, JsonData> item0 : this.metaFields.entrySet()) {
            generator.writeKey(item0.getKey());
            item0.getValue().serialize(generator, mapper);
        }
        if (this.explanation != null) {
            generator.writeKey("_explanation");
            this.explanation.serialize(generator, mapper);
        }

        if (ApiTypeHelper.isDefined(this.fields)) {
            generator.writeKey("fields");
            generator.writeStartObject();
            for (Map.Entry<String, JsonData> item0 : this.fields.entrySet()) {
                generator.writeKey(item0.getKey());
                item0.getValue().serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (ApiTypeHelper.isDefined(this.highlight)) {
            generator.writeKey("highlight");
            generator.writeStartObject();
            for (Map.Entry<String, List<String>> item0 : this.highlight.entrySet()) {
                generator.writeKey(item0.getKey());
                generator.writeStartArray();
                if (item0.getValue() != null) {
                    for (String item1 : item0.getValue()) {
                        generator.write(item1);
                    }
                }
                generator.writeEnd();
            }
            generator.writeEnd();
        }

        if (this.id != null) {
            generator.writeKey("_id");
            generator.write(this.id);
        }

        if (ApiTypeHelper.isDefined(this.ignored)) {
            generator.writeKey("_ignored");
            generator.writeStartArray();
            for (String item0 : this.ignored) {
                generator.write(item0);
            }
            generator.writeEnd();
        }

        if (ApiTypeHelper.isDefined(this.ignoredFieldValues)) {
            generator.writeKey("ignored_field_values");
            generator.writeStartObject();
            for (Map.Entry<String, List<String>> item0 : this.ignoredFieldValues.entrySet()) {
                generator.writeKey(item0.getKey());
                generator.writeStartArray();
                if (item0.getValue() != null) {
                    for (String item1 : item0.getValue()) {
                        generator.write(item1);
                    }
                }
                generator.writeEnd();
            }
            generator.writeEnd();
        }

        if (this.index != null) {
            generator.writeKey("_index");
            generator.write(this.index);
        }

        if (ApiTypeHelper.isDefined(this.innerHits)) {
            generator.writeKey("inner_hits");
            generator.writeStartObject();
            for (Map.Entry<String, InnerHitsResult> item0 : this.innerHits.entrySet()) {
                generator.writeKey(item0.getKey());
                item0.getValue().serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (ApiTypeHelper.isDefined(this.matchedQueries)) {
            generator.writeKey("matched_queries");
            generator.writeStartArray();
            for (String item0 : this.matchedQueries) {
                generator.write(item0);
            }
            generator.writeEnd();
        }

        if (this.nested != null) {
            generator.writeKey("_nested");
            this.nested.serialize(generator, mapper);
        }

        if (this.node != null) {
            generator.writeKey("_node");
            generator.write(this.node);
        }

        if (this.primaryTerm != null) {
            generator.writeKey("_primary_term");
            generator.write(this.primaryTerm);
        }

        if (this.routing != null) {
            generator.writeKey("_routing");
            generator.write(this.routing);
        }

        if (this.score != null) {
            generator.writeKey("_score");
            generator.write(this.score);
        }

        if (this.seqNo != null) {
            generator.writeKey("_seq_no");
            generator.write(this.seqNo);
        }

        if (this.shard != null) {
            generator.writeKey("_shard");
            generator.write(this.shard);
        }

        if (ApiTypeHelper.isDefined(this.sort)) {
            generator.writeKey("sort");
            generator.writeStartArray();
            for (FieldValue item0 : this.sort) {
                item0.serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (this.source != null) {
            generator.writeKey("_source");
            JsonpUtils.serialize(this.source, generator, tDocumentSerializer, mapper);
        }

        if (this.version != null) {
            generator.writeKey("_version");
            generator.write(this.version);
        }
    }

    // ---------------------------------------------------------------------------------------------

    @Override
    @Nonnull
    public Builder<TDocument> toBuilder() {
        return new Builder<>(this);
    }

    @Nonnull
    public static <TDocument> Builder builder() {
        return new Builder<>();
    }

    /**
     * Builder for {@link Hit}.
     */
    public static class Builder<TDocument> extends ObjectBuilderBase implements CopyableBuilder<Builder<TDocument>, Hit<TDocument>> {
        @Nullable
        private Explanation explanation;
        @Nullable
        private Map<String, JsonData> fields;
        @Nullable
        private Map<String, List<String>> highlight;
        @Nullable
        private String id;
        @Nullable
        private List<String> ignored;
        @Nullable
        private Map<String, List<String>> ignoredFieldValues;
        @Nullable
        private String index;
        @Nullable
        private Map<String, InnerHitsResult> innerHits;
        @Nullable
        private List<String> matchedQueries;
        @Nullable
        private Map<String, JsonData> metaFields;
        @Nullable
        private NestedIdentity nested;
        @Nullable
        private String node;
        @Nullable
        private Long primaryTerm;
        @Nullable
        private String routing;
        @Nullable
        private Double score;
        @Nullable
        private Long seqNo;
        @Nullable
        private String shard;
        @Nullable
        private List<FieldValue> sort;
        @Nullable
        private TDocument source;
        @Nullable
        private JsonpSerializer<TDocument> tDocumentSerializer;
        @Nullable
        private Long version;

        public Builder() {}

        private Builder(Hit<TDocument> o) {
            this.explanation = o.explanation;
            this.fields = _mapCopy(o.fields);
            this.highlight = _mapCopy(o.highlight);
            this.id = o.id;
            this.ignored = _listCopy(o.ignored);
            this.ignoredFieldValues = _mapCopy(o.ignoredFieldValues);
            this.index = o.index;
            this.innerHits = _mapCopy(o.innerHits);
            this.matchedQueries = _listCopy(o.matchedQueries);
            this.metaFields = _mapCopy(o.metaFields);
            this.nested = o.nested;
            this.node = o.node;
            this.primaryTerm = o.primaryTerm;
            this.routing = o.routing;
            this.score = o.score;
            this.seqNo = o.seqNo;
            this.shard = o.shard;
            this.sort = _listCopy(o.sort);
            this.source = o.source;
            this.tDocumentSerializer = o.tDocumentSerializer;
            this.version = o.version;
        }

        private Builder(Builder<TDocument> o) {
            this.explanation = o.explanation;
            this.fields = _mapCopy(o.fields);
            this.highlight = _mapCopy(o.highlight);
            this.id = o.id;
            this.ignored = _listCopy(o.ignored);
            this.ignoredFieldValues = _mapCopy(o.ignoredFieldValues);
            this.index = o.index;
            this.innerHits = _mapCopy(o.innerHits);
            this.matchedQueries = _listCopy(o.matchedQueries);
            this.metaFields = _mapCopy(o.metaFields);
            this.nested = o.nested;
            this.node = o.node;
            this.primaryTerm = o.primaryTerm;
            this.routing = o.routing;
            this.score = o.score;
            this.seqNo = o.seqNo;
            this.shard = o.shard;
            this.sort = _listCopy(o.sort);
            this.source = o.source;
            this.tDocumentSerializer = o.tDocumentSerializer;
            this.version = o.version;
        }

        @Override
        @Nonnull
        public Builder<TDocument> copy() {
            return new Builder<>(this);
        }

        /**
         * API name: {@code _explanation}
         */
        @Nonnull
        public final Builder<TDocument> explanation(@Nullable Explanation value) {
            this.explanation = value;
            return this;
        }

        /**
         * API name: {@code _explanation}
         */
        @Nonnull
        public final Builder<TDocument> explanation(Function<Explanation.Builder, ObjectBuilder<Explanation>> fn) {
            return explanation(fn.apply(new Explanation.Builder()).build());
        }

        /**
         * API name: {@code fields}
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>fields</code>.
         * </p>
         */
        @Nonnull
        public final Builder<TDocument> fields(Map<String, JsonData> map) {
            this.fields = _mapPutAll(this.fields, map);
            return this;
        }

        /**
         * API name: {@code fields}
         *
         * <p>
         * Adds an entry to <code>fields</code>.
         * </p>
         */
        @Nonnull
        public final Builder<TDocument> fields(String key, JsonData value) {
            this.fields = _mapPut(this.fields, key, value);
            return this;
        }

        /**
         * API name: {@code highlight}
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>highlight</code>.
         * </p>
         */
        @Nonnull
        public final Builder<TDocument> highlight(Map<String, List<String>> map) {
            this.highlight = _mapPutAll(this.highlight, map);
            return this;
        }

        /**
         * API name: {@code highlight}
         *
         * <p>
         * Adds an entry to <code>highlight</code>.
         * </p>
         */
        @Nonnull
        public final Builder<TDocument> highlight(String key, List<String> value) {
            this.highlight = _mapPut(this.highlight, key, value);
            return this;
        }

        /**
         * API name: {@code _id}
         */
        @Nonnull
        public final Builder<TDocument> id(@Nullable String value) {
            this.id = value;
            return this;
        }

        /**
         * API name: {@code _ignored}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>ignored</code>.
         * </p>
         */
        @Nonnull
        public final Builder<TDocument> ignored(List<String> list) {
            this.ignored = _listAddAll(this.ignored, list);
            return this;
        }

        /**
         * API name: {@code _ignored}
         *
         * <p>
         * Adds one or more values to <code>ignored</code>.
         * </p>
         */
        @Nonnull
        public final Builder<TDocument> ignored(String value, String... values) {
            this.ignored = _listAdd(this.ignored, value, values);
            return this;
        }

        /**
         * API name: {@code ignored_field_values}
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>ignoredFieldValues</code>.
         * </p>
         */
        @Nonnull
        public final Builder<TDocument> ignoredFieldValues(Map<String, List<String>> map) {
            this.ignoredFieldValues = _mapPutAll(this.ignoredFieldValues, map);
            return this;
        }

        /**
         * API name: {@code ignored_field_values}
         *
         * <p>
         * Adds an entry to <code>ignoredFieldValues</code>.
         * </p>
         */
        @Nonnull
        public final Builder<TDocument> ignoredFieldValues(String key, List<String> value) {
            this.ignoredFieldValues = _mapPut(this.ignoredFieldValues, key, value);
            return this;
        }

        /**
         * API name: {@code _index}
         */
        @Nonnull
        public final Builder<TDocument> index(@Nullable String value) {
            this.index = value;
            return this;
        }

        /**
         * API name: {@code inner_hits}
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>innerHits</code>.
         * </p>
         */
        @Nonnull
        public final Builder<TDocument> innerHits(Map<String, InnerHitsResult> map) {
            this.innerHits = _mapPutAll(this.innerHits, map);
            return this;
        }

        /**
         * API name: {@code inner_hits}
         *
         * <p>
         * Adds an entry to <code>innerHits</code>.
         * </p>
         */
        @Nonnull
        public final Builder<TDocument> innerHits(String key, InnerHitsResult value) {
            this.innerHits = _mapPut(this.innerHits, key, value);
            return this;
        }

        /**
         * API name: {@code inner_hits}
         *
         * <p>
         * Adds a value to <code>innerHits</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder<TDocument> innerHits(String key, Function<InnerHitsResult.Builder, ObjectBuilder<InnerHitsResult>> fn) {
            return innerHits(key, fn.apply(new InnerHitsResult.Builder()).build());
        }

        /**
         * API name: {@code matched_queries}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>matchedQueries</code>.
         * </p>
         */
        @Nonnull
        public final Builder<TDocument> matchedQueries(List<String> list) {
            this.matchedQueries = _listAddAll(this.matchedQueries, list);
            return this;
        }

        /**
         * API name: {@code matched_queries}
         *
         * <p>
         * Adds one or more values to <code>matchedQueries</code>.
         * </p>
         */
        @Nonnull
        public final Builder<TDocument> matchedQueries(String value, String... values) {
            this.matchedQueries = _listAdd(this.matchedQueries, value, values);
            return this;
        }

        /**
         * Contains metadata values for the documents.
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>metaFields</code>.
         * </p>
         */
        @Nonnull
        public final Builder<TDocument> metaFields(Map<String, JsonData> map) {
            this.metaFields = _mapPutAll(this.metaFields, map);
            return this;
        }

        /**
         * Contains metadata values for the documents.
         *
         * <p>
         * Adds an entry to <code>metaFields</code>.
         * </p>
         */
        @Nonnull
        public final Builder<TDocument> metaFields(String key, JsonData value) {
            this.metaFields = _mapPut(this.metaFields, key, value);
            return this;
        }

        /**
         * API name: {@code _nested}
         */
        @Nonnull
        public final Builder<TDocument> nested(@Nullable NestedIdentity value) {
            this.nested = value;
            return this;
        }

        /**
         * API name: {@code _nested}
         */
        @Nonnull
        public final Builder<TDocument> nested(Function<NestedIdentity.Builder, ObjectBuilder<NestedIdentity>> fn) {
            return nested(fn.apply(new NestedIdentity.Builder()).build());
        }

        /**
         * API name: {@code _node}
         */
        @Nonnull
        public final Builder<TDocument> node(@Nullable String value) {
            this.node = value;
            return this;
        }

        /**
         * API name: {@code _primary_term}
         */
        @Nonnull
        public final Builder<TDocument> primaryTerm(@Nullable Long value) {
            this.primaryTerm = value;
            return this;
        }

        /**
         * API name: {@code _routing}
         */
        @Nonnull
        public final Builder<TDocument> routing(@Nullable String value) {
            this.routing = value;
            return this;
        }

        /**
         * API name: {@code _score}
         */
        @Nonnull
        public final Builder<TDocument> score(@Nullable Double value) {
            this.score = value;
            return this;
        }

        /**
         * API name: {@code _seq_no}
         */
        @Nonnull
        public final Builder<TDocument> seqNo(@Nullable Long value) {
            this.seqNo = value;
            return this;
        }

        /**
         * API name: {@code _shard}
         */
        @Nonnull
        public final Builder<TDocument> shard(@Nullable String value) {
            this.shard = value;
            return this;
        }

        /**
         * API name: {@code sort}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>sort</code>.
         * </p>
         */
        @Nonnull
        public final Builder<TDocument> sort(List<FieldValue> list) {
            this.sort = _listAddAll(this.sort, list);
            return this;
        }

        /**
         * API name: {@code sort}
         *
         * <p>
         * Adds one or more values to <code>sort</code>.
         * </p>
         */
        @Nonnull
        public final Builder<TDocument> sort(FieldValue value, FieldValue... values) {
            this.sort = _listAdd(this.sort, value, values);
            return this;
        }

        /**
         * API name: {@code sort}
         *
         * <p>
         * Adds a value to <code>sort</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder<TDocument> sort(Function<FieldValue.Builder, ObjectBuilder<FieldValue>> fn) {
            return sort(fn.apply(new FieldValue.Builder()).build());
        }

        /**
         * API name: {@code _source}
         */
        @Nonnull
        public final Builder<TDocument> source(@Nullable TDocument value) {
            this.source = value;
            return this;
        }

        /**
         * Serializer for {@code TDocument}. If not set, an attempt will be made to find a serializer from the JSON context.
         */
        @Nonnull
        public final Builder<TDocument> tDocumentSerializer(@Nullable JsonpSerializer<TDocument> value) {
            this.tDocumentSerializer = value;
            return this;
        }

        /**
         * API name: {@code _version}
         */
        @Nonnull
        public final Builder<TDocument> version(@Nullable Long value) {
            this.version = value;
            return this;
        }

        /**
         * Builds a {@link Hit}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public Hit<TDocument> build() {
            _checkSingleUse();

            return new Hit<>(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Create a JSON deserializer for Hit.
     */
    public static <TDocument> JsonpDeserializer<Hit<TDocument>> createHitDeserializer(JsonpDeserializer<TDocument> tDocumentDeserializer) {
        return ObjectBuilderDeserializer.createForObject(
            Builder<TDocument>::new,
            op -> Hit.setupHitDeserializer(op, tDocumentDeserializer)
        );
    }

    protected static <TDocument> void setupHitDeserializer(
        ObjectDeserializer<Hit.Builder<TDocument>> op,
        JsonpDeserializer<TDocument> tDocumentDeserializer
    ) {
        op.add(Builder::explanation, Explanation._DESERIALIZER, "_explanation");
        op.add(Builder::fields, JsonpDeserializer.stringMapDeserializer(JsonData._DESERIALIZER), "fields");
        op.add(
            Builder::highlight,
            JsonpDeserializer.stringMapDeserializer(JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer())),
            "highlight"
        );
        op.add(Builder::id, JsonpDeserializer.stringDeserializer(), "_id");
        op.add(Builder::ignored, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "_ignored");
        op.add(
            Builder::ignoredFieldValues,
            JsonpDeserializer.stringMapDeserializer(JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer())),
            "ignored_field_values"
        );
        op.add(Builder::index, JsonpDeserializer.stringDeserializer(), "_index");
        op.add(Builder::innerHits, JsonpDeserializer.stringMapDeserializer(InnerHitsResult._DESERIALIZER), "inner_hits");
        op.add(Builder::matchedQueries, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "matched_queries");
        op.add(Builder::nested, NestedIdentity._DESERIALIZER, "_nested");
        op.add(Builder::node, JsonpDeserializer.stringDeserializer(), "_node");
        op.add(Builder::primaryTerm, JsonpDeserializer.longDeserializer(), "_primary_term");
        op.add(Builder::routing, JsonpDeserializer.stringDeserializer(), "_routing");
        op.add(Builder::score, JsonpDeserializer.doubleDeserializer(), "_score");
        op.add(Builder::seqNo, JsonpDeserializer.longDeserializer(), "_seq_no");
        op.add(Builder::shard, JsonpDeserializer.stringDeserializer(), "_shard");
        op.add(Builder::sort, JsonpDeserializer.arrayDeserializer(FieldValue._DESERIALIZER), "sort");
        op.add(Builder::source, tDocumentDeserializer, "_source");
        op.add(Builder::version, JsonpDeserializer.longDeserializer(), "_version");
        op.setUnknownFieldHandler((builder, name, parser, mapper) -> {
            if (builder.metaFields == null) {
                builder.metaFields = new HashMap<>();
            }
            builder.metaFields.put(name, JsonData._DESERIALIZER.deserialize(parser, mapper));
        });
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.explanation);
        result = 31 * result + Objects.hashCode(this.fields);
        result = 31 * result + Objects.hashCode(this.highlight);
        result = 31 * result + Objects.hashCode(this.id);
        result = 31 * result + Objects.hashCode(this.ignored);
        result = 31 * result + Objects.hashCode(this.ignoredFieldValues);
        result = 31 * result + Objects.hashCode(this.index);
        result = 31 * result + Objects.hashCode(this.innerHits);
        result = 31 * result + Objects.hashCode(this.matchedQueries);
        result = 31 * result + Objects.hashCode(this.metaFields);
        result = 31 * result + Objects.hashCode(this.nested);
        result = 31 * result + Objects.hashCode(this.node);
        result = 31 * result + Objects.hashCode(this.primaryTerm);
        result = 31 * result + Objects.hashCode(this.routing);
        result = 31 * result + Objects.hashCode(this.score);
        result = 31 * result + Objects.hashCode(this.seqNo);
        result = 31 * result + Objects.hashCode(this.shard);
        result = 31 * result + Objects.hashCode(this.sort);
        result = 31 * result + Objects.hashCode(this.source);
        result = 31 * result + Objects.hashCode(this.version);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Hit<?> other = (Hit<?>) o;
        return Objects.equals(this.explanation, other.explanation)
            && Objects.equals(this.fields, other.fields)
            && Objects.equals(this.highlight, other.highlight)
            && Objects.equals(this.id, other.id)
            && Objects.equals(this.ignored, other.ignored)
            && Objects.equals(this.ignoredFieldValues, other.ignoredFieldValues)
            && Objects.equals(this.index, other.index)
            && Objects.equals(this.innerHits, other.innerHits)
            && Objects.equals(this.matchedQueries, other.matchedQueries)
            && Objects.equals(this.metaFields, other.metaFields)
            && Objects.equals(this.nested, other.nested)
            && Objects.equals(this.node, other.node)
            && Objects.equals(this.primaryTerm, other.primaryTerm)
            && Objects.equals(this.routing, other.routing)
            && Objects.equals(this.score, other.score)
            && Objects.equals(this.seqNo, other.seqNo)
            && Objects.equals(this.shard, other.shard)
            && Objects.equals(this.sort, other.sort)
            && Objects.equals(this.source, other.source)
            && Objects.equals(this.version, other.version);
    }
}
