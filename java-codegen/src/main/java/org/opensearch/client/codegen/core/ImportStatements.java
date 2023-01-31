package org.opensearch.client.codegen.core;

import software.amazon.smithy.codegen.core.CodegenException;
import software.amazon.smithy.codegen.core.ImportContainer;
import software.amazon.smithy.codegen.core.Symbol;

import java.util.HashSet;
import java.util.Objects;
import java.util.stream.Collectors;

public class ImportStatements implements ImportContainer {
    private final String packageName;
    private final HashSet<ImportStatement> imports = new HashSet<>();

    public ImportStatements(String packageName) {
        this.packageName = packageName;
    }

    @Override
    public void importSymbol(Symbol symbol, String alias) {
        String name = symbol.getName();
        String namespace = symbol.getNamespace();

        if (!name.equals(alias)) {
            throw new CodegenException("Java does not allow import aliasing");
        }

        if (!namespace.isEmpty() && !namespace.equals(packageName)) {
            imports.add(new ImportStatement(namespace, name));
        }
    }

    @Override
    public String toString() {
        return imports
                .stream()
                .map(ImportStatement::toString)
                .sorted()
                .collect(Collectors.joining("\n"));
    }

    private static class ImportStatement {
        private final String packageName;
        private final String symbolName;

        public ImportStatement(String packageName, String symbolName) {
            this.packageName = packageName;
            this.symbolName = symbolName;
        }

        @Override
        public String toString() {
            return "import " + packageName + "." + symbolName + ";";
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ImportStatement that = (ImportStatement) o;
            return Objects.equals(packageName, that.packageName) && Objects.equals(symbolName, that.symbolName);
        }

        @Override
        public int hashCode() {
            return Objects.hash(packageName, symbolName);
        }
    }
}
