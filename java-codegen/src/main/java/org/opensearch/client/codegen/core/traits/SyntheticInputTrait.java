package org.opensearch.client.codegen.core.traits;

import software.amazon.smithy.model.node.Node;
import software.amazon.smithy.model.shapes.ShapeId;
import software.amazon.smithy.model.traits.AnnotationTrait;

public class SyntheticInputTrait extends AnnotationTrait {
    private static final ShapeId ID = ShapeId.from("smithy.api.internal#syntheticInput");
    private final ShapeId operation;

    public SyntheticInputTrait(ShapeId operation) {
        super(ID, Node.objectNode());
        this.operation = operation;
    }

    public ShapeId getOperation() {
        return operation;
    }
}
