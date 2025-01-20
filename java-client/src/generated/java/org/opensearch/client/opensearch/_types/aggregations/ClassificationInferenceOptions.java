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

// typedef: _types.aggregations.ClassificationInferenceOptions

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class ClassificationInferenceOptions
    implements
        InferenceConfigVariant,
        PlainJsonSerializable,
        ToCopyableBuilder<ClassificationInferenceOptions.Builder, ClassificationInferenceOptions> {

    @Nullable
    private final Integer numTopClasses;

    @Nullable
    private final Integer numTopFeatureImportanceValues;

    @Nullable
    private final String predictionFieldType;

    @Nullable
    private final String resultsField;

    @Nullable
    private final String topClassesResultsField;

    // ---------------------------------------------------------------------------------------------

    private ClassificationInferenceOptions(Builder builder) {
        this.numTopClasses = builder.numTopClasses;
        this.numTopFeatureImportanceValues = builder.numTopFeatureImportanceValues;
        this.predictionFieldType = builder.predictionFieldType;
        this.resultsField = builder.resultsField;
        this.topClassesResultsField = builder.topClassesResultsField;
    }

    public static ClassificationInferenceOptions of(
        Function<ClassificationInferenceOptions.Builder, ObjectBuilder<ClassificationInferenceOptions>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link InferenceConfig} variant kind.
     */
    @Override
    public InferenceConfig.Kind _inferenceConfigKind() {
        return InferenceConfig.Kind.Classification;
    }

    /**
     * Specifies the number of top class predictions to return. Defaults to 0.
     * <p>
     * API name: {@code num_top_classes}
     * </p>
     */
    @Nullable
    public final Integer numTopClasses() {
        return this.numTopClasses;
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
     * Specifies the type of the predicted field to write. Acceptable values are: string, number, Boolean. When Boolean is provided 1.0 is
     * transformed to true and 0.0 to false.
     * <p>
     * API name: {@code prediction_field_type}
     * </p>
     */
    @Nullable
    public final String predictionFieldType() {
        return this.predictionFieldType;
    }

    /**
     * The field that is added to incoming documents to contain the inference prediction. Defaults to <code>predicted_value</code>.
     * <p>
     * API name: {@code results_field}
     * </p>
     */
    @Nullable
    public final String resultsField() {
        return this.resultsField;
    }

    /**
     * Specifies the field to which the top classes are written. Defaults to <code>top_classes</code>.
     * <p>
     * API name: {@code top_classes_results_field}
     * </p>
     */
    @Nullable
    public final String topClassesResultsField() {
        return this.topClassesResultsField;
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
        if (this.numTopClasses != null) {
            generator.writeKey("num_top_classes");
            generator.write(this.numTopClasses);
        }

        if (this.numTopFeatureImportanceValues != null) {
            generator.writeKey("num_top_feature_importance_values");
            generator.write(this.numTopFeatureImportanceValues);
        }

        if (this.predictionFieldType != null) {
            generator.writeKey("prediction_field_type");
            generator.write(this.predictionFieldType);
        }

        if (this.resultsField != null) {
            generator.writeKey("results_field");
            generator.write(this.resultsField);
        }

        if (this.topClassesResultsField != null) {
            generator.writeKey("top_classes_results_field");
            generator.write(this.topClassesResultsField);
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
     * Builder for {@link ClassificationInferenceOptions}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, ClassificationInferenceOptions> {
        @Nullable
        private Integer numTopClasses;
        @Nullable
        private Integer numTopFeatureImportanceValues;
        @Nullable
        private String predictionFieldType;
        @Nullable
        private String resultsField;
        @Nullable
        private String topClassesResultsField;

        public Builder() {}

        private Builder(ClassificationInferenceOptions o) {
            this.numTopClasses = o.numTopClasses;
            this.numTopFeatureImportanceValues = o.numTopFeatureImportanceValues;
            this.predictionFieldType = o.predictionFieldType;
            this.resultsField = o.resultsField;
            this.topClassesResultsField = o.topClassesResultsField;
        }

        private Builder(Builder o) {
            this.numTopClasses = o.numTopClasses;
            this.numTopFeatureImportanceValues = o.numTopFeatureImportanceValues;
            this.predictionFieldType = o.predictionFieldType;
            this.resultsField = o.resultsField;
            this.topClassesResultsField = o.topClassesResultsField;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Specifies the number of top class predictions to return. Defaults to 0.
         * <p>
         * API name: {@code num_top_classes}
         * </p>
         */
        @Nonnull
        public final Builder numTopClasses(@Nullable Integer value) {
            this.numTopClasses = value;
            return this;
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
         * Specifies the type of the predicted field to write. Acceptable values are: string, number, Boolean. When Boolean is provided 1.0
         * is transformed to true and 0.0 to false.
         * <p>
         * API name: {@code prediction_field_type}
         * </p>
         */
        @Nonnull
        public final Builder predictionFieldType(@Nullable String value) {
            this.predictionFieldType = value;
            return this;
        }

        /**
         * The field that is added to incoming documents to contain the inference prediction. Defaults to <code>predicted_value</code>.
         * <p>
         * API name: {@code results_field}
         * </p>
         */
        @Nonnull
        public final Builder resultsField(@Nullable String value) {
            this.resultsField = value;
            return this;
        }

        /**
         * Specifies the field to which the top classes are written. Defaults to <code>top_classes</code>.
         * <p>
         * API name: {@code top_classes_results_field}
         * </p>
         */
        @Nonnull
        public final Builder topClassesResultsField(@Nullable String value) {
            this.topClassesResultsField = value;
            return this;
        }

        /**
         * Builds a {@link ClassificationInferenceOptions}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ClassificationInferenceOptions build() {
            _checkSingleUse();

            return new ClassificationInferenceOptions(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ClassificationInferenceOptions}
     */
    public static final JsonpDeserializer<ClassificationInferenceOptions> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ClassificationInferenceOptions::setupClassificationInferenceOptionsDeserializer
    );

    protected static void setupClassificationInferenceOptionsDeserializer(ObjectDeserializer<ClassificationInferenceOptions.Builder> op) {
        op.add(Builder::numTopClasses, JsonpDeserializer.integerDeserializer(), "num_top_classes");
        op.add(Builder::numTopFeatureImportanceValues, JsonpDeserializer.integerDeserializer(), "num_top_feature_importance_values");
        op.add(Builder::predictionFieldType, JsonpDeserializer.stringDeserializer(), "prediction_field_type");
        op.add(Builder::resultsField, JsonpDeserializer.stringDeserializer(), "results_field");
        op.add(Builder::topClassesResultsField, JsonpDeserializer.stringDeserializer(), "top_classes_results_field");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.numTopClasses);
        result = 31 * result + Objects.hashCode(this.numTopFeatureImportanceValues);
        result = 31 * result + Objects.hashCode(this.predictionFieldType);
        result = 31 * result + Objects.hashCode(this.resultsField);
        result = 31 * result + Objects.hashCode(this.topClassesResultsField);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ClassificationInferenceOptions other = (ClassificationInferenceOptions) o;
        return Objects.equals(this.numTopClasses, other.numTopClasses)
            && Objects.equals(this.numTopFeatureImportanceValues, other.numTopFeatureImportanceValues)
            && Objects.equals(this.predictionFieldType, other.predictionFieldType)
            && Objects.equals(this.resultsField, other.resultsField)
            && Objects.equals(this.topClassesResultsField, other.topClassesResultsField);
    }
}
