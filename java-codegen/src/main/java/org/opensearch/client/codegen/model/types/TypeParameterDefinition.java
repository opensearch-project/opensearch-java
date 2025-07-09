/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen.model.types;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.opensearch.client.codegen.utils.Strings;
import org.opensearch.client.codegen.utils.builder.ObjectBuilderBase;

public final class TypeParameterDefinition {
    @Nonnull
    private final String name;
    @Nullable
    private final Type extendsType;

    private TypeParameterDefinition(Builder builder) {
        this.name = Strings.requireNonBlank(builder.name, "name must not be blank");
        this.extendsType = builder.extendsType;
    }

    @Nonnull
    public String getName() {
        return name;
    }

    @Nullable
    public Type getExtends() {
        return extendsType;
    }

    @Nonnull
    public TypeParameterRef toRef() {
        return new TypeParameterRef(name);
    }

    @Override
    public String toString() {
        return name + (extendsType != null ? " extends " + extendsType : "");
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder extends ObjectBuilderBase<TypeParameterDefinition, Builder> {
        private String name;
        private Type extendsType;

        private Builder() {}

        @Nonnull
        @Override
        protected TypeParameterDefinition construct() {
            return new TypeParameterDefinition(this);
        }

        @Nonnull
        public Builder withName(@Nonnull String name) {
            this.name = Strings.requireNonBlank(name, "name must not be blank");
            return this;
        }

        @Nonnull
        public Builder withExtends(@Nullable Type type) {
            this.extendsType = type;
            return this;
        }
    }
}
