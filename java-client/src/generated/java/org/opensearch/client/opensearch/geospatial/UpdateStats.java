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
    private final Long lastProcessingTimeInMillis;

    @Nullable
    private final Long lastSucceededAtInEpochMillis;

    // ---------------------------------------------------------------------------------------------

    private UpdateStats(Builder builder) {
        this.lastProcessingTimeInMillis = builder.lastProcessingTimeInMillis;
        this.lastSucceededAtInEpochMillis = builder.lastSucceededAtInEpochMillis;
    }

    public static UpdateStats of(Function<UpdateStats.Builder, ObjectBuilder<UpdateStats>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code last_processing_time_in_millis}
     */
    @Nullable
    public final Long lastProcessingTimeInMillis() {
        return this.lastProcessingTimeInMillis;
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
        if (this.lastProcessingTimeInMillis != null) {
            generator.writeKey("last_processing_time_in_millis");
            generator.write(this.lastProcessingTimeInMillis);
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
        private Long lastProcessingTimeInMillis;
        @Nullable
        private Long lastSucceededAtInEpochMillis;

        public Builder() {}

        private Builder(UpdateStats o) {
            this.lastProcessingTimeInMillis = o.lastProcessingTimeInMillis;
            this.lastSucceededAtInEpochMillis = o.lastSucceededAtInEpochMillis;
        }

        private Builder(Builder o) {
            this.lastProcessingTimeInMillis = o.lastProcessingTimeInMillis;
            this.lastSucceededAtInEpochMillis = o.lastSucceededAtInEpochMillis;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code last_processing_time_in_millis}
         */
        @Nonnull
        public final Builder lastProcessingTimeInMillis(@Nullable Long value) {
            this.lastProcessingTimeInMillis = value;
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
        op.add(Builder::lastProcessingTimeInMillis, JsonpDeserializer.longDeserializer(), "last_processing_time_in_millis");
        op.add(Builder::lastSucceededAtInEpochMillis, JsonpDeserializer.longDeserializer(), "last_succeeded_at_in_epoch_millis");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.lastProcessingTimeInMillis);
        result = 31 * result + Objects.hashCode(this.lastSucceededAtInEpochMillis);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        UpdateStats other = (UpdateStats) o;
        return Objects.equals(this.lastProcessingTimeInMillis, other.lastProcessingTimeInMillis)
            && Objects.equals(this.lastSucceededAtInEpochMillis, other.lastSucceededAtInEpochMillis);
    }
}
