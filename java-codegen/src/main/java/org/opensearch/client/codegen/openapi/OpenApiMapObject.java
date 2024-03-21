/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen.openapi;

import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public abstract class OpenApiMapObject<
    TKey extends Enum<TKey>,
    TValue extends OpenApiObject<TValueInner>,
    TInner extends Map<String, TValueInner>,
    TValueInner> extends OpenApiObject<TInner> {
    private final Factory<TValueInner, TValue> factory;

    protected OpenApiMapObject(OpenApiSpec parent, JsonPointer jsonPtr, TInner inner, Factory<TValueInner, TValue> factory) {
        super(parent, jsonPtr, inner);
        Objects.requireNonNull(factory);
        this.factory = factory;
    }

    public Optional<TValue> get(TKey key) {
        var keyStr = key.toString();
        return childOpt(keyStr, i -> i.get(keyStr), factory);
    }
}
