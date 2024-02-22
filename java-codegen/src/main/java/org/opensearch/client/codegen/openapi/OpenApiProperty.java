/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen.openapi;

import io.swagger.v3.oas.models.media.Schema;

public class OpenApiProperty extends OpenApiSchema {
    private final boolean required;

    protected OpenApiProperty(OpenApiSpec parent, JsonPointer jsonPtr, Schema<?> schema, boolean required) {
        super(parent, jsonPtr, schema);
        this.required = required;
    }

    public String getName() {
        return getJsonPtr().getKey().orElseThrow();
    }

    public boolean isRequired() {
        return required;
    }
}
