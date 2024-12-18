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

// typedef: _types.IndexingStats

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class IndexingStats implements PlainJsonSerializable, ToCopyableBuilder<IndexingStats.Builder, IndexingStats> {

    private final long deleteCurrent;

    @Nullable
    private final Time deleteTime;

    private final long deleteTimeInMillis;

    private final long deleteTotal;

    @Nullable
    private final DocStatus docStatus;

    private final long indexCurrent;

    private final long indexFailed;

    @Nullable
    private final Time indexTime;

    private final long indexTimeInMillis;

    private final long indexTotal;

    private final boolean isThrottled;

    private final long noopUpdateTotal;

    @Nullable
    private final Time throttleTime;

    private final long throttleTimeInMillis;

    // ---------------------------------------------------------------------------------------------

    private IndexingStats(Builder builder) {
        this.deleteCurrent = ApiTypeHelper.requireNonNull(builder.deleteCurrent, this, "deleteCurrent");
        this.deleteTime = builder.deleteTime;
        this.deleteTimeInMillis = ApiTypeHelper.requireNonNull(builder.deleteTimeInMillis, this, "deleteTimeInMillis");
        this.deleteTotal = ApiTypeHelper.requireNonNull(builder.deleteTotal, this, "deleteTotal");
        this.docStatus = builder.docStatus;
        this.indexCurrent = ApiTypeHelper.requireNonNull(builder.indexCurrent, this, "indexCurrent");
        this.indexFailed = ApiTypeHelper.requireNonNull(builder.indexFailed, this, "indexFailed");
        this.indexTime = builder.indexTime;
        this.indexTimeInMillis = ApiTypeHelper.requireNonNull(builder.indexTimeInMillis, this, "indexTimeInMillis");
        this.indexTotal = ApiTypeHelper.requireNonNull(builder.indexTotal, this, "indexTotal");
        this.isThrottled = ApiTypeHelper.requireNonNull(builder.isThrottled, this, "isThrottled");
        this.noopUpdateTotal = ApiTypeHelper.requireNonNull(builder.noopUpdateTotal, this, "noopUpdateTotal");
        this.throttleTime = builder.throttleTime;
        this.throttleTimeInMillis = ApiTypeHelper.requireNonNull(builder.throttleTimeInMillis, this, "throttleTimeInMillis");
    }

    public static IndexingStats of(Function<IndexingStats.Builder, ObjectBuilder<IndexingStats>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code delete_current}
     */
    public final long deleteCurrent() {
        return this.deleteCurrent;
    }

    /**
     * API name: {@code delete_time}
     */
    @Nullable
    public final Time deleteTime() {
        return this.deleteTime;
    }

    /**
     * Required - API name: {@code delete_time_in_millis}
     */
    public final long deleteTimeInMillis() {
        return this.deleteTimeInMillis;
    }

    /**
     * Required - API name: {@code delete_total}
     */
    public final long deleteTotal() {
        return this.deleteTotal;
    }

    /**
     * API name: {@code doc_status}
     */
    @Nullable
    public final DocStatus docStatus() {
        return this.docStatus;
    }

    /**
     * Required - API name: {@code index_current}
     */
    public final long indexCurrent() {
        return this.indexCurrent;
    }

    /**
     * Required - API name: {@code index_failed}
     */
    public final long indexFailed() {
        return this.indexFailed;
    }

    /**
     * API name: {@code index_time}
     */
    @Nullable
    public final Time indexTime() {
        return this.indexTime;
    }

    /**
     * Required - API name: {@code index_time_in_millis}
     */
    public final long indexTimeInMillis() {
        return this.indexTimeInMillis;
    }

    /**
     * Required - API name: {@code index_total}
     */
    public final long indexTotal() {
        return this.indexTotal;
    }

    /**
     * Required - API name: {@code is_throttled}
     */
    public final boolean isThrottled() {
        return this.isThrottled;
    }

    /**
     * Required - API name: {@code noop_update_total}
     */
    public final long noopUpdateTotal() {
        return this.noopUpdateTotal;
    }

    /**
     * API name: {@code throttle_time}
     */
    @Nullable
    public final Time throttleTime() {
        return this.throttleTime;
    }

    /**
     * Required - API name: {@code throttle_time_in_millis}
     */
    public final long throttleTimeInMillis() {
        return this.throttleTimeInMillis;
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
        generator.writeKey("delete_current");
        generator.write(this.deleteCurrent);

        if (this.deleteTime != null) {
            generator.writeKey("delete_time");
            this.deleteTime.serialize(generator, mapper);
        }

        generator.writeKey("delete_time_in_millis");
        generator.write(this.deleteTimeInMillis);

        generator.writeKey("delete_total");
        generator.write(this.deleteTotal);

        if (this.docStatus != null) {
            generator.writeKey("doc_status");
            this.docStatus.serialize(generator, mapper);
        }

        generator.writeKey("index_current");
        generator.write(this.indexCurrent);

        generator.writeKey("index_failed");
        generator.write(this.indexFailed);

        if (this.indexTime != null) {
            generator.writeKey("index_time");
            this.indexTime.serialize(generator, mapper);
        }

        generator.writeKey("index_time_in_millis");
        generator.write(this.indexTimeInMillis);

        generator.writeKey("index_total");
        generator.write(this.indexTotal);

        generator.writeKey("is_throttled");
        generator.write(this.isThrottled);

        generator.writeKey("noop_update_total");
        generator.write(this.noopUpdateTotal);

        if (this.throttleTime != null) {
            generator.writeKey("throttle_time");
            this.throttleTime.serialize(generator, mapper);
        }

        generator.writeKey("throttle_time_in_millis");
        generator.write(this.throttleTimeInMillis);
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
     * Builder for {@link IndexingStats}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, IndexingStats> {
        private Long deleteCurrent;
        @Nullable
        private Time deleteTime;
        private Long deleteTimeInMillis;
        private Long deleteTotal;
        @Nullable
        private DocStatus docStatus;
        private Long indexCurrent;
        private Long indexFailed;
        @Nullable
        private Time indexTime;
        private Long indexTimeInMillis;
        private Long indexTotal;
        private Boolean isThrottled;
        private Long noopUpdateTotal;
        @Nullable
        private Time throttleTime;
        private Long throttleTimeInMillis;

        public Builder() {}

        private Builder(IndexingStats o) {
            this.deleteCurrent = o.deleteCurrent;
            this.deleteTime = o.deleteTime;
            this.deleteTimeInMillis = o.deleteTimeInMillis;
            this.deleteTotal = o.deleteTotal;
            this.docStatus = o.docStatus;
            this.indexCurrent = o.indexCurrent;
            this.indexFailed = o.indexFailed;
            this.indexTime = o.indexTime;
            this.indexTimeInMillis = o.indexTimeInMillis;
            this.indexTotal = o.indexTotal;
            this.isThrottled = o.isThrottled;
            this.noopUpdateTotal = o.noopUpdateTotal;
            this.throttleTime = o.throttleTime;
            this.throttleTimeInMillis = o.throttleTimeInMillis;
        }

        private Builder(Builder o) {
            this.deleteCurrent = o.deleteCurrent;
            this.deleteTime = o.deleteTime;
            this.deleteTimeInMillis = o.deleteTimeInMillis;
            this.deleteTotal = o.deleteTotal;
            this.docStatus = o.docStatus;
            this.indexCurrent = o.indexCurrent;
            this.indexFailed = o.indexFailed;
            this.indexTime = o.indexTime;
            this.indexTimeInMillis = o.indexTimeInMillis;
            this.indexTotal = o.indexTotal;
            this.isThrottled = o.isThrottled;
            this.noopUpdateTotal = o.noopUpdateTotal;
            this.throttleTime = o.throttleTime;
            this.throttleTimeInMillis = o.throttleTimeInMillis;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - API name: {@code delete_current}
         */
        @Nonnull
        public final Builder deleteCurrent(long value) {
            this.deleteCurrent = value;
            return this;
        }

        /**
         * API name: {@code delete_time}
         */
        @Nonnull
        public final Builder deleteTime(@Nullable Time value) {
            this.deleteTime = value;
            return this;
        }

        /**
         * API name: {@code delete_time}
         */
        @Nonnull
        public final Builder deleteTime(Function<Time.Builder, ObjectBuilder<Time>> fn) {
            return deleteTime(fn.apply(new Time.Builder()).build());
        }

        /**
         * Required - API name: {@code delete_time_in_millis}
         */
        @Nonnull
        public final Builder deleteTimeInMillis(long value) {
            this.deleteTimeInMillis = value;
            return this;
        }

        /**
         * Required - API name: {@code delete_total}
         */
        @Nonnull
        public final Builder deleteTotal(long value) {
            this.deleteTotal = value;
            return this;
        }

        /**
         * API name: {@code doc_status}
         */
        @Nonnull
        public final Builder docStatus(@Nullable DocStatus value) {
            this.docStatus = value;
            return this;
        }

        /**
         * API name: {@code doc_status}
         */
        @Nonnull
        public final Builder docStatus(Function<DocStatus.Builder, ObjectBuilder<DocStatus>> fn) {
            return docStatus(fn.apply(new DocStatus.Builder()).build());
        }

        /**
         * Required - API name: {@code index_current}
         */
        @Nonnull
        public final Builder indexCurrent(long value) {
            this.indexCurrent = value;
            return this;
        }

        /**
         * Required - API name: {@code index_failed}
         */
        @Nonnull
        public final Builder indexFailed(long value) {
            this.indexFailed = value;
            return this;
        }

        /**
         * API name: {@code index_time}
         */
        @Nonnull
        public final Builder indexTime(@Nullable Time value) {
            this.indexTime = value;
            return this;
        }

        /**
         * API name: {@code index_time}
         */
        @Nonnull
        public final Builder indexTime(Function<Time.Builder, ObjectBuilder<Time>> fn) {
            return indexTime(fn.apply(new Time.Builder()).build());
        }

        /**
         * Required - API name: {@code index_time_in_millis}
         */
        @Nonnull
        public final Builder indexTimeInMillis(long value) {
            this.indexTimeInMillis = value;
            return this;
        }

        /**
         * Required - API name: {@code index_total}
         */
        @Nonnull
        public final Builder indexTotal(long value) {
            this.indexTotal = value;
            return this;
        }

        /**
         * Required - API name: {@code is_throttled}
         */
        @Nonnull
        public final Builder isThrottled(boolean value) {
            this.isThrottled = value;
            return this;
        }

        /**
         * Required - API name: {@code noop_update_total}
         */
        @Nonnull
        public final Builder noopUpdateTotal(long value) {
            this.noopUpdateTotal = value;
            return this;
        }

        /**
         * API name: {@code throttle_time}
         */
        @Nonnull
        public final Builder throttleTime(@Nullable Time value) {
            this.throttleTime = value;
            return this;
        }

        /**
         * API name: {@code throttle_time}
         */
        @Nonnull
        public final Builder throttleTime(Function<Time.Builder, ObjectBuilder<Time>> fn) {
            return throttleTime(fn.apply(new Time.Builder()).build());
        }

        /**
         * Required - API name: {@code throttle_time_in_millis}
         */
        @Nonnull
        public final Builder throttleTimeInMillis(long value) {
            this.throttleTimeInMillis = value;
            return this;
        }

        /**
         * Builds a {@link IndexingStats}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public IndexingStats build() {
            _checkSingleUse();

            return new IndexingStats(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link IndexingStats}
     */
    public static final JsonpDeserializer<IndexingStats> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        IndexingStats::setupIndexingStatsDeserializer
    );

    protected static void setupIndexingStatsDeserializer(ObjectDeserializer<IndexingStats.Builder> op) {
        op.add(Builder::deleteCurrent, JsonpDeserializer.longDeserializer(), "delete_current");
        op.add(Builder::deleteTime, Time._DESERIALIZER, "delete_time");
        op.add(Builder::deleteTimeInMillis, JsonpDeserializer.longDeserializer(), "delete_time_in_millis");
        op.add(Builder::deleteTotal, JsonpDeserializer.longDeserializer(), "delete_total");
        op.add(Builder::docStatus, DocStatus._DESERIALIZER, "doc_status");
        op.add(Builder::indexCurrent, JsonpDeserializer.longDeserializer(), "index_current");
        op.add(Builder::indexFailed, JsonpDeserializer.longDeserializer(), "index_failed");
        op.add(Builder::indexTime, Time._DESERIALIZER, "index_time");
        op.add(Builder::indexTimeInMillis, JsonpDeserializer.longDeserializer(), "index_time_in_millis");
        op.add(Builder::indexTotal, JsonpDeserializer.longDeserializer(), "index_total");
        op.add(Builder::isThrottled, JsonpDeserializer.booleanDeserializer(), "is_throttled");
        op.add(Builder::noopUpdateTotal, JsonpDeserializer.longDeserializer(), "noop_update_total");
        op.add(Builder::throttleTime, Time._DESERIALIZER, "throttle_time");
        op.add(Builder::throttleTimeInMillis, JsonpDeserializer.longDeserializer(), "throttle_time_in_millis");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Long.hashCode(this.deleteCurrent);
        result = 31 * result + Objects.hashCode(this.deleteTime);
        result = 31 * result + Long.hashCode(this.deleteTimeInMillis);
        result = 31 * result + Long.hashCode(this.deleteTotal);
        result = 31 * result + Objects.hashCode(this.docStatus);
        result = 31 * result + Long.hashCode(this.indexCurrent);
        result = 31 * result + Long.hashCode(this.indexFailed);
        result = 31 * result + Objects.hashCode(this.indexTime);
        result = 31 * result + Long.hashCode(this.indexTimeInMillis);
        result = 31 * result + Long.hashCode(this.indexTotal);
        result = 31 * result + Boolean.hashCode(this.isThrottled);
        result = 31 * result + Long.hashCode(this.noopUpdateTotal);
        result = 31 * result + Objects.hashCode(this.throttleTime);
        result = 31 * result + Long.hashCode(this.throttleTimeInMillis);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        IndexingStats other = (IndexingStats) o;
        return this.deleteCurrent == other.deleteCurrent
            && Objects.equals(this.deleteTime, other.deleteTime)
            && this.deleteTimeInMillis == other.deleteTimeInMillis
            && this.deleteTotal == other.deleteTotal
            && Objects.equals(this.docStatus, other.docStatus)
            && this.indexCurrent == other.indexCurrent
            && this.indexFailed == other.indexFailed
            && Objects.equals(this.indexTime, other.indexTime)
            && this.indexTimeInMillis == other.indexTimeInMillis
            && this.indexTotal == other.indexTotal
            && this.isThrottled == other.isThrottled
            && this.noopUpdateTotal == other.noopUpdateTotal
            && Objects.equals(this.throttleTime, other.throttleTime)
            && this.throttleTimeInMillis == other.throttleTimeInMillis;
    }
}
