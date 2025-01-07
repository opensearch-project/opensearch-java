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

package org.opensearch.client.opensearch.ingest;

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
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: ingest.TextEmbeddingProcessor

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class TextEmbeddingProcessor extends ProcessorBase
    implements
        ProcessorVariant,
        ToCopyableBuilder<TextEmbeddingProcessor.Builder, TextEmbeddingProcessor> {

    @Nullable
    private final Integer batchSize;

    @Nonnull
    private final Map<String, String> fieldMap;

    @Nonnull
    private final String modelId;

    // ---------------------------------------------------------------------------------------------

    private TextEmbeddingProcessor(Builder builder) {
        super(builder);
        this.batchSize = builder.batchSize;
        this.fieldMap = ApiTypeHelper.unmodifiableRequired(builder.fieldMap, this, "fieldMap");
        this.modelId = ApiTypeHelper.requireNonNull(builder.modelId, this, "modelId");
    }

    public static TextEmbeddingProcessor of(Function<TextEmbeddingProcessor.Builder, ObjectBuilder<TextEmbeddingProcessor>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link Processor} variant kind.
     */
    @Override
    public Processor.Kind _processorKind() {
        return Processor.Kind.TextEmbedding;
    }

    /**
     * API name: {@code batch_size}
     */
    @Nullable
    public final Integer batchSize() {
        return this.batchSize;
    }

    /**
     * Required - Contains key-value pairs that specify the mapping of a text field to a vector field.
     * <p>
     * API name: {@code field_map}
     * </p>
     */
    @Nonnull
    public final Map<String, String> fieldMap() {
        return this.fieldMap;
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
        if (this.batchSize != null) {
            generator.writeKey("batch_size");
            generator.write(this.batchSize);
        }

        generator.writeKey("field_map");
        generator.writeStartObject();
        for (Map.Entry<String, String> item0 : this.fieldMap.entrySet()) {
            generator.writeKey(item0.getKey());
            generator.write(item0.getValue());
        }
        generator.writeEnd();

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
     * Builder for {@link TextEmbeddingProcessor}.
     */
    public static class Builder extends ProcessorBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, TextEmbeddingProcessor> {
        @Nullable
        private Integer batchSize;
        private Map<String, String> fieldMap;
        private String modelId;

        public Builder() {}

        private Builder(TextEmbeddingProcessor o) {
            super(o);
            this.batchSize = o.batchSize;
            this.fieldMap = _mapCopy(o.fieldMap);
            this.modelId = o.modelId;
        }

        private Builder(Builder o) {
            super(o);
            this.batchSize = o.batchSize;
            this.fieldMap = _mapCopy(o.fieldMap);
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
         * API name: {@code batch_size}
         */
        @Nonnull
        public final Builder batchSize(@Nullable Integer value) {
            this.batchSize = value;
            return this;
        }

        /**
         * Required - Contains key-value pairs that specify the mapping of a text field to a vector field.
         * <p>
         * API name: {@code field_map}
         * </p>
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>fieldMap</code>.
         * </p>
         */
        @Nonnull
        public final Builder fieldMap(Map<String, String> map) {
            this.fieldMap = _mapPutAll(this.fieldMap, map);
            return this;
        }

        /**
         * Required - Contains key-value pairs that specify the mapping of a text field to a vector field.
         * <p>
         * API name: {@code field_map}
         * </p>
         *
         * <p>
         * Adds an entry to <code>fieldMap</code>.
         * </p>
         */
        @Nonnull
        public final Builder fieldMap(String key, String value) {
            this.fieldMap = _mapPut(this.fieldMap, key, value);
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
         * Builds a {@link TextEmbeddingProcessor}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public TextEmbeddingProcessor build() {
            _checkSingleUse();

            return new TextEmbeddingProcessor(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link TextEmbeddingProcessor}
     */
    public static final JsonpDeserializer<TextEmbeddingProcessor> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        TextEmbeddingProcessor::setupTextEmbeddingProcessorDeserializer
    );

    protected static void setupTextEmbeddingProcessorDeserializer(ObjectDeserializer<TextEmbeddingProcessor.Builder> op) {
        setupProcessorBaseDeserializer(op);
        op.add(Builder::batchSize, JsonpDeserializer.integerDeserializer(), "batch_size");
        op.add(Builder::fieldMap, JsonpDeserializer.stringMapDeserializer(JsonpDeserializer.stringDeserializer()), "field_map");
        op.add(Builder::modelId, JsonpDeserializer.stringDeserializer(), "model_id");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(this.batchSize);
        result = 31 * result + this.fieldMap.hashCode();
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
        TextEmbeddingProcessor other = (TextEmbeddingProcessor) o;
        return Objects.equals(this.batchSize, other.batchSize)
            && this.fieldMap.equals(other.fieldMap)
            && this.modelId.equals(other.modelId);
    }
}
