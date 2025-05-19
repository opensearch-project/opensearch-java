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

// typedef: _types.mapping.DateRangeProperty

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class DateRangeProperty extends RangePropertyBase
    implements
        PropertyVariant,
        ToCopyableBuilder<DateRangeProperty.Builder, DateRangeProperty> {

    @Nullable
    private final String format;

    // ---------------------------------------------------------------------------------------------

    private DateRangeProperty(Builder builder) {
        super(builder);
        this.format = builder.format;
    }

    public static DateRangeProperty of(Function<DateRangeProperty.Builder, ObjectBuilder<DateRangeProperty>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link Property} variant kind.
     */
    @Override
    public Property.Kind _propertyKind() {
        return Property.Kind.DateRange;
    }

    /**
     * API name: {@code format}
     */
    @Nullable
    public final String format() {
        return this.format;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        generator.write("type", "date_range");
        super.serializeInternal(generator, mapper);
        if (this.format != null) {
            generator.writeKey("format");
            generator.write(this.format);
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
     * Builder for {@link DateRangeProperty}.
     */
    public static class Builder extends RangePropertyBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, DateRangeProperty> {
        @Nullable
        private String format;

        public Builder() {}

        private Builder(DateRangeProperty o) {
            super(o);
            this.format = o.format;
        }

        private Builder(Builder o) {
            super(o);
            this.format = o.format;
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
         * API name: {@code format}
         */
        @Nonnull
        public final Builder format(@Nullable String value) {
            this.format = value;
            return this;
        }

        /**
         * Builds a {@link DateRangeProperty}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public DateRangeProperty build() {
            _checkSingleUse();

            return new DateRangeProperty(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link DateRangeProperty}
     */
    public static final JsonpDeserializer<DateRangeProperty> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        DateRangeProperty::setupDateRangePropertyDeserializer
    );

    protected static void setupDateRangePropertyDeserializer(ObjectDeserializer<DateRangeProperty.Builder> op) {
        setupRangePropertyBaseDeserializer(op);
        op.add(Builder::format, JsonpDeserializer.stringDeserializer(), "format");

        op.ignore("type");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(this.format);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        DateRangeProperty other = (DateRangeProperty) o;
        return Objects.equals(this.format, other.format);
    }
}
