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

package org.opensearch.client.opensearch.indices;

import jakarta.json.stream.JsonGenerator;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.opensearch.client.json.JsonData;
import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.json.PlainJsonSerializable;
import org.opensearch.client.opensearch.ingestion.ErrorPolicy;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: indices.IngestionSource

/**
 * The pull-based ingestion settings controlling how data is read from streaming sources.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class IngestionSource implements PlainJsonSerializable, ToCopyableBuilder<IngestionSource.Builder, IngestionSource> {

    @Nullable
    private final Boolean allActive;

    @Nullable
    private final ErrorPolicy errorStrategy;

    @Nullable
    private final Integer internalQueueSize;

    @Nullable
    private final Integer numProcessorThreads;

    @Nonnull
    private final Map<String, JsonData> param;

    @Nullable
    private final IngestionSourcePointer pointer;

    @Nullable
    private final IngestionSourcePointerInitReset pointerInitReset;

    @Nullable
    private final String pointerInitResetValue;

    @Nullable
    private final IngestionSourcePoll poll;

    @Nullable
    private final Long pollMaxBatchSize;

    @Nullable
    private final Integer pollTimeout;

    @Nullable
    private final IngestionSourceType type;

    // ---------------------------------------------------------------------------------------------

    private IngestionSource(Builder builder) {
        this.allActive = builder.allActive;
        this.errorStrategy = builder.errorStrategy;
        this.internalQueueSize = builder.internalQueueSize;
        this.numProcessorThreads = builder.numProcessorThreads;
        this.param = ApiTypeHelper.unmodifiable(builder.param);
        this.pointer = builder.pointer;
        this.pointerInitReset = builder.pointerInitReset;
        this.pointerInitResetValue = builder.pointerInitResetValue;
        this.poll = builder.poll;
        this.pollMaxBatchSize = builder.pollMaxBatchSize;
        this.pollTimeout = builder.pollTimeout;
        this.type = builder.type;
    }

    public static IngestionSource of(Function<IngestionSource.Builder, ObjectBuilder<IngestionSource>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Indicates if all-active ingestion is enabled for this index.
     * <p>
     * API name: {@code all_active}
     * </p>
     */
    @Nullable
    public final Boolean allActive() {
        return this.allActive;
    }

    /**
     * Defines the policy for error handling.
     * <p>
     * API name: {@code error_strategy}
     * </p>
     */
    @Nullable
    public final ErrorPolicy errorStrategy() {
        return this.errorStrategy;
    }

    /**
     * Defines the size of the internal blocking queue in pull-based ingestion.
     * <p>
     * API name: {@code internal_queue_size}
     * </p>
     */
    @Nullable
    public final Integer internalQueueSize() {
        return this.internalQueueSize;
    }

    /**
     * Defines the number of processor or writer threads.
     * <p>
     * API name: {@code num_processor_threads}
     * </p>
     */
    @Nullable
    public final Integer numProcessorThreads() {
        return this.numProcessorThreads;
    }

    /**
     * Custom parameters for the ingestion source.
     * <p>
     * API name: {@code param}
     * </p>
     */
    @Nonnull
    public final Map<String, JsonData> param() {
        return this.param;
    }

    /**
     * API name: {@code pointer}
     */
    @Nullable
    public final IngestionSourcePointer pointer() {
        return this.pointer;
    }

    /**
     * API name: {@code pointer.init.reset}
     */
    @Nullable
    public final IngestionSourcePointerInitReset pointerInitReset() {
        return this.pointerInitReset;
    }

    /**
     * Specifies the offset value or timestamp in milliseconds.
     * <p>
     * API name: {@code pointer.init.reset.value}
     * </p>
     */
    @Nullable
    public final String pointerInitResetValue() {
        return this.pointerInitResetValue;
    }

    /**
     * API name: {@code poll}
     */
    @Nullable
    public final IngestionSourcePoll poll() {
        return this.poll;
    }

    /**
     * The maximum number of records to retrieve in each poll operation.
     * <p>
     * API name: {@code poll.max_batch_size}
     * </p>
     */
    @Nullable
    public final Long pollMaxBatchSize() {
        return this.pollMaxBatchSize;
    }

    /**
     * Determines the Poll timeout value.
     * <p>
     * API name: {@code poll.timeout}
     * </p>
     */
    @Nullable
    public final Integer pollTimeout() {
        return this.pollTimeout;
    }

    /**
     * The streaming source type.
     * <p>
     * API name: {@code type}
     * </p>
     */
    @Nullable
    public final IngestionSourceType type() {
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
        if (this.allActive != null) {
            generator.writeKey("all_active");
            generator.write(this.allActive);
        }

        if (this.errorStrategy != null) {
            generator.writeKey("error_strategy");
            this.errorStrategy.serialize(generator, mapper);
        }

        if (this.internalQueueSize != null) {
            generator.writeKey("internal_queue_size");
            generator.write(this.internalQueueSize);
        }

        if (this.numProcessorThreads != null) {
            generator.writeKey("num_processor_threads");
            generator.write(this.numProcessorThreads);
        }

        if (ApiTypeHelper.isDefined(this.param)) {
            generator.writeKey("param");
            generator.writeStartObject();
            for (Map.Entry<String, JsonData> item0 : this.param.entrySet()) {
                generator.writeKey(item0.getKey());
                item0.getValue().serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (this.pointer != null) {
            generator.writeKey("pointer");
            this.pointer.serialize(generator, mapper);
        }

        if (this.pointerInitReset != null) {
            generator.writeKey("pointer.init.reset");
            this.pointerInitReset.serialize(generator, mapper);
        }

        if (this.pointerInitResetValue != null) {
            generator.writeKey("pointer.init.reset.value");
            generator.write(this.pointerInitResetValue);
        }

        if (this.poll != null) {
            generator.writeKey("poll");
            this.poll.serialize(generator, mapper);
        }

        if (this.pollMaxBatchSize != null) {
            generator.writeKey("poll.max_batch_size");
            generator.write(this.pollMaxBatchSize);
        }

        if (this.pollTimeout != null) {
            generator.writeKey("poll.timeout");
            generator.write(this.pollTimeout);
        }

        if (this.type != null) {
            generator.writeKey("type");
            this.type.serialize(generator, mapper);
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
     * Builder for {@link IngestionSource}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, IngestionSource> {
        @Nullable
        private Boolean allActive;
        @Nullable
        private ErrorPolicy errorStrategy;
        @Nullable
        private Integer internalQueueSize;
        @Nullable
        private Integer numProcessorThreads;
        @Nullable
        private Map<String, JsonData> param;
        @Nullable
        private IngestionSourcePointer pointer;
        @Nullable
        private IngestionSourcePointerInitReset pointerInitReset;
        @Nullable
        private String pointerInitResetValue;
        @Nullable
        private IngestionSourcePoll poll;
        @Nullable
        private Long pollMaxBatchSize;
        @Nullable
        private Integer pollTimeout;
        @Nullable
        private IngestionSourceType type;

        public Builder() {}

        private Builder(IngestionSource o) {
            this.allActive = o.allActive;
            this.errorStrategy = o.errorStrategy;
            this.internalQueueSize = o.internalQueueSize;
            this.numProcessorThreads = o.numProcessorThreads;
            this.param = _mapCopy(o.param);
            this.pointer = o.pointer;
            this.pointerInitReset = o.pointerInitReset;
            this.pointerInitResetValue = o.pointerInitResetValue;
            this.poll = o.poll;
            this.pollMaxBatchSize = o.pollMaxBatchSize;
            this.pollTimeout = o.pollTimeout;
            this.type = o.type;
        }

        private Builder(Builder o) {
            this.allActive = o.allActive;
            this.errorStrategy = o.errorStrategy;
            this.internalQueueSize = o.internalQueueSize;
            this.numProcessorThreads = o.numProcessorThreads;
            this.param = _mapCopy(o.param);
            this.pointer = o.pointer;
            this.pointerInitReset = o.pointerInitReset;
            this.pointerInitResetValue = o.pointerInitResetValue;
            this.poll = o.poll;
            this.pollMaxBatchSize = o.pollMaxBatchSize;
            this.pollTimeout = o.pollTimeout;
            this.type = o.type;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Indicates if all-active ingestion is enabled for this index.
         * <p>
         * API name: {@code all_active}
         * </p>
         */
        @Nonnull
        public final Builder allActive(@Nullable Boolean value) {
            this.allActive = value;
            return this;
        }

        /**
         * Defines the policy for error handling.
         * <p>
         * API name: {@code error_strategy}
         * </p>
         */
        @Nonnull
        public final Builder errorStrategy(@Nullable ErrorPolicy value) {
            this.errorStrategy = value;
            return this;
        }

        /**
         * Defines the size of the internal blocking queue in pull-based ingestion.
         * <p>
         * API name: {@code internal_queue_size}
         * </p>
         */
        @Nonnull
        public final Builder internalQueueSize(@Nullable Integer value) {
            this.internalQueueSize = value;
            return this;
        }

        /**
         * Defines the number of processor or writer threads.
         * <p>
         * API name: {@code num_processor_threads}
         * </p>
         */
        @Nonnull
        public final Builder numProcessorThreads(@Nullable Integer value) {
            this.numProcessorThreads = value;
            return this;
        }

        /**
         * Custom parameters for the ingestion source.
         * <p>
         * API name: {@code param}
         * </p>
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>param</code>.
         * </p>
         */
        @Nonnull
        public final Builder param(Map<String, JsonData> map) {
            this.param = _mapPutAll(this.param, map);
            return this;
        }

        /**
         * Custom parameters for the ingestion source.
         * <p>
         * API name: {@code param}
         * </p>
         *
         * <p>
         * Adds an entry to <code>param</code>.
         * </p>
         */
        @Nonnull
        public final Builder param(String key, JsonData value) {
            this.param = _mapPut(this.param, key, value);
            return this;
        }

        /**
         * API name: {@code pointer}
         */
        @Nonnull
        public final Builder pointer(@Nullable IngestionSourcePointer value) {
            this.pointer = value;
            return this;
        }

        /**
         * API name: {@code pointer}
         */
        @Nonnull
        public final Builder pointer(Function<IngestionSourcePointer.Builder, ObjectBuilder<IngestionSourcePointer>> fn) {
            return pointer(fn.apply(new IngestionSourcePointer.Builder()).build());
        }

        /**
         * API name: {@code pointer.init.reset}
         */
        @Nonnull
        public final Builder pointerInitReset(@Nullable IngestionSourcePointerInitReset value) {
            this.pointerInitReset = value;
            return this;
        }

        /**
         * Specifies the offset value or timestamp in milliseconds.
         * <p>
         * API name: {@code pointer.init.reset.value}
         * </p>
         */
        @Nonnull
        public final Builder pointerInitResetValue(@Nullable String value) {
            this.pointerInitResetValue = value;
            return this;
        }

        /**
         * API name: {@code poll}
         */
        @Nonnull
        public final Builder poll(@Nullable IngestionSourcePoll value) {
            this.poll = value;
            return this;
        }

        /**
         * API name: {@code poll}
         */
        @Nonnull
        public final Builder poll(Function<IngestionSourcePoll.Builder, ObjectBuilder<IngestionSourcePoll>> fn) {
            return poll(fn.apply(new IngestionSourcePoll.Builder()).build());
        }

        /**
         * The maximum number of records to retrieve in each poll operation.
         * <p>
         * API name: {@code poll.max_batch_size}
         * </p>
         */
        @Nonnull
        public final Builder pollMaxBatchSize(@Nullable Long value) {
            this.pollMaxBatchSize = value;
            return this;
        }

        /**
         * Determines the Poll timeout value.
         * <p>
         * API name: {@code poll.timeout}
         * </p>
         */
        @Nonnull
        public final Builder pollTimeout(@Nullable Integer value) {
            this.pollTimeout = value;
            return this;
        }

        /**
         * The streaming source type.
         * <p>
         * API name: {@code type}
         * </p>
         */
        @Nonnull
        public final Builder type(@Nullable IngestionSourceType value) {
            this.type = value;
            return this;
        }

        /**
         * Builds a {@link IngestionSource}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public IngestionSource build() {
            _checkSingleUse();

            return new IngestionSource(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link IngestionSource}
     */
    public static final JsonpDeserializer<IngestionSource> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        IngestionSource::setupIngestionSourceDeserializer
    );

    protected static void setupIngestionSourceDeserializer(ObjectDeserializer<IngestionSource.Builder> op) {
        op.add(Builder::allActive, JsonpDeserializer.booleanDeserializer(), "all_active");
        op.add(Builder::errorStrategy, ErrorPolicy._DESERIALIZER, "error_strategy");
        op.add(Builder::internalQueueSize, JsonpDeserializer.integerDeserializer(), "internal_queue_size");
        op.add(Builder::numProcessorThreads, JsonpDeserializer.integerDeserializer(), "num_processor_threads");
        op.add(Builder::param, JsonpDeserializer.stringMapDeserializer(JsonData._DESERIALIZER), "param");
        op.add(Builder::pointer, IngestionSourcePointer._DESERIALIZER, "pointer");
        op.add(Builder::pointerInitReset, IngestionSourcePointerInitReset._DESERIALIZER, "pointer.init.reset");
        op.add(Builder::pointerInitResetValue, JsonpDeserializer.stringDeserializer(), "pointer.init.reset.value");
        op.add(Builder::poll, IngestionSourcePoll._DESERIALIZER, "poll");
        op.add(Builder::pollMaxBatchSize, JsonpDeserializer.longDeserializer(), "poll.max_batch_size");
        op.add(Builder::pollTimeout, JsonpDeserializer.integerDeserializer(), "poll.timeout");
        op.add(Builder::type, IngestionSourceType._DESERIALIZER, "type");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.allActive);
        result = 31 * result + Objects.hashCode(this.errorStrategy);
        result = 31 * result + Objects.hashCode(this.internalQueueSize);
        result = 31 * result + Objects.hashCode(this.numProcessorThreads);
        result = 31 * result + Objects.hashCode(this.param);
        result = 31 * result + Objects.hashCode(this.pointer);
        result = 31 * result + Objects.hashCode(this.pointerInitReset);
        result = 31 * result + Objects.hashCode(this.pointerInitResetValue);
        result = 31 * result + Objects.hashCode(this.poll);
        result = 31 * result + Objects.hashCode(this.pollMaxBatchSize);
        result = 31 * result + Objects.hashCode(this.pollTimeout);
        result = 31 * result + Objects.hashCode(this.type);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        IngestionSource other = (IngestionSource) o;
        return Objects.equals(this.allActive, other.allActive)
            && Objects.equals(this.errorStrategy, other.errorStrategy)
            && Objects.equals(this.internalQueueSize, other.internalQueueSize)
            && Objects.equals(this.numProcessorThreads, other.numProcessorThreads)
            && Objects.equals(this.param, other.param)
            && Objects.equals(this.pointer, other.pointer)
            && Objects.equals(this.pointerInitReset, other.pointerInitReset)
            && Objects.equals(this.pointerInitResetValue, other.pointerInitResetValue)
            && Objects.equals(this.poll, other.poll)
            && Objects.equals(this.pollMaxBatchSize, other.pollMaxBatchSize)
            && Objects.equals(this.pollTimeout, other.pollTimeout)
            && Objects.equals(this.type, other.type);
    }
}
