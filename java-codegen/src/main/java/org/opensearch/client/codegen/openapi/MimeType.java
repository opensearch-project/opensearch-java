/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen.openapi;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Nonnull;
import org.opensearch.client.codegen.utils.Strings;

public enum MimeType {
    JSON("application/json"),
    NDJSON("application/x-ndjson");

    private static final Map<String, MimeType> MIME_TYPES = Arrays.stream(MimeType.values())
        .collect(Collectors.toMap(MimeType::toString, Function.identity()));
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
        var value = MIME_TYPES.get(Strings.requireNonBlank(mimeType, "mimeType must not be blank"));
        if (value == null) {
            throw new IllegalArgumentException("Unknown mime type: " + mimeType);
        }
        return value;
    }
}
