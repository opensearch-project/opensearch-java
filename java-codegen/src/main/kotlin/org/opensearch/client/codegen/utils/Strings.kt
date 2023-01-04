package org.opensearch.client.codegen.utils

import software.amazon.smithy.utils.CaseUtils
import software.amazon.smithy.utils.StringUtils

fun String.dq(): String = StringUtils.escapeJavaString(this, "")

fun String.toSnakeCase(): String = CaseUtils.toSnakeCase(this)

fun String.toPascalCase(): String = CaseUtils.toPascalCase(toSnakeCase())

fun String.toCamelCase(): String = CaseUtils.toCamelCase(toSnakeCase())
