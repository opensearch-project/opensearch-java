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

package org.opensearch.client.opensearch.indices.stats;

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

// typedef: indices.stats.ShardFileSizeInfo

/**
 * The size information for shard files.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class ShardFileSizeInfo implements PlainJsonSerializable, ToCopyableBuilder<ShardFileSizeInfo.Builder, ShardFileSizeInfo> {

    @Nullable
    private final Long averageSizeInBytes;

    @Nullable
    private final Long count;

    @Nonnull
    private final String description;

    @Nullable
    private final Long maxSizeInBytes;

    @Nullable
    private final Long minSizeInBytes;

    @Nullable
    private final String size;

    private final long sizeInBytes;

    // ---------------------------------------------------------------------------------------------

    private ShardFileSizeInfo(Builder builder) {
        this.averageSizeInBytes = builder.averageSizeInBytes;
        this.count = builder.count;
        this.description = ApiTypeHelper.requireNonNull(builder.description, this, "description");
        this.maxSizeInBytes = builder.maxSizeInBytes;
        this.minSizeInBytes = builder.minSizeInBytes;
        this.size = builder.size;
        this.sizeInBytes = ApiTypeHelper.requireNonNull(builder.sizeInBytes, this, "sizeInBytes");
    }

    public static ShardFileSizeInfo of(Function<ShardFileSizeInfo.Builder, ObjectBuilder<ShardFileSizeInfo>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code average_size_in_bytes}
     */
    @Nullable
    public final Long averageSizeInBytes() {
        return this.averageSizeInBytes;
    }

    /**
     * The number of files.
     * <p>
     * API name: {@code count}
     * </p>
     */
    @Nullable
    public final Long count() {
        return this.count;
    }

    /**
     * Required - The description of the file type.
     * <p>
     * API name: {@code description}
     * </p>
     */
    @Nonnull
    public final String description() {
        return this.description;
    }

    /**
     * API name: {@code max_size_in_bytes}
     */
    @Nullable
    public final Long maxSizeInBytes() {
        return this.maxSizeInBytes;
    }

    /**
     * API name: {@code min_size_in_bytes}
     */
    @Nullable
    public final Long minSizeInBytes() {
        return this.minSizeInBytes;
    }

    /**
     * API name: {@code size}
     */
    @Nullable
    public final String size() {
        return this.size;
    }

    /**
     * Required - API name: {@code size_in_bytes}
     */
    public final long sizeInBytes() {
        return this.sizeInBytes;
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
        if (this.averageSizeInBytes != null) {
            generator.writeKey("average_size_in_bytes");
            generator.write(this.averageSizeInBytes);
        }

        if (this.count != null) {
            generator.writeKey("count");
            generator.write(this.count);
        }

        generator.writeKey("description");
        generator.write(this.description);

        if (this.maxSizeInBytes != null) {
            generator.writeKey("max_size_in_bytes");
            generator.write(this.maxSizeInBytes);
        }

        if (this.minSizeInBytes != null) {
            generator.writeKey("min_size_in_bytes");
            generator.write(this.minSizeInBytes);
        }

        if (this.size != null) {
            generator.writeKey("size");
            generator.write(this.size);
        }

        generator.writeKey("size_in_bytes");
        generator.write(this.sizeInBytes);
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
     * Builder for {@link ShardFileSizeInfo}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, ShardFileSizeInfo> {
        @Nullable
        private Long averageSizeInBytes;
        @Nullable
        private Long count;
        private String description;
        @Nullable
        private Long maxSizeInBytes;
        @Nullable
        private Long minSizeInBytes;
        @Nullable
        private String size;
        private Long sizeInBytes;

        public Builder() {}

        private Builder(ShardFileSizeInfo o) {
            this.averageSizeInBytes = o.averageSizeInBytes;
            this.count = o.count;
            this.description = o.description;
            this.maxSizeInBytes = o.maxSizeInBytes;
            this.minSizeInBytes = o.minSizeInBytes;
            this.size = o.size;
            this.sizeInBytes = o.sizeInBytes;
        }

        private Builder(Builder o) {
            this.averageSizeInBytes = o.averageSizeInBytes;
            this.count = o.count;
            this.description = o.description;
            this.maxSizeInBytes = o.maxSizeInBytes;
            this.minSizeInBytes = o.minSizeInBytes;
            this.size = o.size;
            this.sizeInBytes = o.sizeInBytes;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code average_size_in_bytes}
         */
        @Nonnull
        public final Builder averageSizeInBytes(@Nullable Long value) {
            this.averageSizeInBytes = value;
            return this;
        }

        /**
         * The number of files.
         * <p>
         * API name: {@code count}
         * </p>
         */
        @Nonnull
        public final Builder count(@Nullable Long value) {
            this.count = value;
            return this;
        }

        /**
         * Required - The description of the file type.
         * <p>
         * API name: {@code description}
         * </p>
         */
        @Nonnull
        public final Builder description(String value) {
            this.description = value;
            return this;
        }

        /**
         * API name: {@code max_size_in_bytes}
         */
        @Nonnull
        public final Builder maxSizeInBytes(@Nullable Long value) {
            this.maxSizeInBytes = value;
            return this;
        }

        /**
         * API name: {@code min_size_in_bytes}
         */
        @Nonnull
        public final Builder minSizeInBytes(@Nullable Long value) {
            this.minSizeInBytes = value;
            return this;
        }

        /**
         * API name: {@code size}
         */
        @Nonnull
        public final Builder size(@Nullable String value) {
            this.size = value;
            return this;
        }

        /**
         * Required - API name: {@code size_in_bytes}
         */
        @Nonnull
        public final Builder sizeInBytes(long value) {
            this.sizeInBytes = value;
            return this;
        }

        /**
         * Builds a {@link ShardFileSizeInfo}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ShardFileSizeInfo build() {
            _checkSingleUse();

            return new ShardFileSizeInfo(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ShardFileSizeInfo}
     */
    public static final JsonpDeserializer<ShardFileSizeInfo> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ShardFileSizeInfo::setupShardFileSizeInfoDeserializer
    );

    protected static void setupShardFileSizeInfoDeserializer(ObjectDeserializer<ShardFileSizeInfo.Builder> op) {
        op.add(Builder::averageSizeInBytes, JsonpDeserializer.longDeserializer(), "average_size_in_bytes");
        op.add(Builder::count, JsonpDeserializer.longDeserializer(), "count");
        op.add(Builder::description, JsonpDeserializer.stringDeserializer(), "description");
        op.add(Builder::maxSizeInBytes, JsonpDeserializer.longDeserializer(), "max_size_in_bytes");
        op.add(Builder::minSizeInBytes, JsonpDeserializer.longDeserializer(), "min_size_in_bytes");
        op.add(Builder::size, JsonpDeserializer.stringDeserializer(), "size");
        op.add(Builder::sizeInBytes, JsonpDeserializer.longDeserializer(), "size_in_bytes");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.averageSizeInBytes);
        result = 31 * result + Objects.hashCode(this.count);
        result = 31 * result + this.description.hashCode();
        result = 31 * result + Objects.hashCode(this.maxSizeInBytes);
        result = 31 * result + Objects.hashCode(this.minSizeInBytes);
        result = 31 * result + Objects.hashCode(this.size);
        result = 31 * result + Long.hashCode(this.sizeInBytes);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ShardFileSizeInfo other = (ShardFileSizeInfo) o;
        return Objects.equals(this.averageSizeInBytes, other.averageSizeInBytes)
            && Objects.equals(this.count, other.count)
            && this.description.equals(other.description)
            && Objects.equals(this.maxSizeInBytes, other.maxSizeInBytes)
            && Objects.equals(this.minSizeInBytes, other.minSizeInBytes)
            && Objects.equals(this.size, other.size)
            && this.sizeInBytes == other.sizeInBytes;
    }
}
