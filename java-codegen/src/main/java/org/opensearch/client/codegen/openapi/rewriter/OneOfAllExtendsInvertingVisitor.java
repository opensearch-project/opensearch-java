/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen.openapi.rewriter;

import java.util.List;
import javax.annotation.Nonnull;
import org.opensearch.client.codegen.openapi.OpenApiSchema;
import org.opensearch.client.codegen.openapi.walker.OpenApiVisitorBase;

public class OneOfAllExtendsInvertingVisitor extends OpenApiVisitorBase {
    @Nonnull
    @Override
    public OpenApiSchema visitSchemaEnd(@Nonnull OpenApiSchema schema) {
        if (schema.hasOneOf()) {
            var oneOf = schema.getOneOf().orElseThrow();
            var count = oneOf.size();
            var newOneOf = new OpenApiSchema[count];
            OpenApiSchema $extends = null;

            for (var i = 0; i < count; ++i) {
                var s = oneOf.get(i);
                var s$extends = s.get$extends().orElse(null);

                if (s$extends == null) {
                    return schema;
                }

                if ($extends == null) {
                    $extends = s$extends;
                } else if (!s$extends.get$ref().orElseThrow().equals($extends.get$ref().orElseThrow())) {
                    return schema;
                }

                newOneOf[i] = s.toBuilder().with$extends((OpenApiSchema) null).build();
            }

            return schema.toBuilder().withOneOf(List.of(newOneOf)).with$extends($extends).build();
        }

        return schema;
    }
}
