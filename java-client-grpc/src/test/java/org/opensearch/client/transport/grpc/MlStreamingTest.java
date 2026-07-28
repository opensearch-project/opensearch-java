/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.transport.grpc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import io.grpc.ManagedChannel;
import io.grpc.Server;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import io.grpc.inprocess.InProcessChannelBuilder;
import io.grpc.inprocess.InProcessServerBuilder;
import io.grpc.stub.StreamObserver;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.jackson3.JacksonJsonpMapper;
import org.opensearch.client.opensearch._types.OpenSearchException;
import org.opensearch.client.transport.TransportException;
import org.opensearch.client.transport.grpc.ml.MlExecuteAgentStreamRequest;
import org.opensearch.client.transport.grpc.ml.MlOutput;
import org.opensearch.client.transport.grpc.ml.MlPredictStreamRequest;
import org.opensearch.client.transport.grpc.ml.MlStreamChunk;
import org.opensearch.client.transport.grpc.ml.MlStreamStatus;
import org.opensearch.protobufs.DataAsMap;
import org.opensearch.protobufs.InferenceResults;
import org.opensearch.protobufs.MlPredictModelStreamRequest;
import org.opensearch.protobufs.Output;
import org.opensearch.protobufs.PredictResponse;
import org.opensearch.protobufs.services.MLServiceGrpc;

/**
 * Tests for the ML gRPC streaming APIs on {@link GrpcTransport}.
 */
public class MlStreamingTest {

    private final JsonpMapper mapper = new JacksonJsonpMapper();

    private Server server;
    private ManagedChannel channel;
    private GrpcTransport transport;
    private FakeMlService service;

    @Before
    public void setUp() throws IOException {
        String name = InProcessServerBuilder.generateName();
        service = new FakeMlService();
        server = InProcessServerBuilder.forName(name).directExecutor().addService(service).build().start();
        channel = InProcessChannelBuilder.forName(name).directExecutor().build();
        transport = GrpcTransport.builder("localhost", 9400).jsonpMapper(mapper).channel(channel).build();
    }

    @After
    public void tearDown() throws IOException {
        if (transport != null) {
            transport.close();
        }
        if (server != null) {
            server.shutdownNow();
        }
    }

    // ═══ Predict streaming ═══════════════════════════════════════════════════════

    @Test
    public void testPredictStreamYieldsAllChunks() {
        service.responses.add(runningChunk("Hello", false));
        service.responses.add(runningChunk(" world", true));

        List<String> content = collectContent(transport.predictModelStream(predictRequest()));

        assertEquals(2, content.size());
        assertEquals("Hello", content.get(0));
        assertEquals(" world", content.get(1));
    }

    @Test
    public void testPredictStreamConvertsChunkFields() {
        service.responses.add(runningChunk("chunk", true));

        Iterator<MlStreamChunk> chunks = transport.predictModelStream(predictRequest());
        assertTrue(chunks.hasNext());
        MlStreamChunk chunk = chunks.next();

        assertEquals(MlStreamStatus.RUNNING, chunk.status());
        assertEquals("chunk", chunk.content());
        assertEquals(Boolean.TRUE, chunk.isLast());
        assertEquals(1, chunk.inferenceResults().size());
        assertEquals("response", chunk.inferenceResults().get(0).output().get(0).name());
        assertFalse(chunks.hasNext());
    }

    @Test
    public void testPredictStreamSendsModelIdAndParameters() {
        service.responses.add(runningChunk("x", true));

        drain(
            transport.predictModelStream(
                MlPredictStreamRequest.builder()
                    .modelId("model-1")
                    .parameters(p -> p.addMessage("user", "Hi").llmInterface("openai/v1/chat/completions"))
                    .build()
            )
        );

        MlPredictModelStreamRequest sent = service.lastPredictRequest;
        assertNotNull(sent);
        assertEquals("model-1", sent.getModelId());
        assertTrue(sent.hasMlPredictModelStreamRequestBody());
        assertEquals("user", sent.getMlPredictModelStreamRequestBody().getParameters().getMessages(0).getRole());
        assertEquals("Hi", sent.getMlPredictModelStreamRequestBody().getParameters().getMessages(0).getContent());
        assertEquals("openai/v1/chat/completions", sent.getMlPredictModelStreamRequestBody().getParameters().getXLlmInterface());
    }

    @Test
    public void testPredictStreamOmitsBodyWhenNoParameters() {
        service.responses.add(runningChunk("x", true));

        drain(transport.predictModelStream(MlPredictStreamRequest.builder().modelId("model-1").build()));

        assertFalse(service.lastPredictRequest.hasMlPredictModelStreamRequestBody());
    }

    @Test
    public void testPredictStreamIsLazy() {
        service.responses.add(runningChunk("x", true));

        transport.predictModelStream(predictRequest());

        // No terminal operation — the RPC must not have been issued yet.
        assertNull(service.lastPredictRequest);
    }

    @Test
    public void testEmptyStreamYieldsNoChunks() {
        assertFalse(transport.predictModelStream(predictRequest()).hasNext());
    }

    // ═══ Agent streaming ═════════════════════════════════════════════════════════

    @Test
    public void testExecuteAgentStreamYieldsChunks() {
        service.responses.add(runningChunk("agent says", true));

        List<String> content = collectContent(
            transport.executeAgentStream(
                MlExecuteAgentStreamRequest.builder().agentId("agent-1").parameters(p -> p.question("What is OpenSearch?")).build()
            )
        );

        assertEquals(1, content.size());
        assertEquals("agent says", content.get(0));
        assertEquals("agent-1", service.lastAgentRequest.getAgentId());
        assertEquals("What is OpenSearch?", service.lastAgentRequest.getMlExecuteAgentStreamRequestBody().getParameters().getQuestion());
    }

    /**
     * Agent chunks lead with {@code memory_id} and {@code parent_interaction_id} outputs
     * that carry only a {@code result}, so the content shortcuts must select the
     * {@code response} output by name rather than taking the first output positionally.
     */
    @Test
    public void testAgentChunkWithLeadingMetadataOutputsExposesContent() {
        service.responses.add(agentChunk("mem-1", "parent-1", "tool call", false));

        Iterator<MlStreamChunk> chunks = transport.executeAgentStream(
            MlExecuteAgentStreamRequest.builder().agentId("agent-1").parameters(p -> p.question("Q")).build()
        );

        assertTrue(chunks.hasNext());
        MlStreamChunk chunk = chunks.next();

        assertEquals("tool call", chunk.content());
        assertEquals(Boolean.FALSE, chunk.isLast());

        // The metadata outputs remain reachable for conversation continuity.
        List<MlOutput> outputs = chunk.inferenceResults().get(0).output();
        assertEquals(3, outputs.size());
        assertEquals("memory_id", outputs.get(0).name());
        assertEquals("mem-1", outputs.get(0).result());
        assertEquals("parent_interaction_id", outputs.get(1).name());
        assertEquals("parent-1", outputs.get(1).result());
    }

    /**
     * A chunk whose only outputs are metadata (no content anywhere) must report null
     * rather than picking up a metadata output's absent content.
     */
    @Test
    public void testMetadataOnlyChunkHasNullContent() {
        service.responses.add(
            PredictResponse.newBuilder()
                .addInferenceResults(
                    InferenceResults.newBuilder().addOutput(Output.newBuilder().setName("memory_id").setResult("mem-1").build()).build()
                )
                .build()
        );

        Iterator<MlStreamChunk> chunks = transport.executeAgentStream(MlExecuteAgentStreamRequest.builder().agentId("agent-1").build());

        MlStreamChunk chunk = chunks.next();
        assertNull(chunk.content());
        assertNull(chunk.isLast());
    }

    /**
     * When the {@code response} output carries {@code is_last} but no content, both
     * shortcuts must still read from it — not fall through to some other output — so they
     * never report a content and an is_last flag that came from different outputs.
     */
    @Test
    public void testContentAndIsLastComeFromTheSameOutput() {
        service.responses.add(
            PredictResponse.newBuilder()
                .addInferenceResults(
                    InferenceResults.newBuilder()
                        // A non-response output that does have content.
                        .addOutput(
                            Output.newBuilder()
                                .setName("other")
                                .setDataAsMap(DataAsMap.newBuilder().setContent("not the answer").build())
                                .build()
                        )
                        // The response output: terminal marker, no content of its own.
                        .addOutput(
                            Output.newBuilder().setName("response").setDataAsMap(DataAsMap.newBuilder().setIsLast(true).build()).build()
                        )
                        .build()
                )
                .build()
        );

        MlStreamChunk chunk = transport.executeAgentStream(MlExecuteAgentStreamRequest.builder().agentId("agent-1").build()).next();

        assertEquals(Boolean.TRUE, chunk.isLast());
        assertNull(chunk.content());
    }

    @Test
    public void testExecuteAgentStreamOmitsBodyWhenNoParameters() {
        service.responses.add(runningChunk("x", true));

        drain(transport.executeAgentStream(MlExecuteAgentStreamRequest.builder().agentId("agent-1").build()));

        assertFalse(service.lastAgentRequest.hasMlExecuteAgentStreamRequestBody());
    }

    // ═══ Error handling ══════════════════════════════════════════════════════════

    @Test
    public void testNotFoundBecomesOpenSearchException() {
        service.error = new StatusRuntimeException(Status.NOT_FOUND.withDescription("no such model"));

        try {
            drain(transport.predictModelStream(predictRequest()));
            fail("Should throw");
        } catch (OpenSearchException e) {
            assertEquals(404, e.status());
        }
    }

    @Test
    public void testUnavailableBecomesUncheckedTransportException() {
        service.error = new StatusRuntimeException(Status.UNAVAILABLE.withDescription("down"));

        try {
            drain(transport.predictModelStream(predictRequest()));
            fail("Should throw");
        } catch (UncheckedIOException e) {
            assertTrue(e.getCause() instanceof TransportException);
        }
    }

    @Test
    public void testUnimplementedBecomesUnsupportedOperation() {
        service.error = new StatusRuntimeException(Status.UNIMPLEMENTED.withDescription("not built"));

        try {
            drain(transport.executeAgentStream(MlExecuteAgentStreamRequest.builder().agentId("a").build()));
            fail("Should throw");
        } catch (UnsupportedOperationException e) {
            assertTrue(e.getMessage().contains("not built"));
        }
    }

    @Test
    public void testErrorAfterChunksPreservesDeliveredChunks() {
        service.responses.add(runningChunk("partial", false));
        service.error = new StatusRuntimeException(Status.INTERNAL.withDescription("boom"));

        Iterator<MlStreamChunk> chunks = transport.predictModelStream(predictRequest());
        assertEquals("partial", chunks.next().content());

        try {
            chunks.hasNext();
            fail("Should throw");
        } catch (UncheckedIOException e) {
            assertTrue(e.getCause() instanceof TransportException);
        }
    }

    @Test
    public void testStreamingWithoutChannelThrows() throws IOException {
        GrpcTransport noChannel = new GrpcTransport(null, mapper, GrpcTransportOptions.defaults(), null);
        try {
            noChannel.predictModelStream(predictRequest()).hasNext();
            fail("Should throw");
        } catch (IllegalStateException e) {
            assertTrue(e.getMessage().contains("channel is not available"));
        } finally {
            noChannel.close();
        }
    }

    // ═══ Request validation ══════════════════════════════════════════════════════

    @Test(expected = IllegalArgumentException.class)
    public void testPredictRequestRequiresModelId() {
        MlPredictStreamRequest.builder().build();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAgentRequestRequiresAgentId() {
        MlExecuteAgentStreamRequest.builder().build();
    }

    // ═══ Helpers ═════════════════════════════════════════════════════════════════

    private static MlPredictStreamRequest predictRequest() {
        return MlPredictStreamRequest.builder().modelId("model-1").parameters(p -> p.addMessage("user", "Hi")).build();
    }

    /**
     * An agent-shaped chunk: {@code memory_id} and {@code parent_interaction_id} outputs
     * carrying only a {@code result}, followed by the {@code response} output that holds
     * the actual payload. This is what {@code MLChatAgentRunner} emits.
     */
    private static PredictResponse agentChunk(String memoryId, String parentInteractionId, String content, boolean isLast) {
        return PredictResponse.newBuilder()
            .addInferenceResults(
                InferenceResults.newBuilder()
                    .addOutput(Output.newBuilder().setName("memory_id").setResult(memoryId).build())
                    .addOutput(Output.newBuilder().setName("parent_interaction_id").setResult(parentInteractionId).build())
                    .addOutput(
                        Output.newBuilder()
                            .setName("response")
                            .setDataAsMap(DataAsMap.newBuilder().setContent(content).setIsLast(isLast).build())
                            .build()
                    )
                    .build()
            )
            .build();
    }

    private static PredictResponse runningChunk(String content, boolean isLast) {
        return PredictResponse.newBuilder()
            .setStatus(org.opensearch.protobufs.Status.STATUS_RUNNING)
            .addInferenceResults(
                InferenceResults.newBuilder()
                    .addOutput(
                        Output.newBuilder()
                            .setName("response")
                            .setDataAsMap(DataAsMap.newBuilder().setContent(content).setIsLast(isLast).build())
                            .build()
                    )
                    .build()
            )
            .build();
    }

    private static List<String> collectContent(Iterator<MlStreamChunk> chunks) {
        List<String> content = new ArrayList<>();
        while (chunks.hasNext()) {
            content.add(chunks.next().content());
        }
        return content;
    }

    private static void drain(Iterator<MlStreamChunk> chunks) {
        while (chunks.hasNext()) {
            chunks.next();
        }
    }

    /**
     * In-process MLService that replays a canned list of chunks, optionally followed by
     * an error, and records the requests it received.
     */
    private static final class FakeMlService extends MLServiceGrpc.MLServiceImplBase {
        final List<PredictResponse> responses = new ArrayList<>();
        StatusRuntimeException error;
        MlPredictModelStreamRequest lastPredictRequest;
        org.opensearch.protobufs.MlExecuteAgentStreamRequest lastAgentRequest;

        @Override
        public void predictModelStream(MlPredictModelStreamRequest request, StreamObserver<PredictResponse> observer) {
            lastPredictRequest = request;
            replay(observer);
        }

        @Override
        public void executeAgentStream(
            org.opensearch.protobufs.MlExecuteAgentStreamRequest request,
            StreamObserver<PredictResponse> observer
        ) {
            lastAgentRequest = request;
            replay(observer);
        }

        private void replay(StreamObserver<PredictResponse> observer) {
            for (PredictResponse response : responses) {
                observer.onNext(response);
            }
            if (error != null) {
                observer.onError(error);
            } else {
                observer.onCompleted();
            }
        }
    }
}
