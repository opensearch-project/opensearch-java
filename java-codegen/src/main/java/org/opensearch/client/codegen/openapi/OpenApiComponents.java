/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen.openapi;

import io.swagger.v3.oas.models.Components;
import java.util.Map;
import java.util.Objects;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class OpenApiComponents extends OpenApiElement<OpenApiComponents> {
    @Nullable
    private final Map<String, OpenApiSchema> schemas;
    @Nullable
    private final Map<String, OpenApiParameter> parameters;
    @Nullable
    private final Map<String, OpenApiResponse> responses;
    @Nullable
    private final Map<String, OpenApiRequestBody> requestBodies;

    protected OpenApiComponents(@Nonnull OpenApiSpecification parent, @Nonnull JsonPointer pointer, @Nonnull Components components) {
        super(parent, pointer);
        Objects.requireNonNull(components, "components must not be null");
        this.schemas = children("schemas", components.getSchemas(), OpenApiSchema::new);
        this.parameters = children("parameters", components.getParameters(), OpenApiParameter::new);
        this.responses = children("responses", components.getResponses(), OpenApiResponse::new);
        this.requestBodies = children("requestBodies", components.getRequestBodies(), OpenApiRequestBody::new);
    }
}
