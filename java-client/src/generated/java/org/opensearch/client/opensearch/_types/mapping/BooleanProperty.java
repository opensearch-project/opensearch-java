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
import org.opensearch.client.opensearch.indices.NumericFielddata;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: _types.mapping.BooleanProperty

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class BooleanProperty extends DocValuesPropertyBase
    implements
        PropertyVariant,
        ToCopyableBuilder<BooleanProperty.Builder, BooleanProperty> {

    @Nullable
    private final Double boost;

    @Nullable
    private final NumericFielddata fielddata;

    @Nullable
    private final Boolean index;

    @Nullable
    private final Boolean nullValue;

    // ---------------------------------------------------------------------------------------------

    private BooleanProperty(Builder builder) {
        super(builder);
        this.boost = builder.boost;
        this.fielddata = builder.fielddata;
        this.index = builder.index;
        this.nullValue = builder.nullValue;
    }

    public static BooleanProperty of(Function<BooleanProperty.Builder, ObjectBuilder<BooleanProperty>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link Property} variant kind.
     */
    @Override
    public Property.Kind _propertyKind() {
        return Property.Kind.Boolean;
    }

    /**
     * API name: {@code boost}
     */
    @Nullable
    public final Double boost() {
        return this.boost;
    }

    /**
     * API name: {@code fielddata}
     */
    @Nullable
    public final NumericFielddata fielddata() {
        return this.fielddata;
    }

    /**
     * API name: {@code index}
     */
    @Nullable
    public final Boolean index() {
        return this.index;
    }

    /**
     * API name: {@code null_value}
     */
    @Nullable
    public final Boolean nullValue() {
        return this.nullValue;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        generator.write("type", "boolean");
        super.serializeInternal(generator, mapper);
        if (this.boost != null) {
            generator.writeKey("boost");
            generator.write(this.boost);
        }

        if (this.fielddata != null) {
            generator.writeKey("fielddata");
            this.fielddata.serialize(generator, mapper);
        }

        if (this.index != null) {
            generator.writeKey("index");
            generator.write(this.index);
        }

        if (this.nullValue != null) {
            generator.writeKey("null_value");
            generator.write(this.nullValue);
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
     * Builder for {@link BooleanProperty}.
     */
    public static class Builder extends DocValuesPropertyBase.AbstractBuilder<Builder>
        implements
            CopyableBuilder<Builder, BooleanProperty> {
        @Nullable
        private Double boost;
        @Nullable
        private NumericFielddata fielddata;
        @Nullable
        private Boolean index;
        @Nullable
        private Boolean nullValue;

        public Builder() {}

        private Builder(BooleanProperty o) {
            super(o);
            this.boost = o.boost;
            this.fielddata = o.fielddata;
            this.index = o.index;
            this.nullValue = o.nullValue;
        }

        private Builder(Builder o) {
            super(o);
            this.boost = o.boost;
            this.fielddata = o.fielddata;
            this.index = o.index;
            this.nullValue = o.nullValue;
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
         * API name: {@code boost}
         */
        @Nonnull
        public final Builder boost(@Nullable Double value) {
            this.boost = value;
            return this;
        }

        /**
         * API name: {@code fielddata}
         */
        @Nonnull
        public final Builder fielddata(@Nullable NumericFielddata value) {
            this.fielddata = value;
            return this;
        }

        /**
         * API name: {@code fielddata}
         */
        @Nonnull
        public final Builder fielddata(Function<NumericFielddata.Builder, ObjectBuilder<NumericFielddata>> fn) {
            return fielddata(fn.apply(new NumericFielddata.Builder()).build());
        }

        /**
         * API name: {@code index}
         */
        @Nonnull
        public final Builder index(@Nullable Boolean value) {
            this.index = value;
            return this;
        }

        /**
         * API name: {@code null_value}
         */
        @Nonnull
        public final Builder nullValue(@Nullable Boolean value) {
            this.nullValue = value;
            return this;
        }

        /**
         * Builds a {@link BooleanProperty}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public BooleanProperty build() {
            _checkSingleUse();

            return new BooleanProperty(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link BooleanProperty}
     */
    public static final JsonpDeserializer<BooleanProperty> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        BooleanProperty::setupBooleanPropertyDeserializer
    );

    protected static void setupBooleanPropertyDeserializer(ObjectDeserializer<BooleanProperty.Builder> op) {
        setupDocValuesPropertyBaseDeserializer(op);
        op.add(Builder::boost, JsonpDeserializer.doubleDeserializer(), "boost");
        op.add(Builder::fielddata, NumericFielddata._DESERIALIZER, "fielddata");
        op.add(Builder::index, JsonpDeserializer.booleanDeserializer(), "index");
        op.add(Builder::nullValue, JsonpDeserializer.booleanDeserializer(), "null_value");

        op.ignore("type");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(this.boost);
        result = 31 * result + Objects.hashCode(this.fielddata);
        result = 31 * result + Objects.hashCode(this.index);
        result = 31 * result + Objects.hashCode(this.nullValue);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        BooleanProperty other = (BooleanProperty) o;
        return Objects.equals(this.boost, other.boost)
            && Objects.equals(this.fielddata, other.fielddata)
            && Objects.equals(this.index, other.index)
            && Objects.equals(this.nullValue, other.nullValue);
    }
}
