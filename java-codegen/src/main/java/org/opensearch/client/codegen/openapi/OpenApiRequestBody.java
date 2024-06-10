/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen.openapi;

import io.swagger.v3.oas.models.parameters.RequestBody;
import javax.annotation.Nonnull;

public class OpenApiRequestBody extends OpenApiOperationBodyElement<OpenApiRequestBody> {
    protected OpenApiRequestBody(@Nonnull OpenApiElement<?> parent, @Nonnull JsonPointer pointer, @Nonnull RequestBody requestBody) {
        super(parent, pointer, requestBody.get$ref(), requestBody.getContent(), OpenApiRequestBody.class);
    }
}
