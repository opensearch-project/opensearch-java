/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen.model;

public abstract class Shape {
    protected final String namespace;
    private final String className;

    public Shape(String namespace, String className) {
        this.namespace = namespace;
        this.className = className;
    }

    public String namespace() {
        return this.namespace;
    }

    public String packageName() {
        return "org.opensearch.client.opensearch." + this.namespace.replace("_", "").toLowerCase();
    }

    public String className() {
        return this.className;
    }
}
