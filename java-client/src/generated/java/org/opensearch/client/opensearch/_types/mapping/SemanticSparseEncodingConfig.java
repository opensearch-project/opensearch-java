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

// typedef: _types.mapping.SemanticSparseEncodingConfig

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class SemanticSparseEncodingConfig
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<SemanticSparseEncodingConfig.Builder, SemanticSparseEncodingConfig> {

    @Nullable
    private final Number pruneRatio;

    @Nullable
    private final String pruneType;

    // ---------------------------------------------------------------------------------------------

    private SemanticSparseEncodingConfig(Builder builder) {
        this.pruneRatio = builder.pruneRatio;
        this.pruneType = builder.pruneType;
    }

    public static SemanticSparseEncodingConfig of(
        Function<SemanticSparseEncodingConfig.Builder, ObjectBuilder<SemanticSparseEncodingConfig>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code prune_ratio}
     */
    @Nullable
    public final Number pruneRatio() {
        return this.pruneRatio;
    }

    /**
     * API name: {@code prune_type}
     */
    @Nullable
    public final String pruneType() {
        return this.pruneType;
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
        if (this.pruneRatio != null) {
            generator.writeKey("prune_ratio");
            generator.write(this.pruneRatio.doubleValue());
        }

        if (this.pruneType != null) {
            generator.writeKey("prune_type");
            generator.write(this.pruneType);
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
     * Builder for {@link SemanticSparseEncodingConfig}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, SemanticSparseEncodingConfig> {
        @Nullable
        private Number pruneRatio;
        @Nullable
        private String pruneType;

        public Builder() {}

        private Builder(SemanticSparseEncodingConfig o) {
            this.pruneRatio = o.pruneRatio;
            this.pruneType = o.pruneType;
        }

        private Builder(Builder o) {
            this.pruneRatio = o.pruneRatio;
            this.pruneType = o.pruneType;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code prune_ratio}
         */
        @Nonnull
        public final Builder pruneRatio(@Nullable Number value) {
            this.pruneRatio = value;
            return this;
        }

        /**
         * API name: {@code prune_type}
         */
        @Nonnull
        public final Builder pruneType(@Nullable String value) {
            this.pruneType = value;
            return this;
        }

        /**
         * Builds a {@link SemanticSparseEncodingConfig}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public SemanticSparseEncodingConfig build() {
            _checkSingleUse();

            return new SemanticSparseEncodingConfig(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link SemanticSparseEncodingConfig}
     */
    public static final JsonpDeserializer<SemanticSparseEncodingConfig> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        SemanticSparseEncodingConfig::setupSemanticSparseEncodingConfigDeserializer
    );

    protected static void setupSemanticSparseEncodingConfigDeserializer(ObjectDeserializer<SemanticSparseEncodingConfig.Builder> op) {
        op.add(Builder::pruneRatio, JsonpDeserializer.numberDeserializer(), "prune_ratio");
        op.add(Builder::pruneType, JsonpDeserializer.stringDeserializer(), "prune_type");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.pruneRatio);
        result = 31 * result + Objects.hashCode(this.pruneType);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        SemanticSparseEncodingConfig other = (SemanticSparseEncodingConfig) o;
        return Objects.equals(this.pruneRatio, other.pruneRatio) && Objects.equals(this.pruneType, other.pruneType);
    }
}
