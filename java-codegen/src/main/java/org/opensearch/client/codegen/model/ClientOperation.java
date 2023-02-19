/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen.model;

import org.opensearch.client.codegen.utils.Strings;

public class ClientOperation {
    private final String id;

    public ClientOperation(String id) {
        this.id = id;
    }

    public String name() {
        return Strings.toCamelCase(id);
    }

    public String requestType() {
        return RequestShape.requestClassName(id);
    }

    public String responseType() {
        return RequestShape.responseClassName(id);
    }
}
