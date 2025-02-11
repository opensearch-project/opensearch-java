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

// typedef: ml.AlgorithmOperations

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class AlgorithmOperations implements PlainJsonSerializable, ToCopyableBuilder<AlgorithmOperations.Builder, AlgorithmOperations> {

    @Nullable
    private final ModelStats deploy;

    @Nullable
    private final ModelStats predict;

    @Nullable
    private final ModelStats register;

    @Nullable
    private final ModelStats train;

    @Nullable
    private final ModelStats trainPredict;

    @Nullable
    private final ModelStats undeploy;

    // ---------------------------------------------------------------------------------------------

    private AlgorithmOperations(Builder builder) {
        this.deploy = builder.deploy;
        this.predict = builder.predict;
        this.register = builder.register;
        this.train = builder.train;
        this.trainPredict = builder.trainPredict;
        this.undeploy = builder.undeploy;
    }

    public static AlgorithmOperations of(Function<AlgorithmOperations.Builder, ObjectBuilder<AlgorithmOperations>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code deploy}
     */
    @Nullable
    public final ModelStats deploy() {
        return this.deploy;
    }

    /**
     * API name: {@code predict}
     */
    @Nullable
    public final ModelStats predict() {
        return this.predict;
    }

    /**
     * API name: {@code register}
     */
    @Nullable
    public final ModelStats register() {
        return this.register;
    }

    /**
     * API name: {@code train}
     */
    @Nullable
    public final ModelStats train() {
        return this.train;
    }

    /**
     * API name: {@code train_predict}
     */
    @Nullable
    public final ModelStats trainPredict() {
        return this.trainPredict;
    }

    /**
     * API name: {@code undeploy}
     */
    @Nullable
    public final ModelStats undeploy() {
        return this.undeploy;
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
        if (this.deploy != null) {
            generator.writeKey("deploy");
            this.deploy.serialize(generator, mapper);
        }

        if (this.predict != null) {
            generator.writeKey("predict");
            this.predict.serialize(generator, mapper);
        }

        if (this.register != null) {
            generator.writeKey("register");
            this.register.serialize(generator, mapper);
        }

        if (this.train != null) {
            generator.writeKey("train");
            this.train.serialize(generator, mapper);
        }

        if (this.trainPredict != null) {
            generator.writeKey("train_predict");
            this.trainPredict.serialize(generator, mapper);
        }

        if (this.undeploy != null) {
            generator.writeKey("undeploy");
            this.undeploy.serialize(generator, mapper);
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
     * Builder for {@link AlgorithmOperations}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, AlgorithmOperations> {
        @Nullable
        private ModelStats deploy;
        @Nullable
        private ModelStats predict;
        @Nullable
        private ModelStats register;
        @Nullable
        private ModelStats train;
        @Nullable
        private ModelStats trainPredict;
        @Nullable
        private ModelStats undeploy;

        public Builder() {}

        private Builder(AlgorithmOperations o) {
            this.deploy = o.deploy;
            this.predict = o.predict;
            this.register = o.register;
            this.train = o.train;
            this.trainPredict = o.trainPredict;
            this.undeploy = o.undeploy;
        }

        private Builder(Builder o) {
            this.deploy = o.deploy;
            this.predict = o.predict;
            this.register = o.register;
            this.train = o.train;
            this.trainPredict = o.trainPredict;
            this.undeploy = o.undeploy;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code deploy}
         */
        @Nonnull
        public final Builder deploy(@Nullable ModelStats value) {
            this.deploy = value;
            return this;
        }

        /**
         * API name: {@code deploy}
         */
        @Nonnull
        public final Builder deploy(Function<ModelStats.Builder, ObjectBuilder<ModelStats>> fn) {
            return deploy(fn.apply(new ModelStats.Builder()).build());
        }

        /**
         * API name: {@code predict}
         */
        @Nonnull
        public final Builder predict(@Nullable ModelStats value) {
            this.predict = value;
            return this;
        }

        /**
         * API name: {@code predict}
         */
        @Nonnull
        public final Builder predict(Function<ModelStats.Builder, ObjectBuilder<ModelStats>> fn) {
            return predict(fn.apply(new ModelStats.Builder()).build());
        }

        /**
         * API name: {@code register}
         */
        @Nonnull
        public final Builder register(@Nullable ModelStats value) {
            this.register = value;
            return this;
        }

        /**
         * API name: {@code register}
         */
        @Nonnull
        public final Builder register(Function<ModelStats.Builder, ObjectBuilder<ModelStats>> fn) {
            return register(fn.apply(new ModelStats.Builder()).build());
        }

        /**
         * API name: {@code train}
         */
        @Nonnull
        public final Builder train(@Nullable ModelStats value) {
            this.train = value;
            return this;
        }

        /**
         * API name: {@code train}
         */
        @Nonnull
        public final Builder train(Function<ModelStats.Builder, ObjectBuilder<ModelStats>> fn) {
            return train(fn.apply(new ModelStats.Builder()).build());
        }

        /**
         * API name: {@code train_predict}
         */
        @Nonnull
        public final Builder trainPredict(@Nullable ModelStats value) {
            this.trainPredict = value;
            return this;
        }

        /**
         * API name: {@code train_predict}
         */
        @Nonnull
        public final Builder trainPredict(Function<ModelStats.Builder, ObjectBuilder<ModelStats>> fn) {
            return trainPredict(fn.apply(new ModelStats.Builder()).build());
        }

        /**
         * API name: {@code undeploy}
         */
        @Nonnull
        public final Builder undeploy(@Nullable ModelStats value) {
            this.undeploy = value;
            return this;
        }

        /**
         * API name: {@code undeploy}
         */
        @Nonnull
        public final Builder undeploy(Function<ModelStats.Builder, ObjectBuilder<ModelStats>> fn) {
            return undeploy(fn.apply(new ModelStats.Builder()).build());
        }

        /**
         * Builds a {@link AlgorithmOperations}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public AlgorithmOperations build() {
            _checkSingleUse();

            return new AlgorithmOperations(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link AlgorithmOperations}
     */
    public static final JsonpDeserializer<AlgorithmOperations> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        AlgorithmOperations::setupAlgorithmOperationsDeserializer
    );

    protected static void setupAlgorithmOperationsDeserializer(ObjectDeserializer<AlgorithmOperations.Builder> op) {
        op.add(Builder::deploy, ModelStats._DESERIALIZER, "deploy");
        op.add(Builder::predict, ModelStats._DESERIALIZER, "predict");
        op.add(Builder::register, ModelStats._DESERIALIZER, "register");
        op.add(Builder::train, ModelStats._DESERIALIZER, "train");
        op.add(Builder::trainPredict, ModelStats._DESERIALIZER, "train_predict");
        op.add(Builder::undeploy, ModelStats._DESERIALIZER, "undeploy");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.deploy);
        result = 31 * result + Objects.hashCode(this.predict);
        result = 31 * result + Objects.hashCode(this.register);
        result = 31 * result + Objects.hashCode(this.train);
        result = 31 * result + Objects.hashCode(this.trainPredict);
        result = 31 * result + Objects.hashCode(this.undeploy);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        AlgorithmOperations other = (AlgorithmOperations) o;
        return Objects.equals(this.deploy, other.deploy)
            && Objects.equals(this.predict, other.predict)
            && Objects.equals(this.register, other.register)
            && Objects.equals(this.train, other.train)
            && Objects.equals(this.trainPredict, other.trainPredict)
            && Objects.equals(this.undeploy, other.undeploy);
    }
}
