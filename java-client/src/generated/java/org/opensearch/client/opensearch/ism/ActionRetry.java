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

package org.opensearch.client.opensearch.ism;

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

// typedef: ism.ActionRetry

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class ActionRetry implements PlainJsonSerializable, ToCopyableBuilder<ActionRetry.Builder, ActionRetry> {

    @Nullable
    private final String backoff;

    @Nullable
    private final Integer count;

    @Nullable
    private final String delay;

    // ---------------------------------------------------------------------------------------------

    private ActionRetry(Builder builder) {
        this.backoff = builder.backoff;
        this.count = builder.count;
        this.delay = builder.delay;
    }

    public static ActionRetry of(Function<ActionRetry.Builder, ObjectBuilder<ActionRetry>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * The backoff strategy for retries.
     * <p>
     * API name: {@code backoff}
     * </p>
     */
    @Nullable
    public final String backoff() {
        return this.backoff;
    }

    /**
     * The number of retry attempts.
     * <p>
     * API name: {@code count}
     * </p>
     */
    @Nullable
    public final Integer count() {
        return this.count;
    }

    /**
     * The delay between retry attempts.
     * <p>
     * API name: {@code delay}
     * </p>
     */
    @Nullable
    public final String delay() {
        return this.delay;
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
        if (this.backoff != null) {
            generator.writeKey("backoff");
            generator.write(this.backoff);
        }

        if (this.count != null) {
            generator.writeKey("count");
            generator.write(this.count);
        }

        if (this.delay != null) {
            generator.writeKey("delay");
            generator.write(this.delay);
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
     * Builder for {@link ActionRetry}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, ActionRetry> {
        @Nullable
        private String backoff;
        @Nullable
        private Integer count;
        @Nullable
        private String delay;

        public Builder() {}

        private Builder(ActionRetry o) {
            this.backoff = o.backoff;
            this.count = o.count;
            this.delay = o.delay;
        }

        private Builder(Builder o) {
            this.backoff = o.backoff;
            this.count = o.count;
            this.delay = o.delay;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * The backoff strategy for retries.
         * <p>
         * API name: {@code backoff}
         * </p>
         */
        @Nonnull
        public final Builder backoff(@Nullable String value) {
            this.backoff = value;
            return this;
        }

        /**
         * The number of retry attempts.
         * <p>
         * API name: {@code count}
         * </p>
         */
        @Nonnull
        public final Builder count(@Nullable Integer value) {
            this.count = value;
            return this;
        }

        /**
         * The delay between retry attempts.
         * <p>
         * API name: {@code delay}
         * </p>
         */
        @Nonnull
        public final Builder delay(@Nullable String value) {
            this.delay = value;
            return this;
        }

        /**
         * Builds a {@link ActionRetry}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ActionRetry build() {
            _checkSingleUse();

            return new ActionRetry(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ActionRetry}
     */
    public static final JsonpDeserializer<ActionRetry> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ActionRetry::setupActionRetryDeserializer
    );

    protected static void setupActionRetryDeserializer(ObjectDeserializer<ActionRetry.Builder> op) {
        op.add(Builder::backoff, JsonpDeserializer.stringDeserializer(), "backoff");
        op.add(Builder::count, JsonpDeserializer.integerDeserializer(), "count");
        op.add(Builder::delay, JsonpDeserializer.stringDeserializer(), "delay");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.backoff);
        result = 31 * result + Objects.hashCode(this.count);
        result = 31 * result + Objects.hashCode(this.delay);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ActionRetry other = (ActionRetry) o;
        return Objects.equals(this.backoff, other.backoff)
            && Objects.equals(this.count, other.count)
            && Objects.equals(this.delay, other.delay);
    }
}
