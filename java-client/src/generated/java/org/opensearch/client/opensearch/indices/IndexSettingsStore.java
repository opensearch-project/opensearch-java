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

package org.opensearch.client.opensearch.indices;

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
import org.opensearch.client.opensearch._types.Time;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: indices.IndexSettingsStore

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class IndexSettingsStore implements PlainJsonSerializable, ToCopyableBuilder<IndexSettingsStore.Builder, IndexSettingsStore> {

    @Nullable
    private final Boolean allowMmap;

    @Nullable
    private final IndexSettingsStoreFs fs;

    @Nullable
    private final IndexSettingsStoreHybrid hybrid;

    @Nonnull
    private final List<String> preload;

    @Nullable
    private final Time statsRefreshInterval;

    @Nonnull
    private final StorageType type;

    // ---------------------------------------------------------------------------------------------

    private IndexSettingsStore(Builder builder) {
        this.allowMmap = builder.allowMmap;
        this.fs = builder.fs;
        this.hybrid = builder.hybrid;
        this.preload = ApiTypeHelper.unmodifiable(builder.preload);
        this.statsRefreshInterval = builder.statsRefreshInterval;
        this.type = ApiTypeHelper.requireNonNull(builder.type, this, "type");
    }

    public static IndexSettingsStore of(Function<IndexSettingsStore.Builder, ObjectBuilder<IndexSettingsStore>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Whether memory-mapping is allowed. You can restrict the use of the <code>mmapfs</code> and the related <code>hybridfs</code> store
     * types with the setting <code>node.store.allow_mmap</code>. This setting is useful, for example, if you are in an environment where
     * you can not control the ability to create a lot of memory maps so you need disable the ability to use memory-mapping.
     * <p>
     * API name: {@code allow_mmap}
     * </p>
     */
    @Nullable
    public final Boolean allowMmap() {
        return this.allowMmap;
    }

    /**
     * API name: {@code fs}
     */
    @Nullable
    public final IndexSettingsStoreFs fs() {
        return this.fs;
    }

    /**
     * API name: {@code hybrid}
     */
    @Nullable
    public final IndexSettingsStoreHybrid hybrid() {
        return this.hybrid;
    }

    /**
     * The list of files to preload into memory.
     * <p>
     * API name: {@code preload}
     * </p>
     */
    @Nonnull
    public final List<String> preload() {
        return this.preload;
    }

    /**
     * API name: {@code stats_refresh_interval}
     */
    @Nullable
    public final Time statsRefreshInterval() {
        return this.statsRefreshInterval;
    }

    /**
     * Required - API name: {@code type}
     */
    @Nonnull
    public final StorageType type() {
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
        if (this.allowMmap != null) {
            generator.writeKey("allow_mmap");
            generator.write(this.allowMmap);
        }

        if (this.fs != null) {
            generator.writeKey("fs");
            this.fs.serialize(generator, mapper);
        }

        if (this.hybrid != null) {
            generator.writeKey("hybrid");
            this.hybrid.serialize(generator, mapper);
        }

        if (ApiTypeHelper.isDefined(this.preload)) {
            generator.writeKey("preload");
            generator.writeStartArray();
            for (String item0 : this.preload) {
                generator.write(item0);
            }
            generator.writeEnd();
        }

        if (this.statsRefreshInterval != null) {
            generator.writeKey("stats_refresh_interval");
            this.statsRefreshInterval.serialize(generator, mapper);
        }

        generator.writeKey("type");
        this.type.serialize(generator, mapper);
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
     * Builder for {@link IndexSettingsStore}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, IndexSettingsStore> {
        @Nullable
        private Boolean allowMmap;
        @Nullable
        private IndexSettingsStoreFs fs;
        @Nullable
        private IndexSettingsStoreHybrid hybrid;
        @Nullable
        private List<String> preload;
        @Nullable
        private Time statsRefreshInterval;
        private StorageType type;

        public Builder() {}

        private Builder(IndexSettingsStore o) {
            this.allowMmap = o.allowMmap;
            this.fs = o.fs;
            this.hybrid = o.hybrid;
            this.preload = _listCopy(o.preload);
            this.statsRefreshInterval = o.statsRefreshInterval;
            this.type = o.type;
        }

        private Builder(Builder o) {
            this.allowMmap = o.allowMmap;
            this.fs = o.fs;
            this.hybrid = o.hybrid;
            this.preload = _listCopy(o.preload);
            this.statsRefreshInterval = o.statsRefreshInterval;
            this.type = o.type;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Whether memory-mapping is allowed. You can restrict the use of the <code>mmapfs</code> and the related <code>hybridfs</code>
         * store types with the setting <code>node.store.allow_mmap</code>. This setting is useful, for example, if you are in an
         * environment where you can not control the ability to create a lot of memory maps so you need disable the ability to use
         * memory-mapping.
         * <p>
         * API name: {@code allow_mmap}
         * </p>
         */
        @Nonnull
        public final Builder allowMmap(@Nullable Boolean value) {
            this.allowMmap = value;
            return this;
        }

        /**
         * API name: {@code fs}
         */
        @Nonnull
        public final Builder fs(@Nullable IndexSettingsStoreFs value) {
            this.fs = value;
            return this;
        }

        /**
         * API name: {@code fs}
         */
        @Nonnull
        public final Builder fs(Function<IndexSettingsStoreFs.Builder, ObjectBuilder<IndexSettingsStoreFs>> fn) {
            return fs(fn.apply(new IndexSettingsStoreFs.Builder()).build());
        }

        /**
         * API name: {@code hybrid}
         */
        @Nonnull
        public final Builder hybrid(@Nullable IndexSettingsStoreHybrid value) {
            this.hybrid = value;
            return this;
        }

        /**
         * API name: {@code hybrid}
         */
        @Nonnull
        public final Builder hybrid(Function<IndexSettingsStoreHybrid.Builder, ObjectBuilder<IndexSettingsStoreHybrid>> fn) {
            return hybrid(fn.apply(new IndexSettingsStoreHybrid.Builder()).build());
        }

        /**
         * The list of files to preload into memory.
         * <p>
         * API name: {@code preload}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>preload</code>.
         * </p>
         */
        @Nonnull
        public final Builder preload(List<String> list) {
            this.preload = _listAddAll(this.preload, list);
            return this;
        }

        /**
         * The list of files to preload into memory.
         * <p>
         * API name: {@code preload}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>preload</code>.
         * </p>
         */
        @Nonnull
        public final Builder preload(String value, String... values) {
            this.preload = _listAdd(this.preload, value, values);
            return this;
        }

        /**
         * API name: {@code stats_refresh_interval}
         */
        @Nonnull
        public final Builder statsRefreshInterval(@Nullable Time value) {
            this.statsRefreshInterval = value;
            return this;
        }

        /**
         * API name: {@code stats_refresh_interval}
         */
        @Nonnull
        public final Builder statsRefreshInterval(Function<Time.Builder, ObjectBuilder<Time>> fn) {
            return statsRefreshInterval(fn.apply(new Time.Builder()).build());
        }

        /**
         * Required - API name: {@code type}
         */
        @Nonnull
        public final Builder type(StorageType value) {
            this.type = value;
            return this;
        }

        /**
         * Required - API name: {@code type}
         */
        @Nonnull
        public final Builder type(Function<StorageType.Builder, ObjectBuilder<StorageType>> fn) {
            return type(fn.apply(new StorageType.Builder()).build());
        }

        /**
         * Builds a {@link IndexSettingsStore}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public IndexSettingsStore build() {
            _checkSingleUse();

            return new IndexSettingsStore(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link IndexSettingsStore}
     */
    public static final JsonpDeserializer<IndexSettingsStore> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        IndexSettingsStore::setupIndexSettingsStoreDeserializer
    );

    protected static void setupIndexSettingsStoreDeserializer(ObjectDeserializer<IndexSettingsStore.Builder> op) {
        op.add(Builder::allowMmap, JsonpDeserializer.booleanDeserializer(), "allow_mmap");
        op.add(Builder::fs, IndexSettingsStoreFs._DESERIALIZER, "fs");
        op.add(Builder::hybrid, IndexSettingsStoreHybrid._DESERIALIZER, "hybrid");
        op.add(Builder::preload, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "preload");
        op.add(Builder::statsRefreshInterval, Time._DESERIALIZER, "stats_refresh_interval");
        op.add(Builder::type, StorageType._DESERIALIZER, "type");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.allowMmap);
        result = 31 * result + Objects.hashCode(this.fs);
        result = 31 * result + Objects.hashCode(this.hybrid);
        result = 31 * result + Objects.hashCode(this.preload);
        result = 31 * result + Objects.hashCode(this.statsRefreshInterval);
        result = 31 * result + this.type.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        IndexSettingsStore other = (IndexSettingsStore) o;
        return Objects.equals(this.allowMmap, other.allowMmap)
            && Objects.equals(this.fs, other.fs)
            && Objects.equals(this.hybrid, other.hybrid)
            && Objects.equals(this.preload, other.preload)
            && Objects.equals(this.statsRefreshInterval, other.statsRefreshInterval)
            && this.type.equals(other.type);
    }
}
