/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen.openapi;

import java.util.Map;
import javax.annotation.Nonnull;
import org.opensearch.client.codegen.utils.Maps;
import org.opensearch.client.codegen.utils.Strings;

public enum In {
    Query,
    Path;

    private static final Map<String, In> VALUES = Maps.createLookupOf(values(), In::toString);

    @Nonnull
    public static In from(@Nonnull String in) {
        var value = VALUES.get(Strings.requireNonBlank(in, "in must not be blank"));
        if (value == null) {
            throw new IllegalArgumentException("Unknown in: " + in);
        }
        return value;
    }

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
