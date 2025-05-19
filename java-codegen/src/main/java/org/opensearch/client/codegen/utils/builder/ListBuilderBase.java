/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen.utils.builder;

import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public abstract class ListBuilderBase<V, Builder extends ListBuilderBase<V, Builder>> extends ObjectBuilderBase<List<V>, Builder> {
    @Nullable
    private List<V> list;

    protected ListBuilderBase() {}

    @Override
    protected final @Nonnull List<V> construct() {
        return _mutableList(list);
    }

    public final @Nonnull Builder with(@Nonnull List<V> list) {
        this.list = _listAddAll(this.list, list);
        return self();
    }

    @SafeVarargs
    public final @Nonnull Builder with(@Nonnull V value, @Nonnull V... values) {
        this.list = _listAdd(this.list, value, values);
        return self();
    }
}
