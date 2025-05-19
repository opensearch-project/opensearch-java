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
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: _types.mapping.KeywordProperty

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class KeywordProperty extends DocValuesPropertyBase
    implements
        PropertyVariant,
        ToCopyableBuilder<KeywordProperty.Builder, KeywordProperty> {

    @Nullable
    private final Double boost;

    @Nullable
    private final Boolean eagerGlobalOrdinals;

    @Nullable
    private final Boolean index;

    @Nullable
    private final IndexOptions indexOptions;

    @Nullable
    private final String normalizer;

    @Nullable
    private final Boolean norms;

    @Nullable
    private final String nullValue;

    @Nullable
    private final Boolean splitQueriesOnWhitespace;

    // ---------------------------------------------------------------------------------------------

    private KeywordProperty(Builder builder) {
        super(builder);
        this.boost = builder.boost;
        this.eagerGlobalOrdinals = builder.eagerGlobalOrdinals;
        this.index = builder.index;
        this.indexOptions = builder.indexOptions;
        this.normalizer = builder.normalizer;
        this.norms = builder.norms;
        this.nullValue = builder.nullValue;
        this.splitQueriesOnWhitespace = builder.splitQueriesOnWhitespace;
    }

    public static KeywordProperty of(Function<KeywordProperty.Builder, ObjectBuilder<KeywordProperty>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link Property} variant kind.
     */
    @Override
    public Property.Kind _propertyKind() {
        return Property.Kind.Keyword;
    }

    /**
     * API name: {@code boost}
     */
    @Nullable
    public final Double boost() {
        return this.boost;
    }

    /**
     * API name: {@code eager_global_ordinals}
     */
    @Nullable
    public final Boolean eagerGlobalOrdinals() {
        return this.eagerGlobalOrdinals;
    }

    /**
     * API name: {@code index}
     */
    @Nullable
    public final Boolean index() {
        return this.index;
    }

    /**
     * API name: {@code index_options}
     */
    @Nullable
    public final IndexOptions indexOptions() {
        return this.indexOptions;
    }

    /**
     * API name: {@code normalizer}
     */
    @Nullable
    public final String normalizer() {
        return this.normalizer;
    }

    /**
     * API name: {@code norms}
     */
    @Nullable
    public final Boolean norms() {
        return this.norms;
    }

    /**
     * API name: {@code null_value}
     */
    @Nullable
    public final String nullValue() {
        return this.nullValue;
    }

    /**
     * API name: {@code split_queries_on_whitespace}
     */
    @Nullable
    public final Boolean splitQueriesOnWhitespace() {
        return this.splitQueriesOnWhitespace;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        generator.write("type", "keyword");
        super.serializeInternal(generator, mapper);
        if (this.boost != null) {
            generator.writeKey("boost");
            generator.write(this.boost);
        }

        if (this.eagerGlobalOrdinals != null) {
            generator.writeKey("eager_global_ordinals");
            generator.write(this.eagerGlobalOrdinals);
        }

        if (this.index != null) {
            generator.writeKey("index");
            generator.write(this.index);
        }

        if (this.indexOptions != null) {
            generator.writeKey("index_options");
            this.indexOptions.serialize(generator, mapper);
        }

        if (this.normalizer != null) {
            generator.writeKey("normalizer");
            generator.write(this.normalizer);
        }

        if (this.norms != null) {
            generator.writeKey("norms");
            generator.write(this.norms);
        }

        if (this.nullValue != null) {
            generator.writeKey("null_value");
            generator.write(this.nullValue);
        }

        if (this.splitQueriesOnWhitespace != null) {
            generator.writeKey("split_queries_on_whitespace");
            generator.write(this.splitQueriesOnWhitespace);
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
     * Builder for {@link KeywordProperty}.
     */
    public static class Builder extends DocValuesPropertyBase.AbstractBuilder<Builder>
        implements
            CopyableBuilder<Builder, KeywordProperty> {
        @Nullable
        private Double boost;
        @Nullable
        private Boolean eagerGlobalOrdinals;
        @Nullable
        private Boolean index;
        @Nullable
        private IndexOptions indexOptions;
        @Nullable
        private String normalizer;
        @Nullable
        private Boolean norms;
        @Nullable
        private String nullValue;
        @Nullable
        private Boolean splitQueriesOnWhitespace;

        public Builder() {}

        private Builder(KeywordProperty o) {
            super(o);
            this.boost = o.boost;
            this.eagerGlobalOrdinals = o.eagerGlobalOrdinals;
            this.index = o.index;
            this.indexOptions = o.indexOptions;
            this.normalizer = o.normalizer;
            this.norms = o.norms;
            this.nullValue = o.nullValue;
            this.splitQueriesOnWhitespace = o.splitQueriesOnWhitespace;
        }

        private Builder(Builder o) {
            super(o);
            this.boost = o.boost;
            this.eagerGlobalOrdinals = o.eagerGlobalOrdinals;
            this.index = o.index;
            this.indexOptions = o.indexOptions;
            this.normalizer = o.normalizer;
            this.norms = o.norms;
            this.nullValue = o.nullValue;
            this.splitQueriesOnWhitespace = o.splitQueriesOnWhitespace;
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
         * API name: {@code boost}
         */
        @Nonnull
        public final Builder boost(@Nullable Double value) {
            this.boost = value;
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
         * API name: {@code index}
         */
        @Nonnull
        public final Builder index(@Nullable Boolean value) {
            this.index = value;
            return this;
        }

        /**
         * API name: {@code index_options}
         */
        @Nonnull
        public final Builder indexOptions(@Nullable IndexOptions value) {
            this.indexOptions = value;
            return this;
        }

        /**
         * API name: {@code normalizer}
         */
        @Nonnull
        public final Builder normalizer(@Nullable String value) {
            this.normalizer = value;
            return this;
        }

        /**
         * API name: {@code norms}
         */
        @Nonnull
        public final Builder norms(@Nullable Boolean value) {
            this.norms = value;
            return this;
        }

        /**
         * API name: {@code null_value}
         */
        @Nonnull
        public final Builder nullValue(@Nullable String value) {
            this.nullValue = value;
            return this;
        }

        /**
         * API name: {@code split_queries_on_whitespace}
         */
        @Nonnull
        public final Builder splitQueriesOnWhitespace(@Nullable Boolean value) {
            this.splitQueriesOnWhitespace = value;
            return this;
        }

        /**
         * Builds a {@link KeywordProperty}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public KeywordProperty build() {
            _checkSingleUse();

            return new KeywordProperty(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link KeywordProperty}
     */
    public static final JsonpDeserializer<KeywordProperty> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        KeywordProperty::setupKeywordPropertyDeserializer
    );

    protected static void setupKeywordPropertyDeserializer(ObjectDeserializer<KeywordProperty.Builder> op) {
        setupDocValuesPropertyBaseDeserializer(op);
        op.add(Builder::boost, JsonpDeserializer.doubleDeserializer(), "boost");
        op.add(Builder::eagerGlobalOrdinals, JsonpDeserializer.booleanDeserializer(), "eager_global_ordinals");
        op.add(Builder::index, JsonpDeserializer.booleanDeserializer(), "index");
        op.add(Builder::indexOptions, IndexOptions._DESERIALIZER, "index_options");
        op.add(Builder::normalizer, JsonpDeserializer.stringDeserializer(), "normalizer");
        op.add(Builder::norms, JsonpDeserializer.booleanDeserializer(), "norms");
        op.add(Builder::nullValue, JsonpDeserializer.stringDeserializer(), "null_value");
        op.add(Builder::splitQueriesOnWhitespace, JsonpDeserializer.booleanDeserializer(), "split_queries_on_whitespace");

        op.ignore("type");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(this.boost);
        result = 31 * result + Objects.hashCode(this.eagerGlobalOrdinals);
        result = 31 * result + Objects.hashCode(this.index);
        result = 31 * result + Objects.hashCode(this.indexOptions);
        result = 31 * result + Objects.hashCode(this.normalizer);
        result = 31 * result + Objects.hashCode(this.norms);
        result = 31 * result + Objects.hashCode(this.nullValue);
        result = 31 * result + Objects.hashCode(this.splitQueriesOnWhitespace);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        KeywordProperty other = (KeywordProperty) o;
        return Objects.equals(this.boost, other.boost)
            && Objects.equals(this.eagerGlobalOrdinals, other.eagerGlobalOrdinals)
            && Objects.equals(this.index, other.index)
            && Objects.equals(this.indexOptions, other.indexOptions)
            && Objects.equals(this.normalizer, other.normalizer)
            && Objects.equals(this.norms, other.norms)
            && Objects.equals(this.nullValue, other.nullValue)
            && Objects.equals(this.splitQueriesOnWhitespace, other.splitQueriesOnWhitespace);
    }
}
