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
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: ml.Tool

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class Tool implements PlainJsonSerializable, ToCopyableBuilder<Tool.Builder, Tool> {

    @Nullable
    private final String description;

    @Nullable
    private final String name;

    @Nullable
    private final String type;

    @Nullable
    private final String version;

    // ---------------------------------------------------------------------------------------------

    private Tool(Builder builder) {
        this.description = builder.description;
        this.name = builder.name;
        this.type = builder.type;
        this.version = builder.version;
    }

    public static Tool of(Function<Tool.Builder, ObjectBuilder<Tool>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * The tool description.
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
     * The tool type.
     * <p>
     * API name: {@code type}
     * </p>
     */
    @Nullable
    public final String type() {
        return this.type;
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
        if (this.description != null) {
            generator.writeKey("description");
            generator.write(this.description);
        }

        if (this.name != null) {
            generator.writeKey("name");
            generator.write(this.name);
        }

        if (this.type != null) {
            generator.writeKey("type");
            generator.write(this.type);
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
     * Builder for {@link Tool}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, Tool> {
        @Nullable
        private String description;
        @Nullable
        private String name;
        @Nullable
        private String type;
        @Nullable
        private String version;

        public Builder() {}

        private Builder(Tool o) {
            this.description = o.description;
            this.name = o.name;
            this.type = o.type;
            this.version = o.version;
        }

        private Builder(Builder o) {
            this.description = o.description;
            this.name = o.name;
            this.type = o.type;
            this.version = o.version;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * The tool description.
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
         * The tool type.
         * <p>
         * API name: {@code type}
         * </p>
         */
        @Nonnull
        public final Builder type(@Nullable String value) {
            this.type = value;
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
         * Builds a {@link Tool}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public Tool build() {
            _checkSingleUse();

            return new Tool(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link Tool}
     */
    public static final JsonpDeserializer<Tool> _DESERIALIZER = ObjectBuilderDeserializer.lazy(Builder::new, Tool::setupToolDeserializer);

    protected static void setupToolDeserializer(ObjectDeserializer<Tool.Builder> op) {
        op.add(Builder::description, JsonpDeserializer.stringDeserializer(), "description");
        op.add(Builder::name, JsonpDeserializer.stringDeserializer(), "name");
        op.add(Builder::type, JsonpDeserializer.stringDeserializer(), "type");
        op.add(Builder::version, JsonpDeserializer.stringDeserializer(), "version");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.description);
        result = 31 * result + Objects.hashCode(this.name);
        result = 31 * result + Objects.hashCode(this.type);
        result = 31 * result + Objects.hashCode(this.version);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Tool other = (Tool) o;
        return Objects.equals(this.description, other.description)
            && Objects.equals(this.name, other.name)
            && Objects.equals(this.type, other.type)
            && Objects.equals(this.version, other.version);
    }
}
