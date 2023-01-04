package org.opensearch.client.codegen.core

import software.amazon.smithy.codegen.core.ReservedWords
import software.amazon.smithy.codegen.core.ReservedWordsBuilder

fun javaReservedWords(): ReservedWords = ReservedWordsBuilder().apply {
    hardReservedWords.forEach { put(it, "_$it") }
}.build()

val hardReservedWords = listOf(
    "null"
)