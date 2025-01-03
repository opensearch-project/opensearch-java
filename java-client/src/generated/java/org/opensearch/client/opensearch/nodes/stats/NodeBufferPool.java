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

// typedef: nodes.stats.NodeBufferPool

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class NodeBufferPool implements PlainJsonSerializable, ToCopyableBuilder<NodeBufferPool.Builder, NodeBufferPool> {

    @Nullable
    private final Long count;

    @Nullable
    private final String totalCapacity;

    @Nullable
    private final Long totalCapacityInBytes;

    @Nullable
    private final String used;

    @Nullable
    private final Long usedInBytes;

    // ---------------------------------------------------------------------------------------------

    private NodeBufferPool(Builder builder) {
        this.count = builder.count;
        this.totalCapacity = builder.totalCapacity;
        this.totalCapacityInBytes = builder.totalCapacityInBytes;
        this.used = builder.used;
        this.usedInBytes = builder.usedInBytes;
    }

    public static NodeBufferPool of(Function<NodeBufferPool.Builder, ObjectBuilder<NodeBufferPool>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Number of buffer pools.
     * <p>
     * API name: {@code count}
     * </p>
     */
    @Nullable
    public final Long count() {
        return this.count;
    }

    /**
     * Total capacity of buffer pools.
     * <p>
     * API name: {@code total_capacity}
     * </p>
     */
    @Nullable
    public final String totalCapacity() {
        return this.totalCapacity;
    }

    /**
     * Total capacity of buffer pools in bytes.
     * <p>
     * API name: {@code total_capacity_in_bytes}
     * </p>
     */
    @Nullable
    public final Long totalCapacityInBytes() {
        return this.totalCapacityInBytes;
    }

    /**
     * Size of buffer pools.
     * <p>
     * API name: {@code used}
     * </p>
     */
    @Nullable
    public final String used() {
        return this.used;
    }

    /**
     * Size of buffer pools in bytes.
     * <p>
     * API name: {@code used_in_bytes}
     * </p>
     */
    @Nullable
    public final Long usedInBytes() {
        return this.usedInBytes;
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
        if (this.count != null) {
            generator.writeKey("count");
            generator.write(this.count);
        }

        if (this.totalCapacity != null) {
            generator.writeKey("total_capacity");
            generator.write(this.totalCapacity);
        }

        if (this.totalCapacityInBytes != null) {
            generator.writeKey("total_capacity_in_bytes");
            generator.write(this.totalCapacityInBytes);
        }

        if (this.used != null) {
            generator.writeKey("used");
            generator.write(this.used);
        }

        if (this.usedInBytes != null) {
            generator.writeKey("used_in_bytes");
            generator.write(this.usedInBytes);
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
     * Builder for {@link NodeBufferPool}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, NodeBufferPool> {
        @Nullable
        private Long count;
        @Nullable
        private String totalCapacity;
        @Nullable
        private Long totalCapacityInBytes;
        @Nullable
        private String used;
        @Nullable
        private Long usedInBytes;

        public Builder() {}

        private Builder(NodeBufferPool o) {
            this.count = o.count;
            this.totalCapacity = o.totalCapacity;
            this.totalCapacityInBytes = o.totalCapacityInBytes;
            this.used = o.used;
            this.usedInBytes = o.usedInBytes;
        }

        private Builder(Builder o) {
            this.count = o.count;
            this.totalCapacity = o.totalCapacity;
            this.totalCapacityInBytes = o.totalCapacityInBytes;
            this.used = o.used;
            this.usedInBytes = o.usedInBytes;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Number of buffer pools.
         * <p>
         * API name: {@code count}
         * </p>
         */
        @Nonnull
        public final Builder count(@Nullable Long value) {
            this.count = value;
            return this;
        }

        /**
         * Total capacity of buffer pools.
         * <p>
         * API name: {@code total_capacity}
         * </p>
         */
        @Nonnull
        public final Builder totalCapacity(@Nullable String value) {
            this.totalCapacity = value;
            return this;
        }

        /**
         * Total capacity of buffer pools in bytes.
         * <p>
         * API name: {@code total_capacity_in_bytes}
         * </p>
         */
        @Nonnull
        public final Builder totalCapacityInBytes(@Nullable Long value) {
            this.totalCapacityInBytes = value;
            return this;
        }

        /**
         * Size of buffer pools.
         * <p>
         * API name: {@code used}
         * </p>
         */
        @Nonnull
        public final Builder used(@Nullable String value) {
            this.used = value;
            return this;
        }

        /**
         * Size of buffer pools in bytes.
         * <p>
         * API name: {@code used_in_bytes}
         * </p>
         */
        @Nonnull
        public final Builder usedInBytes(@Nullable Long value) {
            this.usedInBytes = value;
            return this;
        }

        /**
         * Builds a {@link NodeBufferPool}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public NodeBufferPool build() {
            _checkSingleUse();

            return new NodeBufferPool(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link NodeBufferPool}
     */
    public static final JsonpDeserializer<NodeBufferPool> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        NodeBufferPool::setupNodeBufferPoolDeserializer
    );

    protected static void setupNodeBufferPoolDeserializer(ObjectDeserializer<NodeBufferPool.Builder> op) {
        op.add(Builder::count, JsonpDeserializer.longDeserializer(), "count");
        op.add(Builder::totalCapacity, JsonpDeserializer.stringDeserializer(), "total_capacity");
        op.add(Builder::totalCapacityInBytes, JsonpDeserializer.longDeserializer(), "total_capacity_in_bytes");
        op.add(Builder::used, JsonpDeserializer.stringDeserializer(), "used");
        op.add(Builder::usedInBytes, JsonpDeserializer.longDeserializer(), "used_in_bytes");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.count);
        result = 31 * result + Objects.hashCode(this.totalCapacity);
        result = 31 * result + Objects.hashCode(this.totalCapacityInBytes);
        result = 31 * result + Objects.hashCode(this.used);
        result = 31 * result + Objects.hashCode(this.usedInBytes);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        NodeBufferPool other = (NodeBufferPool) o;
        return Objects.equals(this.count, other.count)
            && Objects.equals(this.totalCapacity, other.totalCapacity)
            && Objects.equals(this.totalCapacityInBytes, other.totalCapacityInBytes)
            && Objects.equals(this.used, other.used)
            && Objects.equals(this.usedInBytes, other.usedInBytes);
    }
}
