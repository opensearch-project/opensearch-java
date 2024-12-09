/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen.utils.matcher;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;

public interface Matcher<T> {
    boolean matches(T t);

    static <T> Matcher<T> all() {
        return t -> true;
    }

    static <T> Matcher<T> none() {
        return t -> false;
    }

    static <T> Matcher<T> not(Matcher<T> matcher) {
        return t -> !matcher.matches(t);
    }

    @SafeVarargs
    static <T> Matcher<T> or(Matcher<T>... matchers) {
        return t -> {
            for (Matcher<T> matcher : matchers) {
                if (matcher.matches(t)) {
                    return true;
                }
            }
            return false;
        };
    }

    @SafeVarargs
    static <T> Matcher<T> and(Matcher<T>... matchers) {
        return t -> {
            for (Matcher<T> matcher : matchers) {
                if (!matcher.matches(t)) {
                    return false;
                }
            }
            return true;
        };
    }

    static <T> Matcher<T> isNull() {
        return Objects::isNull;
    }

    static <T> Matcher<T> is(T value) {
        return v -> Objects.equals(v, value);
    }

    static <T> Matcher<T> isNot(T value) {
        return not(is(value));
    }

    @SafeVarargs
    static <T> Matcher<T> isOneOf(T... values) {
        var set = new HashSet<>(Arrays.asList(values));
        return set::contains;
    }
}
