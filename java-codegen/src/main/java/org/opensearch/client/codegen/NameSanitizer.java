package org.opensearch.client.codegen;

import org.apache.commons.text.CaseUtils;

import java.util.HashSet;
import java.util.Set;

public class NameSanitizer {
    private static final Set<String> reservedWords = new HashSet<>(){{
        add("transient");
    }};

    public static String wireNameToField(String wireName) {
        String name = CaseUtils.toCamelCase(wireName, false, '_');
        if (reservedWords.contains(name)) {
            name += "_";
        }
        return name;
    }
}
