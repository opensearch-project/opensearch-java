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

package org.opensearch.client.opensearch.cluster.stats;

import jakarta.json.stream.JsonGenerator;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
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

// typedef: cluster.stats.ClusterShardMetrics

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class ClusterShardMetrics implements PlainJsonSerializable, ToCopyableBuilder<ClusterShardMetrics.Builder, ClusterShardMetrics> {

    private final double avg;

    private final double max;

    private final double min;

    // ---------------------------------------------------------------------------------------------

    private ClusterShardMetrics(Builder builder) {
        this.avg = ApiTypeHelper.requireNonNull(builder.avg, this, "avg");
        this.max = ApiTypeHelper.requireNonNull(builder.max, this, "max");
        this.min = ApiTypeHelper.requireNonNull(builder.min, this, "min");
    }

    public static ClusterShardMetrics of(Function<ClusterShardMetrics.Builder, ObjectBuilder<ClusterShardMetrics>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - Mean number of shards in an index, counting only shards assigned to selected nodes.
     * <p>
     * API name: {@code avg}
     * </p>
     */
    public final double avg() {
        return this.avg;
    }

    /**
     * Required - Maximum number of shards in an index, counting only shards assigned to selected nodes.
     * <p>
     * API name: {@code max}
     * </p>
     */
    public final double max() {
        return this.max;
    }

    /**
     * Required - Minimum number of shards in an index, counting only shards assigned to selected nodes.
     * <p>
     * API name: {@code min}
     * </p>
     */
    public final double min() {
        return this.min;
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
        generator.writeKey("avg");
        generator.write(this.avg);

        generator.writeKey("max");
        generator.write(this.max);

        generator.writeKey("min");
        generator.write(this.min);
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
     * Builder for {@link ClusterShardMetrics}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, ClusterShardMetrics> {
        private Double avg;
        private Double max;
        private Double min;

        public Builder() {}

        private Builder(ClusterShardMetrics o) {
            this.avg = o.avg;
            this.max = o.max;
            this.min = o.min;
        }

        private Builder(Builder o) {
            this.avg = o.avg;
            this.max = o.max;
            this.min = o.min;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - Mean number of shards in an index, counting only shards assigned to selected nodes.
         * <p>
         * API name: {@code avg}
         * </p>
         */
        @Nonnull
        public final Builder avg(double value) {
            this.avg = value;
            return this;
        }

        /**
         * Required - Maximum number of shards in an index, counting only shards assigned to selected nodes.
         * <p>
         * API name: {@code max}
         * </p>
         */
        @Nonnull
        public final Builder max(double value) {
            this.max = value;
            return this;
        }

        /**
         * Required - Minimum number of shards in an index, counting only shards assigned to selected nodes.
         * <p>
         * API name: {@code min}
         * </p>
         */
        @Nonnull
        public final Builder min(double value) {
            this.min = value;
            return this;
        }

        /**
         * Builds a {@link ClusterShardMetrics}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ClusterShardMetrics build() {
            _checkSingleUse();

            return new ClusterShardMetrics(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ClusterShardMetrics}
     */
    public static final JsonpDeserializer<ClusterShardMetrics> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ClusterShardMetrics::setupClusterShardMetricsDeserializer
    );

    protected static void setupClusterShardMetricsDeserializer(ObjectDeserializer<ClusterShardMetrics.Builder> op) {
        op.add(Builder::avg, JsonpDeserializer.doubleDeserializer(), "avg");
        op.add(Builder::max, JsonpDeserializer.doubleDeserializer(), "max");
        op.add(Builder::min, JsonpDeserializer.doubleDeserializer(), "min");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Double.hashCode(this.avg);
        result = 31 * result + Double.hashCode(this.max);
        result = 31 * result + Double.hashCode(this.min);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ClusterShardMetrics other = (ClusterShardMetrics) o;
        return this.avg == other.avg && this.max == other.max && this.min == other.min;
    }
}
