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

package org.opensearch.client.codegen.utils.builder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.Function;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public abstract class ObjectBuilderBase<T, Builder extends ObjectBuilderBase<T, Builder>> implements ObjectBuilder<T> {
    private boolean _used = false;

    protected ObjectBuilderBase() {}

    protected @Nonnull Builder self() {
        // noinspection unchecked
        return (Builder) this;
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

    // ----- Conditional utilities

    public final @Nonnull Builder when(boolean condition, @Nonnull Function<Builder, Builder> fn) {
        return condition ? Objects.requireNonNull(fn, "fn must not be null").apply(self()) : self();
    }

    public final @Nonnull <V> Builder whenNonNull(@Nullable V value, @Nonnull BiFunction<Builder, V, Builder> fn) {
        return value != null ? Objects.requireNonNull(fn, "fn must not be null").apply(self(), value) : self();
    }

    @SuppressWarnings("OptionalUsedAsFieldOrParameterType")
    public final @Nonnull <V> Builder whenPresent(@Nonnull Optional<V> value, @Nonnull BiFunction<Builder, V, Builder> fn) {
        return Objects.requireNonNull(value, "value must not be null").isPresent()
            ? Objects.requireNonNull(fn, "fn must not be null").apply(self(), value.get())
            : self();
    }

    // ----- Set utilities

    private static final class OwnedSet<T> extends HashSet<T> {
        OwnedSet() {}

        OwnedSet(Collection<? extends T> c) {
            super(c);
        }
    };

    protected static <T> Set<T> _mutableSet(Set<T> set) {
        if (set == null) {
            return new OwnedSet<>();
        } else if (set instanceof OwnedSet) {
            return set;
        } else {
            // Adding to a set we don't own: make a defensive copy, also ensuring it is mutable.
            return new OwnedSet<>(set);
        }
    }

    @SafeVarargs
    protected static <T> Set<T> _setAdd(Set<T> set, T value, T... values) {
        set = _mutableSet(set);
        set.add(value);
        if (values.length > 0) {
            set.addAll(Arrays.asList(values));
        }
        return set;
    }

    protected static <T> Set<T> _setAddAll(Set<T> set, Set<T> values) {
        if (set == null) {
            // Keep the original set to avoid an unnecessary copy.
            // It will be copied if we add more values.
            return Objects.requireNonNull(values);
        } else {
            set = _mutableSet(set);
            set.addAll(values);
            return set;
        }
    }

    // ----- List utilities

    private static final class OwnedList<T> extends ArrayList<T> {
        OwnedList() {}

        OwnedList(Collection<? extends T> c) {
            super(c);
        }
    };

    protected static <T> List<T> _mutableList(List<T> list) {
        if (list == null) {
            return new OwnedList<>();
        } else if (list instanceof OwnedList) {
            return list;
        } else {
            // Adding to a list we don't own: make a defensive copy, also ensuring it is mutable.
            return new OwnedList<>(list);
        }
    }

    @SafeVarargs
    protected static <T> List<T> _listAdd(List<T> list, T value, T... values) {
        list = _mutableList(list);
        list.add(value);
        if (values.length > 0) {
            list.addAll(Arrays.asList(values));
        }
        return list;
    }

    protected static <T> List<T> _listAddAll(List<T> list, List<T> values) {
        if (list == null) {
            // Keep the original list to avoid an unnecessary copy.
            // It will be copied if we add more values.
            return Objects.requireNonNull(values);
        } else {
            list = _mutableList(list);
            list.addAll(values);
            return list;
        }
    }

    // ----- Map utilities

    private static final class OwnedMap<K, V> extends HashMap<K, V> {
        OwnedMap() {}

        OwnedMap(Map<? extends K, ? extends V> m) {
            super(m);
        }
    }

    protected static <K, V> Map<K, V> _mutableMap(Map<K, V> map) {
        if (map == null) {
            return new OwnedMap<>();
        } else if (map instanceof OwnedMap) {
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
