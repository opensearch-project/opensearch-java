/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen.openapi;

import io.swagger.v3.oas.models.parameters.RequestBody;
import java.util.Optional;

public class OpenApiRequestBody extends OpenApiRefObject<OpenApiRequestBody, RequestBody> {
    protected OpenApiRequestBody(OpenApiSpec parent, JsonPointer jsonPtr, RequestBody inner) {
        super(parent, jsonPtr, inner, OpenApiRequestBody::new, api -> api.getComponents().getRequestBodies(), RequestBody::get$ref);
    }

    public Optional<OpenApiContent> getContent() {
        return childOpt("content", RequestBody::getContent, OpenApiContent::new);
    }

    @Override
    protected OpenApiRequestBody getSelf() {
        return this;
    }
}
