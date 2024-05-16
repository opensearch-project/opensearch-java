package org.opensearch.client.codegen.model;

import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.regex.Pattern;
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

    private OperationGroup(@Nullable String namespace, @Nonnull String name) {
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

    @Nonnull
    public static Matcher matcher() {
        return new Matcher();
    }

    public static class Matcher {
        private final Set<String> namespaces = new HashSet<>();
        private final Set<OperationGroup> operations = new HashSet<>();
        private final Collection<Pattern> patterns = new HashSet<>();

        private Matcher() {}

        @Nonnull
        public Matcher add(@Nullable String namespace, @Nullable String... operations) {
            if (operations == null || operations.length == 0) {
                namespaces.add(Strings.requireNonBlank(namespace, "namespace must not be blank"));
            } else {
                for (String operation : operations) {
                    add(new OperationGroup(namespace, operation));
                }
            }
            return this;
        }

        @Nonnull
        public Matcher add(@Nonnull OperationGroup operation) {
            operations.add(Objects.requireNonNull(operation, "operation must not be null"));
            return this;
        }

        @Nonnull
        public Matcher add(@Nonnull Pattern pattern) {
            patterns.add(Objects.requireNonNull(pattern, "pattern must not be null"));
            return this;
        }

        public boolean matches(@Nonnull OperationGroup operation) {
            Objects.requireNonNull(operation, "operation must not be null");
            if (operation.getNamespace().map(namespaces::contains).orElse(false)) {
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
