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
import org.opensearch.client.json.JsonData;
import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: _types.mapping.ConstantKeywordProperty

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class ConstantKeywordProperty extends PropertyBase
    implements
        PropertyVariant,
        ToCopyableBuilder<ConstantKeywordProperty.Builder, ConstantKeywordProperty> {

    @Nullable
    private final JsonData value;

    // ---------------------------------------------------------------------------------------------

    private ConstantKeywordProperty(Builder builder) {
        super(builder);
        this.value = builder.value;
    }

    public static ConstantKeywordProperty of(Function<ConstantKeywordProperty.Builder, ObjectBuilder<ConstantKeywordProperty>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link Property} variant kind.
     */
    @Override
    public Property.Kind _propertyKind() {
        return Property.Kind.ConstantKeyword;
    }

    /**
     * API name: {@code value}
     */
    @Nullable
    public final JsonData value() {
        return this.value;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        generator.write("type", "constant_keyword");
        super.serializeInternal(generator, mapper);
        if (this.value != null) {
            generator.writeKey("value");
            this.value.serialize(generator, mapper);
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
     * Builder for {@link ConstantKeywordProperty}.
     */
    public static class Builder extends PropertyBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, ConstantKeywordProperty> {
        @Nullable
        private JsonData value;

        public Builder() {}

        private Builder(ConstantKeywordProperty o) {
            super(o);
            this.value = o.value;
        }

        private Builder(Builder o) {
            super(o);
            this.value = o.value;
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
         * API name: {@code value}
         */
        @Nonnull
        public final Builder value(@Nullable JsonData value) {
            this.value = value;
            return this;
        }

        /**
         * Builds a {@link ConstantKeywordProperty}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ConstantKeywordProperty build() {
            _checkSingleUse();

            return new ConstantKeywordProperty(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ConstantKeywordProperty}
     */
    public static final JsonpDeserializer<ConstantKeywordProperty> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ConstantKeywordProperty::setupConstantKeywordPropertyDeserializer
    );

    protected static void setupConstantKeywordPropertyDeserializer(ObjectDeserializer<ConstantKeywordProperty.Builder> op) {
        setupPropertyBaseDeserializer(op);
        op.add(Builder::value, JsonData._DESERIALIZER, "value");

        op.ignore("type");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(this.value);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ConstantKeywordProperty other = (ConstantKeywordProperty) o;
        return Objects.equals(this.value, other.value);
    }
}
