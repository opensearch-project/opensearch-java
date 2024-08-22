/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen.openapi;

import java.util.Map;
import javax.annotation.Nonnull;
import org.opensearch.client.codegen.utils.Maps;
import org.opensearch.client.codegen.utils.Strings;

public enum OpenApiSchemaFormat {
    Float,
    Double,
    Int32,
    Int64,
    Binary;

    private static final Map<String, OpenApiSchemaFormat> VALUES = Maps.createLookupOf(values(), OpenApiSchemaFormat::toString);

    @Nonnull
    public static OpenApiSchemaFormat from(@Nonnull String format) {
        var value = VALUES.get(Strings.requireNonBlank(format, "format must not be blank"));
        if (value == null) {
            throw new IllegalArgumentException("Unknown format: " + format);
        }
        return value;
    }

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
