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
import org.opensearch.client.opensearch._types.FieldValue;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: _types.query_dsl.TermQuery

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class TermQuery extends QueryBase implements QueryVariant, ToCopyableBuilder<TermQuery.Builder, TermQuery> {

    @Nullable
    private final Boolean caseInsensitive;

    @Nonnull
    private final String field;

    @Nonnull
    private final FieldValue value;

    // ---------------------------------------------------------------------------------------------

    private TermQuery(Builder builder) {
        super(builder);
        this.caseInsensitive = builder.caseInsensitive;
        this.field = ApiTypeHelper.requireNonNull(builder.field, this, "field");
        this.value = ApiTypeHelper.requireNonNull(builder.value, this, "value");
    }

    public static TermQuery of(Function<TermQuery.Builder, ObjectBuilder<TermQuery>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link Query} variant kind.
     */
    @Override
    public Query.Kind _queryKind() {
        return Query.Kind.Term;
    }

    /**
     * Allows ASCII case insensitive matching of the value with the indexed field values when set to <code>true</code>. When
     * <code>false</code>, the case sensitivity of matching depends on the underlying field's mapping.
     * <p>
     * API name: {@code case_insensitive}
     * </p>
     */
    @Nullable
    public final Boolean caseInsensitive() {
        return this.caseInsensitive;
    }

    /**
     * Required - The target field
     */
    @Nonnull
    public final String field() {
        return this.field;
    }

    /**
     * Required - API name: {@code value}
     */
    @Nonnull
    public final FieldValue value() {
        return this.value;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        generator.writeStartObject(this.field);
        super.serializeInternal(generator, mapper);
        if (this.caseInsensitive != null) {
            generator.writeKey("case_insensitive");
            generator.write(this.caseInsensitive);
        }

        generator.writeKey("value");
        this.value.serialize(generator, mapper);
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
     * Builder for {@link TermQuery}.
     */
    public static class Builder extends QueryBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, TermQuery> {
        @Nullable
        private Boolean caseInsensitive;
        private String field;
        private FieldValue value;

        public Builder() {}

        private Builder(TermQuery o) {
            super(o);
            this.caseInsensitive = o.caseInsensitive;
            this.field = o.field;
            this.value = o.value;
        }

        private Builder(Builder o) {
            super(o);
            this.caseInsensitive = o.caseInsensitive;
            this.field = o.field;
            this.value = o.value;
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
         * Allows ASCII case insensitive matching of the value with the indexed field values when set to <code>true</code>. When
         * <code>false</code>, the case sensitivity of matching depends on the underlying field's mapping.
         * <p>
         * API name: {@code case_insensitive}
         * </p>
         */
        @Nonnull
        public final Builder caseInsensitive(@Nullable Boolean value) {
            this.caseInsensitive = value;
            return this;
        }

        /**
         * Required - The target field
         */
        @Nonnull
        public final Builder field(String value) {
            this.field = value;
            return this;
        }

        /**
         * Required - API name: {@code value}
         */
        @Nonnull
        public final Builder value(FieldValue value) {
            this.value = value;
            return this;
        }

        /**
         * Required - API name: {@code value}
         */
        @Nonnull
        public final Builder value(Function<FieldValue.Builder, ObjectBuilder<FieldValue>> fn) {
            return value(fn.apply(new FieldValue.Builder()).build());
        }

        /**
         * Builds a {@link TermQuery}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public TermQuery build() {
            _checkSingleUse();

            return new TermQuery(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link TermQuery}
     */
    public static final JsonpDeserializer<TermQuery> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        TermQuery::setupTermQueryDeserializer
    );

    protected static void setupTermQueryDeserializer(ObjectDeserializer<TermQuery.Builder> op) {
        setupQueryBaseDeserializer(op);
        op.add(Builder::caseInsensitive, JsonpDeserializer.booleanDeserializer(), "case_insensitive");
        op.add(Builder::value, FieldValue._DESERIALIZER, "value");
        op.setKey(Builder::field, JsonpDeserializer.stringDeserializer());

        op.shortcutProperty("value");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(this.caseInsensitive);
        result = 31 * result + this.field.hashCode();
        result = 31 * result + this.value.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        TermQuery other = (TermQuery) o;
        return Objects.equals(this.caseInsensitive, other.caseInsensitive)
            && this.field.equals(other.field)
            && this.value.equals(other.value);
    }
}
