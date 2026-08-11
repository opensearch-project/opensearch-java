/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.transport.grpc.translation;

import java.util.ArrayList;
import java.util.List;
import org.opensearch.client.opensearch._types.ErrorCause;
import org.opensearch.client.opensearch._types.ShardStatistics;
import org.opensearch.client.opensearch.core.BulkResponse;
import org.opensearch.client.opensearch.core.bulk.BulkResponseItem;
import org.opensearch.client.opensearch.core.bulk.OperationType;
import org.opensearch.protobufs.Item;
import org.opensearch.protobufs.ResponseItem;

/**
 * Converts a protobuf {@link org.opensearch.protobufs.BulkResponse} to an
 * opensearch-java client {@link BulkResponse}.
 * <p>
 * This is the Java equivalent of the Python {@code ResponseConverter} class in
 * {@code opensearch_grpc/translation.py}.
 */
public final class BulkResponseConverter {

    private BulkResponseConverter() {
        // utility class
    }

    /**
     * Converts a protobuf BulkResponse to a client BulkResponse.
     *
     * @param protoResponse the protobuf BulkResponse from the gRPC server
     * @return the client BulkResponse matching the REST API format
     */
    public static BulkResponse fromProto(org.opensearch.protobufs.BulkResponse protoResponse) {
        BulkResponse.Builder builder = new BulkResponse.Builder();

        builder.took(protoResponse.getTook());
        builder.errors(protoResponse.getErrors());

        if (protoResponse.hasIngestTook()) {
            builder.ingestTook(protoResponse.getIngestTook());
        }

        List<BulkResponseItem> items = new ArrayList<>();
        for (Item item : protoResponse.getItemsList()) {
            BulkResponseItem responseItem = convertItem(item);
            if (responseItem != null) {
                items.add(responseItem);
            }
        }
        builder.items(items);

        return builder.build();
    }

    /**
     * Converts a single protobuf Item (oneof: create, delete, index, update) to a BulkResponseItem.
     */
    private static BulkResponseItem convertItem(Item item) {
        OperationType opType;
        ResponseItem responseItem;

        switch (item.getItemCase()) {
            case INDEX:
                opType = OperationType.Index;
                responseItem = item.getIndex();
                break;
            case CREATE:
                opType = OperationType.Create;
                responseItem = item.getCreate();
                break;
            case UPDATE:
                opType = OperationType.Update;
                responseItem = item.getUpdate();
                break;
            case DELETE:
                opType = OperationType.Delete;
                responseItem = item.getDelete();
                break;
            default:
                return null;
        }

        return convertResponseItem(responseItem, opType);
    }

    /**
     * Converts a protobuf ResponseItem to a client BulkResponseItem.
     */
    private static BulkResponseItem convertResponseItem(ResponseItem proto, OperationType opType) {
        BulkResponseItem.Builder builder = new BulkResponseItem.Builder();

        builder.operationType(opType);
        builder.index(proto.getXIndex());
        builder.status(proto.getStatus());

        if (proto.hasXId()) {
            builder.id(proto.getXId());
        }

        if (proto.hasResult()) {
            builder.result(proto.getResult());
        }

        if (proto.hasXVersion()) {
            builder.version(proto.getXVersion());
        }

        if (proto.hasXSeqNo()) {
            builder.seqNo(proto.getXSeqNo());
        }

        if (proto.hasXPrimaryTerm()) {
            builder.primaryTerm(proto.getXPrimaryTerm());
        }

        if (proto.hasForcedRefresh()) {
            builder.forcedRefresh(proto.getForcedRefresh());
        }

        // Error cause
        if (proto.hasError()) {
            builder.error(convertErrorCause(proto.getError()));
        }

        // Shard statistics
        if (proto.hasXShards()) {
            builder.shards(convertShardInfo(proto.getXShards()));
        }

        return builder.build();
    }

    /**
     * Converts a protobuf ErrorCause to a client ErrorCause.
     */
    private static ErrorCause convertErrorCause(org.opensearch.protobufs.ErrorCause protoError) {
        ErrorCause.Builder builder = ErrorCause.builder();
        builder.type(protoError.getType());
        if (protoError.hasReason()) {
            builder.reason(protoError.getReason());
        }
        if (protoError.hasCausedBy()) {
            builder.causedBy(convertErrorCause(protoError.getCausedBy()));
        }
        return builder.build();
    }

    /**
     * Converts protobuf ShardInfo to client ShardStatistics.
     */
    private static ShardStatistics convertShardInfo(org.opensearch.protobufs.ShardInfo protoShards) {
        ShardStatistics.Builder builder = ShardStatistics.builder();
        builder.total(protoShards.getTotal());
        builder.successful(protoShards.getSuccessful());
        builder.failed(protoShards.getFailed());
        return builder.build();
    }
}
