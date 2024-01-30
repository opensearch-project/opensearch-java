/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen.utils;

import java.util.function.Function;

public abstract class Either<L, R> {
    public abstract boolean isLeft();

    public abstract boolean isRight();

    public abstract L getLeft();

    public abstract R getRight();

    public <X extends Throwable> L getLeftOrThrow(Function<? super R, X> exceptionFn) throws X {
        if (isLeft()) {
            return getLeft();
        } else {
            throw exceptionFn.apply(getRight());
        }
    }

    public <X extends Throwable> R getRightOrThrow(Function<? super L, X> exceptionFn) throws X {
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

    public static <L, R> Either<L, R> left(L value) {
        return new Left<>(value);
    }

    public static <L, R> Either<L, R> right(R value) {
        return new Right<>(value);
    }

    private static class Left<L, R> extends Either<L, R> {
        private final L value;

        private Left(L value) {
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

        @Override
        public L getLeft() {
            return value;
        }

        @Override
        public R getRight() {
            throw new IllegalStateException("Cannot get right value from left");
        }
    }

    private static class Right<L, R> extends Either<L, R> {
        private final R value;

        private Right(R value) {
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

        @Override
        public L getLeft() {
            throw new IllegalStateException("Cannot get left value from right");
        }

        @Override
        public R getRight() {
            return value;
        }
    }
}
