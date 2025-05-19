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

// typedef: _types.query_dsl.WildcardQuery

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class WildcardQuery extends QueryBase implements QueryVariant, ToCopyableBuilder<WildcardQuery.Builder, WildcardQuery> {

    @Nullable
    private final Boolean caseInsensitive;

    @Nonnull
    private final String field;

    @Nullable
    private final String rewrite;

    @Nullable
    private final String value;

    @Nullable
    private final String wildcard;

    // ---------------------------------------------------------------------------------------------

    private WildcardQuery(Builder builder) {
        super(builder);
        this.caseInsensitive = builder.caseInsensitive;
        this.field = ApiTypeHelper.requireNonNull(builder.field, this, "field");
        this.rewrite = builder.rewrite;
        this.value = builder.value;
        this.wildcard = builder.wildcard;
    }

    public static WildcardQuery of(Function<WildcardQuery.Builder, ObjectBuilder<WildcardQuery>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link Query} variant kind.
     */
    @Override
    public Query.Kind _queryKind() {
        return Query.Kind.Wildcard;
    }

    /**
     * Allows case insensitive matching of the pattern with the indexed field values when set to <code>true</code>. Default is
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
     * Wildcard pattern for terms you wish to find in the provided field. Required, when wildcard is not set.
     * <p>
     * API name: {@code value}
     * </p>
     */
    @Nullable
    public final String value() {
        return this.value;
    }

    /**
     * Wildcard pattern for terms you wish to find in the provided field. Required, when value is not set.
     * <p>
     * API name: {@code wildcard}
     * </p>
     */
    @Nullable
    public final String wildcard() {
        return this.wildcard;
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

        if (this.value != null) {
            generator.writeKey("value");
            generator.write(this.value);
        }

        if (this.wildcard != null) {
            generator.writeKey("wildcard");
            generator.write(this.wildcard);
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
     * Builder for {@link WildcardQuery}.
     */
    public static class Builder extends QueryBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, WildcardQuery> {
        @Nullable
        private Boolean caseInsensitive;
        private String field;
        @Nullable
        private String rewrite;
        @Nullable
        private String value;
        @Nullable
        private String wildcard;

        public Builder() {}

        private Builder(WildcardQuery o) {
            super(o);
            this.caseInsensitive = o.caseInsensitive;
            this.field = o.field;
            this.rewrite = o.rewrite;
            this.value = o.value;
            this.wildcard = o.wildcard;
        }

        private Builder(Builder o) {
            super(o);
            this.caseInsensitive = o.caseInsensitive;
            this.field = o.field;
            this.rewrite = o.rewrite;
            this.value = o.value;
            this.wildcard = o.wildcard;
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
         * Allows case insensitive matching of the pattern with the indexed field values when set to <code>true</code>. Default is
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
         * Wildcard pattern for terms you wish to find in the provided field. Required, when wildcard is not set.
         * <p>
         * API name: {@code value}
         * </p>
         */
        @Nonnull
        public final Builder value(@Nullable String value) {
            this.value = value;
            return this;
        }

        /**
         * Wildcard pattern for terms you wish to find in the provided field. Required, when value is not set.
         * <p>
         * API name: {@code wildcard}
         * </p>
         */
        @Nonnull
        public final Builder wildcard(@Nullable String value) {
            this.wildcard = value;
            return this;
        }

        /**
         * Builds a {@link WildcardQuery}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public WildcardQuery build() {
            _checkSingleUse();

            return new WildcardQuery(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link WildcardQuery}
     */
    public static final JsonpDeserializer<WildcardQuery> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        WildcardQuery::setupWildcardQueryDeserializer
    );

    protected static void setupWildcardQueryDeserializer(ObjectDeserializer<WildcardQuery.Builder> op) {
        setupQueryBaseDeserializer(op);
        op.add(Builder::caseInsensitive, JsonpDeserializer.booleanDeserializer(), "case_insensitive");
        op.add(Builder::rewrite, JsonpDeserializer.stringDeserializer(), "rewrite");
        op.add(Builder::value, JsonpDeserializer.stringDeserializer(), "value");
        op.add(Builder::wildcard, JsonpDeserializer.stringDeserializer(), "wildcard");
        op.setKey(Builder::field, JsonpDeserializer.stringDeserializer());

        op.shortcutProperty("value");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(this.caseInsensitive);
        result = 31 * result + this.field.hashCode();
        result = 31 * result + Objects.hashCode(this.rewrite);
        result = 31 * result + Objects.hashCode(this.value);
        result = 31 * result + Objects.hashCode(this.wildcard);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        WildcardQuery other = (WildcardQuery) o;
        return Objects.equals(this.caseInsensitive, other.caseInsensitive)
            && this.field.equals(other.field)
            && Objects.equals(this.rewrite, other.rewrite)
            && Objects.equals(this.value, other.value)
            && Objects.equals(this.wildcard, other.wildcard);
    }
}
