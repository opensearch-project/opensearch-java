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
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: snapshot.SnapshotShardsStatsSummary

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class SnapshotShardsStatsSummary
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<SnapshotShardsStatsSummary.Builder, SnapshotShardsStatsSummary> {

    @Nonnull
    private final SnapshotShardsStatsSummaryItem incremental;

    @Nullable
    private final SnapshotShardsStatsSummaryItem processed;

    private final long startTimeInMillis;

    @Nullable
    private final Time time;

    private final long timeInMillis;

    @Nonnull
    private final SnapshotShardsStatsSummaryItem total;

    // ---------------------------------------------------------------------------------------------

    private SnapshotShardsStatsSummary(Builder builder) {
        this.incremental = ApiTypeHelper.requireNonNull(builder.incremental, this, "incremental");
        this.processed = builder.processed;
        this.startTimeInMillis = ApiTypeHelper.requireNonNull(builder.startTimeInMillis, this, "startTimeInMillis");
        this.time = builder.time;
        this.timeInMillis = ApiTypeHelper.requireNonNull(builder.timeInMillis, this, "timeInMillis");
        this.total = ApiTypeHelper.requireNonNull(builder.total, this, "total");
    }

    public static SnapshotShardsStatsSummary of(
        Function<SnapshotShardsStatsSummary.Builder, ObjectBuilder<SnapshotShardsStatsSummary>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code incremental}
     */
    @Nonnull
    public final SnapshotShardsStatsSummaryItem incremental() {
        return this.incremental;
    }

    /**
     * API name: {@code processed}
     */
    @Nullable
    public final SnapshotShardsStatsSummaryItem processed() {
        return this.processed;
    }

    /**
     * Required - API name: {@code start_time_in_millis}
     */
    public final long startTimeInMillis() {
        return this.startTimeInMillis;
    }

    /**
     * API name: {@code time}
     */
    @Nullable
    public final Time time() {
        return this.time;
    }

    /**
     * Required - API name: {@code time_in_millis}
     */
    public final long timeInMillis() {
        return this.timeInMillis;
    }

    /**
     * Required - API name: {@code total}
     */
    @Nonnull
    public final SnapshotShardsStatsSummaryItem total() {
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
        generator.writeKey("incremental");
        this.incremental.serialize(generator, mapper);

        if (this.processed != null) {
            generator.writeKey("processed");
            this.processed.serialize(generator, mapper);
        }

        generator.writeKey("start_time_in_millis");
        generator.write(this.startTimeInMillis);

        if (this.time != null) {
            generator.writeKey("time");
            this.time.serialize(generator, mapper);
        }

        generator.writeKey("time_in_millis");
        generator.write(this.timeInMillis);

        generator.writeKey("total");
        this.total.serialize(generator, mapper);
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
     * Builder for {@link SnapshotShardsStatsSummary}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, SnapshotShardsStatsSummary> {
        private SnapshotShardsStatsSummaryItem incremental;
        @Nullable
        private SnapshotShardsStatsSummaryItem processed;
        private Long startTimeInMillis;
        @Nullable
        private Time time;
        private Long timeInMillis;
        private SnapshotShardsStatsSummaryItem total;

        public Builder() {}

        private Builder(SnapshotShardsStatsSummary o) {
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
         * Required - API name: {@code incremental}
         */
        @Nonnull
        public final Builder incremental(SnapshotShardsStatsSummaryItem value) {
            this.incremental = value;
            return this;
        }

        /**
         * Required - API name: {@code incremental}
         */
        @Nonnull
        public final Builder incremental(
            Function<SnapshotShardsStatsSummaryItem.Builder, ObjectBuilder<SnapshotShardsStatsSummaryItem>> fn
        ) {
            return incremental(fn.apply(new SnapshotShardsStatsSummaryItem.Builder()).build());
        }

        /**
         * API name: {@code processed}
         */
        @Nonnull
        public final Builder processed(@Nullable SnapshotShardsStatsSummaryItem value) {
            this.processed = value;
            return this;
        }

        /**
         * API name: {@code processed}
         */
        @Nonnull
        public final Builder processed(Function<SnapshotShardsStatsSummaryItem.Builder, ObjectBuilder<SnapshotShardsStatsSummaryItem>> fn) {
            return processed(fn.apply(new SnapshotShardsStatsSummaryItem.Builder()).build());
        }

        /**
         * Required - API name: {@code start_time_in_millis}
         */
        @Nonnull
        public final Builder startTimeInMillis(long value) {
            this.startTimeInMillis = value;
            return this;
        }

        /**
         * API name: {@code time}
         */
        @Nonnull
        public final Builder time(@Nullable Time value) {
            this.time = value;
            return this;
        }

        /**
         * API name: {@code time}
         */
        @Nonnull
        public final Builder time(Function<Time.Builder, ObjectBuilder<Time>> fn) {
            return time(fn.apply(new Time.Builder()).build());
        }

        /**
         * Required - API name: {@code time_in_millis}
         */
        @Nonnull
        public final Builder timeInMillis(long value) {
            this.timeInMillis = value;
            return this;
        }

        /**
         * Required - API name: {@code total}
         */
        @Nonnull
        public final Builder total(SnapshotShardsStatsSummaryItem value) {
            this.total = value;
            return this;
        }

        /**
         * Required - API name: {@code total}
         */
        @Nonnull
        public final Builder total(Function<SnapshotShardsStatsSummaryItem.Builder, ObjectBuilder<SnapshotShardsStatsSummaryItem>> fn) {
            return total(fn.apply(new SnapshotShardsStatsSummaryItem.Builder()).build());
        }

        /**
         * Builds a {@link SnapshotShardsStatsSummary}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public SnapshotShardsStatsSummary build() {
            _checkSingleUse();

            return new SnapshotShardsStatsSummary(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link SnapshotShardsStatsSummary}
     */
    public static final JsonpDeserializer<SnapshotShardsStatsSummary> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        SnapshotShardsStatsSummary::setupSnapshotShardsStatsSummaryDeserializer
    );

    protected static void setupSnapshotShardsStatsSummaryDeserializer(ObjectDeserializer<SnapshotShardsStatsSummary.Builder> op) {
        op.add(Builder::incremental, SnapshotShardsStatsSummaryItem._DESERIALIZER, "incremental");
        op.add(Builder::processed, SnapshotShardsStatsSummaryItem._DESERIALIZER, "processed");
        op.add(Builder::startTimeInMillis, JsonpDeserializer.longDeserializer(), "start_time_in_millis");
        op.add(Builder::time, Time._DESERIALIZER, "time");
        op.add(Builder::timeInMillis, JsonpDeserializer.longDeserializer(), "time_in_millis");
        op.add(Builder::total, SnapshotShardsStatsSummaryItem._DESERIALIZER, "total");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.incremental.hashCode();
        result = 31 * result + Objects.hashCode(this.processed);
        result = 31 * result + Long.hashCode(this.startTimeInMillis);
        result = 31 * result + Objects.hashCode(this.time);
        result = 31 * result + Long.hashCode(this.timeInMillis);
        result = 31 * result + this.total.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        SnapshotShardsStatsSummary other = (SnapshotShardsStatsSummary) o;
        return this.incremental.equals(other.incremental)
            && Objects.equals(this.processed, other.processed)
            && this.startTimeInMillis == other.startTimeInMillis
            && Objects.equals(this.time, other.time)
            && this.timeInMillis == other.timeInMillis
            && this.total.equals(other.total);
    }
}
