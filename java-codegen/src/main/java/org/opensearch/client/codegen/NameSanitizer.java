/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen;

import java.util.HashSet;
import java.util.Set;
import org.opensearch.client.codegen.utils.Strings;

public class NameSanitizer {
    private static final Set<String> reservedWords = new HashSet<>() {
        {
            add("default");
            add("native");
            add("transient");
        }
    };

    public static String wireNameToField(String wireName) {
        var name = Strings.toCamelCase(wireName);
        if (reservedWords.contains(name)) {
            name += "_";
        }
        return name;
    }
}
