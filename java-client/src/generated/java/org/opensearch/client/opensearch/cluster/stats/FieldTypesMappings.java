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

package org.opensearch.client.opensearch.cluster.stats;

import jakarta.json.stream.JsonGenerator;
import java.util.List;
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

// typedef: cluster.stats.FieldTypesMappings

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class FieldTypesMappings implements PlainJsonSerializable, ToCopyableBuilder<FieldTypesMappings.Builder, FieldTypesMappings> {

    @Nonnull
    private final List<FieldTypes> fieldTypes;

    // ---------------------------------------------------------------------------------------------

    private FieldTypesMappings(Builder builder) {
        this.fieldTypes = ApiTypeHelper.unmodifiableRequired(builder.fieldTypes, this, "fieldTypes");
    }

    public static FieldTypesMappings of(Function<FieldTypesMappings.Builder, ObjectBuilder<FieldTypesMappings>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - Contains statistics about field data types used in selected nodes.
     * <p>
     * API name: {@code field_types}
     * </p>
     */
    @Nonnull
    public final List<FieldTypes> fieldTypes() {
        return this.fieldTypes;
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
        generator.writeKey("field_types");
        generator.writeStartArray();
        for (FieldTypes item0 : this.fieldTypes) {
            item0.serialize(generator, mapper);
        }
        generator.writeEnd();
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
     * Builder for {@link FieldTypesMappings}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, FieldTypesMappings> {
        private List<FieldTypes> fieldTypes;

        public Builder() {}

        private Builder(FieldTypesMappings o) {
            this.fieldTypes = _listCopy(o.fieldTypes);
        }

        private Builder(Builder o) {
            this.fieldTypes = _listCopy(o.fieldTypes);
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - Contains statistics about field data types used in selected nodes.
         * <p>
         * API name: {@code field_types}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>fieldTypes</code>.
         * </p>
         */
        @Nonnull
        public final Builder fieldTypes(List<FieldTypes> list) {
            this.fieldTypes = _listAddAll(this.fieldTypes, list);
            return this;
        }

        /**
         * Required - Contains statistics about field data types used in selected nodes.
         * <p>
         * API name: {@code field_types}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>fieldTypes</code>.
         * </p>
         */
        @Nonnull
        public final Builder fieldTypes(FieldTypes value, FieldTypes... values) {
            this.fieldTypes = _listAdd(this.fieldTypes, value, values);
            return this;
        }

        /**
         * Required - Contains statistics about field data types used in selected nodes.
         * <p>
         * API name: {@code field_types}
         * </p>
         *
         * <p>
         * Adds a value to <code>fieldTypes</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder fieldTypes(Function<FieldTypes.Builder, ObjectBuilder<FieldTypes>> fn) {
            return fieldTypes(fn.apply(new FieldTypes.Builder()).build());
        }

        /**
         * Builds a {@link FieldTypesMappings}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public FieldTypesMappings build() {
            _checkSingleUse();

            return new FieldTypesMappings(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link FieldTypesMappings}
     */
    public static final JsonpDeserializer<FieldTypesMappings> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        FieldTypesMappings::setupFieldTypesMappingsDeserializer
    );

    protected static void setupFieldTypesMappingsDeserializer(ObjectDeserializer<FieldTypesMappings.Builder> op) {
        op.add(Builder::fieldTypes, JsonpDeserializer.arrayDeserializer(FieldTypes._DESERIALIZER), "field_types");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.fieldTypes.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        FieldTypesMappings other = (FieldTypesMappings) o;
        return this.fieldTypes.equals(other.fieldTypes);
    }
}
