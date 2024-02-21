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
import java.util.function.BiFunction;
import java.util.function.Function;

public abstract class OpenApiRefObject<T extends OpenApiRefObject<T, O>, O> extends OpenApiObject<O> {
    private final BiFunction<OpenApiSpec, O, T> constructor;
    private final Function<OpenAPI, Map<String, O>> componentsGetter;
    private final Function<O, String> get$ref;

    protected OpenApiRefObject(
        OpenApiSpec parent,
        O inner,
        BiFunction<OpenApiSpec, O, T> constructor,
        Function<OpenAPI, Map<String, O>> componentsGetter,
        Function<O, String> get$ref
    ) {
        super(parent, inner);
        this.constructor = constructor;
        this.componentsGetter = componentsGetter;
        this.get$ref = get$ref;
    }

    public String get$ref() {
        return get$ref.apply(getInner());
    }

    public T resolve() {
        return getParent().resolve(componentsGetter, getInner(), get$ref).apply(constructor::apply);
    }
}
