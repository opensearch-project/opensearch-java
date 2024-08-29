/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen.model;

import java.util.Objects;
import java.util.function.Function;
import javax.annotation.Nonnull;
import org.opensearch.client.codegen.utils.Either;
import org.opensearch.client.codegen.utils.ObjectBuilderBase;

public final class TypeParameterDiamond {
    @Nonnull
    private final Either<Type[], TypeParameterDefinition[]> params;

    private TypeParameterDiamond(Builder builder) {
        this.params = Objects.requireNonNull(builder.params, "params must not be null");
    }

    public void toString(@Nonnull StringBuilder out) {
        Objects.requireNonNull(out, "out must not be null");
        var params = this.params.fold(Function.identity(), Function.identity());
        out.append("<");
        for (var i = 0; i < params.length; i++) {
            if (i > 0) {
                out.append(", ");
            }
            out.append(params[i].toString());
        }
        out.append(">");
    }

    public Type[] getParamTypes() {
        return params.getLeft();
    }

    @Override
    public @Nonnull String toString() {
        var out = new StringBuilder();
        toString(out);
        return out.toString();
    }

    @Nonnull
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder extends ObjectBuilderBase<TypeParameterDiamond, Builder> {
        private Either<Type[], TypeParameterDefinition[]> params;

        private Builder() {
            super(TypeParameterDiamond::new);
        }

        @Override
        protected @Nonnull Builder self() {
            return this;
        }

        @Nonnull
        public Builder withParams(@Nonnull Type... params) {
            this.params = Either.left(Objects.requireNonNull(params, "params must not be null"));
            return this;
        }

        @Nonnull
        public Builder withParams(@Nonnull TypeParameterDefinition... params) {
            this.params = Either.right(Objects.requireNonNull(params, "params must not be null"));
            return this;
        }
    }
}
