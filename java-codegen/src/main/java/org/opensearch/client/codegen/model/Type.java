/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen.model;

import com.samskivert.mustache.Mustache;
import org.openapi4j.parser.model.v3.Schema;
import org.opensearch.client.codegen.Renderer;
import org.opensearch.client.codegen.utils.Schemas;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import static org.opensearch.client.codegen.Renderer.templateLambda;

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

    public boolean isString() {
        return "String".equals(name);
    }

    public boolean isPrimitive() { return PRIMITIVES.contains(name); }

    public boolean isBuiltIn() { return isListOrMap() || isPrimitive() || "JsonData".equals(name); }

    public boolean hasBuilder() {
        return !isBuiltIn() && !Schemas.hasEnums(schema);
    }

    public Type builderType() {
        if (!hasBuilder()) return null;

        return new Type(name + ".Builder");
    }

    public Type builderFuncType() {
        if (!hasBuilder()) return null;

        return new Type(null, "Function", builderType(), new Type(null, "ObjectBuilder", this));
    }

    public Mustache.Lambda serializer() {
        return Renderer.templateLambda(
                "Type/serializer",
                frag -> new SerializerLambdaContext(
                        Type.this,
                        frag.execute(),
                        frag.context() instanceof SerializerLambdaContext
                                ? ((SerializerLambdaContext) frag.context()).depth + 1
                                : 0
                )
        );
    }

    private static class SerializerLambdaContext {
        public final Type type;
        public final String value;
        public final int depth;

        private SerializerLambdaContext(Type type, String value, int depth) {
            this.type = type;
            this.value = value;
            this.depth = depth;
        }
    }

    public Mustache.Lambda queryParamify() {
        return templateLambda(
                "Type/queryParamify",
                frag -> new Object() {
                    final Type type = Type.this;
                    final String value = frag.execute();
                }
        );
    }
}
