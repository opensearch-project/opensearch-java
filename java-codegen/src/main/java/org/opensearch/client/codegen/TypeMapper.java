package org.opensearch.client.codegen;

import org.openapi4j.core.model.OAIContext;
import org.openapi4j.core.model.v3.OAI3SchemaKeywords;
import org.openapi4j.parser.model.v3.Schema;
import org.opensearch.client.codegen.model.Type;
import org.opensearch.client.codegen.utils.Schemas;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BiConsumer;

public class TypeMapper {
    private final OAIContext context;
    private final Map<Schema, Type> cache = new ConcurrentHashMap<>();
    private final BiConsumer<String, Schema> referencedSchemaVisitor;

    public TypeMapper(OAIContext context, BiConsumer<String, Schema> referencedSchemaVisitor) {
        this.context = context;
        this.referencedSchemaVisitor = referencedSchemaVisitor;
    }

    public Type mapType(Schema schema) {
        return mapType(schema, false);
    }

    public Type mapType(Schema schema, boolean boxed) {
        Type type = cache.get(schema);
        if (type == null) {
            type = mapTypeInner(schema);
            cache.put(schema, type);
        }
        return boxed ? type.boxed() : type;
    }

    private Type mapTypeInner(Schema schema) {
        if (schema.isRef()) {
            Schema target = schema.getFlatSchema(context);

            if (!shouldKeepRef(target)) {
                return mapType(target);
            }

            if (Schemas.isObject(target) && target.getProperties() == null) {
                return new Type(target, "Map", "String", "JsonData");
            }

            String ref = schema.getRef();

            referencedSchemaVisitor.accept(ref, target);

            String[] refParts = ref.split("/");
            return new Type(target, refParts[refParts.length - 1]);
        }

        String type = schema.getType();

        if (type == null) {
            return new Type(schema, "JsonData");
        }

        String format = schema.getFormat();

        switch (type) {
            case OAI3SchemaKeywords.TYPE_ARRAY:
                return new Type(schema, "List", mapType(schema.getItemsSchema(), true));
            case OAI3SchemaKeywords.TYPE_STRING:
                return new Type(schema, "String");
            case OAI3SchemaKeywords.TYPE_BOOLEAN:
                return new Type(schema, "boolean");
            case OAI3SchemaKeywords.TYPE_INTEGER:
                if (format == null) format = OAI3SchemaKeywords.FORMAT_INT32;
                switch (format) {
                    case OAI3SchemaKeywords.FORMAT_INT32:
                        return new Type(schema, "int");
                    case OAI3SchemaKeywords.FORMAT_INT64:
                        return new Type(schema, "long");
                    default:
                        throw new UnsupportedOperationException("Can not get type name for integer with format: " + format);
                }
            case OAI3SchemaKeywords.TYPE_NUMBER:
                switch (format) {
                    case OAI3SchemaKeywords.FORMAT_FLOAT:
                        return new Type(schema, "float");
                    case OAI3SchemaKeywords.FORMAT_DOUBLE:
                        return new Type(schema, "double");
                    default:
                        throw new UnsupportedOperationException("Can not get type name for number with format: " + format);
                }
        }

        throw new UnsupportedOperationException("Can not get type name for: " + type);
    }

    private boolean shouldKeepRef(Schema schema) {
        if (Schemas.isObject(schema)) {
            return true;
        }

        if (Schemas.isString(schema)) {
            return schema.hasEnums();
        }

        return false;
    }
}
