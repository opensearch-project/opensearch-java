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

// typedef: nodes.stats.TransportUsageStats

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class TransportUsageStats implements PlainJsonSerializable, ToCopyableBuilder<TransportUsageStats.Builder, TransportUsageStats> {

    @Nonnull
    private final Map<String, Long> rejectionCount;

    // ---------------------------------------------------------------------------------------------

    private TransportUsageStats(Builder builder) {
        this.rejectionCount = ApiTypeHelper.unmodifiable(builder.rejectionCount);
    }

    public static TransportUsageStats of(Function<TransportUsageStats.Builder, ObjectBuilder<TransportUsageStats>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code rejection_count}
     */
    @Nonnull
    public final Map<String, Long> rejectionCount() {
        return this.rejectionCount;
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
        if (ApiTypeHelper.isDefined(this.rejectionCount)) {
            generator.writeKey("rejection_count");
            generator.writeStartObject();
            for (Map.Entry<String, Long> item0 : this.rejectionCount.entrySet()) {
                generator.writeKey(item0.getKey());
                generator.write(item0.getValue());
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
     * Builder for {@link TransportUsageStats}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, TransportUsageStats> {
        @Nullable
        private Map<String, Long> rejectionCount;

        public Builder() {}

        private Builder(TransportUsageStats o) {
            this.rejectionCount = _mapCopy(o.rejectionCount);
        }

        private Builder(Builder o) {
            this.rejectionCount = _mapCopy(o.rejectionCount);
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code rejection_count}
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>rejectionCount</code>.
         * </p>
         */
        @Nonnull
        public final Builder rejectionCount(Map<String, Long> map) {
            this.rejectionCount = _mapPutAll(this.rejectionCount, map);
            return this;
        }

        /**
         * API name: {@code rejection_count}
         *
         * <p>
         * Adds an entry to <code>rejectionCount</code>.
         * </p>
         */
        @Nonnull
        public final Builder rejectionCount(String key, Long value) {
            this.rejectionCount = _mapPut(this.rejectionCount, key, value);
            return this;
        }

        /**
         * Builds a {@link TransportUsageStats}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public TransportUsageStats build() {
            _checkSingleUse();

            return new TransportUsageStats(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link TransportUsageStats}
     */
    public static final JsonpDeserializer<TransportUsageStats> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        TransportUsageStats::setupTransportUsageStatsDeserializer
    );

    protected static void setupTransportUsageStatsDeserializer(ObjectDeserializer<TransportUsageStats.Builder> op) {
        op.add(Builder::rejectionCount, JsonpDeserializer.stringMapDeserializer(JsonpDeserializer.longDeserializer()), "rejection_count");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.rejectionCount);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        TransportUsageStats other = (TransportUsageStats) o;
        return Objects.equals(this.rejectionCount, other.rejectionCount);
    }
}
