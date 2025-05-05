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

package org.opensearch.client.opensearch.indices.recovery;

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

// typedef: indices.recovery.RecoveryOrigin

/**
 * The source or target of a recovery operation.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class RecoveryOrigin implements PlainJsonSerializable, ToCopyableBuilder<RecoveryOrigin.Builder, RecoveryOrigin> {

    @Nullable
    private final Boolean bootstrapNewHistoryUuid;

    @Nullable
    private final String host;

    @Nullable
    private final String hostname;

    @Nullable
    private final String id;

    @Nullable
    private final String index;

    @Nullable
    private final String ip;

    @Nullable
    private final Boolean isSearchableSnapshot;

    @Nullable
    private final String name;

    @Nullable
    private final Boolean remoteStoreIndexShallowCopy;

    @Nullable
    private final String repository;

    @Nullable
    private final String restoreUuid;

    @Nullable
    private final String snapshot;

    @Nullable
    private final String sourceRemoteStoreRepository;

    @Nullable
    private final String sourceRemoteTranslogRepository;

    @Nullable
    private final String transportAddress;

    @Nullable
    private final String version;

    // ---------------------------------------------------------------------------------------------

    private RecoveryOrigin(Builder builder) {
        this.bootstrapNewHistoryUuid = builder.bootstrapNewHistoryUuid;
        this.host = builder.host;
        this.hostname = builder.hostname;
        this.id = builder.id;
        this.index = builder.index;
        this.ip = builder.ip;
        this.isSearchableSnapshot = builder.isSearchableSnapshot;
        this.name = builder.name;
        this.remoteStoreIndexShallowCopy = builder.remoteStoreIndexShallowCopy;
        this.repository = builder.repository;
        this.restoreUuid = builder.restoreUuid;
        this.snapshot = builder.snapshot;
        this.sourceRemoteStoreRepository = builder.sourceRemoteStoreRepository;
        this.sourceRemoteTranslogRepository = builder.sourceRemoteTranslogRepository;
        this.transportAddress = builder.transportAddress;
        this.version = builder.version;
    }

    public static RecoveryOrigin of(Function<RecoveryOrigin.Builder, ObjectBuilder<RecoveryOrigin>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Whether a new history UUID was bootstrapped.
     * <p>
     * API name: {@code bootstrap_new_history_uuid}
     * </p>
     */
    @Nullable
    public final Boolean bootstrapNewHistoryUuid() {
        return this.bootstrapNewHistoryUuid;
    }

    /**
     * API name: {@code host}
     */
    @Nullable
    public final String host() {
        return this.host;
    }

    /**
     * The hostname of the node.
     * <p>
     * API name: {@code hostname}
     * </p>
     */
    @Nullable
    public final String hostname() {
        return this.hostname;
    }

    /**
     * API name: {@code id}
     */
    @Nullable
    public final String id() {
        return this.id;
    }

    /**
     * API name: {@code index}
     */
    @Nullable
    public final String index() {
        return this.index;
    }

    /**
     * API name: {@code ip}
     */
    @Nullable
    public final String ip() {
        return this.ip;
    }

    /**
     * Whether this is a searchable snapshot.
     * <p>
     * API name: {@code isSearchableSnapshot}
     * </p>
     */
    @Nullable
    public final Boolean isSearchableSnapshot() {
        return this.isSearchableSnapshot;
    }

    /**
     * API name: {@code name}
     */
    @Nullable
    public final String name() {
        return this.name;
    }

    /**
     * Whether this is a shallow copy from a remote store.
     * <p>
     * API name: {@code remoteStoreIndexShallowCopy}
     * </p>
     */
    @Nullable
    public final Boolean remoteStoreIndexShallowCopy() {
        return this.remoteStoreIndexShallowCopy;
    }

    /**
     * API name: {@code repository}
     */
    @Nullable
    public final String repository() {
        return this.repository;
    }

    /**
     * API name: {@code restoreUUID}
     */
    @Nullable
    public final String restoreUuid() {
        return this.restoreUuid;
    }

    /**
     * API name: {@code snapshot}
     */
    @Nullable
    public final String snapshot() {
        return this.snapshot;
    }

    /**
     * The source remote store repository.
     * <p>
     * API name: {@code sourceRemoteStoreRepository}
     * </p>
     */
    @Nullable
    public final String sourceRemoteStoreRepository() {
        return this.sourceRemoteStoreRepository;
    }

    /**
     * The source remote translog repository.
     * <p>
     * API name: {@code sourceRemoteTranslogRepository}
     * </p>
     */
    @Nullable
    public final String sourceRemoteTranslogRepository() {
        return this.sourceRemoteTranslogRepository;
    }

    /**
     * API name: {@code transport_address}
     */
    @Nullable
    public final String transportAddress() {
        return this.transportAddress;
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
        if (this.bootstrapNewHistoryUuid != null) {
            generator.writeKey("bootstrap_new_history_uuid");
            generator.write(this.bootstrapNewHistoryUuid);
        }

        if (this.host != null) {
            generator.writeKey("host");
            generator.write(this.host);
        }

        if (this.hostname != null) {
            generator.writeKey("hostname");
            generator.write(this.hostname);
        }

        if (this.id != null) {
            generator.writeKey("id");
            generator.write(this.id);
        }

        if (this.index != null) {
            generator.writeKey("index");
            generator.write(this.index);
        }

        if (this.ip != null) {
            generator.writeKey("ip");
            generator.write(this.ip);
        }

        if (this.isSearchableSnapshot != null) {
            generator.writeKey("isSearchableSnapshot");
            generator.write(this.isSearchableSnapshot);
        }

        if (this.name != null) {
            generator.writeKey("name");
            generator.write(this.name);
        }

        if (this.remoteStoreIndexShallowCopy != null) {
            generator.writeKey("remoteStoreIndexShallowCopy");
            generator.write(this.remoteStoreIndexShallowCopy);
        }

        if (this.repository != null) {
            generator.writeKey("repository");
            generator.write(this.repository);
        }

        if (this.restoreUuid != null) {
            generator.writeKey("restoreUUID");
            generator.write(this.restoreUuid);
        }

        if (this.snapshot != null) {
            generator.writeKey("snapshot");
            generator.write(this.snapshot);
        }

        if (this.sourceRemoteStoreRepository != null) {
            generator.writeKey("sourceRemoteStoreRepository");
            generator.write(this.sourceRemoteStoreRepository);
        }

        if (this.sourceRemoteTranslogRepository != null) {
            generator.writeKey("sourceRemoteTranslogRepository");
            generator.write(this.sourceRemoteTranslogRepository);
        }

        if (this.transportAddress != null) {
            generator.writeKey("transport_address");
            generator.write(this.transportAddress);
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
     * Builder for {@link RecoveryOrigin}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, RecoveryOrigin> {
        @Nullable
        private Boolean bootstrapNewHistoryUuid;
        @Nullable
        private String host;
        @Nullable
        private String hostname;
        @Nullable
        private String id;
        @Nullable
        private String index;
        @Nullable
        private String ip;
        @Nullable
        private Boolean isSearchableSnapshot;
        @Nullable
        private String name;
        @Nullable
        private Boolean remoteStoreIndexShallowCopy;
        @Nullable
        private String repository;
        @Nullable
        private String restoreUuid;
        @Nullable
        private String snapshot;
        @Nullable
        private String sourceRemoteStoreRepository;
        @Nullable
        private String sourceRemoteTranslogRepository;
        @Nullable
        private String transportAddress;
        @Nullable
        private String version;

        public Builder() {}

        private Builder(RecoveryOrigin o) {
            this.bootstrapNewHistoryUuid = o.bootstrapNewHistoryUuid;
            this.host = o.host;
            this.hostname = o.hostname;
            this.id = o.id;
            this.index = o.index;
            this.ip = o.ip;
            this.isSearchableSnapshot = o.isSearchableSnapshot;
            this.name = o.name;
            this.remoteStoreIndexShallowCopy = o.remoteStoreIndexShallowCopy;
            this.repository = o.repository;
            this.restoreUuid = o.restoreUuid;
            this.snapshot = o.snapshot;
            this.sourceRemoteStoreRepository = o.sourceRemoteStoreRepository;
            this.sourceRemoteTranslogRepository = o.sourceRemoteTranslogRepository;
            this.transportAddress = o.transportAddress;
            this.version = o.version;
        }

        private Builder(Builder o) {
            this.bootstrapNewHistoryUuid = o.bootstrapNewHistoryUuid;
            this.host = o.host;
            this.hostname = o.hostname;
            this.id = o.id;
            this.index = o.index;
            this.ip = o.ip;
            this.isSearchableSnapshot = o.isSearchableSnapshot;
            this.name = o.name;
            this.remoteStoreIndexShallowCopy = o.remoteStoreIndexShallowCopy;
            this.repository = o.repository;
            this.restoreUuid = o.restoreUuid;
            this.snapshot = o.snapshot;
            this.sourceRemoteStoreRepository = o.sourceRemoteStoreRepository;
            this.sourceRemoteTranslogRepository = o.sourceRemoteTranslogRepository;
            this.transportAddress = o.transportAddress;
            this.version = o.version;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Whether a new history UUID was bootstrapped.
         * <p>
         * API name: {@code bootstrap_new_history_uuid}
         * </p>
         */
        @Nonnull
        public final Builder bootstrapNewHistoryUuid(@Nullable Boolean value) {
            this.bootstrapNewHistoryUuid = value;
            return this;
        }

        /**
         * API name: {@code host}
         */
        @Nonnull
        public final Builder host(@Nullable String value) {
            this.host = value;
            return this;
        }

        /**
         * The hostname of the node.
         * <p>
         * API name: {@code hostname}
         * </p>
         */
        @Nonnull
        public final Builder hostname(@Nullable String value) {
            this.hostname = value;
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
         * API name: {@code index}
         */
        @Nonnull
        public final Builder index(@Nullable String value) {
            this.index = value;
            return this;
        }

        /**
         * API name: {@code ip}
         */
        @Nonnull
        public final Builder ip(@Nullable String value) {
            this.ip = value;
            return this;
        }

        /**
         * Whether this is a searchable snapshot.
         * <p>
         * API name: {@code isSearchableSnapshot}
         * </p>
         */
        @Nonnull
        public final Builder isSearchableSnapshot(@Nullable Boolean value) {
            this.isSearchableSnapshot = value;
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
         * Whether this is a shallow copy from a remote store.
         * <p>
         * API name: {@code remoteStoreIndexShallowCopy}
         * </p>
         */
        @Nonnull
        public final Builder remoteStoreIndexShallowCopy(@Nullable Boolean value) {
            this.remoteStoreIndexShallowCopy = value;
            return this;
        }

        /**
         * API name: {@code repository}
         */
        @Nonnull
        public final Builder repository(@Nullable String value) {
            this.repository = value;
            return this;
        }

        /**
         * API name: {@code restoreUUID}
         */
        @Nonnull
        public final Builder restoreUuid(@Nullable String value) {
            this.restoreUuid = value;
            return this;
        }

        /**
         * API name: {@code snapshot}
         */
        @Nonnull
        public final Builder snapshot(@Nullable String value) {
            this.snapshot = value;
            return this;
        }

        /**
         * The source remote store repository.
         * <p>
         * API name: {@code sourceRemoteStoreRepository}
         * </p>
         */
        @Nonnull
        public final Builder sourceRemoteStoreRepository(@Nullable String value) {
            this.sourceRemoteStoreRepository = value;
            return this;
        }

        /**
         * The source remote translog repository.
         * <p>
         * API name: {@code sourceRemoteTranslogRepository}
         * </p>
         */
        @Nonnull
        public final Builder sourceRemoteTranslogRepository(@Nullable String value) {
            this.sourceRemoteTranslogRepository = value;
            return this;
        }

        /**
         * API name: {@code transport_address}
         */
        @Nonnull
        public final Builder transportAddress(@Nullable String value) {
            this.transportAddress = value;
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
         * Builds a {@link RecoveryOrigin}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public RecoveryOrigin build() {
            _checkSingleUse();

            return new RecoveryOrigin(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link RecoveryOrigin}
     */
    public static final JsonpDeserializer<RecoveryOrigin> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        RecoveryOrigin::setupRecoveryOriginDeserializer
    );

    protected static void setupRecoveryOriginDeserializer(ObjectDeserializer<RecoveryOrigin.Builder> op) {
        op.add(Builder::bootstrapNewHistoryUuid, JsonpDeserializer.booleanDeserializer(), "bootstrap_new_history_uuid");
        op.add(Builder::host, JsonpDeserializer.stringDeserializer(), "host");
        op.add(Builder::hostname, JsonpDeserializer.stringDeserializer(), "hostname");
        op.add(Builder::id, JsonpDeserializer.stringDeserializer(), "id");
        op.add(Builder::index, JsonpDeserializer.stringDeserializer(), "index");
        op.add(Builder::ip, JsonpDeserializer.stringDeserializer(), "ip");
        op.add(Builder::isSearchableSnapshot, JsonpDeserializer.booleanDeserializer(), "isSearchableSnapshot");
        op.add(Builder::name, JsonpDeserializer.stringDeserializer(), "name");
        op.add(Builder::remoteStoreIndexShallowCopy, JsonpDeserializer.booleanDeserializer(), "remoteStoreIndexShallowCopy");
        op.add(Builder::repository, JsonpDeserializer.stringDeserializer(), "repository");
        op.add(Builder::restoreUuid, JsonpDeserializer.stringDeserializer(), "restoreUUID");
        op.add(Builder::snapshot, JsonpDeserializer.stringDeserializer(), "snapshot");
        op.add(Builder::sourceRemoteStoreRepository, JsonpDeserializer.stringDeserializer(), "sourceRemoteStoreRepository");
        op.add(Builder::sourceRemoteTranslogRepository, JsonpDeserializer.stringDeserializer(), "sourceRemoteTranslogRepository");
        op.add(Builder::transportAddress, JsonpDeserializer.stringDeserializer(), "transport_address");
        op.add(Builder::version, JsonpDeserializer.stringDeserializer(), "version");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.bootstrapNewHistoryUuid);
        result = 31 * result + Objects.hashCode(this.host);
        result = 31 * result + Objects.hashCode(this.hostname);
        result = 31 * result + Objects.hashCode(this.id);
        result = 31 * result + Objects.hashCode(this.index);
        result = 31 * result + Objects.hashCode(this.ip);
        result = 31 * result + Objects.hashCode(this.isSearchableSnapshot);
        result = 31 * result + Objects.hashCode(this.name);
        result = 31 * result + Objects.hashCode(this.remoteStoreIndexShallowCopy);
        result = 31 * result + Objects.hashCode(this.repository);
        result = 31 * result + Objects.hashCode(this.restoreUuid);
        result = 31 * result + Objects.hashCode(this.snapshot);
        result = 31 * result + Objects.hashCode(this.sourceRemoteStoreRepository);
        result = 31 * result + Objects.hashCode(this.sourceRemoteTranslogRepository);
        result = 31 * result + Objects.hashCode(this.transportAddress);
        result = 31 * result + Objects.hashCode(this.version);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        RecoveryOrigin other = (RecoveryOrigin) o;
        return Objects.equals(this.bootstrapNewHistoryUuid, other.bootstrapNewHistoryUuid)
            && Objects.equals(this.host, other.host)
            && Objects.equals(this.hostname, other.hostname)
            && Objects.equals(this.id, other.id)
            && Objects.equals(this.index, other.index)
            && Objects.equals(this.ip, other.ip)
            && Objects.equals(this.isSearchableSnapshot, other.isSearchableSnapshot)
            && Objects.equals(this.name, other.name)
            && Objects.equals(this.remoteStoreIndexShallowCopy, other.remoteStoreIndexShallowCopy)
            && Objects.equals(this.repository, other.repository)
            && Objects.equals(this.restoreUuid, other.restoreUuid)
            && Objects.equals(this.snapshot, other.snapshot)
            && Objects.equals(this.sourceRemoteStoreRepository, other.sourceRemoteStoreRepository)
            && Objects.equals(this.sourceRemoteTranslogRepository, other.sourceRemoteTranslogRepository)
            && Objects.equals(this.transportAddress, other.transportAddress)
            && Objects.equals(this.version, other.version);
    }
}
