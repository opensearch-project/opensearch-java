package org.opensearch.client.codegen;

import org.opensearch.client.codegen.core.GenerationContext;
import org.opensearch.client.codegen.core.JavaDelegator;
import org.opensearch.client.codegen.core.JavaSymbolProvider;
import org.opensearch.client.codegen.core.RenderingContext;
import org.opensearch.client.codegen.model.OperationNormalizer;
import org.opensearch.client.codegen.render.ServiceGenerator;
import org.opensearch.client.codegen.render.StructureGenerator;
import software.amazon.smithy.build.FileManifest;
import software.amazon.smithy.build.PluginContext;
import software.amazon.smithy.codegen.core.Symbol;
import software.amazon.smithy.model.Model;
import software.amazon.smithy.model.knowledge.HttpBindingIndex;
import software.amazon.smithy.model.neighbor.Walker;
import software.amazon.smithy.model.shapes.ServiceShape;
import software.amazon.smithy.model.shapes.Shape;
import software.amazon.smithy.model.shapes.ShapeVisitor;
import software.amazon.smithy.model.shapes.StructureShape;
import software.amazon.smithy.model.transform.ModelTransformer;

import java.util.logging.Logger;

public class CodegenVisitor extends ShapeVisitor.Default<Void> {
    private static final Logger LOGGER = Logger.getLogger(CodegenVisitor.class.getName());
    private final OpenSearchJavaSettings settings;
    private final Model model;
    private final ServiceShape service;
    private final JavaSymbolProvider symbolProvider;
    private final JavaDelegator writers;
    private final GenerationContext generationContext;


    public CodegenVisitor(PluginContext context) {
        settings = OpenSearchJavaSettings.from(context.getModel(), context.getSettings());
        model = baselineTransform(context.getModel());
        service = settings.getService(model);
        FileManifest fileManifest = context.getFileManifest();
        symbolProvider = new JavaSymbolProvider(model);
        HttpBindingIndex httpBindingIndex = HttpBindingIndex.of(model);
        writers = new JavaDelegator(fileManifest, symbolProvider);
        generationContext = new GenerationContext(model, symbolProvider, httpBindingIndex, settings);
    }

    private Model baselineTransform(Model model) {
        model = ModelTransformer.create().flattenAndRemoveMixins(model);
        model = ModelTransformer.create().copyServiceErrorsToOperations(model, settings.getService(model));
        model = OperationNormalizer.transform(model);
        return model;
    }

    public void execute() {
        new Walker(model)
                .walkShapes(service)
                .forEach(s -> s.accept(this));
        writers.flushWriters();
    }

    @Override
    protected Void getDefault(Shape shape) {
        return null;
    }

    @Override
    public Void serviceShape(ServiceShape shape) {
        LOGGER.info("Generating structure " + shape.getId().getName());

        writers.useShapeWriter(shape, w -> {
            RenderingContext<ServiceShape> ctx = new RenderingContext<>(generationContext, w, shape);
            new ServiceGenerator(ctx).render();
        });

        Symbol asyncSymbol = symbolProvider.serviceAsyncSymbol(shape);
        writers.useSymbolWriter(asyncSymbol, w -> {
            RenderingContext<ServiceShape> ctx = new RenderingContext<>(generationContext, w, shape, asyncSymbol);
            new ServiceGenerator(ctx).render();
        });

        return null;
    }

    @Override
    public Void structureShape(StructureShape shape) {
        writers.useShapeWriter(shape, w -> {
            RenderingContext<StructureShape> ctx = new RenderingContext<>(generationContext, w, shape);
            new StructureGenerator(ctx).render();
        });

        return null;
    }
}
