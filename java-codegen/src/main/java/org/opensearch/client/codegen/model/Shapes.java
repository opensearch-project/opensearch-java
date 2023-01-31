package org.opensearch.client.codegen.model;

import software.amazon.smithy.model.Model;
import software.amazon.smithy.model.shapes.*;

public class Shapes {
    public static boolean isListOrMap(Shape shape) {
        return shape.isListShape() || shape.isMapShape();
    }

    public static Shape getElementShape(ListShape shape, Model model) {
        return getTargetShape(shape.getMember(), model);
    }

    public static Shape getElementShape(MapShape shape, Model model) {
        return getTargetShape(shape.getValue(), model);
    }

    public static Shape getTargetShape(MemberShape shape, Model model) {
        return model.expectShape(shape.getTarget());
    }

    public static StructureShape getInputShape(OperationShape operation, Model model) {
        return model.expectShape(operation.getInputShape(), StructureShape.class);
    }

    public static StructureShape getOutputShape(OperationShape operation, Model model) {
        return model.expectShape(operation.getOutputShape(), StructureShape.class);
    }
}
