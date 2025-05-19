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

// typedef: _types.analysis.IcuNormalizationCharFilter

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class IcuNormalizationCharFilter extends CharFilterBase
    implements
        CharFilterDefinitionVariant,
        ToCopyableBuilder<IcuNormalizationCharFilter.Builder, IcuNormalizationCharFilter> {

    @Nullable
    private final IcuNormalizationMode mode;

    @Nullable
    private final IcuNormalizationType name;

    // ---------------------------------------------------------------------------------------------

    private IcuNormalizationCharFilter(Builder builder) {
        super(builder);
        this.mode = builder.mode;
        this.name = builder.name;
    }

    public static IcuNormalizationCharFilter of(
        Function<IcuNormalizationCharFilter.Builder, ObjectBuilder<IcuNormalizationCharFilter>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link CharFilterDefinition} variant kind.
     */
    @Override
    public CharFilterDefinition.Kind _charFilterDefinitionKind() {
        return CharFilterDefinition.Kind.IcuNormalizer;
    }

    /**
     * API name: {@code mode}
     */
    @Nullable
    public final IcuNormalizationMode mode() {
        return this.mode;
    }

    /**
     * API name: {@code name}
     */
    @Nullable
    public final IcuNormalizationType name() {
        return this.name;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        generator.write("type", "icu_normalizer");
        super.serializeInternal(generator, mapper);
        if (this.mode != null) {
            generator.writeKey("mode");
            this.mode.serialize(generator, mapper);
        }

        if (this.name != null) {
            generator.writeKey("name");
            this.name.serialize(generator, mapper);
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
     * Builder for {@link IcuNormalizationCharFilter}.
     */
    public static class Builder extends CharFilterBase.AbstractBuilder<Builder>
        implements
            CopyableBuilder<Builder, IcuNormalizationCharFilter> {
        @Nullable
        private IcuNormalizationMode mode;
        @Nullable
        private IcuNormalizationType name;

        public Builder() {}

        private Builder(IcuNormalizationCharFilter o) {
            super(o);
            this.mode = o.mode;
            this.name = o.name;
        }

        private Builder(Builder o) {
            super(o);
            this.mode = o.mode;
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
         * API name: {@code mode}
         */
        @Nonnull
        public final Builder mode(@Nullable IcuNormalizationMode value) {
            this.mode = value;
            return this;
        }

        /**
         * API name: {@code name}
         */
        @Nonnull
        public final Builder name(@Nullable IcuNormalizationType value) {
            this.name = value;
            return this;
        }

        /**
         * Builds a {@link IcuNormalizationCharFilter}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public IcuNormalizationCharFilter build() {
            _checkSingleUse();

            return new IcuNormalizationCharFilter(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link IcuNormalizationCharFilter}
     */
    public static final JsonpDeserializer<IcuNormalizationCharFilter> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        IcuNormalizationCharFilter::setupIcuNormalizationCharFilterDeserializer
    );

    protected static void setupIcuNormalizationCharFilterDeserializer(ObjectDeserializer<IcuNormalizationCharFilter.Builder> op) {
        setupCharFilterBaseDeserializer(op);
        op.add(Builder::mode, IcuNormalizationMode._DESERIALIZER, "mode");
        op.add(Builder::name, IcuNormalizationType._DESERIALIZER, "name");

        op.ignore("type");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(this.mode);
        result = 31 * result + Objects.hashCode(this.name);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        IcuNormalizationCharFilter other = (IcuNormalizationCharFilter) o;
        return Objects.equals(this.mode, other.mode) && Objects.equals(this.name, other.name);
    }
}
