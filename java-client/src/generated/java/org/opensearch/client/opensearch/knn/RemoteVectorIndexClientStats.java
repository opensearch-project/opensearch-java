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

// typedef: knn.RemoteVectorIndexClientStats

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class RemoteVectorIndexClientStats
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<RemoteVectorIndexClientStats.Builder, RemoteVectorIndexClientStats> {

    @Nullable
    private final Long buildRequestFailureCount;

    @Nullable
    private final Long buildRequestSuccessCount;

    @Nullable
    private final Long indexBuildFailureCount;

    @Nullable
    private final Long indexBuildSuccessCount;

    @Nullable
    private final Long statusRequestFailureCount;

    @Nullable
    private final Long statusRequestSuccessCount;

    @Nullable
    private final Long waitingTimeInMs;

    // ---------------------------------------------------------------------------------------------

    private RemoteVectorIndexClientStats(Builder builder) {
        this.buildRequestFailureCount = builder.buildRequestFailureCount;
        this.buildRequestSuccessCount = builder.buildRequestSuccessCount;
        this.indexBuildFailureCount = builder.indexBuildFailureCount;
        this.indexBuildSuccessCount = builder.indexBuildSuccessCount;
        this.statusRequestFailureCount = builder.statusRequestFailureCount;
        this.statusRequestSuccessCount = builder.statusRequestSuccessCount;
        this.waitingTimeInMs = builder.waitingTimeInMs;
    }

    public static RemoteVectorIndexClientStats of(
        Function<RemoteVectorIndexClientStats.Builder, ObjectBuilder<RemoteVectorIndexClientStats>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code build_request_failure_count}
     */
    @Nullable
    public final Long buildRequestFailureCount() {
        return this.buildRequestFailureCount;
    }

    /**
     * API name: {@code build_request_success_count}
     */
    @Nullable
    public final Long buildRequestSuccessCount() {
        return this.buildRequestSuccessCount;
    }

    /**
     * API name: {@code index_build_failure_count}
     */
    @Nullable
    public final Long indexBuildFailureCount() {
        return this.indexBuildFailureCount;
    }

    /**
     * API name: {@code index_build_success_count}
     */
    @Nullable
    public final Long indexBuildSuccessCount() {
        return this.indexBuildSuccessCount;
    }

    /**
     * API name: {@code status_request_failure_count}
     */
    @Nullable
    public final Long statusRequestFailureCount() {
        return this.statusRequestFailureCount;
    }

    /**
     * API name: {@code status_request_success_count}
     */
    @Nullable
    public final Long statusRequestSuccessCount() {
        return this.statusRequestSuccessCount;
    }

    /**
     * API name: {@code waiting_time_in_ms}
     */
    @Nullable
    public final Long waitingTimeInMs() {
        return this.waitingTimeInMs;
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
        if (this.buildRequestFailureCount != null) {
            generator.writeKey("build_request_failure_count");
            generator.write(this.buildRequestFailureCount);
        }

        if (this.buildRequestSuccessCount != null) {
            generator.writeKey("build_request_success_count");
            generator.write(this.buildRequestSuccessCount);
        }

        if (this.indexBuildFailureCount != null) {
            generator.writeKey("index_build_failure_count");
            generator.write(this.indexBuildFailureCount);
        }

        if (this.indexBuildSuccessCount != null) {
            generator.writeKey("index_build_success_count");
            generator.write(this.indexBuildSuccessCount);
        }

        if (this.statusRequestFailureCount != null) {
            generator.writeKey("status_request_failure_count");
            generator.write(this.statusRequestFailureCount);
        }

        if (this.statusRequestSuccessCount != null) {
            generator.writeKey("status_request_success_count");
            generator.write(this.statusRequestSuccessCount);
        }

        if (this.waitingTimeInMs != null) {
            generator.writeKey("waiting_time_in_ms");
            generator.write(this.waitingTimeInMs);
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
     * Builder for {@link RemoteVectorIndexClientStats}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, RemoteVectorIndexClientStats> {
        @Nullable
        private Long buildRequestFailureCount;
        @Nullable
        private Long buildRequestSuccessCount;
        @Nullable
        private Long indexBuildFailureCount;
        @Nullable
        private Long indexBuildSuccessCount;
        @Nullable
        private Long statusRequestFailureCount;
        @Nullable
        private Long statusRequestSuccessCount;
        @Nullable
        private Long waitingTimeInMs;

        public Builder() {}

        private Builder(RemoteVectorIndexClientStats o) {
            this.buildRequestFailureCount = o.buildRequestFailureCount;
            this.buildRequestSuccessCount = o.buildRequestSuccessCount;
            this.indexBuildFailureCount = o.indexBuildFailureCount;
            this.indexBuildSuccessCount = o.indexBuildSuccessCount;
            this.statusRequestFailureCount = o.statusRequestFailureCount;
            this.statusRequestSuccessCount = o.statusRequestSuccessCount;
            this.waitingTimeInMs = o.waitingTimeInMs;
        }

        private Builder(Builder o) {
            this.buildRequestFailureCount = o.buildRequestFailureCount;
            this.buildRequestSuccessCount = o.buildRequestSuccessCount;
            this.indexBuildFailureCount = o.indexBuildFailureCount;
            this.indexBuildSuccessCount = o.indexBuildSuccessCount;
            this.statusRequestFailureCount = o.statusRequestFailureCount;
            this.statusRequestSuccessCount = o.statusRequestSuccessCount;
            this.waitingTimeInMs = o.waitingTimeInMs;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code build_request_failure_count}
         */
        @Nonnull
        public final Builder buildRequestFailureCount(@Nullable Long value) {
            this.buildRequestFailureCount = value;
            return this;
        }

        /**
         * API name: {@code build_request_success_count}
         */
        @Nonnull
        public final Builder buildRequestSuccessCount(@Nullable Long value) {
            this.buildRequestSuccessCount = value;
            return this;
        }

        /**
         * API name: {@code index_build_failure_count}
         */
        @Nonnull
        public final Builder indexBuildFailureCount(@Nullable Long value) {
            this.indexBuildFailureCount = value;
            return this;
        }

        /**
         * API name: {@code index_build_success_count}
         */
        @Nonnull
        public final Builder indexBuildSuccessCount(@Nullable Long value) {
            this.indexBuildSuccessCount = value;
            return this;
        }

        /**
         * API name: {@code status_request_failure_count}
         */
        @Nonnull
        public final Builder statusRequestFailureCount(@Nullable Long value) {
            this.statusRequestFailureCount = value;
            return this;
        }

        /**
         * API name: {@code status_request_success_count}
         */
        @Nonnull
        public final Builder statusRequestSuccessCount(@Nullable Long value) {
            this.statusRequestSuccessCount = value;
            return this;
        }

        /**
         * API name: {@code waiting_time_in_ms}
         */
        @Nonnull
        public final Builder waitingTimeInMs(@Nullable Long value) {
            this.waitingTimeInMs = value;
            return this;
        }

        /**
         * Builds a {@link RemoteVectorIndexClientStats}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public RemoteVectorIndexClientStats build() {
            _checkSingleUse();

            return new RemoteVectorIndexClientStats(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link RemoteVectorIndexClientStats}
     */
    public static final JsonpDeserializer<RemoteVectorIndexClientStats> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        RemoteVectorIndexClientStats::setupRemoteVectorIndexClientStatsDeserializer
    );

    protected static void setupRemoteVectorIndexClientStatsDeserializer(ObjectDeserializer<RemoteVectorIndexClientStats.Builder> op) {
        op.add(Builder::buildRequestFailureCount, JsonpDeserializer.longDeserializer(), "build_request_failure_count");
        op.add(Builder::buildRequestSuccessCount, JsonpDeserializer.longDeserializer(), "build_request_success_count");
        op.add(Builder::indexBuildFailureCount, JsonpDeserializer.longDeserializer(), "index_build_failure_count");
        op.add(Builder::indexBuildSuccessCount, JsonpDeserializer.longDeserializer(), "index_build_success_count");
        op.add(Builder::statusRequestFailureCount, JsonpDeserializer.longDeserializer(), "status_request_failure_count");
        op.add(Builder::statusRequestSuccessCount, JsonpDeserializer.longDeserializer(), "status_request_success_count");
        op.add(Builder::waitingTimeInMs, JsonpDeserializer.longDeserializer(), "waiting_time_in_ms");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.buildRequestFailureCount);
        result = 31 * result + Objects.hashCode(this.buildRequestSuccessCount);
        result = 31 * result + Objects.hashCode(this.indexBuildFailureCount);
        result = 31 * result + Objects.hashCode(this.indexBuildSuccessCount);
        result = 31 * result + Objects.hashCode(this.statusRequestFailureCount);
        result = 31 * result + Objects.hashCode(this.statusRequestSuccessCount);
        result = 31 * result + Objects.hashCode(this.waitingTimeInMs);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        RemoteVectorIndexClientStats other = (RemoteVectorIndexClientStats) o;
        return Objects.equals(this.buildRequestFailureCount, other.buildRequestFailureCount)
            && Objects.equals(this.buildRequestSuccessCount, other.buildRequestSuccessCount)
            && Objects.equals(this.indexBuildFailureCount, other.indexBuildFailureCount)
            && Objects.equals(this.indexBuildSuccessCount, other.indexBuildSuccessCount)
            && Objects.equals(this.statusRequestFailureCount, other.statusRequestFailureCount)
            && Objects.equals(this.statusRequestSuccessCount, other.statusRequestSuccessCount)
            && Objects.equals(this.waitingTimeInMs, other.waitingTimeInMs);
    }
}
