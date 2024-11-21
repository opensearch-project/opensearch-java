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
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: ml.register_agents.Request

/**
 * Register an agent.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class RegisterAgentsRequest extends RequestBase
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<RegisterAgentsRequest.Builder, RegisterAgentsRequest> {

    @Nullable
    private final String appType;

    @Nullable
    private final String description;

    @Nullable
    private final LLM llm;

    @Nullable
    private final Memory memory;

    @Nonnull
    private final String name;

    @Nonnull
    private final Map<String, JsonData> parameters;

    @Nonnull
    private final List<ToolItems> tools;

    @Nonnull
    private final String type;

    // ---------------------------------------------------------------------------------------------

    private RegisterAgentsRequest(Builder builder) {
        this.appType = builder.appType;
        this.description = builder.description;
        this.llm = builder.llm;
        this.memory = builder.memory;
        this.name = ApiTypeHelper.requireNonNull(builder.name, this, "name");
        this.parameters = ApiTypeHelper.unmodifiable(builder.parameters);
        this.tools = ApiTypeHelper.unmodifiable(builder.tools);
        this.type = ApiTypeHelper.requireNonNull(builder.type, this, "type");
    }

    public static RegisterAgentsRequest of(Function<RegisterAgentsRequest.Builder, ObjectBuilder<RegisterAgentsRequest>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code app_type}
     */
    @Nullable
    public final String appType() {
        return this.appType;
    }

    /**
     * API name: {@code description}
     */
    @Nullable
    public final String description() {
        return this.description;
    }

    /**
     * API name: {@code llm}
     */
    @Nullable
    public final LLM llm() {
        return this.llm;
    }

    /**
     * API name: {@code memory}
     */
    @Nullable
    public final Memory memory() {
        return this.memory;
    }

    /**
     * Required - API name: {@code name}
     */
    @Nonnull
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
     * API name: {@code tools}
     */
    @Nonnull
    public final List<ToolItems> tools() {
        return this.tools;
    }

    /**
     * Required - API name: {@code type}
     */
    @Nonnull
    public final String type() {
        return this.type;
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
        if (this.appType != null) {
            generator.writeKey("app_type");
            generator.write(this.appType);
        }

        if (this.description != null) {
            generator.writeKey("description");
            generator.write(this.description);
        }

        if (this.llm != null) {
            generator.writeKey("llm");
            this.llm.serialize(generator, mapper);
        }

        if (this.memory != null) {
            generator.writeKey("memory");
            this.memory.serialize(generator, mapper);
        }

        generator.writeKey("name");
        generator.write(this.name);

        if (ApiTypeHelper.isDefined(this.parameters)) {
            generator.writeKey("parameters");
            generator.writeStartObject();
            for (Map.Entry<String, JsonData> item0 : this.parameters.entrySet()) {
                generator.writeKey(item0.getKey());
                item0.getValue().serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (ApiTypeHelper.isDefined(this.tools)) {
            generator.writeKey("tools");
            generator.writeStartArray();
            for (ToolItems item0 : this.tools) {
                item0.serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        generator.writeKey("type");
        generator.write(this.type);
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
     * Builder for {@link RegisterAgentsRequest}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, RegisterAgentsRequest> {
        @Nullable
        private String appType;
        @Nullable
        private String description;
        @Nullable
        private LLM llm;
        @Nullable
        private Memory memory;
        private String name;
        @Nullable
        private Map<String, JsonData> parameters;
        @Nullable
        private List<ToolItems> tools;
        private String type;

        public Builder() {}

        private Builder(RegisterAgentsRequest o) {
            this.appType = o.appType;
            this.description = o.description;
            this.llm = o.llm;
            this.memory = o.memory;
            this.name = o.name;
            this.parameters = _mapCopy(o.parameters);
            this.tools = _listCopy(o.tools);
            this.type = o.type;
        }

        private Builder(Builder o) {
            this.appType = o.appType;
            this.description = o.description;
            this.llm = o.llm;
            this.memory = o.memory;
            this.name = o.name;
            this.parameters = _mapCopy(o.parameters);
            this.tools = _listCopy(o.tools);
            this.type = o.type;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code app_type}
         */
        @Nonnull
        public final Builder appType(@Nullable String value) {
            this.appType = value;
            return this;
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
         * API name: {@code llm}
         */
        @Nonnull
        public final Builder llm(@Nullable LLM value) {
            this.llm = value;
            return this;
        }

        /**
         * API name: {@code llm}
         */
        @Nonnull
        public final Builder llm(Function<LLM.Builder, ObjectBuilder<LLM>> fn) {
            return llm(fn.apply(new LLM.Builder()).build());
        }

        /**
         * API name: {@code memory}
         */
        @Nonnull
        public final Builder memory(@Nullable Memory value) {
            this.memory = value;
            return this;
        }

        /**
         * API name: {@code memory}
         */
        @Nonnull
        public final Builder memory(Function<Memory.Builder, ObjectBuilder<Memory>> fn) {
            return memory(fn.apply(new Memory.Builder()).build());
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
         * API name: {@code tools}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>tools</code>.
         * </p>
         */
        @Nonnull
        public final Builder tools(List<ToolItems> list) {
            this.tools = _listAddAll(this.tools, list);
            return this;
        }

        /**
         * API name: {@code tools}
         *
         * <p>
         * Adds one or more values to <code>tools</code>.
         * </p>
         */
        @Nonnull
        public final Builder tools(ToolItems value, ToolItems... values) {
            this.tools = _listAdd(this.tools, value, values);
            return this;
        }

        /**
         * API name: {@code tools}
         *
         * <p>
         * Adds a value to <code>tools</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder tools(Function<ToolItems.Builder, ObjectBuilder<ToolItems>> fn) {
            return tools(fn.apply(new ToolItems.Builder()).build());
        }

        /**
         * Required - API name: {@code type}
         */
        @Nonnull
        public final Builder type(String value) {
            this.type = value;
            return this;
        }

        /**
         * Builds a {@link RegisterAgentsRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public RegisterAgentsRequest build() {
            _checkSingleUse();

            return new RegisterAgentsRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link RegisterAgentsRequest}
     */
    public static final JsonpDeserializer<RegisterAgentsRequest> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        RegisterAgentsRequest::setupRegisterAgentsRequestDeserializer
    );

    protected static void setupRegisterAgentsRequestDeserializer(ObjectDeserializer<RegisterAgentsRequest.Builder> op) {
        op.add(Builder::appType, JsonpDeserializer.stringDeserializer(), "app_type");
        op.add(Builder::description, JsonpDeserializer.stringDeserializer(), "description");
        op.add(Builder::llm, LLM._DESERIALIZER, "llm");
        op.add(Builder::memory, Memory._DESERIALIZER, "memory");
        op.add(Builder::name, JsonpDeserializer.stringDeserializer(), "name");
        op.add(Builder::parameters, JsonpDeserializer.stringMapDeserializer(JsonData._DESERIALIZER), "parameters");
        op.add(Builder::tools, JsonpDeserializer.arrayDeserializer(ToolItems._DESERIALIZER), "tools");
        op.add(Builder::type, JsonpDeserializer.stringDeserializer(), "type");
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Endpoint "{@code ml.register_agents}".
     */
    public static final Endpoint<RegisterAgentsRequest, RegisterAgentsResponse, ErrorResponse> _ENDPOINT = new SimpleEndpoint<>(
        // Request method
        request -> "POST",
        // Request path
        request -> "/_plugins/_ml/agents/_register",
        // Request parameters
        SimpleEndpoint.emptyMap(),
        SimpleEndpoint.emptyMap(),
        true,
        RegisterAgentsResponse._DESERIALIZER
    );

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.appType);
        result = 31 * result + Objects.hashCode(this.description);
        result = 31 * result + Objects.hashCode(this.llm);
        result = 31 * result + Objects.hashCode(this.memory);
        result = 31 * result + this.name.hashCode();
        result = 31 * result + Objects.hashCode(this.parameters);
        result = 31 * result + Objects.hashCode(this.tools);
        result = 31 * result + this.type.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        RegisterAgentsRequest other = (RegisterAgentsRequest) o;
        return Objects.equals(this.appType, other.appType)
            && Objects.equals(this.description, other.description)
            && Objects.equals(this.llm, other.llm)
            && Objects.equals(this.memory, other.memory)
            && this.name.equals(other.name)
            && Objects.equals(this.parameters, other.parameters)
            && Objects.equals(this.tools, other.tools)
            && this.type.equals(other.type);
    }
}
