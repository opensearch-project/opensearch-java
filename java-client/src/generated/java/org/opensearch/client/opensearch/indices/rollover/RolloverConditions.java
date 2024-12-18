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

package org.opensearch.client.opensearch.indices.rollover;

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
import org.opensearch.client.opensearch._types.Time;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: indices.rollover.RolloverConditions

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class RolloverConditions implements PlainJsonSerializable, ToCopyableBuilder<RolloverConditions.Builder, RolloverConditions> {

    @Nullable
    private final Time maxAge;

    @Nullable
    private final Long maxAgeMillis;

    @Nullable
    private final Long maxDocs;

    @Nullable
    private final Long maxPrimaryShardDocs;

    @Nullable
    private final String maxPrimaryShardSize;

    @Nullable
    private final Long maxPrimaryShardSizeBytes;

    @Nullable
    private final String maxSize;

    @Nullable
    private final Long maxSizeBytes;

    @Nullable
    private final Time minAge;

    @Nullable
    private final Long minDocs;

    @Nullable
    private final Long minPrimaryShardDocs;

    @Nullable
    private final String minPrimaryShardSize;

    @Nullable
    private final Long minPrimaryShardSizeBytes;

    @Nullable
    private final String minSize;

    @Nullable
    private final Long minSizeBytes;

    // ---------------------------------------------------------------------------------------------

    private RolloverConditions(Builder builder) {
        this.maxAge = builder.maxAge;
        this.maxAgeMillis = builder.maxAgeMillis;
        this.maxDocs = builder.maxDocs;
        this.maxPrimaryShardDocs = builder.maxPrimaryShardDocs;
        this.maxPrimaryShardSize = builder.maxPrimaryShardSize;
        this.maxPrimaryShardSizeBytes = builder.maxPrimaryShardSizeBytes;
        this.maxSize = builder.maxSize;
        this.maxSizeBytes = builder.maxSizeBytes;
        this.minAge = builder.minAge;
        this.minDocs = builder.minDocs;
        this.minPrimaryShardDocs = builder.minPrimaryShardDocs;
        this.minPrimaryShardSize = builder.minPrimaryShardSize;
        this.minPrimaryShardSizeBytes = builder.minPrimaryShardSizeBytes;
        this.minSize = builder.minSize;
        this.minSizeBytes = builder.minSizeBytes;
    }

    public static RolloverConditions of(Function<RolloverConditions.Builder, ObjectBuilder<RolloverConditions>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code max_age}
     */
    @Nullable
    public final Time maxAge() {
        return this.maxAge;
    }

    /**
     * API name: {@code max_age_millis}
     */
    @Nullable
    public final Long maxAgeMillis() {
        return this.maxAgeMillis;
    }

    /**
     * API name: {@code max_docs}
     */
    @Nullable
    public final Long maxDocs() {
        return this.maxDocs;
    }

    /**
     * API name: {@code max_primary_shard_docs}
     */
    @Nullable
    public final Long maxPrimaryShardDocs() {
        return this.maxPrimaryShardDocs;
    }

    /**
     * API name: {@code max_primary_shard_size}
     */
    @Nullable
    public final String maxPrimaryShardSize() {
        return this.maxPrimaryShardSize;
    }

    /**
     * API name: {@code max_primary_shard_size_bytes}
     */
    @Nullable
    public final Long maxPrimaryShardSizeBytes() {
        return this.maxPrimaryShardSizeBytes;
    }

    /**
     * API name: {@code max_size}
     */
    @Nullable
    public final String maxSize() {
        return this.maxSize;
    }

    /**
     * API name: {@code max_size_bytes}
     */
    @Nullable
    public final Long maxSizeBytes() {
        return this.maxSizeBytes;
    }

    /**
     * API name: {@code min_age}
     */
    @Nullable
    public final Time minAge() {
        return this.minAge;
    }

    /**
     * API name: {@code min_docs}
     */
    @Nullable
    public final Long minDocs() {
        return this.minDocs;
    }

    /**
     * API name: {@code min_primary_shard_docs}
     */
    @Nullable
    public final Long minPrimaryShardDocs() {
        return this.minPrimaryShardDocs;
    }

    /**
     * API name: {@code min_primary_shard_size}
     */
    @Nullable
    public final String minPrimaryShardSize() {
        return this.minPrimaryShardSize;
    }

    /**
     * API name: {@code min_primary_shard_size_bytes}
     */
    @Nullable
    public final Long minPrimaryShardSizeBytes() {
        return this.minPrimaryShardSizeBytes;
    }

    /**
     * API name: {@code min_size}
     */
    @Nullable
    public final String minSize() {
        return this.minSize;
    }

    /**
     * API name: {@code min_size_bytes}
     */
    @Nullable
    public final Long minSizeBytes() {
        return this.minSizeBytes;
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
        if (this.maxAge != null) {
            generator.writeKey("max_age");
            this.maxAge.serialize(generator, mapper);
        }

        if (this.maxAgeMillis != null) {
            generator.writeKey("max_age_millis");
            generator.write(this.maxAgeMillis);
        }

        if (this.maxDocs != null) {
            generator.writeKey("max_docs");
            generator.write(this.maxDocs);
        }

        if (this.maxPrimaryShardDocs != null) {
            generator.writeKey("max_primary_shard_docs");
            generator.write(this.maxPrimaryShardDocs);
        }

        if (this.maxPrimaryShardSize != null) {
            generator.writeKey("max_primary_shard_size");
            generator.write(this.maxPrimaryShardSize);
        }

        if (this.maxPrimaryShardSizeBytes != null) {
            generator.writeKey("max_primary_shard_size_bytes");
            generator.write(this.maxPrimaryShardSizeBytes);
        }

        if (this.maxSize != null) {
            generator.writeKey("max_size");
            generator.write(this.maxSize);
        }

        if (this.maxSizeBytes != null) {
            generator.writeKey("max_size_bytes");
            generator.write(this.maxSizeBytes);
        }

        if (this.minAge != null) {
            generator.writeKey("min_age");
            this.minAge.serialize(generator, mapper);
        }

        if (this.minDocs != null) {
            generator.writeKey("min_docs");
            generator.write(this.minDocs);
        }

        if (this.minPrimaryShardDocs != null) {
            generator.writeKey("min_primary_shard_docs");
            generator.write(this.minPrimaryShardDocs);
        }

        if (this.minPrimaryShardSize != null) {
            generator.writeKey("min_primary_shard_size");
            generator.write(this.minPrimaryShardSize);
        }

        if (this.minPrimaryShardSizeBytes != null) {
            generator.writeKey("min_primary_shard_size_bytes");
            generator.write(this.minPrimaryShardSizeBytes);
        }

        if (this.minSize != null) {
            generator.writeKey("min_size");
            generator.write(this.minSize);
        }

        if (this.minSizeBytes != null) {
            generator.writeKey("min_size_bytes");
            generator.write(this.minSizeBytes);
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
     * Builder for {@link RolloverConditions}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, RolloverConditions> {
        @Nullable
        private Time maxAge;
        @Nullable
        private Long maxAgeMillis;
        @Nullable
        private Long maxDocs;
        @Nullable
        private Long maxPrimaryShardDocs;
        @Nullable
        private String maxPrimaryShardSize;
        @Nullable
        private Long maxPrimaryShardSizeBytes;
        @Nullable
        private String maxSize;
        @Nullable
        private Long maxSizeBytes;
        @Nullable
        private Time minAge;
        @Nullable
        private Long minDocs;
        @Nullable
        private Long minPrimaryShardDocs;
        @Nullable
        private String minPrimaryShardSize;
        @Nullable
        private Long minPrimaryShardSizeBytes;
        @Nullable
        private String minSize;
        @Nullable
        private Long minSizeBytes;

        public Builder() {}

        private Builder(RolloverConditions o) {
            this.maxAge = o.maxAge;
            this.maxAgeMillis = o.maxAgeMillis;
            this.maxDocs = o.maxDocs;
            this.maxPrimaryShardDocs = o.maxPrimaryShardDocs;
            this.maxPrimaryShardSize = o.maxPrimaryShardSize;
            this.maxPrimaryShardSizeBytes = o.maxPrimaryShardSizeBytes;
            this.maxSize = o.maxSize;
            this.maxSizeBytes = o.maxSizeBytes;
            this.minAge = o.minAge;
            this.minDocs = o.minDocs;
            this.minPrimaryShardDocs = o.minPrimaryShardDocs;
            this.minPrimaryShardSize = o.minPrimaryShardSize;
            this.minPrimaryShardSizeBytes = o.minPrimaryShardSizeBytes;
            this.minSize = o.minSize;
            this.minSizeBytes = o.minSizeBytes;
        }

        private Builder(Builder o) {
            this.maxAge = o.maxAge;
            this.maxAgeMillis = o.maxAgeMillis;
            this.maxDocs = o.maxDocs;
            this.maxPrimaryShardDocs = o.maxPrimaryShardDocs;
            this.maxPrimaryShardSize = o.maxPrimaryShardSize;
            this.maxPrimaryShardSizeBytes = o.maxPrimaryShardSizeBytes;
            this.maxSize = o.maxSize;
            this.maxSizeBytes = o.maxSizeBytes;
            this.minAge = o.minAge;
            this.minDocs = o.minDocs;
            this.minPrimaryShardDocs = o.minPrimaryShardDocs;
            this.minPrimaryShardSize = o.minPrimaryShardSize;
            this.minPrimaryShardSizeBytes = o.minPrimaryShardSizeBytes;
            this.minSize = o.minSize;
            this.minSizeBytes = o.minSizeBytes;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code max_age}
         */
        @Nonnull
        public final Builder maxAge(@Nullable Time value) {
            this.maxAge = value;
            return this;
        }

        /**
         * API name: {@code max_age}
         */
        @Nonnull
        public final Builder maxAge(Function<Time.Builder, ObjectBuilder<Time>> fn) {
            return maxAge(fn.apply(new Time.Builder()).build());
        }

        /**
         * API name: {@code max_age_millis}
         */
        @Nonnull
        public final Builder maxAgeMillis(@Nullable Long value) {
            this.maxAgeMillis = value;
            return this;
        }

        /**
         * API name: {@code max_docs}
         */
        @Nonnull
        public final Builder maxDocs(@Nullable Long value) {
            this.maxDocs = value;
            return this;
        }

        /**
         * API name: {@code max_primary_shard_docs}
         */
        @Nonnull
        public final Builder maxPrimaryShardDocs(@Nullable Long value) {
            this.maxPrimaryShardDocs = value;
            return this;
        }

        /**
         * API name: {@code max_primary_shard_size}
         */
        @Nonnull
        public final Builder maxPrimaryShardSize(@Nullable String value) {
            this.maxPrimaryShardSize = value;
            return this;
        }

        /**
         * API name: {@code max_primary_shard_size_bytes}
         */
        @Nonnull
        public final Builder maxPrimaryShardSizeBytes(@Nullable Long value) {
            this.maxPrimaryShardSizeBytes = value;
            return this;
        }

        /**
         * API name: {@code max_size}
         */
        @Nonnull
        public final Builder maxSize(@Nullable String value) {
            this.maxSize = value;
            return this;
        }

        /**
         * API name: {@code max_size_bytes}
         */
        @Nonnull
        public final Builder maxSizeBytes(@Nullable Long value) {
            this.maxSizeBytes = value;
            return this;
        }

        /**
         * API name: {@code min_age}
         */
        @Nonnull
        public final Builder minAge(@Nullable Time value) {
            this.minAge = value;
            return this;
        }

        /**
         * API name: {@code min_age}
         */
        @Nonnull
        public final Builder minAge(Function<Time.Builder, ObjectBuilder<Time>> fn) {
            return minAge(fn.apply(new Time.Builder()).build());
        }

        /**
         * API name: {@code min_docs}
         */
        @Nonnull
        public final Builder minDocs(@Nullable Long value) {
            this.minDocs = value;
            return this;
        }

        /**
         * API name: {@code min_primary_shard_docs}
         */
        @Nonnull
        public final Builder minPrimaryShardDocs(@Nullable Long value) {
            this.minPrimaryShardDocs = value;
            return this;
        }

        /**
         * API name: {@code min_primary_shard_size}
         */
        @Nonnull
        public final Builder minPrimaryShardSize(@Nullable String value) {
            this.minPrimaryShardSize = value;
            return this;
        }

        /**
         * API name: {@code min_primary_shard_size_bytes}
         */
        @Nonnull
        public final Builder minPrimaryShardSizeBytes(@Nullable Long value) {
            this.minPrimaryShardSizeBytes = value;
            return this;
        }

        /**
         * API name: {@code min_size}
         */
        @Nonnull
        public final Builder minSize(@Nullable String value) {
            this.minSize = value;
            return this;
        }

        /**
         * API name: {@code min_size_bytes}
         */
        @Nonnull
        public final Builder minSizeBytes(@Nullable Long value) {
            this.minSizeBytes = value;
            return this;
        }

        /**
         * Builds a {@link RolloverConditions}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public RolloverConditions build() {
            _checkSingleUse();

            return new RolloverConditions(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link RolloverConditions}
     */
    public static final JsonpDeserializer<RolloverConditions> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        RolloverConditions::setupRolloverConditionsDeserializer
    );

    protected static void setupRolloverConditionsDeserializer(ObjectDeserializer<RolloverConditions.Builder> op) {
        op.add(Builder::maxAge, Time._DESERIALIZER, "max_age");
        op.add(Builder::maxAgeMillis, JsonpDeserializer.longDeserializer(), "max_age_millis");
        op.add(Builder::maxDocs, JsonpDeserializer.longDeserializer(), "max_docs");
        op.add(Builder::maxPrimaryShardDocs, JsonpDeserializer.longDeserializer(), "max_primary_shard_docs");
        op.add(Builder::maxPrimaryShardSize, JsonpDeserializer.stringDeserializer(), "max_primary_shard_size");
        op.add(Builder::maxPrimaryShardSizeBytes, JsonpDeserializer.longDeserializer(), "max_primary_shard_size_bytes");
        op.add(Builder::maxSize, JsonpDeserializer.stringDeserializer(), "max_size");
        op.add(Builder::maxSizeBytes, JsonpDeserializer.longDeserializer(), "max_size_bytes");
        op.add(Builder::minAge, Time._DESERIALIZER, "min_age");
        op.add(Builder::minDocs, JsonpDeserializer.longDeserializer(), "min_docs");
        op.add(Builder::minPrimaryShardDocs, JsonpDeserializer.longDeserializer(), "min_primary_shard_docs");
        op.add(Builder::minPrimaryShardSize, JsonpDeserializer.stringDeserializer(), "min_primary_shard_size");
        op.add(Builder::minPrimaryShardSizeBytes, JsonpDeserializer.longDeserializer(), "min_primary_shard_size_bytes");
        op.add(Builder::minSize, JsonpDeserializer.stringDeserializer(), "min_size");
        op.add(Builder::minSizeBytes, JsonpDeserializer.longDeserializer(), "min_size_bytes");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.maxAge);
        result = 31 * result + Objects.hashCode(this.maxAgeMillis);
        result = 31 * result + Objects.hashCode(this.maxDocs);
        result = 31 * result + Objects.hashCode(this.maxPrimaryShardDocs);
        result = 31 * result + Objects.hashCode(this.maxPrimaryShardSize);
        result = 31 * result + Objects.hashCode(this.maxPrimaryShardSizeBytes);
        result = 31 * result + Objects.hashCode(this.maxSize);
        result = 31 * result + Objects.hashCode(this.maxSizeBytes);
        result = 31 * result + Objects.hashCode(this.minAge);
        result = 31 * result + Objects.hashCode(this.minDocs);
        result = 31 * result + Objects.hashCode(this.minPrimaryShardDocs);
        result = 31 * result + Objects.hashCode(this.minPrimaryShardSize);
        result = 31 * result + Objects.hashCode(this.minPrimaryShardSizeBytes);
        result = 31 * result + Objects.hashCode(this.minSize);
        result = 31 * result + Objects.hashCode(this.minSizeBytes);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        RolloverConditions other = (RolloverConditions) o;
        return Objects.equals(this.maxAge, other.maxAge)
            && Objects.equals(this.maxAgeMillis, other.maxAgeMillis)
            && Objects.equals(this.maxDocs, other.maxDocs)
            && Objects.equals(this.maxPrimaryShardDocs, other.maxPrimaryShardDocs)
            && Objects.equals(this.maxPrimaryShardSize, other.maxPrimaryShardSize)
            && Objects.equals(this.maxPrimaryShardSizeBytes, other.maxPrimaryShardSizeBytes)
            && Objects.equals(this.maxSize, other.maxSize)
            && Objects.equals(this.maxSizeBytes, other.maxSizeBytes)
            && Objects.equals(this.minAge, other.minAge)
            && Objects.equals(this.minDocs, other.minDocs)
            && Objects.equals(this.minPrimaryShardDocs, other.minPrimaryShardDocs)
            && Objects.equals(this.minPrimaryShardSize, other.minPrimaryShardSize)
            && Objects.equals(this.minPrimaryShardSizeBytes, other.minPrimaryShardSizeBytes)
            && Objects.equals(this.minSize, other.minSize)
            && Objects.equals(this.minSizeBytes, other.minSizeBytes);
    }
}
