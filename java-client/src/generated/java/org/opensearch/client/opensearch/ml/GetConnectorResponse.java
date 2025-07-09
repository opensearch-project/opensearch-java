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
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: ml.get_connector.Response

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class GetConnectorResponse implements PlainJsonSerializable, ToCopyableBuilder<GetConnectorResponse.Builder, GetConnectorResponse> {

    @Nonnull
    private final List<Action> actions;

    @Nullable
    private final Long createdTime;

    @Nullable
    private final String description;

    @Nullable
    private final Long lastUpdatedTime;

    @Nullable
    private final String name;

    @Nonnull
    private final Map<String, JsonData> parameters;

    @Nullable
    private final String protocol;

    @Nullable
    private final String version;

    // ---------------------------------------------------------------------------------------------

    private GetConnectorResponse(Builder builder) {
        this.actions = ApiTypeHelper.unmodifiable(builder.actions);
        this.createdTime = builder.createdTime;
        this.description = builder.description;
        this.lastUpdatedTime = builder.lastUpdatedTime;
        this.name = builder.name;
        this.parameters = ApiTypeHelper.unmodifiable(builder.parameters);
        this.protocol = builder.protocol;
        this.version = builder.version;
    }

    public static GetConnectorResponse of(Function<GetConnectorResponse.Builder, ObjectBuilder<GetConnectorResponse>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code actions}
     */
    @Nonnull
    public final List<Action> actions() {
        return this.actions;
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
     * API name: {@code parameters}
     */
    @Nonnull
    public final Map<String, JsonData> parameters() {
        return this.parameters;
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
    public final String version() {
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
        if (ApiTypeHelper.isDefined(this.actions)) {
            generator.writeKey("actions");
            generator.writeStartArray();
            for (Action item0 : this.actions) {
                item0.serialize(generator, mapper);
            }
            generator.writeEnd();
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

        if (ApiTypeHelper.isDefined(this.parameters)) {
            generator.writeKey("parameters");
            generator.writeStartObject();
            for (Map.Entry<String, JsonData> item0 : this.parameters.entrySet()) {
                generator.writeKey(item0.getKey());
                item0.getValue().serialize(generator, mapper);
            }
            generator.writeEnd();
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
     * Builder for {@link GetConnectorResponse}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, GetConnectorResponse> {
        @Nullable
        private List<Action> actions;
        @Nullable
        private Long createdTime;
        @Nullable
        private String description;
        @Nullable
        private Long lastUpdatedTime;
        @Nullable
        private String name;
        @Nullable
        private Map<String, JsonData> parameters;
        @Nullable
        private String protocol;
        @Nullable
        private String version;

        public Builder() {}

        private Builder(GetConnectorResponse o) {
            this.actions = _listCopy(o.actions);
            this.createdTime = o.createdTime;
            this.description = o.description;
            this.lastUpdatedTime = o.lastUpdatedTime;
            this.name = o.name;
            this.parameters = _mapCopy(o.parameters);
            this.protocol = o.protocol;
            this.version = o.version;
        }

        private Builder(Builder o) {
            this.actions = _listCopy(o.actions);
            this.createdTime = o.createdTime;
            this.description = o.description;
            this.lastUpdatedTime = o.lastUpdatedTime;
            this.name = o.name;
            this.parameters = _mapCopy(o.parameters);
            this.protocol = o.protocol;
            this.version = o.version;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
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
        public final Builder version(@Nullable String value) {
            this.version = value;
            return this;
        }

        /**
         * Builds a {@link GetConnectorResponse}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public GetConnectorResponse build() {
            _checkSingleUse();

            return new GetConnectorResponse(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link GetConnectorResponse}
     */
    public static final JsonpDeserializer<GetConnectorResponse> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        GetConnectorResponse::setupGetConnectorResponseDeserializer
    );

    protected static void setupGetConnectorResponseDeserializer(ObjectDeserializer<GetConnectorResponse.Builder> op) {
        op.add(Builder::actions, JsonpDeserializer.arrayDeserializer(Action._DESERIALIZER), "actions");
        op.add(Builder::createdTime, JsonpDeserializer.longDeserializer(), "created_time");
        op.add(Builder::description, JsonpDeserializer.stringDeserializer(), "description");
        op.add(Builder::lastUpdatedTime, JsonpDeserializer.longDeserializer(), "last_updated_time");
        op.add(Builder::name, JsonpDeserializer.stringDeserializer(), "name");
        op.add(Builder::parameters, JsonpDeserializer.stringMapDeserializer(JsonData._DESERIALIZER), "parameters");
        op.add(Builder::protocol, JsonpDeserializer.stringDeserializer(), "protocol");
        op.add(Builder::version, JsonpDeserializer.stringDeserializer(), "version");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.actions);
        result = 31 * result + Objects.hashCode(this.createdTime);
        result = 31 * result + Objects.hashCode(this.description);
        result = 31 * result + Objects.hashCode(this.lastUpdatedTime);
        result = 31 * result + Objects.hashCode(this.name);
        result = 31 * result + Objects.hashCode(this.parameters);
        result = 31 * result + Objects.hashCode(this.protocol);
        result = 31 * result + Objects.hashCode(this.version);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        GetConnectorResponse other = (GetConnectorResponse) o;
        return Objects.equals(this.actions, other.actions)
            && Objects.equals(this.createdTime, other.createdTime)
            && Objects.equals(this.description, other.description)
            && Objects.equals(this.lastUpdatedTime, other.lastUpdatedTime)
            && Objects.equals(this.name, other.name)
            && Objects.equals(this.parameters, other.parameters)
            && Objects.equals(this.protocol, other.protocol)
            && Objects.equals(this.version, other.version);
    }
}
