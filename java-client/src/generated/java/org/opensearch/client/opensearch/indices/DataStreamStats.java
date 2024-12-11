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

// typedef: indices.DataStreamStats

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class DataStreamStats implements PlainJsonSerializable, ToCopyableBuilder<DataStreamStats.Builder, DataStreamStats> {

    private final int backingIndices;

    @Nonnull
    private final String dataStream;

    private final long maximumTimestamp;

    @Nullable
    private final String storeSize;

    private final long storeSizeBytes;

    // ---------------------------------------------------------------------------------------------

    private DataStreamStats(Builder builder) {
        this.backingIndices = ApiTypeHelper.requireNonNull(builder.backingIndices, this, "backingIndices");
        this.dataStream = ApiTypeHelper.requireNonNull(builder.dataStream, this, "dataStream");
        this.maximumTimestamp = ApiTypeHelper.requireNonNull(builder.maximumTimestamp, this, "maximumTimestamp");
        this.storeSize = builder.storeSize;
        this.storeSizeBytes = ApiTypeHelper.requireNonNull(builder.storeSizeBytes, this, "storeSizeBytes");
    }

    public static DataStreamStats of(Function<DataStreamStats.Builder, ObjectBuilder<DataStreamStats>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - Current number of backing indexes for the data stream.
     * <p>
     * API name: {@code backing_indices}
     * </p>
     */
    public final int backingIndices() {
        return this.backingIndices;
    }

    /**
     * Required - API name: {@code data_stream}
     */
    @Nonnull
    public final String dataStream() {
        return this.dataStream;
    }

    /**
     * Required - API name: {@code maximum_timestamp}
     */
    public final long maximumTimestamp() {
        return this.maximumTimestamp;
    }

    /**
     * API name: {@code store_size}
     */
    @Nullable
    public final String storeSize() {
        return this.storeSize;
    }

    /**
     * Required - Total size, in bytes, of all shards for the data stream's backing indexes.
     * <p>
     * API name: {@code store_size_bytes}
     * </p>
     */
    public final long storeSizeBytes() {
        return this.storeSizeBytes;
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

        generator.writeKey("data_stream");
        generator.write(this.dataStream);

        generator.writeKey("maximum_timestamp");
        generator.write(this.maximumTimestamp);

        if (this.storeSize != null) {
            generator.writeKey("store_size");
            generator.write(this.storeSize);
        }

        generator.writeKey("store_size_bytes");
        generator.write(this.storeSizeBytes);
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
     * Builder for {@link DataStreamStats}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, DataStreamStats> {
        private Integer backingIndices;
        private String dataStream;
        private Long maximumTimestamp;
        @Nullable
        private String storeSize;
        private Long storeSizeBytes;

        public Builder() {}

        private Builder(DataStreamStats o) {
            this.backingIndices = o.backingIndices;
            this.dataStream = o.dataStream;
            this.maximumTimestamp = o.maximumTimestamp;
            this.storeSize = o.storeSize;
            this.storeSizeBytes = o.storeSizeBytes;
        }

        private Builder(Builder o) {
            this.backingIndices = o.backingIndices;
            this.dataStream = o.dataStream;
            this.maximumTimestamp = o.maximumTimestamp;
            this.storeSize = o.storeSize;
            this.storeSizeBytes = o.storeSizeBytes;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - Current number of backing indexes for the data stream.
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
         * Required - API name: {@code data_stream}
         */
        @Nonnull
        public final Builder dataStream(String value) {
            this.dataStream = value;
            return this;
        }

        /**
         * Required - API name: {@code maximum_timestamp}
         */
        @Nonnull
        public final Builder maximumTimestamp(long value) {
            this.maximumTimestamp = value;
            return this;
        }

        /**
         * API name: {@code store_size}
         */
        @Nonnull
        public final Builder storeSize(@Nullable String value) {
            this.storeSize = value;
            return this;
        }

        /**
         * Required - Total size, in bytes, of all shards for the data stream's backing indexes.
         * <p>
         * API name: {@code store_size_bytes}
         * </p>
         */
        @Nonnull
        public final Builder storeSizeBytes(long value) {
            this.storeSizeBytes = value;
            return this;
        }

        /**
         * Builds a {@link DataStreamStats}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public DataStreamStats build() {
            _checkSingleUse();

            return new DataStreamStats(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link DataStreamStats}
     */
    public static final JsonpDeserializer<DataStreamStats> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        DataStreamStats::setupDataStreamStatsDeserializer
    );

    protected static void setupDataStreamStatsDeserializer(ObjectDeserializer<DataStreamStats.Builder> op) {
        op.add(Builder::backingIndices, JsonpDeserializer.integerDeserializer(), "backing_indices");
        op.add(Builder::dataStream, JsonpDeserializer.stringDeserializer(), "data_stream");
        op.add(Builder::maximumTimestamp, JsonpDeserializer.longDeserializer(), "maximum_timestamp");
        op.add(Builder::storeSize, JsonpDeserializer.stringDeserializer(), "store_size");
        op.add(Builder::storeSizeBytes, JsonpDeserializer.longDeserializer(), "store_size_bytes");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Integer.hashCode(this.backingIndices);
        result = 31 * result + this.dataStream.hashCode();
        result = 31 * result + Long.hashCode(this.maximumTimestamp);
        result = 31 * result + Objects.hashCode(this.storeSize);
        result = 31 * result + Long.hashCode(this.storeSizeBytes);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        DataStreamStats other = (DataStreamStats) o;
        return this.backingIndices == other.backingIndices
            && this.dataStream.equals(other.dataStream)
            && this.maximumTimestamp == other.maximumTimestamp
            && Objects.equals(this.storeSize, other.storeSize)
            && this.storeSizeBytes == other.storeSizeBytes;
    }
}
