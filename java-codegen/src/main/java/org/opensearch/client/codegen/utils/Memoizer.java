/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen.utils;

import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import javax.annotation.Nonnull;

public class Memoizer<I, O> {
    @Nonnull
    private final Map<I, O> cache = new ConcurrentHashMap<>();
    @Nonnull
    private final Set<I> calculating = ConcurrentHashMap.newKeySet();
    @Nonnull
    private final Function<I, O> getter;

    public Memoizer(@Nonnull Function<I, O> getter) {
        this.getter = Objects.requireNonNull(getter, "getter cannot be null");
    }

    @Nonnull
    public O get(@Nonnull I input) {
        if (cache.containsKey(Objects.requireNonNull(input, "input cannot be null"))) {
            return cache.get(input);
        }
        var alreadyCalculating = !calculating.add(input);
        var result = getter.apply(input);
        if (!alreadyCalculating) {
            cache.put(input, result);
            calculating.remove(input);
        }
        return result;
    }
}
