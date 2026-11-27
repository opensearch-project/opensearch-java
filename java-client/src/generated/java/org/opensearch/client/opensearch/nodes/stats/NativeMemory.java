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

// typedef: nodes.stats.NativeMemory

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class NativeMemory implements PlainJsonSerializable, ToCopyableBuilder<NativeMemory.Builder, NativeMemory> {

    @Nullable
    private final NativeMemoryAnalyticsBackend analyticsBackend;

    @Nullable
    private final NativeMemoryAllocator nativeAllocator;

    @Nullable
    private final Long totalEstimatedBytes;

    // ---------------------------------------------------------------------------------------------

    private NativeMemory(Builder builder) {
        this.analyticsBackend = builder.analyticsBackend;
        this.nativeAllocator = builder.nativeAllocator;
        this.totalEstimatedBytes = builder.totalEstimatedBytes;
    }

    public static NativeMemory of(Function<NativeMemory.Builder, ObjectBuilder<NativeMemory>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Native memory tracked by the <code>jemalloc</code> allocator of the analytics backend. Present only when the
     * <code>native_memory</code> metric is requested and an analytics backend plugin reports it.
     * <p>
     * API name: {@code analytics_backend}
     * </p>
     */
    @Nullable
    public final NativeMemoryAnalyticsBackend analyticsBackend() {
        return this.analyticsBackend;
    }

    /**
     * Native allocator pool statistics. Present only when the <code>native_allocator</code> metric is requested and a plugin that owns a
     * native allocator reports them.
     * <p>
     * API name: {@code native_allocator}
     * </p>
     */
    @Nullable
    public final NativeMemoryAllocator nativeAllocator() {
        return this.nativeAllocator;
    }

    /**
     * Estimated process native memory, calculated as anonymous resident memory minus committed JVM heap and non-heap memory, floored at
     * <code>0</code>. <code>-1</code> if the estimate is unavailable.
     * <p>
     * API name: {@code total_estimated_bytes}
     * </p>
     */
    @Nullable
    public final Long totalEstimatedBytes() {
        return this.totalEstimatedBytes;
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
        if (this.analyticsBackend != null) {
            generator.writeKey("analytics_backend");
            this.analyticsBackend.serialize(generator, mapper);
        }

        if (this.nativeAllocator != null) {
            generator.writeKey("native_allocator");
            this.nativeAllocator.serialize(generator, mapper);
        }

        if (this.totalEstimatedBytes != null) {
            generator.writeKey("total_estimated_bytes");
            generator.write(this.totalEstimatedBytes);
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
     * Builder for {@link NativeMemory}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, NativeMemory> {
        @Nullable
        private NativeMemoryAnalyticsBackend analyticsBackend;
        @Nullable
        private NativeMemoryAllocator nativeAllocator;
        @Nullable
        private Long totalEstimatedBytes;

        public Builder() {}

        private Builder(NativeMemory o) {
            this.analyticsBackend = o.analyticsBackend;
            this.nativeAllocator = o.nativeAllocator;
            this.totalEstimatedBytes = o.totalEstimatedBytes;
        }

        private Builder(Builder o) {
            this.analyticsBackend = o.analyticsBackend;
            this.nativeAllocator = o.nativeAllocator;
            this.totalEstimatedBytes = o.totalEstimatedBytes;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Native memory tracked by the <code>jemalloc</code> allocator of the analytics backend. Present only when the
         * <code>native_memory</code> metric is requested and an analytics backend plugin reports it.
         * <p>
         * API name: {@code analytics_backend}
         * </p>
         */
        @Nonnull
        public final Builder analyticsBackend(@Nullable NativeMemoryAnalyticsBackend value) {
            this.analyticsBackend = value;
            return this;
        }

        /**
         * Native memory tracked by the <code>jemalloc</code> allocator of the analytics backend. Present only when the
         * <code>native_memory</code> metric is requested and an analytics backend plugin reports it.
         * <p>
         * API name: {@code analytics_backend}
         * </p>
         */
        @Nonnull
        public final Builder analyticsBackend(
            Function<NativeMemoryAnalyticsBackend.Builder, ObjectBuilder<NativeMemoryAnalyticsBackend>> fn
        ) {
            return analyticsBackend(fn.apply(new NativeMemoryAnalyticsBackend.Builder()).build());
        }

        /**
         * Native allocator pool statistics. Present only when the <code>native_allocator</code> metric is requested and a plugin that owns
         * a native allocator reports them.
         * <p>
         * API name: {@code native_allocator}
         * </p>
         */
        @Nonnull
        public final Builder nativeAllocator(@Nullable NativeMemoryAllocator value) {
            this.nativeAllocator = value;
            return this;
        }

        /**
         * Native allocator pool statistics. Present only when the <code>native_allocator</code> metric is requested and a plugin that owns
         * a native allocator reports them.
         * <p>
         * API name: {@code native_allocator}
         * </p>
         */
        @Nonnull
        public final Builder nativeAllocator(Function<NativeMemoryAllocator.Builder, ObjectBuilder<NativeMemoryAllocator>> fn) {
            return nativeAllocator(fn.apply(new NativeMemoryAllocator.Builder()).build());
        }

        /**
         * Estimated process native memory, calculated as anonymous resident memory minus committed JVM heap and non-heap memory, floored at
         * <code>0</code>. <code>-1</code> if the estimate is unavailable.
         * <p>
         * API name: {@code total_estimated_bytes}
         * </p>
         */
        @Nonnull
        public final Builder totalEstimatedBytes(@Nullable Long value) {
            this.totalEstimatedBytes = value;
            return this;
        }

        /**
         * Builds a {@link NativeMemory}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public NativeMemory build() {
            _checkSingleUse();

            return new NativeMemory(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link NativeMemory}
     */
    public static final JsonpDeserializer<NativeMemory> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        NativeMemory::setupNativeMemoryDeserializer
    );

    protected static void setupNativeMemoryDeserializer(ObjectDeserializer<NativeMemory.Builder> op) {
        op.add(Builder::analyticsBackend, NativeMemoryAnalyticsBackend._DESERIALIZER, "analytics_backend");
        op.add(Builder::nativeAllocator, NativeMemoryAllocator._DESERIALIZER, "native_allocator");
        op.add(Builder::totalEstimatedBytes, JsonpDeserializer.longDeserializer(), "total_estimated_bytes");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.analyticsBackend);
        result = 31 * result + Objects.hashCode(this.nativeAllocator);
        result = 31 * result + Objects.hashCode(this.totalEstimatedBytes);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        NativeMemory other = (NativeMemory) o;
        return Objects.equals(this.analyticsBackend, other.analyticsBackend)
            && Objects.equals(this.nativeAllocator, other.nativeAllocator)
            && Objects.equals(this.totalEstimatedBytes, other.totalEstimatedBytes);
    }
}
