/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen.model.types;

import java.util.Optional;
import java.util.Set;
import javax.annotation.Nullable;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.opensearch.client.codegen.model.EnumShape;
import org.opensearch.client.codegen.model.Shape;

public class ShapeTypeRef extends TypeRef {
    private final Shape shape;

    public ShapeTypeRef(Shape shape) {
        this.shape = shape;
    }

    @Override
    public String getName() {
        return shape.getClassName();
    }

    @Override
    public boolean hasTypeParams() {
        return shape.getMaterializedType().hasTypeParams();
    }

    @Nullable
    @Override
    public TypeRef[] getTypeParams() {
        return shape.getMaterializedType().getTypeParams();
    }

    @Override
    public boolean isTypeParameterRef() {
        return false;
    }

    @Override
    public boolean canQueryParamify() {
        return isEnum();
    }

    @Override
    public boolean hasBuilder() {
        return !isEnum();
    }

    @Override
    public Type getBuilderType() {
        if (!hasBuilder()) return null;

        return shape.getMaterializedType().getBuilderType();
    }

    @Override
    public Type getBuilderFnType() {
        if (!hasBuilder()) return null;

        return Types.Java.Util.Function.Function(getBuilderType(), Types.Client.Util.ObjectBuilder(this));
    }

    @Override
    public boolean isInsidePackage(String packageName) {
        return shape.getPackageName().startsWith(packageName);
    }

    @Override
    public boolean isList() {
        return false;
    }

    @Override
    public TypeRef getListValueType() {
        return null;
    }

    @Override
    public boolean isMap() {
        return false;
    }

    @Override
    public TypeRef getMapEntryType() {
        return null;
    }

    @Override
    public TypeRef getMapKeyType() {
        return null;
    }

    @Override
    public TypeRef getMapValueType() {
        return null;
    }

    @Override
    public boolean isString() {
        return false;
    }

    @Override
    public boolean isEnum() {
        return shape instanceof EnumShape;
    }

    @Override
    public boolean isPotentiallyBoxedPrimitive() {
        return false;
    }

    @Override
    public Optional<Shape> getTargetShape() {
        return Optional.of(shape);
    }

    @Override
    public TypeRef getBoxed() {
        return this;
    }

    @Override
    public String toString() {
        return shape.getMaterializedType().toString();
    }

    @Override
    protected void collectTypeParameterRefs(Set<TypeParameterRef> refs) {

    }

    @Override
    public void getRequiredImports(Set<String> imports, String currentPkg) {
        shape.getMaterializedType().getRequiredImports(imports, currentPkg);
    }

    @Override
    public Type getNestedType(String name) {
        return shape.getMaterializedType().getNestedType(name);
    }

    public Type getSelfType() {
        return shape.getSelfType();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        ShapeTypeRef that = (ShapeTypeRef) o;

        return new EqualsBuilder().append(shape, that.shape).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(shape).toHashCode();
    }
}
