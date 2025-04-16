/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen.openapi.rewriter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.BiFunction;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.opensearch.client.codegen.openapi.OpenApiComponents;
import org.opensearch.client.codegen.openapi.OpenApiContent;
import org.opensearch.client.codegen.openapi.OpenApiDiscriminator;
import org.opensearch.client.codegen.openapi.OpenApiElement;
import org.opensearch.client.codegen.openapi.OpenApiMediaType;
import org.opensearch.client.codegen.openapi.OpenApiOperation;
import org.opensearch.client.codegen.openapi.OpenApiParameter;
import org.opensearch.client.codegen.openapi.OpenApiPath;
import org.opensearch.client.codegen.openapi.OpenApiRequestBody;
import org.opensearch.client.codegen.openapi.OpenApiResponse;
import org.opensearch.client.codegen.openapi.OpenApiResponses;
import org.opensearch.client.codegen.openapi.OpenApiSchema;
import org.opensearch.client.codegen.openapi.OpenApiSpecification;
import org.opensearch.client.codegen.openapi.walker.OpenApiVisitor;

public final class VisitorChain implements OpenApiVisitor {
    private static final Logger LOGGER = LogManager.getLogger();
    @Nonnull
    private final List<OpenApiVisitor> visitors = new ArrayList<>();

    public VisitorChain() {}

    public void add(@Nonnull OpenApiVisitor visitor) {
        visitors.add(Objects.requireNonNull(visitor, "visitor cannot be null"));
    }

    private <T extends OpenApiElement<T>> T visit(@Nonnull T element, @Nonnull BiFunction<OpenApiVisitor, T, T> visitMethod) {
        LOGGER.trace("Visiting: {}[{}]", element.getClass().getSimpleName(), element.getPointer());
        var visitorCount = visitors.size();
        for (var i = 0; i < visitorCount; ++i) {
            var newElement = visitMethod.apply(visitors.get(i), element);
            if (newElement != null && newElement != element) {
                element = newElement;
                i = 0;
            }
        }
        return element;
    }

    @Nullable
    @Override
    public OpenApiSpecification visitSpecificationStart(@Nonnull OpenApiSpecification specification) {
        return visit(specification, OpenApiVisitor::visitSpecificationStart);
    }

    @Nullable
    @Override
    public OpenApiSpecification visitSpecificationEnd(@Nonnull OpenApiSpecification specification) {
        return visit(specification, OpenApiVisitor::visitSpecificationEnd);
    }

    @Nullable
    @Override
    public OpenApiPath visitPathStart(@Nonnull OpenApiPath path) {
        return visit(path, OpenApiVisitor::visitPathStart);
    }

    @Nullable
    @Override
    public OpenApiPath visitPathEnd(@Nonnull OpenApiPath path) {
        return visit(path, OpenApiVisitor::visitPathEnd);
    }

    @Nullable
    @Override
    public OpenApiComponents visitComponentsStart(@Nonnull OpenApiComponents components) {
        return visit(components, OpenApiVisitor::visitComponentsStart);
    }

    @Nullable
    @Override
    public OpenApiComponents visitComponentsEnd(@Nonnull OpenApiComponents components) {
        return visit(components, OpenApiVisitor::visitComponentsEnd);
    }

    @Nullable
    @Override
    public OpenApiOperation visitOperationStart(@Nonnull OpenApiOperation operation) {
        return visit(operation, OpenApiVisitor::visitOperationStart);
    }

    @Nullable
    @Override
    public OpenApiOperation visitOperationEnd(@Nonnull OpenApiOperation operation) {
        return visit(operation, OpenApiVisitor::visitOperationEnd);
    }

    @Nullable
    @Override
    public OpenApiParameter visitParameterStart(@Nonnull OpenApiParameter parameter) {
        return visit(parameter, OpenApiVisitor::visitParameterStart);
    }

    @Nullable
    @Override
    public OpenApiParameter visitParameterEnd(@Nonnull OpenApiParameter parameter) {
        return visit(parameter, OpenApiVisitor::visitParameterEnd);
    }

    @Nullable
    @Override
    public OpenApiSchema visitSchemaStart(@Nonnull OpenApiSchema schema) {
        return visit(schema, OpenApiVisitor::visitSchemaStart);
    }

    @Nullable
    @Override
    public OpenApiSchema visitSchemaEnd(@Nonnull OpenApiSchema schema) {
        return visit(schema, OpenApiVisitor::visitSchemaEnd);
    }

    @Nullable
    @Override
    public OpenApiDiscriminator visitDiscriminatorStart(@Nonnull OpenApiDiscriminator discriminator) {
        return visit(discriminator, OpenApiVisitor::visitDiscriminatorStart);
    }

    @Nullable
    @Override
    public OpenApiDiscriminator visitDiscriminatorEnd(@Nonnull OpenApiDiscriminator discriminator) {
        return visit(discriminator, OpenApiVisitor::visitDiscriminatorEnd);
    }

    @Nullable
    @Override
    public OpenApiResponse visitResponseStart(@Nonnull OpenApiResponse response) {
        return visit(response, OpenApiVisitor::visitResponseStart);
    }

    @Nullable
    @Override
    public OpenApiResponse visitResponseEnd(@Nonnull OpenApiResponse response) {
        return visit(response, OpenApiVisitor::visitResponseEnd);
    }

    @Nullable
    @Override
    public OpenApiRequestBody visitRequestBodyStart(@Nonnull OpenApiRequestBody requestBody) {
        return visit(requestBody, OpenApiVisitor::visitRequestBodyStart);
    }

    @Nullable
    @Override
    public OpenApiRequestBody visitRequestBodyEnd(@Nonnull OpenApiRequestBody requestBody) {
        return visit(requestBody, OpenApiVisitor::visitRequestBodyEnd);
    }

    @Nullable
    @Override
    public OpenApiResponses visitResponsesStart(@Nonnull OpenApiResponses responses) {
        return visit(responses, OpenApiVisitor::visitResponsesStart);
    }

    @Nullable
    @Override
    public OpenApiResponses visitResponsesEnd(@Nonnull OpenApiResponses responses) {
        return visit(responses, OpenApiVisitor::visitResponsesEnd);
    }

    @Nullable
    @Override
    public OpenApiContent visitContentStart(@Nonnull OpenApiContent content) {
        return visit(content, OpenApiVisitor::visitContentStart);
    }

    @Nullable
    @Override
    public OpenApiContent visitContentEnd(@Nonnull OpenApiContent content) {
        return visit(content, OpenApiVisitor::visitContentEnd);
    }

    @Nullable
    @Override
    public OpenApiMediaType visitMediaTypeStart(@Nonnull OpenApiMediaType schema) {
        return visit(schema, OpenApiVisitor::visitMediaTypeStart);
    }

    @Nullable
    @Override
    public OpenApiMediaType visitMediaTypeEnd(@Nonnull OpenApiMediaType schema) {
        return visit(schema, OpenApiVisitor::visitMediaTypeEnd);
    }
}
