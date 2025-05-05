/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen.openapi.rewriter;

import javax.annotation.Nonnull;
import org.opensearch.client.codegen.openapi.OpenApiSchema;
import org.opensearch.client.codegen.openapi.walker.OpenApiVisitorBase;

public final class ExtendsAllOfRewritingVisitor extends OpenApiVisitorBase {
    @Nonnull
    @Override
    public OpenApiSchema visitSchemaEnd(@Nonnull OpenApiSchema schema) {
        if (schema.hasAllOf()) {
            var allOf = schema.getAllOf().orElseThrow();
            if (allOf.size() == 2 && allOf.get(0).has$ref()) {
                String description = schema.getDescription().orElse(null);
                schema = allOf.get(1);
                schema.set$extends(allOf.get(0));
                if (description != null) {
                    schema.setDescription(description);
                }
            }
        }

        return schema;
    }
}
