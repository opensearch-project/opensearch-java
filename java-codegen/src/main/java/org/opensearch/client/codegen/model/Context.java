package org.opensearch.client.codegen.model;

import org.openapi4j.core.model.OAIContext;
import org.opensearch.client.codegen.TypeMapper;

public class Context {
    public final Namespace namespace;
    public final OAIContext openApiCtx;
    public final TypeMapper typeMapper;

    public Context(Namespace namespace, OAIContext openApiCtx, TypeMapper typeMapper) {
        this.namespace = namespace;
        this.openApiCtx = openApiCtx;
        this.typeMapper = typeMapper;
    }

    public Context withNamespace(Namespace namespace) {
        return new Context(namespace, openApiCtx, typeMapper);
    }
}
