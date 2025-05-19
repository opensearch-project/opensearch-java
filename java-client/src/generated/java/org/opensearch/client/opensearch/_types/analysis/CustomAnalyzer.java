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

// typedef: _types.analysis.CustomAnalyzer

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class CustomAnalyzer implements AnalyzerVariant, PlainJsonSerializable, ToCopyableBuilder<CustomAnalyzer.Builder, CustomAnalyzer> {

    @Nonnull
    private final List<String> charFilter;

    @Nonnull
    private final List<String> filter;

    @Nullable
    private final Integer positionIncrementGap;

    @Nullable
    private final Integer positionOffsetGap;

    @Nonnull
    private final String tokenizer;

    // ---------------------------------------------------------------------------------------------

    private CustomAnalyzer(Builder builder) {
        this.charFilter = ApiTypeHelper.unmodifiable(builder.charFilter);
        this.filter = ApiTypeHelper.unmodifiable(builder.filter);
        this.positionIncrementGap = builder.positionIncrementGap;
        this.positionOffsetGap = builder.positionOffsetGap;
        this.tokenizer = ApiTypeHelper.requireNonNull(builder.tokenizer, this, "tokenizer");
    }

    public static CustomAnalyzer of(Function<CustomAnalyzer.Builder, ObjectBuilder<CustomAnalyzer>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link Analyzer} variant kind.
     */
    @Override
    public Analyzer.Kind _analyzerKind() {
        return Analyzer.Kind.Custom;
    }

    /**
     * API name: {@code char_filter}
     */
    @Nonnull
    public final List<String> charFilter() {
        return this.charFilter;
    }

    /**
     * API name: {@code filter}
     */
    @Nonnull
    public final List<String> filter() {
        return this.filter;
    }

    /**
     * API name: {@code position_increment_gap}
     */
    @Nullable
    public final Integer positionIncrementGap() {
        return this.positionIncrementGap;
    }

    /**
     * API name: {@code position_offset_gap}
     */
    @Nullable
    public final Integer positionOffsetGap() {
        return this.positionOffsetGap;
    }

    /**
     * Required - API name: {@code tokenizer}
     */
    @Nonnull
    public final String tokenizer() {
        return this.tokenizer;
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
        generator.write("type", "custom");
        if (ApiTypeHelper.isDefined(this.charFilter)) {
            generator.writeKey("char_filter");
            generator.writeStartArray();
            for (String item0 : this.charFilter) {
                generator.write(item0);
            }
            generator.writeEnd();
        }

        if (ApiTypeHelper.isDefined(this.filter)) {
            generator.writeKey("filter");
            generator.writeStartArray();
            for (String item0 : this.filter) {
                generator.write(item0);
            }
            generator.writeEnd();
        }

        if (this.positionIncrementGap != null) {
            generator.writeKey("position_increment_gap");
            generator.write(this.positionIncrementGap);
        }

        if (this.positionOffsetGap != null) {
            generator.writeKey("position_offset_gap");
            generator.write(this.positionOffsetGap);
        }

        generator.writeKey("tokenizer");
        generator.write(this.tokenizer);
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
     * Builder for {@link CustomAnalyzer}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, CustomAnalyzer> {
        @Nullable
        private List<String> charFilter;
        @Nullable
        private List<String> filter;
        @Nullable
        private Integer positionIncrementGap;
        @Nullable
        private Integer positionOffsetGap;
        private String tokenizer;

        public Builder() {}

        private Builder(CustomAnalyzer o) {
            this.charFilter = _listCopy(o.charFilter);
            this.filter = _listCopy(o.filter);
            this.positionIncrementGap = o.positionIncrementGap;
            this.positionOffsetGap = o.positionOffsetGap;
            this.tokenizer = o.tokenizer;
        }

        private Builder(Builder o) {
            this.charFilter = _listCopy(o.charFilter);
            this.filter = _listCopy(o.filter);
            this.positionIncrementGap = o.positionIncrementGap;
            this.positionOffsetGap = o.positionOffsetGap;
            this.tokenizer = o.tokenizer;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code char_filter}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>charFilter</code>.
         * </p>
         */
        @Nonnull
        public final Builder charFilter(List<String> list) {
            this.charFilter = _listAddAll(this.charFilter, list);
            return this;
        }

        /**
         * API name: {@code char_filter}
         *
         * <p>
         * Adds one or more values to <code>charFilter</code>.
         * </p>
         */
        @Nonnull
        public final Builder charFilter(String value, String... values) {
            this.charFilter = _listAdd(this.charFilter, value, values);
            return this;
        }

        /**
         * API name: {@code filter}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>filter</code>.
         * </p>
         */
        @Nonnull
        public final Builder filter(List<String> list) {
            this.filter = _listAddAll(this.filter, list);
            return this;
        }

        /**
         * API name: {@code filter}
         *
         * <p>
         * Adds one or more values to <code>filter</code>.
         * </p>
         */
        @Nonnull
        public final Builder filter(String value, String... values) {
            this.filter = _listAdd(this.filter, value, values);
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
         * API name: {@code position_offset_gap}
         */
        @Nonnull
        public final Builder positionOffsetGap(@Nullable Integer value) {
            this.positionOffsetGap = value;
            return this;
        }

        /**
         * Required - API name: {@code tokenizer}
         */
        @Nonnull
        public final Builder tokenizer(String value) {
            this.tokenizer = value;
            return this;
        }

        /**
         * Builds a {@link CustomAnalyzer}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public CustomAnalyzer build() {
            _checkSingleUse();

            return new CustomAnalyzer(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link CustomAnalyzer}
     */
    public static final JsonpDeserializer<CustomAnalyzer> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        CustomAnalyzer::setupCustomAnalyzerDeserializer
    );

    protected static void setupCustomAnalyzerDeserializer(ObjectDeserializer<CustomAnalyzer.Builder> op) {
        op.add(Builder::charFilter, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "char_filter");
        op.add(Builder::filter, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "filter");
        op.add(Builder::positionIncrementGap, JsonpDeserializer.integerDeserializer(), "position_increment_gap");
        op.add(Builder::positionOffsetGap, JsonpDeserializer.integerDeserializer(), "position_offset_gap");
        op.add(Builder::tokenizer, JsonpDeserializer.stringDeserializer(), "tokenizer");

        op.ignore("type");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.charFilter);
        result = 31 * result + Objects.hashCode(this.filter);
        result = 31 * result + Objects.hashCode(this.positionIncrementGap);
        result = 31 * result + Objects.hashCode(this.positionOffsetGap);
        result = 31 * result + this.tokenizer.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        CustomAnalyzer other = (CustomAnalyzer) o;
        return Objects.equals(this.charFilter, other.charFilter)
            && Objects.equals(this.filter, other.filter)
            && Objects.equals(this.positionIncrementGap, other.positionIncrementGap)
            && Objects.equals(this.positionOffsetGap, other.positionOffsetGap)
            && this.tokenizer.equals(other.tokenizer);
    }
}
