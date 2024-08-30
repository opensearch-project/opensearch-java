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

public abstract class ObjectBuilderBase<T, Self extends ObjectBuilderBase<T, Self>> implements ObjectBuilder<T> {
    private final Function<Self, T> ctor;
    private boolean _used = false;

    protected ObjectBuilderBase(Function<Self, T> ctor) {
        this.ctor = Objects.requireNonNull(ctor, "ctor must not be null");
    }

    @Nonnull
    protected abstract Self self();

    @Override
    public @Nonnull T build() {
        if (this._used) {
            throw new IllegalStateException("Object builders can only be used once");
        }
        this._used = true;
        return ctor.apply(self());
    }
}
