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
import org.opensearch.client.json.PlainJsonSerializable;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;

// typedef: _types.mapping.RuntimeFieldFetchFields

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class RuntimeFieldFetchFields implements PlainJsonSerializable {

    @Nonnull
    private final String field;

    @Nullable
    private final String format;

    // ---------------------------------------------------------------------------------------------

    private RuntimeFieldFetchFields(Builder builder) {
        this.field = ApiTypeHelper.requireNonNull(builder.field, this, "field");
        this.format = builder.format;
    }

    public static RuntimeFieldFetchFields of(Function<RuntimeFieldFetchFields.Builder, ObjectBuilder<RuntimeFieldFetchFields>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code field}
     */
    @Nonnull
    public final String field() {
        return this.field;
    }

    /**
     * API name: {@code format}
     */
    @Nullable
    public final String format() {
        return this.format;
    }

    /**
     * Serialize this object to JSON.
     */
    @Override
    public void serialize(JsonGenerator generator, JsonpMapper mapper) {
        generator.writeStartObject();
        serializeInternal(generator, mapper);
        generator.writeEnd();
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        generator.writeKey("field");
        generator.write(this.field);

        if (this.format != null) {
            generator.writeKey("format");
            generator.write(this.format);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Builder for {@link RuntimeFieldFetchFields}.
     */
    public static class Builder extends ObjectBuilderBase implements ObjectBuilder<RuntimeFieldFetchFields> {
        private String field;
        @Nullable
        private String format;

        /**
         * Required - API name: {@code field}
         */
        public final Builder field(String value) {
            this.field = value;
            return this;
        }

        /**
         * API name: {@code format}
         */
        public final Builder format(@Nullable String value) {
            this.format = value;
            return this;
        }

        /**
         * Builds a {@link RuntimeFieldFetchFields}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        public RuntimeFieldFetchFields build() {
            _checkSingleUse();

            return new RuntimeFieldFetchFields(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link RuntimeFieldFetchFields}
     */
    public static final JsonpDeserializer<RuntimeFieldFetchFields> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        RuntimeFieldFetchFields::setupRuntimeFieldFetchFieldsDeserializer
    );

    protected static void setupRuntimeFieldFetchFieldsDeserializer(ObjectDeserializer<RuntimeFieldFetchFields.Builder> op) {
        op.add(Builder::field, JsonpDeserializer.stringDeserializer(), "field");
        op.add(Builder::format, JsonpDeserializer.stringDeserializer(), "format");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.field.hashCode();
        result = 31 * result + Objects.hashCode(this.format);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        RuntimeFieldFetchFields other = (RuntimeFieldFetchFields) o;
        return this.field.equals(other.field) && Objects.equals(this.format, other.format);
    }
}
