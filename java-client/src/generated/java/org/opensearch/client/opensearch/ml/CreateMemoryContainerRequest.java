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
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: ml.create_memory_container.Request

/**
 * Create a memory container.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public final class CreateMemoryContainerRequest extends RequestBase
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<CreateMemoryContainerRequest.Builder, CreateMemoryContainerRequest> {

    @Nonnull
    private final MemoryContainerConfiguration configuration;

    @Nullable
    private final String description;

    @Nonnull
    private final String name;

    // ---------------------------------------------------------------------------------------------

    private CreateMemoryContainerRequest(Builder builder) {
        super(builder);
        this.configuration = ApiTypeHelper.requireNonNull(builder.configuration, this, "configuration");
        this.description = builder.description;
        this.name = ApiTypeHelper.requireNonNull(builder.name, this, "name");
    }

    public static CreateMemoryContainerRequest of(
        Function<CreateMemoryContainerRequest.Builder, ObjectBuilder<CreateMemoryContainerRequest>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code configuration}
     */
    @Nonnull
    public final MemoryContainerConfiguration configuration() {
        return this.configuration;
    }

    /**
     * API name: {@code description}
     */
    @Nullable
    public final String description() {
        return this.description;
    }

    /**
     * Required - API name: {@code name}
     */
    @Nonnull
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
        generator.writeKey("configuration");
        this.configuration.serialize(generator, mapper);

        if (this.description != null) {
            generator.writeKey("description");
            generator.write(this.description);
        }

        generator.writeKey("name");
        generator.write(this.name);
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
     * Builder for {@link CreateMemoryContainerRequest}.
     */
    public static class Builder extends RequestBase.AbstractBuilder<Builder>
        implements
            CopyableBuilder<Builder, CreateMemoryContainerRequest> {
        private MemoryContainerConfiguration configuration;
        @Nullable
        private String description;
        private String name;

        public Builder() {}

        private Builder(CreateMemoryContainerRequest o) {
            super(o);
            this.configuration = o.configuration;
            this.description = o.description;
            this.name = o.name;
        }

        private Builder(Builder o) {
            super(o);
            this.configuration = o.configuration;
            this.description = o.description;
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
         * Required - API name: {@code configuration}
         */
        @Nonnull
        public final Builder configuration(MemoryContainerConfiguration value) {
            this.configuration = value;
            return this;
        }

        /**
         * Required - API name: {@code configuration}
         */
        @Nonnull
        public final Builder configuration(Function<MemoryContainerConfiguration.Builder, ObjectBuilder<MemoryContainerConfiguration>> fn) {
            return configuration(fn.apply(new MemoryContainerConfiguration.Builder()).build());
        }

        /**
         * API name: {@code description}
         */
        @Nonnull
        public final Builder description(@Nullable String value) {
            this.description = value;
            return this;
        }

        /**
         * Required - API name: {@code name}
         */
        @Nonnull
        public final Builder name(String value) {
            this.name = value;
            return this;
        }

        /**
         * Builds a {@link CreateMemoryContainerRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public CreateMemoryContainerRequest build() {
            _checkSingleUse();

            return new CreateMemoryContainerRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link CreateMemoryContainerRequest}
     */
    public static final JsonpDeserializer<CreateMemoryContainerRequest> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        CreateMemoryContainerRequest::setupCreateMemoryContainerRequestDeserializer
    );

    protected static void setupCreateMemoryContainerRequestDeserializer(ObjectDeserializer<CreateMemoryContainerRequest.Builder> op) {
        op.add(Builder::configuration, MemoryContainerConfiguration._DESERIALIZER, "configuration");
        op.add(Builder::description, JsonpDeserializer.stringDeserializer(), "description");
        op.add(Builder::name, JsonpDeserializer.stringDeserializer(), "name");
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Endpoint "{@code ml.create_memory_container}".
     */
    public static final Endpoint<CreateMemoryContainerRequest, CreateMemoryContainerResponse, ErrorResponse> _ENDPOINT =
        new SimpleEndpoint<>(
            // Request method
            request -> "POST",
            // Request path
            request -> "/_plugins/_ml/memory_containers/_create",
            // Request parameters
            request -> {
                Map<String, String> params = new HashMap<>();
                request.applyQueryParameters(params);
                return params;
            },
            SimpleEndpoint.emptyMap(),
            true,
            CreateMemoryContainerResponse._DESERIALIZER
        );

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.configuration.hashCode();
        result = 31 * result + Objects.hashCode(this.description);
        result = 31 * result + this.name.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        CreateMemoryContainerRequest other = (CreateMemoryContainerRequest) o;
        return this.configuration.equals(other.configuration)
            && Objects.equals(this.description, other.description)
            && this.name.equals(other.name);
    }
}
