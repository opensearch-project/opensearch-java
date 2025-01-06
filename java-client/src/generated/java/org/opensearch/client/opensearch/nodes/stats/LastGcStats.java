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

package org.opensearch.client.opensearch.nodes.stats;

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

// typedef: nodes.stats.LastGcStats

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class LastGcStats implements PlainJsonSerializable, ToCopyableBuilder<LastGcStats.Builder, LastGcStats> {

    @Nullable
    private final String max;

    @Nullable
    private final Long maxInBytes;

    @Nullable
    private final Double usagePercent;

    @Nullable
    private final String used;

    @Nullable
    private final Long usedInBytes;

    // ---------------------------------------------------------------------------------------------

    private LastGcStats(Builder builder) {
        this.max = builder.max;
        this.maxInBytes = builder.maxInBytes;
        this.usagePercent = builder.usagePercent;
        this.used = builder.used;
        this.usedInBytes = builder.usedInBytes;
    }

    public static LastGcStats of(Function<LastGcStats.Builder, ObjectBuilder<LastGcStats>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code max}
     */
    @Nullable
    public final String max() {
        return this.max;
    }

    /**
     * API name: {@code max_in_bytes}
     */
    @Nullable
    public final Long maxInBytes() {
        return this.maxInBytes;
    }

    /**
     * API name: {@code usage_percent}
     */
    @Nullable
    public final Double usagePercent() {
        return this.usagePercent;
    }

    /**
     * API name: {@code used}
     */
    @Nullable
    public final String used() {
        return this.used;
    }

    /**
     * API name: {@code used_in_bytes}
     */
    @Nullable
    public final Long usedInBytes() {
        return this.usedInBytes;
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

        if (this.maxInBytes != null) {
            generator.writeKey("max_in_bytes");
            generator.write(this.maxInBytes);
        }

        if (this.usagePercent != null) {
            generator.writeKey("usage_percent");
            generator.write(this.usagePercent);
        }

        if (this.used != null) {
            generator.writeKey("used");
            generator.write(this.used);
        }

        if (this.usedInBytes != null) {
            generator.writeKey("used_in_bytes");
            generator.write(this.usedInBytes);
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
     * Builder for {@link LastGcStats}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, LastGcStats> {
        @Nullable
        private String max;
        @Nullable
        private Long maxInBytes;
        @Nullable
        private Double usagePercent;
        @Nullable
        private String used;
        @Nullable
        private Long usedInBytes;

        public Builder() {}

        private Builder(LastGcStats o) {
            this.max = o.max;
            this.maxInBytes = o.maxInBytes;
            this.usagePercent = o.usagePercent;
            this.used = o.used;
            this.usedInBytes = o.usedInBytes;
        }

        private Builder(Builder o) {
            this.max = o.max;
            this.maxInBytes = o.maxInBytes;
            this.usagePercent = o.usagePercent;
            this.used = o.used;
            this.usedInBytes = o.usedInBytes;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code max}
         */
        @Nonnull
        public final Builder max(@Nullable String value) {
            this.max = value;
            return this;
        }

        /**
         * API name: {@code max_in_bytes}
         */
        @Nonnull
        public final Builder maxInBytes(@Nullable Long value) {
            this.maxInBytes = value;
            return this;
        }

        /**
         * API name: {@code usage_percent}
         */
        @Nonnull
        public final Builder usagePercent(@Nullable Double value) {
            this.usagePercent = value;
            return this;
        }

        /**
         * API name: {@code used}
         */
        @Nonnull
        public final Builder used(@Nullable String value) {
            this.used = value;
            return this;
        }

        /**
         * API name: {@code used_in_bytes}
         */
        @Nonnull
        public final Builder usedInBytes(@Nullable Long value) {
            this.usedInBytes = value;
            return this;
        }

        /**
         * Builds a {@link LastGcStats}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public LastGcStats build() {
            _checkSingleUse();

            return new LastGcStats(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link LastGcStats}
     */
    public static final JsonpDeserializer<LastGcStats> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        LastGcStats::setupLastGcStatsDeserializer
    );

    protected static void setupLastGcStatsDeserializer(ObjectDeserializer<LastGcStats.Builder> op) {
        op.add(Builder::max, JsonpDeserializer.stringDeserializer(), "max");
        op.add(Builder::maxInBytes, JsonpDeserializer.longDeserializer(), "max_in_bytes");
        op.add(Builder::usagePercent, JsonpDeserializer.doubleDeserializer(), "usage_percent");
        op.add(Builder::used, JsonpDeserializer.stringDeserializer(), "used");
        op.add(Builder::usedInBytes, JsonpDeserializer.longDeserializer(), "used_in_bytes");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.max);
        result = 31 * result + Objects.hashCode(this.maxInBytes);
        result = 31 * result + Objects.hashCode(this.usagePercent);
        result = 31 * result + Objects.hashCode(this.used);
        result = 31 * result + Objects.hashCode(this.usedInBytes);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        LastGcStats other = (LastGcStats) o;
        return Objects.equals(this.max, other.max)
            && Objects.equals(this.maxInBytes, other.maxInBytes)
            && Objects.equals(this.usagePercent, other.usagePercent)
            && Objects.equals(this.used, other.used)
            && Objects.equals(this.usedInBytes, other.usedInBytes);
    }
}
