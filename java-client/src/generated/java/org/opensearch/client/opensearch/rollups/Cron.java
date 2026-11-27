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

package org.opensearch.client.opensearch.rollups;

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

// typedef: rollups.Cron

/**
 * Defines a cron schedule for the rollup job execution.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class Cron implements PlainJsonSerializable, ToCopyableBuilder<Cron.Builder, Cron> {

    @Nullable
    private final String expression;

    @Nullable
    private final Long scheduleDelay;

    @Nullable
    private final String timezone;

    // ---------------------------------------------------------------------------------------------

    private Cron(Builder builder) {
        this.expression = builder.expression;
        this.scheduleDelay = builder.scheduleDelay;
        this.timezone = builder.timezone;
    }

    public static Cron of(Function<Cron.Builder, ObjectBuilder<Cron>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * The cron expression that defines the schedule.
     * <p>
     * API name: {@code expression}
     * </p>
     */
    @Nullable
    public final String expression() {
        return this.expression;
    }

    /**
     * The delay in milliseconds before starting the rollup process.
     * <p>
     * API name: {@code schedule_delay}
     * </p>
     */
    @Nullable
    public final Long scheduleDelay() {
        return this.scheduleDelay;
    }

    /**
     * The timezone for interpreting the cron expression.
     * <p>
     * API name: {@code timezone}
     * </p>
     */
    @Nullable
    public final String timezone() {
        return this.timezone;
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
        if (this.expression != null) {
            generator.writeKey("expression");
            generator.write(this.expression);
        }

        if (this.scheduleDelay != null) {
            generator.writeKey("schedule_delay");
            generator.write(this.scheduleDelay);
        }

        if (this.timezone != null) {
            generator.writeKey("timezone");
            generator.write(this.timezone);
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
     * Builder for {@link Cron}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, Cron> {
        @Nullable
        private String expression;
        @Nullable
        private Long scheduleDelay;
        @Nullable
        private String timezone;

        public Builder() {}

        private Builder(Cron o) {
            this.expression = o.expression;
            this.scheduleDelay = o.scheduleDelay;
            this.timezone = o.timezone;
        }

        private Builder(Builder o) {
            this.expression = o.expression;
            this.scheduleDelay = o.scheduleDelay;
            this.timezone = o.timezone;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * The cron expression that defines the schedule.
         * <p>
         * API name: {@code expression}
         * </p>
         */
        @Nonnull
        public final Builder expression(@Nullable String value) {
            this.expression = value;
            return this;
        }

        /**
         * The delay in milliseconds before starting the rollup process.
         * <p>
         * API name: {@code schedule_delay}
         * </p>
         */
        @Nonnull
        public final Builder scheduleDelay(@Nullable Long value) {
            this.scheduleDelay = value;
            return this;
        }

        /**
         * The timezone for interpreting the cron expression.
         * <p>
         * API name: {@code timezone}
         * </p>
         */
        @Nonnull
        public final Builder timezone(@Nullable String value) {
            this.timezone = value;
            return this;
        }

        /**
         * Builds a {@link Cron}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public Cron build() {
            _checkSingleUse();

            return new Cron(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link Cron}
     */
    public static final JsonpDeserializer<Cron> _DESERIALIZER = ObjectBuilderDeserializer.lazy(Builder::new, Cron::setupCronDeserializer);

    protected static void setupCronDeserializer(ObjectDeserializer<Cron.Builder> op) {
        op.add(Builder::expression, JsonpDeserializer.stringDeserializer(), "expression");
        op.add(Builder::scheduleDelay, JsonpDeserializer.longDeserializer(), "schedule_delay");
        op.add(Builder::timezone, JsonpDeserializer.stringDeserializer(), "timezone");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.expression);
        result = 31 * result + Objects.hashCode(this.scheduleDelay);
        result = 31 * result + Objects.hashCode(this.timezone);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Cron other = (Cron) o;
        return Objects.equals(this.expression, other.expression)
            && Objects.equals(this.scheduleDelay, other.scheduleDelay)
            && Objects.equals(this.timezone, other.timezone);
    }
}
