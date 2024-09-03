/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen.utils;

import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public abstract class MapBuilderBase<K, V, VBuilder extends ObjectBuilder<V>, Self extends MapBuilderBase<K, V, VBuilder, Self>> extends
    ObjectBuilderBase<Map<K, V>, Self> {
    @Nullable
    private Map<K, V> map;

    protected MapBuilderBase() {}

    protected abstract @Nonnull VBuilder valueBuilder();

    @Override
    protected @Nonnull Map<K, V> construct() {
        return map != null ? Collections.unmodifiableMap(map) : Collections.emptyMap();
    }

    public @Nonnull Self with(@Nonnull Map<K, V> map) {
        this.map = _mapPutAll(this.map, map);
        return self();
    }

    public @Nonnull Self with(@Nonnull K key, @Nonnull V value) {
        this.map = _mapPut(this.map, key, value);
        return self();
    }

    public @Nonnull Self with(@Nonnull K key, @Nonnull Function<VBuilder, ObjectBuilder<V>> fn) {
        return with(key, Objects.requireNonNull(fn, "fn must not be null").apply(valueBuilder()).build());
    }
}
