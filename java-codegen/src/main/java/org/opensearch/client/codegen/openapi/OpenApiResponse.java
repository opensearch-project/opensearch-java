/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen.openapi;

import io.swagger.v3.oas.models.responses.ApiResponse;
import javax.annotation.Nonnull;

public class OpenApiResponse extends OpenApiOperationBodyElement<OpenApiResponse> {
    protected OpenApiResponse(@Nonnull OpenApiElement<?> parent, @Nonnull JsonPointer pointer, @Nonnull ApiResponse response) {
        super(parent, pointer, response.get$ref(), response.getContent(), OpenApiResponse.class);
    }
}
