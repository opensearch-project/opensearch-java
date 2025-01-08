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

package org.opensearch.client.opensearch.snapshot;

import jakarta.json.stream.JsonGenerator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
import org.opensearch.client.opensearch._types.ErrorResponse;
import org.opensearch.client.opensearch._types.RequestBase;
import org.opensearch.client.opensearch._types.Time;
import org.opensearch.client.opensearch.indices.IndexSettings;
import org.opensearch.client.transport.Endpoint;
import org.opensearch.client.transport.endpoints.SimpleEndpoint;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: snapshot.restore.Request

/**
 * Restores a snapshot.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public final class RestoreSnapshotRequest extends RequestBase
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<RestoreSnapshotRequest.Builder, RestoreSnapshotRequest> {

    @Nullable
    private final Time clusterManagerTimeout;

    @Nonnull
    private final List<String> ignoreIndexSettings;

    @Nullable
    private final Boolean ignoreUnavailable;

    @Nullable
    private final Boolean includeAliases;

    @Nullable
    private final Boolean includeGlobalState;

    @Nullable
    private final IndexSettings indexSettings;

    @Nonnull
    private final List<String> indices;

    @Deprecated
    @Nullable
    private final Time masterTimeout;

    @Nullable
    private final Boolean partial;

    @Nullable
    private final String renameAliasPattern;

    @Nullable
    private final String renameAliasReplacement;

    @Nullable
    private final String renamePattern;

    @Nullable
    private final String renameReplacement;

    @Nonnull
    private final String repository;

    @Nonnull
    private final String snapshot;

    @Nullable
    private final String sourceRemoteStoreRepository;

    @Nullable
    private final String storageType;

    @Nullable
    private final Boolean waitForCompletion;

    // ---------------------------------------------------------------------------------------------

    private RestoreSnapshotRequest(Builder builder) {
        super(builder);
        this.clusterManagerTimeout = builder.clusterManagerTimeout;
        this.ignoreIndexSettings = ApiTypeHelper.unmodifiable(builder.ignoreIndexSettings);
        this.ignoreUnavailable = builder.ignoreUnavailable;
        this.includeAliases = builder.includeAliases;
        this.includeGlobalState = builder.includeGlobalState;
        this.indexSettings = builder.indexSettings;
        this.indices = ApiTypeHelper.unmodifiable(builder.indices);
        this.masterTimeout = builder.masterTimeout;
        this.partial = builder.partial;
        this.renameAliasPattern = builder.renameAliasPattern;
        this.renameAliasReplacement = builder.renameAliasReplacement;
        this.renamePattern = builder.renamePattern;
        this.renameReplacement = builder.renameReplacement;
        this.repository = ApiTypeHelper.requireNonNull(builder.repository, this, "repository");
        this.snapshot = ApiTypeHelper.requireNonNull(builder.snapshot, this, "snapshot");
        this.sourceRemoteStoreRepository = builder.sourceRemoteStoreRepository;
        this.storageType = builder.storageType;
        this.waitForCompletion = builder.waitForCompletion;
    }

    public static RestoreSnapshotRequest of(Function<RestoreSnapshotRequest.Builder, ObjectBuilder<RestoreSnapshotRequest>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Operation timeout for connection to cluster-manager node.
     * <p>
     * API name: {@code cluster_manager_timeout}
     * </p>
     */
    @Nullable
    public final Time clusterManagerTimeout() {
        return this.clusterManagerTimeout;
    }

    /**
     * A comma-delimited list of index settings that you don't want to restore from a snapshot.
     * <p>
     * API name: {@code ignore_index_settings}
     * </p>
     */
    @Nonnull
    public final List<String> ignoreIndexSettings() {
        return this.ignoreIndexSettings;
    }

    /**
     * How to handle data streams or indexes that are missing or closed. If <code>false</code>, the request returns an error for any data
     * stream or index that is missing or closed. If <code>true</code>, the request ignores data streams and indexes in indexes that are
     * missing or closed. Defaults to <code>false</code>.
     * <p>
     * API name: {@code ignore_unavailable}
     * </p>
     */
    @Nullable
    public final Boolean ignoreUnavailable() {
        return this.ignoreUnavailable;
    }

    /**
     * How to handle index aliases from the original snapshot. If <code>true</code>, index aliases from the original snapshot are restored.
     * If <code>false</code>, aliases along with associated indexes are not restored. Defaults to <code>true</code>.
     * <p>
     * API name: {@code include_aliases}
     * </p>
     */
    @Nullable
    public final Boolean includeAliases() {
        return this.includeAliases;
    }

    /**
     * Whether to restore the current cluster state. If <code>false</code>, the cluster state is not restored. If true, the current cluster
     * state is restored. Defaults to <code>false</code>.
     * <p>
     * API name: {@code include_global_state}
     * </p>
     */
    @Nullable
    public final Boolean includeGlobalState() {
        return this.includeGlobalState;
    }

    /**
     * A comma-delimited list of settings to add or change in all restored indexes. Use this parameter to override index settings during
     * snapshot restoration. For data streams, these index settings are applied to the restored backing indexes.
     * <p>
     * API name: {@code index_settings}
     * </p>
     */
    @Nullable
    public final IndexSettings indexSettings() {
        return this.indexSettings;
    }

    /**
     * A comma-delimited list of data streams and indexes to restore from the snapshot. Multi-index syntax is supported. By default, a
     * restore operation includes all data streams and indexes in the snapshot. If this argument is provided, the restore operation only
     * includes the data streams and indexes that you specify.
     * <p>
     * API name: {@code indices}
     * </p>
     */
    @Nonnull
    public final List<String> indices() {
        return this.indices;
    }

    /**
     * Explicit operation timeout for connection to cluster-manager node
     * <p>
     * API name: {@code master_timeout}
     * </p>
     */
    @Deprecated
    @Nullable
    public final Time masterTimeout() {
        return this.masterTimeout;
    }

    /**
     * How the restore operation will behave if indexes in the snapshot do not have all primary shards available. If <code>false</code>, the
     * entire restore operation fails if any indexes in the snapshot do not have all primary shards available. If <code>true</code>, allows
     * the restoration of a partial snapshot of indexes with unavailable shards. Only shards that were successfully included in the snapshot
     * are restored. All missing shards are recreated as empty. By default, the entire restore operation fails if one or more indexes
     * included in the snapshot do not have all primary shards available. To change this behavior, set <code>partial</code> to
     * <code>true</code>. Defaults to <code>false</code>.
     * <p>
     * API name: {@code partial}
     * </p>
     */
    @Nullable
    public final Boolean partial() {
        return this.partial;
    }

    /**
     * The pattern to apply to the restored aliases. Aliases matching the rename pattern will be renamed according to the
     * <code>rename_alias_replacement</code> setting. The rename pattern is applied as defined by the regular expression that supports
     * referencing the original text. If two or more aliases are renamed into the same name, these aliases will be merged into one.
     * <p>
     * API name: {@code rename_alias_pattern}
     * </p>
     */
    @Nullable
    public final String renameAliasPattern() {
        return this.renameAliasPattern;
    }

    /**
     * The rename replacement string for aliases.
     * <p>
     * API name: {@code rename_alias_replacement}
     * </p>
     */
    @Nullable
    public final String renameAliasReplacement() {
        return this.renameAliasReplacement;
    }

    /**
     * The pattern to apply to the restored data streams and indexes. Data streams and indexes matching the rename pattern will be renamed
     * according to the <code>rename_replacement</code> setting. The rename pattern is applied as defined by the regular expression that
     * supports referencing the original text. The request fails if two or more data streams or indexes are renamed into the same name. If
     * you rename a restored data stream, its backing indexes are also renamed. For example, if you rename the logs data stream to
     * <code>recovered-logs</code>, the backing index <code>.ds-logs-1</code> is renamed to <code>.ds-recovered-logs-1</code>. If you rename
     * a restored stream, ensure an index template matches the new stream name. If there are no matching index template names, the stream
     * cannot roll over and new backing indexes are not created.
     * <p>
     * API name: {@code rename_pattern}
     * </p>
     */
    @Nullable
    public final String renamePattern() {
        return this.renamePattern;
    }

    /**
     * The rename replacement string.
     * <p>
     * API name: {@code rename_replacement}
     * </p>
     */
    @Nullable
    public final String renameReplacement() {
        return this.renameReplacement;
    }

    /**
     * Required - A repository name
     * <p>
     * API name: {@code repository}
     * </p>
     */
    @Nonnull
    public final String repository() {
        return this.repository;
    }

    /**
     * Required - A snapshot name
     * <p>
     * API name: {@code snapshot}
     * </p>
     */
    @Nonnull
    public final String snapshot() {
        return this.snapshot;
    }

    /**
     * The name of the remote store repository of the source index being restored. If not provided, the Snapshot Restore API will use the
     * repository that was registered when the snapshot was created.
     * <p>
     * API name: {@code source_remote_store_repository}
     * </p>
     */
    @Nullable
    public final String sourceRemoteStoreRepository() {
        return this.sourceRemoteStoreRepository;
    }

    /**
     * Where will be the authoritative store of the restored indexes' data. A value of <code>local</code> indicates that all snapshot
     * metadata and index data will be downloaded to local storage. A value of <code>remote_snapshot</code> indicates that snapshot metadata
     * will be downloaded to the cluster, but the remote repository will remain the authoritative store of the index data. Data will be
     * downloaded and cached as necessary to service queries. At least one node in the cluster must be configured with the search role in
     * order to restore a snapshot using the type <code>remote_snapshot</code>. Defaults to <code>local</code>.
     * <p>
     * API name: {@code storage_type}
     * </p>
     */
    @Nullable
    public final String storageType() {
        return this.storageType;
    }

    /**
     * Should this request wait until the operation has completed before returning
     * <p>
     * API name: {@code wait_for_completion}
     * </p>
     */
    @Nullable
    public final Boolean waitForCompletion() {
        return this.waitForCompletion;
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
        if (ApiTypeHelper.isDefined(this.ignoreIndexSettings)) {
            generator.writeKey("ignore_index_settings");
            generator.writeStartArray();
            for (String item0 : this.ignoreIndexSettings) {
                generator.write(item0);
            }
            generator.writeEnd();
        }

        if (this.ignoreUnavailable != null) {
            generator.writeKey("ignore_unavailable");
            generator.write(this.ignoreUnavailable);
        }

        if (this.includeAliases != null) {
            generator.writeKey("include_aliases");
            generator.write(this.includeAliases);
        }

        if (this.includeGlobalState != null) {
            generator.writeKey("include_global_state");
            generator.write(this.includeGlobalState);
        }

        if (this.indexSettings != null) {
            generator.writeKey("index_settings");
            this.indexSettings.serialize(generator, mapper);
        }

        if (ApiTypeHelper.isDefined(this.indices)) {
            generator.writeKey("indices");
            generator.writeStartArray();
            for (String item0 : this.indices) {
                generator.write(item0);
            }
            generator.writeEnd();
        }

        if (this.partial != null) {
            generator.writeKey("partial");
            generator.write(this.partial);
        }

        if (this.renameAliasPattern != null) {
            generator.writeKey("rename_alias_pattern");
            generator.write(this.renameAliasPattern);
        }

        if (this.renameAliasReplacement != null) {
            generator.writeKey("rename_alias_replacement");
            generator.write(this.renameAliasReplacement);
        }

        if (this.renamePattern != null) {
            generator.writeKey("rename_pattern");
            generator.write(this.renamePattern);
        }

        if (this.renameReplacement != null) {
            generator.writeKey("rename_replacement");
            generator.write(this.renameReplacement);
        }

        if (this.sourceRemoteStoreRepository != null) {
            generator.writeKey("source_remote_store_repository");
            generator.write(this.sourceRemoteStoreRepository);
        }

        if (this.storageType != null) {
            generator.writeKey("storage_type");
            generator.write(this.storageType);
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
     * Builder for {@link RestoreSnapshotRequest}.
     */
    public static class Builder extends RequestBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, RestoreSnapshotRequest> {
        @Nullable
        private Time clusterManagerTimeout;
        @Nullable
        private List<String> ignoreIndexSettings;
        @Nullable
        private Boolean ignoreUnavailable;
        @Nullable
        private Boolean includeAliases;
        @Nullable
        private Boolean includeGlobalState;
        @Nullable
        private IndexSettings indexSettings;
        @Nullable
        private List<String> indices;
        @Nullable
        private Time masterTimeout;
        @Nullable
        private Boolean partial;
        @Nullable
        private String renameAliasPattern;
        @Nullable
        private String renameAliasReplacement;
        @Nullable
        private String renamePattern;
        @Nullable
        private String renameReplacement;
        private String repository;
        private String snapshot;
        @Nullable
        private String sourceRemoteStoreRepository;
        @Nullable
        private String storageType;
        @Nullable
        private Boolean waitForCompletion;

        public Builder() {}

        private Builder(RestoreSnapshotRequest o) {
            super(o);
            this.clusterManagerTimeout = o.clusterManagerTimeout;
            this.ignoreIndexSettings = _listCopy(o.ignoreIndexSettings);
            this.ignoreUnavailable = o.ignoreUnavailable;
            this.includeAliases = o.includeAliases;
            this.includeGlobalState = o.includeGlobalState;
            this.indexSettings = o.indexSettings;
            this.indices = _listCopy(o.indices);
            this.masterTimeout = o.masterTimeout;
            this.partial = o.partial;
            this.renameAliasPattern = o.renameAliasPattern;
            this.renameAliasReplacement = o.renameAliasReplacement;
            this.renamePattern = o.renamePattern;
            this.renameReplacement = o.renameReplacement;
            this.repository = o.repository;
            this.snapshot = o.snapshot;
            this.sourceRemoteStoreRepository = o.sourceRemoteStoreRepository;
            this.storageType = o.storageType;
            this.waitForCompletion = o.waitForCompletion;
        }

        private Builder(Builder o) {
            super(o);
            this.clusterManagerTimeout = o.clusterManagerTimeout;
            this.ignoreIndexSettings = _listCopy(o.ignoreIndexSettings);
            this.ignoreUnavailable = o.ignoreUnavailable;
            this.includeAliases = o.includeAliases;
            this.includeGlobalState = o.includeGlobalState;
            this.indexSettings = o.indexSettings;
            this.indices = _listCopy(o.indices);
            this.masterTimeout = o.masterTimeout;
            this.partial = o.partial;
            this.renameAliasPattern = o.renameAliasPattern;
            this.renameAliasReplacement = o.renameAliasReplacement;
            this.renamePattern = o.renamePattern;
            this.renameReplacement = o.renameReplacement;
            this.repository = o.repository;
            this.snapshot = o.snapshot;
            this.sourceRemoteStoreRepository = o.sourceRemoteStoreRepository;
            this.storageType = o.storageType;
            this.waitForCompletion = o.waitForCompletion;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        @Override
        @Nonnull
        protected Builder self() {
            return this;
        }

        /**
         * Operation timeout for connection to cluster-manager node.
         * <p>
         * API name: {@code cluster_manager_timeout}
         * </p>
         */
        @Nonnull
        public final Builder clusterManagerTimeout(@Nullable Time value) {
            this.clusterManagerTimeout = value;
            return this;
        }

        /**
         * Operation timeout for connection to cluster-manager node.
         * <p>
         * API name: {@code cluster_manager_timeout}
         * </p>
         */
        @Nonnull
        public final Builder clusterManagerTimeout(Function<Time.Builder, ObjectBuilder<Time>> fn) {
            return clusterManagerTimeout(fn.apply(new Time.Builder()).build());
        }

        /**
         * A comma-delimited list of index settings that you don't want to restore from a snapshot.
         * <p>
         * API name: {@code ignore_index_settings}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>ignoreIndexSettings</code>.
         * </p>
         */
        @Nonnull
        public final Builder ignoreIndexSettings(List<String> list) {
            this.ignoreIndexSettings = _listAddAll(this.ignoreIndexSettings, list);
            return this;
        }

        /**
         * A comma-delimited list of index settings that you don't want to restore from a snapshot.
         * <p>
         * API name: {@code ignore_index_settings}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>ignoreIndexSettings</code>.
         * </p>
         */
        @Nonnull
        public final Builder ignoreIndexSettings(String value, String... values) {
            this.ignoreIndexSettings = _listAdd(this.ignoreIndexSettings, value, values);
            return this;
        }

        /**
         * How to handle data streams or indexes that are missing or closed. If <code>false</code>, the request returns an error for any
         * data stream or index that is missing or closed. If <code>true</code>, the request ignores data streams and indexes in indexes
         * that are missing or closed. Defaults to <code>false</code>.
         * <p>
         * API name: {@code ignore_unavailable}
         * </p>
         */
        @Nonnull
        public final Builder ignoreUnavailable(@Nullable Boolean value) {
            this.ignoreUnavailable = value;
            return this;
        }

        /**
         * How to handle index aliases from the original snapshot. If <code>true</code>, index aliases from the original snapshot are
         * restored. If <code>false</code>, aliases along with associated indexes are not restored. Defaults to <code>true</code>.
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
         * Whether to restore the current cluster state. If <code>false</code>, the cluster state is not restored. If true, the current
         * cluster state is restored. Defaults to <code>false</code>.
         * <p>
         * API name: {@code include_global_state}
         * </p>
         */
        @Nonnull
        public final Builder includeGlobalState(@Nullable Boolean value) {
            this.includeGlobalState = value;
            return this;
        }

        /**
         * A comma-delimited list of settings to add or change in all restored indexes. Use this parameter to override index settings during
         * snapshot restoration. For data streams, these index settings are applied to the restored backing indexes.
         * <p>
         * API name: {@code index_settings}
         * </p>
         */
        @Nonnull
        public final Builder indexSettings(@Nullable IndexSettings value) {
            this.indexSettings = value;
            return this;
        }

        /**
         * A comma-delimited list of settings to add or change in all restored indexes. Use this parameter to override index settings during
         * snapshot restoration. For data streams, these index settings are applied to the restored backing indexes.
         * <p>
         * API name: {@code index_settings}
         * </p>
         */
        @Nonnull
        public final Builder indexSettings(Function<IndexSettings.Builder, ObjectBuilder<IndexSettings>> fn) {
            return indexSettings(fn.apply(new IndexSettings.Builder()).build());
        }

        /**
         * A comma-delimited list of data streams and indexes to restore from the snapshot. Multi-index syntax is supported. By default, a
         * restore operation includes all data streams and indexes in the snapshot. If this argument is provided, the restore operation only
         * includes the data streams and indexes that you specify.
         * <p>
         * API name: {@code indices}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>indices</code>.
         * </p>
         */
        @Nonnull
        public final Builder indices(List<String> list) {
            this.indices = _listAddAll(this.indices, list);
            return this;
        }

        /**
         * A comma-delimited list of data streams and indexes to restore from the snapshot. Multi-index syntax is supported. By default, a
         * restore operation includes all data streams and indexes in the snapshot. If this argument is provided, the restore operation only
         * includes the data streams and indexes that you specify.
         * <p>
         * API name: {@code indices}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>indices</code>.
         * </p>
         */
        @Nonnull
        public final Builder indices(String value, String... values) {
            this.indices = _listAdd(this.indices, value, values);
            return this;
        }

        /**
         * Explicit operation timeout for connection to cluster-manager node
         * <p>
         * API name: {@code master_timeout}
         * </p>
         */
        @Deprecated
        @Nonnull
        public final Builder masterTimeout(@Nullable Time value) {
            this.masterTimeout = value;
            return this;
        }

        /**
         * Explicit operation timeout for connection to cluster-manager node
         * <p>
         * API name: {@code master_timeout}
         * </p>
         */
        @Deprecated
        @Nonnull
        public final Builder masterTimeout(Function<Time.Builder, ObjectBuilder<Time>> fn) {
            return masterTimeout(fn.apply(new Time.Builder()).build());
        }

        /**
         * How the restore operation will behave if indexes in the snapshot do not have all primary shards available. If <code>false</code>,
         * the entire restore operation fails if any indexes in the snapshot do not have all primary shards available. If <code>true</code>,
         * allows the restoration of a partial snapshot of indexes with unavailable shards. Only shards that were successfully included in
         * the snapshot are restored. All missing shards are recreated as empty. By default, the entire restore operation fails if one or
         * more indexes included in the snapshot do not have all primary shards available. To change this behavior, set <code>partial</code>
         * to <code>true</code>. Defaults to <code>false</code>.
         * <p>
         * API name: {@code partial}
         * </p>
         */
        @Nonnull
        public final Builder partial(@Nullable Boolean value) {
            this.partial = value;
            return this;
        }

        /**
         * The pattern to apply to the restored aliases. Aliases matching the rename pattern will be renamed according to the
         * <code>rename_alias_replacement</code> setting. The rename pattern is applied as defined by the regular expression that supports
         * referencing the original text. If two or more aliases are renamed into the same name, these aliases will be merged into one.
         * <p>
         * API name: {@code rename_alias_pattern}
         * </p>
         */
        @Nonnull
        public final Builder renameAliasPattern(@Nullable String value) {
            this.renameAliasPattern = value;
            return this;
        }

        /**
         * The rename replacement string for aliases.
         * <p>
         * API name: {@code rename_alias_replacement}
         * </p>
         */
        @Nonnull
        public final Builder renameAliasReplacement(@Nullable String value) {
            this.renameAliasReplacement = value;
            return this;
        }

        /**
         * The pattern to apply to the restored data streams and indexes. Data streams and indexes matching the rename pattern will be
         * renamed according to the <code>rename_replacement</code> setting. The rename pattern is applied as defined by the regular
         * expression that supports referencing the original text. The request fails if two or more data streams or indexes are renamed into
         * the same name. If you rename a restored data stream, its backing indexes are also renamed. For example, if you rename the logs
         * data stream to <code>recovered-logs</code>, the backing index <code>.ds-logs-1</code> is renamed to
         * <code>.ds-recovered-logs-1</code>. If you rename a restored stream, ensure an index template matches the new stream name. If
         * there are no matching index template names, the stream cannot roll over and new backing indexes are not created.
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
         * The rename replacement string.
         * <p>
         * API name: {@code rename_replacement}
         * </p>
         */
        @Nonnull
        public final Builder renameReplacement(@Nullable String value) {
            this.renameReplacement = value;
            return this;
        }

        /**
         * Required - A repository name
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
         * Required - A snapshot name
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
         * The name of the remote store repository of the source index being restored. If not provided, the Snapshot Restore API will use
         * the repository that was registered when the snapshot was created.
         * <p>
         * API name: {@code source_remote_store_repository}
         * </p>
         */
        @Nonnull
        public final Builder sourceRemoteStoreRepository(@Nullable String value) {
            this.sourceRemoteStoreRepository = value;
            return this;
        }

        /**
         * Where will be the authoritative store of the restored indexes' data. A value of <code>local</code> indicates that all snapshot
         * metadata and index data will be downloaded to local storage. A value of <code>remote_snapshot</code> indicates that snapshot
         * metadata will be downloaded to the cluster, but the remote repository will remain the authoritative store of the index data. Data
         * will be downloaded and cached as necessary to service queries. At least one node in the cluster must be configured with the
         * search role in order to restore a snapshot using the type <code>remote_snapshot</code>. Defaults to <code>local</code>.
         * <p>
         * API name: {@code storage_type}
         * </p>
         */
        @Nonnull
        public final Builder storageType(@Nullable String value) {
            this.storageType = value;
            return this;
        }

        /**
         * Should this request wait until the operation has completed before returning
         * <p>
         * API name: {@code wait_for_completion}
         * </p>
         */
        @Nonnull
        public final Builder waitForCompletion(@Nullable Boolean value) {
            this.waitForCompletion = value;
            return this;
        }

        /**
         * Builds a {@link RestoreSnapshotRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public RestoreSnapshotRequest build() {
            _checkSingleUse();

            return new RestoreSnapshotRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link RestoreSnapshotRequest}
     */
    public static final JsonpDeserializer<RestoreSnapshotRequest> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        RestoreSnapshotRequest::setupRestoreSnapshotRequestDeserializer
    );

    protected static void setupRestoreSnapshotRequestDeserializer(ObjectDeserializer<RestoreSnapshotRequest.Builder> op) {
        op.add(
            Builder::ignoreIndexSettings,
            JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()),
            "ignore_index_settings"
        );
        op.add(Builder::ignoreUnavailable, JsonpDeserializer.booleanDeserializer(), "ignore_unavailable");
        op.add(Builder::includeAliases, JsonpDeserializer.booleanDeserializer(), "include_aliases");
        op.add(Builder::includeGlobalState, JsonpDeserializer.booleanDeserializer(), "include_global_state");
        op.add(Builder::indexSettings, IndexSettings._DESERIALIZER, "index_settings");
        op.add(Builder::indices, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "indices");
        op.add(Builder::partial, JsonpDeserializer.booleanDeserializer(), "partial");
        op.add(Builder::renameAliasPattern, JsonpDeserializer.stringDeserializer(), "rename_alias_pattern");
        op.add(Builder::renameAliasReplacement, JsonpDeserializer.stringDeserializer(), "rename_alias_replacement");
        op.add(Builder::renamePattern, JsonpDeserializer.stringDeserializer(), "rename_pattern");
        op.add(Builder::renameReplacement, JsonpDeserializer.stringDeserializer(), "rename_replacement");
        op.add(Builder::sourceRemoteStoreRepository, JsonpDeserializer.stringDeserializer(), "source_remote_store_repository");
        op.add(Builder::storageType, JsonpDeserializer.stringDeserializer(), "storage_type");
    }

    // ---------------------------------------------------------------------------------------------

    @Override
    protected void applyQueryParameters(@Nonnull Map<String, String> params) {
        super.applyQueryParameters(params);
        if (this.clusterManagerTimeout != null) {
            params.put("cluster_manager_timeout", this.clusterManagerTimeout._toJsonString());
        }
        if (this.masterTimeout != null) {
            params.put("master_timeout", this.masterTimeout._toJsonString());
        }
        if (this.waitForCompletion != null) {
            params.put("wait_for_completion", String.valueOf(this.waitForCompletion));
        }
    }

    /**
     * Endpoint "{@code snapshot.restore}".
     */
    public static final Endpoint<RestoreSnapshotRequest, RestoreSnapshotResponse, ErrorResponse> _ENDPOINT = new SimpleEndpoint<>(
        // Request method
        request -> "POST",
        // Request path
        request -> {
            StringBuilder buf = new StringBuilder();
            buf.append("/_snapshot/");
            SimpleEndpoint.pathEncode(request.repository, buf);
            buf.append("/");
            SimpleEndpoint.pathEncode(request.snapshot, buf);
            buf.append("/_restore");
            return buf.toString();
        },
        // Request parameters
        request -> {
            Map<String, String> params = new HashMap<>();
            request.applyQueryParameters(params);
            return params;
        },
        SimpleEndpoint.emptyMap(),
        true,
        RestoreSnapshotResponse._DESERIALIZER
    );

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.clusterManagerTimeout);
        result = 31 * result + Objects.hashCode(this.ignoreIndexSettings);
        result = 31 * result + Objects.hashCode(this.ignoreUnavailable);
        result = 31 * result + Objects.hashCode(this.includeAliases);
        result = 31 * result + Objects.hashCode(this.includeGlobalState);
        result = 31 * result + Objects.hashCode(this.indexSettings);
        result = 31 * result + Objects.hashCode(this.indices);
        result = 31 * result + Objects.hashCode(this.masterTimeout);
        result = 31 * result + Objects.hashCode(this.partial);
        result = 31 * result + Objects.hashCode(this.renameAliasPattern);
        result = 31 * result + Objects.hashCode(this.renameAliasReplacement);
        result = 31 * result + Objects.hashCode(this.renamePattern);
        result = 31 * result + Objects.hashCode(this.renameReplacement);
        result = 31 * result + this.repository.hashCode();
        result = 31 * result + this.snapshot.hashCode();
        result = 31 * result + Objects.hashCode(this.sourceRemoteStoreRepository);
        result = 31 * result + Objects.hashCode(this.storageType);
        result = 31 * result + Objects.hashCode(this.waitForCompletion);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        RestoreSnapshotRequest other = (RestoreSnapshotRequest) o;
        return Objects.equals(this.clusterManagerTimeout, other.clusterManagerTimeout)
            && Objects.equals(this.ignoreIndexSettings, other.ignoreIndexSettings)
            && Objects.equals(this.ignoreUnavailable, other.ignoreUnavailable)
            && Objects.equals(this.includeAliases, other.includeAliases)
            && Objects.equals(this.includeGlobalState, other.includeGlobalState)
            && Objects.equals(this.indexSettings, other.indexSettings)
            && Objects.equals(this.indices, other.indices)
            && Objects.equals(this.masterTimeout, other.masterTimeout)
            && Objects.equals(this.partial, other.partial)
            && Objects.equals(this.renameAliasPattern, other.renameAliasPattern)
            && Objects.equals(this.renameAliasReplacement, other.renameAliasReplacement)
            && Objects.equals(this.renamePattern, other.renamePattern)
            && Objects.equals(this.renameReplacement, other.renameReplacement)
            && this.repository.equals(other.repository)
            && this.snapshot.equals(other.snapshot)
            && Objects.equals(this.sourceRemoteStoreRepository, other.sourceRemoteStoreRepository)
            && Objects.equals(this.storageType, other.storageType)
            && Objects.equals(this.waitForCompletion, other.waitForCompletion);
    }
}
