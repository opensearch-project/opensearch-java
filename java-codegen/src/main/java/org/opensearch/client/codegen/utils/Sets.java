/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen.utils;

import java.util.Collections;
import java.util.Optional;
import java.util.Set;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public final class Sets {
    private Sets() {}

    @Nonnull
    public static <T> Optional<Set<T>> unmodifiableOpt(@Nullable Set<T> set) {
        return Optional.ofNullable(set).map(Collections::unmodifiableSet);
    }
}
