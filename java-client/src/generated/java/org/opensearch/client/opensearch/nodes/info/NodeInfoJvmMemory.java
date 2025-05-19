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

package org.opensearch.client.opensearch.nodes.info;

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

// typedef: nodes.info.NodeInfoJvmMemory

/**
 * Provides JVM memory settings and statistics.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class NodeInfoJvmMemory implements PlainJsonSerializable, ToCopyableBuilder<NodeInfoJvmMemory.Builder, NodeInfoJvmMemory> {

    @Nullable
    private final String directMax;

    private final long directMaxInBytes;

    @Nullable
    private final String heapInit;

    private final long heapInitInBytes;

    @Nullable
    private final String heapMax;

    private final long heapMaxInBytes;

    @Nullable
    private final String nonHeapInit;

    private final long nonHeapInitInBytes;

    @Nullable
    private final String nonHeapMax;

    private final long nonHeapMaxInBytes;

    // ---------------------------------------------------------------------------------------------

    private NodeInfoJvmMemory(Builder builder) {
        this.directMax = builder.directMax;
        this.directMaxInBytes = ApiTypeHelper.requireNonNull(builder.directMaxInBytes, this, "directMaxInBytes");
        this.heapInit = builder.heapInit;
        this.heapInitInBytes = ApiTypeHelper.requireNonNull(builder.heapInitInBytes, this, "heapInitInBytes");
        this.heapMax = builder.heapMax;
        this.heapMaxInBytes = ApiTypeHelper.requireNonNull(builder.heapMaxInBytes, this, "heapMaxInBytes");
        this.nonHeapInit = builder.nonHeapInit;
        this.nonHeapInitInBytes = ApiTypeHelper.requireNonNull(builder.nonHeapInitInBytes, this, "nonHeapInitInBytes");
        this.nonHeapMax = builder.nonHeapMax;
        this.nonHeapMaxInBytes = ApiTypeHelper.requireNonNull(builder.nonHeapMaxInBytes, this, "nonHeapMaxInBytes");
    }

    public static NodeInfoJvmMemory of(Function<NodeInfoJvmMemory.Builder, ObjectBuilder<NodeInfoJvmMemory>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code direct_max}
     */
    @Nullable
    public final String directMax() {
        return this.directMax;
    }

    /**
     * Required - API name: {@code direct_max_in_bytes}
     */
    public final long directMaxInBytes() {
        return this.directMaxInBytes;
    }

    /**
     * API name: {@code heap_init}
     */
    @Nullable
    public final String heapInit() {
        return this.heapInit;
    }

    /**
     * Required - API name: {@code heap_init_in_bytes}
     */
    public final long heapInitInBytes() {
        return this.heapInitInBytes;
    }

    /**
     * API name: {@code heap_max}
     */
    @Nullable
    public final String heapMax() {
        return this.heapMax;
    }

    /**
     * Required - API name: {@code heap_max_in_bytes}
     */
    public final long heapMaxInBytes() {
        return this.heapMaxInBytes;
    }

    /**
     * API name: {@code non_heap_init}
     */
    @Nullable
    public final String nonHeapInit() {
        return this.nonHeapInit;
    }

    /**
     * Required - API name: {@code non_heap_init_in_bytes}
     */
    public final long nonHeapInitInBytes() {
        return this.nonHeapInitInBytes;
    }

    /**
     * API name: {@code non_heap_max}
     */
    @Nullable
    public final String nonHeapMax() {
        return this.nonHeapMax;
    }

    /**
     * Required - API name: {@code non_heap_max_in_bytes}
     */
    public final long nonHeapMaxInBytes() {
        return this.nonHeapMaxInBytes;
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
        if (this.directMax != null) {
            generator.writeKey("direct_max");
            generator.write(this.directMax);
        }

        generator.writeKey("direct_max_in_bytes");
        generator.write(this.directMaxInBytes);

        if (this.heapInit != null) {
            generator.writeKey("heap_init");
            generator.write(this.heapInit);
        }

        generator.writeKey("heap_init_in_bytes");
        generator.write(this.heapInitInBytes);

        if (this.heapMax != null) {
            generator.writeKey("heap_max");
            generator.write(this.heapMax);
        }

        generator.writeKey("heap_max_in_bytes");
        generator.write(this.heapMaxInBytes);

        if (this.nonHeapInit != null) {
            generator.writeKey("non_heap_init");
            generator.write(this.nonHeapInit);
        }

        generator.writeKey("non_heap_init_in_bytes");
        generator.write(this.nonHeapInitInBytes);

        if (this.nonHeapMax != null) {
            generator.writeKey("non_heap_max");
            generator.write(this.nonHeapMax);
        }

        generator.writeKey("non_heap_max_in_bytes");
        generator.write(this.nonHeapMaxInBytes);
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
     * Builder for {@link NodeInfoJvmMemory}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, NodeInfoJvmMemory> {
        @Nullable
        private String directMax;
        private Long directMaxInBytes;
        @Nullable
        private String heapInit;
        private Long heapInitInBytes;
        @Nullable
        private String heapMax;
        private Long heapMaxInBytes;
        @Nullable
        private String nonHeapInit;
        private Long nonHeapInitInBytes;
        @Nullable
        private String nonHeapMax;
        private Long nonHeapMaxInBytes;

        public Builder() {}

        private Builder(NodeInfoJvmMemory o) {
            this.directMax = o.directMax;
            this.directMaxInBytes = o.directMaxInBytes;
            this.heapInit = o.heapInit;
            this.heapInitInBytes = o.heapInitInBytes;
            this.heapMax = o.heapMax;
            this.heapMaxInBytes = o.heapMaxInBytes;
            this.nonHeapInit = o.nonHeapInit;
            this.nonHeapInitInBytes = o.nonHeapInitInBytes;
            this.nonHeapMax = o.nonHeapMax;
            this.nonHeapMaxInBytes = o.nonHeapMaxInBytes;
        }

        private Builder(Builder o) {
            this.directMax = o.directMax;
            this.directMaxInBytes = o.directMaxInBytes;
            this.heapInit = o.heapInit;
            this.heapInitInBytes = o.heapInitInBytes;
            this.heapMax = o.heapMax;
            this.heapMaxInBytes = o.heapMaxInBytes;
            this.nonHeapInit = o.nonHeapInit;
            this.nonHeapInitInBytes = o.nonHeapInitInBytes;
            this.nonHeapMax = o.nonHeapMax;
            this.nonHeapMaxInBytes = o.nonHeapMaxInBytes;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code direct_max}
         */
        @Nonnull
        public final Builder directMax(@Nullable String value) {
            this.directMax = value;
            return this;
        }

        /**
         * Required - API name: {@code direct_max_in_bytes}
         */
        @Nonnull
        public final Builder directMaxInBytes(long value) {
            this.directMaxInBytes = value;
            return this;
        }

        /**
         * API name: {@code heap_init}
         */
        @Nonnull
        public final Builder heapInit(@Nullable String value) {
            this.heapInit = value;
            return this;
        }

        /**
         * Required - API name: {@code heap_init_in_bytes}
         */
        @Nonnull
        public final Builder heapInitInBytes(long value) {
            this.heapInitInBytes = value;
            return this;
        }

        /**
         * API name: {@code heap_max}
         */
        @Nonnull
        public final Builder heapMax(@Nullable String value) {
            this.heapMax = value;
            return this;
        }

        /**
         * Required - API name: {@code heap_max_in_bytes}
         */
        @Nonnull
        public final Builder heapMaxInBytes(long value) {
            this.heapMaxInBytes = value;
            return this;
        }

        /**
         * API name: {@code non_heap_init}
         */
        @Nonnull
        public final Builder nonHeapInit(@Nullable String value) {
            this.nonHeapInit = value;
            return this;
        }

        /**
         * Required - API name: {@code non_heap_init_in_bytes}
         */
        @Nonnull
        public final Builder nonHeapInitInBytes(long value) {
            this.nonHeapInitInBytes = value;
            return this;
        }

        /**
         * API name: {@code non_heap_max}
         */
        @Nonnull
        public final Builder nonHeapMax(@Nullable String value) {
            this.nonHeapMax = value;
            return this;
        }

        /**
         * Required - API name: {@code non_heap_max_in_bytes}
         */
        @Nonnull
        public final Builder nonHeapMaxInBytes(long value) {
            this.nonHeapMaxInBytes = value;
            return this;
        }

        /**
         * Builds a {@link NodeInfoJvmMemory}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public NodeInfoJvmMemory build() {
            _checkSingleUse();

            return new NodeInfoJvmMemory(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link NodeInfoJvmMemory}
     */
    public static final JsonpDeserializer<NodeInfoJvmMemory> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        NodeInfoJvmMemory::setupNodeInfoJvmMemoryDeserializer
    );

    protected static void setupNodeInfoJvmMemoryDeserializer(ObjectDeserializer<NodeInfoJvmMemory.Builder> op) {
        op.add(Builder::directMax, JsonpDeserializer.stringDeserializer(), "direct_max");
        op.add(Builder::directMaxInBytes, JsonpDeserializer.longDeserializer(), "direct_max_in_bytes");
        op.add(Builder::heapInit, JsonpDeserializer.stringDeserializer(), "heap_init");
        op.add(Builder::heapInitInBytes, JsonpDeserializer.longDeserializer(), "heap_init_in_bytes");
        op.add(Builder::heapMax, JsonpDeserializer.stringDeserializer(), "heap_max");
        op.add(Builder::heapMaxInBytes, JsonpDeserializer.longDeserializer(), "heap_max_in_bytes");
        op.add(Builder::nonHeapInit, JsonpDeserializer.stringDeserializer(), "non_heap_init");
        op.add(Builder::nonHeapInitInBytes, JsonpDeserializer.longDeserializer(), "non_heap_init_in_bytes");
        op.add(Builder::nonHeapMax, JsonpDeserializer.stringDeserializer(), "non_heap_max");
        op.add(Builder::nonHeapMaxInBytes, JsonpDeserializer.longDeserializer(), "non_heap_max_in_bytes");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.directMax);
        result = 31 * result + Long.hashCode(this.directMaxInBytes);
        result = 31 * result + Objects.hashCode(this.heapInit);
        result = 31 * result + Long.hashCode(this.heapInitInBytes);
        result = 31 * result + Objects.hashCode(this.heapMax);
        result = 31 * result + Long.hashCode(this.heapMaxInBytes);
        result = 31 * result + Objects.hashCode(this.nonHeapInit);
        result = 31 * result + Long.hashCode(this.nonHeapInitInBytes);
        result = 31 * result + Objects.hashCode(this.nonHeapMax);
        result = 31 * result + Long.hashCode(this.nonHeapMaxInBytes);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        NodeInfoJvmMemory other = (NodeInfoJvmMemory) o;
        return Objects.equals(this.directMax, other.directMax)
            && this.directMaxInBytes == other.directMaxInBytes
            && Objects.equals(this.heapInit, other.heapInit)
            && this.heapInitInBytes == other.heapInitInBytes
            && Objects.equals(this.heapMax, other.heapMax)
            && this.heapMaxInBytes == other.heapMaxInBytes
            && Objects.equals(this.nonHeapInit, other.nonHeapInit)
            && this.nonHeapInitInBytes == other.nonHeapInitInBytes
            && Objects.equals(this.nonHeapMax, other.nonHeapMax)
            && this.nonHeapMaxInBytes == other.nonHeapMaxInBytes;
    }
}
