/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen.openapi.rewriter;

import java.util.Collections;
import javax.annotation.Nonnull;
import org.opensearch.client.codegen.openapi.JsonPointer;
import org.opensearch.client.codegen.openapi.OpenApiResponse;
import org.opensearch.client.codegen.openapi.OpenApiSchema;
import org.opensearch.client.codegen.openapi.reference.RelativeRef;
import org.opensearch.client.codegen.openapi.walker.OpenApiVisitorBase;

public final class ResponseSchemaVisitor extends OpenApiVisitorBase {
    @Nonnull
    @Override
    public OpenApiResponse visitResponseEnd(@Nonnull OpenApiResponse response) {
        response.getContent().ifPresent(content -> {
            content.entries().forEach(entry -> {
                var mediaType = entry.getValue();
                var schema = mediaType.getSchema().orElse(null);

                if (schema != null
                    && schema.get$ref()
                        .map(RelativeRef::getPointer)
                        .flatMap(JsonPointer::getLastKey)
                        .map(k -> k.endsWith("Base"))
                        .orElse(false)) {
                    mediaType.setSchema(
                        OpenApiSchema.builder()
                            .withTypes(schema.getTypes().orElse(null))
                            .with$extends(schema)
                            .withProperties(Collections.emptyMap())
                            .withRequired(Collections.emptySet())
                            .build()
                    );
                }
            });
        });
        return response;
    }
}
