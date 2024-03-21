/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen.openapi;

import io.swagger.v3.oas.models.media.MediaType;
import java.util.Optional;

public class OpenApiMediaType extends OpenApiObject<MediaType> {
    protected OpenApiMediaType(OpenApiSpec parent, JsonPointer jsonPtr, MediaType inner) {
        super(parent, jsonPtr, inner);
    }

    public Optional<OpenApiSchema> getSchema() {
        return childOpt("schema", MediaType::getSchema, OpenApiSchema::new);
    }
}
