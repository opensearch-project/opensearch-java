/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen.utils;

import java.util.Map;
import java.util.Optional;

public class Maps {
    public static <K, V> Optional<V> tryGet(Map<K, V> map, K key) {
        return Optional.ofNullable(map)
                .flatMap(m -> Optional.ofNullable(m.get(key)));
    }
}
