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
 * Request for the ML streaming agent execute API ({@code MLService/ExecuteAgentStream}).
 */
public final class MlExecuteAgentStreamRequest {

    private final String agentId;
    private final MlParameters parameters;

    private MlExecuteAgentStreamRequest(Builder builder) {
        if (builder.agentId == null || builder.agentId.isEmpty()) {
            throw new IllegalArgumentException("agentId is required");
        }
        this.agentId = builder.agentId;
        this.parameters = builder.parameters;
    }

    /**
     * The ID of the agent to execute. Never null.
     */
    public String agentId() {
        return agentId;
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
        private String agentId;
        private MlParameters parameters;

        public Builder agentId(String agentId) {
            this.agentId = agentId;
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

        public MlExecuteAgentStreamRequest build() {
            return new MlExecuteAgentStreamRequest(this);
        }
    }
}
