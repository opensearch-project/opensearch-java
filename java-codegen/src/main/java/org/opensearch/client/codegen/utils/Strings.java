/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen.utils;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.apache.commons.text.CaseUtils;
import org.jetbrains.annotations.Contract;

public final class Strings {
    private Strings() {}

    public static boolean isNullOrEmpty(@Nullable String str) {
        return str == null || str.isEmpty();
    }

    public static boolean isNullOrBlank(@Nullable String str) {
        return str == null || str.isBlank();
    }

    @Nonnull
    @Contract(value = "null, _ -> fail; _, _ -> param1", pure = true)
    public static String requireNonBlank(@Nullable String str, @Nullable String message) {
        if (isNullOrBlank(str)) {
            throw new IllegalArgumentException(message);
        }
        return str;
    }

    private static final Map<String, String> SPECIAL_CASE_SNAKE_CASE_CONVERSION = new HashMap<>() {
        {
            put("noop", "no_op");
        }
    };

    @Nonnull
    public static String toSnakeCase(@Nonnull String str) {
        Objects.requireNonNull(str, "str must not be null");
        if (str.isEmpty()) {
            return str;
        }

        var specialCase = SPECIAL_CASE_SNAKE_CASE_CONVERSION.get(str);
        if (specialCase != null) return specialCase;

        return str.replaceAll("([A-Z]+)([A-Z][a-z])", "$1_$2")
            .replaceAll("([a-z\\d])([A-Z])", "$1_$2")
            .replaceAll("(\\s|[-:.])", "_")
            .toLowerCase(Locale.US);
    }

    @Nonnull
    private static String toCamelCase(@Nonnull String str, boolean capitalizeFirstLetter) {
        return CaseUtils.toCamelCase(toSnakeCase(str), capitalizeFirstLetter, '_');
    }

    @Nonnull
    public static String toCamelCase(@Nonnull String str) {
        return toCamelCase(str, false);
    }

    @Nonnull
    public static String toPascalCase(@Nonnull String str) {
        return toCamelCase(str, true);
    }
}
