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

package org.opensearch.client.opensearch.search_pipeline;

import jakarta.json.stream.JsonGenerator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.opensearch.client.json.JsonData;
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

// typedef: search_pipeline.MLInferenceRequestProcessor

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class MLInferenceRequestProcessor
    implements
        RequestProcessorVariant,
        PlainJsonSerializable,
        ToCopyableBuilder<MLInferenceRequestProcessor.Builder, MLInferenceRequestProcessor> {

    @Nullable
    private final String description;

    @Nullable
    private final String functionName;

    @Nullable
    private final Boolean ignoreFailure;

    @Nonnull
    private final List<Map<String, String>> inputMap;

    @Nonnull
    private final Map<String, JsonData> modelConfig;

    @Nonnull
    private final String modelId;

    @Nullable
    private final String modelInput;

    @Nonnull
    private final List<Map<String, String>> outputMap;

    @Nullable
    private final String tag;

    // ---------------------------------------------------------------------------------------------

    private MLInferenceRequestProcessor(Builder builder) {
        this.description = builder.description;
        this.functionName = builder.functionName;
        this.ignoreFailure = builder.ignoreFailure;
        this.inputMap = ApiTypeHelper.unmodifiable(builder.inputMap);
        this.modelConfig = ApiTypeHelper.unmodifiable(builder.modelConfig);
        this.modelId = ApiTypeHelper.requireNonNull(builder.modelId, this, "modelId");
        this.modelInput = builder.modelInput;
        this.outputMap = ApiTypeHelper.unmodifiable(builder.outputMap);
        this.tag = builder.tag;
    }

    public static MLInferenceRequestProcessor of(
        Function<MLInferenceRequestProcessor.Builder, ObjectBuilder<MLInferenceRequestProcessor>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link RequestProcessor} variant kind.
     */
    @Override
    public RequestProcessor.Kind _requestProcessorKind() {
        return RequestProcessor.Kind.MlInference;
    }

    /**
     * API name: {@code description}
     */
    @Nullable
    public final String description() {
        return this.description;
    }

    /**
     * API name: {@code function_name}
     */
    @Nullable
    public final String functionName() {
        return this.functionName;
    }

    /**
     * API name: {@code ignore_failure}
     */
    @Nullable
    public final Boolean ignoreFailure() {
        return this.ignoreFailure;
    }

    /**
     * API name: {@code input_map}
     */
    @Nonnull
    public final List<Map<String, String>> inputMap() {
        return this.inputMap;
    }

    /**
     * API name: {@code model_config}
     */
    @Nonnull
    public final Map<String, JsonData> modelConfig() {
        return this.modelConfig;
    }

    /**
     * Required - API name: {@code model_id}
     */
    @Nonnull
    public final String modelId() {
        return this.modelId;
    }

    /**
     * API name: {@code model_input}
     */
    @Nullable
    public final String modelInput() {
        return this.modelInput;
    }

    /**
     * API name: {@code output_map}
     */
    @Nonnull
    public final List<Map<String, String>> outputMap() {
        return this.outputMap;
    }

    /**
     * API name: {@code tag}
     */
    @Nullable
    public final String tag() {
        return this.tag;
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
        if (this.description != null) {
            generator.writeKey("description");
            generator.write(this.description);
        }

        if (this.functionName != null) {
            generator.writeKey("function_name");
            generator.write(this.functionName);
        }

        if (this.ignoreFailure != null) {
            generator.writeKey("ignore_failure");
            generator.write(this.ignoreFailure);
        }

        if (ApiTypeHelper.isDefined(this.inputMap)) {
            generator.writeKey("input_map");
            generator.writeStartArray();
            for (Map<String, String> item0 : this.inputMap) {
                generator.writeStartObject();
                if (item0 != null) {
                    for (Map.Entry<String, String> item1 : item0.entrySet()) {
                        generator.writeKey(item1.getKey());
                        generator.write(item1.getValue());
                    }
                }
                generator.writeEnd();
            }
            generator.writeEnd();
        }

        if (ApiTypeHelper.isDefined(this.modelConfig)) {
            generator.writeKey("model_config");
            generator.writeStartObject();
            for (Map.Entry<String, JsonData> item0 : this.modelConfig.entrySet()) {
                generator.writeKey(item0.getKey());
                item0.getValue().serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        generator.writeKey("model_id");
        generator.write(this.modelId);

        if (this.modelInput != null) {
            generator.writeKey("model_input");
            generator.write(this.modelInput);
        }

        if (ApiTypeHelper.isDefined(this.outputMap)) {
            generator.writeKey("output_map");
            generator.writeStartArray();
            for (Map<String, String> item0 : this.outputMap) {
                generator.writeStartObject();
                if (item0 != null) {
                    for (Map.Entry<String, String> item1 : item0.entrySet()) {
                        generator.writeKey(item1.getKey());
                        generator.write(item1.getValue());
                    }
                }
                generator.writeEnd();
            }
            generator.writeEnd();
        }

        if (this.tag != null) {
            generator.writeKey("tag");
            generator.write(this.tag);
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
     * Builder for {@link MLInferenceRequestProcessor}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, MLInferenceRequestProcessor> {
        @Nullable
        private String description;
        @Nullable
        private String functionName;
        @Nullable
        private Boolean ignoreFailure;
        @Nullable
        private List<Map<String, String>> inputMap;
        @Nullable
        private Map<String, JsonData> modelConfig;
        private String modelId;
        @Nullable
        private String modelInput;
        @Nullable
        private List<Map<String, String>> outputMap;
        @Nullable
        private String tag;

        public Builder() {}

        private Builder(MLInferenceRequestProcessor o) {
            this.description = o.description;
            this.functionName = o.functionName;
            this.ignoreFailure = o.ignoreFailure;
            this.inputMap = _listCopy(o.inputMap);
            this.modelConfig = _mapCopy(o.modelConfig);
            this.modelId = o.modelId;
            this.modelInput = o.modelInput;
            this.outputMap = _listCopy(o.outputMap);
            this.tag = o.tag;
        }

        private Builder(Builder o) {
            this.description = o.description;
            this.functionName = o.functionName;
            this.ignoreFailure = o.ignoreFailure;
            this.inputMap = _listCopy(o.inputMap);
            this.modelConfig = _mapCopy(o.modelConfig);
            this.modelId = o.modelId;
            this.modelInput = o.modelInput;
            this.outputMap = _listCopy(o.outputMap);
            this.tag = o.tag;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code description}
         */
        @Nonnull
        public final Builder description(@Nullable String value) {
            this.description = value;
            return this;
        }

        /**
         * API name: {@code function_name}
         */
        @Nonnull
        public final Builder functionName(@Nullable String value) {
            this.functionName = value;
            return this;
        }

        /**
         * API name: {@code ignore_failure}
         */
        @Nonnull
        public final Builder ignoreFailure(@Nullable Boolean value) {
            this.ignoreFailure = value;
            return this;
        }

        /**
         * API name: {@code input_map}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>inputMap</code>.
         * </p>
         */
        @Nonnull
        public final Builder inputMap(List<Map<String, String>> list) {
            this.inputMap = _listAddAll(this.inputMap, list);
            return this;
        }

        /**
         * API name: {@code input_map}
         *
         * <p>
         * Adds one or more values to <code>inputMap</code>.
         * </p>
         */
        @Nonnull
        public final Builder inputMap(Map<String, String> value, Map<String, String>... values) {
            this.inputMap = _listAdd(this.inputMap, value, values);
            return this;
        }

        /**
         * API name: {@code model_config}
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>modelConfig</code>.
         * </p>
         */
        @Nonnull
        public final Builder modelConfig(Map<String, JsonData> map) {
            this.modelConfig = _mapPutAll(this.modelConfig, map);
            return this;
        }

        /**
         * API name: {@code model_config}
         *
         * <p>
         * Adds an entry to <code>modelConfig</code>.
         * </p>
         */
        @Nonnull
        public final Builder modelConfig(String key, JsonData value) {
            this.modelConfig = _mapPut(this.modelConfig, key, value);
            return this;
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
         * API name: {@code model_input}
         */
        @Nonnull
        public final Builder modelInput(@Nullable String value) {
            this.modelInput = value;
            return this;
        }

        /**
         * API name: {@code output_map}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>outputMap</code>.
         * </p>
         */
        @Nonnull
        public final Builder outputMap(List<Map<String, String>> list) {
            this.outputMap = _listAddAll(this.outputMap, list);
            return this;
        }

        /**
         * API name: {@code output_map}
         *
         * <p>
         * Adds one or more values to <code>outputMap</code>.
         * </p>
         */
        @Nonnull
        public final Builder outputMap(Map<String, String> value, Map<String, String>... values) {
            this.outputMap = _listAdd(this.outputMap, value, values);
            return this;
        }

        /**
         * API name: {@code tag}
         */
        @Nonnull
        public final Builder tag(@Nullable String value) {
            this.tag = value;
            return this;
        }

        /**
         * Builds a {@link MLInferenceRequestProcessor}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public MLInferenceRequestProcessor build() {
            _checkSingleUse();

            return new MLInferenceRequestProcessor(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link MLInferenceRequestProcessor}
     */
    public static final JsonpDeserializer<MLInferenceRequestProcessor> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        MLInferenceRequestProcessor::setupMLInferenceRequestProcessorDeserializer
    );

    protected static void setupMLInferenceRequestProcessorDeserializer(ObjectDeserializer<MLInferenceRequestProcessor.Builder> op) {
        op.add(Builder::description, JsonpDeserializer.stringDeserializer(), "description");
        op.add(Builder::functionName, JsonpDeserializer.stringDeserializer(), "function_name");
        op.add(Builder::ignoreFailure, JsonpDeserializer.booleanDeserializer(), "ignore_failure");
        op.add(
            Builder::inputMap,
            JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringMapDeserializer(JsonpDeserializer.stringDeserializer())),
            "input_map"
        );
        op.add(Builder::modelConfig, JsonpDeserializer.stringMapDeserializer(JsonData._DESERIALIZER), "model_config");
        op.add(Builder::modelId, JsonpDeserializer.stringDeserializer(), "model_id");
        op.add(Builder::modelInput, JsonpDeserializer.stringDeserializer(), "model_input");
        op.add(
            Builder::outputMap,
            JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringMapDeserializer(JsonpDeserializer.stringDeserializer())),
            "output_map"
        );
        op.add(Builder::tag, JsonpDeserializer.stringDeserializer(), "tag");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.description);
        result = 31 * result + Objects.hashCode(this.functionName);
        result = 31 * result + Objects.hashCode(this.ignoreFailure);
        result = 31 * result + Objects.hashCode(this.inputMap);
        result = 31 * result + Objects.hashCode(this.modelConfig);
        result = 31 * result + this.modelId.hashCode();
        result = 31 * result + Objects.hashCode(this.modelInput);
        result = 31 * result + Objects.hashCode(this.outputMap);
        result = 31 * result + Objects.hashCode(this.tag);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        MLInferenceRequestProcessor other = (MLInferenceRequestProcessor) o;
        return Objects.equals(this.description, other.description)
            && Objects.equals(this.functionName, other.functionName)
            && Objects.equals(this.ignoreFailure, other.ignoreFailure)
            && Objects.equals(this.inputMap, other.inputMap)
            && Objects.equals(this.modelConfig, other.modelConfig)
            && this.modelId.equals(other.modelId)
            && Objects.equals(this.modelInput, other.modelInput)
            && Objects.equals(this.outputMap, other.outputMap)
            && Objects.equals(this.tag, other.tag);
    }
}
