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

// typedef: nodes.stats.ClusterStateQueue

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class ClusterStateQueue implements PlainJsonSerializable, ToCopyableBuilder<ClusterStateQueue.Builder, ClusterStateQueue> {

    @Nullable
    private final Integer committed;

    @Nullable
    private final Integer pending;

    @Nullable
    private final Integer total;

    // ---------------------------------------------------------------------------------------------

    private ClusterStateQueue(Builder builder) {
        this.committed = builder.committed;
        this.pending = builder.pending;
        this.total = builder.total;
    }

    public static ClusterStateQueue of(Function<ClusterStateQueue.Builder, ObjectBuilder<ClusterStateQueue>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Number of committed cluster states in queue.
     * <p>
     * API name: {@code committed}
     * </p>
     */
    @Nullable
    public final Integer committed() {
        return this.committed;
    }

    /**
     * Number of pending cluster states in queue.
     * <p>
     * API name: {@code pending}
     * </p>
     */
    @Nullable
    public final Integer pending() {
        return this.pending;
    }

    /**
     * Total number of cluster states in queue.
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
        if (this.committed != null) {
            generator.writeKey("committed");
            generator.write(this.committed);
        }

        if (this.pending != null) {
            generator.writeKey("pending");
            generator.write(this.pending);
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
     * Builder for {@link ClusterStateQueue}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, ClusterStateQueue> {
        @Nullable
        private Integer committed;
        @Nullable
        private Integer pending;
        @Nullable
        private Integer total;

        public Builder() {}

        private Builder(ClusterStateQueue o) {
            this.committed = o.committed;
            this.pending = o.pending;
            this.total = o.total;
        }

        private Builder(Builder o) {
            this.committed = o.committed;
            this.pending = o.pending;
            this.total = o.total;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Number of committed cluster states in queue.
         * <p>
         * API name: {@code committed}
         * </p>
         */
        @Nonnull
        public final Builder committed(@Nullable Integer value) {
            this.committed = value;
            return this;
        }

        /**
         * Number of pending cluster states in queue.
         * <p>
         * API name: {@code pending}
         * </p>
         */
        @Nonnull
        public final Builder pending(@Nullable Integer value) {
            this.pending = value;
            return this;
        }

        /**
         * Total number of cluster states in queue.
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
         * Builds a {@link ClusterStateQueue}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ClusterStateQueue build() {
            _checkSingleUse();

            return new ClusterStateQueue(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ClusterStateQueue}
     */
    public static final JsonpDeserializer<ClusterStateQueue> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ClusterStateQueue::setupClusterStateQueueDeserializer
    );

    protected static void setupClusterStateQueueDeserializer(ObjectDeserializer<ClusterStateQueue.Builder> op) {
        op.add(Builder::committed, JsonpDeserializer.integerDeserializer(), "committed");
        op.add(Builder::pending, JsonpDeserializer.integerDeserializer(), "pending");
        op.add(Builder::total, JsonpDeserializer.integerDeserializer(), "total");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.committed);
        result = 31 * result + Objects.hashCode(this.pending);
        result = 31 * result + Objects.hashCode(this.total);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ClusterStateQueue other = (ClusterStateQueue) o;
        return Objects.equals(this.committed, other.committed)
            && Objects.equals(this.pending, other.pending)
            && Objects.equals(this.total, other.total);
    }
}
