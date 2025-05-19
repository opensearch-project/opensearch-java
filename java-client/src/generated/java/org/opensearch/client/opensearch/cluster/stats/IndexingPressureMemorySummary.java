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

// typedef: cluster.stats.IndexingPressureMemorySummary

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class IndexingPressureMemorySummary
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<IndexingPressureMemorySummary.Builder, IndexingPressureMemorySummary> {

    private final long allInBytes;

    private final long combinedCoordinatingAndPrimaryInBytes;

    private final long coordinatingInBytes;

    @Nullable
    private final Number coordinatingRejections;

    private final long primaryInBytes;

    @Nullable
    private final Number primaryRejections;

    private final long replicaInBytes;

    @Nullable
    private final Number replicaRejections;

    // ---------------------------------------------------------------------------------------------

    private IndexingPressureMemorySummary(Builder builder) {
        this.allInBytes = ApiTypeHelper.requireNonNull(builder.allInBytes, this, "allInBytes");
        this.combinedCoordinatingAndPrimaryInBytes = ApiTypeHelper.requireNonNull(
            builder.combinedCoordinatingAndPrimaryInBytes,
            this,
            "combinedCoordinatingAndPrimaryInBytes"
        );
        this.coordinatingInBytes = ApiTypeHelper.requireNonNull(builder.coordinatingInBytes, this, "coordinatingInBytes");
        this.coordinatingRejections = builder.coordinatingRejections;
        this.primaryInBytes = ApiTypeHelper.requireNonNull(builder.primaryInBytes, this, "primaryInBytes");
        this.primaryRejections = builder.primaryRejections;
        this.replicaInBytes = ApiTypeHelper.requireNonNull(builder.replicaInBytes, this, "replicaInBytes");
        this.replicaRejections = builder.replicaRejections;
    }

    public static IndexingPressureMemorySummary of(
        Function<IndexingPressureMemorySummary.Builder, ObjectBuilder<IndexingPressureMemorySummary>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code all_in_bytes}
     */
    public final long allInBytes() {
        return this.allInBytes;
    }

    /**
     * Required - API name: {@code combined_coordinating_and_primary_in_bytes}
     */
    public final long combinedCoordinatingAndPrimaryInBytes() {
        return this.combinedCoordinatingAndPrimaryInBytes;
    }

    /**
     * Required - API name: {@code coordinating_in_bytes}
     */
    public final long coordinatingInBytes() {
        return this.coordinatingInBytes;
    }

    /**
     * API name: {@code coordinating_rejections}
     */
    @Nullable
    public final Number coordinatingRejections() {
        return this.coordinatingRejections;
    }

    /**
     * Required - API name: {@code primary_in_bytes}
     */
    public final long primaryInBytes() {
        return this.primaryInBytes;
    }

    /**
     * API name: {@code primary_rejections}
     */
    @Nullable
    public final Number primaryRejections() {
        return this.primaryRejections;
    }

    /**
     * Required - API name: {@code replica_in_bytes}
     */
    public final long replicaInBytes() {
        return this.replicaInBytes;
    }

    /**
     * API name: {@code replica_rejections}
     */
    @Nullable
    public final Number replicaRejections() {
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
        generator.writeKey("all_in_bytes");
        generator.write(this.allInBytes);

        generator.writeKey("combined_coordinating_and_primary_in_bytes");
        generator.write(this.combinedCoordinatingAndPrimaryInBytes);

        generator.writeKey("coordinating_in_bytes");
        generator.write(this.coordinatingInBytes);

        if (this.coordinatingRejections != null) {
            generator.writeKey("coordinating_rejections");
            generator.write(this.coordinatingRejections.doubleValue());
        }

        generator.writeKey("primary_in_bytes");
        generator.write(this.primaryInBytes);

        if (this.primaryRejections != null) {
            generator.writeKey("primary_rejections");
            generator.write(this.primaryRejections.doubleValue());
        }

        generator.writeKey("replica_in_bytes");
        generator.write(this.replicaInBytes);

        if (this.replicaRejections != null) {
            generator.writeKey("replica_rejections");
            generator.write(this.replicaRejections.doubleValue());
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
     * Builder for {@link IndexingPressureMemorySummary}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, IndexingPressureMemorySummary> {
        private Long allInBytes;
        private Long combinedCoordinatingAndPrimaryInBytes;
        private Long coordinatingInBytes;
        @Nullable
        private Number coordinatingRejections;
        private Long primaryInBytes;
        @Nullable
        private Number primaryRejections;
        private Long replicaInBytes;
        @Nullable
        private Number replicaRejections;

        public Builder() {}

        private Builder(IndexingPressureMemorySummary o) {
            this.allInBytes = o.allInBytes;
            this.combinedCoordinatingAndPrimaryInBytes = o.combinedCoordinatingAndPrimaryInBytes;
            this.coordinatingInBytes = o.coordinatingInBytes;
            this.coordinatingRejections = o.coordinatingRejections;
            this.primaryInBytes = o.primaryInBytes;
            this.primaryRejections = o.primaryRejections;
            this.replicaInBytes = o.replicaInBytes;
            this.replicaRejections = o.replicaRejections;
        }

        private Builder(Builder o) {
            this.allInBytes = o.allInBytes;
            this.combinedCoordinatingAndPrimaryInBytes = o.combinedCoordinatingAndPrimaryInBytes;
            this.coordinatingInBytes = o.coordinatingInBytes;
            this.coordinatingRejections = o.coordinatingRejections;
            this.primaryInBytes = o.primaryInBytes;
            this.primaryRejections = o.primaryRejections;
            this.replicaInBytes = o.replicaInBytes;
            this.replicaRejections = o.replicaRejections;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - API name: {@code all_in_bytes}
         */
        @Nonnull
        public final Builder allInBytes(long value) {
            this.allInBytes = value;
            return this;
        }

        /**
         * Required - API name: {@code combined_coordinating_and_primary_in_bytes}
         */
        @Nonnull
        public final Builder combinedCoordinatingAndPrimaryInBytes(long value) {
            this.combinedCoordinatingAndPrimaryInBytes = value;
            return this;
        }

        /**
         * Required - API name: {@code coordinating_in_bytes}
         */
        @Nonnull
        public final Builder coordinatingInBytes(long value) {
            this.coordinatingInBytes = value;
            return this;
        }

        /**
         * API name: {@code coordinating_rejections}
         */
        @Nonnull
        public final Builder coordinatingRejections(@Nullable Number value) {
            this.coordinatingRejections = value;
            return this;
        }

        /**
         * Required - API name: {@code primary_in_bytes}
         */
        @Nonnull
        public final Builder primaryInBytes(long value) {
            this.primaryInBytes = value;
            return this;
        }

        /**
         * API name: {@code primary_rejections}
         */
        @Nonnull
        public final Builder primaryRejections(@Nullable Number value) {
            this.primaryRejections = value;
            return this;
        }

        /**
         * Required - API name: {@code replica_in_bytes}
         */
        @Nonnull
        public final Builder replicaInBytes(long value) {
            this.replicaInBytes = value;
            return this;
        }

        /**
         * API name: {@code replica_rejections}
         */
        @Nonnull
        public final Builder replicaRejections(@Nullable Number value) {
            this.replicaRejections = value;
            return this;
        }

        /**
         * Builds a {@link IndexingPressureMemorySummary}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public IndexingPressureMemorySummary build() {
            _checkSingleUse();

            return new IndexingPressureMemorySummary(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link IndexingPressureMemorySummary}
     */
    public static final JsonpDeserializer<IndexingPressureMemorySummary> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        IndexingPressureMemorySummary::setupIndexingPressureMemorySummaryDeserializer
    );

    protected static void setupIndexingPressureMemorySummaryDeserializer(ObjectDeserializer<IndexingPressureMemorySummary.Builder> op) {
        op.add(Builder::allInBytes, JsonpDeserializer.longDeserializer(), "all_in_bytes");
        op.add(
            Builder::combinedCoordinatingAndPrimaryInBytes,
            JsonpDeserializer.longDeserializer(),
            "combined_coordinating_and_primary_in_bytes"
        );
        op.add(Builder::coordinatingInBytes, JsonpDeserializer.longDeserializer(), "coordinating_in_bytes");
        op.add(Builder::coordinatingRejections, JsonpDeserializer.numberDeserializer(), "coordinating_rejections");
        op.add(Builder::primaryInBytes, JsonpDeserializer.longDeserializer(), "primary_in_bytes");
        op.add(Builder::primaryRejections, JsonpDeserializer.numberDeserializer(), "primary_rejections");
        op.add(Builder::replicaInBytes, JsonpDeserializer.longDeserializer(), "replica_in_bytes");
        op.add(Builder::replicaRejections, JsonpDeserializer.numberDeserializer(), "replica_rejections");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Long.hashCode(this.allInBytes);
        result = 31 * result + Long.hashCode(this.combinedCoordinatingAndPrimaryInBytes);
        result = 31 * result + Long.hashCode(this.coordinatingInBytes);
        result = 31 * result + Objects.hashCode(this.coordinatingRejections);
        result = 31 * result + Long.hashCode(this.primaryInBytes);
        result = 31 * result + Objects.hashCode(this.primaryRejections);
        result = 31 * result + Long.hashCode(this.replicaInBytes);
        result = 31 * result + Objects.hashCode(this.replicaRejections);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        IndexingPressureMemorySummary other = (IndexingPressureMemorySummary) o;
        return this.allInBytes == other.allInBytes
            && this.combinedCoordinatingAndPrimaryInBytes == other.combinedCoordinatingAndPrimaryInBytes
            && this.coordinatingInBytes == other.coordinatingInBytes
            && Objects.equals(this.coordinatingRejections, other.coordinatingRejections)
            && this.primaryInBytes == other.primaryInBytes
            && Objects.equals(this.primaryRejections, other.primaryRejections)
            && this.replicaInBytes == other.replicaInBytes
            && Objects.equals(this.replicaRejections, other.replicaRejections);
    }
}
