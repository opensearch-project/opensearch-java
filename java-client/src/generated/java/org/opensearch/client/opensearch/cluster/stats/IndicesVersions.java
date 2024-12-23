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

// typedef: cluster.stats.IndicesVersions

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class IndicesVersions implements PlainJsonSerializable, ToCopyableBuilder<IndicesVersions.Builder, IndicesVersions> {

    private final int indexCount;

    private final int primaryShardCount;

    private final long totalPrimaryBytes;

    @Nonnull
    private final String version;

    // ---------------------------------------------------------------------------------------------

    private IndicesVersions(Builder builder) {
        this.indexCount = ApiTypeHelper.requireNonNull(builder.indexCount, this, "indexCount");
        this.primaryShardCount = ApiTypeHelper.requireNonNull(builder.primaryShardCount, this, "primaryShardCount");
        this.totalPrimaryBytes = ApiTypeHelper.requireNonNull(builder.totalPrimaryBytes, this, "totalPrimaryBytes");
        this.version = ApiTypeHelper.requireNonNull(builder.version, this, "version");
    }

    public static IndicesVersions of(Function<IndicesVersions.Builder, ObjectBuilder<IndicesVersions>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code index_count}
     */
    public final int indexCount() {
        return this.indexCount;
    }

    /**
     * Required - API name: {@code primary_shard_count}
     */
    public final int primaryShardCount() {
        return this.primaryShardCount;
    }

    /**
     * Required - API name: {@code total_primary_bytes}
     */
    public final long totalPrimaryBytes() {
        return this.totalPrimaryBytes;
    }

    /**
     * Required - API name: {@code version}
     */
    @Nonnull
    public final String version() {
        return this.version;
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
        generator.writeKey("index_count");
        generator.write(this.indexCount);

        generator.writeKey("primary_shard_count");
        generator.write(this.primaryShardCount);

        generator.writeKey("total_primary_bytes");
        generator.write(this.totalPrimaryBytes);

        generator.writeKey("version");
        generator.write(this.version);
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
     * Builder for {@link IndicesVersions}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, IndicesVersions> {
        private Integer indexCount;
        private Integer primaryShardCount;
        private Long totalPrimaryBytes;
        private String version;

        public Builder() {}

        private Builder(IndicesVersions o) {
            this.indexCount = o.indexCount;
            this.primaryShardCount = o.primaryShardCount;
            this.totalPrimaryBytes = o.totalPrimaryBytes;
            this.version = o.version;
        }

        private Builder(Builder o) {
            this.indexCount = o.indexCount;
            this.primaryShardCount = o.primaryShardCount;
            this.totalPrimaryBytes = o.totalPrimaryBytes;
            this.version = o.version;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - API name: {@code index_count}
         */
        @Nonnull
        public final Builder indexCount(int value) {
            this.indexCount = value;
            return this;
        }

        /**
         * Required - API name: {@code primary_shard_count}
         */
        @Nonnull
        public final Builder primaryShardCount(int value) {
            this.primaryShardCount = value;
            return this;
        }

        /**
         * Required - API name: {@code total_primary_bytes}
         */
        @Nonnull
        public final Builder totalPrimaryBytes(long value) {
            this.totalPrimaryBytes = value;
            return this;
        }

        /**
         * Required - API name: {@code version}
         */
        @Nonnull
        public final Builder version(String value) {
            this.version = value;
            return this;
        }

        /**
         * Builds a {@link IndicesVersions}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public IndicesVersions build() {
            _checkSingleUse();

            return new IndicesVersions(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link IndicesVersions}
     */
    public static final JsonpDeserializer<IndicesVersions> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        IndicesVersions::setupIndicesVersionsDeserializer
    );

    protected static void setupIndicesVersionsDeserializer(ObjectDeserializer<IndicesVersions.Builder> op) {
        op.add(Builder::indexCount, JsonpDeserializer.integerDeserializer(), "index_count");
        op.add(Builder::primaryShardCount, JsonpDeserializer.integerDeserializer(), "primary_shard_count");
        op.add(Builder::totalPrimaryBytes, JsonpDeserializer.longDeserializer(), "total_primary_bytes");
        op.add(Builder::version, JsonpDeserializer.stringDeserializer(), "version");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Integer.hashCode(this.indexCount);
        result = 31 * result + Integer.hashCode(this.primaryShardCount);
        result = 31 * result + Long.hashCode(this.totalPrimaryBytes);
        result = 31 * result + this.version.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        IndicesVersions other = (IndicesVersions) o;
        return this.indexCount == other.indexCount
            && this.primaryShardCount == other.primaryShardCount
            && this.totalPrimaryBytes == other.totalPrimaryBytes
            && this.version.equals(other.version);
    }
}
