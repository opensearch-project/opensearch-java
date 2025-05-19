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
import org.opensearch.client.opensearch._types.Time;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: nodes.stats.GarbageCollectorTotal

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class GarbageCollectorTotal
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<GarbageCollectorTotal.Builder, GarbageCollectorTotal> {

    @Nullable
    private final Long collectionCount;

    @Nullable
    private final Time collectionTime;

    @Nullable
    private final Long collectionTimeInMillis;

    // ---------------------------------------------------------------------------------------------

    private GarbageCollectorTotal(Builder builder) {
        this.collectionCount = builder.collectionCount;
        this.collectionTime = builder.collectionTime;
        this.collectionTimeInMillis = builder.collectionTimeInMillis;
    }

    public static GarbageCollectorTotal of(Function<GarbageCollectorTotal.Builder, ObjectBuilder<GarbageCollectorTotal>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Total number of JVM garbage collectors that collect objects.
     * <p>
     * API name: {@code collection_count}
     * </p>
     */
    @Nullable
    public final Long collectionCount() {
        return this.collectionCount;
    }

    /**
     * Total time spent by JVM collecting objects.
     * <p>
     * API name: {@code collection_time}
     * </p>
     */
    @Nullable
    public final Time collectionTime() {
        return this.collectionTime;
    }

    /**
     * Total time, in milliseconds, spent by JVM collecting objects.
     * <p>
     * API name: {@code collection_time_in_millis}
     * </p>
     */
    @Nullable
    public final Long collectionTimeInMillis() {
        return this.collectionTimeInMillis;
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
        if (this.collectionCount != null) {
            generator.writeKey("collection_count");
            generator.write(this.collectionCount);
        }

        if (this.collectionTime != null) {
            generator.writeKey("collection_time");
            this.collectionTime.serialize(generator, mapper);
        }

        if (this.collectionTimeInMillis != null) {
            generator.writeKey("collection_time_in_millis");
            generator.write(this.collectionTimeInMillis);
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
     * Builder for {@link GarbageCollectorTotal}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, GarbageCollectorTotal> {
        @Nullable
        private Long collectionCount;
        @Nullable
        private Time collectionTime;
        @Nullable
        private Long collectionTimeInMillis;

        public Builder() {}

        private Builder(GarbageCollectorTotal o) {
            this.collectionCount = o.collectionCount;
            this.collectionTime = o.collectionTime;
            this.collectionTimeInMillis = o.collectionTimeInMillis;
        }

        private Builder(Builder o) {
            this.collectionCount = o.collectionCount;
            this.collectionTime = o.collectionTime;
            this.collectionTimeInMillis = o.collectionTimeInMillis;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Total number of JVM garbage collectors that collect objects.
         * <p>
         * API name: {@code collection_count}
         * </p>
         */
        @Nonnull
        public final Builder collectionCount(@Nullable Long value) {
            this.collectionCount = value;
            return this;
        }

        /**
         * Total time spent by JVM collecting objects.
         * <p>
         * API name: {@code collection_time}
         * </p>
         */
        @Nonnull
        public final Builder collectionTime(@Nullable Time value) {
            this.collectionTime = value;
            return this;
        }

        /**
         * Total time spent by JVM collecting objects.
         * <p>
         * API name: {@code collection_time}
         * </p>
         */
        @Nonnull
        public final Builder collectionTime(Function<Time.Builder, ObjectBuilder<Time>> fn) {
            return collectionTime(fn.apply(new Time.Builder()).build());
        }

        /**
         * Total time, in milliseconds, spent by JVM collecting objects.
         * <p>
         * API name: {@code collection_time_in_millis}
         * </p>
         */
        @Nonnull
        public final Builder collectionTimeInMillis(@Nullable Long value) {
            this.collectionTimeInMillis = value;
            return this;
        }

        /**
         * Builds a {@link GarbageCollectorTotal}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public GarbageCollectorTotal build() {
            _checkSingleUse();

            return new GarbageCollectorTotal(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link GarbageCollectorTotal}
     */
    public static final JsonpDeserializer<GarbageCollectorTotal> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        GarbageCollectorTotal::setupGarbageCollectorTotalDeserializer
    );

    protected static void setupGarbageCollectorTotalDeserializer(ObjectDeserializer<GarbageCollectorTotal.Builder> op) {
        op.add(Builder::collectionCount, JsonpDeserializer.longDeserializer(), "collection_count");
        op.add(Builder::collectionTime, Time._DESERIALIZER, "collection_time");
        op.add(Builder::collectionTimeInMillis, JsonpDeserializer.longDeserializer(), "collection_time_in_millis");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.collectionCount);
        result = 31 * result + Objects.hashCode(this.collectionTime);
        result = 31 * result + Objects.hashCode(this.collectionTimeInMillis);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        GarbageCollectorTotal other = (GarbageCollectorTotal) o;
        return Objects.equals(this.collectionCount, other.collectionCount)
            && Objects.equals(this.collectionTime, other.collectionTime)
            && Objects.equals(this.collectionTimeInMillis, other.collectionTimeInMillis);
    }
}
