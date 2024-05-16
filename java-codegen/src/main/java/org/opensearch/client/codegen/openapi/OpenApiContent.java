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

public class OpenApiContent extends OpenApiMapElement<OpenApiContent, MimeType, OpenApiMediaType> {
    protected OpenApiContent(@Nonnull OpenApiElement<?> parent, @Nonnull JsonPointer pointer, @Nonnull Content content) {
        super(parent, pointer, content, MimeType::from, OpenApiMediaType::new);
    }
}
