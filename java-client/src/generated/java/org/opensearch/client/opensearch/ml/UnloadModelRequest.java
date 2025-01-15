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

// typedef: ml.unload_model.Request

/**
 * Unloads a model.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public final class UnloadModelRequest extends RequestBase
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<UnloadModelRequest.Builder, UnloadModelRequest> {

    @Nullable
    private final String modelId;

    @Nonnull
    private final List<String> modelIds;

    @Nonnull
    private final List<String> nodeIds;

    // ---------------------------------------------------------------------------------------------

    private UnloadModelRequest(Builder builder) {
        super(builder);
        this.modelId = builder.modelId;
        this.modelIds = ApiTypeHelper.unmodifiable(builder.modelIds);
        this.nodeIds = ApiTypeHelper.unmodifiable(builder.nodeIds);
    }

    public static UnloadModelRequest of(Function<UnloadModelRequest.Builder, ObjectBuilder<UnloadModelRequest>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code model_id}
     */
    @Nullable
    public final String modelId() {
        return this.modelId;
    }

    /**
     * API name: {@code model_ids}
     */
    @Nonnull
    public final List<String> modelIds() {
        return this.modelIds;
    }

    /**
     * API name: {@code node_ids}
     */
    @Nonnull
    public final List<String> nodeIds() {
        return this.nodeIds;
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
        if (ApiTypeHelper.isDefined(this.modelIds)) {
            generator.writeKey("model_ids");
            generator.writeStartArray();
            for (String item0 : this.modelIds) {
                generator.write(item0);
            }
            generator.writeEnd();
        }

        if (ApiTypeHelper.isDefined(this.nodeIds)) {
            generator.writeKey("node_ids");
            generator.writeStartArray();
            for (String item0 : this.nodeIds) {
                generator.write(item0);
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
     * Builder for {@link UnloadModelRequest}.
     */
    public static class Builder extends RequestBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, UnloadModelRequest> {
        @Nullable
        private String modelId;
        @Nullable
        private List<String> modelIds;
        @Nullable
        private List<String> nodeIds;

        public Builder() {}

        private Builder(UnloadModelRequest o) {
            super(o);
            this.modelId = o.modelId;
            this.modelIds = _listCopy(o.modelIds);
            this.nodeIds = _listCopy(o.nodeIds);
        }

        private Builder(Builder o) {
            super(o);
            this.modelId = o.modelId;
            this.modelIds = _listCopy(o.modelIds);
            this.nodeIds = _listCopy(o.nodeIds);
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
         * API name: {@code model_id}
         */
        @Nonnull
        public final Builder modelId(@Nullable String value) {
            this.modelId = value;
            return this;
        }

        /**
         * API name: {@code model_ids}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>modelIds</code>.
         * </p>
         */
        @Nonnull
        public final Builder modelIds(List<String> list) {
            this.modelIds = _listAddAll(this.modelIds, list);
            return this;
        }

        /**
         * API name: {@code model_ids}
         *
         * <p>
         * Adds one or more values to <code>modelIds</code>.
         * </p>
         */
        @Nonnull
        public final Builder modelIds(String value, String... values) {
            this.modelIds = _listAdd(this.modelIds, value, values);
            return this;
        }

        /**
         * API name: {@code node_ids}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>nodeIds</code>.
         * </p>
         */
        @Nonnull
        public final Builder nodeIds(List<String> list) {
            this.nodeIds = _listAddAll(this.nodeIds, list);
            return this;
        }

        /**
         * API name: {@code node_ids}
         *
         * <p>
         * Adds one or more values to <code>nodeIds</code>.
         * </p>
         */
        @Nonnull
        public final Builder nodeIds(String value, String... values) {
            this.nodeIds = _listAdd(this.nodeIds, value, values);
            return this;
        }

        /**
         * Builds a {@link UnloadModelRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public UnloadModelRequest build() {
            _checkSingleUse();

            return new UnloadModelRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link UnloadModelRequest}
     */
    public static final JsonpDeserializer<UnloadModelRequest> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        UnloadModelRequest::setupUnloadModelRequestDeserializer
    );

    protected static void setupUnloadModelRequestDeserializer(ObjectDeserializer<UnloadModelRequest.Builder> op) {
        op.add(Builder::modelIds, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "model_ids");
        op.add(Builder::nodeIds, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "node_ids");
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Endpoint "{@code ml.unload_model}".
     */
    public static final Endpoint<UnloadModelRequest, UnloadModelResponse, ErrorResponse> _ENDPOINT = new SimpleEndpoint<>(
        // Request method
        request -> "POST",
        // Request path
        request -> {
            final int _modelId = 1 << 0;

            int propsSet = 0;

            if (request.modelId() != null) propsSet |= _modelId;

            if (propsSet == 0) {
                return "/_plugins/_ml/models/_unload";
            }
            if (propsSet == (_modelId)) {
                StringBuilder buf = new StringBuilder();
                buf.append("/_plugins/_ml/models/");
                SimpleEndpoint.pathEncode(request.modelId, buf);
                buf.append("/_unload");
                return buf.toString();
            }

            throw SimpleEndpoint.noPathTemplateFound("path");
        },
        // Request parameters
        request -> {
            Map<String, String> params = new HashMap<>();
            request.applyQueryParameters(params);
            return params;
        },
        SimpleEndpoint.emptyMap(),
        true,
        UnloadModelResponse._DESERIALIZER
    );

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.modelId);
        result = 31 * result + Objects.hashCode(this.modelIds);
        result = 31 * result + Objects.hashCode(this.nodeIds);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        UnloadModelRequest other = (UnloadModelRequest) o;
        return Objects.equals(this.modelId, other.modelId)
            && Objects.equals(this.modelIds, other.modelIds)
            && Objects.equals(this.nodeIds, other.nodeIds);
    }
}
