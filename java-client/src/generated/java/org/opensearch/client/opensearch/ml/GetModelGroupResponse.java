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
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: ml.get_model_group.Response

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class GetModelGroupResponse
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<GetModelGroupResponse.Builder, GetModelGroupResponse> {

    @Nonnull
    private final String access;

    @Nullable
    private final Long createdTime;

    @Nonnull
    private final String description;

    @Nullable
    private final Long lastUpdatedTime;

    private final int latestVersion;

    @Nonnull
    private final String name;

    // ---------------------------------------------------------------------------------------------

    private GetModelGroupResponse(Builder builder) {
        this.access = ApiTypeHelper.requireNonNull(builder.access, this, "access");
        this.createdTime = builder.createdTime;
        this.description = ApiTypeHelper.requireNonNull(builder.description, this, "description");
        this.lastUpdatedTime = builder.lastUpdatedTime;
        this.latestVersion = ApiTypeHelper.requireNonNull(builder.latestVersion, this, "latestVersion");
        this.name = ApiTypeHelper.requireNonNull(builder.name, this, "name");
    }

    public static GetModelGroupResponse of(Function<GetModelGroupResponse.Builder, ObjectBuilder<GetModelGroupResponse>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - The model group access.
     * <p>
     * API name: {@code access}
     * </p>
     */
    @Nonnull
    public final String access() {
        return this.access;
    }

    /**
     * API name: {@code created_time}
     */
    @Nullable
    public final Long createdTime() {
        return this.createdTime;
    }

    /**
     * Required - The model group description.
     * <p>
     * API name: {@code description}
     * </p>
     */
    @Nonnull
    public final String description() {
        return this.description;
    }

    /**
     * API name: {@code last_updated_time}
     */
    @Nullable
    public final Long lastUpdatedTime() {
        return this.lastUpdatedTime;
    }

    /**
     * Required - The latest version.
     * <p>
     * API name: {@code latest_version}
     * </p>
     */
    public final int latestVersion() {
        return this.latestVersion;
    }

    /**
     * Required - The model group name.
     * <p>
     * API name: {@code name}
     * </p>
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
        generator.writeKey("access");
        generator.write(this.access);

        if (this.createdTime != null) {
            generator.writeKey("created_time");
            generator.write(this.createdTime);
        }

        generator.writeKey("description");
        generator.write(this.description);

        if (this.lastUpdatedTime != null) {
            generator.writeKey("last_updated_time");
            generator.write(this.lastUpdatedTime);
        }

        generator.writeKey("latest_version");
        generator.write(this.latestVersion);

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
     * Builder for {@link GetModelGroupResponse}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, GetModelGroupResponse> {
        private String access;
        @Nullable
        private Long createdTime;
        private String description;
        @Nullable
        private Long lastUpdatedTime;
        private Integer latestVersion;
        private String name;

        public Builder() {}

        private Builder(GetModelGroupResponse o) {
            this.access = o.access;
            this.createdTime = o.createdTime;
            this.description = o.description;
            this.lastUpdatedTime = o.lastUpdatedTime;
            this.latestVersion = o.latestVersion;
            this.name = o.name;
        }

        private Builder(Builder o) {
            this.access = o.access;
            this.createdTime = o.createdTime;
            this.description = o.description;
            this.lastUpdatedTime = o.lastUpdatedTime;
            this.latestVersion = o.latestVersion;
            this.name = o.name;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - The model group access.
         * <p>
         * API name: {@code access}
         * </p>
         */
        @Nonnull
        public final Builder access(String value) {
            this.access = value;
            return this;
        }

        /**
         * API name: {@code created_time}
         */
        @Nonnull
        public final Builder createdTime(@Nullable Long value) {
            this.createdTime = value;
            return this;
        }

        /**
         * Required - The model group description.
         * <p>
         * API name: {@code description}
         * </p>
         */
        @Nonnull
        public final Builder description(String value) {
            this.description = value;
            return this;
        }

        /**
         * API name: {@code last_updated_time}
         */
        @Nonnull
        public final Builder lastUpdatedTime(@Nullable Long value) {
            this.lastUpdatedTime = value;
            return this;
        }

        /**
         * Required - The latest version.
         * <p>
         * API name: {@code latest_version}
         * </p>
         */
        @Nonnull
        public final Builder latestVersion(int value) {
            this.latestVersion = value;
            return this;
        }

        /**
         * Required - The model group name.
         * <p>
         * API name: {@code name}
         * </p>
         */
        @Nonnull
        public final Builder name(String value) {
            this.name = value;
            return this;
        }

        /**
         * Builds a {@link GetModelGroupResponse}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public GetModelGroupResponse build() {
            _checkSingleUse();

            return new GetModelGroupResponse(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link GetModelGroupResponse}
     */
    public static final JsonpDeserializer<GetModelGroupResponse> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        GetModelGroupResponse::setupGetModelGroupResponseDeserializer
    );

    protected static void setupGetModelGroupResponseDeserializer(ObjectDeserializer<GetModelGroupResponse.Builder> op) {
        op.add(Builder::access, JsonpDeserializer.stringDeserializer(), "access");
        op.add(Builder::createdTime, JsonpDeserializer.longDeserializer(), "created_time");
        op.add(Builder::description, JsonpDeserializer.stringDeserializer(), "description");
        op.add(Builder::lastUpdatedTime, JsonpDeserializer.longDeserializer(), "last_updated_time");
        op.add(Builder::latestVersion, JsonpDeserializer.integerDeserializer(), "latest_version");
        op.add(Builder::name, JsonpDeserializer.stringDeserializer(), "name");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.access.hashCode();
        result = 31 * result + Objects.hashCode(this.createdTime);
        result = 31 * result + this.description.hashCode();
        result = 31 * result + Objects.hashCode(this.lastUpdatedTime);
        result = 31 * result + Integer.hashCode(this.latestVersion);
        result = 31 * result + this.name.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        GetModelGroupResponse other = (GetModelGroupResponse) o;
        return this.access.equals(other.access)
            && Objects.equals(this.createdTime, other.createdTime)
            && this.description.equals(other.description)
            && Objects.equals(this.lastUpdatedTime, other.lastUpdatedTime)
            && this.latestVersion == other.latestVersion
            && this.name.equals(other.name);
    }
}
