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

// typedef: _types.RemoteStoreDownloadStats

/**
 * Statistics related to downloads to the remote segment store.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class RemoteStoreDownloadStats
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<RemoteStoreDownloadStats.Builder, RemoteStoreDownloadStats> {

    @Nonnull
    private final RemoteStoreUploadDownloadStats totalDownloadSize;

    @Nullable
    private final Time totalTimeSpent;

    private final long totalTimeSpentInMillis;

    // ---------------------------------------------------------------------------------------------

    private RemoteStoreDownloadStats(Builder builder) {
        this.totalDownloadSize = ApiTypeHelper.requireNonNull(builder.totalDownloadSize, this, "totalDownloadSize");
        this.totalTimeSpent = builder.totalTimeSpent;
        this.totalTimeSpentInMillis = ApiTypeHelper.requireNonNull(builder.totalTimeSpentInMillis, this, "totalTimeSpentInMillis");
    }

    public static RemoteStoreDownloadStats of(Function<RemoteStoreDownloadStats.Builder, ObjectBuilder<RemoteStoreDownloadStats>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - The total amount of data downloaded from the remote segment store.
     * <p>
     * API name: {@code total_download_size}
     * </p>
     */
    @Nonnull
    public final RemoteStoreUploadDownloadStats totalDownloadSize() {
        return this.totalDownloadSize;
    }

    /**
     * The total amount of time spent on downloads from the remote segment store.
     * <p>
     * API name: {@code total_time_spent}
     * </p>
     */
    @Nullable
    public final Time totalTimeSpent() {
        return this.totalTimeSpent;
    }

    /**
     * Required - The total duration, in milliseconds, spent on downloads from the remote segment store.
     * <p>
     * API name: {@code total_time_spent_in_millis}
     * </p>
     */
    public final long totalTimeSpentInMillis() {
        return this.totalTimeSpentInMillis;
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
        generator.writeKey("total_download_size");
        this.totalDownloadSize.serialize(generator, mapper);

        if (this.totalTimeSpent != null) {
            generator.writeKey("total_time_spent");
            this.totalTimeSpent.serialize(generator, mapper);
        }

        generator.writeKey("total_time_spent_in_millis");
        generator.write(this.totalTimeSpentInMillis);
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
     * Builder for {@link RemoteStoreDownloadStats}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, RemoteStoreDownloadStats> {
        private RemoteStoreUploadDownloadStats totalDownloadSize;
        @Nullable
        private Time totalTimeSpent;
        private Long totalTimeSpentInMillis;

        public Builder() {}

        private Builder(RemoteStoreDownloadStats o) {
            this.totalDownloadSize = o.totalDownloadSize;
            this.totalTimeSpent = o.totalTimeSpent;
            this.totalTimeSpentInMillis = o.totalTimeSpentInMillis;
        }

        private Builder(Builder o) {
            this.totalDownloadSize = o.totalDownloadSize;
            this.totalTimeSpent = o.totalTimeSpent;
            this.totalTimeSpentInMillis = o.totalTimeSpentInMillis;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - The total amount of data downloaded from the remote segment store.
         * <p>
         * API name: {@code total_download_size}
         * </p>
         */
        @Nonnull
        public final Builder totalDownloadSize(RemoteStoreUploadDownloadStats value) {
            this.totalDownloadSize = value;
            return this;
        }

        /**
         * Required - The total amount of data downloaded from the remote segment store.
         * <p>
         * API name: {@code total_download_size}
         * </p>
         */
        @Nonnull
        public final Builder totalDownloadSize(
            Function<RemoteStoreUploadDownloadStats.Builder, ObjectBuilder<RemoteStoreUploadDownloadStats>> fn
        ) {
            return totalDownloadSize(fn.apply(new RemoteStoreUploadDownloadStats.Builder()).build());
        }

        /**
         * The total amount of time spent on downloads from the remote segment store.
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
         * The total amount of time spent on downloads from the remote segment store.
         * <p>
         * API name: {@code total_time_spent}
         * </p>
         */
        @Nonnull
        public final Builder totalTimeSpent(Function<Time.Builder, ObjectBuilder<Time>> fn) {
            return totalTimeSpent(fn.apply(new Time.Builder()).build());
        }

        /**
         * Required - The total duration, in milliseconds, spent on downloads from the remote segment store.
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
         * Builds a {@link RemoteStoreDownloadStats}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public RemoteStoreDownloadStats build() {
            _checkSingleUse();

            return new RemoteStoreDownloadStats(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link RemoteStoreDownloadStats}
     */
    public static final JsonpDeserializer<RemoteStoreDownloadStats> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        RemoteStoreDownloadStats::setupRemoteStoreDownloadStatsDeserializer
    );

    protected static void setupRemoteStoreDownloadStatsDeserializer(ObjectDeserializer<RemoteStoreDownloadStats.Builder> op) {
        op.add(Builder::totalDownloadSize, RemoteStoreUploadDownloadStats._DESERIALIZER, "total_download_size");
        op.add(Builder::totalTimeSpent, Time._DESERIALIZER, "total_time_spent");
        op.add(Builder::totalTimeSpentInMillis, JsonpDeserializer.longDeserializer(), "total_time_spent_in_millis");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.totalDownloadSize.hashCode();
        result = 31 * result + Objects.hashCode(this.totalTimeSpent);
        result = 31 * result + Long.hashCode(this.totalTimeSpentInMillis);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        RemoteStoreDownloadStats other = (RemoteStoreDownloadStats) o;
        return this.totalDownloadSize.equals(other.totalDownloadSize)
            && Objects.equals(this.totalTimeSpent, other.totalTimeSpent)
            && this.totalTimeSpentInMillis == other.totalTimeSpentInMillis;
    }
}
