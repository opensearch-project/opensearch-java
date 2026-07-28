/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.transport.grpc.ml;

/**
 * Status of a streamed ML response chunk.
 */
public enum MlStreamStatus {
    /** Status was not set or is not recognized by this client version. */
    UNSPECIFIED,
    /** The streaming task was cancelled. */
    CANCELLED,
    /** The streaming task completed successfully. */
    COMPLETED,
    /** The streaming task completed, but with an error. */
    COMPLETED_WITH_ERROR,
    /** The streaming task was created. */
    CREATED,
    /** The streaming task failed. */
    FAILED,
    /** The streaming task is in progress; more chunks may follow. */
    RUNNING;

    /**
     * Maps a protobuf {@code Status} to this enum. Unrecognized values —
     * including statuses added by newer servers — map to {@link #UNSPECIFIED}.
     *
     * @param status the protobuf status
     * @return the corresponding client status
     */
    public static MlStreamStatus fromProto(org.opensearch.protobufs.Status status) {
        if (status == null) {
            return UNSPECIFIED;
        }
        switch (status) {
            case STATUS_CANCELLED:
                return CANCELLED;
            case STATUS_COMPLETED:
                return COMPLETED;
            case STATUS_COMPLETED_WITH_ERROR:
                return COMPLETED_WITH_ERROR;
            case STATUS_CREATED:
                return CREATED;
            case STATUS_FAILED:
                return FAILED;
            case STATUS_RUNNING:
                return RUNNING;
            default:
                return UNSPECIFIED;
        }
    }
}
