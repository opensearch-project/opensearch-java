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

// typedef: _types.RemoteStoreTranslogUploadTotalUploadsStats

/**
 * The number of syncs to the remote translog store.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class RemoteStoreTranslogUploadTotalUploadsStats
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<RemoteStoreTranslogUploadTotalUploadsStats.Builder, RemoteStoreTranslogUploadTotalUploadsStats> {

    private final long failed;

    private final long started;

    private final long succeeded;

    // ---------------------------------------------------------------------------------------------

    private RemoteStoreTranslogUploadTotalUploadsStats(Builder builder) {
        this.failed = ApiTypeHelper.requireNonNull(builder.failed, this, "failed");
        this.started = ApiTypeHelper.requireNonNull(builder.started, this, "started");
        this.succeeded = ApiTypeHelper.requireNonNull(builder.succeeded, this, "succeeded");
    }

    public static RemoteStoreTranslogUploadTotalUploadsStats of(
        Function<RemoteStoreTranslogUploadTotalUploadsStats.Builder, ObjectBuilder<RemoteStoreTranslogUploadTotalUploadsStats>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - The number of failed upload syncs to the remote translog store.
     * <p>
     * API name: {@code failed}
     * </p>
     */
    public final long failed() {
        return this.failed;
    }

    /**
     * Required - The number of upload syncs to the remote translog store that have started.
     * <p>
     * API name: {@code started}
     * </p>
     */
    public final long started() {
        return this.started;
    }

    /**
     * Required - The number of successful upload syncs to the remote translog store.
     * <p>
     * API name: {@code succeeded}
     * </p>
     */
    public final long succeeded() {
        return this.succeeded;
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
        generator.writeKey("failed");
        generator.write(this.failed);

        generator.writeKey("started");
        generator.write(this.started);

        generator.writeKey("succeeded");
        generator.write(this.succeeded);
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
     * Builder for {@link RemoteStoreTranslogUploadTotalUploadsStats}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, RemoteStoreTranslogUploadTotalUploadsStats> {
        private Long failed;
        private Long started;
        private Long succeeded;

        public Builder() {}

        private Builder(RemoteStoreTranslogUploadTotalUploadsStats o) {
            this.failed = o.failed;
            this.started = o.started;
            this.succeeded = o.succeeded;
        }

        private Builder(Builder o) {
            this.failed = o.failed;
            this.started = o.started;
            this.succeeded = o.succeeded;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - The number of failed upload syncs to the remote translog store.
         * <p>
         * API name: {@code failed}
         * </p>
         */
        @Nonnull
        public final Builder failed(long value) {
            this.failed = value;
            return this;
        }

        /**
         * Required - The number of upload syncs to the remote translog store that have started.
         * <p>
         * API name: {@code started}
         * </p>
         */
        @Nonnull
        public final Builder started(long value) {
            this.started = value;
            return this;
        }

        /**
         * Required - The number of successful upload syncs to the remote translog store.
         * <p>
         * API name: {@code succeeded}
         * </p>
         */
        @Nonnull
        public final Builder succeeded(long value) {
            this.succeeded = value;
            return this;
        }

        /**
         * Builds a {@link RemoteStoreTranslogUploadTotalUploadsStats}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public RemoteStoreTranslogUploadTotalUploadsStats build() {
            _checkSingleUse();

            return new RemoteStoreTranslogUploadTotalUploadsStats(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link RemoteStoreTranslogUploadTotalUploadsStats}
     */
    public static final JsonpDeserializer<RemoteStoreTranslogUploadTotalUploadsStats> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        RemoteStoreTranslogUploadTotalUploadsStats::setupRemoteStoreTranslogUploadTotalUploadsStatsDeserializer
    );

    protected static void setupRemoteStoreTranslogUploadTotalUploadsStatsDeserializer(
        ObjectDeserializer<RemoteStoreTranslogUploadTotalUploadsStats.Builder> op
    ) {
        op.add(Builder::failed, JsonpDeserializer.longDeserializer(), "failed");
        op.add(Builder::started, JsonpDeserializer.longDeserializer(), "started");
        op.add(Builder::succeeded, JsonpDeserializer.longDeserializer(), "succeeded");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Long.hashCode(this.failed);
        result = 31 * result + Long.hashCode(this.started);
        result = 31 * result + Long.hashCode(this.succeeded);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        RemoteStoreTranslogUploadTotalUploadsStats other = (RemoteStoreTranslogUploadTotalUploadsStats) o;
        return this.failed == other.failed && this.started == other.started && this.succeeded == other.succeeded;
    }
}
