package org.opensearch.client.codegen;

import software.amazon.smithy.codegen.core.CodegenException;
import software.amazon.smithy.model.Model;
import software.amazon.smithy.model.node.ObjectNode;
import software.amazon.smithy.model.node.StringNode;
import software.amazon.smithy.model.shapes.ServiceShape;
import software.amazon.smithy.model.shapes.Shape;
import software.amazon.smithy.model.shapes.ShapeId;

import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class OpenSearchJavaSettings {
    private static final Logger LOGGER = Logger.getLogger(OpenSearchJavaSettings.class.getName());
    private static final String SERVICE = "service";
    private final ShapeId service;

    private OpenSearchJavaSettings(ShapeId service) {
        this.service = service;
    }

    public ServiceShape getService(Model model) {
        return model.expectShape(service, ServiceShape.class);
    }

    public static OpenSearchJavaSettings from(Model model, ObjectNode config) {
        config.warnIfAdditionalProperties(Collections.singletonList(SERVICE));

        ShapeId service = config.getStringMember(SERVICE).map(StringNode::expectShapeId).orElseGet(() -> inferService(model));

        return new OpenSearchJavaSettings(service);
    }

    private static ShapeId inferService(Model model) {
        List<ShapeId> services = model.shapes(ServiceShape.class).map(Shape::getId).sorted().collect(Collectors.toList());

        if (services.isEmpty()) {
            throw new CodegenException("Cannot infer a service to generate because the model does not contain any service shapes");
        }
        if (services.size() > 1) {
            throw new CodegenException("Cannot infer a service to generate because the model contains multiple service shapes: " + services);
        }

        ShapeId service = services.get(0);
        LOGGER.info("Inferring service to generate as: " + service);
        return service;
    }
}
