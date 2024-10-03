/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen.utils.builder;

import java.util.Set;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public abstract class SetBuilderBase<V, Builder extends SetBuilderBase<V, Builder>> extends ObjectBuilderBase<Set<V>, Builder> {
    @Nullable
    private Set<V> set;

    protected SetBuilderBase() {}

    @Override
    protected final @Nonnull Set<V> construct() {
        return _mutableSet(set);
    }

    public final @Nonnull Builder with(@Nonnull Set<V> set) {
        this.set = _setAddAll(this.set, set);
        return self();
    }

    @SafeVarargs
    public final @Nonnull Builder with(@Nonnull V value, @Nonnull V... values) {
        this.set = _setAdd(this.set, value, values);
        return self();
    }
}
