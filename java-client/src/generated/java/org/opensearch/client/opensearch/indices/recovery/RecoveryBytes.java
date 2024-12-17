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

package org.opensearch.client.opensearch.indices.recovery;

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

// typedef: indices.recovery.RecoveryBytes

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class RecoveryBytes implements PlainJsonSerializable, ToCopyableBuilder<RecoveryBytes.Builder, RecoveryBytes> {

    @Nonnull
    private final String percent;

    @Nullable
    private final String recovered;

    @Nullable
    private final String recoveredFromSnapshot;

    @Nullable
    private final Long recoveredFromSnapshotInBytes;

    private final long recoveredInBytes;

    @Nullable
    private final String reused;

    private final long reusedInBytes;

    @Nullable
    private final String total;

    private final long totalInBytes;

    // ---------------------------------------------------------------------------------------------

    private RecoveryBytes(Builder builder) {
        this.percent = ApiTypeHelper.requireNonNull(builder.percent, this, "percent");
        this.recovered = builder.recovered;
        this.recoveredFromSnapshot = builder.recoveredFromSnapshot;
        this.recoveredFromSnapshotInBytes = builder.recoveredFromSnapshotInBytes;
        this.recoveredInBytes = ApiTypeHelper.requireNonNull(builder.recoveredInBytes, this, "recoveredInBytes");
        this.reused = builder.reused;
        this.reusedInBytes = ApiTypeHelper.requireNonNull(builder.reusedInBytes, this, "reusedInBytes");
        this.total = builder.total;
        this.totalInBytes = ApiTypeHelper.requireNonNull(builder.totalInBytes, this, "totalInBytes");
    }

    public static RecoveryBytes of(Function<RecoveryBytes.Builder, ObjectBuilder<RecoveryBytes>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code percent}
     */
    @Nonnull
    public final String percent() {
        return this.percent;
    }

    /**
     * API name: {@code recovered}
     */
    @Nullable
    public final String recovered() {
        return this.recovered;
    }

    /**
     * API name: {@code recovered_from_snapshot}
     */
    @Nullable
    public final String recoveredFromSnapshot() {
        return this.recoveredFromSnapshot;
    }

    /**
     * API name: {@code recovered_from_snapshot_in_bytes}
     */
    @Nullable
    public final Long recoveredFromSnapshotInBytes() {
        return this.recoveredFromSnapshotInBytes;
    }

    /**
     * Required - API name: {@code recovered_in_bytes}
     */
    public final long recoveredInBytes() {
        return this.recoveredInBytes;
    }

    /**
     * API name: {@code reused}
     */
    @Nullable
    public final String reused() {
        return this.reused;
    }

    /**
     * Required - API name: {@code reused_in_bytes}
     */
    public final long reusedInBytes() {
        return this.reusedInBytes;
    }

    /**
     * API name: {@code total}
     */
    @Nullable
    public final String total() {
        return this.total;
    }

    /**
     * Required - API name: {@code total_in_bytes}
     */
    public final long totalInBytes() {
        return this.totalInBytes;
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
        generator.writeKey("percent");
        generator.write(this.percent);

        if (this.recovered != null) {
            generator.writeKey("recovered");
            generator.write(this.recovered);
        }

        if (this.recoveredFromSnapshot != null) {
            generator.writeKey("recovered_from_snapshot");
            generator.write(this.recoveredFromSnapshot);
        }

        if (this.recoveredFromSnapshotInBytes != null) {
            generator.writeKey("recovered_from_snapshot_in_bytes");
            generator.write(this.recoveredFromSnapshotInBytes);
        }

        generator.writeKey("recovered_in_bytes");
        generator.write(this.recoveredInBytes);

        if (this.reused != null) {
            generator.writeKey("reused");
            generator.write(this.reused);
        }

        generator.writeKey("reused_in_bytes");
        generator.write(this.reusedInBytes);

        if (this.total != null) {
            generator.writeKey("total");
            generator.write(this.total);
        }

        generator.writeKey("total_in_bytes");
        generator.write(this.totalInBytes);
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
     * Builder for {@link RecoveryBytes}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, RecoveryBytes> {
        private String percent;
        @Nullable
        private String recovered;
        @Nullable
        private String recoveredFromSnapshot;
        @Nullable
        private Long recoveredFromSnapshotInBytes;
        private Long recoveredInBytes;
        @Nullable
        private String reused;
        private Long reusedInBytes;
        @Nullable
        private String total;
        private Long totalInBytes;

        public Builder() {}

        private Builder(RecoveryBytes o) {
            this.percent = o.percent;
            this.recovered = o.recovered;
            this.recoveredFromSnapshot = o.recoveredFromSnapshot;
            this.recoveredFromSnapshotInBytes = o.recoveredFromSnapshotInBytes;
            this.recoveredInBytes = o.recoveredInBytes;
            this.reused = o.reused;
            this.reusedInBytes = o.reusedInBytes;
            this.total = o.total;
            this.totalInBytes = o.totalInBytes;
        }

        private Builder(Builder o) {
            this.percent = o.percent;
            this.recovered = o.recovered;
            this.recoveredFromSnapshot = o.recoveredFromSnapshot;
            this.recoveredFromSnapshotInBytes = o.recoveredFromSnapshotInBytes;
            this.recoveredInBytes = o.recoveredInBytes;
            this.reused = o.reused;
            this.reusedInBytes = o.reusedInBytes;
            this.total = o.total;
            this.totalInBytes = o.totalInBytes;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - API name: {@code percent}
         */
        @Nonnull
        public final Builder percent(String value) {
            this.percent = value;
            return this;
        }

        /**
         * API name: {@code recovered}
         */
        @Nonnull
        public final Builder recovered(@Nullable String value) {
            this.recovered = value;
            return this;
        }

        /**
         * API name: {@code recovered_from_snapshot}
         */
        @Nonnull
        public final Builder recoveredFromSnapshot(@Nullable String value) {
            this.recoveredFromSnapshot = value;
            return this;
        }

        /**
         * API name: {@code recovered_from_snapshot_in_bytes}
         */
        @Nonnull
        public final Builder recoveredFromSnapshotInBytes(@Nullable Long value) {
            this.recoveredFromSnapshotInBytes = value;
            return this;
        }

        /**
         * Required - API name: {@code recovered_in_bytes}
         */
        @Nonnull
        public final Builder recoveredInBytes(long value) {
            this.recoveredInBytes = value;
            return this;
        }

        /**
         * API name: {@code reused}
         */
        @Nonnull
        public final Builder reused(@Nullable String value) {
            this.reused = value;
            return this;
        }

        /**
         * Required - API name: {@code reused_in_bytes}
         */
        @Nonnull
        public final Builder reusedInBytes(long value) {
            this.reusedInBytes = value;
            return this;
        }

        /**
         * API name: {@code total}
         */
        @Nonnull
        public final Builder total(@Nullable String value) {
            this.total = value;
            return this;
        }

        /**
         * Required - API name: {@code total_in_bytes}
         */
        @Nonnull
        public final Builder totalInBytes(long value) {
            this.totalInBytes = value;
            return this;
        }

        /**
         * Builds a {@link RecoveryBytes}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public RecoveryBytes build() {
            _checkSingleUse();

            return new RecoveryBytes(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link RecoveryBytes}
     */
    public static final JsonpDeserializer<RecoveryBytes> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        RecoveryBytes::setupRecoveryBytesDeserializer
    );

    protected static void setupRecoveryBytesDeserializer(ObjectDeserializer<RecoveryBytes.Builder> op) {
        op.add(Builder::percent, JsonpDeserializer.stringDeserializer(), "percent");
        op.add(Builder::recovered, JsonpDeserializer.stringDeserializer(), "recovered");
        op.add(Builder::recoveredFromSnapshot, JsonpDeserializer.stringDeserializer(), "recovered_from_snapshot");
        op.add(Builder::recoveredFromSnapshotInBytes, JsonpDeserializer.longDeserializer(), "recovered_from_snapshot_in_bytes");
        op.add(Builder::recoveredInBytes, JsonpDeserializer.longDeserializer(), "recovered_in_bytes");
        op.add(Builder::reused, JsonpDeserializer.stringDeserializer(), "reused");
        op.add(Builder::reusedInBytes, JsonpDeserializer.longDeserializer(), "reused_in_bytes");
        op.add(Builder::total, JsonpDeserializer.stringDeserializer(), "total");
        op.add(Builder::totalInBytes, JsonpDeserializer.longDeserializer(), "total_in_bytes");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.percent.hashCode();
        result = 31 * result + Objects.hashCode(this.recovered);
        result = 31 * result + Objects.hashCode(this.recoveredFromSnapshot);
        result = 31 * result + Objects.hashCode(this.recoveredFromSnapshotInBytes);
        result = 31 * result + Long.hashCode(this.recoveredInBytes);
        result = 31 * result + Objects.hashCode(this.reused);
        result = 31 * result + Long.hashCode(this.reusedInBytes);
        result = 31 * result + Objects.hashCode(this.total);
        result = 31 * result + Long.hashCode(this.totalInBytes);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        RecoveryBytes other = (RecoveryBytes) o;
        return this.percent.equals(other.percent)
            && Objects.equals(this.recovered, other.recovered)
            && Objects.equals(this.recoveredFromSnapshot, other.recoveredFromSnapshot)
            && Objects.equals(this.recoveredFromSnapshotInBytes, other.recoveredFromSnapshotInBytes)
            && this.recoveredInBytes == other.recoveredInBytes
            && Objects.equals(this.reused, other.reused)
            && this.reusedInBytes == other.reusedInBytes
            && Objects.equals(this.total, other.total)
            && this.totalInBytes == other.totalInBytes;
    }
}
