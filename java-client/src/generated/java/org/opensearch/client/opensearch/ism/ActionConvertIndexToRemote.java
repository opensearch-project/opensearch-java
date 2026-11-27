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

package org.opensearch.client.opensearch.ism;

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
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: ism.ActionConvertIndexToRemote

/**
 * The convert index to remote action configuration.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class ActionConvertIndexToRemote
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<ActionConvertIndexToRemote.Builder, ActionConvertIndexToRemote> {

    @Nullable
    private final Boolean deleteOriginalIndex;

    @Nullable
    private final String ignoreIndexSettings;

    @Nullable
    private final Boolean includeAliases;

    @Nullable
    private final Integer numberOfReplicas;

    @Nullable
    private final String renamePattern;

    @Nonnull
    private final String repository;

    @Nonnull
    private final String snapshot;

    // ---------------------------------------------------------------------------------------------

    private ActionConvertIndexToRemote(Builder builder) {
        this.deleteOriginalIndex = builder.deleteOriginalIndex;
        this.ignoreIndexSettings = builder.ignoreIndexSettings;
        this.includeAliases = builder.includeAliases;
        this.numberOfReplicas = builder.numberOfReplicas;
        this.renamePattern = builder.renamePattern;
        this.repository = ApiTypeHelper.requireNonNull(builder.repository, this, "repository");
        this.snapshot = ApiTypeHelper.requireNonNull(builder.snapshot, this, "snapshot");
    }

    public static ActionConvertIndexToRemote of(
        Function<ActionConvertIndexToRemote.Builder, ObjectBuilder<ActionConvertIndexToRemote>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Whether to delete the original index after the restore.
     * <p>
     * API name: {@code delete_original_index}
     * </p>
     */
    @Nullable
    public final Boolean deleteOriginalIndex() {
        return this.deleteOriginalIndex;
    }

    /**
     * Comma-separated list of index settings to ignore when restoring.
     * <p>
     * API name: {@code ignore_index_settings}
     * </p>
     */
    @Nullable
    public final String ignoreIndexSettings() {
        return this.ignoreIndexSettings;
    }

    /**
     * Whether to restore the aliases of the index.
     * <p>
     * API name: {@code include_aliases}
     * </p>
     */
    @Nullable
    public final Boolean includeAliases() {
        return this.includeAliases;
    }

    /**
     * The number of replicas of the restored index.
     * <p>
     * API name: {@code number_of_replicas}
     * </p>
     */
    @Nullable
    public final Integer numberOfReplicas() {
        return this.numberOfReplicas;
    }

    /**
     * The pattern for the name of the restored index.
     * <p>
     * API name: {@code rename_pattern}
     * </p>
     */
    @Nullable
    public final String renamePattern() {
        return this.renamePattern;
    }

    /**
     * Required - The repository that holds the snapshot.
     * <p>
     * API name: {@code repository}
     * </p>
     */
    @Nonnull
    public final String repository() {
        return this.repository;
    }

    /**
     * Required - The name of the snapshot to restore.
     * <p>
     * API name: {@code snapshot}
     * </p>
     */
    @Nonnull
    public final String snapshot() {
        return this.snapshot;
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
        if (this.deleteOriginalIndex != null) {
            generator.writeKey("delete_original_index");
            generator.write(this.deleteOriginalIndex);
        }

        if (this.ignoreIndexSettings != null) {
            generator.writeKey("ignore_index_settings");
            generator.write(this.ignoreIndexSettings);
        }

        if (this.includeAliases != null) {
            generator.writeKey("include_aliases");
            generator.write(this.includeAliases);
        }

        if (this.numberOfReplicas != null) {
            generator.writeKey("number_of_replicas");
            generator.write(this.numberOfReplicas);
        }

        if (this.renamePattern != null) {
            generator.writeKey("rename_pattern");
            generator.write(this.renamePattern);
        }

        generator.writeKey("repository");
        generator.write(this.repository);

        generator.writeKey("snapshot");
        generator.write(this.snapshot);
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
     * Builder for {@link ActionConvertIndexToRemote}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, ActionConvertIndexToRemote> {
        @Nullable
        private Boolean deleteOriginalIndex;
        @Nullable
        private String ignoreIndexSettings;
        @Nullable
        private Boolean includeAliases;
        @Nullable
        private Integer numberOfReplicas;
        @Nullable
        private String renamePattern;
        private String repository;
        private String snapshot;

        public Builder() {}

        private Builder(ActionConvertIndexToRemote o) {
            this.deleteOriginalIndex = o.deleteOriginalIndex;
            this.ignoreIndexSettings = o.ignoreIndexSettings;
            this.includeAliases = o.includeAliases;
            this.numberOfReplicas = o.numberOfReplicas;
            this.renamePattern = o.renamePattern;
            this.repository = o.repository;
            this.snapshot = o.snapshot;
        }

        private Builder(Builder o) {
            this.deleteOriginalIndex = o.deleteOriginalIndex;
            this.ignoreIndexSettings = o.ignoreIndexSettings;
            this.includeAliases = o.includeAliases;
            this.numberOfReplicas = o.numberOfReplicas;
            this.renamePattern = o.renamePattern;
            this.repository = o.repository;
            this.snapshot = o.snapshot;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Whether to delete the original index after the restore.
         * <p>
         * API name: {@code delete_original_index}
         * </p>
         */
        @Nonnull
        public final Builder deleteOriginalIndex(@Nullable Boolean value) {
            this.deleteOriginalIndex = value;
            return this;
        }

        /**
         * Comma-separated list of index settings to ignore when restoring.
         * <p>
         * API name: {@code ignore_index_settings}
         * </p>
         */
        @Nonnull
        public final Builder ignoreIndexSettings(@Nullable String value) {
            this.ignoreIndexSettings = value;
            return this;
        }

        /**
         * Whether to restore the aliases of the index.
         * <p>
         * API name: {@code include_aliases}
         * </p>
         */
        @Nonnull
        public final Builder includeAliases(@Nullable Boolean value) {
            this.includeAliases = value;
            return this;
        }

        /**
         * The number of replicas of the restored index.
         * <p>
         * API name: {@code number_of_replicas}
         * </p>
         */
        @Nonnull
        public final Builder numberOfReplicas(@Nullable Integer value) {
            this.numberOfReplicas = value;
            return this;
        }

        /**
         * The pattern for the name of the restored index.
         * <p>
         * API name: {@code rename_pattern}
         * </p>
         */
        @Nonnull
        public final Builder renamePattern(@Nullable String value) {
            this.renamePattern = value;
            return this;
        }

        /**
         * Required - The repository that holds the snapshot.
         * <p>
         * API name: {@code repository}
         * </p>
         */
        @Nonnull
        public final Builder repository(String value) {
            this.repository = value;
            return this;
        }

        /**
         * Required - The name of the snapshot to restore.
         * <p>
         * API name: {@code snapshot}
         * </p>
         */
        @Nonnull
        public final Builder snapshot(String value) {
            this.snapshot = value;
            return this;
        }

        /**
         * Builds a {@link ActionConvertIndexToRemote}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ActionConvertIndexToRemote build() {
            _checkSingleUse();

            return new ActionConvertIndexToRemote(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ActionConvertIndexToRemote}
     */
    public static final JsonpDeserializer<ActionConvertIndexToRemote> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ActionConvertIndexToRemote::setupActionConvertIndexToRemoteDeserializer
    );

    protected static void setupActionConvertIndexToRemoteDeserializer(ObjectDeserializer<ActionConvertIndexToRemote.Builder> op) {
        op.add(Builder::deleteOriginalIndex, JsonpDeserializer.booleanDeserializer(), "delete_original_index");
        op.add(Builder::ignoreIndexSettings, JsonpDeserializer.stringDeserializer(), "ignore_index_settings");
        op.add(Builder::includeAliases, JsonpDeserializer.booleanDeserializer(), "include_aliases");
        op.add(Builder::numberOfReplicas, JsonpDeserializer.integerDeserializer(), "number_of_replicas");
        op.add(Builder::renamePattern, JsonpDeserializer.stringDeserializer(), "rename_pattern");
        op.add(Builder::repository, JsonpDeserializer.stringDeserializer(), "repository");
        op.add(Builder::snapshot, JsonpDeserializer.stringDeserializer(), "snapshot");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.deleteOriginalIndex);
        result = 31 * result + Objects.hashCode(this.ignoreIndexSettings);
        result = 31 * result + Objects.hashCode(this.includeAliases);
        result = 31 * result + Objects.hashCode(this.numberOfReplicas);
        result = 31 * result + Objects.hashCode(this.renamePattern);
        result = 31 * result + this.repository.hashCode();
        result = 31 * result + this.snapshot.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ActionConvertIndexToRemote other = (ActionConvertIndexToRemote) o;
        return Objects.equals(this.deleteOriginalIndex, other.deleteOriginalIndex)
            && Objects.equals(this.ignoreIndexSettings, other.ignoreIndexSettings)
            && Objects.equals(this.includeAliases, other.includeAliases)
            && Objects.equals(this.numberOfReplicas, other.numberOfReplicas)
            && Objects.equals(this.renamePattern, other.renamePattern)
            && this.repository.equals(other.repository)
            && this.snapshot.equals(other.snapshot);
    }
}
