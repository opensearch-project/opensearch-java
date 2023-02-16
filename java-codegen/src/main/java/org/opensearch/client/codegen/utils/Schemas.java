/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen.utils;

import org.openapi4j.core.model.v3.OAI3SchemaKeywords;
import org.openapi4j.parser.model.v3.AbsExtendedOpenApiSchema;
import org.openapi4j.parser.model.v3.AbsExtendedRefOpenApiSchema;
import org.openapi4j.parser.model.v3.Schema;

public final class Schemas {
    public static String getType(Schema schema) { return schema != null ? schema.getType() : null; }
    public static boolean is(Schema schema, String type) { return type.equals(getType(schema)); }

    public static boolean isObject(Schema schema) { return is(schema, OAI3SchemaKeywords.TYPE_OBJECT); }

    public static boolean isString(Schema schema) { return is(schema, OAI3SchemaKeywords.TYPE_STRING); }

    public static boolean hasEnums(Schema schema) { return schema != null && schema.hasEnums(); }

    public static String getNamespaceExtension(AbsExtendedOpenApiSchema<?> schema) {
        return (String) getExtension(schema, "x-namespace");
    }

    public static String getNamespaceExtension(AbsExtendedRefOpenApiSchema<?> schema) {
        return (String) getExtension(schema, "x-namespace");
    }

    public static Object getExtension(AbsExtendedOpenApiSchema<?> schema, String key) {
        return schema.getExtensions().get(key);
    }

    public static Object getExtension(AbsExtendedRefOpenApiSchema<?> schema, String key) {
        return schema.getExtensions().get(key);
    }
}
