/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen.utils;

import java.util.Set;
import javax.annotation.Nonnull;

public class NameSanitizer {
    private static final Set<String> reservedWords = Set.of(
        "default",
        "if",
        "interface",
        "native",
        "transient",
        "boolean",
        "char",
        "byte",
        "short",
        "int",
        "long",
        "float",
        "double"
    );

    @Nonnull
    public static String fieldName(@Nonnull String name) {
        name = Strings.toCamelCase(name);
        if (reservedWords.contains(name)) {
            name += "_";
        }
        if (Character.isDigit(name.charAt(0))) {
            name = "_" + name;
        }
        return name;
    }
}
