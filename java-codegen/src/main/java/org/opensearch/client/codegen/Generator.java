package org.opensearch.client.codegen;

import org.opensearch.client.codegen.exceptions.ApiSpecificationParseException;
import org.opensearch.client.codegen.exceptions.RenderException;

import java.io.File;

public class Generator {
    private final ApiSpecification apiSpecification;
    private final Renderer renderer;

    public Generator(File schemaFile) throws ApiSpecificationParseException {
        apiSpecification = ApiSpecification.parse(schemaFile);
        renderer = new Renderer();
    }

    public void generate() throws RenderException {
        renderer.render(apiSpecification.getOperationRequests().get(12));
    }
}
