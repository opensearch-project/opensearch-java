package org.opensearch.client.codegen.core

import org.opensearch.client.codegen.OpenSearchJavaSettings
import software.amazon.smithy.build.FileManifest
import software.amazon.smithy.codegen.core.*
import software.amazon.smithy.model.shapes.Shape
import java.util.function.Consumer

class JavaDelegator(
    fileManifest: FileManifest,
    symbolProvider: SymbolProvider,
    settings: OpenSearchJavaSettings
) {
    private val inner = WriterDelegator(fileManifest, symbolProvider, JavaWriter.factory())

    fun useShapeWriter(shape: Shape, writerConsumer: Consumer<JavaWriter>) {
        inner.useShapeWriter(shape, writerConsumer)
    }

    fun useSymbolWriter(symbol: Symbol, writerConsumer: Consumer<JavaWriter>) {
        inner.useFileWriter(symbol.definitionFile, symbol.namespace, writerConsumer)
    }

    fun finalize() {
        inner.flushWriters()
    }
}