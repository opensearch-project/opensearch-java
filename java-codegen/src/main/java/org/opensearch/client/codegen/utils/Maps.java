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
import java.util.Optional;
import java.util.stream.Collectors;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public final class Maps {
    private Maps() {}

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
