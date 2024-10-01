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
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import javax.annotation.Generated;
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
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;

// typedef: ml.create_connector.Request

/**
 * Creates a standalone connector.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class CreateConnectorRequest extends RequestBase implements PlainJsonSerializable {

    private final List<Action> actions;

    @Nullable
    private final ClientConfig clientConfig;

    private final Credential credential;

    private final String description;

    private final String name;

    private final Map<String, JsonData> parameters;

    private final String protocol;

    private final int version;

    // ---------------------------------------------------------------------------------------------

    private CreateConnectorRequest(Builder builder) {
        this.actions = ApiTypeHelper.unmodifiableRequired(builder.actions, this, "actions");
        this.clientConfig = builder.clientConfig;
        this.credential = ApiTypeHelper.requireNonNull(builder.credential, this, "credential");
        this.description = ApiTypeHelper.requireNonNull(builder.description, this, "description");
        this.name = ApiTypeHelper.requireNonNull(builder.name, this, "name");
        this.parameters = ApiTypeHelper.unmodifiableRequired(builder.parameters, this, "parameters");
        this.protocol = ApiTypeHelper.requireNonNull(builder.protocol, this, "protocol");
        this.version = ApiTypeHelper.requireNonNull(builder.version, this, "version");
    }

    public static CreateConnectorRequest of(Function<CreateConnectorRequest.Builder, ObjectBuilder<CreateConnectorRequest>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code actions}
     */
    public final List<Action> actions() {
        return this.actions;
    }

    /**
     * API name: {@code client_config}
     */
    @Nullable
    public final ClientConfig clientConfig() {
        return this.clientConfig;
    }

    /**
     * Required - API name: {@code credential}
     */
    public final Credential credential() {
        return this.credential;
    }

    /**
     * Required - API name: {@code description}
     */
    public final String description() {
        return this.description;
    }

    /**
     * Required - API name: {@code name}
     */
    public final String name() {
        return this.name;
    }

    /**
     * Required - API name: {@code parameters}
     */
    public final Map<String, JsonData> parameters() {
        return this.parameters;
    }

    /**
     * Required - API name: {@code protocol}
     */
    public final String protocol() {
        return this.protocol;
    }

    /**
     * Required - API name: {@code version}
     */
    public final int version() {
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
        generator.writeKey("actions");
        generator.writeStartArray();
        for (Action item0 : this.actions) {
            item0.serialize(generator, mapper);
        }
        generator.writeEnd();

        if (this.clientConfig != null) {
            generator.writeKey("client_config");
            this.clientConfig.serialize(generator, mapper);
        }

        generator.writeKey("credential");
        this.credential.serialize(generator, mapper);

        generator.writeKey("description");
        generator.write(this.description);

        generator.writeKey("name");
        generator.write(this.name);

        generator.writeKey("parameters");
        generator.writeStartObject();
        for (Map.Entry<String, JsonData> item0 : this.parameters.entrySet()) {
            generator.writeKey(item0.getKey());
            item0.getValue().serialize(generator, mapper);
        }
        generator.writeEnd();

        generator.writeKey("protocol");
        generator.write(this.protocol);

        generator.writeKey("version");
        generator.write(this.version);
    }
    // ---------------------------------------------------------------------------------------------

    /**
     * Builder for {@link CreateConnectorRequest}.
     */
    public static class Builder extends ObjectBuilderBase implements ObjectBuilder<CreateConnectorRequest> {
        private List<Action> actions;
        @Nullable
        private ClientConfig clientConfig;
        private Credential credential;
        private String description;
        private String name;
        private Map<String, JsonData> parameters;
        private String protocol;
        private Integer version;

        /**
         * Required - API name: {@code actions}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>actions</code>.
         * </p>
         */
        public final Builder actions(List<Action> list) {
            this.actions = _listAddAll(this.actions, list);
            return this;
        }

        /**
         * Required - API name: {@code actions}
         *
         * <p>
         * Adds one or more values to <code>actions</code>.
         * </p>
         */
        public final Builder actions(Action value, Action... values) {
            this.actions = _listAdd(this.actions, value, values);
            return this;
        }

        /**
         * Required - API name: {@code actions}
         *
         * <p>
         * Adds a value to <code>actions</code> using a builder lambda.
         * </p>
         */
        public final Builder actions(Function<Action.Builder, ObjectBuilder<Action>> fn) {
            return actions(fn.apply(new Action.Builder()).build());
        }

        /**
         * API name: {@code client_config}
         */
        public final Builder clientConfig(@Nullable ClientConfig value) {
            this.clientConfig = value;
            return this;
        }

        /**
         * API name: {@code client_config}
         */
        public final Builder clientConfig(Function<ClientConfig.Builder, ObjectBuilder<ClientConfig>> fn) {
            return clientConfig(fn.apply(new ClientConfig.Builder()).build());
        }

        /**
         * Required - API name: {@code credential}
         */
        public final Builder credential(Credential value) {
            this.credential = value;
            return this;
        }

        /**
         * Required - API name: {@code credential}
         */
        public final Builder credential(Function<Credential.Builder, ObjectBuilder<Credential>> fn) {
            return credential(fn.apply(new Credential.Builder()).build());
        }

        /**
         * Required - API name: {@code description}
         */
        public final Builder description(String value) {
            this.description = value;
            return this;
        }

        /**
         * Required - API name: {@code name}
         */
        public final Builder name(String value) {
            this.name = value;
            return this;
        }

        /**
         * Required - API name: {@code parameters}
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>parameters</code>.
         * </p>
         */
        public final Builder parameters(Map<String, JsonData> map) {
            this.parameters = _mapPutAll(this.parameters, map);
            return this;
        }

        /**
         * Required - API name: {@code parameters}
         *
         * <p>
         * Adds an entry to <code>parameters</code>.
         * </p>
         */
        public final Builder parameters(String key, JsonData value) {
            this.parameters = _mapPut(this.parameters, key, value);
            return this;
        }

        /**
         * Required - API name: {@code protocol}
         */
        public final Builder protocol(String value) {
            this.protocol = value;
            return this;
        }

        /**
         * Required - API name: {@code version}
         */
        public final Builder version(int value) {
            this.version = value;
            return this;
        }

        /**
         * Builds a {@link CreateConnectorRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        public CreateConnectorRequest build() {
            _checkSingleUse();

            return new CreateConnectorRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link CreateConnectorRequest}
     */
    public static final JsonpDeserializer<CreateConnectorRequest> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        CreateConnectorRequest::setupCreateConnectorRequestDeserializer
    );

    protected static void setupCreateConnectorRequestDeserializer(ObjectDeserializer<CreateConnectorRequest.Builder> op) {
        op.add(Builder::actions, JsonpDeserializer.arrayDeserializer(Action._DESERIALIZER), "actions");
        op.add(Builder::clientConfig, ClientConfig._DESERIALIZER, "client_config");
        op.add(Builder::credential, Credential._DESERIALIZER, "credential");
        op.add(Builder::description, JsonpDeserializer.stringDeserializer(), "description");
        op.add(Builder::name, JsonpDeserializer.stringDeserializer(), "name");
        op.add(Builder::parameters, JsonpDeserializer.stringMapDeserializer(JsonData._DESERIALIZER), "parameters");
        op.add(Builder::protocol, JsonpDeserializer.stringDeserializer(), "protocol");
        op.add(Builder::version, JsonpDeserializer.integerDeserializer(), "version");
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Endpoint "{@code ml.create_connector}".
     */
    public static final Endpoint<CreateConnectorRequest, CreateConnectorResponse, ErrorResponse> _ENDPOINT = new SimpleEndpoint<>(
        // Request method
        request -> "POST",
        // Request path
        request -> "/_plugins/_ml/connectors/_create",
        // Request parameters
        SimpleEndpoint.emptyMap(),
        SimpleEndpoint.emptyMap(),
        true,
        CreateConnectorResponse._DESERIALIZER
    );

    public int hashCode() {
        int result = 17;
        result = 31 * result + this.actions.hashCode();
        result = 31 * result + Objects.hashCode(this.clientConfig);
        result = 31 * result + this.credential.hashCode();
        result = 31 * result + this.description.hashCode();
        result = 31 * result + this.name.hashCode();
        result = 31 * result + this.parameters.hashCode();
        result = 31 * result + this.protocol.hashCode();
        result = 31 * result + Integer.hashCode(this.version);
        return result;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (this.getClass() != o.getClass()) return false;
        CreateConnectorRequest other = (CreateConnectorRequest) o;
        return Objects.equals(this.actions, other.actions)
            && Objects.equals(this.clientConfig, other.clientConfig)
            && Objects.equals(this.credential, other.credential)
            && Objects.equals(this.description, other.description)
            && Objects.equals(this.name, other.name)
            && Objects.equals(this.parameters, other.parameters)
            && Objects.equals(this.protocol, other.protocol)
            && this.version() == other.version();
    }
}
