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
import java.util.function.Function;
import javax.annotation.Nonnull;

public abstract class OpenApiMapElement<TSelf extends OpenApiMapElement<TSelf, TKey, TValue>, TKey, TValue extends OpenApiElement<TValue>>
    extends OpenApiElement<TSelf> {
    @Nonnull
    private final Map<TKey, TValue> value;

    <TOld> OpenApiMapElement(
        @Nonnull OpenApiElement<?> parent,
        @Nonnull JsonPointer pointer,
        @Nonnull Map<String, TOld> value,
        @Nonnull Function<String, TKey> keyMapper,
        @Nonnull Factory<TSelf, TOld, TValue> factory
    ) {
        super(parent, pointer);
        this.value = Objects.requireNonNull(
            children(
                Objects.requireNonNull(value, "value must not be null"),
                Objects.requireNonNull(keyMapper, "keyMapper must not be null"),
                Objects.requireNonNull(factory, "factory must not be null")
            )
        );
    }

    @Nonnull
    public Optional<TValue> get(@Nonnull TKey key) {
        return Optional.ofNullable(value.get(Objects.requireNonNull(key, "key must not be null")));
    }
}
