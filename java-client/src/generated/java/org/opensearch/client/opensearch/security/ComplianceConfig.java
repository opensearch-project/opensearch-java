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

package org.opensearch.client.opensearch.security;

import jakarta.json.stream.JsonGenerator;
import java.util.List;
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

// typedef: security.ComplianceConfig

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class ComplianceConfig implements PlainJsonSerializable, ToCopyableBuilder<ComplianceConfig.Builder, ComplianceConfig> {

    @Nullable
    private final Boolean enabled;

    @Nullable
    private final Boolean externalConfig;

    @Nullable
    private final Boolean internalConfig;

    @Nonnull
    private final List<String> readIgnoreUsers;

    @Nullable
    private final Boolean readMetadataOnly;

    @Nullable
    private final JsonData readWatchedFields;

    @Nonnull
    private final List<String> writeIgnoreUsers;

    @Nullable
    private final Boolean writeLogDiffs;

    @Nullable
    private final Boolean writeMetadataOnly;

    @Nonnull
    private final List<String> writeWatchedIndices;

    // ---------------------------------------------------------------------------------------------

    private ComplianceConfig(Builder builder) {
        this.enabled = builder.enabled;
        this.externalConfig = builder.externalConfig;
        this.internalConfig = builder.internalConfig;
        this.readIgnoreUsers = ApiTypeHelper.unmodifiable(builder.readIgnoreUsers);
        this.readMetadataOnly = builder.readMetadataOnly;
        this.readWatchedFields = builder.readWatchedFields;
        this.writeIgnoreUsers = ApiTypeHelper.unmodifiable(builder.writeIgnoreUsers);
        this.writeLogDiffs = builder.writeLogDiffs;
        this.writeMetadataOnly = builder.writeMetadataOnly;
        this.writeWatchedIndices = ApiTypeHelper.unmodifiable(builder.writeWatchedIndices);
    }

    public static ComplianceConfig of(Function<ComplianceConfig.Builder, ObjectBuilder<ComplianceConfig>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code enabled}
     */
    @Nullable
    public final Boolean enabled() {
        return this.enabled;
    }

    /**
     * API name: {@code external_config}
     */
    @Nullable
    public final Boolean externalConfig() {
        return this.externalConfig;
    }

    /**
     * API name: {@code internal_config}
     */
    @Nullable
    public final Boolean internalConfig() {
        return this.internalConfig;
    }

    /**
     * API name: {@code read_ignore_users}
     */
    @Nonnull
    public final List<String> readIgnoreUsers() {
        return this.readIgnoreUsers;
    }

    /**
     * API name: {@code read_metadata_only}
     */
    @Nullable
    public final Boolean readMetadataOnly() {
        return this.readMetadataOnly;
    }

    /**
     * API name: {@code read_watched_fields}
     */
    @Nullable
    public final JsonData readWatchedFields() {
        return this.readWatchedFields;
    }

    /**
     * API name: {@code write_ignore_users}
     */
    @Nonnull
    public final List<String> writeIgnoreUsers() {
        return this.writeIgnoreUsers;
    }

    /**
     * API name: {@code write_log_diffs}
     */
    @Nullable
    public final Boolean writeLogDiffs() {
        return this.writeLogDiffs;
    }

    /**
     * API name: {@code write_metadata_only}
     */
    @Nullable
    public final Boolean writeMetadataOnly() {
        return this.writeMetadataOnly;
    }

    /**
     * API name: {@code write_watched_indices}
     */
    @Nonnull
    public final List<String> writeWatchedIndices() {
        return this.writeWatchedIndices;
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
        if (this.enabled != null) {
            generator.writeKey("enabled");
            generator.write(this.enabled);
        }

        if (this.externalConfig != null) {
            generator.writeKey("external_config");
            generator.write(this.externalConfig);
        }

        if (this.internalConfig != null) {
            generator.writeKey("internal_config");
            generator.write(this.internalConfig);
        }

        if (ApiTypeHelper.isDefined(this.readIgnoreUsers)) {
            generator.writeKey("read_ignore_users");
            generator.writeStartArray();
            for (String item0 : this.readIgnoreUsers) {
                generator.write(item0);
            }
            generator.writeEnd();
        }

        if (this.readMetadataOnly != null) {
            generator.writeKey("read_metadata_only");
            generator.write(this.readMetadataOnly);
        }

        if (this.readWatchedFields != null) {
            generator.writeKey("read_watched_fields");
            this.readWatchedFields.serialize(generator, mapper);
        }

        if (ApiTypeHelper.isDefined(this.writeIgnoreUsers)) {
            generator.writeKey("write_ignore_users");
            generator.writeStartArray();
            for (String item0 : this.writeIgnoreUsers) {
                generator.write(item0);
            }
            generator.writeEnd();
        }

        if (this.writeLogDiffs != null) {
            generator.writeKey("write_log_diffs");
            generator.write(this.writeLogDiffs);
        }

        if (this.writeMetadataOnly != null) {
            generator.writeKey("write_metadata_only");
            generator.write(this.writeMetadataOnly);
        }

        if (ApiTypeHelper.isDefined(this.writeWatchedIndices)) {
            generator.writeKey("write_watched_indices");
            generator.writeStartArray();
            for (String item0 : this.writeWatchedIndices) {
                generator.write(item0);
            }
            generator.writeEnd();
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
     * Builder for {@link ComplianceConfig}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, ComplianceConfig> {
        @Nullable
        private Boolean enabled;
        @Nullable
        private Boolean externalConfig;
        @Nullable
        private Boolean internalConfig;
        @Nullable
        private List<String> readIgnoreUsers;
        @Nullable
        private Boolean readMetadataOnly;
        @Nullable
        private JsonData readWatchedFields;
        @Nullable
        private List<String> writeIgnoreUsers;
        @Nullable
        private Boolean writeLogDiffs;
        @Nullable
        private Boolean writeMetadataOnly;
        @Nullable
        private List<String> writeWatchedIndices;

        public Builder() {}

        private Builder(ComplianceConfig o) {
            this.enabled = o.enabled;
            this.externalConfig = o.externalConfig;
            this.internalConfig = o.internalConfig;
            this.readIgnoreUsers = _listCopy(o.readIgnoreUsers);
            this.readMetadataOnly = o.readMetadataOnly;
            this.readWatchedFields = o.readWatchedFields;
            this.writeIgnoreUsers = _listCopy(o.writeIgnoreUsers);
            this.writeLogDiffs = o.writeLogDiffs;
            this.writeMetadataOnly = o.writeMetadataOnly;
            this.writeWatchedIndices = _listCopy(o.writeWatchedIndices);
        }

        private Builder(Builder o) {
            this.enabled = o.enabled;
            this.externalConfig = o.externalConfig;
            this.internalConfig = o.internalConfig;
            this.readIgnoreUsers = _listCopy(o.readIgnoreUsers);
            this.readMetadataOnly = o.readMetadataOnly;
            this.readWatchedFields = o.readWatchedFields;
            this.writeIgnoreUsers = _listCopy(o.writeIgnoreUsers);
            this.writeLogDiffs = o.writeLogDiffs;
            this.writeMetadataOnly = o.writeMetadataOnly;
            this.writeWatchedIndices = _listCopy(o.writeWatchedIndices);
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code enabled}
         */
        @Nonnull
        public final Builder enabled(@Nullable Boolean value) {
            this.enabled = value;
            return this;
        }

        /**
         * API name: {@code external_config}
         */
        @Nonnull
        public final Builder externalConfig(@Nullable Boolean value) {
            this.externalConfig = value;
            return this;
        }

        /**
         * API name: {@code internal_config}
         */
        @Nonnull
        public final Builder internalConfig(@Nullable Boolean value) {
            this.internalConfig = value;
            return this;
        }

        /**
         * API name: {@code read_ignore_users}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>readIgnoreUsers</code>.
         * </p>
         */
        @Nonnull
        public final Builder readIgnoreUsers(List<String> list) {
            this.readIgnoreUsers = _listAddAll(this.readIgnoreUsers, list);
            return this;
        }

        /**
         * API name: {@code read_ignore_users}
         *
         * <p>
         * Adds one or more values to <code>readIgnoreUsers</code>.
         * </p>
         */
        @Nonnull
        public final Builder readIgnoreUsers(String value, String... values) {
            this.readIgnoreUsers = _listAdd(this.readIgnoreUsers, value, values);
            return this;
        }

        /**
         * API name: {@code read_metadata_only}
         */
        @Nonnull
        public final Builder readMetadataOnly(@Nullable Boolean value) {
            this.readMetadataOnly = value;
            return this;
        }

        /**
         * API name: {@code read_watched_fields}
         */
        @Nonnull
        public final Builder readWatchedFields(@Nullable JsonData value) {
            this.readWatchedFields = value;
            return this;
        }

        /**
         * API name: {@code write_ignore_users}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>writeIgnoreUsers</code>.
         * </p>
         */
        @Nonnull
        public final Builder writeIgnoreUsers(List<String> list) {
            this.writeIgnoreUsers = _listAddAll(this.writeIgnoreUsers, list);
            return this;
        }

        /**
         * API name: {@code write_ignore_users}
         *
         * <p>
         * Adds one or more values to <code>writeIgnoreUsers</code>.
         * </p>
         */
        @Nonnull
        public final Builder writeIgnoreUsers(String value, String... values) {
            this.writeIgnoreUsers = _listAdd(this.writeIgnoreUsers, value, values);
            return this;
        }

        /**
         * API name: {@code write_log_diffs}
         */
        @Nonnull
        public final Builder writeLogDiffs(@Nullable Boolean value) {
            this.writeLogDiffs = value;
            return this;
        }

        /**
         * API name: {@code write_metadata_only}
         */
        @Nonnull
        public final Builder writeMetadataOnly(@Nullable Boolean value) {
            this.writeMetadataOnly = value;
            return this;
        }

        /**
         * API name: {@code write_watched_indices}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>writeWatchedIndices</code>.
         * </p>
         */
        @Nonnull
        public final Builder writeWatchedIndices(List<String> list) {
            this.writeWatchedIndices = _listAddAll(this.writeWatchedIndices, list);
            return this;
        }

        /**
         * API name: {@code write_watched_indices}
         *
         * <p>
         * Adds one or more values to <code>writeWatchedIndices</code>.
         * </p>
         */
        @Nonnull
        public final Builder writeWatchedIndices(String value, String... values) {
            this.writeWatchedIndices = _listAdd(this.writeWatchedIndices, value, values);
            return this;
        }

        /**
         * Builds a {@link ComplianceConfig}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ComplianceConfig build() {
            _checkSingleUse();

            return new ComplianceConfig(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ComplianceConfig}
     */
    public static final JsonpDeserializer<ComplianceConfig> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ComplianceConfig::setupComplianceConfigDeserializer
    );

    protected static void setupComplianceConfigDeserializer(ObjectDeserializer<ComplianceConfig.Builder> op) {
        op.add(Builder::enabled, JsonpDeserializer.booleanDeserializer(), "enabled");
        op.add(Builder::externalConfig, JsonpDeserializer.booleanDeserializer(), "external_config");
        op.add(Builder::internalConfig, JsonpDeserializer.booleanDeserializer(), "internal_config");
        op.add(Builder::readIgnoreUsers, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "read_ignore_users");
        op.add(Builder::readMetadataOnly, JsonpDeserializer.booleanDeserializer(), "read_metadata_only");
        op.add(Builder::readWatchedFields, JsonData._DESERIALIZER, "read_watched_fields");
        op.add(
            Builder::writeIgnoreUsers,
            JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()),
            "write_ignore_users"
        );
        op.add(Builder::writeLogDiffs, JsonpDeserializer.booleanDeserializer(), "write_log_diffs");
        op.add(Builder::writeMetadataOnly, JsonpDeserializer.booleanDeserializer(), "write_metadata_only");
        op.add(
            Builder::writeWatchedIndices,
            JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()),
            "write_watched_indices"
        );
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.enabled);
        result = 31 * result + Objects.hashCode(this.externalConfig);
        result = 31 * result + Objects.hashCode(this.internalConfig);
        result = 31 * result + Objects.hashCode(this.readIgnoreUsers);
        result = 31 * result + Objects.hashCode(this.readMetadataOnly);
        result = 31 * result + Objects.hashCode(this.readWatchedFields);
        result = 31 * result + Objects.hashCode(this.writeIgnoreUsers);
        result = 31 * result + Objects.hashCode(this.writeLogDiffs);
        result = 31 * result + Objects.hashCode(this.writeMetadataOnly);
        result = 31 * result + Objects.hashCode(this.writeWatchedIndices);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ComplianceConfig other = (ComplianceConfig) o;
        return Objects.equals(this.enabled, other.enabled)
            && Objects.equals(this.externalConfig, other.externalConfig)
            && Objects.equals(this.internalConfig, other.internalConfig)
            && Objects.equals(this.readIgnoreUsers, other.readIgnoreUsers)
            && Objects.equals(this.readMetadataOnly, other.readMetadataOnly)
            && Objects.equals(this.readWatchedFields, other.readWatchedFields)
            && Objects.equals(this.writeIgnoreUsers, other.writeIgnoreUsers)
            && Objects.equals(this.writeLogDiffs, other.writeLogDiffs)
            && Objects.equals(this.writeMetadataOnly, other.writeMetadataOnly)
            && Objects.equals(this.writeWatchedIndices, other.writeWatchedIndices);
    }
}
