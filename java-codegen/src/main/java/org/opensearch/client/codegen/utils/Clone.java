/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen.utils;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.annotation.Nonnull;

public interface Clone<T> {
    T clone();

    static <T extends Clone<T>> List<T> clone(@Nonnull Collection<T> list) {
        return list.stream().map(Clone::clone).collect(Collectors.toList());
    }

    static <K, V extends Clone<V>> Map<K, V> clone(@Nonnull Map<K, V> map) {
        return map.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, e -> e.getValue().clone()));
    }
}
