/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen.model;

import static org.opensearch.client.codegen.model.Types.Client;
import static org.opensearch.client.codegen.model.Types.Java;

import com.samskivert.mustache.Mustache;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;
import org.opensearch.client.codegen.renderer.lambdas.TypeQueryParamifyLambda;
import org.opensearch.client.codegen.renderer.lambdas.TypeSerializerLambda;

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

    private final String pkg;
    private final String name;
    private final Type[] typeParams;
    private final boolean isEnum;

    private Type(Builder builder) {
        this.pkg = builder.pkg;
        this.name = builder.name;
        this.typeParams = builder.typeParams;
        this.isEnum = builder.isEnum;
    }

    public Builder toBuilder() {
        return new Builder().pkg(pkg).name(name).typeParams(typeParams).isEnum(isEnum);
    }

    @Override
    public String toString() {
        String str = name;
        if (typeParams != null && typeParams.length > 0) {
            str += "<";
            str += Arrays.stream(typeParams).map(Type::toString).collect(Collectors.joining(", "));
            str += ">";
        }
        return str;
    }

    public String getName() {
        return name;
    }

    public Type getBoxed() {
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

    public Type getMapEntryType() {
        if (!isMap()) return null;

        return Java.Util.MapEntry(this.typeParams[0], this.typeParams[1]);
    }

    public Type getMapKeyType() {
        if (!isMap()) return null;

        return this.typeParams[0];
    }

    public Type getMapValueType() {
        if (!isMap()) return null;

        return this.typeParams[1];
    }

    public boolean isList() {
        return "List".equals(name);
    }

    public Type getListValueType() {
        if (!isList()) return null;

        return this.typeParams[0];
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
        return isEnum;
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

    public Type getBuilderType() {
        if (!hasBuilder()) return null;

        return getNestedType("Builder");
    }

    public Type getBuilderFnType() {
        if (!hasBuilder()) return null;

        return Java.Util.Function.Function(getBuilderType(), Client.Util.ObjectBuilder(this));
    }

    public Type getNestedType(String name) {
        return builder().pkg(pkg).name(this.name + "." + name).build();
    }

    public Mustache.Lambda serializer() {
        return new TypeSerializerLambda(this, false);
    }

    public Mustache.Lambda directSerializer() {
        return new TypeSerializerLambda(this, true);
    }

    public void getRequiredImports(Set<String> imports, String currentPkg) {
        if (pkg != null && !pkg.equals(Java.Lang.PACKAGE) && !pkg.equals(currentPkg)) {
            var dotIdx = name.indexOf('.');
            imports.add(pkg + '.' + (dotIdx > 0 ? name.substring(0, dotIdx) : name));
        }
        if (typeParams != null) {
            for (Type arg : typeParams) {
                arg.getRequiredImports(imports, currentPkg);
            }
        }
    }

    public Type withTypeParams(Type... typeParams) {
        return toBuilder().typeParams(typeParams).build();
    }

    public Mustache.Lambda queryParamify() {
        return new TypeQueryParamifyLambda(this);
    }

    public static final class Builder {
        private String pkg;
        private String name;
        private Type[] typeParams;
        private boolean isEnum;

        public Builder pkg(String pkg) {
            this.pkg = pkg;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder typeParams(Type... typeParams) {
            this.typeParams = typeParams;
            return this;
        }

        public Builder isEnum(boolean isEnum) {
            this.isEnum = isEnum;
            return this;
        }

        public Type build() {
            return new Type(this);
        }
    }
}
