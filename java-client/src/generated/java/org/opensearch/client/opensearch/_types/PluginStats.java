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

package org.opensearch.client.opensearch._types;

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

// typedef: _types.PluginStats

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class PluginStats implements PlainJsonSerializable, ToCopyableBuilder<PluginStats.Builder, PluginStats> {

    @Nonnull
    private final String classname;

    @Nullable
    private final String customFoldername;

    @Nonnull
    private final String description;

    @Nonnull
    private final List<String> extendedPlugins;

    private final boolean hasNativeController;

    @Nonnull
    private final String javaVersion;

    @Nullable
    private final Boolean licensed;

    @Nonnull
    private final String name;

    @Nonnull
    private final String opensearchVersion;

    @Nonnull
    private final String version;

    // ---------------------------------------------------------------------------------------------

    private PluginStats(Builder builder) {
        this.classname = ApiTypeHelper.requireNonNull(builder.classname, this, "classname");
        this.customFoldername = builder.customFoldername;
        this.description = ApiTypeHelper.requireNonNull(builder.description, this, "description");
        this.extendedPlugins = ApiTypeHelper.unmodifiableRequired(builder.extendedPlugins, this, "extendedPlugins");
        this.hasNativeController = ApiTypeHelper.requireNonNull(builder.hasNativeController, this, "hasNativeController");
        this.javaVersion = ApiTypeHelper.requireNonNull(builder.javaVersion, this, "javaVersion");
        this.licensed = builder.licensed;
        this.name = ApiTypeHelper.requireNonNull(builder.name, this, "name");
        this.opensearchVersion = ApiTypeHelper.requireNonNull(builder.opensearchVersion, this, "opensearchVersion");
        this.version = ApiTypeHelper.requireNonNull(builder.version, this, "version");
    }

    public static PluginStats of(Function<PluginStats.Builder, ObjectBuilder<PluginStats>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code classname}
     */
    @Nonnull
    public final String classname() {
        return this.classname;
    }

    /**
     * API name: {@code custom_foldername}
     */
    @Nullable
    public final String customFoldername() {
        return this.customFoldername;
    }

    /**
     * Required - API name: {@code description}
     */
    @Nonnull
    public final String description() {
        return this.description;
    }

    /**
     * Required - API name: {@code extended_plugins}
     */
    @Nonnull
    public final List<String> extendedPlugins() {
        return this.extendedPlugins;
    }

    /**
     * Required - API name: {@code has_native_controller}
     */
    public final boolean hasNativeController() {
        return this.hasNativeController;
    }

    /**
     * Required - API name: {@code java_version}
     */
    @Nonnull
    public final String javaVersion() {
        return this.javaVersion;
    }

    /**
     * API name: {@code licensed}
     */
    @Nullable
    public final Boolean licensed() {
        return this.licensed;
    }

    /**
     * Required - API name: {@code name}
     */
    @Nonnull
    public final String name() {
        return this.name;
    }

    /**
     * Required - API name: {@code opensearch_version}
     */
    @Nonnull
    public final String opensearchVersion() {
        return this.opensearchVersion;
    }

    /**
     * Required - API name: {@code version}
     */
    @Nonnull
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
        generator.writeKey("classname");
        generator.write(this.classname);

        if (this.customFoldername != null) {
            generator.writeKey("custom_foldername");
            generator.write(this.customFoldername);
        }

        generator.writeKey("description");
        generator.write(this.description);

        generator.writeKey("extended_plugins");
        generator.writeStartArray();
        for (String item0 : this.extendedPlugins) {
            generator.write(item0);
        }
        generator.writeEnd();

        generator.writeKey("has_native_controller");
        generator.write(this.hasNativeController);

        generator.writeKey("java_version");
        generator.write(this.javaVersion);

        if (this.licensed != null) {
            generator.writeKey("licensed");
            generator.write(this.licensed);
        }

        generator.writeKey("name");
        generator.write(this.name);

        generator.writeKey("opensearch_version");
        generator.write(this.opensearchVersion);

        generator.writeKey("version");
        generator.write(this.version);
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
     * Builder for {@link PluginStats}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, PluginStats> {
        private String classname;
        @Nullable
        private String customFoldername;
        private String description;
        private List<String> extendedPlugins;
        private Boolean hasNativeController;
        private String javaVersion;
        @Nullable
        private Boolean licensed;
        private String name;
        private String opensearchVersion;
        private String version;

        public Builder() {}

        private Builder(PluginStats o) {
            this.classname = o.classname;
            this.customFoldername = o.customFoldername;
            this.description = o.description;
            this.extendedPlugins = _listCopy(o.extendedPlugins);
            this.hasNativeController = o.hasNativeController;
            this.javaVersion = o.javaVersion;
            this.licensed = o.licensed;
            this.name = o.name;
            this.opensearchVersion = o.opensearchVersion;
            this.version = o.version;
        }

        private Builder(Builder o) {
            this.classname = o.classname;
            this.customFoldername = o.customFoldername;
            this.description = o.description;
            this.extendedPlugins = _listCopy(o.extendedPlugins);
            this.hasNativeController = o.hasNativeController;
            this.javaVersion = o.javaVersion;
            this.licensed = o.licensed;
            this.name = o.name;
            this.opensearchVersion = o.opensearchVersion;
            this.version = o.version;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - API name: {@code classname}
         */
        @Nonnull
        public final Builder classname(String value) {
            this.classname = value;
            return this;
        }

        /**
         * API name: {@code custom_foldername}
         */
        @Nonnull
        public final Builder customFoldername(@Nullable String value) {
            this.customFoldername = value;
            return this;
        }

        /**
         * Required - API name: {@code description}
         */
        @Nonnull
        public final Builder description(String value) {
            this.description = value;
            return this;
        }

        /**
         * Required - API name: {@code extended_plugins}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>extendedPlugins</code>.
         * </p>
         */
        @Nonnull
        public final Builder extendedPlugins(List<String> list) {
            this.extendedPlugins = _listAddAll(this.extendedPlugins, list);
            return this;
        }

        /**
         * Required - API name: {@code extended_plugins}
         *
         * <p>
         * Adds one or more values to <code>extendedPlugins</code>.
         * </p>
         */
        @Nonnull
        public final Builder extendedPlugins(String value, String... values) {
            this.extendedPlugins = _listAdd(this.extendedPlugins, value, values);
            return this;
        }

        /**
         * Required - API name: {@code has_native_controller}
         */
        @Nonnull
        public final Builder hasNativeController(boolean value) {
            this.hasNativeController = value;
            return this;
        }

        /**
         * Required - API name: {@code java_version}
         */
        @Nonnull
        public final Builder javaVersion(String value) {
            this.javaVersion = value;
            return this;
        }

        /**
         * API name: {@code licensed}
         */
        @Nonnull
        public final Builder licensed(@Nullable Boolean value) {
            this.licensed = value;
            return this;
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
         * Required - API name: {@code opensearch_version}
         */
        @Nonnull
        public final Builder opensearchVersion(String value) {
            this.opensearchVersion = value;
            return this;
        }

        /**
         * Required - API name: {@code version}
         */
        @Nonnull
        public final Builder version(String value) {
            this.version = value;
            return this;
        }

        /**
         * Builds a {@link PluginStats}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public PluginStats build() {
            _checkSingleUse();

            return new PluginStats(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link PluginStats}
     */
    public static final JsonpDeserializer<PluginStats> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        PluginStats::setupPluginStatsDeserializer
    );

    protected static void setupPluginStatsDeserializer(ObjectDeserializer<PluginStats.Builder> op) {
        op.add(Builder::classname, JsonpDeserializer.stringDeserializer(), "classname");
        op.add(Builder::customFoldername, JsonpDeserializer.stringDeserializer(), "custom_foldername");
        op.add(Builder::description, JsonpDeserializer.stringDeserializer(), "description");
        op.add(Builder::extendedPlugins, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "extended_plugins");
        op.add(Builder::hasNativeController, JsonpDeserializer.booleanDeserializer(), "has_native_controller");
        op.add(Builder::javaVersion, JsonpDeserializer.stringDeserializer(), "java_version");
        op.add(Builder::licensed, JsonpDeserializer.booleanDeserializer(), "licensed");
        op.add(Builder::name, JsonpDeserializer.stringDeserializer(), "name");
        op.add(Builder::opensearchVersion, JsonpDeserializer.stringDeserializer(), "opensearch_version");
        op.add(Builder::version, JsonpDeserializer.stringDeserializer(), "version");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.classname.hashCode();
        result = 31 * result + Objects.hashCode(this.customFoldername);
        result = 31 * result + this.description.hashCode();
        result = 31 * result + this.extendedPlugins.hashCode();
        result = 31 * result + Boolean.hashCode(this.hasNativeController);
        result = 31 * result + this.javaVersion.hashCode();
        result = 31 * result + Objects.hashCode(this.licensed);
        result = 31 * result + this.name.hashCode();
        result = 31 * result + this.opensearchVersion.hashCode();
        result = 31 * result + this.version.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        PluginStats other = (PluginStats) o;
        return this.classname.equals(other.classname)
            && Objects.equals(this.customFoldername, other.customFoldername)
            && this.description.equals(other.description)
            && this.extendedPlugins.equals(other.extendedPlugins)
            && this.hasNativeController == other.hasNativeController
            && this.javaVersion.equals(other.javaVersion)
            && Objects.equals(this.licensed, other.licensed)
            && this.name.equals(other.name)
            && this.opensearchVersion.equals(other.opensearchVersion)
            && this.version.equals(other.version);
    }
}
