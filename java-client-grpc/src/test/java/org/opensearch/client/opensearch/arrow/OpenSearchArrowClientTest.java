/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.opensearch.arrow;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import io.grpc.Context;
import io.grpc.Contexts;
import io.grpc.ManagedChannel;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.Server;
import io.grpc.ServerCall;
import io.grpc.ServerCallHandler;
import io.grpc.ServerInterceptor;
import io.grpc.ServerInterceptors;
import io.grpc.ServerServiceDefinition;
import io.grpc.Status;
import io.grpc.inprocess.InProcessChannelBuilder;
import io.grpc.inprocess.InProcessServerBuilder;
import io.grpc.stub.ServerCallStreamObserver;
import io.grpc.stub.ServerCalls;
import io.grpc.stub.StreamObserver;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import org.apache.arrow.memory.BufferAllocator;
import org.apache.arrow.memory.OutOfMemoryException;
import org.apache.arrow.memory.RootAllocator;
import org.apache.arrow.vector.BigIntVector;
import org.apache.arrow.vector.IntVector;
import org.apache.arrow.vector.VarCharVector;
import org.apache.arrow.vector.VectorSchemaRoot;
import org.apache.arrow.vector.ipc.message.ArrowFieldNode;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.opensearch.client.json.jackson3.JacksonJsonpMapper;
import org.opensearch.client.opensearch._types.FieldValue;
import org.opensearch.client.opensearch._types.OpenSearchException;
import org.opensearch.client.opensearch.core.SearchResponse;
import org.opensearch.client.transport.TransportException;
import org.opensearch.client.transport.TransportOptions;
import org.opensearch.client.transport.grpc.GrpcTransport;
import org.opensearch.client.transport.grpc.GrpcTransportOptions;
import org.opensearch.client.transport.grpc.HybridTransport;
import org.opensearch.protobufs.HitsMetadata;
import org.opensearch.protobufs.HitsMetadataTotal;
import org.opensearch.protobufs.ShardStatistics;
import org.opensearch.protobufs.TotalHits;
import org.opensearch.protobufs.TotalHitsRelation;
import org.opensearch.protobufs.services.SearchServiceGrpc;

/**
 * The Arrow client against an in-process {@code ServerStreamSearch} that streams Arrow IPC payloads the way the
 * arrow-search plugin does.
 */
public class OpenSearchArrowClientTest {

    private static final Metadata.Key<String> FORMAT = Metadata.Key.of("x-opensearch-format", Metadata.ASCII_STRING_MARSHALLER);
    private static final Context.Key<Metadata> HEADERS = Context.key("headers");
    private static final int ROWS_PER_BATCH = 100;

    /** The server sends raw bytes: data messages are field 100 only, as the plugin writes them. */
    private static final MethodDescriptor.Marshaller<byte[]> BYTES = new MethodDescriptor.Marshaller<byte[]>() {
        @Override
        public InputStream stream(byte[] value) {
            return new ByteArrayInputStream(value);
        }

        @Override
        public byte[] parse(InputStream stream) {
            try {
                return stream.readAllBytes();
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        }
    };

    // What the server does, set per test.
    private volatile int batches = 3;
    private volatile Status failBeforeSchema;
    private volatile int failAfterBatches = -1;
    /** Sent in place of the first batch, if set. */
    private volatile byte[] firstBatch;
    /** Ends the call with an error after the summary, if set. */
    private volatile boolean failAfterSummary;

    private final CopyOnWriteArrayList<Metadata> headers = new CopyOnWriteArrayList<>();
    private final CopyOnWriteArrayList<org.opensearch.protobufs.SearchRequest> requests = new CopyOnWriteArrayList<>();
    private final AtomicInteger batchesSent = new AtomicInteger();
    /** Guards the server's allocator: a cancelled call's handler may still be building a batch during teardown. */
    private final Object serverAllocatorLock = new Object();
    private boolean serverAllocatorClosed;
    private final CountDownLatch serverCancelled = new CountDownLatch(1);
    private BufferAllocator serverAllocator;
    private BufferAllocator allocator;
    private Server server;
    private ManagedChannel channel;
    private GrpcTransport transport;

    @Before
    public void start() throws IOException {
        serverAllocator = new RootAllocator();
        allocator = new RootAllocator();
        String name = InProcessServerBuilder.generateName();
        MethodDescriptor<org.opensearch.protobufs.SearchRequest, org.opensearch.protobufs.SearchResponse> declared = SearchServiceGrpc
            .getServerStreamSearchMethod();
        MethodDescriptor<org.opensearch.protobufs.SearchRequest, byte[]> rawResponses = declared.toBuilder(
            declared.getRequestMarshaller(),
            BYTES
        ).build();
        ServerInterceptor headersToContext = new ServerInterceptor() {
            @Override
            public <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(
                ServerCall<ReqT, RespT> call,
                Metadata metadata,
                ServerCallHandler<ReqT, RespT> next
            ) {
                return Contexts.interceptCall(Context.current().withValue(HEADERS, metadata), call, metadata, next);
            }
        };
        ServerServiceDefinition service = ServerServiceDefinition.builder(SearchServiceGrpc.SERVICE_NAME)
            .addMethod(rawResponses, ServerCalls.asyncServerStreamingCall(this::serve))
            .build();
        server = InProcessServerBuilder.forName(name).addService(ServerInterceptors.intercept(service, headersToContext)).build().start();
        channel = InProcessChannelBuilder.forName(name).build();
        transport = GrpcTransport.builder("in-process", 0)
            .jsonpMapper(new JacksonJsonpMapper())
            .grpcOptions(GrpcTransportOptions.builder().maxRetries(0).build())
            .channel(channel)
            .build();
    }

    private void serve(org.opensearch.protobufs.SearchRequest request, StreamObserver<byte[]> out) {
        headers.add(HEADERS.get());
        requests.add(request);
        if (failBeforeSchema != null) {
            out.onError(failBeforeSchema.asRuntimeException());
            return;
        }
        ServerCallStreamObserver<byte[]> observer = (ServerCallStreamObserver<byte[]>) out;
        observer.setOnCancelHandler(serverCancelled::countDown);
        AtomicInteger next = new AtomicInteger(-1);
        Runnable drain = new Runnable() {
            @Override
            public synchronized void run() {
                try {
                    while (observer.isReady() && observer.isCancelled() == false) {
                        int i = next.getAndIncrement();
                        if (i == -1) {
                            observer.onNext(ArrowIpcMarshallerTest.schemaMessage(ArrowIpcMarshallerTest.SCHEMA));
                        } else if (i == failAfterBatches) {
                            observer.onError(Status.UNAVAILABLE.withDescription("node left").asRuntimeException());
                            return;
                        } else if (i < batches) {
                            byte[] batch;
                            synchronized (serverAllocatorLock) {
                                if (serverAllocatorClosed) {
                                    return;
                                }
                                batch = i == 0 && firstBatch != null
                                    ? firstBatch
                                    : ArrowIpcMarshallerTest.batchMessage(serverAllocator, ROWS_PER_BATCH, i * ROWS_PER_BATCH);
                            }
                            observer.onNext(batch);
                            batchesSent.incrementAndGet();
                        } else if (i == batches) {
                            observer.onNext(summary(batches * ROWS_PER_BATCH).toByteArray());
                            if (failAfterSummary) {
                                observer.onError(Status.INTERNAL.withDescription("failed after the summary").asRuntimeException());
                            } else {
                                observer.onCompleted();
                            }
                            return;
                        } else {
                            return;
                        }
                    }
                } catch (Exception e) {
                    observer.onError(Status.INTERNAL.withCause(e).asRuntimeException());
                }
            }
        };
        observer.setOnReadyHandler(drain);
        drain.run();
    }

    private static org.opensearch.protobufs.SearchResponse summary(long rows) {
        return org.opensearch.protobufs.SearchResponse.newBuilder()
            .setTook(12)
            .setTimedOut(false)
            .setTerminatedEarly(false)
            .setXShards(ShardStatistics.newBuilder().setTotal(2).setSuccessful(2).setFailed(0))
            .setHits(
                HitsMetadata.newBuilder()
                    .setTotal(
                        HitsMetadataTotal.newBuilder()
                            .setTotalHits(TotalHits.newBuilder().setValue(rows).setRelation(TotalHitsRelation.TOTAL_HITS_RELATION_EQ))
                    )
            )
            .build();
    }

    @After
    public void stop() throws InterruptedException {
        channel.shutdownNow().awaitTermination(5, TimeUnit.SECONDS);
        server.shutdownNow().awaitTermination(5, TimeUnit.SECONDS);
        assertEquals("the client released all its Arrow memory", 0, allocator.getAllocatedMemory());
        allocator.close();
        synchronized (serverAllocatorLock) {
            serverAllocatorClosed = true;
            serverAllocator.close();
        }
    }

    private OpenSearchArrowClient client() {
        return new OpenSearchArrowClient(transport, allocator);
    }

    @Test
    public void testSearchStreamsBatchesThenTheSummary() throws IOException {
        long rows = 0;
        try (
            ArrowSearchResponse response = client().search(
                s -> s.index("logs")
                    .query(q -> q.term(t -> t.field("group").value(FieldValue.of(1))))
                    .docvalueFields(f -> f.field("id"))
                    .docvalueFields(f -> f.field("tags").format("list"))
            )
        ) {
            VectorSchemaRoot root = response.getVectorSchemaRoot();
            assertEquals(ArrowIpcMarshallerTest.SCHEMA, root.getSchema());
            while (response.loadNextBatch()) {
                int first = (int) rows;
                assertEquals(ROWS_PER_BATCH, root.getRowCount());
                assertEquals(String.valueOf(first + 1), new String(((VarCharVector) root.getVector("id")).get(1), StandardCharsets.UTF_8));
                assertEquals((first + 1) % 4, ((IntVector) root.getVector("group")).get(1));
                assertEquals((first + 1) * 10L, ((BigIntVector) root.getVector("value")).get(1));
                rows += root.getRowCount();
            }
            assertFalse("ended streams stay ended", response.loadNextBatch());
            SearchResponse<Void> summary = response.summary();
            assertEquals(300, summary.hits().total().value());
            assertEquals(12, summary.took());
            assertEquals(2, summary.shards().successful());
            assertTrue(response.bytesRead() > 0);
        }
        assertEquals(300, rows);
        assertEquals("arrow", headers.get(0).get(FORMAT));
        org.opensearch.protobufs.SearchRequest sent = requests.get(0);
        assertEquals("group", sent.getSearchRequestBody().getQuery().getTerm().getField());
        assertEquals("list", sent.getSearchRequestBody().getDocvalueFields(1).getFormat());
    }

    @Test
    public void testAnEmptyResultHasASchemaAndNoBatches() throws IOException {
        batches = 0;
        try (ArrowSearchResponse response = client().search(s -> s.index("logs").docvalueFields(f -> f.field("id")))) {
            assertEquals(3, response.getVectorSchemaRoot().getFieldVectors().size());
            assertFalse(response.loadNextBatch());
            assertEquals(0, response.summary().hits().total().value());
        }
    }

    @Test
    public void testRequestErrorsAreThrownFromSearch() throws IOException {
        failBeforeSchema = Status.INVALID_ARGUMENT.withDescription("[sort] is not supported by Arrow search");
        try {
            client().search(s -> s.index("logs"));
            fail("expected OpenSearchException");
        } catch (OpenSearchException e) {
            assertEquals(400, e.status());
        }
    }

    @Test
    public void testOptionsGrpcCannotSendAreRejectedBeforeAnythingIsSent() throws IOException {
        try {
            client().search(s -> s.index("logs").sort(o -> o.field(f -> f.field("ts"))));
            fail("expected UnsupportedOperationException");
        } catch (UnsupportedOperationException e) {
            assertTrue(e.getMessage(), e.getMessage().contains("'sort'"));
        }
        try {
            // A token read from a file that ends in a newline, which gRPC metadata cannot carry
            client().withTransportOptions(TransportOptions.builder().addHeader("Authorization", "Bearer token\n").build())
                .search(s -> s.index("logs"));
            fail("expected UnsupportedOperationException");
        } catch (UnsupportedOperationException e) {
            assertTrue(e.getMessage(), e.getMessage().contains("Authorization"));
        }
        assertEquals(0, requests.size());
    }

    @Test
    public void testAFailureAfterBatchesIsThrownFromLoadNextBatch() throws IOException {
        failAfterBatches = 1;
        try (ArrowSearchResponse response = client().search(s -> s.index("logs"))) {
            assertTrue(response.loadNextBatch());
            try {
                response.loadNextBatch();
                fail("expected TransportException");
            } catch (TransportException e) {
                assertTrue(e.getMessage(), e.getMessage().contains("node left"));
            }
        }
    }

    @Test
    public void testAReaderThatStopsReadingPausesTheServer() throws Exception {
        batches = 1_000;
        try (ArrowSearchResponse response = client().search(s -> s.index("logs"))) {
            assertTrue(response.loadNextBatch());
            int sentWhilePaused = batchesSent.get();
            // Flow control lets the server run at most a few batches ahead of a reader that does not read.
            assertFalse(waitUntil(() -> batchesSent.get() > 6, 300));
            assertTrue("sent " + sentWhilePaused, sentWhilePaused <= 6);
        }
        assertTrue("closing early cancels the search", serverCancelled.await(10, TimeUnit.SECONDS));
    }

    @Test
    public void testTheAllocatorLimitFailsTheSearchAndFreesEverything() throws IOException {
        // A batch of 100 rows takes about 1.9KB of Arrow memory.
        try (BufferAllocator small = new RootAllocator(1024)) {
            OpenSearchArrowClient limited = new OpenSearchArrowClient(transport, small);
            try (ArrowSearchResponse response = limited.search(s -> s.index("logs"))) {
                response.loadNextBatch();
                fail("expected OutOfMemoryException");
            } catch (OutOfMemoryException e) {
                // the batch does not fit the caller's allocator
            }
            assertEquals(0, small.getAllocatedMemory());
        }
    }

    @Test
    public void testABatchDeclaringMoreRowsThanItHoldsFailsBeforeArrowAllocatesThem() throws Exception {
        // About 200 bytes that declare a billion rows in every column of the schema (id, group, value)
        int rows = 1_000_000_000;
        firstBatch = ArrowIpcMarshallerTest.recordBatchMessage(
            serverAllocator,
            rows,
            List.of(new ArrowFieldNode(rows, 0), new ArrowFieldNode(rows, 0), new ArrowFieldNode(rows, 0)),
            new byte[8],
            new byte[8],
            new byte[0],
            new byte[8],
            new byte[8],
            new byte[8],
            new byte[8]
        );
        try (BufferAllocator limited = new RootAllocator(16 * 1024 * 1024)) {
            try (ArrowSearchResponse response = new OpenSearchArrowClient(transport, limited).search(s -> s.index("logs"))) {
                response.loadNextBatch();
                fail("expected TransportException");
            } catch (TransportException e) {
                assertTrue(e.getMessage(), e.getMessage().contains("Invalid Arrow record batch"));
            }
            assertTrue("peak of " + limited.getPeakMemoryAllocation() + " bytes", limited.getPeakMemoryAllocation() < 64 * 1024);
            assertEquals(0, limited.getAllocatedMemory());
        }
    }

    @Test
    public void testHybridTransportSearchesOverGrpc() throws IOException {
        OpenSearchArrowClient hybrid = new OpenSearchArrowClient(new HybridTransport(transport, restTransportNeverCalled()), allocator);
        try (ArrowSearchResponse response = hybrid.search(s -> s.index("logs"))) {
            int loaded = 0;
            while (response.loadNextBatch()) {
                loaded++;
            }
            assertEquals(3, loaded);
        }
    }

    /** A REST transport the hybrid transport must not use for Arrow search; it only provides the JSON mapper. */
    private static org.opensearch.client.transport.OpenSearchTransport restTransportNeverCalled() {
        org.opensearch.client.json.JsonpMapper mapper = new JacksonJsonpMapper();
        return new org.opensearch.client.transport.OpenSearchTransport() {
            @Override
            public <RequestT, ResponseT, ErrorT> ResponseT performRequest(
                RequestT request,
                org.opensearch.client.transport.Endpoint<RequestT, ResponseT, ErrorT> endpoint,
                org.opensearch.client.transport.TransportOptions options
            ) {
                throw new AssertionError("REST was used");
            }

            @Override
            public <RequestT, ResponseT, ErrorT> java.util.concurrent.CompletableFuture<ResponseT> performRequestAsync(
                RequestT request,
                org.opensearch.client.transport.Endpoint<RequestT, ResponseT, ErrorT> endpoint,
                org.opensearch.client.transport.TransportOptions options
            ) {
                throw new AssertionError("REST was used");
            }

            @Override
            public org.opensearch.client.json.JsonpMapper jsonpMapper() {
                return mapper;
            }

            @Override
            public org.opensearch.client.transport.TransportOptions options() {
                return null;
            }

            @Override
            public void close() {}
        };
    }

    @Test
    public void testAMessageThatFailsToDecodeFailsTheSearchWithATransportException() throws IOException {
        // A payload too short to hold an Arrow IPC message.
        firstBatch = ArrowIpcMarshallerTest.payload(new byte[] { 1, 2, 3 });
        try (ArrowSearchResponse response = client().search(s -> s.index("logs"))) {
            try {
                response.loadNextBatch();
                fail("expected TransportException");
            } catch (TransportException e) {
                assertTrue(e.getMessage(), e.getMessage().startsWith("Malformed Arrow search message"));
            }
        }
    }

    @Test
    public void testASearchThatFailsAfterItsSummaryHasNoSummary() throws IOException {
        batches = 0;
        failAfterSummary = true;
        try (ArrowSearchResponse response = client().search(s -> s.index("logs"))) {
            try {
                response.loadNextBatch();
                fail("expected an exception");
            } catch (IOException | RuntimeException e) {
                // the call's failure
            }
            try {
                response.summary();
                fail("expected IllegalStateException");
            } catch (IllegalStateException e) {
                // the search did not succeed
            }
        }
    }

    private static boolean waitUntil(java.util.function.BooleanSupplier condition, long millis) throws InterruptedException {
        long deadline = System.nanoTime() + TimeUnit.MILLISECONDS.toNanos(millis);
        CountDownLatch never = new CountDownLatch(1);
        while (System.nanoTime() < deadline) {
            if (condition.getAsBoolean()) {
                return true;
            }
            never.await(10, TimeUnit.MILLISECONDS);
        }
        return condition.getAsBoolean();
    }
}
