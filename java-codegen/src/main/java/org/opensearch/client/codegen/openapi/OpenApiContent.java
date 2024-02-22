/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen.openapi;

import io.swagger.v3.oas.models.media.Content;
import io.swagger.v3.oas.models.media.MediaType;

public class OpenApiContent extends OpenApiMapObject<MimeType, OpenApiMediaType, Content, MediaType> {
    protected OpenApiContent(OpenApiSpec parent, JsonPointer jsonPtr, Content inner) {
        super(parent, jsonPtr, inner, OpenApiMediaType::new);
    }
}
