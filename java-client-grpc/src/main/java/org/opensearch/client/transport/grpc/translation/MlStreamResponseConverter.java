/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.transport.grpc.translation;

import org.opensearch.client.transport.grpc.ml.MlInferenceResult;
import org.opensearch.client.transport.grpc.ml.MlOutput;
import org.opensearch.client.transport.grpc.ml.MlStreamChunk;
import org.opensearch.client.transport.grpc.ml.MlStreamStatus;
import org.opensearch.protobufs.DataAsMap;
import org.opensearch.protobufs.InferenceResults;
import org.opensearch.protobufs.Output;
import org.opensearch.protobufs.PredictResponse;

/**
 * Converts protobuf {@code PredictResponse} chunks received from an ML server stream
 * to opensearch-java {@link MlStreamChunk} objects.
 */
public final class MlStreamResponseConverter {

    private MlStreamResponseConverter() {
        // utility class
    }

    /**
     * Converts one protobuf {@code PredictResponse} to an {@link MlStreamChunk}.
     *
     * @param response the streamed protobuf response
     * @return the converted chunk
     */
    public static MlStreamChunk fromProto(PredictResponse response) {
        MlStreamChunk.Builder builder = MlStreamChunk.builder();

        if (response.hasStatus()) {
            builder.status(MlStreamStatus.fromProto(response.getStatus()));
        }

        for (InferenceResults results : response.getInferenceResultsList()) {
            MlInferenceResult.Builder resultBuilder = MlInferenceResult.builder();
            for (Output output : results.getOutputList()) {
                resultBuilder.addOutput(convertOutput(output));
            }
            builder.addInferenceResult(resultBuilder.build());
        }

        return builder.build();
    }

    private static MlOutput convertOutput(Output output) {
        MlOutput.Builder builder = MlOutput.builder();

        if (output.hasName()) {
            builder.name(output.getName());
        }
        if (output.hasResult()) {
            builder.result(output.getResult());
        }
        if (output.hasDataAsMap()) {
            DataAsMap dataAsMap = output.getDataAsMap();
            if (dataAsMap.hasContent()) {
                builder.content(dataAsMap.getContent());
            }
            if (dataAsMap.hasIsLast()) {
                builder.isLast(dataAsMap.getIsLast());
            }
        }

        return builder.build();
    }
}
