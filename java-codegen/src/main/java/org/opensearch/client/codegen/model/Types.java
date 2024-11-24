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
    private static Map<String, Object> TYPES_MAP;

    public static Map<String, Object> asMap() {
        if (TYPES_MAP == null) {
            TYPES_MAP = asMap(Types.class);
        }
        return TYPES_MAP;
    }

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

    private static Type type(String name) {
        return Type.builder().withName(name).build();
    }

    private static Type type(String packageName, String name) {
        return Type.builder().withPackage(packageName).withName(name).build();
    }

    public static final class Primitive {
        public static final Type Boolean = type("boolean");
        public static final Type Int = type("int");
        public static final Type Long = type("long");
        public static final Type Float = type("float");
        public static final Type Double = type("double");
    }

    public static final class Java {
        public static final String PACKAGE = "java";

        public static final class Io {
            public static final String PACKAGE = Java.PACKAGE + ".io";
            public static final Type IOException = type(PACKAGE, "IOException");
        }

        public static final class Lang {
            public static final String PACKAGE = Java.PACKAGE + ".lang";
            public static final Type String = type(PACKAGE, "String");
            public static final Type Character = type(PACKAGE, "Character");
            public static final Type Boolean = type(PACKAGE, "Boolean");
            public static final Type Byte = type(PACKAGE, "Byte");
            public static final Type Short = type(PACKAGE, "Short");
            public static final Type Integer = type(PACKAGE, "Integer");
            public static final Type Long = type(PACKAGE, "Long");
            public static final Type Float = type(PACKAGE, "Float");
            public static final Type Double = type(PACKAGE, "Double");
            public static final Type Object = type(PACKAGE, "Object");
            public static final Type Number = type(PACKAGE, "Number");
        }

        public static final class Util {
            public static final String PACKAGE = Java.PACKAGE + ".util";
            public static final Type Objects = type(PACKAGE, "Objects");
            public static final Type HashMap = type(PACKAGE, "HashMap");

            public static Type Map(Type keyType, Type valueType) {
                return Map.withTypeParameters(keyType, valueType);
            }

            public static final Type Map = type(PACKAGE, "Map");

            public static Type MapEntry(Type keyType, Type valueType) {
                return MapEntry.withTypeParameters(keyType, valueType);
            }

            public static final Type MapEntry = type(PACKAGE, "Map.Entry");

            public static Type List(Type valueType) {
                return List.withTypeParameters(valueType);
            }

            public static final Type List = type(PACKAGE, "List");

            public static final class Concurrent {
                public static final String PACKAGE = Util.PACKAGE + ".concurrent";
                public static final Type CompletableFuture = type(PACKAGE, "CompletableFuture");
            }

            public static final class Function {
                public static final String PACKAGE = Util.PACKAGE + ".function";

                public static Type Function(Type argType, Type returnType) {
                    return Function.withTypeParameters(argType, returnType);
                }

                public static final Type Function = type(PACKAGE, "Function");
            }

            public static final class Stream {
                public static final String PACKAGE = Util.PACKAGE + ".stream";
                public static final Type Collectors = type(PACKAGE, "Collectors");
            }
        }
    }

    public static final class Javax {
        public static final String PACKAGE = "javax";

        public static final class Annotation {
            public static final String PACKAGE = Javax.PACKAGE + ".annotation";
            public static final Type Generated = type(PACKAGE, "Generated");
            public static final Type Nonnull = type(PACKAGE, "Nonnull");
            public static final Type Nullable = type(PACKAGE, "Nullable");
        }
    }

    public static final class Client {
        public static final String PACKAGE = "org.opensearch.client";

        public static Type ApiClient(Type transport, Type client) {
            return ApiClient.withTypeParameters(transport, client);
        }

        public static final Type ApiClient = type(PACKAGE, "ApiClient");

        public static final class Json {
            public static final String PACKAGE = Client.PACKAGE + ".json";
            public static final Type JsonData = type(PACKAGE, "JsonData");
            public static final Type JsonpDeserializable = type(PACKAGE, "JsonpDeserializable");
            public static final Type JsonpDeserializer = type(PACKAGE, "JsonpDeserializer");
            public static final Type JsonEnum = type(PACKAGE, "JsonEnum");
            public static final Type JsonpMapper = type(PACKAGE, "JsonpMapper");
            public static final Type JsonpSerializable = type(PACKAGE, "JsonpSerializable");
            public static final Type ObjectBuilderDeserializer = type(PACKAGE, "ObjectBuilderDeserializer");
            public static final Type ObjectDeserializer = type(PACKAGE, "ObjectDeserializer");
            public static final Type PlainDeserializable = type(PACKAGE, "PlainDeserializable");
            public static final Type PlainJsonSerializable = type(PACKAGE, "PlainJsonSerializable");
            public static final Type UnionDeserializer = type(PACKAGE, "UnionDeserializer");
        }

        public static final class OpenSearch {
            public static final String PACKAGE = Client.PACKAGE + ".opensearch";

            public static final class _Types {
                public static final String PACKAGE = OpenSearch.PACKAGE + "._types";
                public static final Type ErrorResponse = type(PACKAGE, "ErrorResponse");
                public static final Type OpenSearchException = type(PACKAGE, "OpenSearchException");
                public static final Type RequestBase = type(PACKAGE, "RequestBase");
                public static final Type Time = type(PACKAGE, "Time");
            }
        }

        public static final class Transport {
            public static final String PACKAGE = Client.PACKAGE + ".transport";
            public static final Type Endpoint = type(PACKAGE, "Endpoint");

            public static Type JsonEndpoint(Type requestType, Type responseType, Type errorType) {
                return JsonEndpoint.withTypeParameters(requestType, responseType, errorType);
            }

            public static final Type JsonEndpoint = type(PACKAGE, "JsonEndpoint");
            public static final Type OpenSearchTransport = type(PACKAGE, "OpenSearchTransport");
            public static final Type TransportOptions = type(PACKAGE, "TransportOptions");

            public static final class Endpoints {
                public static final String PACKAGE = Transport.PACKAGE + ".endpoints";

                public static final Type BooleanEndpoint = type(PACKAGE, "BooleanEndpoint");
                public static final Type BooleanResponse = type(PACKAGE, "BooleanResponse");

                public static Type DictionaryResponse(Type keyType, Type valueType) {
                    return DictionaryResponse.withTypeParameters(keyType, valueType);
                }

                public static final Type DictionaryResponse = type(PACKAGE, "DictionaryResponse");
                public static final Type SimpleEndpoint = type(PACKAGE, "SimpleEndpoint");
            }
        }

        public static final class Util {
            public static final String PACKAGE = Client.PACKAGE + ".util";
            public static final Type ApiTypeHelper = type(PACKAGE, "ApiTypeHelper");
            public static final Type CopyableBuilder = type(PACKAGE, "CopyableBuilder");

            public static Type ObjectBuilder(Type type) {
                return ObjectBuilder.withTypeParameters(type);
            }

            public static final Type ObjectBuilder = type(PACKAGE, "ObjectBuilder");
            public static final Type ObjectBuilderBase = type(PACKAGE, "ObjectBuilderBase");

            public static Type TaggedUnion(Type tagType, Type baseType) {
                return TaggedUnion.withTypeParameters(tagType, baseType);
            }

            public static final Type TaggedUnion = type(PACKAGE, "TaggedUnion");
            public static final Type TaggedUnionUtils = type(PACKAGE, "TaggedUnionUtils");

            public static Type ToCopyableBuilder(Type builder, Type type) {
                return ToCopyableBuilder.withTypeParameters(builder, type);
            }

            public static final Type ToCopyableBuilder = type(PACKAGE, "ToCopyableBuilder");
        }
    }

    public static final class Jakarta {
        public static final String PACKAGE = "jakarta";

        public static final class Json {
            public static final String PACKAGE = Jakarta.PACKAGE + ".json";

            public static final class Stream {
                public static final String PACKAGE = Json.PACKAGE + ".stream";
                public static final Type JsonGenerator = type(PACKAGE, "JsonGenerator");
            }
        }
    }
}
