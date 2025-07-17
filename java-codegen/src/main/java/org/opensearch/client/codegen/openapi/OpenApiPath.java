/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen.openapi;

import static org.opensearch.client.codegen.utils.Functional.ifNonnull;

import io.swagger.v3.oas.models.PathItem;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.opensearch.client.codegen.utils.Clone;
import org.opensearch.client.codegen.utils.Lists;
import org.opensearch.client.codegen.utils.Maps;
import org.opensearch.client.codegen.utils.builder.ToBuilder;
import org.opensearch.client.codegen.utils.json.JsonGenerator;

public final class OpenApiPath extends OpenApiRefElement<OpenApiPath> implements ToBuilder<OpenApiPath.Builder> {
    private String httpPath;
    @Nullable
    private Map<HttpMethod, OpenApiOperation> operations;
    @Nullable
    private List<OpenApiParameter> parameters;

    private OpenApiPath(@Nonnull Builder builder) {
        super(builder, OpenApiPath.class);
        setOperations(builder.operations);
        setParameters(builder.parameters);
    }

    OpenApiPath(@Nonnull PathItem pathItem) {
        super(pathItem.get$ref(), OpenApiPath.class);
        setOperations(children(pathItem.readOperationsMap(), HttpMethod::from, OpenApiOperation::new));
        setParameters(children(pathItem.getParameters(), OpenApiParameter::new));
    }

    @Override
    void initialize(@Nullable OpenApiElement<?> parent, @Nonnull JsonPointer pointer) {
        super.initialize(parent, pointer);
        this.httpPath = pointer.getLastKey().orElseThrow();
        initializeOperations();
        initializeChildren("parameters", parameters);
    }

    @Nonnull
    public String getHttpPath() {
        return httpPath;
    }

    @Nonnull
    public Optional<Map<HttpMethod, OpenApiOperation>> getOperations() {
        return Maps.unmodifiableOpt(operations);
    }

    public void setOperations(@Nullable Map<HttpMethod, OpenApiOperation> operations) {
        this.operations = operations;
        initializeOperations();
    }

    private void initializeOperations() {
        if (operations == null) {
            return;
        }
        var ptr = getPointer();
        operations.forEach((key, value) -> value.initialize(this, ptr.append(key.toString())));
    }

    @Nonnull
    public Optional<List<OpenApiParameter>> getParameters() {
        return Lists.unmodifiableOpt(parameters);
    }

    public void setParameters(@Nullable List<OpenApiParameter> parameters) {
        this.parameters = parameters;
        initializeChildren("parameters", parameters);
    }

    @Override
    protected void toJsonInner(JsonGenerator generator) {
        super.toJsonInner(generator);
        if (operations != null) {
            generator.writeMapInner(operations);
        }
        if (parameters != null) {
            generator.writeField("parameters", parameters);
        }
    }

    @Override
    public @Nonnull OpenApiPath clone() {
        return toBuilder().build();
    }

    @Override
    public @Nonnull Builder toBuilder() {
        return super.toBuilder(builder()).withOperations(ifNonnull(operations, Clone::clone))
            .withParameters(ifNonnull(parameters, Clone::clone));
    }

    public static @Nonnull Builder builder() {
        return new Builder();
    }

    public static final class Builder extends OpenApiRefElement.AbstractBuilder<OpenApiPath, Builder> {
        @Nullable
        private Map<HttpMethod, OpenApiOperation> operations;
        @Nullable
        private List<OpenApiParameter> parameters;

        private Builder() {}

        @Nonnull
        @Override
        protected OpenApiPath construct() {
            return new OpenApiPath(this);
        }

        public @Nonnull Builder withOperations(@Nullable Map<HttpMethod, OpenApiOperation> operations) {
            this.operations = operations;
            return this;
        }

        public @Nonnull Builder withParameters(@Nullable List<OpenApiParameter> parameters) {
            this.parameters = parameters;
            return this;
        }
    }
}
