/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.util;

import java.util.function.Consumer;
import javax.annotation.Nonnull;

public interface ToCopyableBuilder<B extends CopyableBuilder<B, T>, T extends ToCopyableBuilder<B, T>> {
    /**
     * Create a new builder {@link B} that is initialised with the current state of this object.
     *
     * @return a new builder instance.
     */
    @Nonnull
    B toBuilder();

    /**
     * A convenience method for calling {@link #toBuilder()}, updating the returned builder and then calling {@link B#build()}.
     *
     * @param modifier A function that mutates this immutable object using the provided builder.
     * @return A new copy of this object with the requested modifications.
     */
    @Nonnull
    default T copy(@Nonnull Consumer<? super B> modifier) {
        return toBuilder().applyMutation(modifier).build();
    }
}
