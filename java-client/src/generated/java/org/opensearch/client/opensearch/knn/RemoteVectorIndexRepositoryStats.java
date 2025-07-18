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

package org.opensearch.client.opensearch.knn;

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

// typedef: knn.RemoteVectorIndexRepositoryStats

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class RemoteVectorIndexRepositoryStats
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<RemoteVectorIndexRepositoryStats.Builder, RemoteVectorIndexRepositoryStats> {

    @Nullable
    private final Long readFailureCount;

    @Nullable
    private final Long readSuccessCount;

    @Nullable
    private final Long successfulReadTimeInMillis;

    @Nullable
    private final Long successfulWriteTimeInMillis;

    @Nullable
    private final Long writeFailureCount;

    @Nullable
    private final Long writeSuccessCount;

    // ---------------------------------------------------------------------------------------------

    private RemoteVectorIndexRepositoryStats(Builder builder) {
        this.readFailureCount = builder.readFailureCount;
        this.readSuccessCount = builder.readSuccessCount;
        this.successfulReadTimeInMillis = builder.successfulReadTimeInMillis;
        this.successfulWriteTimeInMillis = builder.successfulWriteTimeInMillis;
        this.writeFailureCount = builder.writeFailureCount;
        this.writeSuccessCount = builder.writeSuccessCount;
    }

    public static RemoteVectorIndexRepositoryStats of(
        Function<RemoteVectorIndexRepositoryStats.Builder, ObjectBuilder<RemoteVectorIndexRepositoryStats>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code read_failure_count}
     */
    @Nullable
    public final Long readFailureCount() {
        return this.readFailureCount;
    }

    /**
     * API name: {@code read_success_count}
     */
    @Nullable
    public final Long readSuccessCount() {
        return this.readSuccessCount;
    }

    /**
     * API name: {@code successful_read_time_in_millis}
     */
    @Nullable
    public final Long successfulReadTimeInMillis() {
        return this.successfulReadTimeInMillis;
    }

    /**
     * API name: {@code successful_write_time_in_millis}
     */
    @Nullable
    public final Long successfulWriteTimeInMillis() {
        return this.successfulWriteTimeInMillis;
    }

    /**
     * API name: {@code write_failure_count}
     */
    @Nullable
    public final Long writeFailureCount() {
        return this.writeFailureCount;
    }

    /**
     * API name: {@code write_success_count}
     */
    @Nullable
    public final Long writeSuccessCount() {
        return this.writeSuccessCount;
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
        if (this.readFailureCount != null) {
            generator.writeKey("read_failure_count");
            generator.write(this.readFailureCount);
        }

        if (this.readSuccessCount != null) {
            generator.writeKey("read_success_count");
            generator.write(this.readSuccessCount);
        }

        if (this.successfulReadTimeInMillis != null) {
            generator.writeKey("successful_read_time_in_millis");
            generator.write(this.successfulReadTimeInMillis);
        }

        if (this.successfulWriteTimeInMillis != null) {
            generator.writeKey("successful_write_time_in_millis");
            generator.write(this.successfulWriteTimeInMillis);
        }

        if (this.writeFailureCount != null) {
            generator.writeKey("write_failure_count");
            generator.write(this.writeFailureCount);
        }

        if (this.writeSuccessCount != null) {
            generator.writeKey("write_success_count");
            generator.write(this.writeSuccessCount);
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
     * Builder for {@link RemoteVectorIndexRepositoryStats}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, RemoteVectorIndexRepositoryStats> {
        @Nullable
        private Long readFailureCount;
        @Nullable
        private Long readSuccessCount;
        @Nullable
        private Long successfulReadTimeInMillis;
        @Nullable
        private Long successfulWriteTimeInMillis;
        @Nullable
        private Long writeFailureCount;
        @Nullable
        private Long writeSuccessCount;

        public Builder() {}

        private Builder(RemoteVectorIndexRepositoryStats o) {
            this.readFailureCount = o.readFailureCount;
            this.readSuccessCount = o.readSuccessCount;
            this.successfulReadTimeInMillis = o.successfulReadTimeInMillis;
            this.successfulWriteTimeInMillis = o.successfulWriteTimeInMillis;
            this.writeFailureCount = o.writeFailureCount;
            this.writeSuccessCount = o.writeSuccessCount;
        }

        private Builder(Builder o) {
            this.readFailureCount = o.readFailureCount;
            this.readSuccessCount = o.readSuccessCount;
            this.successfulReadTimeInMillis = o.successfulReadTimeInMillis;
            this.successfulWriteTimeInMillis = o.successfulWriteTimeInMillis;
            this.writeFailureCount = o.writeFailureCount;
            this.writeSuccessCount = o.writeSuccessCount;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code read_failure_count}
         */
        @Nonnull
        public final Builder readFailureCount(@Nullable Long value) {
            this.readFailureCount = value;
            return this;
        }

        /**
         * API name: {@code read_success_count}
         */
        @Nonnull
        public final Builder readSuccessCount(@Nullable Long value) {
            this.readSuccessCount = value;
            return this;
        }

        /**
         * API name: {@code successful_read_time_in_millis}
         */
        @Nonnull
        public final Builder successfulReadTimeInMillis(@Nullable Long value) {
            this.successfulReadTimeInMillis = value;
            return this;
        }

        /**
         * API name: {@code successful_write_time_in_millis}
         */
        @Nonnull
        public final Builder successfulWriteTimeInMillis(@Nullable Long value) {
            this.successfulWriteTimeInMillis = value;
            return this;
        }

        /**
         * API name: {@code write_failure_count}
         */
        @Nonnull
        public final Builder writeFailureCount(@Nullable Long value) {
            this.writeFailureCount = value;
            return this;
        }

        /**
         * API name: {@code write_success_count}
         */
        @Nonnull
        public final Builder writeSuccessCount(@Nullable Long value) {
            this.writeSuccessCount = value;
            return this;
        }

        /**
         * Builds a {@link RemoteVectorIndexRepositoryStats}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public RemoteVectorIndexRepositoryStats build() {
            _checkSingleUse();

            return new RemoteVectorIndexRepositoryStats(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link RemoteVectorIndexRepositoryStats}
     */
    public static final JsonpDeserializer<RemoteVectorIndexRepositoryStats> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        RemoteVectorIndexRepositoryStats::setupRemoteVectorIndexRepositoryStatsDeserializer
    );

    protected static void setupRemoteVectorIndexRepositoryStatsDeserializer(
        ObjectDeserializer<RemoteVectorIndexRepositoryStats.Builder> op
    ) {
        op.add(Builder::readFailureCount, JsonpDeserializer.longDeserializer(), "read_failure_count");
        op.add(Builder::readSuccessCount, JsonpDeserializer.longDeserializer(), "read_success_count");
        op.add(Builder::successfulReadTimeInMillis, JsonpDeserializer.longDeserializer(), "successful_read_time_in_millis");
        op.add(Builder::successfulWriteTimeInMillis, JsonpDeserializer.longDeserializer(), "successful_write_time_in_millis");
        op.add(Builder::writeFailureCount, JsonpDeserializer.longDeserializer(), "write_failure_count");
        op.add(Builder::writeSuccessCount, JsonpDeserializer.longDeserializer(), "write_success_count");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.readFailureCount);
        result = 31 * result + Objects.hashCode(this.readSuccessCount);
        result = 31 * result + Objects.hashCode(this.successfulReadTimeInMillis);
        result = 31 * result + Objects.hashCode(this.successfulWriteTimeInMillis);
        result = 31 * result + Objects.hashCode(this.writeFailureCount);
        result = 31 * result + Objects.hashCode(this.writeSuccessCount);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        RemoteVectorIndexRepositoryStats other = (RemoteVectorIndexRepositoryStats) o;
        return Objects.equals(this.readFailureCount, other.readFailureCount)
            && Objects.equals(this.readSuccessCount, other.readSuccessCount)
            && Objects.equals(this.successfulReadTimeInMillis, other.successfulReadTimeInMillis)
            && Objects.equals(this.successfulWriteTimeInMillis, other.successfulWriteTimeInMillis)
            && Objects.equals(this.writeFailureCount, other.writeFailureCount)
            && Objects.equals(this.writeSuccessCount, other.writeSuccessCount);
    }
}
