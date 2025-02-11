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

// typedef: ml.update_model_group.Request

/**
 * Updates a model group.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public final class UpdateModelGroupRequest extends RequestBase
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<UpdateModelGroupRequest.Builder, UpdateModelGroupRequest> {

    @Nullable
    private final Boolean addAllBackendRoles;

    @Nonnull
    private final List<String> addBackendRoles;

    @Nonnull
    private final List<String> backendRoles;

    @Nullable
    private final String description;

    @Nullable
    private final String modelAccessName;

    @Nonnull
    private final String modelGroupId;

    @Nullable
    private final String name;

    // ---------------------------------------------------------------------------------------------

    private UpdateModelGroupRequest(Builder builder) {
        super(builder);
        this.addAllBackendRoles = builder.addAllBackendRoles;
        this.addBackendRoles = ApiTypeHelper.unmodifiable(builder.addBackendRoles);
        this.backendRoles = ApiTypeHelper.unmodifiable(builder.backendRoles);
        this.description = builder.description;
        this.modelAccessName = builder.modelAccessName;
        this.modelGroupId = ApiTypeHelper.requireNonNull(builder.modelGroupId, this, "modelGroupId");
        this.name = builder.name;
    }

    public static UpdateModelGroupRequest of(Function<UpdateModelGroupRequest.Builder, ObjectBuilder<UpdateModelGroupRequest>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Whether to include all backend roles.
     * <p>
     * API name: {@code add_all_backend_roles}
     * </p>
     */
    @Nullable
    public final Boolean addAllBackendRoles() {
        return this.addAllBackendRoles;
    }

    /**
     * The backend roles to add.
     * <p>
     * API name: {@code add_backend_roles}
     * </p>
     */
    @Nonnull
    public final List<String> addBackendRoles() {
        return this.addBackendRoles;
    }

    /**
     * The backend roles.
     * <p>
     * API name: {@code backend_roles}
     * </p>
     */
    @Nonnull
    public final List<String> backendRoles() {
        return this.backendRoles;
    }

    /**
     * The model group description.
     * <p>
     * API name: {@code description}
     * </p>
     */
    @Nullable
    public final String description() {
        return this.description;
    }

    /**
     * The model access name
     * <p>
     * API name: {@code model_access_name}
     * </p>
     */
    @Nullable
    public final String modelAccessName() {
        return this.modelAccessName;
    }

    /**
     * Required - API name: {@code model_group_id}
     */
    @Nonnull
    public final String modelGroupId() {
        return this.modelGroupId;
    }

    /**
     * The model group name.
     * <p>
     * API name: {@code name}
     * </p>
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
        if (this.addAllBackendRoles != null) {
            generator.writeKey("add_all_backend_roles");
            generator.write(this.addAllBackendRoles);
        }

        if (ApiTypeHelper.isDefined(this.addBackendRoles)) {
            generator.writeKey("add_backend_roles");
            generator.writeStartArray();
            for (String item0 : this.addBackendRoles) {
                generator.write(item0);
            }
            generator.writeEnd();
        }

        if (ApiTypeHelper.isDefined(this.backendRoles)) {
            generator.writeKey("backend_roles");
            generator.writeStartArray();
            for (String item0 : this.backendRoles) {
                generator.write(item0);
            }
            generator.writeEnd();
        }

        if (this.description != null) {
            generator.writeKey("description");
            generator.write(this.description);
        }

        if (this.modelAccessName != null) {
            generator.writeKey("model_access_name");
            generator.write(this.modelAccessName);
        }

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
     * Builder for {@link UpdateModelGroupRequest}.
     */
    public static class Builder extends RequestBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, UpdateModelGroupRequest> {
        @Nullable
        private Boolean addAllBackendRoles;
        @Nullable
        private List<String> addBackendRoles;
        @Nullable
        private List<String> backendRoles;
        @Nullable
        private String description;
        @Nullable
        private String modelAccessName;
        private String modelGroupId;
        @Nullable
        private String name;

        public Builder() {}

        private Builder(UpdateModelGroupRequest o) {
            super(o);
            this.addAllBackendRoles = o.addAllBackendRoles;
            this.addBackendRoles = _listCopy(o.addBackendRoles);
            this.backendRoles = _listCopy(o.backendRoles);
            this.description = o.description;
            this.modelAccessName = o.modelAccessName;
            this.modelGroupId = o.modelGroupId;
            this.name = o.name;
        }

        private Builder(Builder o) {
            super(o);
            this.addAllBackendRoles = o.addAllBackendRoles;
            this.addBackendRoles = _listCopy(o.addBackendRoles);
            this.backendRoles = _listCopy(o.backendRoles);
            this.description = o.description;
            this.modelAccessName = o.modelAccessName;
            this.modelGroupId = o.modelGroupId;
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
         * Whether to include all backend roles.
         * <p>
         * API name: {@code add_all_backend_roles}
         * </p>
         */
        @Nonnull
        public final Builder addAllBackendRoles(@Nullable Boolean value) {
            this.addAllBackendRoles = value;
            return this;
        }

        /**
         * The backend roles to add.
         * <p>
         * API name: {@code add_backend_roles}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>addBackendRoles</code>.
         * </p>
         */
        @Nonnull
        public final Builder addBackendRoles(List<String> list) {
            this.addBackendRoles = _listAddAll(this.addBackendRoles, list);
            return this;
        }

        /**
         * The backend roles to add.
         * <p>
         * API name: {@code add_backend_roles}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>addBackendRoles</code>.
         * </p>
         */
        @Nonnull
        public final Builder addBackendRoles(String value, String... values) {
            this.addBackendRoles = _listAdd(this.addBackendRoles, value, values);
            return this;
        }

        /**
         * The backend roles.
         * <p>
         * API name: {@code backend_roles}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>backendRoles</code>.
         * </p>
         */
        @Nonnull
        public final Builder backendRoles(List<String> list) {
            this.backendRoles = _listAddAll(this.backendRoles, list);
            return this;
        }

        /**
         * The backend roles.
         * <p>
         * API name: {@code backend_roles}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>backendRoles</code>.
         * </p>
         */
        @Nonnull
        public final Builder backendRoles(String value, String... values) {
            this.backendRoles = _listAdd(this.backendRoles, value, values);
            return this;
        }

        /**
         * The model group description.
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
         * The model access name
         * <p>
         * API name: {@code model_access_name}
         * </p>
         */
        @Nonnull
        public final Builder modelAccessName(@Nullable String value) {
            this.modelAccessName = value;
            return this;
        }

        /**
         * Required - API name: {@code model_group_id}
         */
        @Nonnull
        public final Builder modelGroupId(String value) {
            this.modelGroupId = value;
            return this;
        }

        /**
         * The model group name.
         * <p>
         * API name: {@code name}
         * </p>
         */
        @Nonnull
        public final Builder name(@Nullable String value) {
            this.name = value;
            return this;
        }

        /**
         * Builds a {@link UpdateModelGroupRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public UpdateModelGroupRequest build() {
            _checkSingleUse();

            return new UpdateModelGroupRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link UpdateModelGroupRequest}
     */
    public static final JsonpDeserializer<UpdateModelGroupRequest> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        UpdateModelGroupRequest::setupUpdateModelGroupRequestDeserializer
    );

    protected static void setupUpdateModelGroupRequestDeserializer(ObjectDeserializer<UpdateModelGroupRequest.Builder> op) {
        op.add(Builder::addAllBackendRoles, JsonpDeserializer.booleanDeserializer(), "add_all_backend_roles");
        op.add(Builder::addBackendRoles, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "add_backend_roles");
        op.add(Builder::backendRoles, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "backend_roles");
        op.add(Builder::description, JsonpDeserializer.stringDeserializer(), "description");
        op.add(Builder::modelAccessName, JsonpDeserializer.stringDeserializer(), "model_access_name");
        op.add(Builder::name, JsonpDeserializer.stringDeserializer(), "name");
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Endpoint "{@code ml.update_model_group}".
     */
    public static final Endpoint<UpdateModelGroupRequest, UpdateModelGroupResponse, ErrorResponse> _ENDPOINT = new SimpleEndpoint<>(
        // Request method
        request -> "PUT",
        // Request path
        request -> {
            StringBuilder buf = new StringBuilder();
            buf.append("/_plugins/_ml/model_groups/");
            SimpleEndpoint.pathEncode(request.modelGroupId, buf);
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
        UpdateModelGroupResponse._DESERIALIZER
    );

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.addAllBackendRoles);
        result = 31 * result + Objects.hashCode(this.addBackendRoles);
        result = 31 * result + Objects.hashCode(this.backendRoles);
        result = 31 * result + Objects.hashCode(this.description);
        result = 31 * result + Objects.hashCode(this.modelAccessName);
        result = 31 * result + this.modelGroupId.hashCode();
        result = 31 * result + Objects.hashCode(this.name);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        UpdateModelGroupRequest other = (UpdateModelGroupRequest) o;
        return Objects.equals(this.addAllBackendRoles, other.addAllBackendRoles)
            && Objects.equals(this.addBackendRoles, other.addBackendRoles)
            && Objects.equals(this.backendRoles, other.backendRoles)
            && Objects.equals(this.description, other.description)
            && Objects.equals(this.modelAccessName, other.modelAccessName)
            && this.modelGroupId.equals(other.modelGroupId)
            && Objects.equals(this.name, other.name);
    }
}
