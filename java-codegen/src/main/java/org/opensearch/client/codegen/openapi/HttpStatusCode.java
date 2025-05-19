/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen.openapi;

import java.util.Map;
import org.opensearch.client.codegen.utils.Maps;
import org.opensearch.client.codegen.utils.Strings;

public enum HttpStatusCode {
    Ok("200"),
    Created("201"),
    Accepted("202"),
    NoContent("204"),
    BadRequest("400"),
    Forbidden("403"),
    NotFound("404"),
    MethodNotAllowed("405"),
    RequestTimeout("408"),
    InternalServerError("500"),
    NotImplemented("501");

    private static final Map<String, HttpStatusCode> VALUES = Maps.createLookupOf(values(), HttpStatusCode::toString);

    private final String code;

    HttpStatusCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return this.code;
    }

    public static HttpStatusCode from(String code) {
        var value = VALUES.get(Strings.requireNonBlank(code, "code must not be blank"));
        if (value == null) {
            throw new IllegalArgumentException("Unknown status code: " + code);
        }
        return value;
    }

    public boolean isSuccessful() {
        return this.code.startsWith("2");
    }
}
