package org.opensearch.client.codegen.core

import software.amazon.smithy.codegen.core.CodegenException
import software.amazon.smithy.codegen.core.Symbol
import software.amazon.smithy.codegen.core.SymbolWriter
import software.amazon.smithy.codegen.core.SymbolWriter.Factory
import software.amazon.smithy.utils.AbstractCodeWriter
import java.util.function.BiFunction

class JavaWriter private constructor(
    private val filename: String,
    val packageName: String
) : SymbolWriter<JavaWriter, ImportStatements>(ImportStatements(packageName)) {
    companion object {
        fun factory(): Factory<JavaWriter> =
            Factory { fileName: String, packageName: String -> JavaWriter(fileName, packageName) }
    }

    init {
        trimBlankLines()
        trimTrailingSpaces()

        indentText = "    "
        expressionStart = '#'

        putFormatter('T', JavaSymbolFormatter(this))
    }

    fun addImport(symbol: Symbol, alias: String = symbol.name): JavaWriter {
        return super.addImport(symbol, alias)
    }

    override fun toString(): String {
        val contents = super.toString()
        val pkgDecl = "package $packageName;\n\n"
        val imports = "${importContainer}\n\n"
        return pkgDecl + imports + contents
    }
}

private class JavaSymbolFormatter(
    private val writer: JavaWriter
) : BiFunction<Any, String, String> {
    override fun apply(type: Any, indent: String): String {
        when (type) {
            is Symbol -> {
                writer.addImport(type)
                return type.name
            }

            else -> throw CodegenException("Invalid type provided for #T. Expected a Symbol, but found `$type`")
        }
    }
}

fun <T : AbstractCodeWriter<T>> T.block(
    header: String,
    vararg args: Any,
    block: T.() -> Unit
): T {
    openBlock("$header {", *args)
    block(this)
    closeBlock("}")
    return this
}

fun <T : AbstractCodeWriter<T>> T.javaClass(
    visibility: JavaVisibility,
    name: String,
    annotations: List<Symbol>? = null,
    extends: Symbol? = null,
    implements: List<Symbol>? = null,
    body: T.() -> Unit
): T {
    annotations?.forEach {
        write("@#T", it)
    }
    var header = format(
        "#L #L",
        visibility,
        name
    )
    if (extends != null) {
        header = format("#L extends #T", header, extends)
    }
    if (!implements.isNullOrEmpty()) {
        header = format(
            "#L implements #L",
            header,
            implements.joinToString(separator = ", ") { format("#T", it) }
        )
    }
    return block(header, block = body)
}