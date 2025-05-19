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

// typedef: _types.mapping.HistogramProperty

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class HistogramProperty extends PropertyBase
    implements
        PropertyVariant,
        ToCopyableBuilder<HistogramProperty.Builder, HistogramProperty> {

    @Nullable
    private final Boolean ignoreMalformed;

    // ---------------------------------------------------------------------------------------------

    private HistogramProperty(Builder builder) {
        super(builder);
        this.ignoreMalformed = builder.ignoreMalformed;
    }

    public static HistogramProperty of(Function<HistogramProperty.Builder, ObjectBuilder<HistogramProperty>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link Property} variant kind.
     */
    @Override
    public Property.Kind _propertyKind() {
        return Property.Kind.Histogram;
    }

    /**
     * API name: {@code ignore_malformed}
     */
    @Nullable
    public final Boolean ignoreMalformed() {
        return this.ignoreMalformed;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        generator.write("type", "histogram");
        super.serializeInternal(generator, mapper);
        if (this.ignoreMalformed != null) {
            generator.writeKey("ignore_malformed");
            generator.write(this.ignoreMalformed);
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
     * Builder for {@link HistogramProperty}.
     */
    public static class Builder extends PropertyBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, HistogramProperty> {
        @Nullable
        private Boolean ignoreMalformed;

        public Builder() {}

        private Builder(HistogramProperty o) {
            super(o);
            this.ignoreMalformed = o.ignoreMalformed;
        }

        private Builder(Builder o) {
            super(o);
            this.ignoreMalformed = o.ignoreMalformed;
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
         * API name: {@code ignore_malformed}
         */
        @Nonnull
        public final Builder ignoreMalformed(@Nullable Boolean value) {
            this.ignoreMalformed = value;
            return this;
        }

        /**
         * Builds a {@link HistogramProperty}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public HistogramProperty build() {
            _checkSingleUse();

            return new HistogramProperty(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link HistogramProperty}
     */
    public static final JsonpDeserializer<HistogramProperty> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        HistogramProperty::setupHistogramPropertyDeserializer
    );

    protected static void setupHistogramPropertyDeserializer(ObjectDeserializer<HistogramProperty.Builder> op) {
        setupPropertyBaseDeserializer(op);
        op.add(Builder::ignoreMalformed, JsonpDeserializer.booleanDeserializer(), "ignore_malformed");

        op.ignore("type");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(this.ignoreMalformed);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        HistogramProperty other = (HistogramProperty) o;
        return Objects.equals(this.ignoreMalformed, other.ignoreMalformed);
    }
}
