/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen.openapi;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.opensearch.client.codegen.utils.Lists;
import org.opensearch.client.codegen.utils.Maps;
import org.opensearch.client.codegen.utils.Strings;

public abstract class OpenApiElement<TSelf extends OpenApiElement<TSelf>> {
    @Nullable
    private final OpenApiElement<?> parent;
    @Nonnull
    private final JsonPointer pointer;

    OpenApiElement(@Nullable OpenApiElement<?> parent, @Nonnull JsonPointer pointer) {
        this.parent = parent;
        this.pointer = Objects.requireNonNull(pointer, "pointer must not be null");
        if (parent != null) {
            this.getSpecification().ifPresent(s -> s.addElement(this.pointer, self()));
        }
    }

    @Nonnull
    @SuppressWarnings("unchecked")
    protected TSelf self() {
        return (TSelf) this;
    }

    @Nonnull
    protected Optional<OpenApiSpecification> getSpecification() {
        return getParent().flatMap(OpenApiElement::getSpecification);
    }

    @Nonnull
    protected Optional<OpenApiElement<?>> getParent() {
        return Optional.ofNullable(parent);
    }

    @Nonnull
    public JsonPointer getPointer() {
        return pointer;
    }

    @Nonnull
    private JsonPointer childPtr(@Nonnull String key) {
        return pointer.append(Strings.requireNonBlank(key, "key must not be blank"));
    }

    @Nullable
    <TIn, TOut> TOut child(@Nonnull String key, @Nullable TIn child, @Nonnull Factory<TSelf, TIn, TOut> factory) {
        if (child == null) {
            return null;
        }
        return Objects.requireNonNull(factory, "factory must not be null").create(self(), childPtr(key), child);
    }

    @Nullable
    <TIn, TOut> List<TOut> children(@Nonnull String key, @Nullable List<TIn> children, @Nonnull Factory<TSelf, TIn, TOut> factory) {
        if (children == null) {
            return null;
        }
        Objects.requireNonNull(factory, "factory must not be null");
        var basePtr = childPtr(key);
        var self = self();
        return Lists.transform(children, (i, v) -> factory.create(self, basePtr.append(String.valueOf(i)), v));
    }

    @Nullable
    <TInKey, TOutKey, TInValue, TOutValue> Map<TOutKey, TOutValue> children(
        @Nullable Map<TInKey, TInValue> children,
        @Nonnull Function<TInKey, TOutKey> keyMapper,
        @Nonnull Factory<TSelf, TInValue, TOutValue> valueFactory
    ) {
        return children(pointer, children, keyMapper, valueFactory);
    }

    @Nullable
    <TKey, TInValue, TOutValue> Map<TKey, TOutValue> children(
        @Nonnull String key,
        @Nullable Map<TKey, TInValue> children,
        @Nonnull Factory<TSelf, TInValue, TOutValue> valueFactory
    ) {
        return children(childPtr(key), children, Function.identity(), valueFactory);
    }

    @Nullable
    <TInKey, TOutKey, TInValue, TOutValue> Map<TOutKey, TOutValue> children(
        @Nonnull JsonPointer basePtr,
        @Nullable Map<TInKey, TInValue> children,
        @Nonnull Function<TInKey, TOutKey> keyMapper,
        @Nonnull Factory<TSelf, TInValue, TOutValue> valueFactory
    ) {
        if (children == null) {
            return null;
        }
        Objects.requireNonNull(basePtr, "basePtr must not be null");
        Objects.requireNonNull(keyMapper, "keyMapper must not be null");
        Objects.requireNonNull(valueFactory, "valueFactory must not be null");
        var self = self();
        return Maps.transform(
            children,
            (k, v) -> keyMapper.apply(k),
            (k, v) -> valueFactory.create(self, basePtr.append(keyMapper.apply(k).toString()), v)
        );
    }

    interface Factory<TParent extends OpenApiElement<TParent>, TIn, TOut> {
        @Nonnull
        TOut create(@Nonnull TParent parent, @Nonnull JsonPointer pointer, @Nonnull TIn value);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("pointer", pointer).toString();
    }
}
