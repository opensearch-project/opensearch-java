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
import org.opensearch.client.opensearch._types.ErrorResponse;
import org.opensearch.client.opensearch._types.RequestBase;
import org.opensearch.client.transport.Endpoint;
import org.opensearch.client.transport.endpoints.SimpleEndpoint;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: ml.update_message.Request

/**
 * Update a message.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public final class UpdateMessageRequest extends RequestBase
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<UpdateMessageRequest.Builder, UpdateMessageRequest> {

    @Nonnull
    private final Map<String, JsonData> additionalInfo;

    @Nullable
    private final String input;

    @Nonnull
    private final String messageId;

    @Nullable
    private final String origin;

    @Nullable
    private final String promptTemplate;

    @Nullable
    private final String response;

    // ---------------------------------------------------------------------------------------------

    private UpdateMessageRequest(Builder builder) {
        super(builder);
        this.additionalInfo = ApiTypeHelper.unmodifiable(builder.additionalInfo);
        this.input = builder.input;
        this.messageId = ApiTypeHelper.requireNonNull(builder.messageId, this, "messageId");
        this.origin = builder.origin;
        this.promptTemplate = builder.promptTemplate;
        this.response = builder.response;
    }

    public static UpdateMessageRequest of(Function<UpdateMessageRequest.Builder, ObjectBuilder<UpdateMessageRequest>> fn) {
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
     * Required - API name: {@code message_id}
     */
    @Nonnull
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

        if (this.input != null) {
            generator.writeKey("input");
            generator.write(this.input);
        }

        if (this.origin != null) {
            generator.writeKey("origin");
            generator.write(this.origin);
        }

        if (this.promptTemplate != null) {
            generator.writeKey("prompt_template");
            generator.write(this.promptTemplate);
        }

        if (this.response != null) {
            generator.writeKey("response");
            generator.write(this.response);
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
     * Builder for {@link UpdateMessageRequest}.
     */
    public static class Builder extends RequestBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, UpdateMessageRequest> {
        @Nullable
        private Map<String, JsonData> additionalInfo;
        @Nullable
        private String input;
        private String messageId;
        @Nullable
        private String origin;
        @Nullable
        private String promptTemplate;
        @Nullable
        private String response;

        public Builder() {}

        private Builder(UpdateMessageRequest o) {
            super(o);
            this.additionalInfo = _mapCopy(o.additionalInfo);
            this.input = o.input;
            this.messageId = o.messageId;
            this.origin = o.origin;
            this.promptTemplate = o.promptTemplate;
            this.response = o.response;
        }

        private Builder(Builder o) {
            super(o);
            this.additionalInfo = _mapCopy(o.additionalInfo);
            this.input = o.input;
            this.messageId = o.messageId;
            this.origin = o.origin;
            this.promptTemplate = o.promptTemplate;
            this.response = o.response;
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
         * Required - API name: {@code message_id}
         */
        @Nonnull
        public final Builder messageId(String value) {
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
         * Builds a {@link UpdateMessageRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public UpdateMessageRequest build() {
            _checkSingleUse();

            return new UpdateMessageRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link UpdateMessageRequest}
     */
    public static final JsonpDeserializer<UpdateMessageRequest> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        UpdateMessageRequest::setupUpdateMessageRequestDeserializer
    );

    protected static void setupUpdateMessageRequestDeserializer(ObjectDeserializer<UpdateMessageRequest.Builder> op) {
        op.add(Builder::additionalInfo, JsonpDeserializer.stringMapDeserializer(JsonData._DESERIALIZER), "additional_info");
        op.add(Builder::input, JsonpDeserializer.stringDeserializer(), "input");
        op.add(Builder::origin, JsonpDeserializer.stringDeserializer(), "origin");
        op.add(Builder::promptTemplate, JsonpDeserializer.stringDeserializer(), "prompt_template");
        op.add(Builder::response, JsonpDeserializer.stringDeserializer(), "response");
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Endpoint "{@code ml.update_message}".
     */
    public static final Endpoint<UpdateMessageRequest, UpdateMessageResponse, ErrorResponse> _ENDPOINT = new SimpleEndpoint<>(
        // Request method
        request -> "PUT",
        // Request path
        request -> {
            StringBuilder buf = new StringBuilder();
            buf.append("/_plugins/_ml/memory/message/");
            SimpleEndpoint.pathEncode(request.messageId, buf);
            return buf.toString();
        },
        // Request parameters
        request -> {
            Map<String, String> params = new HashMap<>();
            request.applyQueryParameters(params);
            return params;
        },
        SimpleEndpoint.emptyMap(),
        true,
        UpdateMessageResponse._DESERIALIZER
    );

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.additionalInfo);
        result = 31 * result + Objects.hashCode(this.input);
        result = 31 * result + this.messageId.hashCode();
        result = 31 * result + Objects.hashCode(this.origin);
        result = 31 * result + Objects.hashCode(this.promptTemplate);
        result = 31 * result + Objects.hashCode(this.response);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        UpdateMessageRequest other = (UpdateMessageRequest) o;
        return Objects.equals(this.additionalInfo, other.additionalInfo)
            && Objects.equals(this.input, other.input)
            && this.messageId.equals(other.messageId)
            && Objects.equals(this.origin, other.origin)
            && Objects.equals(this.promptTemplate, other.promptTemplate)
            && Objects.equals(this.response, other.response);
    }
}
