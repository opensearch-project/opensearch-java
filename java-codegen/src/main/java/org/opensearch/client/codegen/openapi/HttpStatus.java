/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen.openapi;

public enum HttpStatus {
    OK("200");

    private final String code;

    HttpStatus(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return code;
    }
}
