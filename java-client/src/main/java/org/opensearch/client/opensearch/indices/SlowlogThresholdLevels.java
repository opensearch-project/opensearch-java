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

package org.opensearch.client.opensearch.indices;

import jakarta.json.stream.JsonGenerator;
import java.util.function.Function;
import javax.annotation.Nullable;
import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.json.PlainJsonSerializable;
import org.opensearch.client.opensearch._types.Time;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;

// typedef: indices._types.SlowlogTresholdLevels

@JsonpDeserializable
public class SlowlogThresholdLevels implements PlainJsonSerializable {
    @Nullable
    private final Time warn;

    @Nullable
    private final Time info;

    @Nullable
    private final Time debug;

    @Nullable
    private final Time trace;

    // ---------------------------------------------------------------------------------------------

    private SlowlogThresholdLevels(Builder builder) {

        this.warn = builder.warn;
        this.info = builder.info;
        this.debug = builder.debug;
        this.trace = builder.trace;

    }

    public static SlowlogThresholdLevels of(Function<Builder, ObjectBuilder<SlowlogThresholdLevels>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code warn}
     */
    @Nullable
    public final Time warn() {
        return this.warn;
    }

    /**
     * API name: {@code info}
     */
    @Nullable
    public final Time info() {
        return this.info;
    }

    /**
     * API name: {@code debug}
     */
    @Nullable
    public final Time debug() {
        return this.debug;
    }

    /**
     * API name: {@code trace}
     */
    @Nullable
    public final Time trace() {
        return this.trace;
    }

    /**
     * Serialize this object to JSON.
     */
    public void serialize(JsonGenerator generator, JsonpMapper mapper) {
        generator.writeStartObject();
        serializeInternal(generator, mapper);
        generator.writeEnd();
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {

        if (this.warn != null) {
            generator.writeKey("warn");
            this.warn.serialize(generator, mapper);

        }
        if (this.info != null) {
            generator.writeKey("info");
            this.info.serialize(generator, mapper);

        }
        if (this.debug != null) {
            generator.writeKey("debug");
            this.debug.serialize(generator, mapper);

        }
        if (this.trace != null) {
            generator.writeKey("trace");
            this.trace.serialize(generator, mapper);

        }

    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Builder for {@link SlowlogThresholdLevels}.
     */
    public static class Builder extends ObjectBuilderBase implements ObjectBuilder<SlowlogThresholdLevels> {
        @Nullable
        private Time warn;

        @Nullable
        private Time info;

        @Nullable
        private Time debug;

        @Nullable
        private Time trace;

        /**
         * API name: {@code warn}
         */
        public final Builder warn(@Nullable Time value) {
            this.warn = value;
            return this;
        }

        /**
         * API name: {@code warn}
         */
        public final Builder warn(Function<Time.Builder, ObjectBuilder<Time>> fn) {
            return this.warn(fn.apply(new Time.Builder()).build());
        }

        /**
         * API name: {@code info}
         */
        public final Builder info(@Nullable Time value) {
            this.info = value;
            return this;
        }

        /**
         * API name: {@code info}
         */
        public final Builder info(Function<Time.Builder, ObjectBuilder<Time>> fn) {
            return this.info(fn.apply(new Time.Builder()).build());
        }

        /**
         * API name: {@code debug}
         */
        public final Builder debug(@Nullable Time value) {
            this.debug = value;
            return this;
        }

        /**
         * API name: {@code debug}
         */
        public final Builder debug(Function<Time.Builder, ObjectBuilder<Time>> fn) {
            return this.debug(fn.apply(new Time.Builder()).build());
        }

        /**
         * API name: {@code trace}
         */
        public final Builder trace(@Nullable Time value) {
            this.trace = value;
            return this;
        }

        /**
         * API name: {@code trace}
         */
        public final Builder trace(Function<Time.Builder, ObjectBuilder<Time>> fn) {
            return this.trace(fn.apply(new Time.Builder()).build());
        }

        /**
         * Builds a {@link SlowlogThresholdLevels}.
         *
         * @throws NullPointerException
         *             if some of the required fields are null.
         */
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
        SlowlogThresholdLevels::setupSlowlogTresholdLevelsDeserializer
    );

    protected static void setupSlowlogTresholdLevelsDeserializer(ObjectDeserializer<Builder> op) {

        op.add(Builder::warn, Time._DESERIALIZER, "warn");
        op.add(Builder::info, Time._DESERIALIZER, "info");
        op.add(Builder::debug, Time._DESERIALIZER, "debug");
        op.add(Builder::trace, Time._DESERIALIZER, "trace");

    }

}
