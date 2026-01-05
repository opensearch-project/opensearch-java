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
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: _types.mapping.SemanticDenseEmbeddingConfig

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class SemanticDenseEmbeddingConfig
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<SemanticDenseEmbeddingConfig.Builder, SemanticDenseEmbeddingConfig> {

    @Nullable
    private final String compressionLevel;

    @Nullable
    private final String dataType;

    @Nullable
    private final KnnVectorMethod method;

    @Nullable
    private final String mode;

    // ---------------------------------------------------------------------------------------------

    private SemanticDenseEmbeddingConfig(Builder builder) {
        this.compressionLevel = builder.compressionLevel;
        this.dataType = builder.dataType;
        this.method = builder.method;
        this.mode = builder.mode;
    }

    public static SemanticDenseEmbeddingConfig of(
        Function<SemanticDenseEmbeddingConfig.Builder, ObjectBuilder<SemanticDenseEmbeddingConfig>> fn
    ) {
        return fn.apply(new Builder()).build();
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
     * Serialize this object to JSON.
     */
    @Override
    public void serialize(JsonGenerator generator, JsonpMapper mapper) {
        generator.writeStartObject();
        serializeInternal(generator, mapper);
        generator.writeEnd();
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        if (this.compressionLevel != null) {
            generator.writeKey("compression_level");
            generator.write(this.compressionLevel);
        }

        if (this.dataType != null) {
            generator.writeKey("data_type");
            generator.write(this.dataType);
        }

        if (this.method != null) {
            generator.writeKey("method");
            this.method.serialize(generator, mapper);
        }

        if (this.mode != null) {
            generator.writeKey("mode");
            generator.write(this.mode);
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
     * Builder for {@link SemanticDenseEmbeddingConfig}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, SemanticDenseEmbeddingConfig> {
        @Nullable
        private String compressionLevel;
        @Nullable
        private String dataType;
        @Nullable
        private KnnVectorMethod method;
        @Nullable
        private String mode;

        public Builder() {}

        private Builder(SemanticDenseEmbeddingConfig o) {
            this.compressionLevel = o.compressionLevel;
            this.dataType = o.dataType;
            this.method = o.method;
            this.mode = o.mode;
        }

        private Builder(Builder o) {
            this.compressionLevel = o.compressionLevel;
            this.dataType = o.dataType;
            this.method = o.method;
            this.mode = o.mode;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
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
         * Builds a {@link SemanticDenseEmbeddingConfig}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public SemanticDenseEmbeddingConfig build() {
            _checkSingleUse();

            return new SemanticDenseEmbeddingConfig(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link SemanticDenseEmbeddingConfig}
     */
    public static final JsonpDeserializer<SemanticDenseEmbeddingConfig> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        SemanticDenseEmbeddingConfig::setupSemanticDenseEmbeddingConfigDeserializer
    );

    protected static void setupSemanticDenseEmbeddingConfigDeserializer(ObjectDeserializer<SemanticDenseEmbeddingConfig.Builder> op) {
        op.add(Builder::compressionLevel, JsonpDeserializer.stringDeserializer(), "compression_level");
        op.add(Builder::dataType, JsonpDeserializer.stringDeserializer(), "data_type");
        op.add(Builder::method, KnnVectorMethod._DESERIALIZER, "method");
        op.add(Builder::mode, JsonpDeserializer.stringDeserializer(), "mode");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.compressionLevel);
        result = 31 * result + Objects.hashCode(this.dataType);
        result = 31 * result + Objects.hashCode(this.method);
        result = 31 * result + Objects.hashCode(this.mode);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        SemanticDenseEmbeddingConfig other = (SemanticDenseEmbeddingConfig) o;
        return Objects.equals(this.compressionLevel, other.compressionLevel)
            && Objects.equals(this.dataType, other.dataType)
            && Objects.equals(this.method, other.method)
            && Objects.equals(this.mode, other.mode);
    }
}
