/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.opensearch.ingest;

import jakarta.json.stream.JsonGenerator;
import java.util.Map;
import java.util.function.Function;
import javax.annotation.Nullable;
import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.ObjectBuilder;

// typedef: ingest._types.TextEmbeddingProcessor

@JsonpDeserializable
public class TextEmbeddingProcessor extends ProcessorBase implements ProcessorVariant {
    private final String modelId;

    private final Map<String, String> fieldMap;

    @Nullable
    private final String description;

    // ---------------------------------------------------------------------------------------------

    private TextEmbeddingProcessor(Builder builder) {
        super(builder);

        this.modelId = ApiTypeHelper.requireNonNull(builder.modelId, this, "modelId");
        this.fieldMap = ApiTypeHelper.unmodifiableRequired(builder.fieldMap, this, "fieldMap");
        this.description = builder.description;

    }

    public static TextEmbeddingProcessor of(Function<Builder, ObjectBuilder<TextEmbeddingProcessor>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Processor variant kind.
     */
    @Override
    public Processor.Kind _processorKind() {
        return Processor.Kind.Inference;
    }

    /**
     * Required - API name: {@code model_id}
     */
    public final String modelId() {
        return this.modelId;
    }

    /**
     * API name: {@code field_map}
     */
    public final Map<String, String> fieldMap() {
        return this.fieldMap;
    }

    /**
    * API name: {@code description}
    */
    @Nullable
    public final String description() {
        return this.description;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {

        super.serializeInternal(generator, mapper);
        generator.writeKey("model_id");
        generator.write(this.modelId);

        if (ApiTypeHelper.isDefined(this.fieldMap)) {
            generator.writeKey("field_map");
            generator.writeStartObject();
            for (Map.Entry<String, String> item0 : this.fieldMap.entrySet()) {
                generator.writeKey(item0.getKey());
                generator.write(item0.getValue());
            }
            generator.writeEnd();

        }
        if (this.description != null) {
            generator.writeKey("description");
            generator.write(this.description);
        }

    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Builder for {@link TextEmbeddingProcessor}.
     */

    public static class Builder extends ProcessorBase.AbstractBuilder<Builder> implements ObjectBuilder<TextEmbeddingProcessor> {
        private String modelId;

        @Nullable
        private Map<String, String> fieldMap;

        @Nullable
        private String description;

        /**
         * Required - API name: {@code model_id}
         */
        public final Builder modelId(String value) {
            this.modelId = value;
            return this;
        }

        /**
         * API name: {@code field_map}
         * <p>
         * Adds all entries of <code>map</code> to <code>fieldMap</code>.
         */
        public final Builder fieldMap(Map<String, String> map) {
            this.fieldMap = _mapPutAll(this.fieldMap, map);
            return this;
        }

        /**
         * API name: {@code field_map}
         * <p>
         * Adds an entry to <code>fieldMap</code>.
         */
        public final Builder fieldMap(String key, String value) {
            this.fieldMap = _mapPut(this.fieldMap, key, value);
            return this;
        }

        /**
         * API name: {@code description}
         */
        public final Builder description(@Nullable String value) {
            this.description = value;
            return this;
        }

        @Override
        protected Builder self() {
            return this;
        }

        /**
         * Builds a {@link TextEmbeddingProcessor}.
         *
         * @throws NullPointerException
         *             if some of the required fields are null.
         */
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
        ProcessorBase.setupProcessorBaseDeserializer(op);
        op.add(Builder::modelId, JsonpDeserializer.stringDeserializer(), "model_id");
        op.add(Builder::fieldMap, JsonpDeserializer.stringMapDeserializer(JsonpDeserializer.stringDeserializer()), "field_map");
        op.add(Builder::description, JsonpDeserializer.stringDeserializer(), "description");
    }

}
