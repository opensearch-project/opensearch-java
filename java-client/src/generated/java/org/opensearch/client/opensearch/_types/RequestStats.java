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

package org.opensearch.client.opensearch._types;

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

// typedef: _types.RequestStats

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class RequestStats implements PlainJsonSerializable, ToCopyableBuilder<RequestStats.Builder, RequestStats> {

    @Nullable
    private final Long current;

    @Nullable
    private final Time time;

    @Nullable
    private final Long timeInMillis;

    @Nullable
    private final Long total;

    // ---------------------------------------------------------------------------------------------

    private RequestStats(Builder builder) {
        this.current = builder.current;
        this.time = builder.time;
        this.timeInMillis = builder.timeInMillis;
        this.total = builder.total;
    }

    public static RequestStats of(Function<RequestStats.Builder, ObjectBuilder<RequestStats>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code current}
     */
    @Nullable
    public final Long current() {
        return this.current;
    }

    /**
     * API name: {@code time}
     */
    @Nullable
    public final Time time() {
        return this.time;
    }

    /**
     * API name: {@code time_in_millis}
     */
    @Nullable
    public final Long timeInMillis() {
        return this.timeInMillis;
    }

    /**
     * API name: {@code total}
     */
    @Nullable
    public final Long total() {
        return this.total;
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
        if (this.current != null) {
            generator.writeKey("current");
            generator.write(this.current);
        }

        if (this.time != null) {
            generator.writeKey("time");
            this.time.serialize(generator, mapper);
        }

        if (this.timeInMillis != null) {
            generator.writeKey("time_in_millis");
            generator.write(this.timeInMillis);
        }

        if (this.total != null) {
            generator.writeKey("total");
            generator.write(this.total);
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
     * Builder for {@link RequestStats}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, RequestStats> {
        @Nullable
        private Long current;
        @Nullable
        private Time time;
        @Nullable
        private Long timeInMillis;
        @Nullable
        private Long total;

        public Builder() {}

        private Builder(RequestStats o) {
            this.current = o.current;
            this.time = o.time;
            this.timeInMillis = o.timeInMillis;
            this.total = o.total;
        }

        private Builder(Builder o) {
            this.current = o.current;
            this.time = o.time;
            this.timeInMillis = o.timeInMillis;
            this.total = o.total;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code current}
         */
        @Nonnull
        public final Builder current(@Nullable Long value) {
            this.current = value;
            return this;
        }

        /**
         * API name: {@code time}
         */
        @Nonnull
        public final Builder time(@Nullable Time value) {
            this.time = value;
            return this;
        }

        /**
         * API name: {@code time}
         */
        @Nonnull
        public final Builder time(Function<Time.Builder, ObjectBuilder<Time>> fn) {
            return time(fn.apply(new Time.Builder()).build());
        }

        /**
         * API name: {@code time_in_millis}
         */
        @Nonnull
        public final Builder timeInMillis(@Nullable Long value) {
            this.timeInMillis = value;
            return this;
        }

        /**
         * API name: {@code total}
         */
        @Nonnull
        public final Builder total(@Nullable Long value) {
            this.total = value;
            return this;
        }

        /**
         * Builds a {@link RequestStats}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public RequestStats build() {
            _checkSingleUse();

            return new RequestStats(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link RequestStats}
     */
    public static final JsonpDeserializer<RequestStats> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        RequestStats::setupRequestStatsDeserializer
    );

    protected static void setupRequestStatsDeserializer(ObjectDeserializer<RequestStats.Builder> op) {
        op.add(Builder::current, JsonpDeserializer.longDeserializer(), "current");
        op.add(Builder::time, Time._DESERIALIZER, "time");
        op.add(Builder::timeInMillis, JsonpDeserializer.longDeserializer(), "time_in_millis");
        op.add(Builder::total, JsonpDeserializer.longDeserializer(), "total");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.current);
        result = 31 * result + Objects.hashCode(this.time);
        result = 31 * result + Objects.hashCode(this.timeInMillis);
        result = 31 * result + Objects.hashCode(this.total);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        RequestStats other = (RequestStats) o;
        return Objects.equals(this.current, other.current)
            && Objects.equals(this.time, other.time)
            && Objects.equals(this.timeInMillis, other.timeInMillis)
            && Objects.equals(this.total, other.total);
    }
}
