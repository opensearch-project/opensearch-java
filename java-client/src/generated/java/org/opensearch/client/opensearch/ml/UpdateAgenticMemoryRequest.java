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

// typedef: ml.update_agentic_memory.Request

/**
 * Update a specific memory by its type and ID.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public final class UpdateAgenticMemoryRequest extends RequestBase
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<UpdateAgenticMemoryRequest.Builder, UpdateAgenticMemoryRequest> {

    @Nonnull
    private final Map<String, JsonData> additionalInfo;

    @Nonnull
    private final Map<String, JsonData> agents;

    @Nonnull
    private final Map<String, JsonData> binaryData;

    @Nonnull
    private final String id;

    @Nullable
    private final String memory;

    @Nonnull
    private final String memoryContainerId;

    @Nonnull
    private final List<Message> messages;

    @Nonnull
    private final Map<String, JsonData> metadata;

    @Nonnull
    private final Map<String, JsonData> structuredData;

    @Nullable
    private final String summary;

    @Nonnull
    private final Map<String, JsonData> tags;

    @Nonnull
    private final MemoryType type;

    // ---------------------------------------------------------------------------------------------

    private UpdateAgenticMemoryRequest(Builder builder) {
        super(builder);
        this.additionalInfo = ApiTypeHelper.unmodifiable(builder.additionalInfo);
        this.agents = ApiTypeHelper.unmodifiable(builder.agents);
        this.binaryData = ApiTypeHelper.unmodifiable(builder.binaryData);
        this.id = ApiTypeHelper.requireNonNull(builder.id, this, "id");
        this.memory = builder.memory;
        this.memoryContainerId = ApiTypeHelper.requireNonNull(builder.memoryContainerId, this, "memoryContainerId");
        this.messages = ApiTypeHelper.unmodifiable(builder.messages);
        this.metadata = ApiTypeHelper.unmodifiable(builder.metadata);
        this.structuredData = ApiTypeHelper.unmodifiable(builder.structuredData);
        this.summary = builder.summary;
        this.tags = ApiTypeHelper.unmodifiable(builder.tags);
        this.type = ApiTypeHelper.requireNonNull(builder.type, this, "type");
    }

    public static UpdateAgenticMemoryRequest of(
        Function<UpdateAgenticMemoryRequest.Builder, ObjectBuilder<UpdateAgenticMemoryRequest>> fn
    ) {
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
     * API name: {@code agents}
     */
    @Nonnull
    public final Map<String, JsonData> agents() {
        return this.agents;
    }

    /**
     * API name: {@code binary_data}
     */
    @Nonnull
    public final Map<String, JsonData> binaryData() {
        return this.binaryData;
    }

    /**
     * Required - API name: {@code id}
     */
    @Nonnull
    public final String id() {
        return this.id;
    }

    /**
     * The updated memory content.
     * <p>
     * API name: {@code memory}
     * </p>
     */
    @Nullable
    public final String memory() {
        return this.memory;
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
     * API name: {@code structured_data}
     */
    @Nonnull
    public final Map<String, JsonData> structuredData() {
        return this.structuredData;
    }

    /**
     * The summary of the session.
     * <p>
     * API name: {@code summary}
     * </p>
     */
    @Nullable
    public final String summary() {
        return this.summary;
    }

    /**
     * API name: {@code tags}
     */
    @Nonnull
    public final Map<String, JsonData> tags() {
        return this.tags;
    }

    /**
     * Required - API name: {@code type}
     */
    @Nonnull
    public final MemoryType type() {
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
        if (ApiTypeHelper.isDefined(this.additionalInfo)) {
            generator.writeKey("additional_info");
            generator.writeStartObject();
            for (Map.Entry<String, JsonData> item0 : this.additionalInfo.entrySet()) {
                generator.writeKey(item0.getKey());
                item0.getValue().serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (ApiTypeHelper.isDefined(this.agents)) {
            generator.writeKey("agents");
            generator.writeStartObject();
            for (Map.Entry<String, JsonData> item0 : this.agents.entrySet()) {
                generator.writeKey(item0.getKey());
                item0.getValue().serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (ApiTypeHelper.isDefined(this.binaryData)) {
            generator.writeKey("binary_data");
            generator.writeStartObject();
            for (Map.Entry<String, JsonData> item0 : this.binaryData.entrySet()) {
                generator.writeKey(item0.getKey());
                item0.getValue().serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (this.memory != null) {
            generator.writeKey("memory");
            generator.write(this.memory);
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

        if (ApiTypeHelper.isDefined(this.structuredData)) {
            generator.writeKey("structured_data");
            generator.writeStartObject();
            for (Map.Entry<String, JsonData> item0 : this.structuredData.entrySet()) {
                generator.writeKey(item0.getKey());
                item0.getValue().serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (this.summary != null) {
            generator.writeKey("summary");
            generator.write(this.summary);
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
     * Builder for {@link UpdateAgenticMemoryRequest}.
     */
    public static class Builder extends RequestBase.AbstractBuilder<Builder>
        implements
            CopyableBuilder<Builder, UpdateAgenticMemoryRequest> {
        @Nullable
        private Map<String, JsonData> additionalInfo;
        @Nullable
        private Map<String, JsonData> agents;
        @Nullable
        private Map<String, JsonData> binaryData;
        private String id;
        @Nullable
        private String memory;
        private String memoryContainerId;
        @Nullable
        private List<Message> messages;
        @Nullable
        private Map<String, JsonData> metadata;
        @Nullable
        private Map<String, JsonData> structuredData;
        @Nullable
        private String summary;
        @Nullable
        private Map<String, JsonData> tags;
        private MemoryType type;

        public Builder() {}

        private Builder(UpdateAgenticMemoryRequest o) {
            super(o);
            this.additionalInfo = _mapCopy(o.additionalInfo);
            this.agents = _mapCopy(o.agents);
            this.binaryData = _mapCopy(o.binaryData);
            this.id = o.id;
            this.memory = o.memory;
            this.memoryContainerId = o.memoryContainerId;
            this.messages = _listCopy(o.messages);
            this.metadata = _mapCopy(o.metadata);
            this.structuredData = _mapCopy(o.structuredData);
            this.summary = o.summary;
            this.tags = _mapCopy(o.tags);
            this.type = o.type;
        }

        private Builder(Builder o) {
            super(o);
            this.additionalInfo = _mapCopy(o.additionalInfo);
            this.agents = _mapCopy(o.agents);
            this.binaryData = _mapCopy(o.binaryData);
            this.id = o.id;
            this.memory = o.memory;
            this.memoryContainerId = o.memoryContainerId;
            this.messages = _listCopy(o.messages);
            this.metadata = _mapCopy(o.metadata);
            this.structuredData = _mapCopy(o.structuredData);
            this.summary = o.summary;
            this.tags = _mapCopy(o.tags);
            this.type = o.type;
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
         * API name: {@code agents}
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>agents</code>.
         * </p>
         */
        @Nonnull
        public final Builder agents(Map<String, JsonData> map) {
            this.agents = _mapPutAll(this.agents, map);
            return this;
        }

        /**
         * API name: {@code agents}
         *
         * <p>
         * Adds an entry to <code>agents</code>.
         * </p>
         */
        @Nonnull
        public final Builder agents(String key, JsonData value) {
            this.agents = _mapPut(this.agents, key, value);
            return this;
        }

        /**
         * API name: {@code binary_data}
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>binaryData</code>.
         * </p>
         */
        @Nonnull
        public final Builder binaryData(Map<String, JsonData> map) {
            this.binaryData = _mapPutAll(this.binaryData, map);
            return this;
        }

        /**
         * API name: {@code binary_data}
         *
         * <p>
         * Adds an entry to <code>binaryData</code>.
         * </p>
         */
        @Nonnull
        public final Builder binaryData(String key, JsonData value) {
            this.binaryData = _mapPut(this.binaryData, key, value);
            return this;
        }

        /**
         * Required - API name: {@code id}
         */
        @Nonnull
        public final Builder id(String value) {
            this.id = value;
            return this;
        }

        /**
         * The updated memory content.
         * <p>
         * API name: {@code memory}
         * </p>
         */
        @Nonnull
        public final Builder memory(@Nullable String value) {
            this.memory = value;
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
         * The summary of the session.
         * <p>
         * API name: {@code summary}
         * </p>
         */
        @Nonnull
        public final Builder summary(@Nullable String value) {
            this.summary = value;
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
         * Required - API name: {@code type}
         */
        @Nonnull
        public final Builder type(MemoryType value) {
            this.type = value;
            return this;
        }

        /**
         * Builds a {@link UpdateAgenticMemoryRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public UpdateAgenticMemoryRequest build() {
            _checkSingleUse();

            return new UpdateAgenticMemoryRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link UpdateAgenticMemoryRequest}
     */
    public static final JsonpDeserializer<UpdateAgenticMemoryRequest> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        UpdateAgenticMemoryRequest::setupUpdateAgenticMemoryRequestDeserializer
    );

    protected static void setupUpdateAgenticMemoryRequestDeserializer(ObjectDeserializer<UpdateAgenticMemoryRequest.Builder> op) {
        op.add(Builder::additionalInfo, JsonpDeserializer.stringMapDeserializer(JsonData._DESERIALIZER), "additional_info");
        op.add(Builder::agents, JsonpDeserializer.stringMapDeserializer(JsonData._DESERIALIZER), "agents");
        op.add(Builder::binaryData, JsonpDeserializer.stringMapDeserializer(JsonData._DESERIALIZER), "binary_data");
        op.add(Builder::memory, JsonpDeserializer.stringDeserializer(), "memory");
        op.add(Builder::messages, JsonpDeserializer.arrayDeserializer(Message._DESERIALIZER), "messages");
        op.add(Builder::metadata, JsonpDeserializer.stringMapDeserializer(JsonData._DESERIALIZER), "metadata");
        op.add(Builder::structuredData, JsonpDeserializer.stringMapDeserializer(JsonData._DESERIALIZER), "structured_data");
        op.add(Builder::summary, JsonpDeserializer.stringDeserializer(), "summary");
        op.add(Builder::tags, JsonpDeserializer.stringMapDeserializer(JsonData._DESERIALIZER), "tags");
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Endpoint "{@code ml.update_agentic_memory}".
     */
    public static final Endpoint<UpdateAgenticMemoryRequest, UpdateAgenticMemoryResponse, ErrorResponse> _ENDPOINT = new SimpleEndpoint<>(
        // Request method
        request -> "PUT",
        // Request path
        request -> {
            StringBuilder buf = new StringBuilder();
            buf.append("/_plugins/_ml/memory_containers/");
            SimpleEndpoint.pathEncode(request.memoryContainerId, buf);
            buf.append("/memories/");
            SimpleEndpoint.pathEncode(request.type.jsonValue(), buf);
            buf.append("/");
            SimpleEndpoint.pathEncode(request.id, buf);
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
        UpdateAgenticMemoryResponse._DESERIALIZER
    );

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.additionalInfo);
        result = 31 * result + Objects.hashCode(this.agents);
        result = 31 * result + Objects.hashCode(this.binaryData);
        result = 31 * result + this.id.hashCode();
        result = 31 * result + Objects.hashCode(this.memory);
        result = 31 * result + this.memoryContainerId.hashCode();
        result = 31 * result + Objects.hashCode(this.messages);
        result = 31 * result + Objects.hashCode(this.metadata);
        result = 31 * result + Objects.hashCode(this.structuredData);
        result = 31 * result + Objects.hashCode(this.summary);
        result = 31 * result + Objects.hashCode(this.tags);
        result = 31 * result + this.type.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        UpdateAgenticMemoryRequest other = (UpdateAgenticMemoryRequest) o;
        return Objects.equals(this.additionalInfo, other.additionalInfo)
            && Objects.equals(this.agents, other.agents)
            && Objects.equals(this.binaryData, other.binaryData)
            && this.id.equals(other.id)
            && Objects.equals(this.memory, other.memory)
            && this.memoryContainerId.equals(other.memoryContainerId)
            && Objects.equals(this.messages, other.messages)
            && Objects.equals(this.metadata, other.metadata)
            && Objects.equals(this.structuredData, other.structuredData)
            && Objects.equals(this.summary, other.summary)
            && Objects.equals(this.tags, other.tags)
            && this.type.equals(other.type);
    }
}
