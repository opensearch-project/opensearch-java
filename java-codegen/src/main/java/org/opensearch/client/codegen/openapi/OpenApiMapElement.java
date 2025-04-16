/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen.openapi;

import static org.opensearch.client.codegen.utils.Functional.ifNonnull;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Stream;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.opensearch.client.codegen.utils.Clone;
import org.opensearch.client.codegen.utils.Maps;

public abstract class OpenApiMapElement<Self extends OpenApiMapElement<Self, Key, Value>, Key, Value extends OpenApiElement<Value>> extends
    OpenApiElement<Self> {
    @Nullable
    private Map<Key, Value> values;

    OpenApiMapElement(@Nonnull AbstractBuilder<Self, Key, Value, ?> builder) {
        super(builder);
        setValues(builder.values);
    }

    <Old> OpenApiMapElement(
        @Nonnull Map<String, Old> values,
        @Nonnull Function<String, Key> keyMapper,
        @Nonnull Factory<Old, Value> factory
    ) {
        setValues(
            Objects.requireNonNull(
                children(
                    Objects.requireNonNull(values, "value must not be null"),
                    Objects.requireNonNull(keyMapper, "keyMapper must not be null"),
                    Objects.requireNonNull(factory, "factory must not be null")
                )
            )
        );
    }

    @Override
    void initialize(@Nullable OpenApiElement<?> parent, @Nonnull JsonPointer pointer) {
        super.initialize(parent, pointer);
        initializeValues();
    }

    @Nonnull
    public Optional<Value> get(@Nonnull Key key) {
        return Maps.tryGet(values, Objects.requireNonNull(key, "key must not be null"));
    }

    public void set(@Nonnull Key key, @Nonnull Value value) {
        if (values == null) {
            values = new HashMap<>();
        }
        values.put(Objects.requireNonNull(key, "key must not be null"), Objects.requireNonNull(value, "value must not be null"));
        value.initialize(this, getPointer().append(key.toString()));
    }

    @Nonnull
    public Optional<Map<Key, Value>> getValues() {
        return Maps.unmodifiableOpt(values);
    }

    public void setValues(@Nullable Map<Key, Value> values) {
        this.values = values;
        initializeValues();
    }

    private void initializeValues() {
        if (values == null) {
            return;
        }
        var ptr = getPointer();
        values.forEach((key, value) -> value.initialize(this, ptr.append(key.toString())));
    }

    @Nonnull
    public Stream<Map.Entry<Key, Value>> entries() {
        return values.entrySet().stream();
    }

    <Builder extends AbstractBuilder<Self, Key, Value, Builder>> @Nonnull Builder toBuilder(@Nonnull Builder builder) {
        return super.toBuilder(builder).withValues(ifNonnull(values, Clone::clone));
    }

    protected static abstract class AbstractBuilder<
        Element extends OpenApiMapElement<Element, Key, Value>,
        Key,
        Value extends OpenApiElement<Value>,
        Builder extends AbstractBuilder<Element, Key, Value, Builder>> extends OpenApiElement.AbstractBuilder<Element, Builder> {
        private Map<Key, Value> values;

        AbstractBuilder() {}

        @Nonnull
        public Builder withValues(@Nullable Map<Key, Value> values) {
            this.values = values;
            return self();
        }
    }
}
