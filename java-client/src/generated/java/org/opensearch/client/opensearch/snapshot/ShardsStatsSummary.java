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

// typedef: snapshot.ShardsStatsSummary

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class ShardsStatsSummary implements PlainJsonSerializable, ToCopyableBuilder<ShardsStatsSummary.Builder, ShardsStatsSummary> {

    @Nonnull
    private final ShardsStatsSummaryItem incremental;

    private final long startTimeInMillis;

    @Nullable
    private final Time time;

    private final long timeInMillis;

    @Nonnull
    private final ShardsStatsSummaryItem total;

    // ---------------------------------------------------------------------------------------------

    private ShardsStatsSummary(Builder builder) {
        this.incremental = ApiTypeHelper.requireNonNull(builder.incremental, this, "incremental");
        this.startTimeInMillis = ApiTypeHelper.requireNonNull(builder.startTimeInMillis, this, "startTimeInMillis");
        this.time = builder.time;
        this.timeInMillis = ApiTypeHelper.requireNonNull(builder.timeInMillis, this, "timeInMillis");
        this.total = ApiTypeHelper.requireNonNull(builder.total, this, "total");
    }

    public static ShardsStatsSummary of(Function<ShardsStatsSummary.Builder, ObjectBuilder<ShardsStatsSummary>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code incremental}
     */
    @Nonnull
    public final ShardsStatsSummaryItem incremental() {
        return this.incremental;
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
    public final ShardsStatsSummaryItem total() {
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
     * Builder for {@link ShardsStatsSummary}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, ShardsStatsSummary> {
        private ShardsStatsSummaryItem incremental;
        private Long startTimeInMillis;
        @Nullable
        private Time time;
        private Long timeInMillis;
        private ShardsStatsSummaryItem total;

        public Builder() {}

        private Builder(ShardsStatsSummary o) {
            this.incremental = o.incremental;
            this.startTimeInMillis = o.startTimeInMillis;
            this.time = o.time;
            this.timeInMillis = o.timeInMillis;
            this.total = o.total;
        }

        private Builder(Builder o) {
            this.incremental = o.incremental;
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
        public final Builder incremental(ShardsStatsSummaryItem value) {
            this.incremental = value;
            return this;
        }

        /**
         * Required - API name: {@code incremental}
         */
        @Nonnull
        public final Builder incremental(Function<ShardsStatsSummaryItem.Builder, ObjectBuilder<ShardsStatsSummaryItem>> fn) {
            return incremental(fn.apply(new ShardsStatsSummaryItem.Builder()).build());
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
        public final Builder total(ShardsStatsSummaryItem value) {
            this.total = value;
            return this;
        }

        /**
         * Required - API name: {@code total}
         */
        @Nonnull
        public final Builder total(Function<ShardsStatsSummaryItem.Builder, ObjectBuilder<ShardsStatsSummaryItem>> fn) {
            return total(fn.apply(new ShardsStatsSummaryItem.Builder()).build());
        }

        /**
         * Builds a {@link ShardsStatsSummary}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ShardsStatsSummary build() {
            _checkSingleUse();

            return new ShardsStatsSummary(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ShardsStatsSummary}
     */
    public static final JsonpDeserializer<ShardsStatsSummary> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ShardsStatsSummary::setupShardsStatsSummaryDeserializer
    );

    protected static void setupShardsStatsSummaryDeserializer(ObjectDeserializer<ShardsStatsSummary.Builder> op) {
        op.add(Builder::incremental, ShardsStatsSummaryItem._DESERIALIZER, "incremental");
        op.add(Builder::startTimeInMillis, JsonpDeserializer.longDeserializer(), "start_time_in_millis");
        op.add(Builder::time, Time._DESERIALIZER, "time");
        op.add(Builder::timeInMillis, JsonpDeserializer.longDeserializer(), "time_in_millis");
        op.add(Builder::total, ShardsStatsSummaryItem._DESERIALIZER, "total");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.incremental.hashCode();
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
        ShardsStatsSummary other = (ShardsStatsSummary) o;
        return this.incremental.equals(other.incremental)
            && this.startTimeInMillis == other.startTimeInMillis
            && Objects.equals(this.time, other.time)
            && this.timeInMillis == other.timeInMillis
            && this.total.equals(other.total);
    }
}
