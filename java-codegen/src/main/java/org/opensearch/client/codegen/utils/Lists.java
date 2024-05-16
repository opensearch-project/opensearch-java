/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen.utils;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;
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
    public static <TOld, TNew> List<TNew> transform(@Nonnull List<TOld> list, @Nonnull Function<TOld, TNew> function) {
        Objects.requireNonNull(list, "list must not be null");
        Objects.requireNonNull(function, "function must not be null");
        return list.stream().map(function).collect(Collectors.toList());
    }

    @Nonnull
    public static <TOld, TNew> List<TNew> transform(@Nonnull List<TOld> list, @Nonnull ItemMapper<TOld, TNew> function) {
        Objects.requireNonNull(list, "list must not be null");
        Objects.requireNonNull(function, "function must not be null");
        return IntStream.range(0, list.size()).mapToObj(i -> function.map(i, list.get(i))).toList();
    }

    @FunctionalInterface
    public interface ItemMapper<TIn, TOut> {
        @Nonnull
        TOut map(int index, @Nonnull TIn item);
    }
}
