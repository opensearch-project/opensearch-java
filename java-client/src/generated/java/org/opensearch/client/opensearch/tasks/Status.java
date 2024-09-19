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

package org.opensearch.client.opensearch.tasks;

import jakarta.json.stream.JsonGenerator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nullable;
import org.opensearch.client.json.JsonData;
import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.json.PlainJsonSerializable;
import org.opensearch.client.opensearch._types.BulkByScrollTaskStatusOrException;
import org.opensearch.client.opensearch._types.Retries;
import org.opensearch.client.opensearch._types.Time;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;

// typedef: tasks.Status

/**
 * Task status information can vary wildly from task to task.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class Status implements PlainJsonSerializable {

    @Nullable
    private final Integer batches;

    @Nullable
    private final String canceled;

    @Nullable
    private final Long created;

    @Nullable
    private final Long deleted;

    @Nullable
    private final Long noops;

    @Nullable
    private final String phase;

    @Nullable
    private final Float requestsPerSecond;

    @Nullable
    private final Retries retries;

    @Nullable
    private final Integer sliceId;

    private final List<BulkByScrollTaskStatusOrException> slices;

    @Nullable
    private final String state;

    @Nullable
    private final Time throttled;

    @Nullable
    private final Long throttledMillis;

    @Nullable
    private final Time throttledUntil;

    @Nullable
    private final Long throttledUntilMillis;

    @Nullable
    private final Long total;

    @Nullable
    private final Long updated;

    @Nullable
    private final Long versionConflicts;

    private final Map<String, JsonData> metadata;

    // ---------------------------------------------------------------------------------------------

    private Status(Builder builder) {
        this.batches = builder.batches;
        this.canceled = builder.canceled;
        this.created = builder.created;
        this.deleted = builder.deleted;
        this.noops = builder.noops;
        this.phase = builder.phase;
        this.requestsPerSecond = builder.requestsPerSecond;
        this.retries = builder.retries;
        this.sliceId = builder.sliceId;
        this.slices = ApiTypeHelper.unmodifiable(builder.slices);
        this.state = builder.state;
        this.throttled = builder.throttled;
        this.throttledMillis = builder.throttledMillis;
        this.throttledUntil = builder.throttledUntil;
        this.throttledUntilMillis = builder.throttledUntilMillis;
        this.total = builder.total;
        this.updated = builder.updated;
        this.versionConflicts = builder.versionConflicts;
        this.metadata = ApiTypeHelper.unmodifiable(builder.metadata);
    }

    public static Status of(Function<Status.Builder, ObjectBuilder<Status>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * The number of scroll responses pulled back by the reindex.
     * <p>
     * API name: {@code batches}
     * </p>
     */
    @Nullable
    public final Integer batches() {
        return this.batches;
    }

    /**
     * API name: {@code canceled}
     */
    @Nullable
    public final String canceled() {
        return this.canceled;
    }

    /**
     * The number of documents that were successfully created.
     * <p>
     * API name: {@code created}
     * </p>
     */
    @Nullable
    public final Long created() {
        return this.created;
    }

    /**
     * The number of documents that were successfully deleted.
     * <p>
     * API name: {@code deleted}
     * </p>
     */
    @Nullable
    public final Long deleted() {
        return this.deleted;
    }

    /**
     * The number of documents that were ignored.
     * <p>
     * API name: {@code noops}
     * </p>
     */
    @Nullable
    public final Long noops() {
        return this.noops;
    }

    /**
     * API name: {@code phase}
     */
    @Nullable
    public final String phase() {
        return this.phase;
    }

    /**
     * The number of requests per second effectively executed during the reindex.
     * <p>
     * API name: {@code requests_per_second}
     * </p>
     */
    @Nullable
    public final Float requestsPerSecond() {
        return this.requestsPerSecond;
    }

    /**
     * API name: {@code retries}
     */
    @Nullable
    public final Retries retries() {
        return this.retries;
    }

    /**
     * API name: {@code slice_id}
     */
    @Nullable
    public final Integer sliceId() {
        return this.sliceId;
    }

    /**
     * API name: {@code slices}
     */
    public final List<BulkByScrollTaskStatusOrException> slices() {
        return this.slices;
    }

    /**
     * API name: {@code state}
     */
    @Nullable
    public final String state() {
        return this.state;
    }

    /**
     * API name: {@code throttled}
     */
    @Nullable
    public final Time throttled() {
        return this.throttled;
    }

    /**
     * API name: {@code throttled_millis}
     */
    @Nullable
    public final Long throttledMillis() {
        return this.throttledMillis;
    }

    /**
     * API name: {@code throttled_until}
     */
    @Nullable
    public final Time throttledUntil() {
        return this.throttledUntil;
    }

    /**
     * API name: {@code throttled_until_millis}
     */
    @Nullable
    public final Long throttledUntilMillis() {
        return this.throttledUntilMillis;
    }

    /**
     * The number of documents that were successfully processed.
     * <p>
     * API name: {@code total}
     * </p>
     */
    @Nullable
    public final Long total() {
        return this.total;
    }

    /**
     * The number of documents that were successfully updated, for example, a document with same ID already existed prior to reindex
     * updating it.
     * <p>
     * API name: {@code updated}
     * </p>
     */
    @Nullable
    public final Long updated() {
        return this.updated;
    }

    /**
     * The number of version conflicts that reindex hits.
     * <p>
     * API name: {@code version_conflicts}
     * </p>
     */
    @Nullable
    public final Long versionConflicts() {
        return this.versionConflicts;
    }

    /**
                                    */
    public final Map<String, JsonData> metadata() {
        return this.metadata;
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
        for (Map.Entry<String, JsonData> item0 : this.metadata.entrySet()) {
            generator.writeKey(item0.getKey());
            item0.getValue().serialize(generator, mapper);
        }
        if (this.batches != null) {
            generator.writeKey("batches");
            generator.write(this.batches);
        }

        if (this.canceled != null) {
            generator.writeKey("canceled");
            generator.write(this.canceled);
        }

        if (this.created != null) {
            generator.writeKey("created");
            generator.write(this.created);
        }

        if (this.deleted != null) {
            generator.writeKey("deleted");
            generator.write(this.deleted);
        }

        if (this.noops != null) {
            generator.writeKey("noops");
            generator.write(this.noops);
        }

        if (this.phase != null) {
            generator.writeKey("phase");
            generator.write(this.phase);
        }

        if (this.requestsPerSecond != null) {
            generator.writeKey("requests_per_second");
            generator.write(this.requestsPerSecond);
        }

        if (this.retries != null) {
            generator.writeKey("retries");
            this.retries.serialize(generator, mapper);
        }

        if (this.sliceId != null) {
            generator.writeKey("slice_id");
            generator.write(this.sliceId);
        }

        if (ApiTypeHelper.isDefined(this.slices)) {
            generator.writeKey("slices");
            generator.writeStartArray();
            for (BulkByScrollTaskStatusOrException item0 : this.slices) {
                item0.serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (this.state != null) {
            generator.writeKey("state");
            generator.write(this.state);
        }

        if (this.throttled != null) {
            generator.writeKey("throttled");
            this.throttled.serialize(generator, mapper);
        }

        if (this.throttledMillis != null) {
            generator.writeKey("throttled_millis");
            generator.write(this.throttledMillis);
        }

        if (this.throttledUntil != null) {
            generator.writeKey("throttled_until");
            this.throttledUntil.serialize(generator, mapper);
        }

        if (this.throttledUntilMillis != null) {
            generator.writeKey("throttled_until_millis");
            generator.write(this.throttledUntilMillis);
        }

        if (this.total != null) {
            generator.writeKey("total");
            generator.write(this.total);
        }

        if (this.updated != null) {
            generator.writeKey("updated");
            generator.write(this.updated);
        }

        if (this.versionConflicts != null) {
            generator.writeKey("version_conflicts");
            generator.write(this.versionConflicts);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Builder for {@link Status}.
     */
    public static class Builder extends ObjectBuilderBase implements ObjectBuilder<Status> {
        @Nullable
        private Integer batches;
        @Nullable
        private String canceled;
        @Nullable
        private Long created;
        @Nullable
        private Long deleted;
        @Nullable
        private Long noops;
        @Nullable
        private String phase;
        @Nullable
        private Float requestsPerSecond;
        @Nullable
        private Retries retries;
        @Nullable
        private Integer sliceId;
        @Nullable
        private List<BulkByScrollTaskStatusOrException> slices;
        @Nullable
        private String state;
        @Nullable
        private Time throttled;
        @Nullable
        private Long throttledMillis;
        @Nullable
        private Time throttledUntil;
        @Nullable
        private Long throttledUntilMillis;
        @Nullable
        private Long total;
        @Nullable
        private Long updated;
        @Nullable
        private Long versionConflicts;
        @Nullable
        private Map<String, JsonData> metadata;

        /**
         * The number of scroll responses pulled back by the reindex.
         * <p>
         * API name: {@code batches}
         * </p>
         */
        public final Builder batches(@Nullable Integer value) {
            this.batches = value;
            return this;
        }

        /**
         * API name: {@code canceled}
         */
        public final Builder canceled(@Nullable String value) {
            this.canceled = value;
            return this;
        }

        /**
         * The number of documents that were successfully created.
         * <p>
         * API name: {@code created}
         * </p>
         */
        public final Builder created(@Nullable Long value) {
            this.created = value;
            return this;
        }

        /**
         * The number of documents that were successfully deleted.
         * <p>
         * API name: {@code deleted}
         * </p>
         */
        public final Builder deleted(@Nullable Long value) {
            this.deleted = value;
            return this;
        }

        /**
         * The number of documents that were ignored.
         * <p>
         * API name: {@code noops}
         * </p>
         */
        public final Builder noops(@Nullable Long value) {
            this.noops = value;
            return this;
        }

        /**
         * API name: {@code phase}
         */
        public final Builder phase(@Nullable String value) {
            this.phase = value;
            return this;
        }

        /**
         * The number of requests per second effectively executed during the reindex.
         * <p>
         * API name: {@code requests_per_second}
         * </p>
         */
        public final Builder requestsPerSecond(@Nullable Float value) {
            this.requestsPerSecond = value;
            return this;
        }

        /**
         * API name: {@code retries}
         */
        public final Builder retries(@Nullable Retries value) {
            this.retries = value;
            return this;
        }

        /**
         * API name: {@code retries}
         */
        public final Builder retries(Function<Retries.Builder, ObjectBuilder<Retries>> fn) {
            return retries(fn.apply(new Retries.Builder()).build());
        }

        /**
         * API name: {@code slice_id}
         */
        public final Builder sliceId(@Nullable Integer value) {
            this.sliceId = value;
            return this;
        }

        /**
         * API name: {@code slices}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>slices</code>.
         * </p>
         */
        public final Builder slices(List<BulkByScrollTaskStatusOrException> list) {
            this.slices = _listAddAll(this.slices, list);
            return this;
        }

        /**
         * API name: {@code slices}
         *
         * <p>
         * Adds one or more values to <code>slices</code>.
         * </p>
         */
        public final Builder slices(BulkByScrollTaskStatusOrException value, BulkByScrollTaskStatusOrException... values) {
            this.slices = _listAdd(this.slices, value, values);
            return this;
        }

        /**
         * API name: {@code slices}
         *
         * <p>
         * Adds a value to <code>slices</code> using a builder lambda.
         * </p>
         */
        public final Builder slices(
            Function<BulkByScrollTaskStatusOrException.Builder, ObjectBuilder<BulkByScrollTaskStatusOrException>> fn
        ) {
            return slices(fn.apply(new BulkByScrollTaskStatusOrException.Builder()).build());
        }

        /**
         * API name: {@code state}
         */
        public final Builder state(@Nullable String value) {
            this.state = value;
            return this;
        }

        /**
         * API name: {@code throttled}
         */
        public final Builder throttled(@Nullable Time value) {
            this.throttled = value;
            return this;
        }

        /**
         * API name: {@code throttled}
         */
        public final Builder throttled(Function<Time.Builder, ObjectBuilder<Time>> fn) {
            return throttled(fn.apply(new Time.Builder()).build());
        }

        /**
         * API name: {@code throttled_millis}
         */
        public final Builder throttledMillis(@Nullable Long value) {
            this.throttledMillis = value;
            return this;
        }

        /**
         * API name: {@code throttled_until}
         */
        public final Builder throttledUntil(@Nullable Time value) {
            this.throttledUntil = value;
            return this;
        }

        /**
         * API name: {@code throttled_until}
         */
        public final Builder throttledUntil(Function<Time.Builder, ObjectBuilder<Time>> fn) {
            return throttledUntil(fn.apply(new Time.Builder()).build());
        }

        /**
         * API name: {@code throttled_until_millis}
         */
        public final Builder throttledUntilMillis(@Nullable Long value) {
            this.throttledUntilMillis = value;
            return this;
        }

        /**
         * The number of documents that were successfully processed.
         * <p>
         * API name: {@code total}
         * </p>
         */
        public final Builder total(@Nullable Long value) {
            this.total = value;
            return this;
        }

        /**
         * The number of documents that were successfully updated, for example, a document with same ID already existed prior to reindex
         * updating it.
         * <p>
         * API name: {@code updated}
         * </p>
         */
        public final Builder updated(@Nullable Long value) {
            this.updated = value;
            return this;
        }

        /**
         * The number of version conflicts that reindex hits.
         * <p>
         * API name: {@code version_conflicts}
         * </p>
         */
        public final Builder versionConflicts(@Nullable Long value) {
            this.versionConflicts = value;
            return this;
        }

        /**
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>metadata</code>.
         * </p>
         */
        public final Builder metadata(Map<String, JsonData> map) {
            this.metadata = _mapPutAll(this.metadata, map);
            return this;
        }

        /**
         *
         * <p>
         * Adds an entry to <code>metadata</code>.
         * </p>
         */
        public final Builder metadata(String key, JsonData value) {
            this.metadata = _mapPut(this.metadata, key, value);
            return this;
        }

        /**
         * Builds a {@link Status}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        public Status build() {
            _checkSingleUse();

            return new Status(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link Status}
     */
    public static final JsonpDeserializer<Status> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        Status::setupStatusDeserializer
    );

    protected static void setupStatusDeserializer(ObjectDeserializer<Status.Builder> op) {
        op.add(Builder::batches, JsonpDeserializer.integerDeserializer(), "batches");
        op.add(Builder::canceled, JsonpDeserializer.stringDeserializer(), "canceled");
        op.add(Builder::created, JsonpDeserializer.longDeserializer(), "created");
        op.add(Builder::deleted, JsonpDeserializer.longDeserializer(), "deleted");
        op.add(Builder::noops, JsonpDeserializer.longDeserializer(), "noops");
        op.add(Builder::phase, JsonpDeserializer.stringDeserializer(), "phase");
        op.add(Builder::requestsPerSecond, JsonpDeserializer.floatDeserializer(), "requests_per_second");
        op.add(Builder::retries, Retries._DESERIALIZER, "retries");
        op.add(Builder::sliceId, JsonpDeserializer.integerDeserializer(), "slice_id");
        op.add(Builder::slices, JsonpDeserializer.arrayDeserializer(BulkByScrollTaskStatusOrException._DESERIALIZER), "slices");
        op.add(Builder::state, JsonpDeserializer.stringDeserializer(), "state");
        op.add(Builder::throttled, Time._DESERIALIZER, "throttled");
        op.add(Builder::throttledMillis, JsonpDeserializer.longDeserializer(), "throttled_millis");
        op.add(Builder::throttledUntil, Time._DESERIALIZER, "throttled_until");
        op.add(Builder::throttledUntilMillis, JsonpDeserializer.longDeserializer(), "throttled_until_millis");
        op.add(Builder::total, JsonpDeserializer.longDeserializer(), "total");
        op.add(Builder::updated, JsonpDeserializer.longDeserializer(), "updated");
        op.add(Builder::versionConflicts, JsonpDeserializer.longDeserializer(), "version_conflicts");
        op.setUnknownFieldHandler((builder, name, parser, mapper) -> {
            if (builder.metadata == null) {
                builder.metadata = new HashMap<>();
            }
            builder.metadata.put(name, JsonData._DESERIALIZER.deserialize(parser, mapper));
        });
    }

    public int hashCode() {
        int result = 17;
        result = 31 * result + (batches != null ? Integer.hashCode(this.batches) : 0);
        result = 31 * result + (canceled != null ? this.canceled.hashCode() : 0);
        result = 31 * result + (created != null ? Long.hashCode(this.created) : 0);
        result = 31 * result + (deleted != null ? Long.hashCode(this.deleted) : 0);
        result = 31 * result + (noops != null ? Long.hashCode(this.noops) : 0);
        result = 31 * result + (phase != null ? this.phase.hashCode() : 0);
        result = 31 * result + (requestsPerSecond != null ? Float.hashCode(this.requestsPerSecond) : 0);
        result = 31 * result + (retries != null ? this.retries.hashCode() : 0);
        result = 31 * result + (sliceId != null ? Integer.hashCode(this.sliceId) : 0);
        result = 31 * result + (slices != null ? this.slices.hashCode() : 0);
        result = 31 * result + (state != null ? this.state.hashCode() : 0);
        result = 31 * result + (throttled != null ? this.throttled.hashCode() : 0);
        result = 31 * result + (throttledMillis != null ? Long.hashCode(this.throttledMillis) : 0);
        result = 31 * result + (throttledUntil != null ? this.throttledUntil.hashCode() : 0);
        result = 31 * result + (throttledUntilMillis != null ? Long.hashCode(this.throttledUntilMillis) : 0);
        result = 31 * result + (total != null ? Long.hashCode(this.total) : 0);
        result = 31 * result + (updated != null ? Long.hashCode(this.updated) : 0);
        result = 31 * result + (versionConflicts != null ? Long.hashCode(this.versionConflicts) : 0);
        result = 31 * result + (metadata != null ? this.metadata.hashCode() : 0);
        return result;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (this.getClass() != o.getClass()) return false;
        Status other = (Status) o;
        if (this.batches() != other.batches()) {
            return false;
        }
        if (!this.canceled().equals(other.canceled())) {
            return false;
        }
        if (this.created() != other.created()) {
            return false;
        }
        if (this.deleted() != other.deleted()) {
            return false;
        }
        if (this.noops() != other.noops()) {
            return false;
        }
        if (!this.phase().equals(other.phase())) {
            return false;
        }
        if (this.requestsPerSecond() != other.requestsPerSecond()) {
            return false;
        }
        if (!this.retries().equals(other.retries())) {
            return false;
        }
        if (this.sliceId() != other.sliceId()) {
            return false;
        }
        if (!this.slices().equals(other.slices())) {
            return false;
        }
        if (!this.state().equals(other.state())) {
            return false;
        }
        if (!this.throttled().equals(other.throttled())) {
            return false;
        }
        if (this.throttledMillis() != other.throttledMillis()) {
            return false;
        }
        if (!this.throttledUntil().equals(other.throttledUntil())) {
            return false;
        }
        if (this.throttledUntilMillis() != other.throttledUntilMillis()) {
            return false;
        }
        if (this.total() != other.total()) {
            return false;
        }
        if (this.updated() != other.updated()) {
            return false;
        }
        if (this.versionConflicts() != other.versionConflicts()) {
            return false;
        }
        if (!this.metadata().equals(other.metadata())) {
            return false;
        }
        return true;
    }
}
