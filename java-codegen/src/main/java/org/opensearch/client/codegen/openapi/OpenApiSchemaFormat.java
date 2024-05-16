/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen.openapi;

import javax.annotation.Nonnull;
import org.opensearch.client.codegen.utils.Strings;

public enum OpenApiSchemaFormat {
    FLOAT,
    DOUBLE,
    INT32,
    INT64;

    @Nonnull
    public static OpenApiSchemaFormat from(@Nonnull String format) {
        Strings.requireNonBlank(format, "format must not be blank");
        return OpenApiSchemaFormat.valueOf(format.toUpperCase());
    }
}
