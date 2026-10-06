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

// typedef: indices.IngestionSourceWarmup

/**
 * Warmup settings for pull-based ingestion.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class IngestionSourceWarmup
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<IngestionSourceWarmup.Builder, IngestionSourceWarmup> {

    @Nullable
    private final Integer lagThreshold;

    @Nullable
    private final Time timeout;

    // ---------------------------------------------------------------------------------------------

    private IngestionSourceWarmup(Builder builder) {
        this.lagThreshold = builder.lagThreshold;
        this.timeout = builder.timeout;
    }

    public static IngestionSourceWarmup of(Function<IngestionSourceWarmup.Builder, ObjectBuilder<IngestionSourceWarmup>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * The lag threshold that triggers warmup.
     * <p>
     * API name: {@code lag_threshold}
     * </p>
     */
    @Nullable
    public final Integer lagThreshold() {
        return this.lagThreshold;
    }

    /**
     * The warmup timeout; <code>-1</code> disables it.
     * <p>
     * API name: {@code timeout}
     * </p>
     */
    @Nullable
    public final Time timeout() {
        return this.timeout;
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
        if (this.lagThreshold != null) {
            generator.writeKey("lag_threshold");
            generator.write(this.lagThreshold);
        }

        if (this.timeout != null) {
            generator.writeKey("timeout");
            this.timeout.serialize(generator, mapper);
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
     * Builder for {@link IngestionSourceWarmup}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, IngestionSourceWarmup> {
        @Nullable
        private Integer lagThreshold;
        @Nullable
        private Time timeout;

        public Builder() {}

        private Builder(IngestionSourceWarmup o) {
            this.lagThreshold = o.lagThreshold;
            this.timeout = o.timeout;
        }

        private Builder(Builder o) {
            this.lagThreshold = o.lagThreshold;
            this.timeout = o.timeout;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * The lag threshold that triggers warmup.
         * <p>
         * API name: {@code lag_threshold}
         * </p>
         */
        @Nonnull
        public final Builder lagThreshold(@Nullable Integer value) {
            this.lagThreshold = value;
            return this;
        }

        /**
         * The warmup timeout; <code>-1</code> disables it.
         * <p>
         * API name: {@code timeout}
         * </p>
         */
        @Nonnull
        public final Builder timeout(@Nullable Time value) {
            this.timeout = value;
            return this;
        }

        /**
         * The warmup timeout; <code>-1</code> disables it.
         * <p>
         * API name: {@code timeout}
         * </p>
         */
        @Nonnull
        public final Builder timeout(Function<Time.Builder, ObjectBuilder<Time>> fn) {
            return timeout(fn.apply(new Time.Builder()).build());
        }

        /**
         * Builds a {@link IngestionSourceWarmup}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public IngestionSourceWarmup build() {
            _checkSingleUse();

            return new IngestionSourceWarmup(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link IngestionSourceWarmup}
     */
    public static final JsonpDeserializer<IngestionSourceWarmup> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        IngestionSourceWarmup::setupIngestionSourceWarmupDeserializer
    );

    protected static void setupIngestionSourceWarmupDeserializer(ObjectDeserializer<IngestionSourceWarmup.Builder> op) {
        op.add(Builder::lagThreshold, JsonpDeserializer.integerDeserializer(), "lag_threshold");
        op.add(Builder::timeout, Time._DESERIALIZER, "timeout");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.lagThreshold);
        result = 31 * result + Objects.hashCode(this.timeout);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        IngestionSourceWarmup other = (IngestionSourceWarmup) o;
        return Objects.equals(this.lagThreshold, other.lagThreshold) && Objects.equals(this.timeout, other.timeout);
    }
}
