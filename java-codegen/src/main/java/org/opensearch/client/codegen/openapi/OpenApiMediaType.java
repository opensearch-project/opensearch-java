/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen.openapi;

import io.swagger.v3.oas.models.media.MediaType;
import io.swagger.v3.oas.models.media.Schema;
import java.util.Optional;
import java.util.function.Function;

public class OpenApiMediaType extends OpenApiObject<MediaType> {
    protected OpenApiMediaType(OpenApiSpec parent, JsonPointer jsonPtr, MediaType inner) {
        super(parent, jsonPtr, inner);
    }

    public Optional<OpenApiSchema> getSchema() {
        return childOpt("schema", (Function<MediaType, Schema<?>>) MediaType::getSchema, OpenApiSchema::new);
    }
}
