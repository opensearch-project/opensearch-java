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
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
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

// typedef: ml.upload_chunk.Response

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class UploadChunkResponse implements PlainJsonSerializable, ToCopyableBuilder<UploadChunkResponse.Builder, UploadChunkResponse> {

    @Nonnull
    private final String status;

    // ---------------------------------------------------------------------------------------------

    private UploadChunkResponse(Builder builder) {
        this.status = ApiTypeHelper.requireNonNull(builder.status, this, "status");
    }

    public static UploadChunkResponse of(Function<UploadChunkResponse.Builder, ObjectBuilder<UploadChunkResponse>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - The status of the chunk upload operation.
     * <p>
     * API name: {@code status}
     * </p>
     */
    @Nonnull
    public final String status() {
        return this.status;
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
        generator.writeKey("status");
        generator.write(this.status);
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
     * Builder for {@link UploadChunkResponse}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, UploadChunkResponse> {
        private String status;

        public Builder() {}

        private Builder(UploadChunkResponse o) {
            this.status = o.status;
        }

        private Builder(Builder o) {
            this.status = o.status;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - The status of the chunk upload operation.
         * <p>
         * API name: {@code status}
         * </p>
         */
        @Nonnull
        public final Builder status(String value) {
            this.status = value;
            return this;
        }

        /**
         * Builds a {@link UploadChunkResponse}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public UploadChunkResponse build() {
            _checkSingleUse();

            return new UploadChunkResponse(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link UploadChunkResponse}
     */
    public static final JsonpDeserializer<UploadChunkResponse> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        UploadChunkResponse::setupUploadChunkResponseDeserializer
    );

    protected static void setupUploadChunkResponseDeserializer(ObjectDeserializer<UploadChunkResponse.Builder> op) {
        op.add(Builder::status, JsonpDeserializer.stringDeserializer(), "status");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.status.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        UploadChunkResponse other = (UploadChunkResponse) o;
        return this.status.equals(other.status);
    }
}
