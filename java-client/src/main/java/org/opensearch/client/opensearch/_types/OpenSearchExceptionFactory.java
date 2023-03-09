/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

/*
 * Modifications Copyright OpenSearch Contributors. See
 * GitHub history for details.
 */

package org.opensearch.client.opensearch._types;

public class OpenSearchExceptionFactory {

    private OpenSearchExceptionFactory() {
        //should be empty
    }

    public static <ErrorT> OpenSearchException createException(ErrorT error) {
        if (error instanceof ErrorResponse) {
            return new OpenSearchException((ErrorResponse) error);
        } else if (error instanceof ErrorStringResponse) {
            ErrorStringResponse errorStringResponse = (ErrorStringResponse) error;
            return new OpenSearchException(getErrorResponse(errorStringResponse.status(), "string_error", errorStringResponse.error()));
        } else {
            throw new OpenSearchException(getErrorResponse(500, "error_type", "Unknown error type: " + error.getClass()));
        }
    }

    private static ErrorResponse getErrorResponse(int status, String type, String reason) {
        return ErrorResponse.of(
                builder -> builder.status(status).error(
                        builder1 -> builder1.type(type).reason(reason)
                )
        );
    }
}
