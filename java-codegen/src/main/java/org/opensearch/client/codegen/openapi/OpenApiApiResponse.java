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
import org.opensearch.client.codegen.utils.Maps;
import org.opensearch.client.codegen.utils.MediaType;

public class OpenApiApiResponse extends OpenApiRefObject<OpenApiApiResponse, ApiResponse> {
    protected OpenApiApiResponse(OpenApiSpec parent, ApiResponse inner) {
        super(parent, inner, OpenApiApiResponse::new, api -> api.getComponents().getResponses(), ApiResponse::get$ref);
    }

    public Optional<OpenApiSchema> getContentSchema(MediaType mediaType) {
        return Maps.tryGet(getInner().getContent(), mediaType.toString())
                .map(m -> new OpenApiSchema(getParent(), m.getSchema()));
    }
}
