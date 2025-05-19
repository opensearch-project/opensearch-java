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

// typedef: cluster.stats.FieldTypes

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class FieldTypes implements PlainJsonSerializable, ToCopyableBuilder<FieldTypes.Builder, FieldTypes> {

    private final int count;

    private final int indexCount;

    @Nonnull
    private final String name;

    // ---------------------------------------------------------------------------------------------

    private FieldTypes(Builder builder) {
        this.count = ApiTypeHelper.requireNonNull(builder.count, this, "count");
        this.indexCount = ApiTypeHelper.requireNonNull(builder.indexCount, this, "indexCount");
        this.name = ApiTypeHelper.requireNonNull(builder.name, this, "name");
    }

    public static FieldTypes of(Function<FieldTypes.Builder, ObjectBuilder<FieldTypes>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - The number of occurrences of the field type in selected nodes.
     * <p>
     * API name: {@code count}
     * </p>
     */
    public final int count() {
        return this.count;
    }

    /**
     * Required - The number of indexes containing the field type in selected nodes.
     * <p>
     * API name: {@code index_count}
     * </p>
     */
    public final int indexCount() {
        return this.indexCount;
    }

    /**
     * Required - API name: {@code name}
     */
    @Nonnull
    public final String name() {
        return this.name;
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
        generator.writeKey("count");
        generator.write(this.count);

        generator.writeKey("index_count");
        generator.write(this.indexCount);

        generator.writeKey("name");
        generator.write(this.name);
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
     * Builder for {@link FieldTypes}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, FieldTypes> {
        private Integer count;
        private Integer indexCount;
        private String name;

        public Builder() {}

        private Builder(FieldTypes o) {
            this.count = o.count;
            this.indexCount = o.indexCount;
            this.name = o.name;
        }

        private Builder(Builder o) {
            this.count = o.count;
            this.indexCount = o.indexCount;
            this.name = o.name;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - The number of occurrences of the field type in selected nodes.
         * <p>
         * API name: {@code count}
         * </p>
         */
        @Nonnull
        public final Builder count(int value) {
            this.count = value;
            return this;
        }

        /**
         * Required - The number of indexes containing the field type in selected nodes.
         * <p>
         * API name: {@code index_count}
         * </p>
         */
        @Nonnull
        public final Builder indexCount(int value) {
            this.indexCount = value;
            return this;
        }

        /**
         * Required - API name: {@code name}
         */
        @Nonnull
        public final Builder name(String value) {
            this.name = value;
            return this;
        }

        /**
         * Builds a {@link FieldTypes}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public FieldTypes build() {
            _checkSingleUse();

            return new FieldTypes(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link FieldTypes}
     */
    public static final JsonpDeserializer<FieldTypes> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        FieldTypes::setupFieldTypesDeserializer
    );

    protected static void setupFieldTypesDeserializer(ObjectDeserializer<FieldTypes.Builder> op) {
        op.add(Builder::count, JsonpDeserializer.integerDeserializer(), "count");
        op.add(Builder::indexCount, JsonpDeserializer.integerDeserializer(), "index_count");
        op.add(Builder::name, JsonpDeserializer.stringDeserializer(), "name");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Integer.hashCode(this.count);
        result = 31 * result + Integer.hashCode(this.indexCount);
        result = 31 * result + this.name.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        FieldTypes other = (FieldTypes) o;
        return this.count == other.count && this.indexCount == other.indexCount && this.name.equals(other.name);
    }
}
