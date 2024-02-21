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
import org.opensearch.client.codegen.utils.Maps;
import org.opensearch.client.codegen.utils.MediaType;

public class OpenApiRequestBody extends OpenApiRefObject<OpenApiRequestBody, RequestBody> {
    protected OpenApiRequestBody(OpenApiSpec parent, RequestBody inner) {
        super(parent, inner, OpenApiRequestBody::new, api -> api.getComponents().getRequestBodies(), RequestBody::get$ref);
    }

    public Optional<OpenApiSchema> getContentSchema(MediaType mediaType) {
        return Maps.tryGet(getInner().getContent(), mediaType.toString()).map(m -> new OpenApiSchema(getParent(), m.getSchema()));
    }
}
