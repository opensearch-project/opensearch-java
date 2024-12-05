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
import org.opensearch.client.opensearch._types.analysis.Analyzer;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: core.search.HighlightField

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class HighlightField extends HighlightBase implements ToCopyableBuilder<HighlightField.Builder, HighlightField> {

    @Nullable
    private final Analyzer analyzer;

    @Nonnull
    private final List<String> matchedFields;

    // ---------------------------------------------------------------------------------------------

    private HighlightField(Builder builder) {
        super(builder);
        this.analyzer = builder.analyzer;
        this.matchedFields = ApiTypeHelper.unmodifiable(builder.matchedFields);
    }

    public static HighlightField of(Function<HighlightField.Builder, ObjectBuilder<HighlightField>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code analyzer}
     */
    @Nullable
    public final Analyzer analyzer() {
        return this.analyzer;
    }

    /**
     * API name: {@code matched_fields}
     */
    @Nonnull
    public final List<String> matchedFields() {
        return this.matchedFields;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        super.serializeInternal(generator, mapper);
        if (this.analyzer != null) {
            generator.writeKey("analyzer");
            this.analyzer.serialize(generator, mapper);
        }

        if (ApiTypeHelper.isDefined(this.matchedFields)) {
            generator.writeKey("matched_fields");
            generator.writeStartArray();
            for (String item0 : this.matchedFields) {
                generator.write(item0);
            }
            generator.writeEnd();
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
     * Builder for {@link HighlightField}.
     */
    public static class Builder extends HighlightBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, HighlightField> {
        @Nullable
        private Analyzer analyzer;
        @Nullable
        private List<String> matchedFields;

        public Builder() {}

        private Builder(HighlightField o) {
            super(o);
            this.analyzer = o.analyzer;
            this.matchedFields = _listCopy(o.matchedFields);
        }

        private Builder(Builder o) {
            super(o);
            this.analyzer = o.analyzer;
            this.matchedFields = _listCopy(o.matchedFields);
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        @Override
        @Nonnull
        protected Builder self() {
            return this;
        }

        /**
         * API name: {@code analyzer}
         */
        @Nonnull
        public final Builder analyzer(@Nullable Analyzer value) {
            this.analyzer = value;
            return this;
        }

        /**
         * API name: {@code analyzer}
         */
        @Nonnull
        public final Builder analyzer(Function<Analyzer.Builder, ObjectBuilder<Analyzer>> fn) {
            return analyzer(fn.apply(new Analyzer.Builder()).build());
        }

        /**
         * API name: {@code matched_fields}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>matchedFields</code>.
         * </p>
         */
        @Nonnull
        public final Builder matchedFields(List<String> list) {
            this.matchedFields = _listAddAll(this.matchedFields, list);
            return this;
        }

        /**
         * API name: {@code matched_fields}
         *
         * <p>
         * Adds one or more values to <code>matchedFields</code>.
         * </p>
         */
        @Nonnull
        public final Builder matchedFields(String value, String... values) {
            this.matchedFields = _listAdd(this.matchedFields, value, values);
            return this;
        }

        /**
         * Builds a {@link HighlightField}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public HighlightField build() {
            _checkSingleUse();

            return new HighlightField(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link HighlightField}
     */
    public static final JsonpDeserializer<HighlightField> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        HighlightField::setupHighlightFieldDeserializer
    );

    protected static void setupHighlightFieldDeserializer(ObjectDeserializer<HighlightField.Builder> op) {
        setupHighlightBaseDeserializer(op);
        op.add(Builder::analyzer, Analyzer._DESERIALIZER, "analyzer");
        op.add(Builder::matchedFields, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "matched_fields");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(this.analyzer);
        result = 31 * result + Objects.hashCode(this.matchedFields);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        HighlightField other = (HighlightField) o;
        return Objects.equals(this.analyzer, other.analyzer) && Objects.equals(this.matchedFields, other.matchedFields);
    }
}
