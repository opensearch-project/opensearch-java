/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen.model.types;

import com.samskivert.mustache.Mustache;
import java.util.Optional;
import java.util.Set;
import javax.annotation.Nullable;
import org.opensearch.client.codegen.model.Shape;
import org.opensearch.client.codegen.renderer.lambdas.TypeIsDefinedLambda;
import org.opensearch.client.codegen.renderer.lambdas.TypeQueryParamifyLambda;
import org.opensearch.client.codegen.renderer.lambdas.TypeSerializerLambda;

public abstract class TypeRef {
    public abstract String getName();

    public abstract boolean hasTypeParams();

    @Nullable
    public abstract TypeRef[] getTypeParams();

    public abstract boolean isTypeParameterRef();

    public abstract boolean canQueryParamify();

    public abstract boolean hasBuilder();

    public abstract TypeRef getBuilderType();

    public abstract TypeRef getBuilderFnType();

    public abstract boolean isInsidePackage(String packageName);

    public abstract boolean isList();

    public abstract TypeRef getListValueType();

    public abstract boolean isMap();

    public abstract TypeRef getMapEntryType();

    public abstract TypeRef getMapKeyType();

    public abstract TypeRef getMapValueType();

    public final boolean isListOrMap() {
        return isList() || isMap();
    }

    public abstract boolean isString();

    public abstract boolean isEnum();

    public abstract boolean isPotentiallyBoxedPrimitive();

    public abstract Optional<Shape> getTargetShape();

    public abstract TypeRef getBoxed();

    public abstract String toString();

    public abstract void getRequiredImports(Set<String> imports, String currentPkg);

    public abstract Type getNestedType(String name);

    public TypeRef getSelfType() {
        return this;
    }

    public final Mustache.Lambda serializer() {
        return new TypeSerializerLambda(this, false);
    }

    public final Mustache.Lambda directSerializer() {
        return new TypeSerializerLambda(this, true);
    }

    public Mustache.Lambda queryParamify() {
        return new TypeQueryParamifyLambda(this);
    }

    public Mustache.Lambda isDefined() {
        return new TypeIsDefinedLambda(this);
    }
}
