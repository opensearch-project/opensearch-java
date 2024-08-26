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
import javax.annotation.Nullable;
import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.json.PlainJsonSerializable;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;

// typedef: ml.get_model_group.Response

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class GetModelGroupResponse implements PlainJsonSerializable {

    private final String access;

    @Nullable
    private final Long createdTime;

    private final String description;

    @Nullable
    private final Long lastUpdatedTime;

    private final int latestVersion;

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

    /**
     * Builder for {@link GetModelGroupResponse}.
     */
    public static class Builder extends ObjectBuilderBase implements ObjectBuilder<GetModelGroupResponse> {
        private String access;
        @Nullable
        private Long createdTime;
        private String description;
        @Nullable
        private Long lastUpdatedTime;
        private Integer latestVersion;
        private String name;

        /**
         * Required - The model group access.
         * <p>
         * API name: {@code access}
         * </p>
         */
        public final Builder access(String value) {
            this.access = value;
            return this;
        }

        /**
         * API name: {@code created_time}
         */
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
        public final Builder description(String value) {
            this.description = value;
            return this;
        }

        /**
         * API name: {@code last_updated_time}
         */
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
        public final Builder name(String value) {
            this.name = value;
            return this;
        }

        /**
         * Builds a {@link GetModelGroupResponse}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
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
}
