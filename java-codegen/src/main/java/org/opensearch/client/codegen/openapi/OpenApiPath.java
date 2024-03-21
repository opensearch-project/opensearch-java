/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen.openapi;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.PathItem;
import java.util.stream.Stream;

public class OpenApiPath extends OpenApiRefObject<OpenApiPath, PathItem> {
    private final String httpPath;

    protected OpenApiPath(OpenApiSpec parent, JsonPointer jsonPtr, String httpPath, PathItem pathItem) {
        super(parent, jsonPtr, pathItem, (api, jPath, p) -> new OpenApiPath(api, jPath, httpPath, p), OpenAPI::getPaths, PathItem::get$ref);
        this.httpPath = httpPath;
    }

    public Stream<OpenApiOperation> getOperations() {
        return getInner().readOperationsMap().entrySet().stream().map(e -> new OpenApiOperation(this, e.getKey(), e.getValue()));
    }

    public Stream<OpenApiParameter> getParameters() {
        return children("parameters", PathItem::getParameters, OpenApiParameter::new);
    }

    public String getHttpPath() {
        return httpPath;
    }

    @Override
    protected OpenApiPath getSelf() {
        return this;
    }
}
