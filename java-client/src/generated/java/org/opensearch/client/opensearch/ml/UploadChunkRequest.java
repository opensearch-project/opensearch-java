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
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
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

// typedef: ml.upload_chunk.Request

/**
 * Uploads model chunk.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public final class UploadChunkRequest extends RequestBase
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<UploadChunkRequest.Builder, UploadChunkRequest> {

    @Nonnull
    private final String chunk;

    private final long chunkNumber;

    @Nonnull
    private final String modelId;

    // ---------------------------------------------------------------------------------------------

    private UploadChunkRequest(Builder builder) {
        super(builder);
        this.chunk = ApiTypeHelper.requireNonNull(builder.chunk, this, "chunk");
        this.chunkNumber = ApiTypeHelper.requireNonNull(builder.chunkNumber, this, "chunkNumber");
        this.modelId = ApiTypeHelper.requireNonNull(builder.modelId, this, "modelId");
    }

    public static UploadChunkRequest of(Function<UploadChunkRequest.Builder, ObjectBuilder<UploadChunkRequest>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - The model chunk.
     * <p>
     * API name: {@code chunk}
     * </p>
     */
    @Nonnull
    public final String chunk() {
        return this.chunk;
    }

    /**
     * Required - API name: {@code chunk_number}
     */
    public final long chunkNumber() {
        return this.chunkNumber;
    }

    /**
     * Required - API name: {@code model_id}
     */
    @Nonnull
    public final String modelId() {
        return this.modelId;
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
        generator.writeKey("chunk");
        generator.write(this.chunk);
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
     * Builder for {@link UploadChunkRequest}.
     */
    public static class Builder extends RequestBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, UploadChunkRequest> {
        private String chunk;
        private Long chunkNumber;
        private String modelId;

        public Builder() {}

        private Builder(UploadChunkRequest o) {
            super(o);
            this.chunk = o.chunk;
            this.chunkNumber = o.chunkNumber;
            this.modelId = o.modelId;
        }

        private Builder(Builder o) {
            super(o);
            this.chunk = o.chunk;
            this.chunkNumber = o.chunkNumber;
            this.modelId = o.modelId;
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
         * Required - The model chunk.
         * <p>
         * API name: {@code chunk}
         * </p>
         */
        @Nonnull
        public final Builder chunk(String value) {
            this.chunk = value;
            return this;
        }

        /**
         * Required - API name: {@code chunk_number}
         */
        @Nonnull
        public final Builder chunkNumber(long value) {
            this.chunkNumber = value;
            return this;
        }

        /**
         * Required - API name: {@code model_id}
         */
        @Nonnull
        public final Builder modelId(String value) {
            this.modelId = value;
            return this;
        }

        /**
         * Builds a {@link UploadChunkRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public UploadChunkRequest build() {
            _checkSingleUse();

            return new UploadChunkRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link UploadChunkRequest}
     */
    public static final JsonpDeserializer<UploadChunkRequest> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        UploadChunkRequest::setupUploadChunkRequestDeserializer
    );

    protected static void setupUploadChunkRequestDeserializer(ObjectDeserializer<UploadChunkRequest.Builder> op) {
        op.add(Builder::chunk, JsonpDeserializer.stringDeserializer(), "chunk");
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Endpoint "{@code ml.upload_chunk}".
     */
    public static final Endpoint<UploadChunkRequest, UploadChunkResponse, ErrorResponse> _ENDPOINT = new SimpleEndpoint<>(
        // Request method
        request -> "POST",
        // Request path
        request -> {
            StringBuilder buf = new StringBuilder();
            buf.append("/_plugins/_ml/models/");
            SimpleEndpoint.pathEncode(request.modelId, buf);
            buf.append("/upload_chunk/");
            SimpleEndpoint.pathEncode(String.valueOf(request.chunkNumber), buf);
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
        UploadChunkResponse._DESERIALIZER
    );

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.chunk.hashCode();
        result = 31 * result + Long.hashCode(this.chunkNumber);
        result = 31 * result + this.modelId.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        UploadChunkRequest other = (UploadChunkRequest) o;
        return this.chunk.equals(other.chunk) && this.chunkNumber == other.chunkNumber && this.modelId.equals(other.modelId);
    }
}
