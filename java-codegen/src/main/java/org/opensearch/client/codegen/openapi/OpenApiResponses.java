/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen.openapi;

import io.swagger.v3.oas.models.responses.ApiResponses;
import javax.annotation.Nonnull;

public class OpenApiResponses extends OpenApiMapElement<OpenApiResponses, HttpStatusCode, OpenApiResponse> {
    protected OpenApiResponses(@Nonnull OpenApiOperation parent, @Nonnull JsonPointer pointer, @Nonnull ApiResponses responses) {
        super(parent, pointer, responses, HttpStatusCode::from, OpenApiResponse::new);
    }
}
