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

// typedef: indices.IndexSettingsMapping

/**
 * The mapping configuration for the index.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class IndexSettingsMapping implements PlainJsonSerializable, ToCopyableBuilder<IndexSettingsMapping.Builder, IndexSettingsMapping> {

    @Nullable
    private final Boolean coerce;

    @Nullable
    private final IndexSettingsMappingLimitDepth depth;

    @Nullable
    private final IndexSettingsMappingLimitDimensionFields dimensionFields;

    @Nullable
    private final IndexSettingsMappingLimitFieldNameLength fieldNameLength;

    @Nullable
    private final Boolean ignoreMalformed;

    @Nullable
    private final IndexSettingsMappingLimitNestedFields nestedFields;

    @Nullable
    private final IndexSettingsMappingLimitNestedObjects nestedObjects;

    @Nullable
    private final IndexSettingsMappingLimitTotalFields totalFields;

    // ---------------------------------------------------------------------------------------------

    private IndexSettingsMapping(Builder builder) {
        this.coerce = builder.coerce;
        this.depth = builder.depth;
        this.dimensionFields = builder.dimensionFields;
        this.fieldNameLength = builder.fieldNameLength;
        this.ignoreMalformed = builder.ignoreMalformed;
        this.nestedFields = builder.nestedFields;
        this.nestedObjects = builder.nestedObjects;
        this.totalFields = builder.totalFields;
    }

    public static IndexSettingsMapping of(Function<IndexSettingsMapping.Builder, ObjectBuilder<IndexSettingsMapping>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code coerce}
     */
    @Nullable
    public final Boolean coerce() {
        return this.coerce;
    }

    /**
     * API name: {@code depth}
     */
    @Nullable
    public final IndexSettingsMappingLimitDepth depth() {
        return this.depth;
    }

    /**
     * API name: {@code dimension_fields}
     */
    @Nullable
    public final IndexSettingsMappingLimitDimensionFields dimensionFields() {
        return this.dimensionFields;
    }

    /**
     * API name: {@code field_name_length}
     */
    @Nullable
    public final IndexSettingsMappingLimitFieldNameLength fieldNameLength() {
        return this.fieldNameLength;
    }

    /**
     * API name: {@code ignore_malformed}
     */
    @Nullable
    public final Boolean ignoreMalformed() {
        return this.ignoreMalformed;
    }

    /**
     * API name: {@code nested_fields}
     */
    @Nullable
    public final IndexSettingsMappingLimitNestedFields nestedFields() {
        return this.nestedFields;
    }

    /**
     * API name: {@code nested_objects}
     */
    @Nullable
    public final IndexSettingsMappingLimitNestedObjects nestedObjects() {
        return this.nestedObjects;
    }

    /**
     * API name: {@code total_fields}
     */
    @Nullable
    public final IndexSettingsMappingLimitTotalFields totalFields() {
        return this.totalFields;
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
        if (this.coerce != null) {
            generator.writeKey("coerce");
            generator.write(this.coerce);
        }

        if (this.depth != null) {
            generator.writeKey("depth");
            this.depth.serialize(generator, mapper);
        }

        if (this.dimensionFields != null) {
            generator.writeKey("dimension_fields");
            this.dimensionFields.serialize(generator, mapper);
        }

        if (this.fieldNameLength != null) {
            generator.writeKey("field_name_length");
            this.fieldNameLength.serialize(generator, mapper);
        }

        if (this.ignoreMalformed != null) {
            generator.writeKey("ignore_malformed");
            generator.write(this.ignoreMalformed);
        }

        if (this.nestedFields != null) {
            generator.writeKey("nested_fields");
            this.nestedFields.serialize(generator, mapper);
        }

        if (this.nestedObjects != null) {
            generator.writeKey("nested_objects");
            this.nestedObjects.serialize(generator, mapper);
        }

        if (this.totalFields != null) {
            generator.writeKey("total_fields");
            this.totalFields.serialize(generator, mapper);
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
     * Builder for {@link IndexSettingsMapping}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, IndexSettingsMapping> {
        @Nullable
        private Boolean coerce;
        @Nullable
        private IndexSettingsMappingLimitDepth depth;
        @Nullable
        private IndexSettingsMappingLimitDimensionFields dimensionFields;
        @Nullable
        private IndexSettingsMappingLimitFieldNameLength fieldNameLength;
        @Nullable
        private Boolean ignoreMalformed;
        @Nullable
        private IndexSettingsMappingLimitNestedFields nestedFields;
        @Nullable
        private IndexSettingsMappingLimitNestedObjects nestedObjects;
        @Nullable
        private IndexSettingsMappingLimitTotalFields totalFields;

        public Builder() {}

        private Builder(IndexSettingsMapping o) {
            this.coerce = o.coerce;
            this.depth = o.depth;
            this.dimensionFields = o.dimensionFields;
            this.fieldNameLength = o.fieldNameLength;
            this.ignoreMalformed = o.ignoreMalformed;
            this.nestedFields = o.nestedFields;
            this.nestedObjects = o.nestedObjects;
            this.totalFields = o.totalFields;
        }

        private Builder(Builder o) {
            this.coerce = o.coerce;
            this.depth = o.depth;
            this.dimensionFields = o.dimensionFields;
            this.fieldNameLength = o.fieldNameLength;
            this.ignoreMalformed = o.ignoreMalformed;
            this.nestedFields = o.nestedFields;
            this.nestedObjects = o.nestedObjects;
            this.totalFields = o.totalFields;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code coerce}
         */
        @Nonnull
        public final Builder coerce(@Nullable Boolean value) {
            this.coerce = value;
            return this;
        }

        /**
         * API name: {@code depth}
         */
        @Nonnull
        public final Builder depth(@Nullable IndexSettingsMappingLimitDepth value) {
            this.depth = value;
            return this;
        }

        /**
         * API name: {@code depth}
         */
        @Nonnull
        public final Builder depth(Function<IndexSettingsMappingLimitDepth.Builder, ObjectBuilder<IndexSettingsMappingLimitDepth>> fn) {
            return depth(fn.apply(new IndexSettingsMappingLimitDepth.Builder()).build());
        }

        /**
         * API name: {@code dimension_fields}
         */
        @Nonnull
        public final Builder dimensionFields(@Nullable IndexSettingsMappingLimitDimensionFields value) {
            this.dimensionFields = value;
            return this;
        }

        /**
         * API name: {@code dimension_fields}
         */
        @Nonnull
        public final Builder dimensionFields(
            Function<IndexSettingsMappingLimitDimensionFields.Builder, ObjectBuilder<IndexSettingsMappingLimitDimensionFields>> fn
        ) {
            return dimensionFields(fn.apply(new IndexSettingsMappingLimitDimensionFields.Builder()).build());
        }

        /**
         * API name: {@code field_name_length}
         */
        @Nonnull
        public final Builder fieldNameLength(@Nullable IndexSettingsMappingLimitFieldNameLength value) {
            this.fieldNameLength = value;
            return this;
        }

        /**
         * API name: {@code field_name_length}
         */
        @Nonnull
        public final Builder fieldNameLength(
            Function<IndexSettingsMappingLimitFieldNameLength.Builder, ObjectBuilder<IndexSettingsMappingLimitFieldNameLength>> fn
        ) {
            return fieldNameLength(fn.apply(new IndexSettingsMappingLimitFieldNameLength.Builder()).build());
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
         * API name: {@code nested_fields}
         */
        @Nonnull
        public final Builder nestedFields(@Nullable IndexSettingsMappingLimitNestedFields value) {
            this.nestedFields = value;
            return this;
        }

        /**
         * API name: {@code nested_fields}
         */
        @Nonnull
        public final Builder nestedFields(
            Function<IndexSettingsMappingLimitNestedFields.Builder, ObjectBuilder<IndexSettingsMappingLimitNestedFields>> fn
        ) {
            return nestedFields(fn.apply(new IndexSettingsMappingLimitNestedFields.Builder()).build());
        }

        /**
         * API name: {@code nested_objects}
         */
        @Nonnull
        public final Builder nestedObjects(@Nullable IndexSettingsMappingLimitNestedObjects value) {
            this.nestedObjects = value;
            return this;
        }

        /**
         * API name: {@code nested_objects}
         */
        @Nonnull
        public final Builder nestedObjects(
            Function<IndexSettingsMappingLimitNestedObjects.Builder, ObjectBuilder<IndexSettingsMappingLimitNestedObjects>> fn
        ) {
            return nestedObjects(fn.apply(new IndexSettingsMappingLimitNestedObjects.Builder()).build());
        }

        /**
         * API name: {@code total_fields}
         */
        @Nonnull
        public final Builder totalFields(@Nullable IndexSettingsMappingLimitTotalFields value) {
            this.totalFields = value;
            return this;
        }

        /**
         * API name: {@code total_fields}
         */
        @Nonnull
        public final Builder totalFields(
            Function<IndexSettingsMappingLimitTotalFields.Builder, ObjectBuilder<IndexSettingsMappingLimitTotalFields>> fn
        ) {
            return totalFields(fn.apply(new IndexSettingsMappingLimitTotalFields.Builder()).build());
        }

        /**
         * Builds a {@link IndexSettingsMapping}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public IndexSettingsMapping build() {
            _checkSingleUse();

            return new IndexSettingsMapping(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link IndexSettingsMapping}
     */
    public static final JsonpDeserializer<IndexSettingsMapping> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        IndexSettingsMapping::setupIndexSettingsMappingDeserializer
    );

    protected static void setupIndexSettingsMappingDeserializer(ObjectDeserializer<IndexSettingsMapping.Builder> op) {
        op.add(Builder::coerce, JsonpDeserializer.booleanDeserializer(), "coerce");
        op.add(Builder::depth, IndexSettingsMappingLimitDepth._DESERIALIZER, "depth");
        op.add(Builder::dimensionFields, IndexSettingsMappingLimitDimensionFields._DESERIALIZER, "dimension_fields");
        op.add(Builder::fieldNameLength, IndexSettingsMappingLimitFieldNameLength._DESERIALIZER, "field_name_length");
        op.add(Builder::ignoreMalformed, JsonpDeserializer.booleanDeserializer(), "ignore_malformed");
        op.add(Builder::nestedFields, IndexSettingsMappingLimitNestedFields._DESERIALIZER, "nested_fields");
        op.add(Builder::nestedObjects, IndexSettingsMappingLimitNestedObjects._DESERIALIZER, "nested_objects");
        op.add(Builder::totalFields, IndexSettingsMappingLimitTotalFields._DESERIALIZER, "total_fields");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.coerce);
        result = 31 * result + Objects.hashCode(this.depth);
        result = 31 * result + Objects.hashCode(this.dimensionFields);
        result = 31 * result + Objects.hashCode(this.fieldNameLength);
        result = 31 * result + Objects.hashCode(this.ignoreMalformed);
        result = 31 * result + Objects.hashCode(this.nestedFields);
        result = 31 * result + Objects.hashCode(this.nestedObjects);
        result = 31 * result + Objects.hashCode(this.totalFields);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        IndexSettingsMapping other = (IndexSettingsMapping) o;
        return Objects.equals(this.coerce, other.coerce)
            && Objects.equals(this.depth, other.depth)
            && Objects.equals(this.dimensionFields, other.dimensionFields)
            && Objects.equals(this.fieldNameLength, other.fieldNameLength)
            && Objects.equals(this.ignoreMalformed, other.ignoreMalformed)
            && Objects.equals(this.nestedFields, other.nestedFields)
            && Objects.equals(this.nestedObjects, other.nestedObjects)
            && Objects.equals(this.totalFields, other.totalFields);
    }
}
