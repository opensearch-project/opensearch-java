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

// typedef: _types.SearchStats

/**
 * The statistics about search operations.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class SearchStats implements PlainJsonSerializable, ToCopyableBuilder<SearchStats.Builder, SearchStats> {

    @Nullable
    private final Double concurrentAvgSliceCount;

    @Nullable
    private final Long concurrentQueryCurrent;

    @Nullable
    private final Time concurrentQueryTime;

    @Nullable
    private final Long concurrentQueryTimeInMillis;

    @Nullable
    private final Long concurrentQueryTotal;

    private final long fetchCurrent;

    @Nullable
    private final Time fetchTime;

    private final long fetchTimeInMillis;

    private final long fetchTotal;

    @Nonnull
    private final Map<String, SearchStats> groups;

    @Nullable
    private final Long openContexts;

    @Nullable
    private final Long pointInTimeCurrent;

    @Nullable
    private final Time pointInTimeTime;

    @Nullable
    private final Long pointInTimeTimeInMillis;

    @Nullable
    private final Long pointInTimeTotal;

    private final long queryCurrent;

    @Nullable
    private final Time queryTime;

    private final long queryTimeInMillis;

    private final long queryTotal;

    @Nonnull
    private final Map<String, RequestStats> request;

    private final long scrollCurrent;

    @Nullable
    private final Time scrollTime;

    private final long scrollTimeInMillis;

    private final long scrollTotal;

    @Nullable
    private final Long searchIdleReactivateCountTotal;

    private final long suggestCurrent;

    @Nullable
    private final Time suggestTime;

    private final long suggestTimeInMillis;

    private final long suggestTotal;

    // ---------------------------------------------------------------------------------------------

    private SearchStats(Builder builder) {
        this.concurrentAvgSliceCount = builder.concurrentAvgSliceCount;
        this.concurrentQueryCurrent = builder.concurrentQueryCurrent;
        this.concurrentQueryTime = builder.concurrentQueryTime;
        this.concurrentQueryTimeInMillis = builder.concurrentQueryTimeInMillis;
        this.concurrentQueryTotal = builder.concurrentQueryTotal;
        this.fetchCurrent = ApiTypeHelper.requireNonNull(builder.fetchCurrent, this, "fetchCurrent");
        this.fetchTime = builder.fetchTime;
        this.fetchTimeInMillis = ApiTypeHelper.requireNonNull(builder.fetchTimeInMillis, this, "fetchTimeInMillis");
        this.fetchTotal = ApiTypeHelper.requireNonNull(builder.fetchTotal, this, "fetchTotal");
        this.groups = ApiTypeHelper.unmodifiable(builder.groups);
        this.openContexts = builder.openContexts;
        this.pointInTimeCurrent = builder.pointInTimeCurrent;
        this.pointInTimeTime = builder.pointInTimeTime;
        this.pointInTimeTimeInMillis = builder.pointInTimeTimeInMillis;
        this.pointInTimeTotal = builder.pointInTimeTotal;
        this.queryCurrent = ApiTypeHelper.requireNonNull(builder.queryCurrent, this, "queryCurrent");
        this.queryTime = builder.queryTime;
        this.queryTimeInMillis = ApiTypeHelper.requireNonNull(builder.queryTimeInMillis, this, "queryTimeInMillis");
        this.queryTotal = ApiTypeHelper.requireNonNull(builder.queryTotal, this, "queryTotal");
        this.request = ApiTypeHelper.unmodifiable(builder.request);
        this.scrollCurrent = ApiTypeHelper.requireNonNull(builder.scrollCurrent, this, "scrollCurrent");
        this.scrollTime = builder.scrollTime;
        this.scrollTimeInMillis = ApiTypeHelper.requireNonNull(builder.scrollTimeInMillis, this, "scrollTimeInMillis");
        this.scrollTotal = ApiTypeHelper.requireNonNull(builder.scrollTotal, this, "scrollTotal");
        this.searchIdleReactivateCountTotal = builder.searchIdleReactivateCountTotal;
        this.suggestCurrent = ApiTypeHelper.requireNonNull(builder.suggestCurrent, this, "suggestCurrent");
        this.suggestTime = builder.suggestTime;
        this.suggestTimeInMillis = ApiTypeHelper.requireNonNull(builder.suggestTimeInMillis, this, "suggestTimeInMillis");
        this.suggestTotal = ApiTypeHelper.requireNonNull(builder.suggestTotal, this, "suggestTotal");
    }

    public static SearchStats of(Function<SearchStats.Builder, ObjectBuilder<SearchStats>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * The average slice count of all search requests. This is computed as the total slice count divided by the total number of concurrent
     * search requests.
     * <p>
     * API name: {@code concurrent_avg_slice_count}
     * </p>
     */
    @Nullable
    public final Double concurrentAvgSliceCount() {
        return this.concurrentAvgSliceCount;
    }

    /**
     * The number of currently running query operations using concurrent segment search.
     * <p>
     * API name: {@code concurrent_query_current}
     * </p>
     */
    @Nullable
    public final Long concurrentQueryCurrent() {
        return this.concurrentQueryCurrent;
    }

    /**
     * API name: {@code concurrent_query_time}
     */
    @Nullable
    public final Time concurrentQueryTime() {
        return this.concurrentQueryTime;
    }

    /**
     * The total amount of time taken by all query operations using concurrent segment search, in milliseconds.
     * <p>
     * API name: {@code concurrent_query_time_in_millis}
     * </p>
     */
    @Nullable
    public final Long concurrentQueryTimeInMillis() {
        return this.concurrentQueryTimeInMillis;
    }

    /**
     * The total number of query operations using concurrent segment search.
     * <p>
     * API name: {@code concurrent_query_total}
     * </p>
     */
    @Nullable
    public final Long concurrentQueryTotal() {
        return this.concurrentQueryTotal;
    }

    /**
     * Required - The number of currently running shard fetch operations.
     * <p>
     * API name: {@code fetch_current}
     * </p>
     */
    public final long fetchCurrent() {
        return this.fetchCurrent;
    }

    /**
     * The total amount of time taken to complete all shard fetch operations.
     * <p>
     * API name: {@code fetch_time}
     * </p>
     */
    @Nullable
    public final Time fetchTime() {
        return this.fetchTime;
    }

    /**
     * Required - The total amount of time taken to complete all shard fetch operations, in milliseconds.
     * <p>
     * API name: {@code fetch_time_in_millis}
     * </p>
     */
    public final long fetchTimeInMillis() {
        return this.fetchTimeInMillis;
    }

    /**
     * Required - The total number of shard fetch operations.
     * <p>
     * API name: {@code fetch_total}
     * </p>
     */
    public final long fetchTotal() {
        return this.fetchTotal;
    }

    /**
     * The search statistics grouped by search groups.
     * <p>
     * API name: {@code groups}
     * </p>
     */
    @Nonnull
    public final Map<String, SearchStats> groups() {
        return this.groups;
    }

    /**
     * The number of open search contexts.
     * <p>
     * API name: {@code open_contexts}
     * </p>
     */
    @Nullable
    public final Long openContexts() {
        return this.openContexts;
    }

    /**
     * The number of currently open shard PIT contexts.
     * <p>
     * API name: {@code point_in_time_current}
     * </p>
     */
    @Nullable
    public final Long pointInTimeCurrent() {
        return this.pointInTimeCurrent;
    }

    /**
     * API name: {@code point_in_time_time}
     */
    @Nullable
    public final Time pointInTimeTime() {
        return this.pointInTimeTime;
    }

    /**
     * The amount of time that shard PIT contexts have been held open since the node last restarted, in milliseconds.
     * <p>
     * API name: {@code point_in_time_time_in_millis}
     * </p>
     */
    @Nullable
    public final Long pointInTimeTimeInMillis() {
        return this.pointInTimeTimeInMillis;
    }

    /**
     * The total number of shard Point in Time (PIT) contexts created (completed and active) since the node last restarted.
     * <p>
     * API name: {@code point_in_time_total}
     * </p>
     */
    @Nullable
    public final Long pointInTimeTotal() {
        return this.pointInTimeTotal;
    }

    /**
     * Required - The number of currently running shard query operations.
     * <p>
     * API name: {@code query_current}
     * </p>
     */
    public final long queryCurrent() {
        return this.queryCurrent;
    }

    /**
     * The total amount of time taken to complete all shard query operations.
     * <p>
     * API name: {@code query_time}
     * </p>
     */
    @Nullable
    public final Time queryTime() {
        return this.queryTime;
    }

    /**
     * Required - The total amount of time taken to complete all shard query operations, in milliseconds.
     * <p>
     * API name: {@code query_time_in_millis}
     * </p>
     */
    public final long queryTimeInMillis() {
        return this.queryTimeInMillis;
    }

    /**
     * Required - The total number of shard query operations.
     * <p>
     * API name: {@code query_total}
     * </p>
     */
    public final long queryTotal() {
        return this.queryTotal;
    }

    /**
     * Statistics related to coordinator search operations for the node.
     * <p>
     * API name: {@code request}
     * </p>
     */
    @Nonnull
    public final Map<String, RequestStats> request() {
        return this.request;
    }

    /**
     * Required - The number of shard scroll operations that are currently running.
     * <p>
     * API name: {@code scroll_current}
     * </p>
     */
    public final long scrollCurrent() {
        return this.scrollCurrent;
    }

    /**
     * The total amount of time taken to complete all shard scroll operations.
     * <p>
     * API name: {@code scroll_time}
     * </p>
     */
    @Nullable
    public final Time scrollTime() {
        return this.scrollTime;
    }

    /**
     * Required - The total amount of time taken to complete all shard scroll operations, in milliseconds.
     * <p>
     * API name: {@code scroll_time_in_millis}
     * </p>
     */
    public final long scrollTimeInMillis() {
        return this.scrollTimeInMillis;
    }

    /**
     * Required - The total number of shard scroll operations.
     * <p>
     * API name: {@code scroll_total}
     * </p>
     */
    public final long scrollTotal() {
        return this.scrollTotal;
    }

    /**
     * The total number of idle search reactivations.
     * <p>
     * API name: {@code search_idle_reactivate_count_total}
     * </p>
     */
    @Nullable
    public final Long searchIdleReactivateCountTotal() {
        return this.searchIdleReactivateCountTotal;
    }

    /**
     * Required - The number of currently running shard suggest operations.
     * <p>
     * API name: {@code suggest_current}
     * </p>
     */
    public final long suggestCurrent() {
        return this.suggestCurrent;
    }

    /**
     * The total amount of time take to complete all shard suggest operations.
     * <p>
     * API name: {@code suggest_time}
     * </p>
     */
    @Nullable
    public final Time suggestTime() {
        return this.suggestTime;
    }

    /**
     * Required - The total amount of time taken to complete all shard suggest operations, in milliseconds.
     * <p>
     * API name: {@code suggest_time_in_millis}
     * </p>
     */
    public final long suggestTimeInMillis() {
        return this.suggestTimeInMillis;
    }

    /**
     * Required - The total number of shard suggest operations.
     * <p>
     * API name: {@code suggest_total}
     * </p>
     */
    public final long suggestTotal() {
        return this.suggestTotal;
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
        if (this.concurrentAvgSliceCount != null) {
            generator.writeKey("concurrent_avg_slice_count");
            generator.write(this.concurrentAvgSliceCount);
        }

        if (this.concurrentQueryCurrent != null) {
            generator.writeKey("concurrent_query_current");
            generator.write(this.concurrentQueryCurrent);
        }

        if (this.concurrentQueryTime != null) {
            generator.writeKey("concurrent_query_time");
            this.concurrentQueryTime.serialize(generator, mapper);
        }

        if (this.concurrentQueryTimeInMillis != null) {
            generator.writeKey("concurrent_query_time_in_millis");
            generator.write(this.concurrentQueryTimeInMillis);
        }

        if (this.concurrentQueryTotal != null) {
            generator.writeKey("concurrent_query_total");
            generator.write(this.concurrentQueryTotal);
        }

        generator.writeKey("fetch_current");
        generator.write(this.fetchCurrent);

        if (this.fetchTime != null) {
            generator.writeKey("fetch_time");
            this.fetchTime.serialize(generator, mapper);
        }

        generator.writeKey("fetch_time_in_millis");
        generator.write(this.fetchTimeInMillis);

        generator.writeKey("fetch_total");
        generator.write(this.fetchTotal);

        if (ApiTypeHelper.isDefined(this.groups)) {
            generator.writeKey("groups");
            generator.writeStartObject();
            for (Map.Entry<String, SearchStats> item0 : this.groups.entrySet()) {
                generator.writeKey(item0.getKey());
                item0.getValue().serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (this.openContexts != null) {
            generator.writeKey("open_contexts");
            generator.write(this.openContexts);
        }

        if (this.pointInTimeCurrent != null) {
            generator.writeKey("point_in_time_current");
            generator.write(this.pointInTimeCurrent);
        }

        if (this.pointInTimeTime != null) {
            generator.writeKey("point_in_time_time");
            this.pointInTimeTime.serialize(generator, mapper);
        }

        if (this.pointInTimeTimeInMillis != null) {
            generator.writeKey("point_in_time_time_in_millis");
            generator.write(this.pointInTimeTimeInMillis);
        }

        if (this.pointInTimeTotal != null) {
            generator.writeKey("point_in_time_total");
            generator.write(this.pointInTimeTotal);
        }

        generator.writeKey("query_current");
        generator.write(this.queryCurrent);

        if (this.queryTime != null) {
            generator.writeKey("query_time");
            this.queryTime.serialize(generator, mapper);
        }

        generator.writeKey("query_time_in_millis");
        generator.write(this.queryTimeInMillis);

        generator.writeKey("query_total");
        generator.write(this.queryTotal);

        if (ApiTypeHelper.isDefined(this.request)) {
            generator.writeKey("request");
            generator.writeStartObject();
            for (Map.Entry<String, RequestStats> item0 : this.request.entrySet()) {
                generator.writeKey(item0.getKey());
                item0.getValue().serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        generator.writeKey("scroll_current");
        generator.write(this.scrollCurrent);

        if (this.scrollTime != null) {
            generator.writeKey("scroll_time");
            this.scrollTime.serialize(generator, mapper);
        }

        generator.writeKey("scroll_time_in_millis");
        generator.write(this.scrollTimeInMillis);

        generator.writeKey("scroll_total");
        generator.write(this.scrollTotal);

        if (this.searchIdleReactivateCountTotal != null) {
            generator.writeKey("search_idle_reactivate_count_total");
            generator.write(this.searchIdleReactivateCountTotal);
        }

        generator.writeKey("suggest_current");
        generator.write(this.suggestCurrent);

        if (this.suggestTime != null) {
            generator.writeKey("suggest_time");
            this.suggestTime.serialize(generator, mapper);
        }

        generator.writeKey("suggest_time_in_millis");
        generator.write(this.suggestTimeInMillis);

        generator.writeKey("suggest_total");
        generator.write(this.suggestTotal);
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
     * Builder for {@link SearchStats}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, SearchStats> {
        @Nullable
        private Double concurrentAvgSliceCount;
        @Nullable
        private Long concurrentQueryCurrent;
        @Nullable
        private Time concurrentQueryTime;
        @Nullable
        private Long concurrentQueryTimeInMillis;
        @Nullable
        private Long concurrentQueryTotal;
        private Long fetchCurrent;
        @Nullable
        private Time fetchTime;
        private Long fetchTimeInMillis;
        private Long fetchTotal;
        @Nullable
        private Map<String, SearchStats> groups;
        @Nullable
        private Long openContexts;
        @Nullable
        private Long pointInTimeCurrent;
        @Nullable
        private Time pointInTimeTime;
        @Nullable
        private Long pointInTimeTimeInMillis;
        @Nullable
        private Long pointInTimeTotal;
        private Long queryCurrent;
        @Nullable
        private Time queryTime;
        private Long queryTimeInMillis;
        private Long queryTotal;
        @Nullable
        private Map<String, RequestStats> request;
        private Long scrollCurrent;
        @Nullable
        private Time scrollTime;
        private Long scrollTimeInMillis;
        private Long scrollTotal;
        @Nullable
        private Long searchIdleReactivateCountTotal;
        private Long suggestCurrent;
        @Nullable
        private Time suggestTime;
        private Long suggestTimeInMillis;
        private Long suggestTotal;

        public Builder() {}

        private Builder(SearchStats o) {
            this.concurrentAvgSliceCount = o.concurrentAvgSliceCount;
            this.concurrentQueryCurrent = o.concurrentQueryCurrent;
            this.concurrentQueryTime = o.concurrentQueryTime;
            this.concurrentQueryTimeInMillis = o.concurrentQueryTimeInMillis;
            this.concurrentQueryTotal = o.concurrentQueryTotal;
            this.fetchCurrent = o.fetchCurrent;
            this.fetchTime = o.fetchTime;
            this.fetchTimeInMillis = o.fetchTimeInMillis;
            this.fetchTotal = o.fetchTotal;
            this.groups = _mapCopy(o.groups);
            this.openContexts = o.openContexts;
            this.pointInTimeCurrent = o.pointInTimeCurrent;
            this.pointInTimeTime = o.pointInTimeTime;
            this.pointInTimeTimeInMillis = o.pointInTimeTimeInMillis;
            this.pointInTimeTotal = o.pointInTimeTotal;
            this.queryCurrent = o.queryCurrent;
            this.queryTime = o.queryTime;
            this.queryTimeInMillis = o.queryTimeInMillis;
            this.queryTotal = o.queryTotal;
            this.request = _mapCopy(o.request);
            this.scrollCurrent = o.scrollCurrent;
            this.scrollTime = o.scrollTime;
            this.scrollTimeInMillis = o.scrollTimeInMillis;
            this.scrollTotal = o.scrollTotal;
            this.searchIdleReactivateCountTotal = o.searchIdleReactivateCountTotal;
            this.suggestCurrent = o.suggestCurrent;
            this.suggestTime = o.suggestTime;
            this.suggestTimeInMillis = o.suggestTimeInMillis;
            this.suggestTotal = o.suggestTotal;
        }

        private Builder(Builder o) {
            this.concurrentAvgSliceCount = o.concurrentAvgSliceCount;
            this.concurrentQueryCurrent = o.concurrentQueryCurrent;
            this.concurrentQueryTime = o.concurrentQueryTime;
            this.concurrentQueryTimeInMillis = o.concurrentQueryTimeInMillis;
            this.concurrentQueryTotal = o.concurrentQueryTotal;
            this.fetchCurrent = o.fetchCurrent;
            this.fetchTime = o.fetchTime;
            this.fetchTimeInMillis = o.fetchTimeInMillis;
            this.fetchTotal = o.fetchTotal;
            this.groups = _mapCopy(o.groups);
            this.openContexts = o.openContexts;
            this.pointInTimeCurrent = o.pointInTimeCurrent;
            this.pointInTimeTime = o.pointInTimeTime;
            this.pointInTimeTimeInMillis = o.pointInTimeTimeInMillis;
            this.pointInTimeTotal = o.pointInTimeTotal;
            this.queryCurrent = o.queryCurrent;
            this.queryTime = o.queryTime;
            this.queryTimeInMillis = o.queryTimeInMillis;
            this.queryTotal = o.queryTotal;
            this.request = _mapCopy(o.request);
            this.scrollCurrent = o.scrollCurrent;
            this.scrollTime = o.scrollTime;
            this.scrollTimeInMillis = o.scrollTimeInMillis;
            this.scrollTotal = o.scrollTotal;
            this.searchIdleReactivateCountTotal = o.searchIdleReactivateCountTotal;
            this.suggestCurrent = o.suggestCurrent;
            this.suggestTime = o.suggestTime;
            this.suggestTimeInMillis = o.suggestTimeInMillis;
            this.suggestTotal = o.suggestTotal;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * The average slice count of all search requests. This is computed as the total slice count divided by the total number of
         * concurrent search requests.
         * <p>
         * API name: {@code concurrent_avg_slice_count}
         * </p>
         */
        @Nonnull
        public final Builder concurrentAvgSliceCount(@Nullable Double value) {
            this.concurrentAvgSliceCount = value;
            return this;
        }

        /**
         * The number of currently running query operations using concurrent segment search.
         * <p>
         * API name: {@code concurrent_query_current}
         * </p>
         */
        @Nonnull
        public final Builder concurrentQueryCurrent(@Nullable Long value) {
            this.concurrentQueryCurrent = value;
            return this;
        }

        /**
         * API name: {@code concurrent_query_time}
         */
        @Nonnull
        public final Builder concurrentQueryTime(@Nullable Time value) {
            this.concurrentQueryTime = value;
            return this;
        }

        /**
         * API name: {@code concurrent_query_time}
         */
        @Nonnull
        public final Builder concurrentQueryTime(Function<Time.Builder, ObjectBuilder<Time>> fn) {
            return concurrentQueryTime(fn.apply(new Time.Builder()).build());
        }

        /**
         * The total amount of time taken by all query operations using concurrent segment search, in milliseconds.
         * <p>
         * API name: {@code concurrent_query_time_in_millis}
         * </p>
         */
        @Nonnull
        public final Builder concurrentQueryTimeInMillis(@Nullable Long value) {
            this.concurrentQueryTimeInMillis = value;
            return this;
        }

        /**
         * The total number of query operations using concurrent segment search.
         * <p>
         * API name: {@code concurrent_query_total}
         * </p>
         */
        @Nonnull
        public final Builder concurrentQueryTotal(@Nullable Long value) {
            this.concurrentQueryTotal = value;
            return this;
        }

        /**
         * Required - The number of currently running shard fetch operations.
         * <p>
         * API name: {@code fetch_current}
         * </p>
         */
        @Nonnull
        public final Builder fetchCurrent(long value) {
            this.fetchCurrent = value;
            return this;
        }

        /**
         * The total amount of time taken to complete all shard fetch operations.
         * <p>
         * API name: {@code fetch_time}
         * </p>
         */
        @Nonnull
        public final Builder fetchTime(@Nullable Time value) {
            this.fetchTime = value;
            return this;
        }

        /**
         * The total amount of time taken to complete all shard fetch operations.
         * <p>
         * API name: {@code fetch_time}
         * </p>
         */
        @Nonnull
        public final Builder fetchTime(Function<Time.Builder, ObjectBuilder<Time>> fn) {
            return fetchTime(fn.apply(new Time.Builder()).build());
        }

        /**
         * Required - The total amount of time taken to complete all shard fetch operations, in milliseconds.
         * <p>
         * API name: {@code fetch_time_in_millis}
         * </p>
         */
        @Nonnull
        public final Builder fetchTimeInMillis(long value) {
            this.fetchTimeInMillis = value;
            return this;
        }

        /**
         * Required - The total number of shard fetch operations.
         * <p>
         * API name: {@code fetch_total}
         * </p>
         */
        @Nonnull
        public final Builder fetchTotal(long value) {
            this.fetchTotal = value;
            return this;
        }

        /**
         * The search statistics grouped by search groups.
         * <p>
         * API name: {@code groups}
         * </p>
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>groups</code>.
         * </p>
         */
        @Nonnull
        public final Builder groups(Map<String, SearchStats> map) {
            this.groups = _mapPutAll(this.groups, map);
            return this;
        }

        /**
         * The search statistics grouped by search groups.
         * <p>
         * API name: {@code groups}
         * </p>
         *
         * <p>
         * Adds an entry to <code>groups</code>.
         * </p>
         */
        @Nonnull
        public final Builder groups(String key, SearchStats value) {
            this.groups = _mapPut(this.groups, key, value);
            return this;
        }

        /**
         * The search statistics grouped by search groups.
         * <p>
         * API name: {@code groups}
         * </p>
         *
         * <p>
         * Adds a value to <code>groups</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder groups(String key, Function<SearchStats.Builder, ObjectBuilder<SearchStats>> fn) {
            return groups(key, fn.apply(new SearchStats.Builder()).build());
        }

        /**
         * The number of open search contexts.
         * <p>
         * API name: {@code open_contexts}
         * </p>
         */
        @Nonnull
        public final Builder openContexts(@Nullable Long value) {
            this.openContexts = value;
            return this;
        }

        /**
         * The number of currently open shard PIT contexts.
         * <p>
         * API name: {@code point_in_time_current}
         * </p>
         */
        @Nonnull
        public final Builder pointInTimeCurrent(@Nullable Long value) {
            this.pointInTimeCurrent = value;
            return this;
        }

        /**
         * API name: {@code point_in_time_time}
         */
        @Nonnull
        public final Builder pointInTimeTime(@Nullable Time value) {
            this.pointInTimeTime = value;
            return this;
        }

        /**
         * API name: {@code point_in_time_time}
         */
        @Nonnull
        public final Builder pointInTimeTime(Function<Time.Builder, ObjectBuilder<Time>> fn) {
            return pointInTimeTime(fn.apply(new Time.Builder()).build());
        }

        /**
         * The amount of time that shard PIT contexts have been held open since the node last restarted, in milliseconds.
         * <p>
         * API name: {@code point_in_time_time_in_millis}
         * </p>
         */
        @Nonnull
        public final Builder pointInTimeTimeInMillis(@Nullable Long value) {
            this.pointInTimeTimeInMillis = value;
            return this;
        }

        /**
         * The total number of shard Point in Time (PIT) contexts created (completed and active) since the node last restarted.
         * <p>
         * API name: {@code point_in_time_total}
         * </p>
         */
        @Nonnull
        public final Builder pointInTimeTotal(@Nullable Long value) {
            this.pointInTimeTotal = value;
            return this;
        }

        /**
         * Required - The number of currently running shard query operations.
         * <p>
         * API name: {@code query_current}
         * </p>
         */
        @Nonnull
        public final Builder queryCurrent(long value) {
            this.queryCurrent = value;
            return this;
        }

        /**
         * The total amount of time taken to complete all shard query operations.
         * <p>
         * API name: {@code query_time}
         * </p>
         */
        @Nonnull
        public final Builder queryTime(@Nullable Time value) {
            this.queryTime = value;
            return this;
        }

        /**
         * The total amount of time taken to complete all shard query operations.
         * <p>
         * API name: {@code query_time}
         * </p>
         */
        @Nonnull
        public final Builder queryTime(Function<Time.Builder, ObjectBuilder<Time>> fn) {
            return queryTime(fn.apply(new Time.Builder()).build());
        }

        /**
         * Required - The total amount of time taken to complete all shard query operations, in milliseconds.
         * <p>
         * API name: {@code query_time_in_millis}
         * </p>
         */
        @Nonnull
        public final Builder queryTimeInMillis(long value) {
            this.queryTimeInMillis = value;
            return this;
        }

        /**
         * Required - The total number of shard query operations.
         * <p>
         * API name: {@code query_total}
         * </p>
         */
        @Nonnull
        public final Builder queryTotal(long value) {
            this.queryTotal = value;
            return this;
        }

        /**
         * Statistics related to coordinator search operations for the node.
         * <p>
         * API name: {@code request}
         * </p>
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>request</code>.
         * </p>
         */
        @Nonnull
        public final Builder request(Map<String, RequestStats> map) {
            this.request = _mapPutAll(this.request, map);
            return this;
        }

        /**
         * Statistics related to coordinator search operations for the node.
         * <p>
         * API name: {@code request}
         * </p>
         *
         * <p>
         * Adds an entry to <code>request</code>.
         * </p>
         */
        @Nonnull
        public final Builder request(String key, RequestStats value) {
            this.request = _mapPut(this.request, key, value);
            return this;
        }

        /**
         * Statistics related to coordinator search operations for the node.
         * <p>
         * API name: {@code request}
         * </p>
         *
         * <p>
         * Adds a value to <code>request</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder request(String key, Function<RequestStats.Builder, ObjectBuilder<RequestStats>> fn) {
            return request(key, fn.apply(new RequestStats.Builder()).build());
        }

        /**
         * Required - The number of shard scroll operations that are currently running.
         * <p>
         * API name: {@code scroll_current}
         * </p>
         */
        @Nonnull
        public final Builder scrollCurrent(long value) {
            this.scrollCurrent = value;
            return this;
        }

        /**
         * The total amount of time taken to complete all shard scroll operations.
         * <p>
         * API name: {@code scroll_time}
         * </p>
         */
        @Nonnull
        public final Builder scrollTime(@Nullable Time value) {
            this.scrollTime = value;
            return this;
        }

        /**
         * The total amount of time taken to complete all shard scroll operations.
         * <p>
         * API name: {@code scroll_time}
         * </p>
         */
        @Nonnull
        public final Builder scrollTime(Function<Time.Builder, ObjectBuilder<Time>> fn) {
            return scrollTime(fn.apply(new Time.Builder()).build());
        }

        /**
         * Required - The total amount of time taken to complete all shard scroll operations, in milliseconds.
         * <p>
         * API name: {@code scroll_time_in_millis}
         * </p>
         */
        @Nonnull
        public final Builder scrollTimeInMillis(long value) {
            this.scrollTimeInMillis = value;
            return this;
        }

        /**
         * Required - The total number of shard scroll operations.
         * <p>
         * API name: {@code scroll_total}
         * </p>
         */
        @Nonnull
        public final Builder scrollTotal(long value) {
            this.scrollTotal = value;
            return this;
        }

        /**
         * The total number of idle search reactivations.
         * <p>
         * API name: {@code search_idle_reactivate_count_total}
         * </p>
         */
        @Nonnull
        public final Builder searchIdleReactivateCountTotal(@Nullable Long value) {
            this.searchIdleReactivateCountTotal = value;
            return this;
        }

        /**
         * Required - The number of currently running shard suggest operations.
         * <p>
         * API name: {@code suggest_current}
         * </p>
         */
        @Nonnull
        public final Builder suggestCurrent(long value) {
            this.suggestCurrent = value;
            return this;
        }

        /**
         * The total amount of time take to complete all shard suggest operations.
         * <p>
         * API name: {@code suggest_time}
         * </p>
         */
        @Nonnull
        public final Builder suggestTime(@Nullable Time value) {
            this.suggestTime = value;
            return this;
        }

        /**
         * The total amount of time take to complete all shard suggest operations.
         * <p>
         * API name: {@code suggest_time}
         * </p>
         */
        @Nonnull
        public final Builder suggestTime(Function<Time.Builder, ObjectBuilder<Time>> fn) {
            return suggestTime(fn.apply(new Time.Builder()).build());
        }

        /**
         * Required - The total amount of time taken to complete all shard suggest operations, in milliseconds.
         * <p>
         * API name: {@code suggest_time_in_millis}
         * </p>
         */
        @Nonnull
        public final Builder suggestTimeInMillis(long value) {
            this.suggestTimeInMillis = value;
            return this;
        }

        /**
         * Required - The total number of shard suggest operations.
         * <p>
         * API name: {@code suggest_total}
         * </p>
         */
        @Nonnull
        public final Builder suggestTotal(long value) {
            this.suggestTotal = value;
            return this;
        }

        /**
         * Builds a {@link SearchStats}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public SearchStats build() {
            _checkSingleUse();

            return new SearchStats(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link SearchStats}
     */
    public static final JsonpDeserializer<SearchStats> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        SearchStats::setupSearchStatsDeserializer
    );

    protected static void setupSearchStatsDeserializer(ObjectDeserializer<SearchStats.Builder> op) {
        op.add(Builder::concurrentAvgSliceCount, JsonpDeserializer.doubleDeserializer(), "concurrent_avg_slice_count");
        op.add(Builder::concurrentQueryCurrent, JsonpDeserializer.longDeserializer(), "concurrent_query_current");
        op.add(Builder::concurrentQueryTime, Time._DESERIALIZER, "concurrent_query_time");
        op.add(Builder::concurrentQueryTimeInMillis, JsonpDeserializer.longDeserializer(), "concurrent_query_time_in_millis");
        op.add(Builder::concurrentQueryTotal, JsonpDeserializer.longDeserializer(), "concurrent_query_total");
        op.add(Builder::fetchCurrent, JsonpDeserializer.longDeserializer(), "fetch_current");
        op.add(Builder::fetchTime, Time._DESERIALIZER, "fetch_time");
        op.add(Builder::fetchTimeInMillis, JsonpDeserializer.longDeserializer(), "fetch_time_in_millis");
        op.add(Builder::fetchTotal, JsonpDeserializer.longDeserializer(), "fetch_total");
        op.add(Builder::groups, JsonpDeserializer.stringMapDeserializer(SearchStats._DESERIALIZER), "groups");
        op.add(Builder::openContexts, JsonpDeserializer.longDeserializer(), "open_contexts");
        op.add(Builder::pointInTimeCurrent, JsonpDeserializer.longDeserializer(), "point_in_time_current");
        op.add(Builder::pointInTimeTime, Time._DESERIALIZER, "point_in_time_time");
        op.add(Builder::pointInTimeTimeInMillis, JsonpDeserializer.longDeserializer(), "point_in_time_time_in_millis");
        op.add(Builder::pointInTimeTotal, JsonpDeserializer.longDeserializer(), "point_in_time_total");
        op.add(Builder::queryCurrent, JsonpDeserializer.longDeserializer(), "query_current");
        op.add(Builder::queryTime, Time._DESERIALIZER, "query_time");
        op.add(Builder::queryTimeInMillis, JsonpDeserializer.longDeserializer(), "query_time_in_millis");
        op.add(Builder::queryTotal, JsonpDeserializer.longDeserializer(), "query_total");
        op.add(Builder::request, JsonpDeserializer.stringMapDeserializer(RequestStats._DESERIALIZER), "request");
        op.add(Builder::scrollCurrent, JsonpDeserializer.longDeserializer(), "scroll_current");
        op.add(Builder::scrollTime, Time._DESERIALIZER, "scroll_time");
        op.add(Builder::scrollTimeInMillis, JsonpDeserializer.longDeserializer(), "scroll_time_in_millis");
        op.add(Builder::scrollTotal, JsonpDeserializer.longDeserializer(), "scroll_total");
        op.add(Builder::searchIdleReactivateCountTotal, JsonpDeserializer.longDeserializer(), "search_idle_reactivate_count_total");
        op.add(Builder::suggestCurrent, JsonpDeserializer.longDeserializer(), "suggest_current");
        op.add(Builder::suggestTime, Time._DESERIALIZER, "suggest_time");
        op.add(Builder::suggestTimeInMillis, JsonpDeserializer.longDeserializer(), "suggest_time_in_millis");
        op.add(Builder::suggestTotal, JsonpDeserializer.longDeserializer(), "suggest_total");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.concurrentAvgSliceCount);
        result = 31 * result + Objects.hashCode(this.concurrentQueryCurrent);
        result = 31 * result + Objects.hashCode(this.concurrentQueryTime);
        result = 31 * result + Objects.hashCode(this.concurrentQueryTimeInMillis);
        result = 31 * result + Objects.hashCode(this.concurrentQueryTotal);
        result = 31 * result + Long.hashCode(this.fetchCurrent);
        result = 31 * result + Objects.hashCode(this.fetchTime);
        result = 31 * result + Long.hashCode(this.fetchTimeInMillis);
        result = 31 * result + Long.hashCode(this.fetchTotal);
        result = 31 * result + Objects.hashCode(this.groups);
        result = 31 * result + Objects.hashCode(this.openContexts);
        result = 31 * result + Objects.hashCode(this.pointInTimeCurrent);
        result = 31 * result + Objects.hashCode(this.pointInTimeTime);
        result = 31 * result + Objects.hashCode(this.pointInTimeTimeInMillis);
        result = 31 * result + Objects.hashCode(this.pointInTimeTotal);
        result = 31 * result + Long.hashCode(this.queryCurrent);
        result = 31 * result + Objects.hashCode(this.queryTime);
        result = 31 * result + Long.hashCode(this.queryTimeInMillis);
        result = 31 * result + Long.hashCode(this.queryTotal);
        result = 31 * result + Objects.hashCode(this.request);
        result = 31 * result + Long.hashCode(this.scrollCurrent);
        result = 31 * result + Objects.hashCode(this.scrollTime);
        result = 31 * result + Long.hashCode(this.scrollTimeInMillis);
        result = 31 * result + Long.hashCode(this.scrollTotal);
        result = 31 * result + Objects.hashCode(this.searchIdleReactivateCountTotal);
        result = 31 * result + Long.hashCode(this.suggestCurrent);
        result = 31 * result + Objects.hashCode(this.suggestTime);
        result = 31 * result + Long.hashCode(this.suggestTimeInMillis);
        result = 31 * result + Long.hashCode(this.suggestTotal);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        SearchStats other = (SearchStats) o;
        return Objects.equals(this.concurrentAvgSliceCount, other.concurrentAvgSliceCount)
            && Objects.equals(this.concurrentQueryCurrent, other.concurrentQueryCurrent)
            && Objects.equals(this.concurrentQueryTime, other.concurrentQueryTime)
            && Objects.equals(this.concurrentQueryTimeInMillis, other.concurrentQueryTimeInMillis)
            && Objects.equals(this.concurrentQueryTotal, other.concurrentQueryTotal)
            && this.fetchCurrent == other.fetchCurrent
            && Objects.equals(this.fetchTime, other.fetchTime)
            && this.fetchTimeInMillis == other.fetchTimeInMillis
            && this.fetchTotal == other.fetchTotal
            && Objects.equals(this.groups, other.groups)
            && Objects.equals(this.openContexts, other.openContexts)
            && Objects.equals(this.pointInTimeCurrent, other.pointInTimeCurrent)
            && Objects.equals(this.pointInTimeTime, other.pointInTimeTime)
            && Objects.equals(this.pointInTimeTimeInMillis, other.pointInTimeTimeInMillis)
            && Objects.equals(this.pointInTimeTotal, other.pointInTimeTotal)
            && this.queryCurrent == other.queryCurrent
            && Objects.equals(this.queryTime, other.queryTime)
            && this.queryTimeInMillis == other.queryTimeInMillis
            && this.queryTotal == other.queryTotal
            && Objects.equals(this.request, other.request)
            && this.scrollCurrent == other.scrollCurrent
            && Objects.equals(this.scrollTime, other.scrollTime)
            && this.scrollTimeInMillis == other.scrollTimeInMillis
            && this.scrollTotal == other.scrollTotal
            && Objects.equals(this.searchIdleReactivateCountTotal, other.searchIdleReactivateCountTotal)
            && this.suggestCurrent == other.suggestCurrent
            && Objects.equals(this.suggestTime, other.suggestTime)
            && this.suggestTimeInMillis == other.suggestTimeInMillis
            && this.suggestTotal == other.suggestTotal;
    }
}
