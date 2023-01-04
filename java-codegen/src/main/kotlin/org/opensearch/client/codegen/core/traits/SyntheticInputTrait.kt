package org.opensearch.client.codegen.core.traits

import software.amazon.smithy.model.node.Node
import software.amazon.smithy.model.shapes.ShapeId
import software.amazon.smithy.model.traits.AnnotationTrait

class SyntheticInputTrait(
    val operation: ShapeId,
    val originalId: ShapeId?,
) : AnnotationTrait(ID, Node.objectNode()) {
    companion object {
        val ID: ShapeId = ShapeId.from("smithy.api.internal#syntheticInput")
    }
}
