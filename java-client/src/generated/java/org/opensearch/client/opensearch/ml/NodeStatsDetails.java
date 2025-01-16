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
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: ml.NodeStatsDetails

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class NodeStatsDetails implements PlainJsonSerializable, ToCopyableBuilder<NodeStatsDetails.Builder, NodeStatsDetails> {

    @Nonnull
    private final Map<String, AlgorithmOperations> algorithms;

    @Nullable
    private final Long mlCircuitBreakerTriggerCount;

    @Nullable
    private final Long mlDeployedModelCount;

    @Nullable
    private final Long mlExecutingTaskCount;

    @Nullable
    private final Long mlFailureCount;

    @Nullable
    private final Long mlJvmHeapUsage;

    @Nullable
    private final Long mlRequestCount;

    @Nonnull
    private final Map<String, ModelProfile> models;

    // ---------------------------------------------------------------------------------------------

    private NodeStatsDetails(Builder builder) {
        this.algorithms = ApiTypeHelper.unmodifiable(builder.algorithms);
        this.mlCircuitBreakerTriggerCount = builder.mlCircuitBreakerTriggerCount;
        this.mlDeployedModelCount = builder.mlDeployedModelCount;
        this.mlExecutingTaskCount = builder.mlExecutingTaskCount;
        this.mlFailureCount = builder.mlFailureCount;
        this.mlJvmHeapUsage = builder.mlJvmHeapUsage;
        this.mlRequestCount = builder.mlRequestCount;
        this.models = ApiTypeHelper.unmodifiable(builder.models);
    }

    public static NodeStatsDetails of(Function<NodeStatsDetails.Builder, ObjectBuilder<NodeStatsDetails>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code algorithms}
     */
    @Nonnull
    public final Map<String, AlgorithmOperations> algorithms() {
        return this.algorithms;
    }

    /**
     * The circuit breaker trigger count.
     * <p>
     * API name: {@code ml_circuit_breaker_trigger_count}
     * </p>
     */
    @Nullable
    public final Long mlCircuitBreakerTriggerCount() {
        return this.mlCircuitBreakerTriggerCount;
    }

    /**
     * The deployed model count.
     * <p>
     * API name: {@code ml_deployed_model_count}
     * </p>
     */
    @Nullable
    public final Long mlDeployedModelCount() {
        return this.mlDeployedModelCount;
    }

    /**
     * The executing task count.
     * <p>
     * API name: {@code ml_executing_task_count}
     * </p>
     */
    @Nullable
    public final Long mlExecutingTaskCount() {
        return this.mlExecutingTaskCount;
    }

    /**
     * The failure count.
     * <p>
     * API name: {@code ml_failure_count}
     * </p>
     */
    @Nullable
    public final Long mlFailureCount() {
        return this.mlFailureCount;
    }

    /**
     * The JVM heap usage.
     * <p>
     * API name: {@code ml_jvm_heap_usage}
     * </p>
     */
    @Nullable
    public final Long mlJvmHeapUsage() {
        return this.mlJvmHeapUsage;
    }

    /**
     * The request count.
     * <p>
     * API name: {@code ml_request_count}
     * </p>
     */
    @Nullable
    public final Long mlRequestCount() {
        return this.mlRequestCount;
    }

    /**
     * API name: {@code models}
     */
    @Nonnull
    public final Map<String, ModelProfile> models() {
        return this.models;
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
        if (ApiTypeHelper.isDefined(this.algorithms)) {
            generator.writeKey("algorithms");
            generator.writeStartObject();
            for (Map.Entry<String, AlgorithmOperations> item0 : this.algorithms.entrySet()) {
                generator.writeKey(item0.getKey());
                item0.getValue().serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (this.mlCircuitBreakerTriggerCount != null) {
            generator.writeKey("ml_circuit_breaker_trigger_count");
            generator.write(this.mlCircuitBreakerTriggerCount);
        }

        if (this.mlDeployedModelCount != null) {
            generator.writeKey("ml_deployed_model_count");
            generator.write(this.mlDeployedModelCount);
        }

        if (this.mlExecutingTaskCount != null) {
            generator.writeKey("ml_executing_task_count");
            generator.write(this.mlExecutingTaskCount);
        }

        if (this.mlFailureCount != null) {
            generator.writeKey("ml_failure_count");
            generator.write(this.mlFailureCount);
        }

        if (this.mlJvmHeapUsage != null) {
            generator.writeKey("ml_jvm_heap_usage");
            generator.write(this.mlJvmHeapUsage);
        }

        if (this.mlRequestCount != null) {
            generator.writeKey("ml_request_count");
            generator.write(this.mlRequestCount);
        }

        if (ApiTypeHelper.isDefined(this.models)) {
            generator.writeKey("models");
            generator.writeStartObject();
            for (Map.Entry<String, ModelProfile> item0 : this.models.entrySet()) {
                generator.writeKey(item0.getKey());
                item0.getValue().serialize(generator, mapper);
            }
            generator.writeEnd();
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
     * Builder for {@link NodeStatsDetails}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, NodeStatsDetails> {
        @Nullable
        private Map<String, AlgorithmOperations> algorithms;
        @Nullable
        private Long mlCircuitBreakerTriggerCount;
        @Nullable
        private Long mlDeployedModelCount;
        @Nullable
        private Long mlExecutingTaskCount;
        @Nullable
        private Long mlFailureCount;
        @Nullable
        private Long mlJvmHeapUsage;
        @Nullable
        private Long mlRequestCount;
        @Nullable
        private Map<String, ModelProfile> models;

        public Builder() {}

        private Builder(NodeStatsDetails o) {
            this.algorithms = _mapCopy(o.algorithms);
            this.mlCircuitBreakerTriggerCount = o.mlCircuitBreakerTriggerCount;
            this.mlDeployedModelCount = o.mlDeployedModelCount;
            this.mlExecutingTaskCount = o.mlExecutingTaskCount;
            this.mlFailureCount = o.mlFailureCount;
            this.mlJvmHeapUsage = o.mlJvmHeapUsage;
            this.mlRequestCount = o.mlRequestCount;
            this.models = _mapCopy(o.models);
        }

        private Builder(Builder o) {
            this.algorithms = _mapCopy(o.algorithms);
            this.mlCircuitBreakerTriggerCount = o.mlCircuitBreakerTriggerCount;
            this.mlDeployedModelCount = o.mlDeployedModelCount;
            this.mlExecutingTaskCount = o.mlExecutingTaskCount;
            this.mlFailureCount = o.mlFailureCount;
            this.mlJvmHeapUsage = o.mlJvmHeapUsage;
            this.mlRequestCount = o.mlRequestCount;
            this.models = _mapCopy(o.models);
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code algorithms}
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>algorithms</code>.
         * </p>
         */
        @Nonnull
        public final Builder algorithms(Map<String, AlgorithmOperations> map) {
            this.algorithms = _mapPutAll(this.algorithms, map);
            return this;
        }

        /**
         * API name: {@code algorithms}
         *
         * <p>
         * Adds an entry to <code>algorithms</code>.
         * </p>
         */
        @Nonnull
        public final Builder algorithms(String key, AlgorithmOperations value) {
            this.algorithms = _mapPut(this.algorithms, key, value);
            return this;
        }

        /**
         * API name: {@code algorithms}
         *
         * <p>
         * Adds a value to <code>algorithms</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder algorithms(String key, Function<AlgorithmOperations.Builder, ObjectBuilder<AlgorithmOperations>> fn) {
            return algorithms(key, fn.apply(new AlgorithmOperations.Builder()).build());
        }

        /**
         * The circuit breaker trigger count.
         * <p>
         * API name: {@code ml_circuit_breaker_trigger_count}
         * </p>
         */
        @Nonnull
        public final Builder mlCircuitBreakerTriggerCount(@Nullable Long value) {
            this.mlCircuitBreakerTriggerCount = value;
            return this;
        }

        /**
         * The deployed model count.
         * <p>
         * API name: {@code ml_deployed_model_count}
         * </p>
         */
        @Nonnull
        public final Builder mlDeployedModelCount(@Nullable Long value) {
            this.mlDeployedModelCount = value;
            return this;
        }

        /**
         * The executing task count.
         * <p>
         * API name: {@code ml_executing_task_count}
         * </p>
         */
        @Nonnull
        public final Builder mlExecutingTaskCount(@Nullable Long value) {
            this.mlExecutingTaskCount = value;
            return this;
        }

        /**
         * The failure count.
         * <p>
         * API name: {@code ml_failure_count}
         * </p>
         */
        @Nonnull
        public final Builder mlFailureCount(@Nullable Long value) {
            this.mlFailureCount = value;
            return this;
        }

        /**
         * The JVM heap usage.
         * <p>
         * API name: {@code ml_jvm_heap_usage}
         * </p>
         */
        @Nonnull
        public final Builder mlJvmHeapUsage(@Nullable Long value) {
            this.mlJvmHeapUsage = value;
            return this;
        }

        /**
         * The request count.
         * <p>
         * API name: {@code ml_request_count}
         * </p>
         */
        @Nonnull
        public final Builder mlRequestCount(@Nullable Long value) {
            this.mlRequestCount = value;
            return this;
        }

        /**
         * API name: {@code models}
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>models</code>.
         * </p>
         */
        @Nonnull
        public final Builder models(Map<String, ModelProfile> map) {
            this.models = _mapPutAll(this.models, map);
            return this;
        }

        /**
         * API name: {@code models}
         *
         * <p>
         * Adds an entry to <code>models</code>.
         * </p>
         */
        @Nonnull
        public final Builder models(String key, ModelProfile value) {
            this.models = _mapPut(this.models, key, value);
            return this;
        }

        /**
         * API name: {@code models}
         *
         * <p>
         * Adds a value to <code>models</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder models(String key, Function<ModelProfile.Builder, ObjectBuilder<ModelProfile>> fn) {
            return models(key, fn.apply(new ModelProfile.Builder()).build());
        }

        /**
         * Builds a {@link NodeStatsDetails}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public NodeStatsDetails build() {
            _checkSingleUse();

            return new NodeStatsDetails(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link NodeStatsDetails}
     */
    public static final JsonpDeserializer<NodeStatsDetails> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        NodeStatsDetails::setupNodeStatsDetailsDeserializer
    );

    protected static void setupNodeStatsDetailsDeserializer(ObjectDeserializer<NodeStatsDetails.Builder> op) {
        op.add(Builder::algorithms, JsonpDeserializer.stringMapDeserializer(AlgorithmOperations._DESERIALIZER), "algorithms");
        op.add(Builder::mlCircuitBreakerTriggerCount, JsonpDeserializer.longDeserializer(), "ml_circuit_breaker_trigger_count");
        op.add(Builder::mlDeployedModelCount, JsonpDeserializer.longDeserializer(), "ml_deployed_model_count");
        op.add(Builder::mlExecutingTaskCount, JsonpDeserializer.longDeserializer(), "ml_executing_task_count");
        op.add(Builder::mlFailureCount, JsonpDeserializer.longDeserializer(), "ml_failure_count");
        op.add(Builder::mlJvmHeapUsage, JsonpDeserializer.longDeserializer(), "ml_jvm_heap_usage");
        op.add(Builder::mlRequestCount, JsonpDeserializer.longDeserializer(), "ml_request_count");
        op.add(Builder::models, JsonpDeserializer.stringMapDeserializer(ModelProfile._DESERIALIZER), "models");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.algorithms);
        result = 31 * result + Objects.hashCode(this.mlCircuitBreakerTriggerCount);
        result = 31 * result + Objects.hashCode(this.mlDeployedModelCount);
        result = 31 * result + Objects.hashCode(this.mlExecutingTaskCount);
        result = 31 * result + Objects.hashCode(this.mlFailureCount);
        result = 31 * result + Objects.hashCode(this.mlJvmHeapUsage);
        result = 31 * result + Objects.hashCode(this.mlRequestCount);
        result = 31 * result + Objects.hashCode(this.models);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        NodeStatsDetails other = (NodeStatsDetails) o;
        return Objects.equals(this.algorithms, other.algorithms)
            && Objects.equals(this.mlCircuitBreakerTriggerCount, other.mlCircuitBreakerTriggerCount)
            && Objects.equals(this.mlDeployedModelCount, other.mlDeployedModelCount)
            && Objects.equals(this.mlExecutingTaskCount, other.mlExecutingTaskCount)
            && Objects.equals(this.mlFailureCount, other.mlFailureCount)
            && Objects.equals(this.mlJvmHeapUsage, other.mlJvmHeapUsage)
            && Objects.equals(this.mlRequestCount, other.mlRequestCount)
            && Objects.equals(this.models, other.models);
    }
}
