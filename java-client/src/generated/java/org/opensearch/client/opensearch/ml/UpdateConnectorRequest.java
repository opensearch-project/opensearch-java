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
import org.opensearch.client.json.JsonData;
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

// typedef: ml.update_connector.Request

/**
 * Updates a standalone connector.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public final class UpdateConnectorRequest extends RequestBase
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<UpdateConnectorRequest.Builder, UpdateConnectorRequest> {

    @Nullable
    private final String accessMode;

    @Nonnull
    private final List<Action> actions;

    @Nonnull
    private final List<String> backendRoles;

    @Nonnull
    private final String connectorId;

    @Nullable
    private final Credential credential;

    @Nullable
    private final String description;

    @Nullable
    private final String name;

    @Nonnull
    private final Map<String, JsonData> parameters;

    @Nullable
    private final Boolean parametersSkipValidatingMissingParameters;

    @Nullable
    private final String protocol;

    @Nullable
    private final Long version;

    // ---------------------------------------------------------------------------------------------

    private UpdateConnectorRequest(Builder builder) {
        super(builder);
        this.accessMode = builder.accessMode;
        this.actions = ApiTypeHelper.unmodifiable(builder.actions);
        this.backendRoles = ApiTypeHelper.unmodifiable(builder.backendRoles);
        this.connectorId = ApiTypeHelper.requireNonNull(builder.connectorId, this, "connectorId");
        this.credential = builder.credential;
        this.description = builder.description;
        this.name = builder.name;
        this.parameters = ApiTypeHelper.unmodifiable(builder.parameters);
        this.parametersSkipValidatingMissingParameters = builder.parametersSkipValidatingMissingParameters;
        this.protocol = builder.protocol;
        this.version = builder.version;
    }

    public static UpdateConnectorRequest of(Function<UpdateConnectorRequest.Builder, ObjectBuilder<UpdateConnectorRequest>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code access_mode}
     */
    @Nullable
    public final String accessMode() {
        return this.accessMode;
    }

    /**
     * API name: {@code actions}
     */
    @Nonnull
    public final List<Action> actions() {
        return this.actions;
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
     * Required - API name: {@code connector_id}
     */
    @Nonnull
    public final String connectorId() {
        return this.connectorId;
    }

    /**
     * API name: {@code credential}
     */
    @Nullable
    public final Credential credential() {
        return this.credential;
    }

    /**
     * The connector description.
     * <p>
     * API name: {@code description}
     * </p>
     */
    @Nullable
    public final String description() {
        return this.description;
    }

    /**
     * API name: {@code name}
     */
    @Nullable
    public final String name() {
        return this.name;
    }

    /**
     * API name: {@code parameters}
     */
    @Nonnull
    public final Map<String, JsonData> parameters() {
        return this.parameters;
    }

    /**
     * Whether to skip validating missing parameters.
     * <p>
     * API name: {@code parameters.skip_validating_missing_parameters}
     * </p>
     */
    @Nullable
    public final Boolean parametersSkipValidatingMissingParameters() {
        return this.parametersSkipValidatingMissingParameters;
    }

    /**
     * API name: {@code protocol}
     */
    @Nullable
    public final String protocol() {
        return this.protocol;
    }

    /**
     * API name: {@code version}
     */
    @Nullable
    public final Long version() {
        return this.version;
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

        if (ApiTypeHelper.isDefined(this.actions)) {
            generator.writeKey("actions");
            generator.writeStartArray();
            for (Action item0 : this.actions) {
                item0.serialize(generator, mapper);
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

        if (this.credential != null) {
            generator.writeKey("credential");
            this.credential.serialize(generator, mapper);
        }

        if (this.description != null) {
            generator.writeKey("description");
            generator.write(this.description);
        }

        if (this.name != null) {
            generator.writeKey("name");
            generator.write(this.name);
        }

        if (ApiTypeHelper.isDefined(this.parameters)) {
            generator.writeKey("parameters");
            generator.writeStartObject();
            for (Map.Entry<String, JsonData> item0 : this.parameters.entrySet()) {
                generator.writeKey(item0.getKey());
                item0.getValue().serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (this.parametersSkipValidatingMissingParameters != null) {
            generator.writeKey("parameters.skip_validating_missing_parameters");
            generator.write(this.parametersSkipValidatingMissingParameters);
        }

        if (this.protocol != null) {
            generator.writeKey("protocol");
            generator.write(this.protocol);
        }

        if (this.version != null) {
            generator.writeKey("version");
            generator.write(this.version);
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
     * Builder for {@link UpdateConnectorRequest}.
     */
    public static class Builder extends RequestBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, UpdateConnectorRequest> {
        @Nullable
        private String accessMode;
        @Nullable
        private List<Action> actions;
        @Nullable
        private List<String> backendRoles;
        private String connectorId;
        @Nullable
        private Credential credential;
        @Nullable
        private String description;
        @Nullable
        private String name;
        @Nullable
        private Map<String, JsonData> parameters;
        @Nullable
        private Boolean parametersSkipValidatingMissingParameters;
        @Nullable
        private String protocol;
        @Nullable
        private Long version;

        public Builder() {}

        private Builder(UpdateConnectorRequest o) {
            super(o);
            this.accessMode = o.accessMode;
            this.actions = _listCopy(o.actions);
            this.backendRoles = _listCopy(o.backendRoles);
            this.connectorId = o.connectorId;
            this.credential = o.credential;
            this.description = o.description;
            this.name = o.name;
            this.parameters = _mapCopy(o.parameters);
            this.parametersSkipValidatingMissingParameters = o.parametersSkipValidatingMissingParameters;
            this.protocol = o.protocol;
            this.version = o.version;
        }

        private Builder(Builder o) {
            super(o);
            this.accessMode = o.accessMode;
            this.actions = _listCopy(o.actions);
            this.backendRoles = _listCopy(o.backendRoles);
            this.connectorId = o.connectorId;
            this.credential = o.credential;
            this.description = o.description;
            this.name = o.name;
            this.parameters = _mapCopy(o.parameters);
            this.parametersSkipValidatingMissingParameters = o.parametersSkipValidatingMissingParameters;
            this.protocol = o.protocol;
            this.version = o.version;
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
         * API name: {@code access_mode}
         */
        @Nonnull
        public final Builder accessMode(@Nullable String value) {
            this.accessMode = value;
            return this;
        }

        /**
         * API name: {@code actions}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>actions</code>.
         * </p>
         */
        @Nonnull
        public final Builder actions(List<Action> list) {
            this.actions = _listAddAll(this.actions, list);
            return this;
        }

        /**
         * API name: {@code actions}
         *
         * <p>
         * Adds one or more values to <code>actions</code>.
         * </p>
         */
        @Nonnull
        public final Builder actions(Action value, Action... values) {
            this.actions = _listAdd(this.actions, value, values);
            return this;
        }

        /**
         * API name: {@code actions}
         *
         * <p>
         * Adds a value to <code>actions</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder actions(Function<Action.Builder, ObjectBuilder<Action>> fn) {
            return actions(fn.apply(new Action.Builder()).build());
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
         * Required - API name: {@code connector_id}
         */
        @Nonnull
        public final Builder connectorId(String value) {
            this.connectorId = value;
            return this;
        }

        /**
         * API name: {@code credential}
         */
        @Nonnull
        public final Builder credential(@Nullable Credential value) {
            this.credential = value;
            return this;
        }

        /**
         * API name: {@code credential}
         */
        @Nonnull
        public final Builder credential(Function<Credential.Builder, ObjectBuilder<Credential>> fn) {
            return credential(fn.apply(new Credential.Builder()).build());
        }

        /**
         * The connector description.
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
         * API name: {@code name}
         */
        @Nonnull
        public final Builder name(@Nullable String value) {
            this.name = value;
            return this;
        }

        /**
         * API name: {@code parameters}
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>parameters</code>.
         * </p>
         */
        @Nonnull
        public final Builder parameters(Map<String, JsonData> map) {
            this.parameters = _mapPutAll(this.parameters, map);
            return this;
        }

        /**
         * API name: {@code parameters}
         *
         * <p>
         * Adds an entry to <code>parameters</code>.
         * </p>
         */
        @Nonnull
        public final Builder parameters(String key, JsonData value) {
            this.parameters = _mapPut(this.parameters, key, value);
            return this;
        }

        /**
         * Whether to skip validating missing parameters.
         * <p>
         * API name: {@code parameters.skip_validating_missing_parameters}
         * </p>
         */
        @Nonnull
        public final Builder parametersSkipValidatingMissingParameters(@Nullable Boolean value) {
            this.parametersSkipValidatingMissingParameters = value;
            return this;
        }

        /**
         * API name: {@code protocol}
         */
        @Nonnull
        public final Builder protocol(@Nullable String value) {
            this.protocol = value;
            return this;
        }

        /**
         * API name: {@code version}
         */
        @Nonnull
        public final Builder version(@Nullable Long value) {
            this.version = value;
            return this;
        }

        /**
         * Builds a {@link UpdateConnectorRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public UpdateConnectorRequest build() {
            _checkSingleUse();

            return new UpdateConnectorRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link UpdateConnectorRequest}
     */
    public static final JsonpDeserializer<UpdateConnectorRequest> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        UpdateConnectorRequest::setupUpdateConnectorRequestDeserializer
    );

    protected static void setupUpdateConnectorRequestDeserializer(ObjectDeserializer<UpdateConnectorRequest.Builder> op) {
        op.add(Builder::accessMode, JsonpDeserializer.stringDeserializer(), "access_mode");
        op.add(Builder::actions, JsonpDeserializer.arrayDeserializer(Action._DESERIALIZER), "actions");
        op.add(Builder::backendRoles, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "backend_roles");
        op.add(Builder::credential, Credential._DESERIALIZER, "credential");
        op.add(Builder::description, JsonpDeserializer.stringDeserializer(), "description");
        op.add(Builder::name, JsonpDeserializer.stringDeserializer(), "name");
        op.add(Builder::parameters, JsonpDeserializer.stringMapDeserializer(JsonData._DESERIALIZER), "parameters");
        op.add(
            Builder::parametersSkipValidatingMissingParameters,
            JsonpDeserializer.booleanDeserializer(),
            "parameters.skip_validating_missing_parameters"
        );
        op.add(Builder::protocol, JsonpDeserializer.stringDeserializer(), "protocol");
        op.add(Builder::version, JsonpDeserializer.longDeserializer(), "version");
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Endpoint "{@code ml.update_connector}".
     */
    public static final Endpoint<UpdateConnectorRequest, UpdateConnectorResponse, ErrorResponse> _ENDPOINT = new SimpleEndpoint<>(
        // Request method
        request -> "PUT",
        // Request path
        request -> {
            StringBuilder buf = new StringBuilder();
            buf.append("/_plugins/_ml/connectors/");
            SimpleEndpoint.pathEncode(request.connectorId, buf);
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
        UpdateConnectorResponse._DESERIALIZER
    );

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.accessMode);
        result = 31 * result + Objects.hashCode(this.actions);
        result = 31 * result + Objects.hashCode(this.backendRoles);
        result = 31 * result + this.connectorId.hashCode();
        result = 31 * result + Objects.hashCode(this.credential);
        result = 31 * result + Objects.hashCode(this.description);
        result = 31 * result + Objects.hashCode(this.name);
        result = 31 * result + Objects.hashCode(this.parameters);
        result = 31 * result + Objects.hashCode(this.parametersSkipValidatingMissingParameters);
        result = 31 * result + Objects.hashCode(this.protocol);
        result = 31 * result + Objects.hashCode(this.version);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        UpdateConnectorRequest other = (UpdateConnectorRequest) o;
        return Objects.equals(this.accessMode, other.accessMode)
            && Objects.equals(this.actions, other.actions)
            && Objects.equals(this.backendRoles, other.backendRoles)
            && this.connectorId.equals(other.connectorId)
            && Objects.equals(this.credential, other.credential)
            && Objects.equals(this.description, other.description)
            && Objects.equals(this.name, other.name)
            && Objects.equals(this.parameters, other.parameters)
            && Objects.equals(this.parametersSkipValidatingMissingParameters, other.parametersSkipValidatingMissingParameters)
            && Objects.equals(this.protocol, other.protocol)
            && Objects.equals(this.version, other.version);
    }
}
