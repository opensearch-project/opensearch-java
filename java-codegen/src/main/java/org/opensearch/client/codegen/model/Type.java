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
import java.util.Set;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.opensearch.client.codegen.renderer.lambdas.TypeIsDefinedLambda;
import org.opensearch.client.codegen.renderer.lambdas.TypeQueryParamifyLambda;
import org.opensearch.client.codegen.renderer.lambdas.TypeSerializerLambda;
import org.opensearch.client.codegen.utils.ObjectBuilderBase;
import org.opensearch.client.codegen.utils.Strings;

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

    @Nullable
    private final String packageName;
    @Nonnull
    private final String name;
    @Nullable
    private final Type[] typeParams;
    private final boolean isEnum;

    private Type(Builder builder) {
        this.packageName = builder.packageName;
        this.name = Strings.requireNonBlank(builder.name, "name must not be blank");
        this.typeParams = builder.typeParams;
        this.isEnum = builder.isEnum;
    }

    public Builder toBuilder() {
        return new Builder().withPackage(packageName).withName(name).withTypeParameters(typeParams).isEnum(isEnum);
    }

    @Override
    public String toString() {
        var out = new StringBuilder();
        out.append(name);
        if (typeParams != null) {
            TypeParameterDiamond.builder().withParams(typeParams).build().toString(out);
        }
        return out.toString();
    }

    @Nonnull
    public String getName() {
        return name;
    }

    @Nonnull
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
        return builder().withPackage(packageName).withName(this.name + "." + name).build();
    }

    public Mustache.Lambda serializer() {
        return new TypeSerializerLambda(this, false);
    }

    public Mustache.Lambda directSerializer() {
        return new TypeSerializerLambda(this, true);
    }

    public void getRequiredImports(Set<String> imports, String currentPkg) {
        if (packageName != null && !packageName.equals(Java.Lang.PACKAGE) && !packageName.equals(currentPkg)) {
            var dotIdx = name.indexOf('.');
            imports.add(packageName + '.' + (dotIdx > 0 ? name.substring(0, dotIdx) : name));
        }
        if (typeParams != null) {
            for (Type arg : typeParams) {
                arg.getRequiredImports(imports, currentPkg);
            }
        }
    }

    public Type withTypeParams(Type... typeParams) {
        return toBuilder().withTypeParameters(typeParams).build();
    }

    public Mustache.Lambda queryParamify() {
        return new TypeQueryParamifyLambda(this);
    }

    public Mustache.Lambda isDefined() {
        return new TypeIsDefinedLambda(this);
    }

    public static final class Builder extends ObjectBuilderBase<Type, Builder> {
        private String packageName;
        private String name;
        private Type[] typeParams;
        private boolean isEnum;

        private Builder() {
            super(Type::new);
        }

        @Override
        protected @Nonnull Builder self() {
            return this;
        }

        @Nonnull
        public Builder withPackage(@Nullable String packageName) {
            this.packageName = packageName;
            return this;
        }

        @Nonnull
        public Builder withName(@Nonnull String name) {
            this.name = Strings.requireNonBlank(name, "name must not be blank");
            return this;
        }

        @Nonnull
        public Builder withTypeParameters(@Nullable Type... typeParams) {
            this.typeParams = typeParams;
            return this;
        }

        @Nonnull
        public Builder isEnum(boolean isEnum) {
            this.isEnum = isEnum;
            return this;
        }
    }
}
