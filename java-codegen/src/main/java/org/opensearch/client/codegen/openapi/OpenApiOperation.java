/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen.openapi;

import static org.opensearch.client.codegen.utils.Functional.ifNonnull;

import io.swagger.v3.oas.models.Operation;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.opensearch.client.codegen.model.Deprecation;
import org.opensearch.client.codegen.model.OperationGroup;

public class OpenApiOperation extends OpenApiElement<OpenApiOperation> {
    @Nonnull
    private final OpenApiPath parentPath;
    @Nonnull
    private final HttpMethod httpMethod;
    @Nonnull
    private final String id;
    @Nullable
    private final List<OpenApiParameter> parameters;
    @Nonnull
    private final OperationGroup operationGroup;
    @Nullable
    private final Boolean isDeprecated;
    @Nullable
    private final String description;
    @Nullable
    private final OpenApiRequestBody requestBody;
    @Nullable
    private final OpenApiResponses responses;
    @Nullable
    private final String versionAdded;
    @Nullable
    private final String versionDeprecated;
    @Nullable
    private final String deprecationMessage;

    protected OpenApiOperation(@Nonnull OpenApiPath parent, @Nonnull JsonPointer pointer, @Nonnull Operation operation) {
        super(parent, pointer);
        this.parentPath = Objects.requireNonNull(parent, "parent must not be null");
        this.httpMethod = HttpMethod.from(pointer.getLastKey().orElseThrow());
        Objects.requireNonNull(operation, "operation must not be null");
        this.id = Objects.requireNonNull(operation.getOperationId());
        this.parameters = children("parameters", operation.getParameters(), OpenApiParameter::new);
        var extensions = Objects.requireNonNull(operation.getExtensions(), "operation must have extensions defined");
        this.operationGroup = OperationGroup.from((String) extensions.get("x-operation-group"));
        this.isDeprecated = operation.getDeprecated();
        this.description = operation.getDescription();
        this.requestBody = child("requestBody", operation.getRequestBody(), OpenApiRequestBody::new);
        this.responses = child("responses", operation.getResponses(), OpenApiResponses::new);
        this.versionAdded = ifNonnull(extensions.get("x-version-added"), String::valueOf);
        this.versionDeprecated = ifNonnull(extensions.get("x-version-deprecated"), String::valueOf);
        this.deprecationMessage = ifNonnull(extensions.get("x-deprecation-message"), String::valueOf);
    }

    @Nonnull
    public String getHttpPath() {
        return parentPath.getHttpPath();
    }

    @Nonnull
    public HttpMethod getHttpMethod() {
        return httpMethod;
    }

    @Nonnull
    public OperationGroup getOperationGroup() {
        return operationGroup;
    }

    @Nonnull
    public Optional<String> getDescription() {
        return Optional.ofNullable(description);
    }

    @Nonnull
    public Optional<OpenApiRequestBody> getRequestBody() {
        return Optional.ofNullable(requestBody);
    }

    @Nonnull
    public Optional<OpenApiResponses> getResponses() {
        return Optional.ofNullable(responses);
    }

    @Nonnull
    public List<OpenApiParameter> getAllRelevantParameters(@Nonnull In in) {
        Objects.requireNonNull(in, "in must not be null");
        return Stream.of(parentPath.getParameters(), Optional.ofNullable(parameters))
            .flatMap(Optional::stream)
            .flatMap(List::stream)
            .map(OpenApiRefElement::resolve)
            .filter(p -> p.getIn().equals(Optional.of(in)))
            .collect(Collectors.toList());
    }

    @Nonnull
    public Optional<String> getVersionAdded() {
        return Optional.ofNullable(versionAdded);
    }

    @Nonnull
    public Optional<Deprecation> getDeprecation() {
        if (versionDeprecated == null && deprecationMessage == null) return Optional.empty();
        return Optional.of(new Deprecation(deprecationMessage, versionDeprecated));
    }
}
