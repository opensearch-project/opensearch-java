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

package org.opensearch.client.opensearch._types.mapping;

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

// typedef: _types.mapping.FieldAliasProperty

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class FieldAliasProperty extends PropertyBase
    implements
        PropertyVariant,
        ToCopyableBuilder<FieldAliasProperty.Builder, FieldAliasProperty> {

    @Nullable
    private final String path;

    // ---------------------------------------------------------------------------------------------

    private FieldAliasProperty(Builder builder) {
        super(builder);
        this.path = builder.path;
    }

    public static FieldAliasProperty of(Function<FieldAliasProperty.Builder, ObjectBuilder<FieldAliasProperty>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link Property} variant kind.
     */
    @Override
    public Property.Kind _propertyKind() {
        return Property.Kind.Alias;
    }

    /**
     * API name: {@code path}
     */
    @Nullable
    public final String path() {
        return this.path;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        generator.write("type", "alias");
        super.serializeInternal(generator, mapper);
        if (this.path != null) {
            generator.writeKey("path");
            generator.write(this.path);
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
     * Builder for {@link FieldAliasProperty}.
     */
    public static class Builder extends PropertyBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, FieldAliasProperty> {
        @Nullable
        private String path;

        public Builder() {}

        private Builder(FieldAliasProperty o) {
            super(o);
            this.path = o.path;
        }

        private Builder(Builder o) {
            super(o);
            this.path = o.path;
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
         * API name: {@code path}
         */
        @Nonnull
        public final Builder path(@Nullable String value) {
            this.path = value;
            return this;
        }

        /**
         * Builds a {@link FieldAliasProperty}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public FieldAliasProperty build() {
            _checkSingleUse();

            return new FieldAliasProperty(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link FieldAliasProperty}
     */
    public static final JsonpDeserializer<FieldAliasProperty> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        FieldAliasProperty::setupFieldAliasPropertyDeserializer
    );

    protected static void setupFieldAliasPropertyDeserializer(ObjectDeserializer<FieldAliasProperty.Builder> op) {
        setupPropertyBaseDeserializer(op);
        op.add(Builder::path, JsonpDeserializer.stringDeserializer(), "path");

        op.ignore("type");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(this.path);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        FieldAliasProperty other = (FieldAliasProperty) o;
        return Objects.equals(this.path, other.path);
    }
}
