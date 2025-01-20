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

package org.opensearch.client.opensearch._types.aggregations;

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

// typedef: _types.aggregations.InferenceAggregation

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class InferenceAggregation extends PipelineAggregationBase
    implements
        AggregationVariant,
        ToCopyableBuilder<InferenceAggregation.Builder, InferenceAggregation> {

    @Nullable
    private final InferenceConfig inferenceConfig;

    @Nonnull
    private final String modelId;

    // ---------------------------------------------------------------------------------------------

    private InferenceAggregation(Builder builder) {
        super(builder);
        this.inferenceConfig = builder.inferenceConfig;
        this.modelId = ApiTypeHelper.requireNonNull(builder.modelId, this, "modelId");
    }

    public static InferenceAggregation of(Function<InferenceAggregation.Builder, ObjectBuilder<InferenceAggregation>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link Aggregation} variant kind.
     */
    @Override
    public Aggregation.Kind _aggregationKind() {
        return Aggregation.Kind.Inference;
    }

    /**
     * API name: {@code inference_config}
     */
    @Nullable
    public final InferenceConfig inferenceConfig() {
        return this.inferenceConfig;
    }

    /**
     * Required - API name: {@code model_id}
     */
    @Nonnull
    public final String modelId() {
        return this.modelId;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        super.serializeInternal(generator, mapper);
        if (this.inferenceConfig != null) {
            generator.writeKey("inference_config");
            this.inferenceConfig.serialize(generator, mapper);
        }

        generator.writeKey("model_id");
        generator.write(this.modelId);
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
     * Builder for {@link InferenceAggregation}.
     */
    public static class Builder extends PipelineAggregationBase.AbstractBuilder<Builder>
        implements
            CopyableBuilder<Builder, InferenceAggregation> {
        @Nullable
        private InferenceConfig inferenceConfig;
        private String modelId;

        public Builder() {}

        private Builder(InferenceAggregation o) {
            super(o);
            this.inferenceConfig = o.inferenceConfig;
            this.modelId = o.modelId;
        }

        private Builder(Builder o) {
            super(o);
            this.inferenceConfig = o.inferenceConfig;
            this.modelId = o.modelId;
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
         * API name: {@code inference_config}
         */
        @Nonnull
        public final Builder inferenceConfig(@Nullable InferenceConfig value) {
            this.inferenceConfig = value;
            return this;
        }

        /**
         * API name: {@code inference_config}
         */
        @Nonnull
        public final Builder inferenceConfig(Function<InferenceConfig.Builder, ObjectBuilder<InferenceConfig>> fn) {
            return inferenceConfig(fn.apply(new InferenceConfig.Builder()).build());
        }

        /**
         * Required - API name: {@code model_id}
         */
        @Nonnull
        public final Builder modelId(String value) {
            this.modelId = value;
            return this;
        }

        /**
         * Builds a {@link InferenceAggregation}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public InferenceAggregation build() {
            _checkSingleUse();

            return new InferenceAggregation(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link InferenceAggregation}
     */
    public static final JsonpDeserializer<InferenceAggregation> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        InferenceAggregation::setupInferenceAggregationDeserializer
    );

    protected static void setupInferenceAggregationDeserializer(ObjectDeserializer<InferenceAggregation.Builder> op) {
        setupPipelineAggregationBaseDeserializer(op);
        op.add(Builder::inferenceConfig, InferenceConfig._DESERIALIZER, "inference_config");
        op.add(Builder::modelId, JsonpDeserializer.stringDeserializer(), "model_id");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(this.inferenceConfig);
        result = 31 * result + this.modelId.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        InferenceAggregation other = (InferenceAggregation) o;
        return Objects.equals(this.inferenceConfig, other.inferenceConfig) && this.modelId.equals(other.modelId);
    }
}
