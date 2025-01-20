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
import org.opensearch.client.json.JsonEnum;
import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.JsonpSerializable;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.json.PlainJsonSerializable;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.TaggedUnion;
import org.opensearch.client.util.TaggedUnionUtils;

// typedef: _types.aggregations.InferenceConfigContainer

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class InferenceConfig implements TaggedUnion<InferenceConfig.Kind, InferenceConfigVariant>, PlainJsonSerializable {
    /**
     * {@link InferenceConfig} variant kinds.
     */
    public enum Kind implements JsonEnum {
        Classification("classification"),
        Regression("regression");

        private final String jsonValue;

        Kind(String jsonValue) {
            this.jsonValue = jsonValue;
        }

        @Override
        public String jsonValue() {
            return jsonValue;
        }
    }

    private final Kind _kind;
    private final InferenceConfigVariant _value;

    @Override
    public final Kind _kind() {
        return _kind;
    }

    @Override
    public final InferenceConfigVariant _get() {
        return _value;
    }

    public InferenceConfig(InferenceConfigVariant value) {
        this._kind = ApiTypeHelper.requireNonNull(value._inferenceConfigKind(), this, "<variant kind>");
        this._value = ApiTypeHelper.requireNonNull(value, this, "<variant value>");
    }

    private InferenceConfig(Builder builder) {
        this._kind = ApiTypeHelper.requireNonNull(builder._kind, builder, "<variant kind>");
        this._value = ApiTypeHelper.requireNonNull(builder._value, builder, "<variant value>");
    }

    public static InferenceConfig of(Function<InferenceConfig.Builder, ObjectBuilder<InferenceConfig>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Is this variant instance of kind {@code classification}?
     */
    public boolean isClassification() {
        return _kind == Kind.Classification;
    }

    /**
     * Get the {@code classification} variant value.
     *
     * @throws IllegalStateException if the current variant is not the {@code classification} kind.
     */
    public ClassificationInferenceOptions classification() {
        return TaggedUnionUtils.get(this, Kind.Classification);
    }

    /**
     * Is this variant instance of kind {@code regression}?
     */
    public boolean isRegression() {
        return _kind == Kind.Regression;
    }

    /**
     * Get the {@code regression} variant value.
     *
     * @throws IllegalStateException if the current variant is not the {@code regression} kind.
     */
    public RegressionInferenceOptions regression() {
        return TaggedUnionUtils.get(this, Kind.Regression);
    }

    @Override
    public void serialize(JsonGenerator generator, JsonpMapper mapper) {
        generator.writeStartObject();
        generator.writeKey(_kind.jsonValue());
        if (_value instanceof JsonpSerializable) {
            ((JsonpSerializable) _value).serialize(generator, mapper);
        }
        generator.writeEnd();
    }

    @Nonnull
    public Builder toBuilder() {
        return new Builder(this);
    }

    @Nonnull
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder extends ObjectBuilderBase implements ObjectBuilder<InferenceConfig> {
        private Kind _kind;
        private InferenceConfigVariant _value;

        public Builder() {}

        private Builder(InferenceConfig o) {
            this._kind = o._kind;
            this._value = o._value;
        }

        public ObjectBuilder<InferenceConfig> classification(ClassificationInferenceOptions v) {
            this._kind = Kind.Classification;
            this._value = v;
            return this;
        }

        public ObjectBuilder<InferenceConfig> classification(
            Function<ClassificationInferenceOptions.Builder, ObjectBuilder<ClassificationInferenceOptions>> fn
        ) {
            return this.classification(fn.apply(new ClassificationInferenceOptions.Builder()).build());
        }

        public ObjectBuilder<InferenceConfig> regression(RegressionInferenceOptions v) {
            this._kind = Kind.Regression;
            this._value = v;
            return this;
        }

        public ObjectBuilder<InferenceConfig> regression(
            Function<RegressionInferenceOptions.Builder, ObjectBuilder<RegressionInferenceOptions>> fn
        ) {
            return this.regression(fn.apply(new RegressionInferenceOptions.Builder()).build());
        }

        @Override
        public InferenceConfig build() {
            _checkSingleUse();
            return new InferenceConfig(this);
        }
    }

    protected static void setupInferenceConfigDeserializer(ObjectDeserializer<Builder> op) {
        op.add(Builder::classification, ClassificationInferenceOptions._DESERIALIZER, "classification");
        op.add(Builder::regression, RegressionInferenceOptions._DESERIALIZER, "regression");
    }

    public static final JsonpDeserializer<InferenceConfig> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        InferenceConfig::setupInferenceConfigDeserializer,
        Builder::build
    );

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this._kind);
        result = 31 * result + Objects.hashCode(this._value);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        InferenceConfig other = (InferenceConfig) o;
        return Objects.equals(this._kind, other._kind) && Objects.equals(this._value, other._value);
    }
}
