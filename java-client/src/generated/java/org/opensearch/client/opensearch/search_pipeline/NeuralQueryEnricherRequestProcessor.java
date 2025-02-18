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
import java.util.Map;
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
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: search_pipeline.NeuralQueryEnricherRequestProcessor

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class NeuralQueryEnricherRequestProcessor
    implements
        RequestProcessorVariant,
        PlainJsonSerializable,
        ToCopyableBuilder<NeuralQueryEnricherRequestProcessor.Builder, NeuralQueryEnricherRequestProcessor> {

    @Nullable
    private final String defaultModelId;

    @Nullable
    private final String description;

    @Nonnull
    private final Map<String, String> neuralFieldDefaultId;

    @Nullable
    private final String tag;

    // ---------------------------------------------------------------------------------------------

    private NeuralQueryEnricherRequestProcessor(Builder builder) {
        this.defaultModelId = builder.defaultModelId;
        this.description = builder.description;
        this.neuralFieldDefaultId = ApiTypeHelper.unmodifiable(builder.neuralFieldDefaultId);
        this.tag = builder.tag;
    }

    public static NeuralQueryEnricherRequestProcessor of(
        Function<NeuralQueryEnricherRequestProcessor.Builder, ObjectBuilder<NeuralQueryEnricherRequestProcessor>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link RequestProcessor} variant kind.
     */
    @Override
    public RequestProcessor.Kind _requestProcessorKind() {
        return RequestProcessor.Kind.NeuralQueryEnricher;
    }

    /**
     * API name: {@code default_model_id}
     */
    @Nullable
    public final String defaultModelId() {
        return this.defaultModelId;
    }

    /**
     * API name: {@code description}
     */
    @Nullable
    public final String description() {
        return this.description;
    }

    /**
     * API name: {@code neural_field_default_id}
     */
    @Nonnull
    public final Map<String, String> neuralFieldDefaultId() {
        return this.neuralFieldDefaultId;
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
        if (this.defaultModelId != null) {
            generator.writeKey("default_model_id");
            generator.write(this.defaultModelId);
        }

        if (this.description != null) {
            generator.writeKey("description");
            generator.write(this.description);
        }

        if (ApiTypeHelper.isDefined(this.neuralFieldDefaultId)) {
            generator.writeKey("neural_field_default_id");
            generator.writeStartObject();
            for (Map.Entry<String, String> item0 : this.neuralFieldDefaultId.entrySet()) {
                generator.writeKey(item0.getKey());
                generator.write(item0.getValue());
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
     * Builder for {@link NeuralQueryEnricherRequestProcessor}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, NeuralQueryEnricherRequestProcessor> {
        @Nullable
        private String defaultModelId;
        @Nullable
        private String description;
        @Nullable
        private Map<String, String> neuralFieldDefaultId;
        @Nullable
        private String tag;

        public Builder() {}

        private Builder(NeuralQueryEnricherRequestProcessor o) {
            this.defaultModelId = o.defaultModelId;
            this.description = o.description;
            this.neuralFieldDefaultId = _mapCopy(o.neuralFieldDefaultId);
            this.tag = o.tag;
        }

        private Builder(Builder o) {
            this.defaultModelId = o.defaultModelId;
            this.description = o.description;
            this.neuralFieldDefaultId = _mapCopy(o.neuralFieldDefaultId);
            this.tag = o.tag;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code default_model_id}
         */
        @Nonnull
        public final Builder defaultModelId(@Nullable String value) {
            this.defaultModelId = value;
            return this;
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
         * API name: {@code neural_field_default_id}
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>neuralFieldDefaultId</code>.
         * </p>
         */
        @Nonnull
        public final Builder neuralFieldDefaultId(Map<String, String> map) {
            this.neuralFieldDefaultId = _mapPutAll(this.neuralFieldDefaultId, map);
            return this;
        }

        /**
         * API name: {@code neural_field_default_id}
         *
         * <p>
         * Adds an entry to <code>neuralFieldDefaultId</code>.
         * </p>
         */
        @Nonnull
        public final Builder neuralFieldDefaultId(String key, String value) {
            this.neuralFieldDefaultId = _mapPut(this.neuralFieldDefaultId, key, value);
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
         * Builds a {@link NeuralQueryEnricherRequestProcessor}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public NeuralQueryEnricherRequestProcessor build() {
            _checkSingleUse();

            return new NeuralQueryEnricherRequestProcessor(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link NeuralQueryEnricherRequestProcessor}
     */
    public static final JsonpDeserializer<NeuralQueryEnricherRequestProcessor> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        NeuralQueryEnricherRequestProcessor::setupNeuralQueryEnricherRequestProcessorDeserializer
    );

    protected static void setupNeuralQueryEnricherRequestProcessorDeserializer(
        ObjectDeserializer<NeuralQueryEnricherRequestProcessor.Builder> op
    ) {
        op.add(Builder::defaultModelId, JsonpDeserializer.stringDeserializer(), "default_model_id");
        op.add(Builder::description, JsonpDeserializer.stringDeserializer(), "description");
        op.add(
            Builder::neuralFieldDefaultId,
            JsonpDeserializer.stringMapDeserializer(JsonpDeserializer.stringDeserializer()),
            "neural_field_default_id"
        );
        op.add(Builder::tag, JsonpDeserializer.stringDeserializer(), "tag");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.defaultModelId);
        result = 31 * result + Objects.hashCode(this.description);
        result = 31 * result + Objects.hashCode(this.neuralFieldDefaultId);
        result = 31 * result + Objects.hashCode(this.tag);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        NeuralQueryEnricherRequestProcessor other = (NeuralQueryEnricherRequestProcessor) o;
        return Objects.equals(this.defaultModelId, other.defaultModelId)
            && Objects.equals(this.description, other.description)
            && Objects.equals(this.neuralFieldDefaultId, other.neuralFieldDefaultId)
            && Objects.equals(this.tag, other.tag);
    }
}
