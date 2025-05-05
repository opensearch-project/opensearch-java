/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen.openapi;

import io.swagger.v3.oas.models.parameters.RequestBody;
import javax.annotation.Nonnull;
import org.opensearch.client.codegen.utils.builder.ToBuilder;

public final class OpenApiRequestBody extends OpenApiOperationBodyElement<OpenApiRequestBody>
    implements
        ToBuilder<OpenApiRequestBody.Builder> {
    private OpenApiRequestBody(@Nonnull OpenApiRequestBody.Builder builder) {
        super(builder, OpenApiRequestBody.class);
    }

    OpenApiRequestBody(@Nonnull RequestBody requestBody) {
        super(requestBody.get$ref(), requestBody.getContent(), OpenApiRequestBody.class);
    }

    @Override
    public @Nonnull OpenApiRequestBody clone() {
        return toBuilder().build();
    }

    @Override
    public @Nonnull Builder toBuilder() {
        return super.toBuilder(builder());
    }

    public static @Nonnull Builder builder() {
        return new Builder();
    }

    public static final class Builder extends OpenApiOperationBodyElement.AbstractBuilder<OpenApiRequestBody, Builder> {
        private Builder() {}

        @Nonnull
        @Override
        public OpenApiRequestBody construct() {
            return new OpenApiRequestBody(this);
        }
    }
}
