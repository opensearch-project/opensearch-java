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
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.jetbrains.annotations.Contract;

public final class Functional {
    private Functional() {}

    @Contract("null,_->null;_,_->_")
    @Nullable
    public static <T, R> R ifNonnull(@Nullable T value, @Nonnull Function<T, R> mapper) {
        Objects.requireNonNull(mapper, "mapper must not be null");
        return value != null ? mapper.apply(value) : null;
    }
}
