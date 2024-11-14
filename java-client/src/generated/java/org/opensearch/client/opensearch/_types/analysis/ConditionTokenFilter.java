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
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
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

// typedef: _types.analysis.ConditionTokenFilter

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class ConditionTokenFilter extends TokenFilterBase
    implements
        TokenFilterDefinitionVariant,
        ToCopyableBuilder<ConditionTokenFilter.Builder, ConditionTokenFilter> {

    @Nonnull
    private final List<String> filter;

    @Nonnull
    private final Script script;

    // ---------------------------------------------------------------------------------------------

    private ConditionTokenFilter(Builder builder) {
        super(builder);
        this.filter = ApiTypeHelper.unmodifiableRequired(builder.filter, this, "filter");
        this.script = ApiTypeHelper.requireNonNull(builder.script, this, "script");
    }

    public static ConditionTokenFilter of(Function<ConditionTokenFilter.Builder, ObjectBuilder<ConditionTokenFilter>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link TokenFilterDefinition} variant kind.
     */
    @Override
    public TokenFilterDefinition.Kind _tokenFilterDefinitionKind() {
        return TokenFilterDefinition.Kind.Condition;
    }

    /**
     * Required - API name: {@code filter}
     */
    @Nonnull
    public final List<String> filter() {
        return this.filter;
    }

    /**
     * Required - API name: {@code script}
     */
    @Nonnull
    public final Script script() {
        return this.script;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        generator.write("type", "condition");
        super.serializeInternal(generator, mapper);
        generator.writeKey("filter");
        generator.writeStartArray();
        for (String item0 : this.filter) {
            generator.write(item0);
        }
        generator.writeEnd();

        generator.writeKey("script");
        this.script.serialize(generator, mapper);
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
     * Builder for {@link ConditionTokenFilter}.
     */
    public static class Builder extends TokenFilterBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, ConditionTokenFilter> {
        private List<String> filter;
        private Script script;

        public Builder() {}

        private Builder(ConditionTokenFilter o) {
            super(o);
            this.filter = _listCopy(o.filter);
            this.script = o.script;
        }

        private Builder(Builder o) {
            super(o);
            this.filter = _listCopy(o.filter);
            this.script = o.script;
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
         * Required - API name: {@code filter}
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
         * Required - API name: {@code filter}
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
         * Required - API name: {@code script}
         */
        @Nonnull
        public final Builder script(Script value) {
            this.script = value;
            return this;
        }

        /**
         * Required - API name: {@code script}
         */
        @Nonnull
        public final Builder script(Function<Script.Builder, ObjectBuilder<Script>> fn) {
            return script(fn.apply(new Script.Builder()).build());
        }

        /**
         * Builds a {@link ConditionTokenFilter}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ConditionTokenFilter build() {
            _checkSingleUse();

            return new ConditionTokenFilter(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ConditionTokenFilter}
     */
    public static final JsonpDeserializer<ConditionTokenFilter> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ConditionTokenFilter::setupConditionTokenFilterDeserializer
    );

    protected static void setupConditionTokenFilterDeserializer(ObjectDeserializer<ConditionTokenFilter.Builder> op) {
        setupTokenFilterBaseDeserializer(op);
        op.add(Builder::filter, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "filter");
        op.add(Builder::script, Script._DESERIALIZER, "script");

        op.ignore("type");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + this.filter.hashCode();
        result = 31 * result + this.script.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ConditionTokenFilter other = (ConditionTokenFilter) o;
        return this.filter.equals(other.filter) && this.script.equals(other.script);
    }
}
