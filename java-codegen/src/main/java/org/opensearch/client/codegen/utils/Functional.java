/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen.utils;

import java.util.function.Function;

public final class Functional {
    private Functional() {}

    public static <T, R> R ifNonnull(T value, Function<T, R> mapper) {
        return value != null ? mapper.apply(value) : null;
    }
}
