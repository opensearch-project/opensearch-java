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

// typedef: indices.SlowlogThresholdLevels

/**
 * The threshold levels for slow log.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class SlowlogThresholdLevels
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<SlowlogThresholdLevels.Builder, SlowlogThresholdLevels> {

    @Nullable
    private final Time debug;

    @Nullable
    private final Time info;

    @Nullable
    private final Time trace;

    @Nullable
    private final Time warn;

    // ---------------------------------------------------------------------------------------------

    private SlowlogThresholdLevels(Builder builder) {
        this.debug = builder.debug;
        this.info = builder.info;
        this.trace = builder.trace;
        this.warn = builder.warn;
    }

    public static SlowlogThresholdLevels of(Function<SlowlogThresholdLevels.Builder, ObjectBuilder<SlowlogThresholdLevels>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code debug}
     */
    @Nullable
    public final Time debug() {
        return this.debug;
    }

    /**
     * API name: {@code info}
     */
    @Nullable
    public final Time info() {
        return this.info;
    }

    /**
     * API name: {@code trace}
     */
    @Nullable
    public final Time trace() {
        return this.trace;
    }

    /**
     * API name: {@code warn}
     */
    @Nullable
    public final Time warn() {
        return this.warn;
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
        if (this.debug != null) {
            generator.writeKey("debug");
            this.debug.serialize(generator, mapper);
        }

        if (this.info != null) {
            generator.writeKey("info");
            this.info.serialize(generator, mapper);
        }

        if (this.trace != null) {
            generator.writeKey("trace");
            this.trace.serialize(generator, mapper);
        }

        if (this.warn != null) {
            generator.writeKey("warn");
            this.warn.serialize(generator, mapper);
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
     * Builder for {@link SlowlogThresholdLevels}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, SlowlogThresholdLevels> {
        @Nullable
        private Time debug;
        @Nullable
        private Time info;
        @Nullable
        private Time trace;
        @Nullable
        private Time warn;

        public Builder() {}

        private Builder(SlowlogThresholdLevels o) {
            this.debug = o.debug;
            this.info = o.info;
            this.trace = o.trace;
            this.warn = o.warn;
        }

        private Builder(Builder o) {
            this.debug = o.debug;
            this.info = o.info;
            this.trace = o.trace;
            this.warn = o.warn;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code debug}
         */
        @Nonnull
        public final Builder debug(@Nullable Time value) {
            this.debug = value;
            return this;
        }

        /**
         * API name: {@code debug}
         */
        @Nonnull
        public final Builder debug(Function<Time.Builder, ObjectBuilder<Time>> fn) {
            return debug(fn.apply(new Time.Builder()).build());
        }

        /**
         * API name: {@code info}
         */
        @Nonnull
        public final Builder info(@Nullable Time value) {
            this.info = value;
            return this;
        }

        /**
         * API name: {@code info}
         */
        @Nonnull
        public final Builder info(Function<Time.Builder, ObjectBuilder<Time>> fn) {
            return info(fn.apply(new Time.Builder()).build());
        }

        /**
         * API name: {@code trace}
         */
        @Nonnull
        public final Builder trace(@Nullable Time value) {
            this.trace = value;
            return this;
        }

        /**
         * API name: {@code trace}
         */
        @Nonnull
        public final Builder trace(Function<Time.Builder, ObjectBuilder<Time>> fn) {
            return trace(fn.apply(new Time.Builder()).build());
        }

        /**
         * API name: {@code warn}
         */
        @Nonnull
        public final Builder warn(@Nullable Time value) {
            this.warn = value;
            return this;
        }

        /**
         * API name: {@code warn}
         */
        @Nonnull
        public final Builder warn(Function<Time.Builder, ObjectBuilder<Time>> fn) {
            return warn(fn.apply(new Time.Builder()).build());
        }

        /**
         * Builds a {@link SlowlogThresholdLevels}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public SlowlogThresholdLevels build() {
            _checkSingleUse();

            return new SlowlogThresholdLevels(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link SlowlogThresholdLevels}
     */
    public static final JsonpDeserializer<SlowlogThresholdLevels> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        SlowlogThresholdLevels::setupSlowlogThresholdLevelsDeserializer
    );

    protected static void setupSlowlogThresholdLevelsDeserializer(ObjectDeserializer<SlowlogThresholdLevels.Builder> op) {
        op.add(Builder::debug, Time._DESERIALIZER, "debug");
        op.add(Builder::info, Time._DESERIALIZER, "info");
        op.add(Builder::trace, Time._DESERIALIZER, "trace");
        op.add(Builder::warn, Time._DESERIALIZER, "warn");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.debug);
        result = 31 * result + Objects.hashCode(this.info);
        result = 31 * result + Objects.hashCode(this.trace);
        result = 31 * result + Objects.hashCode(this.warn);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        SlowlogThresholdLevels other = (SlowlogThresholdLevels) o;
        return Objects.equals(this.debug, other.debug)
            && Objects.equals(this.info, other.info)
            && Objects.equals(this.trace, other.trace)
            && Objects.equals(this.warn, other.warn);
    }
}
