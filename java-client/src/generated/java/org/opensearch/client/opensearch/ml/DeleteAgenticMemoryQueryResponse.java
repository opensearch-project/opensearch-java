/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

//----------------------------------------------------
// THIS CODE IS GENERATED. MANUAL EDITS WILL BE LOST.
//----------------------------------------------------

package org.opensearch.client.opensearch.ml;

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
import org.opensearch.client.opensearch._types.Retries;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: ml.delete_agentic_memory_query.Response

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class DeleteAgenticMemoryQueryResponse
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<DeleteAgenticMemoryQueryResponse.Builder, DeleteAgenticMemoryQueryResponse> {

    @Nullable
    private final Long batches;

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
    private final String result;

    @Nullable
    private final Retries retries;

    @Nullable
    private final Long throttledMillis;

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

    private DeleteAgenticMemoryQueryResponse(Builder builder) {
        this.batches = builder.batches;
        this.created = builder.created;
        this.deleted = builder.deleted;
        this.failures = ApiTypeHelper.unmodifiable(builder.failures);
        this.noops = builder.noops;
        this.requestsPerSecond = builder.requestsPerSecond;
        this.result = builder.result;
        this.retries = builder.retries;
        this.throttledMillis = builder.throttledMillis;
        this.throttledUntilMillis = builder.throttledUntilMillis;
        this.timedOut = builder.timedOut;
        this.took = builder.took;
        this.total = builder.total;
        this.updated = builder.updated;
        this.versionConflicts = builder.versionConflicts;
    }

    public static DeleteAgenticMemoryQueryResponse of(
        Function<DeleteAgenticMemoryQueryResponse.Builder, ObjectBuilder<DeleteAgenticMemoryQueryResponse>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Number of batches processed.
     * <p>
     * API name: {@code batches}
     * </p>
     */
    @Nullable
    public final Long batches() {
        return this.batches;
    }

    /**
     * Number of documents created.
     * <p>
     * API name: {@code created}
     * </p>
     */
    @Nullable
    public final Long created() {
        return this.created;
    }

    /**
     * Number of documents deleted.
     * <p>
     * API name: {@code deleted}
     * </p>
     */
    @Nullable
    public final Long deleted() {
        return this.deleted;
    }

    /**
     * Any failures occurred during the operation.
     * <p>
     * API name: {@code failures}
     * </p>
     */
    @Nonnull
    public final List<BulkByScrollFailure> failures() {
        return this.failures;
    }

    /**
     * Number of no-operation updates.
     * <p>
     * API name: {@code noops}
     * </p>
     */
    @Nullable
    public final Long noops() {
        return this.noops;
    }

    /**
     * Number of requests processed per second.
     * <p>
     * API name: {@code requests_per_second}
     * </p>
     */
    @Nullable
    public final Float requestsPerSecond() {
        return this.requestsPerSecond;
    }

    /**
     * The result of delete operation.
     * <p>
     * API name: {@code result}
     * </p>
     */
    @Nullable
    public final String result() {
        return this.result;
    }

    /**
     * API name: {@code retries}
     */
    @Nullable
    public final Retries retries() {
        return this.retries;
    }

    /**
     * Time that the request was throttled.
     * <p>
     * API name: {@code throttled_millis}
     * </p>
     */
    @Nullable
    public final Long throttledMillis() {
        return this.throttledMillis;
    }

    /**
     * Time until throttling is lifted.
     * <p>
     * API name: {@code throttled_until_millis}
     * </p>
     */
    @Nullable
    public final Long throttledUntilMillis() {
        return this.throttledUntilMillis;
    }

    /**
     * Whether the request timed out.
     * <p>
     * API name: {@code timed_out}
     * </p>
     */
    @Nullable
    public final Boolean timedOut() {
        return this.timedOut;
    }

    /**
     * Time taken to execute the request.
     * <p>
     * API name: {@code took}
     * </p>
     */
    @Nullable
    public final Long took() {
        return this.took;
    }

    /**
     * Total number of documents processed.
     * <p>
     * API name: {@code total}
     * </p>
     */
    @Nullable
    public final Long total() {
        return this.total;
    }

    /**
     * Number of documents updated.
     * <p>
     * API name: {@code updated}
     * </p>
     */
    @Nullable
    public final Long updated() {
        return this.updated;
    }

    /**
     * Number of version conflicts encountered.
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

        if (this.result != null) {
            generator.writeKey("result");
            generator.write(this.result);
        }

        if (this.retries != null) {
            generator.writeKey("retries");
            this.retries.serialize(generator, mapper);
        }

        if (this.throttledMillis != null) {
            generator.writeKey("throttled_millis");
            generator.write(this.throttledMillis);
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
     * Builder for {@link DeleteAgenticMemoryQueryResponse}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, DeleteAgenticMemoryQueryResponse> {
        @Nullable
        private Long batches;
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
        private String result;
        @Nullable
        private Retries retries;
        @Nullable
        private Long throttledMillis;
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

        private Builder(DeleteAgenticMemoryQueryResponse o) {
            this.batches = o.batches;
            this.created = o.created;
            this.deleted = o.deleted;
            this.failures = _listCopy(o.failures);
            this.noops = o.noops;
            this.requestsPerSecond = o.requestsPerSecond;
            this.result = o.result;
            this.retries = o.retries;
            this.throttledMillis = o.throttledMillis;
            this.throttledUntilMillis = o.throttledUntilMillis;
            this.timedOut = o.timedOut;
            this.took = o.took;
            this.total = o.total;
            this.updated = o.updated;
            this.versionConflicts = o.versionConflicts;
        }

        private Builder(Builder o) {
            this.batches = o.batches;
            this.created = o.created;
            this.deleted = o.deleted;
            this.failures = _listCopy(o.failures);
            this.noops = o.noops;
            this.requestsPerSecond = o.requestsPerSecond;
            this.result = o.result;
            this.retries = o.retries;
            this.throttledMillis = o.throttledMillis;
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
         * Number of batches processed.
         * <p>
         * API name: {@code batches}
         * </p>
         */
        @Nonnull
        public final Builder batches(@Nullable Long value) {
            this.batches = value;
            return this;
        }

        /**
         * Number of documents created.
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
         * Number of documents deleted.
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
         * Any failures occurred during the operation.
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
         * Any failures occurred during the operation.
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
         * Any failures occurred during the operation.
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
         * Number of no-operation updates.
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
         * Number of requests processed per second.
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
         * The result of delete operation.
         * <p>
         * API name: {@code result}
         * </p>
         */
        @Nonnull
        public final Builder result(@Nullable String value) {
            this.result = value;
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
         * Time that the request was throttled.
         * <p>
         * API name: {@code throttled_millis}
         * </p>
         */
        @Nonnull
        public final Builder throttledMillis(@Nullable Long value) {
            this.throttledMillis = value;
            return this;
        }

        /**
         * Time until throttling is lifted.
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
         * Whether the request timed out.
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
         * Time taken to execute the request.
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
         * Total number of documents processed.
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
         * Number of documents updated.
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
         * Number of version conflicts encountered.
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
         * Builds a {@link DeleteAgenticMemoryQueryResponse}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public DeleteAgenticMemoryQueryResponse build() {
            _checkSingleUse();

            return new DeleteAgenticMemoryQueryResponse(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link DeleteAgenticMemoryQueryResponse}
     */
    public static final JsonpDeserializer<DeleteAgenticMemoryQueryResponse> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        DeleteAgenticMemoryQueryResponse::setupDeleteAgenticMemoryQueryResponseDeserializer
    );

    protected static void setupDeleteAgenticMemoryQueryResponseDeserializer(
        ObjectDeserializer<DeleteAgenticMemoryQueryResponse.Builder> op
    ) {
        op.add(Builder::batches, JsonpDeserializer.longDeserializer(), "batches");
        op.add(Builder::created, JsonpDeserializer.longDeserializer(), "created");
        op.add(Builder::deleted, JsonpDeserializer.longDeserializer(), "deleted");
        op.add(Builder::failures, JsonpDeserializer.arrayDeserializer(BulkByScrollFailure._DESERIALIZER), "failures");
        op.add(Builder::noops, JsonpDeserializer.longDeserializer(), "noops");
        op.add(Builder::requestsPerSecond, JsonpDeserializer.floatDeserializer(), "requests_per_second");
        op.add(Builder::result, JsonpDeserializer.stringDeserializer(), "result");
        op.add(Builder::retries, Retries._DESERIALIZER, "retries");
        op.add(Builder::throttledMillis, JsonpDeserializer.longDeserializer(), "throttled_millis");
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
        result = 31 * result + Objects.hashCode(this.created);
        result = 31 * result + Objects.hashCode(this.deleted);
        result = 31 * result + Objects.hashCode(this.failures);
        result = 31 * result + Objects.hashCode(this.noops);
        result = 31 * result + Objects.hashCode(this.requestsPerSecond);
        result = 31 * result + Objects.hashCode(this.result);
        result = 31 * result + Objects.hashCode(this.retries);
        result = 31 * result + Objects.hashCode(this.throttledMillis);
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
        DeleteAgenticMemoryQueryResponse other = (DeleteAgenticMemoryQueryResponse) o;
        return Objects.equals(this.batches, other.batches)
            && Objects.equals(this.created, other.created)
            && Objects.equals(this.deleted, other.deleted)
            && Objects.equals(this.failures, other.failures)
            && Objects.equals(this.noops, other.noops)
            && Objects.equals(this.requestsPerSecond, other.requestsPerSecond)
            && Objects.equals(this.result, other.result)
            && Objects.equals(this.retries, other.retries)
            && Objects.equals(this.throttledMillis, other.throttledMillis)
            && Objects.equals(this.throttledUntilMillis, other.throttledUntilMillis)
            && Objects.equals(this.timedOut, other.timedOut)
            && Objects.equals(this.took, other.took)
            && Objects.equals(this.total, other.total)
            && Objects.equals(this.updated, other.updated)
            && Objects.equals(this.versionConflicts, other.versionConflicts);
    }
}
