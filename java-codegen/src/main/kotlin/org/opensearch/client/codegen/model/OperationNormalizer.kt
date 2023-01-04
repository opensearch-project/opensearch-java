package org.opensearch.client.codegen.model

import org.opensearch.client.codegen.core.traits.SyntheticInputTrait
import software.amazon.smithy.model.Model
import software.amazon.smithy.model.shapes.OperationShape
import software.amazon.smithy.model.shapes.Shape
import software.amazon.smithy.model.shapes.ShapeId
import software.amazon.smithy.model.shapes.StructureShape
import software.amazon.smithy.model.transform.ModelTransformer
import java.util.*
import kotlin.streams.toList

object OperationNormalizer {
    private fun OperationShape.syntheticInputId() =
        ShapeId.fromParts(this.id.namespace + ".synthetic", "${this.id.name}Request")

    private fun OperationShape.syntheticOutputId() =
        ShapeId.fromParts(this.id.namespace + ".synthetic", "${this.id.name}Response")

    fun transform(model: Model): Model {
        val transformer = ModelTransformer.create()
        val operations = model.shapes(OperationShape::class.java).toList()
        val newShapes = operations.flatMap { operation ->
            // Generate or modify the input and output of the given `Operation` to be a unique shape
            listOf(syntheticInputShape(model, operation), syntheticOutputShape(model, operation))
        }
        val shapeConflict = newShapes.firstOrNull { shape -> model.getShape(shape.id).isPresent }
        check(
            shapeConflict == null,
        ) { "shape $shapeConflict conflicted with an existing shape in the model (${model.getShape(shapeConflict!!.id)}. This is a bug." }
        val modelWithOperationInputs = model.toBuilder().addShapes(newShapes).build()
        return transformer.mapShapes(modelWithOperationInputs) {
            // Update all operations to point to their new input/output shapes
            val transformed: Optional<Shape> = it.asOperationShape().map { operation ->
                modelWithOperationInputs.expectShape(operation.syntheticInputId())
                operation.toBuilder()
                    .input(operation.syntheticInputId())
                    .output(operation.syntheticOutputId())
                    .build()
            }
            transformed.orElse(it)
        }
    }

    private fun syntheticOutputShape(model: Model, operation: OperationShape): StructureShape {
        val outputId = operation.syntheticOutputId()
        val outputShapeBuilder = operation.output.map { shapeId ->
            model.expectShape(shapeId, StructureShape::class.java).toBuilder().rename(outputId)
        }.orElse(empty(outputId))
        return outputShapeBuilder.build()
    }

    private fun syntheticInputShape(model: Model, operation: OperationShape): StructureShape {
        val inputId = operation.syntheticInputId()
        val inputShapeBuilder = operation.input.map { shapeId ->
            model.expectShape(shapeId, StructureShape::class.java).toBuilder().rename(inputId)
        }.orElse(empty(inputId))
        return inputShapeBuilder.addTrait(
            SyntheticInputTrait(operation.id, operation.input.orElse(null))
        ).build()
    }

    private fun empty(id: ShapeId): StructureShape.Builder = StructureShape.builder().id(id)
}