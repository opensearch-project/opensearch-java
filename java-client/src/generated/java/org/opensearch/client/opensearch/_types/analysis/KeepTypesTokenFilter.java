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

// typedef: _types.analysis.KeepTypesTokenFilter

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class KeepTypesTokenFilter extends TokenFilterBase
    implements
        TokenFilterDefinitionVariant,
        ToCopyableBuilder<KeepTypesTokenFilter.Builder, KeepTypesTokenFilter> {

    @Nullable
    private final KeepTypesMode mode;

    @Nonnull
    private final List<String> types;

    // ---------------------------------------------------------------------------------------------

    private KeepTypesTokenFilter(Builder builder) {
        super(builder);
        this.mode = builder.mode;
        this.types = ApiTypeHelper.unmodifiable(builder.types);
    }

    public static KeepTypesTokenFilter of(Function<KeepTypesTokenFilter.Builder, ObjectBuilder<KeepTypesTokenFilter>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link TokenFilterDefinition} variant kind.
     */
    @Override
    public TokenFilterDefinition.Kind _tokenFilterDefinitionKind() {
        return TokenFilterDefinition.Kind.KeepTypes;
    }

    /**
     * API name: {@code mode}
     */
    @Nullable
    public final KeepTypesMode mode() {
        return this.mode;
    }

    /**
     * API name: {@code types}
     */
    @Nonnull
    public final List<String> types() {
        return this.types;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        generator.write("type", "keep_types");
        super.serializeInternal(generator, mapper);
        if (this.mode != null) {
            generator.writeKey("mode");
            this.mode.serialize(generator, mapper);
        }

        if (ApiTypeHelper.isDefined(this.types)) {
            generator.writeKey("types");
            generator.writeStartArray();
            for (String item0 : this.types) {
                generator.write(item0);
            }
            generator.writeEnd();
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
     * Builder for {@link KeepTypesTokenFilter}.
     */
    public static class Builder extends TokenFilterBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, KeepTypesTokenFilter> {
        @Nullable
        private KeepTypesMode mode;
        @Nullable
        private List<String> types;

        public Builder() {}

        private Builder(KeepTypesTokenFilter o) {
            super(o);
            this.mode = o.mode;
            this.types = _listCopy(o.types);
        }

        private Builder(Builder o) {
            super(o);
            this.mode = o.mode;
            this.types = _listCopy(o.types);
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
        public final Builder mode(@Nullable KeepTypesMode value) {
            this.mode = value;
            return this;
        }

        /**
         * API name: {@code types}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>types</code>.
         * </p>
         */
        @Nonnull
        public final Builder types(List<String> list) {
            this.types = _listAddAll(this.types, list);
            return this;
        }

        /**
         * API name: {@code types}
         *
         * <p>
         * Adds one or more values to <code>types</code>.
         * </p>
         */
        @Nonnull
        public final Builder types(String value, String... values) {
            this.types = _listAdd(this.types, value, values);
            return this;
        }

        /**
         * Builds a {@link KeepTypesTokenFilter}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public KeepTypesTokenFilter build() {
            _checkSingleUse();

            return new KeepTypesTokenFilter(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link KeepTypesTokenFilter}
     */
    public static final JsonpDeserializer<KeepTypesTokenFilter> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        KeepTypesTokenFilter::setupKeepTypesTokenFilterDeserializer
    );

    protected static void setupKeepTypesTokenFilterDeserializer(ObjectDeserializer<KeepTypesTokenFilter.Builder> op) {
        setupTokenFilterBaseDeserializer(op);
        op.add(Builder::mode, KeepTypesMode._DESERIALIZER, "mode");
        op.add(Builder::types, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "types");

        op.ignore("type");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(this.mode);
        result = 31 * result + Objects.hashCode(this.types);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        KeepTypesTokenFilter other = (KeepTypesTokenFilter) o;
        return Objects.equals(this.mode, other.mode) && Objects.equals(this.types, other.types);
    }
}
