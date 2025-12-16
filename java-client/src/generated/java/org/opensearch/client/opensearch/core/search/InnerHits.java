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
import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.json.PlainJsonSerializable;
import org.opensearch.client.opensearch._types.ScriptField;
import org.opensearch.client.opensearch._types.SortOptions;
import org.opensearch.client.opensearch._types.query_dsl.FieldAndFormat;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: core.search.InnerHits

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class InnerHits implements PlainJsonSerializable, ToCopyableBuilder<InnerHits.Builder, InnerHits> {

    @Nullable
    private final FieldCollapse collapse;

    @Nonnull
    private final List<FieldAndFormat> docvalueFields;

    @Nullable
    private final Boolean explain;

    @Nonnull
    private final List<FieldAndFormat> fields;

    @Nullable
    private final Integer from;

    @Nullable
    private final Highlight highlight;

    @Nullable
    private final Boolean ignoreUnmapped;

    @Nullable
    private final String name;

    @Nonnull
    private final Map<String, ScriptField> scriptFields;

    @Nullable
    private final Boolean seqNoPrimaryTerm;

    @Nullable
    private final Integer size;

    @Nonnull
    private final List<SortOptions> sort;

    @Nullable
    private final SourceConfig source;

    @Nonnull
    private final List<String> storedFields;

    @Nullable
    private final Boolean trackScores;

    @Nullable
    private final Boolean version;

    // ---------------------------------------------------------------------------------------------

    private InnerHits(Builder builder) {
        this.collapse = builder.collapse;
        this.docvalueFields = ApiTypeHelper.unmodifiable(builder.docvalueFields);
        this.explain = builder.explain;
        this.fields = ApiTypeHelper.unmodifiable(builder.fields);
        this.from = builder.from;
        this.highlight = builder.highlight;
        this.ignoreUnmapped = builder.ignoreUnmapped;
        this.name = builder.name;
        this.scriptFields = ApiTypeHelper.unmodifiable(builder.scriptFields);
        this.seqNoPrimaryTerm = builder.seqNoPrimaryTerm;
        this.size = builder.size;
        this.sort = ApiTypeHelper.unmodifiable(builder.sort);
        this.source = builder.source;
        this.storedFields = ApiTypeHelper.unmodifiable(builder.storedFields);
        this.trackScores = builder.trackScores;
        this.version = builder.version;
    }

    public static InnerHits of(Function<InnerHits.Builder, ObjectBuilder<InnerHits>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code collapse}
     */
    @Nullable
    public final FieldCollapse collapse() {
        return this.collapse;
    }

    /**
     * API name: {@code docvalue_fields}
     */
    @Nonnull
    public final List<FieldAndFormat> docvalueFields() {
        return this.docvalueFields;
    }

    /**
     * API name: {@code explain}
     */
    @Nullable
    public final Boolean explain() {
        return this.explain;
    }

    /**
     * API name: {@code fields}
     */
    @Nonnull
    public final List<FieldAndFormat> fields() {
        return this.fields;
    }

    /**
     * The inner hit that initiates document offset.
     * <p>
     * API name: {@code from}
     * </p>
     */
    @Nullable
    public final Integer from() {
        return this.from;
    }

    /**
     * API name: {@code highlight}
     */
    @Nullable
    public final Highlight highlight() {
        return this.highlight;
    }

    /**
     * API name: {@code ignore_unmapped}
     */
    @Nullable
    public final Boolean ignoreUnmapped() {
        return this.ignoreUnmapped;
    }

    /**
     * API name: {@code name}
     */
    @Nullable
    public final String name() {
        return this.name;
    }

    /**
     * API name: {@code script_fields}
     */
    @Nonnull
    public final Map<String, ScriptField> scriptFields() {
        return this.scriptFields;
    }

    /**
     * API name: {@code seq_no_primary_term}
     */
    @Nullable
    public final Boolean seqNoPrimaryTerm() {
        return this.seqNoPrimaryTerm;
    }

    /**
     * The maximum number of hits to return per <code>inner_hits</code>.
     * <p>
     * API name: {@code size}
     * </p>
     */
    @Nullable
    public final Integer size() {
        return this.size;
    }

    /**
     * API name: {@code sort}
     */
    @Nonnull
    public final List<SortOptions> sort() {
        return this.sort;
    }

    /**
     * API name: {@code _source}
     */
    @Nullable
    public final SourceConfig source() {
        return this.source;
    }

    /**
     * API name: {@code stored_fields}
     */
    @Nonnull
    public final List<String> storedFields() {
        return this.storedFields;
    }

    /**
     * API name: {@code track_scores}
     */
    @Nullable
    public final Boolean trackScores() {
        return this.trackScores;
    }

    /**
     * API name: {@code version}
     */
    @Nullable
    public final Boolean version() {
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
        if (this.collapse != null) {
            generator.writeKey("collapse");
            this.collapse.serialize(generator, mapper);
        }

        if (ApiTypeHelper.isDefined(this.docvalueFields)) {
            generator.writeKey("docvalue_fields");
            generator.writeStartArray();
            for (FieldAndFormat item0 : this.docvalueFields) {
                item0.serialize(generator, mapper);
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

        if (this.from != null) {
            generator.writeKey("from");
            generator.write(this.from);
        }

        if (this.highlight != null) {
            generator.writeKey("highlight");
            this.highlight.serialize(generator, mapper);
        }

        if (this.ignoreUnmapped != null) {
            generator.writeKey("ignore_unmapped");
            generator.write(this.ignoreUnmapped);
        }

        if (this.name != null) {
            generator.writeKey("name");
            generator.write(this.name);
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

        if (this.source != null) {
            generator.writeKey("_source");
            this.source.serialize(generator, mapper);
        }

        if (ApiTypeHelper.isDefined(this.storedFields)) {
            generator.writeKey("stored_fields");
            generator.writeStartArray();
            for (String item0 : this.storedFields) {
                generator.write(item0);
            }
            generator.writeEnd();
        }

        if (this.trackScores != null) {
            generator.writeKey("track_scores");
            generator.write(this.trackScores);
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
     * Builder for {@link InnerHits}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, InnerHits> {
        @Nullable
        private FieldCollapse collapse;
        @Nullable
        private List<FieldAndFormat> docvalueFields;
        @Nullable
        private Boolean explain;
        @Nullable
        private List<FieldAndFormat> fields;
        @Nullable
        private Integer from;
        @Nullable
        private Highlight highlight;
        @Nullable
        private Boolean ignoreUnmapped;
        @Nullable
        private String name;
        @Nullable
        private Map<String, ScriptField> scriptFields;
        @Nullable
        private Boolean seqNoPrimaryTerm;
        @Nullable
        private Integer size;
        @Nullable
        private List<SortOptions> sort;
        @Nullable
        private SourceConfig source;
        @Nullable
        private List<String> storedFields;
        @Nullable
        private Boolean trackScores;
        @Nullable
        private Boolean version;

        public Builder() {}

        private Builder(InnerHits o) {
            this.collapse = o.collapse;
            this.docvalueFields = _listCopy(o.docvalueFields);
            this.explain = o.explain;
            this.fields = _listCopy(o.fields);
            this.from = o.from;
            this.highlight = o.highlight;
            this.ignoreUnmapped = o.ignoreUnmapped;
            this.name = o.name;
            this.scriptFields = _mapCopy(o.scriptFields);
            this.seqNoPrimaryTerm = o.seqNoPrimaryTerm;
            this.size = o.size;
            this.sort = _listCopy(o.sort);
            this.source = o.source;
            this.storedFields = _listCopy(o.storedFields);
            this.trackScores = o.trackScores;
            this.version = o.version;
        }

        private Builder(Builder o) {
            this.collapse = o.collapse;
            this.docvalueFields = _listCopy(o.docvalueFields);
            this.explain = o.explain;
            this.fields = _listCopy(o.fields);
            this.from = o.from;
            this.highlight = o.highlight;
            this.ignoreUnmapped = o.ignoreUnmapped;
            this.name = o.name;
            this.scriptFields = _mapCopy(o.scriptFields);
            this.seqNoPrimaryTerm = o.seqNoPrimaryTerm;
            this.size = o.size;
            this.sort = _listCopy(o.sort);
            this.source = o.source;
            this.storedFields = _listCopy(o.storedFields);
            this.trackScores = o.trackScores;
            this.version = o.version;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code collapse}
         */
        @Nonnull
        public final Builder collapse(@Nullable FieldCollapse value) {
            this.collapse = value;
            return this;
        }

        /**
         * API name: {@code collapse}
         */
        @Nonnull
        public final Builder collapse(Function<FieldCollapse.Builder, ObjectBuilder<FieldCollapse>> fn) {
            return collapse(fn.apply(new FieldCollapse.Builder()).build());
        }

        /**
         * API name: {@code docvalue_fields}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>docvalueFields</code>.
         * </p>
         */
        @Nonnull
        public final Builder docvalueFields(List<FieldAndFormat> list) {
            this.docvalueFields = _listAddAll(this.docvalueFields, list);
            return this;
        }

        /**
         * API name: {@code docvalue_fields}
         *
         * <p>
         * Adds one or more values to <code>docvalueFields</code>.
         * </p>
         */
        @Nonnull
        public final Builder docvalueFields(FieldAndFormat value, FieldAndFormat... values) {
            this.docvalueFields = _listAdd(this.docvalueFields, value, values);
            return this;
        }

        /**
         * API name: {@code docvalue_fields}
         *
         * <p>
         * Adds a value to <code>docvalueFields</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder docvalueFields(Function<FieldAndFormat.Builder, ObjectBuilder<FieldAndFormat>> fn) {
            return docvalueFields(fn.apply(new FieldAndFormat.Builder()).build());
        }

        /**
         * API name: {@code explain}
         */
        @Nonnull
        public final Builder explain(@Nullable Boolean value) {
            this.explain = value;
            return this;
        }

        /**
         * API name: {@code fields}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>fields</code>.
         * </p>
         */
        @Nonnull
        public final Builder fields(List<FieldAndFormat> list) {
            this.fields = _listAddAll(this.fields, list);
            return this;
        }

        /**
         * API name: {@code fields}
         *
         * <p>
         * Adds one or more values to <code>fields</code>.
         * </p>
         */
        @Nonnull
        public final Builder fields(FieldAndFormat value, FieldAndFormat... values) {
            this.fields = _listAdd(this.fields, value, values);
            return this;
        }

        /**
         * API name: {@code fields}
         *
         * <p>
         * Adds a value to <code>fields</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder fields(Function<FieldAndFormat.Builder, ObjectBuilder<FieldAndFormat>> fn) {
            return fields(fn.apply(new FieldAndFormat.Builder()).build());
        }

        /**
         * The inner hit that initiates document offset.
         * <p>
         * API name: {@code from}
         * </p>
         */
        @Nonnull
        public final Builder from(@Nullable Integer value) {
            this.from = value;
            return this;
        }

        /**
         * API name: {@code highlight}
         */
        @Nonnull
        public final Builder highlight(@Nullable Highlight value) {
            this.highlight = value;
            return this;
        }

        /**
         * API name: {@code highlight}
         */
        @Nonnull
        public final Builder highlight(Function<Highlight.Builder, ObjectBuilder<Highlight>> fn) {
            return highlight(fn.apply(new Highlight.Builder()).build());
        }

        /**
         * API name: {@code ignore_unmapped}
         */
        @Nonnull
        public final Builder ignoreUnmapped(@Nullable Boolean value) {
            this.ignoreUnmapped = value;
            return this;
        }

        /**
         * API name: {@code name}
         */
        @Nonnull
        public final Builder name(@Nullable String value) {
            this.name = value;
            return this;
        }

        /**
         * API name: {@code script_fields}
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>scriptFields</code>.
         * </p>
         */
        @Nonnull
        public final Builder scriptFields(Map<String, ScriptField> map) {
            this.scriptFields = _mapPutAll(this.scriptFields, map);
            return this;
        }

        /**
         * API name: {@code script_fields}
         *
         * <p>
         * Adds an entry to <code>scriptFields</code>.
         * </p>
         */
        @Nonnull
        public final Builder scriptFields(String key, ScriptField value) {
            this.scriptFields = _mapPut(this.scriptFields, key, value);
            return this;
        }

        /**
         * API name: {@code script_fields}
         *
         * <p>
         * Adds a value to <code>scriptFields</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder scriptFields(String key, Function<ScriptField.Builder, ObjectBuilder<ScriptField>> fn) {
            return scriptFields(key, fn.apply(new ScriptField.Builder()).build());
        }

        /**
         * API name: {@code seq_no_primary_term}
         */
        @Nonnull
        public final Builder seqNoPrimaryTerm(@Nullable Boolean value) {
            this.seqNoPrimaryTerm = value;
            return this;
        }

        /**
         * The maximum number of hits to return per <code>inner_hits</code>.
         * <p>
         * API name: {@code size}
         * </p>
         */
        @Nonnull
        public final Builder size(@Nullable Integer value) {
            this.size = value;
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
        public final Builder sort(List<SortOptions> list) {
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
        public final Builder sort(SortOptions value, SortOptions... values) {
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
        public final Builder sort(Function<SortOptions.Builder, ObjectBuilder<SortOptions>> fn) {
            return sort(fn.apply(new SortOptions.Builder()).build());
        }

        /**
         * API name: {@code _source}
         */
        @Nonnull
        public final Builder source(@Nullable SourceConfig value) {
            this.source = value;
            return this;
        }

        /**
         * API name: {@code _source}
         */
        @Nonnull
        public final Builder source(Function<SourceConfig.Builder, ObjectBuilder<SourceConfig>> fn) {
            return source(fn.apply(new SourceConfig.Builder()).build());
        }

        /**
         * API name: {@code stored_fields}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>storedFields</code>.
         * </p>
         */
        @Nonnull
        public final Builder storedFields(List<String> list) {
            this.storedFields = _listAddAll(this.storedFields, list);
            return this;
        }

        /**
         * API name: {@code stored_fields}
         *
         * <p>
         * Adds one or more values to <code>storedFields</code>.
         * </p>
         */
        @Nonnull
        public final Builder storedFields(String value, String... values) {
            this.storedFields = _listAdd(this.storedFields, value, values);
            return this;
        }

        /**
         * API name: {@code track_scores}
         */
        @Nonnull
        public final Builder trackScores(@Nullable Boolean value) {
            this.trackScores = value;
            return this;
        }

        /**
         * API name: {@code version}
         */
        @Nonnull
        public final Builder version(@Nullable Boolean value) {
            this.version = value;
            return this;
        }

        /**
         * Builds a {@link InnerHits}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public InnerHits build() {
            _checkSingleUse();

            return new InnerHits(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link InnerHits}
     */
    public static final JsonpDeserializer<InnerHits> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        InnerHits::setupInnerHitsDeserializer
    );

    protected static void setupInnerHitsDeserializer(ObjectDeserializer<InnerHits.Builder> op) {
        op.add(Builder::collapse, FieldCollapse._DESERIALIZER, "collapse");
        op.add(Builder::docvalueFields, JsonpDeserializer.arrayDeserializer(FieldAndFormat._DESERIALIZER), "docvalue_fields");
        op.add(Builder::explain, JsonpDeserializer.booleanDeserializer(), "explain");
        op.add(Builder::fields, JsonpDeserializer.arrayDeserializer(FieldAndFormat._DESERIALIZER), "fields");
        op.add(Builder::from, JsonpDeserializer.integerDeserializer(), "from");
        op.add(Builder::highlight, Highlight._DESERIALIZER, "highlight");
        op.add(Builder::ignoreUnmapped, JsonpDeserializer.booleanDeserializer(), "ignore_unmapped");
        op.add(Builder::name, JsonpDeserializer.stringDeserializer(), "name");
        op.add(Builder::scriptFields, JsonpDeserializer.stringMapDeserializer(ScriptField._DESERIALIZER), "script_fields");
        op.add(Builder::seqNoPrimaryTerm, JsonpDeserializer.booleanDeserializer(), "seq_no_primary_term");
        op.add(Builder::size, JsonpDeserializer.integerDeserializer(), "size");
        op.add(Builder::sort, JsonpDeserializer.arrayDeserializer(SortOptions._DESERIALIZER), "sort");
        op.add(Builder::source, SourceConfig._DESERIALIZER, "_source");
        op.add(Builder::storedFields, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "stored_fields");
        op.add(Builder::trackScores, JsonpDeserializer.booleanDeserializer(), "track_scores");
        op.add(Builder::version, JsonpDeserializer.booleanDeserializer(), "version");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.collapse);
        result = 31 * result + Objects.hashCode(this.docvalueFields);
        result = 31 * result + Objects.hashCode(this.explain);
        result = 31 * result + Objects.hashCode(this.fields);
        result = 31 * result + Objects.hashCode(this.from);
        result = 31 * result + Objects.hashCode(this.highlight);
        result = 31 * result + Objects.hashCode(this.ignoreUnmapped);
        result = 31 * result + Objects.hashCode(this.name);
        result = 31 * result + Objects.hashCode(this.scriptFields);
        result = 31 * result + Objects.hashCode(this.seqNoPrimaryTerm);
        result = 31 * result + Objects.hashCode(this.size);
        result = 31 * result + Objects.hashCode(this.sort);
        result = 31 * result + Objects.hashCode(this.source);
        result = 31 * result + Objects.hashCode(this.storedFields);
        result = 31 * result + Objects.hashCode(this.trackScores);
        result = 31 * result + Objects.hashCode(this.version);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        InnerHits other = (InnerHits) o;
        return Objects.equals(this.collapse, other.collapse)
            && Objects.equals(this.docvalueFields, other.docvalueFields)
            && Objects.equals(this.explain, other.explain)
            && Objects.equals(this.fields, other.fields)
            && Objects.equals(this.from, other.from)
            && Objects.equals(this.highlight, other.highlight)
            && Objects.equals(this.ignoreUnmapped, other.ignoreUnmapped)
            && Objects.equals(this.name, other.name)
            && Objects.equals(this.scriptFields, other.scriptFields)
            && Objects.equals(this.seqNoPrimaryTerm, other.seqNoPrimaryTerm)
            && Objects.equals(this.size, other.size)
            && Objects.equals(this.sort, other.sort)
            && Objects.equals(this.source, other.source)
            && Objects.equals(this.storedFields, other.storedFields)
            && Objects.equals(this.trackScores, other.trackScores)
            && Objects.equals(this.version, other.version);
    }
}
