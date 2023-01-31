package org.opensearch.client.codegen.utils;

import software.amazon.smithy.utils.CaseUtils;
import software.amazon.smithy.utils.StringUtils;

public class Strings {
    public static String dq(String str) {
        return StringUtils.escapeJavaString(str, "");
    }

    public static String toSnakeCase(String str) {
        return CaseUtils.toSnakeCase(str);
    }

    public static String toPascalCase(String str) {
        return CaseUtils.toPascalCase(toSnakeCase(str));
    }

    public static String toCamelCase(String str) {
        return CaseUtils.toCamelCase(toSnakeCase(str));
    }
}
