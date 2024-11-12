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
import javax.annotation.Nullable;
import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.util.ObjectBuilder;

// typedef: _types.mapping.FlatObjectProperty

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class FlatObjectProperty extends PropertyBase implements PropertyVariant {

    @Nullable
    private final Boolean aggregatable;

    @Nullable
    private final Boolean searchable;

    // ---------------------------------------------------------------------------------------------

    private FlatObjectProperty(Builder builder) {
        super(builder);
        this.aggregatable = builder.aggregatable;
        this.searchable = builder.searchable;
    }

    public static FlatObjectProperty of(Function<FlatObjectProperty.Builder, ObjectBuilder<FlatObjectProperty>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link Property} variant kind.
     */
    @Override
    public Property.Kind _propertyKind() {
        return Property.Kind.FlatObject;
    }

    /**
     * API name: {@code aggregatable}
     */
    @Nullable
    public final Boolean aggregatable() {
        return this.aggregatable;
    }

    /**
     * API name: {@code searchable}
     */
    @Nullable
    public final Boolean searchable() {
        return this.searchable;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        generator.write("type", "flat_object");
        super.serializeInternal(generator, mapper);
        if (this.aggregatable != null) {
            generator.writeKey("aggregatable");
            generator.write(this.aggregatable);
        }

        if (this.searchable != null) {
            generator.writeKey("searchable");
            generator.write(this.searchable);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Builder for {@link FlatObjectProperty}.
     */
    public static class Builder extends PropertyBase.AbstractBuilder<Builder> implements ObjectBuilder<FlatObjectProperty> {
        @Nullable
        private Boolean aggregatable;
        @Nullable
        private Boolean searchable;

        /**
         * API name: {@code aggregatable}
         */
        public final Builder aggregatable(@Nullable Boolean value) {
            this.aggregatable = value;
            return this;
        }

        /**
         * API name: {@code searchable}
         */
        public final Builder searchable(@Nullable Boolean value) {
            this.searchable = value;
            return this;
        }

        @Override
        protected Builder self() {
            return this;
        }

        /**
         * Builds a {@link FlatObjectProperty}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        public FlatObjectProperty build() {
            _checkSingleUse();

            return new FlatObjectProperty(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link FlatObjectProperty}
     */
    public static final JsonpDeserializer<FlatObjectProperty> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        FlatObjectProperty::setupFlatObjectPropertyDeserializer
    );

    protected static void setupFlatObjectPropertyDeserializer(ObjectDeserializer<FlatObjectProperty.Builder> op) {
        setupPropertyBaseDeserializer(op);
        op.add(Builder::aggregatable, JsonpDeserializer.booleanDeserializer(), "aggregatable");
        op.add(Builder::searchable, JsonpDeserializer.booleanDeserializer(), "searchable");

        op.ignore("type");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(this.aggregatable);
        result = 31 * result + Objects.hashCode(this.searchable);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        FlatObjectProperty other = (FlatObjectProperty) o;
        return Objects.equals(this.aggregatable, other.aggregatable) && Objects.equals(this.searchable, other.searchable);
    }
}
