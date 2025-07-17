/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen.openapi;

import static org.opensearch.client.codegen.utils.Functional.ifNonnull;

import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.opensearch.client.codegen.openapi.reference.RelativeRef;
import org.opensearch.client.codegen.utils.json.JsonGenerator;

public abstract class OpenApiRefElement<Self extends OpenApiRefElement<Self>> extends OpenApiElement<Self> {
    @Nullable
    private RelativeRef $ref;
    @Nonnull
    private final Class<Self> clazz;

    OpenApiRefElement(@Nonnull AbstractBuilder<Self, ?> builder, @Nonnull Class<Self> clazz) {
        super(builder);
        this.$ref = builder.$ref;
        this.clazz = Objects.requireNonNull(clazz, "clazz must not be null");
    }

    OpenApiRefElement(@Nullable String $ref, @Nonnull Class<Self> clazz) {
        this.$ref = ifNonnull($ref, RelativeRef::parse);
        this.clazz = Objects.requireNonNull(clazz, "clazz must not be null");
    }

    public boolean has$ref() {
        return $ref != null;
    }

    @Nonnull
    public Optional<RelativeRef> get$ref() {
        return Optional.ofNullable($ref);
    }

    public void set$ref(@Nullable RelativeRef $ref) {
        this.$ref = $ref;
    }

    @Nonnull
    public Self resolve() {
        if ($ref == null) {
            return self();
        }
        return resolve(getSpecification().orElseThrow(() -> new IllegalStateException("Cannot resolve $ref without a specification")));
    }

    @Nonnull
    public Self resolve(@Nonnull OpenApiSpecification specification) {
        if ($ref == null) {
            return self();
        }
        Objects.requireNonNull(specification, "specification must not be null");
        var resolved = $ref.resolveIn(specification).orElseThrow(() -> new IllegalStateException("Failed to resolve $ref: " + $ref));
        if (!clazz.isInstance(resolved)) {
            throw new IllegalStateException("Resolved $ref is not an instance of " + clazz.getSimpleName());
        }
        return clazz.cast(resolved);
    }

    @Override
    protected void toJsonInner(JsonGenerator generator) {
        if ($ref != null) {
            generator.writeField("$ref", $ref.toString());
        }
    }

    @Nonnull
    <Builder extends AbstractBuilder<Self, Builder>> Builder toBuilder(@Nonnull Builder builder) {
        return super.toBuilder(builder).with$ref($ref);
    }

    public static abstract class AbstractBuilder<
        Element extends OpenApiRefElement<Element>,
        Builder extends AbstractBuilder<Element, Builder>> extends OpenApiElement.AbstractBuilder<Element, Builder> {
        @Nullable
        private RelativeRef $ref;

        AbstractBuilder() {}

        @Nonnull
        public Builder with$ref(@Nullable RelativeRef $ref) {
            this.$ref = $ref;
            return self();
        }
    }
}
