package org.opensearch.client.codegen.core

import org.opensearch.client.codegen.model.toSymbol

object RuntimeTypes {
    private const val ClientPkg = "org.opensearch.client"

    val ApiClient = "$ClientPkg.ApiClient".toSymbol()

    object Json {
        private const val JsonPkg = "$ClientPkg.json"

        val JsonpDeserializable = "$JsonPkg.JsonpDeserializable".toSymbol()
        val JsonpDeserializer = "$JsonPkg.JsonpDeserializer".toSymbol()
        val JsonpMapper = "$JsonPkg.JsonpMapper".toSymbol()
        val JsonpSerializable = "$JsonPkg.JsonpSerializable".toSymbol()
        val ObjectBuilderDeserializer = "$JsonPkg.ObjectBuilderDeserializer".toSymbol()
        val ObjectDeserializer = "$JsonPkg.ObjectDeserializer".toSymbol()
    }

    object OpenSearch {
        private const val OpenSearchPkg = "$ClientPkg.opensearch"

        object Types {
            private const val TypesPkg = "$OpenSearchPkg._types"

            val ErrorResponse = "$TypesPkg.ErrorResponse".toSymbol()
            val OpenSearchException = "$TypesPkg.OpenSearchException".toSymbol()
            val RequestBase = "$TypesPkg.RequestBase".toSymbol()
        }
    }

    object Transport {
        private const val TransportPkg = "$ClientPkg.transport"

        val Endpoint = "$TransportPkg.Endpoint".toSymbol()
        val JsonEndpoint = "$TransportPkg.JsonEndpoint".toSymbol()
        val OpenSearchTransport = "$TransportPkg.OpenSearchTransport".toSymbol()
        val TransportOptions = "$TransportPkg.TransportOptions".toSymbol()

        object Endpoints {
            private const val EndpointsPkg = "$TransportPkg.endpoints"

            val SimpleEndpoint = "$EndpointsPkg.SimpleEndpoint".toSymbol()
        }
    }

    object Util {
        private const val UtilPkg = "$ClientPkg.util"

        val ApiTypeHelper = "$UtilPkg.ApiTypeHelper".toSymbol()
        val ObjectBuilder = "$UtilPkg.ObjectBuilder".toSymbol()
        val ObjectBuilderBase = "$UtilPkg.ObjectBuilderBase".toSymbol()
    }

    object Jakarta {
        val JsonGenerator = "jakarta.json.stream.JsonGenerator".toSymbol()
    }

    object JavaIo {
        val IOException = "java.io.IOException".toSymbol()
    }

    object JavaUtil {
        val Function = "java.util.function.Function".toSymbol()
        val HashMap = "java.util.HashMap".toSymbol()
        val Map = "java.util.Map".toSymbol()
    }

    object Javax {
        val Nullable = "javax.annotation.Nullable".toSymbol()
    }
}