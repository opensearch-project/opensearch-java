/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen.model;

import static org.opensearch.client.codegen.Renderer.templateLambda;
import static org.opensearch.client.codegen.model.Types.*;

import com.samskivert.mustache.Mustache;
import io.swagger.v3.oas.models.media.Schema;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;
import org.opensearch.client.codegen.Renderer;
import org.opensearch.client.codegen.utils.Schemas;

public class Type {
    private static final Set<String> PRIMITIVES = Set.of(
        "String",
        "boolean",
        "Boolean",
        "char",
        "Character",
        "byte",
        "Byte",
        "short",
        "Short",
        "int",
        "Integer",
        "long",
        "Long",
        "float",
        "Float",
        "double",
        "Double"
    );

    public static Builder builder() {
        return new Builder();
    }

    private final Schema<?> schema;
    private final String pkg;
    private final String name;
    private final Type[] genericArgs;

    private Type(Schema<?> schema, String pkg, String name, Type... genericArgs) {
        this.schema = schema;
        this.pkg = pkg;
        this.name = name;
        this.genericArgs = genericArgs;
    }

    @Override
    public String toString() {
        String str = name;
        if (genericArgs != null && genericArgs.length > 0) {
            str += "<";
            str += Arrays.stream(genericArgs).map(Type::toString).collect(Collectors.joining(", "));
            str += ">";
        }
        return str;
    }

    public Type boxed() {
        switch (name) {
            case "char":
                return Java.Lang.Character;
            case "boolean":
                return Java.Lang.Boolean;
            case "byte":
                return Java.Lang.Byte;
            case "short":
                return Java.Lang.Short;
            case "int":
                return Java.Lang.Integer;
            case "long":
                return Java.Lang.Long;
            case "float":
                return Java.Lang.Float;
            case "double":
                return Java.Lang.Double;
            default:
                return this;
        }
    }

    public boolean isMap() {
        return "Map".equals(name);
    }

    public Type mapEntryType() {
        if (!isMap()) return null;

        return Java.Util.MapEntry(this.genericArgs[0], this.genericArgs[1]);
    }

    public Type mapKeyType() {
        if (!isMap()) return null;

        return this.genericArgs[0];
    }

    public Type mapValueType() {
        if (!isMap()) return null;

        return this.genericArgs[1];
    }

    public boolean isList() {
        return "List".equals(name);
    }

    public Type listValueType() {
        if (!isList()) return null;

        return this.genericArgs[0];
    }

    public boolean isListOrMap() {
        return isList() || isMap();
    }

    public boolean isString() {
        return "String".equals(name);
    }

    public boolean isPrimitive() {
        return PRIMITIVES.contains(name);
    }

    public boolean isEnum() {
        return Schemas.hasEnums(schema);
    }

    public boolean isTime() {
        return "Time".equals(name);
    }

    public boolean isBuiltIn() {
        return isListOrMap() || isPrimitive() || "JsonData".equals(name);
    }

    public boolean hasBuilder() {
        return !isBuiltIn() && !isEnum();
    }

    public Type builderType() {
        if (!hasBuilder()) return null;

        return builder()
                .pkg(pkg)
                .name(name + ".Builder")
                .build();
    }

    public Type builderFuncType() {
        if (!hasBuilder()) return null;

        return Java.Util.Function.Function(builderType(), Client.Util.ObjectBuilder(this));
    }

    public Mustache.Lambda serializer() {
        return Renderer.templateLambda(
            "Type/serializer",
            frag -> new SerializerLambdaContext(
                Type.this,
                frag.execute(),
                frag.context() instanceof SerializerLambdaContext ? ((SerializerLambdaContext) frag.context()).depth + 1 : 0
            )
        );
    }

    public void getRequiredImports(Set<String> imports, String currentPkg) {
        if (pkg != null && !pkg.equals(Java.Lang.PACKAGE) && !pkg.equals(currentPkg)) {
            var dotIdx = name.indexOf('.');
            imports.add(pkg + '.' + (dotIdx > 0 ? name.substring(0, dotIdx) : name));
        }
        if (genericArgs != null) {
            for (Type arg : genericArgs) {
                arg.getRequiredImports(imports, currentPkg);
            }
        }
    }

    public Type withGenericArgs(Type... genericArgs) {
        return new Type(schema, pkg, name, genericArgs);
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
        return templateLambda("Type/queryParamify", frag -> new Object() {
            final Type type = Type.this;
            final String value = frag.execute();
        });
    }

    public static class Builder {
        private Schema<?> schema;
        private String pkg;
        private String name;
        private Type[] genericArgs;

        public Builder schema(Schema<?> schema) {
            this.schema = schema;
            return this;
        }

        public Builder pkg(String pkg) {
            this.pkg = pkg;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder genericArgs(Type... genericArgs) {
            this.genericArgs = genericArgs;
            return this;
        }

        public Type build() {
            return new Type(schema, pkg, name, genericArgs);
        }
    }
}
