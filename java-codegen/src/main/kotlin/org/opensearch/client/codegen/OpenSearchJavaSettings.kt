package org.opensearch.client.codegen

import org.opensearch.client.codegen.model.expectShape
import software.amazon.smithy.codegen.core.CodegenException
import software.amazon.smithy.model.Model
import software.amazon.smithy.model.node.ObjectNode
import software.amazon.smithy.model.node.StringNode
import software.amazon.smithy.model.shapes.ServiceShape
import software.amazon.smithy.model.shapes.Shape
import software.amazon.smithy.model.shapes.ShapeId
import java.util.logging.Logger
import kotlin.streams.toList

const val SERVICE: String = "service"

class OpenSearchJavaSettings(
    val service: ShapeId
) {
    fun getService(model: Model): ServiceShape {
        return model.expectShape<ServiceShape>(service)
    }

    companion object {
        private val LOGGER: Logger = Logger.getLogger(OpenSearchJavaSettings::class.java.name)

        fun from(model: Model, config: ObjectNode): OpenSearchJavaSettings {
            config.warnIfAdditionalProperties(
                arrayListOf(
                    SERVICE
                )
            )

            val service = config.getStringMember(SERVICE)
                .map(StringNode::expectShapeId)
                .orElseGet { inferService(model) }

            return OpenSearchJavaSettings(service)
        }

        @JvmStatic
        private fun inferService(model: Model): ShapeId {
            val services = model.shapes(ServiceShape::class.java)
                .map(Shape::getId)
                .sorted()
                .toList()

            when {
                services.isEmpty() -> {
                    throw CodegenException(
                        "Cannot infer a service to generate because the model does not " +
                                "contain any service shapes",
                    )
                }

                services.size > 1 -> {
                    throw CodegenException(
                        "Cannot infer service to generate because the model contains " +
                                "multiple service shapes: " + services,
                    )
                }

                else -> {
                    val service = services[0]
                    LOGGER.info("Inferring service to generate as: $service")
                    return service
                }
            }
        }
    }
}