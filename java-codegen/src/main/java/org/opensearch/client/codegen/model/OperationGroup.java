package org.opensearch.client.codegen.model;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;
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

    public String getNamespace() {
        return namespace;
    }

    public String getName() {
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

    public static Matcher matcher() {
        return new Matcher();
    }

    public static class Matcher {
        private final Set<String> namespaces = new HashSet<>();
        private final Set<OperationGroup> operations = new HashSet<>();
        private final Collection<Pattern> patterns = new HashSet<>();

        private Matcher() {
        }

        public Matcher add(String namespace, String... operations) {
            if (operations == null || operations.length == 0) {
                namespaces.add(namespace);
            } else {
                for (String operation : operations) {
                    add(new OperationGroup(namespace, operation));
                }
            }
            return this;
        }

        public Matcher add(OperationGroup operation) {
            operations.add(operation);
            return this;
        }

        public Matcher add(Pattern pattern) {
            patterns.add(pattern);
            return this;
        }

        public boolean matches(OperationGroup operation) {
            if (namespaces.contains(operation.getNamespace())) {
                return true;
            }
            if (operations.contains(operation)) {
                return true;
            }
            var str = operation.toString();
            for (Pattern pattern : patterns) {
                if (pattern.matcher(str).matches()) {
                    return true;
                }
            }
            return false;
        }
    }
}
