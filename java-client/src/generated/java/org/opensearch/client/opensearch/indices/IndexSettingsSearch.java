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

package org.opensearch.client.opensearch.indices;

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

// typedef: indices.IndexSettingsSearch

/**
 * The configuration for search operations.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class IndexSettingsSearch implements PlainJsonSerializable, ToCopyableBuilder<IndexSettingsSearch.Builder, IndexSettingsSearch> {

    @Nullable
    private final IndexSettingsSearchConcurrent concurrent;

    @Nullable
    private final IndexSettingsSearchConcurrentSegmentSearch concurrentSegmentSearch;

    @Nullable
    private final String defaultPipeline;

    @Nullable
    private final SearchIdle idle;

    @Nullable
    private final SearchSlowlog slowlog;

    @Nullable
    private final IndexSettingsSearchStarTreeIndex starTreeIndex;

    @Nullable
    private final Boolean throttled;

    // ---------------------------------------------------------------------------------------------

    private IndexSettingsSearch(Builder builder) {
        this.concurrent = builder.concurrent;
        this.concurrentSegmentSearch = builder.concurrentSegmentSearch;
        this.defaultPipeline = builder.defaultPipeline;
        this.idle = builder.idle;
        this.slowlog = builder.slowlog;
        this.starTreeIndex = builder.starTreeIndex;
        this.throttled = builder.throttled;
    }

    public static IndexSettingsSearch of(Function<IndexSettingsSearch.Builder, ObjectBuilder<IndexSettingsSearch>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code concurrent}
     */
    @Nullable
    public final IndexSettingsSearchConcurrent concurrent() {
        return this.concurrent;
    }

    /**
     * API name: {@code concurrent_segment_search}
     */
    @Nullable
    public final IndexSettingsSearchConcurrentSegmentSearch concurrentSegmentSearch() {
        return this.concurrentSegmentSearch;
    }

    /**
     * The default search pipeline to use.
     * <p>
     * API name: {@code default_pipeline}
     * </p>
     */
    @Nullable
    public final String defaultPipeline() {
        return this.defaultPipeline;
    }

    /**
     * API name: {@code idle}
     */
    @Nullable
    public final SearchIdle idle() {
        return this.idle;
    }

    /**
     * API name: {@code slowlog}
     */
    @Nullable
    public final SearchSlowlog slowlog() {
        return this.slowlog;
    }

    /**
     * API name: {@code star_tree_index}
     */
    @Nullable
    public final IndexSettingsSearchStarTreeIndex starTreeIndex() {
        return this.starTreeIndex;
    }

    /**
     * API name: {@code throttled}
     */
    @Nullable
    public final Boolean throttled() {
        return this.throttled;
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
        if (this.concurrent != null) {
            generator.writeKey("concurrent");
            this.concurrent.serialize(generator, mapper);
        }

        if (this.concurrentSegmentSearch != null) {
            generator.writeKey("concurrent_segment_search");
            this.concurrentSegmentSearch.serialize(generator, mapper);
        }

        if (this.defaultPipeline != null) {
            generator.writeKey("default_pipeline");
            generator.write(this.defaultPipeline);
        }

        if (this.idle != null) {
            generator.writeKey("idle");
            this.idle.serialize(generator, mapper);
        }

        if (this.slowlog != null) {
            generator.writeKey("slowlog");
            this.slowlog.serialize(generator, mapper);
        }

        if (this.starTreeIndex != null) {
            generator.writeKey("star_tree_index");
            this.starTreeIndex.serialize(generator, mapper);
        }

        if (this.throttled != null) {
            generator.writeKey("throttled");
            generator.write(this.throttled);
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
     * Builder for {@link IndexSettingsSearch}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, IndexSettingsSearch> {
        @Nullable
        private IndexSettingsSearchConcurrent concurrent;
        @Nullable
        private IndexSettingsSearchConcurrentSegmentSearch concurrentSegmentSearch;
        @Nullable
        private String defaultPipeline;
        @Nullable
        private SearchIdle idle;
        @Nullable
        private SearchSlowlog slowlog;
        @Nullable
        private IndexSettingsSearchStarTreeIndex starTreeIndex;
        @Nullable
        private Boolean throttled;

        public Builder() {}

        private Builder(IndexSettingsSearch o) {
            this.concurrent = o.concurrent;
            this.concurrentSegmentSearch = o.concurrentSegmentSearch;
            this.defaultPipeline = o.defaultPipeline;
            this.idle = o.idle;
            this.slowlog = o.slowlog;
            this.starTreeIndex = o.starTreeIndex;
            this.throttled = o.throttled;
        }

        private Builder(Builder o) {
            this.concurrent = o.concurrent;
            this.concurrentSegmentSearch = o.concurrentSegmentSearch;
            this.defaultPipeline = o.defaultPipeline;
            this.idle = o.idle;
            this.slowlog = o.slowlog;
            this.starTreeIndex = o.starTreeIndex;
            this.throttled = o.throttled;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code concurrent}
         */
        @Nonnull
        public final Builder concurrent(@Nullable IndexSettingsSearchConcurrent value) {
            this.concurrent = value;
            return this;
        }

        /**
         * API name: {@code concurrent}
         */
        @Nonnull
        public final Builder concurrent(Function<IndexSettingsSearchConcurrent.Builder, ObjectBuilder<IndexSettingsSearchConcurrent>> fn) {
            return concurrent(fn.apply(new IndexSettingsSearchConcurrent.Builder()).build());
        }

        /**
         * API name: {@code concurrent_segment_search}
         */
        @Nonnull
        public final Builder concurrentSegmentSearch(@Nullable IndexSettingsSearchConcurrentSegmentSearch value) {
            this.concurrentSegmentSearch = value;
            return this;
        }

        /**
         * API name: {@code concurrent_segment_search}
         */
        @Nonnull
        public final Builder concurrentSegmentSearch(
            Function<IndexSettingsSearchConcurrentSegmentSearch.Builder, ObjectBuilder<IndexSettingsSearchConcurrentSegmentSearch>> fn
        ) {
            return concurrentSegmentSearch(fn.apply(new IndexSettingsSearchConcurrentSegmentSearch.Builder()).build());
        }

        /**
         * The default search pipeline to use.
         * <p>
         * API name: {@code default_pipeline}
         * </p>
         */
        @Nonnull
        public final Builder defaultPipeline(@Nullable String value) {
            this.defaultPipeline = value;
            return this;
        }

        /**
         * API name: {@code idle}
         */
        @Nonnull
        public final Builder idle(@Nullable SearchIdle value) {
            this.idle = value;
            return this;
        }

        /**
         * API name: {@code idle}
         */
        @Nonnull
        public final Builder idle(Function<SearchIdle.Builder, ObjectBuilder<SearchIdle>> fn) {
            return idle(fn.apply(new SearchIdle.Builder()).build());
        }

        /**
         * API name: {@code slowlog}
         */
        @Nonnull
        public final Builder slowlog(@Nullable SearchSlowlog value) {
            this.slowlog = value;
            return this;
        }

        /**
         * API name: {@code slowlog}
         */
        @Nonnull
        public final Builder slowlog(Function<SearchSlowlog.Builder, ObjectBuilder<SearchSlowlog>> fn) {
            return slowlog(fn.apply(new SearchSlowlog.Builder()).build());
        }

        /**
         * API name: {@code star_tree_index}
         */
        @Nonnull
        public final Builder starTreeIndex(@Nullable IndexSettingsSearchStarTreeIndex value) {
            this.starTreeIndex = value;
            return this;
        }

        /**
         * API name: {@code star_tree_index}
         */
        @Nonnull
        public final Builder starTreeIndex(
            Function<IndexSettingsSearchStarTreeIndex.Builder, ObjectBuilder<IndexSettingsSearchStarTreeIndex>> fn
        ) {
            return starTreeIndex(fn.apply(new IndexSettingsSearchStarTreeIndex.Builder()).build());
        }

        /**
         * API name: {@code throttled}
         */
        @Nonnull
        public final Builder throttled(@Nullable Boolean value) {
            this.throttled = value;
            return this;
        }

        /**
         * Builds a {@link IndexSettingsSearch}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public IndexSettingsSearch build() {
            _checkSingleUse();

            return new IndexSettingsSearch(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link IndexSettingsSearch}
     */
    public static final JsonpDeserializer<IndexSettingsSearch> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        IndexSettingsSearch::setupIndexSettingsSearchDeserializer
    );

    protected static void setupIndexSettingsSearchDeserializer(ObjectDeserializer<IndexSettingsSearch.Builder> op) {
        op.add(Builder::concurrent, IndexSettingsSearchConcurrent._DESERIALIZER, "concurrent");
        op.add(Builder::concurrentSegmentSearch, IndexSettingsSearchConcurrentSegmentSearch._DESERIALIZER, "concurrent_segment_search");
        op.add(Builder::defaultPipeline, JsonpDeserializer.stringDeserializer(), "default_pipeline");
        op.add(Builder::idle, SearchIdle._DESERIALIZER, "idle");
        op.add(Builder::slowlog, SearchSlowlog._DESERIALIZER, "slowlog");
        op.add(Builder::starTreeIndex, IndexSettingsSearchStarTreeIndex._DESERIALIZER, "star_tree_index");
        op.add(Builder::throttled, JsonpDeserializer.booleanDeserializer(), "throttled");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.concurrent);
        result = 31 * result + Objects.hashCode(this.concurrentSegmentSearch);
        result = 31 * result + Objects.hashCode(this.defaultPipeline);
        result = 31 * result + Objects.hashCode(this.idle);
        result = 31 * result + Objects.hashCode(this.slowlog);
        result = 31 * result + Objects.hashCode(this.starTreeIndex);
        result = 31 * result + Objects.hashCode(this.throttled);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        IndexSettingsSearch other = (IndexSettingsSearch) o;
        return Objects.equals(this.concurrent, other.concurrent)
            && Objects.equals(this.concurrentSegmentSearch, other.concurrentSegmentSearch)
            && Objects.equals(this.defaultPipeline, other.defaultPipeline)
            && Objects.equals(this.idle, other.idle)
            && Objects.equals(this.slowlog, other.slowlog)
            && Objects.equals(this.starTreeIndex, other.starTreeIndex)
            && Objects.equals(this.throttled, other.throttled);
    }
}
