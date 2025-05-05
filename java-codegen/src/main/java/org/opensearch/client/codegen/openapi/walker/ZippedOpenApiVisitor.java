/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen.openapi.walker;

import javax.annotation.Nullable;
import org.opensearch.client.codegen.openapi.OpenApiSchema;

public interface ZippedOpenApiVisitor {
    void visitSchemaStart(@Nullable OpenApiSchema left, @Nullable OpenApiSchema right);

    void visitSchemaEnd(@Nullable OpenApiSchema left, @Nullable OpenApiSchema right);
}
