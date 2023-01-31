package org.opensearch.client.codegen.render;

import org.opensearch.client.codegen.core.JavaWriter;
import org.opensearch.client.codegen.core.RenderingContext;
import org.opensearch.client.codegen.core.RuntimeTypes;
import org.opensearch.client.codegen.model.Shapes;
import org.opensearch.client.codegen.utils.Strings;
import software.amazon.smithy.codegen.core.Symbol;
import software.amazon.smithy.codegen.core.SymbolProvider;
import software.amazon.smithy.model.Model;
import software.amazon.smithy.model.knowledge.TopDownIndex;
import software.amazon.smithy.model.shapes.OperationShape;
import software.amazon.smithy.model.shapes.ServiceShape;
import software.amazon.smithy.model.shapes.Shape;
import software.amazon.smithy.model.shapes.StructureShape;

import java.util.Comparator;
import java.util.NoSuchElementException;

public class ServiceGenerator {
    private final Model model;
    private final Shape shape;
    private final SymbolProvider symbolProvider;
    private final Symbol symbol;
    private final JavaWriter writer;
    private final TopDownIndex index;

    public ServiceGenerator(RenderingContext<ServiceShape> ctx) {
        model = ctx.getModel();
        shape = ctx.getShape().orElseThrow(() -> new NoSuchElementException("Missing shape on rendering context"));
        symbolProvider = ctx.getSymbolProvider();
        symbol = symbolProvider.toSymbol(shape);
        writer = ctx.getWriter();
        index = TopDownIndex.of(model);
    }

    public void render() {
        writer.block(
                "public class #1T extends #2T<#3T, #1T>",
                new Object[]{symbol, RuntimeTypes.ApiClient, RuntimeTypes.Transport.OpenSearchTransport},
                w -> {
                    renderConstructors();

                    index.getContainedOperations(shape)
                            .stream()
                            .sorted(Comparator.comparing(Shape::getId))
                            .forEach(this::renderOperation);
                }
        );
    }

    private void renderConstructors() {
        writer.block(
                "public #T(#T transport)",
                new Object[]{symbol, RuntimeTypes.Transport.OpenSearchTransport},
                w -> w.write("super(transport);")
        );
        writer.write("");

        writer.block(
                "public #T(#T transport, @#T #T transportOptions)",
                new Object[]{symbol, RuntimeTypes.Transport.OpenSearchTransport, RuntimeTypes.Javax.Nullable, RuntimeTypes.Transport.TransportOptions},
                w -> w.write("super(transport, transportOptions);")
        );
        writer.write("");

        writer.block(
                "@Override public #T withTransportOptions(@#T #T transportOptions)",
                new Object[]{symbol, RuntimeTypes.Javax.Nullable, RuntimeTypes.Transport.TransportOptions},
                w -> w.write("return new #T(this.transport, transportOptions);", symbol)
        );
        writer.write("");
    }

    private void renderOperation(OperationShape operation) {
        StructureShape inputShape = Shapes.getInputShape(operation, model);
        Symbol inputSymbol = symbolProvider.toSymbol(inputShape);
        StructureShape outputShape = Shapes.getOutputShape(operation, model);
        Symbol outputSymbol = symbolProvider.toSymbol(outputShape);
        String operationName = Strings.toCamelCase(operation.getId().getName());

        writer.block(
                "public #T #L(#T request) throws #T, #T",
                new Object[]{outputSymbol, operationName, inputSymbol, RuntimeTypes.JavaIo.IOException, RuntimeTypes.OpenSearch.Types.OpenSearchException},
                w -> {
                    String endpointType = w.format(
                            "#T<#T, #T, #T>",
                            RuntimeTypes.Transport.JsonEndpoint,
                            inputSymbol,
                            outputSymbol,
                            RuntimeTypes.OpenSearch.Types.ErrorResponse
                    );

                    w.write("@SuppressWarnings(\"unchecked\")");
                    w.write("#1L endpoint = (#1L) #2T._ENDPOINT;", endpointType, inputSymbol);
                    w.write("");
                    w.write("return this.transport.performRequest(request, endpoint, this.transportOptions);");
                }
        );
        writer.write("");

        writer.block(
                "public final #1T #2L(#3T<#4T.Builder, #5T<#4T>> fn) throws #6T, #7T",
                new Object[]{outputSymbol, operationName, RuntimeTypes.JavaUtil.Function, inputSymbol, RuntimeTypes.Util.ObjectBuilder, RuntimeTypes.JavaIo.IOException, RuntimeTypes.OpenSearch.Types.OpenSearchException},
                w -> w.write("return #L(fn.apply(new #T.Builder()).build());", operationName, inputSymbol)
        );
        writer.write("");
    }
}
