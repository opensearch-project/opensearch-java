/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.opensearch._helpers.bulk;

import jakarta.json.stream.JsonGenerator;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import javax.annotation.Nullable;
import org.junit.Assert;
import org.junit.Test;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.JsonpSerializer;
import org.opensearch.client.json.NdJsonpSerializable;
import org.opensearch.client.json.jackson.JacksonJsonpMapper;
import org.opensearch.client.opensearch.OpenSearchAsyncClient;
import org.opensearch.client.opensearch._types.Script;
import org.opensearch.client.opensearch._types.VersionType;
import org.opensearch.client.opensearch.core.BulkRequest;
import org.opensearch.client.opensearch.core.BulkResponse;
import org.opensearch.client.opensearch.core.bulk.BulkOperation;
import org.opensearch.client.opensearch.core.bulk.BulkResponseItem;
import org.opensearch.client.opensearch.core.bulk.OperationType;
import org.opensearch.client.opensearch.core.bulk.UpdateOperation;
import org.opensearch.client.transport.BackoffPolicy;
import org.opensearch.client.transport.Endpoint;
import org.opensearch.client.transport.OpenSearchTransport;
import org.opensearch.client.transport.TransportOptions;
import org.opensearch.client.util.BinaryData;
import org.opensearch.client.util.ObjectBuilder;

public class IngesterOperationTest extends Assert {

    /**
     * Maximum allowed difference between the estimated and the actual serialized size of an operation. The estimate
     * does not account for the operation type wrapper (e.g. <code>{"update":</code>) and approximates numbers.
     */
    private static final long SIZE_TOLERANCE = 16;

    private static final JsonpMapper MAPPER = new JacksonJsonpMapper();

    public static class AppData {
        private int intValue;
        private String msg;

        public AppData() {}

        AppData(int intValue, String msg) {
            this.intValue = intValue;
            this.msg = msg;
        }

        public int getIntValue() {
            return intValue;
        }

        public void setIntValue(int intValue) {
            this.intValue = intValue;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }
    }

    private static final AppData DOC = new AppData(42, "a document with some text in it");
    private static final AppData UPSERT = new AppData(1, "the upsert document");
    private static final Script SCRIPT = Script.of(s -> s.inline(i -> i.source("ctx._source.intValue += 1")));

    private static List<BulkOperation> updateVariants() {
        final var variants = new ArrayList<Function<UpdateOperation.Builder<AppData>, ObjectBuilder<UpdateOperation<AppData>>>>();
        variants.add(u -> u.document(DOC));
        variants.add(u -> u.document(DOC).upsert(UPSERT));
        variants.add(u -> u.document(DOC).docAsUpsert(true));
        variants.add(u -> u.script(SCRIPT).upsert(UPSERT).scriptedUpsert(true));
        variants.add(u -> u.document(DOC).detectNoop(false));
        variants.add(u -> u.script(SCRIPT));
        variants.add(u -> u.document(DOC).source(sc -> sc.filter(f -> f.includes("msg"))));
        variants.add(u -> u.document(DOC).source(sc -> sc.fetch(true)));
        variants.add(u -> u.document(DOC).requireAlias(true).retryOnConflict(3));
        variants.add(
            u -> u.document(DOC)
                .upsert(UPSERT)
                .docAsUpsert(false)
                .scriptedUpsert(false)
                .detectNoop(true)
                .requireAlias(false)
                .retryOnConflict(12)
                .source(sc -> sc.fetch(false))
                .routing("some-routing")
                .ifSeqNo(123L)
                .ifPrimaryTerm(4L)
        );
        variants.add(u -> u.document(DOC).version(7L).versionType(VersionType.External));

        final var operations = new ArrayList<BulkOperation>();
        for (final var variant : variants) {
            operations.add(BulkOperation.of(bo -> bo.<AppData>update(u -> variant.apply(u.index("test-index").id("doc-1")))));
        }
        return operations;
    }

    private static <T> IngesterOperation<T> ingesterOperation(BulkOperation operation) {
        return IngesterOperation.of(new RetryableBulkOperation<>(operation, null, null), MAPPER);
    }

    @Test
    public void updateIsConvertedToBinary() {
        for (final var operation : updateVariants()) {
            final var converted = ingesterOperation(operation).operation().update().data();
            if (converted.document() != null) {
                assertTrue(converted.document() instanceof BinaryData);
            }
            if (converted.upsert() != null) {
                assertTrue(converted.upsert() instanceof BinaryData);
            }
        }
    }

    @Test
    public void updateSerializationIsUnchanged() {
        for (final var operation : updateVariants()) {
            final var converted = ingesterOperation(operation).operation();
            assertEquals(ndjson(operation), ndjson(converted));
        }
    }

    @Test
    public void updateSizeIsConsistentWithSerializedSize() {
        for (final var operation : updateVariants()) {
            assertSizeConsistent(operation);
        }
    }

    @Test
    public void indexAndCreateSizeIsConsistentWithSerializedSize() {
        assertSizeConsistent(BulkOperation.of(bo -> bo.index(i -> i.index("test-index").id("doc-1").document(DOC))));
        assertSizeConsistent(BulkOperation.of(bo -> bo.create(c -> c.index("test-index").id("doc-1").document(DOC))));
    }

    @Test
    public void updateSizeAccountsForDocumentSize() {
        final var small = BulkOperation.of(bo -> bo.update(u -> u.index("test-index").id("doc-1").document(new AppData(1, "x"))));
        final var largeMsg = "x".repeat(10_000);
        final var large = BulkOperation.of(bo -> bo.update(u -> u.index("test-index").id("doc-1").document(new AppData(1, largeMsg))));

        assertSizeConsistent(small);
        assertSizeConsistent(large);
        assertEquals(largeMsg.length() - 1, ingesterOperation(large).size() - ingesterOperation(small).size());
    }

    @Test
    public void binaryUpdateDocumentsAreReused() {
        final var binaryDoc = BinaryData.of(DOC, MAPPER);
        final var binaryUpsert = BinaryData.of(UPSERT, MAPPER);
        final var operation = BulkOperation.of(
            bo -> bo.update(u -> u.index("test-index").id("doc-1").document(binaryDoc).upsert(binaryUpsert).docAsUpsert(true))
        );

        final var ingesterOp = ingesterOperation(operation);

        assertSame(operation, ingesterOp.operation());
        assertSame(binaryDoc, ingesterOp.operation().update().data().document());
        assertSame(binaryUpsert, ingesterOp.operation().update().data().upsert());
        assertSizeConsistent(operation);
    }

    @Test
    public void updateWithoutDocumentsIsReused() {
        final var operation = BulkOperation.of(bo -> bo.update(u -> u.index("test-index").id("doc-1").script(SCRIPT)));

        final var ingesterOp = ingesterOperation(operation);

        assertSame(operation, ingesterOp.operation());
        assertSizeConsistent(operation);
    }

    @Test
    public void convertedUpdateIsNotConvertedAgain() {
        final var converted = ingesterOperation(updateVariants().get(1));

        final var reconverted = IngesterOperation.of(converted.repeatableOperation(), MAPPER);

        assertSame(converted.operation(), reconverted.operation());
        assertEquals(converted.size(), reconverted.size());
    }

    @Test
    public void updateHonoursCustomDocumentSerializer() {
        final JsonpSerializer<AppData> serializer = (value, generator, mapper) -> {
            generator.writeStartObject();
            generator.write("custom", value.getMsg().toUpperCase());
            generator.writeEnd();
        };
        final var operation = BulkOperation.of(
            bo -> bo.<AppData>update(u -> u.index("test-index").id("doc-1").document(DOC).upsert(UPSERT).tDocumentSerializer(serializer))
        );

        final var converted = ingesterOperation(operation).operation();

        assertEquals(ndjson(operation), ndjson(converted));
        assertTrue(ndjson(converted).contains("\"doc\":{\"custom\":\"A DOCUMENT WITH SOME TEXT IN IT\"}"));
        assertSizeConsistent(operation);
    }

    @Test
    public void retriedUpdatesAreResentUnchanged() throws Exception {
        final var operations = updateVariants();
        final var expected = operations.stream().map(IngesterOperationTest::ndjson).sorted().toList();

        final var transport = new RetryTestTransport();
        final var ingester = BulkIngester.<Void>of(
            b -> b.client(new OpenSearchAsyncClient(transport))
                .maxOperations(operations.size())
                .backoffPolicy(BackoffPolicy.constantBackoff(10L, 3))
        );

        try {
            operations.forEach(ingester::add);
            ingester.flush();

            // Retried operations may be spread over several requests
            final var deadline = System.nanoTime() + TimeUnit.SECONDS.toNanos(10);
            while (transport.retriedOperations().size() < operations.size()) {
                if (System.nanoTime() - deadline > 0) {
                    fail("Timed out waiting for the retries, got " + transport.retriedOperations().size() + " retried operations");
                }
                Thread.sleep(5);
            }
        } finally {
            ingester.close();
            transport.close();
        }

        assertEquals(expected, transport.requests.get(0).stream().sorted().toList());
        assertEquals(expected, transport.retriedOperations().stream().sorted().toList());
    }

    private static void assertSizeConsistent(BulkOperation operation) {
        final var estimated = ingesterOperation(operation).size();
        final var actual = ndjson(operation).getBytes(StandardCharsets.UTF_8).length;
        assertTrue(
            "Estimated size " + estimated + " too far from actual size " + actual + " for " + ndjson(operation),
            Math.abs(actual - estimated) <= SIZE_TOLERANCE
        );
    }

    private static String ndjson(BulkOperation operation) {
        return ndjson(Collections.singletonList(operation));
    }

    private static String ndjson(List<BulkOperation> operations) {
        final var baos = new ByteArrayOutputStream();
        for (final var operation : operations) {
            writeNdJson(operation, baos);
        }
        return baos.toString(StandardCharsets.UTF_8);
    }

    /**
     * Same as the NDJSON serialization done by the transports.
     */
    private static void writeNdJson(NdJsonpSerializable value, ByteArrayOutputStream baos) {
        final Iterator<?> values = value._serializables();
        while (values.hasNext()) {
            final var item = values.next();
            if (item instanceof NdJsonpSerializable && item != value) {
                writeNdJson((NdJsonpSerializable) item, baos);
            } else {
                final JsonGenerator generator = MAPPER.jsonProvider().createGenerator(baos);
                MAPPER.serialize(item, generator);
                generator.close();
                baos.write('\n');
            }
        }
    }

    /**
     * Fails all operations of the first request with a 429 and succeeds afterwards, recording the NDJSON of every
     * operation of every request.
     */
    private static class RetryTestTransport implements OpenSearchTransport {
        final List<List<String>> requests = new CopyOnWriteArrayList<>();
        private final AtomicInteger requestCount = new AtomicInteger();
        private final ExecutorService executor = Executors.newCachedThreadPool();

        List<String> retriedOperations() {
            return requests.stream().skip(1).flatMap(List::stream).toList();
        }

        @Override
        public <RequestT, ResponseT, ErrorT> ResponseT performRequest(
            RequestT request,
            Endpoint<RequestT, ResponseT, ErrorT> endpoint,
            @Nullable TransportOptions options
        ) {
            throw new UnsupportedOperationException();
        }

        @Override
        public <RequestT, ResponseT, ErrorT> CompletableFuture<ResponseT> performRequestAsync(
            RequestT request,
            Endpoint<RequestT, ResponseT, ErrorT> endpoint,
            @Nullable TransportOptions options
        ) {
            final var bulk = (BulkRequest) request;
            requests.add(bulk.operations().stream().map(IngesterOperationTest::ndjson).toList());
            final var fail = requestCount.getAndIncrement() == 0;

            final var items = new ArrayList<BulkResponseItem>();
            for (int i = 0; i < bulk.operations().size(); i++) {
                if (fail) {
                    items.add(
                        BulkResponseItem.of(
                            r -> r.index("test-index")
                                .status(429)
                                .operationType(OperationType.Update)
                                .error(e -> e.type("es_rejected_execution_exception").reason("too many requests"))
                        )
                    );
                } else {
                    items.add(BulkResponseItem.of(r -> r.index("test-index").status(200).operationType(OperationType.Update)));
                }
            }

            final var response = new CompletableFuture<BulkResponse>();
            executor.submit(() -> response.complete(BulkResponse.of(r -> r.errors(fail).items(items).took(1))));

            @SuppressWarnings("unchecked")
            final var result = (CompletableFuture<ResponseT>) (CompletableFuture<?>) response;
            return result;
        }

        @Override
        public JsonpMapper jsonpMapper() {
            return MAPPER;
        }

        @Override
        public TransportOptions options() {
            return null;
        }

        @Override
        public void close() throws IOException {
            executor.shutdown();
            try {
                executor.awaitTermination(1, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
