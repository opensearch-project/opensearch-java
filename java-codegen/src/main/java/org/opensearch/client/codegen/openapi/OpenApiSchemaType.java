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

public enum OpenApiSchemaType {
    ARRAY,
    BOOLEAN,
    INTEGER,
    NUMBER,
    OBJECT,
    STRING;

    @Nonnull
    public static OpenApiSchemaType from(@Nonnull String type) {
        Strings.requireNonBlank(type, "type must not be blank");
        return OpenApiSchemaType.valueOf(type.toUpperCase());
    }
}
