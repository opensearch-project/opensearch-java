/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.transport.grpc.translation;

import org.opensearch.protobufs.OpType;
import org.opensearch.protobufs.Refresh;
import org.opensearch.protobufs.VersionType;
import org.opensearch.protobufs.WaitForActiveShardOptions;
import org.opensearch.protobufs.WaitForActiveShards;

/**
 * Maps opensearch-java client enum types to their protobuf equivalents.
 */
final class FieldMappingUtil {

    private FieldMappingUtil() {
        // utility class
    }

    /**
     * Maps the client Refresh enum to protobuf Refresh enum.
     *
     * @param refresh the client refresh value, or null
     * @return the protobuf Refresh enum value
     */
    public static Refresh mapRefresh(org.opensearch.client.opensearch._types.Refresh refresh) {
        if (refresh == null) {
            return Refresh.REFRESH_UNSPECIFIED;
        }
        switch (refresh) {
            case True:
                return Refresh.REFRESH_TRUE;
            case False:
                return Refresh.REFRESH_FALSE;
            case WaitFor:
                return Refresh.REFRESH_WAIT_FOR;
            default:
                return Refresh.REFRESH_UNSPECIFIED;
        }
    }

    /**
     * Maps the client VersionType enum to protobuf VersionType enum.
     *
     * @param versionType the client version type, or null
     * @return the protobuf VersionType enum value
     */
    public static VersionType mapVersionType(org.opensearch.client.opensearch._types.VersionType versionType) {
        if (versionType == null) {
            return VersionType.VERSION_TYPE_UNSPECIFIED;
        }
        switch (versionType) {
            case External:
                return VersionType.VERSION_TYPE_EXTERNAL;
            case ExternalGte:
                return VersionType.VERSION_TYPE_EXTERNAL_GTE;
            case Internal:
                // Internal is the default, no proto equivalent needed beyond unspecified
                return VersionType.VERSION_TYPE_UNSPECIFIED;
            default:
                return VersionType.VERSION_TYPE_UNSPECIFIED;
        }
    }

    /**
     * Maps the client OpType enum to protobuf OpType enum.
     *
     * @param opType the client op type, or null
     * @return the protobuf OpType enum value
     */
    public static OpType mapOpType(org.opensearch.client.opensearch._types.OpType opType) {
        if (opType == null) {
            return OpType.OP_TYPE_UNSPECIFIED;
        }
        switch (opType) {
            case Index:
                return OpType.OP_TYPE_INDEX;
            case Create:
                return OpType.OP_TYPE_CREATE;
            default:
                return OpType.OP_TYPE_UNSPECIFIED;
        }
    }

    /**
     * Maps the client WaitForActiveShards to protobuf WaitForActiveShards.
     *
     * The client type is a tagged union: either an integer count or the "all" option.
     *
     * @param waitForActiveShards the client WaitForActiveShards, or null
     * @return the protobuf WaitForActiveShards message, or null if input is null
     */
    public static WaitForActiveShards mapWaitForActiveShards(
        org.opensearch.client.opensearch._types.WaitForActiveShards waitForActiveShards
    ) {
        if (waitForActiveShards == null) {
            return null;
        }

        WaitForActiveShards.Builder builder = WaitForActiveShards.newBuilder();

        if (waitForActiveShards.isCount()) {
            builder.setCount(waitForActiveShards.count());
        } else if (waitForActiveShards.isOption()) {
            org.opensearch.client.opensearch._types.WaitForActiveShardOptions option = waitForActiveShards.option();
            if (option == org.opensearch.client.opensearch._types.WaitForActiveShardOptions.All) {
                builder.setOption(WaitForActiveShardOptions.WAIT_FOR_ACTIVE_SHARD_OPTIONS_ALL);
            } else {
                builder.setOption(WaitForActiveShardOptions.WAIT_FOR_ACTIVE_SHARD_OPTIONS_UNSPECIFIED);
            }
        }

        return builder.build();
    }

    /**
     * Converts a gRPC status code integer to an HTTP status code integer.
     * <p>
     * For OK (0), the result field disambiguates:
     * - "created" → 201
     * - "updated", "deleted", "noop" → 200
     *
     * @param grpcCode the gRPC status code (0-16)
     * @param result   the result string from the response item, may be null
     * @return the equivalent HTTP status code
     */
    public static int grpcStatusToHttpStatus(int grpcCode, String result) {
        switch (grpcCode) {
            case 0: // OK
                if ("created".equals(result)) {
                    return 201;
                }
                return 200;
            case 1:
                return 499; // CANCELLED
            case 2:
                return 500; // UNKNOWN
            case 3:
                return 400; // INVALID_ARGUMENT
            case 4:
                return 408; // DEADLINE_EXCEEDED
            case 5:
                return 404; // NOT_FOUND
            case 6:
                return 409; // ALREADY_EXISTS
            case 7:
                return 403; // PERMISSION_DENIED
            case 8:
                return 429; // RESOURCE_EXHAUSTED
            case 9:
                return 412; // FAILED_PRECONDITION
            case 10:
                return 409; // ABORTED
            case 11:
                return 400; // OUT_OF_RANGE
            case 12:
                return 501; // UNIMPLEMENTED
            case 13:
                return 500; // INTERNAL
            case 14:
                return 503; // UNAVAILABLE
            case 15:
                return 500; // DATA_LOSS
            case 16:
                return 401; // UNAUTHENTICATED
            default:
                return 500;
        }
    }
}
