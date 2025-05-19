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

// typedef: _types.mapping.TokenCountProperty

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class TokenCountProperty extends DocValuesPropertyBase
    implements
        PropertyVariant,
        ToCopyableBuilder<TokenCountProperty.Builder, TokenCountProperty> {

    @Nullable
    private final String analyzer;

    @Nullable
    private final Double boost;

    @Nullable
    private final Boolean enablePositionIncrements;

    @Nullable
    private final Boolean index;

    @Nullable
    private final Double nullValue;

    // ---------------------------------------------------------------------------------------------

    private TokenCountProperty(Builder builder) {
        super(builder);
        this.analyzer = builder.analyzer;
        this.boost = builder.boost;
        this.enablePositionIncrements = builder.enablePositionIncrements;
        this.index = builder.index;
        this.nullValue = builder.nullValue;
    }

    public static TokenCountProperty of(Function<TokenCountProperty.Builder, ObjectBuilder<TokenCountProperty>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link Property} variant kind.
     */
    @Override
    public Property.Kind _propertyKind() {
        return Property.Kind.TokenCount;
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
     * API name: {@code enable_position_increments}
     */
    @Nullable
    public final Boolean enablePositionIncrements() {
        return this.enablePositionIncrements;
    }

    /**
     * API name: {@code index}
     */
    @Nullable
    public final Boolean index() {
        return this.index;
    }

    /**
     * API name: {@code null_value}
     */
    @Nullable
    public final Double nullValue() {
        return this.nullValue;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        generator.write("type", "token_count");
        super.serializeInternal(generator, mapper);
        if (this.analyzer != null) {
            generator.writeKey("analyzer");
            generator.write(this.analyzer);
        }

        if (this.boost != null) {
            generator.writeKey("boost");
            generator.write(this.boost);
        }

        if (this.enablePositionIncrements != null) {
            generator.writeKey("enable_position_increments");
            generator.write(this.enablePositionIncrements);
        }

        if (this.index != null) {
            generator.writeKey("index");
            generator.write(this.index);
        }

        if (this.nullValue != null) {
            generator.writeKey("null_value");
            generator.write(this.nullValue);
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
     * Builder for {@link TokenCountProperty}.
     */
    public static class Builder extends DocValuesPropertyBase.AbstractBuilder<Builder>
        implements
            CopyableBuilder<Builder, TokenCountProperty> {
        @Nullable
        private String analyzer;
        @Nullable
        private Double boost;
        @Nullable
        private Boolean enablePositionIncrements;
        @Nullable
        private Boolean index;
        @Nullable
        private Double nullValue;

        public Builder() {}

        private Builder(TokenCountProperty o) {
            super(o);
            this.analyzer = o.analyzer;
            this.boost = o.boost;
            this.enablePositionIncrements = o.enablePositionIncrements;
            this.index = o.index;
            this.nullValue = o.nullValue;
        }

        private Builder(Builder o) {
            super(o);
            this.analyzer = o.analyzer;
            this.boost = o.boost;
            this.enablePositionIncrements = o.enablePositionIncrements;
            this.index = o.index;
            this.nullValue = o.nullValue;
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
         * API name: {@code enable_position_increments}
         */
        @Nonnull
        public final Builder enablePositionIncrements(@Nullable Boolean value) {
            this.enablePositionIncrements = value;
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
         * API name: {@code null_value}
         */
        @Nonnull
        public final Builder nullValue(@Nullable Double value) {
            this.nullValue = value;
            return this;
        }

        /**
         * Builds a {@link TokenCountProperty}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public TokenCountProperty build() {
            _checkSingleUse();

            return new TokenCountProperty(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link TokenCountProperty}
     */
    public static final JsonpDeserializer<TokenCountProperty> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        TokenCountProperty::setupTokenCountPropertyDeserializer
    );

    protected static void setupTokenCountPropertyDeserializer(ObjectDeserializer<TokenCountProperty.Builder> op) {
        setupDocValuesPropertyBaseDeserializer(op);
        op.add(Builder::analyzer, JsonpDeserializer.stringDeserializer(), "analyzer");
        op.add(Builder::boost, JsonpDeserializer.doubleDeserializer(), "boost");
        op.add(Builder::enablePositionIncrements, JsonpDeserializer.booleanDeserializer(), "enable_position_increments");
        op.add(Builder::index, JsonpDeserializer.booleanDeserializer(), "index");
        op.add(Builder::nullValue, JsonpDeserializer.doubleDeserializer(), "null_value");

        op.ignore("type");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(this.analyzer);
        result = 31 * result + Objects.hashCode(this.boost);
        result = 31 * result + Objects.hashCode(this.enablePositionIncrements);
        result = 31 * result + Objects.hashCode(this.index);
        result = 31 * result + Objects.hashCode(this.nullValue);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        TokenCountProperty other = (TokenCountProperty) o;
        return Objects.equals(this.analyzer, other.analyzer)
            && Objects.equals(this.boost, other.boost)
            && Objects.equals(this.enablePositionIncrements, other.enablePositionIncrements)
            && Objects.equals(this.index, other.index)
            && Objects.equals(this.nullValue, other.nullValue);
    }
}
