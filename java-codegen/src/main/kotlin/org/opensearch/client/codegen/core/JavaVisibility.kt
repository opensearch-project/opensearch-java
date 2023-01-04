package org.opensearch.client.codegen.core

enum class JavaVisibility {
    PUBLIC,
    PROTECTED,
    PRIVATE;

    override fun toString(): String {
        return super.toString().lowercase()
    }
}