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

// typedef: _types.mapping.ScaledFloatNumberProperty

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class ScaledFloatNumberProperty extends NumberPropertyBase
    implements
        PropertyVariant,
        ToCopyableBuilder<ScaledFloatNumberProperty.Builder, ScaledFloatNumberProperty> {

    @Nullable
    private final Double nullValue;

    @Nullable
    private final Double scalingFactor;

    // ---------------------------------------------------------------------------------------------

    private ScaledFloatNumberProperty(Builder builder) {
        super(builder);
        this.nullValue = builder.nullValue;
        this.scalingFactor = builder.scalingFactor;
    }

    public static ScaledFloatNumberProperty of(Function<ScaledFloatNumberProperty.Builder, ObjectBuilder<ScaledFloatNumberProperty>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link Property} variant kind.
     */
    @Override
    public Property.Kind _propertyKind() {
        return Property.Kind.ScaledFloat;
    }

    /**
     * API name: {@code null_value}
     */
    @Nullable
    public final Double nullValue() {
        return this.nullValue;
    }

    /**
     * API name: {@code scaling_factor}
     */
    @Nullable
    public final Double scalingFactor() {
        return this.scalingFactor;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        generator.write("type", "scaled_float");
        super.serializeInternal(generator, mapper);
        if (this.nullValue != null) {
            generator.writeKey("null_value");
            generator.write(this.nullValue);
        }

        if (this.scalingFactor != null) {
            generator.writeKey("scaling_factor");
            generator.write(this.scalingFactor);
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
     * Builder for {@link ScaledFloatNumberProperty}.
     */
    public static class Builder extends NumberPropertyBase.AbstractBuilder<Builder>
        implements
            CopyableBuilder<Builder, ScaledFloatNumberProperty> {
        @Nullable
        private Double nullValue;
        @Nullable
        private Double scalingFactor;

        public Builder() {}

        private Builder(ScaledFloatNumberProperty o) {
            super(o);
            this.nullValue = o.nullValue;
            this.scalingFactor = o.scalingFactor;
        }

        private Builder(Builder o) {
            super(o);
            this.nullValue = o.nullValue;
            this.scalingFactor = o.scalingFactor;
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
         * API name: {@code null_value}
         */
        @Nonnull
        public final Builder nullValue(@Nullable Double value) {
            this.nullValue = value;
            return this;
        }

        /**
         * API name: {@code scaling_factor}
         */
        @Nonnull
        public final Builder scalingFactor(@Nullable Double value) {
            this.scalingFactor = value;
            return this;
        }

        /**
         * Builds a {@link ScaledFloatNumberProperty}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ScaledFloatNumberProperty build() {
            _checkSingleUse();

            return new ScaledFloatNumberProperty(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ScaledFloatNumberProperty}
     */
    public static final JsonpDeserializer<ScaledFloatNumberProperty> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ScaledFloatNumberProperty::setupScaledFloatNumberPropertyDeserializer
    );

    protected static void setupScaledFloatNumberPropertyDeserializer(ObjectDeserializer<ScaledFloatNumberProperty.Builder> op) {
        setupNumberPropertyBaseDeserializer(op);
        op.add(Builder::nullValue, JsonpDeserializer.doubleDeserializer(), "null_value");
        op.add(Builder::scalingFactor, JsonpDeserializer.doubleDeserializer(), "scaling_factor");

        op.ignore("type");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(this.nullValue);
        result = 31 * result + Objects.hashCode(this.scalingFactor);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ScaledFloatNumberProperty other = (ScaledFloatNumberProperty) o;
        return Objects.equals(this.nullValue, other.nullValue) && Objects.equals(this.scalingFactor, other.scalingFactor);
    }
}
