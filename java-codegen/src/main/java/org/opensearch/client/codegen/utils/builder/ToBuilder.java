/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen.utils.builder;

import javax.annotation.Nonnull;

public interface ToBuilder<Builder extends ObjectBuilder<?>> {
    @Nonnull
    Builder toBuilder();
}
