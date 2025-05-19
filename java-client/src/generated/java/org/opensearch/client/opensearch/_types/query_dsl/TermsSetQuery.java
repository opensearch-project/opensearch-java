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
import org.opensearch.client.opensearch._types.Script;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: _types.query_dsl.TermsSetQuery

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class TermsSetQuery extends QueryBase implements QueryVariant, ToCopyableBuilder<TermsSetQuery.Builder, TermsSetQuery> {

    @Nonnull
    private final String field;

    @Nullable
    private final String minimumShouldMatchField;

    @Nullable
    private final Script minimumShouldMatchScript;

    @Nonnull
    private final List<String> terms;

    // ---------------------------------------------------------------------------------------------

    private TermsSetQuery(Builder builder) {
        super(builder);
        this.field = ApiTypeHelper.requireNonNull(builder.field, this, "field");
        this.minimumShouldMatchField = builder.minimumShouldMatchField;
        this.minimumShouldMatchScript = builder.minimumShouldMatchScript;
        this.terms = ApiTypeHelper.unmodifiableRequired(builder.terms, this, "terms");
    }

    public static TermsSetQuery of(Function<TermsSetQuery.Builder, ObjectBuilder<TermsSetQuery>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link Query} variant kind.
     */
    @Override
    public Query.Kind _queryKind() {
        return Query.Kind.TermsSet;
    }

    /**
     * Required - The target field
     */
    @Nonnull
    public final String field() {
        return this.field;
    }

    /**
     * API name: {@code minimum_should_match_field}
     */
    @Nullable
    public final String minimumShouldMatchField() {
        return this.minimumShouldMatchField;
    }

    /**
     * API name: {@code minimum_should_match_script}
     */
    @Nullable
    public final Script minimumShouldMatchScript() {
        return this.minimumShouldMatchScript;
    }

    /**
     * Required - API name: {@code terms}
     */
    @Nonnull
    public final List<String> terms() {
        return this.terms;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        generator.writeStartObject(this.field);
        super.serializeInternal(generator, mapper);
        if (this.minimumShouldMatchField != null) {
            generator.writeKey("minimum_should_match_field");
            generator.write(this.minimumShouldMatchField);
        }

        if (this.minimumShouldMatchScript != null) {
            generator.writeKey("minimum_should_match_script");
            this.minimumShouldMatchScript.serialize(generator, mapper);
        }

        generator.writeKey("terms");
        generator.writeStartArray();
        for (String item0 : this.terms) {
            generator.write(item0);
        }
        generator.writeEnd();
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
     * Builder for {@link TermsSetQuery}.
     */
    public static class Builder extends QueryBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, TermsSetQuery> {
        private String field;
        @Nullable
        private String minimumShouldMatchField;
        @Nullable
        private Script minimumShouldMatchScript;
        private List<String> terms;

        public Builder() {}

        private Builder(TermsSetQuery o) {
            super(o);
            this.field = o.field;
            this.minimumShouldMatchField = o.minimumShouldMatchField;
            this.minimumShouldMatchScript = o.minimumShouldMatchScript;
            this.terms = _listCopy(o.terms);
        }

        private Builder(Builder o) {
            super(o);
            this.field = o.field;
            this.minimumShouldMatchField = o.minimumShouldMatchField;
            this.minimumShouldMatchScript = o.minimumShouldMatchScript;
            this.terms = _listCopy(o.terms);
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
         * Required - The target field
         */
        @Nonnull
        public final Builder field(String value) {
            this.field = value;
            return this;
        }

        /**
         * API name: {@code minimum_should_match_field}
         */
        @Nonnull
        public final Builder minimumShouldMatchField(@Nullable String value) {
            this.minimumShouldMatchField = value;
            return this;
        }

        /**
         * API name: {@code minimum_should_match_script}
         */
        @Nonnull
        public final Builder minimumShouldMatchScript(@Nullable Script value) {
            this.minimumShouldMatchScript = value;
            return this;
        }

        /**
         * API name: {@code minimum_should_match_script}
         */
        @Nonnull
        public final Builder minimumShouldMatchScript(Function<Script.Builder, ObjectBuilder<Script>> fn) {
            return minimumShouldMatchScript(fn.apply(new Script.Builder()).build());
        }

        /**
         * Required - API name: {@code terms}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>terms</code>.
         * </p>
         */
        @Nonnull
        public final Builder terms(List<String> list) {
            this.terms = _listAddAll(this.terms, list);
            return this;
        }

        /**
         * Required - API name: {@code terms}
         *
         * <p>
         * Adds one or more values to <code>terms</code>.
         * </p>
         */
        @Nonnull
        public final Builder terms(String value, String... values) {
            this.terms = _listAdd(this.terms, value, values);
            return this;
        }

        /**
         * Builds a {@link TermsSetQuery}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public TermsSetQuery build() {
            _checkSingleUse();

            return new TermsSetQuery(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link TermsSetQuery}
     */
    public static final JsonpDeserializer<TermsSetQuery> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        TermsSetQuery::setupTermsSetQueryDeserializer
    );

    protected static void setupTermsSetQueryDeserializer(ObjectDeserializer<TermsSetQuery.Builder> op) {
        setupQueryBaseDeserializer(op);
        op.add(Builder::minimumShouldMatchField, JsonpDeserializer.stringDeserializer(), "minimum_should_match_field");
        op.add(Builder::minimumShouldMatchScript, Script._DESERIALIZER, "minimum_should_match_script");
        op.add(Builder::terms, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "terms");
        op.setKey(Builder::field, JsonpDeserializer.stringDeserializer());
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + this.field.hashCode();
        result = 31 * result + Objects.hashCode(this.minimumShouldMatchField);
        result = 31 * result + Objects.hashCode(this.minimumShouldMatchScript);
        result = 31 * result + this.terms.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        TermsSetQuery other = (TermsSetQuery) o;
        return this.field.equals(other.field)
            && Objects.equals(this.minimumShouldMatchField, other.minimumShouldMatchField)
            && Objects.equals(this.minimumShouldMatchScript, other.minimumShouldMatchScript)
            && this.terms.equals(other.terms);
    }
}
