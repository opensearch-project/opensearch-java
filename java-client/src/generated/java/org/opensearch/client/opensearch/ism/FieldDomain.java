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

package org.opensearch.client.opensearch.ism;

import jakarta.json.stream.JsonGenerator;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.json.PlainJsonSerializable;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: ism.FieldDomain

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class FieldDomain implements PlainJsonSerializable, ToCopyableBuilder<FieldDomain.Builder, FieldDomain> {

    @Nonnull
    private final String field;

    @Nonnull
    private final FieldDomainType type;

    // ---------------------------------------------------------------------------------------------

    private FieldDomain(Builder builder) {
        this.field = ApiTypeHelper.requireNonNull(builder.field, this, "field");
        this.type = ApiTypeHelper.requireNonNull(builder.type, this, "type");
    }

    public static FieldDomain of(Function<FieldDomain.Builder, ObjectBuilder<FieldDomain>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - The name of the field.
     * <p>
     * API name: {@code field}
     * </p>
     */
    @Nonnull
    public final String field() {
        return this.field;
    }

    /**
     * Required - API name: {@code type}
     */
    @Nonnull
    public final FieldDomainType type() {
        return this.type;
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

        generator.writeKey("type");
        this.type.serialize(generator, mapper);
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
     * Builder for {@link FieldDomain}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, FieldDomain> {
        private String field;
        private FieldDomainType type;

        public Builder() {}

        private Builder(FieldDomain o) {
            this.field = o.field;
            this.type = o.type;
        }

        private Builder(Builder o) {
            this.field = o.field;
            this.type = o.type;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - The name of the field.
         * <p>
         * API name: {@code field}
         * </p>
         */
        @Nonnull
        public final Builder field(String value) {
            this.field = value;
            return this;
        }

        /**
         * Required - API name: {@code type}
         */
        @Nonnull
        public final Builder type(FieldDomainType value) {
            this.type = value;
            return this;
        }

        /**
         * Builds a {@link FieldDomain}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public FieldDomain build() {
            _checkSingleUse();

            return new FieldDomain(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link FieldDomain}
     */
    public static final JsonpDeserializer<FieldDomain> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        FieldDomain::setupFieldDomainDeserializer
    );

    protected static void setupFieldDomainDeserializer(ObjectDeserializer<FieldDomain.Builder> op) {
        op.add(Builder::field, JsonpDeserializer.stringDeserializer(), "field");
        op.add(Builder::type, FieldDomainType._DESERIALIZER, "type");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.field.hashCode();
        result = 31 * result + this.type.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        FieldDomain other = (FieldDomain) o;
        return this.field.equals(other.field) && this.type.equals(other.type);
    }
}
