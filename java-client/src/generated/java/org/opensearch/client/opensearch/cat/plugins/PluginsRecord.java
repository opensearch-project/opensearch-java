/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

/*
 * Licensed to Elasticsearch B.V. under one or more contributor
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
 * ownership. Elasticsearch B.V. licenses this file to you under
 * the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

/*
 * Modifications Copyright OpenSearch Contributors. See
 * GitHub history for details.
 */

//----------------------------------------------------
// THIS CODE IS GENERATED. MANUAL EDITS WILL BE LOST.
//----------------------------------------------------

package org.opensearch.client.opensearch.cat.plugins;

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

// typedef: cat.plugins.PluginsRecord

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class PluginsRecord implements PlainJsonSerializable, ToCopyableBuilder<PluginsRecord.Builder, PluginsRecord> {

    @Nullable
    private final String component;

    @Nullable
    private final String description;

    @Nullable
    private final String id;

    @Nullable
    private final String name;

    @Nullable
    private final String type;

    @Nullable
    private final String version;

    // ---------------------------------------------------------------------------------------------

    private PluginsRecord(Builder builder) {
        this.component = builder.component;
        this.description = builder.description;
        this.id = builder.id;
        this.name = builder.name;
        this.type = builder.type;
        this.version = builder.version;
    }

    public static PluginsRecord of(Function<PluginsRecord.Builder, ObjectBuilder<PluginsRecord>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * The component name.
     * <p>
     * API name: {@code component}
     * </p>
     */
    @Nullable
    public final String component() {
        return this.component;
    }

    /**
     * The plugin details.
     * <p>
     * API name: {@code description}
     * </p>
     */
    @Nullable
    public final String description() {
        return this.description;
    }

    /**
     * API name: {@code id}
     */
    @Nullable
    public final String id() {
        return this.id;
    }

    /**
     * API name: {@code name}
     */
    @Nullable
    public final String name() {
        return this.name;
    }

    /**
     * The plugin type.
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
        if (this.component != null) {
            generator.writeKey("component");
            generator.write(this.component);
        }

        if (this.description != null) {
            generator.writeKey("description");
            generator.write(this.description);
        }

        if (this.id != null) {
            generator.writeKey("id");
            generator.write(this.id);
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
     * Builder for {@link PluginsRecord}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, PluginsRecord> {
        @Nullable
        private String component;
        @Nullable
        private String description;
        @Nullable
        private String id;
        @Nullable
        private String name;
        @Nullable
        private String type;
        @Nullable
        private String version;

        public Builder() {}

        private Builder(PluginsRecord o) {
            this.component = o.component;
            this.description = o.description;
            this.id = o.id;
            this.name = o.name;
            this.type = o.type;
            this.version = o.version;
        }

        private Builder(Builder o) {
            this.component = o.component;
            this.description = o.description;
            this.id = o.id;
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
         * The component name.
         * <p>
         * API name: {@code component}
         * </p>
         */
        @Nonnull
        public final Builder component(@Nullable String value) {
            this.component = value;
            return this;
        }

        /**
         * The plugin details.
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
         * API name: {@code id}
         */
        @Nonnull
        public final Builder id(@Nullable String value) {
            this.id = value;
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
         * The plugin type.
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
         * Builds a {@link PluginsRecord}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public PluginsRecord build() {
            _checkSingleUse();

            return new PluginsRecord(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link PluginsRecord}
     */
    public static final JsonpDeserializer<PluginsRecord> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        PluginsRecord::setupPluginsRecordDeserializer
    );

    protected static void setupPluginsRecordDeserializer(ObjectDeserializer<PluginsRecord.Builder> op) {
        op.add(Builder::component, JsonpDeserializer.stringDeserializer(), "component");
        op.add(Builder::description, JsonpDeserializer.stringDeserializer(), "description");
        op.add(Builder::id, JsonpDeserializer.stringDeserializer(), "id");
        op.add(Builder::name, JsonpDeserializer.stringDeserializer(), "name");
        op.add(Builder::type, JsonpDeserializer.stringDeserializer(), "type");
        op.add(Builder::version, JsonpDeserializer.stringDeserializer(), "version");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.component);
        result = 31 * result + Objects.hashCode(this.description);
        result = 31 * result + Objects.hashCode(this.id);
        result = 31 * result + Objects.hashCode(this.name);
        result = 31 * result + Objects.hashCode(this.type);
        result = 31 * result + Objects.hashCode(this.version);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        PluginsRecord other = (PluginsRecord) o;
        return Objects.equals(this.component, other.component)
            && Objects.equals(this.description, other.description)
            && Objects.equals(this.id, other.id)
            && Objects.equals(this.name, other.name)
            && Objects.equals(this.type, other.type)
            && Objects.equals(this.version, other.version);
    }
}
