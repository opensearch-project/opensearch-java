/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen.utils.builder;

import java.util.Objects;
import java.util.function.Function;
import javax.annotation.Nonnull;

public abstract class ObjectMapBuilderBase<
    K,
    V,
    VBuilder extends ObjectBuilder<V>,
    Builder extends ObjectMapBuilderBase<K, V, VBuilder, Builder>> extends MapBuilderBase<K, V, Builder> {
    protected ObjectMapBuilderBase() {}

    protected abstract @Nonnull VBuilder valueBuilder();

    public final @Nonnull Builder with(@Nonnull K key, @Nonnull Function<VBuilder, ObjectBuilder<V>> fn) {
        return with(key, Objects.requireNonNull(fn, "fn must not be null").apply(valueBuilder()).build());
    }
}
