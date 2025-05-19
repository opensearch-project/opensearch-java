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

// typedef: _types.analysis.StemmerOverrideTokenFilter

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class StemmerOverrideTokenFilter extends TokenFilterBase
    implements
        TokenFilterDefinitionVariant,
        ToCopyableBuilder<StemmerOverrideTokenFilter.Builder, StemmerOverrideTokenFilter> {

    @Nonnull
    private final List<String> rules;

    @Nullable
    private final String rulesPath;

    // ---------------------------------------------------------------------------------------------

    private StemmerOverrideTokenFilter(Builder builder) {
        super(builder);
        this.rules = ApiTypeHelper.unmodifiable(builder.rules);
        this.rulesPath = builder.rulesPath;
    }

    public static StemmerOverrideTokenFilter of(
        Function<StemmerOverrideTokenFilter.Builder, ObjectBuilder<StemmerOverrideTokenFilter>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link TokenFilterDefinition} variant kind.
     */
    @Override
    public TokenFilterDefinition.Kind _tokenFilterDefinitionKind() {
        return TokenFilterDefinition.Kind.StemmerOverride;
    }

    /**
     * API name: {@code rules}
     */
    @Nonnull
    public final List<String> rules() {
        return this.rules;
    }

    /**
     * API name: {@code rules_path}
     */
    @Nullable
    public final String rulesPath() {
        return this.rulesPath;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        generator.write("type", "stemmer_override");
        super.serializeInternal(generator, mapper);
        if (ApiTypeHelper.isDefined(this.rules)) {
            generator.writeKey("rules");
            generator.writeStartArray();
            for (String item0 : this.rules) {
                generator.write(item0);
            }
            generator.writeEnd();
        }

        if (this.rulesPath != null) {
            generator.writeKey("rules_path");
            generator.write(this.rulesPath);
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
     * Builder for {@link StemmerOverrideTokenFilter}.
     */
    public static class Builder extends TokenFilterBase.AbstractBuilder<Builder>
        implements
            CopyableBuilder<Builder, StemmerOverrideTokenFilter> {
        @Nullable
        private List<String> rules;
        @Nullable
        private String rulesPath;

        public Builder() {}

        private Builder(StemmerOverrideTokenFilter o) {
            super(o);
            this.rules = _listCopy(o.rules);
            this.rulesPath = o.rulesPath;
        }

        private Builder(Builder o) {
            super(o);
            this.rules = _listCopy(o.rules);
            this.rulesPath = o.rulesPath;
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
         * API name: {@code rules}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>rules</code>.
         * </p>
         */
        @Nonnull
        public final Builder rules(List<String> list) {
            this.rules = _listAddAll(this.rules, list);
            return this;
        }

        /**
         * API name: {@code rules}
         *
         * <p>
         * Adds one or more values to <code>rules</code>.
         * </p>
         */
        @Nonnull
        public final Builder rules(String value, String... values) {
            this.rules = _listAdd(this.rules, value, values);
            return this;
        }

        /**
         * API name: {@code rules_path}
         */
        @Nonnull
        public final Builder rulesPath(@Nullable String value) {
            this.rulesPath = value;
            return this;
        }

        /**
         * Builds a {@link StemmerOverrideTokenFilter}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public StemmerOverrideTokenFilter build() {
            _checkSingleUse();

            return new StemmerOverrideTokenFilter(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link StemmerOverrideTokenFilter}
     */
    public static final JsonpDeserializer<StemmerOverrideTokenFilter> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        StemmerOverrideTokenFilter::setupStemmerOverrideTokenFilterDeserializer
    );

    protected static void setupStemmerOverrideTokenFilterDeserializer(ObjectDeserializer<StemmerOverrideTokenFilter.Builder> op) {
        setupTokenFilterBaseDeserializer(op);
        op.add(Builder::rules, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "rules");
        op.add(Builder::rulesPath, JsonpDeserializer.stringDeserializer(), "rules_path");

        op.ignore("type");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(this.rules);
        result = 31 * result + Objects.hashCode(this.rulesPath);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        StemmerOverrideTokenFilter other = (StemmerOverrideTokenFilter) o;
        return Objects.equals(this.rules, other.rules) && Objects.equals(this.rulesPath, other.rulesPath);
    }
}
