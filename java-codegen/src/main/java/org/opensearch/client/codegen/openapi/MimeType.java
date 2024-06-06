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

public enum MimeType {
    Json("application/json"),
    NdJson("application/x-ndjson");

    private static final Map<String, MimeType> VALUES = Maps.createLookupOf(values(), MimeType::toString);

    private final String mimeType;

    MimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    @Override
    public String toString() {
        return this.mimeType;
    }

    @Nonnull
    public static MimeType from(@Nonnull String mimeType) {
        var value = VALUES.get(Strings.requireNonBlank(mimeType, "mimeType must not be blank"));
        if (value == null) {
            throw new IllegalArgumentException("Unknown mime type: " + mimeType);
        }
        return value;
    }
}
