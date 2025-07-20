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

package org.opensearch.client.opensearch.knn;

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

// typedef: knn.RemoteVectorIndexBuildStatsDetails

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class RemoteVectorIndexBuildStatsDetails
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<RemoteVectorIndexBuildStatsDetails.Builder, RemoteVectorIndexBuildStatsDetails> {

    @Nullable
    private final Long remoteIndexBuildCurrentFlushOperations;

    @Nullable
    private final Long remoteIndexBuildCurrentFlushSize;

    @Nullable
    private final Long remoteIndexBuildCurrentMergeOperations;

    @Nullable
    private final Long remoteIndexBuildCurrentMergeSize;

    @Nullable
    private final Long remoteIndexBuildFlushTimeInMillis;

    @Nullable
    private final Long remoteIndexBuildMergeTimeInMillis;

    // ---------------------------------------------------------------------------------------------

    private RemoteVectorIndexBuildStatsDetails(Builder builder) {
        this.remoteIndexBuildCurrentFlushOperations = builder.remoteIndexBuildCurrentFlushOperations;
        this.remoteIndexBuildCurrentFlushSize = builder.remoteIndexBuildCurrentFlushSize;
        this.remoteIndexBuildCurrentMergeOperations = builder.remoteIndexBuildCurrentMergeOperations;
        this.remoteIndexBuildCurrentMergeSize = builder.remoteIndexBuildCurrentMergeSize;
        this.remoteIndexBuildFlushTimeInMillis = builder.remoteIndexBuildFlushTimeInMillis;
        this.remoteIndexBuildMergeTimeInMillis = builder.remoteIndexBuildMergeTimeInMillis;
    }

    public static RemoteVectorIndexBuildStatsDetails of(
        Function<RemoteVectorIndexBuildStatsDetails.Builder, ObjectBuilder<RemoteVectorIndexBuildStatsDetails>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code remote_index_build_current_flush_operations}
     */
    @Nullable
    public final Long remoteIndexBuildCurrentFlushOperations() {
        return this.remoteIndexBuildCurrentFlushOperations;
    }

    /**
     * API name: {@code remote_index_build_current_flush_size}
     */
    @Nullable
    public final Long remoteIndexBuildCurrentFlushSize() {
        return this.remoteIndexBuildCurrentFlushSize;
    }

    /**
     * API name: {@code remote_index_build_current_merge_operations}
     */
    @Nullable
    public final Long remoteIndexBuildCurrentMergeOperations() {
        return this.remoteIndexBuildCurrentMergeOperations;
    }

    /**
     * API name: {@code remote_index_build_current_merge_size}
     */
    @Nullable
    public final Long remoteIndexBuildCurrentMergeSize() {
        return this.remoteIndexBuildCurrentMergeSize;
    }

    /**
     * API name: {@code remote_index_build_flush_time_in_millis}
     */
    @Nullable
    public final Long remoteIndexBuildFlushTimeInMillis() {
        return this.remoteIndexBuildFlushTimeInMillis;
    }

    /**
     * API name: {@code remote_index_build_merge_time_in_millis}
     */
    @Nullable
    public final Long remoteIndexBuildMergeTimeInMillis() {
        return this.remoteIndexBuildMergeTimeInMillis;
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
        if (this.remoteIndexBuildCurrentFlushOperations != null) {
            generator.writeKey("remote_index_build_current_flush_operations");
            generator.write(this.remoteIndexBuildCurrentFlushOperations);
        }

        if (this.remoteIndexBuildCurrentFlushSize != null) {
            generator.writeKey("remote_index_build_current_flush_size");
            generator.write(this.remoteIndexBuildCurrentFlushSize);
        }

        if (this.remoteIndexBuildCurrentMergeOperations != null) {
            generator.writeKey("remote_index_build_current_merge_operations");
            generator.write(this.remoteIndexBuildCurrentMergeOperations);
        }

        if (this.remoteIndexBuildCurrentMergeSize != null) {
            generator.writeKey("remote_index_build_current_merge_size");
            generator.write(this.remoteIndexBuildCurrentMergeSize);
        }

        if (this.remoteIndexBuildFlushTimeInMillis != null) {
            generator.writeKey("remote_index_build_flush_time_in_millis");
            generator.write(this.remoteIndexBuildFlushTimeInMillis);
        }

        if (this.remoteIndexBuildMergeTimeInMillis != null) {
            generator.writeKey("remote_index_build_merge_time_in_millis");
            generator.write(this.remoteIndexBuildMergeTimeInMillis);
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
     * Builder for {@link RemoteVectorIndexBuildStatsDetails}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, RemoteVectorIndexBuildStatsDetails> {
        @Nullable
        private Long remoteIndexBuildCurrentFlushOperations;
        @Nullable
        private Long remoteIndexBuildCurrentFlushSize;
        @Nullable
        private Long remoteIndexBuildCurrentMergeOperations;
        @Nullable
        private Long remoteIndexBuildCurrentMergeSize;
        @Nullable
        private Long remoteIndexBuildFlushTimeInMillis;
        @Nullable
        private Long remoteIndexBuildMergeTimeInMillis;

        public Builder() {}

        private Builder(RemoteVectorIndexBuildStatsDetails o) {
            this.remoteIndexBuildCurrentFlushOperations = o.remoteIndexBuildCurrentFlushOperations;
            this.remoteIndexBuildCurrentFlushSize = o.remoteIndexBuildCurrentFlushSize;
            this.remoteIndexBuildCurrentMergeOperations = o.remoteIndexBuildCurrentMergeOperations;
            this.remoteIndexBuildCurrentMergeSize = o.remoteIndexBuildCurrentMergeSize;
            this.remoteIndexBuildFlushTimeInMillis = o.remoteIndexBuildFlushTimeInMillis;
            this.remoteIndexBuildMergeTimeInMillis = o.remoteIndexBuildMergeTimeInMillis;
        }

        private Builder(Builder o) {
            this.remoteIndexBuildCurrentFlushOperations = o.remoteIndexBuildCurrentFlushOperations;
            this.remoteIndexBuildCurrentFlushSize = o.remoteIndexBuildCurrentFlushSize;
            this.remoteIndexBuildCurrentMergeOperations = o.remoteIndexBuildCurrentMergeOperations;
            this.remoteIndexBuildCurrentMergeSize = o.remoteIndexBuildCurrentMergeSize;
            this.remoteIndexBuildFlushTimeInMillis = o.remoteIndexBuildFlushTimeInMillis;
            this.remoteIndexBuildMergeTimeInMillis = o.remoteIndexBuildMergeTimeInMillis;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code remote_index_build_current_flush_operations}
         */
        @Nonnull
        public final Builder remoteIndexBuildCurrentFlushOperations(@Nullable Long value) {
            this.remoteIndexBuildCurrentFlushOperations = value;
            return this;
        }

        /**
         * API name: {@code remote_index_build_current_flush_size}
         */
        @Nonnull
        public final Builder remoteIndexBuildCurrentFlushSize(@Nullable Long value) {
            this.remoteIndexBuildCurrentFlushSize = value;
            return this;
        }

        /**
         * API name: {@code remote_index_build_current_merge_operations}
         */
        @Nonnull
        public final Builder remoteIndexBuildCurrentMergeOperations(@Nullable Long value) {
            this.remoteIndexBuildCurrentMergeOperations = value;
            return this;
        }

        /**
         * API name: {@code remote_index_build_current_merge_size}
         */
        @Nonnull
        public final Builder remoteIndexBuildCurrentMergeSize(@Nullable Long value) {
            this.remoteIndexBuildCurrentMergeSize = value;
            return this;
        }

        /**
         * API name: {@code remote_index_build_flush_time_in_millis}
         */
        @Nonnull
        public final Builder remoteIndexBuildFlushTimeInMillis(@Nullable Long value) {
            this.remoteIndexBuildFlushTimeInMillis = value;
            return this;
        }

        /**
         * API name: {@code remote_index_build_merge_time_in_millis}
         */
        @Nonnull
        public final Builder remoteIndexBuildMergeTimeInMillis(@Nullable Long value) {
            this.remoteIndexBuildMergeTimeInMillis = value;
            return this;
        }

        /**
         * Builds a {@link RemoteVectorIndexBuildStatsDetails}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public RemoteVectorIndexBuildStatsDetails build() {
            _checkSingleUse();

            return new RemoteVectorIndexBuildStatsDetails(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link RemoteVectorIndexBuildStatsDetails}
     */
    public static final JsonpDeserializer<RemoteVectorIndexBuildStatsDetails> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        RemoteVectorIndexBuildStatsDetails::setupRemoteVectorIndexBuildStatsDetailsDeserializer
    );

    protected static void setupRemoteVectorIndexBuildStatsDetailsDeserializer(
        ObjectDeserializer<RemoteVectorIndexBuildStatsDetails.Builder> op
    ) {
        op.add(
            Builder::remoteIndexBuildCurrentFlushOperations,
            JsonpDeserializer.longDeserializer(),
            "remote_index_build_current_flush_operations"
        );
        op.add(Builder::remoteIndexBuildCurrentFlushSize, JsonpDeserializer.longDeserializer(), "remote_index_build_current_flush_size");
        op.add(
            Builder::remoteIndexBuildCurrentMergeOperations,
            JsonpDeserializer.longDeserializer(),
            "remote_index_build_current_merge_operations"
        );
        op.add(Builder::remoteIndexBuildCurrentMergeSize, JsonpDeserializer.longDeserializer(), "remote_index_build_current_merge_size");
        op.add(Builder::remoteIndexBuildFlushTimeInMillis, JsonpDeserializer.longDeserializer(), "remote_index_build_flush_time_in_millis");
        op.add(Builder::remoteIndexBuildMergeTimeInMillis, JsonpDeserializer.longDeserializer(), "remote_index_build_merge_time_in_millis");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.remoteIndexBuildCurrentFlushOperations);
        result = 31 * result + Objects.hashCode(this.remoteIndexBuildCurrentFlushSize);
        result = 31 * result + Objects.hashCode(this.remoteIndexBuildCurrentMergeOperations);
        result = 31 * result + Objects.hashCode(this.remoteIndexBuildCurrentMergeSize);
        result = 31 * result + Objects.hashCode(this.remoteIndexBuildFlushTimeInMillis);
        result = 31 * result + Objects.hashCode(this.remoteIndexBuildMergeTimeInMillis);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        RemoteVectorIndexBuildStatsDetails other = (RemoteVectorIndexBuildStatsDetails) o;
        return Objects.equals(this.remoteIndexBuildCurrentFlushOperations, other.remoteIndexBuildCurrentFlushOperations)
            && Objects.equals(this.remoteIndexBuildCurrentFlushSize, other.remoteIndexBuildCurrentFlushSize)
            && Objects.equals(this.remoteIndexBuildCurrentMergeOperations, other.remoteIndexBuildCurrentMergeOperations)
            && Objects.equals(this.remoteIndexBuildCurrentMergeSize, other.remoteIndexBuildCurrentMergeSize)
            && Objects.equals(this.remoteIndexBuildFlushTimeInMillis, other.remoteIndexBuildFlushTimeInMillis)
            && Objects.equals(this.remoteIndexBuildMergeTimeInMillis, other.remoteIndexBuildMergeTimeInMillis);
    }
}
