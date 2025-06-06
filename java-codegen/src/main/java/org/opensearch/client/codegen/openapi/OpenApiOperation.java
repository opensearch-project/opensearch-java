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
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.opensearch.client.codegen.model.Deprecation;
import org.opensearch.client.codegen.model.OperationGroup;
import org.opensearch.client.codegen.utils.Clone;
import org.opensearch.client.codegen.utils.Lists;
import org.opensearch.client.codegen.utils.Versions;
import org.opensearch.client.codegen.utils.builder.ToBuilder;
import org.semver4j.Semver;

public final class OpenApiOperation extends OpenApiElement<OpenApiOperation> implements ToBuilder<OpenApiOperation.Builder> {
    private HttpMethod httpMethod;
    @Nonnull
    private final String id;
    @Nullable
    private List<OpenApiParameter> parameters;
    @Nonnull
    private final OperationGroup operationGroup;
    @Nullable
    private final Boolean isDeprecated;
    @Nullable
    private final String description;
    @Nullable
    private OpenApiRequestBody requestBody;
    @Nullable
    private OpenApiResponses responses;
    @Nullable
    private final String versionAdded;
    @Nullable
    private final Semver versionDeprecated;
    @Nullable
    private final String deprecationMessage;
    @Nullable
    private final Boolean ignorable;

    OpenApiOperation(@Nonnull Builder builder) {
        super(builder);
        this.id = Objects.requireNonNull(builder.id, "id must not be null");
        setParameters(builder.parameters);
        this.operationGroup = Objects.requireNonNull(builder.operationGroup, "operationGroup must not be null");
        this.isDeprecated = builder.isDeprecated;
        this.description = builder.description;
        setRequestBody(builder.requestBody);
        setResponses(builder.responses);
        this.versionAdded = builder.versionAdded;
        this.versionDeprecated = builder.versionDeprecated;
        this.deprecationMessage = builder.deprecationMessage;
        this.ignorable = builder.ignorable;
    }

    OpenApiOperation(@Nonnull Operation operation) {
        Objects.requireNonNull(operation, "operation must not be null");
        this.id = Objects.requireNonNull(operation.getOperationId());
        setParameters(children(operation.getParameters(), OpenApiParameter::new));
        var extensions = Objects.requireNonNull(operation.getExtensions(), "operation must have extensions defined");
        this.operationGroup = OperationGroup.from((String) extensions.get("x-operation-group"));
        this.isDeprecated = operation.getDeprecated();
        this.description = operation.getDescription();
        setRequestBody(ifNonnull(operation.getRequestBody(), OpenApiRequestBody::new));
        setResponses(ifNonnull(operation.getResponses(), OpenApiResponses::new));
        this.versionAdded = ifNonnull(extensions.get("x-version-added"), String::valueOf);
        this.versionDeprecated = ifNonnull(extensions.get("x-version-deprecated"), v -> Versions.coerce((String) v));
        this.deprecationMessage = ifNonnull(extensions.get("x-deprecation-message"), String::valueOf);
        this.ignorable = ifNonnull(extensions.get("x-ignorable"), Boolean.class::cast);
    }

    @Override
    void initialize(@Nullable OpenApiElement<?> parent, @Nonnull JsonPointer pointer) {
        super.initialize(parent, pointer);
        this.httpMethod = HttpMethod.from(pointer.getLastKey().orElseThrow());
        initializeChildren("parameters", parameters);
        initializeChild("requestBody", requestBody);
        initializeChild("responses", responses);
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
    public Optional<List<OpenApiParameter>> getParameters() {
        return Lists.unmodifiableOpt(parameters);
    }

    public void setParameters(@Nullable List<OpenApiParameter> parameters) {
        this.parameters = parameters;
        initializeChildren("parameters", parameters);
    }

    @Nonnull
    public Optional<OpenApiRequestBody> getRequestBody() {
        return Optional.ofNullable(requestBody);
    }

    public void setRequestBody(@Nullable OpenApiRequestBody requestBody) {
        this.requestBody = requestBody;
        initializeChild("requestBody", requestBody);
    }

    @Nonnull
    public Optional<OpenApiResponses> getResponses() {
        return Optional.ofNullable(responses);
    }

    public void setResponses(@Nullable OpenApiResponses responses) {
        this.responses = responses;
        initializeChild("responses", responses);
    }

    @Nonnull
    public Optional<String> getVersionAdded() {
        return Optional.ofNullable(versionAdded);
    }

    @Nonnull
    public Optional<Deprecation> getDeprecation() {
        if (versionDeprecated == null) return Optional.empty();
        return Optional.of(new Deprecation(deprecationMessage, versionDeprecated));
    }

    public boolean isIgnorable() {
        return ignorable != null && ignorable;
    }

    @Override
    public @Nonnull OpenApiOperation clone() {
        return toBuilder().build();
    }

    @Override
    public @Nonnull Builder toBuilder() {
        return super.toBuilder(builder()).withId(id)
            .withParameters(ifNonnull(parameters, Clone::clone))
            .withOperationGroup(operationGroup)
            .withIsDeprecated(isDeprecated)
            .withDescription(description)
            .withRequestBody(ifNonnull(requestBody, Clone::clone))
            .withResponses(ifNonnull(responses, Clone::clone))
            .withVersionAdded(versionAdded)
            .withVersionDeprecated(versionDeprecated)
            .withDeprecationMessage(deprecationMessage)
            .withIgnorable(ignorable);
    }

    public static @Nonnull Builder builder() {
        return new Builder();
    }

    public static final class Builder extends OpenApiElement.AbstractBuilder<OpenApiOperation, Builder> {
        private String id;
        private List<OpenApiParameter> parameters;
        private OperationGroup operationGroup;
        private Boolean isDeprecated;
        private String description;
        private OpenApiRequestBody requestBody;
        private OpenApiResponses responses;
        private String versionAdded;
        private Semver versionDeprecated;
        private String deprecationMessage;
        private Boolean ignorable;

        private Builder() {}

        @Nonnull
        @Override
        protected OpenApiOperation construct() {
            return new OpenApiOperation(this);
        }

        public @Nonnull Builder withId(@Nonnull String id) {
            this.id = Objects.requireNonNull(id, "id must not be null");
            return this;
        }

        public @Nonnull Builder withParameters(@Nullable List<OpenApiParameter> parameters) {
            this.parameters = parameters;
            return this;
        }

        public @Nonnull Builder withOperationGroup(@Nonnull OperationGroup operationGroup) {
            this.operationGroup = Objects.requireNonNull(operationGroup, "operationGroup must not be null");
            return this;
        }

        public @Nonnull Builder withIsDeprecated(@Nullable Boolean isDeprecated) {
            this.isDeprecated = isDeprecated;
            return this;
        }

        public @Nonnull Builder withDescription(@Nullable String description) {
            this.description = description;
            return this;
        }

        public @Nonnull Builder withRequestBody(@Nullable OpenApiRequestBody requestBody) {
            this.requestBody = requestBody;
            return this;
        }

        public @Nonnull Builder withResponses(@Nullable OpenApiResponses responses) {
            this.responses = responses;
            return this;
        }

        public @Nonnull Builder withVersionAdded(@Nullable String versionAdded) {
            this.versionAdded = versionAdded;
            return this;
        }

        public @Nonnull Builder withVersionDeprecated(@Nullable Semver versionDeprecated) {
            this.versionDeprecated = versionDeprecated;
            return this;
        }

        public @Nonnull Builder withDeprecationMessage(@Nullable String deprecationMessage) {
            this.deprecationMessage = deprecationMessage;
            return this;
        }

        public @Nonnull Builder withIgnorable(@Nullable Boolean ignorable) {
            this.ignorable = ignorable;
            return this;
        }
    }
}
