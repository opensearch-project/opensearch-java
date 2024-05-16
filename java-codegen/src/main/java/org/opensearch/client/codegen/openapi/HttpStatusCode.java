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
import org.opensearch.client.codegen.utils.Strings;

public enum HttpStatusCode {
    OK("200"),
    BAD_REQUEST("400"),
    FORBIDDEN("403"),
    INTERNAL_SERVER_ERROR("500"),
    NOT_IMPLEMENTED("501");

    private static final Map<String, HttpStatusCode> STATUS_CODES = Arrays.stream(values())
        .collect(Collectors.toMap(HttpStatusCode::toString, Function.identity()));
    private final String code;

    HttpStatusCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return this.code;
    }

    public static HttpStatusCode from(String code) {
        var value = STATUS_CODES.get(Strings.requireNonBlank(code, "code must not be blank"));
        if (value == null) {
            throw new IllegalArgumentException("Unknown status code: " + code);
        }
        return value;
    }
}
