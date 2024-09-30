/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen.utils;

import javax.annotation.Nonnull;
import org.semver4j.Semver;

public final class Versions {
    private Versions() {}

    public static final Semver V2_0_0 = Semver.of(2, 0, 0);

    @Nonnull
    public static Semver coerce(String str) {
        var version = Semver.coerce(str);
        if (version == null) throw new IllegalArgumentException("Unable to coerce `" + str + "` to semver");
        return version;
    }
}
