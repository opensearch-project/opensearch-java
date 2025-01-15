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
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: ml.ModelProfile

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class ModelProfile implements PlainJsonSerializable, ToCopyableBuilder<ModelProfile.Builder, ModelProfile> {

    @Nullable
    private final Long memorySizeEstimationCpu;

    @Nullable
    private final Long memorySizeEstimationGpu;

    @Nullable
    private final String modelState;

    @Nullable
    private final PredictRequestStats predictRequestStats;

    @Nullable
    private final String predictor;

    @Nonnull
    private final List<List<String>> targetWorkerNodes;

    @Nonnull
    private final List<List<String>> workerNodes;

    // ---------------------------------------------------------------------------------------------

    private ModelProfile(Builder builder) {
        this.memorySizeEstimationCpu = builder.memorySizeEstimationCpu;
        this.memorySizeEstimationGpu = builder.memorySizeEstimationGpu;
        this.modelState = builder.modelState;
        this.predictRequestStats = builder.predictRequestStats;
        this.predictor = builder.predictor;
        this.targetWorkerNodes = ApiTypeHelper.unmodifiable(builder.targetWorkerNodes);
        this.workerNodes = ApiTypeHelper.unmodifiable(builder.workerNodes);
    }

    public static ModelProfile of(Function<ModelProfile.Builder, ObjectBuilder<ModelProfile>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * The estimated memory size in CPU.
     * <p>
     * API name: {@code memory_size_estimation_cpu}
     * </p>
     */
    @Nullable
    public final Long memorySizeEstimationCpu() {
        return this.memorySizeEstimationCpu;
    }

    /**
     * The estimated memory size in GPU.
     * <p>
     * API name: {@code memory_size_estimation_gpu}
     * </p>
     */
    @Nullable
    public final Long memorySizeEstimationGpu() {
        return this.memorySizeEstimationGpu;
    }

    /**
     * The model state.
     * <p>
     * API name: {@code model_state}
     * </p>
     */
    @Nullable
    public final String modelState() {
        return this.modelState;
    }

    /**
     * API name: {@code predict_request_stats}
     */
    @Nullable
    public final PredictRequestStats predictRequestStats() {
        return this.predictRequestStats;
    }

    /**
     * The predictor.
     * <p>
     * API name: {@code predictor}
     * </p>
     */
    @Nullable
    public final String predictor() {
        return this.predictor;
    }

    /**
     * API name: {@code target_worker_nodes}
     */
    @Nonnull
    public final List<List<String>> targetWorkerNodes() {
        return this.targetWorkerNodes;
    }

    /**
     * API name: {@code worker_nodes}
     */
    @Nonnull
    public final List<List<String>> workerNodes() {
        return this.workerNodes;
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
        if (this.memorySizeEstimationCpu != null) {
            generator.writeKey("memory_size_estimation_cpu");
            generator.write(this.memorySizeEstimationCpu);
        }

        if (this.memorySizeEstimationGpu != null) {
            generator.writeKey("memory_size_estimation_gpu");
            generator.write(this.memorySizeEstimationGpu);
        }

        if (this.modelState != null) {
            generator.writeKey("model_state");
            generator.write(this.modelState);
        }

        if (this.predictRequestStats != null) {
            generator.writeKey("predict_request_stats");
            this.predictRequestStats.serialize(generator, mapper);
        }

        if (this.predictor != null) {
            generator.writeKey("predictor");
            generator.write(this.predictor);
        }

        if (ApiTypeHelper.isDefined(this.targetWorkerNodes)) {
            generator.writeKey("target_worker_nodes");
            generator.writeStartArray();
            for (List<String> item0 : this.targetWorkerNodes) {
                generator.writeStartArray();
                for (String item1 : item0) {
                    generator.write(item1);
                }
                generator.writeEnd();
            }
            generator.writeEnd();
        }

        if (ApiTypeHelper.isDefined(this.workerNodes)) {
            generator.writeKey("worker_nodes");
            generator.writeStartArray();
            for (List<String> item0 : this.workerNodes) {
                generator.writeStartArray();
                for (String item1 : item0) {
                    generator.write(item1);
                }
                generator.writeEnd();
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
     * Builder for {@link ModelProfile}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, ModelProfile> {
        @Nullable
        private Long memorySizeEstimationCpu;
        @Nullable
        private Long memorySizeEstimationGpu;
        @Nullable
        private String modelState;
        @Nullable
        private PredictRequestStats predictRequestStats;
        @Nullable
        private String predictor;
        @Nullable
        private List<List<String>> targetWorkerNodes;
        @Nullable
        private List<List<String>> workerNodes;

        public Builder() {}

        private Builder(ModelProfile o) {
            this.memorySizeEstimationCpu = o.memorySizeEstimationCpu;
            this.memorySizeEstimationGpu = o.memorySizeEstimationGpu;
            this.modelState = o.modelState;
            this.predictRequestStats = o.predictRequestStats;
            this.predictor = o.predictor;
            this.targetWorkerNodes = _listCopy(o.targetWorkerNodes);
            this.workerNodes = _listCopy(o.workerNodes);
        }

        private Builder(Builder o) {
            this.memorySizeEstimationCpu = o.memorySizeEstimationCpu;
            this.memorySizeEstimationGpu = o.memorySizeEstimationGpu;
            this.modelState = o.modelState;
            this.predictRequestStats = o.predictRequestStats;
            this.predictor = o.predictor;
            this.targetWorkerNodes = _listCopy(o.targetWorkerNodes);
            this.workerNodes = _listCopy(o.workerNodes);
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * The estimated memory size in CPU.
         * <p>
         * API name: {@code memory_size_estimation_cpu}
         * </p>
         */
        @Nonnull
        public final Builder memorySizeEstimationCpu(@Nullable Long value) {
            this.memorySizeEstimationCpu = value;
            return this;
        }

        /**
         * The estimated memory size in GPU.
         * <p>
         * API name: {@code memory_size_estimation_gpu}
         * </p>
         */
        @Nonnull
        public final Builder memorySizeEstimationGpu(@Nullable Long value) {
            this.memorySizeEstimationGpu = value;
            return this;
        }

        /**
         * The model state.
         * <p>
         * API name: {@code model_state}
         * </p>
         */
        @Nonnull
        public final Builder modelState(@Nullable String value) {
            this.modelState = value;
            return this;
        }

        /**
         * API name: {@code predict_request_stats}
         */
        @Nonnull
        public final Builder predictRequestStats(@Nullable PredictRequestStats value) {
            this.predictRequestStats = value;
            return this;
        }

        /**
         * API name: {@code predict_request_stats}
         */
        @Nonnull
        public final Builder predictRequestStats(Function<PredictRequestStats.Builder, ObjectBuilder<PredictRequestStats>> fn) {
            return predictRequestStats(fn.apply(new PredictRequestStats.Builder()).build());
        }

        /**
         * The predictor.
         * <p>
         * API name: {@code predictor}
         * </p>
         */
        @Nonnull
        public final Builder predictor(@Nullable String value) {
            this.predictor = value;
            return this;
        }

        /**
         * API name: {@code target_worker_nodes}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>targetWorkerNodes</code>.
         * </p>
         */
        @Nonnull
        public final Builder targetWorkerNodes(List<List<String>> list) {
            this.targetWorkerNodes = _listAddAll(this.targetWorkerNodes, list);
            return this;
        }

        /**
         * API name: {@code target_worker_nodes}
         *
         * <p>
         * Adds one or more values to <code>targetWorkerNodes</code>.
         * </p>
         */
        @Nonnull
        public final Builder targetWorkerNodes(List<String> value, List<String>... values) {
            this.targetWorkerNodes = _listAdd(this.targetWorkerNodes, value, values);
            return this;
        }

        /**
         * API name: {@code worker_nodes}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>workerNodes</code>.
         * </p>
         */
        @Nonnull
        public final Builder workerNodes(List<List<String>> list) {
            this.workerNodes = _listAddAll(this.workerNodes, list);
            return this;
        }

        /**
         * API name: {@code worker_nodes}
         *
         * <p>
         * Adds one or more values to <code>workerNodes</code>.
         * </p>
         */
        @Nonnull
        public final Builder workerNodes(List<String> value, List<String>... values) {
            this.workerNodes = _listAdd(this.workerNodes, value, values);
            return this;
        }

        /**
         * Builds a {@link ModelProfile}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ModelProfile build() {
            _checkSingleUse();

            return new ModelProfile(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ModelProfile}
     */
    public static final JsonpDeserializer<ModelProfile> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ModelProfile::setupModelProfileDeserializer
    );

    protected static void setupModelProfileDeserializer(ObjectDeserializer<ModelProfile.Builder> op) {
        op.add(Builder::memorySizeEstimationCpu, JsonpDeserializer.longDeserializer(), "memory_size_estimation_cpu");
        op.add(Builder::memorySizeEstimationGpu, JsonpDeserializer.longDeserializer(), "memory_size_estimation_gpu");
        op.add(Builder::modelState, JsonpDeserializer.stringDeserializer(), "model_state");
        op.add(Builder::predictRequestStats, PredictRequestStats._DESERIALIZER, "predict_request_stats");
        op.add(Builder::predictor, JsonpDeserializer.stringDeserializer(), "predictor");
        op.add(
            Builder::targetWorkerNodes,
            JsonpDeserializer.arrayDeserializer(JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer())),
            "target_worker_nodes"
        );
        op.add(
            Builder::workerNodes,
            JsonpDeserializer.arrayDeserializer(JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer())),
            "worker_nodes"
        );
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.memorySizeEstimationCpu);
        result = 31 * result + Objects.hashCode(this.memorySizeEstimationGpu);
        result = 31 * result + Objects.hashCode(this.modelState);
        result = 31 * result + Objects.hashCode(this.predictRequestStats);
        result = 31 * result + Objects.hashCode(this.predictor);
        result = 31 * result + Objects.hashCode(this.targetWorkerNodes);
        result = 31 * result + Objects.hashCode(this.workerNodes);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ModelProfile other = (ModelProfile) o;
        return Objects.equals(this.memorySizeEstimationCpu, other.memorySizeEstimationCpu)
            && Objects.equals(this.memorySizeEstimationGpu, other.memorySizeEstimationGpu)
            && Objects.equals(this.modelState, other.modelState)
            && Objects.equals(this.predictRequestStats, other.predictRequestStats)
            && Objects.equals(this.predictor, other.predictor)
            && Objects.equals(this.targetWorkerNodes, other.targetWorkerNodes)
            && Objects.equals(this.workerNodes, other.workerNodes);
    }
}
