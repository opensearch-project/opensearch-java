/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen.model;

import io.swagger.v3.oas.models.OpenAPI;
import org.opensearch.client.codegen.TypeMapper;

public class Context {
    public final Namespace namespace;
    public final OpenAPI openApi;
    public final TypeMapper typeMapper;

    public Context(Namespace namespace, OpenAPI openApi, TypeMapper typeMapper) {
        this.namespace = namespace;
        this.openApi = openApi;
        this.typeMapper = typeMapper;
    }

    public Context withNamespace(Namespace namespace) {
        return new Context(namespace, openApi, typeMapper);
    }
}
