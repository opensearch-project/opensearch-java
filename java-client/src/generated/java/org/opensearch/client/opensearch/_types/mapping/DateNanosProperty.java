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

// typedef: _types.mapping.DateNanosProperty

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class DateNanosProperty extends DocValuesPropertyBase
    implements
        PropertyVariant,
        ToCopyableBuilder<DateNanosProperty.Builder, DateNanosProperty> {

    @Nullable
    private final Double boost;

    @Nullable
    private final String format;

    @Nullable
    private final Boolean ignoreMalformed;

    @Nullable
    private final Boolean index;

    @Nullable
    private final String nullValue;

    @Nullable
    private final Integer precisionStep;

    // ---------------------------------------------------------------------------------------------

    private DateNanosProperty(Builder builder) {
        super(builder);
        this.boost = builder.boost;
        this.format = builder.format;
        this.ignoreMalformed = builder.ignoreMalformed;
        this.index = builder.index;
        this.nullValue = builder.nullValue;
        this.precisionStep = builder.precisionStep;
    }

    public static DateNanosProperty of(Function<DateNanosProperty.Builder, ObjectBuilder<DateNanosProperty>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link Property} variant kind.
     */
    @Override
    public Property.Kind _propertyKind() {
        return Property.Kind.DateNanos;
    }

    /**
     * API name: {@code boost}
     */
    @Nullable
    public final Double boost() {
        return this.boost;
    }

    /**
     * API name: {@code format}
     */
    @Nullable
    public final String format() {
        return this.format;
    }

    /**
     * API name: {@code ignore_malformed}
     */
    @Nullable
    public final Boolean ignoreMalformed() {
        return this.ignoreMalformed;
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
    public final String nullValue() {
        return this.nullValue;
    }

    /**
     * API name: {@code precision_step}
     */
    @Nullable
    public final Integer precisionStep() {
        return this.precisionStep;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        generator.write("type", "date_nanos");
        super.serializeInternal(generator, mapper);
        if (this.boost != null) {
            generator.writeKey("boost");
            generator.write(this.boost);
        }

        if (this.format != null) {
            generator.writeKey("format");
            generator.write(this.format);
        }

        if (this.ignoreMalformed != null) {
            generator.writeKey("ignore_malformed");
            generator.write(this.ignoreMalformed);
        }

        if (this.index != null) {
            generator.writeKey("index");
            generator.write(this.index);
        }

        if (this.nullValue != null) {
            generator.writeKey("null_value");
            generator.write(this.nullValue);
        }

        if (this.precisionStep != null) {
            generator.writeKey("precision_step");
            generator.write(this.precisionStep);
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
     * Builder for {@link DateNanosProperty}.
     */
    public static class Builder extends DocValuesPropertyBase.AbstractBuilder<Builder>
        implements
            CopyableBuilder<Builder, DateNanosProperty> {
        @Nullable
        private Double boost;
        @Nullable
        private String format;
        @Nullable
        private Boolean ignoreMalformed;
        @Nullable
        private Boolean index;
        @Nullable
        private String nullValue;
        @Nullable
        private Integer precisionStep;

        public Builder() {}

        private Builder(DateNanosProperty o) {
            super(o);
            this.boost = o.boost;
            this.format = o.format;
            this.ignoreMalformed = o.ignoreMalformed;
            this.index = o.index;
            this.nullValue = o.nullValue;
            this.precisionStep = o.precisionStep;
        }

        private Builder(Builder o) {
            super(o);
            this.boost = o.boost;
            this.format = o.format;
            this.ignoreMalformed = o.ignoreMalformed;
            this.index = o.index;
            this.nullValue = o.nullValue;
            this.precisionStep = o.precisionStep;
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
         * API name: {@code format}
         */
        @Nonnull
        public final Builder format(@Nullable String value) {
            this.format = value;
            return this;
        }

        /**
         * API name: {@code ignore_malformed}
         */
        @Nonnull
        public final Builder ignoreMalformed(@Nullable Boolean value) {
            this.ignoreMalformed = value;
            return this;
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
        public final Builder nullValue(@Nullable String value) {
            this.nullValue = value;
            return this;
        }

        /**
         * API name: {@code precision_step}
         */
        @Nonnull
        public final Builder precisionStep(@Nullable Integer value) {
            this.precisionStep = value;
            return this;
        }

        /**
         * Builds a {@link DateNanosProperty}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public DateNanosProperty build() {
            _checkSingleUse();

            return new DateNanosProperty(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link DateNanosProperty}
     */
    public static final JsonpDeserializer<DateNanosProperty> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        DateNanosProperty::setupDateNanosPropertyDeserializer
    );

    protected static void setupDateNanosPropertyDeserializer(ObjectDeserializer<DateNanosProperty.Builder> op) {
        setupDocValuesPropertyBaseDeserializer(op);
        op.add(Builder::boost, JsonpDeserializer.doubleDeserializer(), "boost");
        op.add(Builder::format, JsonpDeserializer.stringDeserializer(), "format");
        op.add(Builder::ignoreMalformed, JsonpDeserializer.booleanDeserializer(), "ignore_malformed");
        op.add(Builder::index, JsonpDeserializer.booleanDeserializer(), "index");
        op.add(Builder::nullValue, JsonpDeserializer.stringDeserializer(), "null_value");
        op.add(Builder::precisionStep, JsonpDeserializer.integerDeserializer(), "precision_step");

        op.ignore("type");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(this.boost);
        result = 31 * result + Objects.hashCode(this.format);
        result = 31 * result + Objects.hashCode(this.ignoreMalformed);
        result = 31 * result + Objects.hashCode(this.index);
        result = 31 * result + Objects.hashCode(this.nullValue);
        result = 31 * result + Objects.hashCode(this.precisionStep);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        DateNanosProperty other = (DateNanosProperty) o;
        return Objects.equals(this.boost, other.boost)
            && Objects.equals(this.format, other.format)
            && Objects.equals(this.ignoreMalformed, other.ignoreMalformed)
            && Objects.equals(this.index, other.index)
            && Objects.equals(this.nullValue, other.nullValue)
            && Objects.equals(this.precisionStep, other.precisionStep);
    }
}
