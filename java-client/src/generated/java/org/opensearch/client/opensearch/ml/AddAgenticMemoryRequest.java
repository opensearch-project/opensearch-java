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
import org.opensearch.client.opensearch._types.ErrorResponse;
import org.opensearch.client.opensearch._types.RequestBase;
import org.opensearch.client.transport.Endpoint;
import org.opensearch.client.transport.endpoints.SimpleEndpoint;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: ml.add_agentic_memory.Request

/**
 * Add agentic memory to a memory container.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public final class AddAgenticMemoryRequest extends RequestBase
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<AddAgenticMemoryRequest.Builder, AddAgenticMemoryRequest> {

    @Nullable
    private final String binaryData;

    @Nullable
    private final Boolean infer;

    @Nonnull
    private final String memoryContainerId;

    @Nonnull
    private final List<Message> messages;

    @Nonnull
    private final Map<String, JsonData> metadata;

    @Nonnull
    private final Map<String, JsonData> namespace;

    @Nullable
    private final String payloadType;

    @Nonnull
    private final Map<String, JsonData> structuredData;

    @Nonnull
    private final Map<String, JsonData> tags;

    // ---------------------------------------------------------------------------------------------

    private AddAgenticMemoryRequest(Builder builder) {
        super(builder);
        this.binaryData = builder.binaryData;
        this.infer = builder.infer;
        this.memoryContainerId = ApiTypeHelper.requireNonNull(builder.memoryContainerId, this, "memoryContainerId");
        this.messages = ApiTypeHelper.unmodifiable(builder.messages);
        this.metadata = ApiTypeHelper.unmodifiable(builder.metadata);
        this.namespace = ApiTypeHelper.unmodifiable(builder.namespace);
        this.payloadType = builder.payloadType;
        this.structuredData = ApiTypeHelper.unmodifiable(builder.structuredData);
        this.tags = ApiTypeHelper.unmodifiable(builder.tags);
    }

    public static AddAgenticMemoryRequest of(Function<AddAgenticMemoryRequest.Builder, ObjectBuilder<AddAgenticMemoryRequest>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Binary data content encoded as Base64 string.
     * <p>
     * API name: {@code binary_data}
     * </p>
     */
    @Nullable
    public final String binaryData() {
        return this.binaryData;
    }

    /**
     * Whether to use LLM to extract key information.
     * <p>
     * API name: {@code infer}
     * </p>
     */
    @Nullable
    public final Boolean infer() {
        return this.infer;
    }

    /**
     * Required - API name: {@code memory_container_id}
     */
    @Nonnull
    public final String memoryContainerId() {
        return this.memoryContainerId;
    }

    /**
     * API name: {@code messages}
     */
    @Nonnull
    public final List<Message> messages() {
        return this.messages;
    }

    /**
     * API name: {@code metadata}
     */
    @Nonnull
    public final Map<String, JsonData> metadata() {
        return this.metadata;
    }

    /**
     * API name: {@code namespace}
     */
    @Nonnull
    public final Map<String, JsonData> namespace() {
        return this.namespace;
    }

    /**
     * The type of payload.
     * <p>
     * API name: {@code payload_type}
     * </p>
     */
    @Nullable
    public final String payloadType() {
        return this.payloadType;
    }

    /**
     * API name: {@code structured_data}
     */
    @Nonnull
    public final Map<String, JsonData> structuredData() {
        return this.structuredData;
    }

    /**
     * API name: {@code tags}
     */
    @Nonnull
    public final Map<String, JsonData> tags() {
        return this.tags;
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
        if (this.binaryData != null) {
            generator.writeKey("binary_data");
            generator.write(this.binaryData);
        }

        if (this.infer != null) {
            generator.writeKey("infer");
            generator.write(this.infer);
        }

        if (ApiTypeHelper.isDefined(this.messages)) {
            generator.writeKey("messages");
            generator.writeStartArray();
            for (Message item0 : this.messages) {
                item0.serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (ApiTypeHelper.isDefined(this.metadata)) {
            generator.writeKey("metadata");
            generator.writeStartObject();
            for (Map.Entry<String, JsonData> item0 : this.metadata.entrySet()) {
                generator.writeKey(item0.getKey());
                item0.getValue().serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (ApiTypeHelper.isDefined(this.namespace)) {
            generator.writeKey("namespace");
            generator.writeStartObject();
            for (Map.Entry<String, JsonData> item0 : this.namespace.entrySet()) {
                generator.writeKey(item0.getKey());
                item0.getValue().serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (this.payloadType != null) {
            generator.writeKey("payload_type");
            generator.write(this.payloadType);
        }

        if (ApiTypeHelper.isDefined(this.structuredData)) {
            generator.writeKey("structured_data");
            generator.writeStartObject();
            for (Map.Entry<String, JsonData> item0 : this.structuredData.entrySet()) {
                generator.writeKey(item0.getKey());
                item0.getValue().serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (ApiTypeHelper.isDefined(this.tags)) {
            generator.writeKey("tags");
            generator.writeStartObject();
            for (Map.Entry<String, JsonData> item0 : this.tags.entrySet()) {
                generator.writeKey(item0.getKey());
                item0.getValue().serialize(generator, mapper);
            }
            generator.writeEnd();
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
     * Builder for {@link AddAgenticMemoryRequest}.
     */
    public static class Builder extends RequestBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, AddAgenticMemoryRequest> {
        @Nullable
        private String binaryData;
        @Nullable
        private Boolean infer;
        private String memoryContainerId;
        @Nullable
        private List<Message> messages;
        @Nullable
        private Map<String, JsonData> metadata;
        @Nullable
        private Map<String, JsonData> namespace;
        @Nullable
        private String payloadType;
        @Nullable
        private Map<String, JsonData> structuredData;
        @Nullable
        private Map<String, JsonData> tags;

        public Builder() {}

        private Builder(AddAgenticMemoryRequest o) {
            super(o);
            this.binaryData = o.binaryData;
            this.infer = o.infer;
            this.memoryContainerId = o.memoryContainerId;
            this.messages = _listCopy(o.messages);
            this.metadata = _mapCopy(o.metadata);
            this.namespace = _mapCopy(o.namespace);
            this.payloadType = o.payloadType;
            this.structuredData = _mapCopy(o.structuredData);
            this.tags = _mapCopy(o.tags);
        }

        private Builder(Builder o) {
            super(o);
            this.binaryData = o.binaryData;
            this.infer = o.infer;
            this.memoryContainerId = o.memoryContainerId;
            this.messages = _listCopy(o.messages);
            this.metadata = _mapCopy(o.metadata);
            this.namespace = _mapCopy(o.namespace);
            this.payloadType = o.payloadType;
            this.structuredData = _mapCopy(o.structuredData);
            this.tags = _mapCopy(o.tags);
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
         * Binary data content encoded as Base64 string.
         * <p>
         * API name: {@code binary_data}
         * </p>
         */
        @Nonnull
        public final Builder binaryData(@Nullable String value) {
            this.binaryData = value;
            return this;
        }

        /**
         * Whether to use LLM to extract key information.
         * <p>
         * API name: {@code infer}
         * </p>
         */
        @Nonnull
        public final Builder infer(@Nullable Boolean value) {
            this.infer = value;
            return this;
        }

        /**
         * Required - API name: {@code memory_container_id}
         */
        @Nonnull
        public final Builder memoryContainerId(String value) {
            this.memoryContainerId = value;
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
        public final Builder messages(List<Message> list) {
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
        public final Builder messages(Message value, Message... values) {
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
        public final Builder messages(Function<Message.Builder, ObjectBuilder<Message>> fn) {
            return messages(fn.apply(new Message.Builder()).build());
        }

        /**
         * API name: {@code metadata}
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
         * API name: {@code metadata}
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
         * API name: {@code namespace}
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>namespace</code>.
         * </p>
         */
        @Nonnull
        public final Builder namespace(Map<String, JsonData> map) {
            this.namespace = _mapPutAll(this.namespace, map);
            return this;
        }

        /**
         * API name: {@code namespace}
         *
         * <p>
         * Adds an entry to <code>namespace</code>.
         * </p>
         */
        @Nonnull
        public final Builder namespace(String key, JsonData value) {
            this.namespace = _mapPut(this.namespace, key, value);
            return this;
        }

        /**
         * The type of payload.
         * <p>
         * API name: {@code payload_type}
         * </p>
         */
        @Nonnull
        public final Builder payloadType(@Nullable String value) {
            this.payloadType = value;
            return this;
        }

        /**
         * API name: {@code structured_data}
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>structuredData</code>.
         * </p>
         */
        @Nonnull
        public final Builder structuredData(Map<String, JsonData> map) {
            this.structuredData = _mapPutAll(this.structuredData, map);
            return this;
        }

        /**
         * API name: {@code structured_data}
         *
         * <p>
         * Adds an entry to <code>structuredData</code>.
         * </p>
         */
        @Nonnull
        public final Builder structuredData(String key, JsonData value) {
            this.structuredData = _mapPut(this.structuredData, key, value);
            return this;
        }

        /**
         * API name: {@code tags}
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>tags</code>.
         * </p>
         */
        @Nonnull
        public final Builder tags(Map<String, JsonData> map) {
            this.tags = _mapPutAll(this.tags, map);
            return this;
        }

        /**
         * API name: {@code tags}
         *
         * <p>
         * Adds an entry to <code>tags</code>.
         * </p>
         */
        @Nonnull
        public final Builder tags(String key, JsonData value) {
            this.tags = _mapPut(this.tags, key, value);
            return this;
        }

        /**
         * Builds a {@link AddAgenticMemoryRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public AddAgenticMemoryRequest build() {
            _checkSingleUse();

            return new AddAgenticMemoryRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link AddAgenticMemoryRequest}
     */
    public static final JsonpDeserializer<AddAgenticMemoryRequest> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        AddAgenticMemoryRequest::setupAddAgenticMemoryRequestDeserializer
    );

    protected static void setupAddAgenticMemoryRequestDeserializer(ObjectDeserializer<AddAgenticMemoryRequest.Builder> op) {
        op.add(Builder::binaryData, JsonpDeserializer.stringDeserializer(), "binary_data");
        op.add(Builder::infer, JsonpDeserializer.booleanDeserializer(), "infer");
        op.add(Builder::messages, JsonpDeserializer.arrayDeserializer(Message._DESERIALIZER), "messages");
        op.add(Builder::metadata, JsonpDeserializer.stringMapDeserializer(JsonData._DESERIALIZER), "metadata");
        op.add(Builder::namespace, JsonpDeserializer.stringMapDeserializer(JsonData._DESERIALIZER), "namespace");
        op.add(Builder::payloadType, JsonpDeserializer.stringDeserializer(), "payload_type");
        op.add(Builder::structuredData, JsonpDeserializer.stringMapDeserializer(JsonData._DESERIALIZER), "structured_data");
        op.add(Builder::tags, JsonpDeserializer.stringMapDeserializer(JsonData._DESERIALIZER), "tags");
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Endpoint "{@code ml.add_agentic_memory}".
     */
    public static final Endpoint<AddAgenticMemoryRequest, AddAgenticMemoryResponse, ErrorResponse> _ENDPOINT = new SimpleEndpoint<>(
        // Request method
        request -> "POST",
        // Request path
        request -> {
            StringBuilder buf = new StringBuilder();
            buf.append("/_plugins/_ml/memory_containers/");
            SimpleEndpoint.pathEncode(request.memoryContainerId, buf);
            buf.append("/memories");
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
        AddAgenticMemoryResponse._DESERIALIZER
    );

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.binaryData);
        result = 31 * result + Objects.hashCode(this.infer);
        result = 31 * result + this.memoryContainerId.hashCode();
        result = 31 * result + Objects.hashCode(this.messages);
        result = 31 * result + Objects.hashCode(this.metadata);
        result = 31 * result + Objects.hashCode(this.namespace);
        result = 31 * result + Objects.hashCode(this.payloadType);
        result = 31 * result + Objects.hashCode(this.structuredData);
        result = 31 * result + Objects.hashCode(this.tags);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        AddAgenticMemoryRequest other = (AddAgenticMemoryRequest) o;
        return Objects.equals(this.binaryData, other.binaryData)
            && Objects.equals(this.infer, other.infer)
            && this.memoryContainerId.equals(other.memoryContainerId)
            && Objects.equals(this.messages, other.messages)
            && Objects.equals(this.metadata, other.metadata)
            && Objects.equals(this.namespace, other.namespace)
            && Objects.equals(this.payloadType, other.payloadType)
            && Objects.equals(this.structuredData, other.structuredData)
            && Objects.equals(this.tags, other.tags);
    }
}
