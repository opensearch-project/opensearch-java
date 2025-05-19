/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen.utils;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public final class Maps {
    private Maps() {}

    @Nonnull
    public static <TKey, TValue> Optional<TValue> tryGet(@Nullable Map<TKey, TValue> map, @Nonnull TKey key) {
        Objects.requireNonNull(key, "key must not be null");
        return Optional.ofNullable(map).flatMap(m -> Optional.ofNullable(m.get(key)));
    }

    @Nonnull
    public static <TKey, TValue> Map<TKey, TValue> createLookupOf(@Nonnull TValue[] values, @Nonnull Function<TValue, TKey> by) {
        Objects.requireNonNull(values, "values must not be null");
        return createLookupOf(Arrays.stream(values), by);
    }

    @Nonnull
    public static <TKey, TValue> Map<TKey, TValue> createLookupOf(@Nonnull Stream<TValue> values, @Nonnull Function<TValue, TKey> by) {
        Objects.requireNonNull(values, "values must not be null");
        Objects.requireNonNull(by, "by must not be null");
        return values.collect(Collectors.toMap(by, Function.identity()));
    }

    @Nonnull
    public static <TKey, TValue> Optional<Map<TKey, TValue>> unmodifiableOpt(@Nullable Map<TKey, TValue> map) {
        return Optional.ofNullable(map).map(Collections::unmodifiableMap);
    }

    @Nonnull
    public static <TOldKey, TOldValue, TNewKey, TNewValue> Map<TNewKey, TNewValue> transform(
        @Nonnull Map<TOldKey, TOldValue> map,
        @Nonnull EntryMapper<TOldKey, TOldValue, TNewKey> keyMapper,
        @Nonnull EntryMapper<TOldKey, TOldValue, TNewValue> valueMapper
    ) {
        Objects.requireNonNull(map, "map must not be null");
        Objects.requireNonNull(keyMapper, "keyMapper must not be null");
        Objects.requireNonNull(valueMapper, "valueMapper must not be null");
        return map.entrySet().stream().collect(Collectors.toMap(keyMapper::map, valueMapper::map));
    }

    @FunctionalInterface
    public interface EntryMapper<TKey, TValue, TResult> {
        @Nonnull
        TResult map(@Nonnull TKey key, @Nonnull TValue value);

        @Nonnull
        default TResult map(@Nonnull Map.Entry<TKey, TValue> entry) {
            return map(entry.getKey(), entry.getValue());
        }
    }
}
