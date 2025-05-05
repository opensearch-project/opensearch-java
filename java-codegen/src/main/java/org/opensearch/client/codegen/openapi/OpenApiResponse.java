/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen.openapi;

import io.swagger.v3.oas.models.responses.ApiResponse;
import javax.annotation.Nonnull;
import org.opensearch.client.codegen.utils.builder.ToBuilder;

public final class OpenApiResponse extends OpenApiOperationBodyElement<OpenApiResponse> implements ToBuilder<OpenApiResponse.Builder> {
    private OpenApiResponse(@Nonnull Builder builder) {
        super(builder, OpenApiResponse.class);
    }

    OpenApiResponse(@Nonnull ApiResponse response) {
        super(response.get$ref(), response.getContent(), OpenApiResponse.class);
    }

    @Override
    public @Nonnull OpenApiResponse clone() {
        return toBuilder().build();
    }

    @Override
    public @Nonnull Builder toBuilder() {
        return super.toBuilder(builder());
    }

    public static @Nonnull Builder builder() {
        return new Builder();
    }

    public static final class Builder extends OpenApiOperationBodyElement.AbstractBuilder<OpenApiResponse, Builder> {
        private Builder() {}

        @Nonnull
        @Override
        public OpenApiResponse construct() {
            return new OpenApiResponse(this);
        }
    }
}
