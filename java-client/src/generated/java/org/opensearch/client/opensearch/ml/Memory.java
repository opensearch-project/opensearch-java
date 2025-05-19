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

// typedef: ml.Memory

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class Memory implements PlainJsonSerializable, ToCopyableBuilder<Memory.Builder, Memory> {

    @Nonnull
    private final Map<String, JsonData> additionalInfo;

    @Nullable
    private final String createTime;

    @Nullable
    private final String memoryId;

    @Nullable
    private final String name;

    @Nullable
    private final String type;

    @Nullable
    private final String updatedTime;

    @Nullable
    private final String user;

    // ---------------------------------------------------------------------------------------------

    private Memory(Builder builder) {
        this.additionalInfo = ApiTypeHelper.unmodifiable(builder.additionalInfo);
        this.createTime = builder.createTime;
        this.memoryId = builder.memoryId;
        this.name = builder.name;
        this.type = builder.type;
        this.updatedTime = builder.updatedTime;
        this.user = builder.user;
    }

    public static Memory of(Function<Memory.Builder, ObjectBuilder<Memory>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code additional_info}
     */
    @Nonnull
    public final Map<String, JsonData> additionalInfo() {
        return this.additionalInfo;
    }

    /**
     * The create time.
     * <p>
     * API name: {@code create_time}
     * </p>
     */
    @Nullable
    public final String createTime() {
        return this.createTime;
    }

    /**
     * API name: {@code memory_id}
     */
    @Nullable
    public final String memoryId() {
        return this.memoryId;
    }

    /**
     * API name: {@code name}
     */
    @Nullable
    public final String name() {
        return this.name;
    }

    /**
     * API name: {@code type}
     */
    @Nullable
    public final String type() {
        return this.type;
    }

    /**
     * The updated time.
     * <p>
     * API name: {@code updated_time}
     * </p>
     */
    @Nullable
    public final String updatedTime() {
        return this.updatedTime;
    }

    /**
     * The username of the user.
     * <p>
     * API name: {@code user}
     * </p>
     */
    @Nullable
    public final String user() {
        return this.user;
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
        if (ApiTypeHelper.isDefined(this.additionalInfo)) {
            generator.writeKey("additional_info");
            generator.writeStartObject();
            for (Map.Entry<String, JsonData> item0 : this.additionalInfo.entrySet()) {
                generator.writeKey(item0.getKey());
                item0.getValue().serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (this.createTime != null) {
            generator.writeKey("create_time");
            generator.write(this.createTime);
        }

        if (this.memoryId != null) {
            generator.writeKey("memory_id");
            generator.write(this.memoryId);
        }

        if (this.name != null) {
            generator.writeKey("name");
            generator.write(this.name);
        }

        if (this.type != null) {
            generator.writeKey("type");
            generator.write(this.type);
        }

        if (this.updatedTime != null) {
            generator.writeKey("updated_time");
            generator.write(this.updatedTime);
        }

        if (this.user != null) {
            generator.writeKey("user");
            generator.write(this.user);
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
     * Builder for {@link Memory}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, Memory> {
        @Nullable
        private Map<String, JsonData> additionalInfo;
        @Nullable
        private String createTime;
        @Nullable
        private String memoryId;
        @Nullable
        private String name;
        @Nullable
        private String type;
        @Nullable
        private String updatedTime;
        @Nullable
        private String user;

        public Builder() {}

        private Builder(Memory o) {
            this.additionalInfo = _mapCopy(o.additionalInfo);
            this.createTime = o.createTime;
            this.memoryId = o.memoryId;
            this.name = o.name;
            this.type = o.type;
            this.updatedTime = o.updatedTime;
            this.user = o.user;
        }

        private Builder(Builder o) {
            this.additionalInfo = _mapCopy(o.additionalInfo);
            this.createTime = o.createTime;
            this.memoryId = o.memoryId;
            this.name = o.name;
            this.type = o.type;
            this.updatedTime = o.updatedTime;
            this.user = o.user;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code additional_info}
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>additionalInfo</code>.
         * </p>
         */
        @Nonnull
        public final Builder additionalInfo(Map<String, JsonData> map) {
            this.additionalInfo = _mapPutAll(this.additionalInfo, map);
            return this;
        }

        /**
         * API name: {@code additional_info}
         *
         * <p>
         * Adds an entry to <code>additionalInfo</code>.
         * </p>
         */
        @Nonnull
        public final Builder additionalInfo(String key, JsonData value) {
            this.additionalInfo = _mapPut(this.additionalInfo, key, value);
            return this;
        }

        /**
         * The create time.
         * <p>
         * API name: {@code create_time}
         * </p>
         */
        @Nonnull
        public final Builder createTime(@Nullable String value) {
            this.createTime = value;
            return this;
        }

        /**
         * API name: {@code memory_id}
         */
        @Nonnull
        public final Builder memoryId(@Nullable String value) {
            this.memoryId = value;
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
         * API name: {@code type}
         */
        @Nonnull
        public final Builder type(@Nullable String value) {
            this.type = value;
            return this;
        }

        /**
         * The updated time.
         * <p>
         * API name: {@code updated_time}
         * </p>
         */
        @Nonnull
        public final Builder updatedTime(@Nullable String value) {
            this.updatedTime = value;
            return this;
        }

        /**
         * The username of the user.
         * <p>
         * API name: {@code user}
         * </p>
         */
        @Nonnull
        public final Builder user(@Nullable String value) {
            this.user = value;
            return this;
        }

        /**
         * Builds a {@link Memory}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public Memory build() {
            _checkSingleUse();

            return new Memory(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link Memory}
     */
    public static final JsonpDeserializer<Memory> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        Memory::setupMemoryDeserializer
    );

    protected static void setupMemoryDeserializer(ObjectDeserializer<Memory.Builder> op) {
        op.add(Builder::additionalInfo, JsonpDeserializer.stringMapDeserializer(JsonData._DESERIALIZER), "additional_info");
        op.add(Builder::createTime, JsonpDeserializer.stringDeserializer(), "create_time");
        op.add(Builder::memoryId, JsonpDeserializer.stringDeserializer(), "memory_id");
        op.add(Builder::name, JsonpDeserializer.stringDeserializer(), "name");
        op.add(Builder::type, JsonpDeserializer.stringDeserializer(), "type");
        op.add(Builder::updatedTime, JsonpDeserializer.stringDeserializer(), "updated_time");
        op.add(Builder::user, JsonpDeserializer.stringDeserializer(), "user");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.additionalInfo);
        result = 31 * result + Objects.hashCode(this.createTime);
        result = 31 * result + Objects.hashCode(this.memoryId);
        result = 31 * result + Objects.hashCode(this.name);
        result = 31 * result + Objects.hashCode(this.type);
        result = 31 * result + Objects.hashCode(this.updatedTime);
        result = 31 * result + Objects.hashCode(this.user);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Memory other = (Memory) o;
        return Objects.equals(this.additionalInfo, other.additionalInfo)
            && Objects.equals(this.createTime, other.createTime)
            && Objects.equals(this.memoryId, other.memoryId)
            && Objects.equals(this.name, other.name)
            && Objects.equals(this.type, other.type)
            && Objects.equals(this.updatedTime, other.updatedTime)
            && Objects.equals(this.user, other.user);
    }
}
