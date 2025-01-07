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

package org.opensearch.client.opensearch.cat.pending_tasks;

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

// typedef: cat.pending_tasks.PendingTasksRecord

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class PendingTasksRecord implements PlainJsonSerializable, ToCopyableBuilder<PendingTasksRecord.Builder, PendingTasksRecord> {

    @Nullable
    private final String insertOrder;

    @Nullable
    private final String priority;

    @Nullable
    private final String source;

    @Nullable
    private final String timeInQueue;

    // ---------------------------------------------------------------------------------------------

    private PendingTasksRecord(Builder builder) {
        this.insertOrder = builder.insertOrder;
        this.priority = builder.priority;
        this.source = builder.source;
        this.timeInQueue = builder.timeInQueue;
    }

    public static PendingTasksRecord of(Function<PendingTasksRecord.Builder, ObjectBuilder<PendingTasksRecord>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * The task insertion order.
     * <p>
     * API name: {@code insertOrder}
     * </p>
     */
    @Nullable
    public final String insertOrder() {
        return this.insertOrder;
    }

    /**
     * The task priority.
     * <p>
     * API name: {@code priority}
     * </p>
     */
    @Nullable
    public final String priority() {
        return this.priority;
    }

    /**
     * The task source.
     * <p>
     * API name: {@code source}
     * </p>
     */
    @Nullable
    public final String source() {
        return this.source;
    }

    /**
     * Indicates how long the task has been in queue.
     * <p>
     * API name: {@code timeInQueue}
     * </p>
     */
    @Nullable
    public final String timeInQueue() {
        return this.timeInQueue;
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
        if (this.insertOrder != null) {
            generator.writeKey("insertOrder");
            generator.write(this.insertOrder);
        }

        if (this.priority != null) {
            generator.writeKey("priority");
            generator.write(this.priority);
        }

        if (this.source != null) {
            generator.writeKey("source");
            generator.write(this.source);
        }

        if (this.timeInQueue != null) {
            generator.writeKey("timeInQueue");
            generator.write(this.timeInQueue);
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
     * Builder for {@link PendingTasksRecord}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, PendingTasksRecord> {
        @Nullable
        private String insertOrder;
        @Nullable
        private String priority;
        @Nullable
        private String source;
        @Nullable
        private String timeInQueue;

        public Builder() {}

        private Builder(PendingTasksRecord o) {
            this.insertOrder = o.insertOrder;
            this.priority = o.priority;
            this.source = o.source;
            this.timeInQueue = o.timeInQueue;
        }

        private Builder(Builder o) {
            this.insertOrder = o.insertOrder;
            this.priority = o.priority;
            this.source = o.source;
            this.timeInQueue = o.timeInQueue;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * The task insertion order.
         * <p>
         * API name: {@code insertOrder}
         * </p>
         */
        @Nonnull
        public final Builder insertOrder(@Nullable String value) {
            this.insertOrder = value;
            return this;
        }

        /**
         * The task priority.
         * <p>
         * API name: {@code priority}
         * </p>
         */
        @Nonnull
        public final Builder priority(@Nullable String value) {
            this.priority = value;
            return this;
        }

        /**
         * The task source.
         * <p>
         * API name: {@code source}
         * </p>
         */
        @Nonnull
        public final Builder source(@Nullable String value) {
            this.source = value;
            return this;
        }

        /**
         * Indicates how long the task has been in queue.
         * <p>
         * API name: {@code timeInQueue}
         * </p>
         */
        @Nonnull
        public final Builder timeInQueue(@Nullable String value) {
            this.timeInQueue = value;
            return this;
        }

        /**
         * Builds a {@link PendingTasksRecord}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public PendingTasksRecord build() {
            _checkSingleUse();

            return new PendingTasksRecord(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link PendingTasksRecord}
     */
    public static final JsonpDeserializer<PendingTasksRecord> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        PendingTasksRecord::setupPendingTasksRecordDeserializer
    );

    protected static void setupPendingTasksRecordDeserializer(ObjectDeserializer<PendingTasksRecord.Builder> op) {
        op.add(Builder::insertOrder, JsonpDeserializer.stringDeserializer(), "insertOrder");
        op.add(Builder::priority, JsonpDeserializer.stringDeserializer(), "priority");
        op.add(Builder::source, JsonpDeserializer.stringDeserializer(), "source");
        op.add(Builder::timeInQueue, JsonpDeserializer.stringDeserializer(), "timeInQueue");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.insertOrder);
        result = 31 * result + Objects.hashCode(this.priority);
        result = 31 * result + Objects.hashCode(this.source);
        result = 31 * result + Objects.hashCode(this.timeInQueue);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        PendingTasksRecord other = (PendingTasksRecord) o;
        return Objects.equals(this.insertOrder, other.insertOrder)
            && Objects.equals(this.priority, other.priority)
            && Objects.equals(this.source, other.source)
            && Objects.equals(this.timeInQueue, other.timeInQueue);
    }
}
