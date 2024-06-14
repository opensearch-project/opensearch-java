/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen.utils;

import java.util.Map;
import javax.annotation.Nonnull;

public enum JavaClassKind {
    Class,
    Enum;

    private static final Map<String, JavaClassKind> VALUES = Maps.createLookupOf(values(), JavaClassKind::toString);

    @Nonnull
    public static JavaClassKind from(@Nonnull String kind) {
        var value = VALUES.get(Strings.requireNonBlank(kind, "kind must not be blank"));
        if (value == null) {
            throw new IllegalArgumentException("Unknown kind: " + kind);
        }
        return value;
    }

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
