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

// typedef: _types.RefreshStats

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class RefreshStats implements PlainJsonSerializable, ToCopyableBuilder<RefreshStats.Builder, RefreshStats> {

    private final long externalTotal;

    @Nullable
    private final Time externalTotalTime;

    private final long externalTotalTimeInMillis;

    private final long listeners;

    private final long total;

    @Nullable
    private final Time totalTime;

    private final long totalTimeInMillis;

    // ---------------------------------------------------------------------------------------------

    private RefreshStats(Builder builder) {
        this.externalTotal = ApiTypeHelper.requireNonNull(builder.externalTotal, this, "externalTotal");
        this.externalTotalTime = builder.externalTotalTime;
        this.externalTotalTimeInMillis = ApiTypeHelper.requireNonNull(builder.externalTotalTimeInMillis, this, "externalTotalTimeInMillis");
        this.listeners = ApiTypeHelper.requireNonNull(builder.listeners, this, "listeners");
        this.total = ApiTypeHelper.requireNonNull(builder.total, this, "total");
        this.totalTime = builder.totalTime;
        this.totalTimeInMillis = ApiTypeHelper.requireNonNull(builder.totalTimeInMillis, this, "totalTimeInMillis");
    }

    public static RefreshStats of(Function<RefreshStats.Builder, ObjectBuilder<RefreshStats>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code external_total}
     */
    public final long externalTotal() {
        return this.externalTotal;
    }

    /**
     * API name: {@code external_total_time}
     */
    @Nullable
    public final Time externalTotalTime() {
        return this.externalTotalTime;
    }

    /**
     * Required - API name: {@code external_total_time_in_millis}
     */
    public final long externalTotalTimeInMillis() {
        return this.externalTotalTimeInMillis;
    }

    /**
     * Required - API name: {@code listeners}
     */
    public final long listeners() {
        return this.listeners;
    }

    /**
     * Required - API name: {@code total}
     */
    public final long total() {
        return this.total;
    }

    /**
     * API name: {@code total_time}
     */
    @Nullable
    public final Time totalTime() {
        return this.totalTime;
    }

    /**
     * Required - API name: {@code total_time_in_millis}
     */
    public final long totalTimeInMillis() {
        return this.totalTimeInMillis;
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
        generator.writeKey("external_total");
        generator.write(this.externalTotal);

        if (this.externalTotalTime != null) {
            generator.writeKey("external_total_time");
            this.externalTotalTime.serialize(generator, mapper);
        }

        generator.writeKey("external_total_time_in_millis");
        generator.write(this.externalTotalTimeInMillis);

        generator.writeKey("listeners");
        generator.write(this.listeners);

        generator.writeKey("total");
        generator.write(this.total);

        if (this.totalTime != null) {
            generator.writeKey("total_time");
            this.totalTime.serialize(generator, mapper);
        }

        generator.writeKey("total_time_in_millis");
        generator.write(this.totalTimeInMillis);
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
     * Builder for {@link RefreshStats}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, RefreshStats> {
        private Long externalTotal;
        @Nullable
        private Time externalTotalTime;
        private Long externalTotalTimeInMillis;
        private Long listeners;
        private Long total;
        @Nullable
        private Time totalTime;
        private Long totalTimeInMillis;

        public Builder() {}

        private Builder(RefreshStats o) {
            this.externalTotal = o.externalTotal;
            this.externalTotalTime = o.externalTotalTime;
            this.externalTotalTimeInMillis = o.externalTotalTimeInMillis;
            this.listeners = o.listeners;
            this.total = o.total;
            this.totalTime = o.totalTime;
            this.totalTimeInMillis = o.totalTimeInMillis;
        }

        private Builder(Builder o) {
            this.externalTotal = o.externalTotal;
            this.externalTotalTime = o.externalTotalTime;
            this.externalTotalTimeInMillis = o.externalTotalTimeInMillis;
            this.listeners = o.listeners;
            this.total = o.total;
            this.totalTime = o.totalTime;
            this.totalTimeInMillis = o.totalTimeInMillis;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - API name: {@code external_total}
         */
        @Nonnull
        public final Builder externalTotal(long value) {
            this.externalTotal = value;
            return this;
        }

        /**
         * API name: {@code external_total_time}
         */
        @Nonnull
        public final Builder externalTotalTime(@Nullable Time value) {
            this.externalTotalTime = value;
            return this;
        }

        /**
         * API name: {@code external_total_time}
         */
        @Nonnull
        public final Builder externalTotalTime(Function<Time.Builder, ObjectBuilder<Time>> fn) {
            return externalTotalTime(fn.apply(new Time.Builder()).build());
        }

        /**
         * Required - API name: {@code external_total_time_in_millis}
         */
        @Nonnull
        public final Builder externalTotalTimeInMillis(long value) {
            this.externalTotalTimeInMillis = value;
            return this;
        }

        /**
         * Required - API name: {@code listeners}
         */
        @Nonnull
        public final Builder listeners(long value) {
            this.listeners = value;
            return this;
        }

        /**
         * Required - API name: {@code total}
         */
        @Nonnull
        public final Builder total(long value) {
            this.total = value;
            return this;
        }

        /**
         * API name: {@code total_time}
         */
        @Nonnull
        public final Builder totalTime(@Nullable Time value) {
            this.totalTime = value;
            return this;
        }

        /**
         * API name: {@code total_time}
         */
        @Nonnull
        public final Builder totalTime(Function<Time.Builder, ObjectBuilder<Time>> fn) {
            return totalTime(fn.apply(new Time.Builder()).build());
        }

        /**
         * Required - API name: {@code total_time_in_millis}
         */
        @Nonnull
        public final Builder totalTimeInMillis(long value) {
            this.totalTimeInMillis = value;
            return this;
        }

        /**
         * Builds a {@link RefreshStats}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public RefreshStats build() {
            _checkSingleUse();

            return new RefreshStats(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link RefreshStats}
     */
    public static final JsonpDeserializer<RefreshStats> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        RefreshStats::setupRefreshStatsDeserializer
    );

    protected static void setupRefreshStatsDeserializer(ObjectDeserializer<RefreshStats.Builder> op) {
        op.add(Builder::externalTotal, JsonpDeserializer.longDeserializer(), "external_total");
        op.add(Builder::externalTotalTime, Time._DESERIALIZER, "external_total_time");
        op.add(Builder::externalTotalTimeInMillis, JsonpDeserializer.longDeserializer(), "external_total_time_in_millis");
        op.add(Builder::listeners, JsonpDeserializer.longDeserializer(), "listeners");
        op.add(Builder::total, JsonpDeserializer.longDeserializer(), "total");
        op.add(Builder::totalTime, Time._DESERIALIZER, "total_time");
        op.add(Builder::totalTimeInMillis, JsonpDeserializer.longDeserializer(), "total_time_in_millis");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Long.hashCode(this.externalTotal);
        result = 31 * result + Objects.hashCode(this.externalTotalTime);
        result = 31 * result + Long.hashCode(this.externalTotalTimeInMillis);
        result = 31 * result + Long.hashCode(this.listeners);
        result = 31 * result + Long.hashCode(this.total);
        result = 31 * result + Objects.hashCode(this.totalTime);
        result = 31 * result + Long.hashCode(this.totalTimeInMillis);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        RefreshStats other = (RefreshStats) o;
        return this.externalTotal == other.externalTotal
            && Objects.equals(this.externalTotalTime, other.externalTotalTime)
            && this.externalTotalTimeInMillis == other.externalTotalTimeInMillis
            && this.listeners == other.listeners
            && this.total == other.total
            && Objects.equals(this.totalTime, other.totalTime)
            && this.totalTimeInMillis == other.totalTimeInMillis;
    }
}
