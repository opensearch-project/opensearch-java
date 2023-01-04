package org.opensearch.client.codegen.core

import org.opensearch.client.codegen.OpenSearchJavaSettings
import software.amazon.smithy.codegen.core.Symbol
import software.amazon.smithy.codegen.core.SymbolProvider
import software.amazon.smithy.model.Model
import software.amazon.smithy.model.knowledge.HttpBindingIndex
import software.amazon.smithy.model.shapes.Shape

interface CodegenContext {
    val model: Model
    val symbolProvider: SymbolProvider
    val httpBindingIndex: HttpBindingIndex
    val settings: OpenSearchJavaSettings
}

data class GenerationContext(
    override val model: Model,
    override val symbolProvider: SymbolProvider,
    override val httpBindingIndex: HttpBindingIndex,
    override val settings: OpenSearchJavaSettings
) : CodegenContext

fun <T : Shape> CodegenContext.toRenderingContext(writer: JavaWriter, forShape: T? = null, symbol: Symbol? = null) =
    RenderingContext(this, writer, forShape, symbol)

data class RenderingContext<T : Shape>(
    val writer: JavaWriter,
    val shape: T?,
    val symbol: Symbol,
    override val model: Model,
    override val symbolProvider: SymbolProvider,
    override val httpBindingIndex: HttpBindingIndex,
    override val settings: OpenSearchJavaSettings
) : CodegenContext {
    constructor(other: CodegenContext, writer: JavaWriter, shape: T?, symbol: Symbol? = null) :
            this(writer, shape, symbol ?: other.symbolProvider.toSymbol(shape), other.model, other.symbolProvider, other.httpBindingIndex, other.settings)
}