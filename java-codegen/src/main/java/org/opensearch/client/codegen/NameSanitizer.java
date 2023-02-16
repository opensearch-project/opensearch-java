/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen;

import org.opensearch.client.codegen.utils.Strings;

import java.util.HashSet;
import java.util.Set;

public class NameSanitizer {
    private static final Set<String> reservedWords = new HashSet<>(){{
        add("transient");
    }};

    public static String wireNameToField(String wireName) {
        String name = Strings.toCamelCase(wireName);
        if (reservedWords.contains(name)) {
            name += "_";
        }
        return name;
    }
}
