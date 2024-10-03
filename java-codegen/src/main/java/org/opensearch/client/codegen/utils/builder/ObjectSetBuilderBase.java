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

public abstract class ObjectSetBuilderBase<V, VBuilder extends ObjectBuilder<V>, Builder extends ObjectSetBuilderBase<V, VBuilder, Builder>>
    extends SetBuilderBase<V, Builder> {
    protected ObjectSetBuilderBase() {}

    protected abstract @Nonnull VBuilder valueBuilder();

    public final @Nonnull Builder with(@Nonnull Function<VBuilder, ObjectBuilder<V>> fn) {
        return with(Objects.requireNonNull(fn, "fn must not be null").apply(valueBuilder()).build());
    }
}
