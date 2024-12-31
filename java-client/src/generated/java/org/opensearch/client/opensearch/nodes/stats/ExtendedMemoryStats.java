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
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: nodes.stats.ExtendedMemoryStats

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class ExtendedMemoryStats extends MemoryStats implements ToCopyableBuilder<ExtendedMemoryStats.Builder, ExtendedMemoryStats> {

    @Nullable
    private final Double freePercent;

    @Nullable
    private final Double usedPercent;

    // ---------------------------------------------------------------------------------------------

    private ExtendedMemoryStats(Builder builder) {
        super(builder);
        this.freePercent = builder.freePercent;
        this.usedPercent = builder.usedPercent;
    }

    public static ExtendedMemoryStats of(Function<ExtendedMemoryStats.Builder, ObjectBuilder<ExtendedMemoryStats>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Percentage of free memory.
     * <p>
     * API name: {@code free_percent}
     * </p>
     */
    @Nullable
    public final Double freePercent() {
        return this.freePercent;
    }

    /**
     * Percentage of used memory.
     * <p>
     * API name: {@code used_percent}
     * </p>
     */
    @Nullable
    public final Double usedPercent() {
        return this.usedPercent;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        super.serializeInternal(generator, mapper);
        if (this.freePercent != null) {
            generator.writeKey("free_percent");
            generator.write(this.freePercent);
        }

        if (this.usedPercent != null) {
            generator.writeKey("used_percent");
            generator.write(this.usedPercent);
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
     * Builder for {@link ExtendedMemoryStats}.
     */
    public static class Builder extends MemoryStats.AbstractBuilder<Builder> implements CopyableBuilder<Builder, ExtendedMemoryStats> {
        @Nullable
        private Double freePercent;
        @Nullable
        private Double usedPercent;

        public Builder() {}

        private Builder(ExtendedMemoryStats o) {
            super(o);
            this.freePercent = o.freePercent;
            this.usedPercent = o.usedPercent;
        }

        private Builder(Builder o) {
            super(o);
            this.freePercent = o.freePercent;
            this.usedPercent = o.usedPercent;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        @Override
        @Nonnull
        protected Builder self() {
            return this;
        }

        /**
         * Percentage of free memory.
         * <p>
         * API name: {@code free_percent}
         * </p>
         */
        @Nonnull
        public final Builder freePercent(@Nullable Double value) {
            this.freePercent = value;
            return this;
        }

        /**
         * Percentage of used memory.
         * <p>
         * API name: {@code used_percent}
         * </p>
         */
        @Nonnull
        public final Builder usedPercent(@Nullable Double value) {
            this.usedPercent = value;
            return this;
        }

        /**
         * Builds a {@link ExtendedMemoryStats}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ExtendedMemoryStats build() {
            _checkSingleUse();

            return new ExtendedMemoryStats(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ExtendedMemoryStats}
     */
    public static final JsonpDeserializer<ExtendedMemoryStats> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ExtendedMemoryStats::setupExtendedMemoryStatsDeserializer
    );

    protected static void setupExtendedMemoryStatsDeserializer(ObjectDeserializer<ExtendedMemoryStats.Builder> op) {
        setupMemoryStatsDeserializer(op);
        op.add(Builder::freePercent, JsonpDeserializer.doubleDeserializer(), "free_percent");
        op.add(Builder::usedPercent, JsonpDeserializer.doubleDeserializer(), "used_percent");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(this.freePercent);
        result = 31 * result + Objects.hashCode(this.usedPercent);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ExtendedMemoryStats other = (ExtendedMemoryStats) o;
        return Objects.equals(this.freePercent, other.freePercent) && Objects.equals(this.usedPercent, other.usedPercent);
    }
}
