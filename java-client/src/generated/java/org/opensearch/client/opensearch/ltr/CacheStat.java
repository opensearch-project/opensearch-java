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

package org.opensearch.client.opensearch.ltr;

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

// typedef: ltr.CacheStat

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class CacheStat implements PlainJsonSerializable, ToCopyableBuilder<CacheStat.Builder, CacheStat> {

    @Nullable
    private final Integer entryCount;

    @Nullable
    private final Integer evictionCount;

    @Nullable
    private final Integer hitCount;

    @Nullable
    private final Integer memoryUsageInBytes;

    @Nullable
    private final Integer missCount;

    // ---------------------------------------------------------------------------------------------

    private CacheStat(Builder builder) {
        this.entryCount = builder.entryCount;
        this.evictionCount = builder.evictionCount;
        this.hitCount = builder.hitCount;
        this.memoryUsageInBytes = builder.memoryUsageInBytes;
        this.missCount = builder.missCount;
    }

    public static CacheStat of(Function<CacheStat.Builder, ObjectBuilder<CacheStat>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code entry_count}
     */
    @Nullable
    public final Integer entryCount() {
        return this.entryCount;
    }

    /**
     * API name: {@code eviction_count}
     */
    @Nullable
    public final Integer evictionCount() {
        return this.evictionCount;
    }

    /**
     * API name: {@code hit_count}
     */
    @Nullable
    public final Integer hitCount() {
        return this.hitCount;
    }

    /**
     * API name: {@code memory_usage_in_bytes}
     */
    @Nullable
    public final Integer memoryUsageInBytes() {
        return this.memoryUsageInBytes;
    }

    /**
     * API name: {@code miss_count}
     */
    @Nullable
    public final Integer missCount() {
        return this.missCount;
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
        if (this.entryCount != null) {
            generator.writeKey("entry_count");
            generator.write(this.entryCount);
        }

        if (this.evictionCount != null) {
            generator.writeKey("eviction_count");
            generator.write(this.evictionCount);
        }

        if (this.hitCount != null) {
            generator.writeKey("hit_count");
            generator.write(this.hitCount);
        }

        if (this.memoryUsageInBytes != null) {
            generator.writeKey("memory_usage_in_bytes");
            generator.write(this.memoryUsageInBytes);
        }

        if (this.missCount != null) {
            generator.writeKey("miss_count");
            generator.write(this.missCount);
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
     * Builder for {@link CacheStat}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, CacheStat> {
        @Nullable
        private Integer entryCount;
        @Nullable
        private Integer evictionCount;
        @Nullable
        private Integer hitCount;
        @Nullable
        private Integer memoryUsageInBytes;
        @Nullable
        private Integer missCount;

        public Builder() {}

        private Builder(CacheStat o) {
            this.entryCount = o.entryCount;
            this.evictionCount = o.evictionCount;
            this.hitCount = o.hitCount;
            this.memoryUsageInBytes = o.memoryUsageInBytes;
            this.missCount = o.missCount;
        }

        private Builder(Builder o) {
            this.entryCount = o.entryCount;
            this.evictionCount = o.evictionCount;
            this.hitCount = o.hitCount;
            this.memoryUsageInBytes = o.memoryUsageInBytes;
            this.missCount = o.missCount;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code entry_count}
         */
        @Nonnull
        public final Builder entryCount(@Nullable Integer value) {
            this.entryCount = value;
            return this;
        }

        /**
         * API name: {@code eviction_count}
         */
        @Nonnull
        public final Builder evictionCount(@Nullable Integer value) {
            this.evictionCount = value;
            return this;
        }

        /**
         * API name: {@code hit_count}
         */
        @Nonnull
        public final Builder hitCount(@Nullable Integer value) {
            this.hitCount = value;
            return this;
        }

        /**
         * API name: {@code memory_usage_in_bytes}
         */
        @Nonnull
        public final Builder memoryUsageInBytes(@Nullable Integer value) {
            this.memoryUsageInBytes = value;
            return this;
        }

        /**
         * API name: {@code miss_count}
         */
        @Nonnull
        public final Builder missCount(@Nullable Integer value) {
            this.missCount = value;
            return this;
        }

        /**
         * Builds a {@link CacheStat}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public CacheStat build() {
            _checkSingleUse();

            return new CacheStat(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link CacheStat}
     */
    public static final JsonpDeserializer<CacheStat> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        CacheStat::setupCacheStatDeserializer
    );

    protected static void setupCacheStatDeserializer(ObjectDeserializer<CacheStat.Builder> op) {
        op.add(Builder::entryCount, JsonpDeserializer.integerDeserializer(), "entry_count");
        op.add(Builder::evictionCount, JsonpDeserializer.integerDeserializer(), "eviction_count");
        op.add(Builder::hitCount, JsonpDeserializer.integerDeserializer(), "hit_count");
        op.add(Builder::memoryUsageInBytes, JsonpDeserializer.integerDeserializer(), "memory_usage_in_bytes");
        op.add(Builder::missCount, JsonpDeserializer.integerDeserializer(), "miss_count");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.entryCount);
        result = 31 * result + Objects.hashCode(this.evictionCount);
        result = 31 * result + Objects.hashCode(this.hitCount);
        result = 31 * result + Objects.hashCode(this.memoryUsageInBytes);
        result = 31 * result + Objects.hashCode(this.missCount);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        CacheStat other = (CacheStat) o;
        return Objects.equals(this.entryCount, other.entryCount)
            && Objects.equals(this.evictionCount, other.evictionCount)
            && Objects.equals(this.hitCount, other.hitCount)
            && Objects.equals(this.memoryUsageInBytes, other.memoryUsageInBytes)
            && Objects.equals(this.missCount, other.missCount);
    }
}
