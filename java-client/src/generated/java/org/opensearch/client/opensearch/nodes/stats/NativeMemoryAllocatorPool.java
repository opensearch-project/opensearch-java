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

// typedef: nodes.stats.NativeMemoryAllocatorPool

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class NativeMemoryAllocatorPool
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<NativeMemoryAllocatorPool.Builder, NativeMemoryAllocatorPool> {

    @Nullable
    private final Long allocatedBytes;

    @Nullable
    private final Long limitBytes;

    @Nullable
    private final Long peakBytes;

    // ---------------------------------------------------------------------------------------------

    private NativeMemoryAllocatorPool(Builder builder) {
        this.allocatedBytes = builder.allocatedBytes;
        this.limitBytes = builder.limitBytes;
        this.peakBytes = builder.peakBytes;
    }

    public static NativeMemoryAllocatorPool of(Function<NativeMemoryAllocatorPool.Builder, ObjectBuilder<NativeMemoryAllocatorPool>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code allocated_bytes}
     */
    @Nullable
    public final Long allocatedBytes() {
        return this.allocatedBytes;
    }

    /**
     * API name: {@code limit_bytes}
     */
    @Nullable
    public final Long limitBytes() {
        return this.limitBytes;
    }

    /**
     * API name: {@code peak_bytes}
     */
    @Nullable
    public final Long peakBytes() {
        return this.peakBytes;
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
        if (this.allocatedBytes != null) {
            generator.writeKey("allocated_bytes");
            generator.write(this.allocatedBytes);
        }

        if (this.limitBytes != null) {
            generator.writeKey("limit_bytes");
            generator.write(this.limitBytes);
        }

        if (this.peakBytes != null) {
            generator.writeKey("peak_bytes");
            generator.write(this.peakBytes);
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
     * Builder for {@link NativeMemoryAllocatorPool}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, NativeMemoryAllocatorPool> {
        @Nullable
        private Long allocatedBytes;
        @Nullable
        private Long limitBytes;
        @Nullable
        private Long peakBytes;

        public Builder() {}

        private Builder(NativeMemoryAllocatorPool o) {
            this.allocatedBytes = o.allocatedBytes;
            this.limitBytes = o.limitBytes;
            this.peakBytes = o.peakBytes;
        }

        private Builder(Builder o) {
            this.allocatedBytes = o.allocatedBytes;
            this.limitBytes = o.limitBytes;
            this.peakBytes = o.peakBytes;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code allocated_bytes}
         */
        @Nonnull
        public final Builder allocatedBytes(@Nullable Long value) {
            this.allocatedBytes = value;
            return this;
        }

        /**
         * API name: {@code limit_bytes}
         */
        @Nonnull
        public final Builder limitBytes(@Nullable Long value) {
            this.limitBytes = value;
            return this;
        }

        /**
         * API name: {@code peak_bytes}
         */
        @Nonnull
        public final Builder peakBytes(@Nullable Long value) {
            this.peakBytes = value;
            return this;
        }

        /**
         * Builds a {@link NativeMemoryAllocatorPool}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public NativeMemoryAllocatorPool build() {
            _checkSingleUse();

            return new NativeMemoryAllocatorPool(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link NativeMemoryAllocatorPool}
     */
    public static final JsonpDeserializer<NativeMemoryAllocatorPool> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        NativeMemoryAllocatorPool::setupNativeMemoryAllocatorPoolDeserializer
    );

    protected static void setupNativeMemoryAllocatorPoolDeserializer(ObjectDeserializer<NativeMemoryAllocatorPool.Builder> op) {
        op.add(Builder::allocatedBytes, JsonpDeserializer.longDeserializer(), "allocated_bytes");
        op.add(Builder::limitBytes, JsonpDeserializer.longDeserializer(), "limit_bytes");
        op.add(Builder::peakBytes, JsonpDeserializer.longDeserializer(), "peak_bytes");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.allocatedBytes);
        result = 31 * result + Objects.hashCode(this.limitBytes);
        result = 31 * result + Objects.hashCode(this.peakBytes);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        NativeMemoryAllocatorPool other = (NativeMemoryAllocatorPool) o;
        return Objects.equals(this.allocatedBytes, other.allocatedBytes)
            && Objects.equals(this.limitBytes, other.limitBytes)
            && Objects.equals(this.peakBytes, other.peakBytes);
    }
}
