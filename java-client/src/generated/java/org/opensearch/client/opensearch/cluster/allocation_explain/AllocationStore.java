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

package org.opensearch.client.opensearch.cluster.allocation_explain;

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
import org.opensearch.client.opensearch._types.ErrorCause;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: cluster.allocation_explain.AllocationStore

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class AllocationStore implements PlainJsonSerializable, ToCopyableBuilder<AllocationStore.Builder, AllocationStore> {

    @Nonnull
    private final String allocationId;

    private final boolean found;

    private final boolean inSync;

    private final long matchingSizeInBytes;

    private final boolean matchingSyncId;

    @Nullable
    private final ErrorCause storeException;

    // ---------------------------------------------------------------------------------------------

    private AllocationStore(Builder builder) {
        this.allocationId = ApiTypeHelper.requireNonNull(builder.allocationId, this, "allocationId");
        this.found = ApiTypeHelper.requireNonNull(builder.found, this, "found");
        this.inSync = ApiTypeHelper.requireNonNull(builder.inSync, this, "inSync");
        this.matchingSizeInBytes = ApiTypeHelper.requireNonNull(builder.matchingSizeInBytes, this, "matchingSizeInBytes");
        this.matchingSyncId = ApiTypeHelper.requireNonNull(builder.matchingSyncId, this, "matchingSyncId");
        this.storeException = builder.storeException;
    }

    public static AllocationStore of(Function<AllocationStore.Builder, ObjectBuilder<AllocationStore>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code allocation_id}
     */
    @Nonnull
    public final String allocationId() {
        return this.allocationId;
    }

    /**
     * Required - API name: {@code found}
     */
    public final boolean found() {
        return this.found;
    }

    /**
     * Required - API name: {@code in_sync}
     */
    public final boolean inSync() {
        return this.inSync;
    }

    /**
     * Required - API name: {@code matching_size_in_bytes}
     */
    public final long matchingSizeInBytes() {
        return this.matchingSizeInBytes;
    }

    /**
     * Required - API name: {@code matching_sync_id}
     */
    public final boolean matchingSyncId() {
        return this.matchingSyncId;
    }

    /**
     * The exception raised when the node failed to open the shard's on-disk index.
     * <p>
     * API name: {@code store_exception}
     * </p>
     */
    @Nullable
    public final ErrorCause storeException() {
        return this.storeException;
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
        generator.writeKey("allocation_id");
        generator.write(this.allocationId);

        generator.writeKey("found");
        generator.write(this.found);

        generator.writeKey("in_sync");
        generator.write(this.inSync);

        generator.writeKey("matching_size_in_bytes");
        generator.write(this.matchingSizeInBytes);

        generator.writeKey("matching_sync_id");
        generator.write(this.matchingSyncId);

        if (this.storeException != null) {
            generator.writeKey("store_exception");
            this.storeException.serialize(generator, mapper);
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
     * Builder for {@link AllocationStore}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, AllocationStore> {
        private String allocationId;
        private Boolean found;
        private Boolean inSync;
        private Long matchingSizeInBytes;
        private Boolean matchingSyncId;
        @Nullable
        private ErrorCause storeException;

        public Builder() {}

        private Builder(AllocationStore o) {
            this.allocationId = o.allocationId;
            this.found = o.found;
            this.inSync = o.inSync;
            this.matchingSizeInBytes = o.matchingSizeInBytes;
            this.matchingSyncId = o.matchingSyncId;
            this.storeException = o.storeException;
        }

        private Builder(Builder o) {
            this.allocationId = o.allocationId;
            this.found = o.found;
            this.inSync = o.inSync;
            this.matchingSizeInBytes = o.matchingSizeInBytes;
            this.matchingSyncId = o.matchingSyncId;
            this.storeException = o.storeException;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - API name: {@code allocation_id}
         */
        @Nonnull
        public final Builder allocationId(String value) {
            this.allocationId = value;
            return this;
        }

        /**
         * Required - API name: {@code found}
         */
        @Nonnull
        public final Builder found(boolean value) {
            this.found = value;
            return this;
        }

        /**
         * Required - API name: {@code in_sync}
         */
        @Nonnull
        public final Builder inSync(boolean value) {
            this.inSync = value;
            return this;
        }

        /**
         * Required - API name: {@code matching_size_in_bytes}
         */
        @Nonnull
        public final Builder matchingSizeInBytes(long value) {
            this.matchingSizeInBytes = value;
            return this;
        }

        /**
         * Required - API name: {@code matching_sync_id}
         */
        @Nonnull
        public final Builder matchingSyncId(boolean value) {
            this.matchingSyncId = value;
            return this;
        }

        /**
         * The exception raised when the node failed to open the shard's on-disk index.
         * <p>
         * API name: {@code store_exception}
         * </p>
         */
        @Nonnull
        public final Builder storeException(@Nullable ErrorCause value) {
            this.storeException = value;
            return this;
        }

        /**
         * The exception raised when the node failed to open the shard's on-disk index.
         * <p>
         * API name: {@code store_exception}
         * </p>
         */
        @Nonnull
        public final Builder storeException(Function<ErrorCause.Builder, ObjectBuilder<ErrorCause>> fn) {
            return storeException(fn.apply(new ErrorCause.Builder()).build());
        }

        /**
         * Builds a {@link AllocationStore}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public AllocationStore build() {
            _checkSingleUse();

            return new AllocationStore(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link AllocationStore}
     */
    public static final JsonpDeserializer<AllocationStore> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        AllocationStore::setupAllocationStoreDeserializer
    );

    protected static void setupAllocationStoreDeserializer(ObjectDeserializer<AllocationStore.Builder> op) {
        op.add(Builder::allocationId, JsonpDeserializer.stringDeserializer(), "allocation_id");
        op.add(Builder::found, JsonpDeserializer.booleanDeserializer(), "found");
        op.add(Builder::inSync, JsonpDeserializer.booleanDeserializer(), "in_sync");
        op.add(Builder::matchingSizeInBytes, JsonpDeserializer.longDeserializer(), "matching_size_in_bytes");
        op.add(Builder::matchingSyncId, JsonpDeserializer.booleanDeserializer(), "matching_sync_id");
        op.add(Builder::storeException, ErrorCause._DESERIALIZER, "store_exception");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.allocationId.hashCode();
        result = 31 * result + Boolean.hashCode(this.found);
        result = 31 * result + Boolean.hashCode(this.inSync);
        result = 31 * result + Long.hashCode(this.matchingSizeInBytes);
        result = 31 * result + Boolean.hashCode(this.matchingSyncId);
        result = 31 * result + Objects.hashCode(this.storeException);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        AllocationStore other = (AllocationStore) o;
        return this.allocationId.equals(other.allocationId)
            && this.found == other.found
            && this.inSync == other.inSync
            && this.matchingSizeInBytes == other.matchingSizeInBytes
            && this.matchingSyncId == other.matchingSyncId
            && Objects.equals(this.storeException, other.storeException);
    }
}
