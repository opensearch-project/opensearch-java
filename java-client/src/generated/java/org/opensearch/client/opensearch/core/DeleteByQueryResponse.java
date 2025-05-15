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

package org.opensearch.client.opensearch.core;

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
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: _global.delete_by_query.Response

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class DeleteByQueryResponse
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<DeleteByQueryResponse.Builder, DeleteByQueryResponse> {

    @Nullable
    private final Integer batches;

    @Nullable
    private final String canceled;

    @Nullable
    private final Long created;

    @Nullable
    private final Long deleted;

    @Nonnull
    private final List<BulkByScrollFailure> failures;

    @Nullable
    private final Long noops;

    @Nullable
    private final Float requestsPerSecond;

    @Nullable
    private final Retries retries;

    @Nullable
    private final Integer sliceId;

    @Nonnull
    private final List<BulkByScrollTaskStatusOrException> slices;

    @Nullable
    private final String task;

    @Nullable
    private final Time throttled;

    @Nullable
    private final Long throttledMillis;

    @Nullable
    private final Time throttledUntil;

    @Nullable
    private final Long throttledUntilMillis;

    @Nullable
    private final Boolean timedOut;

    @Nullable
    private final Long took;

    @Nullable
    private final Long total;

    @Nullable
    private final Long updated;

    @Nullable
    private final Long versionConflicts;

    // ---------------------------------------------------------------------------------------------

    private DeleteByQueryResponse(Builder builder) {
        this.batches = builder.batches;
        this.canceled = builder.canceled;
        this.created = builder.created;
        this.deleted = builder.deleted;
        this.failures = ApiTypeHelper.unmodifiable(builder.failures);
        this.noops = builder.noops;
        this.requestsPerSecond = builder.requestsPerSecond;
        this.retries = builder.retries;
        this.sliceId = builder.sliceId;
        this.slices = ApiTypeHelper.unmodifiable(builder.slices);
        this.task = builder.task;
        this.throttled = builder.throttled;
        this.throttledMillis = builder.throttledMillis;
        this.throttledUntil = builder.throttledUntil;
        this.throttledUntilMillis = builder.throttledUntilMillis;
        this.timedOut = builder.timedOut;
        this.took = builder.took;
        this.total = builder.total;
        this.updated = builder.updated;
        this.versionConflicts = builder.versionConflicts;
    }

    public static DeleteByQueryResponse of(Function<DeleteByQueryResponse.Builder, ObjectBuilder<DeleteByQueryResponse>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * The number of scroll responses pulled back by the reindex operation.
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
     * The list of failures that occurred during the operation.
     * <p>
     * API name: {@code failures}
     * </p>
     */
    @Nonnull
    public final List<BulkByScrollFailure> failures() {
        return this.failures;
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
     * The number of requests per second effectively executed during the reindex operation.
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
    @Nonnull
    public final List<BulkByScrollTaskStatusOrException> slices() {
        return this.slices;
    }

    /**
     * API name: {@code task}
     */
    @Nullable
    public final String task() {
        return this.task;
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
     * The amount time before the throttling will end.
     * <p>
     * API name: {@code throttled_until}
     * </p>
     */
    @Nullable
    public final Time throttledUntil() {
        return this.throttledUntil;
    }

    /**
     * When the throttling will end in milliseconds.
     * <p>
     * API name: {@code throttled_until_millis}
     * </p>
     */
    @Nullable
    public final Long throttledUntilMillis() {
        return this.throttledUntilMillis;
    }

    /**
     * Whether the operation timed out.
     * <p>
     * API name: {@code timed_out}
     * </p>
     */
    @Nullable
    public final Boolean timedOut() {
        return this.timedOut;
    }

    /**
     * The time taken by the operation in milliseconds.
     * <p>
     * API name: {@code took}
     * </p>
     */
    @Nullable
    public final Long took() {
        return this.took;
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
     * The number of version conflicts encountered by the reindex operation.
     * <p>
     * API name: {@code version_conflicts}
     * </p>
     */
    @Nullable
    public final Long versionConflicts() {
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

        if (ApiTypeHelper.isDefined(this.failures)) {
            generator.writeKey("failures");
            generator.writeStartArray();
            for (BulkByScrollFailure item0 : this.failures) {
                item0.serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (this.noops != null) {
            generator.writeKey("noops");
            generator.write(this.noops);
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

        if (this.task != null) {
            generator.writeKey("task");
            generator.write(this.task);
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

        if (this.timedOut != null) {
            generator.writeKey("timed_out");
            generator.write(this.timedOut);
        }

        if (this.took != null) {
            generator.writeKey("took");
            generator.write(this.took);
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
     * Builder for {@link DeleteByQueryResponse}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, DeleteByQueryResponse> {
        @Nullable
        private Integer batches;
        @Nullable
        private String canceled;
        @Nullable
        private Long created;
        @Nullable
        private Long deleted;
        @Nullable
        private List<BulkByScrollFailure> failures;
        @Nullable
        private Long noops;
        @Nullable
        private Float requestsPerSecond;
        @Nullable
        private Retries retries;
        @Nullable
        private Integer sliceId;
        @Nullable
        private List<BulkByScrollTaskStatusOrException> slices;
        @Nullable
        private String task;
        @Nullable
        private Time throttled;
        @Nullable
        private Long throttledMillis;
        @Nullable
        private Time throttledUntil;
        @Nullable
        private Long throttledUntilMillis;
        @Nullable
        private Boolean timedOut;
        @Nullable
        private Long took;
        @Nullable
        private Long total;
        @Nullable
        private Long updated;
        @Nullable
        private Long versionConflicts;

        public Builder() {}

        private Builder(DeleteByQueryResponse o) {
            this.batches = o.batches;
            this.canceled = o.canceled;
            this.created = o.created;
            this.deleted = o.deleted;
            this.failures = _listCopy(o.failures);
            this.noops = o.noops;
            this.requestsPerSecond = o.requestsPerSecond;
            this.retries = o.retries;
            this.sliceId = o.sliceId;
            this.slices = _listCopy(o.slices);
            this.task = o.task;
            this.throttled = o.throttled;
            this.throttledMillis = o.throttledMillis;
            this.throttledUntil = o.throttledUntil;
            this.throttledUntilMillis = o.throttledUntilMillis;
            this.timedOut = o.timedOut;
            this.took = o.took;
            this.total = o.total;
            this.updated = o.updated;
            this.versionConflicts = o.versionConflicts;
        }

        private Builder(Builder o) {
            this.batches = o.batches;
            this.canceled = o.canceled;
            this.created = o.created;
            this.deleted = o.deleted;
            this.failures = _listCopy(o.failures);
            this.noops = o.noops;
            this.requestsPerSecond = o.requestsPerSecond;
            this.retries = o.retries;
            this.sliceId = o.sliceId;
            this.slices = _listCopy(o.slices);
            this.task = o.task;
            this.throttled = o.throttled;
            this.throttledMillis = o.throttledMillis;
            this.throttledUntil = o.throttledUntil;
            this.throttledUntilMillis = o.throttledUntilMillis;
            this.timedOut = o.timedOut;
            this.took = o.took;
            this.total = o.total;
            this.updated = o.updated;
            this.versionConflicts = o.versionConflicts;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * The number of scroll responses pulled back by the reindex operation.
         * <p>
         * API name: {@code batches}
         * </p>
         */
        @Nonnull
        public final Builder batches(@Nullable Integer value) {
            this.batches = value;
            return this;
        }

        /**
         * API name: {@code canceled}
         */
        @Nonnull
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
        @Nonnull
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
        @Nonnull
        public final Builder deleted(@Nullable Long value) {
            this.deleted = value;
            return this;
        }

        /**
         * The list of failures that occurred during the operation.
         * <p>
         * API name: {@code failures}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>failures</code>.
         * </p>
         */
        @Nonnull
        public final Builder failures(List<BulkByScrollFailure> list) {
            this.failures = _listAddAll(this.failures, list);
            return this;
        }

        /**
         * The list of failures that occurred during the operation.
         * <p>
         * API name: {@code failures}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>failures</code>.
         * </p>
         */
        @Nonnull
        public final Builder failures(BulkByScrollFailure value, BulkByScrollFailure... values) {
            this.failures = _listAdd(this.failures, value, values);
            return this;
        }

        /**
         * The list of failures that occurred during the operation.
         * <p>
         * API name: {@code failures}
         * </p>
         *
         * <p>
         * Adds a value to <code>failures</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder failures(Function<BulkByScrollFailure.Builder, ObjectBuilder<BulkByScrollFailure>> fn) {
            return failures(fn.apply(new BulkByScrollFailure.Builder()).build());
        }

        /**
         * The number of documents that were ignored.
         * <p>
         * API name: {@code noops}
         * </p>
         */
        @Nonnull
        public final Builder noops(@Nullable Long value) {
            this.noops = value;
            return this;
        }

        /**
         * The number of requests per second effectively executed during the reindex operation.
         * <p>
         * API name: {@code requests_per_second}
         * </p>
         */
        @Nonnull
        public final Builder requestsPerSecond(@Nullable Float value) {
            this.requestsPerSecond = value;
            return this;
        }

        /**
         * API name: {@code retries}
         */
        @Nonnull
        public final Builder retries(@Nullable Retries value) {
            this.retries = value;
            return this;
        }

        /**
         * API name: {@code retries}
         */
        @Nonnull
        public final Builder retries(Function<Retries.Builder, ObjectBuilder<Retries>> fn) {
            return retries(fn.apply(new Retries.Builder()).build());
        }

        /**
         * API name: {@code slice_id}
         */
        @Nonnull
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
        @Nonnull
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
        @Nonnull
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
        @Nonnull
        public final Builder slices(
            Function<BulkByScrollTaskStatusOrException.Builder, ObjectBuilder<BulkByScrollTaskStatusOrException>> fn
        ) {
            return slices(fn.apply(new BulkByScrollTaskStatusOrException.Builder()).build());
        }

        /**
         * API name: {@code task}
         */
        @Nonnull
        public final Builder task(@Nullable String value) {
            this.task = value;
            return this;
        }

        /**
         * API name: {@code throttled}
         */
        @Nonnull
        public final Builder throttled(@Nullable Time value) {
            this.throttled = value;
            return this;
        }

        /**
         * API name: {@code throttled}
         */
        @Nonnull
        public final Builder throttled(Function<Time.Builder, ObjectBuilder<Time>> fn) {
            return throttled(fn.apply(new Time.Builder()).build());
        }

        /**
         * API name: {@code throttled_millis}
         */
        @Nonnull
        public final Builder throttledMillis(@Nullable Long value) {
            this.throttledMillis = value;
            return this;
        }

        /**
         * The amount time before the throttling will end.
         * <p>
         * API name: {@code throttled_until}
         * </p>
         */
        @Nonnull
        public final Builder throttledUntil(@Nullable Time value) {
            this.throttledUntil = value;
            return this;
        }

        /**
         * The amount time before the throttling will end.
         * <p>
         * API name: {@code throttled_until}
         * </p>
         */
        @Nonnull
        public final Builder throttledUntil(Function<Time.Builder, ObjectBuilder<Time>> fn) {
            return throttledUntil(fn.apply(new Time.Builder()).build());
        }

        /**
         * When the throttling will end in milliseconds.
         * <p>
         * API name: {@code throttled_until_millis}
         * </p>
         */
        @Nonnull
        public final Builder throttledUntilMillis(@Nullable Long value) {
            this.throttledUntilMillis = value;
            return this;
        }

        /**
         * Whether the operation timed out.
         * <p>
         * API name: {@code timed_out}
         * </p>
         */
        @Nonnull
        public final Builder timedOut(@Nullable Boolean value) {
            this.timedOut = value;
            return this;
        }

        /**
         * The time taken by the operation in milliseconds.
         * <p>
         * API name: {@code took}
         * </p>
         */
        @Nonnull
        public final Builder took(@Nullable Long value) {
            this.took = value;
            return this;
        }

        /**
         * The number of documents that were successfully processed.
         * <p>
         * API name: {@code total}
         * </p>
         */
        @Nonnull
        public final Builder total(@Nullable Long value) {
            this.total = value;
            return this;
        }

        /**
         * The number of documents that were successfully updated after the reindex operation.
         * <p>
         * API name: {@code updated}
         * </p>
         */
        @Nonnull
        public final Builder updated(@Nullable Long value) {
            this.updated = value;
            return this;
        }

        /**
         * The number of version conflicts encountered by the reindex operation.
         * <p>
         * API name: {@code version_conflicts}
         * </p>
         */
        @Nonnull
        public final Builder versionConflicts(@Nullable Long value) {
            this.versionConflicts = value;
            return this;
        }

        /**
         * Builds a {@link DeleteByQueryResponse}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public DeleteByQueryResponse build() {
            _checkSingleUse();

            return new DeleteByQueryResponse(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link DeleteByQueryResponse}
     */
    public static final JsonpDeserializer<DeleteByQueryResponse> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        DeleteByQueryResponse::setupDeleteByQueryResponseDeserializer
    );

    protected static void setupDeleteByQueryResponseDeserializer(ObjectDeserializer<DeleteByQueryResponse.Builder> op) {
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
        op.add(Builder::task, JsonpDeserializer.stringDeserializer(), "task");
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
        result = 31 * result + Objects.hashCode(this.batches);
        result = 31 * result + Objects.hashCode(this.canceled);
        result = 31 * result + Objects.hashCode(this.created);
        result = 31 * result + Objects.hashCode(this.deleted);
        result = 31 * result + Objects.hashCode(this.failures);
        result = 31 * result + Objects.hashCode(this.noops);
        result = 31 * result + Objects.hashCode(this.requestsPerSecond);
        result = 31 * result + Objects.hashCode(this.retries);
        result = 31 * result + Objects.hashCode(this.sliceId);
        result = 31 * result + Objects.hashCode(this.slices);
        result = 31 * result + Objects.hashCode(this.task);
        result = 31 * result + Objects.hashCode(this.throttled);
        result = 31 * result + Objects.hashCode(this.throttledMillis);
        result = 31 * result + Objects.hashCode(this.throttledUntil);
        result = 31 * result + Objects.hashCode(this.throttledUntilMillis);
        result = 31 * result + Objects.hashCode(this.timedOut);
        result = 31 * result + Objects.hashCode(this.took);
        result = 31 * result + Objects.hashCode(this.total);
        result = 31 * result + Objects.hashCode(this.updated);
        result = 31 * result + Objects.hashCode(this.versionConflicts);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        DeleteByQueryResponse other = (DeleteByQueryResponse) o;
        return Objects.equals(this.batches, other.batches)
            && Objects.equals(this.canceled, other.canceled)
            && Objects.equals(this.created, other.created)
            && Objects.equals(this.deleted, other.deleted)
            && Objects.equals(this.failures, other.failures)
            && Objects.equals(this.noops, other.noops)
            && Objects.equals(this.requestsPerSecond, other.requestsPerSecond)
            && Objects.equals(this.retries, other.retries)
            && Objects.equals(this.sliceId, other.sliceId)
            && Objects.equals(this.slices, other.slices)
            && Objects.equals(this.task, other.task)
            && Objects.equals(this.throttled, other.throttled)
            && Objects.equals(this.throttledMillis, other.throttledMillis)
            && Objects.equals(this.throttledUntil, other.throttledUntil)
            && Objects.equals(this.throttledUntilMillis, other.throttledUntilMillis)
            && Objects.equals(this.timedOut, other.timedOut)
            && Objects.equals(this.took, other.took)
            && Objects.equals(this.total, other.total)
            && Objects.equals(this.updated, other.updated)
            && Objects.equals(this.versionConflicts, other.versionConflicts);
    }
}
