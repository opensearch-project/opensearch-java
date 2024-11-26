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

package org.opensearch.client.opensearch.indices;

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
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: indices.IndexSettingsMappingLimitNestedFields

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class IndexSettingsMappingLimitNestedFields
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<IndexSettingsMappingLimitNestedFields.Builder, IndexSettingsMappingLimitNestedFields> {

    @Nullable
    private final Long limit;

    // ---------------------------------------------------------------------------------------------

    private IndexSettingsMappingLimitNestedFields(Builder builder) {
        this.limit = builder.limit;
    }

    public static IndexSettingsMappingLimitNestedFields of(
        Function<IndexSettingsMappingLimitNestedFields.Builder, ObjectBuilder<IndexSettingsMappingLimitNestedFields>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * The maximum number of distinct nested mappings in an index. The nested type should only be used in special cases, when arrays of
     * objects need to be queried independently of each other. To safeguard against poorly designed mappings, this setting limits the number
     * of unique nested types per index.
     * <p>
     * API name: {@code limit}
     * </p>
     */
    @Nullable
    public final Long limit() {
        return this.limit;
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
        if (this.limit != null) {
            generator.writeKey("limit");
            generator.write(this.limit);
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
     * Builder for {@link IndexSettingsMappingLimitNestedFields}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, IndexSettingsMappingLimitNestedFields> {
        @Nullable
        private Long limit;

        public Builder() {}

        private Builder(IndexSettingsMappingLimitNestedFields o) {
            this.limit = o.limit;
        }

        private Builder(Builder o) {
            this.limit = o.limit;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * The maximum number of distinct nested mappings in an index. The nested type should only be used in special cases, when arrays of
         * objects need to be queried independently of each other. To safeguard against poorly designed mappings, this setting limits the
         * number of unique nested types per index.
         * <p>
         * API name: {@code limit}
         * </p>
         */
        @Nonnull
        public final Builder limit(@Nullable Long value) {
            this.limit = value;
            return this;
        }

        /**
         * Builds a {@link IndexSettingsMappingLimitNestedFields}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public IndexSettingsMappingLimitNestedFields build() {
            _checkSingleUse();

            return new IndexSettingsMappingLimitNestedFields(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link IndexSettingsMappingLimitNestedFields}
     */
    public static final JsonpDeserializer<IndexSettingsMappingLimitNestedFields> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        IndexSettingsMappingLimitNestedFields::setupIndexSettingsMappingLimitNestedFieldsDeserializer
    );

    protected static void setupIndexSettingsMappingLimitNestedFieldsDeserializer(
        ObjectDeserializer<IndexSettingsMappingLimitNestedFields.Builder> op
    ) {
        op.add(Builder::limit, JsonpDeserializer.longDeserializer(), "limit");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.limit);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        IndexSettingsMappingLimitNestedFields other = (IndexSettingsMappingLimitNestedFields) o;
        return Objects.equals(this.limit, other.limit);
    }
}
