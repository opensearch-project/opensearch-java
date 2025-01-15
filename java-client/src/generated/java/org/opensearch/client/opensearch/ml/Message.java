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

// typedef: ml.Message

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class Message implements PlainJsonSerializable, ToCopyableBuilder<Message.Builder, Message> {

    @Nonnull
    private final Map<String, JsonData> additionalInfo;

    @Nullable
    private final String createTime;

    @Nullable
    private final String input;

    @Nullable
    private final String memoryId;

    @Nullable
    private final String messageId;

    @Nullable
    private final String origin;

    @Nullable
    private final String parentMessageId;

    @Nullable
    private final String promptTemplate;

    @Nullable
    private final String response;

    @Nullable
    private final Long traceNumber;

    // ---------------------------------------------------------------------------------------------

    private Message(Builder builder) {
        this.additionalInfo = ApiTypeHelper.unmodifiable(builder.additionalInfo);
        this.createTime = builder.createTime;
        this.input = builder.input;
        this.memoryId = builder.memoryId;
        this.messageId = builder.messageId;
        this.origin = builder.origin;
        this.parentMessageId = builder.parentMessageId;
        this.promptTemplate = builder.promptTemplate;
        this.response = builder.response;
        this.traceNumber = builder.traceNumber;
    }

    public static Message of(Function<Message.Builder, ObjectBuilder<Message>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code additional_info}
     */
    @Nonnull
    public final Map<String, JsonData> additionalInfo() {
        return this.additionalInfo;
    }

    /**
     * The create time.
     * <p>
     * API name: {@code create_time}
     * </p>
     */
    @Nullable
    public final String createTime() {
        return this.createTime;
    }

    /**
     * The question in the message.
     * <p>
     * API name: {@code input}
     * </p>
     */
    @Nullable
    public final String input() {
        return this.input;
    }

    /**
     * API name: {@code memory_id}
     */
    @Nullable
    public final String memoryId() {
        return this.memoryId;
    }

    /**
     * API name: {@code message_id}
     */
    @Nullable
    public final String messageId() {
        return this.messageId;
    }

    /**
     * The system name that generated the response.
     * <p>
     * API name: {@code origin}
     * </p>
     */
    @Nullable
    public final String origin() {
        return this.origin;
    }

    /**
     * The parent message ID.
     * <p>
     * API name: {@code parent_message_id}
     * </p>
     */
    @Nullable
    public final String parentMessageId() {
        return this.parentMessageId;
    }

    /**
     * The prompt template.
     * <p>
     * API name: {@code prompt_template}
     * </p>
     */
    @Nullable
    public final String promptTemplate() {
        return this.promptTemplate;
    }

    /**
     * The answer to the question.
     * <p>
     * API name: {@code response}
     * </p>
     */
    @Nullable
    public final String response() {
        return this.response;
    }

    /**
     * The trace number.
     * <p>
     * API name: {@code trace_number}
     * </p>
     */
    @Nullable
    public final Long traceNumber() {
        return this.traceNumber;
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
        if (ApiTypeHelper.isDefined(this.additionalInfo)) {
            generator.writeKey("additional_info");
            generator.writeStartObject();
            for (Map.Entry<String, JsonData> item0 : this.additionalInfo.entrySet()) {
                generator.writeKey(item0.getKey());
                item0.getValue().serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (this.createTime != null) {
            generator.writeKey("create_time");
            generator.write(this.createTime);
        }

        if (this.input != null) {
            generator.writeKey("input");
            generator.write(this.input);
        }

        if (this.memoryId != null) {
            generator.writeKey("memory_id");
            generator.write(this.memoryId);
        }

        if (this.messageId != null) {
            generator.writeKey("message_id");
            generator.write(this.messageId);
        }

        if (this.origin != null) {
            generator.writeKey("origin");
            generator.write(this.origin);
        }

        if (this.parentMessageId != null) {
            generator.writeKey("parent_message_id");
            generator.write(this.parentMessageId);
        }

        if (this.promptTemplate != null) {
            generator.writeKey("prompt_template");
            generator.write(this.promptTemplate);
        }

        if (this.response != null) {
            generator.writeKey("response");
            generator.write(this.response);
        }

        if (this.traceNumber != null) {
            generator.writeKey("trace_number");
            generator.write(this.traceNumber);
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
     * Builder for {@link Message}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, Message> {
        @Nullable
        private Map<String, JsonData> additionalInfo;
        @Nullable
        private String createTime;
        @Nullable
        private String input;
        @Nullable
        private String memoryId;
        @Nullable
        private String messageId;
        @Nullable
        private String origin;
        @Nullable
        private String parentMessageId;
        @Nullable
        private String promptTemplate;
        @Nullable
        private String response;
        @Nullable
        private Long traceNumber;

        public Builder() {}

        private Builder(Message o) {
            this.additionalInfo = _mapCopy(o.additionalInfo);
            this.createTime = o.createTime;
            this.input = o.input;
            this.memoryId = o.memoryId;
            this.messageId = o.messageId;
            this.origin = o.origin;
            this.parentMessageId = o.parentMessageId;
            this.promptTemplate = o.promptTemplate;
            this.response = o.response;
            this.traceNumber = o.traceNumber;
        }

        private Builder(Builder o) {
            this.additionalInfo = _mapCopy(o.additionalInfo);
            this.createTime = o.createTime;
            this.input = o.input;
            this.memoryId = o.memoryId;
            this.messageId = o.messageId;
            this.origin = o.origin;
            this.parentMessageId = o.parentMessageId;
            this.promptTemplate = o.promptTemplate;
            this.response = o.response;
            this.traceNumber = o.traceNumber;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code additional_info}
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>additionalInfo</code>.
         * </p>
         */
        @Nonnull
        public final Builder additionalInfo(Map<String, JsonData> map) {
            this.additionalInfo = _mapPutAll(this.additionalInfo, map);
            return this;
        }

        /**
         * API name: {@code additional_info}
         *
         * <p>
         * Adds an entry to <code>additionalInfo</code>.
         * </p>
         */
        @Nonnull
        public final Builder additionalInfo(String key, JsonData value) {
            this.additionalInfo = _mapPut(this.additionalInfo, key, value);
            return this;
        }

        /**
         * The create time.
         * <p>
         * API name: {@code create_time}
         * </p>
         */
        @Nonnull
        public final Builder createTime(@Nullable String value) {
            this.createTime = value;
            return this;
        }

        /**
         * The question in the message.
         * <p>
         * API name: {@code input}
         * </p>
         */
        @Nonnull
        public final Builder input(@Nullable String value) {
            this.input = value;
            return this;
        }

        /**
         * API name: {@code memory_id}
         */
        @Nonnull
        public final Builder memoryId(@Nullable String value) {
            this.memoryId = value;
            return this;
        }

        /**
         * API name: {@code message_id}
         */
        @Nonnull
        public final Builder messageId(@Nullable String value) {
            this.messageId = value;
            return this;
        }

        /**
         * The system name that generated the response.
         * <p>
         * API name: {@code origin}
         * </p>
         */
        @Nonnull
        public final Builder origin(@Nullable String value) {
            this.origin = value;
            return this;
        }

        /**
         * The parent message ID.
         * <p>
         * API name: {@code parent_message_id}
         * </p>
         */
        @Nonnull
        public final Builder parentMessageId(@Nullable String value) {
            this.parentMessageId = value;
            return this;
        }

        /**
         * The prompt template.
         * <p>
         * API name: {@code prompt_template}
         * </p>
         */
        @Nonnull
        public final Builder promptTemplate(@Nullable String value) {
            this.promptTemplate = value;
            return this;
        }

        /**
         * The answer to the question.
         * <p>
         * API name: {@code response}
         * </p>
         */
        @Nonnull
        public final Builder response(@Nullable String value) {
            this.response = value;
            return this;
        }

        /**
         * The trace number.
         * <p>
         * API name: {@code trace_number}
         * </p>
         */
        @Nonnull
        public final Builder traceNumber(@Nullable Long value) {
            this.traceNumber = value;
            return this;
        }

        /**
         * Builds a {@link Message}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public Message build() {
            _checkSingleUse();

            return new Message(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link Message}
     */
    public static final JsonpDeserializer<Message> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        Message::setupMessageDeserializer
    );

    protected static void setupMessageDeserializer(ObjectDeserializer<Message.Builder> op) {
        op.add(Builder::additionalInfo, JsonpDeserializer.stringMapDeserializer(JsonData._DESERIALIZER), "additional_info");
        op.add(Builder::createTime, JsonpDeserializer.stringDeserializer(), "create_time");
        op.add(Builder::input, JsonpDeserializer.stringDeserializer(), "input");
        op.add(Builder::memoryId, JsonpDeserializer.stringDeserializer(), "memory_id");
        op.add(Builder::messageId, JsonpDeserializer.stringDeserializer(), "message_id");
        op.add(Builder::origin, JsonpDeserializer.stringDeserializer(), "origin");
        op.add(Builder::parentMessageId, JsonpDeserializer.stringDeserializer(), "parent_message_id");
        op.add(Builder::promptTemplate, JsonpDeserializer.stringDeserializer(), "prompt_template");
        op.add(Builder::response, JsonpDeserializer.stringDeserializer(), "response");
        op.add(Builder::traceNumber, JsonpDeserializer.longDeserializer(), "trace_number");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.additionalInfo);
        result = 31 * result + Objects.hashCode(this.createTime);
        result = 31 * result + Objects.hashCode(this.input);
        result = 31 * result + Objects.hashCode(this.memoryId);
        result = 31 * result + Objects.hashCode(this.messageId);
        result = 31 * result + Objects.hashCode(this.origin);
        result = 31 * result + Objects.hashCode(this.parentMessageId);
        result = 31 * result + Objects.hashCode(this.promptTemplate);
        result = 31 * result + Objects.hashCode(this.response);
        result = 31 * result + Objects.hashCode(this.traceNumber);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Message other = (Message) o;
        return Objects.equals(this.additionalInfo, other.additionalInfo)
            && Objects.equals(this.createTime, other.createTime)
            && Objects.equals(this.input, other.input)
            && Objects.equals(this.memoryId, other.memoryId)
            && Objects.equals(this.messageId, other.messageId)
            && Objects.equals(this.origin, other.origin)
            && Objects.equals(this.parentMessageId, other.parentMessageId)
            && Objects.equals(this.promptTemplate, other.promptTemplate)
            && Objects.equals(this.response, other.response)
            && Objects.equals(this.traceNumber, other.traceNumber);
    }
}
