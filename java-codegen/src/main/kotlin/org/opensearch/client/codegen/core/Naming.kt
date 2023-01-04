package org.opensearch.client.codegen.core

import org.opensearch.client.codegen.utils.toCamelCase
import org.opensearch.client.codegen.utils.toPascalCase
import software.amazon.smithy.model.shapes.MemberShape
import software.amazon.smithy.model.shapes.OperationShape
import software.amazon.smithy.model.shapes.ServiceShape
import software.amazon.smithy.model.shapes.StructureShape

fun MemberShape.defaultName(): String = memberName.toCamelCase()

fun OperationShape.defaultName(): String = id.name.toPascalCase()

fun ServiceShape.defaultName(): String = id.name.toPascalCase() + "Client"

fun ServiceShape.asyncName(): String = id.name.toPascalCase() + "AsyncClient"

fun StructureShape.defaultName(): String = id.name.toPascalCase()