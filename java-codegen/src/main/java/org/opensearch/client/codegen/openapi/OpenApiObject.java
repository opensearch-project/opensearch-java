/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen.openapi;

public abstract class OpenApiObject<O> {
    private final OpenApiSpec parent;
    private final O inner;

    protected OpenApiObject(OpenApiSpec parent, O inner) {
        this.parent = parent;
        this.inner = inner;
    }

    public OpenApiSpec getParent() {
        return parent;
    }

    public O getInner() {
        return inner;
    }
}
