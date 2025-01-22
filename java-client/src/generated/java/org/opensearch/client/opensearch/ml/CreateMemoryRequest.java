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
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: ml.create_memory.Request

/**
 * Create a memory.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public final class CreateMemoryRequest extends RequestBase
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<CreateMemoryRequest.Builder, CreateMemoryRequest> {

    @Nullable
    private final String name;

    // ---------------------------------------------------------------------------------------------

    private CreateMemoryRequest(Builder builder) {
        super(builder);
        this.name = builder.name;
    }

    public static CreateMemoryRequest of(Function<CreateMemoryRequest.Builder, ObjectBuilder<CreateMemoryRequest>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code name}
     */
    @Nullable
    public final String name() {
        return this.name;
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
        if (this.name != null) {
            generator.writeKey("name");
            generator.write(this.name);
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
     * Builder for {@link CreateMemoryRequest}.
     */
    public static class Builder extends RequestBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, CreateMemoryRequest> {
        @Nullable
        private String name;

        public Builder() {}

        private Builder(CreateMemoryRequest o) {
            super(o);
            this.name = o.name;
        }

        private Builder(Builder o) {
            super(o);
            this.name = o.name;
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
         * API name: {@code name}
         */
        @Nonnull
        public final Builder name(@Nullable String value) {
            this.name = value;
            return this;
        }

        /**
         * Builds a {@link CreateMemoryRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public CreateMemoryRequest build() {
            _checkSingleUse();

            return new CreateMemoryRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link CreateMemoryRequest}
     */
    public static final JsonpDeserializer<CreateMemoryRequest> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        CreateMemoryRequest::setupCreateMemoryRequestDeserializer
    );

    protected static void setupCreateMemoryRequestDeserializer(ObjectDeserializer<CreateMemoryRequest.Builder> op) {
        op.add(Builder::name, JsonpDeserializer.stringDeserializer(), "name");
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Endpoint "{@code ml.create_memory}".
     */
    public static final Endpoint<CreateMemoryRequest, CreateMemoryResponse, ErrorResponse> _ENDPOINT = new SimpleEndpoint<>(
        // Request method
        request -> "POST",
        // Request path
        request -> "/_plugins/_ml/memory",
        // Request parameters
        request -> {
            Map<String, String> params = new HashMap<>();
            request.applyQueryParameters(params);
            return params;
        },
        SimpleEndpoint.emptyMap(),
        true,
        CreateMemoryResponse._DESERIALIZER
    );

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.name);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        CreateMemoryRequest other = (CreateMemoryRequest) o;
        return Objects.equals(this.name, other.name);
    }
}
