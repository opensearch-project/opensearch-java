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
import org.opensearch.client.opensearch.indices.stats.ShardFileSizeInfo;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: _types.SegmentsStats

/**
 * The statistics about segments.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class SegmentsStats implements PlainJsonSerializable, ToCopyableBuilder<SegmentsStats.Builder, SegmentsStats> {

    private final int count;

    @Nullable
    private final String docValuesMemory;

    private final long docValuesMemoryInBytes;

    @Nonnull
    private final Map<String, ShardFileSizeInfo> fileSizes;

    @Nullable
    private final String fixedBitSet;

    private final long fixedBitSetMemoryInBytes;

    @Nullable
    private final Long indexWriterMaxMemoryInBytes;

    @Nullable
    private final String indexWriterMemory;

    private final long indexWriterMemoryInBytes;

    private final long maxUnsafeAutoIdTimestamp;

    @Nullable
    private final String memory;

    private final long memoryInBytes;

    @Nullable
    private final String normsMemory;

    private final long normsMemoryInBytes;

    @Nullable
    private final String pointsMemory;

    private final long pointsMemoryInBytes;

    @Nullable
    private final RemoteStoreStats remoteStore;

    @Nullable
    private final SegmentReplicationStats segmentReplication;

    @Nullable
    private final String storedFieldsMemory;

    private final long storedFieldsMemoryInBytes;

    @Nullable
    private final String termVectorsMemory;

    private final long termVectorsMemoryInBytes;

    @Nullable
    private final String termsMemory;

    private final long termsMemoryInBytes;

    @Nullable
    private final String versionMapMemory;

    private final long versionMapMemoryInBytes;

    // ---------------------------------------------------------------------------------------------

    private SegmentsStats(Builder builder) {
        this.count = ApiTypeHelper.requireNonNull(builder.count, this, "count");
        this.docValuesMemory = builder.docValuesMemory;
        this.docValuesMemoryInBytes = ApiTypeHelper.requireNonNull(builder.docValuesMemoryInBytes, this, "docValuesMemoryInBytes");
        this.fileSizes = ApiTypeHelper.unmodifiableRequired(builder.fileSizes, this, "fileSizes");
        this.fixedBitSet = builder.fixedBitSet;
        this.fixedBitSetMemoryInBytes = ApiTypeHelper.requireNonNull(builder.fixedBitSetMemoryInBytes, this, "fixedBitSetMemoryInBytes");
        this.indexWriterMaxMemoryInBytes = builder.indexWriterMaxMemoryInBytes;
        this.indexWriterMemory = builder.indexWriterMemory;
        this.indexWriterMemoryInBytes = ApiTypeHelper.requireNonNull(builder.indexWriterMemoryInBytes, this, "indexWriterMemoryInBytes");
        this.maxUnsafeAutoIdTimestamp = ApiTypeHelper.requireNonNull(builder.maxUnsafeAutoIdTimestamp, this, "maxUnsafeAutoIdTimestamp");
        this.memory = builder.memory;
        this.memoryInBytes = ApiTypeHelper.requireNonNull(builder.memoryInBytes, this, "memoryInBytes");
        this.normsMemory = builder.normsMemory;
        this.normsMemoryInBytes = ApiTypeHelper.requireNonNull(builder.normsMemoryInBytes, this, "normsMemoryInBytes");
        this.pointsMemory = builder.pointsMemory;
        this.pointsMemoryInBytes = ApiTypeHelper.requireNonNull(builder.pointsMemoryInBytes, this, "pointsMemoryInBytes");
        this.remoteStore = builder.remoteStore;
        this.segmentReplication = builder.segmentReplication;
        this.storedFieldsMemory = builder.storedFieldsMemory;
        this.storedFieldsMemoryInBytes = ApiTypeHelper.requireNonNull(builder.storedFieldsMemoryInBytes, this, "storedFieldsMemoryInBytes");
        this.termVectorsMemory = builder.termVectorsMemory;
        this.termVectorsMemoryInBytes = ApiTypeHelper.requireNonNull(builder.termVectorsMemoryInBytes, this, "termVectorsMemoryInBytes");
        this.termsMemory = builder.termsMemory;
        this.termsMemoryInBytes = ApiTypeHelper.requireNonNull(builder.termsMemoryInBytes, this, "termsMemoryInBytes");
        this.versionMapMemory = builder.versionMapMemory;
        this.versionMapMemoryInBytes = ApiTypeHelper.requireNonNull(builder.versionMapMemoryInBytes, this, "versionMapMemoryInBytes");
    }

    public static SegmentsStats of(Function<SegmentsStats.Builder, ObjectBuilder<SegmentsStats>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - The total number of segments across all shards assigned to the selected nodes.
     * <p>
     * API name: {@code count}
     * </p>
     */
    public final int count() {
        return this.count;
    }

    /**
     * The human-readable amount of memory used for doc values.
     * <p>
     * API name: {@code doc_values_memory}
     * </p>
     */
    @Nullable
    public final String docValuesMemory() {
        return this.docValuesMemory;
    }

    /**
     * Required - The total amount, in bytes, of memory used for document values across all shards assigned to the selected nodes.
     * <p>
     * API name: {@code doc_values_memory_in_bytes}
     * </p>
     */
    public final long docValuesMemoryInBytes() {
        return this.docValuesMemoryInBytes;
    }

    /**
     * Required - This object is not populated by the cluster stats API. To get information on segment files, use the node stats API.
     * <p>
     * API name: {@code file_sizes}
     * </p>
     */
    @Nonnull
    public final Map<String, ShardFileSizeInfo> fileSizes() {
        return this.fileSizes;
    }

    /**
     * API name: {@code fixed_bit_set}
     */
    @Nullable
    public final String fixedBitSet() {
        return this.fixedBitSet;
    }

    /**
     * Required - The total amount of memory, in bytes, used by fixed bit sets across all shards assigned to the selected nodes.
     * <p>
     * API name: {@code fixed_bit_set_memory_in_bytes}
     * </p>
     */
    public final long fixedBitSetMemoryInBytes() {
        return this.fixedBitSetMemoryInBytes;
    }

    /**
     * The maximum amount of memory, in bytes, used by index writers.
     * <p>
     * API name: {@code index_writer_max_memory_in_bytes}
     * </p>
     */
    @Nullable
    public final Long indexWriterMaxMemoryInBytes() {
        return this.indexWriterMaxMemoryInBytes;
    }

    /**
     * The human-readable amount of memory used by index writers.
     * <p>
     * API name: {@code index_writer_memory}
     * </p>
     */
    @Nullable
    public final String indexWriterMemory() {
        return this.indexWriterMemory;
    }

    /**
     * Required - The total amount, in bytes, of memory used by all index writers across all shards assigned to the selected nodes.
     * <p>
     * API name: {@code index_writer_memory_in_bytes}
     * </p>
     */
    public final long indexWriterMemoryInBytes() {
        return this.indexWriterMemoryInBytes;
    }

    /**
     * Required - The Unix timestamp, in milliseconds, of the most recently retried indexing request.
     * <p>
     * API name: {@code max_unsafe_auto_id_timestamp}
     * </p>
     */
    public final long maxUnsafeAutoIdTimestamp() {
        return this.maxUnsafeAutoIdTimestamp;
    }

    /**
     * The total amount of memory used for segments across all shards assigned to the selected nodes.
     * <p>
     * API name: {@code memory}
     * </p>
     */
    @Nullable
    public final String memory() {
        return this.memory;
    }

    /**
     * Required - The total amount, in bytes, of memory used for segments across all shards assigned to the selected nodes.
     * <p>
     * API name: {@code memory_in_bytes}
     * </p>
     */
    public final long memoryInBytes() {
        return this.memoryInBytes;
    }

    /**
     * The total amount of memory used for normalization factors across all shards assigned to the selected nodes.
     * <p>
     * API name: {@code norms_memory}
     * </p>
     */
    @Nullable
    public final String normsMemory() {
        return this.normsMemory;
    }

    /**
     * Required - The total amount, in bytes, of memory used for normalization factors across all shards assigned to the selected nodes.
     * <p>
     * API name: {@code norms_memory_in_bytes}
     * </p>
     */
    public final long normsMemoryInBytes() {
        return this.normsMemoryInBytes;
    }

    /**
     * The total amount of memory used for points across all shards assigned to the selected nodes.
     * <p>
     * API name: {@code points_memory}
     * </p>
     */
    @Nullable
    public final String pointsMemory() {
        return this.pointsMemory;
    }

    /**
     * Required - The total amount, in bytes, of memory used for points across all shards assigned to the selected nodes.
     * <p>
     * API name: {@code points_memory_in_bytes}
     * </p>
     */
    public final long pointsMemoryInBytes() {
        return this.pointsMemoryInBytes;
    }

    /**
     * API name: {@code remote_store}
     */
    @Nullable
    public final RemoteStoreStats remoteStore() {
        return this.remoteStore;
    }

    /**
     * API name: {@code segment_replication}
     */
    @Nullable
    public final SegmentReplicationStats segmentReplication() {
        return this.segmentReplication;
    }

    /**
     * The total amount of memory used for stored fields across all shards assigned to the selected nodes.
     * <p>
     * API name: {@code stored_fields_memory}
     * </p>
     */
    @Nullable
    public final String storedFieldsMemory() {
        return this.storedFieldsMemory;
    }

    /**
     * Required - The total amount, in bytes, of memory used for stored fields across all shards assigned to the selected nodes.
     * <p>
     * API name: {@code stored_fields_memory_in_bytes}
     * </p>
     */
    public final long storedFieldsMemoryInBytes() {
        return this.storedFieldsMemoryInBytes;
    }

    /**
     * The total amount of memory used for term vectors across all shards assigned to the selected nodes.
     * <p>
     * API name: {@code term_vectors_memory}
     * </p>
     */
    @Nullable
    public final String termVectorsMemory() {
        return this.termVectorsMemory;
    }

    /**
     * Required - The total amount, in bytes, of memory used for term vectors across all shards assigned to the selected nodes.
     * <p>
     * API name: {@code term_vectors_memory_in_bytes}
     * </p>
     */
    public final long termVectorsMemoryInBytes() {
        return this.termVectorsMemoryInBytes;
    }

    /**
     * The total amount of memory used for terms across all shards assigned to the selected nodes.
     * <p>
     * API name: {@code terms_memory}
     * </p>
     */
    @Nullable
    public final String termsMemory() {
        return this.termsMemory;
    }

    /**
     * Required - The total amount, in bytes, of memory used for terms across all shards assigned to the selected nodes.
     * <p>
     * API name: {@code terms_memory_in_bytes}
     * </p>
     */
    public final long termsMemoryInBytes() {
        return this.termsMemoryInBytes;
    }

    /**
     * The total amount of memory used by all version maps across all shards assigned to the selected nodes.
     * <p>
     * API name: {@code version_map_memory}
     * </p>
     */
    @Nullable
    public final String versionMapMemory() {
        return this.versionMapMemory;
    }

    /**
     * Required - The total amount, in bytes, of memory used by all version maps across all shards assigned to the selected nodes.
     * <p>
     * API name: {@code version_map_memory_in_bytes}
     * </p>
     */
    public final long versionMapMemoryInBytes() {
        return this.versionMapMemoryInBytes;
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
        generator.writeKey("count");
        generator.write(this.count);

        if (this.docValuesMemory != null) {
            generator.writeKey("doc_values_memory");
            generator.write(this.docValuesMemory);
        }

        generator.writeKey("doc_values_memory_in_bytes");
        generator.write(this.docValuesMemoryInBytes);

        generator.writeKey("file_sizes");
        generator.writeStartObject();
        for (Map.Entry<String, ShardFileSizeInfo> item0 : this.fileSizes.entrySet()) {
            generator.writeKey(item0.getKey());
            item0.getValue().serialize(generator, mapper);
        }
        generator.writeEnd();

        if (this.fixedBitSet != null) {
            generator.writeKey("fixed_bit_set");
            generator.write(this.fixedBitSet);
        }

        generator.writeKey("fixed_bit_set_memory_in_bytes");
        generator.write(this.fixedBitSetMemoryInBytes);

        if (this.indexWriterMaxMemoryInBytes != null) {
            generator.writeKey("index_writer_max_memory_in_bytes");
            generator.write(this.indexWriterMaxMemoryInBytes);
        }

        if (this.indexWriterMemory != null) {
            generator.writeKey("index_writer_memory");
            generator.write(this.indexWriterMemory);
        }

        generator.writeKey("index_writer_memory_in_bytes");
        generator.write(this.indexWriterMemoryInBytes);

        generator.writeKey("max_unsafe_auto_id_timestamp");
        generator.write(this.maxUnsafeAutoIdTimestamp);

        if (this.memory != null) {
            generator.writeKey("memory");
            generator.write(this.memory);
        }

        generator.writeKey("memory_in_bytes");
        generator.write(this.memoryInBytes);

        if (this.normsMemory != null) {
            generator.writeKey("norms_memory");
            generator.write(this.normsMemory);
        }

        generator.writeKey("norms_memory_in_bytes");
        generator.write(this.normsMemoryInBytes);

        if (this.pointsMemory != null) {
            generator.writeKey("points_memory");
            generator.write(this.pointsMemory);
        }

        generator.writeKey("points_memory_in_bytes");
        generator.write(this.pointsMemoryInBytes);

        if (this.remoteStore != null) {
            generator.writeKey("remote_store");
            this.remoteStore.serialize(generator, mapper);
        }

        if (this.segmentReplication != null) {
            generator.writeKey("segment_replication");
            this.segmentReplication.serialize(generator, mapper);
        }

        if (this.storedFieldsMemory != null) {
            generator.writeKey("stored_fields_memory");
            generator.write(this.storedFieldsMemory);
        }

        generator.writeKey("stored_fields_memory_in_bytes");
        generator.write(this.storedFieldsMemoryInBytes);

        if (this.termVectorsMemory != null) {
            generator.writeKey("term_vectors_memory");
            generator.write(this.termVectorsMemory);
        }

        generator.writeKey("term_vectors_memory_in_bytes");
        generator.write(this.termVectorsMemoryInBytes);

        if (this.termsMemory != null) {
            generator.writeKey("terms_memory");
            generator.write(this.termsMemory);
        }

        generator.writeKey("terms_memory_in_bytes");
        generator.write(this.termsMemoryInBytes);

        if (this.versionMapMemory != null) {
            generator.writeKey("version_map_memory");
            generator.write(this.versionMapMemory);
        }

        generator.writeKey("version_map_memory_in_bytes");
        generator.write(this.versionMapMemoryInBytes);
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
     * Builder for {@link SegmentsStats}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, SegmentsStats> {
        private Integer count;
        @Nullable
        private String docValuesMemory;
        private Long docValuesMemoryInBytes;
        private Map<String, ShardFileSizeInfo> fileSizes;
        @Nullable
        private String fixedBitSet;
        private Long fixedBitSetMemoryInBytes;
        @Nullable
        private Long indexWriterMaxMemoryInBytes;
        @Nullable
        private String indexWriterMemory;
        private Long indexWriterMemoryInBytes;
        private Long maxUnsafeAutoIdTimestamp;
        @Nullable
        private String memory;
        private Long memoryInBytes;
        @Nullable
        private String normsMemory;
        private Long normsMemoryInBytes;
        @Nullable
        private String pointsMemory;
        private Long pointsMemoryInBytes;
        @Nullable
        private RemoteStoreStats remoteStore;
        @Nullable
        private SegmentReplicationStats segmentReplication;
        @Nullable
        private String storedFieldsMemory;
        private Long storedFieldsMemoryInBytes;
        @Nullable
        private String termVectorsMemory;
        private Long termVectorsMemoryInBytes;
        @Nullable
        private String termsMemory;
        private Long termsMemoryInBytes;
        @Nullable
        private String versionMapMemory;
        private Long versionMapMemoryInBytes;

        public Builder() {}

        private Builder(SegmentsStats o) {
            this.count = o.count;
            this.docValuesMemory = o.docValuesMemory;
            this.docValuesMemoryInBytes = o.docValuesMemoryInBytes;
            this.fileSizes = _mapCopy(o.fileSizes);
            this.fixedBitSet = o.fixedBitSet;
            this.fixedBitSetMemoryInBytes = o.fixedBitSetMemoryInBytes;
            this.indexWriterMaxMemoryInBytes = o.indexWriterMaxMemoryInBytes;
            this.indexWriterMemory = o.indexWriterMemory;
            this.indexWriterMemoryInBytes = o.indexWriterMemoryInBytes;
            this.maxUnsafeAutoIdTimestamp = o.maxUnsafeAutoIdTimestamp;
            this.memory = o.memory;
            this.memoryInBytes = o.memoryInBytes;
            this.normsMemory = o.normsMemory;
            this.normsMemoryInBytes = o.normsMemoryInBytes;
            this.pointsMemory = o.pointsMemory;
            this.pointsMemoryInBytes = o.pointsMemoryInBytes;
            this.remoteStore = o.remoteStore;
            this.segmentReplication = o.segmentReplication;
            this.storedFieldsMemory = o.storedFieldsMemory;
            this.storedFieldsMemoryInBytes = o.storedFieldsMemoryInBytes;
            this.termVectorsMemory = o.termVectorsMemory;
            this.termVectorsMemoryInBytes = o.termVectorsMemoryInBytes;
            this.termsMemory = o.termsMemory;
            this.termsMemoryInBytes = o.termsMemoryInBytes;
            this.versionMapMemory = o.versionMapMemory;
            this.versionMapMemoryInBytes = o.versionMapMemoryInBytes;
        }

        private Builder(Builder o) {
            this.count = o.count;
            this.docValuesMemory = o.docValuesMemory;
            this.docValuesMemoryInBytes = o.docValuesMemoryInBytes;
            this.fileSizes = _mapCopy(o.fileSizes);
            this.fixedBitSet = o.fixedBitSet;
            this.fixedBitSetMemoryInBytes = o.fixedBitSetMemoryInBytes;
            this.indexWriterMaxMemoryInBytes = o.indexWriterMaxMemoryInBytes;
            this.indexWriterMemory = o.indexWriterMemory;
            this.indexWriterMemoryInBytes = o.indexWriterMemoryInBytes;
            this.maxUnsafeAutoIdTimestamp = o.maxUnsafeAutoIdTimestamp;
            this.memory = o.memory;
            this.memoryInBytes = o.memoryInBytes;
            this.normsMemory = o.normsMemory;
            this.normsMemoryInBytes = o.normsMemoryInBytes;
            this.pointsMemory = o.pointsMemory;
            this.pointsMemoryInBytes = o.pointsMemoryInBytes;
            this.remoteStore = o.remoteStore;
            this.segmentReplication = o.segmentReplication;
            this.storedFieldsMemory = o.storedFieldsMemory;
            this.storedFieldsMemoryInBytes = o.storedFieldsMemoryInBytes;
            this.termVectorsMemory = o.termVectorsMemory;
            this.termVectorsMemoryInBytes = o.termVectorsMemoryInBytes;
            this.termsMemory = o.termsMemory;
            this.termsMemoryInBytes = o.termsMemoryInBytes;
            this.versionMapMemory = o.versionMapMemory;
            this.versionMapMemoryInBytes = o.versionMapMemoryInBytes;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - The total number of segments across all shards assigned to the selected nodes.
         * <p>
         * API name: {@code count}
         * </p>
         */
        @Nonnull
        public final Builder count(int value) {
            this.count = value;
            return this;
        }

        /**
         * The human-readable amount of memory used for doc values.
         * <p>
         * API name: {@code doc_values_memory}
         * </p>
         */
        @Nonnull
        public final Builder docValuesMemory(@Nullable String value) {
            this.docValuesMemory = value;
            return this;
        }

        /**
         * Required - The total amount, in bytes, of memory used for document values across all shards assigned to the selected nodes.
         * <p>
         * API name: {@code doc_values_memory_in_bytes}
         * </p>
         */
        @Nonnull
        public final Builder docValuesMemoryInBytes(long value) {
            this.docValuesMemoryInBytes = value;
            return this;
        }

        /**
         * Required - This object is not populated by the cluster stats API. To get information on segment files, use the node stats API.
         * <p>
         * API name: {@code file_sizes}
         * </p>
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>fileSizes</code>.
         * </p>
         */
        @Nonnull
        public final Builder fileSizes(Map<String, ShardFileSizeInfo> map) {
            this.fileSizes = _mapPutAll(this.fileSizes, map);
            return this;
        }

        /**
         * Required - This object is not populated by the cluster stats API. To get information on segment files, use the node stats API.
         * <p>
         * API name: {@code file_sizes}
         * </p>
         *
         * <p>
         * Adds an entry to <code>fileSizes</code>.
         * </p>
         */
        @Nonnull
        public final Builder fileSizes(String key, ShardFileSizeInfo value) {
            this.fileSizes = _mapPut(this.fileSizes, key, value);
            return this;
        }

        /**
         * Required - This object is not populated by the cluster stats API. To get information on segment files, use the node stats API.
         * <p>
         * API name: {@code file_sizes}
         * </p>
         *
         * <p>
         * Adds a value to <code>fileSizes</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder fileSizes(String key, Function<ShardFileSizeInfo.Builder, ObjectBuilder<ShardFileSizeInfo>> fn) {
            return fileSizes(key, fn.apply(new ShardFileSizeInfo.Builder()).build());
        }

        /**
         * API name: {@code fixed_bit_set}
         */
        @Nonnull
        public final Builder fixedBitSet(@Nullable String value) {
            this.fixedBitSet = value;
            return this;
        }

        /**
         * Required - The total amount of memory, in bytes, used by fixed bit sets across all shards assigned to the selected nodes.
         * <p>
         * API name: {@code fixed_bit_set_memory_in_bytes}
         * </p>
         */
        @Nonnull
        public final Builder fixedBitSetMemoryInBytes(long value) {
            this.fixedBitSetMemoryInBytes = value;
            return this;
        }

        /**
         * The maximum amount of memory, in bytes, used by index writers.
         * <p>
         * API name: {@code index_writer_max_memory_in_bytes}
         * </p>
         */
        @Nonnull
        public final Builder indexWriterMaxMemoryInBytes(@Nullable Long value) {
            this.indexWriterMaxMemoryInBytes = value;
            return this;
        }

        /**
         * The human-readable amount of memory used by index writers.
         * <p>
         * API name: {@code index_writer_memory}
         * </p>
         */
        @Nonnull
        public final Builder indexWriterMemory(@Nullable String value) {
            this.indexWriterMemory = value;
            return this;
        }

        /**
         * Required - The total amount, in bytes, of memory used by all index writers across all shards assigned to the selected nodes.
         * <p>
         * API name: {@code index_writer_memory_in_bytes}
         * </p>
         */
        @Nonnull
        public final Builder indexWriterMemoryInBytes(long value) {
            this.indexWriterMemoryInBytes = value;
            return this;
        }

        /**
         * Required - The Unix timestamp, in milliseconds, of the most recently retried indexing request.
         * <p>
         * API name: {@code max_unsafe_auto_id_timestamp}
         * </p>
         */
        @Nonnull
        public final Builder maxUnsafeAutoIdTimestamp(long value) {
            this.maxUnsafeAutoIdTimestamp = value;
            return this;
        }

        /**
         * The total amount of memory used for segments across all shards assigned to the selected nodes.
         * <p>
         * API name: {@code memory}
         * </p>
         */
        @Nonnull
        public final Builder memory(@Nullable String value) {
            this.memory = value;
            return this;
        }

        /**
         * Required - The total amount, in bytes, of memory used for segments across all shards assigned to the selected nodes.
         * <p>
         * API name: {@code memory_in_bytes}
         * </p>
         */
        @Nonnull
        public final Builder memoryInBytes(long value) {
            this.memoryInBytes = value;
            return this;
        }

        /**
         * The total amount of memory used for normalization factors across all shards assigned to the selected nodes.
         * <p>
         * API name: {@code norms_memory}
         * </p>
         */
        @Nonnull
        public final Builder normsMemory(@Nullable String value) {
            this.normsMemory = value;
            return this;
        }

        /**
         * Required - The total amount, in bytes, of memory used for normalization factors across all shards assigned to the selected nodes.
         * <p>
         * API name: {@code norms_memory_in_bytes}
         * </p>
         */
        @Nonnull
        public final Builder normsMemoryInBytes(long value) {
            this.normsMemoryInBytes = value;
            return this;
        }

        /**
         * The total amount of memory used for points across all shards assigned to the selected nodes.
         * <p>
         * API name: {@code points_memory}
         * </p>
         */
        @Nonnull
        public final Builder pointsMemory(@Nullable String value) {
            this.pointsMemory = value;
            return this;
        }

        /**
         * Required - The total amount, in bytes, of memory used for points across all shards assigned to the selected nodes.
         * <p>
         * API name: {@code points_memory_in_bytes}
         * </p>
         */
        @Nonnull
        public final Builder pointsMemoryInBytes(long value) {
            this.pointsMemoryInBytes = value;
            return this;
        }

        /**
         * API name: {@code remote_store}
         */
        @Nonnull
        public final Builder remoteStore(@Nullable RemoteStoreStats value) {
            this.remoteStore = value;
            return this;
        }

        /**
         * API name: {@code remote_store}
         */
        @Nonnull
        public final Builder remoteStore(Function<RemoteStoreStats.Builder, ObjectBuilder<RemoteStoreStats>> fn) {
            return remoteStore(fn.apply(new RemoteStoreStats.Builder()).build());
        }

        /**
         * API name: {@code segment_replication}
         */
        @Nonnull
        public final Builder segmentReplication(@Nullable SegmentReplicationStats value) {
            this.segmentReplication = value;
            return this;
        }

        /**
         * API name: {@code segment_replication}
         */
        @Nonnull
        public final Builder segmentReplication(Function<SegmentReplicationStats.Builder, ObjectBuilder<SegmentReplicationStats>> fn) {
            return segmentReplication(fn.apply(new SegmentReplicationStats.Builder()).build());
        }

        /**
         * The total amount of memory used for stored fields across all shards assigned to the selected nodes.
         * <p>
         * API name: {@code stored_fields_memory}
         * </p>
         */
        @Nonnull
        public final Builder storedFieldsMemory(@Nullable String value) {
            this.storedFieldsMemory = value;
            return this;
        }

        /**
         * Required - The total amount, in bytes, of memory used for stored fields across all shards assigned to the selected nodes.
         * <p>
         * API name: {@code stored_fields_memory_in_bytes}
         * </p>
         */
        @Nonnull
        public final Builder storedFieldsMemoryInBytes(long value) {
            this.storedFieldsMemoryInBytes = value;
            return this;
        }

        /**
         * The total amount of memory used for term vectors across all shards assigned to the selected nodes.
         * <p>
         * API name: {@code term_vectors_memory}
         * </p>
         */
        @Nonnull
        public final Builder termVectorsMemory(@Nullable String value) {
            this.termVectorsMemory = value;
            return this;
        }

        /**
         * Required - The total amount, in bytes, of memory used for term vectors across all shards assigned to the selected nodes.
         * <p>
         * API name: {@code term_vectors_memory_in_bytes}
         * </p>
         */
        @Nonnull
        public final Builder termVectorsMemoryInBytes(long value) {
            this.termVectorsMemoryInBytes = value;
            return this;
        }

        /**
         * The total amount of memory used for terms across all shards assigned to the selected nodes.
         * <p>
         * API name: {@code terms_memory}
         * </p>
         */
        @Nonnull
        public final Builder termsMemory(@Nullable String value) {
            this.termsMemory = value;
            return this;
        }

        /**
         * Required - The total amount, in bytes, of memory used for terms across all shards assigned to the selected nodes.
         * <p>
         * API name: {@code terms_memory_in_bytes}
         * </p>
         */
        @Nonnull
        public final Builder termsMemoryInBytes(long value) {
            this.termsMemoryInBytes = value;
            return this;
        }

        /**
         * The total amount of memory used by all version maps across all shards assigned to the selected nodes.
         * <p>
         * API name: {@code version_map_memory}
         * </p>
         */
        @Nonnull
        public final Builder versionMapMemory(@Nullable String value) {
            this.versionMapMemory = value;
            return this;
        }

        /**
         * Required - The total amount, in bytes, of memory used by all version maps across all shards assigned to the selected nodes.
         * <p>
         * API name: {@code version_map_memory_in_bytes}
         * </p>
         */
        @Nonnull
        public final Builder versionMapMemoryInBytes(long value) {
            this.versionMapMemoryInBytes = value;
            return this;
        }

        /**
         * Builds a {@link SegmentsStats}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public SegmentsStats build() {
            _checkSingleUse();

            return new SegmentsStats(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link SegmentsStats}
     */
    public static final JsonpDeserializer<SegmentsStats> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        SegmentsStats::setupSegmentsStatsDeserializer
    );

    protected static void setupSegmentsStatsDeserializer(ObjectDeserializer<SegmentsStats.Builder> op) {
        op.add(Builder::count, JsonpDeserializer.integerDeserializer(), "count");
        op.add(Builder::docValuesMemory, JsonpDeserializer.stringDeserializer(), "doc_values_memory");
        op.add(Builder::docValuesMemoryInBytes, JsonpDeserializer.longDeserializer(), "doc_values_memory_in_bytes");
        op.add(Builder::fileSizes, JsonpDeserializer.stringMapDeserializer(ShardFileSizeInfo._DESERIALIZER), "file_sizes");
        op.add(Builder::fixedBitSet, JsonpDeserializer.stringDeserializer(), "fixed_bit_set");
        op.add(Builder::fixedBitSetMemoryInBytes, JsonpDeserializer.longDeserializer(), "fixed_bit_set_memory_in_bytes");
        op.add(Builder::indexWriterMaxMemoryInBytes, JsonpDeserializer.longDeserializer(), "index_writer_max_memory_in_bytes");
        op.add(Builder::indexWriterMemory, JsonpDeserializer.stringDeserializer(), "index_writer_memory");
        op.add(Builder::indexWriterMemoryInBytes, JsonpDeserializer.longDeserializer(), "index_writer_memory_in_bytes");
        op.add(Builder::maxUnsafeAutoIdTimestamp, JsonpDeserializer.longDeserializer(), "max_unsafe_auto_id_timestamp");
        op.add(Builder::memory, JsonpDeserializer.stringDeserializer(), "memory");
        op.add(Builder::memoryInBytes, JsonpDeserializer.longDeserializer(), "memory_in_bytes");
        op.add(Builder::normsMemory, JsonpDeserializer.stringDeserializer(), "norms_memory");
        op.add(Builder::normsMemoryInBytes, JsonpDeserializer.longDeserializer(), "norms_memory_in_bytes");
        op.add(Builder::pointsMemory, JsonpDeserializer.stringDeserializer(), "points_memory");
        op.add(Builder::pointsMemoryInBytes, JsonpDeserializer.longDeserializer(), "points_memory_in_bytes");
        op.add(Builder::remoteStore, RemoteStoreStats._DESERIALIZER, "remote_store");
        op.add(Builder::segmentReplication, SegmentReplicationStats._DESERIALIZER, "segment_replication");
        op.add(Builder::storedFieldsMemory, JsonpDeserializer.stringDeserializer(), "stored_fields_memory");
        op.add(Builder::storedFieldsMemoryInBytes, JsonpDeserializer.longDeserializer(), "stored_fields_memory_in_bytes");
        op.add(Builder::termVectorsMemory, JsonpDeserializer.stringDeserializer(), "term_vectors_memory");
        op.add(Builder::termVectorsMemoryInBytes, JsonpDeserializer.longDeserializer(), "term_vectors_memory_in_bytes");
        op.add(Builder::termsMemory, JsonpDeserializer.stringDeserializer(), "terms_memory");
        op.add(Builder::termsMemoryInBytes, JsonpDeserializer.longDeserializer(), "terms_memory_in_bytes");
        op.add(Builder::versionMapMemory, JsonpDeserializer.stringDeserializer(), "version_map_memory");
        op.add(Builder::versionMapMemoryInBytes, JsonpDeserializer.longDeserializer(), "version_map_memory_in_bytes");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Integer.hashCode(this.count);
        result = 31 * result + Objects.hashCode(this.docValuesMemory);
        result = 31 * result + Long.hashCode(this.docValuesMemoryInBytes);
        result = 31 * result + this.fileSizes.hashCode();
        result = 31 * result + Objects.hashCode(this.fixedBitSet);
        result = 31 * result + Long.hashCode(this.fixedBitSetMemoryInBytes);
        result = 31 * result + Objects.hashCode(this.indexWriterMaxMemoryInBytes);
        result = 31 * result + Objects.hashCode(this.indexWriterMemory);
        result = 31 * result + Long.hashCode(this.indexWriterMemoryInBytes);
        result = 31 * result + Long.hashCode(this.maxUnsafeAutoIdTimestamp);
        result = 31 * result + Objects.hashCode(this.memory);
        result = 31 * result + Long.hashCode(this.memoryInBytes);
        result = 31 * result + Objects.hashCode(this.normsMemory);
        result = 31 * result + Long.hashCode(this.normsMemoryInBytes);
        result = 31 * result + Objects.hashCode(this.pointsMemory);
        result = 31 * result + Long.hashCode(this.pointsMemoryInBytes);
        result = 31 * result + Objects.hashCode(this.remoteStore);
        result = 31 * result + Objects.hashCode(this.segmentReplication);
        result = 31 * result + Objects.hashCode(this.storedFieldsMemory);
        result = 31 * result + Long.hashCode(this.storedFieldsMemoryInBytes);
        result = 31 * result + Objects.hashCode(this.termVectorsMemory);
        result = 31 * result + Long.hashCode(this.termVectorsMemoryInBytes);
        result = 31 * result + Objects.hashCode(this.termsMemory);
        result = 31 * result + Long.hashCode(this.termsMemoryInBytes);
        result = 31 * result + Objects.hashCode(this.versionMapMemory);
        result = 31 * result + Long.hashCode(this.versionMapMemoryInBytes);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        SegmentsStats other = (SegmentsStats) o;
        return this.count == other.count
            && Objects.equals(this.docValuesMemory, other.docValuesMemory)
            && this.docValuesMemoryInBytes == other.docValuesMemoryInBytes
            && this.fileSizes.equals(other.fileSizes)
            && Objects.equals(this.fixedBitSet, other.fixedBitSet)
            && this.fixedBitSetMemoryInBytes == other.fixedBitSetMemoryInBytes
            && Objects.equals(this.indexWriterMaxMemoryInBytes, other.indexWriterMaxMemoryInBytes)
            && Objects.equals(this.indexWriterMemory, other.indexWriterMemory)
            && this.indexWriterMemoryInBytes == other.indexWriterMemoryInBytes
            && this.maxUnsafeAutoIdTimestamp == other.maxUnsafeAutoIdTimestamp
            && Objects.equals(this.memory, other.memory)
            && this.memoryInBytes == other.memoryInBytes
            && Objects.equals(this.normsMemory, other.normsMemory)
            && this.normsMemoryInBytes == other.normsMemoryInBytes
            && Objects.equals(this.pointsMemory, other.pointsMemory)
            && this.pointsMemoryInBytes == other.pointsMemoryInBytes
            && Objects.equals(this.remoteStore, other.remoteStore)
            && Objects.equals(this.segmentReplication, other.segmentReplication)
            && Objects.equals(this.storedFieldsMemory, other.storedFieldsMemory)
            && this.storedFieldsMemoryInBytes == other.storedFieldsMemoryInBytes
            && Objects.equals(this.termVectorsMemory, other.termVectorsMemory)
            && this.termVectorsMemoryInBytes == other.termVectorsMemoryInBytes
            && Objects.equals(this.termsMemory, other.termsMemory)
            && this.termsMemoryInBytes == other.termsMemoryInBytes
            && Objects.equals(this.versionMapMemory, other.versionMapMemory)
            && this.versionMapMemoryInBytes == other.versionMapMemoryInBytes;
    }
}
