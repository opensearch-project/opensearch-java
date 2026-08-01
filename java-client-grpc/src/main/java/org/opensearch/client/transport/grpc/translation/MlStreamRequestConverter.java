/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.transport.grpc.translation;

import org.opensearch.client.transport.grpc.ml.MlExecuteAgentStreamRequest;
import org.opensearch.client.transport.grpc.ml.MlMessage;
import org.opensearch.client.transport.grpc.ml.MlParameters;
import org.opensearch.client.transport.grpc.ml.MlPredictStreamRequest;
import org.opensearch.protobufs.MLExecuteAgentStreamRequestBody;
import org.opensearch.protobufs.MLPredictModelStreamRequestBody;
import org.opensearch.protobufs.Messages;
import org.opensearch.protobufs.Parameters;

/**
 * Converts opensearch-java ML streaming requests to their protobuf equivalents
 * for transmission over gRPC.
 */
public final class MlStreamRequestConverter {

    private MlStreamRequestConverter() {
        // utility class
    }

    /**
     * Converts a client {@link MlPredictStreamRequest} to a protobuf
     * {@code MlPredictModelStreamRequest}.
     *
     * @param request the client request
     * @return the protobuf request ready to send over gRPC
     */
    public static org.opensearch.protobufs.MlPredictModelStreamRequest toProto(MlPredictStreamRequest request) {
        org.opensearch.protobufs.MlPredictModelStreamRequest.Builder builder = org.opensearch.protobufs.MlPredictModelStreamRequest
            .newBuilder();

        builder.setModelId(request.modelId());

        if (request.parameters() != null) {
            builder.setMlPredictModelStreamRequestBody(
                MLPredictModelStreamRequestBody.newBuilder().setParameters(toProto(request.parameters())).build()
            );
        }

        return builder.build();
    }

    /**
     * Converts a client {@link MlExecuteAgentStreamRequest} to a protobuf
     * {@code MlExecuteAgentStreamRequest}.
     *
     * @param request the client request
     * @return the protobuf request ready to send over gRPC
     */
    public static org.opensearch.protobufs.MlExecuteAgentStreamRequest toProto(MlExecuteAgentStreamRequest request) {
        org.opensearch.protobufs.MlExecuteAgentStreamRequest.Builder builder = org.opensearch.protobufs.MlExecuteAgentStreamRequest
            .newBuilder();

        builder.setAgentId(request.agentId());

        if (request.parameters() != null) {
            builder.setMlExecuteAgentStreamRequestBody(
                MLExecuteAgentStreamRequestBody.newBuilder().setParameters(toProto(request.parameters())).build()
            );
        }

        return builder.build();
    }

    /**
     * Converts client {@link MlParameters} to a protobuf {@code Parameters}.
     * Only fields that were set are mapped.
     */
    private static Parameters toProto(MlParameters parameters) {
        Parameters.Builder builder = Parameters.newBuilder();

        for (MlMessage message : parameters.messages()) {
            Messages.Builder messageBuilder = Messages.newBuilder();
            if (message.role() != null) {
                messageBuilder.setRole(message.role());
            }
            if (message.content() != null) {
                messageBuilder.setContent(message.content());
            }
            builder.addMessages(messageBuilder.build());
        }

        if (parameters.inputs() != null) {
            builder.setInputs(parameters.inputs());
        }
        if (parameters.question() != null) {
            builder.setQuestion(parameters.question());
        }
        if (parameters.llmInterface() != null) {
            builder.setXLlmInterface(parameters.llmInterface());
        }

        return builder.build();
    }
}
