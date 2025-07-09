/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

//----------------------------------------------------
// THIS CODE IS GENERATED. MANUAL EDITS WILL BE LOST.
//----------------------------------------------------

package org.opensearch.client.opensearch.ml;

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

// typedef: ml.Guardrails

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class Guardrails implements PlainJsonSerializable, ToCopyableBuilder<Guardrails.Builder, Guardrails> {

    @Nullable
    private final String indexName;

    @Nullable
    private final GuardrailsInputOutput inputGuardrail;

    @Nullable
    private final String modelId;

    @Nullable
    private final GuardrailsInputOutput outputGuardrail;

    @Nonnull
    private final Map<String, JsonData> regex;

    @Nullable
    private final String responseFilter;

    @Nullable
    private final String responseValidationRegex;

    @Nonnull
    private final List<String> sourceFields;

    @Nonnull
    private final List<String> stopWords;

    @Nullable
    private final String type;

    // ---------------------------------------------------------------------------------------------

    private Guardrails(Builder builder) {
        this.indexName = builder.indexName;
        this.inputGuardrail = builder.inputGuardrail;
        this.modelId = builder.modelId;
        this.outputGuardrail = builder.outputGuardrail;
        this.regex = ApiTypeHelper.unmodifiable(builder.regex);
        this.responseFilter = builder.responseFilter;
        this.responseValidationRegex = builder.responseValidationRegex;
        this.sourceFields = ApiTypeHelper.unmodifiable(builder.sourceFields);
        this.stopWords = ApiTypeHelper.unmodifiable(builder.stopWords);
        this.type = builder.type;
    }

    public static Guardrails of(Function<Guardrails.Builder, ObjectBuilder<Guardrails>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code index_name}
     */
    @Nullable
    public final String indexName() {
        return this.indexName;
    }

    /**
     * API name: {@code input_guardrail}
     */
    @Nullable
    public final GuardrailsInputOutput inputGuardrail() {
        return this.inputGuardrail;
    }

    /**
     * The model ID.
     * <p>
     * API name: {@code model_id}
     * </p>
     */
    @Nullable
    public final String modelId() {
        return this.modelId;
    }

    /**
     * API name: {@code output_guardrail}
     */
    @Nullable
    public final GuardrailsInputOutput outputGuardrail() {
        return this.outputGuardrail;
    }

    /**
     * The regex used for input/output validation.
     * <p>
     * API name: {@code regex}
     * </p>
     */
    @Nonnull
    public final Map<String, JsonData> regex() {
        return this.regex;
    }

    /**
     * The response filter.
     * <p>
     * API name: {@code response_filter}
     * </p>
     */
    @Nullable
    public final String responseFilter() {
        return this.responseFilter;
    }

    /**
     * The response validation regex.
     * <p>
     * API name: {@code response_validation_regex}
     * </p>
     */
    @Nullable
    public final String responseValidationRegex() {
        return this.responseValidationRegex;
    }

    /**
     * API name: {@code source_fields}
     */
    @Nonnull
    public final List<String> sourceFields() {
        return this.sourceFields;
    }

    /**
     * API name: {@code stop_words}
     */
    @Nonnull
    public final List<String> stopWords() {
        return this.stopWords;
    }

    /**
     * API name: {@code type}
     */
    @Nullable
    public final String type() {
        return this.type;
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
        if (this.indexName != null) {
            generator.writeKey("index_name");
            generator.write(this.indexName);
        }

        if (this.inputGuardrail != null) {
            generator.writeKey("input_guardrail");
            this.inputGuardrail.serialize(generator, mapper);
        }

        if (this.modelId != null) {
            generator.writeKey("model_id");
            generator.write(this.modelId);
        }

        if (this.outputGuardrail != null) {
            generator.writeKey("output_guardrail");
            this.outputGuardrail.serialize(generator, mapper);
        }

        if (ApiTypeHelper.isDefined(this.regex)) {
            generator.writeKey("regex");
            generator.writeStartObject();
            for (Map.Entry<String, JsonData> item0 : this.regex.entrySet()) {
                generator.writeKey(item0.getKey());
                item0.getValue().serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (this.responseFilter != null) {
            generator.writeKey("response_filter");
            generator.write(this.responseFilter);
        }

        if (this.responseValidationRegex != null) {
            generator.writeKey("response_validation_regex");
            generator.write(this.responseValidationRegex);
        }

        if (ApiTypeHelper.isDefined(this.sourceFields)) {
            generator.writeKey("source_fields");
            generator.writeStartArray();
            for (String item0 : this.sourceFields) {
                generator.write(item0);
            }
            generator.writeEnd();
        }

        if (ApiTypeHelper.isDefined(this.stopWords)) {
            generator.writeKey("stop_words");
            generator.writeStartArray();
            for (String item0 : this.stopWords) {
                generator.write(item0);
            }
            generator.writeEnd();
        }

        if (this.type != null) {
            generator.writeKey("type");
            generator.write(this.type);
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
     * Builder for {@link Guardrails}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, Guardrails> {
        @Nullable
        private String indexName;
        @Nullable
        private GuardrailsInputOutput inputGuardrail;
        @Nullable
        private String modelId;
        @Nullable
        private GuardrailsInputOutput outputGuardrail;
        @Nullable
        private Map<String, JsonData> regex;
        @Nullable
        private String responseFilter;
        @Nullable
        private String responseValidationRegex;
        @Nullable
        private List<String> sourceFields;
        @Nullable
        private List<String> stopWords;
        @Nullable
        private String type;

        public Builder() {}

        private Builder(Guardrails o) {
            this.indexName = o.indexName;
            this.inputGuardrail = o.inputGuardrail;
            this.modelId = o.modelId;
            this.outputGuardrail = o.outputGuardrail;
            this.regex = _mapCopy(o.regex);
            this.responseFilter = o.responseFilter;
            this.responseValidationRegex = o.responseValidationRegex;
            this.sourceFields = _listCopy(o.sourceFields);
            this.stopWords = _listCopy(o.stopWords);
            this.type = o.type;
        }

        private Builder(Builder o) {
            this.indexName = o.indexName;
            this.inputGuardrail = o.inputGuardrail;
            this.modelId = o.modelId;
            this.outputGuardrail = o.outputGuardrail;
            this.regex = _mapCopy(o.regex);
            this.responseFilter = o.responseFilter;
            this.responseValidationRegex = o.responseValidationRegex;
            this.sourceFields = _listCopy(o.sourceFields);
            this.stopWords = _listCopy(o.stopWords);
            this.type = o.type;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code index_name}
         */
        @Nonnull
        public final Builder indexName(@Nullable String value) {
            this.indexName = value;
            return this;
        }

        /**
         * API name: {@code input_guardrail}
         */
        @Nonnull
        public final Builder inputGuardrail(@Nullable GuardrailsInputOutput value) {
            this.inputGuardrail = value;
            return this;
        }

        /**
         * API name: {@code input_guardrail}
         */
        @Nonnull
        public final Builder inputGuardrail(Function<GuardrailsInputOutput.Builder, ObjectBuilder<GuardrailsInputOutput>> fn) {
            return inputGuardrail(fn.apply(new GuardrailsInputOutput.Builder()).build());
        }

        /**
         * The model ID.
         * <p>
         * API name: {@code model_id}
         * </p>
         */
        @Nonnull
        public final Builder modelId(@Nullable String value) {
            this.modelId = value;
            return this;
        }

        /**
         * API name: {@code output_guardrail}
         */
        @Nonnull
        public final Builder outputGuardrail(@Nullable GuardrailsInputOutput value) {
            this.outputGuardrail = value;
            return this;
        }

        /**
         * API name: {@code output_guardrail}
         */
        @Nonnull
        public final Builder outputGuardrail(Function<GuardrailsInputOutput.Builder, ObjectBuilder<GuardrailsInputOutput>> fn) {
            return outputGuardrail(fn.apply(new GuardrailsInputOutput.Builder()).build());
        }

        /**
         * The regex used for input/output validation.
         * <p>
         * API name: {@code regex}
         * </p>
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>regex</code>.
         * </p>
         */
        @Nonnull
        public final Builder regex(Map<String, JsonData> map) {
            this.regex = _mapPutAll(this.regex, map);
            return this;
        }

        /**
         * The regex used for input/output validation.
         * <p>
         * API name: {@code regex}
         * </p>
         *
         * <p>
         * Adds an entry to <code>regex</code>.
         * </p>
         */
        @Nonnull
        public final Builder regex(String key, JsonData value) {
            this.regex = _mapPut(this.regex, key, value);
            return this;
        }

        /**
         * The response filter.
         * <p>
         * API name: {@code response_filter}
         * </p>
         */
        @Nonnull
        public final Builder responseFilter(@Nullable String value) {
            this.responseFilter = value;
            return this;
        }

        /**
         * The response validation regex.
         * <p>
         * API name: {@code response_validation_regex}
         * </p>
         */
        @Nonnull
        public final Builder responseValidationRegex(@Nullable String value) {
            this.responseValidationRegex = value;
            return this;
        }

        /**
         * API name: {@code source_fields}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>sourceFields</code>.
         * </p>
         */
        @Nonnull
        public final Builder sourceFields(List<String> list) {
            this.sourceFields = _listAddAll(this.sourceFields, list);
            return this;
        }

        /**
         * API name: {@code source_fields}
         *
         * <p>
         * Adds one or more values to <code>sourceFields</code>.
         * </p>
         */
        @Nonnull
        public final Builder sourceFields(String value, String... values) {
            this.sourceFields = _listAdd(this.sourceFields, value, values);
            return this;
        }

        /**
         * API name: {@code stop_words}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>stopWords</code>.
         * </p>
         */
        @Nonnull
        public final Builder stopWords(List<String> list) {
            this.stopWords = _listAddAll(this.stopWords, list);
            return this;
        }

        /**
         * API name: {@code stop_words}
         *
         * <p>
         * Adds one or more values to <code>stopWords</code>.
         * </p>
         */
        @Nonnull
        public final Builder stopWords(String value, String... values) {
            this.stopWords = _listAdd(this.stopWords, value, values);
            return this;
        }

        /**
         * API name: {@code type}
         */
        @Nonnull
        public final Builder type(@Nullable String value) {
            this.type = value;
            return this;
        }

        /**
         * Builds a {@link Guardrails}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public Guardrails build() {
            _checkSingleUse();

            return new Guardrails(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link Guardrails}
     */
    public static final JsonpDeserializer<Guardrails> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        Guardrails::setupGuardrailsDeserializer
    );

    protected static void setupGuardrailsDeserializer(ObjectDeserializer<Guardrails.Builder> op) {
        op.add(Builder::indexName, JsonpDeserializer.stringDeserializer(), "index_name");
        op.add(Builder::inputGuardrail, GuardrailsInputOutput._DESERIALIZER, "input_guardrail");
        op.add(Builder::modelId, JsonpDeserializer.stringDeserializer(), "model_id");
        op.add(Builder::outputGuardrail, GuardrailsInputOutput._DESERIALIZER, "output_guardrail");
        op.add(Builder::regex, JsonpDeserializer.stringMapDeserializer(JsonData._DESERIALIZER), "regex");
        op.add(Builder::responseFilter, JsonpDeserializer.stringDeserializer(), "response_filter");
        op.add(Builder::responseValidationRegex, JsonpDeserializer.stringDeserializer(), "response_validation_regex");
        op.add(Builder::sourceFields, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "source_fields");
        op.add(Builder::stopWords, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "stop_words");
        op.add(Builder::type, JsonpDeserializer.stringDeserializer(), "type");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.indexName);
        result = 31 * result + Objects.hashCode(this.inputGuardrail);
        result = 31 * result + Objects.hashCode(this.modelId);
        result = 31 * result + Objects.hashCode(this.outputGuardrail);
        result = 31 * result + Objects.hashCode(this.regex);
        result = 31 * result + Objects.hashCode(this.responseFilter);
        result = 31 * result + Objects.hashCode(this.responseValidationRegex);
        result = 31 * result + Objects.hashCode(this.sourceFields);
        result = 31 * result + Objects.hashCode(this.stopWords);
        result = 31 * result + Objects.hashCode(this.type);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Guardrails other = (Guardrails) o;
        return Objects.equals(this.indexName, other.indexName)
            && Objects.equals(this.inputGuardrail, other.inputGuardrail)
            && Objects.equals(this.modelId, other.modelId)
            && Objects.equals(this.outputGuardrail, other.outputGuardrail)
            && Objects.equals(this.regex, other.regex)
            && Objects.equals(this.responseFilter, other.responseFilter)
            && Objects.equals(this.responseValidationRegex, other.responseValidationRegex)
            && Objects.equals(this.sourceFields, other.sourceFields)
            && Objects.equals(this.stopWords, other.stopWords)
            && Objects.equals(this.type, other.type);
    }
}
