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
import java.util.List;
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
import org.opensearch.client.opensearch._types.BulkByScrollFailure;
import org.opensearch.client.opensearch._types.BulkByScrollTaskStatusOrException;
import org.opensearch.client.opensearch._types.Retries;
import org.opensearch.client.opensearch._types.Time;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;

// typedef: tasks.TaskResponse

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class TaskResponse implements PlainJsonSerializable {

    private final int batches;

    @Nullable
    private final String canceled;

    @Nullable
    private final Long created;

    private final long deleted;

    @Nonnull
    private final List<BulkByScrollFailure> failures;

    private final long noops;

    private final float requestsPerSecond;

    @Nonnull
    private final Retries retries;

    @Nullable
    private final Integer sliceId;

    @Nonnull
    private final List<BulkByScrollTaskStatusOrException> slices;

    @Nullable
    private final Time throttled;

    private final long throttledMillis;

    @Nullable
    private final Time throttledUntil;

    private final long throttledUntilMillis;

    private final boolean timedOut;

    private final long took;

    private final long total;

    @Nullable
    private final Long updated;

    private final long versionConflicts;

    // ---------------------------------------------------------------------------------------------

    private TaskResponse(Builder builder) {
        this.batches = ApiTypeHelper.requireNonNull(builder.batches, this, "batches");
        this.canceled = builder.canceled;
        this.created = builder.created;
        this.deleted = ApiTypeHelper.requireNonNull(builder.deleted, this, "deleted");
        this.failures = ApiTypeHelper.unmodifiableRequired(builder.failures, this, "failures");
        this.noops = ApiTypeHelper.requireNonNull(builder.noops, this, "noops");
        this.requestsPerSecond = ApiTypeHelper.requireNonNull(builder.requestsPerSecond, this, "requestsPerSecond");
        this.retries = ApiTypeHelper.requireNonNull(builder.retries, this, "retries");
        this.sliceId = builder.sliceId;
        this.slices = ApiTypeHelper.unmodifiable(builder.slices);
        this.throttled = builder.throttled;
        this.throttledMillis = ApiTypeHelper.requireNonNull(builder.throttledMillis, this, "throttledMillis");
        this.throttledUntil = builder.throttledUntil;
        this.throttledUntilMillis = ApiTypeHelper.requireNonNull(builder.throttledUntilMillis, this, "throttledUntilMillis");
        this.timedOut = ApiTypeHelper.requireNonNull(builder.timedOut, this, "timedOut");
        this.took = ApiTypeHelper.requireNonNull(builder.took, this, "took");
        this.total = ApiTypeHelper.requireNonNull(builder.total, this, "total");
        this.updated = builder.updated;
        this.versionConflicts = ApiTypeHelper.requireNonNull(builder.versionConflicts, this, "versionConflicts");
    }

    public static TaskResponse of(Function<TaskResponse.Builder, ObjectBuilder<TaskResponse>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - The number of scroll responses pulled back by the reindex operation.
     * <p>
     * API name: {@code batches}
     * </p>
     */
    public final int batches() {
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
     * Required - The number of documents that were successfully deleted.
     * <p>
     * API name: {@code deleted}
     * </p>
     */
    public final long deleted() {
        return this.deleted;
    }

    /**
     * Required - API name: {@code failures}
     */
    @Nonnull
    public final List<BulkByScrollFailure> failures() {
        return this.failures;
    }

    /**
     * Required - The number of documents that were ignored.
     * <p>
     * API name: {@code noops}
     * </p>
     */
    public final long noops() {
        return this.noops;
    }

    /**
     * Required - The number of requests per second effectively executed during the reindex operation.
     * <p>
     * API name: {@code requests_per_second}
     * </p>
     */
    public final float requestsPerSecond() {
        return this.requestsPerSecond;
    }

    /**
     * Required - API name: {@code retries}
     */
    @Nonnull
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
    @Nonnull
    public final List<BulkByScrollTaskStatusOrException> slices() {
        return this.slices;
    }

    /**
     * API name: {@code throttled}
     */
    @Nullable
    public final Time throttled() {
        return this.throttled;
    }

    /**
     * Required - API name: {@code throttled_millis}
     */
    public final long throttledMillis() {
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
     * Required - API name: {@code throttled_until_millis}
     */
    public final long throttledUntilMillis() {
        return this.throttledUntilMillis;
    }

    /**
     * Required - API name: {@code timed_out}
     */
    public final boolean timedOut() {
        return this.timedOut;
    }

    /**
     * Required - API name: {@code took}
     */
    public final long took() {
        return this.took;
    }

    /**
     * Required - The number of documents that were successfully processed.
     * <p>
     * API name: {@code total}
     * </p>
     */
    public final long total() {
        return this.total;
    }

    /**
     * The number of documents that were successfully updated after the reindex operation.
     * <p>
     * API name: {@code updated}
     * </p>
     */
    @Nullable
    public final Long updated() {
        return this.updated;
    }

    /**
     * Required - The number of version conflicts encountered by the reindex operation.
     * <p>
     * API name: {@code version_conflicts}
     * </p>
     */
    public final long versionConflicts() {
        return this.versionConflicts;
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
        generator.writeKey("batches");
        generator.write(this.batches);

        if (this.canceled != null) {
            generator.writeKey("canceled");
            generator.write(this.canceled);
        }

        if (this.created != null) {
            generator.writeKey("created");
            generator.write(this.created);
        }

        generator.writeKey("deleted");
        generator.write(this.deleted);

        generator.writeKey("failures");
        generator.writeStartArray();
        for (BulkByScrollFailure item0 : this.failures) {
            item0.serialize(generator, mapper);
        }
        generator.writeEnd();

        generator.writeKey("noops");
        generator.write(this.noops);

        generator.writeKey("requests_per_second");
        generator.write(this.requestsPerSecond);

        generator.writeKey("retries");
        this.retries.serialize(generator, mapper);

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

        if (this.throttled != null) {
            generator.writeKey("throttled");
            this.throttled.serialize(generator, mapper);
        }

        generator.writeKey("throttled_millis");
        generator.write(this.throttledMillis);

        if (this.throttledUntil != null) {
            generator.writeKey("throttled_until");
            this.throttledUntil.serialize(generator, mapper);
        }

        generator.writeKey("throttled_until_millis");
        generator.write(this.throttledUntilMillis);

        generator.writeKey("timed_out");
        generator.write(this.timedOut);

        generator.writeKey("took");
        generator.write(this.took);

        generator.writeKey("total");
        generator.write(this.total);

        if (this.updated != null) {
            generator.writeKey("updated");
            generator.write(this.updated);
        }

        generator.writeKey("version_conflicts");
        generator.write(this.versionConflicts);
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Builder for {@link TaskResponse}.
     */
    public static class Builder extends ObjectBuilderBase implements ObjectBuilder<TaskResponse> {
        private Integer batches;
        @Nullable
        private String canceled;
        @Nullable
        private Long created;
        private Long deleted;
        private List<BulkByScrollFailure> failures;
        private Long noops;
        private Float requestsPerSecond;
        private Retries retries;
        @Nullable
        private Integer sliceId;
        @Nullable
        private List<BulkByScrollTaskStatusOrException> slices;
        @Nullable
        private Time throttled;
        private Long throttledMillis;
        @Nullable
        private Time throttledUntil;
        private Long throttledUntilMillis;
        private Boolean timedOut;
        private Long took;
        private Long total;
        @Nullable
        private Long updated;
        private Long versionConflicts;

        /**
         * Required - The number of scroll responses pulled back by the reindex operation.
         * <p>
         * API name: {@code batches}
         * </p>
         */
        public final Builder batches(int value) {
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
         * Required - The number of documents that were successfully deleted.
         * <p>
         * API name: {@code deleted}
         * </p>
         */
        public final Builder deleted(long value) {
            this.deleted = value;
            return this;
        }

        /**
         * Required - API name: {@code failures}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>failures</code>.
         * </p>
         */
        public final Builder failures(List<BulkByScrollFailure> list) {
            this.failures = _listAddAll(this.failures, list);
            return this;
        }

        /**
         * Required - API name: {@code failures}
         *
         * <p>
         * Adds one or more values to <code>failures</code>.
         * </p>
         */
        public final Builder failures(BulkByScrollFailure value, BulkByScrollFailure... values) {
            this.failures = _listAdd(this.failures, value, values);
            return this;
        }

        /**
         * Required - API name: {@code failures}
         *
         * <p>
         * Adds a value to <code>failures</code> using a builder lambda.
         * </p>
         */
        public final Builder failures(Function<BulkByScrollFailure.Builder, ObjectBuilder<BulkByScrollFailure>> fn) {
            return failures(fn.apply(new BulkByScrollFailure.Builder()).build());
        }

        /**
         * Required - The number of documents that were ignored.
         * <p>
         * API name: {@code noops}
         * </p>
         */
        public final Builder noops(long value) {
            this.noops = value;
            return this;
        }

        /**
         * Required - The number of requests per second effectively executed during the reindex operation.
         * <p>
         * API name: {@code requests_per_second}
         * </p>
         */
        public final Builder requestsPerSecond(float value) {
            this.requestsPerSecond = value;
            return this;
        }

        /**
         * Required - API name: {@code retries}
         */
        public final Builder retries(Retries value) {
            this.retries = value;
            return this;
        }

        /**
         * Required - API name: {@code retries}
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
         * Required - API name: {@code throttled_millis}
         */
        public final Builder throttledMillis(long value) {
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
         * Required - API name: {@code throttled_until_millis}
         */
        public final Builder throttledUntilMillis(long value) {
            this.throttledUntilMillis = value;
            return this;
        }

        /**
         * Required - API name: {@code timed_out}
         */
        public final Builder timedOut(boolean value) {
            this.timedOut = value;
            return this;
        }

        /**
         * Required - API name: {@code took}
         */
        public final Builder took(long value) {
            this.took = value;
            return this;
        }

        /**
         * Required - The number of documents that were successfully processed.
         * <p>
         * API name: {@code total}
         * </p>
         */
        public final Builder total(long value) {
            this.total = value;
            return this;
        }

        /**
         * The number of documents that were successfully updated after the reindex operation.
         * <p>
         * API name: {@code updated}
         * </p>
         */
        public final Builder updated(@Nullable Long value) {
            this.updated = value;
            return this;
        }

        /**
         * Required - The number of version conflicts encountered by the reindex operation.
         * <p>
         * API name: {@code version_conflicts}
         * </p>
         */
        public final Builder versionConflicts(long value) {
            this.versionConflicts = value;
            return this;
        }

        /**
         * Builds a {@link TaskResponse}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        public TaskResponse build() {
            _checkSingleUse();

            return new TaskResponse(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link TaskResponse}
     */
    public static final JsonpDeserializer<TaskResponse> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        TaskResponse::setupTaskResponseDeserializer
    );

    protected static void setupTaskResponseDeserializer(ObjectDeserializer<TaskResponse.Builder> op) {
        op.add(Builder::batches, JsonpDeserializer.integerDeserializer(), "batches");
        op.add(Builder::canceled, JsonpDeserializer.stringDeserializer(), "canceled");
        op.add(Builder::created, JsonpDeserializer.longDeserializer(), "created");
        op.add(Builder::deleted, JsonpDeserializer.longDeserializer(), "deleted");
        op.add(Builder::failures, JsonpDeserializer.arrayDeserializer(BulkByScrollFailure._DESERIALIZER), "failures");
        op.add(Builder::noops, JsonpDeserializer.longDeserializer(), "noops");
        op.add(Builder::requestsPerSecond, JsonpDeserializer.floatDeserializer(), "requests_per_second");
        op.add(Builder::retries, Retries._DESERIALIZER, "retries");
        op.add(Builder::sliceId, JsonpDeserializer.integerDeserializer(), "slice_id");
        op.add(Builder::slices, JsonpDeserializer.arrayDeserializer(BulkByScrollTaskStatusOrException._DESERIALIZER), "slices");
        op.add(Builder::throttled, Time._DESERIALIZER, "throttled");
        op.add(Builder::throttledMillis, JsonpDeserializer.longDeserializer(), "throttled_millis");
        op.add(Builder::throttledUntil, Time._DESERIALIZER, "throttled_until");
        op.add(Builder::throttledUntilMillis, JsonpDeserializer.longDeserializer(), "throttled_until_millis");
        op.add(Builder::timedOut, JsonpDeserializer.booleanDeserializer(), "timed_out");
        op.add(Builder::took, JsonpDeserializer.longDeserializer(), "took");
        op.add(Builder::total, JsonpDeserializer.longDeserializer(), "total");
        op.add(Builder::updated, JsonpDeserializer.longDeserializer(), "updated");
        op.add(Builder::versionConflicts, JsonpDeserializer.longDeserializer(), "version_conflicts");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Integer.hashCode(this.batches);
        result = 31 * result + Objects.hashCode(this.canceled);
        result = 31 * result + Objects.hashCode(this.created);
        result = 31 * result + Long.hashCode(this.deleted);
        result = 31 * result + this.failures.hashCode();
        result = 31 * result + Long.hashCode(this.noops);
        result = 31 * result + Float.hashCode(this.requestsPerSecond);
        result = 31 * result + this.retries.hashCode();
        result = 31 * result + Objects.hashCode(this.sliceId);
        result = 31 * result + Objects.hashCode(this.slices);
        result = 31 * result + Objects.hashCode(this.throttled);
        result = 31 * result + Long.hashCode(this.throttledMillis);
        result = 31 * result + Objects.hashCode(this.throttledUntil);
        result = 31 * result + Long.hashCode(this.throttledUntilMillis);
        result = 31 * result + Boolean.hashCode(this.timedOut);
        result = 31 * result + Long.hashCode(this.took);
        result = 31 * result + Long.hashCode(this.total);
        result = 31 * result + Objects.hashCode(this.updated);
        result = 31 * result + Long.hashCode(this.versionConflicts);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        TaskResponse other = (TaskResponse) o;
        return this.batches == other.batches
            && Objects.equals(this.canceled, other.canceled)
            && Objects.equals(this.created, other.created)
            && this.deleted == other.deleted
            && this.failures.equals(other.failures)
            && this.noops == other.noops
            && this.requestsPerSecond == other.requestsPerSecond
            && this.retries.equals(other.retries)
            && Objects.equals(this.sliceId, other.sliceId)
            && Objects.equals(this.slices, other.slices)
            && Objects.equals(this.throttled, other.throttled)
            && this.throttledMillis == other.throttledMillis
            && Objects.equals(this.throttledUntil, other.throttledUntil)
            && this.throttledUntilMillis == other.throttledUntilMillis
            && this.timedOut == other.timedOut
            && this.took == other.took
            && this.total == other.total
            && Objects.equals(this.updated, other.updated)
            && this.versionConflicts == other.versionConflicts;
    }
}
