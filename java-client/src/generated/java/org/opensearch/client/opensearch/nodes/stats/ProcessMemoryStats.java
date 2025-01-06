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

// typedef: nodes.stats.ProcessMemoryStats

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class ProcessMemoryStats implements PlainJsonSerializable, ToCopyableBuilder<ProcessMemoryStats.Builder, ProcessMemoryStats> {

    @Nullable
    private final String totalVirtual;

    @Nullable
    private final Long totalVirtualInBytes;

    // ---------------------------------------------------------------------------------------------

    private ProcessMemoryStats(Builder builder) {
        this.totalVirtual = builder.totalVirtual;
        this.totalVirtualInBytes = builder.totalVirtualInBytes;
    }

    public static ProcessMemoryStats of(Function<ProcessMemoryStats.Builder, ObjectBuilder<ProcessMemoryStats>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code total_virtual}
     */
    @Nullable
    public final String totalVirtual() {
        return this.totalVirtual;
    }

    /**
     * API name: {@code total_virtual_in_bytes}
     */
    @Nullable
    public final Long totalVirtualInBytes() {
        return this.totalVirtualInBytes;
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
        if (this.totalVirtual != null) {
            generator.writeKey("total_virtual");
            generator.write(this.totalVirtual);
        }

        if (this.totalVirtualInBytes != null) {
            generator.writeKey("total_virtual_in_bytes");
            generator.write(this.totalVirtualInBytes);
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
     * Builder for {@link ProcessMemoryStats}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, ProcessMemoryStats> {
        @Nullable
        private String totalVirtual;
        @Nullable
        private Long totalVirtualInBytes;

        public Builder() {}

        private Builder(ProcessMemoryStats o) {
            this.totalVirtual = o.totalVirtual;
            this.totalVirtualInBytes = o.totalVirtualInBytes;
        }

        private Builder(Builder o) {
            this.totalVirtual = o.totalVirtual;
            this.totalVirtualInBytes = o.totalVirtualInBytes;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code total_virtual}
         */
        @Nonnull
        public final Builder totalVirtual(@Nullable String value) {
            this.totalVirtual = value;
            return this;
        }

        /**
         * API name: {@code total_virtual_in_bytes}
         */
        @Nonnull
        public final Builder totalVirtualInBytes(@Nullable Long value) {
            this.totalVirtualInBytes = value;
            return this;
        }

        /**
         * Builds a {@link ProcessMemoryStats}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ProcessMemoryStats build() {
            _checkSingleUse();

            return new ProcessMemoryStats(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ProcessMemoryStats}
     */
    public static final JsonpDeserializer<ProcessMemoryStats> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ProcessMemoryStats::setupProcessMemoryStatsDeserializer
    );

    protected static void setupProcessMemoryStatsDeserializer(ObjectDeserializer<ProcessMemoryStats.Builder> op) {
        op.add(Builder::totalVirtual, JsonpDeserializer.stringDeserializer(), "total_virtual");
        op.add(Builder::totalVirtualInBytes, JsonpDeserializer.longDeserializer(), "total_virtual_in_bytes");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.totalVirtual);
        result = 31 * result + Objects.hashCode(this.totalVirtualInBytes);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ProcessMemoryStats other = (ProcessMemoryStats) o;
        return Objects.equals(this.totalVirtual, other.totalVirtual) && Objects.equals(this.totalVirtualInBytes, other.totalVirtualInBytes);
    }
}
