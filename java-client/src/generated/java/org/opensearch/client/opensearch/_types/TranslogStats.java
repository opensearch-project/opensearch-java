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

package org.opensearch.client.opensearch._types;

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

// typedef: _types.TranslogStats

/**
 * The statistics about translog operations.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class TranslogStats implements PlainJsonSerializable, ToCopyableBuilder<TranslogStats.Builder, TranslogStats> {

    private final long earliestLastModifiedAge;

    private final int operations;

    @Nullable
    private final RemoteStoreTranslogStats remoteStore;

    @Nullable
    private final String size;

    private final long sizeInBytes;

    private final int uncommittedOperations;

    @Nullable
    private final String uncommittedSize;

    private final long uncommittedSizeInBytes;

    // ---------------------------------------------------------------------------------------------

    private TranslogStats(Builder builder) {
        this.earliestLastModifiedAge = ApiTypeHelper.requireNonNull(builder.earliestLastModifiedAge, this, "earliestLastModifiedAge");
        this.operations = ApiTypeHelper.requireNonNull(builder.operations, this, "operations");
        this.remoteStore = builder.remoteStore;
        this.size = builder.size;
        this.sizeInBytes = ApiTypeHelper.requireNonNull(builder.sizeInBytes, this, "sizeInBytes");
        this.uncommittedOperations = ApiTypeHelper.requireNonNull(builder.uncommittedOperations, this, "uncommittedOperations");
        this.uncommittedSize = builder.uncommittedSize;
        this.uncommittedSizeInBytes = ApiTypeHelper.requireNonNull(builder.uncommittedSizeInBytes, this, "uncommittedSizeInBytes");
    }

    public static TranslogStats of(Function<TranslogStats.Builder, ObjectBuilder<TranslogStats>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - The age of the oldest translog entry.
     * <p>
     * API name: {@code earliest_last_modified_age}
     * </p>
     */
    public final long earliestLastModifiedAge() {
        return this.earliestLastModifiedAge;
    }

    /**
     * Required - The number of operations in the translog.
     * <p>
     * API name: {@code operations}
     * </p>
     */
    public final int operations() {
        return this.operations;
    }

    /**
     * API name: {@code remote_store}
     */
    @Nullable
    public final RemoteStoreTranslogStats remoteStore() {
        return this.remoteStore;
    }

    /**
     * The size of the translog in a human-readable format.
     * <p>
     * API name: {@code size}
     * </p>
     */
    @Nullable
    public final String size() {
        return this.size;
    }

    /**
     * Required - The size of the translog in bytes.
     * <p>
     * API name: {@code size_in_bytes}
     * </p>
     */
    public final long sizeInBytes() {
        return this.sizeInBytes;
    }

    /**
     * Required - The number of uncommitted operations in the translog.
     * <p>
     * API name: {@code uncommitted_operations}
     * </p>
     */
    public final int uncommittedOperations() {
        return this.uncommittedOperations;
    }

    /**
     * The size of uncommitted operations in a human-readable format.
     * <p>
     * API name: {@code uncommitted_size}
     * </p>
     */
    @Nullable
    public final String uncommittedSize() {
        return this.uncommittedSize;
    }

    /**
     * Required - The size of uncommitted operations in bytes.
     * <p>
     * API name: {@code uncommitted_size_in_bytes}
     * </p>
     */
    public final long uncommittedSizeInBytes() {
        return this.uncommittedSizeInBytes;
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
        generator.writeKey("earliest_last_modified_age");
        generator.write(this.earliestLastModifiedAge);

        generator.writeKey("operations");
        generator.write(this.operations);

        if (this.remoteStore != null) {
            generator.writeKey("remote_store");
            this.remoteStore.serialize(generator, mapper);
        }

        if (this.size != null) {
            generator.writeKey("size");
            generator.write(this.size);
        }

        generator.writeKey("size_in_bytes");
        generator.write(this.sizeInBytes);

        generator.writeKey("uncommitted_operations");
        generator.write(this.uncommittedOperations);

        if (this.uncommittedSize != null) {
            generator.writeKey("uncommitted_size");
            generator.write(this.uncommittedSize);
        }

        generator.writeKey("uncommitted_size_in_bytes");
        generator.write(this.uncommittedSizeInBytes);
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
     * Builder for {@link TranslogStats}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, TranslogStats> {
        private Long earliestLastModifiedAge;
        private Integer operations;
        @Nullable
        private RemoteStoreTranslogStats remoteStore;
        @Nullable
        private String size;
        private Long sizeInBytes;
        private Integer uncommittedOperations;
        @Nullable
        private String uncommittedSize;
        private Long uncommittedSizeInBytes;

        public Builder() {}

        private Builder(TranslogStats o) {
            this.earliestLastModifiedAge = o.earliestLastModifiedAge;
            this.operations = o.operations;
            this.remoteStore = o.remoteStore;
            this.size = o.size;
            this.sizeInBytes = o.sizeInBytes;
            this.uncommittedOperations = o.uncommittedOperations;
            this.uncommittedSize = o.uncommittedSize;
            this.uncommittedSizeInBytes = o.uncommittedSizeInBytes;
        }

        private Builder(Builder o) {
            this.earliestLastModifiedAge = o.earliestLastModifiedAge;
            this.operations = o.operations;
            this.remoteStore = o.remoteStore;
            this.size = o.size;
            this.sizeInBytes = o.sizeInBytes;
            this.uncommittedOperations = o.uncommittedOperations;
            this.uncommittedSize = o.uncommittedSize;
            this.uncommittedSizeInBytes = o.uncommittedSizeInBytes;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - The age of the oldest translog entry.
         * <p>
         * API name: {@code earliest_last_modified_age}
         * </p>
         */
        @Nonnull
        public final Builder earliestLastModifiedAge(long value) {
            this.earliestLastModifiedAge = value;
            return this;
        }

        /**
         * Required - The number of operations in the translog.
         * <p>
         * API name: {@code operations}
         * </p>
         */
        @Nonnull
        public final Builder operations(int value) {
            this.operations = value;
            return this;
        }

        /**
         * API name: {@code remote_store}
         */
        @Nonnull
        public final Builder remoteStore(@Nullable RemoteStoreTranslogStats value) {
            this.remoteStore = value;
            return this;
        }

        /**
         * API name: {@code remote_store}
         */
        @Nonnull
        public final Builder remoteStore(Function<RemoteStoreTranslogStats.Builder, ObjectBuilder<RemoteStoreTranslogStats>> fn) {
            return remoteStore(fn.apply(new RemoteStoreTranslogStats.Builder()).build());
        }

        /**
         * The size of the translog in a human-readable format.
         * <p>
         * API name: {@code size}
         * </p>
         */
        @Nonnull
        public final Builder size(@Nullable String value) {
            this.size = value;
            return this;
        }

        /**
         * Required - The size of the translog in bytes.
         * <p>
         * API name: {@code size_in_bytes}
         * </p>
         */
        @Nonnull
        public final Builder sizeInBytes(long value) {
            this.sizeInBytes = value;
            return this;
        }

        /**
         * Required - The number of uncommitted operations in the translog.
         * <p>
         * API name: {@code uncommitted_operations}
         * </p>
         */
        @Nonnull
        public final Builder uncommittedOperations(int value) {
            this.uncommittedOperations = value;
            return this;
        }

        /**
         * The size of uncommitted operations in a human-readable format.
         * <p>
         * API name: {@code uncommitted_size}
         * </p>
         */
        @Nonnull
        public final Builder uncommittedSize(@Nullable String value) {
            this.uncommittedSize = value;
            return this;
        }

        /**
         * Required - The size of uncommitted operations in bytes.
         * <p>
         * API name: {@code uncommitted_size_in_bytes}
         * </p>
         */
        @Nonnull
        public final Builder uncommittedSizeInBytes(long value) {
            this.uncommittedSizeInBytes = value;
            return this;
        }

        /**
         * Builds a {@link TranslogStats}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public TranslogStats build() {
            _checkSingleUse();

            return new TranslogStats(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link TranslogStats}
     */
    public static final JsonpDeserializer<TranslogStats> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        TranslogStats::setupTranslogStatsDeserializer
    );

    protected static void setupTranslogStatsDeserializer(ObjectDeserializer<TranslogStats.Builder> op) {
        op.add(Builder::earliestLastModifiedAge, JsonpDeserializer.longDeserializer(), "earliest_last_modified_age");
        op.add(Builder::operations, JsonpDeserializer.integerDeserializer(), "operations");
        op.add(Builder::remoteStore, RemoteStoreTranslogStats._DESERIALIZER, "remote_store");
        op.add(Builder::size, JsonpDeserializer.stringDeserializer(), "size");
        op.add(Builder::sizeInBytes, JsonpDeserializer.longDeserializer(), "size_in_bytes");
        op.add(Builder::uncommittedOperations, JsonpDeserializer.integerDeserializer(), "uncommitted_operations");
        op.add(Builder::uncommittedSize, JsonpDeserializer.stringDeserializer(), "uncommitted_size");
        op.add(Builder::uncommittedSizeInBytes, JsonpDeserializer.longDeserializer(), "uncommitted_size_in_bytes");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Long.hashCode(this.earliestLastModifiedAge);
        result = 31 * result + Integer.hashCode(this.operations);
        result = 31 * result + Objects.hashCode(this.remoteStore);
        result = 31 * result + Objects.hashCode(this.size);
        result = 31 * result + Long.hashCode(this.sizeInBytes);
        result = 31 * result + Integer.hashCode(this.uncommittedOperations);
        result = 31 * result + Objects.hashCode(this.uncommittedSize);
        result = 31 * result + Long.hashCode(this.uncommittedSizeInBytes);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        TranslogStats other = (TranslogStats) o;
        return this.earliestLastModifiedAge == other.earliestLastModifiedAge
            && this.operations == other.operations
            && Objects.equals(this.remoteStore, other.remoteStore)
            && Objects.equals(this.size, other.size)
            && this.sizeInBytes == other.sizeInBytes
            && this.uncommittedOperations == other.uncommittedOperations
            && Objects.equals(this.uncommittedSize, other.uncommittedSize)
            && this.uncommittedSizeInBytes == other.uncommittedSizeInBytes;
    }
}
