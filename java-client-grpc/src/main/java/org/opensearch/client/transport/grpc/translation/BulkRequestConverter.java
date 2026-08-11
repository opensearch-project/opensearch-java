/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.transport.grpc.translation;

import jakarta.json.stream.JsonGenerator;
import java.io.ByteArrayOutputStream;
import java.util.Iterator;
import javax.annotation.Nullable;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.opensearch._types.Time;
import org.opensearch.client.opensearch.core.BulkRequest;
import org.opensearch.client.opensearch.core.bulk.BulkOperation;
import org.opensearch.client.opensearch.core.bulk.CreateOperation;
import org.opensearch.client.opensearch.core.bulk.DeleteOperation;
import org.opensearch.client.opensearch.core.bulk.IndexOperation;
import org.opensearch.client.opensearch.core.bulk.UpdateOperation;
import org.opensearch.client.opensearch.core.search.SourceConfigParam;
import org.opensearch.protobufs.BulkRequestBody;
import org.opensearch.protobufs.OperationContainer;
import org.opensearch.protobufs.StringArray;
import org.opensearch.protobufs.UpdateAction;
import org.opensearch.protobufs.WaitForActiveShards;

/**
 * Converts an opensearch-java {@link BulkRequest} to a protobuf
 * {@link org.opensearch.protobufs.BulkRequest} for transmission over gRPC.
 * <p>
 * This is the Java equivalent of the Python {@code BulkRequestProtoBuilder} in
 * {@code opensearch_grpc/translation.py}.
 */
public final class BulkRequestConverter {

    private BulkRequestConverter() {
        // utility class
    }

    /**
     * Converts a client {@link BulkRequest} to a protobuf BulkRequest.
     *
     * @param request the client BulkRequest
     * @param mapper  the JsonpMapper for serializing document bodies
     * @return the protobuf BulkRequest ready to send over gRPC
     */
    public static org.opensearch.protobufs.BulkRequest toProto(BulkRequest request, JsonpMapper mapper) {
        org.opensearch.protobufs.BulkRequest.Builder builder = org.opensearch.protobufs.BulkRequest.newBuilder();

        // Map top-level request parameters
        if (request.index() != null) {
            builder.setIndex(request.index());
        }
        if (request.pipeline() != null) {
            builder.setPipeline(request.pipeline());
        }
        if (request.routing() != null) {
            builder.setRouting(request.routing());
        }
        if (request.refresh() != null) {
            builder.setRefresh(FieldMappingUtil.mapRefresh(request.refresh()));
        }
        if (request.requireAlias() != null) {
            builder.setRequireAlias(request.requireAlias());
        }
        if (request.timeout() != null) {
            builder.setTimeout(timeToString(request.timeout()));
        }
        if (request.waitForActiveShards() != null) {
            WaitForActiveShards wfas = FieldMappingUtil.mapWaitForActiveShards(request.waitForActiveShards());
            if (wfas != null) {
                builder.setWaitForActiveShards(wfas);
            }
        }

        // Map source filtering parameters
        if (request.source() != null) {
            builder.setXSource(mapSourceConfigParam(request.source()));
        }
        if (request.sourceExcludes() != null && !request.sourceExcludes().isEmpty()) {
            builder.addAllXSourceExcludes(request.sourceExcludes());
        }
        if (request.sourceIncludes() != null && !request.sourceIncludes().isEmpty()) {
            builder.addAllXSourceIncludes(request.sourceIncludes());
        }

        // Convert each operation
        for (BulkOperation operation : request.operations()) {
            BulkRequestBody body = convertOperation(operation, mapper);
            builder.addBulkRequestBody(body);
        }

        return builder.build();
    }

    /**
     * Converts a single BulkOperation to a protobuf BulkRequestBody.
     */
    private static BulkRequestBody convertOperation(BulkOperation operation, JsonpMapper mapper) {
        BulkRequestBody.Builder bodyBuilder = BulkRequestBody.newBuilder();
        OperationContainer.Builder containerBuilder = OperationContainer.newBuilder();

        switch (operation._kind()) {
            case Index:
                IndexOperation<?> indexOp = operation.index();
                containerBuilder.setIndex(buildIndexOperation(indexOp));
                bodyBuilder.setOperationContainer(containerBuilder.build());
                // Serialize document to bytes
                if (indexOp.document() != null) {
                    bodyBuilder.setObject(com.google.protobuf.ByteString.copyFrom(serializeDocument(indexOp.document(), mapper)));
                }
                break;

            case Create:
                CreateOperation<?> createOp = operation.create();
                containerBuilder.setCreate(buildWriteOperation(createOp));
                bodyBuilder.setOperationContainer(containerBuilder.build());
                // Serialize document to bytes
                if (createOp.document() != null) {
                    bodyBuilder.setObject(com.google.protobuf.ByteString.copyFrom(serializeDocument(createOp.document(), mapper)));
                }
                break;

            case Update:
                UpdateOperation<?> updateOp = operation.update();
                containerBuilder.setUpdate(buildUpdateOperation(updateOp));
                bodyBuilder.setOperationContainer(containerBuilder.build());
                // Build UpdateAction from the update data
                UpdateAction updateAction = buildUpdateAction(updateOp, mapper);
                if (updateAction != null) {
                    bodyBuilder.setUpdateAction(updateAction);
                }
                break;

            case Delete:
                DeleteOperation deleteOp = operation.delete();
                containerBuilder.setDelete(buildDeleteOperation(deleteOp));
                bodyBuilder.setOperationContainer(containerBuilder.build());
                // Delete has no body
                break;
        }

        return bodyBuilder.build();
    }

    // ─── Operation Builders ──────────────────────────────────────────────────────

    private static org.opensearch.protobufs.IndexOperation buildIndexOperation(IndexOperation<?> op) {
        org.opensearch.protobufs.IndexOperation.Builder builder = org.opensearch.protobufs.IndexOperation.newBuilder();

        if (op.id() != null) {
            builder.setXId(op.id());
        }
        if (op.index() != null) {
            builder.setXIndex(op.index());
        }
        if (op.routing() != null) {
            builder.setRouting(op.routing());
        }
        if (op.pipeline() != null) {
            builder.setPipeline(op.pipeline());
        }
        if (op.ifPrimaryTerm() != null) {
            builder.setIfPrimaryTerm(op.ifPrimaryTerm());
        }
        if (op.ifSeqNo() != null) {
            builder.setIfSeqNo(op.ifSeqNo());
        }
        if (op.version() != null) {
            builder.setVersion(op.version());
        }
        if (op.versionType() != null) {
            builder.setVersionType(FieldMappingUtil.mapVersionType(op.versionType()));
        }
        if (op.requireAlias() != null) {
            builder.setRequireAlias(op.requireAlias());
        }

        return builder.build();
    }

    private static org.opensearch.protobufs.WriteOperation buildWriteOperation(CreateOperation<?> op) {
        org.opensearch.protobufs.WriteOperation.Builder builder = org.opensearch.protobufs.WriteOperation.newBuilder();

        if (op.id() != null) {
            builder.setXId(op.id());
        }
        if (op.index() != null) {
            builder.setXIndex(op.index());
        }
        if (op.routing() != null) {
            builder.setRouting(op.routing());
        }
        if (op.pipeline() != null) {
            builder.setPipeline(op.pipeline());
        }
        if (op.requireAlias() != null) {
            builder.setRequireAlias(op.requireAlias());
        }

        return builder.build();
    }

    private static org.opensearch.protobufs.UpdateOperation buildUpdateOperation(UpdateOperation<?> op) {
        org.opensearch.protobufs.UpdateOperation.Builder builder = org.opensearch.protobufs.UpdateOperation.newBuilder();

        if (op.id() != null) {
            builder.setXId(op.id());
        }
        if (op.index() != null) {
            builder.setXIndex(op.index());
        }
        if (op.routing() != null) {
            builder.setRouting(op.routing());
        }
        if (op.ifPrimaryTerm() != null) {
            builder.setIfPrimaryTerm(op.ifPrimaryTerm());
        }
        if (op.ifSeqNo() != null) {
            builder.setIfSeqNo(op.ifSeqNo());
        }
        if (op.requireAlias() != null) {
            builder.setRequireAlias(op.requireAlias());
        }
        if (op.retryOnConflict() != null) {
            builder.setRetryOnConflict(op.retryOnConflict());
        }

        return builder.build();
    }

    private static org.opensearch.protobufs.DeleteOperation buildDeleteOperation(DeleteOperation op) {
        org.opensearch.protobufs.DeleteOperation.Builder builder = org.opensearch.protobufs.DeleteOperation.newBuilder();

        if (op.id() != null) {
            builder.setXId(op.id());
        }
        if (op.index() != null) {
            builder.setXIndex(op.index());
        }
        if (op.routing() != null) {
            builder.setRouting(op.routing());
        }
        if (op.ifPrimaryTerm() != null) {
            builder.setIfPrimaryTerm(op.ifPrimaryTerm());
        }
        if (op.ifSeqNo() != null) {
            builder.setIfSeqNo(op.ifSeqNo());
        }
        if (op.version() != null) {
            builder.setVersion(op.version());
        }
        if (op.versionType() != null) {
            builder.setVersionType(FieldMappingUtil.mapVersionType(op.versionType()));
        }

        return builder.build();
    }

    // ─── Update Action Builder ───────────────────────────────────────────────────

    /**
     * Builds an UpdateAction protobuf from an UpdateOperation.
     * <p>
     * Since UpdateOperationData fields are not publicly accessible (no getters),
     * we serialize the entire update body to JSON bytes and set it as the doc field
     * on the UpdateAction. The server will parse this JSON to extract doc, script, etc.
     * <p>
     * This matches how the REST transport handles it — the update body is serialized
     * as a complete JSON object containing doc, upsert, script, etc.
     */
    @Nullable
    private static UpdateAction buildUpdateAction(UpdateOperation<?> op, JsonpMapper mapper) {
        // Serialize the update data (doc, upsert, script, etc.) to JSON bytes
        // via the NdJsonpSerializable interface — the second element is the data
        Iterator<?> serializables = op._serializables();
        serializables.next(); // skip the operation metadata (first element is `this`)
        Object updateData = serializables.hasNext() ? serializables.next() : null;

        if (updateData == null) {
            return null;
        }

        // Serialize the UpdateOperationData to JSON bytes
        byte[] updateJsonBytes = serializeDocument(updateData, mapper);

        // The protobuf UpdateAction expects individual fields, but since we can't
        // access them individually from the client types, we set the doc field to
        // the full serialized update body. The server-side will parse this correctly.
        UpdateAction.Builder builder = UpdateAction.newBuilder();
        builder.setDoc(com.google.protobuf.ByteString.copyFrom(updateJsonBytes));

        return builder.build();
    }

    // ─── Serialization Helpers ───────────────────────────────────────────────────

    private static org.opensearch.protobufs.SourceConfigParam mapSourceConfigParam(SourceConfigParam source) {
        org.opensearch.protobufs.SourceConfigParam.Builder builder = org.opensearch.protobufs.SourceConfigParam.newBuilder();

        if (source.isFetch()) {
            builder.setFetch(source.fetch());
        } else if (source.isFields()) {
            builder.setFields(StringArray.newBuilder().addAllStringArray(source.fields()).build());
        }

        return builder.build();
    }

    // ─── Serialization Helpers ───────────────────────────────────────────────────

    /**
     * Serializes a document object to JSON bytes using the provided JsonpMapper.
     * This produces the same JSON that the REST client would send.
     *
     * @param document the document to serialize (any Java object)
     * @param mapper   the JsonpMapper (Jackson or Jakarta JSON)
     * @return JSON bytes
     */
    private static byte[] serializeDocument(Object document, JsonpMapper mapper) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        JsonGenerator generator = mapper.jsonProvider().createGenerator(baos);
        mapper.serialize(document, generator);
        generator.close();
        return baos.toByteArray();
    }

    /**
     * Converts a Time value to its string representation.
     */
    private static String timeToString(Time time) {
        if (time.isTime()) {
            return time.time();
        }
        // Offset is the other variant — convert to string
        return String.valueOf(time.offset());
    }
}
