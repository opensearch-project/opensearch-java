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
import java.util.HashMap;
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

// typedef: ml.Parameters

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class Parameters implements PlainJsonSerializable, ToCopyableBuilder<Parameters.Builder, Parameters> {

    @Nullable
    private final String inputs;

    @Nullable
    private final String llmInterface;

    @Nonnull
    private final List<Messages> messages;

    @Nonnull
    private final Map<String, JsonData> metadata;

    @Nullable
    private final String question;

    // ---------------------------------------------------------------------------------------------

    private Parameters(Builder builder) {
        this.inputs = builder.inputs;
        this.llmInterface = builder.llmInterface;
        this.messages = ApiTypeHelper.unmodifiable(builder.messages);
        this.metadata = ApiTypeHelper.unmodifiable(builder.metadata);
        this.question = builder.question;
    }

    public static Parameters of(Function<Parameters.Builder, ObjectBuilder<Parameters>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code inputs}
     */
    @Nullable
    public final String inputs() {
        return this.inputs;
    }

    /**
     * API name: {@code _llm_interface}
     */
    @Nullable
    public final String llmInterface() {
        return this.llmInterface;
    }

    /**
     * API name: {@code messages}
     */
    @Nonnull
    public final List<Messages> messages() {
        return this.messages;
    }

    @Nonnull
    public final Map<String, JsonData> metadata() {
        return this.metadata;
    }

    /**
     * API name: {@code question}
     */
    @Nullable
    public final String question() {
        return this.question;
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
        for (Map.Entry<String, JsonData> item0 : this.metadata.entrySet()) {
            generator.writeKey(item0.getKey());
            item0.getValue().serialize(generator, mapper);
        }
        if (this.inputs != null) {
            generator.writeKey("inputs");
            generator.write(this.inputs);
        }

        if (this.llmInterface != null) {
            generator.writeKey("_llm_interface");
            generator.write(this.llmInterface);
        }

        if (ApiTypeHelper.isDefined(this.messages)) {
            generator.writeKey("messages");
            generator.writeStartArray();
            for (Messages item0 : this.messages) {
                item0.serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (this.question != null) {
            generator.writeKey("question");
            generator.write(this.question);
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
     * Builder for {@link Parameters}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, Parameters> {
        @Nullable
        private String inputs;
        @Nullable
        private String llmInterface;
        @Nullable
        private List<Messages> messages;
        @Nullable
        private Map<String, JsonData> metadata;
        @Nullable
        private String question;

        public Builder() {}

        private Builder(Parameters o) {
            this.inputs = o.inputs;
            this.llmInterface = o.llmInterface;
            this.messages = _listCopy(o.messages);
            this.metadata = _mapCopy(o.metadata);
            this.question = o.question;
        }

        private Builder(Builder o) {
            this.inputs = o.inputs;
            this.llmInterface = o.llmInterface;
            this.messages = _listCopy(o.messages);
            this.metadata = _mapCopy(o.metadata);
            this.question = o.question;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code inputs}
         */
        @Nonnull
        public final Builder inputs(@Nullable String value) {
            this.inputs = value;
            return this;
        }

        /**
         * API name: {@code _llm_interface}
         */
        @Nonnull
        public final Builder llmInterface(@Nullable String value) {
            this.llmInterface = value;
            return this;
        }

        /**
         * API name: {@code messages}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>messages</code>.
         * </p>
         */
        @Nonnull
        public final Builder messages(List<Messages> list) {
            this.messages = _listAddAll(this.messages, list);
            return this;
        }

        /**
         * API name: {@code messages}
         *
         * <p>
         * Adds one or more values to <code>messages</code>.
         * </p>
         */
        @Nonnull
        public final Builder messages(Messages value, Messages... values) {
            this.messages = _listAdd(this.messages, value, values);
            return this;
        }

        /**
         * API name: {@code messages}
         *
         * <p>
         * Adds a value to <code>messages</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder messages(Function<Messages.Builder, ObjectBuilder<Messages>> fn) {
            return messages(fn.apply(new Messages.Builder()).build());
        }

        /**
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>metadata</code>.
         * </p>
         */
        @Nonnull
        public final Builder metadata(Map<String, JsonData> map) {
            this.metadata = _mapPutAll(this.metadata, map);
            return this;
        }

        /**
         *
         * <p>
         * Adds an entry to <code>metadata</code>.
         * </p>
         */
        @Nonnull
        public final Builder metadata(String key, JsonData value) {
            this.metadata = _mapPut(this.metadata, key, value);
            return this;
        }

        /**
         * API name: {@code question}
         */
        @Nonnull
        public final Builder question(@Nullable String value) {
            this.question = value;
            return this;
        }

        /**
         * Builds a {@link Parameters}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public Parameters build() {
            _checkSingleUse();

            return new Parameters(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link Parameters}
     */
    public static final JsonpDeserializer<Parameters> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        Parameters::setupParametersDeserializer
    );

    protected static void setupParametersDeserializer(ObjectDeserializer<Parameters.Builder> op) {
        op.add(Builder::inputs, JsonpDeserializer.stringDeserializer(), "inputs");
        op.add(Builder::llmInterface, JsonpDeserializer.stringDeserializer(), "_llm_interface");
        op.add(Builder::messages, JsonpDeserializer.arrayDeserializer(Messages._DESERIALIZER), "messages");
        op.add(Builder::question, JsonpDeserializer.stringDeserializer(), "question");
        op.setUnknownFieldHandler((builder, name, parser, mapper) -> {
            if (builder.metadata == null) {
                builder.metadata = new HashMap<>();
            }
            builder.metadata.put(name, JsonData._DESERIALIZER.deserialize(parser, mapper));
        });
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.inputs);
        result = 31 * result + Objects.hashCode(this.llmInterface);
        result = 31 * result + Objects.hashCode(this.messages);
        result = 31 * result + Objects.hashCode(this.metadata);
        result = 31 * result + Objects.hashCode(this.question);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Parameters other = (Parameters) o;
        return Objects.equals(this.inputs, other.inputs)
            && Objects.equals(this.llmInterface, other.llmInterface)
            && Objects.equals(this.messages, other.messages)
            && Objects.equals(this.metadata, other.metadata)
            && Objects.equals(this.question, other.question);
    }
}
