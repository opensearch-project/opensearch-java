package org.opensearch.client.codegen.core;

import org.opensearch.client.codegen.utils.Strings;
import software.amazon.smithy.model.shapes.MemberShape;
import software.amazon.smithy.model.shapes.OperationShape;
import software.amazon.smithy.model.shapes.ServiceShape;
import software.amazon.smithy.model.shapes.StructureShape;

public class Naming {
    public static String defaultName(MemberShape shape) {
        return Strings.toCamelCase(shape.getMemberName());
    }

    public static String defaultName(OperationShape shape) {
        return Strings.toCamelCase(shape.getId().getName());
    }

    public static String defaultName(ServiceShape shape) {
        return Strings.toPascalCase(shape.getId().getName()) + "Client";
    }

    public static String asyncName(ServiceShape shape) {
        return Strings.toPascalCase(shape.getId().getName()) + "AsyncClient";
    }

    public static String defaultName(StructureShape shape) {
        return Strings.toPascalCase(shape.getId().getName());
    }
}
