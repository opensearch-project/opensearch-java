/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen.model;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.jetbrains.annotations.NotNull;
import org.opensearch.client.codegen.utils.ObjectBuilderBase;
import org.opensearch.client.codegen.utils.Strings;

public final class TypeParameterDefinition {
    @Nonnull
    private final String name;
    @Nullable
    private final Type extends_;

    private TypeParameterDefinition(Builder builder) {
        this.name = Strings.requireNonBlank(builder.name, "name must not be blank");
        this.extends_ = builder.extends_;
    }

    @Nonnull
    public String getName() {
        return name;
    }

    @Nullable
    public Type getExtends() {
        return extends_;
    }

    @Override
    public String toString() {
        return name + (extends_ != null ? " extends " + extends_ : "");
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder extends ObjectBuilderBase<TypeParameterDefinition, Builder> {
        private String name;
        private Type extends_;

        private Builder() {
            super(TypeParameterDefinition::new);
        }

        @Override
        protected @NotNull Builder self() {
            return this;
        }

        @Nonnull
        public Builder withName(@Nonnull String name) {
            this.name = Strings.requireNonBlank(name, "name must not be blank");
            return this;
        }

        @Nonnull
        public Builder withExtends(@Nullable Type type) {
            this.extends_ = type;
            return this;
        }
    }
}
