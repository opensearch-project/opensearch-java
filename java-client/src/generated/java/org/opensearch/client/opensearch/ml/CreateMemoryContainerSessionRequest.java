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

// typedef: ml.create_memory_container_session.Request

/**
 * Create session in a memory container.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public final class CreateMemoryContainerSessionRequest extends RequestBase
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<CreateMemoryContainerSessionRequest.Builder, CreateMemoryContainerSessionRequest> {

    @Nonnull
    private final String memoryContainerId;

    @Nonnull
    private final Map<String, JsonData> metadata;

    @Nonnull
    private final Map<String, JsonData> namespace;

    @Nullable
    private final String sessionId;

    @Nullable
    private final String summary;

    // ---------------------------------------------------------------------------------------------

    private CreateMemoryContainerSessionRequest(Builder builder) {
        super(builder);
        this.memoryContainerId = ApiTypeHelper.requireNonNull(builder.memoryContainerId, this, "memoryContainerId");
        this.metadata = ApiTypeHelper.unmodifiable(builder.metadata);
        this.namespace = ApiTypeHelper.unmodifiable(builder.namespace);
        this.sessionId = builder.sessionId;
        this.summary = builder.summary;
    }

    public static CreateMemoryContainerSessionRequest of(
        Function<CreateMemoryContainerSessionRequest.Builder, ObjectBuilder<CreateMemoryContainerSessionRequest>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code memory_container_id}
     */
    @Nonnull
    public final String memoryContainerId() {
        return this.memoryContainerId;
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
     * Custom session ID.
     * <p>
     * API name: {@code session_id}
     * </p>
     */
    @Nullable
    public final String sessionId() {
        return this.sessionId;
    }

    /**
     * Session summary or description.
     * <p>
     * API name: {@code summary}
     * </p>
     */
    @Nullable
    public final String summary() {
        return this.summary;
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

        if (this.sessionId != null) {
            generator.writeKey("session_id");
            generator.write(this.sessionId);
        }

        if (this.summary != null) {
            generator.writeKey("summary");
            generator.write(this.summary);
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
     * Builder for {@link CreateMemoryContainerSessionRequest}.
     */
    public static class Builder extends RequestBase.AbstractBuilder<Builder>
        implements
            CopyableBuilder<Builder, CreateMemoryContainerSessionRequest> {
        private String memoryContainerId;
        @Nullable
        private Map<String, JsonData> metadata;
        @Nullable
        private Map<String, JsonData> namespace;
        @Nullable
        private String sessionId;
        @Nullable
        private String summary;

        public Builder() {}

        private Builder(CreateMemoryContainerSessionRequest o) {
            super(o);
            this.memoryContainerId = o.memoryContainerId;
            this.metadata = _mapCopy(o.metadata);
            this.namespace = _mapCopy(o.namespace);
            this.sessionId = o.sessionId;
            this.summary = o.summary;
        }

        private Builder(Builder o) {
            super(o);
            this.memoryContainerId = o.memoryContainerId;
            this.metadata = _mapCopy(o.metadata);
            this.namespace = _mapCopy(o.namespace);
            this.sessionId = o.sessionId;
            this.summary = o.summary;
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
         * Required - API name: {@code memory_container_id}
         */
        @Nonnull
        public final Builder memoryContainerId(String value) {
            this.memoryContainerId = value;
            return this;
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
         * Custom session ID.
         * <p>
         * API name: {@code session_id}
         * </p>
         */
        @Nonnull
        public final Builder sessionId(@Nullable String value) {
            this.sessionId = value;
            return this;
        }

        /**
         * Session summary or description.
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
         * Builds a {@link CreateMemoryContainerSessionRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public CreateMemoryContainerSessionRequest build() {
            _checkSingleUse();

            return new CreateMemoryContainerSessionRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link CreateMemoryContainerSessionRequest}
     */
    public static final JsonpDeserializer<CreateMemoryContainerSessionRequest> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        CreateMemoryContainerSessionRequest::setupCreateMemoryContainerSessionRequestDeserializer
    );

    protected static void setupCreateMemoryContainerSessionRequestDeserializer(
        ObjectDeserializer<CreateMemoryContainerSessionRequest.Builder> op
    ) {
        op.add(Builder::metadata, JsonpDeserializer.stringMapDeserializer(JsonData._DESERIALIZER), "metadata");
        op.add(Builder::namespace, JsonpDeserializer.stringMapDeserializer(JsonData._DESERIALIZER), "namespace");
        op.add(Builder::sessionId, JsonpDeserializer.stringDeserializer(), "session_id");
        op.add(Builder::summary, JsonpDeserializer.stringDeserializer(), "summary");
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Endpoint "{@code ml.create_memory_container_session}".
     */
    public static final Endpoint<CreateMemoryContainerSessionRequest, CreateMemoryContainerSessionResponse, ErrorResponse> _ENDPOINT =
        new SimpleEndpoint<>(
            // Request method
            request -> "POST",
            // Request path
            request -> {
                StringBuilder buf = new StringBuilder();
                buf.append("/_plugins/_ml/memory_containers/");
                SimpleEndpoint.pathEncode(request.memoryContainerId, buf);
                buf.append("/memories/sessions");
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
            CreateMemoryContainerSessionResponse._DESERIALIZER
        );

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.memoryContainerId.hashCode();
        result = 31 * result + Objects.hashCode(this.metadata);
        result = 31 * result + Objects.hashCode(this.namespace);
        result = 31 * result + Objects.hashCode(this.sessionId);
        result = 31 * result + Objects.hashCode(this.summary);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        CreateMemoryContainerSessionRequest other = (CreateMemoryContainerSessionRequest) o;
        return this.memoryContainerId.equals(other.memoryContainerId)
            && Objects.equals(this.metadata, other.metadata)
            && Objects.equals(this.namespace, other.namespace)
            && Objects.equals(this.sessionId, other.sessionId)
            && Objects.equals(this.summary, other.summary);
    }
}
