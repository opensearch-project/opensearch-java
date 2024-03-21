/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen.utils;

import java.util.Locale;
import org.apache.commons.text.CaseUtils;

public final class Strings {
    private Strings() {}

    public static String toCamelCase(String str) {
        return toCamelCase(str, false);
    }

    public static String toPascalCase(String str) {
        return toCamelCase(str, true);
    }

    private static String toCamelCase(String str, boolean capitalizeFirstLetter) {
        return CaseUtils.toCamelCase(toSnakeCase(str), capitalizeFirstLetter, '_', '.');
    }

    public static String toSnakeCase(String str) {
        return str.replaceAll("([A-Z]+)([A-Z][a-z])", "$1_$2")
            .replaceAll("([a-z\\d])([A-Z])", "$1_$2")
            .replaceAll("(\\s|-)", "_")
            .toLowerCase(Locale.US);
    }
}
