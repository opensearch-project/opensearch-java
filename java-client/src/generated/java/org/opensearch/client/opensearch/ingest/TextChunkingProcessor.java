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

// typedef: ingest.TextChunkingProcessor

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class TextChunkingProcessor extends ProcessorBase
    implements
        ProcessorVariant,
        ToCopyableBuilder<TextChunkingProcessor.Builder, TextChunkingProcessor> {

    @Nonnull
    private final ChunkingAlgorithm algorithm;

    @Nonnull
    private final Map<String, String> fieldMap;

    @Nullable
    private final Integer maxChunkLimit;

    // ---------------------------------------------------------------------------------------------

    private TextChunkingProcessor(Builder builder) {
        super(builder);
        this.algorithm = ApiTypeHelper.requireNonNull(builder.algorithm, this, "algorithm");
        this.fieldMap = ApiTypeHelper.unmodifiableRequired(builder.fieldMap, this, "fieldMap");
        this.maxChunkLimit = builder.maxChunkLimit;
    }

    public static TextChunkingProcessor of(Function<TextChunkingProcessor.Builder, ObjectBuilder<TextChunkingProcessor>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link Processor} variant kind.
     */
    @Override
    public Processor.Kind _processorKind() {
        return Processor.Kind.TextChunking;
    }

    /**
     * Required - API name: {@code algorithm}
     */
    @Nonnull
    public final ChunkingAlgorithm algorithm() {
        return this.algorithm;
    }

    /**
     * Required - Contains key-value pairs that specify the mapping of a source text field to a target chunked field.
     * <p>
     * API name: {@code field_map}
     * </p>
     */
    @Nonnull
    public final Map<String, String> fieldMap() {
        return this.fieldMap;
    }

    /**
     * Maximum number of chunks a document field can be split into. Defaults to 100.
     * <p>
     * API name: {@code max_chunk_limit}
     * </p>
     */
    @Nullable
    public final Integer maxChunkLimit() {
        return this.maxChunkLimit;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        super.serializeInternal(generator, mapper);
        generator.writeKey("algorithm");
        this.algorithm.serialize(generator, mapper);

        generator.writeKey("field_map");
        generator.writeStartObject();
        for (Map.Entry<String, String> item0 : this.fieldMap.entrySet()) {
            generator.writeKey(item0.getKey());
            generator.write(item0.getValue());
        }
        generator.writeEnd();

        if (this.maxChunkLimit != null) {
            generator.writeKey("max_chunk_limit");
            generator.write(this.maxChunkLimit);
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
     * Builder for {@link TextChunkingProcessor}.
     */
    public static class Builder extends ProcessorBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, TextChunkingProcessor> {
        private ChunkingAlgorithm algorithm;
        private Map<String, String> fieldMap;
        @Nullable
        private Integer maxChunkLimit;

        public Builder() {}

        private Builder(TextChunkingProcessor o) {
            super(o);
            this.algorithm = o.algorithm;
            this.fieldMap = _mapCopy(o.fieldMap);
            this.maxChunkLimit = o.maxChunkLimit;
        }

        private Builder(Builder o) {
            super(o);
            this.algorithm = o.algorithm;
            this.fieldMap = _mapCopy(o.fieldMap);
            this.maxChunkLimit = o.maxChunkLimit;
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
         * Required - API name: {@code algorithm}
         */
        @Nonnull
        public final Builder algorithm(ChunkingAlgorithm value) {
            this.algorithm = value;
            return this;
        }

        /**
         * Required - API name: {@code algorithm}
         */
        @Nonnull
        public final Builder algorithm(Function<ChunkingAlgorithm.Builder, ObjectBuilder<ChunkingAlgorithm>> fn) {
            return algorithm(fn.apply(new ChunkingAlgorithm.Builder()).build());
        }

        /**
         * Required - Contains key-value pairs that specify the mapping of a source text field to a target chunked field.
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
         * Required - Contains key-value pairs that specify the mapping of a source text field to a target chunked field.
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
         * Maximum number of chunks a document field can be split into. Defaults to 100.
         * <p>
         * API name: {@code max_chunk_limit}
         * </p>
         */
        @Nonnull
        public final Builder maxChunkLimit(@Nullable Integer value) {
            this.maxChunkLimit = value;
            return this;
        }

        /**
         * Builds a {@link TextChunkingProcessor}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public TextChunkingProcessor build() {
            _checkSingleUse();

            return new TextChunkingProcessor(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link TextChunkingProcessor}
     */
    public static final JsonpDeserializer<TextChunkingProcessor> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        TextChunkingProcessor::setupTextChunkingProcessorDeserializer
    );

    protected static void setupTextChunkingProcessorDeserializer(ObjectDeserializer<TextChunkingProcessor.Builder> op) {
        setupProcessorBaseDeserializer(op);
        op.add(Builder::algorithm, ChunkingAlgorithm._DESERIALIZER, "algorithm");
        op.add(Builder::fieldMap, JsonpDeserializer.stringMapDeserializer(JsonpDeserializer.stringDeserializer()), "field_map");
        op.add(Builder::maxChunkLimit, JsonpDeserializer.integerDeserializer(), "max_chunk_limit");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + this.algorithm.hashCode();
        result = 31 * result + this.fieldMap.hashCode();
        result = 31 * result + Objects.hashCode(this.maxChunkLimit);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        TextChunkingProcessor other = (TextChunkingProcessor) o;
        return this.algorithm.equals(other.algorithm)
            && this.fieldMap.equals(other.fieldMap)
            && Objects.equals(this.maxChunkLimit, other.maxChunkLimit);
    }
}
