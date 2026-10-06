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

// typedef: ml.get_agentic_memory.Response

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class GetAgenticMemoryResponse
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<GetAgenticMemoryResponse.Builder, GetAgenticMemoryResponse> {

    @Nullable
    private final ActionType action;

    @Nonnull
    private final Map<String, JsonData> after;

    @Nonnull
    private final Map<String, JsonData> before;

    @Nullable
    private final Long createdTime;

    @Nullable
    private final Boolean infer;

    @Nullable
    private final Long lastUpdatedTime;

    @Nullable
    private final String memory;

    @Nullable
    private final String memoryContainerId;

    @Nonnull
    private final List<Double> memoryEmbedding;

    @Nullable
    private final String memoryId;

    @Nonnull
    private final List<Message> messages;

    @Nonnull
    private final Map<String, JsonData> metadata;

    @Nonnull
    private final Map<String, JsonData> namespace;

    @Nullable
    private final Long namespaceSize;

    @Nullable
    private final String ownerId;

    @Nullable
    private final PayloadType payloadType;

    @Nullable
    private final String strategyId;

    @Nullable
    private final StrategyType strategyType;

    @Nonnull
    private final Map<String, JsonData> tags;

    // ---------------------------------------------------------------------------------------------

    private GetAgenticMemoryResponse(Builder builder) {
        this.action = builder.action;
        this.after = ApiTypeHelper.unmodifiable(builder.after);
        this.before = ApiTypeHelper.unmodifiable(builder.before);
        this.createdTime = builder.createdTime;
        this.infer = builder.infer;
        this.lastUpdatedTime = builder.lastUpdatedTime;
        this.memory = builder.memory;
        this.memoryContainerId = builder.memoryContainerId;
        this.memoryEmbedding = ApiTypeHelper.unmodifiable(builder.memoryEmbedding);
        this.memoryId = builder.memoryId;
        this.messages = ApiTypeHelper.unmodifiable(builder.messages);
        this.metadata = ApiTypeHelper.unmodifiable(builder.metadata);
        this.namespace = ApiTypeHelper.unmodifiable(builder.namespace);
        this.namespaceSize = builder.namespaceSize;
        this.ownerId = builder.ownerId;
        this.payloadType = builder.payloadType;
        this.strategyId = builder.strategyId;
        this.strategyType = builder.strategyType;
        this.tags = ApiTypeHelper.unmodifiable(builder.tags);
    }

    public static GetAgenticMemoryResponse of(Function<GetAgenticMemoryResponse.Builder, ObjectBuilder<GetAgenticMemoryResponse>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code action}
     */
    @Nullable
    public final ActionType action() {
        return this.action;
    }

    /**
     * API name: {@code after}
     */
    @Nonnull
    public final Map<String, JsonData> after() {
        return this.after;
    }

    /**
     * API name: {@code before}
     */
    @Nonnull
    public final Map<String, JsonData> before() {
        return this.before;
    }

    /**
     * The created time.
     * <p>
     * API name: {@code created_time}
     * </p>
     */
    @Nullable
    public final Long createdTime() {
        return this.createdTime;
    }

    /**
     * Whether inference was enabled.
     * <p>
     * API name: {@code infer}
     * </p>
     */
    @Nullable
    public final Boolean infer() {
        return this.infer;
    }

    /**
     * The last updated time.
     * <p>
     * API name: {@code last_updated_time}
     * </p>
     */
    @Nullable
    public final Long lastUpdatedTime() {
        return this.lastUpdatedTime;
    }

    /**
     * The extracted long-term memory fact.
     * <p>
     * API name: {@code memory}
     * </p>
     */
    @Nullable
    public final String memory() {
        return this.memory;
    }

    /**
     * The ID of the memory container.
     * <p>
     * API name: {@code memory_container_id}
     * </p>
     */
    @Nullable
    public final String memoryContainerId() {
        return this.memoryContainerId;
    }

    /**
     * API name: {@code memory_embedding}
     */
    @Nonnull
    public final List<Double> memoryEmbedding() {
        return this.memoryEmbedding;
    }

    /**
     * The ID of the memory.
     * <p>
     * API name: {@code memory_id}
     * </p>
     */
    @Nullable
    public final String memoryId() {
        return this.memoryId;
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
     * The number of namespaces.
     * <p>
     * API name: {@code namespace_size}
     * </p>
     */
    @Nullable
    public final Long namespaceSize() {
        return this.namespaceSize;
    }

    /**
     * The ID of the memory owner.
     * <p>
     * API name: {@code owner_id}
     * </p>
     */
    @Nullable
    public final String ownerId() {
        return this.ownerId;
    }

    /**
     * API name: {@code payload_type}
     */
    @Nullable
    public final PayloadType payloadType() {
        return this.payloadType;
    }

    /**
     * The ID for the strategy instance.
     * <p>
     * API name: {@code strategy_id}
     * </p>
     */
    @Nullable
    public final String strategyId() {
        return this.strategyId;
    }

    /**
     * API name: {@code strategy_type}
     */
    @Nullable
    public final StrategyType strategyType() {
        return this.strategyType;
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
        if (this.action != null) {
            generator.writeKey("action");
            this.action.serialize(generator, mapper);
        }

        if (ApiTypeHelper.isDefined(this.after)) {
            generator.writeKey("after");
            generator.writeStartObject();
            for (Map.Entry<String, JsonData> item0 : this.after.entrySet()) {
                generator.writeKey(item0.getKey());
                item0.getValue().serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (ApiTypeHelper.isDefined(this.before)) {
            generator.writeKey("before");
            generator.writeStartObject();
            for (Map.Entry<String, JsonData> item0 : this.before.entrySet()) {
                generator.writeKey(item0.getKey());
                item0.getValue().serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (this.createdTime != null) {
            generator.writeKey("created_time");
            generator.write(this.createdTime);
        }

        if (this.infer != null) {
            generator.writeKey("infer");
            generator.write(this.infer);
        }

        if (this.lastUpdatedTime != null) {
            generator.writeKey("last_updated_time");
            generator.write(this.lastUpdatedTime);
        }

        if (this.memory != null) {
            generator.writeKey("memory");
            generator.write(this.memory);
        }

        if (this.memoryContainerId != null) {
            generator.writeKey("memory_container_id");
            generator.write(this.memoryContainerId);
        }

        if (ApiTypeHelper.isDefined(this.memoryEmbedding)) {
            generator.writeKey("memory_embedding");
            generator.writeStartArray();
            for (Double item0 : this.memoryEmbedding) {
                generator.write(item0);
            }
            generator.writeEnd();
        }

        if (this.memoryId != null) {
            generator.writeKey("memory_id");
            generator.write(this.memoryId);
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

        if (this.namespaceSize != null) {
            generator.writeKey("namespace_size");
            generator.write(this.namespaceSize);
        }

        if (this.ownerId != null) {
            generator.writeKey("owner_id");
            generator.write(this.ownerId);
        }

        if (this.payloadType != null) {
            generator.writeKey("payload_type");
            this.payloadType.serialize(generator, mapper);
        }

        if (this.strategyId != null) {
            generator.writeKey("strategy_id");
            generator.write(this.strategyId);
        }

        if (this.strategyType != null) {
            generator.writeKey("strategy_type");
            this.strategyType.serialize(generator, mapper);
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
     * Builder for {@link GetAgenticMemoryResponse}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, GetAgenticMemoryResponse> {
        @Nullable
        private ActionType action;
        @Nullable
        private Map<String, JsonData> after;
        @Nullable
        private Map<String, JsonData> before;
        @Nullable
        private Long createdTime;
        @Nullable
        private Boolean infer;
        @Nullable
        private Long lastUpdatedTime;
        @Nullable
        private String memory;
        @Nullable
        private String memoryContainerId;
        @Nullable
        private List<Double> memoryEmbedding;
        @Nullable
        private String memoryId;
        @Nullable
        private List<Message> messages;
        @Nullable
        private Map<String, JsonData> metadata;
        @Nullable
        private Map<String, JsonData> namespace;
        @Nullable
        private Long namespaceSize;
        @Nullable
        private String ownerId;
        @Nullable
        private PayloadType payloadType;
        @Nullable
        private String strategyId;
        @Nullable
        private StrategyType strategyType;
        @Nullable
        private Map<String, JsonData> tags;

        public Builder() {}

        private Builder(GetAgenticMemoryResponse o) {
            this.action = o.action;
            this.after = _mapCopy(o.after);
            this.before = _mapCopy(o.before);
            this.createdTime = o.createdTime;
            this.infer = o.infer;
            this.lastUpdatedTime = o.lastUpdatedTime;
            this.memory = o.memory;
            this.memoryContainerId = o.memoryContainerId;
            this.memoryEmbedding = _listCopy(o.memoryEmbedding);
            this.memoryId = o.memoryId;
            this.messages = _listCopy(o.messages);
            this.metadata = _mapCopy(o.metadata);
            this.namespace = _mapCopy(o.namespace);
            this.namespaceSize = o.namespaceSize;
            this.ownerId = o.ownerId;
            this.payloadType = o.payloadType;
            this.strategyId = o.strategyId;
            this.strategyType = o.strategyType;
            this.tags = _mapCopy(o.tags);
        }

        private Builder(Builder o) {
            this.action = o.action;
            this.after = _mapCopy(o.after);
            this.before = _mapCopy(o.before);
            this.createdTime = o.createdTime;
            this.infer = o.infer;
            this.lastUpdatedTime = o.lastUpdatedTime;
            this.memory = o.memory;
            this.memoryContainerId = o.memoryContainerId;
            this.memoryEmbedding = _listCopy(o.memoryEmbedding);
            this.memoryId = o.memoryId;
            this.messages = _listCopy(o.messages);
            this.metadata = _mapCopy(o.metadata);
            this.namespace = _mapCopy(o.namespace);
            this.namespaceSize = o.namespaceSize;
            this.ownerId = o.ownerId;
            this.payloadType = o.payloadType;
            this.strategyId = o.strategyId;
            this.strategyType = o.strategyType;
            this.tags = _mapCopy(o.tags);
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code action}
         */
        @Nonnull
        public final Builder action(@Nullable ActionType value) {
            this.action = value;
            return this;
        }

        /**
         * API name: {@code after}
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>after</code>.
         * </p>
         */
        @Nonnull
        public final Builder after(Map<String, JsonData> map) {
            this.after = _mapPutAll(this.after, map);
            return this;
        }

        /**
         * API name: {@code after}
         *
         * <p>
         * Adds an entry to <code>after</code>.
         * </p>
         */
        @Nonnull
        public final Builder after(String key, JsonData value) {
            this.after = _mapPut(this.after, key, value);
            return this;
        }

        /**
         * API name: {@code before}
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>before</code>.
         * </p>
         */
        @Nonnull
        public final Builder before(Map<String, JsonData> map) {
            this.before = _mapPutAll(this.before, map);
            return this;
        }

        /**
         * API name: {@code before}
         *
         * <p>
         * Adds an entry to <code>before</code>.
         * </p>
         */
        @Nonnull
        public final Builder before(String key, JsonData value) {
            this.before = _mapPut(this.before, key, value);
            return this;
        }

        /**
         * The created time.
         * <p>
         * API name: {@code created_time}
         * </p>
         */
        @Nonnull
        public final Builder createdTime(@Nullable Long value) {
            this.createdTime = value;
            return this;
        }

        /**
         * Whether inference was enabled.
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
         * The last updated time.
         * <p>
         * API name: {@code last_updated_time}
         * </p>
         */
        @Nonnull
        public final Builder lastUpdatedTime(@Nullable Long value) {
            this.lastUpdatedTime = value;
            return this;
        }

        /**
         * The extracted long-term memory fact.
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
         * The ID of the memory container.
         * <p>
         * API name: {@code memory_container_id}
         * </p>
         */
        @Nonnull
        public final Builder memoryContainerId(@Nullable String value) {
            this.memoryContainerId = value;
            return this;
        }

        /**
         * API name: {@code memory_embedding}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>memoryEmbedding</code>.
         * </p>
         */
        @Nonnull
        public final Builder memoryEmbedding(List<Double> list) {
            this.memoryEmbedding = _listAddAll(this.memoryEmbedding, list);
            return this;
        }

        /**
         * API name: {@code memory_embedding}
         *
         * <p>
         * Adds one or more values to <code>memoryEmbedding</code>.
         * </p>
         */
        @Nonnull
        public final Builder memoryEmbedding(Double value, Double... values) {
            this.memoryEmbedding = _listAdd(this.memoryEmbedding, value, values);
            return this;
        }

        /**
         * The ID of the memory.
         * <p>
         * API name: {@code memory_id}
         * </p>
         */
        @Nonnull
        public final Builder memoryId(@Nullable String value) {
            this.memoryId = value;
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
         * The number of namespaces.
         * <p>
         * API name: {@code namespace_size}
         * </p>
         */
        @Nonnull
        public final Builder namespaceSize(@Nullable Long value) {
            this.namespaceSize = value;
            return this;
        }

        /**
         * The ID of the memory owner.
         * <p>
         * API name: {@code owner_id}
         * </p>
         */
        @Nonnull
        public final Builder ownerId(@Nullable String value) {
            this.ownerId = value;
            return this;
        }

        /**
         * API name: {@code payload_type}
         */
        @Nonnull
        public final Builder payloadType(@Nullable PayloadType value) {
            this.payloadType = value;
            return this;
        }

        /**
         * The ID for the strategy instance.
         * <p>
         * API name: {@code strategy_id}
         * </p>
         */
        @Nonnull
        public final Builder strategyId(@Nullable String value) {
            this.strategyId = value;
            return this;
        }

        /**
         * API name: {@code strategy_type}
         */
        @Nonnull
        public final Builder strategyType(@Nullable StrategyType value) {
            this.strategyType = value;
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
         * Builds a {@link GetAgenticMemoryResponse}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public GetAgenticMemoryResponse build() {
            _checkSingleUse();

            return new GetAgenticMemoryResponse(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link GetAgenticMemoryResponse}
     */
    public static final JsonpDeserializer<GetAgenticMemoryResponse> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        GetAgenticMemoryResponse::setupGetAgenticMemoryResponseDeserializer
    );

    protected static void setupGetAgenticMemoryResponseDeserializer(ObjectDeserializer<GetAgenticMemoryResponse.Builder> op) {
        op.add(Builder::action, ActionType._DESERIALIZER, "action");
        op.add(Builder::after, JsonpDeserializer.stringMapDeserializer(JsonData._DESERIALIZER), "after");
        op.add(Builder::before, JsonpDeserializer.stringMapDeserializer(JsonData._DESERIALIZER), "before");
        op.add(Builder::createdTime, JsonpDeserializer.longDeserializer(), "created_time");
        op.add(Builder::infer, JsonpDeserializer.booleanDeserializer(), "infer");
        op.add(Builder::lastUpdatedTime, JsonpDeserializer.longDeserializer(), "last_updated_time");
        op.add(Builder::memory, JsonpDeserializer.stringDeserializer(), "memory");
        op.add(Builder::memoryContainerId, JsonpDeserializer.stringDeserializer(), "memory_container_id");
        op.add(Builder::memoryEmbedding, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.doubleDeserializer()), "memory_embedding");
        op.add(Builder::memoryId, JsonpDeserializer.stringDeserializer(), "memory_id");
        op.add(Builder::messages, JsonpDeserializer.arrayDeserializer(Message._DESERIALIZER), "messages");
        op.add(Builder::metadata, JsonpDeserializer.stringMapDeserializer(JsonData._DESERIALIZER), "metadata");
        op.add(Builder::namespace, JsonpDeserializer.stringMapDeserializer(JsonData._DESERIALIZER), "namespace");
        op.add(Builder::namespaceSize, JsonpDeserializer.longDeserializer(), "namespace_size");
        op.add(Builder::ownerId, JsonpDeserializer.stringDeserializer(), "owner_id");
        op.add(Builder::payloadType, PayloadType._DESERIALIZER, "payload_type");
        op.add(Builder::strategyId, JsonpDeserializer.stringDeserializer(), "strategy_id");
        op.add(Builder::strategyType, StrategyType._DESERIALIZER, "strategy_type");
        op.add(Builder::tags, JsonpDeserializer.stringMapDeserializer(JsonData._DESERIALIZER), "tags");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.action);
        result = 31 * result + Objects.hashCode(this.after);
        result = 31 * result + Objects.hashCode(this.before);
        result = 31 * result + Objects.hashCode(this.createdTime);
        result = 31 * result + Objects.hashCode(this.infer);
        result = 31 * result + Objects.hashCode(this.lastUpdatedTime);
        result = 31 * result + Objects.hashCode(this.memory);
        result = 31 * result + Objects.hashCode(this.memoryContainerId);
        result = 31 * result + Objects.hashCode(this.memoryEmbedding);
        result = 31 * result + Objects.hashCode(this.memoryId);
        result = 31 * result + Objects.hashCode(this.messages);
        result = 31 * result + Objects.hashCode(this.metadata);
        result = 31 * result + Objects.hashCode(this.namespace);
        result = 31 * result + Objects.hashCode(this.namespaceSize);
        result = 31 * result + Objects.hashCode(this.ownerId);
        result = 31 * result + Objects.hashCode(this.payloadType);
        result = 31 * result + Objects.hashCode(this.strategyId);
        result = 31 * result + Objects.hashCode(this.strategyType);
        result = 31 * result + Objects.hashCode(this.tags);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        GetAgenticMemoryResponse other = (GetAgenticMemoryResponse) o;
        return Objects.equals(this.action, other.action)
            && Objects.equals(this.after, other.after)
            && Objects.equals(this.before, other.before)
            && Objects.equals(this.createdTime, other.createdTime)
            && Objects.equals(this.infer, other.infer)
            && Objects.equals(this.lastUpdatedTime, other.lastUpdatedTime)
            && Objects.equals(this.memory, other.memory)
            && Objects.equals(this.memoryContainerId, other.memoryContainerId)
            && Objects.equals(this.memoryEmbedding, other.memoryEmbedding)
            && Objects.equals(this.memoryId, other.memoryId)
            && Objects.equals(this.messages, other.messages)
            && Objects.equals(this.metadata, other.metadata)
            && Objects.equals(this.namespace, other.namespace)
            && Objects.equals(this.namespaceSize, other.namespaceSize)
            && Objects.equals(this.ownerId, other.ownerId)
            && Objects.equals(this.payloadType, other.payloadType)
            && Objects.equals(this.strategyId, other.strategyId)
            && Objects.equals(this.strategyType, other.strategyType)
            && Objects.equals(this.tags, other.tags);
    }
}
