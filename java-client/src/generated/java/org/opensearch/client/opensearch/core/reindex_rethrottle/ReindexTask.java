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

package org.opensearch.client.opensearch.core.reindex_rethrottle;

import jakarta.json.stream.JsonGenerator;
import java.util.List;
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
import org.opensearch.client.opensearch._types.ResourceStats;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: core.reindex_rethrottle.ReindexTask

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class ReindexTask implements PlainJsonSerializable, ToCopyableBuilder<ReindexTask.Builder, ReindexTask> {

    @Nonnull
    private final String action;

    private final boolean cancellable;

    @Nullable
    private final Boolean cancelled;

    @Nonnull
    private final String description;

    @Nonnull
    private final Map<String, List<String>> headers;

    private final long id;

    @Nonnull
    private final String node;

    @Nullable
    private final ResourceStats resourceStats;

    private final long runningTimeInNanos;

    private final long startTimeInMillis;

    @Nonnull
    private final ReindexStatus status;

    @Nonnull
    private final String type;

    // ---------------------------------------------------------------------------------------------

    private ReindexTask(Builder builder) {
        this.action = ApiTypeHelper.requireNonNull(builder.action, this, "action");
        this.cancellable = ApiTypeHelper.requireNonNull(builder.cancellable, this, "cancellable");
        this.cancelled = builder.cancelled;
        this.description = ApiTypeHelper.requireNonNull(builder.description, this, "description");
        this.headers = ApiTypeHelper.unmodifiableRequired(builder.headers, this, "headers");
        this.id = ApiTypeHelper.requireNonNull(builder.id, this, "id");
        this.node = ApiTypeHelper.requireNonNull(builder.node, this, "node");
        this.resourceStats = builder.resourceStats;
        this.runningTimeInNanos = ApiTypeHelper.requireNonNull(builder.runningTimeInNanos, this, "runningTimeInNanos");
        this.startTimeInMillis = ApiTypeHelper.requireNonNull(builder.startTimeInMillis, this, "startTimeInMillis");
        this.status = ApiTypeHelper.requireNonNull(builder.status, this, "status");
        this.type = ApiTypeHelper.requireNonNull(builder.type, this, "type");
    }

    public static ReindexTask of(Function<ReindexTask.Builder, ObjectBuilder<ReindexTask>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code action}
     */
    @Nonnull
    public final String action() {
        return this.action;
    }

    /**
     * Required - API name: {@code cancellable}
     */
    public final boolean cancellable() {
        return this.cancellable;
    }

    /**
     * API name: {@code cancelled}
     */
    @Nullable
    public final Boolean cancelled() {
        return this.cancelled;
    }

    /**
     * Required - API name: {@code description}
     */
    @Nonnull
    public final String description() {
        return this.description;
    }

    /**
     * Required - API name: {@code headers}
     */
    @Nonnull
    public final Map<String, List<String>> headers() {
        return this.headers;
    }

    /**
     * Required - API name: {@code id}
     */
    public final long id() {
        return this.id;
    }

    /**
     * Required - API name: {@code node}
     */
    @Nonnull
    public final String node() {
        return this.node;
    }

    /**
     * API name: {@code resource_stats}
     */
    @Nullable
    public final ResourceStats resourceStats() {
        return this.resourceStats;
    }

    /**
     * Required - API name: {@code running_time_in_nanos}
     */
    public final long runningTimeInNanos() {
        return this.runningTimeInNanos;
    }

    /**
     * Required - API name: {@code start_time_in_millis}
     */
    public final long startTimeInMillis() {
        return this.startTimeInMillis;
    }

    /**
     * Required - API name: {@code status}
     */
    @Nonnull
    public final ReindexStatus status() {
        return this.status;
    }

    /**
     * Required - API name: {@code type}
     */
    @Nonnull
    public final String type() {
        return this.type;
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
        generator.writeKey("action");
        generator.write(this.action);

        generator.writeKey("cancellable");
        generator.write(this.cancellable);

        if (this.cancelled != null) {
            generator.writeKey("cancelled");
            generator.write(this.cancelled);
        }

        generator.writeKey("description");
        generator.write(this.description);

        generator.writeKey("headers");
        generator.writeStartObject();
        for (Map.Entry<String, List<String>> item0 : this.headers.entrySet()) {
            generator.writeKey(item0.getKey());
            generator.writeStartArray();
            if (item0.getValue() != null) {
                for (String item1 : item0.getValue()) {
                    generator.write(item1);
                }
            }
            generator.writeEnd();
        }
        generator.writeEnd();

        generator.writeKey("id");
        generator.write(this.id);

        generator.writeKey("node");
        generator.write(this.node);

        if (this.resourceStats != null) {
            generator.writeKey("resource_stats");
            this.resourceStats.serialize(generator, mapper);
        }

        generator.writeKey("running_time_in_nanos");
        generator.write(this.runningTimeInNanos);

        generator.writeKey("start_time_in_millis");
        generator.write(this.startTimeInMillis);

        generator.writeKey("status");
        this.status.serialize(generator, mapper);

        generator.writeKey("type");
        generator.write(this.type);
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
     * Builder for {@link ReindexTask}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, ReindexTask> {
        private String action;
        private Boolean cancellable;
        @Nullable
        private Boolean cancelled;
        private String description;
        private Map<String, List<String>> headers;
        private Long id;
        private String node;
        @Nullable
        private ResourceStats resourceStats;
        private Long runningTimeInNanos;
        private Long startTimeInMillis;
        private ReindexStatus status;
        private String type;

        public Builder() {}

        private Builder(ReindexTask o) {
            this.action = o.action;
            this.cancellable = o.cancellable;
            this.cancelled = o.cancelled;
            this.description = o.description;
            this.headers = _mapCopy(o.headers);
            this.id = o.id;
            this.node = o.node;
            this.resourceStats = o.resourceStats;
            this.runningTimeInNanos = o.runningTimeInNanos;
            this.startTimeInMillis = o.startTimeInMillis;
            this.status = o.status;
            this.type = o.type;
        }

        private Builder(Builder o) {
            this.action = o.action;
            this.cancellable = o.cancellable;
            this.cancelled = o.cancelled;
            this.description = o.description;
            this.headers = _mapCopy(o.headers);
            this.id = o.id;
            this.node = o.node;
            this.resourceStats = o.resourceStats;
            this.runningTimeInNanos = o.runningTimeInNanos;
            this.startTimeInMillis = o.startTimeInMillis;
            this.status = o.status;
            this.type = o.type;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - API name: {@code action}
         */
        @Nonnull
        public final Builder action(String value) {
            this.action = value;
            return this;
        }

        /**
         * Required - API name: {@code cancellable}
         */
        @Nonnull
        public final Builder cancellable(boolean value) {
            this.cancellable = value;
            return this;
        }

        /**
         * API name: {@code cancelled}
         */
        @Nonnull
        public final Builder cancelled(@Nullable Boolean value) {
            this.cancelled = value;
            return this;
        }

        /**
         * Required - API name: {@code description}
         */
        @Nonnull
        public final Builder description(String value) {
            this.description = value;
            return this;
        }

        /**
         * Required - API name: {@code headers}
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>headers</code>.
         * </p>
         */
        @Nonnull
        public final Builder headers(Map<String, List<String>> map) {
            this.headers = _mapPutAll(this.headers, map);
            return this;
        }

        /**
         * Required - API name: {@code headers}
         *
         * <p>
         * Adds an entry to <code>headers</code>.
         * </p>
         */
        @Nonnull
        public final Builder headers(String key, List<String> value) {
            this.headers = _mapPut(this.headers, key, value);
            return this;
        }

        /**
         * Required - API name: {@code id}
         */
        @Nonnull
        public final Builder id(long value) {
            this.id = value;
            return this;
        }

        /**
         * Required - API name: {@code node}
         */
        @Nonnull
        public final Builder node(String value) {
            this.node = value;
            return this;
        }

        /**
         * API name: {@code resource_stats}
         */
        @Nonnull
        public final Builder resourceStats(@Nullable ResourceStats value) {
            this.resourceStats = value;
            return this;
        }

        /**
         * API name: {@code resource_stats}
         */
        @Nonnull
        public final Builder resourceStats(Function<ResourceStats.Builder, ObjectBuilder<ResourceStats>> fn) {
            return resourceStats(fn.apply(new ResourceStats.Builder()).build());
        }

        /**
         * Required - API name: {@code running_time_in_nanos}
         */
        @Nonnull
        public final Builder runningTimeInNanos(long value) {
            this.runningTimeInNanos = value;
            return this;
        }

        /**
         * Required - API name: {@code start_time_in_millis}
         */
        @Nonnull
        public final Builder startTimeInMillis(long value) {
            this.startTimeInMillis = value;
            return this;
        }

        /**
         * Required - API name: {@code status}
         */
        @Nonnull
        public final Builder status(ReindexStatus value) {
            this.status = value;
            return this;
        }

        /**
         * Required - API name: {@code status}
         */
        @Nonnull
        public final Builder status(Function<ReindexStatus.Builder, ObjectBuilder<ReindexStatus>> fn) {
            return status(fn.apply(new ReindexStatus.Builder()).build());
        }

        /**
         * Required - API name: {@code type}
         */
        @Nonnull
        public final Builder type(String value) {
            this.type = value;
            return this;
        }

        /**
         * Builds a {@link ReindexTask}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ReindexTask build() {
            _checkSingleUse();

            return new ReindexTask(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ReindexTask}
     */
    public static final JsonpDeserializer<ReindexTask> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ReindexTask::setupReindexTaskDeserializer
    );

    protected static void setupReindexTaskDeserializer(ObjectDeserializer<ReindexTask.Builder> op) {
        op.add(Builder::action, JsonpDeserializer.stringDeserializer(), "action");
        op.add(Builder::cancellable, JsonpDeserializer.booleanDeserializer(), "cancellable");
        op.add(Builder::cancelled, JsonpDeserializer.booleanDeserializer(), "cancelled");
        op.add(Builder::description, JsonpDeserializer.stringDeserializer(), "description");
        op.add(
            Builder::headers,
            JsonpDeserializer.stringMapDeserializer(JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer())),
            "headers"
        );
        op.add(Builder::id, JsonpDeserializer.longDeserializer(), "id");
        op.add(Builder::node, JsonpDeserializer.stringDeserializer(), "node");
        op.add(Builder::resourceStats, ResourceStats._DESERIALIZER, "resource_stats");
        op.add(Builder::runningTimeInNanos, JsonpDeserializer.longDeserializer(), "running_time_in_nanos");
        op.add(Builder::startTimeInMillis, JsonpDeserializer.longDeserializer(), "start_time_in_millis");
        op.add(Builder::status, ReindexStatus._DESERIALIZER, "status");
        op.add(Builder::type, JsonpDeserializer.stringDeserializer(), "type");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.action.hashCode();
        result = 31 * result + Boolean.hashCode(this.cancellable);
        result = 31 * result + Objects.hashCode(this.cancelled);
        result = 31 * result + this.description.hashCode();
        result = 31 * result + this.headers.hashCode();
        result = 31 * result + Long.hashCode(this.id);
        result = 31 * result + this.node.hashCode();
        result = 31 * result + Objects.hashCode(this.resourceStats);
        result = 31 * result + Long.hashCode(this.runningTimeInNanos);
        result = 31 * result + Long.hashCode(this.startTimeInMillis);
        result = 31 * result + this.status.hashCode();
        result = 31 * result + this.type.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ReindexTask other = (ReindexTask) o;
        return this.action.equals(other.action)
            && this.cancellable == other.cancellable
            && Objects.equals(this.cancelled, other.cancelled)
            && this.description.equals(other.description)
            && this.headers.equals(other.headers)
            && this.id == other.id
            && this.node.equals(other.node)
            && Objects.equals(this.resourceStats, other.resourceStats)
            && this.runningTimeInNanos == other.runningTimeInNanos
            && this.startTimeInMillis == other.startTimeInMillis
            && this.status.equals(other.status)
            && this.type.equals(other.type);
    }
}
