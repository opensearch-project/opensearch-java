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
import org.opensearch.client.opensearch._types.Time;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: indices.recovery.TranslogStatus

/**
 * The transaction log recovery status.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class TranslogStatus implements PlainJsonSerializable, ToCopyableBuilder<TranslogStatus.Builder, TranslogStatus> {

    @Nonnull
    private final String percent;

    private final int recovered;

    private final int total;

    private final int totalOnStart;

    @Nullable
    private final Time totalTime;

    private final long totalTimeInMillis;

    // ---------------------------------------------------------------------------------------------

    private TranslogStatus(Builder builder) {
        this.percent = ApiTypeHelper.requireNonNull(builder.percent, this, "percent");
        this.recovered = ApiTypeHelper.requireNonNull(builder.recovered, this, "recovered");
        this.total = ApiTypeHelper.requireNonNull(builder.total, this, "total");
        this.totalOnStart = ApiTypeHelper.requireNonNull(builder.totalOnStart, this, "totalOnStart");
        this.totalTime = builder.totalTime;
        this.totalTimeInMillis = ApiTypeHelper.requireNonNull(builder.totalTimeInMillis, this, "totalTimeInMillis");
    }

    public static TranslogStatus of(Function<TranslogStatus.Builder, ObjectBuilder<TranslogStatus>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code percent}
     */
    @Nonnull
    public final String percent() {
        return this.percent;
    }

    /**
     * Required - The number of recovered transaction log operations.
     * <p>
     * API name: {@code recovered}
     * </p>
     */
    public final int recovered() {
        return this.recovered;
    }

    /**
     * Required - The total number of transaction log operations.
     * <p>
     * API name: {@code total}
     * </p>
     */
    public final int total() {
        return this.total;
    }

    /**
     * Required - The number of transaction log operations at start.
     * <p>
     * API name: {@code total_on_start}
     * </p>
     */
    public final int totalOnStart() {
        return this.totalOnStart;
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
        generator.writeKey("percent");
        generator.write(this.percent);

        generator.writeKey("recovered");
        generator.write(this.recovered);

        generator.writeKey("total");
        generator.write(this.total);

        generator.writeKey("total_on_start");
        generator.write(this.totalOnStart);

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
     * Builder for {@link TranslogStatus}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, TranslogStatus> {
        private String percent;
        private Integer recovered;
        private Integer total;
        private Integer totalOnStart;
        @Nullable
        private Time totalTime;
        private Long totalTimeInMillis;

        public Builder() {}

        private Builder(TranslogStatus o) {
            this.percent = o.percent;
            this.recovered = o.recovered;
            this.total = o.total;
            this.totalOnStart = o.totalOnStart;
            this.totalTime = o.totalTime;
            this.totalTimeInMillis = o.totalTimeInMillis;
        }

        private Builder(Builder o) {
            this.percent = o.percent;
            this.recovered = o.recovered;
            this.total = o.total;
            this.totalOnStart = o.totalOnStart;
            this.totalTime = o.totalTime;
            this.totalTimeInMillis = o.totalTimeInMillis;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - API name: {@code percent}
         */
        @Nonnull
        public final Builder percent(String value) {
            this.percent = value;
            return this;
        }

        /**
         * Required - The number of recovered transaction log operations.
         * <p>
         * API name: {@code recovered}
         * </p>
         */
        @Nonnull
        public final Builder recovered(int value) {
            this.recovered = value;
            return this;
        }

        /**
         * Required - The total number of transaction log operations.
         * <p>
         * API name: {@code total}
         * </p>
         */
        @Nonnull
        public final Builder total(int value) {
            this.total = value;
            return this;
        }

        /**
         * Required - The number of transaction log operations at start.
         * <p>
         * API name: {@code total_on_start}
         * </p>
         */
        @Nonnull
        public final Builder totalOnStart(int value) {
            this.totalOnStart = value;
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
         * Builds a {@link TranslogStatus}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public TranslogStatus build() {
            _checkSingleUse();

            return new TranslogStatus(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link TranslogStatus}
     */
    public static final JsonpDeserializer<TranslogStatus> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        TranslogStatus::setupTranslogStatusDeserializer
    );

    protected static void setupTranslogStatusDeserializer(ObjectDeserializer<TranslogStatus.Builder> op) {
        op.add(Builder::percent, JsonpDeserializer.stringDeserializer(), "percent");
        op.add(Builder::recovered, JsonpDeserializer.integerDeserializer(), "recovered");
        op.add(Builder::total, JsonpDeserializer.integerDeserializer(), "total");
        op.add(Builder::totalOnStart, JsonpDeserializer.integerDeserializer(), "total_on_start");
        op.add(Builder::totalTime, Time._DESERIALIZER, "total_time");
        op.add(Builder::totalTimeInMillis, JsonpDeserializer.longDeserializer(), "total_time_in_millis");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.percent.hashCode();
        result = 31 * result + Integer.hashCode(this.recovered);
        result = 31 * result + Integer.hashCode(this.total);
        result = 31 * result + Integer.hashCode(this.totalOnStart);
        result = 31 * result + Objects.hashCode(this.totalTime);
        result = 31 * result + Long.hashCode(this.totalTimeInMillis);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        TranslogStatus other = (TranslogStatus) o;
        return this.percent.equals(other.percent)
            && this.recovered == other.recovered
            && this.total == other.total
            && this.totalOnStart == other.totalOnStart
            && Objects.equals(this.totalTime, other.totalTime)
            && this.totalTimeInMillis == other.totalTimeInMillis;
    }
}
