/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen.model;

import org.opensearch.client.codegen.TypeMapper;

public class Context {
    public final Namespace namespace;
    public final TypeMapper typeMapper;

    public Context(Namespace namespace, TypeMapper typeMapper) {
        this.namespace = namespace;
        this.typeMapper = typeMapper;
    }

    public Context withNamespace(Namespace namespace) {
        return new Context(namespace, typeMapper);
    }
}
