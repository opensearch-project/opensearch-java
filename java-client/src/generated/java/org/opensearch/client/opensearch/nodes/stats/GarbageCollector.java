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
import java.util.Map;
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
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: nodes.stats.GarbageCollector

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class GarbageCollector implements PlainJsonSerializable, ToCopyableBuilder<GarbageCollector.Builder, GarbageCollector> {

    @Nonnull
    private final Map<String, GarbageCollectorTotal> collectors;

    // ---------------------------------------------------------------------------------------------

    private GarbageCollector(Builder builder) {
        this.collectors = ApiTypeHelper.unmodifiable(builder.collectors);
    }

    public static GarbageCollector of(Function<GarbageCollector.Builder, ObjectBuilder<GarbageCollector>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Contains statistics about JVM garbage collectors for the node.
     * <p>
     * API name: {@code collectors}
     * </p>
     */
    @Nonnull
    public final Map<String, GarbageCollectorTotal> collectors() {
        return this.collectors;
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
        if (ApiTypeHelper.isDefined(this.collectors)) {
            generator.writeKey("collectors");
            generator.writeStartObject();
            for (Map.Entry<String, GarbageCollectorTotal> item0 : this.collectors.entrySet()) {
                generator.writeKey(item0.getKey());
                item0.getValue().serialize(generator, mapper);
            }
            generator.writeEnd();
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
     * Builder for {@link GarbageCollector}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, GarbageCollector> {
        @Nullable
        private Map<String, GarbageCollectorTotal> collectors;

        public Builder() {}

        private Builder(GarbageCollector o) {
            this.collectors = _mapCopy(o.collectors);
        }

        private Builder(Builder o) {
            this.collectors = _mapCopy(o.collectors);
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Contains statistics about JVM garbage collectors for the node.
         * <p>
         * API name: {@code collectors}
         * </p>
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>collectors</code>.
         * </p>
         */
        @Nonnull
        public final Builder collectors(Map<String, GarbageCollectorTotal> map) {
            this.collectors = _mapPutAll(this.collectors, map);
            return this;
        }

        /**
         * Contains statistics about JVM garbage collectors for the node.
         * <p>
         * API name: {@code collectors}
         * </p>
         *
         * <p>
         * Adds an entry to <code>collectors</code>.
         * </p>
         */
        @Nonnull
        public final Builder collectors(String key, GarbageCollectorTotal value) {
            this.collectors = _mapPut(this.collectors, key, value);
            return this;
        }

        /**
         * Contains statistics about JVM garbage collectors for the node.
         * <p>
         * API name: {@code collectors}
         * </p>
         *
         * <p>
         * Adds a value to <code>collectors</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder collectors(String key, Function<GarbageCollectorTotal.Builder, ObjectBuilder<GarbageCollectorTotal>> fn) {
            return collectors(key, fn.apply(new GarbageCollectorTotal.Builder()).build());
        }

        /**
         * Builds a {@link GarbageCollector}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public GarbageCollector build() {
            _checkSingleUse();

            return new GarbageCollector(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link GarbageCollector}
     */
    public static final JsonpDeserializer<GarbageCollector> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        GarbageCollector::setupGarbageCollectorDeserializer
    );

    protected static void setupGarbageCollectorDeserializer(ObjectDeserializer<GarbageCollector.Builder> op) {
        op.add(Builder::collectors, JsonpDeserializer.stringMapDeserializer(GarbageCollectorTotal._DESERIALIZER), "collectors");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.collectors);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        GarbageCollector other = (GarbageCollector) o;
        return Objects.equals(this.collectors, other.collectors);
    }
}
