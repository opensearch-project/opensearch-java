package org.opensearch.client.codegen.model

import software.amazon.smithy.model.Model
import software.amazon.smithy.model.shapes.OperationShape
import software.amazon.smithy.model.shapes.Shape
import software.amazon.smithy.model.shapes.ShapeId
import software.amazon.smithy.model.shapes.StructureShape
import software.amazon.smithy.model.traits.Trait

inline fun <reified T : Trait> Shape.hasTrait(): Boolean = hasTrait(T::class.java)
inline fun <reified T : Trait> Shape.getTrait(): T? = getTrait(T::class.java).orElse(null)
inline fun <reified T : Trait> Shape.expectTrait(): T = expectTrait(T::class.java)

fun OperationShape.inputShape(model: Model): StructureShape = model.expectShape<StructureShape>(this.inputShape)
fun OperationShape.outputShape(model: Model): StructureShape = model.expectShape<StructureShape>(this.outputShape)

fun StructureShape.Builder.rename(newId: ShapeId): StructureShape.Builder {
    val renamedMembers = this.build().members().map {
        it.toBuilder().id(newId.withMember(it.memberName)).build()
    }
    return this.id(newId).members(renamedMembers)
}

val Shape.isListOrMap: Boolean
    get() = isListShape || isMapShape