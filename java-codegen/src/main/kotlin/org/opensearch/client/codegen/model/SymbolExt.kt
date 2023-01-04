package org.opensearch.client.codegen.model

import software.amazon.smithy.codegen.core.Symbol
import software.amazon.smithy.model.shapes.Shape

object SymbolProperty {
    const val SHAPE_KEY: String = "shape"
    const val NULLABLE_KEY: String = "nullable"
}

fun String.toSymbol(): Symbol {
    require(isNotBlank()) { "Invalid string to convert to symbol" }
    val segments = split(".")
    val name = segments.last()
    val namespace = segments.dropLast(1).joinToString(separator = ".") { it }
    return Symbol.builder()
        .name(name)
        .namespace(namespace, ".")
        .build()
}

fun Symbol.Builder.boxed(): Symbol.Builder {
    val symbol = build()
    val newName = if (symbol.namespace.isNullOrEmpty()) {
        when (symbol.name) {
            "byte" -> "Byte"
            "short" -> "Short"
            "int" -> "Integer"
            "long" -> "Long"
            "float" -> "Float"
            "double" -> "Double"
            "boolean" -> "Boolean"
            "char" -> "Character"
            else -> null
        }
    } else {
        null
    }

    return if (newName != null) {
        this.name(newName)
    } else {
        this
    }
}

fun Symbol.Builder.nullable(): Symbol.Builder =
    boxed()
        .putProperty(SymbolProperty.NULLABLE_KEY, true)

val Symbol.isNullable: Boolean
    get() = getProperty(SymbolProperty.NULLABLE_KEY).map {
        when (it) {
            is Boolean -> it
            else -> false
        }
    }.orElse(false)

val Symbol.shape: Shape
    get() = getProperty(SymbolProperty.SHAPE_KEY, Shape::class.java).get()