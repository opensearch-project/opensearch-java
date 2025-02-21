/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen.utils;

import java.util.Map;
import javax.annotation.Nonnull;

public enum JavaAbstractionLevel {
    Abstract("abstract"),
    Concrete(""),
    Final("final");

    private static final Map<String, JavaAbstractionLevel> VALUES = Maps.createLookupOf(values(), JavaAbstractionLevel::toString);

    private final String value;

    JavaAbstractionLevel(String value) {
        this.value = value;
    }

    @Nonnull
    public static JavaAbstractionLevel from(@Nonnull String level) {
        var value = VALUES.get(Strings.requireNonBlank(level, "level must not be blank"));
        if (value == null) {
            throw new IllegalArgumentException("Unknown level: " + level);
        }
        return value;
    }

    @Override
    public String toString() {
        return this.value;
    }
}
