package org.opensearch.client.codegen.utils;

import java.util.Collection;
import java.util.function.Function;
import java.util.stream.Stream;

public class Streams {
    public static <V> Stream<V> tryOf(Collection<V> list) {
        return list == null ? Stream.empty() : list.stream();
    }

    public static <T, K extends Comparable<K>> Stream<T> sortedBy(Stream<T> stream, Function<T, K> keyExtractor) {
        return stream.sorted((a, b) -> {
            var ka = keyExtractor.apply(a);
            var kb = keyExtractor.apply(b);
            if (ka == null) return kb == null ? 0 : -1;
            if (kb == null) return 1;
            return ka.compareTo(kb);
        });
    }
}
