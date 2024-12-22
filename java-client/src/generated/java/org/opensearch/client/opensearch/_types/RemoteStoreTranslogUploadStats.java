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
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
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

// typedef: _types.RemoteStoreTranslogUploadStats

/**
 * Statistics related to uploads to the remote translog store.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class RemoteStoreTranslogUploadStats
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<RemoteStoreTranslogUploadStats.Builder, RemoteStoreTranslogUploadStats> {

    @Nonnull
    private final RemoteStoreTranslogUploadTotalUploadSizeStats totalUploadSize;

    @Nonnull
    private final RemoteStoreTranslogUploadTotalUploadsStats totalUploads;

    // ---------------------------------------------------------------------------------------------

    private RemoteStoreTranslogUploadStats(Builder builder) {
        this.totalUploadSize = ApiTypeHelper.requireNonNull(builder.totalUploadSize, this, "totalUploadSize");
        this.totalUploads = ApiTypeHelper.requireNonNull(builder.totalUploads, this, "totalUploads");
    }

    public static RemoteStoreTranslogUploadStats of(
        Function<RemoteStoreTranslogUploadStats.Builder, ObjectBuilder<RemoteStoreTranslogUploadStats>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code total_upload_size}
     */
    @Nonnull
    public final RemoteStoreTranslogUploadTotalUploadSizeStats totalUploadSize() {
        return this.totalUploadSize;
    }

    /**
     * Required - API name: {@code total_uploads}
     */
    @Nonnull
    public final RemoteStoreTranslogUploadTotalUploadsStats totalUploads() {
        return this.totalUploads;
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
        generator.writeKey("total_upload_size");
        this.totalUploadSize.serialize(generator, mapper);

        generator.writeKey("total_uploads");
        this.totalUploads.serialize(generator, mapper);
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
     * Builder for {@link RemoteStoreTranslogUploadStats}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, RemoteStoreTranslogUploadStats> {
        private RemoteStoreTranslogUploadTotalUploadSizeStats totalUploadSize;
        private RemoteStoreTranslogUploadTotalUploadsStats totalUploads;

        public Builder() {}

        private Builder(RemoteStoreTranslogUploadStats o) {
            this.totalUploadSize = o.totalUploadSize;
            this.totalUploads = o.totalUploads;
        }

        private Builder(Builder o) {
            this.totalUploadSize = o.totalUploadSize;
            this.totalUploads = o.totalUploads;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - API name: {@code total_upload_size}
         */
        @Nonnull
        public final Builder totalUploadSize(RemoteStoreTranslogUploadTotalUploadSizeStats value) {
            this.totalUploadSize = value;
            return this;
        }

        /**
         * Required - API name: {@code total_upload_size}
         */
        @Nonnull
        public final Builder totalUploadSize(
            Function<RemoteStoreTranslogUploadTotalUploadSizeStats.Builder, ObjectBuilder<RemoteStoreTranslogUploadTotalUploadSizeStats>> fn
        ) {
            return totalUploadSize(fn.apply(new RemoteStoreTranslogUploadTotalUploadSizeStats.Builder()).build());
        }

        /**
         * Required - API name: {@code total_uploads}
         */
        @Nonnull
        public final Builder totalUploads(RemoteStoreTranslogUploadTotalUploadsStats value) {
            this.totalUploads = value;
            return this;
        }

        /**
         * Required - API name: {@code total_uploads}
         */
        @Nonnull
        public final Builder totalUploads(
            Function<RemoteStoreTranslogUploadTotalUploadsStats.Builder, ObjectBuilder<RemoteStoreTranslogUploadTotalUploadsStats>> fn
        ) {
            return totalUploads(fn.apply(new RemoteStoreTranslogUploadTotalUploadsStats.Builder()).build());
        }

        /**
         * Builds a {@link RemoteStoreTranslogUploadStats}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public RemoteStoreTranslogUploadStats build() {
            _checkSingleUse();

            return new RemoteStoreTranslogUploadStats(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link RemoteStoreTranslogUploadStats}
     */
    public static final JsonpDeserializer<RemoteStoreTranslogUploadStats> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        RemoteStoreTranslogUploadStats::setupRemoteStoreTranslogUploadStatsDeserializer
    );

    protected static void setupRemoteStoreTranslogUploadStatsDeserializer(ObjectDeserializer<RemoteStoreTranslogUploadStats.Builder> op) {
        op.add(Builder::totalUploadSize, RemoteStoreTranslogUploadTotalUploadSizeStats._DESERIALIZER, "total_upload_size");
        op.add(Builder::totalUploads, RemoteStoreTranslogUploadTotalUploadsStats._DESERIALIZER, "total_uploads");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.totalUploadSize.hashCode();
        result = 31 * result + this.totalUploads.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        RemoteStoreTranslogUploadStats other = (RemoteStoreTranslogUploadStats) o;
        return this.totalUploadSize.equals(other.totalUploadSize) && this.totalUploads.equals(other.totalUploads);
    }
}
