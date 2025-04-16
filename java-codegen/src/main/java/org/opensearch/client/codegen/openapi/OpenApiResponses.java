/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen.openapi;

import io.swagger.v3.oas.models.responses.ApiResponses;
import javax.annotation.Nonnull;
import org.opensearch.client.codegen.utils.builder.ToBuilder;

public final class OpenApiResponses extends OpenApiMapElement<OpenApiResponses, HttpStatusCode, OpenApiResponse>
    implements
        ToBuilder<OpenApiResponses.Builder> {
    private OpenApiResponses(@Nonnull Builder builder) {
        super(builder);
    }

    OpenApiResponses(@Nonnull ApiResponses responses) {
        super(responses, HttpStatusCode::from, OpenApiResponse::new);
    }

    @Override
    public @Nonnull OpenApiResponses clone() {
        return toBuilder().build();
    }

    @Override
    public @Nonnull Builder toBuilder() {
        return super.toBuilder(builder());
    }

    public static @Nonnull Builder builder() {
        return new Builder();
    }

    public static final class Builder extends OpenApiMapElement.AbstractBuilder<
        OpenApiResponses,
        HttpStatusCode,
        OpenApiResponse,
        Builder> {
        private Builder() {}

        @Nonnull
        @Override
        public OpenApiResponses construct() {
            return new OpenApiResponses(this);
        }
    }
}
