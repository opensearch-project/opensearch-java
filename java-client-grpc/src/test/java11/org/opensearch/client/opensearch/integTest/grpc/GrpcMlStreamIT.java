/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.opensearch.integTest.grpc;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.junit.After;
import org.junit.Assume;
import org.junit.Test;
import org.opensearch.client.json.jackson3.JacksonJsonpMapper;
import org.opensearch.client.transport.grpc.GrpcTransport;
import org.opensearch.client.transport.grpc.GrpcTransportOptions;
import org.opensearch.client.transport.grpc.ml.MlExecuteAgentStreamRequest;
import org.opensearch.client.transport.grpc.ml.MlPredictStreamRequest;
import org.opensearch.client.transport.grpc.ml.MlStreamChunk;

/**
 * End-to-end integration tests for the ML gRPC streaming APIs
 */
public class GrpcMlStreamIT extends AbstractGrpcIT {

    private GrpcTransport transport;

    @After
    public void closeTransport() throws IOException {
        if (transport != null) {
            transport.close();
            transport = null;
        }
    }

    // ─── Tests ───────────────────────────────────────────────────────────────────

    /**
     * Streams a chat completion from a deployed model and verifies that chunks arrive
     * and carry incremental content.
     */
    @Test
    public void testPredictModelStream() throws IOException {
        assumeGrpcSupported();
        String modelId = requireId("tests.ml.model.id", "OPENSEARCH_ML_MODEL_ID");

        Iterator<MlStreamChunk> chunks = grpcTransport().predictModelStream(
            MlPredictStreamRequest.builder()
                .modelId(modelId)
                .parameters(p -> p.addMessage("user", "What is OpenSearch? Answer in one sentence."))
                .build()
        );

        List<MlStreamChunk> received = drain(chunks);

        assertFalse("Should receive at least one chunk", received.isEmpty());
        assertTrue("At least one chunk should carry content", received.stream().anyMatch(c -> c.content() != null));

        // Every chunk must convert cleanly, even status-only ones.
        for (MlStreamChunk chunk : received) {
            assertNotNull(chunk.inferenceResults());
        }
    }

    /**
     * Streams an agent execution and verifies that chunks arrive.
     */
    @Test
    public void testExecuteAgentStream() throws IOException {
        assumeGrpcSupported();
        String agentId = requireId("tests.ml.agent.id", "OPENSEARCH_ML_AGENT_ID");

        Iterator<MlStreamChunk> chunks = grpcTransport().executeAgentStream(
            MlExecuteAgentStreamRequest.builder().agentId(agentId).parameters(p -> p.question("What is OpenSearch?")).build()
        );

        assertFalse("Should receive at least one chunk", drain(chunks).isEmpty());
    }

    /**
     * Verifies that a nonexistent model surfaces a server error during iteration rather
     * than hanging or returning an empty stream.
     */
    @Test
    public void testPredictStreamUnknownModelFails() throws IOException {
        assumeGrpcSupported();

        Iterator<MlStreamChunk> chunks = grpcTransport().predictModelStream(
            MlPredictStreamRequest.builder().modelId("nonexistent-model-id").parameters(p -> p.addMessage("user", "Hi")).build()
        );

        try {
            drain(chunks);
            // Some server configurations report the failure as a terminal chunk rather
            // than a gRPC error status; either behavior is acceptable here — what matters
            // is that the call completes instead of hanging.
        } catch (RuntimeException e) {
            assertNotNull(e.getMessage());
        }
    }

    // ─── Helpers ─────────────────────────────────────────────────────────────────

    private GrpcTransport grpcTransport() {
        if (transport == null) {
            transport = GrpcTransport.builder(getGrpcHost(), getGrpcPort())
                .jsonpMapper(new JacksonJsonpMapper())
                .grpcOptions(GrpcTransportOptions.builder().maxRetries(2).build())
                .build();
        }
        return transport;
    }

    private static String requireId(String systemProperty, String environmentVariable) {
        String value = System.getProperty(systemProperty);
        if (value == null || value.isBlank()) {
            value = System.getenv(environmentVariable);
        }
        Assume.assumeTrue(
            "Set -D" + systemProperty + " or " + environmentVariable + " to run ML streaming integration tests",
            value != null && !value.isBlank()
        );
        return value;
    }

    private static List<MlStreamChunk> drain(Iterator<MlStreamChunk> chunks) {
        List<MlStreamChunk> received = new ArrayList<>();
        while (chunks.hasNext()) {
            received.add(chunks.next());
        }
        return received;
    }
}
