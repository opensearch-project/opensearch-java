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

package org.opensearch.client.opensearch.nodes.stats;

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

// typedef: nodes.stats.ClusterStateOverallStats

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class ClusterStateOverallStats
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<ClusterStateOverallStats.Builder, ClusterStateOverallStats> {

    @Nullable
    private final Long failedCount;

    @Nullable
    private final Long totalTimeInMillis;

    @Nullable
    private final Long updateCount;

    // ---------------------------------------------------------------------------------------------

    private ClusterStateOverallStats(Builder builder) {
        this.failedCount = builder.failedCount;
        this.totalTimeInMillis = builder.totalTimeInMillis;
        this.updateCount = builder.updateCount;
    }

    public static ClusterStateOverallStats of(Function<ClusterStateOverallStats.Builder, ObjectBuilder<ClusterStateOverallStats>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code failed_count}
     */
    @Nullable
    public final Long failedCount() {
        return this.failedCount;
    }

    /**
     * API name: {@code total_time_in_millis}
     */
    @Nullable
    public final Long totalTimeInMillis() {
        return this.totalTimeInMillis;
    }

    /**
     * API name: {@code update_count}
     */
    @Nullable
    public final Long updateCount() {
        return this.updateCount;
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
        if (this.failedCount != null) {
            generator.writeKey("failed_count");
            generator.write(this.failedCount);
        }

        if (this.totalTimeInMillis != null) {
            generator.writeKey("total_time_in_millis");
            generator.write(this.totalTimeInMillis);
        }

        if (this.updateCount != null) {
            generator.writeKey("update_count");
            generator.write(this.updateCount);
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
     * Builder for {@link ClusterStateOverallStats}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, ClusterStateOverallStats> {
        @Nullable
        private Long failedCount;
        @Nullable
        private Long totalTimeInMillis;
        @Nullable
        private Long updateCount;

        public Builder() {}

        private Builder(ClusterStateOverallStats o) {
            this.failedCount = o.failedCount;
            this.totalTimeInMillis = o.totalTimeInMillis;
            this.updateCount = o.updateCount;
        }

        private Builder(Builder o) {
            this.failedCount = o.failedCount;
            this.totalTimeInMillis = o.totalTimeInMillis;
            this.updateCount = o.updateCount;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code failed_count}
         */
        @Nonnull
        public final Builder failedCount(@Nullable Long value) {
            this.failedCount = value;
            return this;
        }

        /**
         * API name: {@code total_time_in_millis}
         */
        @Nonnull
        public final Builder totalTimeInMillis(@Nullable Long value) {
            this.totalTimeInMillis = value;
            return this;
        }

        /**
         * API name: {@code update_count}
         */
        @Nonnull
        public final Builder updateCount(@Nullable Long value) {
            this.updateCount = value;
            return this;
        }

        /**
         * Builds a {@link ClusterStateOverallStats}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ClusterStateOverallStats build() {
            _checkSingleUse();

            return new ClusterStateOverallStats(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ClusterStateOverallStats}
     */
    public static final JsonpDeserializer<ClusterStateOverallStats> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ClusterStateOverallStats::setupClusterStateOverallStatsDeserializer
    );

    protected static void setupClusterStateOverallStatsDeserializer(ObjectDeserializer<ClusterStateOverallStats.Builder> op) {
        op.add(Builder::failedCount, JsonpDeserializer.longDeserializer(), "failed_count");
        op.add(Builder::totalTimeInMillis, JsonpDeserializer.longDeserializer(), "total_time_in_millis");
        op.add(Builder::updateCount, JsonpDeserializer.longDeserializer(), "update_count");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.failedCount);
        result = 31 * result + Objects.hashCode(this.totalTimeInMillis);
        result = 31 * result + Objects.hashCode(this.updateCount);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ClusterStateOverallStats other = (ClusterStateOverallStats) o;
        return Objects.equals(this.failedCount, other.failedCount)
            && Objects.equals(this.totalTimeInMillis, other.totalTimeInMillis)
            && Objects.equals(this.updateCount, other.updateCount);
    }
}
