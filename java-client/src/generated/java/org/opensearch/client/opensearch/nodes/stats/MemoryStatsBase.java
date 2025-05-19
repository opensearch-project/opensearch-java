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
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.json.PlainJsonSerializable;
import org.opensearch.client.util.ObjectBuilderBase;

// typedef: nodes.stats.MemoryStatsBase

@Generated("org.opensearch.client.codegen.CodeGenerator")
public abstract class MemoryStatsBase implements PlainJsonSerializable {

    @Nullable
    private final String free;

    @Nullable
    private final Long freeInBytes;

    @Nullable
    private final String total;

    @Nullable
    private final Long totalInBytes;

    @Nullable
    private final String used;

    @Nullable
    private final Long usedInBytes;

    // ---------------------------------------------------------------------------------------------

    protected MemoryStatsBase(AbstractBuilder<?> builder) {
        this.free = builder.free;
        this.freeInBytes = builder.freeInBytes;
        this.total = builder.total;
        this.totalInBytes = builder.totalInBytes;
        this.used = builder.used;
        this.usedInBytes = builder.usedInBytes;
    }

    /**
     * Amount of free physical memory.
     * <p>
     * API name: {@code free}
     * </p>
     */
    @Nullable
    public final String free() {
        return this.free;
    }

    /**
     * Amount of free physical memory in bytes.
     * <p>
     * API name: {@code free_in_bytes}
     * </p>
     */
    @Nullable
    public final Long freeInBytes() {
        return this.freeInBytes;
    }

    /**
     * Total amount of physical memory.
     * <p>
     * API name: {@code total}
     * </p>
     */
    @Nullable
    public final String total() {
        return this.total;
    }

    /**
     * Total amount of physical memory in bytes.
     * <p>
     * API name: {@code total_in_bytes}
     * </p>
     */
    @Nullable
    public final Long totalInBytes() {
        return this.totalInBytes;
    }

    /**
     * Amount of used physical memory.
     * <p>
     * API name: {@code used}
     * </p>
     */
    @Nullable
    public final String used() {
        return this.used;
    }

    /**
     * Amount of used physical memory in bytes.
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
        if (this.free != null) {
            generator.writeKey("free");
            generator.write(this.free);
        }

        if (this.freeInBytes != null) {
            generator.writeKey("free_in_bytes");
            generator.write(this.freeInBytes);
        }

        if (this.total != null) {
            generator.writeKey("total");
            generator.write(this.total);
        }

        if (this.totalInBytes != null) {
            generator.writeKey("total_in_bytes");
            generator.write(this.totalInBytes);
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

    public abstract static class AbstractBuilder<BuilderT extends AbstractBuilder<BuilderT>> extends ObjectBuilderBase {
        @Nullable
        private String free;
        @Nullable
        private Long freeInBytes;
        @Nullable
        private String total;
        @Nullable
        private Long totalInBytes;
        @Nullable
        private String used;
        @Nullable
        private Long usedInBytes;

        protected AbstractBuilder() {}

        protected AbstractBuilder(MemoryStatsBase o) {
            this.free = o.free;
            this.freeInBytes = o.freeInBytes;
            this.total = o.total;
            this.totalInBytes = o.totalInBytes;
            this.used = o.used;
            this.usedInBytes = o.usedInBytes;
        }

        protected AbstractBuilder(AbstractBuilder<BuilderT> o) {
            this.free = o.free;
            this.freeInBytes = o.freeInBytes;
            this.total = o.total;
            this.totalInBytes = o.totalInBytes;
            this.used = o.used;
            this.usedInBytes = o.usedInBytes;
        }

        @Nonnull
        protected abstract BuilderT self();

        /**
         * Amount of free physical memory.
         * <p>
         * API name: {@code free}
         * </p>
         */
        @Nonnull
        public final BuilderT free(@Nullable String value) {
            this.free = value;
            return self();
        }

        /**
         * Amount of free physical memory in bytes.
         * <p>
         * API name: {@code free_in_bytes}
         * </p>
         */
        @Nonnull
        public final BuilderT freeInBytes(@Nullable Long value) {
            this.freeInBytes = value;
            return self();
        }

        /**
         * Total amount of physical memory.
         * <p>
         * API name: {@code total}
         * </p>
         */
        @Nonnull
        public final BuilderT total(@Nullable String value) {
            this.total = value;
            return self();
        }

        /**
         * Total amount of physical memory in bytes.
         * <p>
         * API name: {@code total_in_bytes}
         * </p>
         */
        @Nonnull
        public final BuilderT totalInBytes(@Nullable Long value) {
            this.totalInBytes = value;
            return self();
        }

        /**
         * Amount of used physical memory.
         * <p>
         * API name: {@code used}
         * </p>
         */
        @Nonnull
        public final BuilderT used(@Nullable String value) {
            this.used = value;
            return self();
        }

        /**
         * Amount of used physical memory in bytes.
         * <p>
         * API name: {@code used_in_bytes}
         * </p>
         */
        @Nonnull
        public final BuilderT usedInBytes(@Nullable Long value) {
            this.usedInBytes = value;
            return self();
        }
    }

    // ---------------------------------------------------------------------------------------------

    protected static <BuilderT extends AbstractBuilder<BuilderT>> void setupMemoryStatsBaseDeserializer(ObjectDeserializer<BuilderT> op) {
        op.add(AbstractBuilder::free, JsonpDeserializer.stringDeserializer(), "free");
        op.add(AbstractBuilder::freeInBytes, JsonpDeserializer.longDeserializer(), "free_in_bytes");
        op.add(AbstractBuilder::total, JsonpDeserializer.stringDeserializer(), "total");
        op.add(AbstractBuilder::totalInBytes, JsonpDeserializer.longDeserializer(), "total_in_bytes");
        op.add(AbstractBuilder::used, JsonpDeserializer.stringDeserializer(), "used");
        op.add(AbstractBuilder::usedInBytes, JsonpDeserializer.longDeserializer(), "used_in_bytes");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.free);
        result = 31 * result + Objects.hashCode(this.freeInBytes);
        result = 31 * result + Objects.hashCode(this.total);
        result = 31 * result + Objects.hashCode(this.totalInBytes);
        result = 31 * result + Objects.hashCode(this.used);
        result = 31 * result + Objects.hashCode(this.usedInBytes);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        MemoryStatsBase other = (MemoryStatsBase) o;
        return Objects.equals(this.free, other.free)
            && Objects.equals(this.freeInBytes, other.freeInBytes)
            && Objects.equals(this.total, other.total)
            && Objects.equals(this.totalInBytes, other.totalInBytes)
            && Objects.equals(this.used, other.used)
            && Objects.equals(this.usedInBytes, other.usedInBytes);
    }
}
