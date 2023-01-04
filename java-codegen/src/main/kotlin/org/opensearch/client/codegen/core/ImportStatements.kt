package org.opensearch.client.codegen.core

import software.amazon.smithy.codegen.core.CodegenException
import software.amazon.smithy.codegen.core.ImportContainer
import software.amazon.smithy.codegen.core.Symbol

class ImportStatements(private val packageName: String) : ImportContainer {
    private val imports: MutableSet<ImportStatement> = mutableSetOf()

    override fun importSymbol(symbol: Symbol, alias: String?) {
        if (alias != symbol.name) {
            throw CodegenException("Java doesn't allow import aliasing")
        }

        if (symbol.namespace.isNotEmpty() && symbol.namespace != packageName) {
            imports.add(ImportStatement(symbol.namespace, symbol.name))
        }
    }

    override fun toString(): String {
        return imports.map { it.toString() }.sorted().joinToString(separator = "\n")
    }
}

private data class ImportStatement(val packageName: String, val symbolName: String) {
    val rendered: String
        get() = "import $packageName.$symbolName;"

    override fun toString(): String = rendered
}