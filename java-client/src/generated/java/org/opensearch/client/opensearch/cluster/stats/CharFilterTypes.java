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

package org.opensearch.client.opensearch.cluster.stats;

import jakarta.json.stream.JsonGenerator;
import java.util.List;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
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

// typedef: cluster.stats.CharFilterTypes

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class CharFilterTypes implements PlainJsonSerializable, ToCopyableBuilder<CharFilterTypes.Builder, CharFilterTypes> {

    @Nonnull
    private final List<FieldTypes> analyzerTypes;

    @Nonnull
    private final List<FieldTypes> builtInAnalyzers;

    @Nonnull
    private final List<FieldTypes> builtInCharFilters;

    @Nonnull
    private final List<FieldTypes> builtInFilters;

    @Nonnull
    private final List<FieldTypes> builtInTokenizers;

    @Nonnull
    private final List<FieldTypes> charFilterTypes;

    @Nonnull
    private final List<FieldTypes> filterTypes;

    @Nonnull
    private final List<FieldTypes> tokenizerTypes;

    // ---------------------------------------------------------------------------------------------

    private CharFilterTypes(Builder builder) {
        this.analyzerTypes = ApiTypeHelper.unmodifiableRequired(builder.analyzerTypes, this, "analyzerTypes");
        this.builtInAnalyzers = ApiTypeHelper.unmodifiableRequired(builder.builtInAnalyzers, this, "builtInAnalyzers");
        this.builtInCharFilters = ApiTypeHelper.unmodifiableRequired(builder.builtInCharFilters, this, "builtInCharFilters");
        this.builtInFilters = ApiTypeHelper.unmodifiableRequired(builder.builtInFilters, this, "builtInFilters");
        this.builtInTokenizers = ApiTypeHelper.unmodifiableRequired(builder.builtInTokenizers, this, "builtInTokenizers");
        this.charFilterTypes = ApiTypeHelper.unmodifiableRequired(builder.charFilterTypes, this, "charFilterTypes");
        this.filterTypes = ApiTypeHelper.unmodifiableRequired(builder.filterTypes, this, "filterTypes");
        this.tokenizerTypes = ApiTypeHelper.unmodifiableRequired(builder.tokenizerTypes, this, "tokenizerTypes");
    }

    public static CharFilterTypes of(Function<CharFilterTypes.Builder, ObjectBuilder<CharFilterTypes>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - Contains statistics about analyzer types used in selected nodes.
     * <p>
     * API name: {@code analyzer_types}
     * </p>
     */
    @Nonnull
    public final List<FieldTypes> analyzerTypes() {
        return this.analyzerTypes;
    }

    /**
     * Required - Contains statistics about built-in analyzers used in selected nodes.
     * <p>
     * API name: {@code built_in_analyzers}
     * </p>
     */
    @Nonnull
    public final List<FieldTypes> builtInAnalyzers() {
        return this.builtInAnalyzers;
    }

    /**
     * Required - Contains statistics about built-in character filters used in selected nodes.
     * <p>
     * API name: {@code built_in_char_filters}
     * </p>
     */
    @Nonnull
    public final List<FieldTypes> builtInCharFilters() {
        return this.builtInCharFilters;
    }

    /**
     * Required - Contains statistics about built-in token filters used in selected nodes.
     * <p>
     * API name: {@code built_in_filters}
     * </p>
     */
    @Nonnull
    public final List<FieldTypes> builtInFilters() {
        return this.builtInFilters;
    }

    /**
     * Required - Contains statistics about built-in tokenizers used in selected nodes.
     * <p>
     * API name: {@code built_in_tokenizers}
     * </p>
     */
    @Nonnull
    public final List<FieldTypes> builtInTokenizers() {
        return this.builtInTokenizers;
    }

    /**
     * Required - Contains statistics about character filter types used in selected nodes.
     * <p>
     * API name: {@code char_filter_types}
     * </p>
     */
    @Nonnull
    public final List<FieldTypes> charFilterTypes() {
        return this.charFilterTypes;
    }

    /**
     * Required - Contains statistics about token filter types used in selected nodes.
     * <p>
     * API name: {@code filter_types}
     * </p>
     */
    @Nonnull
    public final List<FieldTypes> filterTypes() {
        return this.filterTypes;
    }

    /**
     * Required - Contains statistics about tokenizer types used in selected nodes.
     * <p>
     * API name: {@code tokenizer_types}
     * </p>
     */
    @Nonnull
    public final List<FieldTypes> tokenizerTypes() {
        return this.tokenizerTypes;
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
        generator.writeKey("analyzer_types");
        generator.writeStartArray();
        for (FieldTypes item0 : this.analyzerTypes) {
            item0.serialize(generator, mapper);
        }
        generator.writeEnd();

        generator.writeKey("built_in_analyzers");
        generator.writeStartArray();
        for (FieldTypes item0 : this.builtInAnalyzers) {
            item0.serialize(generator, mapper);
        }
        generator.writeEnd();

        generator.writeKey("built_in_char_filters");
        generator.writeStartArray();
        for (FieldTypes item0 : this.builtInCharFilters) {
            item0.serialize(generator, mapper);
        }
        generator.writeEnd();

        generator.writeKey("built_in_filters");
        generator.writeStartArray();
        for (FieldTypes item0 : this.builtInFilters) {
            item0.serialize(generator, mapper);
        }
        generator.writeEnd();

        generator.writeKey("built_in_tokenizers");
        generator.writeStartArray();
        for (FieldTypes item0 : this.builtInTokenizers) {
            item0.serialize(generator, mapper);
        }
        generator.writeEnd();

        generator.writeKey("char_filter_types");
        generator.writeStartArray();
        for (FieldTypes item0 : this.charFilterTypes) {
            item0.serialize(generator, mapper);
        }
        generator.writeEnd();

        generator.writeKey("filter_types");
        generator.writeStartArray();
        for (FieldTypes item0 : this.filterTypes) {
            item0.serialize(generator, mapper);
        }
        generator.writeEnd();

        generator.writeKey("tokenizer_types");
        generator.writeStartArray();
        for (FieldTypes item0 : this.tokenizerTypes) {
            item0.serialize(generator, mapper);
        }
        generator.writeEnd();
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
     * Builder for {@link CharFilterTypes}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, CharFilterTypes> {
        private List<FieldTypes> analyzerTypes;
        private List<FieldTypes> builtInAnalyzers;
        private List<FieldTypes> builtInCharFilters;
        private List<FieldTypes> builtInFilters;
        private List<FieldTypes> builtInTokenizers;
        private List<FieldTypes> charFilterTypes;
        private List<FieldTypes> filterTypes;
        private List<FieldTypes> tokenizerTypes;

        public Builder() {}

        private Builder(CharFilterTypes o) {
            this.analyzerTypes = _listCopy(o.analyzerTypes);
            this.builtInAnalyzers = _listCopy(o.builtInAnalyzers);
            this.builtInCharFilters = _listCopy(o.builtInCharFilters);
            this.builtInFilters = _listCopy(o.builtInFilters);
            this.builtInTokenizers = _listCopy(o.builtInTokenizers);
            this.charFilterTypes = _listCopy(o.charFilterTypes);
            this.filterTypes = _listCopy(o.filterTypes);
            this.tokenizerTypes = _listCopy(o.tokenizerTypes);
        }

        private Builder(Builder o) {
            this.analyzerTypes = _listCopy(o.analyzerTypes);
            this.builtInAnalyzers = _listCopy(o.builtInAnalyzers);
            this.builtInCharFilters = _listCopy(o.builtInCharFilters);
            this.builtInFilters = _listCopy(o.builtInFilters);
            this.builtInTokenizers = _listCopy(o.builtInTokenizers);
            this.charFilterTypes = _listCopy(o.charFilterTypes);
            this.filterTypes = _listCopy(o.filterTypes);
            this.tokenizerTypes = _listCopy(o.tokenizerTypes);
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - Contains statistics about analyzer types used in selected nodes.
         * <p>
         * API name: {@code analyzer_types}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>analyzerTypes</code>.
         * </p>
         */
        @Nonnull
        public final Builder analyzerTypes(List<FieldTypes> list) {
            this.analyzerTypes = _listAddAll(this.analyzerTypes, list);
            return this;
        }

        /**
         * Required - Contains statistics about analyzer types used in selected nodes.
         * <p>
         * API name: {@code analyzer_types}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>analyzerTypes</code>.
         * </p>
         */
        @Nonnull
        public final Builder analyzerTypes(FieldTypes value, FieldTypes... values) {
            this.analyzerTypes = _listAdd(this.analyzerTypes, value, values);
            return this;
        }

        /**
         * Required - Contains statistics about analyzer types used in selected nodes.
         * <p>
         * API name: {@code analyzer_types}
         * </p>
         *
         * <p>
         * Adds a value to <code>analyzerTypes</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder analyzerTypes(Function<FieldTypes.Builder, ObjectBuilder<FieldTypes>> fn) {
            return analyzerTypes(fn.apply(new FieldTypes.Builder()).build());
        }

        /**
         * Required - Contains statistics about built-in analyzers used in selected nodes.
         * <p>
         * API name: {@code built_in_analyzers}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>builtInAnalyzers</code>.
         * </p>
         */
        @Nonnull
        public final Builder builtInAnalyzers(List<FieldTypes> list) {
            this.builtInAnalyzers = _listAddAll(this.builtInAnalyzers, list);
            return this;
        }

        /**
         * Required - Contains statistics about built-in analyzers used in selected nodes.
         * <p>
         * API name: {@code built_in_analyzers}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>builtInAnalyzers</code>.
         * </p>
         */
        @Nonnull
        public final Builder builtInAnalyzers(FieldTypes value, FieldTypes... values) {
            this.builtInAnalyzers = _listAdd(this.builtInAnalyzers, value, values);
            return this;
        }

        /**
         * Required - Contains statistics about built-in analyzers used in selected nodes.
         * <p>
         * API name: {@code built_in_analyzers}
         * </p>
         *
         * <p>
         * Adds a value to <code>builtInAnalyzers</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder builtInAnalyzers(Function<FieldTypes.Builder, ObjectBuilder<FieldTypes>> fn) {
            return builtInAnalyzers(fn.apply(new FieldTypes.Builder()).build());
        }

        /**
         * Required - Contains statistics about built-in character filters used in selected nodes.
         * <p>
         * API name: {@code built_in_char_filters}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>builtInCharFilters</code>.
         * </p>
         */
        @Nonnull
        public final Builder builtInCharFilters(List<FieldTypes> list) {
            this.builtInCharFilters = _listAddAll(this.builtInCharFilters, list);
            return this;
        }

        /**
         * Required - Contains statistics about built-in character filters used in selected nodes.
         * <p>
         * API name: {@code built_in_char_filters}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>builtInCharFilters</code>.
         * </p>
         */
        @Nonnull
        public final Builder builtInCharFilters(FieldTypes value, FieldTypes... values) {
            this.builtInCharFilters = _listAdd(this.builtInCharFilters, value, values);
            return this;
        }

        /**
         * Required - Contains statistics about built-in character filters used in selected nodes.
         * <p>
         * API name: {@code built_in_char_filters}
         * </p>
         *
         * <p>
         * Adds a value to <code>builtInCharFilters</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder builtInCharFilters(Function<FieldTypes.Builder, ObjectBuilder<FieldTypes>> fn) {
            return builtInCharFilters(fn.apply(new FieldTypes.Builder()).build());
        }

        /**
         * Required - Contains statistics about built-in token filters used in selected nodes.
         * <p>
         * API name: {@code built_in_filters}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>builtInFilters</code>.
         * </p>
         */
        @Nonnull
        public final Builder builtInFilters(List<FieldTypes> list) {
            this.builtInFilters = _listAddAll(this.builtInFilters, list);
            return this;
        }

        /**
         * Required - Contains statistics about built-in token filters used in selected nodes.
         * <p>
         * API name: {@code built_in_filters}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>builtInFilters</code>.
         * </p>
         */
        @Nonnull
        public final Builder builtInFilters(FieldTypes value, FieldTypes... values) {
            this.builtInFilters = _listAdd(this.builtInFilters, value, values);
            return this;
        }

        /**
         * Required - Contains statistics about built-in token filters used in selected nodes.
         * <p>
         * API name: {@code built_in_filters}
         * </p>
         *
         * <p>
         * Adds a value to <code>builtInFilters</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder builtInFilters(Function<FieldTypes.Builder, ObjectBuilder<FieldTypes>> fn) {
            return builtInFilters(fn.apply(new FieldTypes.Builder()).build());
        }

        /**
         * Required - Contains statistics about built-in tokenizers used in selected nodes.
         * <p>
         * API name: {@code built_in_tokenizers}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>builtInTokenizers</code>.
         * </p>
         */
        @Nonnull
        public final Builder builtInTokenizers(List<FieldTypes> list) {
            this.builtInTokenizers = _listAddAll(this.builtInTokenizers, list);
            return this;
        }

        /**
         * Required - Contains statistics about built-in tokenizers used in selected nodes.
         * <p>
         * API name: {@code built_in_tokenizers}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>builtInTokenizers</code>.
         * </p>
         */
        @Nonnull
        public final Builder builtInTokenizers(FieldTypes value, FieldTypes... values) {
            this.builtInTokenizers = _listAdd(this.builtInTokenizers, value, values);
            return this;
        }

        /**
         * Required - Contains statistics about built-in tokenizers used in selected nodes.
         * <p>
         * API name: {@code built_in_tokenizers}
         * </p>
         *
         * <p>
         * Adds a value to <code>builtInTokenizers</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder builtInTokenizers(Function<FieldTypes.Builder, ObjectBuilder<FieldTypes>> fn) {
            return builtInTokenizers(fn.apply(new FieldTypes.Builder()).build());
        }

        /**
         * Required - Contains statistics about character filter types used in selected nodes.
         * <p>
         * API name: {@code char_filter_types}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>charFilterTypes</code>.
         * </p>
         */
        @Nonnull
        public final Builder charFilterTypes(List<FieldTypes> list) {
            this.charFilterTypes = _listAddAll(this.charFilterTypes, list);
            return this;
        }

        /**
         * Required - Contains statistics about character filter types used in selected nodes.
         * <p>
         * API name: {@code char_filter_types}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>charFilterTypes</code>.
         * </p>
         */
        @Nonnull
        public final Builder charFilterTypes(FieldTypes value, FieldTypes... values) {
            this.charFilterTypes = _listAdd(this.charFilterTypes, value, values);
            return this;
        }

        /**
         * Required - Contains statistics about character filter types used in selected nodes.
         * <p>
         * API name: {@code char_filter_types}
         * </p>
         *
         * <p>
         * Adds a value to <code>charFilterTypes</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder charFilterTypes(Function<FieldTypes.Builder, ObjectBuilder<FieldTypes>> fn) {
            return charFilterTypes(fn.apply(new FieldTypes.Builder()).build());
        }

        /**
         * Required - Contains statistics about token filter types used in selected nodes.
         * <p>
         * API name: {@code filter_types}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>filterTypes</code>.
         * </p>
         */
        @Nonnull
        public final Builder filterTypes(List<FieldTypes> list) {
            this.filterTypes = _listAddAll(this.filterTypes, list);
            return this;
        }

        /**
         * Required - Contains statistics about token filter types used in selected nodes.
         * <p>
         * API name: {@code filter_types}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>filterTypes</code>.
         * </p>
         */
        @Nonnull
        public final Builder filterTypes(FieldTypes value, FieldTypes... values) {
            this.filterTypes = _listAdd(this.filterTypes, value, values);
            return this;
        }

        /**
         * Required - Contains statistics about token filter types used in selected nodes.
         * <p>
         * API name: {@code filter_types}
         * </p>
         *
         * <p>
         * Adds a value to <code>filterTypes</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder filterTypes(Function<FieldTypes.Builder, ObjectBuilder<FieldTypes>> fn) {
            return filterTypes(fn.apply(new FieldTypes.Builder()).build());
        }

        /**
         * Required - Contains statistics about tokenizer types used in selected nodes.
         * <p>
         * API name: {@code tokenizer_types}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>tokenizerTypes</code>.
         * </p>
         */
        @Nonnull
        public final Builder tokenizerTypes(List<FieldTypes> list) {
            this.tokenizerTypes = _listAddAll(this.tokenizerTypes, list);
            return this;
        }

        /**
         * Required - Contains statistics about tokenizer types used in selected nodes.
         * <p>
         * API name: {@code tokenizer_types}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>tokenizerTypes</code>.
         * </p>
         */
        @Nonnull
        public final Builder tokenizerTypes(FieldTypes value, FieldTypes... values) {
            this.tokenizerTypes = _listAdd(this.tokenizerTypes, value, values);
            return this;
        }

        /**
         * Required - Contains statistics about tokenizer types used in selected nodes.
         * <p>
         * API name: {@code tokenizer_types}
         * </p>
         *
         * <p>
         * Adds a value to <code>tokenizerTypes</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder tokenizerTypes(Function<FieldTypes.Builder, ObjectBuilder<FieldTypes>> fn) {
            return tokenizerTypes(fn.apply(new FieldTypes.Builder()).build());
        }

        /**
         * Builds a {@link CharFilterTypes}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public CharFilterTypes build() {
            _checkSingleUse();

            return new CharFilterTypes(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link CharFilterTypes}
     */
    public static final JsonpDeserializer<CharFilterTypes> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        CharFilterTypes::setupCharFilterTypesDeserializer
    );

    protected static void setupCharFilterTypesDeserializer(ObjectDeserializer<CharFilterTypes.Builder> op) {
        op.add(Builder::analyzerTypes, JsonpDeserializer.arrayDeserializer(FieldTypes._DESERIALIZER), "analyzer_types");
        op.add(Builder::builtInAnalyzers, JsonpDeserializer.arrayDeserializer(FieldTypes._DESERIALIZER), "built_in_analyzers");
        op.add(Builder::builtInCharFilters, JsonpDeserializer.arrayDeserializer(FieldTypes._DESERIALIZER), "built_in_char_filters");
        op.add(Builder::builtInFilters, JsonpDeserializer.arrayDeserializer(FieldTypes._DESERIALIZER), "built_in_filters");
        op.add(Builder::builtInTokenizers, JsonpDeserializer.arrayDeserializer(FieldTypes._DESERIALIZER), "built_in_tokenizers");
        op.add(Builder::charFilterTypes, JsonpDeserializer.arrayDeserializer(FieldTypes._DESERIALIZER), "char_filter_types");
        op.add(Builder::filterTypes, JsonpDeserializer.arrayDeserializer(FieldTypes._DESERIALIZER), "filter_types");
        op.add(Builder::tokenizerTypes, JsonpDeserializer.arrayDeserializer(FieldTypes._DESERIALIZER), "tokenizer_types");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.analyzerTypes.hashCode();
        result = 31 * result + this.builtInAnalyzers.hashCode();
        result = 31 * result + this.builtInCharFilters.hashCode();
        result = 31 * result + this.builtInFilters.hashCode();
        result = 31 * result + this.builtInTokenizers.hashCode();
        result = 31 * result + this.charFilterTypes.hashCode();
        result = 31 * result + this.filterTypes.hashCode();
        result = 31 * result + this.tokenizerTypes.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        CharFilterTypes other = (CharFilterTypes) o;
        return this.analyzerTypes.equals(other.analyzerTypes)
            && this.builtInAnalyzers.equals(other.builtInAnalyzers)
            && this.builtInCharFilters.equals(other.builtInCharFilters)
            && this.builtInFilters.equals(other.builtInFilters)
            && this.builtInTokenizers.equals(other.builtInTokenizers)
            && this.charFilterTypes.equals(other.charFilterTypes)
            && this.filterTypes.equals(other.filterTypes)
            && this.tokenizerTypes.equals(other.tokenizerTypes);
    }
}
