/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen.openapi;

import io.swagger.v3.oas.models.responses.ApiResponse;
import io.swagger.v3.oas.models.responses.ApiResponses;

public class OpenApiApiResponses extends OpenApiMapObject<HttpStatus, OpenApiApiResponse, ApiResponses, ApiResponse> {
    protected OpenApiApiResponses(OpenApiSpec parent, JsonPointer jsonPtr, ApiResponses inner) {
        super(parent, jsonPtr, inner, OpenApiApiResponse::new);
    }
}
