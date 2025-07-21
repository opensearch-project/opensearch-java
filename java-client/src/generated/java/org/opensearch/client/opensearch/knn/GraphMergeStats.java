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

// typedef: knn.GraphMergeStats

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class GraphMergeStats implements PlainJsonSerializable, ToCopyableBuilder<GraphMergeStats.Builder, GraphMergeStats> {

    @Nullable
    private final Long current;

    @Nullable
    private final Long currentDocs;

    @Nullable
    private final Long currentSizeInBytes;

    @Nullable
    private final Long total;

    @Nullable
    private final Long totalDocs;

    @Nullable
    private final Long totalSizeInBytes;

    @Nullable
    private final Long totalTimeInMillis;

    // ---------------------------------------------------------------------------------------------

    private GraphMergeStats(Builder builder) {
        this.current = builder.current;
        this.currentDocs = builder.currentDocs;
        this.currentSizeInBytes = builder.currentSizeInBytes;
        this.total = builder.total;
        this.totalDocs = builder.totalDocs;
        this.totalSizeInBytes = builder.totalSizeInBytes;
        this.totalTimeInMillis = builder.totalTimeInMillis;
    }

    public static GraphMergeStats of(Function<GraphMergeStats.Builder, ObjectBuilder<GraphMergeStats>> fn) {
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
     * API name: {@code current_docs}
     */
    @Nullable
    public final Long currentDocs() {
        return this.currentDocs;
    }

    /**
     * API name: {@code current_size_in_bytes}
     */
    @Nullable
    public final Long currentSizeInBytes() {
        return this.currentSizeInBytes;
    }

    /**
     * API name: {@code total}
     */
    @Nullable
    public final Long total() {
        return this.total;
    }

    /**
     * API name: {@code total_docs}
     */
    @Nullable
    public final Long totalDocs() {
        return this.totalDocs;
    }

    /**
     * API name: {@code total_size_in_bytes}
     */
    @Nullable
    public final Long totalSizeInBytes() {
        return this.totalSizeInBytes;
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
        if (this.current != null) {
            generator.writeKey("current");
            generator.write(this.current);
        }

        if (this.currentDocs != null) {
            generator.writeKey("current_docs");
            generator.write(this.currentDocs);
        }

        if (this.currentSizeInBytes != null) {
            generator.writeKey("current_size_in_bytes");
            generator.write(this.currentSizeInBytes);
        }

        if (this.total != null) {
            generator.writeKey("total");
            generator.write(this.total);
        }

        if (this.totalDocs != null) {
            generator.writeKey("total_docs");
            generator.write(this.totalDocs);
        }

        if (this.totalSizeInBytes != null) {
            generator.writeKey("total_size_in_bytes");
            generator.write(this.totalSizeInBytes);
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
     * Builder for {@link GraphMergeStats}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, GraphMergeStats> {
        @Nullable
        private Long current;
        @Nullable
        private Long currentDocs;
        @Nullable
        private Long currentSizeInBytes;
        @Nullable
        private Long total;
        @Nullable
        private Long totalDocs;
        @Nullable
        private Long totalSizeInBytes;
        @Nullable
        private Long totalTimeInMillis;

        public Builder() {}

        private Builder(GraphMergeStats o) {
            this.current = o.current;
            this.currentDocs = o.currentDocs;
            this.currentSizeInBytes = o.currentSizeInBytes;
            this.total = o.total;
            this.totalDocs = o.totalDocs;
            this.totalSizeInBytes = o.totalSizeInBytes;
            this.totalTimeInMillis = o.totalTimeInMillis;
        }

        private Builder(Builder o) {
            this.current = o.current;
            this.currentDocs = o.currentDocs;
            this.currentSizeInBytes = o.currentSizeInBytes;
            this.total = o.total;
            this.totalDocs = o.totalDocs;
            this.totalSizeInBytes = o.totalSizeInBytes;
            this.totalTimeInMillis = o.totalTimeInMillis;
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
         * API name: {@code current_docs}
         */
        @Nonnull
        public final Builder currentDocs(@Nullable Long value) {
            this.currentDocs = value;
            return this;
        }

        /**
         * API name: {@code current_size_in_bytes}
         */
        @Nonnull
        public final Builder currentSizeInBytes(@Nullable Long value) {
            this.currentSizeInBytes = value;
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
         * API name: {@code total_docs}
         */
        @Nonnull
        public final Builder totalDocs(@Nullable Long value) {
            this.totalDocs = value;
            return this;
        }

        /**
         * API name: {@code total_size_in_bytes}
         */
        @Nonnull
        public final Builder totalSizeInBytes(@Nullable Long value) {
            this.totalSizeInBytes = value;
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
         * Builds a {@link GraphMergeStats}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public GraphMergeStats build() {
            _checkSingleUse();

            return new GraphMergeStats(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link GraphMergeStats}
     */
    public static final JsonpDeserializer<GraphMergeStats> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        GraphMergeStats::setupGraphMergeStatsDeserializer
    );

    protected static void setupGraphMergeStatsDeserializer(ObjectDeserializer<GraphMergeStats.Builder> op) {
        op.add(Builder::current, JsonpDeserializer.longDeserializer(), "current");
        op.add(Builder::currentDocs, JsonpDeserializer.longDeserializer(), "current_docs");
        op.add(Builder::currentSizeInBytes, JsonpDeserializer.longDeserializer(), "current_size_in_bytes");
        op.add(Builder::total, JsonpDeserializer.longDeserializer(), "total");
        op.add(Builder::totalDocs, JsonpDeserializer.longDeserializer(), "total_docs");
        op.add(Builder::totalSizeInBytes, JsonpDeserializer.longDeserializer(), "total_size_in_bytes");
        op.add(Builder::totalTimeInMillis, JsonpDeserializer.longDeserializer(), "total_time_in_millis");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.current);
        result = 31 * result + Objects.hashCode(this.currentDocs);
        result = 31 * result + Objects.hashCode(this.currentSizeInBytes);
        result = 31 * result + Objects.hashCode(this.total);
        result = 31 * result + Objects.hashCode(this.totalDocs);
        result = 31 * result + Objects.hashCode(this.totalSizeInBytes);
        result = 31 * result + Objects.hashCode(this.totalTimeInMillis);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        GraphMergeStats other = (GraphMergeStats) o;
        return Objects.equals(this.current, other.current)
            && Objects.equals(this.currentDocs, other.currentDocs)
            && Objects.equals(this.currentSizeInBytes, other.currentSizeInBytes)
            && Objects.equals(this.total, other.total)
            && Objects.equals(this.totalDocs, other.totalDocs)
            && Objects.equals(this.totalSizeInBytes, other.totalSizeInBytes)
            && Objects.equals(this.totalTimeInMillis, other.totalTimeInMillis);
    }
}
