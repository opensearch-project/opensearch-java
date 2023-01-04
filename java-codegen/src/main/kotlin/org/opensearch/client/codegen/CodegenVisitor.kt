package org.opensearch.client.codegen

import org.opensearch.client.codegen.core.GenerationContext
import org.opensearch.client.codegen.core.JavaDelegator
import org.opensearch.client.codegen.core.JavaSymbolProvider
import org.opensearch.client.codegen.core.toRenderingContext
import org.opensearch.client.codegen.model.OperationNormalizer
import org.opensearch.client.codegen.render.ServiceGenerator
import org.opensearch.client.codegen.render.StructureGenerator
import software.amazon.smithy.build.FileManifest
import software.amazon.smithy.build.PluginContext
import software.amazon.smithy.codegen.core.SymbolProvider
import software.amazon.smithy.model.Model
import software.amazon.smithy.model.knowledge.HttpBindingIndex
import software.amazon.smithy.model.neighbor.Walker
import software.amazon.smithy.model.shapes.ServiceShape
import software.amazon.smithy.model.shapes.Shape
import software.amazon.smithy.model.shapes.ShapeVisitor
import software.amazon.smithy.model.shapes.StructureShape
import software.amazon.smithy.model.transform.ModelTransformer
import java.util.logging.Logger

class CodegenVisitor(
    context: PluginContext
) : ShapeVisitor.Default<Unit>() {
    private val logger = Logger.getLogger(javaClass.name)
    private val settings = OpenSearchJavaSettings.from(context.model, context.settings)

    private val model: Model
    private val service: ServiceShape
    private val fileManifest: FileManifest = context.fileManifest
    private val symbolProvider: JavaSymbolProvider
    private val httpBindingIndex: HttpBindingIndex
    private val writers: JavaDelegator
    private val generationContext: GenerationContext

    init {
        model = baselineTransform(context.model)
        service = settings.getService(model)
        symbolProvider = JavaSymbolProvider(model, settings)
        httpBindingIndex = HttpBindingIndex.of(model)
        writers = JavaDelegator(fileManifest, symbolProvider, settings)
        generationContext = GenerationContext(model, symbolProvider, httpBindingIndex, settings)
    }

    private fun baselineTransform(model: Model) =
        model
            .let { ModelTransformer.create().flattenAndRemoveMixins(it) }
            .let { ModelTransformer.create().copyServiceErrorsToOperations(it, settings.getService(it)) }
            .let { OperationNormalizer.transform(it) }

    fun execute() {
        val service = settings.getService(model)
        val serviceShapes = Walker(model).walkShapes(service)
        serviceShapes.forEach { it.accept(this) }
        writers.finalize()
    }

    override fun getDefault(shape: Shape?) {}

    override fun serviceShape(shape: ServiceShape) {
        logger.info("Generating structure ${shape.id.name}")
        writers.useShapeWriter(shape) {
            val ctx = generationContext.toRenderingContext(it, shape)
            ServiceGenerator(ctx).render()
        }
        val asyncSymbol = symbolProvider.serviceAsyncSymbol(shape)
        writers.useSymbolWriter(asyncSymbol) {
            val ctx = generationContext.toRenderingContext(it, shape, asyncSymbol)
            ServiceGenerator(ctx).render()
        }
    }

    override fun structureShape(shape: StructureShape) {
        writers.useShapeWriter(shape) {
            val ctx = generationContext.toRenderingContext(it, shape)
            StructureGenerator(ctx).render()
        }
    }
}