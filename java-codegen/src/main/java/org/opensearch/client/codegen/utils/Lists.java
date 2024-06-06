/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen.utils;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public final class Lists {
    private Lists() {}

    @Nonnull
    public static <T> Optional<List<T>> unmodifiableOpt(@Nullable List<T> list) {
        return Optional.ofNullable(list).map(Collections::unmodifiableList);
    }

    @Nonnull
    public static <T> List<T> filter(@Nonnull Collection<T> list, @Nonnull Predicate<T> predicate) {
        Objects.requireNonNull(list, "list must not be null");
        Objects.requireNonNull(predicate, "predicate must not be null");
        return list.stream().filter(predicate).collect(Collectors.toList());
    }

    @Nonnull
    public static <TIn, TOut> List<TOut> map(@Nonnull Collection<TIn> list, @Nonnull Function<TIn, TOut> mapper) {
        Objects.requireNonNull(list, "list must not be null");
        Objects.requireNonNull(mapper, "mapper must not be null");
        return list.stream().map(mapper).collect(Collectors.toList());
    }

    @Nonnull
    public static <TIn, TOut> List<TOut> map(@Nonnull List<TIn> list, @Nonnull ItemMapper<TIn, TOut> mapper) {
        Objects.requireNonNull(list, "list must not be null");
        Objects.requireNonNull(mapper, "mapper must not be null");
        return IntStream.range(0, list.size()).mapToObj(i -> mapper.map(i, list.get(i))).collect(Collectors.toList());
    }

    @FunctionalInterface
    public interface ItemMapper<TIn, TOut> {
        @Nonnull
        TOut map(int index, @Nonnull TIn item);
    }

    @Nonnull
    public static <TIn, TOut> List<TOut> filterMap(
        @Nonnull Collection<TIn> list,
        @Nonnull Predicate<TIn> predicate,
        @Nonnull Function<TIn, TOut> mapper
    ) {
        Objects.requireNonNull(list, "list must not be null");
        Objects.requireNonNull(predicate, "predicate must not be null");
        Objects.requireNonNull(mapper, "mapper must not be null");
        return list.stream().filter(predicate).map(mapper).collect(Collectors.toList());
    }
}
