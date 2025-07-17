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

package org.opensearch.client.opensearch.knn;

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

// typedef: knn.GraphRefreshStats

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class GraphRefreshStats implements PlainJsonSerializable, ToCopyableBuilder<GraphRefreshStats.Builder, GraphRefreshStats> {

    @Nullable
    private final Long total;

    @Nullable
    private final Long totalTimeInMillis;

    // ---------------------------------------------------------------------------------------------

    private GraphRefreshStats(Builder builder) {
        this.total = builder.total;
        this.totalTimeInMillis = builder.totalTimeInMillis;
    }

    public static GraphRefreshStats of(Function<GraphRefreshStats.Builder, ObjectBuilder<GraphRefreshStats>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code total}
     */
    @Nullable
    public final Long total() {
        return this.total;
    }

    /**
     * API name: {@code total_time_in_millis}
     */
    @Nullable
    public final Long totalTimeInMillis() {
        return this.totalTimeInMillis;
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
        if (this.total != null) {
            generator.writeKey("total");
            generator.write(this.total);
        }

        if (this.totalTimeInMillis != null) {
            generator.writeKey("total_time_in_millis");
            generator.write(this.totalTimeInMillis);
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
     * Builder for {@link GraphRefreshStats}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, GraphRefreshStats> {
        @Nullable
        private Long total;
        @Nullable
        private Long totalTimeInMillis;

        public Builder() {}

        private Builder(GraphRefreshStats o) {
            this.total = o.total;
            this.totalTimeInMillis = o.totalTimeInMillis;
        }

        private Builder(Builder o) {
            this.total = o.total;
            this.totalTimeInMillis = o.totalTimeInMillis;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
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
         * API name: {@code total_time_in_millis}
         */
        @Nonnull
        public final Builder totalTimeInMillis(@Nullable Long value) {
            this.totalTimeInMillis = value;
            return this;
        }

        /**
         * Builds a {@link GraphRefreshStats}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public GraphRefreshStats build() {
            _checkSingleUse();

            return new GraphRefreshStats(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link GraphRefreshStats}
     */
    public static final JsonpDeserializer<GraphRefreshStats> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        GraphRefreshStats::setupGraphRefreshStatsDeserializer
    );

    protected static void setupGraphRefreshStatsDeserializer(ObjectDeserializer<GraphRefreshStats.Builder> op) {
        op.add(Builder::total, JsonpDeserializer.longDeserializer(), "total");
        op.add(Builder::totalTimeInMillis, JsonpDeserializer.longDeserializer(), "total_time_in_millis");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.total);
        result = 31 * result + Objects.hashCode(this.totalTimeInMillis);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        GraphRefreshStats other = (GraphRefreshStats) o;
        return Objects.equals(this.total, other.total) && Objects.equals(this.totalTimeInMillis, other.totalTimeInMillis);
    }
}
