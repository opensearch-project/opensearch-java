/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen.openapi;

import static org.opensearch.client.codegen.utils.Functional.ifNonnull;

import io.swagger.v3.oas.models.Components;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.opensearch.client.codegen.utils.Clone;
import org.opensearch.client.codegen.utils.Maps;
import org.opensearch.client.codegen.utils.builder.ToBuilder;
import org.opensearch.client.codegen.utils.json.JsonGenerator;

public final class OpenApiComponents extends OpenApiElement<OpenApiComponents> implements ToBuilder<OpenApiComponents.Builder> {
    @Nullable
    private Map<String, OpenApiSchema> schemas;
    @Nullable
    private Map<String, OpenApiParameter> parameters;
    @Nullable
    private Map<String, OpenApiResponse> responses;
    @Nullable
    private Map<String, OpenApiRequestBody> requestBodies;

    private OpenApiComponents(@Nonnull Builder builder) {
        super(builder);
        setSchemas(builder.schemas);
        setParameters(builder.parameters);
        setResponses(builder.responses);
        setRequestBodies(builder.requestBodies);
    }

    OpenApiComponents(@Nonnull Components components) {
        Objects.requireNonNull(components, "components must not be null");
        setSchemas(children(components.getSchemas(), OpenApiSchema::new));
        setParameters(children(components.getParameters(), OpenApiParameter::new));
        setResponses(children(components.getResponses(), OpenApiResponse::new));
        setRequestBodies(children(components.getRequestBodies(), OpenApiRequestBody::new));
    }

    @Override
    void initialize(@Nullable OpenApiElement<?> parent, @Nonnull JsonPointer pointer) {
        super.initialize(parent, pointer);
        initializeChildren("schemas", schemas);
        initializeChildren("parameters", parameters);
        initializeChildren("responses", responses);
        initializeChildren("requestBodies", requestBodies);
    }

    @Nonnull
    public Optional<Map<String, OpenApiSchema>> getSchemas() {
        return Maps.unmodifiableOpt(schemas);
    }

    public void setSchemas(@Nullable Map<String, OpenApiSchema> schemas) {
        this.schemas = schemas;
        initializeChildren("schemas", schemas);
    }

    @Nonnull
    public Optional<Map<String, OpenApiParameter>> getParameters() {
        return Maps.unmodifiableOpt(parameters);
    }

    public void setParameters(@Nullable Map<String, OpenApiParameter> parameters) {
        this.parameters = parameters;
        initializeChildren("parameters", parameters);
    }

    @Nonnull
    public Optional<Map<String, OpenApiResponse>> getResponses() {
        return Maps.unmodifiableOpt(responses);
    }

    public void setResponses(@Nullable Map<String, OpenApiResponse> responses) {
        this.responses = responses;
        initializeChildren("responses", responses);
    }

    @Nonnull
    public Optional<Map<String, OpenApiRequestBody>> getRequestBodies() {
        return Maps.unmodifiableOpt(requestBodies);
    }

    public void setRequestBodies(@Nullable Map<String, OpenApiRequestBody> requestBodies) {
        this.requestBodies = requestBodies;
        initializeChildren("requestBodies", requestBodies);
    }

    @Override
    public @Nonnull OpenApiComponents clone() {
        return toBuilder().build();
    }

    @Override
    protected void toJsonInner(JsonGenerator generator) {
        if (parameters != null) {
            generator.writeField("parameters", parameters);
        }
        if (requestBodies != null) {
            generator.writeField("requestBodies", requestBodies);
        }
        if (responses != null) {
            generator.writeField("responses", responses);
        }
        if (schemas != null) {
            generator.writeField("schemas", schemas);
        }
    }

    @Override
    public @Nonnull Builder toBuilder() {
        return super.toBuilder(builder()).withSchemas(ifNonnull(schemas, Clone::clone))
            .withParameters(ifNonnull(parameters, Clone::clone))
            .withResponses(ifNonnull(responses, Clone::clone))
            .withRequestBodies(ifNonnull(requestBodies, Clone::clone));
    }

    public static @Nonnull Builder builder() {
        return new Builder();
    }

    public static final class Builder extends OpenApiElement.AbstractBuilder<OpenApiComponents, Builder> {
        private Map<String, OpenApiSchema> schemas;
        private Map<String, OpenApiParameter> parameters;
        private Map<String, OpenApiResponse> responses;
        private Map<String, OpenApiRequestBody> requestBodies;

        private Builder() {}

        @Nonnull
        @Override
        protected OpenApiComponents construct() {
            return new OpenApiComponents(this);
        }

        public Builder withSchemas(@Nullable Map<String, OpenApiSchema> schemas) {
            this.schemas = schemas;
            return this;
        }

        public Builder withParameters(@Nullable Map<String, OpenApiParameter> parameters) {
            this.parameters = parameters;
            return this;
        }

        public Builder withResponses(@Nullable Map<String, OpenApiResponse> responses) {
            this.responses = responses;
            return this;
        }

        public Builder withRequestBodies(@Nullable Map<String, OpenApiRequestBody> requestBodies) {
            this.requestBodies = requestBodies;
            return this;
        }
    }
}
