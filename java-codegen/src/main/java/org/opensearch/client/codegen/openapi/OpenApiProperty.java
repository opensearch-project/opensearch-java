/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen.openapi;

import io.swagger.v3.oas.models.media.Schema;

public class OpenApiProperty extends OpenApiObject<Schema<?>> {
    private final String name;
    private final boolean required;

    protected OpenApiProperty(OpenApiSpec parent, String name, Schema<?> schema, boolean required) {
        super(parent, schema);
        this.name = name;
        this.required = required;
    }

    public OpenApiSchema getSchema() {
        return new OpenApiSchema(getParent(), getInner());
    }

    public String getName() {
        return name;
    }

    public boolean isRequired() {
        return required;
    }

    public String getDescription() {
        return getInner().getDescription();
    }
}
