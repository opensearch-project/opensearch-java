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

// typedef: _types.query_dsl.PrefixQuery

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class PrefixQuery extends QueryBase implements QueryVariant, ToCopyableBuilder<PrefixQuery.Builder, PrefixQuery> {

    @Nullable
    private final Boolean caseInsensitive;

    @Nonnull
    private final String field;

    @Nullable
    private final String rewrite;

    @Nonnull
    private final String value;

    // ---------------------------------------------------------------------------------------------

    private PrefixQuery(Builder builder) {
        super(builder);
        this.caseInsensitive = builder.caseInsensitive;
        this.field = ApiTypeHelper.requireNonNull(builder.field, this, "field");
        this.rewrite = builder.rewrite;
        this.value = ApiTypeHelper.requireNonNull(builder.value, this, "value");
    }

    public static PrefixQuery of(Function<PrefixQuery.Builder, ObjectBuilder<PrefixQuery>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link Query} variant kind.
     */
    @Override
    public Query.Kind _queryKind() {
        return Query.Kind.Prefix;
    }

    /**
     * Allows ASCII case insensitive matching of the value with the indexed field values when set to <code>true</code>. Default is
     * <code>false</code> which means the case sensitivity of matching depends on the underlying field's mapping.
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
     * API name: {@code rewrite}
     */
    @Nullable
    public final String rewrite() {
        return this.rewrite;
    }

    /**
     * Required - Beginning characters of terms you wish to find in the provided field.
     * <p>
     * API name: {@code value}
     * </p>
     */
    @Nonnull
    public final String value() {
        return this.value;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        generator.writeStartObject(this.field);
        super.serializeInternal(generator, mapper);
        if (this.caseInsensitive != null) {
            generator.writeKey("case_insensitive");
            generator.write(this.caseInsensitive);
        }

        if (this.rewrite != null) {
            generator.writeKey("rewrite");
            generator.write(this.rewrite);
        }

        generator.writeKey("value");
        generator.write(this.value);
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
     * Builder for {@link PrefixQuery}.
     */
    public static class Builder extends QueryBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, PrefixQuery> {
        @Nullable
        private Boolean caseInsensitive;
        private String field;
        @Nullable
        private String rewrite;
        private String value;

        public Builder() {}

        private Builder(PrefixQuery o) {
            super(o);
            this.caseInsensitive = o.caseInsensitive;
            this.field = o.field;
            this.rewrite = o.rewrite;
            this.value = o.value;
        }

        private Builder(Builder o) {
            super(o);
            this.caseInsensitive = o.caseInsensitive;
            this.field = o.field;
            this.rewrite = o.rewrite;
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
         * Allows ASCII case insensitive matching of the value with the indexed field values when set to <code>true</code>. Default is
         * <code>false</code> which means the case sensitivity of matching depends on the underlying field's mapping.
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
         * API name: {@code rewrite}
         */
        @Nonnull
        public final Builder rewrite(@Nullable String value) {
            this.rewrite = value;
            return this;
        }

        /**
         * Required - Beginning characters of terms you wish to find in the provided field.
         * <p>
         * API name: {@code value}
         * </p>
         */
        @Nonnull
        public final Builder value(String value) {
            this.value = value;
            return this;
        }

        /**
         * Builds a {@link PrefixQuery}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public PrefixQuery build() {
            _checkSingleUse();

            return new PrefixQuery(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link PrefixQuery}
     */
    public static final JsonpDeserializer<PrefixQuery> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        PrefixQuery::setupPrefixQueryDeserializer
    );

    protected static void setupPrefixQueryDeserializer(ObjectDeserializer<PrefixQuery.Builder> op) {
        setupQueryBaseDeserializer(op);
        op.add(Builder::caseInsensitive, JsonpDeserializer.booleanDeserializer(), "case_insensitive");
        op.add(Builder::rewrite, JsonpDeserializer.stringDeserializer(), "rewrite");
        op.add(Builder::value, JsonpDeserializer.stringDeserializer(), "value");
        op.setKey(Builder::field, JsonpDeserializer.stringDeserializer());

        op.shortcutProperty("value");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(this.caseInsensitive);
        result = 31 * result + this.field.hashCode();
        result = 31 * result + Objects.hashCode(this.rewrite);
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
        PrefixQuery other = (PrefixQuery) o;
        return Objects.equals(this.caseInsensitive, other.caseInsensitive)
            && this.field.equals(other.field)
            && Objects.equals(this.rewrite, other.rewrite)
            && this.value.equals(other.value);
    }
}
