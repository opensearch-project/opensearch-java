/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.transport.grpc.translation;

import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import org.opensearch.client.opensearch._types.ErrorCause;
import org.opensearch.client.opensearch._types.ErrorResponse;
import org.opensearch.client.opensearch._types.OpenSearchException;
import org.opensearch.client.transport.TransportException;

/**
 * Converts gRPC status codes and errors to opensearch-java client exceptions.
 * <p>
 * Maps gRPC status codes to the same exception types that the REST transport raises,
 * so users' existing catch blocks work unchanged when switching to gRPC.
 * <p>
 * Mapping follows the gRPC-to-HTTP status code table from
 * opensearch-project/OpenSearch#18926 (RestToGrpcStatusConverter.java):
 * <ul>
 *   <li>OK (0)                → (no error)</li>
 *   <li>CANCELLED (1)         → TransportException</li>
 *   <li>UNKNOWN (2)           → TransportException</li>
 *   <li>INVALID_ARGUMENT (3)  → OpenSearchException (400)</li>
 *   <li>DEADLINE_EXCEEDED (4) → TransportException (timeout)</li>
 *   <li>NOT_FOUND (5)         → OpenSearchException (404)</li>
 *   <li>ALREADY_EXISTS (6)    → OpenSearchException (409)</li>
 *   <li>PERMISSION_DENIED (7) → TransportException (403)</li>
 *   <li>RESOURCE_EXHAUSTED(8) → TransportException (429)</li>
 *   <li>FAILED_PRECONDITION(9)→ OpenSearchException (412)</li>
 *   <li>ABORTED (10)          → OpenSearchException (409)</li>
 *   <li>OUT_OF_RANGE (11)     → OpenSearchException (400)</li>
 *   <li>UNIMPLEMENTED (12)    → UnsupportedOperationException</li>
 *   <li>INTERNAL (13)         → TransportException (500)</li>
 *   <li>UNAVAILABLE (14)      → TransportException (connection error)</li>
 *   <li>DATA_LOSS (15)        → TransportException (500)</li>
 *   <li>UNAUTHENTICATED (16)  → TransportException (401)</li>
 * </ul>
 */
public final class GrpcStatusConverter {

    private GrpcStatusConverter() {
        // utility class
    }

    /**
     * Converts a gRPC {@link StatusRuntimeException} to the appropriate opensearch-java exception.
     *
     * @param e the gRPC exception
     * @return the converted exception (TransportException, OpenSearchException, or UnsupportedOperationException)
     */
    static Exception convert(StatusRuntimeException e) {
        Status status = e.getStatus();
        Status.Code code = status.getCode();
        String description = status.getDescription() != null ? status.getDescription() : e.getMessage();

        switch (code) {
            case OK:
                // Should not happen — OK means success
                return null;

            case UNAVAILABLE:
                return new TransportException("gRPC connection unavailable: " + description, e);

            case DEADLINE_EXCEEDED:
                return new TransportException("gRPC request timed out: " + description, e);

            case UNAUTHENTICATED:
                return new TransportException("Authentication failed (401): " + description, e);

            case PERMISSION_DENIED:
                return new TransportException("Forbidden access (403): " + description, e);

            case RESOURCE_EXHAUSTED:
                return new TransportException("Rate limited (429): " + description, e);

            case INTERNAL:
                return new TransportException("Internal gRPC error (500): " + description, e);

            case DATA_LOSS:
                return new TransportException("gRPC data loss (500): " + description, e);

            case CANCELLED:
                return new TransportException("gRPC request cancelled: " + description, e);

            case UNKNOWN:
                return new TransportException("Unknown gRPC error: " + description, e);

            case UNIMPLEMENTED:
                return new UnsupportedOperationException("gRPC endpoint not implemented: " + description, e);

            case NOT_FOUND:
                return buildOpenSearchException(404, "not_found", description);

            case INVALID_ARGUMENT:
                return buildOpenSearchException(400, "illegal_argument_exception", description);

            case OUT_OF_RANGE:
                return buildOpenSearchException(400, "out_of_range_exception", description);

            case ALREADY_EXISTS:
                return buildOpenSearchException(409, "version_conflict_engine_exception", description);

            case ABORTED:
                return buildOpenSearchException(409, "aborted_exception", description);

            case FAILED_PRECONDITION:
                return buildOpenSearchException(412, "failed_precondition_exception", description);

            default:
                return new TransportException("gRPC error [" + code.name() + "]: " + description, e);
        }
    }

    /**
     * Throws the appropriate exception for the given gRPC error.
     * This is a convenience method that calls {@link #convert(StatusRuntimeException)} and throws.
     *
     * @param e the gRPC exception
     * @throws TransportException for transport-level errors
     * @throws OpenSearchException for server-side errors
     */
    public static void throwConverted(StatusRuntimeException e) throws TransportException {
        Exception converted = convert(e);
        if (converted instanceof TransportException) {
            throw (TransportException) converted;
        } else if (converted instanceof OpenSearchException) {
            throw (OpenSearchException) converted;
        } else if (converted instanceof UnsupportedOperationException) {
            throw (UnsupportedOperationException) converted;
        } else if (converted != null) {
            throw new TransportException("gRPC error: " + e.getMessage(), e);
        }
    }

    /**
     * Builds an OpenSearchException with a synthetic ErrorResponse for server-side errors
     * that have a clear HTTP status equivalent.
     */
    private static OpenSearchException buildOpenSearchException(int status, String type, String reason) {
        ErrorCause errorCause = ErrorCause.of(b -> b.type(type).reason(reason));
        ErrorResponse errorResponse = ErrorResponse.of(b -> b.status(status).error(errorCause));
        return new OpenSearchException(errorResponse);
    }

    /**
     * Returns the HTTP status code equivalent for a gRPC status code.
     *
     * @param code the gRPC status code
     * @return HTTP status code equivalent
     */
    public static int toHttpStatus(Status.Code code) {
        switch (code) {
            case OK:
                return 200;
            case CANCELLED:
                return 499;
            case UNKNOWN:
                return 500;
            case INVALID_ARGUMENT:
                return 400;
            case DEADLINE_EXCEEDED:
                return 408;
            case NOT_FOUND:
                return 404;
            case ALREADY_EXISTS:
                return 409;
            case PERMISSION_DENIED:
                return 403;
            case RESOURCE_EXHAUSTED:
                return 429;
            case FAILED_PRECONDITION:
                return 412;
            case ABORTED:
                return 409;
            case OUT_OF_RANGE:
                return 400;
            case UNIMPLEMENTED:
                return 501;
            case INTERNAL:
                return 500;
            case UNAVAILABLE:
                return 503;
            case DATA_LOSS:
                return 500;
            case UNAUTHENTICATED:
                return 401;
            default:
                return 500;
        }
    }

    /**
     * Determines if a gRPC status code represents a retryable error.
     * Transient errors like UNAVAILABLE and DEADLINE_EXCEEDED may succeed on retry.
     *
     * @param code the gRPC status code
     * @return true if the error is potentially retryable
     */
    public static boolean isRetryable(Status.Code code) {
        switch (code) {
            case UNAVAILABLE:
            case DEADLINE_EXCEEDED:
            case RESOURCE_EXHAUSTED:
            case ABORTED:
                return true;
            default:
                return false;
        }
    }
}
