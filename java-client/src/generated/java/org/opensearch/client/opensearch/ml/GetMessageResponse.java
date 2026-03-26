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

// typedef: ml.get_message.Response

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class GetMessageResponse implements PlainJsonSerializable, ToCopyableBuilder<GetMessageResponse.Builder, GetMessageResponse> {

    @Nonnull
    private final Map<String, JsonData> additionalInfo;

    @Nonnull
    private final List<Content> content;

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
    private final String role;

    @Nullable
    private final Long traceNumber;

    // ---------------------------------------------------------------------------------------------

    private GetMessageResponse(Builder builder) {
        this.additionalInfo = ApiTypeHelper.unmodifiable(builder.additionalInfo);
        this.content = ApiTypeHelper.unmodifiable(builder.content);
        this.createTime = builder.createTime;
        this.input = builder.input;
        this.memoryId = builder.memoryId;
        this.messageId = builder.messageId;
        this.origin = builder.origin;
        this.parentMessageId = builder.parentMessageId;
        this.promptTemplate = builder.promptTemplate;
        this.response = builder.response;
        this.role = builder.role;
        this.traceNumber = builder.traceNumber;
    }

    public static GetMessageResponse of(Function<GetMessageResponse.Builder, ObjectBuilder<GetMessageResponse>> fn) {
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
     * API name: {@code content}
     */
    @Nonnull
    public final List<Content> content() {
        return this.content;
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
     * The role of the message.
     * <p>
     * API name: {@code role}
     * </p>
     */
    @Nullable
    public final String role() {
        return this.role;
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

        if (ApiTypeHelper.isDefined(this.content)) {
            generator.writeKey("content");
            generator.writeStartArray();
            for (Content item0 : this.content) {
                item0.serialize(generator, mapper);
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

        if (this.role != null) {
            generator.writeKey("role");
            generator.write(this.role);
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
     * Builder for {@link GetMessageResponse}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, GetMessageResponse> {
        @Nullable
        private Map<String, JsonData> additionalInfo;
        @Nullable
        private List<Content> content;
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
        private String role;
        @Nullable
        private Long traceNumber;

        public Builder() {}

        private Builder(GetMessageResponse o) {
            this.additionalInfo = _mapCopy(o.additionalInfo);
            this.content = _listCopy(o.content);
            this.createTime = o.createTime;
            this.input = o.input;
            this.memoryId = o.memoryId;
            this.messageId = o.messageId;
            this.origin = o.origin;
            this.parentMessageId = o.parentMessageId;
            this.promptTemplate = o.promptTemplate;
            this.response = o.response;
            this.role = o.role;
            this.traceNumber = o.traceNumber;
        }

        private Builder(Builder o) {
            this.additionalInfo = _mapCopy(o.additionalInfo);
            this.content = _listCopy(o.content);
            this.createTime = o.createTime;
            this.input = o.input;
            this.memoryId = o.memoryId;
            this.messageId = o.messageId;
            this.origin = o.origin;
            this.parentMessageId = o.parentMessageId;
            this.promptTemplate = o.promptTemplate;
            this.response = o.response;
            this.role = o.role;
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
         * API name: {@code content}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>content</code>.
         * </p>
         */
        @Nonnull
        public final Builder content(List<Content> list) {
            this.content = _listAddAll(this.content, list);
            return this;
        }

        /**
         * API name: {@code content}
         *
         * <p>
         * Adds one or more values to <code>content</code>.
         * </p>
         */
        @Nonnull
        public final Builder content(Content value, Content... values) {
            this.content = _listAdd(this.content, value, values);
            return this;
        }

        /**
         * API name: {@code content}
         *
         * <p>
         * Adds a value to <code>content</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder content(Function<Content.Builder, ObjectBuilder<Content>> fn) {
            return content(fn.apply(new Content.Builder()).build());
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
         * The role of the message.
         * <p>
         * API name: {@code role}
         * </p>
         */
        @Nonnull
        public final Builder role(@Nullable String value) {
            this.role = value;
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
         * Builds a {@link GetMessageResponse}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public GetMessageResponse build() {
            _checkSingleUse();

            return new GetMessageResponse(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link GetMessageResponse}
     */
    public static final JsonpDeserializer<GetMessageResponse> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        GetMessageResponse::setupGetMessageResponseDeserializer
    );

    protected static void setupGetMessageResponseDeserializer(ObjectDeserializer<GetMessageResponse.Builder> op) {
        op.add(Builder::additionalInfo, JsonpDeserializer.stringMapDeserializer(JsonData._DESERIALIZER), "additional_info");
        op.add(Builder::content, JsonpDeserializer.arrayDeserializer(Content._DESERIALIZER), "content");
        op.add(Builder::createTime, JsonpDeserializer.stringDeserializer(), "create_time");
        op.add(Builder::input, JsonpDeserializer.stringDeserializer(), "input");
        op.add(Builder::memoryId, JsonpDeserializer.stringDeserializer(), "memory_id");
        op.add(Builder::messageId, JsonpDeserializer.stringDeserializer(), "message_id");
        op.add(Builder::origin, JsonpDeserializer.stringDeserializer(), "origin");
        op.add(Builder::parentMessageId, JsonpDeserializer.stringDeserializer(), "parent_message_id");
        op.add(Builder::promptTemplate, JsonpDeserializer.stringDeserializer(), "prompt_template");
        op.add(Builder::response, JsonpDeserializer.stringDeserializer(), "response");
        op.add(Builder::role, JsonpDeserializer.stringDeserializer(), "role");
        op.add(Builder::traceNumber, JsonpDeserializer.longDeserializer(), "trace_number");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.additionalInfo);
        result = 31 * result + Objects.hashCode(this.content);
        result = 31 * result + Objects.hashCode(this.createTime);
        result = 31 * result + Objects.hashCode(this.input);
        result = 31 * result + Objects.hashCode(this.memoryId);
        result = 31 * result + Objects.hashCode(this.messageId);
        result = 31 * result + Objects.hashCode(this.origin);
        result = 31 * result + Objects.hashCode(this.parentMessageId);
        result = 31 * result + Objects.hashCode(this.promptTemplate);
        result = 31 * result + Objects.hashCode(this.response);
        result = 31 * result + Objects.hashCode(this.role);
        result = 31 * result + Objects.hashCode(this.traceNumber);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        GetMessageResponse other = (GetMessageResponse) o;
        return Objects.equals(this.additionalInfo, other.additionalInfo)
            && Objects.equals(this.content, other.content)
            && Objects.equals(this.createTime, other.createTime)
            && Objects.equals(this.input, other.input)
            && Objects.equals(this.memoryId, other.memoryId)
            && Objects.equals(this.messageId, other.messageId)
            && Objects.equals(this.origin, other.origin)
            && Objects.equals(this.parentMessageId, other.parentMessageId)
            && Objects.equals(this.promptTemplate, other.promptTemplate)
            && Objects.equals(this.response, other.response)
            && Objects.equals(this.role, other.role)
            && Objects.equals(this.traceNumber, other.traceNumber);
    }
}
