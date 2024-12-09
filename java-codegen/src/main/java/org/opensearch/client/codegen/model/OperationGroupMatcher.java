/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen.model;

import org.opensearch.client.codegen.utils.matcher.Matcher;

public final class OperationGroupMatcher {
    private OperationGroupMatcher() {}

    public static Matcher<OperationGroup> name(Matcher<String> nameMatcher) {
        return group -> nameMatcher.matches(group.getName());
    }

    public static Matcher<OperationGroup> namespace(Matcher<String> namespaceMatcher) {
        return group -> namespaceMatcher.matches(group.getNamespace().orElse(null));
    }
}
