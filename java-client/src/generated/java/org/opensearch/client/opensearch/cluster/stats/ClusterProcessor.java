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

package org.opensearch.client.opensearch.cluster.stats;

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
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: cluster.stats.ClusterProcessor

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class ClusterProcessor implements PlainJsonSerializable, ToCopyableBuilder<ClusterProcessor.Builder, ClusterProcessor> {

    private final long count;

    private final long current;

    private final long failed;

    @Nullable
    private final Time time;

    private final long timeInMillis;

    // ---------------------------------------------------------------------------------------------

    private ClusterProcessor(Builder builder) {
        this.count = ApiTypeHelper.requireNonNull(builder.count, this, "count");
        this.current = ApiTypeHelper.requireNonNull(builder.current, this, "current");
        this.failed = ApiTypeHelper.requireNonNull(builder.failed, this, "failed");
        this.time = builder.time;
        this.timeInMillis = ApiTypeHelper.requireNonNull(builder.timeInMillis, this, "timeInMillis");
    }

    public static ClusterProcessor of(Function<ClusterProcessor.Builder, ObjectBuilder<ClusterProcessor>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code count}
     */
    public final long count() {
        return this.count;
    }

    /**
     * Required - API name: {@code current}
     */
    public final long current() {
        return this.current;
    }

    /**
     * Required - API name: {@code failed}
     */
    public final long failed() {
        return this.failed;
    }

    /**
     * API name: {@code time}
     */
    @Nullable
    public final Time time() {
        return this.time;
    }

    /**
     * Required - API name: {@code time_in_millis}
     */
    public final long timeInMillis() {
        return this.timeInMillis;
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
        generator.writeKey("count");
        generator.write(this.count);

        generator.writeKey("current");
        generator.write(this.current);

        generator.writeKey("failed");
        generator.write(this.failed);

        if (this.time != null) {
            generator.writeKey("time");
            this.time.serialize(generator, mapper);
        }

        generator.writeKey("time_in_millis");
        generator.write(this.timeInMillis);
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
     * Builder for {@link ClusterProcessor}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, ClusterProcessor> {
        private Long count;
        private Long current;
        private Long failed;
        @Nullable
        private Time time;
        private Long timeInMillis;

        public Builder() {}

        private Builder(ClusterProcessor o) {
            this.count = o.count;
            this.current = o.current;
            this.failed = o.failed;
            this.time = o.time;
            this.timeInMillis = o.timeInMillis;
        }

        private Builder(Builder o) {
            this.count = o.count;
            this.current = o.current;
            this.failed = o.failed;
            this.time = o.time;
            this.timeInMillis = o.timeInMillis;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - API name: {@code count}
         */
        @Nonnull
        public final Builder count(long value) {
            this.count = value;
            return this;
        }

        /**
         * Required - API name: {@code current}
         */
        @Nonnull
        public final Builder current(long value) {
            this.current = value;
            return this;
        }

        /**
         * Required - API name: {@code failed}
         */
        @Nonnull
        public final Builder failed(long value) {
            this.failed = value;
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
         * Required - API name: {@code time_in_millis}
         */
        @Nonnull
        public final Builder timeInMillis(long value) {
            this.timeInMillis = value;
            return this;
        }

        /**
         * Builds a {@link ClusterProcessor}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ClusterProcessor build() {
            _checkSingleUse();

            return new ClusterProcessor(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ClusterProcessor}
     */
    public static final JsonpDeserializer<ClusterProcessor> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ClusterProcessor::setupClusterProcessorDeserializer
    );

    protected static void setupClusterProcessorDeserializer(ObjectDeserializer<ClusterProcessor.Builder> op) {
        op.add(Builder::count, JsonpDeserializer.longDeserializer(), "count");
        op.add(Builder::current, JsonpDeserializer.longDeserializer(), "current");
        op.add(Builder::failed, JsonpDeserializer.longDeserializer(), "failed");
        op.add(Builder::time, Time._DESERIALIZER, "time");
        op.add(Builder::timeInMillis, JsonpDeserializer.longDeserializer(), "time_in_millis");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Long.hashCode(this.count);
        result = 31 * result + Long.hashCode(this.current);
        result = 31 * result + Long.hashCode(this.failed);
        result = 31 * result + Objects.hashCode(this.time);
        result = 31 * result + Long.hashCode(this.timeInMillis);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ClusterProcessor other = (ClusterProcessor) o;
        return this.count == other.count
            && this.current == other.current
            && this.failed == other.failed
            && Objects.equals(this.time, other.time)
            && this.timeInMillis == other.timeInMillis;
    }
}
