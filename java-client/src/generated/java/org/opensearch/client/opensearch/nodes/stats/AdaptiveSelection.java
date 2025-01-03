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
import org.opensearch.client.opensearch._types.Time;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: nodes.stats.AdaptiveSelection

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class AdaptiveSelection implements PlainJsonSerializable, ToCopyableBuilder<AdaptiveSelection.Builder, AdaptiveSelection> {

    @Nullable
    private final Long avgQueueSize;

    @Nullable
    private final Time avgResponseTime;

    @Nullable
    private final Long avgResponseTimeNs;

    @Nullable
    private final Time avgServiceTime;

    @Nullable
    private final Long avgServiceTimeNs;

    @Nullable
    private final Long outgoingSearches;

    @Nullable
    private final String rank;

    // ---------------------------------------------------------------------------------------------

    private AdaptiveSelection(Builder builder) {
        this.avgQueueSize = builder.avgQueueSize;
        this.avgResponseTime = builder.avgResponseTime;
        this.avgResponseTimeNs = builder.avgResponseTimeNs;
        this.avgServiceTime = builder.avgServiceTime;
        this.avgServiceTimeNs = builder.avgServiceTimeNs;
        this.outgoingSearches = builder.outgoingSearches;
        this.rank = builder.rank;
    }

    public static AdaptiveSelection of(Function<AdaptiveSelection.Builder, ObjectBuilder<AdaptiveSelection>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * The exponentially weighted moving average queue size of search requests on the keyed node.
     * <p>
     * API name: {@code avg_queue_size}
     * </p>
     */
    @Nullable
    public final Long avgQueueSize() {
        return this.avgQueueSize;
    }

    /**
     * API name: {@code avg_response_time}
     */
    @Nullable
    public final Time avgResponseTime() {
        return this.avgResponseTime;
    }

    /**
     * The exponentially weighted moving average response time, in nanoseconds, of search requests on the keyed node.
     * <p>
     * API name: {@code avg_response_time_ns}
     * </p>
     */
    @Nullable
    public final Long avgResponseTimeNs() {
        return this.avgResponseTimeNs;
    }

    /**
     * API name: {@code avg_service_time}
     */
    @Nullable
    public final Time avgServiceTime() {
        return this.avgServiceTime;
    }

    /**
     * The exponentially weighted moving average service time, in nanoseconds, of search requests on the keyed node.
     * <p>
     * API name: {@code avg_service_time_ns}
     * </p>
     */
    @Nullable
    public final Long avgServiceTimeNs() {
        return this.avgServiceTimeNs;
    }

    /**
     * The number of outstanding search requests to the keyed node from the node these stats are for.
     * <p>
     * API name: {@code outgoing_searches}
     * </p>
     */
    @Nullable
    public final Long outgoingSearches() {
        return this.outgoingSearches;
    }

    /**
     * The rank of this node; used for shard selection when routing search requests.
     * <p>
     * API name: {@code rank}
     * </p>
     */
    @Nullable
    public final String rank() {
        return this.rank;
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
        if (this.avgQueueSize != null) {
            generator.writeKey("avg_queue_size");
            generator.write(this.avgQueueSize);
        }

        if (this.avgResponseTime != null) {
            generator.writeKey("avg_response_time");
            this.avgResponseTime.serialize(generator, mapper);
        }

        if (this.avgResponseTimeNs != null) {
            generator.writeKey("avg_response_time_ns");
            generator.write(this.avgResponseTimeNs);
        }

        if (this.avgServiceTime != null) {
            generator.writeKey("avg_service_time");
            this.avgServiceTime.serialize(generator, mapper);
        }

        if (this.avgServiceTimeNs != null) {
            generator.writeKey("avg_service_time_ns");
            generator.write(this.avgServiceTimeNs);
        }

        if (this.outgoingSearches != null) {
            generator.writeKey("outgoing_searches");
            generator.write(this.outgoingSearches);
        }

        if (this.rank != null) {
            generator.writeKey("rank");
            generator.write(this.rank);
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
     * Builder for {@link AdaptiveSelection}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, AdaptiveSelection> {
        @Nullable
        private Long avgQueueSize;
        @Nullable
        private Time avgResponseTime;
        @Nullable
        private Long avgResponseTimeNs;
        @Nullable
        private Time avgServiceTime;
        @Nullable
        private Long avgServiceTimeNs;
        @Nullable
        private Long outgoingSearches;
        @Nullable
        private String rank;

        public Builder() {}

        private Builder(AdaptiveSelection o) {
            this.avgQueueSize = o.avgQueueSize;
            this.avgResponseTime = o.avgResponseTime;
            this.avgResponseTimeNs = o.avgResponseTimeNs;
            this.avgServiceTime = o.avgServiceTime;
            this.avgServiceTimeNs = o.avgServiceTimeNs;
            this.outgoingSearches = o.outgoingSearches;
            this.rank = o.rank;
        }

        private Builder(Builder o) {
            this.avgQueueSize = o.avgQueueSize;
            this.avgResponseTime = o.avgResponseTime;
            this.avgResponseTimeNs = o.avgResponseTimeNs;
            this.avgServiceTime = o.avgServiceTime;
            this.avgServiceTimeNs = o.avgServiceTimeNs;
            this.outgoingSearches = o.outgoingSearches;
            this.rank = o.rank;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * The exponentially weighted moving average queue size of search requests on the keyed node.
         * <p>
         * API name: {@code avg_queue_size}
         * </p>
         */
        @Nonnull
        public final Builder avgQueueSize(@Nullable Long value) {
            this.avgQueueSize = value;
            return this;
        }

        /**
         * API name: {@code avg_response_time}
         */
        @Nonnull
        public final Builder avgResponseTime(@Nullable Time value) {
            this.avgResponseTime = value;
            return this;
        }

        /**
         * API name: {@code avg_response_time}
         */
        @Nonnull
        public final Builder avgResponseTime(Function<Time.Builder, ObjectBuilder<Time>> fn) {
            return avgResponseTime(fn.apply(new Time.Builder()).build());
        }

        /**
         * The exponentially weighted moving average response time, in nanoseconds, of search requests on the keyed node.
         * <p>
         * API name: {@code avg_response_time_ns}
         * </p>
         */
        @Nonnull
        public final Builder avgResponseTimeNs(@Nullable Long value) {
            this.avgResponseTimeNs = value;
            return this;
        }

        /**
         * API name: {@code avg_service_time}
         */
        @Nonnull
        public final Builder avgServiceTime(@Nullable Time value) {
            this.avgServiceTime = value;
            return this;
        }

        /**
         * API name: {@code avg_service_time}
         */
        @Nonnull
        public final Builder avgServiceTime(Function<Time.Builder, ObjectBuilder<Time>> fn) {
            return avgServiceTime(fn.apply(new Time.Builder()).build());
        }

        /**
         * The exponentially weighted moving average service time, in nanoseconds, of search requests on the keyed node.
         * <p>
         * API name: {@code avg_service_time_ns}
         * </p>
         */
        @Nonnull
        public final Builder avgServiceTimeNs(@Nullable Long value) {
            this.avgServiceTimeNs = value;
            return this;
        }

        /**
         * The number of outstanding search requests to the keyed node from the node these stats are for.
         * <p>
         * API name: {@code outgoing_searches}
         * </p>
         */
        @Nonnull
        public final Builder outgoingSearches(@Nullable Long value) {
            this.outgoingSearches = value;
            return this;
        }

        /**
         * The rank of this node; used for shard selection when routing search requests.
         * <p>
         * API name: {@code rank}
         * </p>
         */
        @Nonnull
        public final Builder rank(@Nullable String value) {
            this.rank = value;
            return this;
        }

        /**
         * Builds a {@link AdaptiveSelection}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public AdaptiveSelection build() {
            _checkSingleUse();

            return new AdaptiveSelection(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link AdaptiveSelection}
     */
    public static final JsonpDeserializer<AdaptiveSelection> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        AdaptiveSelection::setupAdaptiveSelectionDeserializer
    );

    protected static void setupAdaptiveSelectionDeserializer(ObjectDeserializer<AdaptiveSelection.Builder> op) {
        op.add(Builder::avgQueueSize, JsonpDeserializer.longDeserializer(), "avg_queue_size");
        op.add(Builder::avgResponseTime, Time._DESERIALIZER, "avg_response_time");
        op.add(Builder::avgResponseTimeNs, JsonpDeserializer.longDeserializer(), "avg_response_time_ns");
        op.add(Builder::avgServiceTime, Time._DESERIALIZER, "avg_service_time");
        op.add(Builder::avgServiceTimeNs, JsonpDeserializer.longDeserializer(), "avg_service_time_ns");
        op.add(Builder::outgoingSearches, JsonpDeserializer.longDeserializer(), "outgoing_searches");
        op.add(Builder::rank, JsonpDeserializer.stringDeserializer(), "rank");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.avgQueueSize);
        result = 31 * result + Objects.hashCode(this.avgResponseTime);
        result = 31 * result + Objects.hashCode(this.avgResponseTimeNs);
        result = 31 * result + Objects.hashCode(this.avgServiceTime);
        result = 31 * result + Objects.hashCode(this.avgServiceTimeNs);
        result = 31 * result + Objects.hashCode(this.outgoingSearches);
        result = 31 * result + Objects.hashCode(this.rank);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        AdaptiveSelection other = (AdaptiveSelection) o;
        return Objects.equals(this.avgQueueSize, other.avgQueueSize)
            && Objects.equals(this.avgResponseTime, other.avgResponseTime)
            && Objects.equals(this.avgResponseTimeNs, other.avgResponseTimeNs)
            && Objects.equals(this.avgServiceTime, other.avgServiceTime)
            && Objects.equals(this.avgServiceTimeNs, other.avgServiceTimeNs)
            && Objects.equals(this.outgoingSearches, other.outgoingSearches)
            && Objects.equals(this.rank, other.rank);
    }
}
