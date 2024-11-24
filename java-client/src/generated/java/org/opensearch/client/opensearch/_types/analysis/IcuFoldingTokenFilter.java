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
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: _types.analysis.IcuFoldingTokenFilter

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class IcuFoldingTokenFilter extends TokenFilterBase
    implements
        TokenFilterDefinitionVariant,
        ToCopyableBuilder<IcuFoldingTokenFilter.Builder, IcuFoldingTokenFilter> {

    @Nonnull
    private final String unicodeSetFilter;

    // ---------------------------------------------------------------------------------------------

    private IcuFoldingTokenFilter(Builder builder) {
        super(builder);
        this.unicodeSetFilter = ApiTypeHelper.requireNonNull(builder.unicodeSetFilter, this, "unicodeSetFilter");
    }

    public static IcuFoldingTokenFilter of(Function<IcuFoldingTokenFilter.Builder, ObjectBuilder<IcuFoldingTokenFilter>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link TokenFilterDefinition} variant kind.
     */
    @Override
    public TokenFilterDefinition.Kind _tokenFilterDefinitionKind() {
        return TokenFilterDefinition.Kind.IcuFolding;
    }

    /**
     * Required - API name: {@code unicode_set_filter}
     */
    @Nonnull
    public final String unicodeSetFilter() {
        return this.unicodeSetFilter;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        generator.write("type", "icu_folding");
        super.serializeInternal(generator, mapper);
        generator.writeKey("unicode_set_filter");
        generator.write(this.unicodeSetFilter);
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
     * Builder for {@link IcuFoldingTokenFilter}.
     */
    public static class Builder extends TokenFilterBase.AbstractBuilder<Builder>
        implements
            CopyableBuilder<Builder, IcuFoldingTokenFilter> {
        private String unicodeSetFilter;

        public Builder() {}

        private Builder(IcuFoldingTokenFilter o) {
            super(o);
            this.unicodeSetFilter = o.unicodeSetFilter;
        }

        private Builder(Builder o) {
            super(o);
            this.unicodeSetFilter = o.unicodeSetFilter;
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
         * Required - API name: {@code unicode_set_filter}
         */
        @Nonnull
        public final Builder unicodeSetFilter(String value) {
            this.unicodeSetFilter = value;
            return this;
        }

        /**
         * Builds a {@link IcuFoldingTokenFilter}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public IcuFoldingTokenFilter build() {
            _checkSingleUse();

            return new IcuFoldingTokenFilter(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link IcuFoldingTokenFilter}
     */
    public static final JsonpDeserializer<IcuFoldingTokenFilter> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        IcuFoldingTokenFilter::setupIcuFoldingTokenFilterDeserializer
    );

    protected static void setupIcuFoldingTokenFilterDeserializer(ObjectDeserializer<IcuFoldingTokenFilter.Builder> op) {
        setupTokenFilterBaseDeserializer(op);
        op.add(Builder::unicodeSetFilter, JsonpDeserializer.stringDeserializer(), "unicode_set_filter");

        op.ignore("type");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + this.unicodeSetFilter.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        IcuFoldingTokenFilter other = (IcuFoldingTokenFilter) o;
        return this.unicodeSetFilter.equals(other.unicodeSetFilter);
    }
}
