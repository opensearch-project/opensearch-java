/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen.model;

public enum ReferenceKind {
    Extends(false),
    Field(true),
    UnionVariant(true);

    private final boolean isConcreteUsage;

    ReferenceKind(boolean isConcreteUsage) {
        this.isConcreteUsage = isConcreteUsage;
    }

    public boolean isConcreteUsage() {
        return isConcreteUsage;
    }
}
