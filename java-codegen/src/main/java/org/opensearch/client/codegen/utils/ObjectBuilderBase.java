/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

/*
 * Licensed to Elasticsearch B.V. under one or more contributor
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
 * ownership. Elasticsearch B.V. licenses this file to you under
 * the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

/*
 * Modifications Copyright OpenSearch Contributors. See
 * GitHub history for details.
 */

package org.opensearch.client.codegen.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import javax.annotation.Nonnull;

public abstract class ObjectBuilderBase<T, Self extends ObjectBuilderBase<T, Self>> implements ObjectBuilder<T> {
    private boolean _used = false;

    protected ObjectBuilderBase() {}

    protected @Nonnull Self self() {
        // noinspection unchecked
        return (Self) this;
    }

    protected abstract @Nonnull T construct();

    protected final void _ensureSingleUse() {
        if (this._used) {
            throw new IllegalStateException("Object builders can only be used once");
        }
        this._used = true;
    }

    @Override
    public final @Nonnull T build() {
        var self = self();
        self._ensureSingleUse();
        return self.construct();
    }

    // ----- Map utilities

    private static final class OwnedMap<K, V> extends HashMap<K, V> {
        OwnedMap() {}

        OwnedMap(Map<? extends K, ? extends V> m) {
            super(m);
        }
    }

    private static <K, V> Map<K, V> _mutableMap(Map<K, V> map) {
        if (map == null) {
            return new OwnedMap<>();
        } else if (map instanceof ObjectBuilderBase.OwnedMap) {
            return map;
        } else {
            // Adding to a map we don't own: make a defensive copy, also ensuring it is mutable.
            return new OwnedMap<>(map);
        }
    }

    protected static <K, V> Map<K, V> _mapPut(Map<K, V> map, K key, V value) {
        map = _mutableMap(map);
        map.put(key, value);
        return map;
    }

    protected static <K, V> Map<K, V> _mapPutAll(Map<K, V> map, Map<K, V> entries) {
        if (map == null) {
            // Keep the original map to avoid an unnecessary copy.
            // It will be copied if we add more entries.
            return Objects.requireNonNull(entries);
        } else {
            map = _mutableMap(map);
            map.putAll(entries);
            return map;
        }
    }
}
