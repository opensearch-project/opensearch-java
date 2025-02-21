/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.util;

import java.util.Objects;
import java.util.function.Consumer;
import javax.annotation.Nonnull;

public interface MutableBuilder<B extends MutableBuilder<B, T>, T> extends ObjectBuilder<T> {
    /**
     * Apply a mutation to this object.
     *
     * @param mutator the mutation to apply
     * @return this object
     */
    @SuppressWarnings("unchecked")
    @Nonnull
    default B applyMutation(@Nonnull Consumer<? super B> mutator) {
        Objects.requireNonNull(mutator, "mutator must not be null").accept((B) this);
        return (B) this;
    }
}
