/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen.model;

import java.util.Optional;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.opensearch.client.codegen.utils.Strings;

public class OperationGroup {
    @Nullable
    private final String namespace;
    @Nonnull
    private final String name;

    @Nonnull
    public static OperationGroup from(@Nonnull String operationGroup) {
        Strings.requireNonBlank(operationGroup, "operationGroup must not be blank");
        int index = operationGroup.lastIndexOf('.');
        if (index == -1) {
            return new OperationGroup(null, operationGroup);
        }
        return new OperationGroup(operationGroup.substring(0, index), operationGroup.substring(index + 1));
    }

    public OperationGroup(@Nullable String namespace, @Nonnull String name) {
        this.namespace = namespace;
        this.name = Strings.requireNonBlank(name, "name must not be blank");
    }

    @Nonnull
    public Optional<String> getNamespace() {
        return Optional.ofNullable(namespace);
    }

    @Nonnull
    public String getName() {
        return name;
    }

    @Nonnull
    public String asTypedefPrefix() {
        return (namespace == null ? "_global" : namespace) + "." + name;
    }

    @Override
    public String toString() {
        return namespace == null ? name : namespace + "." + name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        OperationGroup that = (OperationGroup) o;

        return new EqualsBuilder().append(namespace, that.namespace).append(name, that.name).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(namespace).append(name).toHashCode();
    }
}
