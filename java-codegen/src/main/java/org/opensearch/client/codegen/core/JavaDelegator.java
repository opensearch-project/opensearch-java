package org.opensearch.client.codegen.core;

import software.amazon.smithy.build.FileManifest;
import software.amazon.smithy.codegen.core.Symbol;
import software.amazon.smithy.codegen.core.SymbolProvider;
import software.amazon.smithy.codegen.core.WriterDelegator;
import software.amazon.smithy.model.shapes.Shape;

import java.util.function.Consumer;

public class JavaDelegator {
    private final WriterDelegator<JavaWriter> inner;

    public JavaDelegator(FileManifest fileManifest, SymbolProvider symbolProvider) {
        inner = new WriterDelegator<>(fileManifest, symbolProvider, JavaWriter.factory());
    }

    public void useShapeWriter(Shape shape, Consumer<JavaWriter> writerConsumer) {
        inner.useShapeWriter(shape, writerConsumer);
    }

    public void useSymbolWriter(Symbol symbol, Consumer<JavaWriter> writerConsumer) {
        inner.useFileWriter(symbol.getDefinitionFile(), symbol.getNamespace(), writerConsumer);
    }

    public void flushWriters() {
        inner.flushWriters();
    }
}
