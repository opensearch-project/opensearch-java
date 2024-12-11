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
import org.opensearch.client.opensearch._types.ShardStatistics;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: indices.data_streams_stats.Response

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class DataStreamsStatsResponse
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<DataStreamsStatsResponse.Builder, DataStreamsStatsResponse> {

    private final int backingIndices;

    private final int dataStreamCount;

    @Nonnull
    private final List<DataStreamStats> dataStreams;

    @Nonnull
    private final ShardStatistics shards;

    @Nullable
    private final String totalStoreSize;

    private final long totalStoreSizeBytes;

    // ---------------------------------------------------------------------------------------------

    private DataStreamsStatsResponse(Builder builder) {
        this.backingIndices = ApiTypeHelper.requireNonNull(builder.backingIndices, this, "backingIndices");
        this.dataStreamCount = ApiTypeHelper.requireNonNull(builder.dataStreamCount, this, "dataStreamCount");
        this.dataStreams = ApiTypeHelper.unmodifiableRequired(builder.dataStreams, this, "dataStreams");
        this.shards = ApiTypeHelper.requireNonNull(builder.shards, this, "shards");
        this.totalStoreSize = builder.totalStoreSize;
        this.totalStoreSizeBytes = ApiTypeHelper.requireNonNull(builder.totalStoreSizeBytes, this, "totalStoreSizeBytes");
    }

    public static DataStreamsStatsResponse of(Function<DataStreamsStatsResponse.Builder, ObjectBuilder<DataStreamsStatsResponse>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - Total number of backing indexes for the selected data streams.
     * <p>
     * API name: {@code backing_indices}
     * </p>
     */
    public final int backingIndices() {
        return this.backingIndices;
    }

    /**
     * Required - Total number of selected data streams.
     * <p>
     * API name: {@code data_stream_count}
     * </p>
     */
    public final int dataStreamCount() {
        return this.dataStreamCount;
    }

    /**
     * Required - Contains statistics for the selected data streams.
     * <p>
     * API name: {@code data_streams}
     * </p>
     */
    @Nonnull
    public final List<DataStreamStats> dataStreams() {
        return this.dataStreams;
    }

    /**
     * Required - API name: {@code _shards}
     */
    @Nonnull
    public final ShardStatistics shards() {
        return this.shards;
    }

    /**
     * API name: {@code total_store_size}
     */
    @Nullable
    public final String totalStoreSize() {
        return this.totalStoreSize;
    }

    /**
     * Required - Total size, in bytes, of all shards for the selected data streams.
     * <p>
     * API name: {@code total_store_size_bytes}
     * </p>
     */
    public final long totalStoreSizeBytes() {
        return this.totalStoreSizeBytes;
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
        generator.writeKey("backing_indices");
        generator.write(this.backingIndices);

        generator.writeKey("data_stream_count");
        generator.write(this.dataStreamCount);

        generator.writeKey("data_streams");
        generator.writeStartArray();
        for (DataStreamStats item0 : this.dataStreams) {
            item0.serialize(generator, mapper);
        }
        generator.writeEnd();

        generator.writeKey("_shards");
        this.shards.serialize(generator, mapper);

        if (this.totalStoreSize != null) {
            generator.writeKey("total_store_size");
            generator.write(this.totalStoreSize);
        }

        generator.writeKey("total_store_size_bytes");
        generator.write(this.totalStoreSizeBytes);
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
     * Builder for {@link DataStreamsStatsResponse}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, DataStreamsStatsResponse> {
        private Integer backingIndices;
        private Integer dataStreamCount;
        private List<DataStreamStats> dataStreams;
        private ShardStatistics shards;
        @Nullable
        private String totalStoreSize;
        private Long totalStoreSizeBytes;

        public Builder() {}

        private Builder(DataStreamsStatsResponse o) {
            this.backingIndices = o.backingIndices;
            this.dataStreamCount = o.dataStreamCount;
            this.dataStreams = _listCopy(o.dataStreams);
            this.shards = o.shards;
            this.totalStoreSize = o.totalStoreSize;
            this.totalStoreSizeBytes = o.totalStoreSizeBytes;
        }

        private Builder(Builder o) {
            this.backingIndices = o.backingIndices;
            this.dataStreamCount = o.dataStreamCount;
            this.dataStreams = _listCopy(o.dataStreams);
            this.shards = o.shards;
            this.totalStoreSize = o.totalStoreSize;
            this.totalStoreSizeBytes = o.totalStoreSizeBytes;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - Total number of backing indexes for the selected data streams.
         * <p>
         * API name: {@code backing_indices}
         * </p>
         */
        @Nonnull
        public final Builder backingIndices(int value) {
            this.backingIndices = value;
            return this;
        }

        /**
         * Required - Total number of selected data streams.
         * <p>
         * API name: {@code data_stream_count}
         * </p>
         */
        @Nonnull
        public final Builder dataStreamCount(int value) {
            this.dataStreamCount = value;
            return this;
        }

        /**
         * Required - Contains statistics for the selected data streams.
         * <p>
         * API name: {@code data_streams}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>dataStreams</code>.
         * </p>
         */
        @Nonnull
        public final Builder dataStreams(List<DataStreamStats> list) {
            this.dataStreams = _listAddAll(this.dataStreams, list);
            return this;
        }

        /**
         * Required - Contains statistics for the selected data streams.
         * <p>
         * API name: {@code data_streams}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>dataStreams</code>.
         * </p>
         */
        @Nonnull
        public final Builder dataStreams(DataStreamStats value, DataStreamStats... values) {
            this.dataStreams = _listAdd(this.dataStreams, value, values);
            return this;
        }

        /**
         * Required - Contains statistics for the selected data streams.
         * <p>
         * API name: {@code data_streams}
         * </p>
         *
         * <p>
         * Adds a value to <code>dataStreams</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder dataStreams(Function<DataStreamStats.Builder, ObjectBuilder<DataStreamStats>> fn) {
            return dataStreams(fn.apply(new DataStreamStats.Builder()).build());
        }

        /**
         * Required - API name: {@code _shards}
         */
        @Nonnull
        public final Builder shards(ShardStatistics value) {
            this.shards = value;
            return this;
        }

        /**
         * Required - API name: {@code _shards}
         */
        @Nonnull
        public final Builder shards(Function<ShardStatistics.Builder, ObjectBuilder<ShardStatistics>> fn) {
            return shards(fn.apply(new ShardStatistics.Builder()).build());
        }

        /**
         * API name: {@code total_store_size}
         */
        @Nonnull
        public final Builder totalStoreSize(@Nullable String value) {
            this.totalStoreSize = value;
            return this;
        }

        /**
         * Required - Total size, in bytes, of all shards for the selected data streams.
         * <p>
         * API name: {@code total_store_size_bytes}
         * </p>
         */
        @Nonnull
        public final Builder totalStoreSizeBytes(long value) {
            this.totalStoreSizeBytes = value;
            return this;
        }

        /**
         * Builds a {@link DataStreamsStatsResponse}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public DataStreamsStatsResponse build() {
            _checkSingleUse();

            return new DataStreamsStatsResponse(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link DataStreamsStatsResponse}
     */
    public static final JsonpDeserializer<DataStreamsStatsResponse> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        DataStreamsStatsResponse::setupDataStreamsStatsResponseDeserializer
    );

    protected static void setupDataStreamsStatsResponseDeserializer(ObjectDeserializer<DataStreamsStatsResponse.Builder> op) {
        op.add(Builder::backingIndices, JsonpDeserializer.integerDeserializer(), "backing_indices");
        op.add(Builder::dataStreamCount, JsonpDeserializer.integerDeserializer(), "data_stream_count");
        op.add(Builder::dataStreams, JsonpDeserializer.arrayDeserializer(DataStreamStats._DESERIALIZER), "data_streams");
        op.add(Builder::shards, ShardStatistics._DESERIALIZER, "_shards");
        op.add(Builder::totalStoreSize, JsonpDeserializer.stringDeserializer(), "total_store_size");
        op.add(Builder::totalStoreSizeBytes, JsonpDeserializer.longDeserializer(), "total_store_size_bytes");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Integer.hashCode(this.backingIndices);
        result = 31 * result + Integer.hashCode(this.dataStreamCount);
        result = 31 * result + this.dataStreams.hashCode();
        result = 31 * result + this.shards.hashCode();
        result = 31 * result + Objects.hashCode(this.totalStoreSize);
        result = 31 * result + Long.hashCode(this.totalStoreSizeBytes);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        DataStreamsStatsResponse other = (DataStreamsStatsResponse) o;
        return this.backingIndices == other.backingIndices
            && this.dataStreamCount == other.dataStreamCount
            && this.dataStreams.equals(other.dataStreams)
            && this.shards.equals(other.shards)
            && Objects.equals(this.totalStoreSize, other.totalStoreSize)
            && this.totalStoreSizeBytes == other.totalStoreSizeBytes;
    }
}
