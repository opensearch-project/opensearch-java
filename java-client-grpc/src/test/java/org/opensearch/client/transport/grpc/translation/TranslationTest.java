/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.transport.grpc.translation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.jackson3.JacksonJsonpMapper;
import org.opensearch.client.opensearch._types.OpenSearchException;
import org.opensearch.client.opensearch._types.Refresh;
import org.opensearch.client.opensearch._types.VersionType;
import org.opensearch.client.opensearch.core.BulkRequest;
import org.opensearch.client.opensearch.core.BulkResponse;
import org.opensearch.client.opensearch.core.bulk.BulkOperation;
import org.opensearch.client.opensearch.core.bulk.OperationType;
import org.opensearch.client.transport.TransportException;
import org.opensearch.protobufs.ErrorCause;
import org.opensearch.protobufs.Item;
import org.opensearch.protobufs.ResponseItem;
import org.opensearch.protobufs.ShardInfo;

/**
 * Combined unit tests for the gRPC translation layer:
 * BulkRequestConverter, BulkResponseConverter, FieldMappingUtil, GrpcStatusConverter.
 */
public class TranslationTest {

    private JsonpMapper mapper;

    @Before
    public void setUp() {
        mapper = new JacksonJsonpMapper();
    }

    // ═══ FieldMappingUtil Tests ══════════════════════════════════════════════════

    @Test
    public void testMapRefreshTrue() {
        assertEquals(org.opensearch.protobufs.Refresh.REFRESH_TRUE, FieldMappingUtil.mapRefresh(Refresh.True));
    }

    @Test
    public void testMapRefreshFalse() {
        assertEquals(org.opensearch.protobufs.Refresh.REFRESH_FALSE, FieldMappingUtil.mapRefresh(Refresh.False));
    }

    @Test
    public void testMapRefreshWaitFor() {
        assertEquals(org.opensearch.protobufs.Refresh.REFRESH_WAIT_FOR, FieldMappingUtil.mapRefresh(Refresh.WaitFor));
    }

    @Test
    public void testMapRefreshNull() {
        assertEquals(org.opensearch.protobufs.Refresh.REFRESH_UNSPECIFIED, FieldMappingUtil.mapRefresh(null));
    }

    @Test
    public void testMapVersionTypeExternal() {
        assertEquals(org.opensearch.protobufs.VersionType.VERSION_TYPE_EXTERNAL, FieldMappingUtil.mapVersionType(VersionType.External));
    }

    @Test
    public void testMapVersionTypeExternalGte() {
        assertEquals(
            org.opensearch.protobufs.VersionType.VERSION_TYPE_EXTERNAL_GTE,
            FieldMappingUtil.mapVersionType(VersionType.ExternalGte)
        );
    }

    @Test
    public void testMapVersionTypeNull() {
        assertEquals(org.opensearch.protobufs.VersionType.VERSION_TYPE_UNSPECIFIED, FieldMappingUtil.mapVersionType(null));
    }

    @Test
    public void testMapOpTypeIndex() {
        assertEquals(
            org.opensearch.protobufs.OpType.OP_TYPE_INDEX,
            FieldMappingUtil.mapOpType(org.opensearch.client.opensearch._types.OpType.Index)
        );
    }

    @Test
    public void testMapOpTypeCreate() {
        assertEquals(
            org.opensearch.protobufs.OpType.OP_TYPE_CREATE,
            FieldMappingUtil.mapOpType(org.opensearch.client.opensearch._types.OpType.Create)
        );
    }

    @Test
    public void testMapOpTypeNull() {
        assertEquals(org.opensearch.protobufs.OpType.OP_TYPE_UNSPECIFIED, FieldMappingUtil.mapOpType(null));
    }

    // ═══ GrpcStatusConverter Tests ═══════════════════════════════════════════════

    @Test
    public void testConvertUnavailable() {
        assertTrue(
            GrpcStatusConverter.convert(
                new StatusRuntimeException(Status.UNAVAILABLE.withDescription("down"))
            ) instanceof TransportException
        );
    }

    @Test
    public void testConvertDeadline() {
        assertTrue(GrpcStatusConverter.convert(new StatusRuntimeException(Status.DEADLINE_EXCEEDED)) instanceof TransportException);
    }

    @Test
    public void testConvertUnauthenticated() {
        assertTrue(
            GrpcStatusConverter.convert(
                new StatusRuntimeException(Status.UNAUTHENTICATED.withDescription("bad"))
            ) instanceof TransportException
        );
    }

    @Test
    public void testConvertNotFound() {
        Exception e = GrpcStatusConverter.convert(new StatusRuntimeException(Status.NOT_FOUND.withDescription("x")));
        assertTrue(e instanceof OpenSearchException);
        assertEquals(404, ((OpenSearchException) e).status());
    }

    @Test
    public void testConvertInvalidArg() {
        Exception e = GrpcStatusConverter.convert(new StatusRuntimeException(Status.INVALID_ARGUMENT.withDescription("x")));
        assertTrue(e instanceof OpenSearchException);
        assertEquals(400, ((OpenSearchException) e).status());
    }

    @Test
    public void testConvertAlreadyExists() {
        Exception e = GrpcStatusConverter.convert(new StatusRuntimeException(Status.ALREADY_EXISTS.withDescription("x")));
        assertTrue(e instanceof OpenSearchException);
        assertEquals(409, ((OpenSearchException) e).status());
    }

    @Test
    public void testConvertUnimplemented() {
        assertTrue(
            GrpcStatusConverter.convert(
                new StatusRuntimeException(Status.UNIMPLEMENTED.withDescription("x"))
            ) instanceof UnsupportedOperationException
        );
    }

    @Test
    public void testConvertOkReturnsNull() {
        assertNull(GrpcStatusConverter.convert(new StatusRuntimeException(Status.OK)));
    }

    @Test
    public void testIsNotRetryableNotFound() {
        assertFalse(GrpcStatusConverter.isRetryable(Status.Code.NOT_FOUND));
    }

    @Test
    public void testIsNotRetryableUnauth() {
        assertFalse(GrpcStatusConverter.isRetryable(Status.Code.UNAUTHENTICATED));
    }

    @Test(expected = TransportException.class)
    public void testThrowConvertedUnavailable() throws TransportException {
        GrpcStatusConverter.throwConverted(new StatusRuntimeException(Status.UNAVAILABLE));
    }

    @Test(expected = OpenSearchException.class)
    public void testThrowConvertedNotFound() throws TransportException {
        GrpcStatusConverter.throwConverted(new StatusRuntimeException(Status.NOT_FOUND.withDescription("x")));
    }

    // ═══ BulkRequestConverter Tests ══════════════════════════════════════════════

    @Test
    public void testIndexOperationBasic() {
        BulkRequest request = new BulkRequest.Builder().index("test-index")
            .operations(op -> op.index(idx -> idx.id("1").document(new Doc("hello", 42))))
            .build();
        org.opensearch.protobufs.BulkRequest proto = BulkRequestConverter.toProto(request, mapper);
        assertEquals("test-index", proto.getIndex());
        assertEquals(1, proto.getBulkRequestBodyCount());
        assertTrue(proto.getBulkRequestBody(0).getOperationContainer().hasIndex());
        assertEquals("1", proto.getBulkRequestBody(0).getOperationContainer().getIndex().getXId());
        assertTrue(proto.getBulkRequestBody(0).hasObject());
    }

    @Test
    public void testCreateOperation() {
        BulkRequest request = new BulkRequest.Builder().operations(op -> op.create(c -> c.id("2").index("idx").document(new Doc("w", 99))))
            .build();
        org.opensearch.protobufs.BulkRequest proto = BulkRequestConverter.toProto(request, mapper);
        assertTrue(proto.getBulkRequestBody(0).getOperationContainer().hasCreate());
    }

    @Test
    public void testDeleteOperation() {
        BulkRequest request = new BulkRequest.Builder().operations(op -> op.delete(d -> d.id("3").index("idx"))).build();
        org.opensearch.protobufs.BulkRequest proto = BulkRequestConverter.toProto(request, mapper);
        assertTrue(proto.getBulkRequestBody(0).getOperationContainer().hasDelete());
        assertFalse(proto.getBulkRequestBody(0).hasObject());
    }

    @Test
    public void testUpdateOperation() {
        BulkRequest request = new BulkRequest.Builder().operations(
            op -> op.update(u -> u.id("4").index("idx").retryOnConflict(3).document(new Doc("u", 1)))
        ).build();
        org.opensearch.protobufs.BulkRequest proto = BulkRequestConverter.toProto(request, mapper);
        assertTrue(proto.getBulkRequestBody(0).getOperationContainer().hasUpdate());
        assertEquals(3, proto.getBulkRequestBody(0).getOperationContainer().getUpdate().getRetryOnConflict());
        assertTrue(proto.getBulkRequestBody(0).hasUpdateAction());
    }

    @Test
    public void testTopLevelRefresh() {
        BulkRequest request = new BulkRequest.Builder().refresh(Refresh.WaitFor)
            .operations(op -> op.delete(d -> d.id("1").index("x")))
            .build();
        assertEquals(org.opensearch.protobufs.Refresh.REFRESH_WAIT_FOR, BulkRequestConverter.toProto(request, mapper).getRefresh());
    }

    @Test
    public void testMultipleMixedOps() {
        List<BulkOperation> ops = new ArrayList<>();
        ops.add(new BulkOperation.Builder().index(idx -> idx.id("1").index("i").document(new Doc("a", 1))).build());
        ops.add(new BulkOperation.Builder().create(c -> c.id("2").index("i").document(new Doc("b", 2))).build());
        ops.add(new BulkOperation.Builder().update(u -> u.id("3").index("i").document(new Doc("c", 3))).build());
        ops.add(new BulkOperation.Builder().delete(d -> d.id("4").index("i")).build());
        BulkRequest request = new BulkRequest.Builder().index("i").operations(ops).build();
        org.opensearch.protobufs.BulkRequest proto = BulkRequestConverter.toProto(request, mapper);
        assertEquals(4, proto.getBulkRequestBodyCount());
        assertTrue(proto.getBulkRequestBody(0).getOperationContainer().hasIndex());
        assertTrue(proto.getBulkRequestBody(1).getOperationContainer().hasCreate());
        assertTrue(proto.getBulkRequestBody(2).getOperationContainer().hasUpdate());
        assertTrue(proto.getBulkRequestBody(3).getOperationContainer().hasDelete());
    }

    @Test
    public void testDocSerialization() {
        BulkRequest request = new BulkRequest.Builder().operations(
            op -> op.index(idx -> idx.id("1").index("t").document(new Doc("hello world", 42)))
        ).build();
        byte[] bytes = BulkRequestConverter.toProto(request, mapper).getBulkRequestBody(0).getObject().toByteArray();
        String json = new String(bytes);
        assertTrue(json.contains("hello world"));
        assertTrue(json.contains("42"));
    }

    // ═══ BulkResponseConverter Tests ═════════════════════════════════════════════

    @Test
    public void testBasicSuccessResponse() {
        org.opensearch.protobufs.BulkResponse proto = org.opensearch.protobufs.BulkResponse.newBuilder()
            .setTook(50)
            .setErrors(false)
            .addItems(
                Item.newBuilder()
                    .setIndex(
                        ResponseItem.newBuilder()
                            .setXIndex("idx")
                            .setXId("1")
                            .setStatus(0)
                            .setResult("created")
                            .setXVersion(1)
                            .setXSeqNo(0)
                            .setXPrimaryTerm(1)
                            .build()
                    )
                    .build()
            )
            .build();
        BulkResponse resp = BulkResponseConverter.fromProto(proto);
        assertEquals(50, resp.took());
        assertFalse(resp.errors());
        assertEquals(1, resp.items().size());
        assertEquals(OperationType.Index, resp.items().get(0).operationType());
        assertEquals("created", resp.items().get(0).result());
    }

    @Test
    public void testResponseWithErrors() {
        org.opensearch.protobufs.BulkResponse proto = org.opensearch.protobufs.BulkResponse.newBuilder()
            .setTook(30)
            .setErrors(true)
            .addItems(
                Item.newBuilder()
                    .setIndex(ResponseItem.newBuilder().setXIndex("idx").setXId("1").setStatus(0).setResult("created").build())
                    .build()
            )
            .addItems(
                Item.newBuilder()
                    .setUpdate(
                        ResponseItem.newBuilder()
                            .setXIndex("idx")
                            .setXId("2")
                            .setStatus(3)
                            .setError(ErrorCause.newBuilder().setType("mapper_parsing_exception").setReason("failed").build())
                            .build()
                    )
                    .build()
            )
            .build();
        BulkResponse resp = BulkResponseConverter.fromProto(proto);
        assertTrue(resp.errors());
        assertNull(resp.items().get(0).error());
        assertNotNull(resp.items().get(1).error());
        assertEquals("mapper_parsing_exception", resp.items().get(1).error().type());
    }

    @Test
    public void testAllOperationTypes() {
        org.opensearch.protobufs.BulkResponse proto = org.opensearch.protobufs.BulkResponse.newBuilder()
            .setTook(10)
            .setErrors(false)
            .addItems(
                Item.newBuilder()
                    .setIndex(ResponseItem.newBuilder().setXIndex("i").setXId("1").setStatus(0).setResult("created").build())
                    .build()
            )
            .addItems(
                Item.newBuilder()
                    .setCreate(ResponseItem.newBuilder().setXIndex("i").setXId("2").setStatus(0).setResult("created").build())
                    .build()
            )
            .addItems(
                Item.newBuilder()
                    .setUpdate(ResponseItem.newBuilder().setXIndex("i").setXId("3").setStatus(0).setResult("updated").build())
                    .build()
            )
            .addItems(
                Item.newBuilder()
                    .setDelete(ResponseItem.newBuilder().setXIndex("i").setXId("4").setStatus(0).setResult("deleted").build())
                    .build()
            )
            .build();
        BulkResponse resp = BulkResponseConverter.fromProto(proto);
        assertEquals(OperationType.Index, resp.items().get(0).operationType());
        assertEquals(OperationType.Create, resp.items().get(1).operationType());
        assertEquals(OperationType.Update, resp.items().get(2).operationType());
        assertEquals(OperationType.Delete, resp.items().get(3).operationType());
    }

    @Test
    public void testResponseWithShards() {
        org.opensearch.protobufs.BulkResponse proto = org.opensearch.protobufs.BulkResponse.newBuilder()
            .setTook(1)
            .setErrors(false)
            .addItems(
                Item.newBuilder()
                    .setIndex(
                        ResponseItem.newBuilder()
                            .setXIndex("i")
                            .setXId("1")
                            .setStatus(0)
                            .setXShards(ShardInfo.newBuilder().setTotal(2).setSuccessful(2).setFailed(0).build())
                            .build()
                    )
                    .build()
            )
            .build();
        BulkResponse resp = BulkResponseConverter.fromProto(proto);
        assertEquals(2, resp.items().get(0).shards().total());
        assertEquals(2, resp.items().get(0).shards().successful());
    }

    @Test
    public void testIngestTook() {
        org.opensearch.protobufs.BulkResponse proto = org.opensearch.protobufs.BulkResponse.newBuilder()
            .setTook(100)
            .setErrors(false)
            .setIngestTook(25)
            .addItems(Item.newBuilder().setIndex(ResponseItem.newBuilder().setXIndex("i").setXId("1").setStatus(0).build()).build())
            .build();
        assertEquals(Long.valueOf(25L), BulkResponseConverter.fromProto(proto).ingestTook());
    }

    // ═══ Helper ══════════════════════════════════════════════════════════════════

    public static class Doc {
        private String name;
        private int value;

        public Doc() {}

        public Doc(String n, int v) {
            name = n;
            value = v;
        }

        public String getName() {
            return name;
        }

        public void setName(String n) {
            name = n;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int v) {
            value = v;
        }
    }
}
