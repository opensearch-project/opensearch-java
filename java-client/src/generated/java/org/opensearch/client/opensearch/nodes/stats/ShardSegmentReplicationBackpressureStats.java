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

// typedef: nodes.stats.ShardSegmentReplicationBackpressureStats

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class ShardSegmentReplicationBackpressureStats
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<ShardSegmentReplicationBackpressureStats.Builder, ShardSegmentReplicationBackpressureStats> {

    @Nullable
    private final Long totalRejectedRequests;

    // ---------------------------------------------------------------------------------------------

    private ShardSegmentReplicationBackpressureStats(Builder builder) {
        this.totalRejectedRequests = builder.totalRejectedRequests;
    }

    public static ShardSegmentReplicationBackpressureStats of(
        Function<ShardSegmentReplicationBackpressureStats.Builder, ObjectBuilder<ShardSegmentReplicationBackpressureStats>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code total_rejected_requests}
     */
    @Nullable
    public final Long totalRejectedRequests() {
        return this.totalRejectedRequests;
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
        if (this.totalRejectedRequests != null) {
            generator.writeKey("total_rejected_requests");
            generator.write(this.totalRejectedRequests);
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
     * Builder for {@link ShardSegmentReplicationBackpressureStats}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, ShardSegmentReplicationBackpressureStats> {
        @Nullable
        private Long totalRejectedRequests;

        public Builder() {}

        private Builder(ShardSegmentReplicationBackpressureStats o) {
            this.totalRejectedRequests = o.totalRejectedRequests;
        }

        private Builder(Builder o) {
            this.totalRejectedRequests = o.totalRejectedRequests;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code total_rejected_requests}
         */
        @Nonnull
        public final Builder totalRejectedRequests(@Nullable Long value) {
            this.totalRejectedRequests = value;
            return this;
        }

        /**
         * Builds a {@link ShardSegmentReplicationBackpressureStats}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ShardSegmentReplicationBackpressureStats build() {
            _checkSingleUse();

            return new ShardSegmentReplicationBackpressureStats(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ShardSegmentReplicationBackpressureStats}
     */
    public static final JsonpDeserializer<ShardSegmentReplicationBackpressureStats> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ShardSegmentReplicationBackpressureStats::setupShardSegmentReplicationBackpressureStatsDeserializer
    );

    protected static void setupShardSegmentReplicationBackpressureStatsDeserializer(
        ObjectDeserializer<ShardSegmentReplicationBackpressureStats.Builder> op
    ) {
        op.add(Builder::totalRejectedRequests, JsonpDeserializer.longDeserializer(), "total_rejected_requests");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.totalRejectedRequests);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ShardSegmentReplicationBackpressureStats other = (ShardSegmentReplicationBackpressureStats) o;
        return Objects.equals(this.totalRejectedRequests, other.totalRejectedRequests);
    }
}
