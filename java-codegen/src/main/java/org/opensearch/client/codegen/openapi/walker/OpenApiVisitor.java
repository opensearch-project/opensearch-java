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

public interface OpenApiVisitor {
    @Nullable
    OpenApiSpecification visitSpecificationStart(@Nonnull OpenApiSpecification specification);

    @Nullable
    OpenApiSpecification visitSpecificationEnd(@Nonnull OpenApiSpecification specification);

    @Nullable
    OpenApiPath visitPathStart(@Nonnull OpenApiPath path);

    @Nullable
    OpenApiPath visitPathEnd(@Nonnull OpenApiPath path);

    @Nullable
    OpenApiComponents visitComponentsStart(@Nonnull OpenApiComponents components);

    @Nullable
    OpenApiComponents visitComponentsEnd(@Nonnull OpenApiComponents components);

    @Nullable
    OpenApiOperation visitOperationStart(@Nonnull OpenApiOperation operation);

    @Nullable
    OpenApiOperation visitOperationEnd(@Nonnull OpenApiOperation operation);

    @Nullable
    OpenApiParameter visitParameterStart(@Nonnull OpenApiParameter parameter);

    @Nullable
    OpenApiParameter visitParameterEnd(@Nonnull OpenApiParameter parameter);

    @Nullable
    OpenApiSchema visitSchemaStart(@Nonnull OpenApiSchema schema);

    @Nullable
    OpenApiSchema visitSchemaEnd(@Nonnull OpenApiSchema schema);

    @Nullable
    OpenApiDiscriminator visitDiscriminatorStart(@Nonnull OpenApiDiscriminator discriminator);

    @Nullable
    OpenApiDiscriminator visitDiscriminatorEnd(@Nonnull OpenApiDiscriminator discriminator);

    @Nullable
    OpenApiResponse visitResponseStart(@Nonnull OpenApiResponse response);

    @Nullable
    OpenApiResponse visitResponseEnd(@Nonnull OpenApiResponse response);

    @Nullable
    OpenApiRequestBody visitRequestBodyStart(@Nonnull OpenApiRequestBody requestBody);

    @Nullable
    OpenApiRequestBody visitRequestBodyEnd(@Nonnull OpenApiRequestBody requestBody);

    @Nullable
    OpenApiResponses visitResponsesStart(@Nonnull OpenApiResponses responses);

    @Nullable
    OpenApiResponses visitResponsesEnd(@Nonnull OpenApiResponses responses);

    @Nullable
    OpenApiContent visitContentStart(@Nonnull OpenApiContent content);

    @Nullable
    OpenApiContent visitContentEnd(@Nonnull OpenApiContent content);

    @Nullable
    OpenApiMediaType visitMediaTypeStart(@Nonnull OpenApiMediaType schema);

    @Nullable
    OpenApiMediaType visitMediaTypeEnd(@Nonnull OpenApiMediaType schema);
}
