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

package org.opensearch.client.opensearch._types.mapping;

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
import org.opensearch.client.opensearch.indices.FielddataFrequencyFilter;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: _types.mapping.MatchOnlyTextProperty

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class MatchOnlyTextProperty
    implements
        PropertyVariant,
        PlainJsonSerializable,
        ToCopyableBuilder<MatchOnlyTextProperty.Builder, MatchOnlyTextProperty> {

    @Nullable
    private final String analyzer;

    @Nullable
    private final Double boost;

    @Nonnull
    private final List<String> copyTo;

    @Nullable
    private final Boolean eagerGlobalOrdinals;

    @Nullable
    private final Boolean fielddata;

    @Nullable
    private final FielddataFrequencyFilter fielddataFrequencyFilter;

    @Nonnull
    private final Map<String, Property> fields;

    @Nullable
    private final Boolean index;

    @Nonnull
    private final Map<String, String> meta;

    @Nullable
    private final Integer positionIncrementGap;

    @Nullable
    private final String searchAnalyzer;

    @Nullable
    private final TermVectorOption termVector;

    // ---------------------------------------------------------------------------------------------

    private MatchOnlyTextProperty(Builder builder) {
        this.analyzer = builder.analyzer;
        this.boost = builder.boost;
        this.copyTo = ApiTypeHelper.unmodifiable(builder.copyTo);
        this.eagerGlobalOrdinals = builder.eagerGlobalOrdinals;
        this.fielddata = builder.fielddata;
        this.fielddataFrequencyFilter = builder.fielddataFrequencyFilter;
        this.fields = ApiTypeHelper.unmodifiable(builder.fields);
        this.index = builder.index;
        this.meta = ApiTypeHelper.unmodifiable(builder.meta);
        this.positionIncrementGap = builder.positionIncrementGap;
        this.searchAnalyzer = builder.searchAnalyzer;
        this.termVector = builder.termVector;
    }

    public static MatchOnlyTextProperty of(Function<MatchOnlyTextProperty.Builder, ObjectBuilder<MatchOnlyTextProperty>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link Property} variant kind.
     */
    @Override
    public Property.Kind _propertyKind() {
        return Property.Kind.MatchOnlyText;
    }

    /**
     * API name: {@code analyzer}
     */
    @Nullable
    public final String analyzer() {
        return this.analyzer;
    }

    /**
     * API name: {@code boost}
     */
    @Nullable
    public final Double boost() {
        return this.boost;
    }

    /**
     * API name: {@code copy_to}
     */
    @Nonnull
    public final List<String> copyTo() {
        return this.copyTo;
    }

    /**
     * API name: {@code eager_global_ordinals}
     */
    @Nullable
    public final Boolean eagerGlobalOrdinals() {
        return this.eagerGlobalOrdinals;
    }

    /**
     * API name: {@code fielddata}
     */
    @Nullable
    public final Boolean fielddata() {
        return this.fielddata;
    }

    /**
     * API name: {@code fielddata_frequency_filter}
     */
    @Nullable
    public final FielddataFrequencyFilter fielddataFrequencyFilter() {
        return this.fielddataFrequencyFilter;
    }

    /**
     * Multi-fields allow the same string value to be indexed in multiple ways for different purposes, such as one field for search and a
     * multi-field for sorting and aggregations, or the same string value analyzed by different analyzers.
     * <p>
     * API name: {@code fields}
     * </p>
     */
    @Nonnull
    public final Map<String, Property> fields() {
        return this.fields;
    }

    /**
     * API name: {@code index}
     */
    @Nullable
    public final Boolean index() {
        return this.index;
    }

    /**
     * Metadata about the field.
     * <p>
     * API name: {@code meta}
     * </p>
     */
    @Nonnull
    public final Map<String, String> meta() {
        return this.meta;
    }

    /**
     * API name: {@code position_increment_gap}
     */
    @Nullable
    public final Integer positionIncrementGap() {
        return this.positionIncrementGap;
    }

    /**
     * API name: {@code search_analyzer}
     */
    @Nullable
    public final String searchAnalyzer() {
        return this.searchAnalyzer;
    }

    /**
     * API name: {@code term_vector}
     */
    @Nullable
    public final TermVectorOption termVector() {
        return this.termVector;
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
        generator.write("type", "match_only_text");
        if (this.analyzer != null) {
            generator.writeKey("analyzer");
            generator.write(this.analyzer);
        }

        if (this.boost != null) {
            generator.writeKey("boost");
            generator.write(this.boost);
        }

        if (ApiTypeHelper.isDefined(this.copyTo)) {
            generator.writeKey("copy_to");
            generator.writeStartArray();
            for (String item0 : this.copyTo) {
                generator.write(item0);
            }
            generator.writeEnd();
        }

        if (this.eagerGlobalOrdinals != null) {
            generator.writeKey("eager_global_ordinals");
            generator.write(this.eagerGlobalOrdinals);
        }

        if (this.fielddata != null) {
            generator.writeKey("fielddata");
            generator.write(this.fielddata);
        }

        if (this.fielddataFrequencyFilter != null) {
            generator.writeKey("fielddata_frequency_filter");
            this.fielddataFrequencyFilter.serialize(generator, mapper);
        }

        if (ApiTypeHelper.isDefined(this.fields)) {
            generator.writeKey("fields");
            generator.writeStartObject();
            for (Map.Entry<String, Property> item0 : this.fields.entrySet()) {
                generator.writeKey(item0.getKey());
                item0.getValue().serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (this.index != null) {
            generator.writeKey("index");
            generator.write(this.index);
        }

        if (ApiTypeHelper.isDefined(this.meta)) {
            generator.writeKey("meta");
            generator.writeStartObject();
            for (Map.Entry<String, String> item0 : this.meta.entrySet()) {
                generator.writeKey(item0.getKey());
                generator.write(item0.getValue());
            }
            generator.writeEnd();
        }

        if (this.positionIncrementGap != null) {
            generator.writeKey("position_increment_gap");
            generator.write(this.positionIncrementGap);
        }

        if (this.searchAnalyzer != null) {
            generator.writeKey("search_analyzer");
            generator.write(this.searchAnalyzer);
        }

        if (this.termVector != null) {
            generator.writeKey("term_vector");
            this.termVector.serialize(generator, mapper);
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
     * Builder for {@link MatchOnlyTextProperty}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, MatchOnlyTextProperty> {
        @Nullable
        private String analyzer;
        @Nullable
        private Double boost;
        @Nullable
        private List<String> copyTo;
        @Nullable
        private Boolean eagerGlobalOrdinals;
        @Nullable
        private Boolean fielddata;
        @Nullable
        private FielddataFrequencyFilter fielddataFrequencyFilter;
        @Nullable
        private Map<String, Property> fields;
        @Nullable
        private Boolean index;
        @Nullable
        private Map<String, String> meta;
        @Nullable
        private Integer positionIncrementGap;
        @Nullable
        private String searchAnalyzer;
        @Nullable
        private TermVectorOption termVector;

        public Builder() {}

        private Builder(MatchOnlyTextProperty o) {
            this.analyzer = o.analyzer;
            this.boost = o.boost;
            this.copyTo = _listCopy(o.copyTo);
            this.eagerGlobalOrdinals = o.eagerGlobalOrdinals;
            this.fielddata = o.fielddata;
            this.fielddataFrequencyFilter = o.fielddataFrequencyFilter;
            this.fields = _mapCopy(o.fields);
            this.index = o.index;
            this.meta = _mapCopy(o.meta);
            this.positionIncrementGap = o.positionIncrementGap;
            this.searchAnalyzer = o.searchAnalyzer;
            this.termVector = o.termVector;
        }

        private Builder(Builder o) {
            this.analyzer = o.analyzer;
            this.boost = o.boost;
            this.copyTo = _listCopy(o.copyTo);
            this.eagerGlobalOrdinals = o.eagerGlobalOrdinals;
            this.fielddata = o.fielddata;
            this.fielddataFrequencyFilter = o.fielddataFrequencyFilter;
            this.fields = _mapCopy(o.fields);
            this.index = o.index;
            this.meta = _mapCopy(o.meta);
            this.positionIncrementGap = o.positionIncrementGap;
            this.searchAnalyzer = o.searchAnalyzer;
            this.termVector = o.termVector;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code analyzer}
         */
        @Nonnull
        public final Builder analyzer(@Nullable String value) {
            this.analyzer = value;
            return this;
        }

        /**
         * API name: {@code boost}
         */
        @Nonnull
        public final Builder boost(@Nullable Double value) {
            this.boost = value;
            return this;
        }

        /**
         * API name: {@code copy_to}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>copyTo</code>.
         * </p>
         */
        @Nonnull
        public final Builder copyTo(List<String> list) {
            this.copyTo = _listAddAll(this.copyTo, list);
            return this;
        }

        /**
         * API name: {@code copy_to}
         *
         * <p>
         * Adds one or more values to <code>copyTo</code>.
         * </p>
         */
        @Nonnull
        public final Builder copyTo(String value, String... values) {
            this.copyTo = _listAdd(this.copyTo, value, values);
            return this;
        }

        /**
         * API name: {@code eager_global_ordinals}
         */
        @Nonnull
        public final Builder eagerGlobalOrdinals(@Nullable Boolean value) {
            this.eagerGlobalOrdinals = value;
            return this;
        }

        /**
         * API name: {@code fielddata}
         */
        @Nonnull
        public final Builder fielddata(@Nullable Boolean value) {
            this.fielddata = value;
            return this;
        }

        /**
         * API name: {@code fielddata_frequency_filter}
         */
        @Nonnull
        public final Builder fielddataFrequencyFilter(@Nullable FielddataFrequencyFilter value) {
            this.fielddataFrequencyFilter = value;
            return this;
        }

        /**
         * API name: {@code fielddata_frequency_filter}
         */
        @Nonnull
        public final Builder fielddataFrequencyFilter(
            Function<FielddataFrequencyFilter.Builder, ObjectBuilder<FielddataFrequencyFilter>> fn
        ) {
            return fielddataFrequencyFilter(fn.apply(new FielddataFrequencyFilter.Builder()).build());
        }

        /**
         * Multi-fields allow the same string value to be indexed in multiple ways for different purposes, such as one field for search and
         * a multi-field for sorting and aggregations, or the same string value analyzed by different analyzers.
         * <p>
         * API name: {@code fields}
         * </p>
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>fields</code>.
         * </p>
         */
        @Nonnull
        public final Builder fields(Map<String, Property> map) {
            this.fields = _mapPutAll(this.fields, map);
            return this;
        }

        /**
         * Multi-fields allow the same string value to be indexed in multiple ways for different purposes, such as one field for search and
         * a multi-field for sorting and aggregations, or the same string value analyzed by different analyzers.
         * <p>
         * API name: {@code fields}
         * </p>
         *
         * <p>
         * Adds an entry to <code>fields</code>.
         * </p>
         */
        @Nonnull
        public final Builder fields(String key, Property value) {
            this.fields = _mapPut(this.fields, key, value);
            return this;
        }

        /**
         * Multi-fields allow the same string value to be indexed in multiple ways for different purposes, such as one field for search and
         * a multi-field for sorting and aggregations, or the same string value analyzed by different analyzers.
         * <p>
         * API name: {@code fields}
         * </p>
         *
         * <p>
         * Adds a value to <code>fields</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder fields(String key, Function<Property.Builder, ObjectBuilder<Property>> fn) {
            return fields(key, fn.apply(new Property.Builder()).build());
        }

        /**
         * API name: {@code index}
         */
        @Nonnull
        public final Builder index(@Nullable Boolean value) {
            this.index = value;
            return this;
        }

        /**
         * Metadata about the field.
         * <p>
         * API name: {@code meta}
         * </p>
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>meta</code>.
         * </p>
         */
        @Nonnull
        public final Builder meta(Map<String, String> map) {
            this.meta = _mapPutAll(this.meta, map);
            return this;
        }

        /**
         * Metadata about the field.
         * <p>
         * API name: {@code meta}
         * </p>
         *
         * <p>
         * Adds an entry to <code>meta</code>.
         * </p>
         */
        @Nonnull
        public final Builder meta(String key, String value) {
            this.meta = _mapPut(this.meta, key, value);
            return this;
        }

        /**
         * API name: {@code position_increment_gap}
         */
        @Nonnull
        public final Builder positionIncrementGap(@Nullable Integer value) {
            this.positionIncrementGap = value;
            return this;
        }

        /**
         * API name: {@code search_analyzer}
         */
        @Nonnull
        public final Builder searchAnalyzer(@Nullable String value) {
            this.searchAnalyzer = value;
            return this;
        }

        /**
         * API name: {@code term_vector}
         */
        @Nonnull
        public final Builder termVector(@Nullable TermVectorOption value) {
            this.termVector = value;
            return this;
        }

        /**
         * Builds a {@link MatchOnlyTextProperty}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public MatchOnlyTextProperty build() {
            _checkSingleUse();

            return new MatchOnlyTextProperty(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link MatchOnlyTextProperty}
     */
    public static final JsonpDeserializer<MatchOnlyTextProperty> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        MatchOnlyTextProperty::setupMatchOnlyTextPropertyDeserializer
    );

    protected static void setupMatchOnlyTextPropertyDeserializer(ObjectDeserializer<MatchOnlyTextProperty.Builder> op) {
        op.add(Builder::analyzer, JsonpDeserializer.stringDeserializer(), "analyzer");
        op.add(Builder::boost, JsonpDeserializer.doubleDeserializer(), "boost");
        op.add(Builder::copyTo, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "copy_to");
        op.add(Builder::eagerGlobalOrdinals, JsonpDeserializer.booleanDeserializer(), "eager_global_ordinals");
        op.add(Builder::fielddata, JsonpDeserializer.booleanDeserializer(), "fielddata");
        op.add(Builder::fielddataFrequencyFilter, FielddataFrequencyFilter._DESERIALIZER, "fielddata_frequency_filter");
        op.add(Builder::fields, JsonpDeserializer.stringMapDeserializer(Property._DESERIALIZER), "fields");
        op.add(Builder::index, JsonpDeserializer.booleanDeserializer(), "index");
        op.add(Builder::meta, JsonpDeserializer.stringMapDeserializer(JsonpDeserializer.stringDeserializer()), "meta");
        op.add(Builder::positionIncrementGap, JsonpDeserializer.integerDeserializer(), "position_increment_gap");
        op.add(Builder::searchAnalyzer, JsonpDeserializer.stringDeserializer(), "search_analyzer");
        op.add(Builder::termVector, TermVectorOption._DESERIALIZER, "term_vector");

        op.ignore("type");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.analyzer);
        result = 31 * result + Objects.hashCode(this.boost);
        result = 31 * result + Objects.hashCode(this.copyTo);
        result = 31 * result + Objects.hashCode(this.eagerGlobalOrdinals);
        result = 31 * result + Objects.hashCode(this.fielddata);
        result = 31 * result + Objects.hashCode(this.fielddataFrequencyFilter);
        result = 31 * result + Objects.hashCode(this.fields);
        result = 31 * result + Objects.hashCode(this.index);
        result = 31 * result + Objects.hashCode(this.meta);
        result = 31 * result + Objects.hashCode(this.positionIncrementGap);
        result = 31 * result + Objects.hashCode(this.searchAnalyzer);
        result = 31 * result + Objects.hashCode(this.termVector);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        MatchOnlyTextProperty other = (MatchOnlyTextProperty) o;
        return Objects.equals(this.analyzer, other.analyzer)
            && Objects.equals(this.boost, other.boost)
            && Objects.equals(this.copyTo, other.copyTo)
            && Objects.equals(this.eagerGlobalOrdinals, other.eagerGlobalOrdinals)
            && Objects.equals(this.fielddata, other.fielddata)
            && Objects.equals(this.fielddataFrequencyFilter, other.fielddataFrequencyFilter)
            && Objects.equals(this.fields, other.fields)
            && Objects.equals(this.index, other.index)
            && Objects.equals(this.meta, other.meta)
            && Objects.equals(this.positionIncrementGap, other.positionIncrementGap)
            && Objects.equals(this.searchAnalyzer, other.searchAnalyzer)
            && Objects.equals(this.termVector, other.termVector);
    }
}
