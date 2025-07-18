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

package org.opensearch.client.opensearch.ltr;

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

// typedef: ltr.NodeStats

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class NodeStats implements PlainJsonSerializable, ToCopyableBuilder<NodeStats.Builder, NodeStats> {

    @Nullable
    private final CacheStats cache;

    @Nullable
    private final Integer requestErrorCount;

    @Nullable
    private final Integer requestTotalCount;

    // ---------------------------------------------------------------------------------------------

    private NodeStats(Builder builder) {
        this.cache = builder.cache;
        this.requestErrorCount = builder.requestErrorCount;
        this.requestTotalCount = builder.requestTotalCount;
    }

    public static NodeStats of(Function<NodeStats.Builder, ObjectBuilder<NodeStats>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code cache}
     */
    @Nullable
    public final CacheStats cache() {
        return this.cache;
    }

    /**
     * API name: {@code request_error_count}
     */
    @Nullable
    public final Integer requestErrorCount() {
        return this.requestErrorCount;
    }

    /**
     * API name: {@code request_total_count}
     */
    @Nullable
    public final Integer requestTotalCount() {
        return this.requestTotalCount;
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
        if (this.cache != null) {
            generator.writeKey("cache");
            this.cache.serialize(generator, mapper);
        }

        if (this.requestErrorCount != null) {
            generator.writeKey("request_error_count");
            generator.write(this.requestErrorCount);
        }

        if (this.requestTotalCount != null) {
            generator.writeKey("request_total_count");
            generator.write(this.requestTotalCount);
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
     * Builder for {@link NodeStats}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, NodeStats> {
        @Nullable
        private CacheStats cache;
        @Nullable
        private Integer requestErrorCount;
        @Nullable
        private Integer requestTotalCount;

        public Builder() {}

        private Builder(NodeStats o) {
            this.cache = o.cache;
            this.requestErrorCount = o.requestErrorCount;
            this.requestTotalCount = o.requestTotalCount;
        }

        private Builder(Builder o) {
            this.cache = o.cache;
            this.requestErrorCount = o.requestErrorCount;
            this.requestTotalCount = o.requestTotalCount;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code cache}
         */
        @Nonnull
        public final Builder cache(@Nullable CacheStats value) {
            this.cache = value;
            return this;
        }

        /**
         * API name: {@code cache}
         */
        @Nonnull
        public final Builder cache(Function<CacheStats.Builder, ObjectBuilder<CacheStats>> fn) {
            return cache(fn.apply(new CacheStats.Builder()).build());
        }

        /**
         * API name: {@code request_error_count}
         */
        @Nonnull
        public final Builder requestErrorCount(@Nullable Integer value) {
            this.requestErrorCount = value;
            return this;
        }

        /**
         * API name: {@code request_total_count}
         */
        @Nonnull
        public final Builder requestTotalCount(@Nullable Integer value) {
            this.requestTotalCount = value;
            return this;
        }

        /**
         * Builds a {@link NodeStats}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public NodeStats build() {
            _checkSingleUse();

            return new NodeStats(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link NodeStats}
     */
    public static final JsonpDeserializer<NodeStats> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        NodeStats::setupNodeStatsDeserializer
    );

    protected static void setupNodeStatsDeserializer(ObjectDeserializer<NodeStats.Builder> op) {
        op.add(Builder::cache, CacheStats._DESERIALIZER, "cache");
        op.add(Builder::requestErrorCount, JsonpDeserializer.integerDeserializer(), "request_error_count");
        op.add(Builder::requestTotalCount, JsonpDeserializer.integerDeserializer(), "request_total_count");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.cache);
        result = 31 * result + Objects.hashCode(this.requestErrorCount);
        result = 31 * result + Objects.hashCode(this.requestTotalCount);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        NodeStats other = (NodeStats) o;
        return Objects.equals(this.cache, other.cache)
            && Objects.equals(this.requestErrorCount, other.requestErrorCount)
            && Objects.equals(this.requestTotalCount, other.requestTotalCount);
    }
}
