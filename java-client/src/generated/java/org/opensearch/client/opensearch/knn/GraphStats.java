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

// typedef: knn.GraphStats

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class GraphStats implements PlainJsonSerializable, ToCopyableBuilder<GraphStats.Builder, GraphStats> {

    @Nullable
    private final GraphMergeStats merge;

    @Nullable
    private final GraphRefreshStats refresh;

    // ---------------------------------------------------------------------------------------------

    private GraphStats(Builder builder) {
        this.merge = builder.merge;
        this.refresh = builder.refresh;
    }

    public static GraphStats of(Function<GraphStats.Builder, ObjectBuilder<GraphStats>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code merge}
     */
    @Nullable
    public final GraphMergeStats merge() {
        return this.merge;
    }

    /**
     * API name: {@code refresh}
     */
    @Nullable
    public final GraphRefreshStats refresh() {
        return this.refresh;
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
        if (this.merge != null) {
            generator.writeKey("merge");
            this.merge.serialize(generator, mapper);
        }

        if (this.refresh != null) {
            generator.writeKey("refresh");
            this.refresh.serialize(generator, mapper);
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
     * Builder for {@link GraphStats}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, GraphStats> {
        @Nullable
        private GraphMergeStats merge;
        @Nullable
        private GraphRefreshStats refresh;

        public Builder() {}

        private Builder(GraphStats o) {
            this.merge = o.merge;
            this.refresh = o.refresh;
        }

        private Builder(Builder o) {
            this.merge = o.merge;
            this.refresh = o.refresh;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code merge}
         */
        @Nonnull
        public final Builder merge(@Nullable GraphMergeStats value) {
            this.merge = value;
            return this;
        }

        /**
         * API name: {@code merge}
         */
        @Nonnull
        public final Builder merge(Function<GraphMergeStats.Builder, ObjectBuilder<GraphMergeStats>> fn) {
            return merge(fn.apply(new GraphMergeStats.Builder()).build());
        }

        /**
         * API name: {@code refresh}
         */
        @Nonnull
        public final Builder refresh(@Nullable GraphRefreshStats value) {
            this.refresh = value;
            return this;
        }

        /**
         * API name: {@code refresh}
         */
        @Nonnull
        public final Builder refresh(Function<GraphRefreshStats.Builder, ObjectBuilder<GraphRefreshStats>> fn) {
            return refresh(fn.apply(new GraphRefreshStats.Builder()).build());
        }

        /**
         * Builds a {@link GraphStats}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public GraphStats build() {
            _checkSingleUse();

            return new GraphStats(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link GraphStats}
     */
    public static final JsonpDeserializer<GraphStats> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        GraphStats::setupGraphStatsDeserializer
    );

    protected static void setupGraphStatsDeserializer(ObjectDeserializer<GraphStats.Builder> op) {
        op.add(Builder::merge, GraphMergeStats._DESERIALIZER, "merge");
        op.add(Builder::refresh, GraphRefreshStats._DESERIALIZER, "refresh");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.merge);
        result = 31 * result + Objects.hashCode(this.refresh);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        GraphStats other = (GraphStats) o;
        return Objects.equals(this.merge, other.merge) && Objects.equals(this.refresh, other.refresh);
    }
}
