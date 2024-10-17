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
import java.util.List;
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
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;

// typedef: ml.register_model_group.Request

/**
 * Registers a model group.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class RegisterModelGroupRequest extends RequestBase implements PlainJsonSerializable {

    @Nullable
    private final String accessMode;

    @Nullable
    private final Boolean addAllBackendRoles;

    @Nonnull
    private final List<String> backendRoles;

    @Nullable
    private final String description;

    @Nonnull
    private final String name;

    // ---------------------------------------------------------------------------------------------

    private RegisterModelGroupRequest(Builder builder) {
        this.accessMode = builder.accessMode;
        this.addAllBackendRoles = builder.addAllBackendRoles;
        this.backendRoles = ApiTypeHelper.unmodifiable(builder.backendRoles);
        this.description = builder.description;
        this.name = ApiTypeHelper.requireNonNull(builder.name, this, "name");
    }

    public static RegisterModelGroupRequest of(Function<RegisterModelGroupRequest.Builder, ObjectBuilder<RegisterModelGroupRequest>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * The model group access mode.
     * <p>
     * API name: {@code access_mode}
     * </p>
     */
    @Nullable
    public final String accessMode() {
        return this.accessMode;
    }

    /**
     * The add all backend roles.
     * <p>
     * API name: {@code add_all_backend_roles}
     * </p>
     */
    @Nullable
    public final Boolean addAllBackendRoles() {
        return this.addAllBackendRoles;
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
        if (this.accessMode != null) {
            generator.writeKey("access_mode");
            generator.write(this.accessMode);
        }

        if (this.addAllBackendRoles != null) {
            generator.writeKey("add_all_backend_roles");
            generator.write(this.addAllBackendRoles);
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

        generator.writeKey("name");
        generator.write(this.name);
    }
    // ---------------------------------------------------------------------------------------------

    /**
     * Builder for {@link RegisterModelGroupRequest}.
     */
    public static class Builder extends ObjectBuilderBase implements ObjectBuilder<RegisterModelGroupRequest> {
        @Nullable
        private String accessMode;
        @Nullable
        private Boolean addAllBackendRoles;
        @Nullable
        private List<String> backendRoles;
        @Nullable
        private String description;
        private String name;

        /**
         * The model group access mode.
         * <p>
         * API name: {@code access_mode}
         * </p>
         */
        public final Builder accessMode(@Nullable String value) {
            this.accessMode = value;
            return this;
        }

        /**
         * The add all backend roles.
         * <p>
         * API name: {@code add_all_backend_roles}
         * </p>
         */
        public final Builder addAllBackendRoles(@Nullable Boolean value) {
            this.addAllBackendRoles = value;
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
        public final Builder description(@Nullable String value) {
            this.description = value;
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
         * Builds a {@link RegisterModelGroupRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        public RegisterModelGroupRequest build() {
            _checkSingleUse();

            return new RegisterModelGroupRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link RegisterModelGroupRequest}
     */
    public static final JsonpDeserializer<RegisterModelGroupRequest> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        RegisterModelGroupRequest::setupRegisterModelGroupRequestDeserializer
    );

    protected static void setupRegisterModelGroupRequestDeserializer(ObjectDeserializer<RegisterModelGroupRequest.Builder> op) {
        op.add(Builder::accessMode, JsonpDeserializer.stringDeserializer(), "access_mode");
        op.add(Builder::addAllBackendRoles, JsonpDeserializer.booleanDeserializer(), "add_all_backend_roles");
        op.add(Builder::backendRoles, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "backend_roles");
        op.add(Builder::description, JsonpDeserializer.stringDeserializer(), "description");
        op.add(Builder::name, JsonpDeserializer.stringDeserializer(), "name");
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Endpoint "{@code ml.register_model_group}".
     */
    public static final Endpoint<RegisterModelGroupRequest, RegisterModelGroupResponse, ErrorResponse> _ENDPOINT = new SimpleEndpoint<>(
        // Request method
        request -> "POST",
        // Request path
        request -> "/_plugins/_ml/model_groups/_register",
        // Request parameters
        SimpleEndpoint.emptyMap(),
        SimpleEndpoint.emptyMap(),
        true,
        RegisterModelGroupResponse._DESERIALIZER
    );

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.accessMode);
        result = 31 * result + Objects.hashCode(this.addAllBackendRoles);
        result = 31 * result + Objects.hashCode(this.backendRoles);
        result = 31 * result + Objects.hashCode(this.description);
        result = 31 * result + this.name.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        RegisterModelGroupRequest other = (RegisterModelGroupRequest) o;
        return Objects.equals(this.accessMode, other.accessMode)
            && Objects.equals(this.addAllBackendRoles, other.addAllBackendRoles)
            && Objects.equals(this.backendRoles, other.backendRoles)
            && Objects.equals(this.description, other.description)
            && this.name.equals(other.name);
    }
}
