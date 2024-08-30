/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen.model;

import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

public final class Types {
    public static final Map<String, Object> TYPES_MAP = asMap(Types.class);

    private static Map<String, Object> asMap(Class<?> clazz) {
        var map = new HashMap<String, Object>();

        for (var subClazz : clazz.getDeclaredClasses()) {
            if ((subClazz.getModifiers() & Modifier.STATIC) == 0) {
                continue;
            }
            map.put(subClazz.getSimpleName(), asMap(subClazz));
        }

        for (var field : clazz.getDeclaredFields()) {
            if ((field.getModifiers() & Modifier.STATIC) == 0 || !Type.class.isAssignableFrom(field.getType())) {
                continue;
            }
            try {
                map.put(field.getName(), field.get(null));
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }

        return map;
    }

    public static final class Primitive {
        public static final Type Boolean = Type.builder().withName("boolean").build();
        public static final Type Int = Type.builder().withName("int").build();
        public static final Type Long = Type.builder().withName("long").build();
        public static final Type Float = Type.builder().withName("float").build();
        public static final Type Double = Type.builder().withName("double").build();
    }

    public static final class Java {
        public static final String PACKAGE = "java";

        public static final class Io {
            public static final String PACKAGE = Java.PACKAGE + ".io";
            public static final Type IOException = Type.builder().withPackage(PACKAGE).withName("IOException").build();
        }

        public static final class Lang {
            public static final String PACKAGE = Java.PACKAGE + ".lang";
            public static final Type String = Type.builder().withPackage(PACKAGE).withName("String").build();
            public static final Type Character = Type.builder().withPackage(PACKAGE).withName("Character").build();
            public static final Type Boolean = Type.builder().withPackage(PACKAGE).withName("Boolean").build();
            public static final Type Byte = Type.builder().withPackage(PACKAGE).withName("Byte").build();
            public static final Type Short = Type.builder().withPackage(PACKAGE).withName("Short").build();
            public static final Type Integer = Type.builder().withPackage(PACKAGE).withName("Integer").build();
            public static final Type Long = Type.builder().withPackage(PACKAGE).withName("Long").build();
            public static final Type Float = Type.builder().withPackage(PACKAGE).withName("Float").build();
            public static final Type Double = Type.builder().withPackage(PACKAGE).withName("Double").build();
            public static final Type Object = Type.builder().withPackage(PACKAGE).withName("Object").build();
        }

        public static final class Util {
            public static final String PACKAGE = Java.PACKAGE + ".util";
            public static final Type HashMap = Type.builder().withPackage(PACKAGE).withName("HashMap").build();

            public static Type Map(Type keyType, Type valueType) {
                return Map.withTypeParams(keyType, valueType);
            }

            public static final Type Map = Type.builder().withPackage(PACKAGE).withName("Map").build();

            public static Type MapEntry(Type keyType, Type valueType) {
                return Type.builder().withPackage(PACKAGE).withName("Map.Entry").withTypeParameters(keyType, valueType).build();
            }

            public static Type List(Type valueType) {
                return Type.builder().withPackage(PACKAGE).withName("List").withTypeParameters(valueType).build();
            }

            public static final class Concurrent {
                public static final String PACKAGE = Util.PACKAGE + ".concurrent";
                public static final Type CompletableFuture = Type.builder().withPackage(PACKAGE).withName("CompletableFuture").build();
            }

            public static final class Function {
                public static final String PACKAGE = Util.PACKAGE + ".function";

                public static Type Function(Type argType, Type returnType) {
                    return Type.builder().withPackage(PACKAGE).withName("Function").withTypeParameters(argType, returnType).build();
                }
            }

            public static final class Stream {
                public static final String PACKAGE = Util.PACKAGE + ".stream";
                public static final Type Collectors = Type.builder().withPackage(PACKAGE).withName("Collectors").build();
            }
        }
    }

    public static final class Javax {
        public static final String PACKAGE = "javax";

        public static final class Annotation {
            public static final String PACKAGE = Javax.PACKAGE + ".annotation";
            public static final Type Generated = Type.builder().withPackage(PACKAGE).withName("Generated").build();
            public static final Type Nullable = Type.builder().withPackage(PACKAGE).withName("Nullable").build();
        }
    }

    public static final class Client {
        public static final String PACKAGE = "org.opensearch.client";

        public static Type ApiClient(Type transport, Type client) {
            return ApiClient.withTypeParams(transport, client);
        }

        public static final Type ApiClient = Type.builder().withPackage(PACKAGE).withName("ApiClient").build();

        public static final class Json {
            public static final String PACKAGE = Client.PACKAGE + ".json";
            public static final Type JsonData = Type.builder().withPackage(PACKAGE).withName("JsonData").build();
            public static final Type JsonpDeserializable = Type.builder().withPackage(PACKAGE).withName("JsonpDeserializable").build();
            public static final Type JsonpDeserializer = Type.builder().withPackage(PACKAGE).withName("JsonpDeserializer").build();
            public static final Type JsonEnum = Type.builder().withPackage(PACKAGE).withName("JsonEnum").build();
            public static final Type JsonpMapper = Type.builder().withPackage(PACKAGE).withName("JsonpMapper").build();
            public static final Type JsonpSerializable = Type.builder().withPackage(PACKAGE).withName("JsonpSerializable").build();
            public static final Type ObjectBuilderDeserializer = Type.builder()
                .withPackage(PACKAGE)
                .withName("ObjectBuilderDeserializer")
                .build();
            public static final Type ObjectDeserializer = Type.builder().withPackage(PACKAGE).withName("ObjectDeserializer").build();
            public static final Type PlainJsonSerializable = Type.builder().withPackage(PACKAGE).withName("PlainJsonSerializable").build();
            public static final Type UnionDeserializer = Type.builder().withPackage(PACKAGE).withName("UnionDeserializer").build();
        }

        public static final class OpenSearch {
            public static final String PACKAGE = Client.PACKAGE + ".opensearch";

            public static final class _Types {
                public static final String PACKAGE = OpenSearch.PACKAGE + "._types";
                public static final Type ErrorResponse = Type.builder().withPackage(PACKAGE).withName("ErrorResponse").build();
                public static final Type OpenSearchException = Type.builder().withPackage(PACKAGE).withName("OpenSearchException").build();
                public static final Type RequestBase = Type.builder().withPackage(PACKAGE).withName("RequestBase").build();
                public static final Type Time = Type.builder().withPackage(PACKAGE).withName("Time").build();
            }
        }

        public static final class Transport {
            public static final String PACKAGE = Client.PACKAGE + ".transport";
            public static final Type Endpoint = Type.builder().withPackage(PACKAGE).withName("Endpoint").build();

            public static Type JsonEndpoint(Type requestType, Type responseType, Type errorType) {
                return JsonEndpoint.withTypeParams(requestType, responseType, errorType);
            }

            public static final Type JsonEndpoint = Type.builder().withPackage(PACKAGE).withName("JsonEndpoint").build();
            public static final Type OpenSearchTransport = Type.builder().withPackage(PACKAGE).withName("OpenSearchTransport").build();
            public static final Type TransportOptions = Type.builder().withPackage(PACKAGE).withName("TransportOptions").build();

            public static final class Endpoints {
                public static final String PACKAGE = Transport.PACKAGE + ".endpoints";
                public static final Type SimpleEndpoint = Type.builder().withPackage(PACKAGE).withName("SimpleEndpoint").build();
            }
        }

        public static final class Util {
            public static final String PACKAGE = Client.PACKAGE + ".util";
            public static final Type ApiTypeHelper = Type.builder().withPackage(PACKAGE).withName("ApiTypeHelper").build();

            public static Type ObjectBuilder(Type type) {
                return ObjectBuilder.withTypeParams(type);
            }

            public static final Type ObjectBuilder = Type.builder().withPackage(PACKAGE).withName("ObjectBuilder").build();
            public static final Type ObjectBuilderBase = Type.builder().withPackage(PACKAGE).withName("ObjectBuilderBase").build();

            public static Type TaggedUnion(Type tagType, Type baseType) {
                return TaggedUnion.withTypeParams(tagType, baseType);
            }

            public static final Type TaggedUnion = Type.builder().withPackage(PACKAGE).withName("TaggedUnion").build();
            public static final Type TaggedUnionUtils = Type.builder().withPackage(PACKAGE).withName("TaggedUnionUtils").build();
        }
    }

    public static final class Jakarta {
        public static final String PACKAGE = "jakarta";

        public static final class Json {
            public static final String PACKAGE = Jakarta.PACKAGE + ".json";

            public static final class Stream {
                public static final String PACKAGE = Json.PACKAGE + ".stream";
                public static final Type JsonGenerator = Type.builder().withPackage(PACKAGE).withName("JsonGenerator").build();
            }
        }
    }
}
