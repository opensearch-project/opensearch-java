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

// typedef: _types.RemoteStoreUploadRefreshSizeLagStats

/**
 * The amount of lag during upload between the remote segment store and the local store.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class RemoteStoreUploadRefreshSizeLagStats
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<RemoteStoreUploadRefreshSizeLagStats.Builder, RemoteStoreUploadRefreshSizeLagStats> {

    @Nullable
    private final String max;

    private final long maxBytes;

    @Nullable
    private final String total;

    private final long totalBytes;

    // ---------------------------------------------------------------------------------------------

    private RemoteStoreUploadRefreshSizeLagStats(Builder builder) {
        this.max = builder.max;
        this.maxBytes = ApiTypeHelper.requireNonNull(builder.maxBytes, this, "maxBytes");
        this.total = builder.total;
        this.totalBytes = ApiTypeHelper.requireNonNull(builder.totalBytes, this, "totalBytes");
    }

    public static RemoteStoreUploadRefreshSizeLagStats of(
        Function<RemoteStoreUploadRefreshSizeLagStats.Builder, ObjectBuilder<RemoteStoreUploadRefreshSizeLagStats>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * The maximum amount of lag, in bytes, during the upload refresh between the remote segment store and the local store.
     * <p>
     * API name: {@code max}
     * </p>
     */
    @Nullable
    public final String max() {
        return this.max;
    }

    /**
     * Required - The maximum amount of lag, in bytes, during the upload refresh between the remote segment store and the local store.
     * <p>
     * API name: {@code max_bytes}
     * </p>
     */
    public final long maxBytes() {
        return this.maxBytes;
    }

    /**
     * The total number of bytes that lagged during the upload refresh between the remote segment store and the local store.
     * <p>
     * API name: {@code total}
     * </p>
     */
    @Nullable
    public final String total() {
        return this.total;
    }

    /**
     * Required - The total number of bytes that lagged during the upload refresh between the remote segment store and the local store.
     * <p>
     * API name: {@code total_bytes}
     * </p>
     */
    public final long totalBytes() {
        return this.totalBytes;
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
        if (this.max != null) {
            generator.writeKey("max");
            generator.write(this.max);
        }

        generator.writeKey("max_bytes");
        generator.write(this.maxBytes);

        if (this.total != null) {
            generator.writeKey("total");
            generator.write(this.total);
        }

        generator.writeKey("total_bytes");
        generator.write(this.totalBytes);
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
     * Builder for {@link RemoteStoreUploadRefreshSizeLagStats}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, RemoteStoreUploadRefreshSizeLagStats> {
        @Nullable
        private String max;
        private Long maxBytes;
        @Nullable
        private String total;
        private Long totalBytes;

        public Builder() {}

        private Builder(RemoteStoreUploadRefreshSizeLagStats o) {
            this.max = o.max;
            this.maxBytes = o.maxBytes;
            this.total = o.total;
            this.totalBytes = o.totalBytes;
        }

        private Builder(Builder o) {
            this.max = o.max;
            this.maxBytes = o.maxBytes;
            this.total = o.total;
            this.totalBytes = o.totalBytes;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * The maximum amount of lag, in bytes, during the upload refresh between the remote segment store and the local store.
         * <p>
         * API name: {@code max}
         * </p>
         */
        @Nonnull
        public final Builder max(@Nullable String value) {
            this.max = value;
            return this;
        }

        /**
         * Required - The maximum amount of lag, in bytes, during the upload refresh between the remote segment store and the local store.
         * <p>
         * API name: {@code max_bytes}
         * </p>
         */
        @Nonnull
        public final Builder maxBytes(long value) {
            this.maxBytes = value;
            return this;
        }

        /**
         * The total number of bytes that lagged during the upload refresh between the remote segment store and the local store.
         * <p>
         * API name: {@code total}
         * </p>
         */
        @Nonnull
        public final Builder total(@Nullable String value) {
            this.total = value;
            return this;
        }

        /**
         * Required - The total number of bytes that lagged during the upload refresh between the remote segment store and the local store.
         * <p>
         * API name: {@code total_bytes}
         * </p>
         */
        @Nonnull
        public final Builder totalBytes(long value) {
            this.totalBytes = value;
            return this;
        }

        /**
         * Builds a {@link RemoteStoreUploadRefreshSizeLagStats}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public RemoteStoreUploadRefreshSizeLagStats build() {
            _checkSingleUse();

            return new RemoteStoreUploadRefreshSizeLagStats(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link RemoteStoreUploadRefreshSizeLagStats}
     */
    public static final JsonpDeserializer<RemoteStoreUploadRefreshSizeLagStats> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        RemoteStoreUploadRefreshSizeLagStats::setupRemoteStoreUploadRefreshSizeLagStatsDeserializer
    );

    protected static void setupRemoteStoreUploadRefreshSizeLagStatsDeserializer(
        ObjectDeserializer<RemoteStoreUploadRefreshSizeLagStats.Builder> op
    ) {
        op.add(Builder::max, JsonpDeserializer.stringDeserializer(), "max");
        op.add(Builder::maxBytes, JsonpDeserializer.longDeserializer(), "max_bytes");
        op.add(Builder::total, JsonpDeserializer.stringDeserializer(), "total");
        op.add(Builder::totalBytes, JsonpDeserializer.longDeserializer(), "total_bytes");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.max);
        result = 31 * result + Long.hashCode(this.maxBytes);
        result = 31 * result + Objects.hashCode(this.total);
        result = 31 * result + Long.hashCode(this.totalBytes);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        RemoteStoreUploadRefreshSizeLagStats other = (RemoteStoreUploadRefreshSizeLagStats) o;
        return Objects.equals(this.max, other.max)
            && this.maxBytes == other.maxBytes
            && Objects.equals(this.total, other.total)
            && this.totalBytes == other.totalBytes;
    }
}
