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

// typedef: _types.analysis.LengthTokenFilter

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class LengthTokenFilter extends TokenFilterBase
    implements
        TokenFilterDefinitionVariant,
        ToCopyableBuilder<LengthTokenFilter.Builder, LengthTokenFilter> {

    @Nullable
    private final Integer max;

    @Nullable
    private final Integer min;

    // ---------------------------------------------------------------------------------------------

    private LengthTokenFilter(Builder builder) {
        super(builder);
        this.max = builder.max;
        this.min = builder.min;
    }

    public static LengthTokenFilter of(Function<LengthTokenFilter.Builder, ObjectBuilder<LengthTokenFilter>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link TokenFilterDefinition} variant kind.
     */
    @Override
    public TokenFilterDefinition.Kind _tokenFilterDefinitionKind() {
        return TokenFilterDefinition.Kind.Length;
    }

    /**
     * API name: {@code max}
     */
    @Nullable
    public final Integer max() {
        return this.max;
    }

    /**
     * API name: {@code min}
     */
    @Nullable
    public final Integer min() {
        return this.min;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        generator.write("type", "length");
        super.serializeInternal(generator, mapper);
        if (this.max != null) {
            generator.writeKey("max");
            generator.write(this.max);
        }

        if (this.min != null) {
            generator.writeKey("min");
            generator.write(this.min);
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
     * Builder for {@link LengthTokenFilter}.
     */
    public static class Builder extends TokenFilterBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, LengthTokenFilter> {
        @Nullable
        private Integer max;
        @Nullable
        private Integer min;

        public Builder() {}

        private Builder(LengthTokenFilter o) {
            super(o);
            this.max = o.max;
            this.min = o.min;
        }

        private Builder(Builder o) {
            super(o);
            this.max = o.max;
            this.min = o.min;
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
         * API name: {@code max}
         */
        @Nonnull
        public final Builder max(@Nullable Integer value) {
            this.max = value;
            return this;
        }

        /**
         * API name: {@code min}
         */
        @Nonnull
        public final Builder min(@Nullable Integer value) {
            this.min = value;
            return this;
        }

        /**
         * Builds a {@link LengthTokenFilter}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public LengthTokenFilter build() {
            _checkSingleUse();

            return new LengthTokenFilter(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link LengthTokenFilter}
     */
    public static final JsonpDeserializer<LengthTokenFilter> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        LengthTokenFilter::setupLengthTokenFilterDeserializer
    );

    protected static void setupLengthTokenFilterDeserializer(ObjectDeserializer<LengthTokenFilter.Builder> op) {
        setupTokenFilterBaseDeserializer(op);
        op.add(Builder::max, JsonpDeserializer.integerDeserializer(), "max");
        op.add(Builder::min, JsonpDeserializer.integerDeserializer(), "min");

        op.ignore("type");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(this.max);
        result = 31 * result + Objects.hashCode(this.min);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        LengthTokenFilter other = (LengthTokenFilter) o;
        return Objects.equals(this.max, other.max) && Objects.equals(this.min, other.min);
    }
}
