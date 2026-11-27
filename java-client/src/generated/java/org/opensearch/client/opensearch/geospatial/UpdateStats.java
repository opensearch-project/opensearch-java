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

package org.opensearch.client.opensearch.geospatial;

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
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: geospatial.UpdateStats

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class UpdateStats implements PlainJsonSerializable, ToCopyableBuilder<UpdateStats.Builder, UpdateStats> {

    @Nullable
    private final String lastFailedAt;

    @Nullable
    private final Long lastFailedAtInEpochMillis;

    @Nullable
    private final Long lastProcessingTimeInMillis;

    @Nullable
    private final String lastSkippedAt;

    @Nullable
    private final Long lastSkippedAtInEpochMillis;

    @Nullable
    private final String lastSucceededAt;

    @Nullable
    private final Long lastSucceededAtInEpochMillis;

    // ---------------------------------------------------------------------------------------------

    private UpdateStats(Builder builder) {
        this.lastFailedAt = builder.lastFailedAt;
        this.lastFailedAtInEpochMillis = builder.lastFailedAtInEpochMillis;
        this.lastProcessingTimeInMillis = builder.lastProcessingTimeInMillis;
        this.lastSkippedAt = builder.lastSkippedAt;
        this.lastSkippedAtInEpochMillis = builder.lastSkippedAtInEpochMillis;
        this.lastSucceededAt = builder.lastSucceededAt;
        this.lastSucceededAtInEpochMillis = builder.lastSucceededAtInEpochMillis;
    }

    public static UpdateStats of(Function<UpdateStats.Builder, ObjectBuilder<UpdateStats>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Human-readable timestamp of the last failed update.
     * <p>
     * API name: {@code last_failed_at}
     * </p>
     */
    @Nullable
    public final String lastFailedAt() {
        return this.lastFailedAt;
    }

    /**
     * API name: {@code last_failed_at_in_epoch_millis}
     */
    @Nullable
    public final Long lastFailedAtInEpochMillis() {
        return this.lastFailedAtInEpochMillis;
    }

    /**
     * Processing time of the last update in milliseconds.
     * <p>
     * API name: {@code last_processing_time_in_millis}
     * </p>
     */
    @Nullable
    public final Long lastProcessingTimeInMillis() {
        return this.lastProcessingTimeInMillis;
    }

    /**
     * Human-readable timestamp of the last skipped update.
     * <p>
     * API name: {@code last_skipped_at}
     * </p>
     */
    @Nullable
    public final String lastSkippedAt() {
        return this.lastSkippedAt;
    }

    /**
     * API name: {@code last_skipped_at_in_epoch_millis}
     */
    @Nullable
    public final Long lastSkippedAtInEpochMillis() {
        return this.lastSkippedAtInEpochMillis;
    }

    /**
     * Human-readable timestamp of the last successful update.
     * <p>
     * API name: {@code last_succeeded_at}
     * </p>
     */
    @Nullable
    public final String lastSucceededAt() {
        return this.lastSucceededAt;
    }

    /**
     * API name: {@code last_succeeded_at_in_epoch_millis}
     */
    @Nullable
    public final Long lastSucceededAtInEpochMillis() {
        return this.lastSucceededAtInEpochMillis;
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
        if (this.lastFailedAt != null) {
            generator.writeKey("last_failed_at");
            generator.write(this.lastFailedAt);
        }

        if (this.lastFailedAtInEpochMillis != null) {
            generator.writeKey("last_failed_at_in_epoch_millis");
            generator.write(this.lastFailedAtInEpochMillis);
        }

        if (this.lastProcessingTimeInMillis != null) {
            generator.writeKey("last_processing_time_in_millis");
            generator.write(this.lastProcessingTimeInMillis);
        }

        if (this.lastSkippedAt != null) {
            generator.writeKey("last_skipped_at");
            generator.write(this.lastSkippedAt);
        }

        if (this.lastSkippedAtInEpochMillis != null) {
            generator.writeKey("last_skipped_at_in_epoch_millis");
            generator.write(this.lastSkippedAtInEpochMillis);
        }

        if (this.lastSucceededAt != null) {
            generator.writeKey("last_succeeded_at");
            generator.write(this.lastSucceededAt);
        }

        if (this.lastSucceededAtInEpochMillis != null) {
            generator.writeKey("last_succeeded_at_in_epoch_millis");
            generator.write(this.lastSucceededAtInEpochMillis);
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
     * Builder for {@link UpdateStats}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, UpdateStats> {
        @Nullable
        private String lastFailedAt;
        @Nullable
        private Long lastFailedAtInEpochMillis;
        @Nullable
        private Long lastProcessingTimeInMillis;
        @Nullable
        private String lastSkippedAt;
        @Nullable
        private Long lastSkippedAtInEpochMillis;
        @Nullable
        private String lastSucceededAt;
        @Nullable
        private Long lastSucceededAtInEpochMillis;

        public Builder() {}

        private Builder(UpdateStats o) {
            this.lastFailedAt = o.lastFailedAt;
            this.lastFailedAtInEpochMillis = o.lastFailedAtInEpochMillis;
            this.lastProcessingTimeInMillis = o.lastProcessingTimeInMillis;
            this.lastSkippedAt = o.lastSkippedAt;
            this.lastSkippedAtInEpochMillis = o.lastSkippedAtInEpochMillis;
            this.lastSucceededAt = o.lastSucceededAt;
            this.lastSucceededAtInEpochMillis = o.lastSucceededAtInEpochMillis;
        }

        private Builder(Builder o) {
            this.lastFailedAt = o.lastFailedAt;
            this.lastFailedAtInEpochMillis = o.lastFailedAtInEpochMillis;
            this.lastProcessingTimeInMillis = o.lastProcessingTimeInMillis;
            this.lastSkippedAt = o.lastSkippedAt;
            this.lastSkippedAtInEpochMillis = o.lastSkippedAtInEpochMillis;
            this.lastSucceededAt = o.lastSucceededAt;
            this.lastSucceededAtInEpochMillis = o.lastSucceededAtInEpochMillis;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Human-readable timestamp of the last failed update.
         * <p>
         * API name: {@code last_failed_at}
         * </p>
         */
        @Nonnull
        public final Builder lastFailedAt(@Nullable String value) {
            this.lastFailedAt = value;
            return this;
        }

        /**
         * API name: {@code last_failed_at_in_epoch_millis}
         */
        @Nonnull
        public final Builder lastFailedAtInEpochMillis(@Nullable Long value) {
            this.lastFailedAtInEpochMillis = value;
            return this;
        }

        /**
         * Processing time of the last update in milliseconds.
         * <p>
         * API name: {@code last_processing_time_in_millis}
         * </p>
         */
        @Nonnull
        public final Builder lastProcessingTimeInMillis(@Nullable Long value) {
            this.lastProcessingTimeInMillis = value;
            return this;
        }

        /**
         * Human-readable timestamp of the last skipped update.
         * <p>
         * API name: {@code last_skipped_at}
         * </p>
         */
        @Nonnull
        public final Builder lastSkippedAt(@Nullable String value) {
            this.lastSkippedAt = value;
            return this;
        }

        /**
         * API name: {@code last_skipped_at_in_epoch_millis}
         */
        @Nonnull
        public final Builder lastSkippedAtInEpochMillis(@Nullable Long value) {
            this.lastSkippedAtInEpochMillis = value;
            return this;
        }

        /**
         * Human-readable timestamp of the last successful update.
         * <p>
         * API name: {@code last_succeeded_at}
         * </p>
         */
        @Nonnull
        public final Builder lastSucceededAt(@Nullable String value) {
            this.lastSucceededAt = value;
            return this;
        }

        /**
         * API name: {@code last_succeeded_at_in_epoch_millis}
         */
        @Nonnull
        public final Builder lastSucceededAtInEpochMillis(@Nullable Long value) {
            this.lastSucceededAtInEpochMillis = value;
            return this;
        }

        /**
         * Builds a {@link UpdateStats}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public UpdateStats build() {
            _checkSingleUse();

            return new UpdateStats(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link UpdateStats}
     */
    public static final JsonpDeserializer<UpdateStats> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        UpdateStats::setupUpdateStatsDeserializer
    );

    protected static void setupUpdateStatsDeserializer(ObjectDeserializer<UpdateStats.Builder> op) {
        op.add(Builder::lastFailedAt, JsonpDeserializer.stringDeserializer(), "last_failed_at");
        op.add(Builder::lastFailedAtInEpochMillis, JsonpDeserializer.longDeserializer(), "last_failed_at_in_epoch_millis");
        op.add(Builder::lastProcessingTimeInMillis, JsonpDeserializer.longDeserializer(), "last_processing_time_in_millis");
        op.add(Builder::lastSkippedAt, JsonpDeserializer.stringDeserializer(), "last_skipped_at");
        op.add(Builder::lastSkippedAtInEpochMillis, JsonpDeserializer.longDeserializer(), "last_skipped_at_in_epoch_millis");
        op.add(Builder::lastSucceededAt, JsonpDeserializer.stringDeserializer(), "last_succeeded_at");
        op.add(Builder::lastSucceededAtInEpochMillis, JsonpDeserializer.longDeserializer(), "last_succeeded_at_in_epoch_millis");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.lastFailedAt);
        result = 31 * result + Objects.hashCode(this.lastFailedAtInEpochMillis);
        result = 31 * result + Objects.hashCode(this.lastProcessingTimeInMillis);
        result = 31 * result + Objects.hashCode(this.lastSkippedAt);
        result = 31 * result + Objects.hashCode(this.lastSkippedAtInEpochMillis);
        result = 31 * result + Objects.hashCode(this.lastSucceededAt);
        result = 31 * result + Objects.hashCode(this.lastSucceededAtInEpochMillis);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        UpdateStats other = (UpdateStats) o;
        return Objects.equals(this.lastFailedAt, other.lastFailedAt)
            && Objects.equals(this.lastFailedAtInEpochMillis, other.lastFailedAtInEpochMillis)
            && Objects.equals(this.lastProcessingTimeInMillis, other.lastProcessingTimeInMillis)
            && Objects.equals(this.lastSkippedAt, other.lastSkippedAt)
            && Objects.equals(this.lastSkippedAtInEpochMillis, other.lastSkippedAtInEpochMillis)
            && Objects.equals(this.lastSucceededAt, other.lastSucceededAt)
            && Objects.equals(this.lastSucceededAtInEpochMillis, other.lastSucceededAtInEpochMillis);
    }
}
