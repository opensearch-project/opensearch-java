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

// typedef: _types.analysis.IcuTransformTokenFilter

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class IcuTransformTokenFilter extends TokenFilterBase
    implements
        TokenFilterDefinitionVariant,
        ToCopyableBuilder<IcuTransformTokenFilter.Builder, IcuTransformTokenFilter> {

    @Nullable
    private final IcuTransformDirection dir;

    @Nonnull
    private final String id;

    // ---------------------------------------------------------------------------------------------

    private IcuTransformTokenFilter(Builder builder) {
        super(builder);
        this.dir = builder.dir;
        this.id = ApiTypeHelper.requireNonNull(builder.id, this, "id");
    }

    public static IcuTransformTokenFilter of(Function<IcuTransformTokenFilter.Builder, ObjectBuilder<IcuTransformTokenFilter>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link TokenFilterDefinition} variant kind.
     */
    @Override
    public TokenFilterDefinition.Kind _tokenFilterDefinitionKind() {
        return TokenFilterDefinition.Kind.IcuTransform;
    }

    /**
     * API name: {@code dir}
     */
    @Nullable
    public final IcuTransformDirection dir() {
        return this.dir;
    }

    /**
     * Required - API name: {@code id}
     */
    @Nonnull
    public final String id() {
        return this.id;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        generator.write("type", "icu_transform");
        super.serializeInternal(generator, mapper);
        if (this.dir != null) {
            generator.writeKey("dir");
            this.dir.serialize(generator, mapper);
        }

        generator.writeKey("id");
        generator.write(this.id);
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
     * Builder for {@link IcuTransformTokenFilter}.
     */
    public static class Builder extends TokenFilterBase.AbstractBuilder<Builder>
        implements
            CopyableBuilder<Builder, IcuTransformTokenFilter> {
        @Nullable
        private IcuTransformDirection dir;
        private String id;

        public Builder() {}

        private Builder(IcuTransformTokenFilter o) {
            super(o);
            this.dir = o.dir;
            this.id = o.id;
        }

        private Builder(Builder o) {
            super(o);
            this.dir = o.dir;
            this.id = o.id;
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
         * API name: {@code dir}
         */
        @Nonnull
        public final Builder dir(@Nullable IcuTransformDirection value) {
            this.dir = value;
            return this;
        }

        /**
         * Required - API name: {@code id}
         */
        @Nonnull
        public final Builder id(String value) {
            this.id = value;
            return this;
        }

        /**
         * Builds a {@link IcuTransformTokenFilter}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public IcuTransformTokenFilter build() {
            _checkSingleUse();

            return new IcuTransformTokenFilter(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link IcuTransformTokenFilter}
     */
    public static final JsonpDeserializer<IcuTransformTokenFilter> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        IcuTransformTokenFilter::setupIcuTransformTokenFilterDeserializer
    );

    protected static void setupIcuTransformTokenFilterDeserializer(ObjectDeserializer<IcuTransformTokenFilter.Builder> op) {
        setupTokenFilterBaseDeserializer(op);
        op.add(Builder::dir, IcuTransformDirection._DESERIALIZER, "dir");
        op.add(Builder::id, JsonpDeserializer.stringDeserializer(), "id");

        op.ignore("type");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(this.dir);
        result = 31 * result + this.id.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        IcuTransformTokenFilter other = (IcuTransformTokenFilter) o;
        return Objects.equals(this.dir, other.dir) && this.id.equals(other.id);
    }
}
