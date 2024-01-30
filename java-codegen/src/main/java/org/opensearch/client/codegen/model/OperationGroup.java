package org.opensearch.client.codegen.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class OperationGroup {
    private final String namespace;
    private final String name;

    public static OperationGroup from(String operationGroup) {
        int index = operationGroup.lastIndexOf('.');
        if (index == -1) {
            return new OperationGroup(null, operationGroup);
        }
        return new OperationGroup(operationGroup.substring(0, index), operationGroup.substring(index + 1));
    }

    private OperationGroup(String namespace, String name) {
        this.namespace = namespace;
        this.name = name;
    }

    public String namespace() {
        return namespace;
    }

    public String name() {
        return name;
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
