/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen.model.types;

import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.opensearch.client.codegen.model.Shape;

/**
 * Decorates a {@link TypeRef} as {@link #isNullable()}, delegating everything else unchanged -- in particular,
 * {@link #getListValueType()} and the other nested-type accessors return the plain, non-nullable delegate's values,
 * so a list's item type is never itself treated as nullable. See {@link TypeRef#asNullable()}.
 */
final class NullableTypeRef extends TypeRef {
    @Nonnull
    private final TypeRef delegate;

    NullableTypeRef(@Nonnull TypeRef delegate) {
        this.delegate = Objects.requireNonNull(delegate, "delegate must not be null");
    }

    @Override
    public boolean isNullable() {
        return true;
    }

    @Override
    public String getName() {
        return delegate.getName();
    }

    @Override
    public boolean hasTypeParams() {
        return delegate.hasTypeParams();
    }

    @Nullable
    @Override
    public TypeRef[] getTypeParams() {
        return delegate.getTypeParams();
    }

    @Override
    public boolean isTypeParameterRef() {
        return delegate.isTypeParameterRef();
    }

    @Override
    public boolean canQueryParamify() {
        return delegate.canQueryParamify();
    }

    @Override
    public boolean hasBuilder() {
        return delegate.hasBuilder();
    }

    @Override
    public TypeRef getBuilderType() {
        return delegate.getBuilderType();
    }

    @Override
    public TypeRef getBuilderFnType() {
        return delegate.getBuilderFnType();
    }

    @Override
    public boolean isInsidePackage(String packageName) {
        return delegate.isInsidePackage(packageName);
    }

    @Override
    public boolean isList() {
        return delegate.isList();
    }

    @Override
    public TypeRef getListValueType() {
        return delegate.getListValueType();
    }

    @Override
    public boolean isMap() {
        return delegate.isMap();
    }

    @Override
    public TypeRef getMapEntryType() {
        return delegate.getMapEntryType();
    }

    @Override
    public TypeRef getMapKeyType() {
        return delegate.getMapKeyType();
    }

    @Override
    public TypeRef getMapValueType() {
        return delegate.getMapValueType();
    }

    @Override
    public boolean isString() {
        return delegate.isString();
    }

    @Override
    public boolean isEnum() {
        return delegate.isEnum();
    }

    @Override
    public boolean isPotentiallyBoxedPrimitive() {
        return delegate.isPotentiallyBoxedPrimitive();
    }

    @Override
    public boolean isNumber() {
        return delegate.isNumber();
    }

    @Override
    public Optional<Shape> getTargetShape() {
        return delegate.getTargetShape();
    }

    @Override
    public TypeRef getBoxed() {
        return delegate.getBoxed();
    }

    @Override
    public String toString() {
        return delegate.toString();
    }

    @Override
    public void getRequiredImports(Set<String> imports, String currentPkg) {
        delegate.getRequiredImports(imports, currentPkg);
    }

    @Override
    public Type getNestedType(String name) {
        return delegate.getNestedType(name);
    }
}
