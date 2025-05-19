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

package org.opensearch.client.opensearch.nodes.stats;

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

// typedef: nodes.stats.FileSystem

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class FileSystem implements PlainJsonSerializable, ToCopyableBuilder<FileSystem.Builder, FileSystem> {

    @Nonnull
    private final List<DataPathStats> data;

    @Nullable
    private final IoStats ioStats;

    @Nullable
    private final Long timestamp;

    @Nullable
    private final FileSystemTotal total;

    // ---------------------------------------------------------------------------------------------

    private FileSystem(Builder builder) {
        this.data = ApiTypeHelper.unmodifiable(builder.data);
        this.ioStats = builder.ioStats;
        this.timestamp = builder.timestamp;
        this.total = builder.total;
    }

    public static FileSystem of(Function<FileSystem.Builder, ObjectBuilder<FileSystem>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * List of all file stores.
     * <p>
     * API name: {@code data}
     * </p>
     */
    @Nonnull
    public final List<DataPathStats> data() {
        return this.data;
    }

    /**
     * API name: {@code io_stats}
     */
    @Nullable
    public final IoStats ioStats() {
        return this.ioStats;
    }

    /**
     * Last time the file stores statistics were refreshed. Recorded in milliseconds since the Unix Epoch.
     * <p>
     * API name: {@code timestamp}
     * </p>
     */
    @Nullable
    public final Long timestamp() {
        return this.timestamp;
    }

    /**
     * API name: {@code total}
     */
    @Nullable
    public final FileSystemTotal total() {
        return this.total;
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
        if (ApiTypeHelper.isDefined(this.data)) {
            generator.writeKey("data");
            generator.writeStartArray();
            for (DataPathStats item0 : this.data) {
                item0.serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (this.ioStats != null) {
            generator.writeKey("io_stats");
            this.ioStats.serialize(generator, mapper);
        }

        if (this.timestamp != null) {
            generator.writeKey("timestamp");
            generator.write(this.timestamp);
        }

        if (this.total != null) {
            generator.writeKey("total");
            this.total.serialize(generator, mapper);
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
     * Builder for {@link FileSystem}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, FileSystem> {
        @Nullable
        private List<DataPathStats> data;
        @Nullable
        private IoStats ioStats;
        @Nullable
        private Long timestamp;
        @Nullable
        private FileSystemTotal total;

        public Builder() {}

        private Builder(FileSystem o) {
            this.data = _listCopy(o.data);
            this.ioStats = o.ioStats;
            this.timestamp = o.timestamp;
            this.total = o.total;
        }

        private Builder(Builder o) {
            this.data = _listCopy(o.data);
            this.ioStats = o.ioStats;
            this.timestamp = o.timestamp;
            this.total = o.total;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * List of all file stores.
         * <p>
         * API name: {@code data}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>data</code>.
         * </p>
         */
        @Nonnull
        public final Builder data(List<DataPathStats> list) {
            this.data = _listAddAll(this.data, list);
            return this;
        }

        /**
         * List of all file stores.
         * <p>
         * API name: {@code data}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>data</code>.
         * </p>
         */
        @Nonnull
        public final Builder data(DataPathStats value, DataPathStats... values) {
            this.data = _listAdd(this.data, value, values);
            return this;
        }

        /**
         * List of all file stores.
         * <p>
         * API name: {@code data}
         * </p>
         *
         * <p>
         * Adds a value to <code>data</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder data(Function<DataPathStats.Builder, ObjectBuilder<DataPathStats>> fn) {
            return data(fn.apply(new DataPathStats.Builder()).build());
        }

        /**
         * API name: {@code io_stats}
         */
        @Nonnull
        public final Builder ioStats(@Nullable IoStats value) {
            this.ioStats = value;
            return this;
        }

        /**
         * API name: {@code io_stats}
         */
        @Nonnull
        public final Builder ioStats(Function<IoStats.Builder, ObjectBuilder<IoStats>> fn) {
            return ioStats(fn.apply(new IoStats.Builder()).build());
        }

        /**
         * Last time the file stores statistics were refreshed. Recorded in milliseconds since the Unix Epoch.
         * <p>
         * API name: {@code timestamp}
         * </p>
         */
        @Nonnull
        public final Builder timestamp(@Nullable Long value) {
            this.timestamp = value;
            return this;
        }

        /**
         * API name: {@code total}
         */
        @Nonnull
        public final Builder total(@Nullable FileSystemTotal value) {
            this.total = value;
            return this;
        }

        /**
         * API name: {@code total}
         */
        @Nonnull
        public final Builder total(Function<FileSystemTotal.Builder, ObjectBuilder<FileSystemTotal>> fn) {
            return total(fn.apply(new FileSystemTotal.Builder()).build());
        }

        /**
         * Builds a {@link FileSystem}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public FileSystem build() {
            _checkSingleUse();

            return new FileSystem(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link FileSystem}
     */
    public static final JsonpDeserializer<FileSystem> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        FileSystem::setupFileSystemDeserializer
    );

    protected static void setupFileSystemDeserializer(ObjectDeserializer<FileSystem.Builder> op) {
        op.add(Builder::data, JsonpDeserializer.arrayDeserializer(DataPathStats._DESERIALIZER), "data");
        op.add(Builder::ioStats, IoStats._DESERIALIZER, "io_stats");
        op.add(Builder::timestamp, JsonpDeserializer.longDeserializer(), "timestamp");
        op.add(Builder::total, FileSystemTotal._DESERIALIZER, "total");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.data);
        result = 31 * result + Objects.hashCode(this.ioStats);
        result = 31 * result + Objects.hashCode(this.timestamp);
        result = 31 * result + Objects.hashCode(this.total);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        FileSystem other = (FileSystem) o;
        return Objects.equals(this.data, other.data)
            && Objects.equals(this.ioStats, other.ioStats)
            && Objects.equals(this.timestamp, other.timestamp)
            && Objects.equals(this.total, other.total);
    }
}
