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
import org.opensearch.client.json.PlainJsonSerializable;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: _types.aggregations.RegressionInferenceOptions

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class RegressionInferenceOptions
    implements
        InferenceConfigVariant,
        PlainJsonSerializable,
        ToCopyableBuilder<RegressionInferenceOptions.Builder, RegressionInferenceOptions> {

    @Nullable
    private final Integer numTopFeatureImportanceValues;

    @Nullable
    private final String resultsField;

    // ---------------------------------------------------------------------------------------------

    private RegressionInferenceOptions(Builder builder) {
        this.numTopFeatureImportanceValues = builder.numTopFeatureImportanceValues;
        this.resultsField = builder.resultsField;
    }

    public static RegressionInferenceOptions of(
        Function<RegressionInferenceOptions.Builder, ObjectBuilder<RegressionInferenceOptions>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link InferenceConfig} variant kind.
     */
    @Override
    public InferenceConfig.Kind _inferenceConfigKind() {
        return InferenceConfig.Kind.Regression;
    }

    /**
     * Specifies the maximum number of feature importance values per document.
     * <p>
     * API name: {@code num_top_feature_importance_values}
     * </p>
     */
    @Nullable
    public final Integer numTopFeatureImportanceValues() {
        return this.numTopFeatureImportanceValues;
    }

    /**
     * API name: {@code results_field}
     */
    @Nullable
    public final String resultsField() {
        return this.resultsField;
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
        if (this.numTopFeatureImportanceValues != null) {
            generator.writeKey("num_top_feature_importance_values");
            generator.write(this.numTopFeatureImportanceValues);
        }

        if (this.resultsField != null) {
            generator.writeKey("results_field");
            generator.write(this.resultsField);
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
     * Builder for {@link RegressionInferenceOptions}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, RegressionInferenceOptions> {
        @Nullable
        private Integer numTopFeatureImportanceValues;
        @Nullable
        private String resultsField;

        public Builder() {}

        private Builder(RegressionInferenceOptions o) {
            this.numTopFeatureImportanceValues = o.numTopFeatureImportanceValues;
            this.resultsField = o.resultsField;
        }

        private Builder(Builder o) {
            this.numTopFeatureImportanceValues = o.numTopFeatureImportanceValues;
            this.resultsField = o.resultsField;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Specifies the maximum number of feature importance values per document.
         * <p>
         * API name: {@code num_top_feature_importance_values}
         * </p>
         */
        @Nonnull
        public final Builder numTopFeatureImportanceValues(@Nullable Integer value) {
            this.numTopFeatureImportanceValues = value;
            return this;
        }

        /**
         * API name: {@code results_field}
         */
        @Nonnull
        public final Builder resultsField(@Nullable String value) {
            this.resultsField = value;
            return this;
        }

        /**
         * Builds a {@link RegressionInferenceOptions}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public RegressionInferenceOptions build() {
            _checkSingleUse();

            return new RegressionInferenceOptions(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link RegressionInferenceOptions}
     */
    public static final JsonpDeserializer<RegressionInferenceOptions> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        RegressionInferenceOptions::setupRegressionInferenceOptionsDeserializer
    );

    protected static void setupRegressionInferenceOptionsDeserializer(ObjectDeserializer<RegressionInferenceOptions.Builder> op) {
        op.add(Builder::numTopFeatureImportanceValues, JsonpDeserializer.integerDeserializer(), "num_top_feature_importance_values");
        op.add(Builder::resultsField, JsonpDeserializer.stringDeserializer(), "results_field");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.numTopFeatureImportanceValues);
        result = 31 * result + Objects.hashCode(this.resultsField);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        RegressionInferenceOptions other = (RegressionInferenceOptions) o;
        return Objects.equals(this.numTopFeatureImportanceValues, other.numTopFeatureImportanceValues)
            && Objects.equals(this.resultsField, other.resultsField);
    }
}
