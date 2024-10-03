/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen.utils.builder;

import java.util.Map;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public abstract class MapBuilderBase<K, V, Builder extends MapBuilderBase<K, V, Builder>> extends ObjectBuilderBase<Map<K, V>, Builder> {
    @Nullable
    private Map<K, V> map;

    protected MapBuilderBase() {}

    @Override
    protected final @Nonnull Map<K, V> construct() {
        return _mutableMap(map);
    }

    public final @Nonnull Builder with(@Nonnull Map<K, V> map) {
        this.map = _mapPutAll(this.map, map);
        return self();
    }

    public final @Nonnull Builder with(@Nonnull K key, @Nonnull V value) {
        this.map = _mapPut(this.map, key, value);
        return self();
    }
}
