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
        public static final Type Boolean = Type.builder().name("boolean").build();
        public static final Type Int = Type.builder().name("int").build();
        public static final Type Long = Type.builder().name("long").build();
        public static final Type Float = Type.builder().name("float").build();
        public static final Type Double = Type.builder().name("double").build();
    }

    public static final class Java {
        public static final String PACKAGE = "java";

        public static final class Io {
            public static final String PACKAGE = Java.PACKAGE + ".io";
            public static final Type IOException = Type.builder().pkg(PACKAGE).name("IOException").build();
        }

        public static final class Lang {
            public static final String PACKAGE = Java.PACKAGE + ".lang";
            public static final Type String = Type.builder().pkg(PACKAGE).name("String").build();
            public static final Type Character = Type.builder().pkg(PACKAGE).name("Character").build();
            public static final Type Boolean = Type.builder().pkg(PACKAGE).name("Boolean").build();
            public static final Type Byte = Type.builder().pkg(PACKAGE).name("Byte").build();
            public static final Type Short = Type.builder().pkg(PACKAGE).name("Short").build();
            public static final Type Integer = Type.builder().pkg(PACKAGE).name("Integer").build();
            public static final Type Long = Type.builder().pkg(PACKAGE).name("Long").build();
            public static final Type Float = Type.builder().pkg(PACKAGE).name("Float").build();
            public static final Type Double = Type.builder().pkg(PACKAGE).name("Double").build();
            public static final Type Object = Type.builder().pkg(PACKAGE).name("Object").build();
        }

        public static final class Util {
            public static final String PACKAGE = Java.PACKAGE + ".util";
            public static final Type HashMap = Type.builder().pkg(PACKAGE).name("HashMap").build();

            public static Type Map(Type keyType, Type valueType) {
                return Map.withGenericArgs(keyType, valueType);
            }

            public static final Type Map = Type.builder().pkg(PACKAGE).name("Map").build();

            public static Type MapEntry(Type keyType, Type valueType) {
                return Type.builder().pkg(PACKAGE).name("Map.Entry").genericArgs(keyType, valueType).build();
            }

            public static Type List(Type valueType) {
                return Type.builder().pkg(PACKAGE).name("List").genericArgs(valueType).build();
            }

            public static final class Concurrent {
                public static final String PACKAGE = Util.PACKAGE + ".concurrent";
                public static final Type CompletableFuture = Type.builder().pkg(PACKAGE).name("CompletableFuture").build();
            }

            public static final class Function {
                public static final String PACKAGE = Util.PACKAGE + ".function";

                public static Type Function(Type argType, Type returnType) {
                    return Type.builder().pkg(PACKAGE).name("Function").genericArgs(argType, returnType).build();
                }
            }

            public static final class Stream {
                public static final String PACKAGE = Util.PACKAGE + ".stream";
                public static final Type Collectors = Type.builder().pkg(PACKAGE).name("Collectors").build();
            }
        }
    }

    public static final class Javax {
        public static final String PACKAGE = "javax";

        public static final class Annotation {
            public static final String PACKAGE = Javax.PACKAGE + ".annotation";
            public static final Type Generated = Type.builder().pkg(PACKAGE).name("Generated").build();
            public static final Type Nullable = Type.builder().pkg(PACKAGE).name("Nullable").build();
        }
    }

    public static final class Client {
        public static final String PACKAGE = "org.opensearch.client";

        public static Type ApiClient(Type transport, Type client) {
            return ApiClient.withGenericArgs(transport, client);
        }

        public static final Type ApiClient = Type.builder().pkg(PACKAGE).name("ApiClient").build();

        public static final class Json {
            public static final String PACKAGE = Client.PACKAGE + ".json";
            public static final Type JsonData = Type.builder().pkg(PACKAGE).name("JsonData").build();
            public static final Type JsonpDeserializable = Type.builder().pkg(PACKAGE).name("JsonpDeserializable").build();
            public static final Type JsonpDeserializer = Type.builder().pkg(PACKAGE).name("JsonpDeserializer").build();
            public static final Type JsonEnum = Type.builder().pkg(PACKAGE).name("JsonEnum").build();
            public static final Type JsonpMapper = Type.builder().pkg(PACKAGE).name("JsonpMapper").build();
            public static final Type JsonpSerializable = Type.builder().pkg(PACKAGE).name("JsonpSerializable").build();
            public static final Type ObjectBuilderDeserializer = Type.builder().pkg(PACKAGE).name("ObjectBuilderDeserializer").build();
            public static final Type ObjectDeserializer = Type.builder().pkg(PACKAGE).name("ObjectDeserializer").build();
            public static final Type UnionDeserializer = Type.builder().pkg(PACKAGE).name("UnionDeserializer").build();
        }

        public static final class OpenSearch {
            public static final String PACKAGE = Client.PACKAGE + ".opensearch";

            public static final class _Types {
                public static final String PACKAGE = OpenSearch.PACKAGE + "._types";
                public static final Type ErrorResponse = Type.builder().pkg(PACKAGE).name("ErrorResponse").build();
                public static final Type OpenSearchException = Type.builder().pkg(PACKAGE).name("OpenSearchException").build();
                public static final Type RequestBase = Type.builder().pkg(PACKAGE).name("RequestBase").build();
                public static final Type Time = Type.builder().pkg(PACKAGE).name("Time").build();
            }
        }

        public static final class Transport {
            public static final String PACKAGE = Client.PACKAGE + ".transport";
            public static final Type Endpoint = Type.builder().pkg(PACKAGE).name("Endpoint").build();
            public static final Type JsonEndpoint = Type.builder().pkg(PACKAGE).name("JsonEndpoint").build();
            public static final Type OpenSearchTransport = Type.builder().pkg(PACKAGE).name("OpenSearchTransport").build();
            public static final Type TransportOptions = Type.builder().pkg(PACKAGE).name("TransportOptions").build();

            public static final class Endpoints {
                public static final String PACKAGE = Transport.PACKAGE + ".endpoints";
                public static final Type SimpleEndpoint = Type.builder().pkg(PACKAGE).name("SimpleEndpoint").build();
            }
        }

        public static final class Util {
            public static final String PACKAGE = Client.PACKAGE + ".util";
            public static final Type ApiTypeHelper = Type.builder().pkg(PACKAGE).name("ApiTypeHelper").build();

            public static Type ObjectBuilder(Type type) {
                return ObjectBuilder.withGenericArgs(type);
            }

            public static final Type ObjectBuilder = Type.builder().pkg(PACKAGE).name("ObjectBuilder").build();
            public static final Type ObjectBuilderBase = Type.builder().pkg(PACKAGE).name("ObjectBuilderBase").build();

            public static Type TaggedUnion(Type tagType, Type baseType) {
                return TaggedUnion.withGenericArgs(tagType, baseType);
            }

            public static final Type TaggedUnion = Type.builder().pkg(PACKAGE).name("TaggedUnion").build();
            public static final Type TaggedUnionUtils = Type.builder().pkg(PACKAGE).name("TaggedUnionUtils").build();
        }
    }

    public static final class Jakarta {
        public static final String PACKAGE = "jakarta";

        public static final class Json {
            public static final String PACKAGE = Jakarta.PACKAGE + ".json";

            public static final class Stream {
                public static final String PACKAGE = Json.PACKAGE + ".stream";
                public static final Type JsonGenerator = Type.builder().pkg(PACKAGE).name("JsonGenerator").build();
            }
        }
    }
}
