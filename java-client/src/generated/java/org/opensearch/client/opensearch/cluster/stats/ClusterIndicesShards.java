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

// typedef: cluster.stats.ClusterIndicesShards

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class ClusterIndicesShards implements PlainJsonSerializable, ToCopyableBuilder<ClusterIndicesShards.Builder, ClusterIndicesShards> {

    @Nullable
    private final ClusterIndicesShardsIndex index;

    @Nullable
    private final Integer primaries;

    @Nullable
    private final Integer replication;

    @Nullable
    private final Integer total;

    // ---------------------------------------------------------------------------------------------

    private ClusterIndicesShards(Builder builder) {
        this.index = builder.index;
        this.primaries = builder.primaries;
        this.replication = builder.replication;
        this.total = builder.total;
    }

    public static ClusterIndicesShards of(Function<ClusterIndicesShards.Builder, ObjectBuilder<ClusterIndicesShards>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code index}
     */
    @Nullable
    public final ClusterIndicesShardsIndex index() {
        return this.index;
    }

    /**
     * Number of primary shards assigned to selected nodes.
     * <p>
     * API name: {@code primaries}
     * </p>
     */
    @Nullable
    public final Integer primaries() {
        return this.primaries;
    }

    /**
     * Ratio of replica shards to primary shards across all selected nodes.
     * <p>
     * API name: {@code replication}
     * </p>
     */
    @Nullable
    public final Integer replication() {
        return this.replication;
    }

    /**
     * Total number of shards assigned to selected nodes.
     * <p>
     * API name: {@code total}
     * </p>
     */
    @Nullable
    public final Integer total() {
        return this.total;
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
        if (this.index != null) {
            generator.writeKey("index");
            this.index.serialize(generator, mapper);
        }

        if (this.primaries != null) {
            generator.writeKey("primaries");
            generator.write(this.primaries);
        }

        if (this.replication != null) {
            generator.writeKey("replication");
            generator.write(this.replication);
        }

        if (this.total != null) {
            generator.writeKey("total");
            generator.write(this.total);
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
     * Builder for {@link ClusterIndicesShards}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, ClusterIndicesShards> {
        @Nullable
        private ClusterIndicesShardsIndex index;
        @Nullable
        private Integer primaries;
        @Nullable
        private Integer replication;
        @Nullable
        private Integer total;

        public Builder() {}

        private Builder(ClusterIndicesShards o) {
            this.index = o.index;
            this.primaries = o.primaries;
            this.replication = o.replication;
            this.total = o.total;
        }

        private Builder(Builder o) {
            this.index = o.index;
            this.primaries = o.primaries;
            this.replication = o.replication;
            this.total = o.total;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code index}
         */
        @Nonnull
        public final Builder index(@Nullable ClusterIndicesShardsIndex value) {
            this.index = value;
            return this;
        }

        /**
         * API name: {@code index}
         */
        @Nonnull
        public final Builder index(Function<ClusterIndicesShardsIndex.Builder, ObjectBuilder<ClusterIndicesShardsIndex>> fn) {
            return index(fn.apply(new ClusterIndicesShardsIndex.Builder()).build());
        }

        /**
         * Number of primary shards assigned to selected nodes.
         * <p>
         * API name: {@code primaries}
         * </p>
         */
        @Nonnull
        public final Builder primaries(@Nullable Integer value) {
            this.primaries = value;
            return this;
        }

        /**
         * Ratio of replica shards to primary shards across all selected nodes.
         * <p>
         * API name: {@code replication}
         * </p>
         */
        @Nonnull
        public final Builder replication(@Nullable Integer value) {
            this.replication = value;
            return this;
        }

        /**
         * Total number of shards assigned to selected nodes.
         * <p>
         * API name: {@code total}
         * </p>
         */
        @Nonnull
        public final Builder total(@Nullable Integer value) {
            this.total = value;
            return this;
        }

        /**
         * Builds a {@link ClusterIndicesShards}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ClusterIndicesShards build() {
            _checkSingleUse();

            return new ClusterIndicesShards(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ClusterIndicesShards}
     */
    public static final JsonpDeserializer<ClusterIndicesShards> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ClusterIndicesShards::setupClusterIndicesShardsDeserializer
    );

    protected static void setupClusterIndicesShardsDeserializer(ObjectDeserializer<ClusterIndicesShards.Builder> op) {
        op.add(Builder::index, ClusterIndicesShardsIndex._DESERIALIZER, "index");
        op.add(Builder::primaries, JsonpDeserializer.integerDeserializer(), "primaries");
        op.add(Builder::replication, JsonpDeserializer.integerDeserializer(), "replication");
        op.add(Builder::total, JsonpDeserializer.integerDeserializer(), "total");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.index);
        result = 31 * result + Objects.hashCode(this.primaries);
        result = 31 * result + Objects.hashCode(this.replication);
        result = 31 * result + Objects.hashCode(this.total);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ClusterIndicesShards other = (ClusterIndicesShards) o;
        return Objects.equals(this.index, other.index)
            && Objects.equals(this.primaries, other.primaries)
            && Objects.equals(this.replication, other.replication)
            && Objects.equals(this.total, other.total);
    }
}
