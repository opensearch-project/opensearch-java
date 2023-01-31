package org.opensearch.client.codegen.model;

import org.opensearch.client.codegen.core.traits.SyntheticInputTrait;
import software.amazon.smithy.model.Model;
import software.amazon.smithy.model.shapes.OperationShape;
import software.amazon.smithy.model.shapes.Shape;
import software.amazon.smithy.model.shapes.ShapeId;
import software.amazon.smithy.model.shapes.StructureShape;
import software.amazon.smithy.model.transform.ModelTransformer;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OperationNormalizer {
    private static final Logger LOGGER = Logger.getLogger(OperationNormalizer.class.getName());

    public static Model transform(Model model) {
        ModelTransformer transformer = ModelTransformer.create();

        List<OperationShape> operations = model.shapes(OperationShape.class).collect(Collectors.toList());
        List<StructureShape> newShapes = operations
                .stream()
                .flatMap(o -> Stream.of(syntheticInputShape(model, o), syntheticOutputShape(model, o)))
                .collect(Collectors.toList());

        Optional<StructureShape> firstConflict = newShapes.stream().filter(s -> model.getShape(s.getId()).isPresent()).findFirst();
        if (firstConflict.isPresent()) {
            throw new IllegalStateException("Shape " + firstConflict + " conflicted with an existing shape in the model (" + model.getShape(firstConflict.get().getId()) + "). This is a bug.");
        }

        Model modelWithOperationInputs = model.toBuilder().addShapes(newShapes).build();

        return transformer.mapShapes(modelWithOperationInputs, s -> s
                .asOperationShape()
                .map(o -> {
                    ShapeId id = o.getId();
                    ShapeId inputId = syntheticInputId(id);
                    modelWithOperationInputs.expectShape(inputId);
                    return (Shape) o.toBuilder()
                            .input(inputId)
                            .output(syntheticOutputId(id))
                            .build();
                })
                .orElse(s));
    }

    private static ShapeId syntheticInputId(ShapeId operationId) {
        return ShapeId.fromParts(operationId.getNamespace() + ".synthetic", operationId.getName() + "Request");
    }

    private static StructureShape syntheticInputShape(Model model, OperationShape operation) {
        ShapeId operationId = operation.getId();
        return renamedOrEmpty(model, operation::getInput, syntheticInputId(operationId))
                .addTrait(new SyntheticInputTrait(operationId))
                .build();
    }

    private static ShapeId syntheticOutputId(ShapeId operationId) {
        return ShapeId.fromParts(operationId.getNamespace() + ".synthetic", operationId.getName() + "Response");
    }

    private static StructureShape syntheticOutputShape(Model model, OperationShape operation) {
        return renamedOrEmpty(model, operation::getOutput, syntheticOutputId(operation.getId())).build();
    }

    private static StructureShape.Builder renamedOrEmpty(Model model, Supplier<Optional<ShapeId>> getExistingShape, ShapeId newId) {
        return getExistingShape
                .get()
                .map(shapeId -> model.expectShape(shapeId, StructureShape.class).toBuilder())
                .orElseGet(StructureShape::builder)
                .id(newId);
    }
}
