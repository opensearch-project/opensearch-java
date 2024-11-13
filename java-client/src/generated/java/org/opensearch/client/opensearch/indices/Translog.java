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

package org.opensearch.client.opensearch.indices;

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

// typedef: indices.Translog

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class Translog implements PlainJsonSerializable, ToCopyableBuilder<Translog.Builder, Translog> {

    @Nullable
    private final TranslogDurability durability;

    @Nullable
    private final String flushThresholdSize;

    @Nullable
    private final String generationThresholdSize;

    @Nullable
    private final TranslogRetention retention;

    @Nullable
    private final Time syncInterval;

    // ---------------------------------------------------------------------------------------------

    private Translog(Builder builder) {
        this.durability = builder.durability;
        this.flushThresholdSize = builder.flushThresholdSize;
        this.generationThresholdSize = builder.generationThresholdSize;
        this.retention = builder.retention;
        this.syncInterval = builder.syncInterval;
    }

    public static Translog of(Function<Translog.Builder, ObjectBuilder<Translog>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code durability}
     */
    @Nullable
    public final TranslogDurability durability() {
        return this.durability;
    }

    /**
     * API name: {@code flush_threshold_size}
     */
    @Nullable
    public final String flushThresholdSize() {
        return this.flushThresholdSize;
    }

    /**
     * API name: {@code generation_threshold_size}
     */
    @Nullable
    public final String generationThresholdSize() {
        return this.generationThresholdSize;
    }

    /**
     * API name: {@code retention}
     */
    @Nullable
    public final TranslogRetention retention() {
        return this.retention;
    }

    /**
     * API name: {@code sync_interval}
     */
    @Nullable
    public final Time syncInterval() {
        return this.syncInterval;
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
        if (this.durability != null) {
            generator.writeKey("durability");
            this.durability.serialize(generator, mapper);
        }

        if (this.flushThresholdSize != null) {
            generator.writeKey("flush_threshold_size");
            generator.write(this.flushThresholdSize);
        }

        if (this.generationThresholdSize != null) {
            generator.writeKey("generation_threshold_size");
            generator.write(this.generationThresholdSize);
        }

        if (this.retention != null) {
            generator.writeKey("retention");
            this.retention.serialize(generator, mapper);
        }

        if (this.syncInterval != null) {
            generator.writeKey("sync_interval");
            this.syncInterval.serialize(generator, mapper);
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
     * Builder for {@link Translog}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, Translog> {
        @Nullable
        private TranslogDurability durability;
        @Nullable
        private String flushThresholdSize;
        @Nullable
        private String generationThresholdSize;
        @Nullable
        private TranslogRetention retention;
        @Nullable
        private Time syncInterval;

        public Builder() {}

        private Builder(Translog o) {
            this.durability = o.durability;
            this.flushThresholdSize = o.flushThresholdSize;
            this.generationThresholdSize = o.generationThresholdSize;
            this.retention = o.retention;
            this.syncInterval = o.syncInterval;
        }

        private Builder(Builder o) {
            this.durability = o.durability;
            this.flushThresholdSize = o.flushThresholdSize;
            this.generationThresholdSize = o.generationThresholdSize;
            this.retention = o.retention;
            this.syncInterval = o.syncInterval;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code durability}
         */
        @Nonnull
        public final Builder durability(@Nullable TranslogDurability value) {
            this.durability = value;
            return this;
        }

        /**
         * API name: {@code flush_threshold_size}
         */
        @Nonnull
        public final Builder flushThresholdSize(@Nullable String value) {
            this.flushThresholdSize = value;
            return this;
        }

        /**
         * API name: {@code generation_threshold_size}
         */
        @Nonnull
        public final Builder generationThresholdSize(@Nullable String value) {
            this.generationThresholdSize = value;
            return this;
        }

        /**
         * API name: {@code retention}
         */
        @Nonnull
        public final Builder retention(@Nullable TranslogRetention value) {
            this.retention = value;
            return this;
        }

        /**
         * API name: {@code retention}
         */
        @Nonnull
        public final Builder retention(Function<TranslogRetention.Builder, ObjectBuilder<TranslogRetention>> fn) {
            return retention(fn.apply(new TranslogRetention.Builder()).build());
        }

        /**
         * API name: {@code sync_interval}
         */
        @Nonnull
        public final Builder syncInterval(@Nullable Time value) {
            this.syncInterval = value;
            return this;
        }

        /**
         * API name: {@code sync_interval}
         */
        @Nonnull
        public final Builder syncInterval(Function<Time.Builder, ObjectBuilder<Time>> fn) {
            return syncInterval(fn.apply(new Time.Builder()).build());
        }

        /**
         * Builds a {@link Translog}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public Translog build() {
            _checkSingleUse();

            return new Translog(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link Translog}
     */
    public static final JsonpDeserializer<Translog> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        Translog::setupTranslogDeserializer
    );

    protected static void setupTranslogDeserializer(ObjectDeserializer<Translog.Builder> op) {
        op.add(Builder::durability, TranslogDurability._DESERIALIZER, "durability");
        op.add(Builder::flushThresholdSize, JsonpDeserializer.stringDeserializer(), "flush_threshold_size");
        op.add(Builder::generationThresholdSize, JsonpDeserializer.stringDeserializer(), "generation_threshold_size");
        op.add(Builder::retention, TranslogRetention._DESERIALIZER, "retention");
        op.add(Builder::syncInterval, Time._DESERIALIZER, "sync_interval");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.durability);
        result = 31 * result + Objects.hashCode(this.flushThresholdSize);
        result = 31 * result + Objects.hashCode(this.generationThresholdSize);
        result = 31 * result + Objects.hashCode(this.retention);
        result = 31 * result + Objects.hashCode(this.syncInterval);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Translog other = (Translog) o;
        return Objects.equals(this.durability, other.durability)
            && Objects.equals(this.flushThresholdSize, other.flushThresholdSize)
            && Objects.equals(this.generationThresholdSize, other.generationThresholdSize)
            && Objects.equals(this.retention, other.retention)
            && Objects.equals(this.syncInterval, other.syncInterval);
    }
}
