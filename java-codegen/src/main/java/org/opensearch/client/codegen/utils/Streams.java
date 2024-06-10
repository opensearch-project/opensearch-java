/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen.utils;

import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Stream;
import javax.annotation.Nonnull;

public final class Streams {
    private Streams() {}

    @Nonnull
    public static <T, K extends Comparable<K>> Stream<T> sortedBy(@Nonnull Stream<T> stream, @Nonnull Function<T, K> keyExtractor) {
        Objects.requireNonNull(stream, "stream must not be null");
        Objects.requireNonNull(keyExtractor, "keyExtractor must not be null");
        return stream.sorted((a, b) -> {
            var ka = keyExtractor.apply(a);
            var kb = keyExtractor.apply(b);
            if (ka == null) return kb == null ? 0 : -1;
            if (kb == null) return 1;
            return ka.compareTo(kb);
        });
    }
}
