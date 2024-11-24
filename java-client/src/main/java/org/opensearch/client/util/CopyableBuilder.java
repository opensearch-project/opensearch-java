/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.util;

import javax.annotation.Nonnull;

public interface CopyableBuilder<B extends CopyableBuilder<B, T>, T extends ToCopyableBuilder<B, T>> extends MutableBuilder<B, T> {
    /**
     * Create a new builder {@link B} that is a copy of this one.
     *
     * @return a new builder instance.
     *
     * @implNote The default implementation of this method calls {@link #build()} and then {@link T#toBuilder()}.
     *           Implementations can override this method to provide a more efficient implementation or to handle copying
     *           partial state.
     */
    @Nonnull
    default B copy() {
        return build().toBuilder();
    }
}
