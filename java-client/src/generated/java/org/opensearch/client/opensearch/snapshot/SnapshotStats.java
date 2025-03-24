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
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: snapshot.SnapshotStats

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class SnapshotStats implements PlainJsonSerializable, ToCopyableBuilder<SnapshotStats.Builder, SnapshotStats> {

    @Nullable
    private final FileCountSnapshotStats incremental;

    @Nullable
    private final FileCountSnapshotStats processed;

    @Nullable
    private final Long startTimeInMillis;

    @Nullable
    private final Time time;

    @Nullable
    private final Long timeInMillis;

    @Nullable
    private final FileCountSnapshotStats total;

    // ---------------------------------------------------------------------------------------------

    private SnapshotStats(Builder builder) {
        this.incremental = builder.incremental;
        this.processed = builder.processed;
        this.startTimeInMillis = builder.startTimeInMillis;
        this.time = builder.time;
        this.timeInMillis = builder.timeInMillis;
        this.total = builder.total;
    }

    public static SnapshotStats of(Function<SnapshotStats.Builder, ObjectBuilder<SnapshotStats>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * The incremental statistics for the snapshot.
     * <p>
     * API name: {@code incremental}
     * </p>
     */
    @Nullable
    public final FileCountSnapshotStats incremental() {
        return this.incremental;
    }

    /**
     * The processed statistics for the snapshot.
     * <p>
     * API name: {@code processed}
     * </p>
     */
    @Nullable
    public final FileCountSnapshotStats processed() {
        return this.processed;
    }

    /**
     * When the snapshot started in milliseconds.
     * <p>
     * API name: {@code start_time_in_millis}
     * </p>
     */
    @Nullable
    public final Long startTimeInMillis() {
        return this.startTimeInMillis;
    }

    /**
     * The total time taken for the snapshot.
     * <p>
     * API name: {@code time}
     * </p>
     */
    @Nullable
    public final Time time() {
        return this.time;
    }

    /**
     * The total time taken for the snapshot in milliseconds.
     * <p>
     * API name: {@code time_in_millis}
     * </p>
     */
    @Nullable
    public final Long timeInMillis() {
        return this.timeInMillis;
    }

    /**
     * The total statistics for the snapshot.
     * <p>
     * API name: {@code total}
     * </p>
     */
    @Nullable
    public final FileCountSnapshotStats total() {
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
        if (this.incremental != null) {
            generator.writeKey("incremental");
            this.incremental.serialize(generator, mapper);
        }

        if (this.processed != null) {
            generator.writeKey("processed");
            this.processed.serialize(generator, mapper);
        }

        if (this.startTimeInMillis != null) {
            generator.writeKey("start_time_in_millis");
            generator.write(this.startTimeInMillis);
        }

        if (this.time != null) {
            generator.writeKey("time");
            this.time.serialize(generator, mapper);
        }

        if (this.timeInMillis != null) {
            generator.writeKey("time_in_millis");
            generator.write(this.timeInMillis);
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
     * Builder for {@link SnapshotStats}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, SnapshotStats> {
        @Nullable
        private FileCountSnapshotStats incremental;
        @Nullable
        private FileCountSnapshotStats processed;
        @Nullable
        private Long startTimeInMillis;
        @Nullable
        private Time time;
        @Nullable
        private Long timeInMillis;
        @Nullable
        private FileCountSnapshotStats total;

        public Builder() {}

        private Builder(SnapshotStats o) {
            this.incremental = o.incremental;
            this.processed = o.processed;
            this.startTimeInMillis = o.startTimeInMillis;
            this.time = o.time;
            this.timeInMillis = o.timeInMillis;
            this.total = o.total;
        }

        private Builder(Builder o) {
            this.incremental = o.incremental;
            this.processed = o.processed;
            this.startTimeInMillis = o.startTimeInMillis;
            this.time = o.time;
            this.timeInMillis = o.timeInMillis;
            this.total = o.total;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * The incremental statistics for the snapshot.
         * <p>
         * API name: {@code incremental}
         * </p>
         */
        @Nonnull
        public final Builder incremental(@Nullable FileCountSnapshotStats value) {
            this.incremental = value;
            return this;
        }

        /**
         * The incremental statistics for the snapshot.
         * <p>
         * API name: {@code incremental}
         * </p>
         */
        @Nonnull
        public final Builder incremental(Function<FileCountSnapshotStats.Builder, ObjectBuilder<FileCountSnapshotStats>> fn) {
            return incremental(fn.apply(new FileCountSnapshotStats.Builder()).build());
        }

        /**
         * The processed statistics for the snapshot.
         * <p>
         * API name: {@code processed}
         * </p>
         */
        @Nonnull
        public final Builder processed(@Nullable FileCountSnapshotStats value) {
            this.processed = value;
            return this;
        }

        /**
         * The processed statistics for the snapshot.
         * <p>
         * API name: {@code processed}
         * </p>
         */
        @Nonnull
        public final Builder processed(Function<FileCountSnapshotStats.Builder, ObjectBuilder<FileCountSnapshotStats>> fn) {
            return processed(fn.apply(new FileCountSnapshotStats.Builder()).build());
        }

        /**
         * When the snapshot started in milliseconds.
         * <p>
         * API name: {@code start_time_in_millis}
         * </p>
         */
        @Nonnull
        public final Builder startTimeInMillis(@Nullable Long value) {
            this.startTimeInMillis = value;
            return this;
        }

        /**
         * The total time taken for the snapshot.
         * <p>
         * API name: {@code time}
         * </p>
         */
        @Nonnull
        public final Builder time(@Nullable Time value) {
            this.time = value;
            return this;
        }

        /**
         * The total time taken for the snapshot.
         * <p>
         * API name: {@code time}
         * </p>
         */
        @Nonnull
        public final Builder time(Function<Time.Builder, ObjectBuilder<Time>> fn) {
            return time(fn.apply(new Time.Builder()).build());
        }

        /**
         * The total time taken for the snapshot in milliseconds.
         * <p>
         * API name: {@code time_in_millis}
         * </p>
         */
        @Nonnull
        public final Builder timeInMillis(@Nullable Long value) {
            this.timeInMillis = value;
            return this;
        }

        /**
         * The total statistics for the snapshot.
         * <p>
         * API name: {@code total}
         * </p>
         */
        @Nonnull
        public final Builder total(@Nullable FileCountSnapshotStats value) {
            this.total = value;
            return this;
        }

        /**
         * The total statistics for the snapshot.
         * <p>
         * API name: {@code total}
         * </p>
         */
        @Nonnull
        public final Builder total(Function<FileCountSnapshotStats.Builder, ObjectBuilder<FileCountSnapshotStats>> fn) {
            return total(fn.apply(new FileCountSnapshotStats.Builder()).build());
        }

        /**
         * Builds a {@link SnapshotStats}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public SnapshotStats build() {
            _checkSingleUse();

            return new SnapshotStats(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link SnapshotStats}
     */
    public static final JsonpDeserializer<SnapshotStats> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        SnapshotStats::setupSnapshotStatsDeserializer
    );

    protected static void setupSnapshotStatsDeserializer(ObjectDeserializer<SnapshotStats.Builder> op) {
        op.add(Builder::incremental, FileCountSnapshotStats._DESERIALIZER, "incremental");
        op.add(Builder::processed, FileCountSnapshotStats._DESERIALIZER, "processed");
        op.add(Builder::startTimeInMillis, JsonpDeserializer.longDeserializer(), "start_time_in_millis");
        op.add(Builder::time, Time._DESERIALIZER, "time");
        op.add(Builder::timeInMillis, JsonpDeserializer.longDeserializer(), "time_in_millis");
        op.add(Builder::total, FileCountSnapshotStats._DESERIALIZER, "total");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.incremental);
        result = 31 * result + Objects.hashCode(this.processed);
        result = 31 * result + Objects.hashCode(this.startTimeInMillis);
        result = 31 * result + Objects.hashCode(this.time);
        result = 31 * result + Objects.hashCode(this.timeInMillis);
        result = 31 * result + Objects.hashCode(this.total);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        SnapshotStats other = (SnapshotStats) o;
        return Objects.equals(this.incremental, other.incremental)
            && Objects.equals(this.processed, other.processed)
            && Objects.equals(this.startTimeInMillis, other.startTimeInMillis)
            && Objects.equals(this.time, other.time)
            && Objects.equals(this.timeInMillis, other.timeInMillis)
            && Objects.equals(this.total, other.total);
    }
}
