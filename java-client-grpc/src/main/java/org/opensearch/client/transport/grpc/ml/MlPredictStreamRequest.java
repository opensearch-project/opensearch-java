/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.transport.grpc.ml;

import javax.annotation.Nullable;

/**
 * Request for the ML streaming predict API ({@code MLService/PredictModelStream}).
 */
public final class MlPredictStreamRequest {

    private final String modelId;
    private final MlParameters parameters;

    private MlPredictStreamRequest(Builder builder) {
        if (builder.modelId == null || builder.modelId.isEmpty()) {
            throw new IllegalArgumentException("modelId is required");
        }
        this.modelId = builder.modelId;
        this.parameters = builder.parameters;
    }

    /**
     * The ID of the model to invoke. Never null.
     */
    public String modelId() {
        return modelId;
    }

    /**
     * The request parameters, or null if unset.
     */
    @Nullable
    public MlParameters parameters() {
        return parameters;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private String modelId;
        private MlParameters parameters;

        public Builder modelId(String modelId) {
            this.modelId = modelId;
            return this;
        }

        public Builder parameters(MlParameters parameters) {
            this.parameters = parameters;
            return this;
        }

        /**
         * Configures the parameters using a builder function.
         */
        public Builder parameters(java.util.function.Function<MlParameters.Builder, MlParameters.Builder> fn) {
            return parameters(fn.apply(MlParameters.builder()).build());
        }

        public MlPredictStreamRequest build() {
            return new MlPredictStreamRequest(this);
        }
    }
}
