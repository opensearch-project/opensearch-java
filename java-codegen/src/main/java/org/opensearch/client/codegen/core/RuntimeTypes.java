package org.opensearch.client.codegen.core;

import org.opensearch.client.codegen.model.Symbols;
import software.amazon.smithy.codegen.core.Symbol;

public class RuntimeTypes {
    private static final String CLIENT_PKG = "org.opensearch.client";

    public static final Symbol ApiClient = Symbols.from(CLIENT_PKG, "ApiClient");
    
    public static class Json {
        private static final String JSON_PKG = CLIENT_PKG + ".json";

        public static final Symbol JsonpDeserializable = Symbols.from(JSON_PKG, "JsonpDeserializable");
        public static final Symbol JsonpDeserializer = Symbols.from(JSON_PKG, "JsonpDeserializer");
        public static final Symbol JsonpMapper = Symbols.from(JSON_PKG, "JsonpMapper");
        public static final Symbol JsonpSerializable = Symbols.from(JSON_PKG, "JsonpSerializable");
        public static final Symbol ObjectBuilderDeserializer = Symbols.from(JSON_PKG, "ObjectBuilderDeserializer");
        public static final Symbol ObjectDeserializer = Symbols.from(JSON_PKG, "ObjectDeserializer");
    }

    public static class OpenSearch {
        private static final String OPENSEARCH_PKG = CLIENT_PKG + ".opensearch";

        public static class Types {
            private static final String TYPES_PKG = OPENSEARCH_PKG + "._types";

            public static final Symbol ErrorResponse = Symbols.from(TYPES_PKG, "ErrorResponse");
            public static final Symbol OpenSearchException = Symbols.from(TYPES_PKG, "OpenSearchException");
            public static final Symbol RequestBase = Symbols.from(TYPES_PKG, "RequestBase");
        }
    }
    
    public static class Transport {
        private static final String TRANSPORT_PKG = CLIENT_PKG + ".transport";

        public static final Symbol Endpoint = Symbols.from(TRANSPORT_PKG, "Endpoint");
        public static final Symbol JsonEndpoint = Symbols.from(TRANSPORT_PKG, "JsonEndpoint");
        public static final Symbol OpenSearchTransport = Symbols.from(TRANSPORT_PKG, "OpenSearchTransport");
        public static final Symbol TransportOptions = Symbols.from(TRANSPORT_PKG, "TransportOptions");
        
        public static class Endpoints {
            private static final String ENDPOINTS_PKG = TRANSPORT_PKG + ".endpoints";
            
            public static final Symbol SimpleEndpoint = Symbols.from(ENDPOINTS_PKG, "SimpleEndpoint");
        }
    }
    
    public static class Util {
        private static final String UTIL_PKG = CLIENT_PKG + ".util";

        public static final Symbol ApiTypeHelper = Symbols.from(UTIL_PKG, "ApiTypeHelper");
        public static final Symbol ObjectBuilder = Symbols.from(UTIL_PKG, "ObjectBuilder");
        public static final Symbol ObjectBuilderBase = Symbols.from(UTIL_PKG, "ObjectBuilderBase");
    }

    public static class Jakarta {
        public static final Symbol JsonGenerator = Symbols.from("jakarta.json.stream", "JsonGenerator");
    }

    public static class JavaIo {
        public static final Symbol IOException = Symbols.from(java.io.IOException.class);
    }

    public static class JavaUtil {
        public static final Symbol Function = Symbols.from(java.util.function.Function.class);
        public static final Symbol HashMap = Symbols.from(java.util.HashMap.class);
        public static final Symbol List = Symbols.from(java.util.List.class);
        public static final Symbol Map = Symbols.from(java.util.Map.class);
    }

    public static class Javax {
        public static final Symbol Nullable = Symbols.from("javax.annotation", "Nullable");
    }
}
