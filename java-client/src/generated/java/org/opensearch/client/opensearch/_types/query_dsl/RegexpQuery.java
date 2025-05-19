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

// typedef: _types.query_dsl.RegexpQuery

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class RegexpQuery extends QueryBase implements QueryVariant, ToCopyableBuilder<RegexpQuery.Builder, RegexpQuery> {

    @Nullable
    private final Boolean caseInsensitive;

    @Nonnull
    private final String field;

    @Nullable
    private final String flags;

    @Nullable
    private final Integer maxDeterminizedStates;

    @Nullable
    private final String rewrite;

    @Nonnull
    private final String value;

    // ---------------------------------------------------------------------------------------------

    private RegexpQuery(Builder builder) {
        super(builder);
        this.caseInsensitive = builder.caseInsensitive;
        this.field = ApiTypeHelper.requireNonNull(builder.field, this, "field");
        this.flags = builder.flags;
        this.maxDeterminizedStates = builder.maxDeterminizedStates;
        this.rewrite = builder.rewrite;
        this.value = ApiTypeHelper.requireNonNull(builder.value, this, "value");
    }

    public static RegexpQuery of(Function<RegexpQuery.Builder, ObjectBuilder<RegexpQuery>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link Query} variant kind.
     */
    @Override
    public Query.Kind _queryKind() {
        return Query.Kind.Regexp;
    }

    /**
     * Allows case insensitive matching of the regular expression value with the indexed field values when set to <code>true</code>. When
     * <code>false</code>, case sensitivity of matching depends on the underlying field's mapping.
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
     * Enables optional operators for the regular expression.
     * <p>
     * API name: {@code flags}
     * </p>
     */
    @Nullable
    public final String flags() {
        return this.flags;
    }

    /**
     * Maximum number of automaton states required for the query.
     * <p>
     * API name: {@code max_determinized_states}
     * </p>
     */
    @Nullable
    public final Integer maxDeterminizedStates() {
        return this.maxDeterminizedStates;
    }

    /**
     * API name: {@code rewrite}
     */
    @Nullable
    public final String rewrite() {
        return this.rewrite;
    }

    /**
     * Required - Regular expression for terms you wish to find in the provided field.
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

        if (this.flags != null) {
            generator.writeKey("flags");
            generator.write(this.flags);
        }

        if (this.maxDeterminizedStates != null) {
            generator.writeKey("max_determinized_states");
            generator.write(this.maxDeterminizedStates);
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
     * Builder for {@link RegexpQuery}.
     */
    public static class Builder extends QueryBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, RegexpQuery> {
        @Nullable
        private Boolean caseInsensitive;
        private String field;
        @Nullable
        private String flags;
        @Nullable
        private Integer maxDeterminizedStates;
        @Nullable
        private String rewrite;
        private String value;

        public Builder() {}

        private Builder(RegexpQuery o) {
            super(o);
            this.caseInsensitive = o.caseInsensitive;
            this.field = o.field;
            this.flags = o.flags;
            this.maxDeterminizedStates = o.maxDeterminizedStates;
            this.rewrite = o.rewrite;
            this.value = o.value;
        }

        private Builder(Builder o) {
            super(o);
            this.caseInsensitive = o.caseInsensitive;
            this.field = o.field;
            this.flags = o.flags;
            this.maxDeterminizedStates = o.maxDeterminizedStates;
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
         * Allows case insensitive matching of the regular expression value with the indexed field values when set to <code>true</code>.
         * When <code>false</code>, case sensitivity of matching depends on the underlying field's mapping.
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
         * Enables optional operators for the regular expression.
         * <p>
         * API name: {@code flags}
         * </p>
         */
        @Nonnull
        public final Builder flags(@Nullable String value) {
            this.flags = value;
            return this;
        }

        /**
         * Maximum number of automaton states required for the query.
         * <p>
         * API name: {@code max_determinized_states}
         * </p>
         */
        @Nonnull
        public final Builder maxDeterminizedStates(@Nullable Integer value) {
            this.maxDeterminizedStates = value;
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
         * Required - Regular expression for terms you wish to find in the provided field.
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
         * Builds a {@link RegexpQuery}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public RegexpQuery build() {
            _checkSingleUse();

            return new RegexpQuery(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link RegexpQuery}
     */
    public static final JsonpDeserializer<RegexpQuery> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        RegexpQuery::setupRegexpQueryDeserializer
    );

    protected static void setupRegexpQueryDeserializer(ObjectDeserializer<RegexpQuery.Builder> op) {
        setupQueryBaseDeserializer(op);
        op.add(Builder::caseInsensitive, JsonpDeserializer.booleanDeserializer(), "case_insensitive");
        op.add(Builder::flags, JsonpDeserializer.stringDeserializer(), "flags");
        op.add(Builder::maxDeterminizedStates, JsonpDeserializer.integerDeserializer(), "max_determinized_states");
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
        result = 31 * result + Objects.hashCode(this.flags);
        result = 31 * result + Objects.hashCode(this.maxDeterminizedStates);
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
        RegexpQuery other = (RegexpQuery) o;
        return Objects.equals(this.caseInsensitive, other.caseInsensitive)
            && this.field.equals(other.field)
            && Objects.equals(this.flags, other.flags)
            && Objects.equals(this.maxDeterminizedStates, other.maxDeterminizedStates)
            && Objects.equals(this.rewrite, other.rewrite)
            && this.value.equals(other.value);
    }
}
