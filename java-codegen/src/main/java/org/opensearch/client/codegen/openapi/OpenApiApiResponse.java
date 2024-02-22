/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen.openapi;

import io.swagger.v3.oas.models.responses.ApiResponse;
import java.util.Optional;

public class OpenApiApiResponse extends OpenApiRefObject<OpenApiApiResponse, ApiResponse> {
    protected OpenApiApiResponse(OpenApiSpec parent, JsonPointer jsonPtr, ApiResponse inner) {
        super(parent, jsonPtr, inner, OpenApiApiResponse::new, api -> api.getComponents().getResponses(), ApiResponse::get$ref);
    }

    public Optional<OpenApiContent> getContent() {
        return childOpt("content", ApiResponse::getContent, OpenApiContent::new);
    }

    @Override
    protected OpenApiApiResponse getSelf() {
        return this;
    }
}
