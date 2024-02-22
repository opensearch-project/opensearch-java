/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen.openapi;

import io.swagger.v3.oas.models.OpenAPI;
import java.util.Map;
import java.util.function.Function;

public abstract class OpenApiRefObject<TSelf extends OpenApiRefObject<TSelf, TInner>, TInner> extends OpenApiObject<TInner> {
    private final Factory<TInner, TSelf> factory;
    private final Function<OpenAPI, Map<String, TInner>> componentsGetter;
    private final Function<TInner, String> get$ref;

    protected OpenApiRefObject(
        OpenApiSpec parent,
        JsonPointer jsonPtr,
        TInner inner,
        Factory<TInner, TSelf> factory,
        Function<OpenAPI, Map<String, TInner>> componentsGetter,
        Function<TInner, String> get$ref
    ) {
        super(parent, jsonPtr, inner);
        this.factory = factory;
        this.componentsGetter = componentsGetter;
        this.get$ref = get$ref;
    }

    public String get$ref() {
        return get$ref.apply(getInner());
    }

    protected abstract TSelf getSelf();

    public TSelf resolve() {
        if (get$ref() == null) return getSelf();
        var resolved = getParent().resolve(componentsGetter, getJsonPtr(), getInner(), get$ref);
        return factory.create(resolved.getLeft(), resolved.getMiddle(), resolved.getRight());
    }
}
