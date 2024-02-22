/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen.openapi;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public abstract class OpenApiObject<TInner> {
    private final OpenApiSpec parent;
    private final JsonPointer jsonPtr;
    private final TInner inner;

    protected OpenApiObject(OpenApiSpec parent, JsonPointer jsonPtr, TInner inner) {
        Objects.requireNonNull(inner, "inner cannot be null");
        this.parent = parent;
        this.jsonPtr = jsonPtr;
        this.inner = inner;
    }

    public OpenApiSpec getParent() {
        return parent;
    }

    public JsonPointer getJsonPtr() {
        return jsonPtr;
    }

    public String getLocation() {
        return parent.getLocation().toString() + "#" + jsonPtr;
    }

    public TInner getInner() {
        return inner;
    }

    protected JsonPointer childPtr(String... keys) {
        return getJsonPtr().append(keys);
    }

    private <TChildInner, TChild extends OpenApiObject<TChildInner>> Optional<TChild> childOpt(
        String key,
        TChildInner child,
        Factory<TChildInner, TChild> factory
    ) {
        return Optional.ofNullable(child).map(c -> factory.create(getParent(), getJsonPtr().append(key), c));
    }

    protected <TChildInner, TChild extends OpenApiObject<TChildInner>> Optional<TChild> childOpt(
        String key,
        Function<TInner, TChildInner> getter,
        Factory<TChildInner, TChild> factory
    ) {
        return childOpt(key, getter.apply(getInner()), factory);
    }

    protected <TChildInner, TChild extends OpenApiObject<TChildInner>> Stream<TChild> children(
        String key,
        List<TChildInner> children,
        Factory<TChildInner, TChild> factory
    ) {
        if (children == null || children.isEmpty()) return Stream.empty();
        var basePtr = getJsonPtr().append(key);
        return IntStream.range(0, children.size())
            .mapToObj(i -> factory.create(getParent(), basePtr.append(String.valueOf(i)), children.get(i)));
    }

    protected <TChildInner, TChild extends OpenApiObject<TChildInner>> Stream<TChild> children(
        String key,
        Function<TInner, List<TChildInner>> getter,
        Factory<TChildInner, TChild> factory
    ) {
        return children(key, getter.apply(getInner()), factory);
    }

    protected <TChildInner, TChild extends OpenApiObject<TChildInner>> Optional<List<TChild>> childrenOpt(
        String key,
        Function<TInner, List<TChildInner>> getter,
        Factory<TChildInner, TChild> factory
    ) {
        return Optional.ofNullable(getter.apply(getInner())).map(l -> children(key, l, factory).toList());
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("parent", parent).append("jsonPtr", jsonPtr).append("inner", inner).toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        OpenApiObject<?> that = (OpenApiObject<?>) o;

        return new EqualsBuilder().append(parent, that.parent).append(jsonPtr, that.jsonPtr).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(parent).append(jsonPtr).toHashCode();
    }

    @FunctionalInterface
    public interface Factory<TInner, T extends OpenApiObject<TInner>> {
        T create(OpenApiSpec parent, JsonPointer jsonPtr, TInner inner);
    }
}
