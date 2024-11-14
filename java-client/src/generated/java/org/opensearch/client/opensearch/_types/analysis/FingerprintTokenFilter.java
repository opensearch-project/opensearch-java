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
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: _types.analysis.FingerprintTokenFilter

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class FingerprintTokenFilter extends TokenFilterBase
    implements
        TokenFilterDefinitionVariant,
        ToCopyableBuilder<FingerprintTokenFilter.Builder, FingerprintTokenFilter> {

    @Nullable
    private final Integer maxOutputSize;

    @Nullable
    private final String separator;

    // ---------------------------------------------------------------------------------------------

    private FingerprintTokenFilter(Builder builder) {
        super(builder);
        this.maxOutputSize = builder.maxOutputSize;
        this.separator = builder.separator;
    }

    public static FingerprintTokenFilter of(Function<FingerprintTokenFilter.Builder, ObjectBuilder<FingerprintTokenFilter>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link TokenFilterDefinition} variant kind.
     */
    @Override
    public TokenFilterDefinition.Kind _tokenFilterDefinitionKind() {
        return TokenFilterDefinition.Kind.Fingerprint;
    }

    /**
     * API name: {@code max_output_size}
     */
    @Nullable
    public final Integer maxOutputSize() {
        return this.maxOutputSize;
    }

    /**
     * API name: {@code separator}
     */
    @Nullable
    public final String separator() {
        return this.separator;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        generator.write("type", "fingerprint");
        super.serializeInternal(generator, mapper);
        if (this.maxOutputSize != null) {
            generator.writeKey("max_output_size");
            generator.write(this.maxOutputSize);
        }

        if (this.separator != null) {
            generator.writeKey("separator");
            generator.write(this.separator);
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
     * Builder for {@link FingerprintTokenFilter}.
     */
    public static class Builder extends TokenFilterBase.AbstractBuilder<Builder>
        implements
            CopyableBuilder<Builder, FingerprintTokenFilter> {
        @Nullable
        private Integer maxOutputSize;
        @Nullable
        private String separator;

        public Builder() {}

        private Builder(FingerprintTokenFilter o) {
            super(o);
            this.maxOutputSize = o.maxOutputSize;
            this.separator = o.separator;
        }

        private Builder(Builder o) {
            super(o);
            this.maxOutputSize = o.maxOutputSize;
            this.separator = o.separator;
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
         * API name: {@code max_output_size}
         */
        @Nonnull
        public final Builder maxOutputSize(@Nullable Integer value) {
            this.maxOutputSize = value;
            return this;
        }

        /**
         * API name: {@code separator}
         */
        @Nonnull
        public final Builder separator(@Nullable String value) {
            this.separator = value;
            return this;
        }

        /**
         * Builds a {@link FingerprintTokenFilter}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public FingerprintTokenFilter build() {
            _checkSingleUse();

            return new FingerprintTokenFilter(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link FingerprintTokenFilter}
     */
    public static final JsonpDeserializer<FingerprintTokenFilter> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        FingerprintTokenFilter::setupFingerprintTokenFilterDeserializer
    );

    protected static void setupFingerprintTokenFilterDeserializer(ObjectDeserializer<FingerprintTokenFilter.Builder> op) {
        setupTokenFilterBaseDeserializer(op);
        op.add(Builder::maxOutputSize, JsonpDeserializer.integerDeserializer(), "max_output_size");
        op.add(Builder::separator, JsonpDeserializer.stringDeserializer(), "separator");

        op.ignore("type");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(this.maxOutputSize);
        result = 31 * result + Objects.hashCode(this.separator);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        FingerprintTokenFilter other = (FingerprintTokenFilter) o;
        return Objects.equals(this.maxOutputSize, other.maxOutputSize) && Objects.equals(this.separator, other.separator);
    }
}
