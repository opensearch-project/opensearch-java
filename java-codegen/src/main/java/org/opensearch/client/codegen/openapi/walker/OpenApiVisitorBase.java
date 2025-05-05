/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen.openapi.walker;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.opensearch.client.codegen.openapi.OpenApiComponents;
import org.opensearch.client.codegen.openapi.OpenApiContent;
import org.opensearch.client.codegen.openapi.OpenApiDiscriminator;
import org.opensearch.client.codegen.openapi.OpenApiMediaType;
import org.opensearch.client.codegen.openapi.OpenApiOperation;
import org.opensearch.client.codegen.openapi.OpenApiParameter;
import org.opensearch.client.codegen.openapi.OpenApiPath;
import org.opensearch.client.codegen.openapi.OpenApiRequestBody;
import org.opensearch.client.codegen.openapi.OpenApiResponse;
import org.opensearch.client.codegen.openapi.OpenApiResponses;
import org.opensearch.client.codegen.openapi.OpenApiSchema;
import org.opensearch.client.codegen.openapi.OpenApiSpecification;

public abstract class OpenApiVisitorBase implements OpenApiVisitor {
    @Override
    @Nullable
    public OpenApiSpecification visitSpecificationStart(@Nonnull OpenApiSpecification specification) {
        return null;
    }

    @Override
    @Nullable
    public OpenApiSpecification visitSpecificationEnd(@Nonnull OpenApiSpecification specification) {
        return null;
    }

    @Override
    @Nullable
    public OpenApiPath visitPathStart(@Nonnull OpenApiPath path) {
        return null;
    }

    @Override
    @Nullable
    public OpenApiPath visitPathEnd(@Nonnull OpenApiPath path) {
        return null;
    }

    @Override
    @Nullable
    public OpenApiComponents visitComponentsStart(@Nonnull OpenApiComponents components) {
        return null;
    }

    @Override
    @Nullable
    public OpenApiComponents visitComponentsEnd(@Nonnull OpenApiComponents components) {
        return null;
    }

    @Override
    @Nullable
    public OpenApiOperation visitOperationStart(@Nonnull OpenApiOperation operation) {
        return null;
    }

    @Override
    @Nullable
    public OpenApiOperation visitOperationEnd(@Nonnull OpenApiOperation operation) {
        return null;
    }

    @Override
    @Nullable
    public OpenApiParameter visitParameterStart(@Nonnull OpenApiParameter parameter) {
        return null;
    }

    @Override
    @Nullable
    public OpenApiParameter visitParameterEnd(@Nonnull OpenApiParameter parameter) {
        return null;
    }

    @Override
    @Nullable
    public OpenApiSchema visitSchemaStart(@Nonnull OpenApiSchema schema) {
        return null;
    }

    @Override
    @Nullable
    public OpenApiSchema visitSchemaEnd(@Nonnull OpenApiSchema schema) {
        return null;
    }

    @Override
    @Nullable
    public OpenApiDiscriminator visitDiscriminatorStart(@Nonnull OpenApiDiscriminator discriminator) {
        return null;
    }

    @Override
    @Nullable
    public OpenApiDiscriminator visitDiscriminatorEnd(@Nonnull OpenApiDiscriminator discriminator) {
        return null;
    }

    @Override
    @Nullable
    public OpenApiResponse visitResponseStart(@Nonnull OpenApiResponse response) {
        return null;
    }

    @Override
    @Nullable
    public OpenApiResponse visitResponseEnd(@Nonnull OpenApiResponse response) {
        return null;
    }

    @Override
    @Nullable
    public OpenApiRequestBody visitRequestBodyStart(@Nonnull OpenApiRequestBody requestBody) {
        return null;
    }

    @Override
    @Nullable
    public OpenApiRequestBody visitRequestBodyEnd(@Nonnull OpenApiRequestBody requestBody) {
        return null;
    }

    @Override
    @Nullable
    public OpenApiResponses visitResponsesStart(@Nonnull OpenApiResponses responses) {
        return null;
    }

    @Override
    @Nullable
    public OpenApiResponses visitResponsesEnd(@Nonnull OpenApiResponses responses) {
        return null;
    }

    @Override
    @Nullable
    public OpenApiContent visitContentStart(@Nonnull OpenApiContent content) {
        return null;
    }

    @Override
    @Nullable
    public OpenApiContent visitContentEnd(@Nonnull OpenApiContent content) {
        return null;
    }

    @Override
    @Nullable
    public OpenApiMediaType visitMediaTypeStart(@Nonnull OpenApiMediaType schema) {
        return null;
    }

    @Override
    @Nullable
    public OpenApiMediaType visitMediaTypeEnd(@Nonnull OpenApiMediaType schema) {
        return null;
    }
}
