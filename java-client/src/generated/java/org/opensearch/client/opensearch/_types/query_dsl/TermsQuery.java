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

package org.opensearch.client.opensearch._types.query_dsl;

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
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: _types.query_dsl.TermsQuery

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class TermsQuery extends QueryBase implements QueryVariant, ToCopyableBuilder<TermsQuery.Builder, TermsQuery> {

    @Nonnull
    private final String field;

    @Nonnull
    private final TermsQueryField terms;

    @Nullable
    private final TermsQueryValueType valueType;

    // ---------------------------------------------------------------------------------------------

    private TermsQuery(Builder builder) {
        super(builder);
        this.field = ApiTypeHelper.requireNonNull(builder.field, this, "field");
        this.terms = ApiTypeHelper.requireNonNull(builder.terms, this, "terms");
        this.valueType = builder.valueType;
    }

    public static TermsQuery of(Function<TermsQuery.Builder, ObjectBuilder<TermsQuery>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link Query} variant kind.
     */
    @Override
    public Query.Kind _queryKind() {
        return Query.Kind.Terms;
    }

    /**
     * Required -
     */
    @Nonnull
    public final String field() {
        return this.field;
    }

    /**
     * Required -
     */
    @Nonnull
    public final TermsQueryField terms() {
        return this.terms;
    }

    /**
     * Specifies the types of values used for filtering. Valid values are <code>default</code> and <code>bitmap</code>. Default is
     * <code>default</code>.
     * <p>
     * API name: {@code value_type}
     * </p>
     */
    @Nullable
    public final TermsQueryValueType valueType() {
        return this.valueType;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        super.serializeInternal(generator, mapper);
        generator.writeKey(this.field);
        this.terms.serialize(generator, mapper);
        if (this.valueType != null) {
            generator.writeKey("value_type");
            this.valueType.serialize(generator, mapper);
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
     * Builder for {@link TermsQuery}.
     */
    public static class Builder extends QueryBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, TermsQuery> {
        private String field;
        private TermsQueryField terms;
        @Nullable
        private TermsQueryValueType valueType;

        public Builder() {}

        private Builder(TermsQuery o) {
            super(o);
            this.field = o.field;
            this.terms = o.terms;
            this.valueType = o.valueType;
        }

        private Builder(Builder o) {
            super(o);
            this.field = o.field;
            this.terms = o.terms;
            this.valueType = o.valueType;
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
         * Required -
         */
        @Nonnull
        public final Builder field(String value) {
            this.field = value;
            return this;
        }

        /**
         * Required -
         */
        @Nonnull
        public final Builder terms(TermsQueryField value) {
            this.terms = value;
            return this;
        }

        /**
         * Required -
         */
        @Nonnull
        public final Builder terms(Function<TermsQueryField.Builder, ObjectBuilder<TermsQueryField>> fn) {
            return terms(fn.apply(new TermsQueryField.Builder()).build());
        }

        /**
         * Specifies the types of values used for filtering. Valid values are <code>default</code> and <code>bitmap</code>. Default is
         * <code>default</code>.
         * <p>
         * API name: {@code value_type}
         * </p>
         */
        @Nonnull
        public final Builder valueType(@Nullable TermsQueryValueType value) {
            this.valueType = value;
            return this;
        }

        /**
         * Builds a {@link TermsQuery}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public TermsQuery build() {
            _checkSingleUse();

            return new TermsQuery(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link TermsQuery}
     */
    public static final JsonpDeserializer<TermsQuery> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        TermsQuery::setupTermsQueryDeserializer
    );

    protected static void setupTermsQueryDeserializer(ObjectDeserializer<TermsQuery.Builder> op) {
        setupQueryBaseDeserializer(op);
        op.add(Builder::valueType, TermsQueryValueType._DESERIALIZER, "value_type");
        op.setUnknownFieldHandler((builder, name, parser, mapper) -> {
            builder.field(name);
            builder.terms(TermsQueryField._DESERIALIZER.deserialize(parser, mapper));
        });
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + this.field.hashCode();
        result = 31 * result + this.terms.hashCode();
        result = 31 * result + Objects.hashCode(this.valueType);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        TermsQuery other = (TermsQuery) o;
        return this.field.equals(other.field) && this.terms.equals(other.terms) && Objects.equals(this.valueType, other.valueType);
    }
}
