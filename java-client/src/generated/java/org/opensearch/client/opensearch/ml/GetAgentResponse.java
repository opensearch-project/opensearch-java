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
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: ml.get_agent.Response

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class GetAgentResponse implements PlainJsonSerializable, ToCopyableBuilder<GetAgentResponse.Builder, GetAgentResponse> {

    @Nullable
    private final Long createdTime;

    @Nullable
    private final String description;

    @Nullable
    private final Boolean isHidden;

    @Nullable
    private final Long lastUpdatedTime;

    @Nullable
    private final String name;

    @Nonnull
    private final List<ToolItems> tools;

    @Nullable
    private final AgentType type;

    // ---------------------------------------------------------------------------------------------

    private GetAgentResponse(Builder builder) {
        this.createdTime = builder.createdTime;
        this.description = builder.description;
        this.isHidden = builder.isHidden;
        this.lastUpdatedTime = builder.lastUpdatedTime;
        this.name = builder.name;
        this.tools = ApiTypeHelper.unmodifiable(builder.tools);
        this.type = builder.type;
    }

    public static GetAgentResponse of(Function<GetAgentResponse.Builder, ObjectBuilder<GetAgentResponse>> fn) {
        return fn.apply(new Builder()).build();
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
     * The agent description.
     * <p>
     * API name: {@code description}
     * </p>
     */
    @Nullable
    public final String description() {
        return this.description;
    }

    /**
     * Whether the agent is hidden.
     * <p>
     * API name: {@code is_hidden}
     * </p>
     */
    @Nullable
    public final Boolean isHidden() {
        return this.isHidden;
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
     * API name: {@code tools}
     */
    @Nonnull
    public final List<ToolItems> tools() {
        return this.tools;
    }

    /**
     * API name: {@code type}
     */
    @Nullable
    public final AgentType type() {
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
        if (this.createdTime != null) {
            generator.writeKey("created_time");
            generator.write(this.createdTime);
        }

        if (this.description != null) {
            generator.writeKey("description");
            generator.write(this.description);
        }

        if (this.isHidden != null) {
            generator.writeKey("is_hidden");
            generator.write(this.isHidden);
        }

        if (this.lastUpdatedTime != null) {
            generator.writeKey("last_updated_time");
            generator.write(this.lastUpdatedTime);
        }

        if (this.name != null) {
            generator.writeKey("name");
            generator.write(this.name);
        }

        if (ApiTypeHelper.isDefined(this.tools)) {
            generator.writeKey("tools");
            generator.writeStartArray();
            for (ToolItems item0 : this.tools) {
                item0.serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (this.type != null) {
            generator.writeKey("type");
            this.type.serialize(generator, mapper);
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
     * Builder for {@link GetAgentResponse}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, GetAgentResponse> {
        @Nullable
        private Long createdTime;
        @Nullable
        private String description;
        @Nullable
        private Boolean isHidden;
        @Nullable
        private Long lastUpdatedTime;
        @Nullable
        private String name;
        @Nullable
        private List<ToolItems> tools;
        @Nullable
        private AgentType type;

        public Builder() {}

        private Builder(GetAgentResponse o) {
            this.createdTime = o.createdTime;
            this.description = o.description;
            this.isHidden = o.isHidden;
            this.lastUpdatedTime = o.lastUpdatedTime;
            this.name = o.name;
            this.tools = _listCopy(o.tools);
            this.type = o.type;
        }

        private Builder(Builder o) {
            this.createdTime = o.createdTime;
            this.description = o.description;
            this.isHidden = o.isHidden;
            this.lastUpdatedTime = o.lastUpdatedTime;
            this.name = o.name;
            this.tools = _listCopy(o.tools);
            this.type = o.type;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
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
         * The agent description.
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
         * Whether the agent is hidden.
         * <p>
         * API name: {@code is_hidden}
         * </p>
         */
        @Nonnull
        public final Builder isHidden(@Nullable Boolean value) {
            this.isHidden = value;
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
         * API name: {@code type}
         */
        @Nonnull
        public final Builder type(@Nullable AgentType value) {
            this.type = value;
            return this;
        }

        /**
         * Builds a {@link GetAgentResponse}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public GetAgentResponse build() {
            _checkSingleUse();

            return new GetAgentResponse(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link GetAgentResponse}
     */
    public static final JsonpDeserializer<GetAgentResponse> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        GetAgentResponse::setupGetAgentResponseDeserializer
    );

    protected static void setupGetAgentResponseDeserializer(ObjectDeserializer<GetAgentResponse.Builder> op) {
        op.add(Builder::createdTime, JsonpDeserializer.longDeserializer(), "created_time");
        op.add(Builder::description, JsonpDeserializer.stringDeserializer(), "description");
        op.add(Builder::isHidden, JsonpDeserializer.booleanDeserializer(), "is_hidden");
        op.add(Builder::lastUpdatedTime, JsonpDeserializer.longDeserializer(), "last_updated_time");
        op.add(Builder::name, JsonpDeserializer.stringDeserializer(), "name");
        op.add(Builder::tools, JsonpDeserializer.arrayDeserializer(ToolItems._DESERIALIZER), "tools");
        op.add(Builder::type, AgentType._DESERIALIZER, "type");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.createdTime);
        result = 31 * result + Objects.hashCode(this.description);
        result = 31 * result + Objects.hashCode(this.isHidden);
        result = 31 * result + Objects.hashCode(this.lastUpdatedTime);
        result = 31 * result + Objects.hashCode(this.name);
        result = 31 * result + Objects.hashCode(this.tools);
        result = 31 * result + Objects.hashCode(this.type);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        GetAgentResponse other = (GetAgentResponse) o;
        return Objects.equals(this.createdTime, other.createdTime)
            && Objects.equals(this.description, other.description)
            && Objects.equals(this.isHidden, other.isHidden)
            && Objects.equals(this.lastUpdatedTime, other.lastUpdatedTime)
            && Objects.equals(this.name, other.name)
            && Objects.equals(this.tools, other.tools)
            && Objects.equals(this.type, other.type);
    }
}
