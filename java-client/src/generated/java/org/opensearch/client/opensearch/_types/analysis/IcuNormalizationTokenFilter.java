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

// typedef: _types.analysis.IcuNormalizationTokenFilter

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class IcuNormalizationTokenFilter extends TokenFilterBase
    implements
        TokenFilterDefinitionVariant,
        ToCopyableBuilder<IcuNormalizationTokenFilter.Builder, IcuNormalizationTokenFilter> {

    @Nonnull
    private final IcuNormalizationType name;

    // ---------------------------------------------------------------------------------------------

    private IcuNormalizationTokenFilter(Builder builder) {
        super(builder);
        this.name = ApiTypeHelper.requireNonNull(builder.name, this, "name");
    }

    public static IcuNormalizationTokenFilter of(
        Function<IcuNormalizationTokenFilter.Builder, ObjectBuilder<IcuNormalizationTokenFilter>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link TokenFilterDefinition} variant kind.
     */
    @Override
    public TokenFilterDefinition.Kind _tokenFilterDefinitionKind() {
        return TokenFilterDefinition.Kind.IcuNormalizer;
    }

    /**
     * Required - API name: {@code name}
     */
    @Nonnull
    public final IcuNormalizationType name() {
        return this.name;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        generator.write("type", "icu_normalizer");
        super.serializeInternal(generator, mapper);
        generator.writeKey("name");
        this.name.serialize(generator, mapper);
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
     * Builder for {@link IcuNormalizationTokenFilter}.
     */
    public static class Builder extends TokenFilterBase.AbstractBuilder<Builder>
        implements
            CopyableBuilder<Builder, IcuNormalizationTokenFilter> {
        private IcuNormalizationType name;

        public Builder() {}

        private Builder(IcuNormalizationTokenFilter o) {
            super(o);
            this.name = o.name;
        }

        private Builder(Builder o) {
            super(o);
            this.name = o.name;
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
         * Required - API name: {@code name}
         */
        @Nonnull
        public final Builder name(IcuNormalizationType value) {
            this.name = value;
            return this;
        }

        /**
         * Builds a {@link IcuNormalizationTokenFilter}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public IcuNormalizationTokenFilter build() {
            _checkSingleUse();

            return new IcuNormalizationTokenFilter(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link IcuNormalizationTokenFilter}
     */
    public static final JsonpDeserializer<IcuNormalizationTokenFilter> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        IcuNormalizationTokenFilter::setupIcuNormalizationTokenFilterDeserializer
    );

    protected static void setupIcuNormalizationTokenFilterDeserializer(ObjectDeserializer<IcuNormalizationTokenFilter.Builder> op) {
        setupTokenFilterBaseDeserializer(op);
        op.add(Builder::name, IcuNormalizationType._DESERIALIZER, "name");

        op.ignore("type");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + this.name.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        IcuNormalizationTokenFilter other = (IcuNormalizationTokenFilter) o;
        return this.name.equals(other.name);
    }
}
