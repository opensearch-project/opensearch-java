/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen.model;

import java.util.Arrays;
import java.util.HashSet;
import javax.annotation.Nonnull;

@FunctionalInterface
public interface OperationGroupMatcher {
    boolean matches(OperationGroup group);

    static OperationGroupMatcher all() {
        return group -> true;
    }

    static OperationGroupMatcher none() {
        return group -> false;
    }

    static OperationGroupMatcher not(OperationGroupMatcher matcher) {
        return group -> !matcher.matches(group);
    }

    static OperationGroupMatcher or(OperationGroupMatcher... matchers) {
        return group -> {
            for (OperationGroupMatcher matcher : matchers) {
                if (matcher.matches(group)) {
                    return true;
                }
            }
            return false;
        };
    }

    static OperationGroupMatcher and(OperationGroupMatcher... matchers) {
        return group -> {
            for (OperationGroupMatcher matcher : matchers) {
                if (!matcher.matches(group)) {
                    return false;
                }
            }
            return true;
        };
    }

    static OperationGroupMatcher named(String... names) {
        var set = new HashSet<>(Arrays.asList(names));
        return group -> set.contains(group.getName());
    }

    static OperationGroupMatcher namespace(@Nonnull String namespace) {
        return group -> namespace.equals(group.getNamespace().orElse(""));
    }
}
