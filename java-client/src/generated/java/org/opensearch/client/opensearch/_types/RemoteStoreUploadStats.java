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

// typedef: _types.RemoteStoreUploadStats

/**
 * Statistics related to uploads to the remote segment store.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class RemoteStoreUploadStats
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<RemoteStoreUploadStats.Builder, RemoteStoreUploadStats> {

    @Nullable
    private final Time maxRefreshTimeLag;

    private final long maxRefreshTimeLagInMillis;

    @Nonnull
    private final RemoteStoreUploadPressureStats pressure;

    @Nonnull
    private final RemoteStoreUploadRefreshSizeLagStats refreshSizeLag;

    @Nullable
    private final Time totalTimeSpent;

    private final long totalTimeSpentInMillis;

    @Nonnull
    private final RemoteStoreUploadDownloadStats totalUploadSize;

    // ---------------------------------------------------------------------------------------------

    private RemoteStoreUploadStats(Builder builder) {
        this.maxRefreshTimeLag = builder.maxRefreshTimeLag;
        this.maxRefreshTimeLagInMillis = ApiTypeHelper.requireNonNull(builder.maxRefreshTimeLagInMillis, this, "maxRefreshTimeLagInMillis");
        this.pressure = ApiTypeHelper.requireNonNull(builder.pressure, this, "pressure");
        this.refreshSizeLag = ApiTypeHelper.requireNonNull(builder.refreshSizeLag, this, "refreshSizeLag");
        this.totalTimeSpent = builder.totalTimeSpent;
        this.totalTimeSpentInMillis = ApiTypeHelper.requireNonNull(builder.totalTimeSpentInMillis, this, "totalTimeSpentInMillis");
        this.totalUploadSize = ApiTypeHelper.requireNonNull(builder.totalUploadSize, this, "totalUploadSize");
    }

    public static RemoteStoreUploadStats of(Function<RemoteStoreUploadStats.Builder, ObjectBuilder<RemoteStoreUploadStats>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * The maximum duration that the remote refresh is behind the local refresh.
     * <p>
     * API name: {@code max_refresh_time_lag}
     * </p>
     */
    @Nullable
    public final Time maxRefreshTimeLag() {
        return this.maxRefreshTimeLag;
    }

    /**
     * Required - The maximum duration, in milliseconds, that the remote refresh is behind the local refresh.
     * <p>
     * API name: {@code max_refresh_time_lag_in_millis}
     * </p>
     */
    public final long maxRefreshTimeLagInMillis() {
        return this.maxRefreshTimeLagInMillis;
    }

    /**
     * Required - API name: {@code pressure}
     */
    @Nonnull
    public final RemoteStoreUploadPressureStats pressure() {
        return this.pressure;
    }

    /**
     * Required - API name: {@code refresh_size_lag}
     */
    @Nonnull
    public final RemoteStoreUploadRefreshSizeLagStats refreshSizeLag() {
        return this.refreshSizeLag;
    }

    /**
     * The total amount of time spent on uploads to the remote segment store.
     * <p>
     * API name: {@code total_time_spent}
     * </p>
     */
    @Nullable
    public final Time totalTimeSpent() {
        return this.totalTimeSpent;
    }

    /**
     * Required - The total amount of time, in milliseconds, spent on uploads to the remote segment store.
     * <p>
     * API name: {@code total_time_spent_in_millis}
     * </p>
     */
    public final long totalTimeSpentInMillis() {
        return this.totalTimeSpentInMillis;
    }

    /**
     * Required - API name: {@code total_upload_size}
     */
    @Nonnull
    public final RemoteStoreUploadDownloadStats totalUploadSize() {
        return this.totalUploadSize;
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
        if (this.maxRefreshTimeLag != null) {
            generator.writeKey("max_refresh_time_lag");
            this.maxRefreshTimeLag.serialize(generator, mapper);
        }

        generator.writeKey("max_refresh_time_lag_in_millis");
        generator.write(this.maxRefreshTimeLagInMillis);

        generator.writeKey("pressure");
        this.pressure.serialize(generator, mapper);

        generator.writeKey("refresh_size_lag");
        this.refreshSizeLag.serialize(generator, mapper);

        if (this.totalTimeSpent != null) {
            generator.writeKey("total_time_spent");
            this.totalTimeSpent.serialize(generator, mapper);
        }

        generator.writeKey("total_time_spent_in_millis");
        generator.write(this.totalTimeSpentInMillis);

        generator.writeKey("total_upload_size");
        this.totalUploadSize.serialize(generator, mapper);
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
     * Builder for {@link RemoteStoreUploadStats}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, RemoteStoreUploadStats> {
        @Nullable
        private Time maxRefreshTimeLag;
        private Long maxRefreshTimeLagInMillis;
        private RemoteStoreUploadPressureStats pressure;
        private RemoteStoreUploadRefreshSizeLagStats refreshSizeLag;
        @Nullable
        private Time totalTimeSpent;
        private Long totalTimeSpentInMillis;
        private RemoteStoreUploadDownloadStats totalUploadSize;

        public Builder() {}

        private Builder(RemoteStoreUploadStats o) {
            this.maxRefreshTimeLag = o.maxRefreshTimeLag;
            this.maxRefreshTimeLagInMillis = o.maxRefreshTimeLagInMillis;
            this.pressure = o.pressure;
            this.refreshSizeLag = o.refreshSizeLag;
            this.totalTimeSpent = o.totalTimeSpent;
            this.totalTimeSpentInMillis = o.totalTimeSpentInMillis;
            this.totalUploadSize = o.totalUploadSize;
        }

        private Builder(Builder o) {
            this.maxRefreshTimeLag = o.maxRefreshTimeLag;
            this.maxRefreshTimeLagInMillis = o.maxRefreshTimeLagInMillis;
            this.pressure = o.pressure;
            this.refreshSizeLag = o.refreshSizeLag;
            this.totalTimeSpent = o.totalTimeSpent;
            this.totalTimeSpentInMillis = o.totalTimeSpentInMillis;
            this.totalUploadSize = o.totalUploadSize;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * The maximum duration that the remote refresh is behind the local refresh.
         * <p>
         * API name: {@code max_refresh_time_lag}
         * </p>
         */
        @Nonnull
        public final Builder maxRefreshTimeLag(@Nullable Time value) {
            this.maxRefreshTimeLag = value;
            return this;
        }

        /**
         * The maximum duration that the remote refresh is behind the local refresh.
         * <p>
         * API name: {@code max_refresh_time_lag}
         * </p>
         */
        @Nonnull
        public final Builder maxRefreshTimeLag(Function<Time.Builder, ObjectBuilder<Time>> fn) {
            return maxRefreshTimeLag(fn.apply(new Time.Builder()).build());
        }

        /**
         * Required - The maximum duration, in milliseconds, that the remote refresh is behind the local refresh.
         * <p>
         * API name: {@code max_refresh_time_lag_in_millis}
         * </p>
         */
        @Nonnull
        public final Builder maxRefreshTimeLagInMillis(long value) {
            this.maxRefreshTimeLagInMillis = value;
            return this;
        }

        /**
         * Required - API name: {@code pressure}
         */
        @Nonnull
        public final Builder pressure(RemoteStoreUploadPressureStats value) {
            this.pressure = value;
            return this;
        }

        /**
         * Required - API name: {@code pressure}
         */
        @Nonnull
        public final Builder pressure(Function<RemoteStoreUploadPressureStats.Builder, ObjectBuilder<RemoteStoreUploadPressureStats>> fn) {
            return pressure(fn.apply(new RemoteStoreUploadPressureStats.Builder()).build());
        }

        /**
         * Required - API name: {@code refresh_size_lag}
         */
        @Nonnull
        public final Builder refreshSizeLag(RemoteStoreUploadRefreshSizeLagStats value) {
            this.refreshSizeLag = value;
            return this;
        }

        /**
         * Required - API name: {@code refresh_size_lag}
         */
        @Nonnull
        public final Builder refreshSizeLag(
            Function<RemoteStoreUploadRefreshSizeLagStats.Builder, ObjectBuilder<RemoteStoreUploadRefreshSizeLagStats>> fn
        ) {
            return refreshSizeLag(fn.apply(new RemoteStoreUploadRefreshSizeLagStats.Builder()).build());
        }

        /**
         * The total amount of time spent on uploads to the remote segment store.
         * <p>
         * API name: {@code total_time_spent}
         * </p>
         */
        @Nonnull
        public final Builder totalTimeSpent(@Nullable Time value) {
            this.totalTimeSpent = value;
            return this;
        }

        /**
         * The total amount of time spent on uploads to the remote segment store.
         * <p>
         * API name: {@code total_time_spent}
         * </p>
         */
        @Nonnull
        public final Builder totalTimeSpent(Function<Time.Builder, ObjectBuilder<Time>> fn) {
            return totalTimeSpent(fn.apply(new Time.Builder()).build());
        }

        /**
         * Required - The total amount of time, in milliseconds, spent on uploads to the remote segment store.
         * <p>
         * API name: {@code total_time_spent_in_millis}
         * </p>
         */
        @Nonnull
        public final Builder totalTimeSpentInMillis(long value) {
            this.totalTimeSpentInMillis = value;
            return this;
        }

        /**
         * Required - API name: {@code total_upload_size}
         */
        @Nonnull
        public final Builder totalUploadSize(RemoteStoreUploadDownloadStats value) {
            this.totalUploadSize = value;
            return this;
        }

        /**
         * Required - API name: {@code total_upload_size}
         */
        @Nonnull
        public final Builder totalUploadSize(
            Function<RemoteStoreUploadDownloadStats.Builder, ObjectBuilder<RemoteStoreUploadDownloadStats>> fn
        ) {
            return totalUploadSize(fn.apply(new RemoteStoreUploadDownloadStats.Builder()).build());
        }

        /**
         * Builds a {@link RemoteStoreUploadStats}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public RemoteStoreUploadStats build() {
            _checkSingleUse();

            return new RemoteStoreUploadStats(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link RemoteStoreUploadStats}
     */
    public static final JsonpDeserializer<RemoteStoreUploadStats> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        RemoteStoreUploadStats::setupRemoteStoreUploadStatsDeserializer
    );

    protected static void setupRemoteStoreUploadStatsDeserializer(ObjectDeserializer<RemoteStoreUploadStats.Builder> op) {
        op.add(Builder::maxRefreshTimeLag, Time._DESERIALIZER, "max_refresh_time_lag");
        op.add(Builder::maxRefreshTimeLagInMillis, JsonpDeserializer.longDeserializer(), "max_refresh_time_lag_in_millis");
        op.add(Builder::pressure, RemoteStoreUploadPressureStats._DESERIALIZER, "pressure");
        op.add(Builder::refreshSizeLag, RemoteStoreUploadRefreshSizeLagStats._DESERIALIZER, "refresh_size_lag");
        op.add(Builder::totalTimeSpent, Time._DESERIALIZER, "total_time_spent");
        op.add(Builder::totalTimeSpentInMillis, JsonpDeserializer.longDeserializer(), "total_time_spent_in_millis");
        op.add(Builder::totalUploadSize, RemoteStoreUploadDownloadStats._DESERIALIZER, "total_upload_size");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.maxRefreshTimeLag);
        result = 31 * result + Long.hashCode(this.maxRefreshTimeLagInMillis);
        result = 31 * result + this.pressure.hashCode();
        result = 31 * result + this.refreshSizeLag.hashCode();
        result = 31 * result + Objects.hashCode(this.totalTimeSpent);
        result = 31 * result + Long.hashCode(this.totalTimeSpentInMillis);
        result = 31 * result + this.totalUploadSize.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        RemoteStoreUploadStats other = (RemoteStoreUploadStats) o;
        return Objects.equals(this.maxRefreshTimeLag, other.maxRefreshTimeLag)
            && this.maxRefreshTimeLagInMillis == other.maxRefreshTimeLagInMillis
            && this.pressure.equals(other.pressure)
            && this.refreshSizeLag.equals(other.refreshSizeLag)
            && Objects.equals(this.totalTimeSpent, other.totalTimeSpent)
            && this.totalTimeSpentInMillis == other.totalTimeSpentInMillis
            && this.totalUploadSize.equals(other.totalUploadSize);
    }
}
