/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen.openapi;

import io.swagger.v3.oas.models.Operation;
import io.swagger.v3.oas.models.PathItem;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;
import org.opensearch.client.codegen.model.Deprecation;
import org.opensearch.client.codegen.model.OperationGroup;

public class OpenApiOperation extends OpenApiObject<Operation> implements OpenApiExtensions {
    private final OpenApiPath path;
    private final PathItem.HttpMethod httpMethod;

    protected OpenApiOperation(OpenApiPath path, PathItem.HttpMethod httpMethod, Operation operation) {
        super(path.getParent(), path.childPtr(httpMethod.toString().toLowerCase()), operation);
        this.path = path;
        this.httpMethod = httpMethod;
    }

    public String getHttpPath() {
        return path.getHttpPath();
    }

    public PathItem.HttpMethod getHttpMethod() {
        return httpMethod;
    }

    public String getDescription() {
        return getInner().getDescription();
    }

    public Stream<OpenApiParameter> getParameters() {
        return children("parameters", Operation::getParameters, OpenApiParameter::new);
    }

    public Stream<OpenApiParameter> getAllApplicableParameters(OpenApiParameter.In in) {
        return Stream.concat(path.getParameters(), getParameters()).map(OpenApiParameter::resolve).filter(p -> in.equals(p.getIn()));
    }

    public Optional<OpenApiRequestBody> getRequestBody() {
        return Optional.ofNullable(getInner().getRequestBody())
            .map(body -> new OpenApiRequestBody(getParent(), childPtr("requestBody"), body));
    }

    public Optional<OpenApiApiResponses> getResponses() {
        return Optional.ofNullable(getInner().getResponses())
            .map(responses -> new OpenApiApiResponses(getParent(), childPtr("responses"), responses));
    }

    @Override
    public Map<String, Object> getExtensions() {
        return getInner().getExtensions();
    }

    public OperationGroup getXOperationGroup() {
        return getExtensionAsString("x-operation-group").map(OperationGroup::from).orElseThrow();
    }

    public Optional<String> getXVersionAdded() {
        return getExtensionAsString("x-version-added");
    }

    public Deprecation getDeprecation() {
        var msg = getExtensionAsString("x-deprecation-message");
        var version = getExtensionAsString("x-version-deprecated");
        if (msg.isEmpty() && version.isEmpty()) return null;
        return new Deprecation(msg.orElse(null), version.orElse(null));
    }
}
