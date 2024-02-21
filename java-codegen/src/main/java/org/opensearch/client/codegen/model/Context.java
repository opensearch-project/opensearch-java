/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen.model;

import org.opensearch.client.codegen.TypeMapper;
import org.opensearch.client.codegen.openapi.OpenApiSchema;

public class Context {
    private final Namespace namespace;
    private final TypeMapper typeMapper;

    public Context(Namespace namespace, TypeMapper typeMapper) {
        this.namespace = namespace;
        this.typeMapper = typeMapper;
    }

    public Context withNamespace(Namespace namespace) {
        return new Context(namespace, typeMapper);
    }

    public Namespace getNamespace() {
        return namespace;
    }

    public Type mapType(OpenApiSchema schema) {
        return typeMapper.mapType(schema);
    }
}
