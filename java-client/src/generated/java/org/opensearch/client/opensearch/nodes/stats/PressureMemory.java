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

// typedef: nodes.stats.PressureMemory

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class PressureMemory implements PlainJsonSerializable, ToCopyableBuilder<PressureMemory.Builder, PressureMemory> {

    @Nullable
    private final String all;

    @Nullable
    private final Long allInBytes;

    @Nullable
    private final String combinedCoordinatingAndPrimary;

    @Nullable
    private final Long combinedCoordinatingAndPrimaryInBytes;

    @Nullable
    private final String coordinating;

    @Nullable
    private final Long coordinatingInBytes;

    @Nullable
    private final Long coordinatingRejections;

    @Nullable
    private final String primary;

    @Nullable
    private final Long primaryInBytes;

    @Nullable
    private final Long primaryRejections;

    @Nullable
    private final String replica;

    @Nullable
    private final Long replicaInBytes;

    @Nullable
    private final Long replicaRejections;

    // ---------------------------------------------------------------------------------------------

    private PressureMemory(Builder builder) {
        this.all = builder.all;
        this.allInBytes = builder.allInBytes;
        this.combinedCoordinatingAndPrimary = builder.combinedCoordinatingAndPrimary;
        this.combinedCoordinatingAndPrimaryInBytes = builder.combinedCoordinatingAndPrimaryInBytes;
        this.coordinating = builder.coordinating;
        this.coordinatingInBytes = builder.coordinatingInBytes;
        this.coordinatingRejections = builder.coordinatingRejections;
        this.primary = builder.primary;
        this.primaryInBytes = builder.primaryInBytes;
        this.primaryRejections = builder.primaryRejections;
        this.replica = builder.replica;
        this.replicaInBytes = builder.replicaInBytes;
        this.replicaRejections = builder.replicaRejections;
    }

    public static PressureMemory of(Function<PressureMemory.Builder, ObjectBuilder<PressureMemory>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code all}
     */
    @Nullable
    public final String all() {
        return this.all;
    }

    /**
     * Memory consumed, in bytes, by indexing requests in the coordinating, primary, or replica stage.
     * <p>
     * API name: {@code all_in_bytes}
     * </p>
     */
    @Nullable
    public final Long allInBytes() {
        return this.allInBytes;
    }

    /**
     * API name: {@code combined_coordinating_and_primary}
     */
    @Nullable
    public final String combinedCoordinatingAndPrimary() {
        return this.combinedCoordinatingAndPrimary;
    }

    /**
     * Memory consumed, in bytes, by indexing requests in the coordinating or primary stage. This value is not the sum of coordinating and
     * primary as a node can reuse the coordinating memory if the primary stage is executed locally.
     * <p>
     * API name: {@code combined_coordinating_and_primary_in_bytes}
     * </p>
     */
    @Nullable
    public final Long combinedCoordinatingAndPrimaryInBytes() {
        return this.combinedCoordinatingAndPrimaryInBytes;
    }

    /**
     * API name: {@code coordinating}
     */
    @Nullable
    public final String coordinating() {
        return this.coordinating;
    }

    /**
     * Memory consumed, in bytes, by indexing requests in the coordinating stage.
     * <p>
     * API name: {@code coordinating_in_bytes}
     * </p>
     */
    @Nullable
    public final Long coordinatingInBytes() {
        return this.coordinatingInBytes;
    }

    /**
     * Number of indexing requests rejected in the coordinating stage.
     * <p>
     * API name: {@code coordinating_rejections}
     * </p>
     */
    @Nullable
    public final Long coordinatingRejections() {
        return this.coordinatingRejections;
    }

    /**
     * API name: {@code primary}
     */
    @Nullable
    public final String primary() {
        return this.primary;
    }

    /**
     * Memory consumed, in bytes, by indexing requests in the primary stage.
     * <p>
     * API name: {@code primary_in_bytes}
     * </p>
     */
    @Nullable
    public final Long primaryInBytes() {
        return this.primaryInBytes;
    }

    /**
     * Number of indexing requests rejected in the primary stage.
     * <p>
     * API name: {@code primary_rejections}
     * </p>
     */
    @Nullable
    public final Long primaryRejections() {
        return this.primaryRejections;
    }

    /**
     * API name: {@code replica}
     */
    @Nullable
    public final String replica() {
        return this.replica;
    }

    /**
     * Memory consumed, in bytes, by indexing requests in the replica stage.
     * <p>
     * API name: {@code replica_in_bytes}
     * </p>
     */
    @Nullable
    public final Long replicaInBytes() {
        return this.replicaInBytes;
    }

    /**
     * Number of indexing requests rejected in the replica stage.
     * <p>
     * API name: {@code replica_rejections}
     * </p>
     */
    @Nullable
    public final Long replicaRejections() {
        return this.replicaRejections;
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
        if (this.all != null) {
            generator.writeKey("all");
            generator.write(this.all);
        }

        if (this.allInBytes != null) {
            generator.writeKey("all_in_bytes");
            generator.write(this.allInBytes);
        }

        if (this.combinedCoordinatingAndPrimary != null) {
            generator.writeKey("combined_coordinating_and_primary");
            generator.write(this.combinedCoordinatingAndPrimary);
        }

        if (this.combinedCoordinatingAndPrimaryInBytes != null) {
            generator.writeKey("combined_coordinating_and_primary_in_bytes");
            generator.write(this.combinedCoordinatingAndPrimaryInBytes);
        }

        if (this.coordinating != null) {
            generator.writeKey("coordinating");
            generator.write(this.coordinating);
        }

        if (this.coordinatingInBytes != null) {
            generator.writeKey("coordinating_in_bytes");
            generator.write(this.coordinatingInBytes);
        }

        if (this.coordinatingRejections != null) {
            generator.writeKey("coordinating_rejections");
            generator.write(this.coordinatingRejections);
        }

        if (this.primary != null) {
            generator.writeKey("primary");
            generator.write(this.primary);
        }

        if (this.primaryInBytes != null) {
            generator.writeKey("primary_in_bytes");
            generator.write(this.primaryInBytes);
        }

        if (this.primaryRejections != null) {
            generator.writeKey("primary_rejections");
            generator.write(this.primaryRejections);
        }

        if (this.replica != null) {
            generator.writeKey("replica");
            generator.write(this.replica);
        }

        if (this.replicaInBytes != null) {
            generator.writeKey("replica_in_bytes");
            generator.write(this.replicaInBytes);
        }

        if (this.replicaRejections != null) {
            generator.writeKey("replica_rejections");
            generator.write(this.replicaRejections);
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
     * Builder for {@link PressureMemory}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, PressureMemory> {
        @Nullable
        private String all;
        @Nullable
        private Long allInBytes;
        @Nullable
        private String combinedCoordinatingAndPrimary;
        @Nullable
        private Long combinedCoordinatingAndPrimaryInBytes;
        @Nullable
        private String coordinating;
        @Nullable
        private Long coordinatingInBytes;
        @Nullable
        private Long coordinatingRejections;
        @Nullable
        private String primary;
        @Nullable
        private Long primaryInBytes;
        @Nullable
        private Long primaryRejections;
        @Nullable
        private String replica;
        @Nullable
        private Long replicaInBytes;
        @Nullable
        private Long replicaRejections;

        public Builder() {}

        private Builder(PressureMemory o) {
            this.all = o.all;
            this.allInBytes = o.allInBytes;
            this.combinedCoordinatingAndPrimary = o.combinedCoordinatingAndPrimary;
            this.combinedCoordinatingAndPrimaryInBytes = o.combinedCoordinatingAndPrimaryInBytes;
            this.coordinating = o.coordinating;
            this.coordinatingInBytes = o.coordinatingInBytes;
            this.coordinatingRejections = o.coordinatingRejections;
            this.primary = o.primary;
            this.primaryInBytes = o.primaryInBytes;
            this.primaryRejections = o.primaryRejections;
            this.replica = o.replica;
            this.replicaInBytes = o.replicaInBytes;
            this.replicaRejections = o.replicaRejections;
        }

        private Builder(Builder o) {
            this.all = o.all;
            this.allInBytes = o.allInBytes;
            this.combinedCoordinatingAndPrimary = o.combinedCoordinatingAndPrimary;
            this.combinedCoordinatingAndPrimaryInBytes = o.combinedCoordinatingAndPrimaryInBytes;
            this.coordinating = o.coordinating;
            this.coordinatingInBytes = o.coordinatingInBytes;
            this.coordinatingRejections = o.coordinatingRejections;
            this.primary = o.primary;
            this.primaryInBytes = o.primaryInBytes;
            this.primaryRejections = o.primaryRejections;
            this.replica = o.replica;
            this.replicaInBytes = o.replicaInBytes;
            this.replicaRejections = o.replicaRejections;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code all}
         */
        @Nonnull
        public final Builder all(@Nullable String value) {
            this.all = value;
            return this;
        }

        /**
         * Memory consumed, in bytes, by indexing requests in the coordinating, primary, or replica stage.
         * <p>
         * API name: {@code all_in_bytes}
         * </p>
         */
        @Nonnull
        public final Builder allInBytes(@Nullable Long value) {
            this.allInBytes = value;
            return this;
        }

        /**
         * API name: {@code combined_coordinating_and_primary}
         */
        @Nonnull
        public final Builder combinedCoordinatingAndPrimary(@Nullable String value) {
            this.combinedCoordinatingAndPrimary = value;
            return this;
        }

        /**
         * Memory consumed, in bytes, by indexing requests in the coordinating or primary stage. This value is not the sum of coordinating
         * and primary as a node can reuse the coordinating memory if the primary stage is executed locally.
         * <p>
         * API name: {@code combined_coordinating_and_primary_in_bytes}
         * </p>
         */
        @Nonnull
        public final Builder combinedCoordinatingAndPrimaryInBytes(@Nullable Long value) {
            this.combinedCoordinatingAndPrimaryInBytes = value;
            return this;
        }

        /**
         * API name: {@code coordinating}
         */
        @Nonnull
        public final Builder coordinating(@Nullable String value) {
            this.coordinating = value;
            return this;
        }

        /**
         * Memory consumed, in bytes, by indexing requests in the coordinating stage.
         * <p>
         * API name: {@code coordinating_in_bytes}
         * </p>
         */
        @Nonnull
        public final Builder coordinatingInBytes(@Nullable Long value) {
            this.coordinatingInBytes = value;
            return this;
        }

        /**
         * Number of indexing requests rejected in the coordinating stage.
         * <p>
         * API name: {@code coordinating_rejections}
         * </p>
         */
        @Nonnull
        public final Builder coordinatingRejections(@Nullable Long value) {
            this.coordinatingRejections = value;
            return this;
        }

        /**
         * API name: {@code primary}
         */
        @Nonnull
        public final Builder primary(@Nullable String value) {
            this.primary = value;
            return this;
        }

        /**
         * Memory consumed, in bytes, by indexing requests in the primary stage.
         * <p>
         * API name: {@code primary_in_bytes}
         * </p>
         */
        @Nonnull
        public final Builder primaryInBytes(@Nullable Long value) {
            this.primaryInBytes = value;
            return this;
        }

        /**
         * Number of indexing requests rejected in the primary stage.
         * <p>
         * API name: {@code primary_rejections}
         * </p>
         */
        @Nonnull
        public final Builder primaryRejections(@Nullable Long value) {
            this.primaryRejections = value;
            return this;
        }

        /**
         * API name: {@code replica}
         */
        @Nonnull
        public final Builder replica(@Nullable String value) {
            this.replica = value;
            return this;
        }

        /**
         * Memory consumed, in bytes, by indexing requests in the replica stage.
         * <p>
         * API name: {@code replica_in_bytes}
         * </p>
         */
        @Nonnull
        public final Builder replicaInBytes(@Nullable Long value) {
            this.replicaInBytes = value;
            return this;
        }

        /**
         * Number of indexing requests rejected in the replica stage.
         * <p>
         * API name: {@code replica_rejections}
         * </p>
         */
        @Nonnull
        public final Builder replicaRejections(@Nullable Long value) {
            this.replicaRejections = value;
            return this;
        }

        /**
         * Builds a {@link PressureMemory}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public PressureMemory build() {
            _checkSingleUse();

            return new PressureMemory(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link PressureMemory}
     */
    public static final JsonpDeserializer<PressureMemory> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        PressureMemory::setupPressureMemoryDeserializer
    );

    protected static void setupPressureMemoryDeserializer(ObjectDeserializer<PressureMemory.Builder> op) {
        op.add(Builder::all, JsonpDeserializer.stringDeserializer(), "all");
        op.add(Builder::allInBytes, JsonpDeserializer.longDeserializer(), "all_in_bytes");
        op.add(Builder::combinedCoordinatingAndPrimary, JsonpDeserializer.stringDeserializer(), "combined_coordinating_and_primary");
        op.add(
            Builder::combinedCoordinatingAndPrimaryInBytes,
            JsonpDeserializer.longDeserializer(),
            "combined_coordinating_and_primary_in_bytes"
        );
        op.add(Builder::coordinating, JsonpDeserializer.stringDeserializer(), "coordinating");
        op.add(Builder::coordinatingInBytes, JsonpDeserializer.longDeserializer(), "coordinating_in_bytes");
        op.add(Builder::coordinatingRejections, JsonpDeserializer.longDeserializer(), "coordinating_rejections");
        op.add(Builder::primary, JsonpDeserializer.stringDeserializer(), "primary");
        op.add(Builder::primaryInBytes, JsonpDeserializer.longDeserializer(), "primary_in_bytes");
        op.add(Builder::primaryRejections, JsonpDeserializer.longDeserializer(), "primary_rejections");
        op.add(Builder::replica, JsonpDeserializer.stringDeserializer(), "replica");
        op.add(Builder::replicaInBytes, JsonpDeserializer.longDeserializer(), "replica_in_bytes");
        op.add(Builder::replicaRejections, JsonpDeserializer.longDeserializer(), "replica_rejections");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.all);
        result = 31 * result + Objects.hashCode(this.allInBytes);
        result = 31 * result + Objects.hashCode(this.combinedCoordinatingAndPrimary);
        result = 31 * result + Objects.hashCode(this.combinedCoordinatingAndPrimaryInBytes);
        result = 31 * result + Objects.hashCode(this.coordinating);
        result = 31 * result + Objects.hashCode(this.coordinatingInBytes);
        result = 31 * result + Objects.hashCode(this.coordinatingRejections);
        result = 31 * result + Objects.hashCode(this.primary);
        result = 31 * result + Objects.hashCode(this.primaryInBytes);
        result = 31 * result + Objects.hashCode(this.primaryRejections);
        result = 31 * result + Objects.hashCode(this.replica);
        result = 31 * result + Objects.hashCode(this.replicaInBytes);
        result = 31 * result + Objects.hashCode(this.replicaRejections);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        PressureMemory other = (PressureMemory) o;
        return Objects.equals(this.all, other.all)
            && Objects.equals(this.allInBytes, other.allInBytes)
            && Objects.equals(this.combinedCoordinatingAndPrimary, other.combinedCoordinatingAndPrimary)
            && Objects.equals(this.combinedCoordinatingAndPrimaryInBytes, other.combinedCoordinatingAndPrimaryInBytes)
            && Objects.equals(this.coordinating, other.coordinating)
            && Objects.equals(this.coordinatingInBytes, other.coordinatingInBytes)
            && Objects.equals(this.coordinatingRejections, other.coordinatingRejections)
            && Objects.equals(this.primary, other.primary)
            && Objects.equals(this.primaryInBytes, other.primaryInBytes)
            && Objects.equals(this.primaryRejections, other.primaryRejections)
            && Objects.equals(this.replica, other.replica)
            && Objects.equals(this.replicaInBytes, other.replicaInBytes)
            && Objects.equals(this.replicaRejections, other.replicaRejections);
    }
}
