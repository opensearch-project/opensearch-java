package org.opensearch.client.codegen.core;

import software.amazon.smithy.codegen.core.CodegenException;
import software.amazon.smithy.codegen.core.Symbol;
import software.amazon.smithy.codegen.core.SymbolWriter;
import software.amazon.smithy.rulesengine.language.eval.Type;

import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class JavaWriter extends SymbolWriter<JavaWriter, ImportStatements> {
    private final String filename;
    private final String namespace;

    public static Factory<JavaWriter> factory() {
        return JavaWriter::new;
    }

    private JavaWriter(String filename, String namespace) {
        super(new ImportStatements(namespace));
        this.filename = filename;
        this.namespace = namespace;

        trimBlankLines();
        trimTrailingSpaces();
        setIndentText("    ");
        setExpressionStart('#');
        putFormatter('T', this::formatSymbol);
    }

    public JavaWriter addImport(Symbol symbol) {
        return super.addImport(symbol, symbol.getName());
    }

    public JavaWriter block(String header, Object[] args, Consumer<JavaWriter> block) {
        openBlock(header + " {", args);
        block.accept(this);
        closeBlock("}");
        return this;
    }

    public JavaWriter javaClass(JavaVisibility visibility, String name, List<Symbol> annotations, Symbol extendz, List<Symbol> implementz, Consumer<JavaWriter> body) {
        if (annotations != null) {
            annotations.forEach(s -> {
                write("@#T", s);
            });
        }

        String header = format("#L #L", visibility, name);
        if (extendz != null) {
            header = format("#L extends #T", header, extendz);
        }
        if (implementz != null && !implementz.isEmpty()) {
            header = format(
                    "#L implements #L",
                    header,
                    implementz
                            .stream()
                            .map(s -> format("#T", s))
                            .collect(Collectors.joining(", "))
            );
        }

        return block(header, new Object[0],  body);
    }

    @Override
    public String toString() {
        return "package " + namespace + ";\n\n" +
                getImportContainer() + "\n\n" +
                super.toString();
    }

    private String formatSymbol(Object o, String indent) {
        if (o instanceof Symbol) {
            Symbol type = (Symbol) o;
            addImport(type);
            return type.getName();
        }

        throw new CodegenException("Invalid type provided for #T. Expected a Symbol, but found `" + o + "`");
    }
}
