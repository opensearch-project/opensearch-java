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
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: _types.mapping.KnnVectorProperty

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class KnnVectorProperty extends DocValuesPropertyBase
    implements
        PropertyVariant,
        ToCopyableBuilder<KnnVectorProperty.Builder, KnnVectorProperty> {

    @Nullable
    private final String compressionLevel;

    @Nullable
    private final String dataType;

    private final int dimension;

    @Nullable
    private final KnnVectorMethod method;

    @Nullable
    private final String mode;

    @Nullable
    private final String modelId;

    @Nullable
    private final String spaceType;

    // ---------------------------------------------------------------------------------------------

    private KnnVectorProperty(Builder builder) {
        super(builder);
        this.compressionLevel = builder.compressionLevel;
        this.dataType = builder.dataType;
        this.dimension = ApiTypeHelper.requireNonNull(builder.dimension, this, "dimension");
        this.method = builder.method;
        this.mode = builder.mode;
        this.modelId = builder.modelId;
        this.spaceType = builder.spaceType;
    }

    public static KnnVectorProperty of(Function<KnnVectorProperty.Builder, ObjectBuilder<KnnVectorProperty>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link Property} variant kind.
     */
    @Override
    public Property.Kind _propertyKind() {
        return Property.Kind.KnnVector;
    }

    /**
     * API name: {@code compression_level}
     */
    @Nullable
    public final String compressionLevel() {
        return this.compressionLevel;
    }

    /**
     * API name: {@code data_type}
     */
    @Nullable
    public final String dataType() {
        return this.dataType;
    }

    /**
     * Required - API name: {@code dimension}
     */
    public final int dimension() {
        return this.dimension;
    }

    /**
     * API name: {@code method}
     */
    @Nullable
    public final KnnVectorMethod method() {
        return this.method;
    }

    /**
     * API name: {@code mode}
     */
    @Nullable
    public final String mode() {
        return this.mode;
    }

    /**
     * API name: {@code model_id}
     */
    @Nullable
    public final String modelId() {
        return this.modelId;
    }

    /**
     * API name: {@code space_type}
     */
    @Nullable
    public final String spaceType() {
        return this.spaceType;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        generator.write("type", "knn_vector");
        super.serializeInternal(generator, mapper);
        if (this.compressionLevel != null) {
            generator.writeKey("compression_level");
            generator.write(this.compressionLevel);
        }

        if (this.dataType != null) {
            generator.writeKey("data_type");
            generator.write(this.dataType);
        }

        generator.writeKey("dimension");
        generator.write(this.dimension);

        if (this.method != null) {
            generator.writeKey("method");
            this.method.serialize(generator, mapper);
        }

        if (this.mode != null) {
            generator.writeKey("mode");
            generator.write(this.mode);
        }

        if (this.modelId != null) {
            generator.writeKey("model_id");
            generator.write(this.modelId);
        }

        if (this.spaceType != null) {
            generator.writeKey("space_type");
            generator.write(this.spaceType);
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
     * Builder for {@link KnnVectorProperty}.
     */
    public static class Builder extends DocValuesPropertyBase.AbstractBuilder<Builder>
        implements
            CopyableBuilder<Builder, KnnVectorProperty> {
        @Nullable
        private String compressionLevel;
        @Nullable
        private String dataType;
        private Integer dimension;
        @Nullable
        private KnnVectorMethod method;
        @Nullable
        private String mode;
        @Nullable
        private String modelId;
        @Nullable
        private String spaceType;

        public Builder() {}

        private Builder(KnnVectorProperty o) {
            super(o);
            this.compressionLevel = o.compressionLevel;
            this.dataType = o.dataType;
            this.dimension = o.dimension;
            this.method = o.method;
            this.mode = o.mode;
            this.modelId = o.modelId;
            this.spaceType = o.spaceType;
        }

        private Builder(Builder o) {
            super(o);
            this.compressionLevel = o.compressionLevel;
            this.dataType = o.dataType;
            this.dimension = o.dimension;
            this.method = o.method;
            this.mode = o.mode;
            this.modelId = o.modelId;
            this.spaceType = o.spaceType;
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
         * API name: {@code compression_level}
         */
        @Nonnull
        public final Builder compressionLevel(@Nullable String value) {
            this.compressionLevel = value;
            return this;
        }

        /**
         * API name: {@code data_type}
         */
        @Nonnull
        public final Builder dataType(@Nullable String value) {
            this.dataType = value;
            return this;
        }

        /**
         * Required - API name: {@code dimension}
         */
        @Nonnull
        public final Builder dimension(int value) {
            this.dimension = value;
            return this;
        }

        /**
         * API name: {@code method}
         */
        @Nonnull
        public final Builder method(@Nullable KnnVectorMethod value) {
            this.method = value;
            return this;
        }

        /**
         * API name: {@code method}
         */
        @Nonnull
        public final Builder method(Function<KnnVectorMethod.Builder, ObjectBuilder<KnnVectorMethod>> fn) {
            return method(fn.apply(new KnnVectorMethod.Builder()).build());
        }

        /**
         * API name: {@code mode}
         */
        @Nonnull
        public final Builder mode(@Nullable String value) {
            this.mode = value;
            return this;
        }

        /**
         * API name: {@code model_id}
         */
        @Nonnull
        public final Builder modelId(@Nullable String value) {
            this.modelId = value;
            return this;
        }

        /**
         * API name: {@code space_type}
         */
        @Nonnull
        public final Builder spaceType(@Nullable String value) {
            this.spaceType = value;
            return this;
        }

        /**
         * Builds a {@link KnnVectorProperty}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public KnnVectorProperty build() {
            _checkSingleUse();

            return new KnnVectorProperty(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link KnnVectorProperty}
     */
    public static final JsonpDeserializer<KnnVectorProperty> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        KnnVectorProperty::setupKnnVectorPropertyDeserializer
    );

    protected static void setupKnnVectorPropertyDeserializer(ObjectDeserializer<KnnVectorProperty.Builder> op) {
        setupDocValuesPropertyBaseDeserializer(op);
        op.add(Builder::compressionLevel, JsonpDeserializer.stringDeserializer(), "compression_level");
        op.add(Builder::dataType, JsonpDeserializer.stringDeserializer(), "data_type");
        op.add(Builder::dimension, JsonpDeserializer.integerDeserializer(), "dimension");
        op.add(Builder::method, KnnVectorMethod._DESERIALIZER, "method");
        op.add(Builder::mode, JsonpDeserializer.stringDeserializer(), "mode");
        op.add(Builder::modelId, JsonpDeserializer.stringDeserializer(), "model_id");
        op.add(Builder::spaceType, JsonpDeserializer.stringDeserializer(), "space_type");

        op.ignore("type");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(this.compressionLevel);
        result = 31 * result + Objects.hashCode(this.dataType);
        result = 31 * result + Integer.hashCode(this.dimension);
        result = 31 * result + Objects.hashCode(this.method);
        result = 31 * result + Objects.hashCode(this.mode);
        result = 31 * result + Objects.hashCode(this.modelId);
        result = 31 * result + Objects.hashCode(this.spaceType);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        KnnVectorProperty other = (KnnVectorProperty) o;
        return Objects.equals(this.compressionLevel, other.compressionLevel)
            && Objects.equals(this.dataType, other.dataType)
            && this.dimension == other.dimension
            && Objects.equals(this.method, other.method)
            && Objects.equals(this.mode, other.mode)
            && Objects.equals(this.modelId, other.modelId)
            && Objects.equals(this.spaceType, other.spaceType);
    }
}
