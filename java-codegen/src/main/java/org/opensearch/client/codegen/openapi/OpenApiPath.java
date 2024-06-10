/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen.openapi;

import io.swagger.v3.oas.models.PathItem;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.opensearch.client.codegen.utils.Lists;
import org.opensearch.client.codegen.utils.Maps;

public class OpenApiPath extends OpenApiRefElement<OpenApiPath> {
    @Nonnull
    private final String httpPath;
    @Nullable
    private final Map<HttpMethod, OpenApiOperation> operations;
    @Nullable
    private final List<OpenApiParameter> parameters;

    protected OpenApiPath(@Nonnull OpenApiSpecification parent, @Nonnull JsonPointer pointer, @Nonnull PathItem pathItem) {
        super(parent, pointer, pathItem.get$ref(), OpenApiPath.class);
        this.httpPath = pointer.getLastKey().orElseThrow();
        this.operations = children(pathItem.readOperationsMap(), HttpMethod::from, OpenApiOperation::new);
        this.parameters = children("parameters", pathItem.getParameters(), OpenApiParameter::new);
    }

    @Nonnull
    public String getHttpPath() {
        return httpPath;
    }

    @Nonnull
    public Optional<Map<HttpMethod, OpenApiOperation>> getOperations() {
        return Maps.unmodifiableOpt(operations);
    }

    @Nonnull
    public Optional<List<OpenApiParameter>> getParameters() {
        return Lists.unmodifiableOpt(parameters);
    }
}
