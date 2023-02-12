package org.opensearch.client.codegen.model;

import com.samskivert.mustache.Mustache;
import org.openapi4j.parser.model.v3.Schema;
import org.opensearch.client.codegen.utils.Schemas;

import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class Type {
    private static final Set<String> PRIMITIVES = Set.of(
            "String",
            "boolean", "Boolean",
            "char", "Character",
            "byte", "Byte",
            "short", "Short",
            "int", "Integer",
            "long", "Long",
            "float", "Float",
            "double", "Double"
    );

    private final Schema schema;
    private final String name;
    private final Type[] genericArgs;

    private Type(String name) {
        this(null, name);
    }

    public Type(Schema schema, String name) {
        this.schema = schema;
        this.name = name;
        this.genericArgs = null;
    }

    public Type(Schema schema, String name, String... genericArgs) {
        this(schema, name, Arrays.stream(genericArgs).map(Type::new).toArray(Type[]::new));
    }

    public Type(Schema schema, String name, Type... genericArgs) {
        this.schema = schema;
        this.name = name;
        this.genericArgs = genericArgs;
    }

    @Override
    public String toString() {
        String str = name;
        if (genericArgs != null && genericArgs.length > 0) {
            str += "<";
            str += Arrays.stream(genericArgs)
                    .map(Type::toString)
                    .collect(Collectors.joining(", "));
            str += ">";
        }
        return str;
    }

    public Type boxed() {
        switch (name) {
            case "char": return new Type(schema, "Character");
            case "boolean": return new Type(schema, "Boolean");
            case "byte": return new Type(schema, "Byte");
            case "short": return new Type(schema, "Short");
            case "int": return new Type(schema, "Integer");
            case "long": return new Type(schema, "Long");
            case "float": return new Type(schema, "Float");
            case "double": return new Type(schema, "Double");
            default: return this;
        }
    }

    public boolean isMap() { return "Map".equals(name); }

    public Type mapEntryType() {
        if (!isMap()) return null;

        return new Type(null, "Map.Entry", this.genericArgs);
    }

    public Type mapKeyType() {
        if (!isMap()) return null;

        return this.genericArgs[0];
    }

    public Type mapValueType() {
        if (!isMap()) return null;

        return this.genericArgs[1];
    }

    public boolean isList() { return "List".equals(name); }

    public Type listValueType() {
        if (!isList()) return null;

        return this.genericArgs[0];
    }

    public boolean isListOrMap() { return isList() || isMap(); }

    public boolean isPrimitive() { return PRIMITIVES.contains(name); }

    public boolean isBuiltIn() { return isListOrMap() || isPrimitive(); }

    public Type builderType() {
        if (isBuiltIn()) return null;

        return new Type(name + ".Builder");
    }

    public Type builderFuncType() {
        if (isBuiltIn()) return null;

        return new Type(null, "Function", builderType(), new Type(null, "ObjectBuilder", this));
    }

    public Mustache.Lambda isDefined() {
        return (frag, out) -> {
            String value = frag.execute();
            if (isListOrMap()) {
                out.write("ApiTypeHelper.isDefined(" + value + ")");
            } else {
                out.write(value + " != null");
            }
        };
    }

    public Mustache.Lambda serializer() {
        return (frag, out) -> serializer(frag.execute(), out, 0);
    }

    private void serializer(String value, Writer out, int depth) throws IOException {
        if (isMap()) {
            String item = "item" + depth;
            out.write("generator.writeStartObject();\n");
            out.write("for (" + mapEntryType() + " " + item + " : " + value + ".entrySet()) {\n");
            out.write("    generator.writeKey(" + item + ".getKey());\n");
            mapValueType().serializer(item + ".getValue()", out, depth + 1);
            out.write("\n}\n");
            out.write("generator.writeEnd();");
        } else if (isList()) {
            String item = "item" + depth;
            out.write("generator.writeStartArray();\n");
            out.write("for (" + listValueType() + " " + item + " : " + value + ") {\n");
            listValueType().serializer(item, out, depth + 1);
            out.write("\n}\n");
            out.write("generator.writeEnd();");
        } else if (isPrimitive()) {
            out.write("generator.write(" + value + ");");
        } else {
            out.write(value + ".serialize(generator, mapper);");
        }
    }

    public String deserializer() {
        switch (name) {
            case "String":
                return "JsonpDeserializer.stringDeserializer()";

            case "boolean":
            case "Boolean":
                return "JsonpDeserializer.booleanDeserializer()";

            case "int":
            case "Integer":
                return "JsonpDeserializer.integerDeserializer()";

            case "long":
            case "Long":
                return "JsonpDeserializer.longDeserializer()";

            case "float":
            case "Float":
                return "JsonpDeserializer.floatDeserializer()";

            case "double":
            case "Double":
                return "JsonpDeserializer.doubleDeserializer()";

            case "List":
                return "JsonpDeserializer.arrayDeserializer(" + listValueType().deserializer() + ")";

            case "Map":
                return "JsonpDeserializer.stringMapDeserializer(" + mapValueType().deserializer() + ")";

            default:
                return name + "._DESERIALIZER";
        }
    }

    public Mustache.Lambda queryParamify() {
        return (frag, out) -> out.write(queryParamify(frag.execute()));
    }

    public String queryParamify(String value) {
        if (Schemas.isString(schema) || "String".equals(name)) {
            return Schemas.hasEnums(schema) ? value + ".jsonValue()" : value;
        } else if (isPrimitive()) {
            return "String.valueOf(" + value + ")";
        } else if (isList()) {
            return value + ".stream().map(v -> " + listValueType().queryParamify("v") + ").collect(Collectors.joining(\",\"))";
        }

        throw new UnsupportedOperationException("Don't know how to queryParamify " + value + " with type: " + this);
    }
}
