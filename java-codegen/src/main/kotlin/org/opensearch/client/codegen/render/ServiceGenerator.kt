package org.opensearch.client.codegen.render

import org.opensearch.client.codegen.core.*
import org.opensearch.client.codegen.model.inputShape
import org.opensearch.client.codegen.model.outputShape
import org.opensearch.client.codegen.utils.toCamelCase
import software.amazon.smithy.codegen.core.SymbolProvider
import software.amazon.smithy.model.Model
import software.amazon.smithy.model.knowledge.TopDownIndex
import software.amazon.smithy.model.shapes.OperationShape
import software.amazon.smithy.model.shapes.ServiceShape

class ServiceGenerator(
    private val ctx: RenderingContext<ServiceShape>
) {
    private val model = ctx.model
    private val shape = ctx.shape
    private val symbol = ctx.symbolProvider.toSymbol(ctx.shape)
    private val symbolProvider = ctx.symbolProvider
    private val writer = ctx.writer
    private val index = TopDownIndex.of(model)

    fun render() {
        writer.block(
            "public class #1T extends #2T<#3T, #1T>",
            symbol, RuntimeTypes.ApiClient, RuntimeTypes.Transport.OpenSearchTransport
        ) {
            renderConstructors()

            val operations = index.getContainedOperations(shape).sortedBy { it.id }
            operations.forEach(::renderOperation)
        }
    }

    private fun renderConstructors() {
        writer.block(
            "public #T(#T transport)",
            symbol, RuntimeTypes.Transport.OpenSearchTransport
        ) {
            write("super(transport);")
        }
        writer.write("")

        writer.block(
            "public #T(#T transport, @#T #T transportOptions)",
            symbol, RuntimeTypes.Transport.OpenSearchTransport, RuntimeTypes.Javax.Nullable, RuntimeTypes.Transport.TransportOptions
        ) {
            write("super(transport, transportOptions);")
        }
        writer.write("")

        writer.block(
            "@Override public #T withTransportOptions(@#T #T transportOptions)",
            symbol, RuntimeTypes.Javax.Nullable, RuntimeTypes.Transport.TransportOptions
        ) {
            write("return new #T(this.transport, transportOptions);", symbol)
        }
        writer.write("")
    }

    private fun renderOperation(operation: OperationShape) {
        val inputShape = operation.inputShape(model)
        val inputSymbol = symbolProvider.toSymbol(inputShape)
        val outputShape = operation.outputShape(model)
        val outputSymbol = symbolProvider.toSymbol(outputShape)
        val operationName = operation.id.name.toCamelCase()

        writer.block(
            "public #T #L(#T request) throws #T, #T",
            outputSymbol, operationName, inputSymbol, RuntimeTypes.JavaIo.IOException, RuntimeTypes.OpenSearch.Types.OpenSearchException
        ) {
            val endpointType = format("#T<#T, #T, #T>", RuntimeTypes.Transport.JsonEndpoint, inputSymbol, outputSymbol, RuntimeTypes.OpenSearch.Types.ErrorResponse)

            write("""
                    @SuppressWarnings("unchecked")
                    #1L endpoint = (#1L) #2T._ENDPOINT;
                    
                    return this.transport.performRequest(request, endpoint, this.transportOptions);
                """.trimIndent(), endpointType, inputSymbol)
        }
        writer.write("")

        writer.block(
            "public final #1T #2L(#3T<#4T.Builder, #5T<#4T>> fn) throws #6T, #7T",
            outputSymbol, operationName, RuntimeTypes.JavaUtil.Function, inputSymbol, RuntimeTypes.Util.ObjectBuilder, RuntimeTypes.JavaIo.IOException, RuntimeTypes.OpenSearch.Types.OpenSearchException
        ) {
            write("return #L(fn.apply(new #T.Builder()).build());", operationName, inputSymbol)
        }
        writer.write("")
    }
}