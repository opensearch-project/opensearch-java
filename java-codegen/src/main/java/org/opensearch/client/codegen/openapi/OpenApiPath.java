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
import org.opensearch.client.codegen.utils.Streams;

public class OpenApiPath extends OpenApiRefObject<OpenApiPath, PathItem> {
    private final String httpPath;

    protected OpenApiPath(OpenApiSpec parent, String httpPath, PathItem pathItem) {
        super(parent, pathItem, (api, p) -> new OpenApiPath(api, httpPath, p), OpenAPI::getPaths, PathItem::get$ref);
        this.httpPath = httpPath;
    }

    public Stream<OpenApiOperation> getOperations() {
        return getInner().readOperationsMap().entrySet().stream().map(e -> new OpenApiOperation(this, e.getKey(), e.getValue()));
    }

    public Stream<OpenApiParameter> getParametersIn(OpenApiParameter.In in) {
        return Streams.tryOf(getInner().getParameters())
            .map(p -> new OpenApiParameter(getParent(), p))
            .map(OpenApiParameter::resolve)
            .filter(p -> in.equals(p.getIn()));
    }

    public String getHttpPath() {
        return httpPath;
    }
}
