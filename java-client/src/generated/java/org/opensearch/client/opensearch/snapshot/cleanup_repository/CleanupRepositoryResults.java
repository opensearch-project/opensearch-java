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

package org.opensearch.client.opensearch.snapshot.cleanup_repository;

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

// typedef: snapshot.cleanup_repository.CleanupRepositoryResults

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class CleanupRepositoryResults
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<CleanupRepositoryResults.Builder, CleanupRepositoryResults> {

    private final long deletedBlobs;

    private final long deletedBytes;

    // ---------------------------------------------------------------------------------------------

    private CleanupRepositoryResults(Builder builder) {
        this.deletedBlobs = ApiTypeHelper.requireNonNull(builder.deletedBlobs, this, "deletedBlobs");
        this.deletedBytes = ApiTypeHelper.requireNonNull(builder.deletedBytes, this, "deletedBytes");
    }

    public static CleanupRepositoryResults of(Function<CleanupRepositoryResults.Builder, ObjectBuilder<CleanupRepositoryResults>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - Number of binary large objects (blobs) removed during cleanup.
     * <p>
     * API name: {@code deleted_blobs}
     * </p>
     */
    public final long deletedBlobs() {
        return this.deletedBlobs;
    }

    /**
     * Required - Number of bytes freed by cleanup operations.
     * <p>
     * API name: {@code deleted_bytes}
     * </p>
     */
    public final long deletedBytes() {
        return this.deletedBytes;
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
        generator.writeKey("deleted_blobs");
        generator.write(this.deletedBlobs);

        generator.writeKey("deleted_bytes");
        generator.write(this.deletedBytes);
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
     * Builder for {@link CleanupRepositoryResults}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, CleanupRepositoryResults> {
        private Long deletedBlobs;
        private Long deletedBytes;

        public Builder() {}

        private Builder(CleanupRepositoryResults o) {
            this.deletedBlobs = o.deletedBlobs;
            this.deletedBytes = o.deletedBytes;
        }

        private Builder(Builder o) {
            this.deletedBlobs = o.deletedBlobs;
            this.deletedBytes = o.deletedBytes;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - Number of binary large objects (blobs) removed during cleanup.
         * <p>
         * API name: {@code deleted_blobs}
         * </p>
         */
        @Nonnull
        public final Builder deletedBlobs(long value) {
            this.deletedBlobs = value;
            return this;
        }

        /**
         * Required - Number of bytes freed by cleanup operations.
         * <p>
         * API name: {@code deleted_bytes}
         * </p>
         */
        @Nonnull
        public final Builder deletedBytes(long value) {
            this.deletedBytes = value;
            return this;
        }

        /**
         * Builds a {@link CleanupRepositoryResults}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public CleanupRepositoryResults build() {
            _checkSingleUse();

            return new CleanupRepositoryResults(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link CleanupRepositoryResults}
     */
    public static final JsonpDeserializer<CleanupRepositoryResults> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        CleanupRepositoryResults::setupCleanupRepositoryResultsDeserializer
    );

    protected static void setupCleanupRepositoryResultsDeserializer(ObjectDeserializer<CleanupRepositoryResults.Builder> op) {
        op.add(Builder::deletedBlobs, JsonpDeserializer.longDeserializer(), "deleted_blobs");
        op.add(Builder::deletedBytes, JsonpDeserializer.longDeserializer(), "deleted_bytes");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Long.hashCode(this.deletedBlobs);
        result = 31 * result + Long.hashCode(this.deletedBytes);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        CleanupRepositoryResults other = (CleanupRepositoryResults) o;
        return this.deletedBlobs == other.deletedBlobs && this.deletedBytes == other.deletedBytes;
    }
}
