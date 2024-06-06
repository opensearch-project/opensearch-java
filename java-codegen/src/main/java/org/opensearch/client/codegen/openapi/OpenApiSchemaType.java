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

public enum OpenApiSchemaType {
    Array,
    Boolean,
    Integer,
    Number,
    Object,
    String;

    private static final Map<String, OpenApiSchemaType> VALUES = Maps.createLookupOf(values(), OpenApiSchemaType::toString);

    @Nonnull
    public static OpenApiSchemaType from(@Nonnull String type) {
        var value = VALUES.get(Strings.requireNonBlank(type, "type must not be blank"));
        if (value == null) {
            throw new IllegalArgumentException("Unknown type: " + type);
        }
        return value;
    }

    @Override
    public java.lang.String toString() {
        return name().toLowerCase();
    }
}
