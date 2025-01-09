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
import org.opensearch.client.opensearch._types.Retries;
import org.opensearch.client.opensearch._types.Time;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: core.reindex_rethrottle.ReindexStatus

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class ReindexStatus implements PlainJsonSerializable, ToCopyableBuilder<ReindexStatus.Builder, ReindexStatus> {

    private final long batches;

    private final long created;

    private final long deleted;

    private final long noops;

    private final float requestsPerSecond;

    @Nonnull
    private final Retries retries;

    @Nullable
    private final Time throttled;

    private final long throttledMillis;

    @Nullable
    private final Time throttledUntil;

    private final long throttledUntilMillis;

    private final long total;

    private final long updated;

    private final long versionConflicts;

    // ---------------------------------------------------------------------------------------------

    private ReindexStatus(Builder builder) {
        this.batches = ApiTypeHelper.requireNonNull(builder.batches, this, "batches");
        this.created = ApiTypeHelper.requireNonNull(builder.created, this, "created");
        this.deleted = ApiTypeHelper.requireNonNull(builder.deleted, this, "deleted");
        this.noops = ApiTypeHelper.requireNonNull(builder.noops, this, "noops");
        this.requestsPerSecond = ApiTypeHelper.requireNonNull(builder.requestsPerSecond, this, "requestsPerSecond");
        this.retries = ApiTypeHelper.requireNonNull(builder.retries, this, "retries");
        this.throttled = builder.throttled;
        this.throttledMillis = ApiTypeHelper.requireNonNull(builder.throttledMillis, this, "throttledMillis");
        this.throttledUntil = builder.throttledUntil;
        this.throttledUntilMillis = ApiTypeHelper.requireNonNull(builder.throttledUntilMillis, this, "throttledUntilMillis");
        this.total = ApiTypeHelper.requireNonNull(builder.total, this, "total");
        this.updated = ApiTypeHelper.requireNonNull(builder.updated, this, "updated");
        this.versionConflicts = ApiTypeHelper.requireNonNull(builder.versionConflicts, this, "versionConflicts");
    }

    public static ReindexStatus of(Function<ReindexStatus.Builder, ObjectBuilder<ReindexStatus>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - The number of scroll responses shown by the reindex.
     * <p>
     * API name: {@code batches}
     * </p>
     */
    public final long batches() {
        return this.batches;
    }

    /**
     * Required - The number of documents that were successfully created.
     * <p>
     * API name: {@code created}
     * </p>
     */
    public final long created() {
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
     * Required - The number of documents that were ignored because the script used for the reindex operation returned a <code>noop</code>
     * value for <code>ctx.op</code>.
     * <p>
     * API name: {@code noops}
     * </p>
     */
    public final long noops() {
        return this.noops;
    }

    /**
     * Required - The number of successful requests per second during the reindex operation.
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
     * Required - The number of documents that were successfully processed.
     * <p>
     * API name: {@code total}
     * </p>
     */
    public final long total() {
        return this.total;
    }

    /**
     * Required - The number of documents that were successfully updated.
     * <p>
     * API name: {@code updated}
     * </p>
     */
    public final long updated() {
        return this.updated;
    }

    /**
     * Required - The number of version conflicts that reindex hits.
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

        generator.writeKey("created");
        generator.write(this.created);

        generator.writeKey("deleted");
        generator.write(this.deleted);

        generator.writeKey("noops");
        generator.write(this.noops);

        generator.writeKey("requests_per_second");
        generator.write(this.requestsPerSecond);

        generator.writeKey("retries");
        this.retries.serialize(generator, mapper);

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

        generator.writeKey("total");
        generator.write(this.total);

        generator.writeKey("updated");
        generator.write(this.updated);

        generator.writeKey("version_conflicts");
        generator.write(this.versionConflicts);
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
     * Builder for {@link ReindexStatus}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, ReindexStatus> {
        private Long batches;
        private Long created;
        private Long deleted;
        private Long noops;
        private Float requestsPerSecond;
        private Retries retries;
        @Nullable
        private Time throttled;
        private Long throttledMillis;
        @Nullable
        private Time throttledUntil;
        private Long throttledUntilMillis;
        private Long total;
        private Long updated;
        private Long versionConflicts;

        public Builder() {}

        private Builder(ReindexStatus o) {
            this.batches = o.batches;
            this.created = o.created;
            this.deleted = o.deleted;
            this.noops = o.noops;
            this.requestsPerSecond = o.requestsPerSecond;
            this.retries = o.retries;
            this.throttled = o.throttled;
            this.throttledMillis = o.throttledMillis;
            this.throttledUntil = o.throttledUntil;
            this.throttledUntilMillis = o.throttledUntilMillis;
            this.total = o.total;
            this.updated = o.updated;
            this.versionConflicts = o.versionConflicts;
        }

        private Builder(Builder o) {
            this.batches = o.batches;
            this.created = o.created;
            this.deleted = o.deleted;
            this.noops = o.noops;
            this.requestsPerSecond = o.requestsPerSecond;
            this.retries = o.retries;
            this.throttled = o.throttled;
            this.throttledMillis = o.throttledMillis;
            this.throttledUntil = o.throttledUntil;
            this.throttledUntilMillis = o.throttledUntilMillis;
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
         * Required - The number of scroll responses shown by the reindex.
         * <p>
         * API name: {@code batches}
         * </p>
         */
        @Nonnull
        public final Builder batches(long value) {
            this.batches = value;
            return this;
        }

        /**
         * Required - The number of documents that were successfully created.
         * <p>
         * API name: {@code created}
         * </p>
         */
        @Nonnull
        public final Builder created(long value) {
            this.created = value;
            return this;
        }

        /**
         * Required - The number of documents that were successfully deleted.
         * <p>
         * API name: {@code deleted}
         * </p>
         */
        @Nonnull
        public final Builder deleted(long value) {
            this.deleted = value;
            return this;
        }

        /**
         * Required - The number of documents that were ignored because the script used for the reindex operation returned a
         * <code>noop</code> value for <code>ctx.op</code>.
         * <p>
         * API name: {@code noops}
         * </p>
         */
        @Nonnull
        public final Builder noops(long value) {
            this.noops = value;
            return this;
        }

        /**
         * Required - The number of successful requests per second during the reindex operation.
         * <p>
         * API name: {@code requests_per_second}
         * </p>
         */
        @Nonnull
        public final Builder requestsPerSecond(float value) {
            this.requestsPerSecond = value;
            return this;
        }

        /**
         * Required - API name: {@code retries}
         */
        @Nonnull
        public final Builder retries(Retries value) {
            this.retries = value;
            return this;
        }

        /**
         * Required - API name: {@code retries}
         */
        @Nonnull
        public final Builder retries(Function<Retries.Builder, ObjectBuilder<Retries>> fn) {
            return retries(fn.apply(new Retries.Builder()).build());
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
         * Required - API name: {@code throttled_millis}
         */
        @Nonnull
        public final Builder throttledMillis(long value) {
            this.throttledMillis = value;
            return this;
        }

        /**
         * API name: {@code throttled_until}
         */
        @Nonnull
        public final Builder throttledUntil(@Nullable Time value) {
            this.throttledUntil = value;
            return this;
        }

        /**
         * API name: {@code throttled_until}
         */
        @Nonnull
        public final Builder throttledUntil(Function<Time.Builder, ObjectBuilder<Time>> fn) {
            return throttledUntil(fn.apply(new Time.Builder()).build());
        }

        /**
         * Required - API name: {@code throttled_until_millis}
         */
        @Nonnull
        public final Builder throttledUntilMillis(long value) {
            this.throttledUntilMillis = value;
            return this;
        }

        /**
         * Required - The number of documents that were successfully processed.
         * <p>
         * API name: {@code total}
         * </p>
         */
        @Nonnull
        public final Builder total(long value) {
            this.total = value;
            return this;
        }

        /**
         * Required - The number of documents that were successfully updated.
         * <p>
         * API name: {@code updated}
         * </p>
         */
        @Nonnull
        public final Builder updated(long value) {
            this.updated = value;
            return this;
        }

        /**
         * Required - The number of version conflicts that reindex hits.
         * <p>
         * API name: {@code version_conflicts}
         * </p>
         */
        @Nonnull
        public final Builder versionConflicts(long value) {
            this.versionConflicts = value;
            return this;
        }

        /**
         * Builds a {@link ReindexStatus}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ReindexStatus build() {
            _checkSingleUse();

            return new ReindexStatus(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ReindexStatus}
     */
    public static final JsonpDeserializer<ReindexStatus> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ReindexStatus::setupReindexStatusDeserializer
    );

    protected static void setupReindexStatusDeserializer(ObjectDeserializer<ReindexStatus.Builder> op) {
        op.add(Builder::batches, JsonpDeserializer.longDeserializer(), "batches");
        op.add(Builder::created, JsonpDeserializer.longDeserializer(), "created");
        op.add(Builder::deleted, JsonpDeserializer.longDeserializer(), "deleted");
        op.add(Builder::noops, JsonpDeserializer.longDeserializer(), "noops");
        op.add(Builder::requestsPerSecond, JsonpDeserializer.floatDeserializer(), "requests_per_second");
        op.add(Builder::retries, Retries._DESERIALIZER, "retries");
        op.add(Builder::throttled, Time._DESERIALIZER, "throttled");
        op.add(Builder::throttledMillis, JsonpDeserializer.longDeserializer(), "throttled_millis");
        op.add(Builder::throttledUntil, Time._DESERIALIZER, "throttled_until");
        op.add(Builder::throttledUntilMillis, JsonpDeserializer.longDeserializer(), "throttled_until_millis");
        op.add(Builder::total, JsonpDeserializer.longDeserializer(), "total");
        op.add(Builder::updated, JsonpDeserializer.longDeserializer(), "updated");
        op.add(Builder::versionConflicts, JsonpDeserializer.longDeserializer(), "version_conflicts");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Long.hashCode(this.batches);
        result = 31 * result + Long.hashCode(this.created);
        result = 31 * result + Long.hashCode(this.deleted);
        result = 31 * result + Long.hashCode(this.noops);
        result = 31 * result + Float.hashCode(this.requestsPerSecond);
        result = 31 * result + this.retries.hashCode();
        result = 31 * result + Objects.hashCode(this.throttled);
        result = 31 * result + Long.hashCode(this.throttledMillis);
        result = 31 * result + Objects.hashCode(this.throttledUntil);
        result = 31 * result + Long.hashCode(this.throttledUntilMillis);
        result = 31 * result + Long.hashCode(this.total);
        result = 31 * result + Long.hashCode(this.updated);
        result = 31 * result + Long.hashCode(this.versionConflicts);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ReindexStatus other = (ReindexStatus) o;
        return this.batches == other.batches
            && this.created == other.created
            && this.deleted == other.deleted
            && this.noops == other.noops
            && this.requestsPerSecond == other.requestsPerSecond
            && this.retries.equals(other.retries)
            && Objects.equals(this.throttled, other.throttled)
            && this.throttledMillis == other.throttledMillis
            && Objects.equals(this.throttledUntil, other.throttledUntil)
            && this.throttledUntilMillis == other.throttledUntilMillis
            && this.total == other.total
            && this.updated == other.updated
            && this.versionConflicts == other.versionConflicts;
    }
}
