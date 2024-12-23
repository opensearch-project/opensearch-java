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
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: cluster.stats.ClusterJvmMemory

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class ClusterJvmMemory implements PlainJsonSerializable, ToCopyableBuilder<ClusterJvmMemory.Builder, ClusterJvmMemory> {

    @Nullable
    private final String heapMax;

    private final long heapMaxInBytes;

    @Nullable
    private final String heapUsed;

    private final long heapUsedInBytes;

    // ---------------------------------------------------------------------------------------------

    private ClusterJvmMemory(Builder builder) {
        this.heapMax = builder.heapMax;
        this.heapMaxInBytes = ApiTypeHelper.requireNonNull(builder.heapMaxInBytes, this, "heapMaxInBytes");
        this.heapUsed = builder.heapUsed;
        this.heapUsedInBytes = ApiTypeHelper.requireNonNull(builder.heapUsedInBytes, this, "heapUsedInBytes");
    }

    public static ClusterJvmMemory of(Function<ClusterJvmMemory.Builder, ObjectBuilder<ClusterJvmMemory>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Maximum amount of memory available for use by the heap across all selected nodes.
     * <p>
     * API name: {@code heap_max}
     * </p>
     */
    @Nullable
    public final String heapMax() {
        return this.heapMax;
    }

    /**
     * Required - Maximum amount of memory, in bytes, available for use by the heap across all selected nodes.
     * <p>
     * API name: {@code heap_max_in_bytes}
     * </p>
     */
    public final long heapMaxInBytes() {
        return this.heapMaxInBytes;
    }

    /**
     * Memory currently in use by the heap across all selected nodes.
     * <p>
     * API name: {@code heap_used}
     * </p>
     */
    @Nullable
    public final String heapUsed() {
        return this.heapUsed;
    }

    /**
     * Required - Memory, in bytes, currently in use by the heap across all selected nodes.
     * <p>
     * API name: {@code heap_used_in_bytes}
     * </p>
     */
    public final long heapUsedInBytes() {
        return this.heapUsedInBytes;
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
        if (this.heapMax != null) {
            generator.writeKey("heap_max");
            generator.write(this.heapMax);
        }

        generator.writeKey("heap_max_in_bytes");
        generator.write(this.heapMaxInBytes);

        if (this.heapUsed != null) {
            generator.writeKey("heap_used");
            generator.write(this.heapUsed);
        }

        generator.writeKey("heap_used_in_bytes");
        generator.write(this.heapUsedInBytes);
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
     * Builder for {@link ClusterJvmMemory}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, ClusterJvmMemory> {
        @Nullable
        private String heapMax;
        private Long heapMaxInBytes;
        @Nullable
        private String heapUsed;
        private Long heapUsedInBytes;

        public Builder() {}

        private Builder(ClusterJvmMemory o) {
            this.heapMax = o.heapMax;
            this.heapMaxInBytes = o.heapMaxInBytes;
            this.heapUsed = o.heapUsed;
            this.heapUsedInBytes = o.heapUsedInBytes;
        }

        private Builder(Builder o) {
            this.heapMax = o.heapMax;
            this.heapMaxInBytes = o.heapMaxInBytes;
            this.heapUsed = o.heapUsed;
            this.heapUsedInBytes = o.heapUsedInBytes;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Maximum amount of memory available for use by the heap across all selected nodes.
         * <p>
         * API name: {@code heap_max}
         * </p>
         */
        @Nonnull
        public final Builder heapMax(@Nullable String value) {
            this.heapMax = value;
            return this;
        }

        /**
         * Required - Maximum amount of memory, in bytes, available for use by the heap across all selected nodes.
         * <p>
         * API name: {@code heap_max_in_bytes}
         * </p>
         */
        @Nonnull
        public final Builder heapMaxInBytes(long value) {
            this.heapMaxInBytes = value;
            return this;
        }

        /**
         * Memory currently in use by the heap across all selected nodes.
         * <p>
         * API name: {@code heap_used}
         * </p>
         */
        @Nonnull
        public final Builder heapUsed(@Nullable String value) {
            this.heapUsed = value;
            return this;
        }

        /**
         * Required - Memory, in bytes, currently in use by the heap across all selected nodes.
         * <p>
         * API name: {@code heap_used_in_bytes}
         * </p>
         */
        @Nonnull
        public final Builder heapUsedInBytes(long value) {
            this.heapUsedInBytes = value;
            return this;
        }

        /**
         * Builds a {@link ClusterJvmMemory}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ClusterJvmMemory build() {
            _checkSingleUse();

            return new ClusterJvmMemory(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ClusterJvmMemory}
     */
    public static final JsonpDeserializer<ClusterJvmMemory> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ClusterJvmMemory::setupClusterJvmMemoryDeserializer
    );

    protected static void setupClusterJvmMemoryDeserializer(ObjectDeserializer<ClusterJvmMemory.Builder> op) {
        op.add(Builder::heapMax, JsonpDeserializer.stringDeserializer(), "heap_max");
        op.add(Builder::heapMaxInBytes, JsonpDeserializer.longDeserializer(), "heap_max_in_bytes");
        op.add(Builder::heapUsed, JsonpDeserializer.stringDeserializer(), "heap_used");
        op.add(Builder::heapUsedInBytes, JsonpDeserializer.longDeserializer(), "heap_used_in_bytes");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.heapMax);
        result = 31 * result + Long.hashCode(this.heapMaxInBytes);
        result = 31 * result + Objects.hashCode(this.heapUsed);
        result = 31 * result + Long.hashCode(this.heapUsedInBytes);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ClusterJvmMemory other = (ClusterJvmMemory) o;
        return Objects.equals(this.heapMax, other.heapMax)
            && this.heapMaxInBytes == other.heapMaxInBytes
            && Objects.equals(this.heapUsed, other.heapUsed)
            && this.heapUsedInBytes == other.heapUsedInBytes;
    }
}
