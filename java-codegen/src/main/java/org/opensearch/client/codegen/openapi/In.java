/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen.openapi;

import javax.annotation.Nonnull;
import org.opensearch.client.codegen.utils.Strings;

public enum In {
    QUERY,
    PATH;

    @Nonnull
    public static In from(@Nonnull String in) {
        Strings.requireNonBlank(in, "in must not be blank");
        return In.valueOf(in.toUpperCase());
    }
}
