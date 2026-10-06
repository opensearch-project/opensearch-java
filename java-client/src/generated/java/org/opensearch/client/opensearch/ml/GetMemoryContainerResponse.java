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
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: ml.get_memory_container.Response

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class GetMemoryContainerResponse
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<GetMemoryContainerResponse.Builder, GetMemoryContainerResponse> {

    @Nullable
    private final MemoryContainerConfiguration configuration;

    @Nullable
    private final Long createdTime;

    @Nullable
    private final String description;

    @Nullable
    private final Long lastUpdatedTime;

    @Nullable
    private final String name;

    @Nullable
    private final Owner owner;

    // ---------------------------------------------------------------------------------------------

    private GetMemoryContainerResponse(Builder builder) {
        this.configuration = builder.configuration;
        this.createdTime = builder.createdTime;
        this.description = builder.description;
        this.lastUpdatedTime = builder.lastUpdatedTime;
        this.name = builder.name;
        this.owner = builder.owner;
    }

    public static GetMemoryContainerResponse of(
        Function<GetMemoryContainerResponse.Builder, ObjectBuilder<GetMemoryContainerResponse>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code configuration}
     */
    @Nullable
    public final MemoryContainerConfiguration configuration() {
        return this.configuration;
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
     * The memory container description.
     * <p>
     * API name: {@code description}
     * </p>
     */
    @Nullable
    public final String description() {
        return this.description;
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
     * API name: {@code name}
     */
    @Nullable
    public final String name() {
        return this.name;
    }

    /**
     * API name: {@code owner}
     */
    @Nullable
    public final Owner owner() {
        return this.owner;
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
        if (this.configuration != null) {
            generator.writeKey("configuration");
            this.configuration.serialize(generator, mapper);
        }

        if (this.createdTime != null) {
            generator.writeKey("created_time");
            generator.write(this.createdTime);
        }

        if (this.description != null) {
            generator.writeKey("description");
            generator.write(this.description);
        }

        if (this.lastUpdatedTime != null) {
            generator.writeKey("last_updated_time");
            generator.write(this.lastUpdatedTime);
        }

        if (this.name != null) {
            generator.writeKey("name");
            generator.write(this.name);
        }

        if (this.owner != null) {
            generator.writeKey("owner");
            this.owner.serialize(generator, mapper);
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
     * Builder for {@link GetMemoryContainerResponse}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, GetMemoryContainerResponse> {
        @Nullable
        private MemoryContainerConfiguration configuration;
        @Nullable
        private Long createdTime;
        @Nullable
        private String description;
        @Nullable
        private Long lastUpdatedTime;
        @Nullable
        private String name;
        @Nullable
        private Owner owner;

        public Builder() {}

        private Builder(GetMemoryContainerResponse o) {
            this.configuration = o.configuration;
            this.createdTime = o.createdTime;
            this.description = o.description;
            this.lastUpdatedTime = o.lastUpdatedTime;
            this.name = o.name;
            this.owner = o.owner;
        }

        private Builder(Builder o) {
            this.configuration = o.configuration;
            this.createdTime = o.createdTime;
            this.description = o.description;
            this.lastUpdatedTime = o.lastUpdatedTime;
            this.name = o.name;
            this.owner = o.owner;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code configuration}
         */
        @Nonnull
        public final Builder configuration(@Nullable MemoryContainerConfiguration value) {
            this.configuration = value;
            return this;
        }

        /**
         * API name: {@code configuration}
         */
        @Nonnull
        public final Builder configuration(Function<MemoryContainerConfiguration.Builder, ObjectBuilder<MemoryContainerConfiguration>> fn) {
            return configuration(fn.apply(new MemoryContainerConfiguration.Builder()).build());
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
         * The memory container description.
         * <p>
         * API name: {@code description}
         * </p>
         */
        @Nonnull
        public final Builder description(@Nullable String value) {
            this.description = value;
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
         * API name: {@code name}
         */
        @Nonnull
        public final Builder name(@Nullable String value) {
            this.name = value;
            return this;
        }

        /**
         * API name: {@code owner}
         */
        @Nonnull
        public final Builder owner(@Nullable Owner value) {
            this.owner = value;
            return this;
        }

        /**
         * API name: {@code owner}
         */
        @Nonnull
        public final Builder owner(Function<Owner.Builder, ObjectBuilder<Owner>> fn) {
            return owner(fn.apply(new Owner.Builder()).build());
        }

        /**
         * Builds a {@link GetMemoryContainerResponse}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public GetMemoryContainerResponse build() {
            _checkSingleUse();

            return new GetMemoryContainerResponse(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link GetMemoryContainerResponse}
     */
    public static final JsonpDeserializer<GetMemoryContainerResponse> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        GetMemoryContainerResponse::setupGetMemoryContainerResponseDeserializer
    );

    protected static void setupGetMemoryContainerResponseDeserializer(ObjectDeserializer<GetMemoryContainerResponse.Builder> op) {
        op.add(Builder::configuration, MemoryContainerConfiguration._DESERIALIZER, "configuration");
        op.add(Builder::createdTime, JsonpDeserializer.longDeserializer(), "created_time");
        op.add(Builder::description, JsonpDeserializer.stringDeserializer(), "description");
        op.add(Builder::lastUpdatedTime, JsonpDeserializer.longDeserializer(), "last_updated_time");
        op.add(Builder::name, JsonpDeserializer.stringDeserializer(), "name");
        op.add(Builder::owner, Owner._DESERIALIZER, "owner");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.configuration);
        result = 31 * result + Objects.hashCode(this.createdTime);
        result = 31 * result + Objects.hashCode(this.description);
        result = 31 * result + Objects.hashCode(this.lastUpdatedTime);
        result = 31 * result + Objects.hashCode(this.name);
        result = 31 * result + Objects.hashCode(this.owner);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        GetMemoryContainerResponse other = (GetMemoryContainerResponse) o;
        return Objects.equals(this.configuration, other.configuration)
            && Objects.equals(this.createdTime, other.createdTime)
            && Objects.equals(this.description, other.description)
            && Objects.equals(this.lastUpdatedTime, other.lastUpdatedTime)
            && Objects.equals(this.name, other.name)
            && Objects.equals(this.owner, other.owner);
    }
}
