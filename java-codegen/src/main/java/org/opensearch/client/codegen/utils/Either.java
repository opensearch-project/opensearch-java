/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen.utils;

import java.util.Objects;
import java.util.function.Function;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.jetbrains.annotations.Contract;

public abstract class Either<L, R> {
    public abstract boolean isLeft();

    public abstract boolean isRight();

    @Nullable
    public abstract L getLeft();

    @Nullable
    public abstract R getRight();

    @Nullable
    public <X extends Throwable> L getLeftOrThrow(@Nonnull Function<? super R, X> exceptionFn) throws X {
        Objects.requireNonNull(exceptionFn, "exceptionFn must not be null");
        if (isLeft()) {
            return getLeft();
        } else {
            throw exceptionFn.apply(getRight());
        }
    }

    public <X extends Throwable> R getRightOrThrow(Function<? super L, X> exceptionFn) throws X {
        Objects.requireNonNull(exceptionFn, "exceptionFn must not be null");
        if (isRight()) {
            return getRight();
        } else {
            throw exceptionFn.apply(getLeft());
        }
    }

    public <T> T fold(Function<? super L, ? extends T> leftFn, Function<? super R, ? extends T> rightFn) {
        if (isLeft()) {
            return leftFn.apply(getLeft());
        } else {
            return rightFn.apply(getRight());
        }
    }

    @Nonnull
    public static <L, R> Either<L, R> left(@Nullable L value) {
        return new Left<>(value);
    }

    @Nonnull
    public static <L, R> Either<L, R> right(@Nullable R value) {
        return new Right<>(value);
    }

    private static class Left<L, R> extends Either<L, R> {
        @Nullable
        private final L value;

        private Left(@Nullable L value) {
            this.value = value;
        }

        @Override
        public boolean isLeft() {
            return true;
        }

        @Override
        public boolean isRight() {
            return false;
        }

        @Nullable
        @Override
        public L getLeft() {
            return value;
        }

        @Contract("-> fail")
        @Override
        public R getRight() {
            throw new IllegalStateException("Cannot get right value from left");
        }
    }

    private static class Right<L, R> extends Either<L, R> {
        @Nullable
        private final R value;

        private Right(@Nullable R value) {
            this.value = value;
        }

        @Override
        public boolean isLeft() {
            return false;
        }

        @Override
        public boolean isRight() {
            return true;
        }

        @Contract("-> fail")
        @Override
        public L getLeft() {
            throw new IllegalStateException("Cannot get left value from right");
        }

        @Nullable
        @Override
        public R getRight() {
            return value;
        }
    }
}
