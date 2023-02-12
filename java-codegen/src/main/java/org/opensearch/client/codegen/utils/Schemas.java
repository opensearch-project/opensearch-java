package org.opensearch.client.codegen.utils;

import org.openapi4j.core.model.v3.OAI3SchemaKeywords;
import org.openapi4j.parser.model.v3.Schema;

public final class Schemas {
    public static String getType(Schema schema) { return schema != null ? schema.getType() : null; }
    public static boolean is(Schema schema, String type) { return type.equals(getType(schema)); }

    public static boolean isObject(Schema schema) { return is(schema, OAI3SchemaKeywords.TYPE_OBJECT); }

    public static boolean isString(Schema schema) { return is(schema, OAI3SchemaKeywords.TYPE_STRING); }

    public static boolean hasEnums(Schema schema) { return schema != null && schema.hasEnums(); }
}
