/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen.openapi;

import io.swagger.v3.oas.models.media.Content;
import javax.annotation.Nonnull;
import org.opensearch.client.codegen.utils.builder.ToBuilder;

public final class OpenApiContent extends OpenApiMapElement<OpenApiContent, MimeType, OpenApiMediaType>
    implements
        ToBuilder<OpenApiContent.Builder> {
    private OpenApiContent(@Nonnull Builder builder) {
        super(builder);
    }

    OpenApiContent(@Nonnull Content content) {
        super(content, MimeType::from, OpenApiMediaType::new);
    }

    @Override
    public @Nonnull OpenApiContent clone() {
        return toBuilder().build();
    }

    @Override
    public @Nonnull Builder toBuilder() {
        return super.toBuilder(builder());
    }

    public static @Nonnull Builder builder() {
        return new Builder();
    }

    public static final class Builder extends OpenApiMapElement.AbstractBuilder<OpenApiContent, MimeType, OpenApiMediaType, Builder> {
        private Builder() {}

        @Nonnull
        @Override
        public OpenApiContent construct() {
            return new OpenApiContent(this);
        }
    }
}
