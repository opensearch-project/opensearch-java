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

// typedef: _types.RemoteStoreTranslogUploadTotalUploadSizeStats

/**
 * The total amount of data uploaded to the remote translog store.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class RemoteStoreTranslogUploadTotalUploadSizeStats
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<RemoteStoreTranslogUploadTotalUploadSizeStats.Builder, RemoteStoreTranslogUploadTotalUploadSizeStats> {

    @Nullable
    private final String failed;

    private final long failedBytes;

    @Nullable
    private final String started;

    private final long startedBytes;

    @Nullable
    private final String succeeded;

    private final long succeededBytes;

    // ---------------------------------------------------------------------------------------------

    private RemoteStoreTranslogUploadTotalUploadSizeStats(Builder builder) {
        this.failed = builder.failed;
        this.failedBytes = ApiTypeHelper.requireNonNull(builder.failedBytes, this, "failedBytes");
        this.started = builder.started;
        this.startedBytes = ApiTypeHelper.requireNonNull(builder.startedBytes, this, "startedBytes");
        this.succeeded = builder.succeeded;
        this.succeededBytes = ApiTypeHelper.requireNonNull(builder.succeededBytes, this, "succeededBytes");
    }

    public static RemoteStoreTranslogUploadTotalUploadSizeStats of(
        Function<RemoteStoreTranslogUploadTotalUploadSizeStats.Builder, ObjectBuilder<RemoteStoreTranslogUploadTotalUploadSizeStats>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * The number of bytes that failed to upload to the remote translog store.
     * <p>
     * API name: {@code failed}
     * </p>
     */
    @Nullable
    public final String failed() {
        return this.failed;
    }

    /**
     * Required - The number of bytes that failed to upload to the remote translog store.
     * <p>
     * API name: {@code failed_bytes}
     * </p>
     */
    public final long failedBytes() {
        return this.failedBytes;
    }

    /**
     * The number of bytes successfully uploaded to the remote translog store.
     * <p>
     * API name: {@code started}
     * </p>
     */
    @Nullable
    public final String started() {
        return this.started;
    }

    /**
     * Required - The number of bytes successfully uploaded to the remote translog store.
     * <p>
     * API name: {@code started_bytes}
     * </p>
     */
    public final long startedBytes() {
        return this.startedBytes;
    }

    /**
     * The number of bytes successfully uploaded to the remote translog store.
     * <p>
     * API name: {@code succeeded}
     * </p>
     */
    @Nullable
    public final String succeeded() {
        return this.succeeded;
    }

    /**
     * Required - The number of bytes successfully uploaded to the remote translog store.
     * <p>
     * API name: {@code succeeded_bytes}
     * </p>
     */
    public final long succeededBytes() {
        return this.succeededBytes;
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
        if (this.failed != null) {
            generator.writeKey("failed");
            generator.write(this.failed);
        }

        generator.writeKey("failed_bytes");
        generator.write(this.failedBytes);

        if (this.started != null) {
            generator.writeKey("started");
            generator.write(this.started);
        }

        generator.writeKey("started_bytes");
        generator.write(this.startedBytes);

        if (this.succeeded != null) {
            generator.writeKey("succeeded");
            generator.write(this.succeeded);
        }

        generator.writeKey("succeeded_bytes");
        generator.write(this.succeededBytes);
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
     * Builder for {@link RemoteStoreTranslogUploadTotalUploadSizeStats}.
     */
    public static class Builder extends ObjectBuilderBase
        implements
            CopyableBuilder<Builder, RemoteStoreTranslogUploadTotalUploadSizeStats> {
        @Nullable
        private String failed;
        private Long failedBytes;
        @Nullable
        private String started;
        private Long startedBytes;
        @Nullable
        private String succeeded;
        private Long succeededBytes;

        public Builder() {}

        private Builder(RemoteStoreTranslogUploadTotalUploadSizeStats o) {
            this.failed = o.failed;
            this.failedBytes = o.failedBytes;
            this.started = o.started;
            this.startedBytes = o.startedBytes;
            this.succeeded = o.succeeded;
            this.succeededBytes = o.succeededBytes;
        }

        private Builder(Builder o) {
            this.failed = o.failed;
            this.failedBytes = o.failedBytes;
            this.started = o.started;
            this.startedBytes = o.startedBytes;
            this.succeeded = o.succeeded;
            this.succeededBytes = o.succeededBytes;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * The number of bytes that failed to upload to the remote translog store.
         * <p>
         * API name: {@code failed}
         * </p>
         */
        @Nonnull
        public final Builder failed(@Nullable String value) {
            this.failed = value;
            return this;
        }

        /**
         * Required - The number of bytes that failed to upload to the remote translog store.
         * <p>
         * API name: {@code failed_bytes}
         * </p>
         */
        @Nonnull
        public final Builder failedBytes(long value) {
            this.failedBytes = value;
            return this;
        }

        /**
         * The number of bytes successfully uploaded to the remote translog store.
         * <p>
         * API name: {@code started}
         * </p>
         */
        @Nonnull
        public final Builder started(@Nullable String value) {
            this.started = value;
            return this;
        }

        /**
         * Required - The number of bytes successfully uploaded to the remote translog store.
         * <p>
         * API name: {@code started_bytes}
         * </p>
         */
        @Nonnull
        public final Builder startedBytes(long value) {
            this.startedBytes = value;
            return this;
        }

        /**
         * The number of bytes successfully uploaded to the remote translog store.
         * <p>
         * API name: {@code succeeded}
         * </p>
         */
        @Nonnull
        public final Builder succeeded(@Nullable String value) {
            this.succeeded = value;
            return this;
        }

        /**
         * Required - The number of bytes successfully uploaded to the remote translog store.
         * <p>
         * API name: {@code succeeded_bytes}
         * </p>
         */
        @Nonnull
        public final Builder succeededBytes(long value) {
            this.succeededBytes = value;
            return this;
        }

        /**
         * Builds a {@link RemoteStoreTranslogUploadTotalUploadSizeStats}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public RemoteStoreTranslogUploadTotalUploadSizeStats build() {
            _checkSingleUse();

            return new RemoteStoreTranslogUploadTotalUploadSizeStats(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link RemoteStoreTranslogUploadTotalUploadSizeStats}
     */
    public static final JsonpDeserializer<RemoteStoreTranslogUploadTotalUploadSizeStats> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        RemoteStoreTranslogUploadTotalUploadSizeStats::setupRemoteStoreTranslogUploadTotalUploadSizeStatsDeserializer
    );

    protected static void setupRemoteStoreTranslogUploadTotalUploadSizeStatsDeserializer(
        ObjectDeserializer<RemoteStoreTranslogUploadTotalUploadSizeStats.Builder> op
    ) {
        op.add(Builder::failed, JsonpDeserializer.stringDeserializer(), "failed");
        op.add(Builder::failedBytes, JsonpDeserializer.longDeserializer(), "failed_bytes");
        op.add(Builder::started, JsonpDeserializer.stringDeserializer(), "started");
        op.add(Builder::startedBytes, JsonpDeserializer.longDeserializer(), "started_bytes");
        op.add(Builder::succeeded, JsonpDeserializer.stringDeserializer(), "succeeded");
        op.add(Builder::succeededBytes, JsonpDeserializer.longDeserializer(), "succeeded_bytes");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.failed);
        result = 31 * result + Long.hashCode(this.failedBytes);
        result = 31 * result + Objects.hashCode(this.started);
        result = 31 * result + Long.hashCode(this.startedBytes);
        result = 31 * result + Objects.hashCode(this.succeeded);
        result = 31 * result + Long.hashCode(this.succeededBytes);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        RemoteStoreTranslogUploadTotalUploadSizeStats other = (RemoteStoreTranslogUploadTotalUploadSizeStats) o;
        return Objects.equals(this.failed, other.failed)
            && this.failedBytes == other.failedBytes
            && Objects.equals(this.started, other.started)
            && this.startedBytes == other.startedBytes
            && Objects.equals(this.succeeded, other.succeeded)
            && this.succeededBytes == other.succeededBytes;
    }
}
