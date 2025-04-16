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
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
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

// typedef: _types.ResourceStats

/**
 * The statistics about resource usage.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class ResourceStats implements PlainJsonSerializable, ToCopyableBuilder<ResourceStats.Builder, ResourceStats> {

    @Nonnull
    private final ResourceStat average;

    @Nonnull
    private final ResourceStat max;

    @Nonnull
    private final ResourceStat min;

    @Nonnull
    private final ThreadInfo threadInfo;

    @Nonnull
    private final ResourceStat total;

    // ---------------------------------------------------------------------------------------------

    private ResourceStats(Builder builder) {
        this.average = ApiTypeHelper.requireNonNull(builder.average, this, "average");
        this.max = ApiTypeHelper.requireNonNull(builder.max, this, "max");
        this.min = ApiTypeHelper.requireNonNull(builder.min, this, "min");
        this.threadInfo = ApiTypeHelper.requireNonNull(builder.threadInfo, this, "threadInfo");
        this.total = ApiTypeHelper.requireNonNull(builder.total, this, "total");
    }

    public static ResourceStats of(Function<ResourceStats.Builder, ObjectBuilder<ResourceStats>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code average}
     */
    @Nonnull
    public final ResourceStat average() {
        return this.average;
    }

    /**
     * Required - API name: {@code max}
     */
    @Nonnull
    public final ResourceStat max() {
        return this.max;
    }

    /**
     * Required - API name: {@code min}
     */
    @Nonnull
    public final ResourceStat min() {
        return this.min;
    }

    /**
     * Required - API name: {@code thread_info}
     */
    @Nonnull
    public final ThreadInfo threadInfo() {
        return this.threadInfo;
    }

    /**
     * Required - API name: {@code total}
     */
    @Nonnull
    public final ResourceStat total() {
        return this.total;
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
        generator.writeKey("average");
        this.average.serialize(generator, mapper);

        generator.writeKey("max");
        this.max.serialize(generator, mapper);

        generator.writeKey("min");
        this.min.serialize(generator, mapper);

        generator.writeKey("thread_info");
        this.threadInfo.serialize(generator, mapper);

        generator.writeKey("total");
        this.total.serialize(generator, mapper);
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
     * Builder for {@link ResourceStats}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, ResourceStats> {
        private ResourceStat average;
        private ResourceStat max;
        private ResourceStat min;
        private ThreadInfo threadInfo;
        private ResourceStat total;

        public Builder() {}

        private Builder(ResourceStats o) {
            this.average = o.average;
            this.max = o.max;
            this.min = o.min;
            this.threadInfo = o.threadInfo;
            this.total = o.total;
        }

        private Builder(Builder o) {
            this.average = o.average;
            this.max = o.max;
            this.min = o.min;
            this.threadInfo = o.threadInfo;
            this.total = o.total;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - API name: {@code average}
         */
        @Nonnull
        public final Builder average(ResourceStat value) {
            this.average = value;
            return this;
        }

        /**
         * Required - API name: {@code average}
         */
        @Nonnull
        public final Builder average(Function<ResourceStat.Builder, ObjectBuilder<ResourceStat>> fn) {
            return average(fn.apply(new ResourceStat.Builder()).build());
        }

        /**
         * Required - API name: {@code max}
         */
        @Nonnull
        public final Builder max(ResourceStat value) {
            this.max = value;
            return this;
        }

        /**
         * Required - API name: {@code max}
         */
        @Nonnull
        public final Builder max(Function<ResourceStat.Builder, ObjectBuilder<ResourceStat>> fn) {
            return max(fn.apply(new ResourceStat.Builder()).build());
        }

        /**
         * Required - API name: {@code min}
         */
        @Nonnull
        public final Builder min(ResourceStat value) {
            this.min = value;
            return this;
        }

        /**
         * Required - API name: {@code min}
         */
        @Nonnull
        public final Builder min(Function<ResourceStat.Builder, ObjectBuilder<ResourceStat>> fn) {
            return min(fn.apply(new ResourceStat.Builder()).build());
        }

        /**
         * Required - API name: {@code thread_info}
         */
        @Nonnull
        public final Builder threadInfo(ThreadInfo value) {
            this.threadInfo = value;
            return this;
        }

        /**
         * Required - API name: {@code thread_info}
         */
        @Nonnull
        public final Builder threadInfo(Function<ThreadInfo.Builder, ObjectBuilder<ThreadInfo>> fn) {
            return threadInfo(fn.apply(new ThreadInfo.Builder()).build());
        }

        /**
         * Required - API name: {@code total}
         */
        @Nonnull
        public final Builder total(ResourceStat value) {
            this.total = value;
            return this;
        }

        /**
         * Required - API name: {@code total}
         */
        @Nonnull
        public final Builder total(Function<ResourceStat.Builder, ObjectBuilder<ResourceStat>> fn) {
            return total(fn.apply(new ResourceStat.Builder()).build());
        }

        /**
         * Builds a {@link ResourceStats}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ResourceStats build() {
            _checkSingleUse();

            return new ResourceStats(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ResourceStats}
     */
    public static final JsonpDeserializer<ResourceStats> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ResourceStats::setupResourceStatsDeserializer
    );

    protected static void setupResourceStatsDeserializer(ObjectDeserializer<ResourceStats.Builder> op) {
        op.add(Builder::average, ResourceStat._DESERIALIZER, "average");
        op.add(Builder::max, ResourceStat._DESERIALIZER, "max");
        op.add(Builder::min, ResourceStat._DESERIALIZER, "min");
        op.add(Builder::threadInfo, ThreadInfo._DESERIALIZER, "thread_info");
        op.add(Builder::total, ResourceStat._DESERIALIZER, "total");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.average.hashCode();
        result = 31 * result + this.max.hashCode();
        result = 31 * result + this.min.hashCode();
        result = 31 * result + this.threadInfo.hashCode();
        result = 31 * result + this.total.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ResourceStats other = (ResourceStats) o;
        return this.average.equals(other.average)
            && this.max.equals(other.max)
            && this.min.equals(other.min)
            && this.threadInfo.equals(other.threadInfo)
            && this.total.equals(other.total);
    }
}
