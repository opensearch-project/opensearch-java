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

// typedef: _types.analysis.HunspellTokenFilter

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class HunspellTokenFilter extends TokenFilterBase
    implements
        TokenFilterDefinitionVariant,
        ToCopyableBuilder<HunspellTokenFilter.Builder, HunspellTokenFilter> {

    @Nullable
    private final Boolean dedup;

    @Nullable
    private final String dictionary;

    @Nonnull
    private final String locale;

    @Nullable
    private final Boolean longestOnly;

    // ---------------------------------------------------------------------------------------------

    private HunspellTokenFilter(Builder builder) {
        super(builder);
        this.dedup = builder.dedup;
        this.dictionary = builder.dictionary;
        this.locale = ApiTypeHelper.requireNonNull(builder.locale, this, "locale");
        this.longestOnly = builder.longestOnly;
    }

    public static HunspellTokenFilter of(Function<HunspellTokenFilter.Builder, ObjectBuilder<HunspellTokenFilter>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link TokenFilterDefinition} variant kind.
     */
    @Override
    public TokenFilterDefinition.Kind _tokenFilterDefinitionKind() {
        return TokenFilterDefinition.Kind.Hunspell;
    }

    /**
     * API name: {@code dedup}
     */
    @Nullable
    public final Boolean dedup() {
        return this.dedup;
    }

    /**
     * API name: {@code dictionary}
     */
    @Nullable
    public final String dictionary() {
        return this.dictionary;
    }

    /**
     * Required - API name: {@code locale}
     */
    @Nonnull
    public final String locale() {
        return this.locale;
    }

    /**
     * API name: {@code longest_only}
     */
    @Nullable
    public final Boolean longestOnly() {
        return this.longestOnly;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        generator.write("type", "hunspell");
        super.serializeInternal(generator, mapper);
        if (this.dedup != null) {
            generator.writeKey("dedup");
            generator.write(this.dedup);
        }

        if (this.dictionary != null) {
            generator.writeKey("dictionary");
            generator.write(this.dictionary);
        }

        generator.writeKey("locale");
        generator.write(this.locale);

        if (this.longestOnly != null) {
            generator.writeKey("longest_only");
            generator.write(this.longestOnly);
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
     * Builder for {@link HunspellTokenFilter}.
     */
    public static class Builder extends TokenFilterBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, HunspellTokenFilter> {
        @Nullable
        private Boolean dedup;
        @Nullable
        private String dictionary;
        private String locale;
        @Nullable
        private Boolean longestOnly;

        public Builder() {}

        private Builder(HunspellTokenFilter o) {
            super(o);
            this.dedup = o.dedup;
            this.dictionary = o.dictionary;
            this.locale = o.locale;
            this.longestOnly = o.longestOnly;
        }

        private Builder(Builder o) {
            super(o);
            this.dedup = o.dedup;
            this.dictionary = o.dictionary;
            this.locale = o.locale;
            this.longestOnly = o.longestOnly;
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
         * API name: {@code dedup}
         */
        @Nonnull
        public final Builder dedup(@Nullable Boolean value) {
            this.dedup = value;
            return this;
        }

        /**
         * API name: {@code dictionary}
         */
        @Nonnull
        public final Builder dictionary(@Nullable String value) {
            this.dictionary = value;
            return this;
        }

        /**
         * Required - API name: {@code locale}
         */
        @Nonnull
        public final Builder locale(String value) {
            this.locale = value;
            return this;
        }

        /**
         * API name: {@code longest_only}
         */
        @Nonnull
        public final Builder longestOnly(@Nullable Boolean value) {
            this.longestOnly = value;
            return this;
        }

        /**
         * Builds a {@link HunspellTokenFilter}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public HunspellTokenFilter build() {
            _checkSingleUse();

            return new HunspellTokenFilter(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link HunspellTokenFilter}
     */
    public static final JsonpDeserializer<HunspellTokenFilter> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        HunspellTokenFilter::setupHunspellTokenFilterDeserializer
    );

    protected static void setupHunspellTokenFilterDeserializer(ObjectDeserializer<HunspellTokenFilter.Builder> op) {
        setupTokenFilterBaseDeserializer(op);
        op.add(Builder::dedup, JsonpDeserializer.booleanDeserializer(), "dedup");
        op.add(Builder::dictionary, JsonpDeserializer.stringDeserializer(), "dictionary");
        op.add(Builder::locale, JsonpDeserializer.stringDeserializer(), "locale");
        op.add(Builder::longestOnly, JsonpDeserializer.booleanDeserializer(), "longest_only");

        op.ignore("type");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(this.dedup);
        result = 31 * result + Objects.hashCode(this.dictionary);
        result = 31 * result + this.locale.hashCode();
        result = 31 * result + Objects.hashCode(this.longestOnly);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        HunspellTokenFilter other = (HunspellTokenFilter) o;
        return Objects.equals(this.dedup, other.dedup)
            && Objects.equals(this.dictionary, other.dictionary)
            && this.locale.equals(other.locale)
            && Objects.equals(this.longestOnly, other.longestOnly);
    }
}
